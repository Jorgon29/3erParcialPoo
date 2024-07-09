package org.poo.parcialfinalpoo.controllers.crud.menuStrategies;

import org.poo.parcialfinalpoo.BcnApp;
import org.poo.parcialfinalpoo.crud.Facilitador.CrudFacilitadorApp;
import org.poo.parcialfinalpoo.crud.Facilitador.CrudFacilitadorDirector;
import org.poo.parcialfinalpoo.crud.Facilitador.builders.ActualizarFacilitadorBuilder;
import org.poo.parcialfinalpoo.crud.Facilitador.builders.EliminarFacilitadorBuilder;
import org.poo.parcialfinalpoo.crud.Facilitador.builders.InsertarFacilitadorBuilder;
import org.poo.parcialfinalpoo.crud.Facilitador.builders.VerFacilitadorBuilder;
import org.poo.parcialfinalpoo.crud.compra.CrudCompraApp;
import org.poo.parcialfinalpoo.crud.compra.CrudCompraDirector;
import org.poo.parcialfinalpoo.crud.compra.builders.ActualizarCompraBuilder;
import org.poo.parcialfinalpoo.crud.compra.builders.EliminarCompraBuilder;
import org.poo.parcialfinalpoo.crud.compra.builders.InsertarCompraBuilder;
import org.poo.parcialfinalpoo.crud.compra.builders.VerCompraBuilder;

public class FacilitadorStrategy implements MenuCrudStrategy{ // 00016823 Esta clase se encarga de llamar los builders para las escenas del crud de la tabla facilitador
    private CrudFacilitadorDirector director; // 00016823 El director que se utilizará para construir las escenas según la operación a realizar
    @Override
    public void enActualizar() { // 00016823 Este método se llama al necesitar una escena para actualizar facilitadores
        director.cambiarBuilder(new ActualizarFacilitadorBuilder()); // 00016823 Se pone un ActualizarFacilitadorBuilder en el director
        CrudFacilitadorApp app = director.make("U"); // 00016823 Se construye una app con los widgets para actualizaciones
        try { // 00016823 Se necesita un bloque try catch ya que en iniciar una application puede lanzarse una excepción
            app.start(BcnApp.getAppStage()); // 00016823 Se toma la escena del sistema y se inicia la app antes construida en ella
        } catch (Exception e) { // 00016823 Se agarra cualquier excepción que ocurra en la inicialización
            throw new RuntimeException(e); // 00016823 Se muestra la excepción en la consola
        }
    }

    @Override
    public void enEliminar() { // 00016823 Este método se llama al necesitar una escena para eliminar facilitadores
        director.cambiarBuilder(new EliminarFacilitadorBuilder()); // 00016823 Se pone un EliminarFacilitadorBuilder en el director
        CrudFacilitadorApp app = director.make("D"); // 00016823 Se construye una app con los widgets para eliminación
        try { // 00016823 Se necesita un bloque try catch ya que en iniciar una application puede lanzarse una excepción
            app.start(BcnApp.getAppStage()); // 00016823 Se toma la escena del sistema y se inicia la app antes construida en ella
        } catch (Exception e) { // 00016823 Se agarra cualquier excepción que ocurra en la inicialización
            throw new RuntimeException(e); // 00016823 Se muestra la excepción en la consola
        }
    }

    @Override
    public void enInsertar() { // 00016823 Este método se llama al necesitar una escena para insertar facilitadores
        director.cambiarBuilder(new InsertarFacilitadorBuilder()); // 00016823 Se pone un InsertarFacilitadorBuilder en el director
        CrudFacilitadorApp app = director.make("C"); // 00016823 Se construye una app con los widgets para inserción
        try { // 00016823 Se necesita un bloque try catch ya que en iniciar una application puede lanzarse una excepción
            app.start(BcnApp.getAppStage()); // 00016823 Se toma la escena del sistema y se inicia la app antes construida en ella
        } catch (Exception e) { // 00016823 Se agarra cualquier excepción que ocurra en la inicialización
            throw new RuntimeException(e); // 00016823 Se muestra la excepción en la consola
        }
    }

    @Override
    public void enVer() { // 00016823 Este método se llama al necesitar una escena para ver facilitadores
        director.cambiarBuilder(new VerFacilitadorBuilder()); // 00016823 Se pone un EliminarFacilitadorBuilder en el director
        CrudFacilitadorApp app = director.make("R"); // 00016823 Se construye una app con los widgets para visualización
        try { // 00016823 Se necesita un bloque try catch ya que en iniciar una application puede lanzarse una excepción
            app.start(BcnApp.getAppStage()); // 00016823 Se toma la escena del sistema y se inicia la app antes construida en ella
        } catch (Exception e) { // 00016823 Se agarra cualquier excepción que ocurra en la inicialización
            throw new RuntimeException(e); // 00016823 Se muestra la excepción en la consola
        }
    }

    public FacilitadorStrategy(){director = new CrudFacilitadorDirector(new ActualizarFacilitadorBuilder());} // 00016823 En el constructor de la strategy se inicializa el director

    @Override
    public String getNombre() {
        return "Facilitador";
    } // 00016823 se obtiene como String el nombre de la tabla a usar
}
