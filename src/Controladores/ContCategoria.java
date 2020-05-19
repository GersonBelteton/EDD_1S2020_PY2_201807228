
package Controladores;
import Estructuras.ArbolAVL;
/**
 *
 * @author gerso
 */
public class ContCategoria {
    
    public static ArbolAVL categorias = new ArbolAVL();
    

    
    public ArbolAVL getCategorias(){
        return categorias;
    }
}
