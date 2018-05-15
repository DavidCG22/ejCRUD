/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplocrud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author DAVID
 */
public class Empleados {

    private Connection conexion;
    private ArrayList<Empleado> Empleados;
    
    public Empleados(){
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
        //metodo para crear el empleado
    public int CrearEmpleado(Empleado emp) throws SQLException {
        int filas;
        String sql = "INSERT INTO empleados VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, emp.getEmp_no());
        sentencia.setString(2, emp.getApellido());
        sentencia.setString(3, emp.getOficio());
        sentencia.setInt(4, emp.getDir());
        sentencia.setDate(5, (Date) emp.getFecha_alt());
        sentencia.setFloat(6, emp.getSalario());
        sentencia.setFloat(7, emp.getComision());
        sentencia.setInt(8, emp.getDpto_no());
        filas = sentencia.executeUpdate();
        return filas;
    }


    //metodo que actualizará al empleado
    public int Update(int emp_no, Empleado emp) throws SQLException {
        String sql = "UPDATE Empleados SET  emp_no= ?, apellido= ?, oficio=?, dir=?, fecha_alt=?,salario=?,comision=?,dpto_no=? WHERE dpto_no=?;";
        int filas;
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, emp_no);
        sentencia.setString(2, emp.apellido);
        sentencia.setString(3, emp.oficio);
        sentencia.setInt(4, emp.dir);
        sentencia.setDate(5, (Date) emp.fecha_alt);
        sentencia.setInt(6, emp.salario);
        sentencia.setInt(7, emp.comision);
        sentencia.setInt(8, emp_no);
        filas = sentencia.executeUpdate();
        return filas;
    }


    //metodo que listará a un solo empleado
    public Empleado ListUno(int emp_no) throws SQLException {
        Empleado emp = new Empleado();
        String sql = "SELECT * FROM Empleados WHERE emp_no=?;";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, emp_no);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
        emp.setEmp_no(rs.getInt(1));
        emp.setApellido(rs.getString(2));
        emp.setOficio(rs.getString(3));
        emp.setDir(rs.getInt(4));
        emp.setFecha_alt(rs.getDate(5));
        emp.setSalario(rs.getInt(6));
        emp.setComision(rs.getInt(7));
        emp.setDpto_no(rs.getInt(8));
        return emp;
    }


    //metodo que buscará a un solo empleado
    public Empleado BuscUno(String Apellido) throws SQLException {
        Empleado emp = new Empleado();
        String sql = "SELECT * FROM Empleados WHERE apellido=?;";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, Apellido);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
        emp.setEmp_no(rs.getInt(1));
        emp.setApellido(rs.getString(2));
        emp.setOficio(rs.getString(3));
        emp.setDir(rs.getInt(4));
        emp.setFecha_alt(rs.getDate(5));
        emp.setSalario(rs.getInt(6));
        emp.setComision(rs.getInt(7));
        emp.setDpto_no(rs.getInt(8));
        return emp;
    }


    //metodo que listará a todos los empleados
    public ArrayList<Empleado> ListTodos() throws SQLException {
        Empleado emp;
        ArrayList<Empleado> emps = new ArrayList<>();
        String sql = "SELECT * FROM Empleados ;";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            emp = new Empleado();
            emp.setEmp_no(rs.getInt(1));
            emp.setApellido(rs.getString(2));
            emp.setOficio(rs.getString(3));
            emp.setDir(rs.getInt(4));
            emp.setFecha_alt(rs.getDate(5));
            emp.setSalario(rs.getInt(6));
            emp.setComision(rs.getInt(7));
            emp.setDpto_no(rs.getInt(8));
            emps.add(emp);
        }
        return emps;
    }


    //metodo para borrar empleados
    public int BorraE(int emp) throws SQLException {
        String sql = "DELETE FROM Empleados WHERE emp_no=?;";
        int filas;
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, emp);
        filas = sentencia.executeUpdate();
        return filas;
    }


   
    public void Close() throws SQLException {
        conexion.close();
    }
}

