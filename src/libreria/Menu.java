package libreria;

import java.util.Scanner;
import libreria.Entidades.Autor;
import libreria.Entidades.Editorial;
import libreria.Entidades.Libro;
import libreria.Servicios.Control;

/**
 *
 * @author Sanat
 */
public class Menu {

    public boolean menu() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Control servicios = new Control();
        int selector;
        String salir = "";

        do {
            do {
                System.out.println("1- Listar libros.");
                System.out.println("2- Listar autores.");
                System.out.println("3- Listar editoriales.");
                System.out.println("4- Buscar libro por ISBN.");
                System.out.println("5- Buscar libro por título.");
                System.out.println("6- Buscar libro/s por autor.");
                System.out.println("7- Buscar libro/s por editorial.");
                System.out.println("8- Buscar autor por ID.");
                System.out.println("9- Buscar autor por nombre.");
                System.out.println("10- Buscar editorial por ID.");
                System.out.println("11- Buscar editorial por nombre.");
                System.out.println("12- Agregar libro.");
                System.out.println("13- Agregar autor.");
                System.out.println("14- Agregar editorial.");
                System.out.println("15- Dar de alta libro.");//mostrar listas alta/baja
                System.out.println("16- Dar de baja libro.");
                System.out.println("17- Dar de alta autor.");
                System.out.println("18- Dar de baja autor.");
                System.out.println("19- Dar de alta editorial.");
                System.out.println("20- Dar de baja editorial.");
                System.out.println("21- Salir.");
                try {
                    selector = leer.nextInt();
                } catch (Exception e) {
                    System.out.println("No ha ingresado un número o su número tenia coma.");
                    LimpiarPantalla.limpiarConAviso();
                    return true; //encerrar llamada a menu o un condicional, true is terminma false si error
                }
            } while (selector < 1 || selector > 21);
            switch (selector) {
                case 1:
                    servicios.getlSer().mostrarTodos();
                    LimpiarPantalla.limpiarConAviso();
                    break;
                case 2:
                    servicios.getaSer().mostrarAutores();
                    LimpiarPantalla.limpiarConAviso();
                    break;
                case 3:
                    servicios.geteSer().mostrarEditoriales();
                    LimpiarPantalla.limpiarConAviso();
                    break;
                case 4:
                    System.out.println("Ingrese ISBN del libro");
                    long isbn = leer.nextLong();
                    if (servicios.getlSer().buscarPorIsbn(isbn) == null) {
                        System.out.println("No se encontro ningun libro con ISBN " + isbn);
                    } else {
                        System.out.println(servicios.getlSer().buscarPorIsbn(isbn));
                    }
                    LimpiarPantalla.limpiarConAviso();
                    break;
                case 5:
                    System.out.println("Ingrese titulo del libro");
                    String titulo = leer.next();
                    if (servicios.getlSer().buscarPorTitulo(titulo) == null) {
                        System.out.println("No se encontro ningun libro con titulo " + titulo);
                    } else {
                        System.out.println(servicios.getlSer().buscarPorTitulo(titulo));
                    }
                    LimpiarPantalla.limpiarConAviso();
                    break;
                case 6:
                    servicios.getlSer().mostrarPorAutor();
                    LimpiarPantalla.limpiarConAviso();
                    break;
                case 7:
                    servicios.getlSer().mostrarPorEditorial();
                    LimpiarPantalla.limpiarConAviso();
                    break;
                case 8:
                    System.out.println("Ingrese ID de autor");
                    int idAutor = leer.nextInt();
                    if (servicios.getaSer().buscarPorId(idAutor) == null) {
                        System.out.println("No se encontro ningun autor con ID = " + idAutor);
                    } else {
                        System.out.println(servicios.getaSer().buscarPorId(idAutor));
                    }
                    LimpiarPantalla.limpiarConAviso();
                    break;
                case 9:
                    System.out.println("Ingrese nombre del autor");
                    String nombreAutor = leer.next();
                    if (servicios.getaSer().buscarPorNombre(nombreAutor) == null) {
                        System.out.println("No se encontro ningun autor con nombre " + nombreAutor);
                    } else {
                        System.out.println(servicios.getaSer().buscarPorNombre(nombreAutor));
                    }
                    LimpiarPantalla.limpiarConAviso();
                    break;
                case 10:
                    System.out.println("Ingrese ID de editorial");
                    int idEditorial = leer.nextInt();
                    if (servicios.geteSer().buscarPorId(idEditorial) == null) {
                        System.out.println("No se encontro ninguna editorial con ID = " + idEditorial);
                    } else {
                        System.out.println(servicios.getaSer().buscarPorId(idEditorial));
                    }
                    LimpiarPantalla.limpiarConAviso();
                    break;
                case 11:
                    System.out.println("Ingrese nombre de la editorial");
                    String nombreEditorial = leer.next();
                    if (servicios.geteSer().buscarPorNombre(nombreEditorial) == null) {
                        System.out.println("No se encontro ninguna editorial con nombre " + nombreEditorial);
                    } else {
                        System.out.println(servicios.getaSer().buscarPorNombre(nombreEditorial));
                    }
                    LimpiarPantalla.limpiarConAviso();
                    break;
                case 12:
                    System.out.println(servicios.getlSer().crearLibro());
                    LimpiarPantalla.limpiarConAviso();
                    break;
                case 13:
                    System.out.println(servicios.getaSer().crearAutor());
                    LimpiarPantalla.limpiarConAviso();
                    break;
                case 14:
                    System.out.println(servicios.geteSer().crearEditorial());
                    LimpiarPantalla.limpiarConAviso();
                    break;
                case 15:
                    servicios.getlSer().darAlta(criterioDeBusquedaLibro());
                    LimpiarPantalla.limpiarConAviso();
                    break;
                case 16:
                    servicios.getlSer().darBaja(criterioDeBusquedaLibro());
                    LimpiarPantalla.limpiarConAviso();
                    break;
                case 17:
                    servicios.getaSer().darAlta(criterioDeBusquedaAutor());
                    LimpiarPantalla.limpiarConAviso();
                    break;
                case 18:
                    servicios.getaSer().darBaja(criterioDeBusquedaAutor());
                    LimpiarPantalla.limpiarConAviso();
                    break;
                case 19:
                    servicios.geteSer().darAlta(criterioDeBusquedaEditorial());
                    LimpiarPantalla.limpiarConAviso();
                    break;
                case 20:
                    servicios.geteSer().darBaja(criterioDeBusquedaEditorial());
                    LimpiarPantalla.limpiarConAviso();
                    break;
                case 21:
                    System.out.println("Seguro desea salir? S/N");
                    salir = leer.next();
                    break;
                default:
                    throw new AssertionError();
            }
        } while (!(salir.equalsIgnoreCase("s")));
        return false;
    }

    public Libro criterioDeBusquedaLibro() {
        Control servicios = new Control();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int selector;

        System.out.println("Ingrese criterio de búsqueda.");
        System.out.println("1- ISBN");//faltaria hacer por editorial y autor
        System.out.println("2- TITULO"); // solo que si busco asi, deberia filtrar las LIST y hacer un selector individual de libros
        try {
            selector = leer.nextInt();
        } catch (Exception e) {
            System.out.println("No ha ingresado un número o su número tenia coma.");
            LimpiarPantalla.limpiarConAviso();
            return null;
        }

        switch (selector) {
            case 1:
                return servicios.getlSer().buscarPorIsbn();
            case 2:
                return servicios.getlSer().buscarPorTitulo();
            default:
                throw new AssertionError();
        }

    }

    public Autor criterioDeBusquedaAutor() {
        Control servicios = new Control();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int selector;

        System.out.println("Ingrese criterio de búsqueda.");
        System.out.println("1- ID");//faltaria hacer por editorial y autor
        System.out.println("2- NOMBRE"); // solo que si busco asi, deberia filtrar las LIST y hacer un selector individual de libros
        try {
            selector = leer.nextInt();
        } catch (Exception e) {
            System.out.println("No ha ingresado un número o su número tenia coma.");
            LimpiarPantalla.limpiarConAviso();
            return null;
        }

        switch (selector) {
            case 1:
                return servicios.getaSer().buscarPorId();
            case 2:
                return servicios.getaSer().buscarPorNombre();
            default:
                throw new AssertionError();
        }

    }

    public Editorial criterioDeBusquedaEditorial() {
        Control servicios = new Control();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int selector;

        System.out.println("Ingrese criterio de búsqueda.");
        System.out.println("1- ID");//faltaria hacer por editorial y autor
        System.out.println("2- NOMBRE"); // solo que si busco asi, deberia filtrar las LIST y hacer un selector individual de libros
        try {
            selector = leer.nextInt();
        } catch (Exception e) {
            System.out.println("No ha ingresado un número o su número tenia coma.");
            LimpiarPantalla.limpiarConAviso();
            return null;
        }

        switch (selector) {
            case 1:
                return servicios.geteSer().buscarPorId();
            case 2:
                return servicios.geteSer().buscarPorNombre();
            default:
                throw new AssertionError();
        }
    }
}
