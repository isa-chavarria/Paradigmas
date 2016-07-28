/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Isa
 */
public class Rectangulo extends Figura {

    private double base;
    private double altura;

    public Rectangulo(String nombre, double coordenada_x, double coordenada_y, double base, double altura, int id) {
        super(nombre, coordenada_x, coordenada_y, id);
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getaltura() {
        return altura;
    }

    public void setaltura(double laltura) {
        this.altura = laltura;
    }
  @Override
    public double calcularArea(){
    double area;
    area = base * altura;
    return area;
    }
    @Override
    public void Dibujar(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D.Double re = new Rectangle2D.Double(getCoordenada_x(), getCoordenada_y(), getBase(), getaltura());
        g2.draw(re);
    }

    @Override
    public String toString() {
        return super.toString() + "Rectangulo con un x, y en la izquierda superior izquierda ( " + getCoordenada_x() + "," + getCoordenada_y() + ")" + "  con una base " + getBase() + ",  con una altura de " + getaltura();
    }

}
