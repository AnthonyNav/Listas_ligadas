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
    public void insertarInicio(Nodo n){
        
    }

    public void insertarFinal(Nodo n){

    }

    public boolean insertarDerX(Nodo n ,int x){
        return true;
    }

    public boolean insertarIzqX(int x){
        return true;
    }

    public boolean insertIPos(int i){
        return true;
    }

    public void ascendente(int x){  // La funcion supone que esta previamente ordenada la lista

    }

    // Metodos de eliminacion (Asumen que la lista no esta vacia)

    public void eliminarInicio(){
        
    }

    public void eliminarFinal(){
        
    }

    public boolean eliminarDerX(int x){
        return true;
    }

    public boolean eliminarIzqX(int x){
        return true;
    }

    public boolean eliminarIPos(int i){
        return true;
    }

    public void elmininarX(int x){

    }
    public void eliminarTodoX(int x){
        
    }

    public boolean estaVacia(){
        return inicio==null;
    }
}
