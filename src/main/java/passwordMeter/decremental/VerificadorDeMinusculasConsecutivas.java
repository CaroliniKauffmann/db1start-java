package passwordMeter.decremental;

import passwordMeter.*;

public class VerificadorDeMinusculasConsecutivas extends Verificador {

    public VerificadorDeMinusculasConsecutivas(String senha) {
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

        int contadorDeMinusculasConsecutivas = 0;
        Integer nTmpAlphaLC = null;

        String[] arrPwd = senha.replaceAll("\\s+", "").split("\\s*");

        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[a-z]")) {

                if (nTmpAlphaLC != null) {
                    if (nTmpAlphaLC + 1 == i) {
                        contadorDeMinusculasConsecutivas++;
                    }
                }
                nTmpAlphaLC = i;
            }
        }
        return contadorDeMinusculasConsecutivas;
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
}
