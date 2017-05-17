import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jordan on 20/11/15.
 */
public class GeneradorCodigo {

    FileWriter archivo;
    PrintWriter escritor;
    int registro;
    String template;

    public GeneradorCodigo(String nombreArchivo) throws IOException {
        archivo = new FileWriter(nombreArchivo);
        escritor = new PrintWriter(archivo);
        registro = 0;
        template = ";Template para imprimir numero\n" +
                "@tempNum = internal constant [4 x i8] c\"%d\\0A\\00\"\n" +
                "\n" +
                ";Importar print\n" +
                "declare i32 @printf(i8 *, ...)\n" +
                "\n" +
                "define i32 @suma(i32 %num1_arg, i32 %num2_arg) {\n" +
                "\t;Crear espacio para las variables\n" +
                "\t%num1 = alloca i32\n" +
                "\t%num2 = alloca i32\n" +
                "\t;Copiar parametros en variables locales\n" +
                "\tstore i32 %num1_arg, i32* %num1\n" +
                "\tstore i32 %num2_arg, i32* %num2\n" +
                "\t;Se cargan las variables\n" +
                "\t%r1 = load i32* %num1\n" +
                "\t%r2 = load i32* %num2\t\n" +
                "\t;Se hacen las sumas\n" +
                "\t%res = add i32 %r1, %r2\n" +
                "\t;Retorno\n" +
                "\tret i32 %res\n" +
                "}\n" +
                "\n" +
                "define i32 @resta(i32 %num1_arg, i32 %num2_arg) {\n" +
                "\t;Crear espacio para las variables\n" +
                "\t%num1 = alloca i32\n" +
                "\t%num2 = alloca i32\n" +
                "\t;Copiar parametros en variables locales\n" +
                "\tstore i32 %num1_arg, i32* %num1\n" +
                "\tstore i32 %num2_arg, i32* %num2\n" +
                "\t;Se cargan las variables\n" +
                "\t%r1 = load i32* %num1\n" +
                "\t%r2 = load i32* %num2\n" +
                "\t;Se hacen las sumas\n" +
                "\t%res = sub i32 %r1, %r2\n" +
                "\t;Retorno\n" +
                "\tret i32 %res\n" +
                "}\n" +
                "\n" +
                "define i32 @mult(i32 %num1_arg, i32 %num2_arg) {\n" +
                "\t;Crear espacio para las variables\n" +
                "\t%num1 = alloca i32\n" +
                "\t%num2 = alloca i32\n" +
                "\t;Copiar parametros en variables locales\n" +
                "\tstore i32 %num1_arg, i32* %num1\n" +
                "\tstore i32 %num2_arg, i32* %num2\t\n" +
                "\t;Se cargan las variables\n" +
                "\t%r1 = load i32* %num1\n" +
                "\t%r2 = load i32* %num2\t\n" +
                "\t;Se hacen las sumas\n" +
                "\t%res = mul i32 %r1, %r2\n" +
                "\t;Retorno\n" +
                "\tret i32 %res\n" +
                "}\n" +
                "\n" +
                "define i32 @div(i32 %num1_arg, i32 %num2_arg) {\n" +
                "\t;Crear espacio para las variables\n" +
                "\t%num1 = alloca i32\n" +
                "\t%num2 = alloca i32\n" +
                "\t;Copiar parametros en variables locales\n" +
                "\tstore i32 %num1_arg, i32* %num1\n" +
                "\tstore i32 %num2_arg, i32* %num2\n" +
                "\t;Se cargan las variables\n" +
                "\t%r1 = load i32* %num1\n" +
                "\t%r2 = load i32* %num2\t\n" +
                "\t;Se hacen las sumas\n" +
                "\t%res = sdiv i32 %r1, %r2\n" +
                "\t;Retorno\n" +
                "\tret i32 %res\n" +
                "}\n" +
                "\n" +
                "define i32 @modulo(i32 %num1_arg, i32 %num2_arg) {\n" +
                "\t;Crear espacio para las variables\n" +
                "\t%num1 = alloca i32\n" +
                "\t%num2 = alloca i32\n" +
                "\t;Copiar parametros en variables locales\n" +
                "\tstore i32 %num1_arg, i32* %num1\n" +
                "\tstore i32 %num2_arg, i32* %num2\n" +
                "\t;Se cargan las variables\n" +
                "\t%r1 = load i32* %num1\n" +
                "\t%r2 = load i32* %num2\t\n" +
                "\t;Se hacen las sumas\n" +
                "\t%res = srem i32 %r1, %r2\n" +
                "\t;Retorno\n" +
                "\tret i32 %res\n" +
                "}\n" +
                "\n" +
                "define i32 @and(i32 %num1_arg, i32 %num2_arg) {\n" +
                "\t;Crear espacio para las variables\n" +
                "\t%num1 = alloca i32\n" +
                "\t%num2 = alloca i32\n" +
                "\t;Copiar parametros en variables locales\n" +
                "\tstore i32 %num1_arg, i32* %num1\n" +
                "\tstore i32 %num2_arg, i32* %num2\n" +
                "\t;Se cargan las variables\n" +
                "\t%r1 = load i32* %num1\n" +
                "\t%r2 = load i32* %num2\t\n" +
                "\t;Se hacen las sumas\n" +
                "\t%res = and i32 %r1, %r2\n" +
                "\t;Retorno\n" +
                "\tret i32 %res\n" +
                "}\n" +
                "\n" +
                "define i32 @or(i32 %num1_arg, i32 %num2_arg) {\n" +
                "\t;Crear espacio para las variables\n" +
                "\t%num1 = alloca i32\n" +
                "\t%num2 = alloca i32\n" +
                "\t;Copiar parametros en variables locales\n" +
                "\tstore i32 %num1_arg, i32* %num1\n" +
                "\tstore i32 %num2_arg, i32* %num2\n" +
                "\t;Se cargan las variables\n" +
                "\t%r1 = load i32* %num1\n" +
                "\t%r2 = load i32* %num2\t\n" +
                "\t;Se hacen las sumas\n" +
                "\t%res = or i32 %r1, %r2\n" +
                "\t;Retorno\n" +
                "\tret i32 %res\n" +
                "}\n" +
                "\n" +
                "define i32 @not(i32 %num1_arg) {\n" +
                "\t;Crear espacio para las variables\n" +
                "\t%num1 = alloca i32\n" +
                "\t;Copiar parametros en variables locales\n" +
                "\tstore i32 %num1_arg, i32* %num1\n" +
                "\t;Se cargan las variables\n" +
                "\t%r1 = load i32* %num1\n" +
                "\t;Se hacen las sumas\n" +
                "\t%cond = icmp eq i32 %r1, 0\n" +
                "\tbr i1 %cond, label %Case0, label %Case1\n" +
                "\tCase0:\n" +
                "\tret i32 1\n" +
                "\tCase1:\n" +
                "\tret i32 0\n" +
                "}\n" +
                "\n" +
                "define i32 @igual(i32 %num1_arg, i32 %num2_arg) {\n" +
                "\t;Crear espacio para las variables\n" +
                "\t%num1 = alloca i32\n" +
                "\t%num2 = alloca i32\n" +
                "\t;Copiar parametros en variables locales\n" +
                "\tstore i32 %num1_arg, i32* %num1\n" +
                "\tstore i32 %num2_arg, i32* %num2\n" +
                "\t;Se cargan las variables\n" +
                "\t%r1 = load i32* %num1\n" +
                "\t%r2 = load i32* %num2\n" +
                "\t%cond = icmp eq i32 %r1, %r2\n" +
                "\tbr i1 %cond, label %Case0, label %Case1\n" +
                "\tCase0:\n" +
                "\tret i32 1\n" +
                "\tCase1:\n" +
                "\tret i32 0\n" +
                "}\n" +
                "\n" +
                "define i32 @distinto(i32 %num1_arg, i32 %num2_arg) {\n" +
                "\t;Crear espacio para las variables\n" +
                "\t%num1 = alloca i32\n" +
                "\t%num2 = alloca i32\n" +
                "\t;Copiar parametros en variables locales\n" +
                "\tstore i32 %num1_arg, i32* %num1\n" +
                "\tstore i32 %num2_arg, i32* %num2\n" +
                "\t;Se cargan las variables\n" +
                "\t%r1 = load i32* %num1\n" +
                "\t%r2 = load i32* %num2\n" +
                "\t%cond = icmp ne i32 %r1, %r2\n" +
                "\tbr i1 %cond, label %Case0, label %Case1\n" +
                "\tCase0:\n" +
                "\tret i32 1\n" +
                "\tCase1:\n" +
                "\tret i32 0\n" +
                "}\n" +
                "\n" +
                "define i32 @mayor(i32 %num1_arg, i32 %num2_arg) {\n" +
                "\t;Crear espacio para las variables\n" +
                "\t%num1 = alloca i32\n" +
                "\t%num2 = alloca i32\n" +
                "\t;Copiar parametros en variables locales\n" +
                "\tstore i32 %num1_arg, i32* %num1\n" +
                "\tstore i32 %num2_arg, i32* %num2\n" +
                "\t;Se cargan las variables\n" +
                "\t%r1 = load i32* %num1\n" +
                "\t%r2 = load i32* %num2\n" +
                "\t%cond = icmp sgt i32 %r1, %r2\n" +
                "\tbr i1 %cond, label %Case0, label %Case1\n" +
                "\tCase0:\n" +
                "\tret i32 1\n" +
                "\tCase1:\n" +
                "\tret i32 0\n" +
                "}\n" +
                "\n" +
                "define i32 @mayorIgual(i32 %num1_arg, i32 %num2_arg) {\n" +
                "\t;Crear espacio para las variables\n" +
                "\t%num1 = alloca i32\n" +
                "\t%num2 = alloca i32\n" +
                "\t;Copiar parametros en variables locales\n" +
                "\tstore i32 %num1_arg, i32* %num1\n" +
                "\tstore i32 %num2_arg, i32* %num2\n" +
                "\t;Se cargan las variables\n" +
                "\t%r1 = load i32* %num1\n" +
                "\t%r2 = load i32* %num2\n" +
                "\t%cond = icmp sge i32 %r1, %r2\n" +
                "\tbr i1 %cond, label %Case0, label %Case1\n" +
                "\tCase0:\n" +
                "\tret i32 1\n" +
                "\tCase1:\n" +
                "\tret i32 0\n" +
                "}\n" +
                "\n" +
                "define i32 @menor(i32 %num1_arg, i32 %num2_arg) {\n" +
                "\t;Crear espacio para las variables\n" +
                "\t%num1 = alloca i32\n" +
                "\t%num2 = alloca i32\n" +
                "\t;Copiar parametros en variables locales\n" +
                "\tstore i32 %num1_arg, i32* %num1\n" +
                "\tstore i32 %num2_arg, i32* %num2\n" +
                "\t;Se cargan las variables\n" +
                "\t%r1 = load i32* %num1\n" +
                "\t%r2 = load i32* %num2\n" +
                "\t%cond = icmp slt i32 %r1, %r2\n" +
                "\tbr i1 %cond, label %Case0, label %Case1\n" +
                "\tCase0:\n" +
                "\tret i32 1\n" +
                "\tCase1:\n" +
                "\tret i32 0\n" +
                "}\n" +
                "\n" +
                "define i32 @menorIgual(i32 %num1_arg, i32 %num2_arg) {\n" +
                "\t;Crear espacio para las variables\n" +
                "\t%num1 = alloca i32\n" +
                "\t%num2 = alloca i32\n" +
                "\t;Copiar parametros en variables locales\n" +
                "\tstore i32 %num1_arg, i32* %num1\n" +
                "\tstore i32 %num2_arg, i32* %num2\n" +
                "\t;Se cargan las variables\n" +
                "\t%r1 = load i32* %num1\n" +
                "\t%r2 = load i32* %num2\n" +
                "\t%cond = icmp sle i32 %r1, %r2\n" +
                "\tbr i1 %cond, label %Case0, label %Case1\n" +
                "\tCase0:\n" +
                "\tret i32 1\n" +
                "\tCase1:\n" +
                "\tret i32 0\n" +
                "}\n" +
                "\n" +
                "define i32 @if(i32 %cond_arg, i32 %num1_arg, i32 %num2_arg) {\n" +
                "\t;Crear espacio para las variables\n" +
                "\t%cond = alloca i32\n" +
                "\t%num1 = alloca i32\n" +
                "\t%num2 = alloca i32\n" +
                "\t;Copiar parametros en variables locales\n" +
                "\tstore i32 %cond_arg, i32* %cond\n" +
                "\tstore i32 %num1_arg, i32* %num1\n" +
                "\tstore i32 %num2_arg, i32* %num2\n" +
                "\t;Se cargan las variables\n" +
                "\t%rcond = load i32* %cond\n" +
                "\t%r1 = load i32* %num1\n" +
                "\t%r2 = load i32* %num2\t\n" +
                "\t%ncond = icmp eq i32 %rcond, 1\n" +
                "\tbr i1 %ncond, label %Case0, label %Case1\n" +
                "\tCase0:\n" +
                "\tret i32 %r1\n" +
                "\tCase1:\n" +
                "\tret i32 %r2\n" +
                "}\n";
        escritor.println(template);
    }

    public void generarHijos(List<AST> nodos) throws Exception {
        int numNodos = nodos.size();
        for(int i = 0; i < numNodos; i++){
            generar(nodos.get(i));
        }
    }

    public void generar(AST nodoAST) throws Exception {
        String nombreNodo = nodoAST.getPadre().getNombre();
        String valorNodo = nodoAST.getPadre().getValor();
        String tipoNodo = nodoAST.getPadre().getTipo();
        List<AST> hijos = nodoAST.getHijos();
        int numHijos = hijos.size();
        if(numHijos > 0){
            switch (nombreNodo){
                case "ConstDeclare":
                    break;
                case "FuncDeclare":
                    escritor.print("define i32 @" + hijos.get(0).getPadre().getValor() + "(");
                    List<AST> params = hijos.get(1).getHijos();
                    for(int i = 0; i < params.size(); i++){
                        escritor.print("i32 " + "%" + params.get(i).getPadre().getValor());
                        if((i + 1) < params.size()){
                            escritor.print(", ");
                        }
                    }
                    escritor.println(") {");
                    generarFunciones(hijos.get(3));
                    escritor.println("\tret i32 " + ("%r" + (registro - 1)));
                    escritor.println("}\n");
                    break;
                case "FuncCall":
                    if(valorNodo.equals("main")){
                        escritor.println("define i32 @main() {");
                        escritor.println("\t%num = getelementptr [4 x i8]* @tempNum, i64 0, i64 0");
                        generarFunciones(nodoAST.getHijos().get(0).getHijos().get(0));
                        escritor.println("\tcall i32 (i8*, ...)* @printf(i8* %num, i32 %r"+ (registro - 1) +")");
                        escritor.println("\tret i32 0");
                        escritor.println("}");
                    }
                    break;
            }
            generarHijos(hijos);
        }
    }

    private boolean verificarHijoLiteral(AST hijo){
        boolean res = false;
        if(hijo.getPadre().getNombre().equals("LiteralEntero") || hijo.getPadre().getNombre().equals("LiteralBool") || hijo.getPadre().getNombre().equals("ID")){
            res = true;
        }
        return res;
    }

    private boolean isNumber(String linea){
        if(Character.isDigit(linea.charAt(0))){
            return true;
        }
        else {
            return false;
        }
    }

    private void escribirOperacionAritmetica(String simbolo, String valor1, String valor2){
        if(simbolo.equals("-")) {
            escritor.println("\t%r" + registro + " = call i32(i32, i32)* @resta(i32 " + valor1 +", i32 " + valor2 + ")");
        }
        else if(simbolo.equals("+")){
            escritor.println("\t%r" + registro + " = call i32(i32, i32)* @suma(i32 " + valor1 +", i32 " + valor2 + ")");
        }
        else if(simbolo.equals("*")){
            escritor.println("\t%r" + registro + " = call i32(i32, i32)* @mult(i32 " + valor1 +", i32 " + valor2 + ")");
        }
        else if(simbolo.equals("/")){
            escritor.println("\t%r" + registro + " = call i32(i32, i32)* @div(i32 " + valor1 +", i32 " + valor2 + ")");
        }
        else if(simbolo.equals("%")){
            escritor.println("\t%r" + registro + " = call i32(i32, i32)* @modulo(i32 " + valor1 +", i32 " + valor2 + ")");
        }
        registro++;
    }

    private void escribirOperacionRelacional(String simbolo, String valor1, String valor2){
        if(simbolo.equals(">")) {
            escritor.println("\t%r" + registro + " = call i32(i32, i32)* @mayor(i32 " + valor1 +", i32 " + valor2 + ")");
        }
        else if(simbolo.equals("<")){
            escritor.println("\t%r" + registro + " = call i32(i32, i32)* @menor(i32 " + valor1 +", i32 " + valor2 + ")");
        }
        else if(simbolo.equals(">=")){
            escritor.println("\t%r" + registro + " = call i32(i32, i32)* @mayorIgual(i32 " + valor1 +", i32 " + valor2 + ")");
        }
        else if(simbolo.equals("<=")){
            escritor.println("\t%r" + registro + " = call i32(i32, i32)* @menorIgual(i32 " + valor1 +", i32 " + valor2 + ")");
        }
        else if(simbolo.equals("==")){
            escritor.println("\t%r" + registro + " = call i32(i32, i32)* @igual(i32 " + valor1 +", i32 " + valor2 + ")");
        }
        else if(simbolo.equals("!=")){
            escritor.println("\t%r" + registro + " = call i32(i32, i32)* @distinto(i32 " + valor1 +", i32 " + valor2 + ")");
        }
        registro++;
    }

    private void escribirOperacionLogica1(String simbolo, String valor1){
        if(simbolo.equals("not")) {
            escritor.println("\t%r" + registro + " = call i32(i32)* @not(i32 " + valor1 + ")");
        }
        registro++;
    }

    private void escribirOperacionLogica2(String simbolo, String valor1, String valor2){
        if(simbolo.equals("and")) {
            escritor.println("\t%r" + registro + " = call i32(i32, i32)* @and(i32 " + valor1 +", i32 " + valor2 + ")");
        }
        else if(simbolo.equals("or")) {
            escritor.println("\t%r" + registro + " = call i32(i32, i32)* @or(i32 " + valor1 +", i32 " + valor2 + ")");
        }
        registro++;
    }

    private void escribirOperacionLogica3(String simbolo, String valor1, String valor2, String valor3){
        if(simbolo.equals("if")) {
            escritor.println("\t%r" + registro + " = call i32(i32, i32, i32)* @if(i32 " + valor1 +", i32 " + valor2 + ", i32 " + valor3 +")");
        }
        registro++;
    }

    private void generarFunciones(AST nodoAST) throws Exception {
        AST puntoInicio = nodoAST;
        if(puntoInicio.getPadre().getNombre().equals("ExprAritmetica")){
            List<AST> hijoExpr = puntoInicio.getHijos();
            AST hijo1 = hijoExpr.get(0);
            AST hijo2 = hijoExpr.get(1);
            String simbolo = puntoInicio.getPadre().getValor();
            if(verificarHijoLiteral(hijo1) && verificarHijoLiteral(hijo2)){
                String valor1 = hijo1.getPadre().getValor();
                String valor2 = hijo2.getPadre().getValor();
                escribirOperacionAritmetica(simbolo, (isNumber(valor1))?(valor1):("%" + valor1), (isNumber(valor2))?(valor2):("%" + valor2));
            }
            else if(verificarHijoLiteral(hijo1) == false && verificarHijoLiteral(hijo2) == false){
                generarFunciones(hijo1);
                generarFunciones(hijo2);
                escribirOperacionAritmetica(simbolo, ("%r" + (registro - 2)), ("%r" + (registro - 1)));
            }
            else if(verificarHijoLiteral(hijo1) == false){
                generarFunciones(hijo1);
                String valor2 = hijo2.getPadre().getValor();
                escribirOperacionAritmetica(simbolo, ("%r" + (registro - 1)), (isNumber(valor2))?(valor2):("%" + valor2));
            }
            else{
                generarFunciones(hijo2);
                String valor1 = hijo1.getPadre().getValor();
                escribirOperacionAritmetica(simbolo, (isNumber(valor1))?(valor1):("%" + valor1), ("%r" + (registro - 1)));
            }

        }
        else if(puntoInicio.getPadre().getNombre().equals("ExprLogica")){
            List<AST> hijoExpr = puntoInicio.getHijos();
            String simbolo = puntoInicio.getPadre().getValor();
            int numHijos = hijoExpr.size();
            if(numHijos == 3){
                AST hijo1 = hijoExpr.get(0);
                AST hijo2 = hijoExpr.get(1);
                AST hijo3 = hijoExpr.get(2);
                if(verificarHijoLiteral(hijo1) && verificarHijoLiteral(hijo2) && verificarHijoLiteral(hijo3)){
                    String valor1 = hijo1.getPadre().getValor();
                    String valor2 = hijo2.getPadre().getValor();
                    String valor3 = hijo3.getPadre().getValor();
                    escribirOperacionLogica3(simbolo, (isNumber(valor1))?(valor1):("%" + valor1), (isNumber(valor2))?(valor2):("%" + valor2), (isNumber(valor3))?(valor3):("%" + valor3));
                }
                else if(verificarHijoLiteral(hijo1) && verificarHijoLiteral(hijo2) && (verificarHijoLiteral(hijo3) == false)){
                    generarFunciones(hijo3);
                    String valor1 = hijo1.getPadre().getValor();
                    String valor2 = hijo2.getPadre().getValor();
                    escribirOperacionLogica3(simbolo, (isNumber(valor1))?(valor1):("%" + valor1), (isNumber(valor2))?(valor2):("%" + valor2), ("%r" + (registro - 1)));
                }
                else if(verificarHijoLiteral(hijo1) && (verificarHijoLiteral(hijo2) == false) && (verificarHijoLiteral(hijo3) == false)){
                    generarFunciones(hijo2);
                    generarFunciones(hijo3);
                    String valor1 = hijo1.getPadre().getValor();
                    escribirOperacionLogica3(simbolo, (isNumber(valor1))?(valor1):("%" + valor1), ("%r" + (registro - 2)), ("%r" + (registro - 1)));
                }
                else if((verificarHijoLiteral(hijo1) == false) && (verificarHijoLiteral(hijo2) == false) && (verificarHijoLiteral(hijo3) == false)){
                    generarFunciones(hijo1);
                    generarFunciones(hijo2);
                    generarFunciones(hijo3);
                    escribirOperacionLogica3(simbolo, ("%r" + (registro - 3)), ("%r" + (registro - 2)), ("%r" + (registro - 1)));
                }
                else if(verificarHijoLiteral(hijo1) && (verificarHijoLiteral(hijo2) == false) && verificarHijoLiteral(hijo3)){
                    generarFunciones(hijo2);
                    String valor1 = hijo1.getPadre().getValor();
                    String valor3 = hijo3.getPadre().getValor();
                    escribirOperacionLogica3(simbolo, (isNumber(valor1))?(valor1):("%" + valor1), ("%r" + (registro - 1)), (isNumber(valor3))?(valor3):("%" + valor3));
                }
                else if((verificarHijoLiteral(hijo1) == false) && (verificarHijoLiteral(hijo2) == false) && verificarHijoLiteral(hijo3)){
                    generarFunciones(hijo1);
                    generarFunciones(hijo2);
                    String valor3 = hijo3.getPadre().getValor();
                    escribirOperacionLogica3(simbolo, ("%r" + (registro - 2)), ("%r" + (registro - 1)), (isNumber(valor3))?(valor3):("%" + valor3));
                }
                else if((verificarHijoLiteral(hijo1) == false) && verificarHijoLiteral(hijo2) && verificarHijoLiteral(hijo3)){
                    generarFunciones(hijo1);
                    String valor2 = hijo2.getPadre().getValor();
                    String valor3 = hijo3.getPadre().getValor();
                    escribirOperacionLogica3(simbolo, ("%r" + (registro - 1)), (isNumber(valor2))?(valor2):("%" + valor2), (isNumber(valor3))?(valor3):("%" + valor3));
                }
            }
            else if(numHijos == 2){
                AST hijo1 = hijoExpr.get(0);
                AST hijo2 = hijoExpr.get(1);
                if(verificarHijoLiteral(hijo1) && verificarHijoLiteral(hijo2)){
                    String valor1 = hijo1.getPadre().getValor();
                    String valor2 = hijo2.getPadre().getValor();
                    escribirOperacionLogica2(simbolo, (isNumber(valor1))?(valor1):("%" + valor1), (isNumber(valor2))?(valor2):("%" + valor2));
                }
                else if(verificarHijoLiteral(hijo1) == false && verificarHijoLiteral(hijo2) == false){
                    generarFunciones(hijo1);
                    generarFunciones(hijo2);
                    escribirOperacionLogica2(simbolo, ("%r" + (registro - 2)), ("%r" + (registro - 1)));
                }
                else if(verificarHijoLiteral(hijo1) == false){
                    generarFunciones(hijo1);
                    String valor2 = hijo2.getPadre().getValor();
                    escribirOperacionLogica2(simbolo, ("%r" + (registro - 1)), (isNumber(valor2))?(valor2):("%" + valor2));
                }
                else{
                    generarFunciones(hijo2);
                    String valor1 = hijo1.getPadre().getValor();
                    escribirOperacionLogica2(simbolo, (isNumber(valor1))?(valor1):("%" + valor1), ("%r" + (registro - 1)));
                }
            }
            else{
                AST hijo1 = hijoExpr.get(0);
                if(verificarHijoLiteral(hijo1)){
                    String valor1 = hijo1.getPadre().getValor();
                    escribirOperacionLogica1(simbolo, (isNumber(valor1))?(valor1):("%" + valor1));
                }
                else{
                    generarFunciones(hijo1);
                    escribirOperacionLogica1(simbolo, ("%r" + (registro - 1)));
                }
            }
        }
        else if(puntoInicio.getPadre().getNombre().equals("ExprRelacional")) {
            List<AST> hijoExpr = puntoInicio.getHijos();
            AST hijo1 = hijoExpr.get(0);
            AST hijo2 = hijoExpr.get(1);
            String simbolo = puntoInicio.getPadre().getValor();
            if(verificarHijoLiteral(hijo1) && verificarHijoLiteral(hijo2)){
                String valor1 = hijo1.getPadre().getValor();
                String valor2 = hijo2.getPadre().getValor();
                escribirOperacionAritmetica(simbolo, (isNumber(valor1))?(valor1):("%" + valor1), (isNumber(valor2))?(valor2):("%" + valor2));
            }
            else if(verificarHijoLiteral(hijo1) == false && verificarHijoLiteral(hijo2) == false){
                generarFunciones(hijo1);
                generarFunciones(hijo2);
                escribirOperacionRelacional(simbolo, ("%r" + (registro - 2)), ("%r" + (registro - 1)));
            }
            else if(verificarHijoLiteral(hijo1) == false){
                generarFunciones(hijo1);
                String valor2 = hijo2.getPadre().getValor();
                escribirOperacionRelacional(simbolo, ("%r" + (registro - 1)), (isNumber(valor2))?(valor2):("%" + valor2));
            }
            else{
                generarFunciones(hijo2);
                String valor1 = hijo1.getPadre().getValor();
                escribirOperacionRelacional(simbolo, (isNumber(valor1))?(valor1):("%" + valor1), ("%r" + (registro - 1)));
            }
        }
        else if(puntoInicio.getPadre().getNombre().equals("ExprPropia")){
            List<AST> hijoExpr = puntoInicio.getHijos();
            List<AST> hijosNoLiterales = filtrarHijosNoLiterales(hijoExpr);
            int numNoLiterales = hijosNoLiterales.size();
            for(int i = 0; i < numNoLiterales; i++){
                generarFunciones(hijosNoLiterales.get(i));
            }
            escritor.print("\t%r" + registro + " = call i32(");
            int numHijos = hijoExpr.size();
            for(int i = 0; i < numHijos; i++){
                escritor.print("i32");
                if((i + 1) < numHijos){
                    escritor.print(", ");
                }
            }
            escritor.print(")* @" + puntoInicio.getPadre().getValor() + "(");
            int registroTemp = registro - 1;
            for(int i = 0; i < numHijos; i++) {
                escritor.print("i32 ");
                if(hijosNoLiterales.contains(hijoExpr.get(i))){
                    escritor.print("%r" + registroTemp);
                    registroTemp--;
                }
                else{
                    escritor.print(hijoExpr.get(i).getPadre().getValor());
                }
                if((i + 1) < numHijos){
                    escritor.print(", ");
                }
            }
            escritor.println(")");
            registro++;
        }
        else if(puntoInicio.getPadre().getNombre().equals("FuncCall")){
            generarFunciones(puntoInicio.getHijos().get(0));
        }
    }

    private List<AST> filtrarHijosNoLiterales(List<AST> hijos){
        List<AST> filtrados = new ArrayList<AST>();
        for(int i = 0; i < hijos.size(); i++){
            if(verificarHijoLiteral(hijos.get(i)) == false){
                filtrados.add(hijos.get(i));
            }
        }
        return filtrados;
    }

    public void close() throws IOException {
        archivo.close();
        escritor.close();
    }
}
