/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo.formas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Random;

/**
 *
 * @author pmart
 */
public class Spray extends Polygon {

    //Nos indican los puntos desde los que parten las líneas
    public int x, y;
    //Color del que se pintará la línea
    public Color color;

    //Sorteamos que píxeles se rellenan y cuales no
    Random random = new Random();
    int valorRandom; //Guardaremos el valor random

    public Spray(int posX, int posY, Color _color) {
        x = posX;
        y = posY;
        color = _color;
    }

    public void dibujate(Graphics2D g2, int posX, int posY, int grosor) {
        g2.setColor(color);
        g2.setStroke(new BasicStroke(1));
        //Para que se aprecie
        grosor += 7;
        for (int i = 0; i < grosor; i++) {
            for (int j = 0; j < grosor; j++) {
                valorRandom = random.nextInt(5);//Uno de cada 5
                if (valorRandom == 3) {
                    g2.drawLine(x + i, y + j, x + i, y + j);
                }
            }

        }
        
        

    }
}
