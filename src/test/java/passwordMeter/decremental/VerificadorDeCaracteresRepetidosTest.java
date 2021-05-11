package passwordMeter.decremental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerificadorDeCaracteresRepetidosTest {

    VerificadorDeCaracteresRepetidos verificador;

    @BeforeEach
    void setUp() {
        verificador = new VerificadorDeCaracteresRepetidos("11223344");

    }

    @Test
    void verificar() {
        verificador.verificar();
        assertEquals(21, verificador.score);
    }

}