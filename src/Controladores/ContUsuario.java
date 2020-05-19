/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import Estructuras.TablaHash;
/**
 *
 * @author gerso
 */
public class ContUsuario {
    public static TablaHash usuarios = new TablaHash();
    public static int carnet ;
    
    
    
    public TablaHash getUsuarios(){
        return usuarios;
    }

    public  int getCarnet() {
        return carnet;
    }

    public  void setCarnet(int carnet) {
        ContUsuario.carnet = carnet;
    }
    
    
    
}
