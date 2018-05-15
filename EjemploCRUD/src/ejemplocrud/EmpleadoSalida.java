/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplocrud;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author DAVID
 */
public class EmpleadoSalida {
    	    //lista a uno o a todos
	    public void Listado() throws SQLException {
	        Empleados emp = new Empleados();
	        Empleado emp1;
	

	        Scanner sc = new Scanner(System.in);
	        System.out.println("");
	        System.out.println("*****************");
	        System.out.println("Presione 1 para que puedas listar todos los empleados o en otro caso 2 para listar un solo empleado");
	        System.out.println("******************");
	

	        switch (Integer.parseInt(sc.nextLine())) {
	            case 1:
	                emp.ListTodos();
	

	                for (int i = 0; i < emp.ListTodos().size(); i++) {
	                    emp1 = new Empleado();
	                    emp1 = emp.ListTodos().get(i);
	                    System.out.println(emp1.getEmp_no() + "|" + emp1.getApellido() + "|" + emp1.getOficio() + "|" + emp1.getDir() + "|" + emp1.getFecha_alt() + "|" + emp1.getSalario() + "|" + emp1.getComision() + "|" + emp1.getDpto_no());
	                }
	                break;
	            case 2:
	                emp1 = emp.ListUno(Integer.parseInt(sc.nextLine()));
	                System.out.println(emp1.getEmp_no() + "|" + emp1.getApellido() + "|" + emp1.getOficio() + "|" + emp1.getDir() + "|" + emp1.getFecha_alt() + "|" + emp1.getSalario() + "|" + emp1.getComision() + "|" + emp1.getDpto_no() + "|");
	                break;
	        }
	    }
	

	    //busca un empleado
	    public void Buscar() throws SQLException {
	

	        Empleados emp = new Empleados();
	        Empleado emp1;
	        Scanner sc = new Scanner(System.in);
	        System.out.println("***********");
	        System.out.println("Solicito el apellido del empleado");
	        System.out.println("***********");
	        emp1 = emp.BuscUno(sc.nextLine());
	        System.out.println("");
	        System.out.println(emp1.getEmp_no() + "|" + emp1.getApellido() + "|" + emp1.getOficio() + "|" + emp1.getDir() + "|" + emp1.getFecha_alt() + "|" + emp1.getSalario() + "|" + emp1.getComision() + "|" + emp1.getDpto_no() + "|");
	

	    }
	

	    //crea un nuevo empleado
	    public void CrearEmpleado() throws SQLException {
	        Empleados emp = new Empleados();
	        Empleado emp1 = new Empleado();
	        Scanner sc = new Scanner(System.in);
	

	        System.out.println("***************");
	        System.out.println("Escribe el num de empleado que va a tener ");
	        System.out.println("***************");
	        emp1.setEmp_no(Integer.parseInt(sc.nextLine()));
	        System.out.println("****************");
	        System.out.println("Escribe su apellido:");
	        System.out.println("****************");
	        emp1.setApellido(sc.nextLine());
	        System.out.println("*****************");
	        System.out.println("Escribe su oficio:");
	        System.out.println("*****************");
	        emp1.setOficio(sc.nextLine());
	        System.out.println("*****************");
	        System.out.println("Escribe el codigo de su director:");
	        System.out.println("******************");
	        emp1.setDir(Integer.parseInt(sc.nextLine()));
	        System.out.println("******************");
	        System.out.println("Dime la fecha de alta donde entró el empleado:");
	        System.out.println("******************");
	        java.sql.Date jsqlD = java.sql.Date.valueOf(sc.nextLine());
	        emp1.setFecha_alt(jsqlD);
	        System.out.println("******************");
	        System.out.println("Salario que tendrá el trabajador:");
	        System.out.println("******************");
	        emp1.setSalario((Integer.parseInt(sc.nextLine())));
	        System.out.println("******************");
	        System.out.println("Comision que se le proporcionará:");
	        System.out.println("******************");
	        emp1.setComision((Integer.parseInt(sc.nextLine())));
	        System.out.println("******************");
	        System.out.println("Su número de departamento es...:");
	        System.out.println("******************");
	        emp1.setDpto_no(Integer.parseInt(sc.nextLine()));
	

	        emp.CrearEmpleado(emp1);
	    }
	

	    //elimina al empleado
	    public void EliminarEmpleado() throws SQLException {
	        Empleados emp = new Empleados();
	

	        Scanner sc = new Scanner(System.in);
	        System.out.println("**********************");
	        System.out.println("Mete el id de empleado para eliminarlo");
	        System.out.println("***********************");
	

	        emp.BorraE(Integer.parseInt(sc.nextLine()));
	    }
	}


    

