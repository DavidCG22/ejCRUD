/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplocrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAVID
 */
public class Departamentos {

    private Connection conexion;
    private ArrayList<Departamento> departamentos;

    public Departamentos() {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//metodo para crear departamentos
    public int Create(Departamento dep) throws SQLException {
        int filas;
        String sql = "INSERT INTO departamentos VALUES ( ?, ?, ? )";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, dep.getDept_no());
        sentencia.setString(2, dep.getDnombre());
        sentencia.setString(3, dep.getLoc());
        filas = sentencia.executeUpdate();
        return filas;
    }
//metodo para actualizar departamentos
    public void Update(int dep_no, Departamento dep) throws SQLException {
        int filas;
        String sql = "UPDATE Departamento set dept_no='?' where dnombre='?' loc='?'";
        PreparedStatement sentencia;
        
        sentencia = conexion.prepareCall(sql);
        sentencia.setInt(1, dep.getDept_no());
        sentencia.setString(2, dep.getDnombre());
        sentencia.setString(3, dep.getLoc());
        filas=sentencia.executeUpdate();
        
}
//metodo que lee un solo departamento
    public Departamento Read(String dept_no) throws SQLException {
         Departamento dep=null;
         String sql ="select * from departamentos where dnombre=?";
                PreparedStatement sentencia=conexion.prepareStatement(sql);
                 sentencia.setString(1, dept_no);
                 ResultSet rs = sentencia.executeQuery();
                 while (rs.next()){
                     dep=new Departamento ( rs.getInt(1), rs.getString(2), rs.getString(3));
                 }
                 return dep;

    }
    
//metodo que lee todos los departamentos
    public ArrayList<Departamento> ReadALL() throws SQLException {
         Departamento dep=null;
         departamentos = new ArrayList<>();
         String sql ="select * from departamentos";
                 Statement sentencia = conexion.createStatement();
                 ResultSet rs = sentencia.executeQuery(sql);
                 rs.first();
                 while (rs.next()){
                     dep=new Departamento ( rs.getInt(1), rs.getString(2), rs.getString(3));
                     departamentos.add(dep);
                 }
                 return departamentos;

    }
//metodo que borra dep
    public int Delete(int dept_no) throws SQLException {
        int filas;
        String sql = "delete from departamentos where dept_no=?";
        PreparedStatement sentencia;
        sentencia=conexion.prepareStatement(sql);
        sentencia.setInt(1,dept_no);
        filas = sentencia.executeUpdate();
        return filas;
    }

    public void Close() throws SQLException{
        conexion.close();
        
    }
    
    public void ListarTODOS() throws SQLException{
        ReadALL();
        
    }
      public Departamento Listar(String D) throws SQLException{
        
        return Read(D);
         }
      
    public Departamento Buscar(int dep_no) throws SQLException
	    {
	        Departamento dep = new Departamento();
	        String sql = "SELECT * FROM departamentos WHERE dept_no = ?";
	        PreparedStatement sentencia = conexion.prepareStatement(sql);
	        sentencia.setInt(1, dep_no);
	        ResultSet rs = sentencia.executeQuery();
	        rs.first();
	        dep.setDept_no(rs.getInt(1));
	        dep.setDnombre(rs.getString(2));
	        dep.setLoc(rs.getString(3));
	        return dep;
	    }
    
    public Departamento BuscarDepartamentos(int dep_no) throws SQLException{
        return Buscar(dep_no);
    }
    
    
    public int CrearDepartamento(Departamento dep) throws SQLException{
        return Create(dep);
    }
    
    public int BorrarDepartamento(int dep_no) throws SQLException{
        return Delete(dep_no);
    }




  
    }

