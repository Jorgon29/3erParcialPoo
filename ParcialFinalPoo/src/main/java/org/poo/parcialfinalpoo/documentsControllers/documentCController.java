package org.poo.parcialfinalpoo.documentsControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.poo.parcialfinalpoo.BcnApp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Calendar;


public class documentCController {


    @FXML
    private TextField IDsearch; //00054123 El campo donde se va a buscar la id


    public void generateReport() {
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=BCN;Encrypt=false", "Final_Poo_2024", "FinalPoo2024_25%");//00054123 Se realiza la conexion a la base de datos usando microsoft sql server y jdbc
            Statement stmt = con.createStatement(); //00054123 Se crea un statement usando la conexion
            ResultSet rs = stmt.executeQuery("select c.nombre as nombre from Cliente c where c.id = "+ IDsearch.getText());//00054123 Se ejecuta la query que busca el nombre de la persona para tener un reporte mas completo
            rs.next(); //00054123 Se itera al siguiente resultado

            String nombreCliente = rs.getString("nombre"); //00054123 se guarda el nombre en una variable para dar un reporte con un mejor formato
            Calendar calendar = Calendar.getInstance(); //00054123 Llamando a la instancia del calendario
            try{
                File reporte = new File("ParcialFinalPoo"+File.separator+"src"+File.separator+"Reportes"+ File.separator+"Reporte C - "+calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DAY_OF_MONTH)+"-"+calendar.get(Calendar.HOUR_OF_DAY)+".txt"); //00054123 Generando el archivo de texto donde está el reporte con formato ReporteB - fecha y hora
                FileWriter fw = new FileWriter(reporte); //00054123 Se crea un filewritter para modificar le archivo respectivamente al reporte
               rs = stmt.executeQuery("select T.numero as numero from Tarjeta T inner join Cliente C on C.id = T.id_cliente where C.id = "+IDsearch.getText()+ "and T.tipo = 'credito';"); //00054123 Se ejecuta un query que busca las tarjetas de credito

               fw.write("Las tarjetas a nombre de: "+nombreCliente+"\n"+"Tarjetas de credito:\n");//00054123 Se inserta algo de texto para un mejor formato de documento

               if(rs.next()){ //00054123 SE revisa si hay una tarjeta
                   do {
                       fw.write(censore(rs.getString("numero")) + "\n"); //00054123 Se escribe los datos en el documento
                   } while (rs.next()); //00054123 Se sigue iterando meintras hayan mas
               }else {fw.write("N/A\n");} //00054123 Como no habian tarjetas pues se deja asi
               fw.write("\n"); //00054123 Se hace un salto de linea para dar espacio a los siguiente
                rs = stmt.executeQuery("select T.numero as numero from Tarjeta T inner join Cliente C on C.id = T.id_cliente where C.id = "+IDsearch.getText()+ "and T.tipo = 'debito';"); //00054123 Ahora se buscan las tarjetas de debito
                fw.write("Tarjetas de debito:\n"); //00054123 Se escribe un texto inicial a colocar tarjetas
                if(rs.next()){ //Se revisa si se obtuvieron resultados
                    do {
                        fw.write(censore(rs.getString("numero")) + "\n"); //00054123 Se escribe la tarjeta y se censura
                    } while (rs.next()); //00054123 Se itera mientras hayan mas

                }else {fw.write("N/A\n");} //00054123 Se escribe n/A porque no es encontraron tarjetas de este tipo

                fw.close(); //00054123 Se cierra el filewritter para ahorrar recursos y buenas practicas
            }catch (IOException e){} //00054123 Catch a exepciones al trabajar archivos
            con.close(); //00054123 SE cierra la conexion pro buenas practicas
        }catch (SQLException e){ //Catch de errores de sql

            Alert error = new Alert(Alert.AlertType.ERROR); //00054123 Se crea un error porque se ingresaron datos incorrectos
            error.setTitle("Error"); //00054123 Se le pone un titulo a la alerta del error
            error.setHeaderText(null); //00054123 se pone un header null
            error.setContentText("Por favor revise los datos ingresados"); //00054123 EL cuepor del error ya que se ingresaron datos de forma incorrecta
            error.showAndWait(); //00054123 Se muestra el mensaje de eror y se espera para seguir

        }


    }

    public String censore(String cardNumbers){

        char[] chars  = cardNumbers.toCharArray(); //00054123 Se hace el texto en un array de caracteres

        for(int i=0; i<chars.length-4; i++){ //00054123 SE itera los caracteres hasta 4 antes
            chars[i] = '*'; //00054123 SE censuran los primeros 12 caracteres
        }


        cardNumbers = new String(chars); //00054123 Se hace un string en base a los caracteres
        return cardNumbers; //00054123 Se retorna el string ahora censurado
    }
     @FXML
    public void onVolver(){

        BcnApp bcnApp = new BcnApp(); //00054123 Se crea una nueva app de menu principal
        try {
            bcnApp.start(((Stage)IDsearch.getScene().getWindow()));//00054123se reutiliza la escena y se inicia el menu principal
        }catch (Exception e){};//00054123 CAtch a exepciones durante el inicio de uan app

    }
}

