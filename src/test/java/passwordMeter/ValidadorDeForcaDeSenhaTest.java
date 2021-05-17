package passwordMeter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorDeForcaDeSenhaTest {

    ValidadorDeForcaDeSenha validadorDeForcaDeSenha;

    @BeforeEach
    void setUp() {
        validadorDeForcaDeSenha = new ValidadorDeForcaDeSenha("Ca$b239");
    }

    @Test
    void verificar() {
        validadorDeForcaDeSenha.verificar();
        assertEquals(72, validadorDeForcaDeSenha.getForcaDaSenha());
        assertEquals(Complexidade.FORTE, validadorDeForcaDeSenha.obterComplexidade());
        assertTrue(!validadorDeForcaDeSenha.atendeRequisitos());

    }

}