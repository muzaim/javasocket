/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sayhello;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class ChatMe extends javax.swing.JFrame implements Runnable{
    Socket client; // class socket untuk client
    ServerSocket server; // class socket untuk server
    BufferedReader server_reader, client_reader; // buffered messege
        BufferedWriter server_writer, client_writer; // buffered typing
    /**
     * Creates new form ChatMe
     */
    public ChatMe() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cboConnection = new javax.swing.JComboBox<>();
        btnConnect = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        listMessege = new java.awt.List();
        txtMessege = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));

        cboConnection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Server", "Client" }));
        cboConnection.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboConnectionItemStateChanged(evt);
            }
        });
        cboConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboConnectionActionPerformed(evt);
            }
        });

        btnConnect.setText("ON");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        btnSend.setText("Kirim");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMessege)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSend))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cboConnection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConnect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(listMessege, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboConnection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConnect)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listMessege, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMessege, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboConnectionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboConnectionItemStateChanged
        if(cboConnection.getSelectedItem().equals("Server")){
            btnConnect.setText("ON");
            txtUsername.setText("Server");
        } else {
            btnConnect.setText("Hubungkan");
            txtUsername.setText("");
        }
    }//GEN-LAST:event_cboConnectionItemStateChanged

    private void cboConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboConnectionActionPerformed

    }//GEN-LAST:event_cboConnectionActionPerformed

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        if(btnConnect.getText().equals("Hubungkan")){
            btnConnect.setText("Putuskan");
            client_connection();
            Thread thread = new Thread((Runnable) this);
            thread.start();
        } else if (cboConnection.getSelectedItem().equals("Server")){
            btnConnect.setText("OFF");
            read_connection();
            Thread thread = new Thread((Runnable) this);
            thread.start();
        }
    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        try {
            server_writer.write(txtUsername.getText() + ": " + txtMessege.getText());
            server_writer.newLine();
            server_writer.flush();
        }
        catch (IOException e){
            Logger.getLogger(ChatMe.class.getName()).log(Level.SEVERE, null, e);
        }
        listMessege.add("Me: "+txtMessege.getText());
        txtMessege.setText("");
    }//GEN-LAST:event_btnSendActionPerformed

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
            java.util.logging.Logger.getLogger(ChatMe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatMe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatMe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatMe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatMe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnSend;
    private javax.swing.JComboBox<String> cboConnection;
    private javax.swing.JPanel jPanel1;
    private java.awt.List listMessege;
    private javax.swing.JTextField txtMessege;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void client_connection() {
         try {
            String ip   = JOptionPane.showInputDialog("Masukkan Alamat IP Server!");
            client      = new Socket(ip, 2000);
            cboConnection.setEnabled(false);
            server_reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            server_writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            btnConnect.setText("Putuskan");
        } catch (UnknownHostException e){
            System.err.println("Akses ke server gagal!");
            System.exit(-1);
        } catch (IOException e){
            Logger.getLogger(ChatMe.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void read_connection() {
      try {
            try {
                try {
                    server  = new ServerSocket(2000);
                    this.setTitle("Mohon Tunggu Sebentar ...");
                }
                catch(IOException e){
                    System.err.println("Gagal membuat server");
                    System.exit(-1);
                }
                client = server.accept();
                this.setTitle("Terhubung ke "+client.getInetAddress());
            }
            catch(IOException e){
                System.err.println("Akses ditolak");
                System.exit(-1);
            }
            server_reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            server_writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } 
        catch(IOException e){
            System.err.println("Tidak dapat membaca pesan");
            System.exit(-1);
        }
    }
    private void disconnected_by_client(){
        try {
            client.close();
            server_reader.close();
            server_writer.close();
            cboConnection.setEnabled(true);
            btnConnect.setText("Hubungkan");
        } catch(IOException e){
            Logger.getLogger(ChatMe.class.getName()).log(Level.SEVERE, null, e);
        }
    }
     private void stopped_by_server(){
        try {
            server_reader.close();
            server_writer.close();
            btnConnect.setText("ON");
            this.setTitle("Terputus");
        }
        catch (IOException e){
            Logger.getLogger(ChatMe.class.getName()).log(Level.SEVERE, null, e);
        }}

    @Override
    public void run() {
       while (true) {
            try {
                listMessege.add(server_reader.readLine());
            } catch (IOException e) {
                Logger.getLogger(ChatMe.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
