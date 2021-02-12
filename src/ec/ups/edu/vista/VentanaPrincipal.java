/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.vista;

import ec.ups.edu.controlador.ControladorEspacios;
import ec.ups.edu.controlador.ControladorParqueadero;
import ec.ups.edu.controlador.ControladorUsuario;
import ec.ups.edu.controlador.ControladorVehiculo;
import images.ControladorImagenes;
import ec.ups.edu.modelo.Parqueadero;
import ec.ups.edu.modelo.Usuario;
import ec.ups.edu.modelo.Vehiculo;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author santi
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    ControladorUsuario controladorUsuario;
    Usuario usuario;
    ControladorVehiculo controladorVehiculo;
    Vehiculo vehiculo;
    ControladorParqueadero controladorParqueadero;
    Parqueadero parqueadero;
    ControladorImagenes controladorImagenes;
    
    VentanaRegistrarse ventanaRegistrarse;
    VentanaIniciarSesion ventanaIniciarSesion;
    VentanaIngresarVehiculo ventanaIngresarVehiculo;
    VentanaParqueadero ventanaParqueadero;
    //ControladorFabVehiculos controladorFabVehiculos;
    ControladorEspacios controladorEspacios;
    VentanaRegistroUsuarios ventanaRegistroUsuarios;
    VentanaRegistroParqueadero ventanaRegistroParqueadero;
    
    public VentanaPrincipal() {
        initComponents();
        
        controladorUsuario = ControladorUsuario.getInstancia();
        controladorVehiculo = ControladorVehiculo.getInstancia();
        controladorParqueadero = ControladorParqueadero.getInstancia();
        usuario = new Usuario();
        vehiculo = new Vehiculo();
        parqueadero = new Parqueadero();
        ventanaRegistrarse = new VentanaRegistrarse(controladorUsuario, usuario);
        ventanaIniciarSesion = new VentanaIniciarSesion(controladorUsuario, usuario, this);
        ventanaParqueadero = new VentanaParqueadero(vehiculo, controladorVehiculo, parqueadero, controladorParqueadero, controladorImagenes);
        ventanaIngresarVehiculo = new VentanaIngresarVehiculo(usuario, controladorUsuario, ventanaParqueadero);
        //itemVentanaIngresoVehiculo.setVisible(false);
        ventanaRegistroUsuarios = new VentanaRegistroUsuarios();
        ventanaRegistroParqueadero = new VentanaRegistroParqueadero();
        itemMenuRegistros.setVisible(false);
        menuGestion.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        itemRegistrarse = new javax.swing.JMenuItem();
        itemIniciarSesion = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        menuGestion = new javax.swing.JMenu();
        itemVentanaIngresoVehiculo = new javax.swing.JMenuItem();
        itemVentanaParqueadero = new javax.swing.JMenuItem();
        itemMenuRegistros = new javax.swing.JMenu();
        itemRegistroUsuariios = new javax.swing.JMenuItem();
        itemRegistrosParqueaderos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Inicio");

        itemRegistrarse.setMnemonic('o');
        itemRegistrarse.setText("Registrarse");
        itemRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistrarseActionPerformed(evt);
            }
        });
        fileMenu.add(itemRegistrarse);

        itemIniciarSesion.setMnemonic('s');
        itemIniciarSesion.setText("Iniciar Sesion");
        itemIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemIniciarSesionActionPerformed(evt);
            }
        });
        fileMenu.add(itemIniciarSesion);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        menuGestion.setMnemonic('e');
        menuGestion.setText("Gestion");

        itemVentanaIngresoVehiculo.setMnemonic('t');
        itemVentanaIngresoVehiculo.setText("Ventana Ingreso Vehiculo");
        itemVentanaIngresoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVentanaIngresoVehiculoActionPerformed(evt);
            }
        });
        menuGestion.add(itemVentanaIngresoVehiculo);

        itemVentanaParqueadero.setMnemonic('d');
        itemVentanaParqueadero.setText("Ventana Parqueadero");
        itemVentanaParqueadero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVentanaParqueaderoActionPerformed(evt);
            }
        });
        menuGestion.add(itemVentanaParqueadero);

        menuBar.add(menuGestion);

        itemMenuRegistros.setMnemonic('e');
        itemMenuRegistros.setText("Registros");

        itemRegistroUsuariios.setMnemonic('t');
        itemRegistroUsuariios.setText("Registro de Usuarios");
        itemRegistroUsuariios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistroUsuariiosActionPerformed(evt);
            }
        });
        itemMenuRegistros.add(itemRegistroUsuariios);

        itemRegistrosParqueaderos.setMnemonic('d');
        itemRegistrosParqueaderos.setText("Registro de parqueadero");
        itemRegistrosParqueaderos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistrosParqueaderosActionPerformed(evt);
            }
        });
        itemMenuRegistros.add(itemRegistrosParqueaderos);

        menuBar.add(itemMenuRegistros);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void itemRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistrarseActionPerformed
        
        desktopPane.add(ventanaRegistrarse);
        ventanaRegistrarse.setVisible(true);

    }//GEN-LAST:event_itemRegistrarseActionPerformed

    private void itemIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemIniciarSesionActionPerformed
        
        desktopPane.add(ventanaIniciarSesion);
        ventanaIniciarSesion.setVisible(true);

    }//GEN-LAST:event_itemIniciarSesionActionPerformed

    private void itemVentanaIngresoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVentanaIngresoVehiculoActionPerformed
        
        desktopPane.add(ventanaIngresarVehiculo);
        ventanaIngresarVehiculo.setVisible(true);

    }//GEN-LAST:event_itemVentanaIngresoVehiculoActionPerformed

    private void itemVentanaParqueaderoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVentanaParqueaderoActionPerformed
        
        desktopPane.add(ventanaParqueadero);
        ventanaParqueadero.setVisible(true);

    }//GEN-LAST:event_itemVentanaParqueaderoActionPerformed

    private void itemRegistroUsuariiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistroUsuariiosActionPerformed
        
        desktopPane.add(ventanaRegistroUsuarios);
        ventanaRegistroUsuarios.setVisible(true);

    }//GEN-LAST:event_itemRegistroUsuariiosActionPerformed

    private void itemRegistrosParqueaderosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistrosParqueaderosActionPerformed
        
        desktopPane.add(ventanaRegistroParqueadero);
        ventanaRegistroParqueadero.setVisible(true);
        
    }//GEN-LAST:event_itemRegistrosParqueaderosActionPerformed
    
    public JMenuItem getVentanaIngresoVehicuo() {
        
        return itemVentanaIngresoVehiculo;
        
    }
    
    public JMenu getMenuVentanaRegistros() {
        
        return itemMenuRegistros;
        
    }
    
    public JMenu getMaenuGestion(){
        
        return menuGestion;
        
    }

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem itemIniciarSesion;
    private javax.swing.JMenu itemMenuRegistros;
    private javax.swing.JMenuItem itemRegistrarse;
    private javax.swing.JMenuItem itemRegistroUsuariios;
    private javax.swing.JMenuItem itemRegistrosParqueaderos;
    private javax.swing.JMenuItem itemVentanaIngresoVehiculo;
    private javax.swing.JMenuItem itemVentanaParqueadero;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuGestion;
    // End of variables declaration//GEN-END:variables

}
