package org.poo.parcialfinalpoo.modelBase.tipos;

public class Facilitador {// 00016823 Clase intermediara entre las queries facilitador y el resto del sistema
    private int id; // 00016823 Atributo que almacena el id del facilitador en la tabla de la base de datos
    private String nombre; // 00016823  nombre del facilitador

    public Facilitador(int id, String nombre) { // 00016823 constructor que recibe todos los parámetros
        this.id = id;
        this.nombre = nombre;
    }

    // 00016823 getters y setters para todos los atributos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {return id + " " + nombre;}  // 00016823 Override a to string para que sea mejor mostrarlos en un observable array en un combo box
}
