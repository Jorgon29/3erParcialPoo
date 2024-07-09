package org.poo.parcialfinalpoo.crud.Facilitador;

import org.poo.parcialfinalpoo.crud.BuilderCrud;
import org.poo.parcialfinalpoo.crud.compra.CrudCompraApp;

public class CrudFacilitadorDirector {
    private BuilderCrud<CrudFacilitadorApp> builder;
    public CrudFacilitadorDirector(BuilderCrud<CrudFacilitadorApp> builder){
        this.builder = builder;
    }

    public void cambiarBuilder(BuilderCrud<CrudFacilitadorApp> builder){
        this.builder = builder;
    }

    public CrudFacilitadorApp make(String tipo){
        builder.reiniciar();
        switch (tipo){
            case "C":
                builder.ponerTextFields();
                builder.ponerBotonInsertar();
                break;
            case "R":
                builder.ponerLabels();
                builder.ponerBuscador();
                break;
            case "U":
                builder.ponerTextFields();
                builder.ponerBotonActualizar();
                builder.ponerBuscador();
                break;
            case "D":
                builder.ponerBotonEliminar();
                builder.ponerLabels();
                builder.ponerBuscador();
                break;
            default:
                return null;
        }
        return builder.getResultado();
    }
}
