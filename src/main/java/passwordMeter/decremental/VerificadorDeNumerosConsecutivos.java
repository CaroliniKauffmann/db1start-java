package passwordMeter.decremental;

import passwordMeter.*;

public class VerificadorDeNumerosConsecutivos extends Verificador {

    public VerificadorDeNumerosConsecutivos(String senha) {
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

        int contadorDeNumerosConsecutivos = 0;
        Integer nTmpAlphaLC = null;

        String[] arrPwd = senha.replaceAll("\\s+", "").split("\\s*");

        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[0-9]")) {

                if (nTmpAlphaLC != null) {
                    if (nTmpAlphaLC + 1 == i) {
                        contadorDeNumerosConsecutivos++;
                    }
                }
                nTmpAlphaLC = i;
            }
        }
        return contadorDeNumerosConsecutivos;
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