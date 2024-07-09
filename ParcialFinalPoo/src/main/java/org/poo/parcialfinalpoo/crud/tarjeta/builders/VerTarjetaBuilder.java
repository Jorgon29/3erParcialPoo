package org.poo.parcialfinalpoo.crud.tarjeta.builders;

import org.poo.parcialfinalpoo.crud.BuilderCrud;
import org.poo.parcialfinalpoo.crud.tarjeta.CrudTarjetaApp;

public class VerTarjetaBuilder implements BuilderCrud<CrudTarjetaApp> {
    private CrudTarjetaApp app;

    @Override
    public void reiniciar() {
    app = new CrudTarjetaApp();
    app.cambiarTitulo("Ver registro");
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
    public CrudTarjetaApp getResultado() {
        return app;
    }
}
