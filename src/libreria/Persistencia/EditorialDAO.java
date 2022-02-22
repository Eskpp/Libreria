/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.Persistencia;

import java.util.List;
import libreria.Entidades.Editorial;

/**
 *
 * @author Sanat
 */
public class EditorialDAO extends DAO<Editorial>{

    @Override
    public void guardar(Editorial editorial) {
        super.guardar(editorial);
    }
    
    @Override
    public void eliminar(Editorial editorial){
        super.eliminar(editorial);
    }

    @Override
    public void editar(Editorial editorial) {
        super.editar(editorial); 
    }
    
    public Editorial buscarPorId(Integer id){
        conectar();
        Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.id LIKE :id")
                .setParameter("id", id).getSingleResult();
        desconectar();
        return editorial;
    }
    
    public Editorial buscarPorNombre(String nombre){
        conectar();
        Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :nombre")
                .setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return editorial;
    }
    
    public List<Editorial> listarTodos(){
        conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e")
                .getResultList();
        desconectar();
        return editoriales;
    }
}
