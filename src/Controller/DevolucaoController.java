package Controller;

import Exceptions.EmprestimoNaoEncontradoException;
import Exceptions.ItemJaDevolvidoException;
import Model.Emprestimo;
import Model.EmprestimoDao;
import Model.Usuario;
import View.PainelDevolucao;
import Model.DevolucaoDao

import javax.swing.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DevolucaoController {
    private DevolucaoDao dao;
    private PainelDevolucao view;
    private MultaController multacontrol;
    private Emprestimo emprestimo;

    public DevolucaoController(DevolucaoDao dao, PainelDevolucao view, MultaController multacontrol) {
        this.dao = dao;
        this.view = view;
        this.multacontrol = multacontrol;
        this.emprestimo = null;
    }



    //variaveis da função

    private LocalDate dataAtual = LocalDate.now();


    private EmprestimoController grupo4;
    private ReservaController grupo6;





    public void finalizarEmprestimo(int IdItem){
        //bloco if e else pra uma variavel no view se foi confirmado devolução ou não
        emprestimo.setStatusDevolvido(true);
        //else
        emprestimo.setStatusDevolvido(false);
    }
    public void realizarDevolucao(int idItem) {
        int id;
        double valordamulta = 0;
        int diasAtraso = 0;

        Emprestimo emprestimo= emprestimo.buscarPorId(id);

        if (emprestimo == null) {
            JOptionPane.showMessageDialog(null,"Emprestimo não encontrado");
        } else{
            //função muda status do emprestimo
            emprestimo.setStatusDevolvido(true);
            Usuario usuario = emprestimo.getUsuario();
            valordamulta = multacontrol.gerarMulta(usuario, diasAtraso);
            view.msg("Valor da Multa: " + valordamulta + "R$");
        }
    }

}