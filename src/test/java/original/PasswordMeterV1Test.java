package original;

import static org.junit.jupiter.api.Assertions.*;

class PasswordMeterV1Test {

    private PasswordMeterV1 passwordMeterV1;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        passwordMeterV1 = new PasswordMeterV1();
    }


    @org.junit.jupiter.api.Test
    void checkPasswordStrong() {
        String senhaForte = "!@#rtyA1265";
        passwordMeterV1.checkPassword(senhaForte);
        assertEquals("Very Strong", passwordMeterV1.sComplexity);
    }

    @org.junit.jupiter.api.Test
    void checkPasswordWeak() {
        String senhaFraca = "12345";
        passwordMeterV1.checkPassword(senhaFraca);
        assertEquals("Very Weak", passwordMeterV1.sComplexity);
    }
}