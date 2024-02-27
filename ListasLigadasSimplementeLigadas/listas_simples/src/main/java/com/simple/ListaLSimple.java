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

    // public void setNextList(ListaLSimple l){
    //     NextList = l;
    // }
    // public ListaLSimple getNextList(){
    //     return NextList;
    // }

    // Metodos indicados

    // Metodos de insercion
    public void insertarInicio(int dato){

        if(this.estaVacia()){
            this.inicio = new Nodo(dato);
        } else {
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
            while (auxNodo.getNext() != null) {
                auxNodo = auxNodo.getNext();
            }
            auxNodo.setNext(new Nodo(dato));
        }
    }

    public boolean insertarDerX(int dato, int x){ // Retorna true si se inserto el dato y falso en caso contrario
        Nodo auxNodo = this.inicio;
        while (auxNodo.getNext() != null) { // nos ubicara en el nodo que contenga a x
            if (auxNodo.getDato() == x) {
                break;
            }
            auxNodo = auxNodo.getNext();   // o al ultimo nodo en caso de que x no exista
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
        Nodo auxNodo = this.inicio;
        Nodo auxNodo2 = auxNodo;
        while (auxNodo.getNext()!=null) {
            if (auxNodo.getDato() == x) {
                break;
            }
            auxNodo2 = auxNodo;
            auxNodo = auxNodo.getNext();
        }
        if (auxNodo.getDato() == x) {
            if (auxNodo == this.inicio) {
                insertarInicio(dato);
            } else {
                Nodo n = new Nodo(dato);
                n.setNext(auxNodo);
                auxNodo2.setNext(n);
            }
            
            return true;
        }
        return false;
    }

    public boolean insertarIPos(int dato, int i){ // Se cuenta desde 1 y se asume que no esta vacia
        Nodo auxNodo = this.inicio;
        Nodo auxNodo2 = auxNodo;
        int counter = 1;
        while (auxNodo.getNext() != null) {
            if (counter == i) {
                break;
            }
            counter++;
            auxNodo2 = auxNodo;
            auxNodo = auxNodo.getNext();
        }
        if (counter == i) {
            if (i == 1) {
                this.insertarInicio(dato);
            } else {
                Nodo n = new Nodo(dato);
                n.setNext(auxNodo);
                auxNodo2.setNext(n);
            }
            return true;
        }
        return false;
    }

    public void ascendente(int dato){  // La funcion supone que esta previamente ordenada la lista y que no esta vacia
        Nodo auxNodo = this.inicio;

        while (auxNodo.getNext() != null) { // Recorre hasta encontrar un valor mayor al dato proporcionado
            if (auxNodo.getDato() > dato) {
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
        Nodo auxNodo = this.inicio;
        Nodo auxNodo2 = auxNodo;
        while (auxNodo.getNext() != null) {
            auxNodo2 = auxNodo;
            auxNodo = auxNodo.getNext();
        }
        if (auxNodo == this.inicio) {
            this.eliminarInicio();
        } else {
            auxNodo2.setNext(null);
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
            } //else {
            //     auxNodo.setNext(null);
            // }
            return true;
        } 
        return false;
    }
    
    public boolean eliminarIzqX(int x){
        Nodo auxNodo = this.inicio;
        Nodo auxNodo2 = auxNodo;
        while (auxNodo.getNext()!=null) {
            if (auxNodo.getDato() == x) {
                break;
            }
            auxNodo2 = auxNodo;
            auxNodo = auxNodo.getNext();
        }
        if (auxNodo.getDato() == x && auxNodo != this.inicio) {
            Nodo auxNodo3 = this.inicio;
            if (auxNodo2 == this.inicio) {
                this.eliminarInicio();
            } else {
                while (auxNodo3.getNext()!=auxNodo2) {
                    auxNodo3 = auxNodo3.getNext();
                }
                auxNodo3.setNext(auxNodo);
            }
            return true;
        }
        return false;
    }
    
    public boolean eliminarIPos(int i){
        Nodo auxNodo = this.inicio;
        Nodo auxNodo2 = auxNodo;
        int counter = 1;
        
        while (auxNodo.getNext() != null) {
            if (counter == i) {
                break;
            }
            counter++;
            auxNodo2 = auxNodo;
            auxNodo = auxNodo.getNext();
        }
        
        if (counter == i) {
            if (i == 1) {
                this.eliminarInicio();
            } else {
                auxNodo2.setNext(auxNodo.getNext());
            }
            return true;
        }
        return false;
    }
    
    public boolean eliminarX(int x){
        Nodo auxNodo = this.inicio;
        Nodo auxNodo2 = auxNodo;  
        while (auxNodo.getNext()!=null) {
            if (auxNodo.getDato() == x) {
                break;
            }
            auxNodo2 = auxNodo;
            auxNodo = auxNodo.getNext();
        } 
        if (auxNodo.getDato() == x) {
            if (auxNodo ==  this.inicio) {
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
        while (auxNodo != null) {
            if (auxNodo.getDato() == x) {
                if (auxNodo == this.inicio) {
                    this.eliminarInicio();
                } else {
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
        while (auxNodo.getNext() != null) {
            output = output + " " + auxNodo.getDato();
            auxNodo = auxNodo.getNext();
        }
        output = output + " " + auxNodo.getDato();
        return output;
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
