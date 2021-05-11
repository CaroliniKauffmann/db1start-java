package passwordMeter.incremental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import passwordMeter.incremental.VerificadorDeRequerimentos;

import static org.junit.jupiter.api.Assertions.*;

class VerificadorDeRequerimentosTest {

    VerificadorDeRequerimentos verificadorDeRequerimentos;

    @BeforeEach
    void setUp() {
        verificadorDeRequerimentos = new VerificadorDeRequerimentos("An4lui$4");

    }

    @Test
    void verificar() {
        verificadorDeRequerimentos.verificar();
        assertEquals(10, verificadorDeRequerimentos.score);
    }


}