/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Factura {

    private Formatter salida; // objeto usado para enviar texto al archivo

    // permite al usuario abrir el archivo
    public void abrir_archivo() {
        try {
            salida = new Formatter("archivo.txt");
        } // fin de try
        catch (SecurityException securityException) {
            System.err.println(
                    "No tiene acceso de escritura a este archivo.");
            System.exit(1);
        } // fin de catch
        catch (FileNotFoundException filesNotFoundException) {
            System.err.println("Error al crear el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrir_archivo

    // agrega registros al archivo
    public void agregar_informacion() {
        // el archivo permite el ingreso
        // de edad, nombre, apellido de una persona
        Scanner entrada = new Scanner(System.in);

        //Declaracion de variables
        boolean bandera2 = true;
        int num_prod = 0;
        int opc = 0;
        double valor_pro = 0;
        double sub_t = 0;
        double iva;
        double valor_total;
        String prod = "";

        try // envía valores al archivo
        {
            // obtiene los datos que se van a enviar
            System.out.println("Ingrese el Nombre del Cliente:"); //Presenta un mensaje para que ingrese el nombre
            String nombre = entrada.nextLine(); //Lee el nombre ingresado
            System.out.println("Ingrese la Ciudad:"); // Presenta un mensaje para que ingrese la ciudad
            String ciudad = entrada.next(); // lee la ciudad ingresada

            // Formato para presentar la factura
            salida.format("*********COMERCIAL DE VENTAS Y REVENTAS*******\n\nNOMBRE: %s\nCIUDAD: %s\n============================================\nPRODUCTO\t\t\tCANTIDAD\t\tPRECIO\n", nombre, ciudad);

            while (bandera2) {
                //Presentacion del menu
                System.out.println("--------------------------------------------------");
                System.out.println("\t\t\tMENU");
                System.out.println("--------------------------------------------------\n");
                System.out.println("\t1. Arroz (Costo del kilo--> $2.50)");
                System.out.println("\t2. Azucar (Costo del kilo--> $1.50)");
                System.out.println("\t3. Aceite (Costo por unidad--> $1.30)");
                System.out.println("\t4. Tallarines (Costo por unidad--> $1.50)");
                System.out.println("\t5. Sal (Costo del kilo--> $1.00)");
                
                System.out.println("\nIngrese el producto que desee:"); //Presenta un mensaje para que ingrese el producto que desea
                opc = entrada.nextInt(); //Lee la opcion del producto ingresada
                System.out.println("Ingrese la cantidad de productos:"); //Presenta un mensaje para que ingrese la cantidad de productos 
                num_prod = entrada.nextInt(); //Lee la cantidad de productos

                //Casos para cada una de las opciones
                switch (opc) {
                    case 1:
                        valor_pro = (2.5 * num_prod); //Calcula el valor del arroz
                        prod = "Arroz       ";
                        break;
                    case 2:
                        valor_pro = (1.5 * num_prod); //Calcula el valor de la azucar
                        prod = "Azucar      ";
                        break;
                    case 3:
                        valor_pro = (1.3 * num_prod); //Calcula el valor del aceite
                        prod = "Aceite      ";
                        break;
                    case 4:
                        valor_pro = (1.5 * num_prod); //Calcula el valor de los tallarines
                        prod = "Tallarines  ";
                        break;
                    case 5:
                        valor_pro = (1 * num_prod); //Calcula el valor de la sal
                        prod = "Sal         ";
                        break;
                }
                //Formato que imprime los productos, la cantidad y el valor total
                salida.format("%s\t\t\t%d\t\t%.2f\n", prod, num_prod, valor_pro); 

                sub_t = sub_t + valor_pro;//calcula el subtotal sin el iva

                System.out.println("\nDesea ingresar más productos: (1)SI  (2)NO");
                int valor = entrada.nextInt();
                if (valor == 2) {
                    bandera2 = false;
                }

            }
            iva = sub_t * 0.14; //calcula el iva
            valor_total = sub_t + iva;//calcula el valor total a pagar

            //Formato que presenta el subtotal, el iva y el valor total a pagar
            salida.format("=============================================\n\n\t\t\t\t\tSUBTOTAL: %.2f\n\t\t\t\t\t\tIVA: %.2f\n\t\t\t\t\t   "
                    + "TOTAL: %.2f\n", sub_t, iva, valor_total);

        } // fin de try
        catch (FormatterClosedException formatterClosedException) {
            System.err.println("Error al escribir en el archivo.");
            return;
        } // fin de catch
        catch (NoSuchElementException elementException) {
            System.err.println("Entrada invalida. Intente de nuevo.");
            entrada.nextLine(); // descarta la entrada para que el usuario intente de nuevo
        } // fin de catch

        // fin de while
    } // fin del método agregarRegistros

    // cierra el arrchivo
    public void cerrar_archivo() {
        if (salida != null) {
            salida.close();
        }
    } // fin del método cerrarArchivo
} // fin de la clase ArchivoTexto


