package passwordMeter.incremental;

import org.junit.jupiter.api.Test;
import passwordMeter.ResultadoDeAnalise;
import passwordMeter.Verificador;
import passwordMeter.incremental.VerificadorDeMaiusculas;

import static org.junit.jupiter.api.Assertions.*;

class VerificadorDeMaiusculasTest {

    Verificador verificador;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        verificador = new VerificadorDeMaiusculas("Carolini");
    }

    @Test
    void verificar() {
        verificador.verificar();
        ResultadoDeAnalise resultadoDeAnalise = verificador.obterResultadoDeAnalise();
        assertEquals(14, resultadoDeAnalise.getPontos());
    }
}