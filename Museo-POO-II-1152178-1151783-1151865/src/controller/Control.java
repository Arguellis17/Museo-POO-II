package controller;

import view.VistaMuseo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modeloVO.Genero;
import modeloVO.VisitanteVO;
import modeloVO.MuseoVO;
import view.VistaInicio;

public class Control implements ActionListener {

    // Creacion de recursos del programa
    private VistaInicio verInicio;
    private VistaMuseo verMuseo;
    private VisitanteVO visitante;
    private MuseoVO museo;
    private Servicios servicios;
    private DefaultTableModel registros;

    // Se inicializan las vistas, la de entrar al museo y la vista del museo
    public Control(VistaMuseo verMuseo, VistaInicio verInicioMuseo) {

        this.verMuseo = verMuseo;
        this.verInicio = verInicioMuseo;

        actionListener(this);

    }

    // Inicializando los botones, conectandolos con el control
    private void actionListener(ActionListener control) {

        verMuseo.btnGuardar.addActionListener(control);
        verMuseo.btnEliminar.addActionListener(control);
        verMuseo.btnLimpiar.addActionListener(control);
        verMuseo.btnBuscar.addActionListener(control);
        verMuseo.btnActualizar.addActionListener(control);
        verMuseo.btnMostrarVisitante.addActionListener(control);
        verMuseo.btnMostrarRegistro.addActionListener(control);
        verMuseo.btnEliminarMuseo.addActionListener(control);
        verMuseo.btnGuardarMuseo.addActionListener(control);
        verInicio.btnEntrar.addActionListener(control);

    }

    @Override
    
    // Ver que botones a presionado el usuario
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().contentEquals("Entrar")) {

            // Se hace visible la vista del museo
            verMuseo.setVisible(true);

            // Se cierra la ventana del login
            verInicio.dispose();
            

        }

        if (e.getActionCommand().contentEquals("Guardar")) {

            if (verMuseo.txtCedula.getText().equals("") || verMuseo.txtNombre.getText().equals("") || verMuseo.txtApellido.getText().equals("") || verMuseo.txtProfesion.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "Campos vacios en el visitante.", "Error: Guardar Visitante", JOptionPane.ERROR_MESSAGE);
            } else {

                String cedula = verMuseo.txtCedula.getText();
                String nombre = verMuseo.txtNombre.getText();
                String apellidos = verMuseo.txtApellido.getText();
                String genero = verMuseo.cmbGenero.getSelectedItem().toString();
                String profesion = verMuseo.txtProfesion.getText();
                String ciudadOrigen = verMuseo.txtCiudad.getText();
                int codigoMuseo = verMuseo.cmbMuseo.getSelectedIndex() + 1;

                Servicios servicios = new Servicios();

                MuseoVO museoCodigo = servicios.buscarMuseoCodigo(codigoMuseo);

                if (genero.equalsIgnoreCase("Masculino")) {
                    VisitanteVO visitante = new VisitanteVO(cedula, nombre, apellidos, Genero.Masculino, profesion, ciudadOrigen, museoCodigo);
                    servicios.guardarVisitante(visitante);
                }
                if (genero.equalsIgnoreCase("Femenino")) {
                    VisitanteVO visitante = new VisitanteVO(cedula, nombre, apellidos, Genero.Femenino, profesion, ciudadOrigen, museoCodigo);
                    servicios.guardarVisitante(visitante);
                }

                servicios.mostrarVisitante(verMuseo.jTableVisitantes);
                servicios.mostrarMuseos(verMuseo.jTableMuseo);

            }

        }
        if (e.getActionCommand().contentEquals("Buscar")) {
            if (verMuseo.txtCedula.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debes ingresar un numero de cédula.", "Advertencia: Buscar Visitante", JOptionPane.WARNING_MESSAGE);
            } else {
                String cedula = verMuseo.txtCedula.getText();
                Servicios servicios = new Servicios();
                VisitanteVO visitante = servicios.buscarVisitanteCedula(cedula);

                if (visitante != null) {
                    verMuseo.txtCedula.setText(visitante.getCedula());
                    verMuseo.txtNombre.setText(visitante.getNombre());
                    verMuseo.txtApellido.setText(visitante.getApellidos());
                    verMuseo.cmbGenero.setSelectedItem(String.valueOf(visitante.getGenero()));
                    verMuseo.txtProfesion.setText(visitante.getProfesion());
                    verMuseo.txtCiudad.setText(visitante.getCiudadOrigen());
                    verMuseo.cmbMuseo.setSelectedItem(visitante.getMuseo().getNombre());
                } else {
                     JOptionPane.showMessageDialog(null, "La cédula no se encuentra registrada.", "Error: Buscar Visitante", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e.getActionCommand().contentEquals("Limpiar")) {
            
            // Limpiar campos del visitante
            verMuseo.txtCedula.setText("");
            verMuseo.txtNombre.setText("");
            verMuseo.txtApellido.setText("");
            verMuseo.cmbGenero.setSelectedIndex(0);
            verMuseo.txtProfesion.setText("");
            verMuseo.txtCiudad.setText("");
            verMuseo.txtAreaResultado.setText("");
            verMuseo.cmbMuseo.setSelectedIndex(0);
            
            
            // Limpiar campos del museo
            verMuseo.txtCodigoMuseo.setText("");
            verMuseo.txtNombreMuseo.setText("");
            verMuseo.txtMunicipio.setText("");
            verMuseo.txtDpto.setText("");

            
        }
        if (e.getActionCommand().contentEquals("Eliminar")) {
            if (verMuseo.txtCedula.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debes ingresar un numero de cédula.", "Advertencia: Eliminar Visitante", JOptionPane.WARNING_MESSAGE);
            } else {
                String cedula = verMuseo.txtCedula.getText();
                Servicios servicios = new Servicios();
                VisitanteVO visitante = servicios.buscarVisitanteCedula(cedula);

                if (visitante != null) {
                    verMuseo.txtCedula.setText(visitante.getCedula());
                    verMuseo.txtNombre.setText(visitante.getNombre());
                    verMuseo.txtApellido.setText(visitante.getApellidos());
                    verMuseo.cmbGenero.setSelectedItem(String.valueOf(visitante.getGenero()));
                    verMuseo.txtProfesion.setText(visitante.getProfesion());
                    verMuseo.txtCiudad.setText(visitante.getCiudadOrigen());
                    verMuseo.cmbMuseo.setSelectedItem(visitante.getMuseo().getNombre());

                    servicios.eliminarVisitante(cedula);
                    JOptionPane.showMessageDialog(null, "Se eliminó el registro del visitante.", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
                    verMuseo.txtCedula.setText("");
                    verMuseo.txtNombre.setText("");
                    verMuseo.txtApellido.setText("");
                    verMuseo.cmbGenero.setSelectedIndex(0);
                    verMuseo.txtProfesion.setText("");
                    verMuseo.txtCiudad.setText("");
                    verMuseo.cmbMuseo.setSelectedIndex(0);

                    servicios.mostrarVisitante(verMuseo.jTableVisitantes);
                    servicios.mostrarMuseos(verMuseo.jTableMuseo);
                } else {
                    JOptionPane.showMessageDialog(null, "La cédula no se encuentra registrada.", "Error: Eliminar Visitante", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
     if (e.getActionCommand().contentEquals("Actualizar")) {
            if (verMuseo.txtCedula.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debes ingresar un numero de cédula.", "Advertencia: Actualizar Ciudad Visitante", JOptionPane.WARNING_MESSAGE);
            } else {

                String cedula = verMuseo.txtCedula.getText();
                Servicios servicios = new Servicios();
                VisitanteVO visitante = servicios.buscarVisitanteCedula(cedula);

                if (visitante == null) {
                    JOptionPane.showMessageDialog(null, "La cédula no se encuentra registrada", "Error: Actualizar Ciudad Visitante", JOptionPane.ERROR_MESSAGE);
                } else {
                    verMuseo.txtCedula.setText(visitante.getCedula());
                    verMuseo.txtNombre.setText(visitante.getNombre());
                    verMuseo.txtApellido.setText(visitante.getApellidos());
                    verMuseo.cmbGenero.setSelectedItem(String.valueOf(visitante.getGenero()));
                    verMuseo.txtProfesion.setText(visitante.getProfesion());
                    verMuseo.txtCiudad.setText(visitante.getCiudadOrigen());
                    verMuseo.cmbMuseo.setSelectedItem(visitante.getMuseo().getNombre());

                    String ciudadNueva = "";
                    do {
                        ciudadNueva = JOptionPane.showInputDialog("Ingrese la ciudad nueva");
                        if (ciudadNueva == null || ciudadNueva.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Ingrese una ciudad válida", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } while (ciudadNueva == null || ciudadNueva.isEmpty());

                    servicios.actualizarCiudadVisitante(cedula, ciudadNueva);
               
                    JOptionPane.showMessageDialog(null, "Se ha actualizado la ciudad correctamente.", "Informacion: Actualizar Ciudad Visitante.", JOptionPane.INFORMATION_MESSAGE);

                    servicios.mostrarVisitante(verMuseo.jTableVisitantes);
                    servicios.mostrarMuseos(verMuseo.jTableMuseo);
                }

            }

        }   if (e.getActionCommand().contentEquals("Mostrar Visitantes")) {
            int codigomuseo = verMuseo.cmbMuseoVisitante.getSelectedIndex() + 1;

            Servicios servicios = new Servicios();
            int[] gen = servicios.mostrarVisitantesMuseo(verMuseo.jTableVisitantes, codigomuseo);
            servicios.mostrarMuseosCodigo(verMuseo.jTableMuseo, codigomuseo);
            verMuseo.txtAreaResultado.setText("Cantidad de mujeres: " + gen[0] + "\n Cantidad de hombres: " + gen[1] + "\n Cantidad Total: " + gen[2]);

        }
        if (e.getActionCommand().contentEquals("Mostrar Registros")) {

            Servicios servicios = new Servicios();
            servicios.mostrarVisitante(verMuseo.jTableVisitantes);
            servicios.mostrarMuseos(verMuseo.jTableMuseo);

        }
        if (e.getActionCommand().contentEquals("Guardar Museo")) {
           
            if (verMuseo.txtCodigoMuseo.getText().equals("") || verMuseo.txtNombreMuseo.getText().equals("") || verMuseo.txtMunicipio.getText().equals("") || verMuseo.txtDpto.getText().equals("")) {
                
                JOptionPane.showMessageDialog(null, "Campos vacios en el museo.", "Error: Guardar Museo", JOptionPane.ERROR_MESSAGE);
    
            } else {

                int codigo = Integer.parseInt(verMuseo.txtCodigoMuseo.getText());
                String nombre = verMuseo.txtNombreMuseo.getText();
                String municipio = verMuseo.txtMunicipio.getText();
                String dpto = verMuseo.txtDpto.getText();

                Servicios servicios = new Servicios();

                MuseoVO museo = new MuseoVO(codigo, nombre, municipio, dpto);

                servicios.guardarMuseo(museo);
                
                servicios.mostrarVisitante(verMuseo.jTableVisitantes);
                servicios.mostrarMuseos(verMuseo.jTableMuseo);

            }

        }if (e.getActionCommand().contentEquals("Eliminar Museo")) {
            if (verMuseo.txtCodigoMuseo.getText().equals("")) {
                 JOptionPane.showMessageDialog(null, "Debes ingresar un código valido.", "Advertencia: Eliminar Museo", JOptionPane.WARNING_MESSAGE);
            } else {
                int codigo = Integer.parseInt(verMuseo.txtCodigoMuseo.getText());
                Servicios servicios = new Servicios();
                MuseoVO museo = new MuseoVO();
                museo = servicios.buscarMuseoCodigo(codigo);

                if(museo !=null){
                verMuseo.txtNombreMuseo.setText(museo.getNombre());
                verMuseo.txtMunicipio.setText(museo.getMunicipio());
                verMuseo.txtDpto.setText(museo.getDepartamento());

                servicios.eliminarMuseo(codigo);
                 JOptionPane.showMessageDialog(null, "Se eliminó el registro del museo.", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);

                verMuseo.txtCodigoMuseo.setText("");
                verMuseo.txtNombreMuseo.setText("");
                verMuseo.txtMunicipio.setText("");
                verMuseo.txtDpto.setText("");

                servicios.mostrarVisitante(verMuseo.jTableVisitantes);
                servicios.mostrarMuseos(verMuseo.jTableMuseo);

                }else{
                     JOptionPane.showMessageDialog(null, "El código no esta registrado.", "Error: Eliminar Museo", JOptionPane.ERROR_MESSAGE);
                }
            }

        }

    }
}

