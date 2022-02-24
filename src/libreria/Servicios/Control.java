/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.Servicios;

/**
 *
 * @author Sanat
 */
public class Control {
    
    private final AutorServicio aSer;
    private final EditorialServicio eSer;
    private final LibroServicio lSer;

    public Control() {
    this.aSer = new AutorServicio();
    this.eSer = new EditorialServicio();
    this.lSer = new LibroServicio();
    }

    public AutorServicio getaSer() {
        return aSer;
    }

    public EditorialServicio geteSer() {
        return eSer;
    }

    public LibroServicio getlSer() {
        return lSer;
    }
    
    
    
}
