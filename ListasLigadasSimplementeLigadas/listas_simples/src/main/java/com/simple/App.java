package com.simple;

import java.util.Scanner;

/**
 * Listas Simplemente Ligadas!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Scanner scan = new Scanner(System.in);
        ListaLSimple l1 = new ListaLSimple();
        ListaLSimple l2 = new ListaLSimple();
        ListaLSimple l3 = new ListaLSimple();
        ListaLSimple auxl = l1;
        String auxprint = "";
        boolean salir = false;

        int opcion, oplist;
        while (!salir) {
            System.out.println("Menú:");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Eliminar elemento");
            System.out.println("3. Mostrar los elementos en la lista");
            System.out.println("4. Invertir una lista");
            System.out.println("5. Mezclar dos listas");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = scan.nextInt();
            if (opcion != 0 && opcion != 5) {
                // System.out.println("\nEstado de las listas");
                // auxprint = (l1.estaVacia()) ? " ":l1.imprimirElementos();
                // System.out.println("L1)" + auxprint);
                // auxprint = (l2.estaVacia()) ? " ":l2.imprimirElementos();
                // System.out.println("L2)" + auxprint);
                // System.out.println("\n");
                System.out.println("Seleccione una lista para realizar la accion: \n1) L1\n2) L2");
                oplist = scan.nextInt();
                auxl = (oplist == 1) ? l1:l2;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Menú de insercion:");
                    System.out.println("1. Al inicio de la lista");
                    System.out.println("2. Al final de la lista");
                    System.out.println("3. A la derecha del elemento con información X");
                    System.out.println("4. A la izquierda del elemento con información X");
                    System.out.println("5. En la i-esima posición");
                    System.out.println("6. De forma ordenada ascendentemente");
                    System.out.print("Elija una opción: ");
                    opcion = scan.nextInt();
                    System.out.println("Ingrese el dato a insertar");

                    switch (opcion) {
                        case 1:
                            auxl.insertarInicio(scan.nextInt());
                            break;
                        case 2:
                            auxl.insertarFinal(scan.nextInt());
                            break;
                        case 3:
                            if (!auxl.estaVacia()) {
                                opcion = scan.nextInt();  // Reutilizamos la variable opcion 
                                System.out.println("Dame el dato x:");
                                auxl.insertarDerX(opcion, scan.nextInt());
                            } else {
                                System.out.println("No es posible buscar X si la lista esta vacia");
                            }
                            break;
                        case 4:
                            if (!auxl.estaVacia()) {
                                opcion = scan.nextInt();  // Reutilizamos la variable opcion 
                                System.out.println("Dame el dato x:");
                                auxl.insertarIzqX(opcion, scan.nextInt());
                            } else {
                                System.out.println("No es posible buscar X si la lista esta vacia");
                            }
                            break;
                        case 5:
                            if (!auxl.estaVacia()) {
                                opcion = scan.nextInt();  // Reutilizamos la variable opcion 
                                System.out.println("Dame la posicion i:");
                                auxl.insertarIPos(opcion, scan.nextInt());
                            } else {
                                System.out.println("No es posible ubicar el dato en la i-esima posicion si la lista esta vacia");
                            }
                            break;
                        case 6:
                            if (!auxl.estaVacia()) {
                                auxl.ascendente(scan.nextInt()); 
                            } else {
                                auxl.insertarInicio(scan.nextInt());
                            }
                            break;
                        default:
                        System.out.println("Opcion no valida");
                            break;
                    }
                    break;
                case 2:
                    if (!auxl.estaVacia()) {
                        System.out.println("Menú de eliminacion:");
                        System.out.println("1. Al inicio de la lista");
                        System.out.println("2. Al final de la lista");
                        System.out.println("3. A la derecha del elemento con información X");
                        System.out.println("4. A la izquierda del elemento con información X");
                        System.out.println("5. En la i-esima posición");
                        System.out.println("6. Con informacion X");
                        System.out.println("7. Todos los elementos con informacion X");
                        System.out.print("Elija una opción: ");
                        opcion = scan.nextInt();

                        switch (opcion) {
                            case 1:
                                auxl.eliminarInicio();
                                break;
                            case 2:
                                auxl.eliminarFinal();
                                break;
                            case 3:
                                System.out.println("Dame el dato x:");
                                if(!auxl.eliminarDerX(scan.nextInt())){
                                    System.out.println("X es el ultimo elemento de la lista, no es posible eliminar a su derecha");
                                }
                                break;
                            case 4:
                                System.out.println("Dame el dato x:");
                                if(!auxl.eliminarIzqX(scan.nextInt())){
                                    System.out.println("X es el primer elemento de la lista, no es posible eliminar a su izquierda");
                                }
                                break;
                            case 5:
                                System.out.println("Dame la posicion i:");
                                auxl.eliminarIPos(scan.nextInt());
                                break;
                            case 6:
                                System.out.println("Dame el dato x:");
                                auxl.eliminarX(scan.nextInt());
                                break;
                            case 7:
                                System.out.println("Dame el dato x:");
                                auxl.eliminarTodoX(scan.nextInt());
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                break;
                        }
                    } else {
                        System.out.println("No se puede eliminar ya que la lista esta vacia");
                    }
                    break;
                case 3:
                    if (!auxl.estaVacia()) {
                        System.out.println("Elementos: " + auxl.imprimirElementos());
                    } else {
                        System.out.println("No existen elementos en la lista");
                    }
                    break;
                case 4:
                    if (!auxl.estaVacia()) {
                        auxl.invertirLista();
                        System.out.println("Lista invertida: " + auxl.imprimirElementos());
                    } else {
                        System.out.println("No se puede invertir la lista porque esta vacia.");
                    }
                    break;
                case 5:
                if(l1==null && l2==null)
                System.out.println("Las listas estan vacias");
                else
                {
                    if(l1==null)
                        System.out.println("La lista 1 esta vacia");
                    else
                        if(l2==null)
                            System.out.println("La lista 2 esta vacia");
                        else 
                        {
                            l3.BorrarLista();
                            l3.Mezclar(l1, l2);
                            System.out.println("El contenido de la lista 1 es: " + l1.imprimirElementos());
                            System.out.println("El contenido de la lista 2 es: " + l2.imprimirElementos());
                            System.out.println("Los elementos mezclados en orden son: " + l3.imprimirElementos());
                        }
                    }
                        break;
                case 0:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        } 
        scan.close();
    }
}

