package org.poo.parcialfinalpoo.crud.Cliente;

import org.poo.parcialfinalpoo.crud.BuilderCrud;

public class CrudClienteDirector {
    private BuilderCrud<CrudClienteApp> builder;
    public CrudClienteDirector(BuilderCrud<CrudClienteApp> builder){
        this.builder = builder;
    }

    public void cambiarBuilder(BuilderCrud<CrudClienteApp> builder){
        this.builder = builder;
    }

    public CrudClienteApp make(String tipo){
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
