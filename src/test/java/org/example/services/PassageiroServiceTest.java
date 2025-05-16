package org.example.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PassageiroServiceTest {
    private PassageiroService passageiroService;

    @BeforeEach
    public void setup() {
        passageiroService = new PassageiroService();
    }

    // 1. Validar CPF válido
    @Test
    public void testarAceitarCpfValido() {
        boolean resultado = passageiroService.validarCpf("12345678909");
        Assertions.assertTrue(resultado);
    }

    // 2. Recusar CPF inválido
    @Test
    public void testarRecusarCpfInvalido() {
        boolean resultado = passageiroService.validarCpf("111111111a1");
        Assertions.assertFalse(resultado);
    }

    // 3. Validar e-mail válido
    @Test
    public void testarAceitarEmailValido() {
        boolean resultado = passageiroService.validarEmail("exemplo@email.com");
        Assertions.assertTrue(resultado);
    }

    // 4. Recusar e-mail inválido
    @Test
    public void testarRecusarEmailInvalido() {
        boolean resultado = passageiroService.validarEmail("invalido.com");
        Assertions.assertFalse(resultado);
    }
}
