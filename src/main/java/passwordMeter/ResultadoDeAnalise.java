package passwordMeter;

public class ResultadoDeAnalise {
    private final int contagem;
    private final int pontos;
    private final Suficiencia suficiencia;
    private final TipoDeOperacao tipoResultado;
    private final TipoRequisito requerido;

    public ResultadoDeAnalise(int contagem, int pontos, Suficiencia suficiencia, TipoDeOperacao tipoResultado, TipoRequisito requerido) {
        this.contagem = contagem;
        this.pontos = pontos;
        this.suficiencia = suficiencia;
        this.tipoResultado = tipoResultado;
        this.requerido = requerido;
    }

    public int getContagem() {
        return contagem;
    }

    public int getPontos() {
        return pontos;
    }

    public Suficiencia getSuficiencia() {
        return suficiencia;
    }

    public TipoDeOperacao getTipoResultado() {
        return tipoResultado;
    }

    public TipoRequisito getRequerido() {
        return requerido;
    }

    public boolean ehIncrementador() {
        return getTipoResultado() == TipoDeOperacao.INCREMENTADOR;
    }

    public int obterPontosConformeTipo() {
        return (ehIncrementador() ? 1 : -1) * getPontos();
    }
}
