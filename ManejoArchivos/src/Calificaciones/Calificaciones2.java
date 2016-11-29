/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calificaciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author SALAS
 */
public class Calificaciones2 {

    private Scanner entrada;

    // permite al usuario abrir el archivo
    public void abrirArchivo() {
        try {
            entrada = new Scanner(new File("Calificaciones.txt"));
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrirArchivo// fin del método abrirArchivo

    public void leer_informacion() {

        try // lee registros del archivo, usando el objeto Scanner
        {
            double lista_suma = 0;
            double promedio_t = 0;
            double nota_mayor = 0;
            String datos = "";
            String cali = "";
            int c = 0;
            double promedio[] = new double[4];

            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
             
                ArrayList<String> linea_partes = new ArrayList<String>(Arrays.asList(linea.split(";")));

                for (int i = 2; i < (linea_partes.size() -1); i++) {
                    c = 0;
                    promedio[c] = 0 ; 
                    datos = linea_partes.get(0);
                    promedio[c] = (promedio[c] + Double.parseDouble(linea_partes.get(i)) + Double.parseDouble(linea_partes.get(i + 1)))/ 2;
                    lista_suma = lista_suma + promedio[c];
                    System.out.println("----------ESTUDIANTE----------");
                    System.out.printf("Nombre: %s\nSu Promedio es: %.2f\n", datos, promedio[c]);

                    if (promedio[c] > nota_mayor) {
                        nota_mayor = promedio[c];
                    }
                    c++; 
                } 
            }
            promedio_t = lista_suma / 4;
            System.out.println("------------------------------------");
            System.out.printf("El promedio Total de los estuadiantes es: %.2f\n", promedio_t);
            System.out.printf("La Nota Mayor es: %.2f\n", nota_mayor);

        } catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del metodo leerRegistros
// cierra el archivo y termina la aplicación

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } // fin del metodo cerrarArchivo
} // fin de la clase LeerArchivoTexto

