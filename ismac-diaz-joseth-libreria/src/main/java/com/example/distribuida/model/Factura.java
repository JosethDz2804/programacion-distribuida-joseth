package com.example.distribuida.model;

import jakarta.persistence.*;

@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Integer idFactura;

    @Column(name = "num_factura")
    private String numFactura;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "total_neto")
    private Double totalNeto;

    @Column(name = "iva")
    private Double iva;

    @Column(name = "total")
    private Double total;

    @Column(name = "id_cliente")
    private Integer idCliente;

    public Factura() {}

    public Integer getIdFactura() { return idFactura; }
    public void setIdFactura(Integer idFactura) { this.idFactura = idFactura; }

    public String getNumFactura() { return numFactura; }
    public void setNumFactura(String numFactura) { this.numFactura = numFactura; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public Double getTotalNeto() { return totalNeto; }
    public void setTotalNeto(Double totalNeto) { this.totalNeto = totalNeto; }

    public Double getIva() { return iva; }
    public void setIva(Double iva) { this.iva = iva; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public Integer getIdCliente() { return idCliente; }
    public void setIdCliente(Integer idCliente) { this.idCliente = idCliente; }
}
