import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.BitSet;

/**
 * Created by jordan on 07/10/15.
 */
public class Main {


    public static void main(String[] args) throws Exception {

        if(args[0].contains(".fc") == false){
            System.out.println("El archivo no contiene la extensión .fc necesaria para la generacion de código");
            System.exit(0);
        }

        //Lexer
        CharStream cs = new ANTLRFileStream(args[0]);
        FunctionalCareLexer lexer = new FunctionalCareLexer(cs);

        //Tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //Parser
        FunctionalCareParser parser = new FunctionalCareParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ListenerError());

        //Arbol de parseado
        ParseTreeWalker walker = new ParseTreeWalker();
        ParseTree tree = parser.func();

        //Se camina en el arbol
        MyListener listener = new MyListener();
        walker.walk(listener, tree);

        //Se obtiene el AST
        AST nodoPrincipal = listener.getAST();

        //Analisis semantico
        ConstructorTablaSimbolos creador  = new ConstructorTablaSimbolos();
        creador.visit(nodoPrincipal);
        AnalizadorSemantico analizador = new AnalizadorSemantico();
        analizador.visit(nodoPrincipal);

        System.out.println("Felicidades!! Su archivo paso los analisis sintacticos y semanticos");

        //Generación de código
        GeneradorCodigo generador = new GeneradorCodigo(args[0].replace(".fc", ".ll"));
        generador.generar(nodoPrincipal);
        generador.close();


    }

}