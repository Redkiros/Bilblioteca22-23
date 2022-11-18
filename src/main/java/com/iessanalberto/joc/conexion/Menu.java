package com.iessanalberto.joc.conexion;

import com.iessanalberto.joc.biblioteca.CrearBilblioteca;
import com.iessanalberto.joc.biblioteca.ManejoBiblioteca;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;
        do {

            System.out.println("Elige una opcion:");
            System.out.println("-------------------OPCIONES DE CONSULTA-------------------");
            System.out.println("1. Ver todos los libros");
            System.out.println("2. Ver todos los socios");
            System.out.println("3. Ver todos los prestamos");
            System.out.println("-------------------OPCIONES DE BASE DE DATOS-------------------");
            System.out.println("4. Crear base de datos biblioteca");
            System.out.println("5. Crear Tablas");
            System.out.println("6. Insertar Libros");
            System.out.println("7. Insertar Socios");
            System.out.println("8. Insertar Prestamos");
            System.out.println("10. Borrar Base de Datos");


            opcion = sc.nextInt();
            switch (opcion) {
                case 0:
                    System.out.println("Saliendo del programa");
                    System.exit(0);
                    break;
                case 1:
                    Consulta.verTodoLibros();
                    break;
                case 2:
                    Consulta.verTodoSocios();
                    break;
                case 3:
                    Consulta.verTodosPrestamos();
                    break;
                case 4:
                    CrearBilblioteca.main(args);
                    break;
                case 5:
                    ManejoBiblioteca.crearTablas();
                    break;
                case 6:
                    ManejoBiblioteca.crearLibros();
                    ManejoBiblioteca.insertarLibros();
                    break;
                case 7:
                    ManejoBiblioteca.crearSocios();
                    ManejoBiblioteca.insertarSocios();
                    break;
                case 8:
                    ManejoBiblioteca.crearPrestamos();
                    ManejoBiblioteca.insertarPrestamos();
                    break;
                case 9:
                    ManejoBiblioteca.borraBiblioteca();
                    break;
            }
        } while (opcion != 0);
    }
}