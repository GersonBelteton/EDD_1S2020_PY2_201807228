package Bean;

/**
 *
 * @author gerso
 */
public class Usuario {

    private int carnet;
    private String nombre;
    private String apellido;
    private String carrera;
    private String password;
    private Usuario siguiente;
    private Usuario anterior;

    public Usuario(int carnet, String nombre, String apellido, String carrera, String password) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.password = password;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getPassword() {
        return password;
    }

    public Usuario getAnterior() {
        return anterior;
    }

    public void setAnterior(Usuario anterior) {
        this.anterior = anterior;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Usuario siguiente) {
        this.siguiente = siguiente;
    }

}
