package BL;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class SenderTableModel extends AbstractTableModel{
    
    private ArrayList<Sender> sender = new ArrayList<>();
    private static String[] colNames = {"Sender","Frequenz","Band"};
    private static String[] colNames2 = {"Sender","Frequenz"};
    private boolean band = true;
    
    public void add(Sender s){
        sender.add(s);
        fireTableDataChanged();
    }
    
    public void updateNumCols(boolean band){
        this.band = band;
        fireTableStructureChanged();
    }
    
    @Override
    public int getRowCount() {
        return sender.size();
    }

    @Override
    public int getColumnCount() {
        if(band){
            return colNames.length;
        }else{
            return colNames2.length;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sender sen = sender.get(rowIndex);
        return sen;
    }
    
    @Override
    public String getColumnName(int i){
        if(band){
            return colNames[i];
        }else{
            return colNames2[i];
        }
    }
}
