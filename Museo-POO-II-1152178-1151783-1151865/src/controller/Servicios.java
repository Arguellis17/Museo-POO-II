package controller;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import modeloDAO.Conexion;
import modeloDAO.MuseoDAO;
import modeloDAO.VisitanteDAO;
import modeloVO.MuseoVO;
import modeloVO.VisitanteVO;

public class Servicios {

    /*
    
    METODOS PARA OPERAR SOBRE LOS VISITANTES
    
    */
    // Guardar un visitante
    public void guardarVisitante(VisitanteVO visitante) {
        try {
            VisitanteDAO vdao = new VisitanteDAO();

            // Verificar si el número de cédula ya está registrado
            boolean existeVisitante = vdao.existeVisitante(Conexion.obtener(), visitante.getCedula());

            if (existeVisitante) {
                JOptionPane.showMessageDialog(null, "Ya hay un visitante registrado con el mismo número de cédula", "Error: Guardar Visitante", JOptionPane.ERROR_MESSAGE);
            } else {
                vdao.guardar(Conexion.obtener(), visitante);
                JOptionPane.showMessageDialog(null, "Se ha guardado al visitante correctamente.", "Informacion: Guardar Visitante.", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {

        }
    }

    // Mostrar visitantes en la tabla
    public void mostrarVisitante(JTable tabla) {
        try {
            VisitanteDAO vdao = new VisitanteDAO();
            vdao.mostrarVisitantes(Conexion.obtener(), tabla);

        } catch (Exception e) {
        }

    }

    // Mostrar visitantes en la tabla 2
    public int[] mostrarVisitantesMuseo(JTable tabla, int codigomuseo) {
        int[] gen = new int[3];
        try {
            VisitanteDAO vdao = new VisitanteDAO();
            gen = vdao.mostrarVisitantesMuseo(Conexion.obtener(), tabla, codigomuseo);

        } catch (Exception e) {
        }
        return gen;
    }

    // Buscar un visitante por cedula
    public VisitanteVO buscarVisitanteCedula(String cedula) {
        VisitanteVO visitanteBuscado = new VisitanteVO();
        try {
            VisitanteDAO vdao = new VisitanteDAO();

            visitanteBuscado = vdao.buscarPorCedula(Conexion.obtener(), cedula);

            return visitanteBuscado;
        } catch (Exception e) {
            return null;
        }
    }

    // Eliminar un visitante
    public void eliminarVisitante(String cedula) {
        try {
            VisitanteDAO vdao = new VisitanteDAO();
            vdao.eliminar(Conexion.obtener(), cedula);

        } catch (Exception e) {
        }

    }

    // Actualizar la ciudad de un visitante
    public void actualizarCiudadVisitante(String cedula, String ciudadNueva) {
        try {
            VisitanteDAO vdao = new VisitanteDAO();
            vdao.actualizarCiudad(Conexion.obtener(), cedula, ciudadNueva);

        } catch (Exception e) {
        }

    }
    /*

    METODOS PARA OPERAR SOBRE LOS MUSEOS

    */
    
    // Guardar un museo
    public void guardarMuseo(MuseoVO museo) {
        try {
            MuseoDAO mdao = new MuseoDAO();

            // Verificar si el número de cédula ya está registrado
            boolean existeMuseo = mdao.existeMuseo(Conexion.obtener(), String.valueOf(museo.getCodigo()));

            if (existeMuseo) {
                JOptionPane.showMessageDialog(null, "Ya hay un museo registrado con el mismo codigo", "Error: Guardar Museo", JOptionPane.ERROR_MESSAGE);
            } else {
                mdao.guardar(Conexion.obtener(), museo);
                JOptionPane.showMessageDialog(null, "Se ha registrado el museo correctamente.", "Informacion: Guardar Museo.", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {

        }
    }

    // Buscar un museo por nombre
    public MuseoVO buscarMuseoNombre(String nombre) {
        MuseoVO museoBuscado = new MuseoVO();
        try {
            MuseoDAO mdao = new MuseoDAO();

            museoBuscado = mdao.buscarPorNombre(Conexion.obtener(), nombre);

            return museoBuscado;
        } catch (Exception e) {
            return null;
        }
    }

    // Buscar un museo por codigo
    public MuseoVO buscarMuseoCodigo(int codigo) {
        MuseoVO museoBuscado = new MuseoVO();
        try {
            MuseoDAO mdao = new MuseoDAO();

            museoBuscado = mdao.buscarPorCodigo(Conexion.obtener(), codigo);

            return museoBuscado;
        } catch (Exception e) {
            return null;
        }
    }
    
    // Mostrar museos en tabla 
    public void mostrarMuseos(JTable tabla) {
        try {
            MuseoDAO mdao = new MuseoDAO();
            mdao.mostrarMuseo(Conexion.obtener(), tabla);

        } catch (Exception e) {
        }

    }
    // Mostrar museos en tabla 2
    public void mostrarMuseosCodigo(JTable tabla, int codigo) {
        try {
            MuseoDAO mdao = new MuseoDAO();
            mdao.mostrarMuseoCodigo(Conexion.obtener(), tabla, codigo);

        } catch (Exception e) {
        }

    }
    // Eliminar un museo
    public void eliminarMuseo(int codigo) {
        try {
            MuseoDAO mdao = new MuseoDAO();
            mdao.eliminar(Conexion.obtener(), codigo);

        } catch (Exception e) {
        }

    }

}
