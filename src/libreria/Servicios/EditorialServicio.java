/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.Servicios;

import java.util.List;
import java.util.Scanner;
import libreria.Entidades.Editorial;
import libreria.Persistencia.EditorialDAO;

/**
 *
 * @author Sanat
 */
public class EditorialServicio {

    private final EditorialDAO DAO;

    public EditorialServicio() {
        this.DAO = new EditorialDAO();
    }
    
    public void darBaja(Editorial editorial) {
        try {
            editorial.setAlta(Boolean.FALSE);
            DAO.editar(editorial);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void darAlta(Editorial editorial) {
        try {
            editorial.setAlta(Boolean.TRUE);
            DAO.editar(editorial);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Editorial crearEditorial() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Ingrese nombre de la editorial: ");
        String nombre = leer.next();
        return persistirEditorial(nombre);
    }

    public Editorial persistirEditorial(String nombre) {
        try {
            Editorial editorial = new Editorial();
            editorial.setNombre(nombre);
            DAO.guardar(editorial);
            return editorial;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Editorial buscarPorId(Integer id) {
        try {
            Editorial editorial = DAO.buscarPorId(id);
            return editorial;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Editorial buscarPorNombre(String nombre) {
        try {
            Editorial editorial = DAO.buscarPorNombre(nombre);
            return editorial;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<Editorial> listarEditoriales(){
        try {
            return DAO.listarTodos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
