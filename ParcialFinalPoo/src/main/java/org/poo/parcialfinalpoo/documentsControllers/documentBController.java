package org.poo.parcialfinalpoo.documentsControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Calendar;

public class documentBController {

    @FXML
    private Button generateReport;

    @FXML
    private TextField monthSearch;

    @FXML
    private Button returnButton;

    @FXML
    private TextField searchID;

    @FXML
    private TextField yearSearch;


    public void onGenerarReporte(){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=BCN;Encrypt=false", "sa", "041204Dyn*");//00054123 Se realiza la conexion a la base de datos usando microsoft sql server y jdbc
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select c.nombre as nombre from Cliente c where c.id = "+ searchID.getText());//00054123 Se ejecuta la query que busca el nombre de la persona para tener un reporte mas completo
            rs.next();

            String nombreCliente = rs.getString("nombre"); //00054123 se guarda el nombre en una variable para dar un reporte con un mejor formato
            Calendar calendar = Calendar.getInstance(); //00054123 Llamando a la instancia del calendario

            try{

                File reporte = new File("src"+File.separator+"Reportes"+ File.separator+"Reporte B - "+calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DAY_OF_MONTH)+"-"+calendar.get(Calendar.HOUR_OF_DAY)+".txt"); //00054123 Generando el archivo de texto donde está el reporte con formato ReporteB - fecha y hora
                FileWriter fw = new FileWriter(reporte); //00054123 Se crea un filewritter para modificar e archivo respectivamente al reporte

                fw.write("Reporte tipo B del cliente: "+nombreCliente+" \n\n"); //00054123 Se agrega algo de texto al inicio del reporte para un mejor formato del mismo
                rs = stmt.executeQuery("select sum(T.total) as total from Transaccion T inner join Tarjeta T2 on T2.id = T.id_tarjeta where T2.id_cliente = "+searchID.getText()+" and datepart(month,fecha) = "+monthSearch.getText()+" and datepart(year,fecha) = "+yearSearch.getText()+";"); //00054123 Se busca en la base de datos transacciones donde la id sea la insertada y el mes y año de las compras sea el mismo
                rs.next(); //00054123 vamos al siguiente para leer los resultados de la query

                if(rs.getString("total")!=null) { //00054123 Revisa si la query encontró los datos
                    fw.write("El total gastado en: " + monthSearch.getText() + "/" + yearSearch.getText() + " ha sido de: $" + rs.getString("total") + "\n********************************************************"); // 00054123 genera el reporte con el gasto total en el mes especificado
                }else {fw.write("No hay ningun gasto en el año y mes especificado"+ "\n********************************************************");} //00054123 Como no habian datos entonces no hay compras asi que se escribe eso en el reporte

                fw.close(); //00054123 Cierra el file writter por buenas practicas y ahorro de recursos

            }catch (IOException e){} //00054123 El catch para un error en los archivos
            con.close(); //00054123 Cerrando la conexion para ahorrar recursos y por buenas practicas
        }catch(SQLException e){System.out.println("Something went wrong");} //00054123 catch por un error en la base de datos

    }

}
