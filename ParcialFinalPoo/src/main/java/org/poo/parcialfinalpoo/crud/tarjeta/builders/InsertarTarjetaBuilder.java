package org.poo.parcialfinalpoo.crud.tarjeta.builders;

import org.poo.parcialfinalpoo.crud.BuilderCrud;
import org.poo.parcialfinalpoo.crud.tarjeta.CrudTarjetaApp;

public class InsertarTarjetaBuilder implements BuilderCrud<CrudTarjetaApp> {
    private CrudTarjetaApp app;

    @Override
    public void reiniciar() {
        app = new CrudTarjetaApp();
        app.cambiarTitulo("Insertar tarjeta");
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
    public CrudTarjetaApp getResultado() {
        return app;
    }
}
