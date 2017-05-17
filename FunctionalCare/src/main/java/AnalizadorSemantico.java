/**
 * Created by jordan on 07/11/15.
 */

import java.util.List;

public class AnalizadorSemantico implements ASTVisitor {

    TablaSimbolos currentScope = new TablaSimbolos();

    public void visitHijos(List<AST> nodos) throws Exception {
        int numNodos = nodos.size();
        for(int i = 0; i < numNodos; i++){
            visit(nodos.get(i));
        }
    }

    public void visit(AST nodoAST) throws Exception {
        String nombreNodo = nodoAST.getPadre().getNombre();
        if(nombreNodo.equals("Principal") || nombreNodo.equals("FuncDeclare")){
            currentScope = nodoAST.getScope();
        }
        List<AST> hijos = nodoAST.getHijos();
        int numHijos = hijos.size();
        if(numHijos > 0){
            visitHijos(hijos);
            chequearNodo(nodoAST);
        }
        else{
            chequearHoja(nodoAST);
        }
    }

    public void chequearHoja(AST nodoAST) throws Exception {
        String nombreNodo = nodoAST.getPadre().getNombre();
        if(nombreNodo.equals("ID") && (nodoAST.getPadre().getTipo() == null)) {
            String valorID = nodoAST.getPadre().getValor();
            Declaration decl = currentScope.lookup(valorID);
            if(decl == null){
                throw new Exception("Identificador nunca se declaro");
            }
            else{
                Nodo nodo = nodoAST.getPadre();
                nodo.setTipo(decl.getRetorno());
                nodoAST.setPadre(nodo);
            }
        }
    }

    public void chequearNodo(AST nodoAST) throws Exception {

        String nombreNodo = nodoAST.getPadre().getNombre();
        String valorNodo = nodoAST.getPadre().getValor();
        List<AST> hijos = nodoAST.getHijos();
        int numHijos = hijos.size();
        switch (nombreNodo){
            case "ExprAritmetica":
                for(int i = 0; i < numHijos; i++){
                    if(hijos.get(i).getPadre().getTipo().equals("int") == false){
                        throw new Exception("Expresion aritmetica solo acepta numeros enteros");
                    }
                }
                break;
            case "ExprRelacional":
                for(int i = 0; i < numHijos; i++){
                    if(hijos.get(i).getPadre().getTipo().equals("int") == false){
                        throw new Exception("Expresion relacional solo acepta numeros enteros");
                    }
                }
                break;
            case "ExprLogica":
                if(numHijos == 1 || numHijos == 2){
                    for(int i = 0; i < numHijos; i++){
                        if(hijos.get(i).getPadre().getTipo().equals("bool") == false) {
                            throw new Exception("Expresion logica solo acepta booleanos");
                        }
                    }
                }
                else{
                    if(hijos.get(0).getPadre().getTipo().equals("bool") == false){
                        throw new Exception("El primer parametro del if es booleano");
                    }
                    Nodo nodo = nodoAST.getPadre();
                    nodo.setTipo(hijos.get(1).getPadre().getTipo());
                    nodoAST.setPadre(nodo);
                }
                break;
            case "ExprPropia":
                Declaration decl = currentScope.lookup(valorNodo);
                if(decl == null){
                    throw new Exception("Nunca se declaro la funcion");
                }
                else if((valorNodo.equals("main") == false) && (decl.getNumParams() != numHijos)){
                    System.out.println(nodoAST.getPadre().getValor());
                    System.out.println(decl.getNumParams());
                    System.out.println(numHijos);
                    System.out.println(hijos.get(0).getPadre().getNombre());
                    throw new Exception("La aridad de la funcion no coincide con la declarada");
                }
                else if((valorNodo.equals("main") == false) && (decl.getNumParams() > 0)){
                    for(int i = 0; i < numHijos; i++){
                        if(hijos.get(i).getPadre().getTipo().equals(decl.getTiposFuncion().get(i)) == false){
                            throw new Exception("Los tipos de los parametros no coinciden");
                        }
                    }
                }
                Nodo nodo = nodoAST.getPadre();
                nodo.setTipo(decl.getRetorno());
                nodoAST.setPadre(nodo);
                break;
            case "FuncCall":
                AST hijoFuncCall = nodoAST.getHijos().get(0);
                String retorno = hijoFuncCall.getPadre().getTipo();
                String nombre = hijoFuncCall.getPadre().getValor();
                Nodo nodo2 = nodoAST.getPadre();
                nodo2.setTipo(retorno);
                nodo2.setValor(nombre);
                nodoAST.setPadre(nodo2);
                break;
            case "ExprParInt":
                if(valorNodo.equals("crearParInt")){
                    if(numHijos != 2) {
                        throw new Exception("La aridad de los parametros de par es incorrecta");
                    }
                    String tipoArg1 = hijos.get(0).getPadre().getTipo();
                    String tipoArg2 = hijos.get(1).getPadre().getTipo();
                    if((tipoArg1.equals("int") == false) && (tipoArg1.equals("parInt") == false)){
                        System.out.println("Entre aquí");
                        throw new Exception("Argumento ingresado en el par es incorrecto");
                    }
                    else if((tipoArg2.equals("int") == false) && (tipoArg1.equals("parInt") == false) && (tipoArg1.equals("null") == false)){
                        throw new Exception("Argumento ingresado en el par es incorrecto");
                    }
                }
                else if(valorNodo.equals("appendParInt")){
                    if(numHijos != 2) {
                        throw new Exception("La aridad de los parametros de par es incorrecta");
                    }
                    String tipoArg1 = hijos.get(0).getPadre().getTipo();
                    String tipoArg2 = hijos.get(1).getPadre().getTipo();
                    if((tipoArg1.equals("parInt") == false)){
                        throw new Exception("Argumento ingresado en el par es incorrecto");
                    }
                    else if((tipoArg2.equals("int") == false)){
                        throw new Exception("Argumento ingresado en el par es incorrecto");
                    }
                }
                else if(valorNodo.equals("firstParInt")){
                    if(numHijos != 1) {
                        throw new Exception("La aridad de los parametros de par es incorrecta");
                    }
                    String tipoArg1 = hijos.get(0).getPadre().getTipo();
                    if((tipoArg1.equals("parInt") == false)){
                        throw new Exception("Argumento ingresado en el par es incorrecto");
                    }
                }
                else if(valorNodo.equals("lastParInt")){
                    if(numHijos != 1) {
                        throw new Exception("La aridad de los parametros de par es incorrecta");
                    }
                    String tipoArg1 = hijos.get(0).getPadre().getTipo();
                    if((tipoArg1.equals("parInt") == false)){
                        throw new Exception("Argumento ingresado en el par es incorrecto");
                    }
                }
                break;
            case "ExprParBool":
                if(valorNodo.equals("crearParBool")){
                    if(numHijos != 2) {
                        throw new Exception("La aridad de los parametros de par es incorrecta");
                    }
                    String tipoArg1 = hijos.get(0).getPadre().getTipo();
                    String tipoArg2 = hijos.get(1).getPadre().getTipo();
                    if((tipoArg1.equals("bool") == false) && (tipoArg1.equals("parBool") == false)){
                        throw new Exception("Argumento ingresado en el par es incorrecto");
                    }
                    else if((tipoArg2.equals("bool") == false) && (tipoArg1.equals("parBool") == false) && (tipoArg1.equals("null") == false)){
                        throw new Exception("Argumento ingresado en el par es incorrecto");
                    }
                }
                else if(valorNodo.equals("appendParBool")){
                    if(numHijos != 2) {
                        throw new Exception("La aridad de los parametros de par es incorrecta");
                    }
                    String tipoArg1 = hijos.get(0).getPadre().getTipo();
                    String tipoArg2 = hijos.get(1).getPadre().getTipo();
                    if((tipoArg1.equals("parBool") == false)){
                        throw new Exception("Argumento ingresado en el par es incorrecto");
                    }
                    else if((tipoArg2.equals("bool") == false)){
                        throw new Exception("Argumento ingresado en el par es incorrecto");
                    }
                }
                else if(valorNodo.equals("firstParBool")){
                    if(numHijos != 1) {
                        throw new Exception("La aridad de los parametros de par es incorrecta");
                    }
                    String tipoArg1 = hijos.get(0).getPadre().getTipo();
                    if((tipoArg1.equals("parBool") == false)){
                        throw new Exception("Argumento ingresado en el par es incorrecto");
                    }
                }
                else if(valorNodo.equals("lastParBool")){
                    if(numHijos != 1) {
                        throw new Exception("La aridad de los parametros de par es incorrecta");
                    }
                    String tipoArg1 = hijos.get(0).getPadre().getTipo();
                    if((tipoArg1.equals("parBool") == false)){
                        throw new Exception("Argumento ingresado en el par es incorrecto");
                    }
                }
                break;
        }
    }

}