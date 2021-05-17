package passwordMeter.decremental;

import passwordMeter.ComparadorRegex;
import passwordMeter.TipoDeOperacao;
import passwordMeter.Verificador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificadorSomenteNumeros extends Verificador {

    public VerificadorSomenteNumeros(String senha) {
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
        String regexNumeros = "([^0-9])";
        ComparadorRegex comparadorRegex = new ComparadorRegex(regexNumeros, senha);

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
