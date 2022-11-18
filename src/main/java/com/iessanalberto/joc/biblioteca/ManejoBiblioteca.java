package com.iessanalberto.joc.biblioteca;

import com.iessanalberto.joc.conexion.Conexion;
import com.iessanalberto.joc.conexion.ManejoTabla;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

// clase para la gestion de la creación y datos de la biblioteca
public class ManejoBiblioteca {
    static ArrayList<Libro> libros = new ArrayList<>();
    static ArrayList<Socio> socios = new ArrayList<>();
    static ArrayList<Prestamo> prestamos = new ArrayList<>();

    public static void crearLibros(){
        // libros
        libros.add(new Libro(1, "El Perfume", "Patrick Suskind", "Edelvives", 1985, "ISBN1", 10, 180));
        libros.add(new Libro(2, "El medico", "Noah Gordon", "Planeta", 1986, "ISBN2", 20, 450));
        libros.add(new Libro(3, "Tuareg", "Vazquez Figueroa", "Marcombo", 1980, "ISBN3", 30, 675));
        libros.add(new Libro(4, "IT", "Stephen King", "Alfaguara", 1986, "ISBN4", 40, 785));
        libros.add(new Libro(5, "Momo", "Michael Ende", "Sintesis", 1973, "ISBN5", 50, 350));

    }
    public static void crearSocios(){
        // socios
        Date bornDate1 = new Date(978307200000L); //01/01/2001
        Date bornDate2 = new Date(315532800000L); //01/01/1980
        Date bornDate3 = new Date(631152000000L); //01/01/1990
        Date bornDate4 = new Date(788918400000L); //01/01/1995
        Date bornDate5 = new Date(1104537600000L); //01/01/2005
        socios.add(new Socio(1, "Pepe", "Sanchez", Date.valueOf(bornDate1.toLocalDate()), "Sabi", "55555555"));
        socios.add(new Socio(2, "Pepa", "Butler", Date.valueOf(bornDate2.toLocalDate()), "Jaca", "2345123"));
        socios.add(new Socio(3, "Juan", "Gaviria", Date.valueOf(bornDate3.toLocalDate()), "Gavin", "3456789"));
        socios.add(new Socio(4, "Juana", "Dessy", Date.valueOf(bornDate4.toLocalDate()), "Tramacastilla", "55555555"));
        socios.add(new Socio(5, "Jose", "Otin", Date.valueOf(bornDate5.toLocalDate()), "Badaguas", "666666"));

    }
    public static void crearPrestamos(){
        // prestamos
        Date initDate1 = new Date(1633132800000L);
        Date initDate2 = new Date(initDate1.getTime() + (1000 * 60 * 60 * 24 * 2)); //2 days later
        Date initDate3 = new Date(initDate1.getTime() + (1000 * 60 * 60 * 24 * 4)); //4 days later
        Date endDate1 = new Date(initDate1.getTime() + (1000 * 60 * 60 * 24 * 15)); //15 days later
        Date endDate2 = new Date(initDate2.getTime() + (1000 * 60 * 60 * 24 * 15)); //15 days later
        Date endDate3 = new Date(initDate3.getTime() + (1000 * 60 * 60 * 24 * 15)); //15 days later
        prestamos.add(new Prestamo(1, 1, Date.valueOf(initDate1.toLocalDate()), Date.valueOf(endDate1.toLocalDate())));
        prestamos.add(new Prestamo(2, 2, Date.valueOf(initDate2.toLocalDate()), Date.valueOf(endDate2.toLocalDate())));
        prestamos.add(new Prestamo(3, 3, Date.valueOf(initDate3.toLocalDate()), Date.valueOf(endDate3.toLocalDate())));
    }

    public static void insertarLibros() {
        Connection miCon = Conexion.conectar2();
        PreparedStatement consulta;

        try {
            for (Libro libro : libros) {
                consulta = miCon.prepareStatement("INSERT INTO libro (codigo, titulo, autor, editorial, ano, isbn, numeroEjemplares, numeroPaginas) VALUES (?,?,?,?,?,?,?,?)");
                consulta.setInt(1, libro.getCodigo());
                consulta.setString(2, libro.getTitulo());
                consulta.setString(3, libro.getAutor());
                consulta.setString(4, libro.getEditorial());
                consulta.setInt(5, libro.getAno());
                consulta.setString(6, libro.getIsbn());
                consulta.setInt(7, libro.getNumeroEjemplares());
                consulta.setInt(8, libro.getNumeroPaginas());
                consulta.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertarSocios() {
        Connection miCon = Conexion.conectar2();
        PreparedStatement consulta;

        for (Socio socio : socios) {
            try {
                consulta = miCon.prepareStatement("INSERT INTO socio (codigo, nombre, apellidos, fechaNacimiento, domicilio, telefono) VALUES (?,?,?,?,?,?)");
                consulta.setInt(1, socio.getCodigo());
                consulta.setString(2, socio.getNombre());
                consulta.setString(3, socio.getApellidos());
                consulta.setDate(4, socio.getFechaNacimiento());
                consulta.setString(5, socio.getDomicilio());
                consulta.setString(6, socio.getTelefono());
                consulta.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void insertarPrestamos() {
        Connection miCon = Conexion.conectar2();
        PreparedStatement consulta;

        for (Prestamo prestamo : prestamos) {
            try {
                consulta = miCon.prepareStatement("INSERT INTO prestamo (codigoLibro, codigoSocio, fechaInicioPrestamo, fechaFinPrestamo) VALUES (?,?,?,?)");
                consulta.setInt(1, prestamo.getCodigoLibro());
                consulta.setInt(2, prestamo.getCodigoSocio());
                consulta.setDate(3, prestamo.getFechaInicioPrestamo());
                consulta.setDate(4, prestamo.getFechaFinPrestamo());
                consulta.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void crearBiblioteca() {
        crearTablas();
        insertarDatos();
    }

    public static void borraBiblioteca() {
        Connection miCon = Conexion.conectar2();
        PreparedStatement consulta;

        try {
            consulta = miCon.prepareStatement("DROP DATABASE biblioteca");
            consulta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertarDatos() {
        insertarLibros();
        insertarSocios();
        insertarPrestamos();
    }

    public static void crearTablas() {
        ManejoTabla.crear("libro",
                "(codigo INT NOT NULL, "
                        + "titulo VARCHAR(40), "
                        + "autor VARCHAR(40), "
                        + "editorial VARCHAR(40), "
                        + "ano INT, "
                        + "isbn VARCHAR(40) NOT NULL, "
                        + "numeroEjemplares INT, "
                        + "numeroPaginas INT, "
                        + "PRIMARY KEY (codigo), UNIQUE (isbn))");

        ManejoTabla.crear("socio",
                "(codigo INT NOT NULL, "
                        + "nombre VARCHAR(40), "
                        + "apellidos VARCHAR(40), "
                        + "fechaNacimiento DATE, "
                        + "domicilio VARCHAR(40), "
                        + "telefono VARCHAR(40), "
                        + "PRIMARY KEY (codigo))");

        ManejoTabla.crear("prestamo",
                "(codigoLibro INT NOT NULL, "
                        + "codigoSocio INT NOT NULL, "
                        + "fechaInicioPrestamo DATE, "
                        + "fechaFinPrestamo DATE, "
                        + "PRIMARY KEY (codigoLibro, codigoSocio), "
                        + "FOREIGN KEY (codigoSocio) REFERENCES socio(codigo), "
                        + "FOREIGN KEY (codigoLibro) REFERENCES libro(codigo))");

    }
}