package br.uel.bd1.dadosparlamentares.util;

import org.junit.jupiter.api.Test;

public class FormatHandlersTest {
    @Test
    public void test() {
        System.out.println(FormatHandlers.formatCpfCnpj(12345678910L));
        System.out.println(FormatHandlers.formatCpfCnpj(123455678910L));
        System.out.println(FormatHandlers.formatCpfCnpj(1234556789101L));
    }
}
