package com.iessanalberto.joc.conexion;

// clase principal que contiene el main

import com.iessanalberto.joc.biblioteca.ManejoBiblioteca;

import java.sql.SQLException;

public class Aplicacion {

    public static void main(String[] args) throws SQLException {
        ManejoBiblioteca.crearBiblioteca();

        Consulta.verTablas();
        Consulta.verTodoLibros();
        Consulta.verTodoSocios();
        Consulta.verTodosPrestamos();
        Consulta.librosPrestados();
        Consulta.librosPrestadosSocio(2);
        Consulta.librosPrestamoExpirado();
        Consulta.sociosLibrosPrestamoExpirado();

    }

}