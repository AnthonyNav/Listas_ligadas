package com.doble;

public class ListaLDoble {
    private Nodo inicio;
    // constructor
    public ListaLDoble() {
        inicio = null;
    }
    // getters y setters
    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    // Metodos indicados

    // Metodos de insercion
    public void insertarInicio(int dato){
        Nodo n = new Nodo(dato);
        if (estaVacia()) {
            this.inicio = n;
        } else {
            n.setNext(this.inicio); // n->init
            this.inicio.setPrev(n); // n <-- init
            this.inicio = n;
        }
    }

    public void insertarFinal(int dato){
        Nodo n = new Nodo(dato);
        if (this.estaVacia()) {
            this.inicio = n;
        } else {
            Nodo auxNodo = this.inicio;
            while (auxNodo.getNext() != null) {
                auxNodo = auxNodo.getNext();
            }
            auxNodo.setNext(n);
            n.setPrev(auxNodo);
        }
    }

    public boolean insertarDerX(int dato ,int x){
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
            if (auxNodo.getNext() != null) {
                auxNodo.getNext().setPrev(n);
            }
            n.setPrev(auxNodo);
            auxNodo.setNext(n);
            return true;
        } 
        return false;
    }

    public boolean insertarIzqX(int dato ,int x){ // Si se inserta cuando x es la primera posicion falla
        Nodo auxNodo = this.inicio;
        while (auxNodo.getNext()!=null) {
            if (auxNodo.getDato() == x) {
                break;
            }
            auxNodo = auxNodo.getNext();
        }
        if (auxNodo.getDato() == x) {
            if (auxNodo == this.inicio) {
                insertarInicio(dato);
            } else {
                Nodo n = new Nodo(dato);
                n.setNext(auxNodo);
                if (auxNodo.getPrev() != null) {
                    auxNodo.getPrev().setNext(n);
                }
                n.setPrev(auxNodo.getPrev());
                auxNodo.setPrev(n);
            }
            
            return true;
        }
        return false;
    }

    public boolean insertarIPos(int dato ,int i){
        Nodo auxNodo = this.inicio;
        int counter = 1;
        while (auxNodo.getNext()!=null) {
            if (counter == i) {
                break;
            }
            counter++;
            auxNodo = auxNodo.getNext();
        }
        if (counter == i) {
            if (i == 1) {
                this.insertarInicio(dato);
            } else {
                Nodo n = new Nodo(dato);
                n.setNext(auxNodo);
                if (auxNodo.getPrev() != null) {
                    auxNodo.getPrev().setNext(n);
                }
                n.setPrev(auxNodo.getPrev());
                auxNodo.setPrev(n);
            }
            return true;
        }
        return false;
    }
    public void ascendente(int dato){  // La funcion supone que esta previamente ordenada la lista y que no este vacia
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
        this.inicio.setPrev(null);
    }

    public void eliminarFinal(){
        Nodo auxNodo = this.inicio;
        while (auxNodo.getNext() != null) {
            auxNodo = auxNodo.getNext();
        }
        if (auxNodo == this.inicio) {
            this.eliminarInicio();
        } else {
            auxNodo.getPrev().setNext(null); 
        }
    }

    public boolean eliminarDerX(int x){
        Nodo auxNodo = this.inicio;
        Nodo auxNodo2;
        while (auxNodo.getNext() != null) { // nos ubicara en el nodo que contenga a x
            if (auxNodo.getDato() == x) {
                break;
            }
            auxNodo = auxNodo.getNext();   // o al ultimo nodo 
        }
        if (auxNodo.getDato() == x) { // En este caso se ubico a x y se inserto el dato
            
            if (auxNodo.getNext() != null) {
                auxNodo2 = auxNodo.getNext();
                if (auxNodo2.getNext() != null) {
                    auxNodo2.getNext().setPrev(auxNodo);
                    auxNodo.setNext(auxNodo2.getNext());
                } else{
                    this.eliminarFinal();
                }
            }
            return true;
        } 
        return false;
    }

    public boolean eliminarIzqX(int x){
        Nodo auxNodo = this.inicio;
        while (auxNodo.getNext()!=null) {
            if (auxNodo.getDato() == x) {
                break;
            }
            auxNodo = auxNodo.getNext();
        }
        if (auxNodo.getDato() == x) {
            if (auxNodo.getPrev() != null) {
                Nodo auxNodo2 = auxNodo.getPrev();
                if (auxNodo2.getPrev() != null) {
                    auxNodo2.getPrev().setNext(auxNodo);
                    auxNodo.setPrev(auxNodo2.getPrev());
                } else {
                    this.eliminarInicio();
                }
            }
            return true;
        }
        return false;
    }

    public boolean eliminarIPos(int i){
        Nodo auxNodo = this.inicio;
        int counter = 1;
        while (auxNodo.getNext()!=null) {
            if (counter == i) {
                break;
            }
            counter++;
            auxNodo = auxNodo.getNext();
        }
        if (counter == i) {
            if (i == 1) {
                eliminarInicio();
            } else {
                if (auxNodo.getNext() != null) {
                    auxNodo.getPrev().setNext(auxNodo.getNext());
                    auxNodo.getNext().setPrev(auxNodo.getPrev());
                } else {
                    this.eliminarFinal();
                }
            } return true;
        }
        return false;
    }

    public boolean eliminarX(int x){
        Nodo auxNodo = this.inicio; 
        while (auxNodo.getNext()!=null) {
            if (auxNodo.getDato() == x) {
                break;
            }
            auxNodo = auxNodo.getNext();
        } 
        if (auxNodo.getDato() == x) {
            if (auxNodo ==  this.inicio) {
                this.eliminarInicio();
            } else {
                if (auxNodo.getNext() != null) {
                    auxNodo.getPrev().setNext(auxNodo.getNext());
                    auxNodo.getNext().setPrev(auxNodo.getPrev());
                } else {
                    this.eliminarFinal();
                }
            } return true;
        }
        return false;
    }
    public void eliminarTodoX(int x){
        Nodo auxNodo = this.inicio; 
        while (auxNodo != null) {
            if (auxNodo.getDato() == x) {
                if (auxNodo == this.inicio) {
                    this.eliminarInicio();
                } else {
                    if (auxNodo.getNext() != null) {
                        auxNodo.getPrev().setNext(auxNodo.getNext());
                        auxNodo.getNext().setPrev(auxNodo.getPrev());
                    } else {
                        this.eliminarFinal();
                    }
                }
            }
            auxNodo = auxNodo.getNext();
        }
    }

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
    
     
    public boolean estaVacia(){
        return inicio==null;
    }
}
