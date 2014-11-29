package br.com.giovanna.trabalhoFinalGiovannaFranco.apresentacao;

import br.com.giovanna.trabalhoFinalGiovannaFranco.controle.TipoAcomodacaoDAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.TipoAcomodacao;
import javax.swing.JOptionPane;

public class FormTipoAcomodacao extends javax.swing.JFrame {

    public FormTipoAcomodacao() {
        initComponents();
        carregarTiposAcomodacoes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jcbTipoAcomodacao = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfCod = new javax.swing.JTextField();
        jtfDescricao = new javax.swing.JTextField();
        btnInserir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfQtde = new javax.swing.JTextField();
        jtfValorDiaria = new javax.swing.JTextField();
        jtfNAdulto = new javax.swing.JTextField();
        jtfNCrianca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jcbTipoAcomodacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoAcomodacaoActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipo Acomodação");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setText("Descrição:");

        jLabel3.setText("Código:");

        jtfCod.setEditable(false);
        jtfCod.setEnabled(false);

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel4.setText("Quantidade:");

        jLabel5.setText("Valor Diária:");

        jLabel6.setText("Número Adulto:");

        jLabel7.setText("Número Criança:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfDescricao)
                    .addComponent(jtfQtde)
                    .addComponent(jtfValorDiaria)
                    .addComponent(jtfNAdulto)
                    .addComponent(jtfNCrianca))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnAlterar)
                .addGap(27, 27, 27)
                .addComponent(btnInserir)
                .addGap(27, 27, 27)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbTipoAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(61, 61, 61)
                        .addComponent(jtfCod, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
            .addComponent(jSeparator1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfValorDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfNAdulto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfNCrianca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInserir)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnVoltar))
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

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        cadastrar();
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterar();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void jcbTipoAcomodacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoAcomodacaoActionPerformed
        validarTipoAcomodacao();
    }//GEN-LAST:event_jcbTipoAcomodacaoActionPerformed
    
    private void cadastrar() {
        TipoAcomodacao tipoAcomodacao = new TipoAcomodacao();
        
        tipoAcomodacao.setDescricao(jtfDescricao.getText());
        tipoAcomodacao.setNroAdulto(Integer.parseInt(jtfNAdulto.getText()));
        tipoAcomodacao.setNroCrianca(Integer.parseInt(jtfNCrianca.getText()));
        tipoAcomodacao.setPrecoDiaria(Double.parseDouble(jtfValorDiaria.getText()));
        tipoAcomodacao.setQtdeAcomodacoes(Integer.parseInt(jtfQtde.getText()));
            
        try {
            new TipoAcomodacaoDAO().inserir(tipoAcomodacao);
            JOptionPane.showMessageDialog(this,"Tipo acomodação foi cadastrado!","SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            carregarTiposAcomodacoes();
            
        }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(this,"Tipo de acomodação não foi inserida!","ERRO", 1);
            throw new IllegalArgumentException(e);
        }
    }
    
    private void alterar(){
        TipoAcomodacao tipoAcomodacao = new TipoAcomodacao();
        
        tipoAcomodacao.setPrecoDiaria(Double.parseDouble(jtfValorDiaria.getText()));
        tipoAcomodacao.setQtdeAcomodacoes(Integer.parseInt(jtfQtde.getText()));
        tipoAcomodacao.setDescricao(jtfDescricao.getText());
        tipoAcomodacao.setId(Integer.parseInt(jtfCod.getText()));
        tipoAcomodacao.setNroAdulto(Integer.parseInt(jtfNAdulto.getText()));
        tipoAcomodacao.setNroCrianca(Integer.parseInt(jtfNCrianca.getText()));
        
        try{
            new TipoAcomodacaoDAO().alterar(tipoAcomodacao);

            JOptionPane.showMessageDialog(this,"Tipo de acomodação foi alterada!","SUCESSO", 1);
            carregarTiposAcomodacoes();
            
        }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(this,"Tipo de acomodação não foi alterada!","ERRO", 1);
            throw new IllegalArgumentException(e);
        }
    }
    
    private void excluir(){
        TipoAcomodacao tipoacomodacao = new TipoAcomodacao();
        int idTipo;

        idTipo = Integer.parseInt(jtfCod.getText());
        
        try{
            new TipoAcomodacaoDAO().excluir(idTipo);
            JOptionPane.showMessageDialog(this,"Tipo de acomodação foi excluído!","ERRO", 1);
            carregarTiposAcomodacoes();
            
        }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(this,"Tipo de acomodação não foi excluído!","ERRO", 1);
            throw new IllegalArgumentException(e);
        }
    }
   
    private void carregarTiposAcomodacoes() {
        jcbTipoAcomodacao.removeAllItems();
        jcbTipoAcomodacao.addItem("Selecione um Tipo de Acomodação");
        
        for (TipoAcomodacao tipo : new TipoAcomodacaoDAO().listarTodos()) {
            jcbTipoAcomodacao.addItem(tipo);
        }
    }

    private void validarTipoAcomodacao(){
        if(jcbTipoAcomodacao.getSelectedIndex() <= 0){
           jtfCod.setText("");
           jtfDescricao.setText("");
           jtfNAdulto.setText("");
           jtfNCrianca.setText("");
           jtfQtde.setText("");
           jtfValorDiaria.setText("");
           
        }else{
            TipoAcomodacao ta = (TipoAcomodacao) jcbTipoAcomodacao.getSelectedItem();
            jtfCod.setText(String.valueOf(ta.getId()));
            jtfDescricao.setText(ta.getDescricao());
            jtfNAdulto.setText(String.valueOf(ta.getNroAdulto()));
            jtfNCrianca.setText(String.valueOf(ta.getNroCrianca()));
            jtfQtde.setText(String.valueOf(ta.getQtdeAcomodacoes()));
            jtfValorDiaria.setText(String.valueOf(ta.getPrecoDiaria()));
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox jcbTipoAcomodacao;
    private javax.swing.JTextField jtfCod;
    private javax.swing.JTextField jtfDescricao;
    private javax.swing.JTextField jtfNAdulto;
    private javax.swing.JTextField jtfNCrianca;
    private javax.swing.JTextField jtfQtde;
    private javax.swing.JTextField jtfValorDiaria;
    // End of variables declaration//GEN-END:variables
}
