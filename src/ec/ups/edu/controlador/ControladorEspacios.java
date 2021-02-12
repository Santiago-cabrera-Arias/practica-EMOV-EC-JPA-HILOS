package ec.ups.edu.controlador;

import ec.ups.edu.modelo.Parqueadero;
import images.ControladorImagenes;
import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author santi
 */
public class ControladorEspacios extends Thread {

    JPanel panel;
    JLabel label;
    String tipoContrato;
    int pos;
    Thread tread;
    ControladorImagenes controladorImagenes;
    ControladorParqueadero controladorParqueadero;
    String ingreso;

    public ControladorEspacios(JPanel panel, int posicion, String ingreso) {

        this.panel = panel;
        this.tipoContrato = tipoContrato;
        this.pos = posicion;
        this.controladorImagenes = new ControladorImagenes();
        this.controladorParqueadero = new ControladorParqueadero();
        this.ingreso = ingreso;
        //Creamos un hilo

        tread = new Thread(this);
        tread.start();

    }

    @Override
    public void run() {

        posicion();
        if (ingreso.equals("ingreso")) {

            ingresoAParqueadero();
            verParqueadero();
            
        } else {

            verParqueadero();
            salirParqueadero();

        }

        

    }//fin run

    int ejex = 130;
    int ejey = 20;

    public void posicion() {

        int filas = 5;
        int columnas = 10;
        int cont = 1;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                if (cont == pos) {

                    return;

                }
                cont++;
                ejex += 45;

            }

            ejex = 130;
            ejey += 100;

        }
    }

    
    
    public void verParqueadero() {

        panel.removeAll();
        panel.updateUI();
        
        int filas = 5;
        int columnas = 10;
        int cont = 1;
         int x = 130;
        int y = 20;

        List<Parqueadero> listaP = controladorParqueadero.findAll();
        JLabel label[][] = new JLabel[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                Parqueadero parq = null;

                for (Parqueadero parqueadero1 : listaP) {

                    if (cont == parqueadero1.getPuesto()) {

                        if (!parqueadero1.getTipo().equals("retirado")) {

                            parq = parqueadero1;

                        }

                    }

                }

                if (parq == null) {

                    label[i][j] = new JLabel();
                    label[i][j].setBounds(x, y, 40, 40);
                    label[i][j].setText(" " + cont++ + " ");
                    label[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));

                    panel.add(label[i][j]);
                } else {

                    label[i][j] = new JLabel();
                    label[i][j].setBounds(x, y, 40, 40);
                    label[i][j].setText(" " + cont++ + " ");
                    label[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));

                    if (parq.getTipo().equals("ingreso")) {

                        label[i][j].setIcon(new ImageIcon(getClass().getResource("carro-deportivo.png")));

                    } else if (parq.getTipo().equals("ingreso")) {

                        label[i][j].setIcon(new ImageIcon(getClass().getResource("carro-deportivo.png")));

                    }

                }

                panel.add(label[i][j]);

                x += 45;

            }

            x = 130;
            y += 100;

        }

        panel.updateUI();
    }

    public void ingresoAParqueadero() {

        label = new JLabel();
        //Le asignamos una imagen al label
        label.setIcon(new ImageIcon(getClass().getResource("carro-deportivo.png")));
        //indicamos el tamanio del label
        label.setSize(24, 24);
        //Indicamos en donde se posicionara el label
        label.setLocation(0, 0);
        //aniadimos el label al panel.
        label.setVisible(true);
        panel.add(label);
        panel.updateUI();

        for (int i = 0; i < ejey + 40; i += 20) {
            try {

                label.setLocation(0, i);

                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControladorEspacios.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        for (int i = 0; i < ejex; i += 20) {

            try {
                label.setLocation(i, ejey + 40);
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControladorEspacios.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        for (int i = ejey + 40; i > ejey; i -= 10) {

            try {
                label.setLocation(ejex, i);
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControladorEspacios.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        label.setVisible(false);
    }

    public void salirParqueadero() {

        label = new JLabel();
        //Le asignamos una imagen al label
        label.setIcon(new ImageIcon(getClass().getResource("carro-deportivo.png")));
        //indicamos el tamanio del label
        label.setSize(24, 24);
        //Indicamos en donde se posicionara el label
        label.setLocation(ejex, ejey);
        //aniadimos el label al panel.
        label.setVisible(true);
        panel.add(label);
        panel.updateUI();

        for (int i = ejex; i < 600; i += 20) {

            try {
                label.setLocation(i, ejey + 40);
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControladorEspacios.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        for (int i = ejey + 40; i < 498; i += 20) {

            try {
                label.setLocation(600, i);
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControladorEspacios.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        label.setVisible(false);

    }

}
