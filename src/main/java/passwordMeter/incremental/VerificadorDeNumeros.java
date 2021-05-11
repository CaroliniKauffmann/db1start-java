package passwordMeter.incremental;

import passwordMeter.TipoDeOperacao;
import passwordMeter.Verificador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificadorDeNumeros extends Verificador {

    public VerificadorDeNumeros(String senha) {
        super(senha);
    }

    @Override
    public void verificar() {
        long count = obterContagem();
        score = count * 4;
    }

    public long obterContagem() {
        String regexNumeros = "([0-9])";
        Pattern padrao = Pattern.compile(regexNumeros);
        Matcher comparador = padrao.matcher(senha);
        long count = comparador.results().count();
        return count;
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.INCREMENTADOR;
    }
}