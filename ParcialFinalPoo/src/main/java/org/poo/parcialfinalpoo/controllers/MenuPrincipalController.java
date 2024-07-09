package org.poo.parcialfinalpoo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.poo.parcialfinalpoo.BcnApp;
import org.poo.parcialfinalpoo.controllers.crud.menuStrategies.ClienteStrategy;
import org.poo.parcialfinalpoo.controllers.crud.menuStrategies.CompraStrategy;
import org.poo.parcialfinalpoo.controllers.crud.menuStrategies.FacilitadorStrategy;
import org.poo.parcialfinalpoo.controllers.crud.menuStrategies.TarjetaStrategy;
import org.poo.parcialfinalpoo.crud.CrudApp;
import org.poo.parcialfinalpoo.documentViews.documentA_App;
import org.poo.parcialfinalpoo.documentViews.documentB_App;
import org.poo.parcialfinalpoo.documentViews.documentC_App;
import org.poo.parcialfinalpoo.documentViews.documentD_App;

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
    public void enFacilitador(){
        try {
            (new CrudApp()).start(BcnApp.getAppStage(), new FacilitadorStrategy());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void enSalir(){
        BcnApp.getAppStage().close();
    }

    @FXML
    public void onA(){

        documentA_App app = new documentA_App(); //00054123 Se crea una nueva app de tipo documentos A para iniciarla
        try {
            app.start(BcnApp.getAppStage());//00054123 Se inicia la app con la escena antes creada
        }catch (Exception e){} //00054123 Catch para exepciones al iniciar una app
    }

    @FXML
    public void onB(){

        documentB_App app = new documentB_App(); //00054123 SE crea una neuva app de tipo documentos B
        try {
            app.start(BcnApp.getAppStage()); //00054123 Se inicia la aplicacion usando el escenario ya antes creado
        }catch (Exception e){} //00054123 Catch para exepciones que pueden ocurrir al iniciar la app
    }

    @FXML
    public void onC(){

        documentC_App app = new documentC_App(); //00054123 Se crea una app documentos C para iniciarla
        try {
            app.start(BcnApp.getAppStage());//00054123 Se inicia la app usando el stage ya creado
        }catch (Exception e){} //00054123 Catch a exepciones que peuden ocurrir durante el inicio de la app
    }

    @FXML
    public void onD(){

        documentD_App app = new documentD_App(); //00054123 Se crea una app de documentos D para inciiarla
        try {
            app.start(BcnApp.getAppStage()); //00054123 Se inicia la app usando el stage ya creado
        }catch (Exception e){} //00054123 Catch a exepciones que peuden ocurrir al iniciar la app


    }

}
