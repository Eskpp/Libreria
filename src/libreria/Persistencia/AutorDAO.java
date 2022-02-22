/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.Persistencia;

import java.util.List;
import libreria.Entidades.Autor;

/**
 *
 * @author Sanat
 */
public class AutorDAO extends DAO<Autor> {

    @Override
    public void eliminar(Autor autor) {
        super.eliminar(autor);
    }

    @Override
    public void editar(Autor autor) {
        super.editar(autor);
    }

    @Override
    public void guardar(Autor autor) {
        super.guardar(autor);
    }

    public Autor buscarPorId(Integer id) {
        conectar();
        Autor autor = em.find(Autor.class, id);
        desconectar();
        return autor;
    }

    public Autor buscarPorNombre(String nombre) {
        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
                .setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return autor;
    }
    
    public List<Autor> listarTodos(){
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a")
                .getResultList();
        desconectar();
        return autores;
    }

}
