package Estructuras;

import Bean.Libro;

/**
 *
 * @author gerso
 */
public class NodoLibro {

    Libro[] libros;
    boolean reccorrido;

    public NodoLibro() {
        libros = new Libro[5];
    }

    public Libro[] getLibros() {
        return libros;
    }

    public void setLibros(Libro[] l) {
        this.libros = l;
    }

    public void insertarLibro(Libro l) {
       for(int i = 0; i < libros.length; i++){
           if(libros[i] == null){
               libros [i] = l;
               break;
           }
       }
       ordenarNodo();

    }
    
    public void igualarReferencias(){
        for(int i = 0; i < libros.length-1; i++){
            if(libros[i+1] != null){
                libros[i+1].setIzquierda(libros[i].getDerecha());
            }
            
        }
    }
    
    public boolean nodoLleno(){
        return libros[libros.length-2] != null;
    }
    
    public boolean menosDelMinimo(){
        return libros[1] == null;
    }
    
    
    
    public void actualizarNodo(){
        //este metodo ordena el nodo de menor a mayor quitando los null de en medio
        NodoLibro nl2 = new NodoLibro();
        for(int i = 0; i<libros.length; i++){
            if(libros[i] != null){
                nl2.insertarLibro(clonarLibro(libros[i]));
                libros[i] = null;
            }
        }
        for(int i = 0; i < libros.length; i++){
            insertarLibro(nl2.getLibros()[i]);
        }
        
    }
    
    
    public int numeroDeLibros(){
        int num = 0;
        for(int i = 0; i < libros.length; i++){
            if(libros[i] != null){
                num++;
            }
        }
        
        return num;
    }
    public void ordenarNodo() {
        for (int i = 0; i < libros.length-1; i++) {
            for (int j = 0; j < libros.length-i-1; j++) {

                if (libros[j+1] != null && libros[j] != null) {
                    if (libros[j].getISBN() > libros[j+1].getISBN()) {
                        Libro aux = clonarLibro(libros[j]);
                        libros[j] = clonarLibro(libros[j+1]);
                        libros[j+1] = clonarLibro(aux);
                        
                        
                        /*Libro aux = libros[j];
                        libros[j] = libros[i];
                        libros[i] = aux;*/
                    }
                }

            }
        }
    }
    
    
    public boolean esHoja(){
        return libros[0].getIzquierda() == null ;
    
    }
    
    public Libro getUltimo(){
        for(int i = 0; i < libros.length; i++){
            if(libros[i] == null){
                return libros[i-1];
            }
        }
        return libros[libros.length-2];
    }
    
    public Libro getPrimero(){
        return libros[0];
    }
    
    public void setPrimero(Libro l){
        libros[0] = l;
    }
    public void setUltimo(Libro l){
        for(int i = 1; i < libros.length; i++){
            if(libros[i] == null){
                libros[i-1] = l;
            }
        }
    }
    
    public void remplazarLibro(Libro l1, Libro l2){
        l1.setAutor(l2.getAutor());
        l1.setAño(l2.getAño());
        l1.setCarnet(l2.getCarnet());
        l1.setCategoria(l2.getCategoria());
        l1.setEdicion(l2.getEdicion());
        l1.setISBN(l2.getISBN());
        l1.setIdioma(l2.getIdioma());
        l1.setTitulo(l2.getTitulo());
    }
    public Libro clonarLibro(Libro l1){
        String autor = l1.getAutor();
        String año = l1.getAño();
        String categoria = l1.getCategoria();
        String edicion = l1.getEdicion();
        String titulo = l1.getTitulo();
        String idioma = l1.getIdioma();
        int isbn = l1.getISBN();
        int carnet = l1.getCarnet();
    
        
        Libro l2  = new Libro(isbn, titulo, autor, año, edicion, categoria, idioma, carnet);
        l2.setIzquierda(l1.getIzquierda());
        l2.setDerecha(l1.getDerecha());
        
        
        return l2;
    }

    public boolean isReccorrido() {
        return reccorrido;
    }

    public void setReccorrido(boolean reccorrido) {
        this.reccorrido = reccorrido;
    }

}
