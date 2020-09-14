package poo.lab5.Model;

import java.util.TreeSet;

public class Autor implements Comparable<Autor> {
    private TreeSet<Libro> librosEscritos;
    private String nombre;
    private int cedula;
    private String estado;

    // Métodos
    // Accessors de librosEscritos
    public TreeSet<Libro> getLibrosEscritos() {
        return this.librosEscritos;
    }

    public void setLibrosEscritos(TreeSet<Libro> _librosEscritos) {
        this.librosEscritos = _librosEscritos;
    }

    // Accessors de nombre
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String _nombre) {
        this.nombre = _nombre;
    }

    // Accessors de cedula
    public int getCedula() {
        return this.cedula;
    }

    public void setCedula(int _cedula) {
        this.cedula = _cedula;
    }

    // Accessors de estado
    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String _estado) {
        this.estado = _estado;
    }

    // Constructor
    public Autor(String _nombre, int _cedula) {
        this.librosEscritos = new TreeSet<Libro>();
        this.nombre = _nombre;
        this.cedula = _cedula;
    }

    // Buscar libro por isbn
    public boolean buscarLibro(String isbn) {
        for (Libro libro : this.librosEscritos) {
            if (libro.getIsbn().equals(isbn)) {
                return false;
            }
        }
        return true;
    }

    // Agregar libro escrito
    public void agregarLibroEscrito(Libro libro) {
        try {
            boolean _libro = this.buscarLibro(libro.getIsbn());
            if (!_libro) {
                return;
            }
            // System.out.println("Tam 1:"+this.librosEscritos.size());
            if (this.getEstado().equals("ACTIVO")) {
                this.librosEscritos.add(libro);
                libro.getAutores().add(this);
                
            }
        } catch (Exception e) {
            return;
        }
    }

    // Comparable method
    @Override
    public int compareTo(Autor otro) {
        /*
         * Devuelve 0 en caso de que ambos objetos tengan el mismo orden (no haya uno
         * mayor que otro) Un número entero negativo si el objeto actual es menor al
         * objeto pasado como parámetro Un número positivo si el objeto actual es mayor
         * al objeto pasado como parámetro
         */
        if (this.cedula == otro.cedula) {
            return 0;
        } else if (this.cedula < otro.cedula) {
            return -1;
        } else {
            return 1;
        }
    }
    public String toString() {
        String retorno = this.nombre + ':' + this.cedula + '-' + this.estado + "\nLibros\n";
        if (this.librosEscritos != null) {
            for (Libro libro : this.librosEscritos) {
                retorno += ('\t' + libro.toString() + '\n');
            }
        }
        return retorno;
    }
}