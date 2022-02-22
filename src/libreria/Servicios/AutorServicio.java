/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.Servicios;

import java.util.List;
import java.util.Scanner;
import libreria.Persistencia.AutorDAO;
import libreria.Entidades.Autor;

/**
 *
 * @author Sanat
 */
public class AutorServicio {

    private final AutorDAO DAO;

    public AutorServicio() {
        this.DAO = new AutorDAO();
    }
    
    public void darBaja(Autor autor) {
        try {
            autor.setAlta(Boolean.FALSE);
            DAO.editar(autor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void darAlta(Autor autor) {
        try {
            autor.setAlta(Boolean.TRUE);
            DAO.editar(autor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Autor crearAutor() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Ingrese nombre del autor: ");
        String nombre = leer.next();
        return persistirAutor(nombre);
    }

    public Autor persistirAutor(String nombre) {
        Autor autor = new Autor();
        try {
            autor.setNombre(nombre);
            DAO.guardar(autor);
            return autor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Autor buscarPorId(Integer id) {
        try {
            Autor autor = DAO.buscarPorId(id);
            return autor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Autor buscarPorNombre(String nombre) {
        try {
            Autor autor = DAO.buscarPorNombre(nombre);
            return autor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<Autor> listarAutores(){
        try {
            return DAO.listarTodos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
