/**
 * Created by jordan on 22/10/15.
 */
public class Nodo {

    private String nombre;
    private String tipo;
    private String valor;
    private int linea;


    public Nodo(String nombre, String tipo, String valor, int linea){
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
        this.linea = linea;
    }

    public Nodo(String nombre, String tipo, String valor){
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
        this.linea = 0;
    }

    public Nodo(String nombre){
        this.nombre = nombre;
        this.tipo = null;
        this.valor = null;
        this.linea = 0;
    }

    public Nodo(String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = null;
        this.linea = 0;
    }

    public Nodo(){
        this.nombre = null;
        this.tipo = null;
        this.valor = null;
        this.linea = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = 0;
    }


}
