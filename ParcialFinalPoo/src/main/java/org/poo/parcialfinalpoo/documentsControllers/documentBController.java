package org.poo.parcialfinalpoo.documentsControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Calendar;

public class documentBController {


    @FXML
    private TextField monthSearch; //00054123 Text field para ingresar el mes que se quiere buscar

    @FXML
    private TextField searchID; //00054123 Un text field para ingresar la id a buscar

    @FXML
    private TextField yearSearch; //00054123 Un text field para ingresar el año a buscar


    public void onGenerarReporte(){
        try{
            if(yearSearch.getText().isEmpty()||monthSearch.getText().isEmpty()||searchID.getText().isEmpty()){ //00054123 Revisa si no se ha ingresado algun campo que es necesario para la busqueda
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=BCN;Encrypt=false", "sa", "041204Dyn*");//00054123 Se realiza la conexion a la base de datos usando microsoft sql server y jdbc
            Statement stmt = con.createStatement(); //00054123 se crea un statement usando la conexion

            ResultSet rs = stmt.executeQuery("select c.nombre as nombre from Cliente c where c.id = "+ searchID.getText());//00054123 Se ejecuta la query que busca el nombre de la persona para tener un reporte mas completo
            rs.next(); //00054123 Se pasa al siguiente resultado para obtener el nombre

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
            }else{

                Alert error = new Alert(Alert.AlertType.ERROR); //00054123 Se crea una alerta de error porque no se llenaron todos los campos
                error.setTitle("Error"); //00054123 Se pone un titulo de error
                error.setHeaderText(null);//00054123 no es necesario un header asi que lo asignamos null
                error.setContentText("Por favor llene todos los campos"); //00054123 El cuerpo del error
                error.showAndWait(); //00054123 se muestra el error y se espera

            }
        }catch(SQLException e){

            Alert error = new Alert(Alert.AlertType.ERROR); //00054123 Se crea una alerta de error
            error.setTitle("Error"); //00054123 Se le pone un titulo al error
            error.setHeaderText(null); //00054123 no es necesario un header para un error corto
            error.setContentText("Por favor revise los datos ingresados"); //00054123 Se coloca el cuerpo del error para informar a quien lo usa
            error.showAndWait(); //00054123 Se muestra el error y se espera para continuar

        } //00054123 catch por un error en la base de datos

    }

}

