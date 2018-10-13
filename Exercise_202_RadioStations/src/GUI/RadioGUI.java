package GUI;

import BL.SenderTableModel;
import BL.SenderTableRenderer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RadioGUI extends javax.swing.JFrame {
    
    private SenderTableModel model = new SenderTableModel();
    private File file = new File("src\\data.bin");
    
    public RadioGUI() throws IOException, FileNotFoundException, ClassNotFoundException {
        initComponents();
        if(model.getRowCount() == 0){
            miVerbergen.setVisible(false);
            miAnzeigen.setVisible(false);
        }
        jtOut.setModel(model);
        try{
            model.load(file);
        }catch(Exception e){
            
        }
        jtOut.setDefaultRenderer(Object.class, new SenderTableRenderer());
        jtOut.setShowGrid(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        miAdd = new javax.swing.JMenuItem();
        miVerbergen = new javax.swing.JMenuItem();
        miAnzeigen = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtOut = new javax.swing.JTable();

        miAdd.setText("Hinzufügen");
        miAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miAdd);

        miVerbergen.setText("Band verstecken");
        miVerbergen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVerbergenActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miVerbergen);

        miAnzeigen.setText("Band anzeigen");
        miAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAnzeigenActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miAnzeigen);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jScrollPane1.setComponentPopupMenu(jPopupMenu1);

        jtOut.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtOut.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jtOut);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddActionPerformed
        SenderDlg dlg = new SenderDlg(this, true);
        
        dlg.setVisible(true);
        if(dlg.isOk()){
            model.add(dlg.getSender());
        }
        if(model.getRowCount() > 0){
            miVerbergen.setVisible(true);
            miAnzeigen.setVisible(true);
        }
    }//GEN-LAST:event_miAddActionPerformed

    private void miVerbergenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVerbergenActionPerformed
        model.updateNumCols(false);
    }//GEN-LAST:event_miVerbergenActionPerformed

    private void miAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAnzeigenActionPerformed
        model.updateNumCols(true);
    }//GEN-LAST:event_miAnzeigenActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            model.safe(file);
        } catch (IOException ex) {
            
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RadioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RadioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RadioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RadioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new RadioGUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(RadioGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(RadioGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtOut;
    private javax.swing.JMenuItem miAdd;
    private javax.swing.JMenuItem miAnzeigen;
    private javax.swing.JMenuItem miVerbergen;
    // End of variables declaration//GEN-END:variables
}
