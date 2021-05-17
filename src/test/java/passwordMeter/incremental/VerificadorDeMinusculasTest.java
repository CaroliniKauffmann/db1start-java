package passwordMeter.incremental;

import org.junit.jupiter.api.Test;
import passwordMeter.ResultadoDeAnalise;
import passwordMeter.Suficiencia;
import passwordMeter.Verificador;
import passwordMeter.incremental.VerificadorDeMinusculas;

import static org.junit.jupiter.api.Assertions.*;

class VerificadorDeMinusculasTest {

    Verificador verificador;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        verificador = new VerificadorDeMinusculas("Carolini");
    }

    @Test
    void verificar() {
        verificador.verificar();
        ResultadoDeAnalise resultadoDeAnalise = verificador.obterResultadoDeAnalise();
        assertEquals(2, resultadoDeAnalise.getPontos());
        assertEquals(Suficiencia.SUFICIENTE, resultadoDeAnalise.getSuficiencia());
    }
}