package passwordMeter.incremental;

import passwordMeter.ComparadorRegex;
import passwordMeter.TipoDeOperacao;
import passwordMeter.Verificador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificadorDeSimbolos extends Verificador {

    public VerificadorDeSimbolos(String senha) {
        super(senha);
    }

    @Override
    public void verificar() {
        if (scoreFoiCalculado()) {
            return;
        }
        long count = obterContagem();
        score = count * 6;
    }

    public long obterContagem() {
        String regexSimbolos = "([^A-Za-z0-9])";
        ComparadorRegex comparadorRegex = new ComparadorRegex(regexSimbolos, senha);
        return comparadorRegex.obterContagem();
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.INCREMENTADOR;
    }
}
