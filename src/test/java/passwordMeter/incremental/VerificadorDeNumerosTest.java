package passwordMeter.incremental;

import org.junit.jupiter.api.Test;
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
        assertEquals(8, verificador.score);
    }
}
