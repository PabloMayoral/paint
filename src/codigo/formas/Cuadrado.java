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
public class Cuadrado extends Formas {
    public Cuadrado (int _posX, int _posY, Color _color, boolean _relleno) {
	//Inicializa el constructo del cuadrado correctamente con 3 lados
	super(_posX, _posY, 4, _color, _relleno);
    }
}
