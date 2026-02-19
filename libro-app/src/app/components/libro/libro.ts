import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { Libro } from '../../model/libro.model';
import { Categoria } from '../../model/categoria.model';
import { Autor } from '../../model/autor.model';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { LibroService } from '../../services/libro';
import { CategoriaService } from '../../services/categoria';
import { AutorService } from '../../services/autor';
import { MatDialog } from '@angular/material/dialog';
import { HttpClient } from '@angular/common/http';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-libro',
  standalone: false,
  templateUrl: './libro.html',
  styleUrls: ['./libro.css']
})

export class LibroComponent implements OnInit {

  libros: Libro[] = [];
  autores: Autor[] = [];
  categorias: Categoria[] = [];

  libro: Libro = {} as Libro;
  editar = false;
  idEditar: number | null = null;

  dataSource = new MatTableDataSource<Libro>();

  seleccionarArchivo!: File;
  imagenPrevia = "";
  libroSeleccionado: Libro | null = null;

  mostrarColumnas: string[] = [
    'detalles',
    'idLibro',
    'titulo',
    'editorial',
    'edicion',
    'idioma',
    'fechaPublicacion',
    'numEjemplares',
    'precio',
    'autor',
    'categoria',
    'acciones'
  ];

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild('modalLibro') modalLibro!: TemplateRef<any>;
  @ViewChild('modalDetalles') modalDetalles!: TemplateRef<any>;

  constructor(
    private libroService: LibroService,
    private autorService: AutorService,
    private categoriaService: CategoriaService,
    private dialog: MatDialog,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.findAll();
    this.cargarAutores();
    this.cargarCategorias();
  }

  findAll(): void {
    this.libroService.findAll().subscribe(data => {
      this.dataSource.data = data;
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  cargarAutores(): void {
    this.autorService.findAll().subscribe(data => {
      this.autores = data;
    });
  }

  cargarCategorias(): void {
    this.categoriaService.findAll().subscribe(data => {
      this.categorias = data;
    });
  }

guardarLibro(): void {

  console.log("🔥 Entró a guardarLibro");

  if (this.seleccionarArchivo) {

    console.log("📂 Hay imagen seleccionada");

    this.libroService.uploadPortada(
      this.seleccionarArchivo,
      this.libro.portada
    ).subscribe(res => {

      console.log("✅ Upload OK:", res);

      this.libro.portada = res.ruta;
      this.guardarDatosLibro();

    }, error => {
      console.error("❌ Error upload:", error);
    });

  } else {

    console.log("⚠️ No hay imagen, guardando directo");
    this.guardarDatosLibro();
  }
}

guardarDatosLibro(): void {

  if (this.editar && this.idEditar !== null) {

    this.libroService.update(this.idEditar, this.libro)
      .subscribe({
        next: (res) => {

          Swal.fire({
            icon: 'success',
            title: 'Actualizado correctamente',
            showConfirmButton: false,
            timer: 1500
          }).then(() => {
            this.reset(); // 👈 limpia y cierra modal
          });

        },
        error: (error) => {
          Swal.fire({
            icon: 'error',
            title: 'Error al actualizar',
            text: 'Ocurrió un problema'
          });
        }
      });

  } else {

    this.libroService.save(this.libro)
      .subscribe({
        next: (res) => {

    Swal.fire({
    icon: 'success',
    title: 'Guardado correctamente',
    confirmButtonText: 'Aceptar'
      }).then((result) => {
      if (result.isConfirmed) {
      this.reset();
      }
    });


        },
        error: (error) => {
          Swal.fire({
            icon: 'error',
            title: 'Error al guardar',
            text: 'Ocurrió un problema'
          });
        }
      });
  }
}

  reset(): void {
    this.libro = {} as Libro;
    this.editar = false;
    this.idEditar = null;

    this.seleccionarArchivo = undefined as any;
    this.imagenPrevia = "";

    this.findAll();
    this.dialog.closeAll();
  }

delete(libro: Libro): void {
  Swal.fire({
    title: '¿Desea eliminar el libro?',
    text: 'Esta acción no se puede deshacer',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#d33',
    cancelButtonColor: '#3085d6',
    confirmButtonText: 'Sí, eliminar',
    cancelButtonText: 'Cancelar'
  }).then(result => {

    if (result.isConfirmed) {

      this.libroService.delete(libro.idLibro).subscribe(() => {

        Swal.fire({
          icon: 'success',
          title: 'Eliminado correctamente',
          showConfirmButton: false,
          timer: 1500
        });

        this.findAll(); // 🔥 refresca tabla
      });

    }
  });
}


  friltroLibro(event: Event): void {
    const filtro = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filtro.trim().toLowerCase();
  }

  nombreCompletoAutor(id: number): string {
    const autor = this.autores.find(a => a.idAutor === id);
    return autor ? `${autor.nombre} ${autor.apellido}` : '';
  }

  obtenerCategoria(id: number): string {
    const categoria = this.categorias.find(c => c.idCategoria === id);
    return categoria ? categoria.categoria : '';
  }

abrirModal(libro?: Libro): void {

  // 🔥 LIMPIAMOS IMAGEN SIEMPRE
  this.seleccionarArchivo = undefined as any;
  this.imagenPrevia = "";

  if (libro) {
    this.libro = { ...libro };
    this.editar = true;
    this.idEditar = libro.idLibro;

    // 🔥 MOSTRAR IMAGEN ACTUAL SI EXISTE
    if (libro.portada) {
      this.imagenPrevia = 'http://localhost:8080/' + libro.portada;
    }

  } else {
    this.libro = {} as Libro;
    this.editar = false;
    this.idEditar = null;
  }

  this.dialog.open(this.modalLibro, {
    width: '800px',
    disableClose: true
  });
}


  //MÉTODOS PARA IMAGEN

seleccionarImagen(event: any): void {
  this.seleccionarArchivo = event.target.files[0];

  if (this.seleccionarArchivo) {
    const reader = new FileReader();
    reader.onload = (e: any) => {
      this.imagenPrevia = e.target.result;
    };
    reader.readAsDataURL(this.seleccionarArchivo);
  }
}



  abrirModalDetalles(libro: Libro): void {
    this.libroSeleccionado = libro;
    this.dialog.open(this.modalDetalles, {
      width: '500px'
    });
  }

cerrarModal(): void {

  Swal.fire({
    title: '¿Desea cancelar?',
    text: 'Los cambios no guardados se perderán',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonText: 'Sí, salir',
    cancelButtonText: 'Seguir editando'
  }).then(result => {
    if (result.isConfirmed) {
      this.reset();
    }
  });

}

}
