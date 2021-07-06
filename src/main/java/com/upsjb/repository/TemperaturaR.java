package com.upsjb.repository;

import com.upsjb.entity.TemperaturaE;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TemperaturaR {

    private String usuario = "root";
    private String pwd = "";
    private static String DB = "controltemperatura";
    private String url = "jdbc:mariadb://localhost/" + DB;
    private Connection connection = null;

    public TemperaturaR() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        connection = (Connection) DriverManager.getConnection(url, usuario, pwd);
    }

    public boolean insert(TemperaturaE temperatura) {
        boolean estado = false;
        try {
            String sql = "INSERT INTO TEMPERATURA( CodigoSensor, UbicacionSensor, Fecha, FechaHora, Hora, ValorTemperatura)VALUES(?,?,?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, temperatura.getCodigoSensor());
            st.setString(2, temperatura.getUbicacionSensor());
            st.setString(3, temperatura.getFecha());
            st.setString(4, temperatura.getFechaHora());
            st.setString(5, temperatura.getHora());
            st.setDouble(6, temperatura.getValorTemperatura());
            st.execute();
            estado = true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            estado = false;
        }
        return estado;
    }

    public List<TemperaturaE> list(String fecha) {
        
        List<TemperaturaE> lista = new ArrayList<>();
        TemperaturaE temp;
        
        try {
            
            String sql = "select UbicacionSensor, hora, avg(valortemperatura) as 'ValorTemperatura'\n"
                    + "from temperatura where fecha = '"+ fecha + "' group by Hora;";

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                temp = new TemperaturaE();
                temp.setUbicacionSensor(rs.getString("UbicacionSensor"));
                temp.setHora(rs.getString("hora"));
                temp.setValorTemperatura(rs.getDouble("ValorTemperatura"));
                lista.add(temp);
            }
            st.close();

        } catch (SQLException ex) {
            System.out.println("Error Lista: " + ex.getMessage());
        }
        return lista;
    }

}
