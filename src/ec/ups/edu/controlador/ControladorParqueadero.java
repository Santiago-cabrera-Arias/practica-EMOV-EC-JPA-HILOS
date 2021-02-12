package ec.ups.edu.controlador;

import ec.ups.edu.modelo.Parqueadero;
import static ec.ups.edu.modelo.Parqueadero_.puesto;
import ec.ups.edu.modelo.Usuario;
import static ec.ups.edu.utils.UtilsJPA.getEntityManager;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author Estudiantes
 */
public class ControladorParqueadero extends AbstractControlador<Parqueadero> {

    private Parqueadero parqueadero;

    private static ControladorParqueadero instancia;

    public static ControladorParqueadero getInstancia() {

        if (instancia == null) {

            instancia = new ControladorParqueadero();

        }

        return instancia;

    }

    @Override
    public boolean validacion(Parqueadero objeto) throws Exception {
        return true;
    }

  /*  public Parqueadero buscar(int espacio) {

        EntityManager em = getEntityManager();
        //List<Parqueadero> lista = new ArrayList<>();

        try {

            String jpql = "Select p from Parqueadero p where p.puesto='" + espacio + "'";
            Parqueadero par = (Parqueadero) em.createQuery(jpql).getResultList();

            
                if (parqueadero1.getPuesto() == espacio && !parqueadero1.getTipo().equals("retirado")) {

                    return parqueadero1;

            

            }

        } catch (NoResultException e) {

            System.out.println("Error " + e);

        }

        return null;

    }
*/
}
