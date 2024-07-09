package org.poo.parcialfinalpoo.crud.tarjeta.builders;

import org.poo.parcialfinalpoo.crud.BuilderCrud;
import org.poo.parcialfinalpoo.crud.Cliente.CrudClienteApp;
import org.poo.parcialfinalpoo.crud.tarjeta.CrudTarjetaApp;
import org.poo.parcialfinalpoo.model.Tarjeta;

public class ActualizarTarjetaBuilder implements BuilderCrud<CrudTarjetaApp> {
    private CrudTarjetaApp app;
    @Override
    public void reiniciar() {
        app = new CrudTarjetaApp();
        app.cambiarTitulo("Actualizar tarjeta");
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
    public CrudTarjetaApp getResultado() {
        return app;
    }
}
