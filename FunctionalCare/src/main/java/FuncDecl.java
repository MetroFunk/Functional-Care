/**
 * Created by jordan on 07/11/15.
 */
public class FuncDecl extends Declaration {

    FuncDecl(String retorno, int numParams){
        tipo = "func";
        this.retorno = retorno;
        this.numParams = numParams;
        this.tiposFuncion = null;
    }

}
