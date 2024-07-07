package org.poo.parcialfinalpoo.crud.Cliente.Builders;

import org.poo.parcialfinalpoo.crud.Cliente.BuilderCrudCliente;
import org.poo.parcialfinalpoo.crud.Cliente.CrudClienteApp;

public class ActualizarClienteBuilder implements BuilderCrudCliente {
    private CrudClienteApp app;
    @Override
    public void reiniciar() {
        app = new CrudClienteApp();
        app.cambiarTitulo("Actualizar cliente -> ID");
    }

    @Override
    public void ponerBotonEliminar() {
    }

    @Override
    public void ponerBotonActualizar() {
        app.ponerBotonActualizar();
    }

    @Override
    public void ponerTextFields() {
        app.ponerTextFields();
    }

    @Override
    public void ponerLabels() {
    }

    @Override
    public CrudClienteApp getResultado() {
        return app;
    }

    @Override
    public void ponerBuscador() {
        app.ponerBuscador();
    }

    @Override
    public void ponerBotonInsertar() {

    }
}
