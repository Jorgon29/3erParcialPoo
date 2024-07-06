package org.poo.parcialfinalpoo.Controllers.Crud.MenuStrategies;

import org.poo.parcialfinalpoo.BcnApp;
import org.poo.parcialfinalpoo.crud.Cliente.ActualizarCliente;

public class ClienteStrategy implements MenuCrudStrategy{
    @Override
    public void enActualizar() {
        ActualizarCliente app = new ActualizarCliente();
        try {
            app.start(BcnApp.getAppStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void enEliminar() {

    }

    @Override
    public void enInsertar() {

    }

    @Override
    public void enVer() {

    }

    @Override
    public String getNombre() {
        return "Cliente";
    }
}
