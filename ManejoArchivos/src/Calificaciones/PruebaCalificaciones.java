/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calificaciones;

/**
 *
 * @author SALAS
 */
public class PruebaCalificaciones {
    
       public static void main( String args[] )
   {
      Calificaciones2 aplicacion = new Calificaciones2();

      aplicacion.abrirArchivo();
      aplicacion.leer_informacion();
      aplicacion.cerrarArchivo();
   } // fin de main
} // fin de la clase PruebaLeerArchivoTexto

