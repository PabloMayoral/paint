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

/**
 *
 * @author Pablo Martin
 */
public class Pincel extends Polygon{
    
    //Nos indican los puntos desde los que parten las líneas
    public int x, y;
    //Color del que se pintará la línea
    public Color color;

    public Pincel(int posX, int posY, Color _color ) {
        x = posX;
        y = posY;
        color = _color;
    }
    
    
    public void dibujate(Graphics2D g2, int posX, int posY ,int grosor) {
        g2.setColor(color);
        g2.setStroke(new BasicStroke(grosor));
        g2.drawLine(posX, posY, x, y);
        x = posX;
        y = posY;

    }
}
