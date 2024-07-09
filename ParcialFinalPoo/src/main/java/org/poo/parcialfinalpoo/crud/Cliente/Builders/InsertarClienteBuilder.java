package org.poo.parcialfinalpoo.crud.Cliente.Builders;

import org.poo.parcialfinalpoo.crud.BuilderCrud;
import org.poo.parcialfinalpoo.crud.Cliente.CrudClienteApp;

public class InsertarClienteBuilder implements BuilderCrud<CrudClienteApp> {
    private CrudClienteApp app;
    @Override
    public void reiniciar() {
        app = new CrudClienteApp();
        app.cambiarTitulo("Insertart cliente");
    }

    @Override
    public void ponerBotonEliminar() {
    }

    @Override
    public void ponerBotonActualizar() {

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
        app.ponerBotonInsertar();
    }
}
