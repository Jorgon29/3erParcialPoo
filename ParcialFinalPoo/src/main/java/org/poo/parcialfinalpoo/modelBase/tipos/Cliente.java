package org.poo.parcialfinalpoo.modelBase.tipos;

public class Cliente {// 00016823 Clase intermediara entre las queries cliente y el resto del sistema
    private int id; // 00016823 int donde se almacena el id del registro en la tabla de la base
    private String nombre; // 00016823 String que almacena el nombre del cliente
    private String telefono;// 00016823 String que almacena el teléfono del cliente
    private String direccion;// 00016823 String que almacena la dirección del cliente

    public Cliente(int id, String nombre, String telefono, String direccion) { // 00016823 Constructor que recibe todos los parámetros posibles
        this.id = id; // 00016823 Asigna el id recibido a su atributo correspondiente
        this.nombre = nombre; // 00016823 Asigna el nombre recibido a su atributo correspondiente
        this.telefono = telefono; // 00016823 Asigna teléfono id recibido a su atributo correspondiente
        this.direccion = direccion; // 00016823 Asigna la dirección recibida a su atributo correspondiente
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {return id + " " + nombre;}  // 00016823 Override a toString para que sea mejor mostrarlos en un observable array en un combo box
}
