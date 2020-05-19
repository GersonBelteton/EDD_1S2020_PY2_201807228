/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Bean.Usuario;

/**
 *
 * @author gerso
 */
public class TablaHash {

    ListaUsuarios[] listas;

    public TablaHash() {
        listas = new ListaUsuarios[45];
    }

    
    public ListaUsuarios[] getArreglo(){
        return listas;
    }
    public void insertar(int carnet, String nombre, String apellido, String carrera, String password) {
        if (listas[funcionHash(carnet)] != null) {
            listas[funcionHash(carnet)].insertar(carnet, nombre, apellido, carrera, password);
        } else {
            listas[funcionHash(carnet)] = new ListaUsuarios();
            listas[funcionHash(carnet)].insertar(carnet, nombre, apellido, carrera, password);
        }

    }

    public Usuario buscar(int carnet) {

        if (listas[funcionHash(carnet)] != null) {
            Usuario aux = listas[funcionHash(carnet)].buscar(carnet);
            return aux;
        }
        return null;

    }

    
    public ListaUsuarios getLista(int pos){
        return listas[pos];
    }
    public void eliminar(int carnet) {
        if (listas[funcionHash(carnet)] != null) {
            listas[funcionHash(carnet)].eliminar(carnet);
        }
    }

    public int funcionHash(int carnet) {
        int posicion = 0;

        posicion = carnet % 45;

        return posicion;
    }

    public void mostrarTabla() {

        for (int i = 0; i < listas.length; i++) {
            if (listas[i] != null) {
                System.out.println("Posicion: " + i);
                listas[i].mostrarLista();
            }

        }
    }

    public String codigoGraficaTH() {
        String codigo = "digraph G { rankdir = LR;\n node [shape=box];\n";
        codigo += "nodoRaiz[label= \"Funcion Hash\"];\n";
        for (int i = 0; i < listas.length; i++) {
            if (listas[i] != null) {
                codigo += "nodoRaiz->nodo" + listas[i].primero.getCarnet() + "[label = \""+i+"\"];\n";
                codigo += listas[i].codigoGraficaLista();
            }

        }

        codigo += "}";
        
        System.out.println(codigo);
        return codigo;
    }

}
  /*grafo += "nodo" + c.getIzquierda().getNombre() + "[label = \" " + c.getIzquierda().getNombre() + "\"];\n";
                grafo += "nodo" + c.getNombre() + "->nodo" + c.getIzquierda().getNombre() + ";\n";*/
