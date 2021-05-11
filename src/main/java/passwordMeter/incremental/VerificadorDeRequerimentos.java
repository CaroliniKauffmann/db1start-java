package passwordMeter.incremental;

import passwordMeter.TipoDeOperacao;
import passwordMeter.Verificador;

import java.util.ArrayList;
import java.util.List;

public class VerificadorDeRequerimentos extends Verificador {


    private List<Verificador> verificadores = new ArrayList<Verificador>();

    public VerificadorDeRequerimentos(String senha) {
        super(senha);
    }

    @Override
    public void verificar() {

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

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.INCREMENTADOR;
    }
}
