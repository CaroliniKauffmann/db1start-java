package passwordMeter.incremental;

import passwordMeter.TipoDeOperacao;
import passwordMeter.Verificador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificadorDeMinusculas extends Verificador {

    public VerificadorDeMinusculas(String senha) {
        super(senha);
    }

    @Override
    public void verificar() {
        if (scoreFoiCalculado()) {
            return;
        }

        long count = obterContagem();
        score = (senha.length() - count) * 2;
    }

    public long obterContagem() {
        String regexMinuscula = "([a-z])";
        Pattern padrao = Pattern.compile(regexMinuscula);
        Matcher comparador = padrao.matcher(senha);
        long count = comparador.results().count();
        return count;
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.INCREMENTADOR;
    }
}