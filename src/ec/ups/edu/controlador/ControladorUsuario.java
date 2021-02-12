/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.controlador;

import ec.ups.edu.modelo.Usuario;
import static ec.ups.edu.utils.UtilsJPA.getEntityManager;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author santi
 */
public class ControladorUsuario extends AbstractControlador<Usuario> {

    private static ControladorUsuario instancia;

    public static ControladorUsuario getInstancia() {

        if (instancia == null) {

            instancia = new ControladorUsuario();

        }

        return instancia;

    }

    public boolean iniciarSesion(String correo, String contrasena, String tipoUsuario) {

        System.out.println(correo);
        System.out.println(contrasena);
        System.out.println(tipoUsuario);

        EntityManager em = getEntityManager();

        List<Usuario> lista = new ArrayList<>();

        try {

            String jpql = "Select u from Usuario u where u.correo='" + correo + "'";
            //String jpql1 = "Select u from Usuario u where u.tipousuario='" + tipoUsuario + "'";

            Usuario usuario = (Usuario) em.createQuery(jpql).getSingleResult();
            //Usuario usuario1 = (Usuario) em.createQuery(jpql).getSingleResult();

            System.out.println(usuario);
            //System.out.println(usuario1);

            if (usuario.getContrasena().equals(contrasena) && usuario.getTipoUsuario().equals(tipoUsuario)) {

                return true;

                //return persona;
            }

            //return persona;
        } catch (NoResultException e) {

            System.out.println("No ha sido posible iniciar Sesion");
            return false;

        }

        return false;

    }

    @Override
    public boolean validacion(Usuario objeto) throws Exception {

        return true;

    }

    public Usuario buscar(String cedula) {

        EntityManager em = getEntityManager();

        try {

            String jpql = "Select u from Usuario u where u.cedula='" + cedula + "'";
            Usuario u = (Usuario) em.createQuery(jpql).getSingleResult();

            return u;

        } catch (NoResultException e) {

            System.out.println("Error " + e);

        }

        return null;

    }

}
