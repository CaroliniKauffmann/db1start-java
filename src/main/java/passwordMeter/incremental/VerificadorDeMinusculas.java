package passwordMeter.incremental;

import passwordMeter.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificadorDeMinusculas extends Verificador {

    public VerificadorDeMinusculas(String senha) {
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
        String regexMinuscula = "([a-z])";
        ComparadorRegex comparadorRegex = new ComparadorRegex(regexMinuscula, senha);
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

    public TipoRequisito obterTipoRequisito(){
        return TipoRequisito.REQUERIDO;
    }
}