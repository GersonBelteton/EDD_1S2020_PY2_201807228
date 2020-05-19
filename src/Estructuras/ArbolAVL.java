package Estructuras;

import Bean.Categoria;

/**
 *
 * @author gerso
 */
public class ArbolAVL {

    Categoria raiz;

    public ArbolAVL() {
        raiz = null;
    }

    public Categoria getRaiz() {
        return raiz;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    public Categoria buscar(String nombre) {
        if (isEmpty()) {
            System.out.println("AVL vacio");
        } else {
            Categoria aux = raiz;
            while (aux != null) {
                if (aux.getNombre().equals(nombre)) {
                    return aux;
                } else {
                    if (isMayor(aux.getNombre(), nombre) == 1) {
                        aux = aux.getIzquierda();
                    } else if (isMayor(aux.getNombre(), nombre) == -1) {
                        aux = aux.getDerecha();
                    }
                }
            }
        }
        return null;
    }

    public void preOrden(Categoria aux) {
        if (aux != null) {
            System.out.println(aux.getNombre());
            preOrden(aux.getIzquierda());
            preOrden(aux.getDerecha());
        }

    }

    public void crearCategoria(String nombre, ArbolB libros) {
        Categoria nuevo = new Categoria(nombre, libros);
        insertar(nuevo, raiz);
        calcularAltura(raiz);
        equilibrar(raiz);
    }

    public void eliminar(String nombre, Categoria aux) {
        if (aux != null) {
            if (isMayor(aux.getNombre(), nombre) == 1) {
                auxPadre = aux;
                eliminar(nombre, aux.getIzquierda());
            } else if (isMayor(aux.getNombre(), nombre) == -1) {
                auxPadre = aux;
                eliminar(nombre, aux.getDerecha());
            } else {
                if (aux.getIzquierda() == null && aux.getDerecha() == null) {
                    if (auxPadre.getIzquierda() == aux) {
                        auxPadre.setIzquierda(null);
                    } else {
                        auxPadre.setDerecha(null);
                    }
                } else {
                    if ((aux.getIzquierda() == null && aux.getDerecha() != null) || (aux.getIzquierda() != null && aux.getDerecha() == null)) {
                        if (aux.getIzquierda() == null && aux.getDerecha() != null) {
                            auxHijo = aux.getDerecha();
                            if (auxPadre.getIzquierda() == aux) {
                                auxPadre.setIzquierda(auxHijo);
                                auxHijo.setPadre(auxPadre);
                            } else {
                                auxPadre.setDerecha(auxHijo);
                                auxHijo.setPadre(auxPadre);
                            }
                        } else {
                            auxHijo = aux.getIzquierda();
                            if (auxPadre.getIzquierda() == aux) {
                                auxPadre.setIzquierda(auxHijo);
                                auxHijo.setPadre(auxPadre);
                            } else {
                                auxPadre.setDerecha(auxHijo);
                                auxHijo.setPadre(auxPadre);
                            }
                        }
                    } else {
                        if (aux.getIzquierda() != null && aux.getDerecha() != null) {
                            temporal = aux.getIzquierda();
                            if (temporal.getIzquierda() == null && temporal.getDerecha() == null) {
                                aux.setNombre(temporal.getNombre());
                                aux.setLibros(temporal.getLibros());
                                aux.setIzquierda(null);
                            } else {
                                temporal = aux.getDerecha();
                                if (temporal.getIzquierda() == null && temporal.getDerecha() == null) {
                                    aux.setNombre(temporal.getNombre());
                                    aux.setLibros(temporal.getLibros());
                                    aux.setDerecha(null);
                                } else {
                                    temporal = aux.getIzquierda();
                                    if (temporal.getDerecha() == null) {
                                        aux.setNombre(temporal.getNombre());
                                        aux.setLibros(temporal.getLibros());
                                        aux.setIzquierda(temporal.getIzquierda());
                                        auxHijo = temporal.getIzquierda();
                                        auxHijo.setPadre(null);
                                    } else {
                                        temporal = aux.getDerecha();
                                        if (temporal.getIzquierda() == null) {
                                            aux.setNombre(temporal.getNombre());
                                            aux.setLibros(temporal.getLibros());
                                            aux.setDerecha(temporal.getDerecha());
                                            auxHijo = temporal.getDerecha();
                                            auxHijo.setPadre(aux);
                                        } else {
                                            temporal = aux.getIzquierda();
                                            auxHijo = temporal;
                                            while (auxHijo.getDerecha() != null) {
                                                temporal = auxHijo;
                                                auxHijo = auxHijo.getDerecha();
                                            }
                                            aux.setNombre(auxHijo.getNombre());
                                            aux.setLibros(auxHijo.getLibros());
                                            temporal.setDerecha(auxHijo.getIzquierda());
                                            nieto = auxHijo.getIzquierda();
                                            nieto.setPadre(temporal);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void insertar(Categoria nuevo, Categoria aux) {

        if (isEmpty()) {
            raiz = nuevo;
            raiz.setPadre(null);
        } else {
            if (isMayor(nuevo.getNombre(), aux.getNombre()) == 1) {
                System.out.println("ismayor 1");
                if (aux.getDerecha() != null) {

                    insertar(nuevo, aux.getDerecha());
                } else {
                    aux.setDerecha(nuevo);
                    nuevo.setPadre(aux);
                    return;
                }
            } else if (isMayor(nuevo.getNombre(), aux.getNombre()) == -1) {
                System.out.println("ismayor -1");
                if (aux.getIzquierda() != null) {

                    insertar(nuevo, aux.getIzquierda());
                } else {
                    aux.setIzquierda(nuevo);
                    nuevo.setPadre(aux);
                    return;
                }
            }
        }
    }

    public int calcularAltura(Categoria aux) {
        if (aux == null) {
            return 0;
        } else {
            aux.setAlturaIzq(calcularAltura(aux.getIzquierda()));
            aux.setAlturaDer(calcularAltura(aux.getDerecha()));
            aux.setFeq(aux.getAlturaDer() - aux.getAlturaIzq());

            if (aux.getAlturaIzq() > aux.getAlturaDer()) {
                return aux.getAlturaIzq() + 1;
            } else {
                return aux.getAlturaDer() + 1;
            }

        }
    }

    Categoria auxPadre, auxHijo;

    public void equilibrar(Categoria aux) {

        if (aux != null) {
            equilibrar(aux.getIzquierda());
            equilibrar(aux.getDerecha());

            if (aux.getFeq() == 2 || aux.getFeq() == -2) {
                System.out.println("equilibrar");
                auxPadre = aux;
                auxHijo = auxPadre.getDerecha();
                if (auxPadre.getFeq() == 2 && auxHijo.getFeq() == 1) {

                    rotacionDD();
                    calcularAltura(raiz);
                    return;
                } else if (auxPadre.getFeq() == 2 && auxHijo.getFeq() == -1) {

                    rotacionDI();
                    calcularAltura(raiz);
                    return;
                } else {
                    auxPadre = aux;
                    auxHijo = auxPadre.getIzquierda();
                    if (auxPadre.getFeq() == -2 && auxHijo.getFeq() == 1) {

                        rotacionID();
                        calcularAltura(raiz);
                        return;
                    } else if (auxPadre.getFeq() == -2 && auxHijo.getFeq() == -1) {

                        rotacionII();
                        calcularAltura(raiz);
                        return;
                    }

                }

            }
        }
    }

    Categoria nieto;
    Categoria abuelo;
    Categoria temporal;

    public void rotacionDI() {
        if (raiz == auxPadre) {
            nieto = auxHijo.getIzquierda();
            raiz = nieto;
            nieto.setPadre(null);
            nieto.setDerecha(auxHijo);
            auxHijo.setPadre(nieto);
            if (auxHijo.getIzquierda() != null) {
                auxHijo.setIzquierda(nieto.getIzquierda());
            } else {
                auxHijo.setIzquierda(null);
            }
            nieto.setIzquierda(auxPadre);
            auxPadre.setDerecha(null);
            auxPadre.setPadre(nieto);

        } else {
            abuelo = auxPadre.getPadre();
            nieto = auxHijo.getIzquierda();
            nieto.setPadre(abuelo);
            nieto.setDerecha(auxHijo);
            auxHijo.setPadre(nieto);
            if (auxHijo.getIzquierda() != null) {
                auxHijo.setIzquierda(nieto.getIzquierda());

            } else {
                auxHijo.setIzquierda(null);
            }

            nieto.setIzquierda(auxPadre);
            auxPadre.setDerecha(null);
            auxPadre.setPadre(nieto);
            if (abuelo.getIzquierda() == auxPadre) {
                abuelo.setIzquierda(nieto);
            } else if (abuelo.getDerecha() == auxPadre) {
                abuelo.setDerecha(nieto);
            }
        }
    }

    public void rotacionID() {
        if (raiz == auxPadre) {
            nieto = auxHijo.getDerecha();
            raiz = nieto;
            nieto.setPadre(null);
            auxHijo.setDerecha(nieto.getIzquierda());
            nieto.setIzquierda(auxHijo);
            auxHijo.setPadre(nieto);

            auxPadre.setIzquierda(null);
            nieto.setDerecha(auxPadre);
            if (auxPadre.getDerecha() == null) {
                auxPadre.setDerecha(null);
            }

            auxPadre.setPadre(nieto);

        } else {
            abuelo = auxPadre.getPadre();
            nieto = auxHijo.getDerecha();
            nieto.setPadre(abuelo);
            nieto.setIzquierda(auxHijo);
            auxHijo.setPadre(nieto);
            if (auxHijo.getDerecha() != null) {
                auxHijo.setDerecha(nieto.getDerecha());

            } else {
                auxHijo.setDerecha(null);
            }

            nieto.setDerecha(auxPadre);
            auxPadre.setIzquierda(null);
            auxPadre.setPadre(nieto);

            if (abuelo.getIzquierda() == auxPadre) {
                abuelo.setIzquierda(nieto);
            } else if (abuelo.getDerecha() == auxPadre) {
                abuelo.setDerecha(nieto);
            }

        }
    }

    public void rotacionII() {
        if (raiz == auxPadre) {
            raiz = auxHijo;
            //nieto = auxHijo.getIzquierda();
            auxHijo.setDerecha(auxPadre);
            auxPadre.setIzquierda(null);
            auxPadre.setPadre(auxHijo);
            auxHijo.setPadre(null);
        } else {
            abuelo = auxPadre.getPadre();
            abuelo.setIzquierda(auxPadre.getIzquierda());
            auxHijo.setPadre(abuelo);
            auxHijo.setDerecha(auxPadre);
            auxPadre.setPadre(auxHijo);
            auxPadre.setIzquierda(null);
        }
    }

    public void rotacionDD() {
        if (raiz == auxPadre) {
            raiz = auxHijo;
            auxHijo.setIzquierda(auxPadre);
            auxPadre.setPadre(auxHijo);
            auxPadre.setDerecha(null);
            auxHijo.setPadre(null);
        } else {
            abuelo = auxPadre.getPadre();
            abuelo.setDerecha(auxPadre.getDerecha());
            auxHijo.setPadre(abuelo);
            auxHijo.setIzquierda(auxPadre);
            auxPadre.setPadre(auxHijo);
            auxPadre.setDerecha(null);
        }
    }
    int contador;

    public String reporteInPrePos(String rep) {

        String codigo = "digraph G { rankdir = LR;\n node [shape=box];\n";
        
        if(rep.equals("In")){
            codigo = reporteInorden(raiz, codigo);
        }else if(rep.equals("Pre")){
            codigo = reportePreorden(raiz, codigo);
        }else if(rep.equals("Pos")){
            codigo = reportePosorden(raiz, codigo);
        }

        for (int i = 0; i < contador - 1; i++) {
            codigo += "nodo" + i + "->nodo" + (i + 1) + ";\n";
        }
        codigo += "}";

        contador = 0;
        return codigo;
    }

    public String reporteInorden(Categoria c, String codigo) {

        if (c != null) {

            codigo = reporteInorden(c.getIzquierda(), codigo);
            codigo += "nodo" + contador + "[label = \" " + c.getNombre() + "\"];\n";
            contador++;
            codigo = reporteInorden(c.getDerecha(), codigo);
        }
        return codigo;
    }

    public String reportePreorden(Categoria c, String codigo) {

        if (c != null) {
            codigo += "nodo" + contador + "[label = \" " + c.getNombre() + "\"];\n";
            contador++;
            codigo = reportePreorden(c.getIzquierda(), codigo);
            codigo = reportePreorden(c.getDerecha(), codigo);
        }
        return codigo;
    }

    public String reportePosorden(Categoria c, String codigo) {

        if (c != null) {

            codigo = reportePosorden(c.getIzquierda(), codigo);
            codigo = reportePosorden(c.getDerecha(), codigo);
            codigo += "nodo" + contador + "[label = \" " + c.getNombre() + "\"];\n";
            contador++;
        }
        return codigo;
    }

    public String codigoGraficaAVL(Categoria c, String grafo) {

        if (c != null) {
            grafo += "nodo" + c.getNombre() + "[label = \" " + c.getNombre() + "\"];\n";

            if (c.getIzquierda() != null) {
                grafo += "nodo" + c.getIzquierda().getNombre() + "[label = \" " + c.getIzquierda().getNombre() + "\"];\n";
                grafo += "nodo" + c.getNombre() + "->nodo" + c.getIzquierda().getNombre() + ";\n";
            }
            if (c.getDerecha() != null) {
                grafo += "nodo" + c.getDerecha().getNombre() + "[label = \" " + c.getDerecha().getNombre() + "\"];\n";
                grafo += "nodo" + c.getNombre() + "->nodo" + c.getDerecha().getNombre() + ";\n";
            }

            grafo = codigoGraficaAVL(c.getIzquierda(), grafo);
            grafo = codigoGraficaAVL(c.getDerecha(), grafo);

        }

        return grafo;
    }

    public int isMayor(String mayor, String menor) {
        //0 iguales, 1 mayor, -1 menor

        int asciiMayor = 0;
        int asciiMenor = 0;
        int limite;
        System.out.println("mayor" + mayor + "menor" + menor);
        if (mayor.length() <= menor.length()) {

            limite = mayor.length();
        } else {
            limite = menor.length();
        }

        for (int j = 0; j < limite; j++) {
            asciiMayor = mayor.charAt(j);
            asciiMenor = menor.charAt(j);

            if (asciiMayor > asciiMenor) {
                return 1;
            } else if (asciiMayor < asciiMenor) {
                return -1;
            } else {

            }
        }
        if (mayor.length() > menor.length()) {
            return 1;
        } else if (mayor.length() < menor.length()) {
            return -1;
        } else {
            return 0;
        }
    }

}
