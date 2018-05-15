/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplocrud;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DAVID
 */
public class DepartamentoSalida {
    //lista a uno o a todos
	    public void listado() throws SQLException {
	        Departamentos dep = new Departamentos();
	        Departamento dep1 = new Departamento();
	        ArrayList<Departamento> deps = new ArrayList<>();
	

	        Scanner sc = new Scanner(System.in);
	        System.out.println("*****************************");
	        System.out.println("Presione 1 para que puedas listar todos los departamentos o en otro caso el 2 para listar un solo departamento");
	        System.out.println("*****************************");
	        switch (Integer.parseInt(sc.nextLine())) {
	            case 1:
	              
	                deps = dep.ReadALL();
	                for (int i = 0; i < deps.size(); i++) {
	                    System.out.println(deps.get(i).getDept_no() + "|" + deps.get(i).getDnombre() + "|" + deps.get(i).getLoc() + "|");
	                }
	                break;
	            case 2:
	                dep1 = dep.Listar(sc.nextLine());
	                System.out.println(dep1.getDnombre() + "|" + dep1.getDnombre() + "|" + dep1.getLoc() + "|");
	                break;
	        }
	    }
	

	    //metodo para buscar el departamento
	    public void BuscarDepepartamento() throws SQLException {
	        Departamentos dep = new Departamentos();
	        Departamento dep1 = new Departamento();
	        Scanner sc = new Scanner(System.in);
	        System.out.println("................");
	        System.out.println("Escribe el nombre del departamento que está buscando");
	        System.out.println("................");
	        dep1 = dep.Read(sc.nextLine());
	        System.out.println("");
	        System.out.println(dep1.getDept_no() + "|" + dep1.getDnombre() + "|" + dep1.getLoc());
	    }
	

	    //metodo para crear el departamento
	    public void CrearDepartamento() throws SQLException {
	        Departamentos dep = new Departamentos();
	        Departamento dep1 = new Departamento();
	        Scanner sc = new Scanner(System.in);
	

	        System.out.println("...................");
	        System.out.println("Pon a gusto el id del departamento");
	        System.out.println("...................");
	        dep1.setDnombre(sc.nextLine());
	        System.out.println("...................");
	        System.out.println("Pon el nombre que tendrá ese departamento:");
	        System.out.println("...................");
	        dep1.setDnombre(sc.nextLine());
	        System.out.println("...................");
	        System.out.println("Escribe la localidad donde se situará:");
	        System.out.println("...................");
	        dep1.setLoc(sc.nextLine());
	        dep.Create(dep1);
	    }
	

	    //metodo para eliminar departamento
	    public void EliminarDepartamento() throws SQLException {
	        Departamentos dep = new Departamentos();
	

	        Scanner sc = new Scanner(System.in);
	        System.out.println("..............");
	        System.out.println("Ahora puedes eliminar cualquier departamento:");
	        System.out.println("..............");
	
System.out.println("Departamento Eliminado filas modificadas: "+dep.Delete((sc.nextInt())));
	       
	    }
	

	}


  
