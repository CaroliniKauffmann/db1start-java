package passwordMeter;

public class Faixa {
    int limiteInferior;
    int limiteSuperior;
    Suficiencia suficiencia;

    public Faixa(int limiteInferior, int limiteSuperior, Suficiencia suficiencia) {
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
        this.suficiencia = suficiencia;
    }

    public static Faixa of(int limiteInferior, int limiteSuperior, Suficiencia suficiencia) {
        return new Faixa(limiteInferior, limiteSuperior, suficiencia);
    }

    public static Faixa superiorOf(int limiteInferior, Suficiencia suficiencia) {
        return of(limiteInferior, Integer.MAX_VALUE, suficiencia);
    }

    public static Faixa inferiorOf(int limiteSuperior, Suficiencia suficiencia) {
        return of(Integer.MIN_VALUE, limiteSuperior, suficiencia);
    }

    public int getLimiteInferior() {
        return limiteInferior;
    }

    public int getLimiteSuperior() {
        return limiteSuperior;
    }

    public Suficiencia getSuficiencia() {
        return suficiencia;
    }
}
