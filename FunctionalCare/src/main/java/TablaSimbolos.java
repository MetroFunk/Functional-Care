import java.util.HashMap;
import java.util.Map;

/**
 * Created by jordan on 06/11/15.
 */
public class TablaSimbolos {

    private Map<String, Declaration> tabla;
    private TablaSimbolos padre;

    TablaSimbolos(){
        tabla = new HashMap<String, Declaration>();
        padre = null;
    }

    TablaSimbolos(TablaSimbolos padre){
        tabla = new HashMap<String, Declaration>();
        this.padre = padre;
    }

    public boolean isEmpty(){
        if(tabla.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }


    public Declaration lookup(String id){
        Declaration entrada = tabla.get(id);
        if (entrada != null){
            return entrada;
        }
        else if (padre != null){
            return padre.lookup(id);
        }
        return null;
    }

    public Declaration get(String id){
        return tabla.get(id);
    }

    public void set(String id, Declaration entrada) throws Exception {
        if(tabla.get(id) != null){
            throw new Exception("Un identificador fue declarado mas de una vez");
        }
        else{
            tabla.put(id, entrada);
        }
    }

    public Map<String, Declaration> getTabla() {
        return tabla;
    }

    public void setTabla(Map<String, Declaration> tabla) {
        this.tabla = tabla;
    }

    public TablaSimbolos getPadre() {
        return padre;
    }

    public void setPadre(TablaSimbolos padre) {
        this.padre = padre;
    }

    public void imprimir(){
        System.out.println(tabla);
        if(padre != null){
            padre.imprimir();
        }
    }
}
