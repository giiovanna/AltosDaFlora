package br.com.giovanna.trabalhoFinalGiovannaFranco.apresentacao;

import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.ItemConsumo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelitemConsumo extends AbstractTableModel{
    private String[] nomeColunas = {"Descricao","Quantidade","Valor unitário","Categoria"};
    private List<ItemConsumo> itensConsumo;
    
    public TableModelitemConsumo(){
        itensConsumo = new ArrayList<>();
    }  
    
    public TableModelitemConsumo(ArrayList<ItemConsumo> listaItens){
        this();
        itensConsumo.addAll(listaItens);
    } 
    
    public void addRow(ItemConsumo it){
        itensConsumo.add(it);
        fireTableRowsInserted(itensConsumo.size() - 1, itensConsumo.size() - 1);
    }

    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }
    
    public ItemConsumo retornarObjetoSelecionado(int linha){
        return itensConsumo.get(linha);
    }
    
    @Override
    public int getRowCount() {
        return itensConsumo.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ItemConsumo ic = itensConsumo.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return ic.getDescricao();
            case 1:
                return ic.getQuantidade();
            case 2:
                return ic.getValorUnitario();
            case 3:
                return ic.getCategoria().getDescricao();
            default:
                throw new UnsupportedOperationException("Operação Sem Suporte");
        }
    }
    
    public List<ItemConsumo> getRows(){
        return itensConsumo;
    }

    public void removeRow(int index) {
        itensConsumo.remove(index);
        fireTableRowsDeleted(index, index);
    }
    
}
