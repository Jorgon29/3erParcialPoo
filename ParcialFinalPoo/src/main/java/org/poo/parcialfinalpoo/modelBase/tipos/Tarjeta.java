package org.poo.parcialfinalpoo.modelBase.tipos;

import java.time.LocalDate;

public class Tarjeta {// 00016823 Clase intermediara entre las queries tarjeta y el resto del sistema
    private int id;// 00016823 id de la tarjeta
    private String tipo;// 00016823 tipo de tarjeta
    private String numero;// 00016823 numero de tarjeta
    private LocalDate fecha_exp;// 00016823 fecha de expiración de la tarjeta
    private String cliente;// 00016823 nombre del cliente asociado a la tarjeta
    private int id_cliente;// 00016823 id del cliente asociada a la tarjeta
    private String facilitador;// 00016823 nombre del facilitador de la tarjeta
    private int id_facilitador;// 00016823 id del facilitador de la tarjeta

    public Tarjeta(int id, String tipo, String numero, LocalDate fecha_exp, String cliente, int id_cliente, String facilitador, int id_facilitador) { // 00016823  constructor que recibe todos los atributos
        this.id = id;
        this.tipo = tipo;
        this.numero = numero;
        this.fecha_exp = fecha_exp;
        this.cliente = cliente;
        this.id_cliente = id_cliente;
        this.facilitador = facilitador;
        this.id_facilitador = id_facilitador;
    }
    // 00016823 getters y setters de todos los atributos
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
