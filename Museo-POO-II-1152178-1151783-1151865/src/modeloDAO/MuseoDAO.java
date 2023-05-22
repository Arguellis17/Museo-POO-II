/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloDAO;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloVO.MuseoVO;


public class MuseoDAO {
   
    // Guardar un museo
    public void guardar(Connection conexion,MuseoVO museo) throws SQLException{
        try{
            PreparedStatement consulta;
            consulta= conexion.prepareStatement("INSERT INTO museo (codigo, nombre, municipio, departamento)" + "VALUES (?,?,?,?)" );
            consulta.setInt(1, museo.getCodigo());
            consulta.setString(2, museo.getNombre());
            consulta.setString(3, museo.getMunicipio());
            consulta.setString(4, museo.getDepartamento());
            
            consulta.executeUpdate();
        }catch (SQLException ex){
            
            throw new SQLException (ex);
        }
    
    
    }
    
    // Buscar un museo por nombre
    public MuseoVO buscarPorNombre(Connection conexion, String nombre) throws SQLException {
        MuseoVO museoEncontrado = null;
        try {
            // Preparamos la consulta, pues vamos a consultar de la base de datos de visitantes
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("SELECT * FROM museo WHERE nombre = ?");
            consulta.setString(1, nombre);
            // executeQuery llama al objeto consulto para ejecutar la consulta y obtener los resultados (de la base de datos de visitante)
            // ResultSet es una interfaz de Java que proporciona metodos para acceder y manipular los datos obtenidos de una consulta SQL
            ResultSet resultado = consulta.executeQuery();
            if (resultado.next()) {
                // Con el resultado de la consulta obtenida, empezamos a tomar los datos de la base de datos del visitante que fue buscado
                int codigo = resultado.getInt("codigo");
                String nombre1=resultado.getString("nombre");
                String municipio = resultado.getString("municipio");
                String departamento = resultado.getString("departamento");
                

                // Se crea al visitante con los valores del visitante buscado
                museoEncontrado = new MuseoVO(codigo, nombre1, municipio, departamento);
            }
            
           
            
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return museoEncontrado;
    }
    
    // Buscar un museo por codigo
    public MuseoVO buscarPorCodigo(Connection conexion, int codigo) throws SQLException {
        MuseoVO museoEncontrado = null;
        try {
            // Preparamos la consulta, pues vamos a consultar de la base de datos de visitantes
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("SELECT * FROM museo WHERE codigo = ?");
            consulta.setInt(1, codigo);
            // executeQuery llama al objeto consulto para ejecutar la consulta y obtener los resultados (de la base de datos de visitante)
            // ResultSet es una interfaz de Java que proporciona metodos para acceder y manipular los datos obtenidos de una consulta SQL
            ResultSet resultado = consulta.executeQuery();
            if (resultado.next()) {
                // Con el resultado de la consulta obtenida, empezamos a tomar los datos de la base de datos del visitante que fue buscado
                int codigo1 = resultado.getInt("codigo");
                String nombre=resultado.getString("nombre");
                String municipio = resultado.getString("municipio");
                String departamento = resultado.getString("departamento");
                

                // Se crea al visitante con los valores del visitante buscado
                museoEncontrado = new MuseoVO(codigo1, nombre, municipio, departamento);
            }
            
           
            
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return museoEncontrado;
    }
    
    // Mostrar museos en la tabla
    public void mostrarMuseo(Connection conexion, JTable tabla) throws SQLException {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Municipio");
        model.addColumn("Departamento");
        
        String consultasql = "SELECT * FROM museo";
        Statement st;

        try {
            st = conexion.createStatement();
            ResultSet resultado = st.executeQuery(consultasql);
            while (resultado.next()) {

                Object[] lista = {resultado.getInt(1), resultado.getString(2), resultado.getString(3),
                    resultado.getString(4)};
                model.addRow(lista);
            }
            tabla.setModel(model);

        } catch (SQLException ex) {
            throw new SQLException(ex);
        }

    }
    
    // Mostrar museo en la tabla 2
    public void mostrarMuseoCodigo(Connection conexion, JTable tabla, int codigo) throws SQLException {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Municipio");
        model.addColumn("Departamento");
        

        try {

            PreparedStatement consulta;
            consulta = conexion.prepareStatement("SELECT * FROM museo WHERE codigo = ?");
            consulta.setInt(1, codigo);

            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {

                int codigo1 = resultado.getInt("codigo");
                String nombre = resultado.getString("nombre");
                String municipio = resultado.getString("municipio");
                String departamento = resultado.getString("departamento");
                

                // Se crea al visitante con los valores del visitante buscado
                Object[] lista = {codigo1, nombre, municipio, departamento};

                model.addRow(lista);
            }
            tabla.setModel(model);

        } catch (SQLException ex) {
            throw new SQLException(ex);
        }

    }

    // Eliminar un museo
    public void eliminar(Connection conexion, int codigo) throws SQLException {
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("DELETE FROM museo WHERE codigo = ?");
            consulta.setInt(1, codigo);
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
           
    
    // Validar que ya haya un museo registrado
    public boolean existeMuseo(Connection conexion, String codigo) {
    boolean existe = false;
    try {
        // Realizar la consulta a la base de datos para verificar si el museo ya existe
        String consulta = "SELECT COUNT(*) FROM museo WHERE codigo = ?";
        PreparedStatement pstmt = conexion.prepareStatement(consulta);
        pstmt.setString(1, codigo);
        ResultSet rs = pstmt.executeQuery(); // Se almacenan los datos de la tabla en un objeto ResultSet

        if (rs.next()) {
            int count = rs.getInt(1); // Trae la columa de las cedulas de los visitantes
            existe = (count > 0);
        }

        rs.close();
        pstmt.close();
    } catch (SQLException e) {
        // Manejo de excepciones
    }
    return existe;
    }
            
}
