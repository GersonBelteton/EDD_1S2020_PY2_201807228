/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Bean.Categoria;
import Estructuras.NodoLibro;
import java.io.FileWriter;
import java.io.IOException;
import Controladores.*;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gerso
 */
public class Reportes extends javax.swing.JFrame {

    ContCategoria cg = new ContCategoria();
    ContUsuario cu = new ContUsuario();
    static int contador = 0;
    String imagen = "";
    DefaultListModel modeloLista;

    /**
     * Creates new form Reportes
     */
    public Reportes() {
        initComponents();
        lista.setVisible(false);
        btnReporte.setVisible(false);
        modeloLista = new DefaultListModel();
        lista.setModel(modeloLista);
        actualizarLista();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        btnVerImagen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblFoto = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        btnReporte = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnRegresar = new javax.swing.JMenu();
        btnReportes = new javax.swing.JMenu();
        btnUsuarios = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        btnCategorias = new javax.swing.JMenuItem();
        btnPreOrden = new javax.swing.JMenuItem();
        btnPosOrden = new javax.swing.JMenuItem();
        btnInOrden = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnVerImagen.setText("Ver Imagen");
        btnVerImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerImagenActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lblFoto);

        lista.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lista);

        btnReporte.setText("Generar reporte ");

        btnRegresar.setText("Regresar");
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnRegresar);

        btnReportes.setText("Reportes");
        btnReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportesMouseClicked(evt);
            }
        });
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        btnUsuarios.setText("Usuarios");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        btnReportes.add(btnUsuarios);

        jMenuItem2.setText("Libros");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        btnReportes.add(jMenuItem2);

        btnCategorias.setText("Categorias");
        btnCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCategoriasMouseClicked(evt);
            }
        });
        btnCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriasActionPerformed(evt);
            }
        });
        btnReportes.add(btnCategorias);

        btnPreOrden.setText("Preorden");
        btnPreOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreOrdenActionPerformed(evt);
            }
        });
        btnReportes.add(btnPreOrden);

        btnPosOrden.setText("Posorden");
        btnPosOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPosOrdenActionPerformed(evt);
            }
        });
        btnReportes.add(btnPosOrden);

        btnInOrden.setText("Inorden");
        btnInOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInOrdenActionPerformed(evt);
            }
        });
        btnReportes.add(btnInOrden);

        jMenuBar1.add(btnReportes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVerImagen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReporte)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVerImagen))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        // TODO add your handling code here:
        Principal p = new Principal();
        this.setVisible(false);
        p.setVisible(true);
        p.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void btnCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCategoriasMouseClicked


    }//GEN-LAST:event_btnCategoriasMouseClicked


    private void btnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriasActionPerformed
        // TODO add your handling code here:

        System.out.println("mouse clicked");
        try {
            // TODO add your handling code here:
            String codigo = "digraph G {\n ";
            Categoria aux = cg.getCategorias().getRaiz();
            codigo = cg.getCategorias().codigoGraficaAVL(aux, codigo);
            codigo += "}";
            generarGrafica("ArbolAVL.txt", "ArbolAVL.jpg", codigo);
        } catch (IOException ex) {
            System.out.println("error");
        }
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void btnVerImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerImagenActionPerformed
        // TODO add your handling code here
        
       
        ImageIcon imagen;
        imagen = new ImageIcon(getClass().getResource(this.imagen));
        ImageIcon icono = new ImageIcon(imagen.getImage());
        lblFoto.setIcon(icono);

    }//GEN-LAST:event_btnVerImagenActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        // TODO add your handling code here:
        String codigo = cu.getUsuarios().codigoGraficaTH();
        try {
            generarGrafica("TablaHash.txt", "TablaHash.jpg", codigo);
        } catch (IOException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnPreOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreOrdenActionPerformed
        try {
            // TODO add your handling code here:

            generarGrafica("PreOrden.txt", "PreOrden.jpg", cg.getCategorias().reporteInPrePos("Pre"));
        } catch (IOException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnPreOrdenActionPerformed

    private void btnInOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInOrdenActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:

            generarGrafica("InOrden.txt", "InOrden.jpg", cg.getCategorias().reporteInPrePos("In"));
        } catch (IOException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInOrdenActionPerformed

    private void btnPosOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPosOrdenActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:

            generarGrafica("PosOrden.txt", "PosOrden.jpg", cg.getCategorias().reporteInPrePos("Pos"));
        } catch (IOException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPosOrdenActionPerformed

    private void btnReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_btnReportesMouseClicked

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnReportesActionPerformed

    private void listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMouseClicked
        // TODO add your handling code here:
        String texto = "digraph G {\n node [shape=box];\n";
        if (lista.getSelectedValue() != null) {
            Categoria c = cg.getCategorias().buscar(lista.getSelectedValue());
            texto = c.getLibros().codigoGraficaB(c.getLibros().getRaiz(), texto);
            System.out.println(texto);
        }
        
        texto += "}";
        try {
            // TODO add your handling code here:
          
            generarGrafica("ArbolB.txt", "ArbolB.jpg", texto);
        } catch (IOException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_listaMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        lista.setVisible(true);
        btnReporte.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public void actualizarLista() {
        modeloLista.clear();
        llenarLista(cg.getCategorias().getRaiz());
    }

    public void llenarLista(Categoria aux) {
        if (aux != null) {
            modeloLista.addElement(aux.getNombre());
            llenarLista(aux.getIzquierda());
            llenarLista(aux.getDerecha());

        }
    }

    public void generarGrafica(String pathTxt, String pathJpg, String codigo) throws IOException {

        System.out.println(codigo);
        try {
            try ( //C:\Program Files (x86)\release\bin
                    FileWriter fichero = new FileWriter( pathTxt)) {
                fichero.write(codigo);
            }
            String dotPath = "c:\\Program Files (x86)\\release\\bin\\dot.exe";

            String fileInputPath = pathTxt;
            String fileOutputPath =  contador + pathJpg;

            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();
          
            rt.exec(cmd);
//C:\Users\gerso\Documents\NetBeansProjects\EDDProyecto2

            //lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("c:\\Users\\gerso\\Documents\\NetBeansProject\\EDDProyecto2\\ArbolAVL.jpg")));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }

        this.imagen =  contador + pathJpg;
        contador++;
    }

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
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnCategorias;
    private javax.swing.JMenuItem btnInOrden;
    private javax.swing.JMenuItem btnPosOrden;
    private javax.swing.JMenuItem btnPreOrden;
    private javax.swing.JMenu btnRegresar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JMenu btnReportes;
    private javax.swing.JMenuItem btnUsuarios;
    private javax.swing.JButton btnVerImagen;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JList<String> lista;
    // End of variables declaration//GEN-END:variables
}