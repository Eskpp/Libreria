/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.Servicios;

import java.util.List;
import java.util.Scanner;
import libreria.Entidades.Autor;
import libreria.Entidades.Editorial;
import libreria.Entidades.Libro;
import libreria.Persistencia.LibroDAO;

/**
 *
 * @author Sanat
 */
public class LibroServicio {

    private final LibroDAO DAO;

    public LibroServicio() {
        this.DAO = new LibroDAO();
    }

    public void darBaja(Libro libro) {
        try {
            libro.setAlta(Boolean.FALSE);
            DAO.editar(libro);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void darAlta(Libro libro) {
        try {
            libro.setAlta(Boolean.TRUE);
            DAO.editar(libro);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Libro persistirLibro(String titulo, Integer anio, Integer ejemplares, Autor autor, Editorial editorial) {
        try {
            Libro libro = new Libro(titulo, anio, ejemplares, autor, editorial);
            DAO.guardar(libro);
            return libro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void crearLibro() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        EditorialServicio eServis = new EditorialServicio();
        AutorServicio aServis = new AutorServicio();
        try {
            System.out.print("Ingrese título del libro: ");
            String titulo = leer.next();
            System.out.print("Ingrese año de publicación: ");
            Integer anio = leer.nextInt();
            System.out.print("Ingrese cantidad de ejemplares: ");
            Integer ejemplares = leer.nextInt();
            System.out.print("Ingrese autor: ");
            String autor = leer.next();
            System.out.print("Ingrese editorial: ");
            String editorial = leer.next();
            
            if (aServis.buscarPorNombre(autor) == null) { //tengo que poner en buscarpornombre una excepcion que arroje que no esta el nombre en la base de datos, y colocar el trycatch de todos los service en los dao
                
            }
            // ó hacer que directamente intente crear un autor con el nombre dado, y si encuentra un autor con ese nombre lo devuelve, si no lo crea y lo vincula directamente
            // de cualquier manera habría que cambiar los try catch
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Libro> listarTodosLibros() {
        try {
            return DAO.listarTodos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<Libro> listarLibrosPorAutor() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        try {
            System.out.print("Ingrese nombre del autor: ");
            String autor = leer.next();            
            return DAO.listarPorAutor(autor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<Libro> listarLibrosPorEditorial() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        try {
            System.out.print("Ingrese nombre de la editorial: ");
            String editorial = leer.next();  
            return DAO.listarPorEditorial(editorial);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
