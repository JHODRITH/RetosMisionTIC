package view;

import controller.ControladorRequerimientosReto4;
import model.vo.LiderCiudad;
import model.vo.SumaProveedor;
import model.vo.ProyectoCiudad;
import model.vo.ObjetosConsulta;
import model.dao.ConsultaBdDao;


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
                //System.out.printf("%s %n", sumaProveedor.getCantidad());
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
                //System.out.printf("%s %n", liderCiudad.getNombreLider());
                datos[i][0]=liderCiudad.getNombreLider();
                i++;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return datos;
    }

    public static Object[][] requerimiento4() {
        ConsultaBdDao campo = new ConsultaBdDao();
        try{

            ArrayList<ObjetosConsulta> rankingObjetosConsulta = controlador.consultarObjetosConsulta();
            datos= new Object[rankingObjetosConsulta.size()+1][campo.ObtenerCampo().length];
            int i=0;
            for(ObjetosConsulta objetosConsulta: rankingObjetosConsulta){

               // System.out.printf("%s %s %s %n", objetosConsulta.getValor0(), objetosConsulta.getValor1(), objetosConsulta.getValor2());
                
                for (int j = 0; j < campo.ObtenerCampo().length; j++) {
                    if(j==0 ){
                        datos[i][j]=objetosConsulta.getValor0();
                    }else{
                    if(j==1 ){
                        datos[i][j]=objetosConsulta.getValor1();
                    }else{
                    if(j==2 ){
                        datos[i][j]=objetosConsulta.getValor2();
                    }else{
                    if(j==3 ){
                        datos[i][j]=objetosConsulta.getValor3();
                    }else{
                    if(j==4 ){
                        datos[i][j]=objetosConsulta.getValor4();
                    }else{
                    if(j==5 ){
                        datos[i][j]=objetosConsulta.getValor5();
                    }else{
                    if(j==6 ){
                        datos[i][j]=objetosConsulta.getValor6();
                    }else{
                    if(j==7 ){
                        datos[i][j]=objetosConsulta.getValor7();
                    }else{
                    if(j==8 ){
                        datos[i][j]=objetosConsulta.getValor8();
                    }else{
                    if(j==9 ){
                        datos[i][j]=objetosConsulta.getValor9();
                    }else{
                    if(j==10){
                        datos[i][j]=objetosConsulta.getValor10();
                    }else{
                        if(j==11 ){
                            datos[i][j]=objetosConsulta.getValor11();
                        }else{
                            if(j==12 ){
                                datos[i][j]=objetosConsulta.getValor12();
                                }else{
                                if(j==13 ){
                                    datos[i][j]=objetosConsulta.getValor13();
                                }else{
                                    if(j==14 ){
                                        datos[i][j]=objetosConsulta.getValor14();
                                        }else{
                                        if(j==15 ){
                                            datos[i][j]=objetosConsulta.getValor15();
                                            }else{
                                            if(j==16 ){
                                                datos[i][j]=objetosConsulta.getValor16();
                                                }else{
                                                if(j==17 ){
                                                    datos[i][j]=objetosConsulta.getValor17();
                                                    }else{
                                                        if(j==18 ){
                                                            datos[i][j]=objetosConsulta.getValor18();
                                                        }else{
                                                            if(j==19 ){
                                                                datos[i][j]=objetosConsulta.getValor19();
                                                            }else{System.out.println("Faltan Campos");}
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }}}}}}}}}}
                }
                
                i++;
            }
            
        }catch(SQLException e){
            System.out.println(e + "aqui");
        }
        return datos;
    }

}