
package eddproyecto2;
import java.io.Serializable;
/**
 *
 * @author gerso
 */
public class Paquete implements Serializable {
 
     private Object objeto;
     private String ipDestino;
     private String ipOrigen;
     private String instruccion;
     private String tipo;
     public Paquete(){
         
     }

    public Paquete(Object objeto, String ipDestino, String ipOrigen, String instruccion, String tipo) {
        this.objeto = objeto;
        this.ipDestino = ipDestino;
        this.ipOrigen = ipOrigen;
        this.instruccion = instruccion;
        this.tipo = tipo;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public String getIpDestino() {
        return ipDestino;
    }

    public void setIpDestino(String ipDestino) {
        this.ipDestino = ipDestino;
    }

    public String getIpOrigen() {
        return ipOrigen;
    }

    public void setIpOrigen(String ipOrigen) {
        this.ipOrigen = ipOrigen;
    }

    public String getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(String instruccion) {
        this.instruccion = instruccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
     
     
}
