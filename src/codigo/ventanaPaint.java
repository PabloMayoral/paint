/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import codigo.formas.Circulo;
import codigo.formas.Cuadrado;

import codigo.formas.Estrella;
import codigo.formas.Formas;
import codigo.formas.Linea;
import codigo.formas.Pincel;
import codigo.formas.Recta;
import codigo.formas.Spray;
import codigo.formas.Trazo;
import codigo.formas.Triangulo;
import codigo.formas.pentagono;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

/**
 *
 * @author pmart
 */
public class ventanaPaint extends javax.swing.JFrame {

    BufferedImage buffer, buffer2 = null;

    Graphics2D bufferGraphics, bufferGraphics2, jpanelGraphics = null;

    Circulo miCirculo = null;

    Formas miForma = new Formas(-1, -1, 1, Color.WHITE, false);
 
    Pincel miPincel = null;
    Recta miRecta = null;
    Spray miSpray = null;

    /**
     * Creates new form ventanaPaint
     */
    public ventanaPaint() {
        initComponents();
        inicializaBuffers();
        jDialog1.setSize(640, 450);//dimensiones del dialog
        //guardar usando control+s
        saveAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
	jMenuItem1.setAction(saveAction);
        //cargar usando control+o
	loadAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
	jMenuItem2.setAction(loadAction);
        //intento para el control+z
        backAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
    }

    private void inicializaBuffers() {
//creo una imagen del mismo ancho y alto que el jpanel
        buffer = (BufferedImage) jPanel1.createImage(jPanel1.getWidth(), jPanel1.getHeight());
        buffer2 = (BufferedImage) jPanel1.createImage(jPanel1.getWidth(), jPanel1.getHeight());

        //cero una imagen modificable
        bufferGraphics = buffer.createGraphics();
        bufferGraphics2 = buffer2.createGraphics();

        //inicializo el buffer para que se pinte de blanco entero
        bufferGraphics.setColor(Color.white);
        bufferGraphics.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
        bufferGraphics2.setColor(Color.white);
        bufferGraphics2.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
        //enlazamos el jpanel1 con el jpanelgraphics
        jpanelGraphics = (Graphics2D) jPanel1.getGraphics();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // pinto el buffer sobre el jpanel
        jpanelGraphics.drawImage(buffer, 0, 0, null);
    }
//public void que usamos para guardar los dibus realizados
    private void guarda() {
        int seleccion = jFileChooser1.showSaveDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            //Botón de guardar presionado en cualquier JFileChooser
            File fichero = jFileChooser1.getSelectedFile();
            String nombre = fichero.getName();
            String extension = nombre.substring(nombre.lastIndexOf('.') + 1);
            if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("png")) {
                try {
                    ImageIO.write(buffer, extension, fichero);
                } catch (IOException e) {
                }
            }
        }
    }
//public void para poder cargar los dibus guardados anteriormente
    private void carga() {
        int seleccion = jFileChooser1.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = jFileChooser1.getSelectedFile();
            String nombre = fichero.getName();
            String extension = nombre.substring(nombre.lastIndexOf('.') + 1);
            BufferedImage imagen = null;
            if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("png")) {
                try {
                    imagen = ImageIO.read(fichero);
                    bufferGraphics.drawImage(imagen, 0, 0, null);
                    bufferGraphics2.drawImage(imagen, 0, 0, null);
                    repaint();
                } catch (IOException e) {
                }
            }
        }
    }
 
    Action saveAction = new AbstractAction("Save") {
        @Override
        public void actionPerformed(ActionEvent e) {
            guarda();
        }
    };

    Action loadAction = new AbstractAction("Load") {
        @Override
        public void actionPerformed(ActionEvent e) {
            carga();
        }
    };
     Action backAction = new AbstractAction("back") {
        @Override
        public void actionPerformed(ActionEvent e) {
         
        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jColorChooser1 = new javax.swing.JColorChooser();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jDialog2 = new javax.swing.JDialog();
        jFileChooser1 = new javax.swing.JFileChooser();
        jSlider1 = new javax.swing.JSlider();
        jPanel1 = new javax.swing.JPanel();
        colores1 = new codigo.colores();
        herramientas1 = new codigo.Herramientas();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("APLICAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFileChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
        );

        jButton1.setText("color mix");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("Guardar");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MousePressed(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Cargar");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem2MousePressed(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Deshacer");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(herramientas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(colores1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(herramientas1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(colores1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged

        bufferGraphics.drawImage(buffer2, 0, 0, null);
        switch (herramientas1.formaElegida) {
            //case 0 para el dibujo libre bien hecho
            case 0:
                miPincel.dibujate(bufferGraphics2, evt.getX(), evt.getY(), herramientas1.lineaGrosor);
                break;
             //case 1 para dibujar circulos
            case 1:
                miCirculo.dibujate(bufferGraphics, evt.getX());
                break;
           //case5 para dibujar el pentagono
            case 5:
                miForma.dibujate(bufferGraphics, evt.getX(), evt.getY());
                break;
                //case 256 para dibujar la estrella
            case 256:
                miForma.dibujate(bufferGraphics, evt.getX(), evt.getY());
                break;
                //case 4 para dibujar el cuadrado
            case 4:
                miForma.dibujate(bufferGraphics, evt.getX(), evt.getY());
                break;
                //case para el dibujo libre
            case 2:
                miForma.dibujate(bufferGraphics, evt.getX(), evt.getY());
                break;
                //case 3 para dibujar el triangulo
            case 3:
                miForma.dibujate(bufferGraphics, evt.getX(), evt.getY());
                break;
                //case 6 para dibujar lineas rectas
            case 6:
                miRecta.dibujate(bufferGraphics, evt.getX(), evt.getY(), herramientas1.lineaGrosor);
                break;
                //case 7 para dibujo libre
            case 7:
                miPincel.dibujate(bufferGraphics2, evt.getX(), evt.getY(), herramientas1.lineaGrosor);
                break;
                //case 8 para el spray
            case 8:
                miSpray = new Spray(evt.getX(), evt.getY(), colores1.colorSeleccionado);
                miSpray.dibujate(bufferGraphics2, evt.getX(), evt.getY(), herramientas1.lineaGrosor);
                break;
                
    }//GEN-LAST:event_jPanel1MouseDragged
        repaint(0, 0, 1, 1);
    }
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        switch (herramientas1.formaElegida) {
          //case para el dibujo libre y la goma
            case 0:

                if (herramientas1.goma) {
                    miPincel = new Pincel(evt.getX(), evt.getY(), colores1.colorSeleccionadoGoma);
                } else {
                    miPincel = new Pincel(evt.getX(), evt.getY(), colores1.colorSeleccionado);
                }

                miPincel.dibujate(bufferGraphics, evt.getX(), evt.getY(), herramientas1.lineaGrosor);
                break;
                //crea el circulo
            case 1:
                miCirculo = new Circulo(evt.getX(), evt.getY(), 1, colores1.colorSeleccionado, herramientas1.relleno);
                miCirculo.dibujate(bufferGraphics, evt.getX());
                break;
                //crea el pentagono
            case 5:
                miForma = new pentagono(evt.getX(), evt.getY(), 5, colores1.colorSeleccionado, herramientas1.relleno);
                miForma.dibujate(bufferGraphics, evt.getX(), evt.getY());
                break;
                //crea la estrella
            case 256:
                miForma = new Estrella(evt.getX(), evt.getY(), 256, colores1.colorSeleccionado, herramientas1.relleno);
                miForma.dibujate(bufferGraphics, evt.getX(), evt.getY());
                break;
                //crea el cuadrado
            case 4:
                miForma = new Cuadrado(evt.getX(), evt.getY(), colores1.colorSeleccionado, herramientas1.relleno);
                miForma.dibujate(bufferGraphics, evt.getX(), evt.getY());
                break;
                //crea la linea recta
            case 2:
                miForma = new Linea(evt.getX(), evt.getY(), colores1.colorSeleccionado, herramientas1.relleno);
                miForma.dibujate(bufferGraphics, evt.getX(), evt.getY());
                break;
                //crea el triangulo
            case 3:
                miForma = new Triangulo(evt.getX(), evt.getY(), 4, colores1.colorSeleccionado, herramientas1.relleno);
                miForma.dibujate(bufferGraphics, evt.getX(), evt.getY());
                break;
                //crea la linea recta
            case 6:
                miRecta = new Recta(evt.getX(), evt.getY(), colores1.colorSeleccionado);
                miRecta.dibujate(bufferGraphics, evt.getX(), evt.getY(), herramientas1.lineaGrosor);
                break;
                //lo mismo que en el case 0
            case 7:
                if (herramientas1.goma) {
                    miPincel = new Pincel(evt.getX(), evt.getY(), colores1.colorSeleccionadoGoma);
                } else {
                    miPincel = new Pincel(evt.getX(), evt.getY(), colores1.colorSeleccionado);
                }

                miPincel.dibujate(bufferGraphics, evt.getX(), evt.getY(), herramientas1.lineaGrosor);
                break;
                //crea el spray
            case 8:
                miSpray = new Spray(evt.getX(), evt.getY(), colores1.colorSeleccionado);
                miSpray.dibujate(bufferGraphics, evt.getX(), evt.getY(), herramientas1.lineaGrosor);
                break;
                //crea la pipeta
            case 9:
                 Color c = new Color(buffer2.getRGB(evt.getX(), evt.getY()), true);
                colores1.colorSeleccionado = c;
                        colores1.jLabel14.setBackground(colores1.colorSeleccionado);
                break;
        }
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        miForma.dibujate(bufferGraphics2, evt.getX(), evt.getY());

        //si se dibuja el circulo se dibuja en el buffergraphics2
        miForma.dibujate(bufferGraphics2, evt.getX(), evt.getY());
        //los if son para que se guarde el dibujo de las formas dibujadas del circulo y las lineas rectas
        if (herramientas1.formaElegida == 1) {
            miCirculo.dibujate(bufferGraphics2, evt.getX());

        } else if (herramientas1.formaElegida == 6) {
            miRecta.dibujate(bufferGraphics2, evt.getX(), evt.getY(), herramientas1.lineaGrosor);
        }
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       //el dialog se vuelve visible
        jDialog1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      //el dialog se oculta
        jDialog1.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //el dialog esta oculto y una vez se ha seleccionado el color deseado aparece el color en el jLabel
        jDialog1.setVisible(false);
        colores1.colorSeleccionado = jColorChooser1.getColor();
        colores1.jLabel14.setBackground(jColorChooser1.getColor());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MousePressed
        carga();
    }//GEN-LAST:event_jMenuItem2MousePressed

    private void jMenuItem1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MousePressed
        guarda();
    }//GEN-LAST:event_jMenuItem1MousePressed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(ventanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanaPaint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private codigo.colores colores1;
    private codigo.Herramientas herramientas1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
}
