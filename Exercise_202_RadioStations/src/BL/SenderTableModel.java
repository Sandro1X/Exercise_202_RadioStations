package BL;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.AbstractTableModel;

public class SenderTableModel extends AbstractTableModel{
    
    private ArrayList<Sender> sender = new ArrayList<>();
    private static String[] colNames = {"Sender","Frequenz","Band"};
    private static String[] colNames2 = {"Sender","Frequenz"};
    private boolean band = true;
    
    public void add(Sender s){
        sender.add(s);
        Collections.sort(sender, new SortierNachFrequenz());
        fireTableDataChanged();
    }
    
    public void updateNumCols(boolean band){
        this.band = band;
        fireTableStructureChanged();
    }
    
    public void load(File f) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        Sender s;
        try{
            while((s = (Sender) ois.readObject()) != null){
            sender.add(s);
            }
        }catch(EOFException eof){
            System.out.println("EOF Exception");
        }
        ois.close();
    }
    
    public void safe(File f) throws FileNotFoundException, IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        
        for (Sender s : sender) {
            oos.writeObject(s);
        }
        oos.flush();
        oos.close();
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
