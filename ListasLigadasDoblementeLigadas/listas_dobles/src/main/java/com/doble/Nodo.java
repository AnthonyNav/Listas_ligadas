package com.doble;

public class Nodo {
    int dato;
    Nodo next;
    Nodo prev;

    public Nodo(int dato) {
        this.dato = dato;
        next = null;
        prev = null;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public Nodo getPrev() {
        return prev;
    }

    public void setPrev(Nodo prev) {
        this.prev = prev;
    }

    public int getDato() {
        return dato;
    }
    

    
}
