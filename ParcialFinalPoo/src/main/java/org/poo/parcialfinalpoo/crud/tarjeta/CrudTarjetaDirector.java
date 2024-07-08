package org.poo.parcialfinalpoo.crud.tarjeta;

import org.poo.parcialfinalpoo.crud.BuilderCrud;
import org.poo.parcialfinalpoo.crud.Cliente.CrudClienteApp;

public class CrudTarjetaDirector {
    private BuilderCrud<CrudTarjetaApp> builder;
    public CrudTarjetaDirector(BuilderCrud<CrudTarjetaApp> builder){
        this.builder = builder;
    }

    public void cambiarBuilder(BuilderCrud<CrudTarjetaApp> builder){
        this.builder = builder;
    }

    public CrudTarjetaApp make(String tipo){
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
