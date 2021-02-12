package images;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class ControladorImagenes {

    public Icon reservado(){
        ImageIcon i =   new ImageIcon(getClass().getResource("reservado.png"));
        Icon icino = new ImageIcon(i.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
        return icino;
    }

    public Icon arrendamiento(){
        
        ImageIcon i =   new ImageIcon(getClass().getResource("aparcamientoArrendar.png"));
        Icon icino = new ImageIcon(i.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
        return icino;
    }

    public Icon vacio(){
                ImageIcon i =   new ImageIcon(getClass().getResource("comprobar.png"));
        Icon icino = new ImageIcon(i.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
        return icino;
    }

    public Icon Ingreso(){
        ImageIcon i =   new ImageIcon(getClass().getResource("coche(1).png"));
        Icon icino = new ImageIcon(i.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
        return icino;
    }
}
