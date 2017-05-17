import java.util.List;

/**
 * Created by jordan on 07/11/15.
 */
public abstract class Declaration {

    String tipo;
    String retorno;
    int numParams;
    List<String> tiposFuncion;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public int getNumParams() {
        return numParams;
    }

    public void setNumParams(int numParams) {
        this.numParams = numParams;
    }

    public List<String> getTiposFuncion() {
        return tiposFuncion;
    }

    public void setTiposFuncion(List<String> tiposFuncion) {
        this.tiposFuncion = tiposFuncion;
    }
}
