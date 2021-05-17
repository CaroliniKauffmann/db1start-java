package passwordMeter.incremental;

import passwordMeter.*;

import java.util.ArrayList;
import java.util.List;

public class VerificadorDeRequerimentos extends Verificador {


    private List<Verificador> verificadores = new ArrayList<Verificador>();

    public VerificadorDeRequerimentos(String senha) {
        super(senha);
    }

    @Override
    public void verificar() {
        if (scoreFoiCalculado()) {
            return;
        }

        verificadores.add(new VerificadorDeMaiusculas(senha));
        verificadores.add(new VerificadorDeMinusculas(senha));
        verificadores.add(new VerificadorDeNumeros(senha));
        verificadores.add(new VerificadorDeSimbolos(senha));

        score = obterContagem() * 2;
    }

    @Override
    public long obterContagem() {
        long contador = 0;

        Verificador verificadorDeQuantidade = new VerificadorDeQuantidadeDeCaracteres(senha);
        if (verificadorDeQuantidade.obterContagem() >= 8){
            contador = 1;
        }

        contador = contador + verificadores.stream().mapToLong(obj -> obj.obterContagem() > 0 ? 1 : 0)
        .reduce(0, (subtotal, element) -> subtotal + element);

        return contador;
    }

    public ResultadoDeAnalise obterResultadoDeAnalise() {

        Faixa faixa1 = Faixa.of(0, 3, Suficiencia.FALHA);
        Faixa faixa2 = Faixa.of(4, 4, Suficiencia.SUFICIENTE);
        Faixa faixa3 = Faixa.superiorOf(5, Suficiencia.EXCELENTE);

        CalculadorDeSuficiencia calculadorDeSuficiencia = new CalculadorDeSuficiencia();

        return new ResultadoDeAnalise(
                (int) obterContagem(),
                score.intValue(),
                calculadorDeSuficiencia.calcular(score.intValue(), faixa1, faixa2, faixa3),
                obterTipoDeOperacao(),
                TipoRequisito.REQUERIDO);
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.INCREMENTADOR;
    }
}
