package br.com.giovanna.trabalhoFinalGiovannaFranco.apresentacao;

import br.com.giovanna.trabalhoFinalGiovannaFranco.controle.AcomodacaoDAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.controle.AcompanhanteDAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.controle.EntradaDAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.controle.FuncionarioDAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.controle.HospedeDAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.controle.ReservaDAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Acomodacao;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Acompanhante;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Entrada;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Funcionario;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Hospede;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Reserva;
import java.util.*;
import javax.swing.JOptionPane;


public class FormInsercaoEntrada extends javax.swing.JFrame {
    private List<Acompanhante> acompanhantes;
    private int adulto;
    private int crianca;
    private TableModelAcompanhante modeloAcompanhante;
    private Reserva reserva;

    public FormInsercaoEntrada() {
        initComponents();
        carregarAcomodacao();
        carregarFuncionario();
        carregarHospede();
        instanciarTabelaAcompanhante();
        jdcDataChegada.setDate(new Date());
       
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
        jLabel7 = new javax.swing.JLabel();
        btnExcluirAcompanhante = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtAcompanhante = new javax.swing.JTable();
        btnInserir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnInserirPorReserva = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel2.setText("Código:");

        jtfCodigo.setEditable(false);
        jtfCodigo.setEnabled(false);

        jLabel3.setText("Data de chegada:");

        jdcDataChegada.setEnabled(false);

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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
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

        btnInserir.setText("Inserir Entrada");
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

        btnInserirPorReserva.setText("Inserir a partir de Reserva");
        btnInserirPorReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirPorReservaActionPerformed(evt);
            }
        });

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
                        .addGap(0, 60, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnInserirPorReserva)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInserir)
                        .addGap(187, 187, 187)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInserir)
                    .addComponent(btnCancelar)
                    .addComponent(btnInserirPorReserva))
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

    private void btnInserirPorReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirPorReservaActionPerformed
        carregarCampos();
    }//GEN-LAST:event_btnInserirPorReservaActionPerformed

    public void carregarCampos(){
        String nome = JOptionPane.showInputDialog(this,"Informe o nome do hóspede que fez a reserva:");
        
        ReservaDAO dao = new ReservaDAO();
        reserva= dao.buscarPorNome(nome);
        
        jdcDataChegada.setDate(reserva.getDataChegada());
        jdcDataSaida.setDate(reserva.getDataSaida());
        jcbFuncionario.getModel().setSelectedItem(reserva.getFuncionario());
        jcbHospede.getModel().setSelectedItem(reserva.getHospede());
        
        carregarAcomodacaoPorTipo(reserva.getTipoAcomodacao().getId());
        
        modeloAcompanhante.addAll(reserva.getAcompanhantes());
                
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
            if(reserva != null){
                new ReservaDAO().excluir(reserva.getId());
            }
            JOptionPane.showMessageDialog(this, "Entrada foi inserida!", "SUCESSO", 1);
            
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Entrada não foi inserida!", "ERRO", 1);
            throw new IllegalArgumentException(e);
        }
    }
    
    private void carregarReserva(){
        String nome = JOptionPane.showInputDialog(this,"Informe o nome do hóspede que fez a reserva:");
        
        ReservaDAO dao =new ReservaDAO();
        Reserva re = dao.buscarPorNome(nome);
        
        jdcDataChegada.setDate(re.getDataChegada());
        jdcDataSaida.setDate(re.getDataSaida());
        jcbFuncionario.setSelectedItem(re.getFuncionario().getNome());
        jcbHospede.setSelectedItem(re.getHospede().getNome());
        
        carregarAcomodacaoPorTipo(re.getTipoAcomodacao().getId());           
        
    }

    private void carregarAcomodacao() {
        List<Acomodacao> acm = new AcomodacaoDAO().listarTodos();

        jcbAcomodacao.removeAllItems();
        for (Acomodacao a : acm) {
            jcbAcomodacao.addItem(a);
        }
    }
    
    private void carregarAcomodacaoPorTipo(int cod) {
        List<Acomodacao> acm = new AcomodacaoDAO().buscarPorTipoAcomodacao(cod);

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
        FormAcompanhanteEntrada fa = new FormAcompanhanteEntrada(this);
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
    private javax.swing.JButton btnInserirPorReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox jcbAcomodacao;
    private javax.swing.JComboBox jcbFuncionario;
    private javax.swing.JComboBox jcbHospede;
    private com.toedter.calendar.JDateChooser jdcDataChegada;
    private com.toedter.calendar.JDateChooser jdcDataSaida;
    private javax.swing.JTable jtAcompanhante;
    private javax.swing.JTextField jtfCodigo;
    // End of variables declaration//GEN-END:variables

    
}
