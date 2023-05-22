
package principal;

import controller.Control;
//import controller.Login;
import view.VistaInicio;
import view.VistaMuseo;


public class AbrirMuseo {

  
    public static void main(String[] args) {
       
        // Se llaman nuestras vistas y el controlador que operara sobre ellas
        VistaInicio abrirMuseo = new VistaInicio();
        VistaMuseo abrirRegistros = new VistaMuseo();
        Control control = new Control(abrirRegistros, abrirMuseo);
       
    }
    
}
