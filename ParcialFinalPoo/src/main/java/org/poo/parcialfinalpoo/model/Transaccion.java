package org.poo.parcialfinalpoo.model;

import java.time.LocalDate;

public class Transaccion {
    private int id;
    private double total;
    private LocalDate fecha;
    private String descripcion;
    private int id_tarjeta;

    public Transaccion(int id, double total, LocalDate fecha, String descripcion, int id_tarjeta) {
        this.id = id;
        this.total = total;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.id_tarjeta = id_tarjeta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_tarjeta() {
        return id_tarjeta;
    }

    public void setId_tarjeta(int id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }
}
