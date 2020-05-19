package Server;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import Bean.Usuario;
import Bean.Libro;
import Bean.Categoria;
import Controladores.ContCategoria;
import Controladores.ContLibro;
import Controladores.ContUsuario;
import Estructuras.*;
import eddproyecto2.Paquete;
/**
 *
 * @author gerso
 */
public class Servidor implements Runnable {

    ContUsuario cu = new ContUsuario();
    ContCategoria cg = new ContCategoria();

    public void run() {

        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            Paquete paquete = null;

            while (true) {
                Socket socket = serverSocket.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                try {
                    paquete = (Paquete) objectInputStream.readObject();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (paquete.getObjeto() != null) {
                    if (paquete.getTipo().equals("usuario")) {
                        Usuario usuario = (Usuario) paquete.getObjeto();

                        if (paquete.getInstruccion().equals("agregar")) {
                            cu.getUsuarios().insertar(usuario.getCarnet(), usuario.getNombre(), usuario.getApellido(), usuario.getCarrera(), usuario.getPassword());
                        } else if (paquete.getInstruccion().equals("eliminar")) {
                            cu.getUsuarios().eliminar(usuario.getCarnet());
                        } else if (paquete.getInstruccion().equals(("editar"))) {

                        }

                    } else if (paquete.getTipo().equals("libro")) {
                        Libro libro = (Libro) paquete.getObjeto();
                        if (paquete.getInstruccion().equals("agregar")) {
                            Categoria c = cg.getCategorias().buscar(libro.getCategoria());
                            if (c != null) {
                                cg.getCategorias().buscar(libro.getCategoria()).getLibros().crearLibro(libro.getISBN(), libro.getTitulo(), libro.getAutor(), libro.getAño(), libro.getEdicion(), libro.getCategoria(), libro.getIdioma(), libro.getCarnet());
                            } else {
                                ArbolB nuevo = new ArbolB();
                                cg.getCategorias().crearCategoria(libro.getCategoria(), nuevo);
                                cg.getCategorias().buscar(libro.getCategoria()).getLibros().crearLibro(libro.getISBN(), libro.getTitulo(), libro.getAutor(), libro.getAño(), libro.getEdicion(), libro.getCategoria(), libro.getIdioma(), libro.getCarnet());
                            }

                        } else if (paquete.getInstruccion().equals("eliminar")) {
                            cg.getCategorias().buscar(libro.getCategoria()).getLibros().eliminar2(libro.getISBN());
                        } else if (paquete.getInstruccion().equals(("editar"))) {

                        }

                    } else if (paquete.getTipo().equals("categ")) {
                        Categoria categoria = (Categoria) paquete.getObjeto();
                        if (paquete.getInstruccion().equals("agregar")) {
                            ArbolB nuevo = new ArbolB();
                            cg.getCategorias().crearCategoria(categoria.getNombre(), nuevo);
                        } else if (paquete.getInstruccion().equals("eliminar")) {
                            cg.getCategorias().eliminar(categoria.getNombre(), cg.getCategorias().getRaiz());
                        } else if (paquete.getInstruccion().equals(("editar"))) {

                        }
                    }
                }

                Socket socketEnviar = new Socket(paquete.getIpDestino(), 8200);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socketEnviar.getOutputStream());
                objectOutputStream.writeObject(paquete);
                objectOutputStream.close();
                socketEnviar.close();
                socket.close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Thread thread = new Thread(this);
        thread.start();
    }
}
