package com.iessanalberto.joc.biblioteca;

// clase que repesenta la tabla socio

import java.sql.Date;

public class Socio {
    int codigo;
    Date fechaNacimiento;
    String nombre, apellidos, domicilio, telefono;

    public Socio(int codigo, String nombre, String apellidos, Date fechaNacimiento, String domicilio, String telefono) {
        this.codigo = codigo;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Socio [codigo=" + codigo + ", fechaNacimiento=" + fechaNacimiento + ", nombre=" + nombre
                + ", apellidos=" + apellidos + ", domicilio=" + domicilio + ", telefono=" + telefono + "]";
    }
}