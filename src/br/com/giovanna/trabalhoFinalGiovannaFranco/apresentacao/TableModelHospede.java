package br.com.giovanna.trabalhoFinalGiovannaFranco.apresentacao;

import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Hospede;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelHospede extends AbstractTableModel {
    private String[] nomeColunas = {"Código", "Nome", "CPF","Data de nascimento"};    
    private List<Hospede> hospedesCadastrados;    
    
    public TableModelHospede(){
        hospedesCadastrados = new ArrayList<>();
    }  
    
    public TableModelHospede(ArrayList<Hospede> listaHospede){
        this();
        hospedesCadastrados.addAll(listaHospede);
    } 
    
    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }
      
    public int retornarCodigoHospede(int linha){
        return hospedesCadastrados.get(linha).getId();
    } 
 
     public Hospede retornarObjetoSelecionado(int linha){
        return hospedesCadastrados.get(linha);
    }
    @Override
    public int getRowCount() {
        return hospedesCadastrados.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Hospede hospede = hospedesCadastrados.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return hospede.getId();
            case 1:
                return hospede.getNome();
            case 2:
                return hospede.getRg();
            case 3:
                return hospede.getDataNasc();
            default:
                throw new UnsupportedOperationException("Operação Sem Suporte");
        }
    } 
    
    public List<Hospede> getRows(){
        return hospedesCadastrados;
    }

    public void removeRow(int index) {
        hospedesCadastrados.remove(index);
        fireTableRowsDeleted(index, index);
    }
    

}

