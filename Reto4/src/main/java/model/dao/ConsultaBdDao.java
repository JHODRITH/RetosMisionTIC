package model.dao;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Estructura de datos
import java.util.ArrayList;
//import java.util.function.Consumer;

//Encapsulamiento de los datos
import model.vo.ConsultaBD;
import model.vo.ObjetosConsulta;
import layout.Visor;

//Clase para conexión
import util.JDBCUtilities;

public class ConsultaBdDao {

    //String nTablas [];= new String[]{}
    String[] nCampos ;

    
    ConsultaBD consul =Visor.informacion();
        
        int posInicial;
        int posFinal;
       
    public ArrayList<ObjetosConsulta> rankingObjetosConsulta() throws SQLException {

        ArrayList<ObjetosConsulta> respuesta = new ArrayList<ObjetosConsulta>();
        Connection conexion = JDBCUtilities.getConnection();

        try {
            
            String consulta = "SELECT "+ consul.getSeleccion()
                            + " FROM "+ consul.getDesde();
                            //+ " WHERE "+ consul.getDonde()
                            
                            if (consul.getDonde().equals(" ")) {
                                System.out.println("Where esta en blanco "+consul.getDonde());
                            }else{
                                consulta = "SELECT "+ consul.getSeleccion()
                                + " FROM "+ consul.getDesde()
                                + " WHERE "+ consul.getDonde();
                            }/**/
            
            this.ObtenerCampo();
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();
            System.out.println(consul.getSeleccion());
            while(resultSet.next()){
                ObjetosConsulta obtenido = new ObjetosConsulta();
                int j=0;

                
                for (int i = 0; i < nCampos.length ; i++) {
                    if (j==0) {
                        obtenido.setValor0(resultSet.getString(nCampos[i]));
                        j++;
                    }else{
                    if (j==1) {
                        obtenido.setValor1(resultSet.getString(nCampos[i].replace(" ", "")));
                        j++;
                    }else{
                    if (j==2) {
                        obtenido.setValor2(resultSet.getString(nCampos[i].replace(" ", "")));
                        j++;
                    }else{
                    if (j==3) {
                        obtenido.setValor3(resultSet.getString(nCampos[i].replace(" ", "")));
                        j++;
                    }else{
                    if (j==4) {
                        obtenido.setValor4(resultSet.getString(nCampos[i].replace(" ", "")));
                        j++;
                    }else{
                    if (j==5) {
                        obtenido.setValor5(resultSet.getString(nCampos[i].replace(" ", "")));
                        j++;
                    }else{
                    if (j==6) {
                        obtenido.setValor6(resultSet.getString(nCampos[i].replace(" ", "")));
                        j++;
                    }else{
                    if (j==7) {
                        obtenido.setValor7(resultSet.getString(nCampos[i].replace(" ", "")));
                        j++;
                    }else{
                    if (j==8) {
                        obtenido.setValor8(resultSet.getString(nCampos[i].replace(" ", "")));
                        j++;
                    }else{
                    if (j==9) {
                        obtenido.setValor9(resultSet.getString(nCampos[i].replace(" ", "")));
                        j++;
                    }else{
                    if (j==10) {
                        obtenido.setValor10(resultSet.getString(nCampos[i].replace(" ", "")));
                        j++;
                    }else{
                    if (j==11) {
                        obtenido.setValor11(resultSet.getString(nCampos[i].replace(" ", "")));
                        j++;
                    }else{
                    if (j==12) {
                        obtenido.setValor12(resultSet.getString(nCampos[i].replace(" ", "")));
                        j++;
                    }else{
                    if (j==13) {
                        obtenido.setValor13(resultSet.getString(nCampos[i].replace(" ", "")));
                        j++;
                    }else{
                    if (j==14) {
                        obtenido.setValor14(resultSet.getString(nCampos[i].replace(" ", "")));
                        j++;
                    }else{
                    if (j==15) {
                        obtenido.setValor15(resultSet.getString(nCampos[i].replace(" ", "")));
                        j++;
                    }else{
                    if (j==16) {
                        obtenido.setValor16(resultSet.getString(nCampos[i].replace(" ", "")));
                        j++;
                    }else{
                    if (j==17) {
                        obtenido.setValor17(resultSet.getString(nCampos[i].replace(" ", "")));
                        j++;
                    }else{
                    if (j==18) {
                        obtenido.setValor18(resultSet.getString(nCampos[i].replace(" ", "")));
                        j++;
                    }else{
                    if (j==19) {
                        obtenido.setValor19(resultSet.getString(nCampos[i].replace(" ", "")));
                        j++;
                    }else{
                        System.out.println("Falta llenar mas datos");
                    }}}}}}}}}}}}}}}}}}}}
                    
                }
                respuesta.add(obtenido);
                
            }

            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error Accesando a la consulta !!" + e);
            
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }
        return respuesta;
    }

    public String[] ObtenerCampo() throws SQLException{
        
        String st= consul.getSeleccion();
        ArrayList<String> lista = new ArrayList<String>();
        Connection conexion = JDBCUtilities.getConnection();
        try {           
            String campo ="SELECT name FROM pragma_table_info('"+consul.getDesde()+"')";
            
            PreparedStatement statementTablas = conexion.prepareStatement(campo);
            ResultSet resultSetTablas = statementTablas.executeQuery();
                //System.out.println(resultSetTablas.last()+" entra obtener campo");
                //System.out.println(.getRow());
                // = new String[]{};

            if (st.equals("*")) {

                //int i= 0;//i++;////String  
                while (resultSetTablas.next()) {
                    
                    //System.out.println(resultSetTablas.getString(1)+" entra obtener campo");
                    
                    lista.add(resultSetTablas.getString(1));
                    
                    
                }

                nCampos= new String[lista.size()];
                for (int i = 0; i < lista.size(); i++) {
                    nCampos[i]=lista.get(i);
                    //System.out.println(nCampos[i]);
                }


            } else {
                nCampos= new String[]{" "," "};
                if (st.contains(" AS ")) {
                    //System.out.println(st+" entra obtener campo");
                    posInicial=st.indexOf(" AS ");
                        //System.out.println(posInicial+" entra obtener campo");
                        //System.out.println(st.substring(posInicial)+" subCadena");
                    posFinal=st.substring(posInicial+5).indexOf("'");
                        //System.out.println("nombre de campo "+st.substring(posInicial+5,posInicial+5+posFinal));
                        //System.out.println(posFinal+" entra obtener campo");
                    nCampos[0]=st.substring(posInicial+5, posInicial+5+posFinal);
                    //System.out.println(nCampos[0]);
                } else {
                    if (st.contains(",")) {
                        nCampos= st.split(",");
                    } else {
                        nCampos[0]=st;
                        
                    }
                }
            }
            resultSetTablas.close();
            statementTablas.close();

        } catch (Exception e) {
            System.err.println("Error Obteniendo Campos !!" + e);
            
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }
        return nCampos;
    }
}
