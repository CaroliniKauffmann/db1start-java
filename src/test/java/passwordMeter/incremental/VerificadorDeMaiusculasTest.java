package passwordMeter.incremental;

import org.junit.jupiter.api.Test;
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
        assertEquals(14, verificador.score);
    }
}