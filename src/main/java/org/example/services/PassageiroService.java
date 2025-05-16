package org.example.services;

import java.util.regex.Pattern;

public class PassageiroService {
    public int soma;
    public int digitoVerificador;

    public boolean validarCpf(String cpf) {
        cpf = cpf.replaceAll("\\D", "");
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) return false;

        soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        digitoVerificador = 11 - (soma % 11);
        digitoVerificador = digitoVerificador >= 10 ? 0 : digitoVerificador;
        if (digitoVerificador != cpf.charAt(9) - '0') return false;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        int dig2 = 11 - (soma % 11);
        dig2 = dig2 >= 10 ? 0 : dig2;
        return dig2 == cpf.charAt(10) - '0';
    }

    public boolean validarEmail(String email) {
        String padraoEmail = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$";
        return Pattern.matches(padraoEmail, email);
    }
}
