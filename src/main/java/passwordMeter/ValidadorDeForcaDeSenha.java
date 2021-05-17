package passwordMeter;

import passwordMeter.incremental.*;
import passwordMeter.decremental.*;

import java.util.ArrayList;
import java.util.List;

public class ValidadorDeForcaDeSenha {

    List<Verificador> verificadores = new ArrayList<Verificador>();

    public long getForcaDaSenha() {
        return forcaDaSenha;
    }

    private long forcaDaSenha = 0;
    private String senha;

    public ValidadorDeForcaDeSenha(String senha) {
        this.senha = senha;
    }

    void verificar(){

        //Incrementadores
        verificadores.add(new VerificadorDeQuantidadeDeCaracteres(senha));
        verificadores.add(new VerificadorDeMaiusculas(senha));
        verificadores.add(new VerificadorDeMinusculas(senha));
        verificadores.add(new VerificadorDeNumeros(senha));
        verificadores.add(new VerificadorDeSimbolos(senha));
        verificadores.add(new VerificadorDeNumerosESimbolos(senha));

        //Decrementadores
        verificadores.add(new VerficadorDeSequenciasDeLetras(senha));
        verificadores.add(new VerficadorDeSequenciasDeNumeros(senha));
        verificadores.add(new VerficadorDeSequenciasDeSimbolos(senha));
        verificadores.add(new VerificadorDeCaracteresRepetidos(senha));
        verificadores.add(new VerificadorDeMaiusculasConsecutivas(senha));
        verificadores.add(new VerificadorDeMinusculasConsecutivas(senha));
        verificadores.add(new VerificadorDeNumerosConsecutivos(senha));
        verificadores.add(new VerificadorSomenteLetras(senha));
        verificadores.add(new VerificadorSomenteNumeros(senha));

        forcaDaSenha = verificadores
                .stream()
                .mapToLong(obj -> {
                    obj.verificar();
                    if (obj.obterTipoDeOperacao() == TipoDeOperacao.DECREMENTADOR){
                        return -obj.score;
                    }
                    return obj.score;
                })
                .reduce(0, (subtotal, element) -> subtotal + element);
    }

    public Complexidade obterComplexidade(){
        return Complexidade.obterComplexidade(forcaDaSenha);
    }

    String obterTituloComplexidade(){
        switch (obterComplexidade()) {
            case MUITO_FRACO: return "Muito Fraco";
            case FRACO: return "Fraco";
            case BOM: return "Bom";
            case FORTE: return "Forte";
            case MUITO_FORTE: return "Muito Forte";

        }
        return "Muito Fraco";
    }

    public boolean atendeRequisitos(){

        Verificador verificadorQuantidade = new VerificadorDeQuantidadeDeCaracteres(senha);
        verificadorQuantidade.verificar();

        return verificadorQuantidade.atendeRequisitos() && verificadores
            .stream()
            .filter(verificador -> verificador.atendeRequisitos())
            .count() > 3;
    }
}