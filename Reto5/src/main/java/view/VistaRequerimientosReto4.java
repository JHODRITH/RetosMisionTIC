package view;

import controller.ControladorRequerimientosReto4;
import model.vo.LiderCiudad;
import model.vo.SumaProveedor;
import model.vo.ProyectoCiudad;

import java.sql.SQLException;
import java.util.ArrayList;

public class VistaRequerimientosReto4 {

    public static ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();
    static Object[][] datos = new Object[][]{};

    public static Object[][] requerimiento1() {
        
        try{
            ArrayList<ProyectoCiudad> rankingProyectosCiudad = controlador.consultarProyectoCiudad();
            datos= new Object[rankingProyectosCiudad.size()+1][3];
            int i=0;
            for(ProyectoCiudad proyectoCiudad: rankingProyectosCiudad){
                //System.out.printf("%s %s %s %n", proyectoCiudad.getConstructora(), proyectoCiudad.getFechaInicio(), proyectoCiudad.getClasificacion());
                datos[i][0]=proyectoCiudad.getConstructora();
                datos[i][1]=proyectoCiudad.getFechaInicio();
                datos[i][2]=proyectoCiudad.getClasificacion();
                i++;
            }
            
        }catch(SQLException e){
            System.out.println(e + "aqui");
        }
        return datos;
    }

    public static Object[][] requerimiento2() {
        
        try{
            ArrayList<SumaProveedor> rankingSumaProveedor = controlador.consultarSumaProveedor();
            datos=new Object[rankingSumaProveedor.size()+1][1];
            int i=0;
            for(SumaProveedor sumaProveedor: rankingSumaProveedor){
                datos[i][0]=sumaProveedor.getCantidad();
                i++;
                System.out.printf("%s %n", sumaProveedor.getCantidad());
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return datos;
    }

    public static Object[][] requerimiento3() {
        Object[][] datos = new Object[][]{};
        try{
            ArrayList<LiderCiudad> rankingLiderCiudad = controlador.consultarLiderCiudad();
            datos=new Object[rankingLiderCiudad.size()+1][1];
            int i=0;
            for(LiderCiudad liderCiudad: rankingLiderCiudad){
                System.out.printf("%s %n", liderCiudad.getNombreLider());
                datos[i][0]=liderCiudad.getNombreLider();
                i++;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return datos;
    }

}
        //ArrayList<Object> listado = new ArrayList<Object>();
        /*String[] encabezado=new String[] {
                "Constructora", "Fecha_Inicio", "Clasificación"
            };

                
                listado.add(nombreTabla);
            listado.add(encabezado);
            listado.add(datos);
            System.out.println(i);
            */