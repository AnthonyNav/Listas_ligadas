package com.simple;

public class ListaLSimple {
    private Nodo inicio;
    // private ListaLSimple NextList;

    // constructor
    public ListaLSimple() {
        inicio = null;
        // NextList = null;
    }
    // getters y setters
    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    // Metodos de insercion
    public void insertarInicio(int dato){

        if(this.estaVacia()){ // Si esta vacia, entonces solo hace referencia al nuevo nodo
            this.inicio = new Nodo(dato);
        } else {           // Si existen elemento, los desplaza y apunta al nuevo
            Nodo n = new Nodo(dato);
            n.setNext(this.inicio);
            this.inicio = n;
        }
    }

    public void insertarFinal(int dato){
        if (this.estaVacia()) {
            this.inicio = new Nodo(dato);
        } else {
            Nodo auxNodo = this.inicio;
            while (auxNodo.getNext() != null) { // Recorre la lista
                auxNodo = auxNodo.getNext();
            }
            auxNodo.setNext(new Nodo(dato)); // Inserta la referencia al nuevo nodo
        }
    }

    public boolean insertarDerX(int dato, int x){ 
        Nodo auxNodo = this.inicio;
        while (auxNodo.getNext() != null) { // nos ubicara en el nodo que contenga a x
            if (auxNodo.getDato() == x) {
                break;
            }
            auxNodo = auxNodo.getNext();   // o al ultimo nodo 
        }
        if (auxNodo.getDato() == x) { // En este caso se ubico a x y se inserto el dato
            Nodo n = new Nodo(dato);
            n.setNext(auxNodo.getNext());
            auxNodo.setNext(n);
            return true;
        } 
        return false;
    }

    public boolean insertarIzqX(int dato,int x){
        Nodo auxNodo = this.inicio; // Para encontrar x
        Nodo auxNodo2 = auxNodo; // nodo que esta antes de x
        while (auxNodo.getNext()!=null) { // Recorre la lista 
            if (auxNodo.getDato() == x) { // hasta maximo el ultimo nodo
                break; // Sale del ciclo si encuenta el dato
            }
            auxNodo2 = auxNodo;
            auxNodo = auxNodo.getNext();
        }
        if (auxNodo.getDato() == x) { // Se verifica si se encontro x
            if (auxNodo == this.inicio) { // si x es el primer nodo
                insertarInicio(dato); // insertamos al inicio
            } else {  // Sino solo 
                Nodo n = new Nodo(dato);
                n.setNext(auxNodo); // enlazamos usando el nodo x
                auxNodo2.setNext(n); // y nuestro nodo auxiliar
            }
            return true;
        }
        return false;
    }

    public boolean insertarIPos(int dato, int i){ 
        Nodo auxNodo = this.inicio; // Nodo indicador
        Nodo auxNodo2 = auxNodo; // Nodo auxiliar
        int counter = 1;
        while (auxNodo.getNext() != null) { // Recorre la lista
            if (counter == i) { // Cuenta las iteraciones
                break;          // para encontar a i
            }
            counter++;
            auxNodo2 = auxNodo;
            auxNodo = auxNodo.getNext();
        }
        if (counter == i) {
            if (i == 1) { // Caso de nodo inicio
                this.insertarInicio(dato);
            } else { // Demás casos
                Nodo n = new Nodo(dato);
                n.setNext(auxNodo);
                auxNodo2.setNext(n);
            }
            return true;
        }
        return false;
    }
// La funcion supone que esta previamente ordenada la lista y que no esta vacia
    public void ascendente(int dato){  
        Nodo auxNodo = this.inicio;

        while (auxNodo.getNext() != null) { // Recorre hasta encontrar 
            if (auxNodo.getDato() > dato) { // un valor mayor al dato proporcionado
                break;
            }
            auxNodo = auxNodo.getNext();
        }
        if (auxNodo.getDato() > dato) { // Si se encuentra, el dato se inserta antes de ese valor
            this.insertarIzqX(dato, auxNodo.getDato());
        } else {
            this.insertarFinal(dato);
        }
    }

    // Metodos de eliminacion (Asumen que la lista no esta vacia)
    
    public void eliminarInicio(){
        this.inicio = this.inicio.getNext();
    }
    
    public void eliminarFinal(){
        Nodo auxNodo = this.inicio; // sera el ultimo nodo
        Nodo auxNodo2 = auxNodo; // sera el penultimo nodo
        while (auxNodo.getNext() != null) { // Recorre la lista
            auxNodo2 = auxNodo;
            auxNodo = auxNodo.getNext();
        }
        if (auxNodo == this.inicio) { // caso solo 1 elemento
            this.eliminarInicio();
        } else {
            auxNodo2.setNext(null); // desligamos
        }
    }
    
    public boolean eliminarDerX(int x){
        Nodo auxNodo = this.inicio;
        while (auxNodo.getNext() != null) { // nos ubicara en el nodo que contenga a x
            if (auxNodo.getDato() == x) {
                break;
            }
            auxNodo = auxNodo.getNext();   // o al ultimo nodo en caso de que x no exista
        }
        if (auxNodo.getDato() == x) { // En este caso se ubico a x y se inserto el dato
            
            if (auxNodo.getNext() != null) {
                auxNodo.setNext(auxNodo.getNext().getNext());
            } 
            return true;
        } 
        return false;
    }
    
    public boolean eliminarIzqX(int x){
        Nodo auxNodo = this.inicio;
        Nodo auxNodo2 = auxNodo;
        while (auxNodo.getNext()!=null) { // Recorre la lista
            if (auxNodo.getDato() == x) {
                break; // Sale si ubica a x
            }
            auxNodo2 = auxNodo;
            auxNodo = auxNodo.getNext();
        }
        if (auxNodo.getDato() == x && auxNodo != this.inicio) {
            Nodo auxNodo3 = this.inicio; // Utilizamos otro auxiliar
            if (auxNodo2 == this.inicio) { // Si x es el primer nodo
                this.eliminarInicio();
            } else { // el tercer nodo auxiliar recorre la lista
                while (auxNodo3.getNext()!=auxNodo2) {
                    auxNodo3 = auxNodo3.getNext();
                }
                auxNodo3.setNext(auxNodo); // redirecciona la referencia
            }
            return true;
        }
        return false;
    }
    
    public boolean eliminarIPos(int i){
        Nodo auxNodo = this.inicio; // Ubica la posicion
        Nodo auxNodo2 = auxNodo; // desliga a auxnodo
        int counter = 1;
        
        while (auxNodo.getNext() != null) { // Recorre
            if (counter == i) {
                break; // Sale si ubica la posicion
            }
            counter++;
            auxNodo2 = auxNodo;
            auxNodo = auxNodo.getNext();
        }
        
        if (counter == i) {
            if (i == 1) { // Si i es el primer elemento
                this.eliminarInicio();
            } else { // Sino redefine la referencia
                auxNodo2.setNext(auxNodo.getNext());
            }
            return true;
        }
        return false;
    }
    
    public boolean eliminarX(int x){
        Nodo auxNodo = this.inicio; // Ubica a X
        Nodo auxNodo2 = auxNodo;  // Nodo auxiliar
        while (auxNodo.getNext()!=null) {
            if (auxNodo.getDato() == x) {
                break; // Sale si encuentra a X
            }
            auxNodo2 = auxNodo;
            auxNodo = auxNodo.getNext();
        } 
        if (auxNodo.getDato() == x) {
            if (auxNodo ==  this.inicio) { // Si X es el nodo de inicio
                this.eliminarInicio();
            } else {
                auxNodo2.setNext(auxNodo.getNext());
            }
        }
        return false;
    }
    public void eliminarTodoX(int x){
        Nodo auxNodo = this.inicio;
        Nodo auxNodo2 = auxNodo;  
        while (auxNodo != null) { // Recorre la lista
            if (auxNodo.getDato() == x) { // Detecta a X
                if (auxNodo == this.inicio) {
                    this.eliminarInicio(); // Cuando X es el primer nodo
                } else { // Sino redefine la referencia para al siguiente elemento de x
                    auxNodo2.setNext(auxNodo.getNext());
                }
            }
            auxNodo2 = auxNodo;
            auxNodo = auxNodo.getNext();
        }
    }

    // Metodos indicados
    public String imprimirElementos(){ // Asume que no esta vacia la lista
        String output = "";
        Nodo auxNodo = this.inicio;
        while (auxNodo.getNext() != null) { // Recorre la lista
            output = output + " " + auxNodo.getDato(); // concatena
            auxNodo = auxNodo.getNext();
        }
        output = output + " " + auxNodo.getDato(); // concatena el ultimo nodo
        return output; // Retorna nuestra cadena que representa los elementos existentes
    }
    
    public void invertirLista() {
        ListaLSimple listaInvertida = new ListaLSimple();
    
        while (!this.estaVacia()) {
            int dato = this.getInicio().getDato(); // Obtenemos el dato del primer nodo de la lista original
            listaInvertida.insertarInicio(dato); // Insertamos el dato al inicio de la lista invertida
            this.eliminarInicio(); // Eliminamos el primer nodo de la lista original
        }
        // Una vez que se ha invertido completamente la lista, copiamos la lista invertida a la lista original
        this.setInicio(listaInvertida.getInicio());
    }

    public void Mezclar(ListaLSimple Lista1, ListaLSimple Lista2)
    { 
        Nodo nodoAuxL = Lista1.getInicio(); // Obtener el inicio de la lista 1
        Nodo nodoAuxl3 = new Nodo(-1); // Nodo ficticio para la lista mezclada
        Nodo auxl3 = nodoAuxl3; // Nodo auxiliar de la lista mezclada

        // Copiar nodos de Lista1 a la lista mezclada
        while (nodoAuxL != null) {
        // Encontrar la posición correcta para insertar el nuevo nodo
        while (auxl3.getNext() != null && auxl3.getNext().getDato() <= nodoAuxL.getDato())
        {
        auxl3 = auxl3.getNext();
        }
        // Insertar el nuevo nodo después de auxl3
        Nodo nuevoNodo = new Nodo(nodoAuxL.getDato());
        nuevoNodo.setNext(auxl3.getNext());
        auxl3.setNext(nuevoNodo);
        // Mover al siguiente nodo en Lista1
        nodoAuxL = nodoAuxL.getNext();
        // Reiniciar auxl3 al inicio de la lista mezclada
        auxl3 = nodoAuxl3;
        }

        // Copiar nodos de Lista2 a la lista mezclada
        nodoAuxL = Lista2.getInicio();
        auxl3 = nodoAuxl3; // Reiniciar auxl3 al inicio de la lista mezclada
        while (nodoAuxL != null) 
        {
        // Encontrar la posición correcta para insertar el nuevo nodo
        while (auxl3.getNext() != null && auxl3.getNext().getDato() <= nodoAuxL.getDato()) 
        {
        auxl3 = auxl3.getNext();
        }
        // Insertar el nuevo nodo después de auxl3
        Nodo nuevoNodo = new Nodo(nodoAuxL.getDato());
        nuevoNodo.setNext(auxl3.getNext());
        auxl3.setNext(nuevoNodo);
        // Mover al siguiente nodo en Lista2
        nodoAuxL = nodoAuxL.getNext();
        // Reiniciar auxl3 al inicio de la lista mezclada
        auxl3 = nodoAuxl3;
        }

        // Establecer el inicio de la lista mezclada
        this.setInicio(nodoAuxl3.getNext()); // nodoAuxl3 es un nodo ficticio, por lo que su siguiente es el inicio real de la lista mezclada
        System.out.println("Listas mezcladas de forma ordenada");
    }
    public void BorrarLista(){
        this.inicio=null;
    }

    // Metodos extras (Ayudan a la construccion de los demas metodos)

    public Nodo getUltimo(){  // Supone que la lista no esta vacia
        Nodo auxNodo = this.inicio;
        while (auxNodo.getNext() != null) { // Si esta vacia, lanzará una excepcion
            auxNodo = auxNodo.getNext();
        }
        return auxNodo;
    }




    public boolean estaVacia(){
        return inicio==null;
    }
    
}
