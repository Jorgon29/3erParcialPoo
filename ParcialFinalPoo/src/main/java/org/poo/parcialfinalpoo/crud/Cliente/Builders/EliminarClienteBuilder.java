package org.poo.parcialfinalpoo.crud.Cliente.Builders;

import org.poo.parcialfinalpoo.crud.Cliente.BuilderCrudCliente;
import org.poo.parcialfinalpoo.crud.Cliente.CrudClienteApp;

public class EliminarClienteBuilder implements BuilderCrudCliente {
    private CrudClienteApp app;
    @Override
    public void reiniciar() {
        app = new CrudClienteApp();
        app.cambiarTitulo("Eliminar cliente -> ID");
    }

    @Override
    public void ponerBotonEliminar() {
        app.ponerBotonEliminar();

    }

    @Override
    public void ponerBotonActualizar() {
    }

    @Override
    public void ponerTextFields() {
    }

    @Override
    public void ponerLabels() {
        app.ponerLabels();
    }

    @Override
    public void ponerBuscador() {
    app.ponerBuscador();
    }

    @Override
    public void ponerBotonInsertar() {

    }

    @Override
    public CrudClienteApp getResultado() {
        return app;
    }
}
