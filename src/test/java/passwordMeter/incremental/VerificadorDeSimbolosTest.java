package passwordMeter.incremental;

import org.junit.jupiter.api.Test;
import passwordMeter.ResultadoDeAnalise;
import passwordMeter.Suficiencia;
import passwordMeter.Verificador;
import passwordMeter.incremental.VerificadorDeSimbolos;

import static org.junit.jupiter.api.Assertions.*;

class VerificadorDeSimbolosTest {

    Verificador verificador;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        verificador = new VerificadorDeSimbolos("M&%rl0s");
    }

    @Test
    void verificar() {
        verificador.verificar();
        ResultadoDeAnalise resultadoDeAnalise = verificador.obterResultadoDeAnalise();
        assertEquals(12, resultadoDeAnalise.getPontos());
        assertEquals(Suficiencia.SUFICIENTE, resultadoDeAnalise.getSuficiencia());
    }
}