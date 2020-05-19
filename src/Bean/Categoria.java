/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import Estructuras.ArbolB;
/**
 *
 * @author gerso
 */
public class Categoria {
    
    String nombre;
    ArbolB libros;
    Categoria izquierda;
    Categoria derecha;
    Categoria padre;
    int feq, alturaIzq, alturaDer;
    public Categoria(String nombre, ArbolB libros) {
        this.nombre = nombre;
        this.libros = libros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArbolB getLibros() {
        return libros;
    }

    public void setLibros(ArbolB libros) {
        this.libros = libros;
    }

    public Categoria getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Categoria izquierda) {
        this.izquierda = izquierda;
    }

    public Categoria getDerecha() {
        return derecha;
    }

    public void setDerecha(Categoria derecha) {
        this.derecha = derecha;
    }

    public int getFeq() {
        return feq;
    }

    public void setFeq(int feq) {
        this.feq = feq;
    }

    public int getAlturaIzq() {
        return alturaIzq;
    }

    public void setAlturaIzq(int alturaIzq) {
        this.alturaIzq = alturaIzq;
    }

    public int getAlturaDer() {
        return alturaDer;
    }

    public void setAlturaDer(int alturaDer) {
        this.alturaDer = alturaDer;
    }

    public Categoria getPadre() {
        return padre;
    }

    public void setPadre(Categoria padre) {
        this.padre = padre;
    }

    
    
    
    
    
    
}
