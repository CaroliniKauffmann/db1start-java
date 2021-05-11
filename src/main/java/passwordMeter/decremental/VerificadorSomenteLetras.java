package passwordMeter.decremental;

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
        score = obterContagem();
    }

    @Override
    public long obterContagem() {
        String regexNumerosESimbolos = "([^A-Za-z])";
        Pattern padrao = Pattern.compile(regexNumerosESimbolos);
        Matcher comparador = padrao.matcher(senha);
        long count = comparador.results().count();

        if (count >  0) {
            return 0;
        }
        return senha.length();
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.DECREMENTADOR;
    }
}
