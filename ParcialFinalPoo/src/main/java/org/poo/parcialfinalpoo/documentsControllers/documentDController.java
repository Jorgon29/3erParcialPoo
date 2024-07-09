package org.poo.parcialfinalpoo.documentsControllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import org.poo.parcialfinalpoo.BcnApp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.ResourceBundle;

public class documentDController implements Initializable {

    @FXML
    private ChoiceBox<String> facilitatorBox; //00054123 El choicebox donde se colocan todos lpos facilitadores de la base de datos


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=BCN;Encrypt=false", "Final_Poo_2024", "FinalPoo2024_25%");//00054123 Se realiza la conexion a la base de datos usando microsoft sql server y jdbc
            Statement stmt = con.createStatement(); //Se crea un statement usando la conexion yae stablecida
            ResultSet rs = stmt.executeQuery("select F.nombre as nombre from Facilitador F"); //00054123 Se ejecuta una query en busca de todos los facilidatores
            while (rs.next()) { //00054123 Se iteran las respuestas
                facilitatorBox.getItems().add(rs.getString("nombre")); //00054123 Se agregan los facilitadores al choicebox
            }
            con.close();//00054123 Se cierra la conexion
        }catch(SQLException e){};//00054123 Catch para una exception de SQL
    }
    public void generateReport() {
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=BCN;Encrypt=false", "Final_Poo_2024", "FinalPoo2024_25%");//00054123 Se realiza la conexion a la base de datos usando microsoft sql server y jdbc
            Statement stmt = con.createStatement(); //00054123 se crea el statement para utilizar queries
            Calendar calendar = Calendar.getInstance(); //00054123 Llamando a la instancia del calendario
            try{
                File reporte = new File("ParcialFinalPoo"+File.separator+"src"+File.separator+"Reportes"+ File.separator+"Reporte D - "+calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DAY_OF_MONTH)+"-"+calendar.get(Calendar.HOUR_OF_DAY)+".txt"); //00054123 Generando el archivo de texto donde está el reporte con formato ReporteB - fecha y hora
                FileWriter fw = new FileWriter(reporte); //00054123 Se crea un filewritter para modificar e archivo respectivamente al reporte
                ResultSet rs = stmt.executeQuery("select C.nombre as nombre, Sum(T2.total) as total, COUNT(T2.id) as transacciones from Cliente C inner join Tarjeta T on C.id = T.id_cliente inner join Transaccion T2 on T.id = T2.id_tarjeta inner join Facilitador F on F.id = T.id_facilitador where F.nombre = '"+facilitatorBox.getValue()+"'" +
                        "GROUP BY C.nombre "); //00054123 Ejecuta la query donde se buscan todos los clientes  que realizaron compra y demas cosas necesarias para el reporte
                fw.write("Informe de tipo C del proveedor: "+facilitatorBox.getValue()+"\n\n"); //Se pone un primer texto para darle un mejor formato al reporte
                while (rs.next()){ //00054123 Se itera en el resultado de la query
                    fw.write("Comprador: "+rs.getString("nombre")+" realizo: "+rs.getInt("transacciones")+" transacciones, con un total de compras de: "+rs.getDouble("total")+"\n"); //00054123 Se llena con los datos que se encontraron
                }
                fw.close(); //00054123 Se cierra el file writter por buenas practicas
            }catch (IOException E){} //00054123 El catch por errores al trabajar con archivos
              con.close(); //0054123 Se cierra la conexion para ahorrar recursos y buenas practicas
        }catch (SQLException e){ //Catch de errores al trabajar con sql

            Alert error = new Alert(Alert.AlertType.ERROR); //00054123 Se crea un error porque se ingresaron datos incorrectos
            error.setTitle("Error"); //00054123 Se le pone un titulo a la alerta del error
            error.setHeaderText(null); //00054123 se pone un header null
            error.setContentText("Por favor revise los datos ingresados"); //00054123 EL cuepor del error ya que se ingresaron datos de forma incorrecta
            error.showAndWait(); //00054123 Se muestra el mensaje de eror y se espera para seguir

        }

    }
    @FXML
    public void onVolver(){
        BcnApp bcnApp = new BcnApp(); //00054123 Se crea un app nueva del menu principal para entrar a ella
        try {
            bcnApp.start(((Stage)facilitatorBox.getScene().getWindow())); //00054123 SE reutiliza el stage que ya se tenia y se entra en la nueva ventana
        }catch (Exception e){} //Un catch generico para posibles exepciones al usar aplicaciones

    }
}
