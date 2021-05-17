package passwordMeter.incremental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import passwordMeter.ResultadoDeAnalise;
import passwordMeter.Suficiencia;
import passwordMeter.incremental.VerificadorDeNumerosESimbolos;

import static org.junit.jupiter.api.Assertions.*;

class VerificadorDeNumerosESimbolosTest {

    VerificadorDeNumerosESimbolos verificadorDeNumerosESimbolos;

    @BeforeEach
    void setUp() {
        verificadorDeNumerosESimbolos = new VerificadorDeNumerosESimbolos("C$5*l1ni");
    }

    @Test
    void contarNumerosESimbolos() {
        assertEquals(4, verificadorDeNumerosESimbolos.obterContagem());
    }

    @Test
    void verificar() {
        verificadorDeNumerosESimbolos.senha = "J$5el*";
        verificadorDeNumerosESimbolos.verificar();
        ResultadoDeAnalise resultadoDeAnalise = verificadorDeNumerosESimbolos.obterResultadoDeAnalise();
        assertEquals(4, resultadoDeAnalise.getPontos());
        assertEquals(Suficiencia.SUFICIENTE, resultadoDeAnalise.getSuficiencia());
    }
}