package com.example.distribuida.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Integer idLibro;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "editorial")
    private String editorial;

    @Column(name = "num_paginas")
    private Integer numPaginas;

    @Column(name = "edicion")
    private String edicion;

    @Column(name = "idioma")
    private String idioma;

    @Column(name = "fecha_publicacion")
    private String fechaPublicacion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tipo_pasta")
    private String tipoPasta;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "num_ejemplares")
    private Integer numEjemplares;

    @Column(name = "portada")
    private String portada;

    @Column(name = "presentacion")
    private String presentacion;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "id_autor")
    private Integer idAutor;

    public Libro() {}

    public Integer getIdLibro() { return idLibro; }
    public void setIdLibro(Integer idLibro) { this.idLibro = idLibro; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getEditorial() { return editorial; }
    public void setEditorial(String editorial) { this.editorial = editorial; }

    public Integer getNumPaginas() { return numPaginas; }
    public void setNumPaginas(Integer numPaginas) { this.numPaginas = numPaginas; }

    public String getEdicion() { return edicion; }
    public void setEdicion(String edicion) { this.edicion = edicion; }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }

    public String getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(String fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getTipoPasta() { return tipoPasta; }
    public void setTipoPasta(String tipoPasta) { this.tipoPasta = tipoPasta; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public Integer getNumEjemplares() { return numEjemplares; }
    public void setNumEjemplares(Integer numEjemplares) { this.numEjemplares = numEjemplares; }

    public String getPortada() { return portada; }
    public void setPortada(String portada) { this.portada = portada; }

    public String getPresentacion() { return presentacion; }
    public void setPresentacion(String presentacion) { this.presentacion = presentacion; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public Integer getIdCategoria() { return idCategoria; }
    public void setIdCategoria(Integer idCategoria) { this.idCategoria = idCategoria; }

    public Integer getIdAutor() { return idAutor; }
    public void setIdAutor(Integer idAutor) { this.idAutor = idAutor; }
}
