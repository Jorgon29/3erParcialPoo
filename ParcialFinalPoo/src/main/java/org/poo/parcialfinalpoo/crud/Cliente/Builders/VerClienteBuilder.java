package org.poo.parcialfinalpoo.crud.Cliente.Builders;

import org.poo.parcialfinalpoo.crud.BuilderCrud;
import org.poo.parcialfinalpoo.crud.Cliente.CrudClienteApp;

public class VerClienteBuilder implements BuilderCrud<CrudClienteApp> {
    private CrudClienteApp app;
    @Override
    public void reiniciar() {
        app = new CrudClienteApp();
        app.cambiarTitulo("Ver cliente -> ID");
    }

    @Override
    public void ponerBotonEliminar() {
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
