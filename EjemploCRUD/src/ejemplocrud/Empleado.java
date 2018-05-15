/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplocrud;

import java.util.Date;

/**
 *
 * @author DAVID
 */

//variables de la clase empleado
public class Empleado {
    private int emp_no;
    String apellido;
    String oficio;
    int dir;
    Date fecha_alt;
    int salario;
    int comision;
    private int dpto_no;
   
//constructor de la clase empleado
    public Empleado(int emp_no, String apellido, String oficio, int dir, Date fecha_alt, int salario, int comision, int dpto_no) {
        this.emp_no = emp_no;
        this.apellido = apellido;
        this.oficio = oficio;
        this.dir = dir;
        this.fecha_alt = fecha_alt;
        this.salario = salario;
        this.comision = comision;
        this.dpto_no = dpto_no;
    }
//también haremos un constructor vacio
    public Empleado() {
        
    }
//getters y setters
    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public Date getFecha_alt() {
        return fecha_alt;
    }

    public void setFecha_alt(Date fecha_alt) {
        this.fecha_alt = fecha_alt;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public int getDpto_no() {
        return dpto_no;
    }

    public void setDpto_no(int dpto_no) {
        this.dpto_no = dpto_no;
    }
    
    
    
    
}
