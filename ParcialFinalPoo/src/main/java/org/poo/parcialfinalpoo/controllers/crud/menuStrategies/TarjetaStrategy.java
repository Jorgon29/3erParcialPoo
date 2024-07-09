package org.poo.parcialfinalpoo.controllers.crud.menuStrategies;

import org.poo.parcialfinalpoo.BcnApp;
import org.poo.parcialfinalpoo.crud.Cliente.Builders.ActualizarClienteBuilder;
import org.poo.parcialfinalpoo.crud.Cliente.CrudClienteApp;
import org.poo.parcialfinalpoo.crud.Cliente.CrudClienteDirector;
import org.poo.parcialfinalpoo.crud.tarjeta.CrudTarjetaApp;
import org.poo.parcialfinalpoo.crud.tarjeta.CrudTarjetaDirector;
import org.poo.parcialfinalpoo.crud.tarjeta.builders.ActualizarTarjetaBuilder;
import org.poo.parcialfinalpoo.crud.tarjeta.builders.EliminarTarjetaBuilder;
import org.poo.parcialfinalpoo.crud.tarjeta.builders.InsertarTarjetaBuilder;
import org.poo.parcialfinalpoo.crud.tarjeta.builders.VerTarjetaBuilder;

public class TarjetaStrategy implements MenuCrudStrategy{
    private CrudTarjetaDirector director;
    @Override
    public void enActualizar() {
        director.cambiarBuilder(new ActualizarTarjetaBuilder());
        CrudTarjetaApp app = director.make("U");
        try {
            app.start(BcnApp.getAppStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void enEliminar() {
        director.cambiarBuilder(new EliminarTarjetaBuilder());
        CrudTarjetaApp app = director.make("D");
        try {
            app.start(BcnApp.getAppStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void enInsertar() {
        director.cambiarBuilder(new InsertarTarjetaBuilder());
        CrudTarjetaApp app = director.make("C");
        try {
            app.start(BcnApp.getAppStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void enVer() {
        director.cambiarBuilder(new VerTarjetaBuilder());
        CrudTarjetaApp app = director.make("R");
        try {
            app.start(BcnApp.getAppStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public TarjetaStrategy(){
        director = new CrudTarjetaDirector(new VerTarjetaBuilder());
    }

    @Override
    public String getNombre() {
        return "Tarjeta";
    }
}
