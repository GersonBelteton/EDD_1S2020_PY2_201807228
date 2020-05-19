package Estructuras;

import Bean.*;
import java.io.FileWriter;
import java.io.IOException;
import Controladores.ContCategoria;

/**
 *
 * @author gerso
 */
public class ArbolB {

    ContCategoria cg = new ContCategoria();
    NodoLibro raiz;
    Libro libroSube;
    boolean subirNodo = false;

    public ArbolB() {
        raiz = null;
        libroSube = null;
    }

    public boolean isEmpty() {
        return raiz == null;

    }

    public NodoLibro getRaiz() {
        return raiz;
    }

    public Libro buscarLibro(int isbn) {
        NodoLibro aux = raiz;
        while (aux != null) {

            for (int i = 0; i < aux.getLibros().length; i++) {
                if (aux.getLibros()[i].getISBN() == isbn) {
                    return aux.getLibros()[i];
                } else if (aux.getLibros()[i].getISBN() > isbn) {
                    aux = aux.getLibros()[i].getIzquierda();
                    break;
                } else if (aux.getUltimo().getISBN() < isbn) {
                    aux = aux.getUltimo().getDerecha();
                    break;
                }
            }
        }

        return null;

    }

    boolean rotacion = false;
    Libro[] lib = new Libro[300];

    public void eliminar(int isbn, NodoLibro nl) {
        if (nl != null) {
            for (int i = 0; i < nl.getLibros().length; i++) {
                if (nl.getLibros()[i] != null) {
                    if (nl.getLibros()[i].getISBN() == isbn) {
                        nl.getLibros()[i] = null;
                        nl.actualizarNodo();
                        if (nl.menosDelMinimo()) {
                            rotacion = true;
                            System.out.println("tiene menos de dos elementos");

                        }
                        break;
                    } else if (nl.getLibros()[i].getISBN() > isbn) {
                        eliminar(isbn, nl.getLibros()[i].getIzquierda());
                        if (rotacion) {
                            if (i - 1 >= 0) {
                                if (nl.getLibros()[i - 1].getIzquierda().numeroDeLibros() > 2) {
                                    Libro temp = nl.clonarLibro(nl.getLibros()[i - 1]);
                                    temp.setIzquierda(null);
                                    temp.setDerecha(null);
                                    nl.getLibros()[i].getIzquierda().insertarLibro(temp);
                                    nl.remplazarLibro(nl.getLibros()[i - 1], nl.getLibros()[i - 1].getIzquierda().getUltimo());
                                    nl.getLibros()[i - 1].getIzquierda().setUltimo(null);
                                } else {
                                    if (i + 1 <= 4 && nl.getLibros()[i + 1] != null) {
                                        if (nl.getLibros()[i].getDerecha().numeroDeLibros() > 2) {
                                            Libro temp = nl.clonarLibro(nl.getLibros()[i]);
                                            temp.setIzquierda(null);
                                            temp.setDerecha(null);
                                            nl.getLibros()[i].getDerecha().insertarLibro(temp);
                                            nl.remplazarLibro(nl.getLibros()[i], nl.getLibros()[i].getDerecha().getPrimero());
                                            nl.getLibros()[i].getDerecha().setPrimero(null);
                                        } else {
                                            //fucionar cualquiera
                                        }
                                    }
                                }
                            } else if (i + 1 <= 4 && nl.getLibros()[i + 1] != null) {

                                if (nl.getLibros()[i].getDerecha().numeroDeLibros() > 2) {
                                    Libro temp = nl.clonarLibro(nl.getLibros()[i]);
                                    temp.setIzquierda(null);
                                    temp.setDerecha(null);
                                    nl.getLibros()[i].getDerecha().insertarLibro(temp);
                                    nl.remplazarLibro(nl.getLibros()[i], nl.getLibros()[i].getDerecha().getPrimero());
                                    nl.getLibros()[i].getDerecha().setPrimero(null);
                                } else {
                                    //fucionar der
                                }

                            }

                            rotacion = false;
                        }
                    } else if (nl.getUltimo().getISBN() < isbn) {
                        eliminar(isbn, nl.getUltimo().getDerecha());
                    }
                }

            }
        }
    }

    public void eliminar2(int isbn) {
        for (int i = 0; i < lib.length; i++) {
            if (lib[i] != null) {
                if (lib[i].getISBN() == isbn) {
                    lib[i] = null;
                    break;
                }
            }

        }

        raiz = null;

        for (int i = 0; i < lib.length; i++) {
            if (lib[i] != null) {
                insertar(lib[i], raiz);
            }

        }
    }
    
    
    
        public void eliminarPorNombre(String nombre) {
        for (int i = 0; i < lib.length; i++) {
            if (lib[i] != null) {
                if (lib[i].getTitulo().equals(nombre)) {
                    lib[i] = null;
                    break;
                }
            }

        }

        raiz = null;

        for (int i = 0; i < lib.length; i++) {
            if (lib[i] != null) {
                insertar(lib[i], raiz);
            }

        }
    }
    
    
    

    public void crearLibro(int ISBN, String titulo, String autor, String año, String edicion, String categoria, String idioma, int carnet) {
        Libro l = new Libro(ISBN, titulo, autor, año, edicion, categoria, idioma, carnet);

        insertar(l, raiz);
        for (int i = 0; i < lib.length; i++) {
            if (lib[i] == null) {
                lib[i] = l;
                break;
            }
        }

    }

    /*public NodoLibro insertar(Libro l, NodoLibro nl) {

        if (isEmpty()) {
            nl = new NodoLibro();
            nl.insertarLibro(l);
            raiz = nl;
        } else {

            //System.out.println("Es hoja");
            if (nl.nodoLleno()) {
                nl.insertarLibro(l);
                NodoLibro nuevo1 = new NodoLibro();
                NodoLibro nuevo2 = new NodoLibro();

                nuevo1.insertarLibro(nl.getLibros()[0]);
                nuevo1.insertarLibro(nl.getLibros()[1]);
                nuevo2.insertarLibro(nl.getLibros()[3]);
                nuevo2.insertarLibro(nl.getLibros()[4]);
                libroSube = nl.clonarLibro(nl.getLibros()[2]);
                //libroSube = nl.getLibros()[2];
                libroSube.setIzquierda(nuevo1);
                libroSube.setDerecha(nuevo2);

                subirNodo = true;

                if (nl == raiz && subirNodo) {
                    NodoLibro root = new NodoLibro();
                    root.insertarLibro(libroSube);
                    raiz = root;
                    subirNodo = false;
                }

            } else {
                if (nl.esHoja()) {
                    nl.insertarLibro(l);
                } else {
                    //   System.out.println("no es hoja");
                    if (nl.getUltimo().getISBN() < l.getISBN()) {
                        nl.getUltimo().setDerecha(insertar(l, nl.getUltimo().getDerecha()));
                        if (subirNodo) {
                            nl.getUltimo().setDerecha(libroSube.getIzquierda());
                            nl.insertarLibro(libroSube);

                            nl.igualarReferencias();
                            subirNodo = false;
                        }
                    } else {
                        System.out.println("si entra");
                        for (int i = 0; i < nl.getLibros().length; i++) {
                            if (nl.getLibros()[i].getISBN() > l.getISBN()) {
                                nl.getLibros()[i].setIzquierda(insertar(l, nl.getLibros()[i].getIzquierda()));
                                if (subirNodo) {
                                    // System.out.println("subir nodo");

                                    nl.getLibros()[i].setIzquierda(libroSube.getDerecha());
                                    nl.insertarLibro(libroSube);
                                    nl.igualarReferencias();

                                    subirNodo = false;

                                    if (nl.nodoLleno()) {
                                        nl.insertarLibro(l);
                                        NodoLibro nuevo1 = new NodoLibro();
                                        NodoLibro nuevo2 = new NodoLibro();

                                        nuevo1.insertarLibro(nl.getLibros()[0]);
                                        nuevo1.insertarLibro(nl.getLibros()[1]);
                                        nuevo2.insertarLibro(nl.getLibros()[3]);
                                        nuevo2.insertarLibro(nl.getLibros()[4]);
                                        libroSube = nl.clonarLibro(nl.getLibros()[2]);
                                        //libroSube = nl.getLibros()[2];
                                        libroSube.setIzquierda(nuevo1);
                                        libroSube.setDerecha(nuevo2);

                                        subirNodo = true;
                                    }
                                }
                                break;
                            }
                        }
                    }

                }

            }

        }
        return nl;
    }*/
    public NodoLibro insertar(Libro l, NodoLibro nl) {

        if (isEmpty()) {
            nl = new NodoLibro();
            nl.insertarLibro(l);
            raiz = nl;
        } else {
            if (nl.esHoja()) {
                //System.out.println("Es hoja");
                if (nl.nodoLleno()) {
                    nl.insertarLibro(l);
                    NodoLibro nuevo1 = new NodoLibro();
                    NodoLibro nuevo2 = new NodoLibro();

                    nuevo1.insertarLibro(nl.getLibros()[0]);
                    nuevo1.insertarLibro(nl.getLibros()[1]);
                    nuevo2.insertarLibro(nl.getLibros()[3]);
                    nuevo2.insertarLibro(nl.getLibros()[4]);
                    libroSube = nl.clonarLibro(nl.getLibros()[2]);
                    //libroSube = nl.getLibros()[2];
                    libroSube.setIzquierda(nuevo1);
                    libroSube.setDerecha(nuevo2);

                    subirNodo = true;

                    if (nl == raiz && subirNodo) {
                        NodoLibro root = new NodoLibro();
                        root.insertarLibro(libroSube);
                        raiz = root;
                        subirNodo = false;
                    }

                } else {
                    nl.insertarLibro(l);
                }
            } else {
                //   System.out.println("no es hoja");
                if (nl.getUltimo().getISBN() < l.getISBN()) {
                    nl.getUltimo().setDerecha(insertar(l, nl.getUltimo().getDerecha()));
                    if (subirNodo) {
                        if (!nl.nodoLleno()) {
                            nl.getUltimo().setDerecha(libroSube.getIzquierda());
                            nl.insertarLibro(libroSube);

                            nl.igualarReferencias();
                            subirNodo = false;
                        } else {
                            nl.getUltimo().setDerecha(libroSube.getIzquierda());
                            nl.insertarLibro(libroSube);

                            nl.igualarReferencias();
                            subirNodo = false;

                            NodoLibro nuevo1 = new NodoLibro();
                            NodoLibro nuevo2 = new NodoLibro();

                            nuevo1.insertarLibro(nl.getLibros()[0]);
                            nuevo1.insertarLibro(nl.getLibros()[1]);
                            nuevo2.insertarLibro(nl.getLibros()[3]);
                            nuevo2.insertarLibro(nl.getLibros()[4]);
                            libroSube = nl.clonarLibro(nl.getLibros()[2]);
                            //libroSube = nl.getLibros()[2];
                            libroSube.setIzquierda(nuevo1);
                            libroSube.setDerecha(nuevo2);

                            subirNodo = true;
                            if (nl == raiz && subirNodo) {
                                NodoLibro root = new NodoLibro();
                                root.insertarLibro(libroSube);
                                raiz = root;
                                subirNodo = false;
                            }

                        }

                    }
                } else {
                    System.out.println("si entra");
                    for (int i = 0; i < nl.getLibros().length; i++) {
                        if (nl.getLibros()[i].getISBN() > l.getISBN()) {
                            nl.getLibros()[i].setIzquierda(insertar(l, nl.getLibros()[i].getIzquierda()));
                            if (subirNodo) {
                                // System.out.println("subir nodo");
                                if (!nl.nodoLleno()) {
                                    nl.getLibros()[i].setIzquierda(libroSube.getDerecha());
                                    nl.insertarLibro(libroSube);
                                    nl.igualarReferencias();

                                    subirNodo = false;
                                } else {
                                    nl.getLibros()[i].setIzquierda(libroSube.getDerecha());
                                    nl.insertarLibro(libroSube);
                                    nl.igualarReferencias();

                                    subirNodo = false;

                                    NodoLibro nuevo1 = new NodoLibro();
                                    NodoLibro nuevo2 = new NodoLibro();

                                    nuevo1.insertarLibro(nl.getLibros()[0]);
                                    nuevo1.insertarLibro(nl.getLibros()[1]);
                                    nuevo2.insertarLibro(nl.getLibros()[3]);
                                    nuevo2.insertarLibro(nl.getLibros()[4]);
                                    libroSube = nl.clonarLibro(nl.getLibros()[2]);
                                    //libroSube = nl.getLibros()[2];
                                    libroSube.setIzquierda(nuevo1);
                                    libroSube.setDerecha(nuevo2);

                                    subirNodo = true;
                                    if (nl == raiz && subirNodo) {
                                        NodoLibro root = new NodoLibro();
                                        root.insertarLibro(libroSube);
                                        raiz = root;
                                        subirNodo = false;
                                    }
                                }

                            }
                            break;
                        }
                    }
                }

            }
        }
        return nl;
    }

    public void recorrerArbolPorNivel(NodoLibro nl) {
        if (nl != null) {

            for (int i = 0; i < nl.getLibros().length; i++) {

                if (nl.getLibros()[i].getIzquierda() == null || !nl.getLibros()[i].getIzquierda().isReccorrido()) {
                    System.out.println(nl.getLibros()[i].getTitulo());

                    if (i == nl.getLibros().length - 1) {

                        if (nl.getLibros()[nl.getLibros().length - 1].getDerecha() != null || nl.getLibros()[nl.getLibros().length - 1].getDerecha().isReccorrido()) {
                            recorrerArbolPorNivel(nl.getLibros()[nl.getLibros().length - 1].getDerecha());
                        }
                        nl.setReccorrido(true);
                    }

                } else {
                    recorrerArbolPorNivel(nl.getLibros()[i].getIzquierda());
                }
            }

        }
    }

    public void mostrarArbol(NodoLibro nl) {
        if (nl != null) {
            System.out.println();
            for (int i = 0; i < nl.getLibros().length; i++) {
                if (nl.getLibros()[i] != null) {
                    System.out.println(nl.getLibros()[i].getISBN());
                    mostrarArbol(nl.getLibros()[i].getIzquierda());

                } else {
                    mostrarArbol(nl.getLibros()[i - 1].getDerecha());
                    break;
                }

            }

            // System.out.println(nl.getLibros()[nl.getLibros().length-1].getISBN() + " " + nl.getLibros()[nl.getLibros().length-1].getTitulo());
        }

    }

    public String codigoGraficaB(NodoLibro nl, String grafo) {
        if (nl != null) {
            grafo += "nodoNL" + nl.getPrimero().getISBN() + "[label = \"NL\"];\n";
            for (int i = 0; i < nl.getLibros().length; i++) {
                if (nl.getLibros()[i] != null) {
                    grafo += "nodoL" + nl.getLibros()[i].getISBN() + "[label = \"" + nl.getLibros()[i].getISBN()+"\n"+nl.getLibros()[i].getTitulo() + "\"];\n";
                    grafo += "nodoNL" + nl.getPrimero().getISBN() + "->nodoL" + nl.getLibros()[i].getISBN() + ";\n";
                    if (nl.getLibros()[i].getIzquierda() != null) {
                        grafo += "nodoNL" + nl.getLibros()[i].getIzquierda().getPrimero().getISBN() + "[label = \"NL\"];\n";
                        grafo += "nodoL" + nl.getLibros()[i].getISBN() + "->nodoNL" + nl.getLibros()[i].getIzquierda().getPrimero().getISBN() + ";\n";
                    }
                    if (nl.getLibros()[i].getDerecha() != null) {
                        grafo += "nodoNL" + nl.getLibros()[i].getDerecha().getPrimero().getISBN() + "[label = \"NL\"];\n";
                        grafo += "nodoL" + nl.getLibros()[i].getISBN() + "->nodoNL" + nl.getLibros()[i].getDerecha().getPrimero().getISBN() + ";\n";
                    }
                    grafo = codigoGraficaB(nl.getLibros()[i].getIzquierda(), grafo);

                } else {
 
                    grafo = codigoGraficaB(nl.getLibros()[i-1].getDerecha(), grafo);
                    break;
                }
            }
        }
        return grafo;
    }

    /*string ArbolJugador::reporteArbol2(NodoJugador* n, string grafo, int contador) {

	if (n != NULL) {
		cout << n->getNombre() << endl;	



		grafo = grafo + "nodo" + n->getNombre() + "[label = \" " + n->getNombre() + "\"];\n";

		if (n->getIzquierda() != NULL) {
			grafo = grafo + "nodo" + n->getIzquierda()->getNombre() + "[label = \" " + n->getIzquierda()->getNombre() + "\"];\n";
			grafo = grafo + "nodo" + n->getNombre() + "->nodo" + n->getIzquierda()->getNombre() + ";\n";
		}
		if (n->getDerecha() != NULL) {
			grafo = grafo + "nodo" + n->getDerecha()->getNombre() + "[label = \" " + n->getDerecha()->getNombre() + "\"];\n";
			grafo = grafo + "nodo" + n->getNombre() + "->nodo" + n->getDerecha()->getNombre() + ";\n";
		}



		grafo = reporteArbol2(n->getIzquierda(), grafo, contador);
		grafo = reporteArbol2(n->getDerecha(), grafo, contador);
	}

	return grafo;
}*/
}
