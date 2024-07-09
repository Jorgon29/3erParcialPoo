package org.poo.parcialfinalpoo.controllers.crud.menuStrategies;

import org.poo.parcialfinalpoo.BcnApp;
import org.poo.parcialfinalpoo.crud.Cliente.Builders.ActualizarClienteBuilder;
import org.poo.parcialfinalpoo.crud.Cliente.Builders.EliminarClienteBuilder;
import org.poo.parcialfinalpoo.crud.Cliente.Builders.InsertarClienteBuilder;
import org.poo.parcialfinalpoo.crud.Cliente.Builders.VerClienteBuilder;
import org.poo.parcialfinalpoo.crud.Cliente.CrudClienteApp;
import org.poo.parcialfinalpoo.crud.Cliente.CrudClienteDirector;

public class ClienteStrategy implements MenuCrudStrategy{ // 00016823 Esta clase se encarga de llamar los builders para las escenas del crud de la tabla cliente
    private CrudClienteDirector director; // 00016823 El director que se utilizará para construir las escenas según la operación a realizar
    @Override
    public void enActualizar() { // 00016823 Este método se llama al necesitar una escena para actualizar clientes
        director.cambiarBuilder(new ActualizarClienteBuilder()); // 00016823 Se pone un ActualizarClienteBuilder en el director
        CrudClienteApp app = director.make("U"); // 00016823 Se construye una app con los widgets para actualizaciones
        try { // 00016823 Se necesita un bloque try catch ya que en iniciar una application puede lanzarse una excepción
            app.start(BcnApp.getAppStage()); // 00016823 Se toma la escena del sistema y se inicia la app antes construida en ella
        } catch (Exception e) { // 00016823 Se agarra cualquier excepción que ocurra en la inicialización
            throw new RuntimeException(e); // 00016823 Se muestra la excepción en la consola
        }
    }

    @Override
    public void enEliminar() { // 00016823 Este método se llama al necesitar una escena para eliminar clientes
        director.cambiarBuilder(new EliminarClienteBuilder()); // 00016823 Se pone un EliminarClienteBuilder en el director
        CrudClienteApp app = director.make("D"); // 00016823 Se construye una app con los widgets para eliminación
        try { // 00016823 Se necesita un bloque try catch ya que en iniciar una application puede lanzarse una excepción
            app.start(BcnApp.getAppStage()); // 00016823 Se toma la escena del sistema y se inicia la app antes construida en ella
        } catch (Exception e) { // 00016823 Se agarra cualquier excepción que ocurra en la inicialización
            throw new RuntimeException(e); // 00016823 Se muestra la excepción en la consola
        }
    }

    @Override
    public void enInsertar() { // 00016823 Este método se llama al necesitar una escena para insertar clientes
        director.cambiarBuilder(new InsertarClienteBuilder()); // 00016823 Se pone un InsertarClienteBuilder en el director
        CrudClienteApp app = director.make("C"); // 00016823 Se construye una app con los widgets para inserción
        try { // 00016823 Se necesita un bloque try catch ya que en iniciar una application puede lanzarse una excepción
            app.start(BcnApp.getAppStage()); // 00016823 Se toma la escena del sistema y se inicia la app antes construida en ella
        } catch (Exception e) { // 00016823 Se agarra cualquier excepción que ocurra en la inicialización
            throw new RuntimeException(e); // 00016823 Se muestra la excepción en la consola
        }
    }

    @Override
    public void enVer() { // 00016823 Este método se llama al necesitar una escena para ver clientes
        director.cambiarBuilder(new VerClienteBuilder()); // 00016823 Se pone un VerClienteBuilder en el director
        CrudClienteApp app = director.make("R"); // 00016823 Se construye una app con los widgets para visualización
        try { // 00016823 Se necesita un bloque try catch ya que en iniciar una application puede lanzarse una excepción
            app.start(BcnApp.getAppStage()); // 00016823 Se toma la escena del sistema y se inicia la app antes construida en ella
        } catch (Exception e) { // 00016823 Se agarra cualquier excepción que ocurra en la inicialización
            throw new RuntimeException(e); // 00016823 Se muestra la excepción en la consola
        }
    }

    public ClienteStrategy(){director = new CrudClienteDirector(new ActualizarClienteBuilder());} // 00016823 En el constructor de la strategy se inicializa el director

    @Override
    public String getNombre() {
        return "Cliente";
    } // 00016823 se obtiene como String el nombre de la tabla a usar
}
