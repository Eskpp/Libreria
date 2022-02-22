/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.Persistencia;


import java.util.List;
import libreria.Entidades.Libro;

/**
 *
 * @author Sanat
 */
public class LibroDAO extends DAO<Libro> {

    @Override
    public void guardar(Libro libro) {
        super.guardar(libro);
    }

    @Override
    public void eliminar(Libro libro) {
        super.eliminar(libro);
    }

    @Override
    public void editar(Libro libro) {
        super.editar(libro);
    }

    /*public void darAltaPorIsbn(Long isbn) {
        Libro libro = buscarPorIsbn(isbn);
        libro.setAlta(true);
        super.editar(libro);
    }*/

    /*public void darBajaPorIsbn(Long isbn) {
        Libro libro = buscarPorIsbn(isbn);
        libro.setAlta(false);
        super.editar(libro);
    }*/

    public Libro buscarPorIsbn(Long isbn) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn LIKE :isbn")
                .setParameter("isbn", isbn).getSingleResult();
        desconectar();
        return libro;
    }
    
    public Libro buscarPorTitulo(String titulo){
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo")
                .setParameter("titulo", titulo).getSingleResult();
        desconectar();
        return libro;
    }
    
    public List<Libro> listarTodos(){
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l")
                .getResultList();
        desconectar();
        return libros;
    }
    
    public List<Libro> listarPorAutor(String autor){
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE :autor")
                .setParameter("autor", autor).getResultList();
        desconectar();
        return libros;
    }
    
    public List<Libro> listarPorEditorial(String editorial){
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre LIKE :editorial")
                .setParameter("editorial", editorial).getResultList();
        desconectar();
        return libros;
    }

}
