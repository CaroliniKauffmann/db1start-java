package passwordMeter.decremental;

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
        Pattern padrao = Pattern.compile(regexNumeros);
        Matcher comparador = padrao.matcher(senha);
        long count = comparador.results().count();

        if (count >  0) {
            return 0;
        }
        long length = senha.length();
        return length;
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.DECREMENTADOR;
    }
}
