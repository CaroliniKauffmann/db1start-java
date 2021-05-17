package passwordMeter;

public class CalculadorDeSuficiencia {

    public Suficiencia calcular(int valor, Faixa... faixas) {
        for (Faixa faixa : faixas) {
            if (valor >= faixa.getLimiteInferior() && valor <= faixa.getLimiteSuperior())
                return faixa.getSuficiencia();
        }

        throw new IllegalArgumentException("Não há faixa para o valor");
    }
}
