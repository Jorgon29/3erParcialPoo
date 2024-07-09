package org.poo.parcialfinalpoo.crud.Facilitador.builders;

import org.poo.parcialfinalpoo.crud.BuilderCrud;
import org.poo.parcialfinalpoo.crud.Facilitador.CrudFacilitadorApp;

public class InsertarFacilitadorBuilder implements BuilderCrud<CrudFacilitadorApp> {

    private CrudFacilitadorApp app;
    @Override
    public void reiniciar() {
        app = new CrudFacilitadorApp();
        app.cambiarTitulo("Insertar facilitador");
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
    public CrudFacilitadorApp getResultado() {
        return app;
    }
}
