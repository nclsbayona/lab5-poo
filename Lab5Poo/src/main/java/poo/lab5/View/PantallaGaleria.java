package poo.lab5.View;
import poo.lab5.Controller.*;
import poo.lab5.Model.*;
public class PantallaGaleria {
    private ControllerLibro controlLibro;
    private ControllerAutor controlAutor;

    public PantallaGaleria() {
        this.controlAutor = new ControllerAutor();
        this.controlLibro = new ControllerLibro();
    }

    public static void main(String args[]) {
        // PantallaGaleria galeria = new PantallaGaleria();
        Autor autores[] = new Autor[3];
        autores[0] = new Autor("Nicolas Bayona", 1000000);
        autores[1] = new Autor("Sebastian Herrera", 2000000);
        Libro libros[] = new Libro[7];
        libros[0] = new Libro("Doña barbara", "4EFG", 25000);
        libros[1] = new Libro("Siempre a tu lado", "4TRG", 50000);
        libros[2] = new Libro("Laia", "544F", 75000);
        libros[3] = new Libro("Inferno", "7JIO", 25000);
        libros[4] = new Libro("Miau", "8JKL", 5000);
        libros[5] = new Libro("Land Dark", "4EFG", 50000);
        libros[6] = new Libro("Andando por la calle", "4TRG", 50000);
        ControllerAutor.agregarAutor(autores[0]);
        autores[0].setEstado("ACTIVO");
        autores[1].setEstado("ACTIVO");
        ControllerLibro.agregarAutores(libros[4], autores[0], autores[1]);
        ControllerAutor.agregarAutor(autores[1]);
        ControllerLibro.agregarLibro(libros[0]);
        ControllerLibro.agregarLibro(libros[5]);
        ControllerLibro.agregarLibro(libros[4], new Autor("AtonCode", 1122334));
        ControllerLibro.agregarLibro(libros[1], autores[0]);
        ControllerAutor.agregarLibroAAutor(libros[0], autores[0]);
        ControllerAutor.agregarAutores(autores[0], libros[2], libros[3], libros[4]);
        ControllerAutor.agregarLibroAAutor(new Libro("Bananas en pijama", "2AVC", 10000), autores[0]);
        ControllerLibro.agregarLibro(libros[6]);
        ControllerLibro.agregarLibro(libros[6], autores[0]);
        ControllerLibro.agregarLibro(libros[6], new Autor("AtonCode", 1122334));
        ControllerLibro.agregarLibro(libros[4]);
        ControllerAutor.agregarLibroAAutor(libros[1], autores[0]);
        ControllerLibro.asignarAutorALibro(libros[2], autores[1]);
        ControllerLibro.asignarAutorALibro(libros[6], autores[0]);
        ControllerLibro.asignarAutorALibro(libros[0],autores[1]);
        ControllerLibro.asignarAutorALibro(libros[6], new Autor("AtonCode", 1122334));
        System.out.print("Buscando \"4RSG\"" + '\n' + "Este se llama: ");
        Libro aux = ControllerLibro.buscarLibro(libros[1].getIsbn());
        System.out.println(aux.getNombre());
        ControllerLibro.agregarLibro(libros[3], autores[1]);
        for (Autor autor : ControllerAutor.getListaAutores()) {
            System.out.println("Autor: "+autor+"Total de costo de sus libros: "+ControllerAutor.calcularCostoTotalLibros(autor.getCedula())); System.out.println(); 
            for (Libro lib :autor.getLibrosEscritos()) {
                System.out.println("Libro: "+lib.getNombre()+':'+lib.getAutores());
            } 
            System.out.println();
        }
        System.out.println("\n\tCOLECCION DE LIBROS");
        System.out.println(ControllerLibro.getLibros());
    }
}
/**
 * Tasks
 * 
 * CONTROLADOR LIBRO 
 * AgregarLibro(Libro lib) -> CHECK 
 * AgregarLibro(Libro lib, Autor aut): -> CHECK
 * AsignarAutorALibro(Libro lib, Autor a)-> CHECK
 * BuscarLibro(String  _isbn) -> CHECK
 * CalcularCostoTotalLibros(): -> CHECK
 *
 * 
 * CONTROLADOR AUTOR
 * agregarAutor(Autor aut) -> Check
 * agregarLibroAAutor(Libro lib, Autor aut) -> Check
 * calcularCostoTotalLibros(int p_cedula) -> Check
 * buscarAutor(int p_cedula): Buscar y retornar el autor cuya cédula llega como parámetro -> Check.
*/