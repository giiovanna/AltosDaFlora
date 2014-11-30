package br.com.giovanna.trabalhoFinalGiovannaFranco.apresentacao;

import br.com.giovanna.trabalhoFinalGiovannaFranco.controle.AcompanhanteDAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.controle.FuncionarioDAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.controle.HospedeDAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.controle.ReservaDAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.controle.TipoAcomodacaoDAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Acompanhante;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Funcionario;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Hospede;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Reserva;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.TipoAcomodacao;
import java.util.*;
import javax.swing.JOptionPane;

public class FormInsercaoReserva extends javax.swing.JFrame {
    private List<Acompanhante> acompanhantes;
    private int adulto;
    private int crianca;
    private TableModelAcompanhante modeloAcompanhante;
    private Funcionario funcionarioLogado;

    public FormInsercaoReserva(Funcionario f) {
        initComponents();
        carregarAcomodacao();
        carregarHospede();
        instanciarTabelaAcompanhante();
        acompanhantes = new ArrayList<>();
        adulto = 1;
        crianca = 0;
        funcionarioLogado = f;
        jtfFuncionario.setText(funcionarioLogado.getNome());
        
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
        jcbTipoAcomodacao = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jcbHospede = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnAdicionarAcompanhante = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnExcluirAcompanhante = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtAcompanhante = new javax.swing.JTable();
        btnInserir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jtfTaxaMulta = new javax.swing.JTextField();
        jtfFuncionario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel2.setText("Código:");

        jtfCodigo.setEditable(false);
        jtfCodigo.setEnabled(false);

        jLabel3.setText("Data de chegada:");

        jLabel4.setText("Data de saída:");

        jLabel5.setText("Tipo de acomodação:");

        jLabel6.setText("Funcionário:");

        jcbTipoAcomodacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do hóspede"));

        jcbHospede.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        jLabel1.setText("Hóspede:");

        btnAdicionarAcompanhante.setText("Adicionar acompanhante");
        btnAdicionarAcompanhante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarAcompanhanteActionPerformed(evt);
            }
        });

        jLabel7.setText("Acompanhantes");

        btnExcluirAcompanhante.setText("Excluir acompanhante");
        btnExcluirAcompanhante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirAcompanhanteActionPerformed(evt);
            }
        });

        jtAcompanhante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtAcompanhante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAcompanhanteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtAcompanhante);

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
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdicionarAcompanhante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExcluirAcompanhante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbHospede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdicionarAcompanhante)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirAcompanhante))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(319, 319, 319))
        );

        btnInserir.setText("Inserir Reserva");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel8.setText("Taxa de multa:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnInserir)
                        .addGap(187, 187, 187)
                        .addComponent(btnCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jtfTaxaMulta, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                    .addComponent(jdcDataChegada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                    .addComponent(jcbTipoAcomodacao, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jdcDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfFuncionario)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                                .addComponent(jtfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jcbTipoAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtfTaxaMulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInserir)
                    .addComponent(btnCancelar))
                .addGap(19, 19, 19))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        cadastrar();
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnAdicionarAcompanhanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarAcompanhanteActionPerformed
       exibirTelaAcompanhante();
    }//GEN-LAST:event_btnAdicionarAcompanhanteActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jtAcompanhanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAcompanhanteMouseClicked
       int linhaSelecionada = jtAcompanhante.getSelectedRow();
       modeloAcompanhante = (TableModelAcompanhante)jtAcompanhante.getModel();
       Acompanhante ac = modeloAcompanhante.retornarObjetoSelecionado(linhaSelecionada);
    }//GEN-LAST:event_jtAcompanhanteMouseClicked

    private void btnExcluirAcompanhanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirAcompanhanteActionPerformed
        excluirAcompanhante();
    }//GEN-LAST:event_btnExcluirAcompanhanteActionPerformed

    private void cadastrar() {
        Reserva r = new Reserva();

        TipoAcomodacao ta = (TipoAcomodacao) jcbTipoAcomodacao.getSelectedItem();
        
        Hospede h = (Hospede) jcbHospede.getSelectedItem();

        r.setDataChegada(jdcDataChegada.getDate());
        r.setDataSaida(jdcDataSaida.getDate());
        r.setTipoAcomodacao(ta);
        r.setFuncionario(funcionarioLogado);
        r.setHospede(h);
        r.setTaxaMulta(Double.parseDouble(jtfTaxaMulta.getText()));
        r.setAcompanhantes(acompanhantes);
        

        try {
            new ReservaDAO().inserir(r);
            JOptionPane.showMessageDialog(this, "Reserva foi inserida!", "SUCESSO", 1);
            
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Reserva não foi inserida!", "ERRO", 1);
            throw new IllegalArgumentException(e);
        }
    }

    private void carregarAcomodacao() {
        List<TipoAcomodacao> ta = new TipoAcomodacaoDAO().listarTodos();

        jcbTipoAcomodacao.removeAllItems();
        jcbTipoAcomodacao.addItem("Selecione tipo de acomodação");
        for (TipoAcomodacao tipoA : ta) {
            jcbTipoAcomodacao.addItem(tipoA);
        }
    }

    private void carregarHospede() {
        List<Hospede> hospede = new HospedeDAO().listarTodos();

        jcbHospede.removeAllItems();
        jcbHospede.addItem("Selecione hóspede");
        for (Hospede h : hospede) {
            jcbHospede.addItem(h);
        }
    }

    public void adicionarAcompanhante(Acompanhante a) {
        verificarAcompanhantes(a);
        
    }

    private void verificarAcompanhantes(Acompanhante a) {
        TipoAcomodacao ta = null;
        try{
            ta = (TipoAcomodacao) jcbTipoAcomodacao.getSelectedItem();
        
        }catch(ClassCastException c){
            c.printStackTrace();
        }
        
        int nroAdulto = ta.getNroAdulto();
        int nroCriancas = ta.getNroCrianca();

        if (a.getIdade() >= 18) {
            if (adulto >= nroAdulto) {
                JOptionPane.showMessageDialog(this, "Não é possivel inserir mais adultos no quarto! ");
            } else {
                acompanhantes.add(a);
                adulto++;
                JOptionPane.showMessageDialog(this, "Acompanhante do tipo adulto inserido!");
                new AcompanhanteDAO().inserir(a);
                modeloAcompanhante.addRow(a);
            }
        } else {
            if (crianca >= nroCriancas) {
                JOptionPane.showMessageDialog(this, "Não é possivel inserir mais crianças no quarto! ");

            } else {
                acompanhantes.add(a);
                crianca++;
                JOptionPane.showMessageDialog(this, "Acompanhante do tipo criança inserido!");
                new AcompanhanteDAO().inserir(a);
                modeloAcompanhante.addRow(a);
            }
        }
        
        
    }
    
    private void instanciarTabelaAcompanhante() {
        modeloAcompanhante = new TableModelAcompanhante();
        jtAcompanhante.setModel(modeloAcompanhante);
    }

    private void exibirTelaAcompanhante(){
        FormAcompanhanteReserva fa = new FormAcompanhanteReserva(this);
        fa.setVisible(true);
    }
    
    private void excluirAcompanhante() {
        int linhaSelecionada = jtAcompanhante.getSelectedRow();
        
        if (linhaSelecionada >= 0) {
            Acompanhante a = modeloAcompanhante.retornarObjetoSelecionado(linhaSelecionada);
                       
            modeloAcompanhante.removeRow(linhaSelecionada);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione o item que deseja remover da tabela.");
        }
    }
    
    public void inserirItem(Acompanhante a) {
        modeloAcompanhante.addRow(a);
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarAcompanhante;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluirAcompanhante;
    private javax.swing.JButton btnInserir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox jcbHospede;
    private javax.swing.JComboBox jcbTipoAcomodacao;
    private com.toedter.calendar.JDateChooser jdcDataChegada;
    private com.toedter.calendar.JDateChooser jdcDataSaida;
    private javax.swing.JTable jtAcompanhante;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfFuncionario;
    private javax.swing.JTextField jtfTaxaMulta;
    // End of variables declaration//GEN-END:variables

    
}
