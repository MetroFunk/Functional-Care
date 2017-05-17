/**
 * Created by jordan on 21/10/15.
 */

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Stack;


public class MyListener extends FunctionalCareBaseListener {

    Stack<AST> reglas;
    AST padreActual;

    public MyListener(){
        super();
        reglas = new Stack<AST>();
        padreActual = new AST(new Nodo("Principal", null, null));
    }

    public AST getAST(){
        return padreActual;
    }

    @Override public void enterDef(FunctionalCareParser.DefContext ctx) {
        reglas.push(padreActual);
        padreActual = new AST(new Nodo("FuncDeclare"));
    }

    @Override public void exitDef(FunctionalCareParser.DefContext ctx) {
        AST padreAnterior = reglas.pop();
        padreAnterior.agregarHijo(padreActual);
        padreActual = padreAnterior;
    }

    @Override public void enterNombreFuncion(FunctionalCareParser.NombreFuncionContext ctx) {
        Nodo nodo = new Nodo("ID");
        nodo.setValor(ctx.ID().getSymbol().getText());
        nodo.setLinea(ctx.ID().getSymbol().getLine());
        AST nuevo = new AST(nodo);
        padreActual.agregarHijo(nuevo);
    }

    @Override public void enterParams(FunctionalCareParser.ParamsContext ctx) {
        reglas.push(padreActual);
        padreActual = new AST(new Nodo("Params"));
    }

    @Override public void exitParams(FunctionalCareParser.ParamsContext ctx) {
        AST padreAnterior = reglas.pop();
        padreAnterior.agregarHijo(padreActual);
        padreActual = padreAnterior;
    }

    @Override public void enterReturnFunct(FunctionalCareParser.ReturnFunctContext ctx) {
        reglas.push(padreActual);
        padreActual = new AST(new Nodo("ReturnType", ctx.getText()));
    }

    @Override public void exitReturnFunct(FunctionalCareParser.ReturnFunctContext ctx) {
        AST padreAnterior = reglas.pop();
        padreAnterior.agregarHijo(padreActual);
        padreActual = padreAnterior;
    }

    @Override public void enterParam(FunctionalCareParser.ParamContext ctx) {
        String nombreParametro = ctx.ID().getSymbol().getText();
        String tipoParametro = ctx.datatypes().getText();
        int lineaParametro = ctx.ID().getSymbol().getLine();
        Nodo nodo = new Nodo("ID",tipoParametro,nombreParametro,lineaParametro);
        AST nuevo = new AST(nodo);
        padreActual.agregarHijo(nuevo);
    }

    @Override public void enterCall(FunctionalCareParser.CallContext ctx) {
        reglas.push(padreActual);
        padreActual = new AST(new Nodo("FuncCall"));
    }

    @Override public void exitCall(FunctionalCareParser.CallContext ctx) {
        AST padreAnterior = reglas.pop();
        padreAnterior.agregarHijo(padreActual);
        padreActual = padreAnterior;
        padreAnterior = reglas.pop();
        padreAnterior.agregarHijo(padreActual);
        padreActual = padreAnterior;
    }

    @Override public void enterMainFunc(FunctionalCareParser.MainFuncContext ctx) {
        reglas.push(padreActual);
        padreActual = new AST(new Nodo("FuncCall"));
        reglas.push(padreActual);
        padreActual = new AST(new Nodo("ExprPropia",null,"main"));
    }

    @Override public void exitMainFunc(FunctionalCareParser.MainFuncContext ctx) {
        AST padreAnterior = reglas.pop();
        padreAnterior.agregarHijo(padreActual);
        padreActual = padreAnterior;
        padreAnterior = reglas.pop();
        padreAnterior.agregarHijo(padreActual);
        padreActual = padreAnterior;
    }

    @Override public void enterCons(FunctionalCareParser.ConsContext ctx) {
        reglas.push(padreActual);
        padreActual = new AST(new Nodo("ConstDeclare"));
        TerminalNode identificador = ctx.ID();
        Nodo nodo = new Nodo("ID");
        nodo.setValor(identificador.getSymbol().getText());
        nodo.setLinea(identificador.getSymbol().getLine());
        AST nuevo = new AST(nodo);
        padreActual.agregarHijo(nuevo);

    }

    @Override public void exitCons(FunctionalCareParser.ConsContext ctx) {
        AST padreAnterior = reglas.pop();
        padreAnterior.agregarHijo(padreActual);
        padreActual = padreAnterior;
    }

    @Override public void enterParintfunc2(FunctionalCareParser.Parintfunc2Context ctx) {
        reglas.push(padreActual);
        padreActual = new AST(new Nodo("ExprParInt","parInt",ctx.getText()));
    }

    @Override public void enterParboolfunc2(FunctionalCareParser.Parboolfunc2Context ctx) {
        reglas.push(padreActual);
        padreActual = new AST(new Nodo("ExprParBool","parBool",ctx.getText()));
    }

    @Override public void enterParintfunc1(FunctionalCareParser.Parintfunc1Context ctx) {
        reglas.push(padreActual);
        String texto = ctx.getText();
        if(texto.equals("firstParInt")){
            padreActual = new AST(new Nodo("ExprParInt","int",ctx.getText()));
        }else{
            padreActual = new AST(new Nodo("ExprParInt","parInt",ctx.getText()));
        }
    }

    @Override public void enterParboolfunc1(FunctionalCareParser.Parboolfunc1Context ctx) {
        reglas.push(padreActual);
        String texto = ctx.getText();
        if(texto.equals("firstParBool")){
            padreActual = new AST(new Nodo("ExprParBool","bool",ctx.getText()));
        }else{
            padreActual = new AST(new Nodo("ExprParBool","parBool",ctx.getText()));
        }
    }

    @Override public void enterAtomid(FunctionalCareParser.AtomidContext ctx) {
        Nodo literalActual = new Nodo("ID");
        literalActual.setValor(ctx.ID().getSymbol().getText());
        AST arbol = new AST(literalActual);
        padreActual.agregarHijo(arbol);
    }

    @Override public void enterAtomnull(FunctionalCareParser.AtomnullContext ctx) {
        Nodo literalActual = new Nodo("LiteralNull","null","null");
        AST arbol = new AST(literalActual);
        padreActual.agregarHijo(arbol);
    }

    @Override public void enterAtomnum(FunctionalCareParser.AtomnumContext ctx) {
        Nodo literalActual = new Nodo("LiteralEntero","int",ctx.NUMBER().getSymbol().getText());
        AST arbol = new AST(literalActual);
        padreActual.agregarHijo(arbol);
    }

    @Override public void enterAtombool(FunctionalCareParser.AtomboolContext ctx) {
        Nodo literalActual = new Nodo("LiteralBool","bool",ctx.BOOL().getSymbol().getText());
        AST arbol = new AST(literalActual);
        padreActual.agregarHijo(arbol);
    }

    @Override public void enterRelationalop(FunctionalCareParser.RelationalopContext ctx) {
        reglas.push(padreActual);
        padreActual = new AST(new Nodo("ExprRelacional","bool",ctx.getText()));
    }

    @Override public void enterIntop(FunctionalCareParser.IntopContext ctx) {
        reglas.push(padreActual);
        padreActual = new AST(new Nodo("ExprAritmetica","int",ctx.getText()));
    }

    @Override public void enterLogicoparity1(FunctionalCareParser.Logicoparity1Context ctx) {
        reglas.push(padreActual);
        padreActual = new AST(new Nodo("ExprLogica","bool",ctx.getText()));
    }

    @Override public void enterLogicoparity2(FunctionalCareParser.Logicoparity2Context ctx) {
        reglas.push(padreActual);
        padreActual = new AST(new Nodo("ExprLogica","bool",ctx.getText()));
    }

    @Override public void enterLogicoparity3(FunctionalCareParser.Logicoparity3Context ctx) {
        reglas.push(padreActual);
        Nodo nodo = new Nodo("ExprLogica");
        nodo.setValor(ctx.getText());
        padreActual = new AST(new Nodo("ExprLogica", null, ctx.getText()));
    }

    @Override public void enterFuncionUsuario(FunctionalCareParser.FuncionUsuarioContext ctx) {
        reglas.push(padreActual);
        padreActual = new AST(new Nodo("ExprPropia",null,ctx.getText()));
    }

}
