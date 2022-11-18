package com.iessanalberto.joc.biblioteca;

import com.iessanalberto.joc.conexion.Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBilblioteca {
    public static void main(String[] args) {
        String bd = "biblioteca";
        Connection miCon = Conexion.conectar();
        String consulta = "CREATE DATABASE " + bd;
        try {
            Statement crearBD = miCon.createStatement();
            crearBD.execute(consulta);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}