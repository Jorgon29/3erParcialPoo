package org.poo.parcialfinalpoo.crud.tarjeta.builders;

import org.poo.parcialfinalpoo.crud.BuilderCrud;
import org.poo.parcialfinalpoo.crud.tarjeta.CrudTarjetaApp;

public class EliminarTarjetaBuilder implements BuilderCrud<CrudTarjetaApp> {
private CrudTarjetaApp app;

    @Override
    public void reiniciar() {
app = new CrudTarjetaApp();
app.cambiarTitulo("Eliminar tarjeta (Elimina compras asociadas)");
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
    public CrudTarjetaApp getResultado() {
        return app;
    }
}
