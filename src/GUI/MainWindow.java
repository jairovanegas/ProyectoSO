/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CPU.Procesador;
import Data.InstruccionData;
import Data.MemoriaData;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GamerGarage
 */
public class MainWindow extends javax.swing.JFrame {

    Procesador cpu;
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        cpu = new Procesador();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pPrincipal = new javax.swing.JPanel();
        pInstrucciones = new javax.swing.JPanel();
        spInstrucciones = new javax.swing.JScrollPane();
        tableInstrucciones = new javax.swing.JTable();
        pProcesos = new javax.swing.JPanel();
        spProcesos = new javax.swing.JScrollPane();
        listProcesos = new javax.swing.JList<>();
        pRegistros = new javax.swing.JPanel();
        spRegistros = new javax.swing.JScrollPane();
        tableRegistros = new javax.swing.JTable();
        pMemoria = new javax.swing.JPanel();
        spMemoria = new javax.swing.JScrollPane();
        tableMemoria = new javax.swing.JTable();
        pPila = new javax.swing.JPanel();
        spPila = new javax.swing.JScrollPane();
        tablePila = new javax.swing.JTable();
        btnTick = new javax.swing.JButton();
        btnDelProceso = new javax.swing.JButton();
        btnAddProceso = new javax.swing.JButton();
        pTraza = new javax.swing.JPanel();
        spTraza = new javax.swing.JScrollPane();
        listTraza = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pInstrucciones.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Instrucciones"));

        tableInstrucciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Comando", "Direccion", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        spInstrucciones.setViewportView(tableInstrucciones);

        javax.swing.GroupLayout pInstruccionesLayout = new javax.swing.GroupLayout(pInstrucciones);
        pInstrucciones.setLayout(pInstruccionesLayout);
        pInstruccionesLayout.setHorizontalGroup(
            pInstruccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spInstrucciones)
        );
        pInstruccionesLayout.setVerticalGroup(
            pInstruccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spInstrucciones, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pProcesos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Procesos"));

        spProcesos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        listProcesos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listProcesosValueChanged(evt);
            }
        });
        spProcesos.setViewportView(listProcesos);

        javax.swing.GroupLayout pProcesosLayout = new javax.swing.GroupLayout(pProcesos);
        pProcesos.setLayout(pProcesosLayout);
        pProcesosLayout.setHorizontalGroup(
            pProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pProcesosLayout.setVerticalGroup(
            pProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pProcesosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(spProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pRegistros.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Registros"));

        spRegistros.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tableRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Direccion", "ID", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        spRegistros.setViewportView(tableRegistros);

        javax.swing.GroupLayout pRegistrosLayout = new javax.swing.GroupLayout(pRegistros);
        pRegistros.setLayout(pRegistrosLayout);
        pRegistrosLayout.setHorizontalGroup(
            pRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pRegistrosLayout.setVerticalGroup(
            pRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pMemoria.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Memoria"));

        spMemoria.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tableMemoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Direccion", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        spMemoria.setViewportView(tableMemoria);

        javax.swing.GroupLayout pMemoriaLayout = new javax.swing.GroupLayout(pMemoria);
        pMemoria.setLayout(pMemoriaLayout);
        pMemoriaLayout.setHorizontalGroup(
            pMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pMemoriaLayout.setVerticalGroup(
            pMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pPila.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pila"));

        spPila.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tablePila.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Direccion", "Valor"
            }
        ));
        spPila.setViewportView(tablePila);

        javax.swing.GroupLayout pPilaLayout = new javax.swing.GroupLayout(pPila);
        pPila.setLayout(pPilaLayout);
        pPilaLayout.setHorizontalGroup(
            pPilaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spPila, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pPilaLayout.setVerticalGroup(
            pPilaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spPila, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnTick.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTick.setText("Avanzar Tick");
        btnTick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTickActionPerformed(evt);
            }
        });

        btnDelProceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graph/del 16x.png"))); // NOI18N
        btnDelProceso.setText("Eliminar Proceso");

        btnAddProceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graph/add 16x.png"))); // NOI18N
        btnAddProceso.setText("Añadir proceso");
        btnAddProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProcesoActionPerformed(evt);
            }
        });

        pTraza.setBorder(javax.swing.BorderFactory.createTitledBorder("Traza"));

        spTraza.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        spTraza.setViewportView(listTraza);

        javax.swing.GroupLayout pTrazaLayout = new javax.swing.GroupLayout(pTraza);
        pTraza.setLayout(pTrazaLayout);
        pTrazaLayout.setHorizontalGroup(
            pTrazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTraza)
        );
        pTrazaLayout.setVerticalGroup(
            pTrazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTrazaLayout.createSequentialGroup()
                .addComponent(spTraza, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pPrincipalLayout = new javax.swing.GroupLayout(pPrincipal);
        pPrincipal.setLayout(pPrincipalLayout);
        pPrincipalLayout.setHorizontalGroup(
            pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrincipalLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pTraza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pPrincipalLayout.createSequentialGroup()
                        .addGroup(pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(pProcesos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAddProceso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDelProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnTick, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pPila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pPrincipalLayout.createSequentialGroup()
                                .addComponent(pRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pInstrucciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pPrincipalLayout.setVerticalGroup(
            pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pInstrucciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pPrincipalLayout.createSequentialGroup()
                        .addComponent(pProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddProceso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelProceso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(24, 24, 24)
                .addGroup(pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pMemoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pPrincipalLayout.createSequentialGroup()
                        .addComponent(pPila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pTraza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(342, 342, 342))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 633, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProcesoActionPerformed
        JFileChooser selector = new JFileChooser();
        selector.setCurrentDirectory(new File(System.getProperty("user.dir")));
        selector.setFileFilter(new FileNameExtensionFilter(null, "ins"));
        if(selector.showOpenDialog(MainWindow.this) == JFileChooser.APPROVE_OPTION){
            String ruta = selector.getSelectedFile().getPath();
            //se crea el fichero para cargar las instrucciones
            File archInstrucciones = new File(ruta);
            //obtenemos el nombre del fichero sin extension
            ruta = ruta.substring(0, ruta.length()-4);
            //agregamos la extension necesaria
            ruta = ruta.concat(".dat");
            //se crea el fichero de entorno para cargar los registros
            File archEntorno = new File(ruta);
            System.out.println(archEntorno.getAbsolutePath());
            try {
                cpu.nuevoProceso(archInstrucciones, archEntorno);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "No se encontro el archivo .dat");
            }
            //actualizamos las tablas
            actualizarProcesos();
            actualizarAmbiente();
        }
    }//GEN-LAST:event_btnAddProcesoActionPerformed

    private void btnTickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTickActionPerformed
        cpu.tick();
        actualizarAmbiente();
    }//GEN-LAST:event_btnTickActionPerformed

    private void listProcesosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listProcesosValueChanged
        
    }//GEN-LAST:event_listProcesosValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProceso;
    private javax.swing.JButton btnDelProceso;
    private javax.swing.JButton btnTick;
    private javax.swing.JList<String> listProcesos;
    private javax.swing.JList<String> listTraza;
    private javax.swing.JPanel pInstrucciones;
    private javax.swing.JPanel pMemoria;
    private javax.swing.JPanel pPila;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JPanel pProcesos;
    private javax.swing.JPanel pRegistros;
    private javax.swing.JPanel pTraza;
    private javax.swing.JScrollPane spInstrucciones;
    private javax.swing.JScrollPane spMemoria;
    private javax.swing.JScrollPane spPila;
    private javax.swing.JScrollPane spProcesos;
    private javax.swing.JScrollPane spRegistros;
    private javax.swing.JScrollPane spTraza;
    private javax.swing.JTable tableInstrucciones;
    private javax.swing.JTable tableMemoria;
    private javax.swing.JTable tablePila;
    private javax.swing.JTable tableRegistros;
    // End of variables declaration//GEN-END:variables

    private void actualizarProcesos() {
        DefaultListModel modelo = new DefaultListModel();
        for(String nombre: cpu.getNombresProcesos()){
            modelo.addElement(nombre);
        }
        listProcesos.setModel(modelo);
    }
    
    private void actualizarTrazas() {
        DefaultListModel modelo = new DefaultListModel();
        for(String traza: cpu.getTraza()){
            modelo.addElement(traza);
        }
        listTraza.setModel(modelo);
    }
    
    private void actualizarInstrucciones(){
        List<InstruccionData> insData = cpu.getInsData(cpu.getActivo());
        String[] columnas = {"Direccion","Comando", "ADR", "Descripcion"};
        Object[][] data = new Object[insData.size()][columnas.length];
        int i=0;
        for(InstruccionData ins: insData){
            data[i][0]=Util.toHexa((int)ins.getDireccion());
            data[i][1]=Util.toHexa((int)ins.getCodigo());
            data[i][2]=Util.toHexa((int)ins.getAdr());
            data[i][3]=ins.getDescripcion();
            i++;
        }
        tableInstrucciones.setModel(new DefaultTableModel(data, columnas));
    }
    
    private void actualizarMemoria(){
        List<MemoriaData> memData = cpu.getMemData(cpu.getActivo());
        String[] columnas = {"Direccion", "Valor"};
        Object[][] data = new Object[memData.size()][columnas.length];
        int i=0;
        for(MemoriaData mem: memData){
            data[i][0]=Util.toHexa((int)mem.getDireccion());
            data[i][1]=Util.toHexa((int)mem.getValor());
            i++;
        }
        tableMemoria.setModel(new DefaultTableModel(data, columnas));
    }
    
    private void actualizarRegistro(){
        Map<String, Long> registro;
        if(cpu.getActivo()!=null){
            registro = cpu.getActivo().getContexto();
        }else{
            registro = new Hashtable<>();
        }
        String[] columnas = {"ID", "Valor"};
        Object[][] data = new Object[registro.keySet().size()][columnas.length];
        int i=0;
        for(String key: registro.keySet()){
            data[i][0]=key;
            data[i][1]=Util.toHexa(registro.get(key).intValue());
            i++;
        }
        tableRegistros.setModel(new DefaultTableModel(data, columnas));
    }
    
    private void actualizarPila(){
        List<MemoriaData> memData = cpu.getPilData(cpu.getActivo());
        String[] columnas = {"Direccion", "Valor"};
        Object[][] data = new Object[memData.size()][columnas.length];
        int i=0;
        for(MemoriaData mem: memData){
            data[i][0]=Util.toHexa((int)mem.getDireccion());
            data[i][1]=Util.toHexa((int)mem.getValor());
            i++;
        }
        tablePila.setModel(new DefaultTableModel(data, columnas));
    }

    private void actualizarAmbiente() {
        actualizarInstrucciones();
        actualizarMemoria();
        actualizarRegistro();
        actualizarPila();
        actualizarTrazas();
    }
}
