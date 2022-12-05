package br.uel.bd1.dadosparlamentares.util;

public class FormatHandlers {
    public static String formatCpf(Long value) {
        if(value == null) {
            throw new IllegalArgumentException("Valor a ser formatado deve ser não nulo");
        }

        char[] cpf = "000.000.000-00".toCharArray();
        String n = value.toString();

        int[] indexes = {0, 1, 2, 4, 5, 6, 8, 9, 10, 12, 13};
        for(int i = n.length() - 1, j = indexes.length - 1;
            i >= 0 && j >= 0; i--, j--) {
            cpf[indexes[j]] = n.charAt(i);
        }

        return new String(cpf);
    }

    public static String formatCnpj(Long value) {
        if(value == null) {
            throw new IllegalArgumentException("Valor a ser formatado deve ser não nulo");
        }

        char[] cpf = "00.000.000/0000-00".toCharArray();
        String n = value.toString();

        int[] indexes = {0, 1, 3, 4, 5, 7, 8, 9, 11, 12, 13, 14, 16, 17};
        for(int i = n.length() - 1, j = indexes.length - 1;
            i >= 0 && j >= 0; i--, j--) {
            cpf[indexes[j]] = n.charAt(i);
        }

        return new String(cpf);
    }

    public static String formatCpfCnpj(Long value) {
        if(value > 99999999999L){
            return formatCnpj(value);
        }
        else {
            return formatCpf(value);
        }
    }
}
