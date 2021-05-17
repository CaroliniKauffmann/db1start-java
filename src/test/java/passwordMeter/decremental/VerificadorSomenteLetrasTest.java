package passwordMeter.decremental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerificadorSomenteLetrasTest {

    VerificadorSomenteLetras verificadorSomenteLetras;

    @BeforeEach
    void setUp() {
        verificadorSomenteLetras = new VerificadorSomenteLetras("c.fdugg");

    }

    @Test
    void verificar() {
        verificadorSomenteLetras.verificar();
        assertEquals(Long.valueOf(0), verificadorSomenteLetras.score);
    }
}