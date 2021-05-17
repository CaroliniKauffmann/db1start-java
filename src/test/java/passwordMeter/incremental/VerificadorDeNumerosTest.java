package passwordMeter.incremental;

import org.junit.jupiter.api.Test;
import passwordMeter.ResultadoDeAnalise;
import passwordMeter.Suficiencia;
import passwordMeter.Verificador;
import passwordMeter.incremental.VerificadorDeNumeros;

import static org.junit.jupiter.api.Assertions.*;

class VerificadorDeNumerosTest {

    Verificador verificador;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        verificador = new VerificadorDeNumeros("M4rl0s");
    }

    @Test
    void verificar() {
        verificador.verificar();
        ResultadoDeAnalise resultadoDeAnalise = verificador.obterResultadoDeAnalise();
        assertEquals(8, resultadoDeAnalise.getPontos());
        assertEquals(Suficiencia.SUFICIENTE, resultadoDeAnalise.getSuficiencia());
    }
}
