package View;

import Controller.*;
import Model.*;

public class PantallaGaleria {
    private ControllerAutor controllerAutor=new ControllerAutor();
    private ControllerLibro controllerLibro=new ControllerLibro();

    public static void main(String args[]) {
        PantallaGaleria galeria = new PantallaGaleria();
        Autor aut = new Autor("Sebastian", 1000471976);
        Autor aut1 = new Autor("Rafael", 1000471976);
        Autor aut2 = new Autor("Lina", 1000500310);
        Autor aut3 = new Autor("Salome", 1000500311);
        Autor aut4 = new Autor("Thiago", 1000500312);
        galeria.controllerAutor.agregarAutor(aut);
        galeria.controllerAutor.agregarAutor(aut1);
        galeria.controllerAutor.agregarAutor(aut2);
        galeria.controllerAutor.agregarAutor(aut3);
        galeria.controllerAutor.agregarAutor(aut4);

        Libro libro1 = new Libro("Geek", "4ABC", 500);
        Libro libro2 = new Libro("Laia", "5FGH", 700);
        Libro libro3 = new Libro("Andrea", "2ACD", 200);
        Libro libro4 = new Libro("Lumia", "2XCC", 200);
        Libro libro5 = new Libro("Repetido", "2XCC", 200);
        Libro libro6 = new Libro("Nuevo", "DDEF", 200);
        Libro libro7 = new Libro("Libro no agregado", "IDDF", 200);
        // Libro 7 no se agrega a la lista
        galeria.controllerLibro.asignarAutorALibro(libro7, aut, galeria.controllerAutor);
        System.out.print("Agregando libro(NO ESTA EN LA LISTA) a autor desde el CONTROLLERAUTOR:"
                + galeria.controllerAutor.agregarLibroAAutor(libro7, aut, galeria.controllerLibro));
        galeria.controllerLibro.agregarLibro(libro1);
        galeria.controllerLibro.agregarLibro(libro2);
        galeria.controllerLibro.agregarLibro(libro3);
        galeria.controllerLibro.agregarLibro(libro4);
        // Autor único
        galeria.controllerAutor.agregarLibroAAutor(libro4, aut, galeria.controllerLibro);

        // Estado inactivo
        aut4.setEstado("INACTIVO");
        galeria.controllerAutor.agregarLibroAAutor(libro2, aut4, galeria.controllerLibro);
        // Multiples autores
        galeria.controllerAutor.agregarLibroAAutor(libro4, aut3, galeria.controllerLibro);
        galeria.controllerAutor.agregarLibroAAutor(libro1, aut, galeria.controllerLibro);
        galeria.controllerAutor.agregarLibroAAutor(libro1, aut2, galeria.controllerLibro);
        System.out.println("\nLibro repetido a un autor : "
                + galeria.controllerAutor.agregarLibroAAutor(libro1, aut2, galeria.controllerLibro));
        // Agregar libro repetido a una lista
        galeria.controllerLibro.agregarLibro(libro5);
        // Agregar libro con autor
        System.out.println("\nAgregar libro a un autor que no se encuentra en la lista :"
                + galeria.controllerLibro.agregarLibro(libro6, aut2, galeria.controllerAutor));
        System.out.println("\nLista de autores\n");
        for (Autor autor : galeria.controllerAutor.getListaAutores()) {
            System.out.println(autor);
            System.out.println("Total " + galeria.controllerAutor.calcularCostoTotalLibros(autor.getCedula()) + "\n");
        }
        System.out.println("\nLista de libros, TAM: " + galeria.controllerLibro.getLibros().size() + "\n");
        for (Libro lib : galeria.controllerLibro.getLibros()) {
            System.out.println("\t" + lib);
        }
        System.out.println("\nTotal valor: " + galeria.controllerLibro.calcularCostoTotalLibros());
    }
}
/**
 * Tasks
 *
 * CONTROLADOR LIBRO AgregarLibro(Libro lib) -> CHECK AgregarLibro(Libro lib,
 * Autor aut): -> CHECK AsignarAutorALibro(Libro lib, Autor a)-> CHECK
 * BuscarLibro(String _isbn) -> CHECK CalcularCostoTotalLibros(): -> CHECK
 *
 *
 * CONTROLADOR AUTOR agregarAutor(Autor aut) -> Check agregarLibroAAutor(Libro
 * lib, Autor aut) -> Check calcularCostoTotalLibros(int p_cedula) -> Check
 * buscarAutor(int p_cedula): Buscar y retornar el autor cuya cédula llega como
 * parámetro -> Check.
 */
