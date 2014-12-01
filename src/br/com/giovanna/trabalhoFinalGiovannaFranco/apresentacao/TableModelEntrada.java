package br.com.giovanna.trabalhoFinalGiovannaFranco.apresentacao;

import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Entrada;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelEntrada extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Data de entrada", "Data de saída", "Código do hóspede"};
    private List<Entrada> entradas;

    public TableModelEntrada() {
        entradas = new ArrayList<>();
    }

    public TableModelEntrada(ArrayList<Entrada> listaEntrada) {
        this();
        entradas.addAll(listaEntrada);
    }

    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }

    public int retornarCodigoEntrada(int linha) {
        return entradas.get(linha).getId();
    }

    public Entrada retornarObjetoSelecionado(int linha) {
        return entradas.get(linha);
    }

    @Override
    public int getRowCount() {
        return entradas.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Entrada e = entradas.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        switch (columnIndex) {
            case 0:
                return e.getId();
            case 1:
                return sdf.format(e.getDataChegada());
            case 2:
                return sdf.format(e.getDataSaida());
            case 3:
                return e.getHospede();
            default:
                throw new UnsupportedOperationException("Operação Sem Suporte");
        }
    }

    public List<Entrada> getRows() {
        return entradas;
    }

    public void removeRow(int index) {
        entradas.remove(index);
        fireTableRowsDeleted(index, index);
    }

}
