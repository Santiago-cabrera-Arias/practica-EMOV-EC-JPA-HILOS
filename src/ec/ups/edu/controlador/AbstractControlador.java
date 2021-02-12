package ec.ups.edu.controlador;

import ec.ups.edu.utils.UtilsJPA;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author santi
 */
public abstract class AbstractControlador<T> {

    private List<T> lista;
    private Class clase;
    EntityManager em;

    public AbstractControlador() {

        lista = new ArrayList();
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        clase = (Class) pt.getActualTypeArguments()[0];
        em = UtilsJPA.getEntityManager();
    }

    public AbstractControlador(EntityManager em) {

        lista = new ArrayList();
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        clase = (Class) pt.getActualTypeArguments()[0];
        this.em = em;

    }

    public boolean create(T objeto) throws Exception {

        if (validacion(objeto)) {
            em.getTransaction().begin();
        }
        em.persist(objeto);
        em.getTransaction().commit();
        lista.add(objeto);
        return true;

    }

    public T read(String cedula) {

        return (T) em.find(clase, cedula);
    }

    public boolean update(T objeto) throws Exception {

        if (validacion(objeto)) {
            em.getTransaction().begin();
        }
        objeto = em.merge(objeto);
        em.getTransaction().commit();
        return true;

    }

    public boolean delete(T objeto) throws Exception {

        if (validacion(objeto)) {
            em.getTransaction().begin();
        }
        em.remove(objeto);
        em.getTransaction().commit();
        lista.remove(objeto);
        return true;

    }

    public List<T> findAll() {

        return em.createQuery("SELECT t FROM " + clase.getSimpleName() + " t").getResultList();

    }

    public abstract boolean validacion(T objeto) throws Exception;

    public List<T> getLista() {
        return lista;
    }

    public void setLista(List<T> lista) {
        this.lista = lista;
    }

    public Class getClase() {
        return clase;
    }

    public void setClase(Class clase) {
        this.clase = clase;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
