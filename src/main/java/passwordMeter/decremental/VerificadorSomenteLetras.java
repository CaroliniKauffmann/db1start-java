package passwordMeter.decremental;

import passwordMeter.ComparadorRegex;
import passwordMeter.TipoDeOperacao;
import passwordMeter.Verificador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificadorSomenteLetras extends Verificador {

    public VerificadorSomenteLetras(String senha) {
        super(senha);
    }

    @Override
    public void verificar() {
        if (scoreFoiCalculado()) {
            return;
        }
        score = obterContagem();
    }

    @Override
    public long obterContagem() {
        String regexLetras = "([^A-Za-z])";
        ComparadorRegex comparadorRegex = new ComparadorRegex(regexLetras, senha);

        if (comparadorRegex.obterContagem() >  0) {
            return 0;
        }
        return senha.length();
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.DECREMENTADOR;
    }
}
