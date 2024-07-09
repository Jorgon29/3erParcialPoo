package org.poo.parcialfinalpoo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.poo.parcialfinalpoo.BcnApp;
import org.poo.parcialfinalpoo.controllers.crud.menuStrategies.ClienteStrategy;
import org.poo.parcialfinalpoo.controllers.crud.menuStrategies.CompraStrategy;
import org.poo.parcialfinalpoo.controllers.crud.menuStrategies.TarjetaStrategy;
import org.poo.parcialfinalpoo.crud.CrudApp;

public class MenuPrincipalController {
    @FXML
    protected Button btnClientes;
    @FXML
    protected Button btnCompras;
    @FXML
    protected Button btnTarjetas;

    @FXML
    public void enClientes(){
        try {
            (new CrudApp()).start(BcnApp.getAppStage(), new ClienteStrategy());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void enCompras(){
        try {
            (new CrudApp()).start(BcnApp.getAppStage(), new CompraStrategy());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void enTarjeta(){
        try {
            (new CrudApp()).start(BcnApp.getAppStage(), new TarjetaStrategy());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void enSalir(){
        BcnApp.getAppStage().close();
    }

}