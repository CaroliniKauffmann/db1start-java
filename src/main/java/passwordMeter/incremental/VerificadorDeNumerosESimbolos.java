package passwordMeter.incremental;

import passwordMeter.ComparadorRegex;
import passwordMeter.TipoDeOperacao;
import passwordMeter.Verificador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificadorDeNumerosESimbolos extends Verificador {

    public VerificadorDeNumerosESimbolos(String senha) {
        super(senha);
    }

    @Override
    public void verificar() {
        if (scoreFoiCalculado()) {
            return;
        }
        score = obterContagem() * 2;
    }

    @Override
    public long obterContagem() {
        String texto = senha.substring(1, senha.length() - 3);
        String regexNumerosESimbolos = "([^A-Za-z])";
        ComparadorRegex comparadorRegex = new ComparadorRegex(regexNumerosESimbolos, senha);
        return comparadorRegex.obterContagem();
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.INCREMENTADOR;
    }

}
