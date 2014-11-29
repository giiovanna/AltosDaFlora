package br.com.giovanna.trabalhoFinalGiovannaFranco.apresentacao;

import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Acompanhante;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.ItemConsumo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelAcompanhante extends AbstractTableModel {
    private String[] nomeColunas = {"Nome", "Idade"};    
    private List<Acompanhante> acompanhantes;    
    
    public TableModelAcompanhante(){
        acompanhantes = new ArrayList<>();
    }  
    
    public TableModelAcompanhante(ArrayList<Acompanhante> listaAcompanhantes){
        this();
        acompanhantes.addAll(listaAcompanhantes);
    } 
    
    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }
      
    public int retornarCodigoAcompanhante(int linha){
        return acompanhantes.get(linha).getId();
    } 
 
     public Acompanhante retornarObjetoSelecionado(int linha){
        return acompanhantes.get(linha);
    }
    @Override
    public int getRowCount() {
        return acompanhantes.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Acompanhante a = acompanhantes.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return a.getNome();
            case 1:
                return a.getIdade();
            default:
                throw new UnsupportedOperationException("Operação Sem Suporte");
        }
    } 
    
    public List<Acompanhante> getRows(){
        return acompanhantes;
    }
    
    public void addAll(List<Acompanhante> listAcompanhante){
        acompanhantes.removeAll(acompanhantes);
        acompanhantes.addAll(listAcompanhante);
         fireTableRowsInserted(0,acompanhantes.size());
        
    }

    public void removeRow(int index) {
        acompanhantes.remove(index);
        fireTableRowsDeleted(index, index);
    }

    
     public void addRow(Acompanhante a){
        acompanhantes.add(a);
        fireTableRowsInserted(acompanhantes.size() - 1, acompanhantes.size() - 1);
    }

}

