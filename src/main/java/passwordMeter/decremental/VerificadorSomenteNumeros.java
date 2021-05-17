package passwordMeter.decremental;

import passwordMeter.*;

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

    public ResultadoDeAnalise obterResultadoDeAnalise() {

        Faixa faixa1 = Faixa.superiorOf(1, Suficiencia.FALHA);
        Faixa faixa2 = Faixa.inferiorOf(0, Suficiencia.SUFICIENTE);

        CalculadorDeSuficiencia calculadorDeSuficiencia = new CalculadorDeSuficiencia();

        return new ResultadoDeAnalise(
                (int) obterContagem(),
                score.intValue(),
                calculadorDeSuficiencia.calcular(score.intValue(), faixa1, faixa2),
                obterTipoDeOperacao(),
                TipoRequisito.REQUERIDO);
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.DECREMENTADOR;
    }

    public TipoRequisito obterTipoRequisito(){
        return TipoRequisito.NAO_REQUERIDO;
    }
}
