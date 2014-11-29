package br.com.giovanna.trabalhoFinalGiovannaFranco.apresentacao;

import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Funcionario;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Hospede;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelFuncionario extends AbstractTableModel {
    private String[] nomeColunas = {"Código", "Nome", "Nivel de acesso","Nome de acesso"};    
    private List<Funcionario> funcionariosCadastrados;    
    
    public TableModelFuncionario(){
        funcionariosCadastrados = new ArrayList<>();
    }  
    
    public TableModelFuncionario(ArrayList<Funcionario> listaFunc){
        this();
        funcionariosCadastrados.addAll(listaFunc);
    } 
    
    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }
      
    public int retornarCodigoFuncionario(int linha){
        return funcionariosCadastrados.get(linha).getId();
    } 
 
     public Funcionario retornarObjetoSelecionado(int linha){
        return funcionariosCadastrados.get(linha);
    }
    @Override
    public int getRowCount() {
        return funcionariosCadastrados.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario f = funcionariosCadastrados.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return f.getId();
            case 1:
                return f.getNome();
            case 2:
                return f.getNivelAcesso();
            case 3:
                return f.getNomeAcesso();
            default:
                throw new UnsupportedOperationException("Operação Sem Suporte");
        }
    } 
    
    public List<Funcionario> getRows(){
        return funcionariosCadastrados;
    }

    public void removeRow(int index) {
        funcionariosCadastrados.remove(index);
        fireTableRowsDeleted(index, index);
    }
    

}

