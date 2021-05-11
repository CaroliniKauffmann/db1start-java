package passwordMeter.incremental;

import org.junit.jupiter.api.Test;
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
        assertEquals(12, verificador.score);
    }
}