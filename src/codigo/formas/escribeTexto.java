/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo.formas;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

/**
 *
 * @author pmart
 */
public class escribeTexto {
    
    public int x, y;
    String texto;

    public escribeTexto (int posX, int posY, String _texto) {
        this.x = posX;
        this.y = posY;
        texto = _texto;
    }
    
    public void escribe(Graphics2D g2,int posX ,int posY,String texto,Color color,int tamañoLetra){
        Font font = new Font("Comic Sans MS", Font.PLAIN, tamañoLetra);
        FontRenderContext frc = new FontRenderContext(null, true, true);
        Rectangle2D bounds = font.getStringBounds(texto, frc);
        g2.setColor(color);
        g2.setFont(font);
        g2.drawString(texto, (float) posX, (float) posY);
    }
    
}