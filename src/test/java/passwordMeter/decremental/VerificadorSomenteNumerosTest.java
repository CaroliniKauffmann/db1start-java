package passwordMeter.decremental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerificadorSomenteNumerosTest {

    VerificadorSomenteNumeros verificadorSomenteNumeros;

    @BeforeEach
    void setUp() {
        verificadorSomenteNumeros = new VerificadorSomenteNumeros("12345678");

    }

    @Test
    void verificar() {
        verificadorSomenteNumeros.verificar();
        assertEquals(8, verificadorSomenteNumeros.score);
    }
}