package passwordMeter.decremental;

import passwordMeter.*;

public class VerficadorDeSequenciasDeSimbolos extends Verificador {

    public VerficadorDeSequenciasDeSimbolos(String senha) {
        super(senha);
    }

    @Override
    public void verificar() {
        if (scoreFoiCalculado()) {
            return;
        }
        score = obterContagem() * 3;

    }

    @Override
    public long obterContagem() {

        int contadorSequenciaDeSimbolos = 0;

        for (int i = 0; i < 8; i++) {
            String SIMBOLOS = ")!@#$%^&*()";
            String sFwd = SIMBOLOS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (senha.toLowerCase().contains(sFwd) || senha.toLowerCase().contains(sRev)) {

                contadorSequenciaDeSimbolos++;
            }
        }
        return contadorSequenciaDeSimbolos;
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
