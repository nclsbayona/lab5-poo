package poo.lab5.Model;
import java.util.TreeSet;
public class Autor 
{
    private TreeSet<Libro> librosEscritos;
    private String nombre;
    private int cedula;
    private String estado;
    //Métodos
    //Accessors de librosEscritos
    public TreeSet<Libro> getLibrosEscritos()
    {
        return this.librosEscritos;
    }
    public void setLibrosEscritos(TreeSet<Libro> _librosEscritos)
    {
        this.librosEscritos=_librosEscritos;
    }
    //Accessors de nombre
    public String getNombre()
    {
        return this.nombre;
    }
    public void setNombre(String _nombre)
    {
        this.nombre=_nombre;
    }
    //Accessors de cedula
    public int getCedula()
    {
        return this.cedula;
    }
    public void setCedula(int _cedula)
    {
        this.cedula=_cedula;
    }
    //Accessors de estado
    public String getEstado()
    {
        return this.estado;
    }
    public void setEstado(String _estado)
    {
        this.estado=_estado;
    }
    //Constructor
    public Autor(String _nombre, int _cedula)
    {
        this.nombre=_nombre;
        this.cedula=_cedula;
    }
    //Agregar libro escrito
    public void agregarLibroEscrito(Libro libro)
    {
        this.librosEscritos.add(libro);
    }
}
