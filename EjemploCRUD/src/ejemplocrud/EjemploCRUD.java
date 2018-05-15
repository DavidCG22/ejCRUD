/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplocrud;

import java.sql.SQLException;
import java.util.Scanner;

/*
 *
 * @author DAVID
 */
public class EjemploCRUD {

    /**
     * @param args the command line arguments
     */
       public static void main(String[] args) throws SQLException {


        //conexiones//
        DepartamentoSalida depSal = new DepartamentoSalida();
        EmpleadoSalida empSal = new EmpleadoSalida();
int main=1;
while( main!=9){

        //Menu inicial
        System.out.println(
                "\n"
                + "1.Lista Departamentos\n"
                + "2.Lista Empleados\n"
                + "3.Busca empleado por su nombre\n"
                + "4.Busca departamento por su nombre\n"
                + "5.Crea empleado\n"
                + "6.Crea departamento\n"
                + "7.Borra empleado\n"
                + "8.Borra departamento\n "
                + "9.Salir del menú\n"
                );


        //switch para que podamos instanciar los metodos
        Scanner sc = new Scanner(System.in);
         main = sc.nextInt();


        switch (main) {


            case 1:
                depSal.listado();
                break;


            case 2:
                empSal.Listado();
                break;
            case 3:
                empSal.Buscar();
                break;


            case 4:
                depSal.BuscarDepepartamento();
                break;


            case 5:
                empSal.CrearEmpleado();
                break;


            case 6:
                depSal.CrearDepartamento();
                break;


            case 7:
                empSal.EliminarEmpleado();
                break;


            case 8:
                depSal.EliminarDepartamento();
                break;
                
            default : if( main!=9) System.out.println("El numero no valee");
        }
//FIN switch

    }
}
}