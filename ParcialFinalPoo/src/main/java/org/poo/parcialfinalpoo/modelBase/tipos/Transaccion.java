package org.poo.parcialfinalpoo.modelBase.tipos;

import java.time.LocalDate;

public class Transaccion {// 00016823 Clase intermediara entre las queries transacción y el resto del sistema
    private int id;// 00016823 id de la transacción
    private double total;// 00016823 total (monetario) de la transacción
    private LocalDate fecha;// 00016823 fecha de la transacción
    private String descripcion;// 00016823 descripción de la transacción
    private int id_tarjeta;// 00016823 id de la tarjeta que realizó la transacción

    public Transaccion(int id, double total, LocalDate fecha, String descripcion, int id_tarjeta) {// 00016823 constructor con todos los atributos como parámetros
        this.id = id;
        this.total = total;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.id_tarjeta = id_tarjeta;
    }
    // 00016823 getters y setters de todos los atributos
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
