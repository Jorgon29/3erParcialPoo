package org.poo.parcialfinalpoo.crud.compra.builders;

import org.poo.parcialfinalpoo.crud.BuilderCrud;
import org.poo.parcialfinalpoo.crud.compra.CrudCompraApp;

public class InsertarCompraBuilder implements BuilderCrud<CrudCompraApp> {
    private CrudCompraApp app;
    @Override
    public void reiniciar() {
        app = new CrudCompraApp();
        app.cambiarTitulo("Insertar compra");
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
    public void ponerBuscador() {

    }

    @Override
    public void ponerBotonInsertar() {
app.ponerBotonInsertar();
    }

    @Override
    public CrudCompraApp getResultado() {
        return app;
    }
}
