package passwordMeter.incremental;

import passwordMeter.TipoDeOperacao;
import passwordMeter.Verificador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificadorDeMaiusculas extends Verificador {

    public VerificadorDeMaiusculas(String senha) {
        super(senha);
    }

    @Override
    public void verificar() {

        long count = obterContagem();
        score = (senha.length() - count) * 2;
    }

    public long obterContagem() {
        String regexMaiuscula = "([A-Z])";
        Pattern padrao = Pattern.compile(regexMaiuscula);
        Matcher comparador = padrao.matcher(senha);
        long count = comparador.results().count();
        return count;
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.INCREMENTADOR;
    }
}
