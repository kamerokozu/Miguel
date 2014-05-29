/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author FIMAZ
 */
public class frmBuscaminas extends javax.swing.JFrame implements ActionListener{
    int size=10;
    int width=40;
    JButton[][] botones = new JButton[size][size];
    int bombas[][] = new int[size][size];
    /**
     * Creates new form ventana
     */
    public frmBuscaminas() {
        initComponents();
        dibujaTablero();
        colocaMinas();
        setSize(600,500);
        panel.setOpaque(false);
    }
    
    public void colocaMinas(){
        int contadorBombas=0;   
        do{
            int fila = (int)Math.round(Math.random()*(size-1));
            int columna = (int)Math.round(Math.random()*(size-1));
            //System.out.println("fila "+fila+", columna: "+columna);
            bombas[fila][columna]=1;
           // botones[fila][columna].setText("B");
            contadorBombas++;
        }while(contadorBombas<25);
        
    }
    
    
    public int cuentaMinas(int fila, int columna){
       /*
        int minas = 0;
        int bomba=0;
        if(bombas[0][0]==0){
            if(bombas[fila][columna+1] == 1) bomba++;
            if(bombas[fila+1][columna] == 1) bomba++;
            if(bombas[fila+1][columna+1] == 1) bomba++;
            return bomba;
        }        
        if(bombas[fila-1][columna-1] == 1) minas++; //ezquina superior izquierda
        if(bombas[fila-1][columna] == 1) minas++; //arriba
        if(bombas[fila-1][columna+1] == 1) minas++; //ezquina superior derecha
        if(bombas[fila][columna-1] == 1) minas++; //izquierda
        if(bombas[fila][columna] == 1) minas++; //centro
        if(bombas[fila][columna+1] == 1) minas++; //derecha
        if(bombas[fila+1][columna-1] == 1) minas++; //ezquina inferior izquierda    
        if(bombas[fila+1][columna] == 1) minas++; //abajo
        if(bombas[fila+1][columna+1] == 1) minas++; //ezquina inferior derecha
        return minas;  
         */
         /*
                         *      x-filas
                         *      y-columnas
                         */

            int minas=0;
            for(int i = columna-1 ; i<= columna+1; i++){

                /*Horizontal*/
                if(i>-1 && i<size){
                        if(bombas[fila][i] == 1){
                                minas++;
                        }
                }
            }
                /*Vertical*/
                for(int j= fila-1 ; j<=fila+1; j++){
                                        if(j>-1 && j<size)
                                                if(bombas[j][columna] == 1){
                                                minas++;
                                                }
                                }
                
                /*Diagonales*/

                /*Esquina superior izquierda*/
                int w = fila;
                int z = columna;
                w--;
                z--;
                        for(int i=w; i<w+3 ; i++)
                                {
                                        if(i>-1 && i<size && z>-1 && z<size)
                                         if(bombas[i][z] == 1){
                                minas++;
                                }
                                z++;
                                }

                /*Esquina superior izquierda*/
                w = fila;
                z = columna;
                w--;
                z++;
                        for(int i = w ; i<w+3 ; i++)
                                {
                                        if(i>-1 && i<size && z>-1 && z<size)
                                         if(bombas[i][z] == 1){
                                minas++;
                                }
                                z--;
                                }
            return minas;
        
    }
    
    public void dibujaTablero(){
        for(int fila=0; fila <size; fila++){
            for(int columna=0; columna < size; columna++){    
                botones[fila][columna]= new JButton();
                botones[fila][columna].setBounds(columna*width,fila*width, width, width);
                botones[fila][columna].addActionListener(this);
                panel.add(botones[fila][columna]);                
            }
        }
    }
    
    void nuevoJuego(){
        for(int i = 0; i<size ; i++)
            for(int j=0 ; j<size ; j++)
                {
                bombas[i][j] = 0;
                botones[i][j].setText("");
                botones[i][j].setBackground(null);
                }
                colocaMinas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        lblfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        getContentPane().add(panel);
        panel.setBounds(10, 0, 400, 400);

        btnSalir.setBackground(new java.awt.Color(0, 0, 0));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(420, 70, 140, 40);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/gamerzone/tag.jpg"))); // NOI18N
        lblLogo.setText("jLabel1");
        getContentPane().add(lblLogo);
        lblLogo.setBounds(110, 420, 430, 50);

        lblfondo.setBackground(new java.awt.Color(0, 0, 0));
        lblfondo.setOpaque(true);
        getContentPane().add(lblfondo);
        lblfondo.setBounds(0, 0, 580, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        
        this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(frmBuscaminas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBuscaminas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBuscaminas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBuscaminas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBuscaminas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblfondo;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int fila=0; fila < size; fila++){
            for(int columna=0; columna < size; columna++){    
                if(botones[fila][columna]==e.getSource()){
                    botones[fila][columna].setText(String.valueOf(cuentaMinas(fila, columna)));
                    
                    if(bombas[fila][columna]==1){
                        JOptionPane.showMessageDialog(this, "Has perdido!!");
                        nuevoJuego();
                    }
                }               
            }
        }        
    }
}
