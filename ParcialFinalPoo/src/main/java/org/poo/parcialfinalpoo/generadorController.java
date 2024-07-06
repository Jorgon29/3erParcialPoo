package org.poo.parcialfinalpoo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.Calendar;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class generadorController {

    @FXML
    private TextField FechaFinal;

    @FXML
    private TextField FechaInicial;

    @FXML
    private TextField IDBuscar;

    @FXML
    private Button Volver;

    @FXML
    private Button generarReporte;

    public void generarReporte(){
        try {

            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=BCN;Encrypt=false", "sa", "041204Dyn*");//00054123 Se realiza la conexion a la base de datos usando microsoft sql server y jdbc
            Statement stmt = con.createStatement(); //00054123 Se crea un statement usando la conexion al servidor

            ResultSet rs = stmt.executeQuery("select c.nombre as nombre from Cliente c where c.id = "+ IDBuscar.getText());//00054123 Se ejecuta la query que busca el nombre de la persona para tener un reporte mas completo
            rs.next();
            String nombreCliente = rs.getString("nombre"); //00054123 se guarda el nombre en una variable para dar un reporte con un mejor formato
            Calendar calendar = Calendar.getInstance(); //00054123 Llamando a la instancia del calendario

            try {

                File reporte = new File("src"+File.separator+"Reportes"+ File.separator+"Reporte A - "+calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DAY_OF_MONTH)+"-"+calendar.get(Calendar.HOUR_OF_DAY)+".txt"); //00054123 Generando el archivo de texto donde está el reporte con formato ReporteA - fecha y hora

                FileWriter fileWriter = new FileWriter(reporte);//00054123 Iniciando un fileWriter para poder llenar el reporte de todo

                fileWriter.write("Reporte del cliente: "+nombreCliente+" \n\n"); //00054123 Se agrega algo de texto al inicio del reporte para un mejor formato del mismo


                rs = stmt.executeQuery("select T.total as total, T.fecha as fecha, T.descripcion as descripcion, C.nombre as nombre from Transaccion T inner join Tarjeta T2 on T2.id = T.id_tarjeta INNER JOIN Cliente C on C.id = "+IDBuscar.getText()+" where T.fecha between '"+FechaInicial.getText()+"' AND '"+FechaFinal.getText()+"';");//00054123 Query para obtener los detalles de las compras entre las fechas ingresadas


                while (rs.next()) { //00054123 Empieza a iterar los resultados de la query para ponerlos en el reporte

                    fileWriter.write(" Total : "+rs.getString("total")+"\n"+" Fecha de transsaccion: "+rs.getString("fecha")+"\n"+" Descripcion: "+rs.getString("descripcion")+"\n"+"***********************************************"+"\n");//00054123 EScribe en el archivo los datos que se requieren para este

                }
                fileWriter.close();//00054123 Se cierra el file writter para evitar uso innecesario de recursos

            }catch (IOException E){System.out.println("Something went wrong with the file");} //00054123 Catch para errores al momento de trabajar los archivos
            con.close(); //00054123 se cierra la conexion al servidor para evitar uso de recursos innecesarios y por buenas practicas
        }catch(SQLException e){System.out.println("Something went wrong");} //Catch para errores de sql

    }

}
