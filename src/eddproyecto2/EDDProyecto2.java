package eddproyecto2;

import Bean.Libro;
import Estructuras.*;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import Vistas.Login;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author gerso
 */
public class EDDProyecto2 {

    public static void main(String[] args) {
        
      
        ArbolB ab = new ArbolB();
        TablaHash th = new TablaHash();
        ArbolAVL avl = new ArbolAVL();

        Scanner s = new Scanner(System.in);
        int isbn;
        int carnet;
        String cat;
         Login log = new Login();
        log.setVisible(true);
        log.setLocationRelativeTo(null);
 /*do{
            System.out.println("Ingresa un ISBN: ");
            isbn = s.nextInt();
            
            ab.crearLibro(isbn, "hola", "gerson", "2020", "1era", "misterio", "eapañol", 201807228);

            
            System.out.println("Arbol");
            ab.mostrarArbol(ab.getRaiz());
            
        }while(isbn != 777);
        
 
 ab.recorrerArbolPorNivel(ab.getRaiz());
        
        int isbnel = 0;
        
        
        
        System.out.println("Eliminar: ");
        isbnel = s.nextInt();
        
        ab.eliminar2(isbnel);
        ab.mostrarArbol(ab.getRaiz());
        
        
         

        ArbolB lib = new ArbolB();
        do {
            System.out.println("Insertar nombre Categoria: ");
            cat = s.nextLine();

            if (!cat.equals("salir")) {
                avl.crearCategoria(cat, lib);
            }

        } while (!cat.equals("salir"));

        
        avl.preOrden(avl.getRaiz());
        
        
        cat = s.nextLine();
        
        avl.eliminar(cat, avl.getRaiz());
        
        avl.preOrden(avl.getRaiz());*/
    }

}
