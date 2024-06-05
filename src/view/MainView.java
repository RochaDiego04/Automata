
package view;

import automata.Automata;
import java.util.List;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Diego
 */
public class MainView extends javax.swing.JFrame {
    private Automata automata;
    
    public MainView() {
        initComponents();
        setupTextDropListener();
    }
    
private String readFile(File file) {
    StringBuilder contentBuilder = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = br.readLine()) != null) {
            contentBuilder.append(line).append("\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return contentBuilder.toString();
}

private void setupTextDropListener() {
    DropTarget dt = new DropTarget(lbl_dropbox, new DropTargetAdapter() {
        @Override
        public void drop(DropTargetDropEvent dtde) {
            try {
                dtde.acceptDrop(DnDConstants.ACTION_COPY);
                Transferable t = dtde.getTransferable();
                DataFlavor[] df = t.getTransferDataFlavors();

                for (DataFlavor f : df) {
                    if (f.isFlavorJavaFileListType()) {
                        List<File> files = (List<File>) t.getTransferData(f);

                        for (File file : files) {
                            if (isTextFile(file)) {
                                String txtContent = readFile(file);
                                // Aquí puedes pasar 'content' a la clase para su análisis
                                // Por ejemplo: MyClass myClass = new MyClass(content);
                                txtArea_textFile.setText(txtContent);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
    lbl_dropbox.setDropTarget(dt);
}




    private boolean isTextFile(File file) {
        String fileName = file.getName().toLowerCase();
        return fileName.endsWith(".txt");
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_background = new javax.swing.JPanel();
        btn_clear = new javax.swing.JButton();
        lbl_title = new javax.swing.JLabel();
        lbl_dropbox = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea_report = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea_textFile = new javax.swing.JTextArea();
        btn_startAutomata = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnl_background.setBackground(new java.awt.Color(8, 8, 23));
        pnl_background.setMinimumSize(new java.awt.Dimension(610, 650));
        pnl_background.setPreferredSize(new java.awt.Dimension(707, 650));
        pnl_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_clear.setBackground(new java.awt.Color(64, 126, 126));
        btn_clear.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("Clear");
        btn_clear.setToolTipText("");
        btn_clear.setAlignmentX(0.5F);
        btn_clear.setBorderPainted(false);
        btn_clear.setFocusPainted(false);
        btn_clear.setSelected(true);
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        pnl_background.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 580, 160, 40));

        lbl_title.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 36)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title.setText("Automata");
        pnl_background.add(lbl_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 480, 60));

        lbl_dropbox.setBackground(new java.awt.Color(102, 255, 255));
        lbl_dropbox.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 22)); // NOI18N
        lbl_dropbox.setForeground(new java.awt.Color(203, 197, 197));
        lbl_dropbox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dropbox.setText("Drop your text file here");
        lbl_dropbox.setToolTipText("");
        lbl_dropbox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 153, 255), null, new java.awt.Color(115, 117, 146)));
        pnl_background.add(lbl_dropbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 380, 50));

        txtArea_report.setBackground(new java.awt.Color(30, 33, 36));
        txtArea_report.setColumns(20);
        txtArea_report.setForeground(new java.awt.Color(241, 241, 241));
        txtArea_report.setRows(5);
        txtArea_report.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 255)));
        txtArea_report.setCaretColor(new java.awt.Color(153, 255, 255));
        txtArea_report.setEnabled(false);
        txtArea_report.setFocusable(false);
        jScrollPane1.setViewportView(txtArea_report);

        pnl_background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 250, 410));

        txtArea_textFile.setBackground(new java.awt.Color(30, 33, 36));
        txtArea_textFile.setColumns(20);
        txtArea_textFile.setForeground(new java.awt.Color(241, 241, 241));
        txtArea_textFile.setRows(5);
        txtArea_textFile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 255)));
        txtArea_textFile.setCaretColor(new java.awt.Color(153, 255, 255));
        jScrollPane2.setViewportView(txtArea_textFile);

        pnl_background.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 410, 410));

        btn_startAutomata.setBackground(new java.awt.Color(64, 126, 126));
        btn_startAutomata.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_startAutomata.setForeground(new java.awt.Color(255, 255, 255));
        btn_startAutomata.setText("Start");
        btn_startAutomata.setToolTipText("");
        btn_startAutomata.setAlignmentX(0.5F);
        btn_startAutomata.setBorderPainted(false);
        btn_startAutomata.setFocusPainted(false);
        btn_startAutomata.setSelected(true);
        btn_startAutomata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startAutomataActionPerformed(evt);
            }
        });
        pnl_background.add(btn_startAutomata, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, 160, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnl_background, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        txtArea_textFile.setText("");
        if(automata != null){
            automata.setTxtToAnalize("");
        }
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_startAutomataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startAutomataActionPerformed
        String txtAreaContent = txtArea_textFile.getText();
        
        if(automata != null){
            automata.setTxtToAnalize(txtAreaContent);
        }else {
            automata = new Automata(txtAreaContent);
        }
        
        automata.evaluateText();
    }//GEN-LAST:event_btn_startAutomataActionPerformed

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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_clear;
    public javax.swing.JButton btn_startAutomata;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_dropbox;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JPanel pnl_background;
    private javax.swing.JTextArea txtArea_report;
    private javax.swing.JTextArea txtArea_textFile;
    // End of variables declaration//GEN-END:variables
}
