/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operasi;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Alfaza
 */
public class main extends javax.swing.JFrame {
    private int id=0;
    private String code;
    private ModelCombo comboModel;
    private DefaultTableModel tbModel;
    private ArrayList<Item> keranjang = new ArrayList<>();
    
    public main() {
        this.comboModel = new ModelCombo();
        this.comboModel.TambahBarang(new Item("Kopi", new Float(10000)));
        this.comboModel.TambahBarang(new Item("Susu", new Float(30000)));
        this.comboModel.TambahBarang(new Item("Gula", new Float(15000)));
        this.comboModel.TambahBarang(new Item("Tepung", new Float(10000)));
        
        ModelTabel tablemodel = new ModelTabel();
        this.tbModel = new DefaultTableModel(tablemodel.getColumnName(), 0);
        
        initComponents();
    }
    
    private void upId(){
        this.id +=1;
    }
    
    private void downId(){
        this.id -=1;
    }
    
    private String setCode(){
        this.upId();
        String tgl = new SimpleDateFormat("yyMMdd").format(new Date());
        this.code= String.format(tgl+"%02d", this.id);
        return code;
    }
    
    private Object[] TambahBarang (String nama, int jumlah){
        float harga=0;
        Item[] barang = this.comboModel.toArray();
        for(int i=0; i<barang.length; i++){
            if(nama.equalsIgnoreCase(barang[i].getNama())){
                harga= barang[i].getHarga();
            }
        }
        Object[] obj = {
            nama,
            harga,
            jumlah
        };
        return obj;
    }
    
    //
    
    private void updateJumlah(String nama, int add){
        ArrayList<String> item = new ArrayList<>();
        for (int i=0; i<tbModel.getRowCount(); i++){
            item.add(tbModel.getValueAt(i, 0).toString());
        }
        for (int i=0; 9<item.size(); i++){
            if(item.get(i).equals(nama)) {
                int jumlah = new Integer(tbModel.getValueAt(i, 2).toString());
                tbModel.setValueAt(jumlah+add, i, 2);
            }
        }
    }
    
    //
    
    private boolean isDuplicate (String nama){
        boolean result = false;
        ArrayList<String> item = new ArrayList<>();
        for (int i=0; i<tbModel.getRowCount(); i++){
            item.add(tbModel.getValueAt(i, 0).toString());
        }
        for ( String i : item){
            if(i.equals(nama)){
                result = true;
            }
        }
        return result;
    }
    
    //
    private boolean isEmpty(){
        return this.TabelListBarang.getModel().getRowCount()<=0;
    }
    //
    private void CekKeranjang(){
        if(isEmpty()) {
            this.ButtonSave.setEnabled(false);
            this.ButtonRemove.setEnabled(false);
        } else {
            this.ButtonSave.setEnabled(true);
            this.ButtonRemove.setEnabled(true);
        }
    }
    
    //
    
    private void newtrns() {
        this.TextJumlah.setText("");
        this.TextCode.setText("");
        this.ButtonNew.setEnabled(true);
        this.ButtonSave.setEnabled(false);
        this.ButtonCancel.setEnabled(false);
        this.ButtonAdd.setEnabled(false);
        this.ButtonRemove.setEnabled(false);
        this.TextJumlah.setEnabled(false);
        this.ComboBox.setEnabled(false);
        this.tbModel.setRowCount(0);
        this.keranjang.clear();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TextCode = new javax.swing.JTextField();
        ButtonNew = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ComboBox = new JComboBox<Item>(this.comboModel.toArray());
        ButtonAdd = new javax.swing.JButton();
        TextJumlah = new javax.swing.JTextField();
        ButtonSave = new javax.swing.JButton();
        ButtonCancel = new javax.swing.JButton();
        ButtonRemove = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelListBarang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Code");

        TextCode.setEnabled(false);
        TextCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextCodeActionPerformed(evt);
            }
        });

        ButtonNew.setText("New");
        ButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNewActionPerformed(evt);
            }
        });

        jLabel2.setText("Items");

        ComboBox.setEnabled(false);
        ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerformed(evt);
            }
        });

        ButtonAdd.setText("Add");
        ButtonAdd.setEnabled(false);
        ButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddActionPerformed(evt);
            }
        });

        ButtonSave.setText("Save");
        ButtonSave.setEnabled(false);
        ButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSaveActionPerformed(evt);
            }
        });

        ButtonCancel.setText("Cancel");
        ButtonCancel.setEnabled(false);
        ButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelActionPerformed(evt);
            }
        });

        ButtonRemove.setText("Remove");
        ButtonRemove.setEnabled(false);
        ButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRemoveActionPerformed(evt);
            }
        });

        TabelListBarang.setModel(this.tbModel);
        jScrollPane2.setViewportView(TabelListBarang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(TextCode, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(TextJumlah)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(ButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(269, 269, 269))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ButtonNew, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                        .addComponent(ButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(ButtonRemove))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonNew))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonAdd)
                    .addComponent(TextJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonRemove)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCancel)
                    .addComponent(ButtonSave))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNewActionPerformed
        this.TextJumlah.setText("1");
        this.ButtonNew.setEnabled(false);
        this.ButtonCancel.setEnabled(true);
        this.ButtonAdd.setEnabled(true);
        this.TextJumlah.setEnabled(true);
        this.ComboBox.setEnabled(true);
        this.TextCode.setText(this.setCode());
    }//GEN-LAST:event_ButtonNewActionPerformed

    private void ButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSaveActionPerformed
        try {
            for (int i=0; i<tbModel.getRowCount(); i++){
                String nama = tbModel.getValueAt(i, 0).toString();
                float harga = new Float(tbModel.getValueAt(i, 1).toString());
                int jumlah = new Integer(tbModel.getValueAt(i, 2).toString());
                this.keranjang.add(new Item(nama,harga,jumlah));
            }
            DetTransaksi trns = new DetTransaksi(this.code, this.keranjang);
            StringBuilder str = new StringBuilder();
            str.append(trns.Info());
            JOptionPane.showMessageDialog(this, str ,"Detail Transaksi",JOptionPane.INFORMATION_MESSAGE);
            newtrns();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_ButtonSaveActionPerformed

    private void TextCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextCodeActionPerformed

    private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelActionPerformed
        newtrns();
        this.downId();
    }//GEN-LAST:event_ButtonCancelActionPerformed

    private void ButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddActionPerformed
        String nama = this.ComboBox.getSelectedItem().toString();
        int jumlah = new Integer(this.TextJumlah.getText());
        if(isDuplicate(nama)) {
            updateJumlah(nama,jumlah);
        }else{
            tbModel.addRow(TambahBarang(nama, jumlah));
        }
        this.CekKeranjang();
    }//GEN-LAST:event_ButtonAddActionPerformed

    private void ButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRemoveActionPerformed
        if(TabelListBarang.getSelectedRow()<0){
            String str = "Pilihlah Barang yang akan di hapus";
            JOptionPane.showMessageDialog(this, str,"Informasi", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int count = TabelListBarang.getSelectedRows().length;
            for(int i=0; i<count; i++){
                tbModel.removeRow(TabelListBarang.getSelectedRow());
            }
        }
        this.CekKeranjang();
    }//GEN-LAST:event_ButtonRemoveActionPerformed

    private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAdd;
    private javax.swing.JButton ButtonCancel;
    private javax.swing.JButton ButtonNew;
    private javax.swing.JButton ButtonRemove;
    private javax.swing.JButton ButtonSave;
    private javax.swing.JComboBox<Item> ComboBox;
    private javax.swing.JTable TabelListBarang;
    private javax.swing.JTextField TextCode;
    private javax.swing.JTextField TextJumlah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
