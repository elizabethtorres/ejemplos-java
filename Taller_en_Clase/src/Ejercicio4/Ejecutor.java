/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

/**
 *
 * @author SALAS
 */
public class Ejecutor {
        public static void main(String args[]) {
            
        Factura aplicacion = new Factura();

        aplicacion.abrir_archivo();
        aplicacion.agregar_informacion();
        aplicacion.cerrar_archivo();
    } // fin de main
} // fin de la clase PruebaCrearArchivoTexto


