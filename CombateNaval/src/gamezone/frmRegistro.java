/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gamezone;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.parser.TokenType;

/**
 *
 * @author miguel
 */
public class frmRegistro extends javax.swing.JFrame {

    Connection conexion;
    /**
     * Creates new form frmRegistro
     */
    public frmRegistro() {
        initComponents();
        inicializaBaseDeDatos();
        setSize(540,320);
    }
    public void inicializaBaseDeDatos(){
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conexion = DriverManager.
                    getConnection("jdbc:mysql://"
                    + "localhost/gamerzone","root","");
        }catch(Exception ex){
            ex.printStackTrace();
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

        lbltag = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lblapellidop = new javax.swing.JLabel();
        lblapellidom = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        lblcontrasena = new javax.swing.JLabel();
        txtGamer = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidoP = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        lbllogo = new javax.swing.JLabel();
        lblconsulta = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lbltag.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltag.setText("GamerTag");
        getContentPane().add(lbltag);
        lbltag.setBounds(10, 10, 60, 23);

        lblnombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblnombre.setText("Nombre");
        getContentPane().add(lblnombre);
        lblnombre.setBounds(10, 90, 60, 15);

        lblapellidop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblapellidop.setText("Apellido  Paterno");
        getContentPane().add(lblapellidop);
        lblapellidop.setBounds(10, 130, 106, 15);

        lblapellidom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblapellidom.setText("Apellido Materno");
        getContentPane().add(lblapellidom);
        lblapellidom.setBounds(10, 170, 105, 20);

        lblemail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblemail.setText("E-mail");
        getContentPane().add(lblemail);
        lblemail.setBounds(10, 210, 36, 20);

        lblcontrasena.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcontrasena.setText("Contraseña");
        getContentPane().add(lblcontrasena);
        lblcontrasena.setBounds(10, 50, 70, 15);

        txtGamer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGamerActionPerformed(evt);
            }
        });
        getContentPane().add(txtGamer);
        txtGamer.setBounds(120, 5, 180, 28);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre);
        txtNombre.setBounds(120, 85, 180, 30);

        txtApellidoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoPActionPerformed(evt);
            }
        });
        getContentPane().add(txtApellidoP);
        txtApellidoP.setBounds(120, 125, 180, 28);
        getContentPane().add(txtApellidoM);
        txtApellidoM.setBounds(120, 165, 180, 28);
        getContentPane().add(txtEmail);
        txtEmail.setBounds(120, 205, 180, 28);

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar);
        btnRegistrar.setBounds(210, 250, 89, 30);

        lbllogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/gamerzone/registro.png"))); // NOI18N
        lbllogo.setText("jLabel8");
        getContentPane().add(lbllogo);
        lbllogo.setBounds(310, 50, 200, 190);

        lblconsulta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(lblconsulta);
        lblconsulta.setBounds(310, 5, 180, 28);
        getContentPane().add(txtContrasena);
        txtContrasena.setBounds(120, 45, 180, 28);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGamerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGamerActionPerformed
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM usuarios WHERE gamertag=?");
            consulta.setString(1,txtGamer.getText());
            ResultSet rs = consulta.executeQuery();
            if(rs.next()){
                lblconsulta.setText("No Disponible");
                lblconsulta.setForeground(Color.red);
                btnRegistrar.setEnabled(false);
            }else{
                lblconsulta.setText("Disponible");
                lblconsulta.setForeground(Color.blue);
                btnRegistrar.setEnabled(true);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }                         
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGamerActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
        String nombre = txtNombre.getText();
        String apellidop = txtApellidoP.getText();
        String apellidom = txtApellidoM.getText();
        String email = txtEmail.getText();
        String gamertag = txtGamer.getText();
        String contrasena = txtContrasena.getText();
        if (nombre.length() == 0 || apellidop.length() == 0 
                || apellidom.length() == 0 || email.length() == 0 
                || gamertag.length() == 0 || contrasena.length() == 0)
            {
                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos para registrar.");
                return;
        }
        try{            
           PreparedStatement consulta = conexion.prepareStatement(""
                    + "INSERT INTO usuarios(nombre,apellidop,apellidom"
                   + ",email,gamertag,contrasena) VALUES (?,?,?,?,?,?)");                  
           consulta.setString(1, nombre);
           consulta.setString(2, apellidop);
           consulta.setString(3, apellidom);
           consulta.setString(4, email);
           consulta.setString(5, gamertag);
           consulta.setString(6, contrasena);   
           
           
           consulta.executeUpdate();
           frmLogin frmLogin1 = new frmLogin();           
           frmLogin1.setVisible(true);
           this.dispose();
           
            }catch(Exception e){
            e.printStackTrace();       
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoPActionPerformed

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
            java.util.logging.Logger.getLogger(frmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel lblapellidom;
    private javax.swing.JLabel lblapellidop;
    private javax.swing.JLabel lblconsulta;
    private javax.swing.JLabel lblcontrasena;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lbltag;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGamer;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
