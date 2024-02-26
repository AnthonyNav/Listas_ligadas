package com.simple;

public class Nodo {
    private int dato;
    private Nodo next;

    public Nodo(int dato) {
        this.dato = dato;
        next = null;
    }
    public Nodo getNext() {
        return next;
    }
    public void setNext(Nodo next) {
        this.next = next;
    }
    public int getDato() {
        return dato;
    }
}
