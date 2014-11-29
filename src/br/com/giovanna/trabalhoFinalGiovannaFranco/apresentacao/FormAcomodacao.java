package br.com.giovanna.trabalhoFinalGiovannaFranco.apresentacao;

import br.com.giovanna.trabalhoFinalGiovannaFranco.controle.AcomodacaoDAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.controle.TipoAcomodacaoDAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Acomodacao;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.TipoAcomodacao;
import javax.swing.JOptionPane;

public class FormAcomodacao extends javax.swing.JFrame {

    public FormAcomodacao() {
        initComponents();
        carregarTiposAcomodacoes();
        carregarAcomodacoes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jcbAcomodacao = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfCod = new javax.swing.JTextField();
        jtfNroAcomodacao = new javax.swing.JTextField();
        btnInserir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtfAndar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jcbTipoAcomodacao = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jcbAcomodacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAcomodacaoActionPerformed(evt);
            }
        });

        jLabel1.setText("Acomodação");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setText("Número:");

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

        jLabel4.setText("Andar:");

        jLabel8.setText("Tipo de acomodação:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbTipoAcomodacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(65, 65, 65)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtfCod, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jtfAndar)
                                    .addComponent(jtfNroAcomodacao))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jtfNroAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfAndar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jcbTipoAcomodacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInserir)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnVoltar))
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

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterar();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void jcbAcomodacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAcomodacaoActionPerformed
        validarAcomodação();
    }//GEN-LAST:event_jcbAcomodacaoActionPerformed
    
    private void cadastrar() {
        Acomodacao acomodacao = new Acomodacao();
        TipoAcomodacao ta = (TipoAcomodacao) jcbTipoAcomodacao.getSelectedItem();
            
        acomodacao.setNumero(Integer.parseInt(jtfNroAcomodacao.getText()));
        acomodacao.setAndar(Integer.parseInt(jtfAndar.getText()));
        acomodacao.setTipoAcomodacao(ta);
        
        try {
            new AcomodacaoDAO().inserir(acomodacao);
            JOptionPane.showMessageDialog(this,"Acomodação foi cadastrado!","SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            carregarAcomodacoes();
            
        }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(this,"Acomodação não foi inserida!","ERRO", 1);
            throw new IllegalArgumentException(e);
        }finally{
            limparCampos();
        }
        
    }
    
    private void alterar(){
        Acomodacao acomodacao = new Acomodacao();
        TipoAcomodacao ta = (TipoAcomodacao) jcbTipoAcomodacao.getSelectedItem();
        
        acomodacao.setNumero(Integer.parseInt(jtfNroAcomodacao.getText()));
        acomodacao.setAndar(Integer.parseInt(jtfAndar.getText()));
        acomodacao.setTipoAcomodacao(ta);
        acomodacao.setId(Integer.parseInt(jtfCod.getText()));
        
        
        try {
            new AcomodacaoDAO().alterar(acomodacao);
            JOptionPane.showMessageDialog(this,"Acomodação foi alterada!","SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            carregarAcomodacoes();
            
        }catch(IllegalArgumentException e){
            
            JOptionPane.showMessageDialog(this,"Acomodação não foi alterada!","ERRO", 1);
            throw new IllegalArgumentException(e);
        }finally{
            limparCampos();
        }
    }
    
    private void excluir(){
        Acomodacao ac = new Acomodacao();
        int idAcomodacao;
        idAcomodacao = Integer.parseInt(jtfCod.getText());
        
        try{
            new AcomodacaoDAO().excluir(idAcomodacao);
            JOptionPane.showMessageDialog(this,"Acomodação foi excluída!","SUCESSO", 1);
            carregarAcomodacoes();
        }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(this,"Acomodação não foi excluída!","ERRO", 1);
            throw new IllegalArgumentException(e);
        }finally{
            limparCampos();
        }
    }
    
    private void carregarTiposAcomodacoes() {
        jcbTipoAcomodacao.removeAllItems();
        jcbTipoAcomodacao.addItem("Selecione um Tipo de Acomodação");
        
        for (TipoAcomodacao tipo : new TipoAcomodacaoDAO().listarTodos()) {
            jcbTipoAcomodacao.addItem(tipo);
        }
    }
    
    private void carregarAcomodacoes() {
        jcbAcomodacao.removeAllItems();
        jcbAcomodacao.addItem("Selecione Acomodação");
        
        for (Acomodacao ac : new AcomodacaoDAO().listarTodos()) {
            jcbAcomodacao.addItem(ac);
        }
    }

    private void validarAcomodação(){
        if(jcbAcomodacao.getSelectedIndex() <= 0){
           jtfCod.setText("");
           jtfAndar.setText("");
           jtfNroAcomodacao.setText("");
           jcbTipoAcomodacao.setSelectedIndex(0);
           
        }else{
            Acomodacao ac = (Acomodacao) jcbAcomodacao.getSelectedItem();
            
            jtfCod.setText(String.valueOf(ac.getId()));
            jtfAndar.setText(String.valueOf(ac.getAndar()));
            jtfNroAcomodacao.setText(String.valueOf(ac.getNumero()));
            jcbTipoAcomodacao.getModel().setSelectedItem(ac.getTipoAcomodacao());//nao aparece  
        }
    }
    
    private void limparCampos(){
        jtfAndar.setText("");
        jtfCod.setText("");
        jtfNroAcomodacao.setText("");
        jcbTipoAcomodacao.setSelectedIndex(0);
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox jcbAcomodacao;
    private javax.swing.JComboBox jcbTipoAcomodacao;
    private javax.swing.JTextField jtfAndar;
    private javax.swing.JTextField jtfCod;
    private javax.swing.JTextField jtfNroAcomodacao;
    // End of variables declaration//GEN-END:variables
}
