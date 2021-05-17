package passwordMeter.incremental;

import passwordMeter.ComparadorRegex;
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
        if (scoreFoiCalculado()) {
            return;
        }

        long count = obterContagem();
        score = count * 4;
    }

    public long obterContagem() {
        String regexNumeros = "([0-9])";
        ComparadorRegex comparadorRegex = new ComparadorRegex(regexNumeros, senha);
        return comparadorRegex.obterContagem();
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.INCREMENTADOR;
    }
}