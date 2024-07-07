package org.poo.parcialfinalpoo.Controllers.Crud.MenuStrategies;

import org.poo.parcialfinalpoo.BcnApp;
import org.poo.parcialfinalpoo.crud.Cliente.BuilderCrudCliente;
import org.poo.parcialfinalpoo.crud.Cliente.Builders.ActualizarClienteBuilder;
import org.poo.parcialfinalpoo.crud.Cliente.Builders.EliminarClienteBuilder;
import org.poo.parcialfinalpoo.crud.Cliente.Builders.InsertarClienteBuilder;
import org.poo.parcialfinalpoo.crud.Cliente.Builders.VerClienteBuilder;
import org.poo.parcialfinalpoo.crud.Cliente.CrudClienteApp;
import org.poo.parcialfinalpoo.crud.Cliente.CrudClienteDirector;

public class ClienteStrategy implements MenuCrudStrategy{
    private CrudClienteDirector director;
    @Override
    public void enActualizar() {
        director.cambiarBuilder(new ActualizarClienteBuilder());
        CrudClienteApp app = director.make("U");
        try {
            app.start(BcnApp.getAppStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void enEliminar() {
        director.cambiarBuilder(new EliminarClienteBuilder());
        CrudClienteApp app = director.make("D");
        try {
            app.start(BcnApp.getAppStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void enInsertar() {
        director.cambiarBuilder(new InsertarClienteBuilder());
        CrudClienteApp app = director.make("C");
        try {
            app.start(BcnApp.getAppStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void enVer() {
        director.cambiarBuilder(new VerClienteBuilder());
        CrudClienteApp app = director.make("R");
        try {
            app.start(BcnApp.getAppStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ClienteStrategy(){
        director = new CrudClienteDirector(new ActualizarClienteBuilder());
    }

    @Override
    public String getNombre() {
        return "Cliente";
    }
}
