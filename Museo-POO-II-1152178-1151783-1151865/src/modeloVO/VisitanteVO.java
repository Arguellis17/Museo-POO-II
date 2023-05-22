
package modeloVO;

/*
En un modelo VO, se ingresan datos de Value Object. Es decir, los atributos, constructor y metodos
consultores (getter and setter), no se deben de ingresar metodos del objeto. Pues estos metodos, pertenecen
a otro paquete conocido como modeloDAO

*/

public class VisitanteVO {
    
    // Atributos del visitante
    private String cedula;
    private String nombre;
    private String apellidos;
    private Genero genero;
    private String profesion;
    private String ciudadOrigen;
    private MuseoVO museo;

    // Constructor vacio y con parametros
    public VisitanteVO() {
    }

    public VisitanteVO(String cedula, String nombre, String apellidos, Genero genero, String profesion, String ciudadOrigen, MuseoVO museo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.profesion = profesion;
        this.ciudadOrigen = ciudadOrigen;
        this.museo = museo;
    }

    // Metodos consultores
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public MuseoVO getMuseo() {
        return museo;
    }

    public void setMuseo(MuseoVO museo) {
        this.museo = museo;
    }
        
            
}
