/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo.formas;

import java.awt.Color;

/**
 *
 * @author pmart
 */
public class Linea extends Formas{
    public Linea(int _posX, int _posY, Color _color, boolean _relleno) {
	//Inicializa el constructo de la linea correctamente
	super(_posX, _posY, 2, _color, _relleno);
    }
}
