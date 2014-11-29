package br.com.giovanna.trabalhoFinalGiovannaFranco.apresentacao;

import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Funcionario;
import javax.swing.JFrame;

public class FormPrincipal extends javax.swing.JFrame {
    private final Funcionario funcionarioLogado;
    
    public FormPrincipal(Funcionario funcionario) {
        initComponents();
        
        maximizarTela();
        
        funcionarioLogado = funcionario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiHospede = new javax.swing.JMenuItem();
        jmiFuncionario = new javax.swing.JMenuItem();
        jmiCategoria = new javax.swing.JMenuItem();
        jmiAcomocacao = new javax.swing.JMenuItem();
        jmiTipoAcomocacao = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiEntrada = new javax.swing.JMenuItem();
        jmiSaida = new javax.swing.JMenuItem();
        jmiConsumo = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel Altos da Flora");

        jMenu1.setText("Cadastros");

        jmiHospede.setText("Hóspede");
        jmiHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiHospedeActionPerformed(evt);
            }
        });
        jMenu1.add(jmiHospede);

        jmiFuncionario.setText("Funcionário");
        jmiFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFuncionarioActionPerformed(evt);
            }
        });
        jMenu1.add(jmiFuncionario);

        jmiCategoria.setText("Categoria de item");
        jmiCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCategoriaActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCategoria);

        jmiAcomocacao.setText("Acomodação");
        jmiAcomocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAcomocacaoActionPerformed(evt);
            }
        });
        jMenu1.add(jmiAcomocacao);

        jmiTipoAcomocacao.setText("Tipo de acomodação");
        jmiTipoAcomocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTipoAcomocacaoActionPerformed(evt);
            }
        });
        jMenu1.add(jmiTipoAcomocacao);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Movimentação");

        jmiEntrada.setText("Entrada");
        jmiEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEntradaActionPerformed(evt);
            }
        });
        jMenu2.add(jmiEntrada);

        jmiSaida.setText("Saída");
        jmiSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSaidaActionPerformed(evt);
            }
        });
        jMenu2.add(jmiSaida);

        jmiConsumo.setText("Consumo");
        jmiConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConsumoActionPerformed(evt);
            }
        });
        jMenu2.add(jmiConsumo);

        jMenuItem9.setText("Reserva");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Relatórios");

        jMenuItem10.setText("Relatório de hóspede");
        jMenu3.add(jMenuItem10);

        jMenuItem11.setText("Relatório de ocupação de acomodações");
        jMenu3.add(jMenuItem11);

        jMenuItem12.setText("Relatório de faturamento periódico");
        jMenu3.add(jMenuItem12);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 772, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiHospedeActionPerformed
        FormHospede fh = new FormHospede();
        fh.setVisible(true);
    }//GEN-LAST:event_jmiHospedeActionPerformed

    private void jmiFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiFuncionarioActionPerformed
        FormFuncionario ff = new FormFuncionario();
        ff.setVisible(true);
    }//GEN-LAST:event_jmiFuncionarioActionPerformed

    private void jmiCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCategoriaActionPerformed
        FormCategoriaItem fci = new FormCategoriaItem();
        fci.setVisible(true);
    }//GEN-LAST:event_jmiCategoriaActionPerformed

    private void jmiAcomocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAcomocacaoActionPerformed
        FormAcomodacao fa = new FormAcomodacao();
        fa.setVisible(true);
    }//GEN-LAST:event_jmiAcomocacaoActionPerformed

    private void jmiTipoAcomocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTipoAcomocacaoActionPerformed
        FormTipoAcomodacao fta = new FormTipoAcomodacao();
        fta.setVisible(true);
    }//GEN-LAST:event_jmiTipoAcomocacaoActionPerformed

    private void jmiEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEntradaActionPerformed
        FormInsercaoEntrada fe = new FormInsercaoEntrada();
        fe.setVisible(true);
    }//GEN-LAST:event_jmiEntradaActionPerformed

    private void jmiConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsumoActionPerformed
        FormConsumo fc = new FormConsumo();
        fc.setVisible(true);
    }//GEN-LAST:event_jmiConsumoActionPerformed

    private void jmiSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSaidaActionPerformed
        FormSaida fs = new FormSaida();
        fs.setVisible(true);
    }//GEN-LAST:event_jmiSaidaActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        FormInsercaoReserva formR = new FormInsercaoReserva();
        formR.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem9ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jmiAcomocacao;
    private javax.swing.JMenuItem jmiCategoria;
    private javax.swing.JMenuItem jmiConsumo;
    private javax.swing.JMenuItem jmiEntrada;
    private javax.swing.JMenuItem jmiFuncionario;
    private javax.swing.JMenuItem jmiHospede;
    private javax.swing.JMenuItem jmiSaida;
    private javax.swing.JMenuItem jmiTipoAcomocacao;
    // End of variables declaration//GEN-END:variables

    private void maximizarTela() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
