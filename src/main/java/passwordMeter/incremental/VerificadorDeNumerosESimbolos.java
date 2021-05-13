package passwordMeter.incremental;

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
        Pattern padrao = Pattern.compile(regexNumerosESimbolos);
        Matcher comparador = padrao.matcher(texto);
        long count = comparador.results().count();
        return count;
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.INCREMENTADOR;
    }

}
