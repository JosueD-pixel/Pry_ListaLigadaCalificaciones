/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacalificaciones;

/**
 * Lista ligada que guarda las calificaciones SIEMPRE ordenadas de menor a mayor
 * @author angel
 */
public class listaLigada {
    private nodo cabeza;   // primer nodo de la lista (la calificacion mas baja)
    private int tamanio;   // cantidad de estudiantes que ya entregaron
    
   
    public listaLigada(){
        tamanio = 0;
        cabeza = null; 
    }
    
    public boolean estaVacia()
    {
        return cabeza == null; 
    }
    
    public int getTamanio(){
        return tamanio;
    }

    public void insertarAlInicio(int dato)
    {
        nodo nuevo = new nodo(dato, cabeza);
        cabeza = nuevo;
        tamanio++;
    }
    
    //Ver la lista siempre ordenada: cada calificacion entra en su lugar
    public void insertarOrdenado(int dato)
    {
        // Caso A
        if (estaVacia())
        {
            insertarAlInicio(dato);
            return;
        }
        // Caso B
        if (dato <= cabeza.getDato())
        {
            insertarAlInicio(dato);
            return;
        }
        // Caso C y D
        nodo nuevo = new nodo(dato);
        nodo actual = cabeza;
        while (actual.getSiguiente() != null && actual.getSiguiente().getDato() < dato)
        {
            actual = actual.getSiguiente();
        }
        nuevo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevo);
        tamanio++;
    }
    
    //Consultar la calificacion en cualquier posicion
    public nodo obtenerNodo(int pos){
        if(pos <= 0 || pos > tamanio){
            return null; 
        }
        nodo aux = cabeza; 
        for(int i = 1; i < pos; i++)
        {
            aux = aux.getSiguiente();
        }
        return aux; 
    }
    
    public int obtenerCalificacion(int pos)
    {
        nodo referencia = obtenerNodo(pos);
        if(referencia == null)
        {
            throw new IllegalStateException("Posicion NO valida " + pos + ", rango valido entre 1 hasta " + tamanio);
        }
        return referencia.getDato();
    }
    
    //la minima siempre es la cabeza
    public int obtenerMinima()
    {
        return obtenerCalificacion(1);
    }
    
    //la maxima siempre es la ultima
    public int obtenerMaxima()
    {
        return obtenerCalificacion(tamanio);
    }
    
    public double obtenerMediana()
    {
        if(estaVacia())
        {
            throw new IllegalStateException("la lista esta vacia");
        }
        if(tamanio % 2 != 0)
        {
            return obtenerCalificacion((tamanio + 1) / 2);
        }
        int a = obtenerCalificacion(tamanio / 2);
        int b = obtenerCalificacion(tamanio / 2 + 1);
        return (a + b) / 2.0;
    }
    
    //Eliminar calificaciones 
    public boolean eliminarPorValor(int x)
    {
        if(estaVacia())
        {
            return false;
        }
        //Caso 1: es la cabeza
        if(cabeza.getDato() == x)
        {
            cabeza = cabeza.getSiguiente(); 
            tamanio--;
            return true; 
        }
        //Caso 2: esta en medio o al final
        nodo aux = cabeza; 
        while(aux.getSiguiente() != null)
        {
            if(aux.getSiguiente().getDato() == x)
            {
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                tamanio--;
                return true; 
            }
            aux = aux.getSiguiente();
        }
        return false;
    }
    
    public boolean corregir(int incorrecta, int correcta)
    {
        if(!eliminarPorValor(incorrecta))
        {
            return false; 
        }
        insertarOrdenado(correcta);
        return true;
    }
    
    //Saber si alguien saco una calificacion especifica
    public boolean buscar(int dato){
        nodo aux = cabeza; 
        while(aux != null) // recorre hasta el ultimo nodo
        {
            if(aux.getDato() == dato)
            {
                return true; 
            }
            if(aux.getDato() > dato)
            {
                return false;
            }
            aux = aux.getSiguiente();
        }
        return false; 
    }
    
    @Override  
    public String toString(){
        String res = "";
        nodo aux = cabeza;
        while (aux != null)
        {
            res = res + "[" + aux.getDato() + "] -> ";
            aux = aux.getSiguiente();
        }
        res = res + "NULL";
        return res;
    }
}
