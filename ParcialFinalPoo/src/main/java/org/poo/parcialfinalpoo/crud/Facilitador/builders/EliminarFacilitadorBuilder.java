package org.poo.parcialfinalpoo.crud.Facilitador.builders;

import org.poo.parcialfinalpoo.crud.BuilderCrud;
import org.poo.parcialfinalpoo.crud.Facilitador.CrudFacilitadorApp;

public class EliminarFacilitadorBuilder implements BuilderCrud<CrudFacilitadorApp> {

    private CrudFacilitadorApp app;
    @Override
    public void reiniciar() {
        app = new CrudFacilitadorApp();
        app.cambiarTitulo("Eliminar facilitador");
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
    public CrudFacilitadorApp getResultado() {
        return app;
    }
}
