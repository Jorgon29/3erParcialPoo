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

public class FacilitadorStrategy implements MenuCrudStrategy{
    private CrudFacilitadorDirector director;
    @Override
    public void enActualizar() {
        director.cambiarBuilder(new ActualizarFacilitadorBuilder());
        CrudFacilitadorApp app = director.make("U");
        try {
            app.start(BcnApp.getAppStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void enEliminar() {
        director.cambiarBuilder(new EliminarFacilitadorBuilder());
        CrudFacilitadorApp app = director.make("D");
        try {
            app.start(BcnApp.getAppStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void enInsertar() {
        director.cambiarBuilder(new InsertarFacilitadorBuilder());
        CrudFacilitadorApp app = director.make("C");
        try {
            app.start(BcnApp.getAppStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void enVer() {
        director.cambiarBuilder(new VerFacilitadorBuilder());
        CrudFacilitadorApp app = director.make("R");
        try {
            app.start(BcnApp.getAppStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public FacilitadorStrategy(){
        director = new CrudFacilitadorDirector(new ActualizarFacilitadorBuilder());
    }

    @Override
    public String getNombre() {
        return "Facilitador";
    }
}
