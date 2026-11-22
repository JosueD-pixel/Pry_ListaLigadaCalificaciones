/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemacalificaciones;

/**
 * Caso de uso: Sistema de Calificaciones en Tiempo Real
 * @author angel
 */
public class SistemaCalificaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        listaLigada lista = new listaLigada();
        int[] llegadas = {78, 92, 65, 85, 40, 100, 85, 0, 71};

        // 1. Ver la lista de calificaciones ordenada 
        System.out.println("Lista inicial: " + lista);
        for (int c : llegadas) {
            lista.insertarOrdenado(c);
            System.out.println("Llega " + c + " -> " + lista
                    + "   (tamanio = " + lista.getTamanio() + ")");
        }

        // 2. consultar 
        System.out.println("\n consultar por posicion:");
        System.out.println("posicion 3 -> " + lista.obtenerCalificacion(3));
        System.out.println("minima: " + lista.obtenerMinima());
        System.out.println("maxima:" + lista.obtenerMaxima());
        System.out.println("mediana:" + lista.obtenerMediana());

        // 3. cambiar
        System.out.println("\n corregir calificacion erronea:");
        lista.corregir(40, 80);
        System.out.println("Corregir 40 por 80 -> " + lista
                + "   (tamanio = " + lista.getTamanio() + ")");

        // 4. eliminar calificaciones invalidas
        System.out.println("\n eliminar calificacion invalida:");
        lista.eliminarPorValor(0);
        System.out.println("eliminar 0 -> " + lista
                + "   (tamanio = " + lista.getTamanio() + ")");

        // 5. saber si alguien saco una calificacion especifica
        System.out.println("\n buscar calificacion:");
        System.out.println("alguien saco 100? " + (lista.buscar(100) ? "Si" : "No"));
        System.out.println("alguien saco 50?  " + (lista.buscar(50) ? "Si" : "No"));

        // 6. Ver el total
        System.out.println("\n total de estudiantes que entregaron: " + lista.getTamanio());
        System.out.println("mediana actualizada: " + lista.obtenerMediana());
    }
    
}
