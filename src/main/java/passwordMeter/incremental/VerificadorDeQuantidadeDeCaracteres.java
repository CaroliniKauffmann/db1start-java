package passwordMeter.incremental;

import passwordMeter.*;

public class VerificadorDeQuantidadeDeCaracteres extends Verificador {

    public VerificadorDeQuantidadeDeCaracteres(String senha) {
        super(senha);
    }

    @Override
    public void verificar() {
        if (scoreFoiCalculado()) {
            return;
        }
        score = obterContagem() * 4;
    }

    public long obterContagem() {
        return senha.length();
    }

    public ResultadoDeAnalise obterResultadoDeAnalise() {

        Faixa faixa1 = Faixa.of(0, 7, Suficiencia.FALHA);
        Faixa faixa2 = Faixa.of(8, 8, Suficiencia.SUFICIENTE);
        Faixa faixa3 = Faixa.superiorOf(9, Suficiencia.EXCELENTE);

        CalculadorDeSuficiencia calculadorDeSuficiencia = new CalculadorDeSuficiencia();

        int contagem = (int) obterContagem();
        return new ResultadoDeAnalise(
                (int) obterContagem(),
                score.intValue(),
                calculadorDeSuficiencia.calcular((int) obterContagem(), faixa1, faixa2, faixa3),
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
