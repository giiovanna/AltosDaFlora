package br.com.giovanna.trabalhoFinalGiovannaFranco.apresentacao;

import br.com.giovanna.trabalhoFinalGiovannaFranco.controle.AcomodacaoDAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.controle.EntradaDAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.controle.FuncionarioDAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.controle.HospedeDAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Acomodacao;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Acompanhante;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Entrada;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Funcionario;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Hospede;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FormEntrada extends javax.swing.JFrame {

    private List<Acompanhante> acompanhantes;
    private int adulto;
    private int crianca;

    public FormEntrada() {
        initComponents();
        carregarAcomodacao();
        carregarFuncionario();
        carregarHospede();
        acompanhantes = new ArrayList<>();
        adulto = 1;
        crianca = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jdcDataChegada = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jdcDataSaida = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcbAcomodacao = new javax.swing.JComboBox();
        jcbFuncionario = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jcbHospede = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnAdicionarAcompanhante = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        btnExcluirAcompanhante = new javax.swing.JButton();
        btnAlterarInformacoesAcompanhante = new javax.swing.JButton();
        btnInserir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel2.setText("Código:");

        jtfCodigo.setEditable(false);

        jLabel3.setText("Data de chegada:");

        jLabel4.setText("Data de saída:");

        jLabel5.setText("Acomodação:");

        jLabel6.setText("Funcionário:");

        jcbAcomodacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        jcbFuncionario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do hóspede"));

        jcbHospede.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        jLabel1.setText("Hóspede:");

        btnAdicionarAcompanhante.setText("Adicionar acompanhante");
        btnAdicionarAcompanhante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarAcompanhanteActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel7.setText("Acompanhantes");

        btnExcluirAcompanhante.setText("Excluir acompanhante");

        btnAlterarInformacoesAcompanhante.setText("Alterar informações");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbHospede, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdicionarAcompanhante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExcluirAcompanhante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAlterarInformacoesAcompanhante, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbHospede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdicionarAcompanhante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAlterarInformacoesAcompanhante)
                        .addGap(8, 8, 8)
                        .addComponent(btnExcluirAcompanhante)))
                .addContainerGap())
        );

        btnInserir.setText("Inserir Entrada");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        btnAlterar.setText("Alterar");

        btnExcluir.setText("Excluir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jdcDataChegada, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                    .addComponent(jcbAcomodacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jdcDataSaida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addGap(102, 102, 102)
                        .addComponent(btnInserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addComponent(jdcDataChegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jdcDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jcbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jcbAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnInserir)
                    .addComponent(btnCancelar)
                    .addComponent(btnExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        cadastrar();
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnAdicionarAcompanhanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarAcompanhanteActionPerformed
        FormAcompanhante fa = new FormAcompanhante(this);
        fa.setVisible(true);
    }//GEN-LAST:event_btnAdicionarAcompanhanteActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormEntrada().setVisible(true);
            }
        });
    }

    private void cadastrar() {
        Entrada et = new Entrada();

        Acomodacao a = (Acomodacao) jcbAcomodacao.getSelectedItem();
        
        a.setDisponivel(false);
        
        Funcionario f = (Funcionario) jcbFuncionario.getSelectedItem();
        Hospede h = (Hospede) jcbHospede.getSelectedItem();

        et.setDataChegada(jdcDataChegada.getDate());
        et.setDataSaida(jdcDataSaida.getDate());
        et.setAcomodacao(a);
        et.setFuncionario(f);
        et.setHospede(h);
        et.setAcompanhantes(acompanhantes);
        

        try {
            new EntradaDAO().inserir(et);
            JOptionPane.showMessageDialog(this, "Entrada foi inserida!", "SUCESSO", 1);

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Entrada não foi inserida!", "ERRO", 1);
            throw new IllegalArgumentException(e);
        }
    }

    private void carregarAcomodacao() {
        List<Acomodacao> acm = new AcomodacaoDAO().listarTodos();

        jcbAcomodacao.removeAllItems();
        for (Acomodacao a : acm) {
            jcbAcomodacao.addItem(a);
        }
    }

    private void carregarFuncionario() {
        List<Funcionario> func = new FuncionarioDAO().listarTodos();

        jcbFuncionario.removeAllItems();
        for (Funcionario f : func) {
            jcbFuncionario.addItem(f);
        }
    }

    private void carregarHospede() {
        List<Hospede> hospede = new HospedeDAO().listarTodos();

        jcbHospede.removeAllItems();
        for (Hospede h : hospede) {
            jcbHospede.addItem(h);
        }
    }

    public void adicionarAcompanhante(Acompanhante a) {
        verificarAcompanhantes(a);
    }

    private void verificarAcompanhantes(Acompanhante a) {
        Acomodacao acm = (Acomodacao) jcbAcomodacao.getSelectedItem();
        int nroAdulto = acm.getTipoAcomodacao().getNroAdulto();
        int nroCriancas = acm.getTipoAcomodacao().getNroCrianca();

        if (a.getIdade() >= 18) {
            if (adulto >= nroAdulto) {
                JOptionPane.showMessageDialog(this, "Não é possivel inserir mais adultos no quarto! ");
            } else {
                acompanhantes.add(a);
                adulto++;
                JOptionPane.showMessageDialog(this, "Acompanhante do tipo adulto inserido!");
            }
        } else {
            if (crianca >= nroCriancas) {
                JOptionPane.showMessageDialog(this, "Não é possivel inserir mais crianças no quarto! ");

            } else {
                acompanhantes.add(a);
                crianca++;
                JOptionPane.showMessageDialog(this, "Acompanhante do tipo criança inserido!");
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarAcompanhante;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAlterarInformacoesAcompanhante;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnExcluirAcompanhante;
    private javax.swing.JButton btnInserir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JComboBox jcbAcomodacao;
    private javax.swing.JComboBox jcbFuncionario;
    private javax.swing.JComboBox jcbHospede;
    private com.toedter.calendar.JDateChooser jdcDataChegada;
    private com.toedter.calendar.JDateChooser jdcDataSaida;
    private javax.swing.JTextField jtfCodigo;
    // End of variables declaration//GEN-END:variables
}
