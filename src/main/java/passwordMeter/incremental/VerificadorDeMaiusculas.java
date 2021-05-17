package passwordMeter.incremental;

import passwordMeter.ComparadorRegex;
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
        if (scoreFoiCalculado()) {
            return;
        }

        long count = obterContagem();
        score = (senha.length() - count) * 2;
    }

    public long obterContagem() {
        String regexMaiuscula = "([A-Z])";
        ComparadorRegex comparadorRegex = new ComparadorRegex(regexMaiuscula, senha);
        return comparadorRegex.obterContagem();
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.INCREMENTADOR;
    }
}
