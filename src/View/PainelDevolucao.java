package View;

import Controller.DevolucaoController;
import Model.Emprestimo;
import Model.Usuario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelDevolucao extends JPanel {

    private JPanel informationPanel;
    private JTextField txtIdItem;
    private JLabel idDevolucao;
    private JLabel usuario;
    private JLabel itemEmprestado;

    private JTextArea areaDetalhes;
    private DevolucaoController controller;
    private JButton btnConfirmar, btnConfirmarDevolucao;

    public PainelDevolucao() {

        informationPanel = new JPanel();
        this.setLayout(new FlowLayout());

        idDevolucao = new JLabel("Id do Item:");

        txtIdItem = new JTextField(15);
        btnConfirmar = new JButton("Confirmar");
        btnConfirmarDevolucao = new JButton("Confirmar devolução");
        this.add(idDevolucao);
        this.add(txtIdItem);
        this.add(btnConfirmar);

        this.setVisible(true);

        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtIdItem.getText());
                    controller.realizarDevolucao(id);
                    txtIdItem.setText(""); // Limpa campo
                    //frame.setVisible(false);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite um número válido.");
                }
            }
        });
    }

    public void msg(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }


}
