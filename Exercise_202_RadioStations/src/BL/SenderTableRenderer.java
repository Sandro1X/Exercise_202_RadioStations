package BL;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class SenderTableRenderer implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Sender s = (Sender) value;
        JLabel label = new JLabel();
        label.setOpaque(true);
        Color c = Color.WHITE;
        
        if(s.getBand().equals("AM")){
            c = Color.BLUE;
        }else if (s.getBand().equals("FM")){
            c = Color.RED;
        }
        
        switch(column){
            case 0: label.setText(s.getName());
            label.setBackground(c);
            label.setForeground(Color.WHITE);break;
            case 1: label.setText(s.getFrequenz()+ "");
            label.setBackground(c);
            label.setForeground(Color.WHITE);break;
            case 2: label.setText(s.getBand());
            label.setBackground(c);
            label.setForeground(Color.WHITE);break;
        }
        return label;
    }
}
