/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArchivoTexto29;

import java.io.FileNotFoundException;

/**
 *
 * @author SALAS
 */
public class PruebaArchivo {
       public static void main( String args[] ) 
   {
      Archivo aplicacion = new Archivo();

      aplicacion.abrir_archivo();
      aplicacion.agregar_informacion();
      aplicacion.cerrar_archivo();
   } // fin de main
} // fin de la clase PruebaCrearArchivoTexto

