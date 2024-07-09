package org.poo.parcialfinalpoo.crud.compra.builders;

import org.poo.parcialfinalpoo.crud.BuilderCrud;
import org.poo.parcialfinalpoo.crud.compra.CrudCompraApp;

public class EliminarCompraBuilder implements BuilderCrud<CrudCompraApp> {
    private CrudCompraApp app;
    @Override
    public void reiniciar() {
        app = new CrudCompraApp();
        app.cambiarTitulo("Eliminar compra");
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
    public CrudCompraApp getResultado() {
        return app;
    }
}
