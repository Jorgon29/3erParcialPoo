package org.poo.parcialfinalpoo.crud.Cliente;

public interface BuilderCrudCliente {
    public void reiniciar();
    public void ponerBotonEliminar();
    public void ponerBotonActualizar();
    public void ponerTextFields();
    public void ponerLabels();
    public void ponerBuscador();
    public void ponerBotonInsertar();
    public CrudClienteApp getResultado();
}
