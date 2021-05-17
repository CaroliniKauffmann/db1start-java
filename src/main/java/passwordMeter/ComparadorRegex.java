package passwordMeter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComparadorRegex {

    public ComparadorRegex(String comparadorRegex, String texto) {
        this.comparadorRegex = comparadorRegex;
        this.texto = texto;
        comparaRegex();
    }

    private String comparadorRegex;
    private String texto;
    private Long contagem;

    public long obterContagem() {
        return contagem;
    }

    public boolean combina() {
        return contagem > 0;
    }

    private void comparaRegex() {

        Pattern padrao = Pattern.compile(comparadorRegex);
        Matcher comparador = padrao.matcher(texto);
        contagem = comparador.results().count();
    }

}
