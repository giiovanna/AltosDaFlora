package br.com.giovanna.trabalhoFinalGiovannaFranco.apresentacao;

import br.com.giovanna.trabalhoFinalGiovannaFranco.controle.ConsumoDAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.controle.EntradaDAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.controle.SaidaDAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Entrada;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Saida;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class FormSaida extends javax.swing.JFrame {

    public FormSaida() {
        initComponents();
        carregarEntrada();
        jdcDataSaida.setDate(new Date());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jdcDataSaida = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnRealizarSaida = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jtfValorTotalConsumo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbCodEntrada = new javax.swing.JComboBox();
        jtfValorDiarias = new javax.swing.JTextField();
        jspNroDiarias = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jcbPagamento = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel2.setText("Código:");

        jtfCodigo.setEditable(false);

        jLabel4.setText("Data de saída:");

        jdcDataSaida.setEnabled(false);

        jLabel5.setText("Número de diárias:");

        jLabel6.setText("Valor total de diárias");

        btnRealizarSaida.setText("Realizar saída");
        btnRealizarSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarSaidaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Voltar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jtfValorTotalConsumo.setEditable(false);

        jLabel1.setText("Valor total do consumo:");

        jLabel3.setText("Código de entrada:");

        jcbCodEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCodEntradaActionPerformed(evt);
            }
        });

        jtfValorDiarias.setEditable(false);

        jspNroDiarias.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jspNroDiarias.setEnabled(false);

        jLabel7.setText("Tipo de pagamento:");

        jcbPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dinheiro", "Cheque", "Cartão de crédito", "Faturado em 30 dias" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRealizarSaida)
                        .addGap(166, 166, 166)
                        .addComponent(btnCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbCodEntrada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jcbPagamento, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtfValorTotalConsumo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdcDataSaida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtfValorDiarias, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jspNroDiarias)))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbCodEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jdcDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jspNroDiarias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfValorTotalConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfValorDiarias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jcbPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRealizarSaida)
                    .addComponent(btnCancelar))
                .addContainerGap())
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

    private void btnRealizarSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarSaidaActionPerformed
        cadastrar();
    }//GEN-LAST:event_btnRealizarSaidaActionPerformed

    private void jcbCodEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCodEntradaActionPerformed
        preencherCamposEntradaSelecionada();
    }//GEN-LAST:event_jcbCodEntradaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cadastrar() {
        Saida saida = new Saida();

        Entrada et = (Entrada) jcbCodEntrada.getSelectedItem();

        saida.setData(jdcDataSaida.getDate());
        saida.setEntrada(et);
        saida.setNumeroDiarias((int) jspNroDiarias.getValue());
        saida.setTotalConsumo(Double.parseDouble(jtfValorTotalConsumo.getText()));
        saida.setTotalDiarias(Double.parseDouble(jtfValorDiarias.getText()));
        saida.setTipoPagamento(jcbPagamento.getSelectedItem().toString());

        try {
            new SaidaDAO().inserir(saida);
            JOptionPane.showMessageDialog(this, "Saida foi realizada!", "SUCESSO", 1);
            carregarEntrada();

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Saída não foi ralizada!", "ERRO", 1);
            throw new IllegalArgumentException(e);
        }
    }

    private void preencherCamposEntradaSelecionada() {
        Entrada entrada = null;
        
        try {
            entrada = (Entrada) jcbCodEntrada.getSelectedItem();
        }catch(ClassCastException c){   
//            c.printStackTrace();
        }
        if (entrada != null) {
            LocalDate dataSaida = LocalDate.now();
            LocalDate dataEntrada = entrada.getDataChegada().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            int numeroDiasHospedado = (int) ChronoUnit.DAYS.between(dataEntrada, dataSaida);

            if (numeroDiasHospedado == 0) {
                numeroDiasHospedado = 1;
            }

            jspNroDiarias.setValue(numeroDiasHospedado);

            double valorDiarias = entrada.getAcomodacao().getTipoAcomodacao().getPrecoDiaria();
            double valorTotalConsumo = new ConsumoDAO().getValorConsumoEntrada(entrada.getId());

            valorDiarias = valorDiarias * numeroDiasHospedado;

            jtfValorTotalConsumo.setText(String.valueOf(valorTotalConsumo));
            jtfValorDiarias.setText(String.valueOf(valorDiarias));
        }
    }

    private void carregarEntrada() {
        List<Entrada> entrada = new EntradaDAO().listarTodos();
        jcbCodEntrada.removeAllItems();
        jcbCodEntrada.addItem("Selecione entrada");
        for (Entrada et : entrada) {
            jcbCodEntrada.addItem(et);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRealizarSaida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox jcbCodEntrada;
    private javax.swing.JComboBox jcbPagamento;
    private com.toedter.calendar.JDateChooser jdcDataSaida;
    private javax.swing.JSpinner jspNroDiarias;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfValorDiarias;
    private javax.swing.JTextField jtfValorTotalConsumo;
    // End of variables declaration//GEN-END:variables
}
