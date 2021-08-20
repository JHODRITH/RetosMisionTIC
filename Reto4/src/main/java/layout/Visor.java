package layout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.*;
import java.sql.SQLException;

import javax.swing.*;
//import javax.swing.border.Border;

import view.VistaRequerimientosReto4;
import model.dao.ConsultaBdDao;
import model.vo.ConsultaBD;

public class Visor extends JFrame implements ActionListener {
    //Construcctor
    public Visor(){
        initComponets();
        setSize(600, 550);
        setLocationRelativeTo(null);
    }
        //Declaracion de los elementos de la ventana
        JMenuBar menuBar=new JMenuBar();
        JMenu jmMenu = new JMenu("Menu");
        JMenuItem itemConsutar = new JMenuItem("Consultar Avanzada");
        JMenuItem itemSalir = new JMenuItem("Salir");
        JMenu jmAyuda = new JMenu("Ayuda");
        JMenuItem itemAcerca = new JMenuItem("Acerca de");

        final JTable campoResultado=new JTable();
        final JScrollPane jScroll = new JScrollPane();
        
        final JLabel nomdre =new JLabel();
        String[] columnas;
        
        JButton bconsulta3=new JButton("Consulta3");
        JButton bconsulta2=new JButton("Consulta2");
        JButton bconsulta1=new JButton("Consulta1");
        JButton bLimpiar = new JButton(" Limpiar ");

        JLabel label =new JLabel("      ");
        JLabel label1 =new JLabel("      ");
        JLabel label2 =new JLabel("      ");
        JLabel label3 =new JLabel("      ");
        
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

    public void initComponets(){
        
        // elementos visibles
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONSULTAS A BASES DE DATOS");
        
        //Estructura barra de Menu
        menuBar.add(jmMenu);
        jmMenu.add(itemConsutar);
        itemConsutar.addActionListener(this);
        jmMenu.add(itemSalir);
        itemSalir.addActionListener(this);

        menuBar.add(jmAyuda);
        jmAyuda.add(itemAcerca);
        itemAcerca.addActionListener(this);

        getContentPane().add(BorderLayout.NORTH, menuBar);

        // Caja de Botones
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
        bLimpiar.setAlignmentX(Component.CENTER_ALIGNMENT);
        bLimpiar.setAlignmentY(Component.LEFT_ALIGNMENT);
        bLimpiar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                nomdre.setText("");
                columnas=new String[]{"       ", "      ", "      "};
                campoResultado.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, columnas) {
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

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(label);
        panel1.add(bconsulta1);
        panel1.add(label1);
        panel1.add(bconsulta2);
        panel1.add(label2);
        panel1.add(bconsulta3);
        panel1.add(label3);
        panel1.add(bLimpiar);

        //Area de la tabla
        panel2.setBorder(BorderFactory.createTitledBorder("Resultado"));
        panel2.add(nomdre);
        panel2.add(jScroll);
        
        getContentPane().add(panel2);
        getContentPane().add(panel1, BorderLayout.LINE_START);

        pack();

    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==itemAcerca){
            actionPerformedAcerca(e);
        }
        if (e.getSource()==itemConsutar) {
            try {
                actionPerformedConsulta(e);
            } catch (SQLException e1) {
                System.out.println("Error ejecutando Consulta avanzada");
                e1.printStackTrace();
            }
        }
        if (e.getSource()==itemSalir) {
            actionPerformedSalir(e);
        }
        
    }
    protected void actionPerformedAcerca(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Consulta1 llama a la tabla Proyecto Ciudad \n muestra estos campos \n Constructora Fecha_Inicio Clasificación", "Acerda de", JOptionPane.INFORMATION_MESSAGE);
    }
    protected void actionPerformedConsulta(ActionEvent e) throws SQLException {

        ConsultaBdDao campo = new ConsultaBdDao();
        nomdre.setText("Consulta Avanzada");
        columnas=campo.ObtenerCampo();

        campoResultado.setModel(new javax.swing.table.DefaultTableModel(VistaRequerimientosReto4.requerimiento4(), columnas) {
            Class<?>[] types = new Class[] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                

            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false,
                false, false, false, false, false,
                false, false, false, false, false,
                false, false, false, false, false
                
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

    protected void actionPerformedSalir(ActionEvent e) {
        System.exit(WIDTH);
    }



    public static ConsultaBD informacion(){
        ConsultaBD query = new ConsultaBD();
        
        query.setSeleccion("*");
        query.setDesde("Proyecto");
        query.setDonde(" ");
        return query;
    }

}

//campoResultado.setSize(Toolkit.getDefaultToolkit().getScreenSize());
//l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido AS 'Nombre Lider' Lider l
//campoResultado.setSize(Toolkit.getDefaultToolkit().getScreenSize());
//jScroll.setAutoscrolls(true);
//jScroll.setBounds(5, 200, 500 , 400);


