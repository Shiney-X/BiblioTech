package Controller;

import Model.Usuario;

public class MultaController {
    public double gerarMulta(Usuario usuario, int diasAtraso) {
        double valor = diasAtraso * 2.50;
        return valor;
    }
}