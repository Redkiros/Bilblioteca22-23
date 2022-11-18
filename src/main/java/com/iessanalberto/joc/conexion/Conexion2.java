package com.iessanalberto.joc.conexion;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexion2 {
    static String URL = "jdbc:mysql://localhost:6603/biblioteca";
    static String USER = "root";
    static String PASS = "admin";

    public DataSource poolConexiones(){
        BasicDataSource datosConexion = new BasicDataSource();
        datosConexion.setUrl(URL);
        datosConexion.setUsername(USER);
        datosConexion.setPassword(PASS);
        datosConexion.setInitialSize(50);
        return datosConexion;
    }
    public Connection conectar() throws SQLException {
        return poolConexiones().getConnection();
    }

}
