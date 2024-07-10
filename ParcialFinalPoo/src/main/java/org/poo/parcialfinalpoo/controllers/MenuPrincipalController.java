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

public class MenuPrincipalController { // 00016823 Menú principal con los botones que llevan a las acciones crud y generación de reportes
    @FXML
    public void enClientes(){// 00016823 Método ejecutado al presionar el botón clientes
        try {
            (new CrudApp()).start(BcnApp.getAppStage(), new ClienteStrategy());// 00016823 Se inicia una nueva CrudApp con una strategy de cliente
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void enCompras(){ // 00016823 Método ejecutado al presionar el botón compras
        try {
            (new CrudApp()).start(BcnApp.getAppStage(), new CompraStrategy()); // 00016823 Se inicia una nueva CrudApp con una strategy de compra
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void enTarjeta(){ // 00016823 Método ejecutado al presionar el botón tarjeta
        try {
            (new CrudApp()).start(BcnApp.getAppStage(), new TarjetaStrategy()); // 00016823 Se inicia una nueva CrudApp con una strategy de tarjeta
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void enFacilitador(){ // 00016823 Método ejecutado al presionar el botón facilitador
        try {
            (new CrudApp()).start(BcnApp.getAppStage(), new FacilitadorStrategy()); // 00016823 Se inicia una nueva CrudApp con una strategy de facilitador
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void enSalir(){BcnApp.getAppStage().close();}  // 00016823 Se cierra la stage del programa y finaliza ejecución

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
