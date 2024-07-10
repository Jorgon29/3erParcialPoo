package org.poo.parcialfinalpoo.crud.tarjeta;

import org.poo.parcialfinalpoo.crud.BuilderCrud;
import org.poo.parcialfinalpoo.crud.Cliente.CrudClienteApp;

public class CrudTarjetaDirector { // 00016823 Director para los builder de CrudTarjetaApp
    private BuilderCrud<CrudTarjetaApp> builder; // 00016823 atributo que almacena el builder
    public CrudTarjetaDirector(BuilderCrud<CrudTarjetaApp> builder){
        this.builder = builder;
    }

    public void cambiarBuilder(BuilderCrud<CrudTarjetaApp> builder){
        this.builder = builder;
    }

    public CrudTarjetaApp make(String tipo){ // 00016823 El director determina qué funciones llamar por medio de un string que sigue las siglas CRUD
        builder.reiniciar(); // 00016823 es necesario reiniciar el resultado a obtener antes de construirlo
        switch (tipo){
            case "C":
                builder.ponerTextFields(); // 00016823 Se ponen los elementos necesarios para CREATE
                builder.ponerBotonInsertar(); // 00016823 Se ponen los elementos necesarios para CREATE
                break;
            case "R":
                builder.ponerLabels(); // 00016823 Se ponen los elementos necesarios para READ
                builder.ponerBuscador(); // 00016823 Se ponen los elementos necesarios para READ
                break;
            case "U":
                builder.ponerTextFields(); // 00016823 Se ponen los elementos necesarios para UPDATE
                builder.ponerBotonActualizar(); // 00016823 Se ponen los elementos necesarios para UPDATE
                builder.ponerBuscador(); // 00016823 Se ponen los elementos necesarios para UPDATE
                break;
            case "D":
                builder.ponerBotonEliminar(); // 00016823 Se ponen los elementos necesarios para DELETE
                builder.ponerLabels(); // 00016823 Se ponen los elementos necesarios para DELETE
                builder.ponerBuscador(); // 00016823 Se ponen los elementos necesarios para DELETE
                break;
            default:
                return null;
        }
        return builder.getResultado(); //00016823 Obtiene la app resultado
    }
}
