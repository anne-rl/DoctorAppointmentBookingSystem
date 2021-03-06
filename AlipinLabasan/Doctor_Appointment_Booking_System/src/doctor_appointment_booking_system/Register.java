/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor_appointment_booking_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author User
 */
public class Register extends javax.swing.JFrame {
    
    public RegistrationData registration;
    public Connection con=null;
    public ResultSet rs = null;
    public PreparedStatement ps = null;
    
    DBHelper dbh = new DBHelper();
    
    
    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
    }

    public void lettersOnly(java.awt.event.KeyEvent evt, JTextField tf){
        char c = evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c)){
            tf.setEditable(true);
        }
        else{
            tf.setEditable(false);
        }
    }
    public void numbersOnly(java.awt.event.KeyEvent evt, JTextField tf){
        char c = evt.getKeyChar();
        if(Character.isDigit(c)||Character.isWhitespace(c)||Character.isISOControl(c)){
            tf.setEditable(true);
        }
        else{
            tf.setEditable(false);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfFirstname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfLastname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfContactNum = new javax.swing.JTextField();
        tfUsername = new javax.swing.JTextField();
        pfFirst = new javax.swing.JPasswordField();
        pfReType = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tfEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 500, 40);

        jPanel1.setBackground(new java.awt.Color(129, 186, 216));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Firstname:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(90, 110, 70, 15);

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("REGISTRATION FORM");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(110, 30, 290, 40);

        tfFirstname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tfFirstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFirstnameActionPerformed(evt);
            }
        });
        tfFirstname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfFirstnameKeyPressed(evt);
            }
        });
        jPanel1.add(tfFirstname);
        tfFirstname.setBounds(210, 100, 170, 30);

        jLabel4.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Lastname:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(90, 160, 70, 15);

        tfLastname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tfLastname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfLastnameKeyPressed(evt);
            }
        });
        jPanel1.add(tfLastname);
        tfLastname.setBounds(210, 150, 170, 30);

        jLabel5.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contact Number:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(90, 210, 110, 15);

        tfContactNum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tfContactNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfContactNumKeyPressed(evt);
            }
        });
        jPanel1.add(tfContactNum);
        tfContactNum.setBounds(210, 200, 170, 30);

        tfUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(tfUsername);
        tfUsername.setBounds(210, 300, 170, 30);

        pfFirst.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pfFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfFirstActionPerformed(evt);
            }
        });
        jPanel1.add(pfFirst);
        pfFirst.setBounds(210, 350, 170, 30);

        pfReType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pfReType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfReTypeActionPerformed(evt);
            }
        });
        jPanel1.add(pfReType);
        pfReType.setBounds(210, 390, 170, 30);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Username:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(90, 310, 100, 15);

        jLabel6.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(90, 360, 80, 15);

        jLabel7.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Confirm Password:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(90, 400, 120, 15);

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 51));
        jButton1.setText("REGISTER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(120, 450, 110, 40);

        jButton2.setBackground(new java.awt.Color(153, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 51));
        jButton2.setText("CANCEL");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(270, 450, 100, 40);

        tfEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(tfEmail);
        tfEmail.setBounds(210, 250, 170, 30);

        jLabel8.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email Address:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(90, 260, 100, 15);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 40, 500, 540);

        setSize(new java.awt.Dimension(500, 580));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       /* boolean result;
        
        Border b = BorderFactory.createLineBorder(Color.RED, 3);
        Border defBorder = BorderFactory.createEmptyBorder();
        if(!tfFirstname.getText().trim().isEmpty()&& !tfLastname.getText().isBlank()&& !tfContactNum.getText().isBlank()&& !tfUsername.getText().isBlank()&& !pfFirst.getText().isBlank() && !pfReType.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Registered Successfully!");          
            this.dispose();
            
            
        }
        else{
             JOptionPane.showMessageDialog(null, "Fill-up every Fields");
             if(tfFirstname.getText().isBlank()){
                 tfFirstname.setBorder(b);
             }else{
                 tfFirstname.setBorder(defBorder);
             }
                 
             if(tfLastname.getText().isBlank()){
                 tfLastname.setBorder(b);
             }else{
                 tfLastname.setBorder(defBorder);
             }
             if(tfContactNum.getText().isBlank()){
                 tfContactNum.setBorder(b);
             }else{
                 tfContactNum.setBorder(defBorder);
             }
             if(tfEmail.getText().isBlank()){
                tfEmail.setBorder(b);
             }else{
                 tfEmail.setBorder(defBorder);
             }
             if(tfUsername.getText().isBlank()){
                 tfUsername.setBorder(b);
             }else{
                 tfUsername.setBorder(defBorder);
             }
             if(pfFirst.getText().isEmpty()){
                 pfFirst.setBorder(b);
             }else{
                 pfFirst.setBorder(defBorder);
             }
             if(pfReType.getText().trim().isEmpty()){
                 pfReType.setBorder(b);
             }else{
                 pfReType.setBorder(defBorder);
             }
             
        } */
    }//GEN-LAST:event_jButton1MouseClicked

    private void tfFirstnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFirstnameKeyPressed
        // TODO add your handling code here:
        lettersOnly(evt, tfFirstname);
    }//GEN-LAST:event_tfFirstnameKeyPressed

    private void tfLastnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLastnameKeyPressed
        // TODO add your handling code here:
        lettersOnly(evt, tfLastname);
    }//GEN-LAST:event_tfLastnameKeyPressed

    private void tfContactNumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfContactNumKeyPressed
        // TODO add your handling code here:
        numbersOnly(evt, tfContactNum);
    }//GEN-LAST:event_tfContactNumKeyPressed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        
        this.dispose();
         try {
             new UserLogin().setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:     
         
        Border b = BorderFactory.createLineBorder(Color.RED, 2);
        Border defBorder = BorderFactory.createLineBorder(Color.black);
        try {
        if(!tfFirstname.getText().isEmpty() && !tfLastname.getText().isEmpty() && !tfContactNum.getText().isEmpty() && !tfEmail.getText().isEmpty() && !tfUsername.getText().isEmpty() && !pfFirst.getText().isEmpty() &&  !pfReType.getText().isEmpty()){
            if(pfFirst.getText().equals(pfReType.getText())){
                System.out.println(pfFirst.getText() + pfReType.getText());
                   boolean result=false;
                   String  fname = tfFirstname.getText() ;
                   String lname = tfLastname.getText();
                   String contactNum = tfContactNum.getText();
                   String  email = tfEmail.getText();
                   String username = tfUsername.getText();
                   String password = pfFirst.getText();
                   if(!new DBHelper().searchUser(username)){
                       new DBHelper().addAccount(fname, lname, contactNum, email, username, password);
                       dispose();
                      // System.out.println("Ma Close MAN!");
                   }
                   else
                       JOptionPane.showMessageDialog(null, "Username Already exist!");            

            }else
                JOptionPane.showMessageDialog(this, "Password does not match!");
            
        } else{
                JOptionPane.showMessageDialog(this, "Fill empty fields!");
             if(tfFirstname.getText().isBlank()){
                 tfFirstname.setBorder(b);
             }else{
                 tfFirstname.setBorder(defBorder);
             }
                 
             if(tfLastname.getText().isBlank()){
                 tfLastname.setBorder(b);
             }else{
                 tfLastname.setBorder(defBorder);
             }
             if(tfContactNum.getText().isBlank()){
                 tfContactNum.setBorder(b);
             }else{
                 tfContactNum.setBorder(defBorder);
             }
             if(tfEmail.getText().isBlank()){
                tfEmail.setBorder(b);
             }else{
                 tfEmail.setBorder(defBorder);
             }
             if(tfUsername.getText().isBlank()){
                 tfUsername.setBorder(b);
             }else{
                 tfUsername.setBorder(defBorder);
             }
             if(pfFirst.getText().isEmpty()){
                 pfFirst.setBorder(b);
             }else{
                 pfFirst.setBorder(defBorder);
             }
             if(pfReType.getText().trim().isEmpty()){
                 pfReType.setBorder(b);
             }else{
                 pfReType.setBorder(defBorder);
             }
             
        }
             }catch(Exception ex){
               ex.printStackTrace();
            }
        
    

    
            
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfFirstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFirstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFirstnameActionPerformed

    private void pfFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfFirstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfFirstActionPerformed

    private void pfReTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfReTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfReTypeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
         try {
             new UserLogin().setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUsernameActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField pfFirst;
    private javax.swing.JPasswordField pfReType;
    private javax.swing.JTextField tfContactNum;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfFirstname;
    private javax.swing.JTextField tfLastname;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
