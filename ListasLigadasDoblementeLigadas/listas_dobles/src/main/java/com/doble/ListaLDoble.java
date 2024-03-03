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
        if (estaVacia()) { // Si esta vacia
            this.inicio = n; // Apuntamos al nuevo nodo
        } else { // Sino ligamos y referenciamos al nuevo nodo
            n.setNext(this.inicio); 
            this.inicio.setPrev(n); 
            this.inicio = n;
        }
    }

    public void insertarFinal(int dato){
        Nodo n = new Nodo(dato);
        if (this.estaVacia()) { // Si esta vacia
            this.inicio = n; // Solo se referencia a n
        } else { // Sino se recorre hasta el ultimo nodo
            Nodo auxNodo = this.inicio;
            while (auxNodo.getNext() != null) {
                auxNodo = auxNodo.getNext();
            }
            auxNodo.setNext(n); // Se inserta al final
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
        while (auxNodo.getNext()!=null) { // Recorre la lista
            if (counter == i) { // Sale si encuentra la posicion
                break;
            }
            counter++;
            auxNodo = auxNodo.getNext();
        }
        if (counter == i) {
            if (i == 1) { // Si i es la posicion inicial
                this.insertarInicio(dato);
            } else { // Sino se hacen los intercambios
                Nodo n = new Nodo(dato);
                n.setNext(auxNodo);
                if (auxNodo.getPrev() != null) { // Si no es el ultimo nodo
                    auxNodo.getPrev().setNext(n); // Ligamos el nodo anterior a n
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
        while (auxNodo.getNext() != null) { // Recorrer
            auxNodo = auxNodo.getNext();
        }
        if (auxNodo == this.inicio) { // Caso inicio
            this.eliminarInicio();
        } else { // Caso normal
            auxNodo.getPrev().setNext(null); // desligar
        }
    }

    public boolean eliminarDerX(int x){
        Nodo auxNodo = this.inicio;
        Nodo auxNodo2;
        while (auxNodo.getNext() != null) { // Recorre
            if (auxNodo.getDato() == x) {
                break; // Sale si encuentra a X
            }
            auxNodo = auxNodo.getNext();   
        }
        if (auxNodo.getDato() == x) { // En este caso se ubico a x y se inserto el dato
            
            if (auxNodo.getNext() != null) { // Si X no es el ultimo nodo
                auxNodo2 = auxNodo.getNext();
                if (auxNodo2.getNext() != null) {
                    auxNodo2.getNext().setPrev(auxNodo);
                    auxNodo.setNext(auxNodo2.getNext());
                } else { // Si es el ultimo nodo
                    this.eliminarFinal();
                }
                return true;
            }
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

    // public void invertirLista() {
    //     ListaLDoble listaInvertida = new ListaLDoble();
    //     while (!this.estaVacia()) {
    //         Nodo nodoEliminado = this.getInicio();
    //         while (nodoEliminado.getNext() != null) {
    //             nodoEliminado = nodoEliminado.getNext();
    //         }
    //         if (nodoEliminado == this.getInicio()) {
    //             this.setInicio(null);
    //         } else {
    //             nodoEliminado.getPrev().setNext(null);
    //         }
    //         listaInvertida.insertarInicio(nodoEliminado.getDato()); // Inserta el nodo al inicio de la lista invertida
    //     }
    //     // Actualiza la lista original con la lista invertida
    //     this.setInicio(listaInvertida.getInicio());
    // }

    public void invertirLista() {
        ListaLDoble listaInvertida = new ListaLDoble();
        if (!this.estaVacia()) {
            while (!this.estaVacia()) {
                Nodo nodoEliminado = this.getInicio();
                this.inicio = this.inicio.getNext(); // Actualiza el inicio de la lista original
                if (this.inicio != null) {
                    this.inicio.setPrev(null); // Actualiza el enlace previo del nuevo inicio
                }
                nodoEliminado.setNext(null); // Desenlaza el nodo eliminado
                listaInvertida.insertarInicio(nodoEliminado.getDato()); // Inserta el nodo al inicio de la lista invertida
            }
            // Actualiza la lista original con la lista invertida
            this.setInicio(listaInvertida.getInicio());
        }
    }

    public void Mezclar(ListaLDoble Lista1, ListaLDoble Lista2)
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
        if(auxl3.getNext()==null)
        {
            auxl3.setNext(nuevoNodo);
            nuevoNodo.setPrev(auxl3);
        }
        else
        {
            nuevoNodo.setNext(auxl3.getNext());
            auxl3.getNext().setPrev(nuevoNodo);
            auxl3.setNext(nuevoNodo);
            nuevoNodo.setPrev(auxl3);
        }
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
        if(auxl3.getNext()==null)
        {
            auxl3.setNext(nuevoNodo);
            nuevoNodo.setPrev(auxl3);
        }
        else
        {
            nuevoNodo.setNext(auxl3.getNext());
            auxl3.getNext().setPrev(nuevoNodo);
            auxl3.setNext(nuevoNodo);
            nuevoNodo.setPrev(auxl3);
        }
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

    
    public boolean estaVacia(){
        return inicio==null;
    }
    
    public boolean convertir(){
        return inicio==null;
    }
}
