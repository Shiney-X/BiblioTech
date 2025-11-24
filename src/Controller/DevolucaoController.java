package Controller;

import Exceptions.EmprestimoNaoEncontradoException;
import Exceptions.ItemJaDevolvidoException;
import Model.Emprestimo;
import Model.EmprestimoDao;
import Model.Usuario;
import View.PainelDevolucao;

import javax.swing.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DevolucaoController {
    EmprestimoDao model = new EmprestimoDao();
    PainelDevolucao view = new PainelDevolucao();

    private LocalDate dataAtual = LocalDate.now();
    Emprestimo emprestimo= model.buscarPorId(id);
    private EmprestimoController emprestimocontrol;
    private ReservaController reservacontrol;
    private MultaController multacontroll;

    int id;
    double valordamulta = 0;
    int diasAtraso;



    public void finalizarEmprestimo(int idItem) {
        Emprestimo emprestimo= model.buscarPorId(id);
        if (emprestimo == null) {
            JOptionPane.showMessageDialog(null,"Emprestimo não encontrado");
        } else{
            //função muda status do emprestimo
            emprestimo.setStatusDevolvido(true);

            //função recupera o nome do usuario que fez o emprestimo


            Usuario usuario;
            valordamulta = multacontroll.gerarMulta(usuario, diasAtraso);
            view.msg("valor da multa"+valordamulta, "Multado");
        }
    }
}