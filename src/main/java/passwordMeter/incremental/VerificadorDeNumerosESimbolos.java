package passwordMeter.incremental;

import passwordMeter.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificadorDeNumerosESimbolos extends Verificador {

    public VerificadorDeNumerosESimbolos(String senha) {
        super(senha);
    }

    @Override
    public void verificar() {
        if (scoreFoiCalculado()) {
            return;
        }
        score = obterContagem() * 2;
    }

    @Override
    public long obterContagem() {
        String texto = senha.substring(1, senha.length() - 3);
        String regexNumerosESimbolos = "([^A-Za-z])";
        ComparadorRegex comparadorRegex = new ComparadorRegex(regexNumerosESimbolos, senha);
        return comparadorRegex.obterContagem();
    }

    public ResultadoDeAnalise obterResultadoDeAnalise() {

        Faixa faixa1 = Faixa.inferiorOf(0, Suficiencia.FALHA);
        Faixa faixa2 = Faixa.of(1, 1, Suficiencia.SUFICIENTE);
        Faixa faixa3 = Faixa.superiorOf(2, Suficiencia.EXCELENTE);

        CalculadorDeSuficiencia calculadorDeSuficiencia = new CalculadorDeSuficiencia();

        int contagem = (int) obterContagem();
        return new ResultadoDeAnalise(
                contagem,
                score.intValue(),
                calculadorDeSuficiencia.calcular(contagem, faixa1, faixa2, faixa3),
                obterTipoDeOperacao(),
                TipoRequisito.REQUERIDO);
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.INCREMENTADOR;
    }

}
