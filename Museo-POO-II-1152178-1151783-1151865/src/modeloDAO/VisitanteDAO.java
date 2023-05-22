
package modeloDAO;

import controller.Servicios;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloVO.Genero;
import modeloVO.MuseoVO;
import modeloVO.VisitanteVO;

/*
Un modelo DAO, se conoce como Data Acces Object. Donde se manipula al objeto desde un modeloVO. Esta
clase representa la manipulacion desde un modeloVO para un VisitanteVO, donde es un VisitanteDAO que 
atraves de los atributos del modeloVO, puede operar sobre el. Creando metodos de guardado, eliminacion,
actualizar informacion, comprobar que ya existe un visitante con el mismo numero de cedula, etc.
 */
public class VisitanteDAO {

    // Guardar un visitante en la base de datos
    public void guardar(Connection conexion, VisitanteVO visitante) throws SQLException {
        try {
            // Se prepara una consulta y se informa la operacion que se realizara
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("INSERT INTO visitante (cedula, nombre, apellidos, genero, profesion, ciudadorigen, codigomuseo)" + "VALUES (?,?,?,?,?,?,?)");
            // A traves del objeto PreparedStatement, se insertan los valores en la base de datos del visitante
            consulta.setString(1, visitante.getCedula());
            consulta.setString(2, visitante.getNombre());
            consulta.setString(3, visitante.getApellidos());
            consulta.setString(4, String.valueOf(visitante.getGenero()));
            consulta.setString(5, visitante.getProfesion());
            consulta.setString(6, visitante.getCiudadOrigen());
            consulta.setInt(7, visitante.getMuseo().getCodigo());
            
            // Guardar cambios en la base de datos
            consulta.executeUpdate();
            
            
        } catch (SQLException ex) {

            throw new SQLException(ex);
        }

    }

    // Actualizar ciudad del visitante
    public void actualizarCiudad(Connection conexion, String cedula, String nuevaCiudad) throws SQLException {

        try {
            // Preparar la consulta
            PreparedStatement consulta;
            // Indicar la consulta que queremos hacer, en este caso es la actualizacion de la ciudad de donde visita el visitante el museo
            consulta = conexion.prepareStatement("UPDATE visitante SET ciudadorigen='" + nuevaCiudad + "'WHERE cedula='" + cedula + "'");
            // Subir cambios a la base de datos
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
    
    // Buscar visitante
    public VisitanteVO buscarPorCedula(Connection conexion, String cedula) throws SQLException {
        VisitanteVO visitanteEncontrado = null;
        try {
            // Preparamos la consulta
            PreparedStatement consulta;
            // Indicamos la consulta que haremos, en esta caso es de seleccion. El parametro "?" representa la cedula pasada por el usuario en el metodo
            consulta = conexion.prepareStatement("SELECT * FROM visitante WHERE cedula = ?");
            consulta.setString(1, cedula); // Obtener solo las filas que coinciden
            // Se almacena al visitante buscado por cedula en un objeto ResultSet, de manera que se pueda operar al visitante
            ResultSet resultado = consulta.executeQuery();
            
            // La expresion resultado.next() es una expresion booleana que comienza desde la primera fila, esta sera cierta o falsa de acuerdo a un criterio
            // de busqueda. Como se indico anteriormente con executeQuery(), el resultado posee ese objeto ya. Pero con el next() nos movemos
            // entre la fila de visitantes, de manera que sera false hasta que no lo encuentra, si es true (encontrado) comenzara a sacar sus datos
            if (resultado.next()) {
                // Se obtienen los datos del visitante de la base de datos y son guardas en unas variables
                String cedula1 = resultado.getString("cedula");
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellidos");
                Genero genero = Genero.valueOf(resultado.getString("genero"));
                String profesion = resultado.getString("profesion");
                String ciudadOrigen = resultado.getString("ciudadorigen");
                int codigomuseo = resultado.getInt("codigomuseo");

                // Se llaman a los servicios
                Servicios servicios = new Servicios();

                // Se llama a un museo y sera buscado en la base de datos, para comprobar que el museo que posee el visitante existe 
                MuseoVO museoCodigo = servicios.buscarMuseoCodigo(codigomuseo);

                // Se crea al visitante con los valores del visitante buscado
                visitanteEncontrado = new VisitanteVO(cedula1, nombre, apellidos, genero, profesion, ciudadOrigen, museoCodigo);
            }

        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return visitanteEncontrado;
    }

    // Eliminar un visitante
    public void eliminar(Connection conexion, String cedula) throws SQLException {
        try {
            // Preparacion de la consulta
            PreparedStatement consulta;
            // Indicar que operacion queremos realizar en la base de datos y a que visitante vamos a eliminar
            consulta = conexion.prepareStatement("DELETE FROM visitante WHERE cedula = ?");
            consulta.setString(1, cedula);
            // Guardar cambios
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
    // Mostrar visitantes
    public void mostrarVisitantes(Connection conexion, JTable tabla) throws SQLException {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cedula");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Genero");
        model.addColumn("Profesion");
        model.addColumn("Ciudad");
        model.addColumn("Codigo Museo");
        String consultasql = "SELECT * FROM visitante";
        Statement st;

        try {
            st = conexion.createStatement();
            ResultSet resultado = st.executeQuery(consultasql);
            while (resultado.next()) {

                Object[] lista = {resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getObject(4),
                    resultado.getString(5), resultado.getString(6), resultado.getInt(7)};
                model.addRow(lista);
            }
            tabla.setModel(model);

        } catch (SQLException ex) {
            throw new SQLException(ex);
        }

    }

    // Mostrar visitantes del museo
    public int[] mostrarVisitantesMuseo(Connection conexion, JTable tabla, int codigomuseo) throws SQLException {
        int[] gen= new int[3];
        int m=0;
        int f=0;
        int t=0;
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cedula");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Genero");
        model.addColumn("Profesion");
        model.addColumn("Ciudad");
        model.addColumn("Codigo Museo");

        try {

            PreparedStatement consulta;
            consulta = conexion.prepareStatement("SELECT * FROM visitante WHERE codigomuseo = ?");
            consulta.setInt(1, codigomuseo);

            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {

                String cedula1 = resultado.getString("cedula");
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellidos");
                Genero genero = Genero.valueOf(resultado.getString("genero"));
                String profesion = resultado.getString("profesion");
                String ciudadOrigen = resultado.getString("ciudadorigen");
                int codigomuseo1 = resultado.getInt("codigomuseo");
                
                t++;
                if(genero.equals(genero.Femenino)){f++;}
                if(genero.equals(genero.Masculino)){m++;}
                // Se crea al visitante con los valores del visitante buscado
                Object[] lista = {cedula1, nombre, apellidos, genero, profesion, ciudadOrigen, codigomuseo1};

                model.addRow(lista);
            }
            gen[0]=f;
            gen[1]=m;
            gen[2]=t;
            tabla.setModel(model);

        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
      return gen;
    }
    
    // Validar que ya haya un visitante registrado
    public boolean existeVisitante(Connection conexion, String cedula) {
    boolean existe = false;
    try {
        // Realizar la consulta a la base de datos para verificar si el visitante ya existe
        String consulta = "SELECT COUNT(*) FROM visitante WHERE cedula = ?";
        PreparedStatement pstmt = conexion.prepareStatement(consulta);
        pstmt.setString(1, cedula);
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
