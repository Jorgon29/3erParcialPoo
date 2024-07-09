package org.poo.parcialfinalpoo.controllers.crud.menuStrategies;

public interface MenuCrudStrategy { // 00016823 Interfaz para las strategies de los diferentes elementos que se deben acceder de la bd
    public void enInsertar(); // 00016823 Se espera el método que maneje la inserción de nuevos registros
    public void enVer(); // 00016823 Se espera el método que maneje la visualización de registros existentes
    public void enActualizar(); // 00016823 Se espera el método que maneje la actualización de registros existentes
    public void enEliminar(); // 00016823 Se espera el método que maneje la eliminación de registros existentes
    public String getNombre(); // 00016823 Se espera el método que devuelva el nombre del elemento a manejar como String
}
