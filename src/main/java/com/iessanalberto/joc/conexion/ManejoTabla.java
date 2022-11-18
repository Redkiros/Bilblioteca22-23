package com.iessanalberto.joc.conexion;

import java.sql.*;

// clase que gestiona la creacion de tablas
public class ManejoTabla {
	
	// metodo para crear tablas
	public static void crear(String nombreTabla, String camposTabla) {
		Connection miCon = Conexion.conectar2();
		String sentencia = "create TABLE IF NOT EXISTS " + nombreTabla + " " + camposTabla + ";";
		
		try {
			Statement consulta = miCon.createStatement();
			
			if (consulta.execute(sentencia)) {
				System.out.println("tabla creada");
			}
			System.out.println("tabla " + nombreTabla + " OK");

		} catch (Exception e ) {
			System.out.println("Error: " + e);
		}
	}
	
	public static void borrar(String nombreTabla) {
		Connection miCon = Conexion.conectar2();
		String sentencia = "DROP TABLE " + nombreTabla + ";";
		
		try {
			Statement consulta = miCon.createStatement();
			consulta.execute(sentencia);
			System.out.println("Tabla borrada");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// metodo no utilizado
	public static void verCosas() {
		Connection miCon = Conexion.conectar2();
	
		DatabaseMetaData dbmd;
		try {
			dbmd = miCon.getMetaData();
			String driverVersion = dbmd.getDriverVersion();
			System.out.println(driverVersion);
			String[] tipos = {"TABLE", "VIEW"};
			ResultSet tablas = dbmd.getTables(null, null, null, tipos);
			while (tablas.next()) {
				String catalogo = tablas.getString("TABLE_CAT");
				String esquema = tablas.getString("TABLE_SCHEM");
				String nombre = tablas.getString("TABLE_NAME");
				String tipo = tablas.getString("TABLE_TYPE");
				
				System.out.println("catalogo: " + nombre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}