package Bean;

import Estructuras.NodoLibro;

/**
 *
 * @author gerso
 */
public class Libro {

    private int ISBN;
    private String titulo;
    private String autor;
    private String año;
    private String edicion;
    private String categoria;
    private String idioma;
    private int carnet;
    private NodoLibro izquierda;
    private NodoLibro derecha;
    private boolean recorrido;
    public Libro(int ISBN, String titulo, String autor, String año, String edicion, String categoria, String idioma, int carnet) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.edicion = edicion;
        this.categoria = categoria;
        this.idioma = idioma;
        this.carnet = carnet;
    }
    
    
    public Libro(int ISBN){
        this.ISBN = ISBN;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getEdicion() {
        return edicion;
    }

    public NodoLibro getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoLibro izquierda) {
        this.izquierda = izquierda;
    }

    public NodoLibro getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoLibro derecha) {
        this.derecha = derecha;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public boolean isRecorrido() {
        return recorrido;
    }

    public void setRecorrido(boolean recorrido) {
        this.recorrido = recorrido;
    }

}
