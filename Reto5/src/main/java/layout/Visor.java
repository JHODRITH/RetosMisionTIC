package layout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;

import javax.swing.*;
import view.VistaRequerimientosReto4;

public class Visor extends JFrame {

    String[] columnas;
    
    //ArrayList<Object> listado = new ArrayList<Object>();

    public Visor(){
        initComponets();
        setSize(600, 550);
        setLocationRelativeTo(null);
    }

    public void initComponets(){
        
        // elementos visibles
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JMenuBar menuBar=new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem itemConsutar = new JMenuItem("Consultar");
        JMenuItem itemSalir = new JMenuItem("Salir");
        JMenu ayuda = new JMenu("Ayuda");

        final JTable campoResultado=new JTable();
        final JLabel nomdre =new JLabel();
        final JScrollPane jScroll = new JScrollPane();
        
        JButton bconsulta3=new JButton("Consulta3");
        JButton bconsulta2=new JButton("Consulta2");
        JButton bconsulta1=new JButton("Consulta1");
        JLabel label =new JLabel("      ");
        JLabel label1 =new JLabel("      ");
        JLabel label2 =new JLabel("      ");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONSULTAS A BASES DE DATOS");
        
        //barra de Menu
        menuBar.add(menu);
        menuBar.add(ayuda);
        menu.add(itemConsutar);
        menu.add(itemSalir);
        getContentPane().add(BorderLayout.NORTH, menuBar);

        // Caja de Botones
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        bconsulta1.setAlignmentX(Component.CENTER_ALIGNMENT);

        bconsulta1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                nomdre.setText("-----Proyecto Ciudad-------");
                columnas=new String[]{"Constructora", "Fecha_Inicio", "Clasificación"};
                campoResultado.setModel(new javax.swing.table.DefaultTableModel(VistaRequerimientosReto4.requerimiento1(), columnas) {
                    Class<?>[] types = new Class[] {
                        java.lang.String.class, java.lang.String.class, java.lang.String.class
                    };
                    boolean[] canEdit = new boolean [] {
                        false, false, false
                    };
        
                    public Class<?> getColumnClass(int columnIndex) {
                        return types [columnIndex];
                    }
        
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
                });
                jScroll.setViewportView(campoResultado);
            }
        });
        bconsulta2.setAlignmentX(Component.CENTER_ALIGNMENT);
        bconsulta2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                nomdre.setText("-----Suma Cantidades-------");
                columnas=new String[]{"Cantidad"};
                campoResultado.setModel(new javax.swing.table.DefaultTableModel(VistaRequerimientosReto4.requerimiento2(), columnas) {
                    Class<?>[] types = new Class[] {
                        java.lang.String.class
                    };
                    boolean[] canEdit = new boolean [] {
                        false
                    };
        
                    public Class<?> getColumnClass(int columnIndex) {
                        return types [columnIndex];
                    }
        
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
                });
                jScroll.setViewportView(campoResultado);

            }
        });
        bconsulta3.setAlignmentX(Component.CENTER_ALIGNMENT);
        bconsulta3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                nomdre.setText("-----Líder Ciudad-------");
                columnas=new String[]{"Nombre Líder"};
                campoResultado.setModel(new javax.swing.table.DefaultTableModel(VistaRequerimientosReto4.requerimiento3(), columnas) {
                    Class<?>[] types = new Class[] {
                        java.lang.String.class
                    };
                    boolean[] canEdit = new boolean [] {
                        false
                    };
        
                    public Class<?> getColumnClass(int columnIndex) {
                        return types [columnIndex];
                    }
        
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
                });
                jScroll.setViewportView(campoResultado);

            }
        });
        panel2.add(nomdre, BorderLayout.PAGE_START);
        
        panel1.add(label);
        panel1.add(bconsulta1);
        panel1.add(label1);
        panel1.add(bconsulta2);
        panel1.add(label2);
        panel1.add(bconsulta3);

        //Area de la tabla
        panel2.setBorder(BorderFactory.createTitledBorder("Resultado"));
        
        panel2.add(jScroll);

        getContentPane().add(panel2);
        getContentPane().add(panel1, BorderLayout.LINE_START);

        pack();

    }

    /*public void accion(){
        System.out.println("columnas asignadas");
        
        System.out.println(listado.toString().trim());
        Object temp = listado.get(1);

        System.out.println(temp.toString());
        columnas=(String[]) temp ;
        System.out.println(columnas.toString());
        for(int i=0;i<=3;i++){
            
        }

            System.out.println(String.valueOf(listado.get(0)));
            
            
            
            elementos=(Object[][])listado.get(2);
            
    }*/

}

