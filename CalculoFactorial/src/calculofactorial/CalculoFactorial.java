/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculofactorial;

/**
 *
 * @author SALAS
 */
public class CalculoFactorial {
    //declaracion recursiva del metodo factorial
    public double factorial(double numero) {

        if (numero <= 1) { //evaluo el caso base
            return 1; // caso bae : 0! y 1! = 1 
        } else { // paso recusrsivo
            return numero * factorial(numero - 1);
        }
    }
    //imprime los factoriales para los valores del 0 a 10
    public void mostrarFactorial() {
        //calcula los factoriales del 0 al 10
        for (int contador = 0; contador <= 10; contador++) {
            System.out.printf("%d! = %.0f\n", contador, factorial(contador));
        }
    }
}
