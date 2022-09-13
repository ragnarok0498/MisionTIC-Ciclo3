package com.grupo56.equipo1.proyecto.conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexionesDB {

        String strConexionDB = "jdbc:mysql://localhost:3306/db_ciencia"; // variable para conectar con la base de datos
        Connection conn = null ;

        public ConexionesDB(){
            try {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection(strConexionDB);
                System.out.println("Conexion Establecida");
            }
            catch(Exception e){
                System.out.println("Error en la conexion" + e);
            }
        }
        public int ejecutarSentenciasSQL (String strSentenciaSQL){
            try {
                PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
                pstm.execute();
                return 1;
            }
            catch(Exception e){
                System.out.println(e);
                return 0;
            }

        }
        public ResultSet consultarRegistros(String strSentenciaSQL){
            try {
                PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
                ResultSet respuesta = pstm.executeQuery();
                return respuesta;

            }

            catch(Exception e){
                System.out.println(e);
                return null;
            }
        }
    }
