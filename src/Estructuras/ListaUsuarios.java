
package Estructuras;
import Bean.Usuario;
/**
 *
 * @author gerso
 */
public class ListaUsuarios {
    
    Usuario primero;
    Usuario ultimo;
    
    public ListaUsuarios(){
        
        primero = null;
        ultimo = null;
    }
    
    public boolean isEmpty(){
        return primero == null;
    }
    
    public void insertar(int carnet, String nombre, String apellido, String carrera, String password){
        Usuario nuevo = new Usuario(carnet, nombre, apellido, carrera, password);
        
        if(isEmpty()){
            primero = nuevo;
            ultimo = nuevo;
        }else{
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
        }
        
        
        
    }
    
    
    
    public Usuario buscar(int carnet){
        Usuario aux = primero;
        while(aux != null){
            if(aux.getCarnet() == carnet){
                return aux;
            }
            aux = aux.getSiguiente();
        }
        
        return null;
    }
    
    public Usuario getPrimero(){
        return primero;
    }
    public void mostrarLista(){
        
        Usuario aux = primero;
        while(aux != null){
            System.out.println("carnet: "+aux.getCarnet()+" Contraseña: "+aux.getPassword());
            aux = aux.getSiguiente();
        }
    }
    
    
    public void eliminar(int carnet){
        Usuario aux = primero;
        System.out.println(primero.getCarnet());
        System.out.println(carnet);
        if(!isEmpty()){
            
            
            if(primero == ultimo){
                primero = null;
                ultimo = null;
            }else
            if(carnet == primero.getCarnet()){
                primero.getSiguiente().setAnterior(null);
                primero = primero.getSiguiente();
                
            }else if(carnet == ultimo.getCarnet()){
                ultimo.getAnterior().setSiguiente(null);
                ultimo = ultimo.getAnterior();
                
            }else{
                while(aux != null){
                    if(aux.getCarnet() == carnet){
                        aux.getAnterior().setSiguiente(aux.getSiguiente());
                        aux.getSiguiente().setAnterior(aux.getAnterior());
                    }
                    aux = aux.getSiguiente();
                }
            }
        }else{
            System.out.println("Lista Vacia");
        }
        
    }
    
    
    public String codigoGraficaLista(){
        String codigo ="";
        
        Usuario aux = primero;
        while(aux != null){
            codigo += "nodo"+aux.getCarnet()+"[label = \""+aux.getNombre()+aux.getApellido()+"\n"+aux.getCarnet()+aux.getCarrera()+"\n"+aux.getPassword()+"\"];\n";
            
            if(aux.getSiguiente()!= null){
                codigo += "nodo"+aux.getSiguiente().getCarnet()+"[label = \""+aux.getSiguiente().getNombre()+aux.getSiguiente().getApellido()+"\n"+aux.getSiguiente().getCarnet()+aux.getSiguiente().getCarrera()+"\n"+aux.getSiguiente().getPassword()+"\"];\n";
                codigo += "nodo"+aux.getCarnet() + "->nodo"+aux.getSiguiente().getCarnet()+";\n";
            }
            
            aux = aux.getSiguiente();
        }
      
        
        return codigo;
    }
    
    
    
}
