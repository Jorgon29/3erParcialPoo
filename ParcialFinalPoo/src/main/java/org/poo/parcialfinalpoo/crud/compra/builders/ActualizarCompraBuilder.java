package org.poo.parcialfinalpoo.crud.compra.builders;

import org.poo.parcialfinalpoo.crud.BuilderCrud;
import org.poo.parcialfinalpoo.crud.compra.CrudCompraApp;

public class ActualizarCompraBuilder implements BuilderCrud<CrudCompraApp> {
    private CrudCompraApp app;
    @Override
    public void reiniciar() {
        app = new CrudCompraApp();
        app.cambiarTitulo("Actualizar compra");
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
