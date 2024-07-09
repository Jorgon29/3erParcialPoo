package org.poo.parcialfinalpoo.crud.compra.builders;

import org.poo.parcialfinalpoo.crud.BuilderCrud;
import org.poo.parcialfinalpoo.crud.compra.CrudCompraApp;

public class VerCompraBuilder implements BuilderCrud<CrudCompraApp> {
    private CrudCompraApp app;
    @Override
    public void reiniciar() {
        app = new CrudCompraApp();
        app.cambiarTitulo("Ver compra");
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
    public CrudCompraApp getResultado() {
        return app;
    }
}
