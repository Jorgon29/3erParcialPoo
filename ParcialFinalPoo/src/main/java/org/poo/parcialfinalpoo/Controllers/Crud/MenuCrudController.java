package org.poo.parcialfinalpoo.Controllers.Crud;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.poo.parcialfinalpoo.BcnApp;
import org.poo.parcialfinalpoo.Controllers.Crud.MenuStrategies.MenuCrudStrategy;

import java.io.IOException;

public class MenuCrudController {
    private MenuCrudStrategy strategy;
    @FXML
    protected Button btnInsertar;
    @FXML
    protected Button btnEliminar;
    @FXML
    protected Button btnVer;
    @FXML
    protected Button btnActualizar;
    @FXML
    protected Label lblTipo;
    @FXML
    protected Button btnRegresar;

    public void setStrategy(MenuCrudStrategy strategy){
        this.strategy = strategy;
    }

    @FXML
    public void enInsertar(){
        strategy.enInsertar();
    }

    @FXML
    public void enEliminar(){
        strategy.enEliminar();
    }
    @FXML
    public void enActualizar(){
        strategy.enActualizar();
    }
    @FXML
    public void enVer(){
        strategy.enVer();
    }

    public Label getLblTipo(){
        return lblTipo;
    }
    @FXML
    public void enRegresar(){
        try {
            (new BcnApp()).start(((Stage) btnActualizar.getScene().getWindow()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
