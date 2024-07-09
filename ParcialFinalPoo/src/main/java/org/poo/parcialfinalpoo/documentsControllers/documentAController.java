package org.poo.parcialfinalpoo.documentsControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.poo.parcialfinalpoo.BcnApp;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class documentAController {

    @FXML
    private DatePicker FechaFinal; //00054123 Un textfield donde se ingresa la fecha final a buscar

    @FXML
    private DatePicker FechaInicial; //00054123 Un textfield donde se ingresa la fecha inicial para buscar

    @FXML
    private TextField IDBuscar; //0054123 Un textfield donde se ingresa la id que se quiere buscar


    public void generarReporte(){
        try {

            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=BCN;Encrypt=false", "Final_Poo_2024", "FinalPoo2024_25%");//00054123 Se realiza la conexion a la base de datos usando microsoft sql server y jdbc
            Statement stmt = con.createStatement(); //00054123 Se crea un statement usando la conexion al servidor

            ResultSet rs = stmt.executeQuery("select c.nombre as nombre from Cliente c where c.id = "+ IDBuscar.getText());//00054123 Se ejecuta la query que busca el nombre de la persona para tener un reporte mas completo
            rs.next();
            String nombreCliente = rs.getString("nombre"); //00054123 se guarda el nombre en una variable para dar un reporte con un mejor formato
            Calendar calendar = Calendar.getInstance(); //00054123 Llamando a la instancia del calendario para pdoer seguir el formato en que se nombran los registros


            try {
                File reporte = new File("ParcialFinalPoo"+File.separator+"src"+File.separator+"Reportes"+ File.separator+"Reporte A - "+calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DAY_OF_MONTH)+"-"+calendar.get(Calendar.HOUR_OF_DAY)+".txt"); //00054123 Generando el archivo de texto donde está el reporte con formato ReporteA - fecha y hora
                FileWriter fileWriter = new FileWriter(reporte);//00054123 Iniciando un fileWriter para poder llenar el reporte
                fileWriter.write("Reporte tipo A del cliente: "+nombreCliente+" \n\n"); //00054123 Se agrega algo de texto al inicio del reporte para un mejor formato del mismo


                Date dateFechaInicial = Date.valueOf(FechaInicial.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                Date dateFechaFinal = Date.valueOf(FechaFinal.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));


                rs = stmt.executeQuery("select T.total as total, T.fecha as fecha, T.descripcion as descripcion from Transaccion T inner join Tarjeta T2 on T2.id = T.id_tarjeta INNER JOIN Cliente C on C.id = T2.id_cliente where C.id = "+IDBuscar.getText()+" and T.fecha between '"+dateFechaInicial+"' AND '"+dateFechaFinal+"';");//00054123 Query para obtener los detalles de las compras entre las fechas ingresadas


                while (rs.next()) { //00054123 Empieza a iterar los resultados de la query para ponerlos en el reporte

                    fileWriter.write(" Total : "+rs.getString("total")+"\n"+" Fecha de transsaccion: "+rs.getString("fecha")+"\n"+" Descripcion: "+rs.getString("descripcion")+"\n"+"***********************************************"+"\n");//00054123 EScribe en el archivo los datos que se requieren para este

                }
                fileWriter.close();//00054123 Se cierra el file writter para evitar uso innecesario de recursos

            }catch (IOException E){} //00054123 Catch para errores al momento de trabajar los archivos

            con.close(); //00054123 se cierra la conexion al servidor para evitar uso de recursos innecesarios y por buenas practicas

        }catch(SQLException e){

            Alert error = new Alert(Alert.AlertType.ERROR); //00054123 Se crea un error porque se ingresaron datos incorrectos
            error.setTitle("Error"); //00054123 Se le pone un titulo a la alerta del error
            error.setHeaderText(null); //00054123 se pone un header null
            error.setContentText("Por favor revise los datos ingresados"); //00054123 EL cuepor del error ya que se ingresaron datos de forma incorrecta
            error.showAndWait(); //00054123 Se muestra el mensaje de eror y se espera para seguir

        } //00054123 Catch para errores de sql


    }
    @FXML
    public void onVolver(){

        BcnApp bcnApp = new BcnApp(); //00054123 SE crea una app del menu principal
        try {
            bcnApp.start(((Stage)IDBuscar.getScene().getWindow())); //00054123 SE reutiliza la escena y se inicia la app neuva
        }catch (Exception e){}; //00054123 Catch de exepciones al iniciar una app

    }



}
