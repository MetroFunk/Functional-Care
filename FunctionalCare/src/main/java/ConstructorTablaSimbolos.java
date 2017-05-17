import java.util.ArrayList;
import java.util.List;

/**
 * Created by jordan on 07/11/15.
 */
public class ConstructorTablaSimbolos implements ASTVisitor {

    TablaSimbolos currentScope = new TablaSimbolos();

    public void generarTablaPrincipal(AST nodoAST) throws Exception {
        List<AST> hijosFuncDeclare = nodoAST.filtrarHijos("FuncDeclare");
        List<AST> hijosConstDeclare = nodoAST.filtrarHijos("ConstDeclare");
        TablaSimbolos nuevoScope = new TablaSimbolos();
        int numHijosFuncDeclare = hijosFuncDeclare.size();
        for(int i = 0; i < numHijosFuncDeclare; i++) {
            AST subNodoAST = hijosFuncDeclare.get(i);
            AST idFunct = subNodoAST.getFirstHijo("ID");
            AST returnFunct = subNodoAST.getFirstHijo("ReturnType");

            List<AST> params = subNodoAST.getHijos().get(1).getHijos();
            int numParams = params.size();
            List<String> tiposParams = new ArrayList<String>();
            for(int j = 0; j < numParams; j++){
                tiposParams.add(params.get(i).getPadre().getTipo());
            }

            Declaration decl = new FuncDecl(returnFunct.getPadre().getTipo(), numParams);
            decl.setTiposFuncion(tiposParams);
            nuevoScope.set(idFunct.getPadre().getValor(), decl);
        }
        int numHijosConstDeclare = hijosConstDeclare.size();
        for(int i = 0; i < numHijosConstDeclare; i++) {
            AST subNodoAST = hijosConstDeclare.get(i);
            AST idFunct = subNodoAST.getFirstHijo("ID");
            AST returnFunct = subNodoAST.getFirstHijo("ReturnType");
            Declaration decl = new ConstDecl(returnFunct.getPadre().getTipo());
            nuevoScope.set(idFunct.getPadre().getValor(), decl);
        }
        nuevoScope.set("main", new FuncDecl(null, 0));
        nodoAST.setScope(nuevoScope);
        currentScope = nuevoScope;
        nodoAST.accept(this);
    }

    public void generarTablaFuncDeclare(AST nodoAST) throws Exception {
        AST params = nodoAST.getFirstHijo("Params");
        List<AST> idParams = params.getHijos();
        TablaSimbolos nuevoScope = new TablaSimbolos();
        int numIdParams = idParams.size();
        for(int i = 0; i < numIdParams; i++){
            String tipoParam = idParams.get(i).getPadre().getTipo();
            String valorParam = idParams.get(i).getPadre().getValor();
            Declaration decl = new ParamsDecl(tipoParam);
            nuevoScope.set(valorParam, decl);
        }
        nuevoScope.setPadre(currentScope);
        nodoAST.setScope(nuevoScope);
    }


    public void visit(AST nodoAST) throws Exception {
        String nombreNodo = nodoAST.getPadre().getNombre();
        switch (nombreNodo){
            case "Principal":
                generarTablaPrincipal(nodoAST);
                break;
            case "FuncDeclare":
                generarTablaFuncDeclare(nodoAST);
                break;
        }

    }

}
