package org.poo.parcialfinalpoo.modelBase.tipos;

import java.time.LocalDate;

public class Tarjeta {
    private int id;
    private String tipo;
    private String numero;
    private LocalDate fecha_exp;
    private String cliente;
    private int id_cliente;
    private String facilitador;
    private int id_facilitador;

    public Tarjeta(int id, String tipo, String numero, LocalDate fecha_exp, String cliente, int id_cliente, String facilitador, int id_facilitador) {
        this.id = id;
        this.tipo = tipo;
        this.numero = numero;
        this.fecha_exp = fecha_exp;
        this.cliente = cliente;
        this.id_cliente = id_cliente;
        this.facilitador = facilitador;
        this.id_facilitador = id_facilitador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getFecha_exp() {
        return fecha_exp;
    }

    public void setFecha_exp(LocalDate fecha_exp) {
        this.fecha_exp = fecha_exp;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFacilitador() {
        return facilitador;
    }

    public void setFacilitador(String facilitador) {
        this.facilitador = facilitador;
    }

    public int getId_facilitador() {
        return id_facilitador;
    }

    public void setId_facilitador(int id_facilitador) {
        this.id_facilitador = id_facilitador;
    }
}
