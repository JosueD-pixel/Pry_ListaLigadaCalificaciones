/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacalificaciones;

/**
 * Nodo de la lista: guarda una calificacion y la referencia al siguiente
 * @author angel
 */
public class nodo {
    //atributos
    private int dato;          // calificacion
    private nodo siguiente;    // siguiente nodo de la lista
    
    //constructores
    public nodo (int x){
        dato = x;
        siguiente = null; 
    }
    
    public nodo(int x, nodo sig)
    {
        dato = x;
        siguiente = sig;
    }
    //set
    public void setDato(int x)
    {
        dato = x; //asigna
    }
    //get
    public int getDato(){
        return dato; //retorna
    }
    public void setSiguiente(nodo sig)
    {
        siguiente = sig;
    }
    public nodo getSiguiente(){
        return siguiente; 
    }
}
