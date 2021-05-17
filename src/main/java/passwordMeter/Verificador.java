package passwordMeter;

public abstract class Verificador {

    public String senha;
    public Long score;

    public Verificador(String senha){
        this.senha = senha;
    }
    public abstract void verificar();
    public abstract long obterContagem();
    public abstract TipoDeOperacao obterTipoDeOperacao();

    public boolean scoreFoiCalculado(){
        return score != null;
    }

    //public abstract ResultadoDeAnalise obterResultadoDeAnalise();

}


