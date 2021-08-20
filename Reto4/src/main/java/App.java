import javax.swing.*;
import layout.Visor;
//import view.VistaRequerimientosReto4;
/**
 * Persistencia Proyectos Construcción
 *
 */
public class App {
    public static void main(String[] args) {

        /*/ Requerimiento 1 - Reto3
        VistaRequerimientosReto4.requerimiento1();
        System.out.println();

        // Requerimiento 3 - Reto3
        VistaRequerimientosReto4.requerimiento3();
        System.out.println();

        // Requerimiento 4 - Reto3
        VistaRequerimientosReto4.requerimiento4();
        System.out.println();*/

        //Ventana
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Visor().setVisible(true);
            }
        });

    }

}
