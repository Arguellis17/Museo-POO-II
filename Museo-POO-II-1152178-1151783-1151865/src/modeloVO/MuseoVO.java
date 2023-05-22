package modeloVO;

/*
En un modelo VO, se ingresan datos de Value Object. Es decir, los atributos, constructor y metodos
consultores (getter and setter), no se deben de ingresar metodos del objeto. Pues estos metodos, pertenecen
a otro paquete conocido como modeloDAO
 */

public class MuseoVO {
    
    // Atributos
    private int codigo;
    private String nombre;
    private String municipio;
    private String departamento;

    // Constructor vacio y con parametros
    public MuseoVO() {
    }

    public MuseoVO(int codigo, String nombre, String municipio, String departamento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.municipio = municipio;
        this.departamento = departamento;
    }

    // Metodos consultores
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

}
