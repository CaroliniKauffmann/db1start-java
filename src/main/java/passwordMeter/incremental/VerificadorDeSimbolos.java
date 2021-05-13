package passwordMeter.incremental;

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
        Pattern padrao = Pattern.compile(regexSimbolos);
        Matcher comparador = padrao.matcher(senha);
        long count = comparador.results().count();
        return count;
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.INCREMENTADOR;
    }
}
