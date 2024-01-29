/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.aldeaninjakonoha.vista;

import com.mycompany.aldeaninjakonoha.habilidad.controller.HabilidadController;
import com.mycompany.aldeaninjakonoha.habilidad.model.HabilidadModel;
import com.mycompany.aldeaninjakonoha.mision.controller.MisionController;
import com.mycompany.aldeaninjakonoha.mision.model.MisionModel;
import com.mycompany.aldeaninjakonoha.ninja.controller.NinjaController;
import com.mycompany.aldeaninjakonoha.ninja.model.NinjaModel;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nicos
 */
public class AldeaNinjaKonoha {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void menuPrincipal() {

        OUTER:
        while (true) {
            System.out.println("""
                                           ------------ Bienvenido al Ninja Menu ------------
                                                                       Escoja su opcion:
                                           1. Ninja
                                           2. Misiones
                                           3. Habilidades
                                           4. Salir
                                           """);
            System.out.print("Option: ");
            try {
                int option = SCANNER.nextInt();
                SCANNER.nextLine();
                switch (option) {
                    case 4:
                        System.out.println("\nSaliendo.");
                        break OUTER;
                    case 1:
                        menuNinja();
                        break;
                    case 2:
                        menuMision();
                        break;
                    case 3:
                        habilidades();
                        break;
                    default:
                        throw new Exception("\nError: La opcion no es valida");
                }
            } catch (InputMismatchException e) {
                SCANNER.nextLine();
                System.out.println("\nError: El caracter ingresado no es valido");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void menuNinja() {
        System.out.println("""
                ------------ Ninja Menu ------------
                
                Escoja su opcion:
                1. Registrar Ninja
                2. Listar Ninjas
                3. Despedir Ninjas                   
                4. Salir
                """);
        System.out.print("Option: ");
        try {
            int option = SCANNER.nextInt();
            SCANNER.nextLine();

            switch (option) {
                case 4:
                    System.out.println("\nSaliendo.");
                    break;
                case 1:
                    System.out.println("Ingrese el nombre del Ninja ");
                    String nombre = SCANNER.nextLine();

                    System.out.println("Ingrese el rango del Ninja ");
                    String rango = SCANNER.nextLine();

                    System.out.println("Ingrese la aldea del Ninja ");
                    String aldea = SCANNER.nextLine();

                    NinjaModel nuevoNinja = new NinjaModel(nombre, rango, aldea);
                    NinjaController controladorNinja = new NinjaController();
                    controladorNinja.save(nuevoNinja);

                    break;

                case 2:
                    List<NinjaModel> listaNinjas = new ArrayList();

                    NinjaController verNinjas = new NinjaController();
                    listaNinjas = verNinjas.getAll();
                    int cont = 0;
                    for (NinjaModel listaNinja : listaNinjas) {
                        cont += 1;
                        System.out.println(cont + ".  Nombre: " + listaNinja.getNombre() + " Rango: " + listaNinja.getRango() + " Aldea: " + listaNinja.getAldea());
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el id del Ninja que desea eliminar");
                    int ninjaId = SCANNER.nextInt();

                    NinjaController eliminarNinja = new NinjaController();
                    eliminarNinja.delete(ninjaId);
                    break;
                default:
                    throw new Exception("\nError: La opcion no es valida para el menú.");
            }
        } catch (InputMismatchException e) {
            SCANNER.nextLine();
            System.out.println("\nError: El caracter no es valido .");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuMision() {
        System.out.println("""
                ------------ Mision Menu ------------
                
                Escoja su opcion:
                1. Registrar Mision
                2. Listar Misiones Completadas
                3. Listar Misiones disponibles para ninjas
                4. Listar todas las Misiones  
                5. Marcar Mision como completada
                6. Salir
                """);
        System.out.print("Option: ");
        try {
            int option = SCANNER.nextInt();
            SCANNER.nextLine();

            switch (option) {
                case 6:
                    System.out.println("\nSaliendo.");
                    break;
                case 1:
                    System.out.println("Ingrese el nombre de la Mision ");
                    String nombre = SCANNER.nextLine();

                    System.out.println("Ingrese la descripcion de la Mision ");
                    String descripcion = SCANNER.nextLine();

                    System.out.println("Ingrese el rango de la Mision ");
                    String rango = SCANNER.nextLine();

                    System.out.println("Ingrese la recompensa de la Mision");
                    String recompensa = SCANNER.nextLine();

                    MisionModel misionNueva = new MisionModel(0, nombre, descripcion, rango, recompensa, false);
                    MisionController controladorMision = new MisionController();
                    controladorMision.save(misionNueva);

                    break;

                case 2:
                    List<MisionModel> listaMision = new ArrayList();

                    MisionController verMisionesCompletadas = new MisionController();
                    listaMision = verMisionesCompletadas.obtenerMisionesCompletadas();
                    int cont = 0;
                    for (MisionModel listaMisiones : listaMision) {
                        cont += 1;
                        System.out.println(cont + ".  -Nombre: " + listaMisiones.getNombre()
                                + " -Rango: " + listaMisiones.getRango() + " -Descripcion: "
                                + listaMisiones.getDescripcion() + " -Completada: " + listaMisiones.isFinalizacion());
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el id del Ninja que desea eliminar");
                    int ninjaId = SCANNER.nextInt();

                    NinjaController eliminarNinja = new NinjaController();
                    eliminarNinja.delete(ninjaId);
                    break;
                case 4:
                    List<MisionModel> listaMisiontodas = new ArrayList();

                    MisionController verTodasMisiones = new MisionController();
                    listaMisiontodas = verTodasMisiones.getAll();
                    cont = 0;
                    for (MisionModel todasMisiones : listaMisiontodas) {
                        cont += 1;
                        System.out.println(cont + ".  -Nombre: " + todasMisiones.getNombre()
                                + " -Rango: " + todasMisiones.getRango() + " -Descripcion: "
                                + todasMisiones.getDescripcion() + " -Completada: " + todasMisiones.isFinalizacion());
                    }
                    break;
                case 5:
                    MisionModel actualizarestado = new MisionModel();
                    
                    MisionController actualizarMision = new MisionController();
                    
                    System.out.println("Ingrese el id de la mision que desea completar");
                    int misionId = SCANNER.nextInt();
                    actualizarestado = actualizarMision.getById(misionId);
                    actualizarestado.setFinalizacion(true);
                    actualizarMision.update(actualizarestado);
                    
                    break;
                default:
                    throw new Exception("\nError: La opcion no es valida para el menú.");
            }
        } catch (InputMismatchException e) {
            SCANNER.nextLine();
            System.out.println("\nError: El caracter no es valido .");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

     public static void habilidades() {
        System.out.println("""
                ------------ Habilidad Menu ------------
                
                Escoja su opcion:
                1. Registrar Habilidad
                2. Eliminar Habilidad          
                3. Salir
                """);
        System.out.print("Option: ");
        try {
            int option = SCANNER.nextInt();
            SCANNER.nextLine();

            switch (option) {
                case 3:
                    System.out.println("\nSaliendo.");
                    break;
                case 1:
                    System.out.println("Ingrese el id del Ninja ");
                    int idNinja = SCANNER.nextInt();

                    System.out.println("Ingrese el nombre de la habilidad ");
                    String nombreHabilidad = SCANNER.nextLine();

                    System.out.println("Ingrese la descripcion de la habilidad ");
                    String descripcion = SCANNER.nextLine();

                    HabilidadModel habilidadNueva = new HabilidadModel(idNinja, nombreHabilidad, descripcion);
                    HabilidadController controlarHabilidad = new HabilidadController() ;
                    
                    controlarHabilidad.save(habilidadNueva);

                    break;

                case 2:
                    break;
                default:
                    throw new Exception("\nError: La opcion no es valida para el menú.");
            }
        } catch (InputMismatchException e) {
            SCANNER.nextLine();
            System.out.println("\nError: El caracter no es valido .");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    
    public static void main(String[] args) {
        menuPrincipal();
    }
}
