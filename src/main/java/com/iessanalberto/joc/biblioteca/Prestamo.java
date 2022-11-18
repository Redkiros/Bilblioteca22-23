package com.iessanalberto.joc.biblioteca;

// clase que representa la tabla prestamos

import java.sql.Date;

public class Prestamo {
    int codigoLibro, codigoSocio;
    Date fechaInicioPrestamo, fechaFinPrestamo;

    public Prestamo(int codigoLibro, int codigoSocio, Date fechaInicioPrestamo, Date fechaFinPrestamo) {
        super();
        this.codigoLibro = codigoLibro;
        this.codigoSocio = codigoSocio;
        this.fechaInicioPrestamo = fechaInicioPrestamo;
        this.fechaFinPrestamo = fechaFinPrestamo;
    }

    public int getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(int codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public int getCodigoSocio() {
        return codigoSocio;
    }

    public void setCodigoSocio(int codigoSocio) {
        this.codigoSocio = codigoSocio;
    }

    public Date getFechaInicioPrestamo() {
        return fechaInicioPrestamo;
    }

    public void setFechaInicioPrestamo(Date fechaInicioPrestamo) {
        this.fechaInicioPrestamo = fechaInicioPrestamo;
    }

    public Date getFechaFinPrestamo() {
        return fechaFinPrestamo;
    }

    public void setFechaFinPrestamo(Date fechaFinPrestamo) {
        this.fechaFinPrestamo = fechaFinPrestamo;
    }

    @Override
    public String toString() {
        return "Prestamo [codigoLibro=" + codigoLibro + ", codigoSocio=" + codigoSocio + ", fechaInicioPrestamo="
                + fechaInicioPrestamo + ", fechaFinPrestamo=" + fechaFinPrestamo + "]";
    }

}