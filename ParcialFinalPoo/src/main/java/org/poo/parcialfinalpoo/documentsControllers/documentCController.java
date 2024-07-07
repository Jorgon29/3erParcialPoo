package org.poo.parcialfinalpoo.documentsControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Calendar;


public class documentCController {

    @FXML
    private Button Back;

    @FXML
    private TextField IDsearch;

    @FXML
    private Button generateReport;

    public void generateReport() {
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=BCN;Encrypt=false", "sa", "041204Dyn*");//00054123 Se realiza la conexion a la base de datos usando microsoft sql server y jdbc
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select c.nombre as nombre from Cliente c where c.id = "+ IDsearch.getText());//00054123 Se ejecuta la query que busca el nombre de la persona para tener un reporte mas completo
            rs.next();

            String nombreCliente = rs.getString("nombre"); //00054123 se guarda el nombre en una variable para dar un reporte con un mejor formato
            Calendar calendar = Calendar.getInstance(); //00054123 Llamando a la instancia del calendario
            try{
                File reporte = new File("src"+File.separator+"Reportes"+ File.separator+"Reporte C - "+calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DAY_OF_MONTH)+"-"+calendar.get(Calendar.HOUR_OF_DAY)+".txt"); //00054123 Generando el archivo de texto donde está el reporte con formato ReporteB - fecha y hora
                FileWriter fw = new FileWriter(reporte); //00054123 Se crea un filewritter para modificar le archivo respectivamente al reporte
               rs = stmt.executeQuery("select T.numero as numero from Tarjeta T inner join Cliente C on C.id = T.id_cliente where C.id = "+IDsearch.getText()+ "and T.tipo = 'credito';");

               fw.write("Las tarjetas a nombre de: "+nombreCliente+"\n"+"Tarjetas de credito\n");

               if(rs.next()){
                   fw.write(censore(rs.getString("numero"))+"\n");
                   while (rs.next()){
                       fw.write(censore(rs.getString("numero"))+"\n");
                   }
               }else {fw.write("N/A\n");}
               fw.write("\n");
                rs = stmt.executeQuery("select T.numero as numero from Tarjeta T inner join Cliente C on C.id = T.id_cliente where C.id = "+IDsearch.getText()+ "and T.tipo = 'debito';");
                fw.write("Tarjetas de debito:\n");
                if(rs.next()){
                    fw.write(censore(rs.getString("numero"))+"\n");
                    while (rs.next()){
                        fw.write(censore(rs.getString("numero"))+"\n");
                    }

                }else {fw.write("N/A\n");}



                fw.close();
            }catch (IOException e){}
            con.close();
        }catch (SQLException e){}


    }

    public String censore(String cardNumbers){

        char[] chars  = cardNumbers.toCharArray();

        for(int i=0; i<chars.length-4; i++){
            chars[i] = '*';
        }


        cardNumbers = new String(chars);
        return cardNumbers;
    }

}

