package org.poo.parcialfinalpoo.controllers.crud.menuStrategies;

import org.poo.parcialfinalpoo.BcnApp;
import org.poo.parcialfinalpoo.crud.Cliente.Builders.InsertarClienteBuilder;
import org.poo.parcialfinalpoo.crud.Cliente.CrudClienteApp;
import org.poo.parcialfinalpoo.crud.Cliente.CrudClienteDirector;
import org.poo.parcialfinalpoo.crud.compra.CrudCompraApp;
import org.poo.parcialfinalpoo.crud.compra.CrudCompraDirector;
import org.poo.parcialfinalpoo.crud.compra.builders.ActualizarCompraBuilder;
import org.poo.parcialfinalpoo.crud.compra.builders.EliminarCompraBuilder;
import org.poo.parcialfinalpoo.crud.compra.builders.InsertarCompraBuilder;
import org.poo.parcialfinalpoo.crud.compra.builders.VerCompraBuilder;

public class CompraStrategy implements MenuCrudStrategy{
    private CrudCompraDirector director;
    @Override
    public void enActualizar() {
        director.cambiarBuilder(new ActualizarCompraBuilder());
        CrudCompraApp app = director.make("U");
        try {
            app.start(BcnApp.getAppStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void enEliminar() {
        director.cambiarBuilder(new EliminarCompraBuilder());
        CrudCompraApp app = director.make("D");
        try {
            app.start(BcnApp.getAppStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void enInsertar() {
        director.cambiarBuilder(new InsertarCompraBuilder());
        CrudCompraApp app = director.make("C");
        try {
            app.start(BcnApp.getAppStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void enVer() {
        director.cambiarBuilder(new VerCompraBuilder());
        CrudCompraApp app = director.make("R");
        try {
            app.start(BcnApp.getAppStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CompraStrategy(){
        director = new CrudCompraDirector(new EliminarCompraBuilder());
    }

    @Override
    public String getNombre() {
        return "Compra";
    }

}
