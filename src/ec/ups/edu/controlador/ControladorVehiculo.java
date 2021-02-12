package ec.ups.edu.controlador;

import ec.ups.edu.modelo.Usuario;
import ec.ups.edu.modelo.Vehiculo;
import static ec.ups.edu.utils.UtilsJPA.getEntityManager;
import java.util.Iterator;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.swing.JComboBox;

/**
 *
 * @author Estudiantes
 */
public class ControladorVehiculo extends AbstractControlador<Vehiculo> {

    private static ControladorVehiculo instancia;

    public static ControladorVehiculo getInstancia() {

        if (instancia == null) {

            instancia = new ControladorVehiculo();

        }

        return instancia;

    }

    @Override
    public boolean validacion(Vehiculo objeto) throws Exception {
        return true;
    }

    public Vehiculo buscar(String placa) {

        EntityManager em = getEntityManager();

        try {

            String jpql = "Select u from Vehiculo u where u.placa='" + placa + "'";
            Vehiculo v = (Vehiculo) em.createQuery(jpql).getSingleResult();

            return v;

        } catch (NoResultException e) {

            System.out.println("Error " + e);

        }

        return null;

    }

    public void llenarComboBox(JComboBox<Vehiculo> cbxVehiculo) {

        EntityManager em = getEntityManager();
        Iterator it = em.createQuery("SELECT v FROM Vehiculo v").getResultList().iterator();
        Vehiculo v;

        try {

            while (it.hasNext()) {

                v = (Vehiculo) it.next();
                cbxVehiculo.addItem(v);
                
            }

        } catch (Exception ex) {

            System.out.println("Error, no se puede listar datos en el combo" + ex);

        }

    }
    
    
    
    

}
