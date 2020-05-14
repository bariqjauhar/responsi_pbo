/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.w3c.dom.ls.LSOutput;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Reponsi extends javax.swing.JFrame {

    private void kosongkan_form(){
        txtDaerah.setEditable(true);
        txtDaerah.setText(null); 
        txtTanggal.setText(null);
        txtPositif.setText(null);
        txtODP.setText(null);
        txtPDP.setText(null);

    }
    
    private void tampilkan_data(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Daerah");
        model.addColumn("Tanggal");
        model.addColumn("Positif");
        model.addColumn("ODP");
        model.addColumn("PDP");
        model.addColumn("ZONA");

        try{
            String sql = "SELECT * FROM covid ";
            Connection conn =(Connection)Konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while(res.next()){
                if (res.getInt(4)>0){
                    //System.out.println("zona merah");
                    model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6), "zona merah"});
                }
                else {
                    //System.out.println("zona hijau");
                    model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6), "zona hijau"});
                }
                //model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)});
            }
            tabelCovid.setModel(model);

        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
//        DefaultTableModel model = new DefaultTableModel();
//        model.addColumn("Daerah");
//        model.addColumn("Tanggal");
//        model.addColumn("Positif");
//        model.addColumn("ODP");
//        model.addColumn("PDP");
//        model.addColumn("ZONA");
//
//        try{
//            String sql = "SELECT daerah,sum(tanggal),sum(positif),sum(ODP),sum(PDP),sum(zona) FROM covid GROUP BY negara ASC";
//            Connection conn =(Connection)Konfig.configDB();
//            java.sql.Statement stm = conn.createStatement();
//            java.sql.ResultSet res = stm.executeQuery(sql);
//
//            while(res.next()){
//                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)});
//            }
//            tabelCovid.setModel(model);
//
//        }catch (SQLException e){
//            System.out.println("Error : " + e.getMessage());
//        }
//    }
    
     private void tampilkan_data2() {
         DefaultTableModel model = new DefaultTableModel();
         model.addColumn("Id");
         model.addColumn("Daerah");
         model.addColumn("Tanggal");
         model.addColumn("Positif");
         model.addColumn("ODP");
         model.addColumn("PDP");
         model.addColumn("ZONA");

         try{
             String sql = "SELECT * FROM covid WHERE daerah='"+txtDaerah.getText()+"' ORDER BY tanggal ASC";
             Connection conn =(Connection)Konfig.configDB();
             java.sql.Statement stm = conn.createStatement();
             java.sql.ResultSet res = stm.executeQuery(sql);

             while(res.next()){
                 if (res.getInt(4)>0){
                     //System.out.println("zona merah");
                     model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6), "zona merah"});
                 }
                 else {
                     //System.out.println("zona hijau");
                     model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6), "zona hijau"});
                 }
                 //model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)});
             }
             tabelCovid.setModel(model);

         }catch (SQLException e){
             System.out.println("Error : " + e.getMessage());
         }
     }
//    DefaultTableModel model = new DefaultTableModel();
//        model.addColumn("Id");
//        model.addColumn("Daerah");
//        model.addColumn("Tanggal");
//        model.addColumn("Positif");
//        model.addColumn("ODP");
//        model.addColumn("PDP");
//        model.addColumn("ZONA");
//
//        try{
//            String sql = "SELECT * FROM covid WHERE daerah='"+txtDaerah.getText()+"' ORDER BY tanggal ASC";
//            Connection conn =(Connection)Konfig.configDB();
//            java.sql.Statement stm = conn.createStatement();
//            java.sql.ResultSet res = stm.executeQuery(sql);
//
//            while(res.next()){
//                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7)});
//            }
//            tabelCovid.setModel(model);
//
//        }catch (SQLException e){
//            System.out.println("Error : " + e.getMessage());
//        }
//}
    
    public Reponsi() {
        initComponents();
        kosongkan_form();
        tampilkan_data();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDaerah = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        txtPositif = new javax.swing.JTextField();
        txtODP = new javax.swing.JTextField();
        txtPDP = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelCovid = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btKembali = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Daerah");

        jLabel2.setText("Tanggal");

        jLabel3.setText("Positif");

        jLabel4.setText("ODP");

        jLabel5.setText("PDP");

        txtDaerah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDaerahActionPerformed(evt);
            }
        });

        txtTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTanggalActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.setPreferredSize(new java.awt.Dimension(77, 25));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.setMaximumSize(new java.awt.Dimension(75, 25));
        btnEdit.setMinimumSize(new java.awt.Dimension(75, 25));
        btnEdit.setPreferredSize(new java.awt.Dimension(77, 25));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.setPreferredSize(new java.awt.Dimension(77, 25));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnKeluar.setText("Keluar");
        btnKeluar.setPreferredSize(new java.awt.Dimension(77, 25));
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        btnCari.setText("Cari");
        btnCari.setPreferredSize(new java.awt.Dimension(77, 25));
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        tabelCovid.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelCovid.setEditingColumn(0);
        tabelCovid.setEditingRow(0);
        tabelCovid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelCovidMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelCovid);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("PANDEMI COVID 19");

        btKembali.setText("Kembali");
        btKembali.setMaximumSize(new java.awt.Dimension(75, 25));
        btKembali.setMinimumSize(new java.awt.Dimension(75, 25));
        btKembali.setPreferredSize(new java.awt.Dimension(77, 25));
        btKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKembaliActionPerformed(evt);
            }
        });

        jLabel6.setText("mm/dd/yy");

        jLabel8.setText("ID");
        jLabel8.setEnabled(false);

        txtID.setEnabled(false);

        jLabel9.setText("*untuk edit dan hapus, cari negara terlebih dahulu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel8)
                                .addGap(12, 12, 12)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel1)
                                .addGap(35, 35, 35)
                                .addComponent(txtDaerah, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel2)
                                .addGap(33, 33, 33)
                                .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(42, 42, 42)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtPositif, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                            .addComponent(txtODP)
                                            .addComponent(txtPDP))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(195, 195, 195))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8))
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtDaerah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2)))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(txtPositif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4))
                    .addComponent(txtODP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5))
                    .addComponent(txtPDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jLabel9)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTanggalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
         try{
            String sql = "INSERT INTO covid (daerah,tanggal,positif,ODP,PDP) VALUES ('"+txtDaerah.getText()+"','"+txtTanggal.getText()+"','"+txtPositif.getText()+"','"+txtODP.getText()+"','"+txtPDP.getText()+"')";
             //String sql = "INSERT INTO covid (negara,tanggal,positif,sembuh,meninggal) VALUES ('"+txtNegara.getText()+"','"+txtTanggal.getText()+"','"+txtPositif.getText()+"','"+txtSembuh.getText()+"','"+txtMeninggal.getText()+"')";
            Connection conn = (Connection)Konfig.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Proses Simpan Data Berhasil..");
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());  
        }
        tampilkan_data2();
        kosongkan_form();
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tabelCovidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelCovidMouseClicked
        try{
        int baris = tabelCovid.rowAtPoint(evt.getPoint());
        String id = tabelCovid.getValueAt(baris, 0).toString();
        txtID.setText(id);
        String daerah = tabelCovid.getValueAt(baris, 1).toString();
        txtDaerah.setText(daerah);
        String tanggal = tabelCovid.getValueAt(baris, 2).toString();
        txtTanggal.setText(tanggal);
        String positif = tabelCovid.getValueAt(baris, 3).toString();
        txtPositif.setText(positif);
        String ODP = tabelCovid.getValueAt(baris, 4).toString();
        txtODP.setText(ODP);
        String PDP = tabelCovid.getValueAt(baris, 5).toString();
        txtPDP.setText(PDP);
//        String zona = tabelCovid.getValueAt(baris, 6).toString();
//        txtPDP.setText(zona);
        }catch (Exception e){
             kosongkan_form();
            JOptionPane.showMessageDialog(this,"Hanya bisa diedit setelah proses cari");
            
        }
    }//GEN-LAST:event_tabelCovidMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try{
            String sql = "UPDATE covid SET daerah='"+txtDaerah.getText()+"',tanggal='"+txtTanggal.getText()+"',positif='"+txtPositif.getText()+"',ODP='"+txtODP.getText()+"',PDP='"+txtPDP.getText()+"' WHERE id='"+txtID.getText()+"'";
            Connection conn = (Connection)Konfig.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Proses Edit Data Berhasil..");
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampilkan_data2();
        kosongkan_form();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try{
            String sql = "DELETE FROM covid WHERE daerah='"+txtDaerah.getText()+"'";
            Connection conn = (Connection)Konfig.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Proses Hapus Data Berhasil..");
        }catch (Exception e){
             kosongkan_form();
            JOptionPane.showMessageDialog(this,"Hanya bisa diedit setelah proses cari");
        }
        tampilkan_data();
        kosongkan_form();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnKeluarActionPerformed

   
    
    private void btnCariActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Daerah");
        model.addColumn("Tanggal");
        model.addColumn("Positif");
        model.addColumn("ODP");
        model.addColumn("PDP");
        model.addColumn("zona");
        
        try{
            String sql = "SELECT * FROM covid WHERE daerah='"+txtDaerah.getText()+"' ORDER BY tanggal ASC";
            Connection conn =(Connection)Konfig.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                if (res.getInt(4)>0){
                    //System.out.println("zona merah");
                    model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6), "zona merah"});
                }
                else {
                    //System.out.println("zona hijau");
                    model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6), "zona hijau"});
                }

               // model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6), /*"zona merah"*/});
            }
            tabelCovid.setModel(model);
            
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
         kosongkan_form();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKembaliActionPerformed
        kosongkan_form();
        tampilkan_data();
    }//GEN-LAST:event_btKembaliActionPerformed

    private void txtDaerahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDaerahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDaerahActionPerformed

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
            java.util.logging.Logger.getLogger(Reponsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reponsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reponsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reponsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reponsi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btKembali;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelCovid;
    private javax.swing.JTextField txtDaerah;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtODP;
    private javax.swing.JTextField txtPDP;
    private javax.swing.JTextField txtPositif;
    private javax.swing.JTextField txtTanggal;
    // End of variables declaration//GEN-END:variables
}
