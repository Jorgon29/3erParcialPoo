package org.poo.parcialfinalpoo.documentsControllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private Button back;

    @FXML
    private ChoiceBox<String> facilitatorBox;

    @FXML
    private Button generateReport;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=BCN;Encrypt=false", "", "");//00054123 Se realiza la conexion a la base de datos usando microsoft sql server y jdbc
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select F.nombre as nombre from Facilitador F");
            while (rs.next()) {
                facilitatorBox.getItems().add(rs.getString("nombre"));
            }
            con.close();
        }catch(SQLException e){};
    }
    public void generateReport() {
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=BCN;Encrypt=false", "sa", "041204Dyn*");//00054123 Se realiza la conexion a la base de datos usando microsoft sql server y jdbc
            Statement stmt = con.createStatement(); //00054123 se crea el statement para utilizar queries
            Calendar calendar = Calendar.getInstance(); //00054123 Llamando a la instancia del calendario
            try{
                File reporte = new File("ParcialFinalPoo"+File.separator+"src"+File.separator+"Reportes"+ File.separator+"Reporte D - "+calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DAY_OF_MONTH)+"-"+calendar.get(Calendar.HOUR_OF_DAY)+".txt"); //00054123 Generando el archivo de texto donde está el reporte con formato ReporteB - fecha y hora
                FileWriter fw = new FileWriter(reporte); //00054123 Se crea un filewritter para modificar e archivo respectivamente al reporte
                ResultSet rs = stmt.executeQuery("select C.nombre as nombre, Sum(T2.total) as total, COUNT(T2.id) as transacciones from Cliente C inner join Tarjeta T on C.id = T.id_cliente inner join Transaccion T2 on T.id = T2.id_tarjeta inner join Facilitador F on F.id = T.id_facilitador where F.nombre = '"+facilitatorBox.getValue()+"'" +
                        "GROUP BY C.nombre ");
                fw.write("Informe de tipo C del proveedor: "+facilitatorBox.getValue()+"\n");
                while (rs.next()){
                    fw.write("Comprador: "+rs.getString("nombre")+" realizo: "+rs.getInt("transacciones")+" transacciones, con un total de compras de: "+rs.getDouble("total")+"\n");
                }
                fw.close();
            }catch (IOException E){}
              con.close();
        }catch (SQLException e){}

    }
    public void onVolver(){
        ((Stage)facilitatorBox.getScene().getWindow()).close();
        Stage stage = new Stage();
        BcnApp bcnApp = new BcnApp();
        try {
            bcnApp.start(stage);
        }catch (Exception e){};

    }
}
