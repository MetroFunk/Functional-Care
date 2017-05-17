/**
 * Created by jordan on 22/10/15.
 */

import java.util.ArrayList;
import java.util.List;

public class AST {

    private Nodo nodo;
    private List<AST> hijos;
    private TablaSimbolos scope;

    public AST(Nodo nodo){
        this.nodo = nodo;
        this.hijos = new ArrayList<AST>();
        scope = null;
    }

    public void accept(ASTVisitor visitor) throws Exception {
        if(visitor instanceof ConstructorTablaSimbolos){
            List<AST> hijosFuncDeclare = this.filtrarHijos("FuncDeclare");
            int numHijosFuncDeclare = hijosFuncDeclare.size();
            for(int i = 0; i < numHijosFuncDeclare; i++){
                visitor.visit(hijosFuncDeclare.get(i));
            }
        }
        else{
            System.out.println("Entro en el error");
        }
    }

    public TablaSimbolos getScope() {
        return scope;
    }

    public void setScope(TablaSimbolos scope) {
        this.scope = scope;
    }

    public Nodo getPadre(){
        return nodo;
    }

    public void setPadre(Nodo nodo){
        this.nodo = nodo;
    }


    public List<AST> filtrarHijos(String nombre){
        int numHijos = hijos.size();
        if(numHijos > 0){
            List<AST> nuevaLista = new ArrayList<AST>();
            for(int i = 0; i < numHijos; i++){
                AST hijo = hijos.get(i);
                String nombreHijo = hijo.getPadre().getNombre();
                if(nombreHijo.equals(nombre)){
                    nuevaLista.add(hijo);
                }
            }
            return nuevaLista;
        }
        return hijos;
    }

    public AST getFirstHijo(String nombre){
        int numHijos = hijos.size();
        if(numHijos > 0){
            for(int i = 0; i < numHijos; i++){
                AST hijo = hijos.get(i);
                String nombreHijo = hijo.getPadre().getNombre();
                if(nombreHijo.equals(nombre)){
                    return hijo;
                }
            }
        }
        return null;
    }

    public void agregarHijo(AST tree){
        if(hijos == null){
            hijos = new ArrayList<AST>();
        }
        hijos.add(tree);
    }

    public List<AST> getHijos(){
        return hijos;
    }

    public void imprimir(){
        System.out.println("--------------------------");
        System.out.print("Nodo: " + nodo.getNombre() + "      " + nodo.getTipo() + "      " + nodo.getValor() + "      ");
        if(scope != null){
            System.out.println(scope);
            scope.imprimir();
        }
        else{
            System.out.println("null");
        }
        for(int i = 0; i < hijos.size(); i++){
            hijos.get(i).imprimir();
        }
        System.out.println("--------------------------");
    }

}
