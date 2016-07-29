/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Isa
 */
public class Triangulo extends Figura {

    private double x2;
    private double x3;
    private double y2;
    private double y3;

    public Triangulo(String nombre, double coordenada_x, double coordenada_y, double x2, double y2, double x3, double y3, int id) {
        super(nombre, coordenada_x, coordenada_y, id);
        this.x2 = x2;
        this.x3 = x3;
        this.y2 = y2;
        this.y3 = y3;

    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getY3() {
        return y3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    @Override
    public double calcularArea() {

        double lado1 = Math.sqrt(Math.pow((x2 - getCoordenada_x()), 2) + Math.pow((y2 - getCoordenada_y()), 2));
        double lado2 = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
        double lado3 = Math.sqrt(Math.pow((getCoordenada_x() - x3), 2) + Math.pow((getCoordenada_y() - y3), 2));
        double semip = (lado1 + lado2 + lado3) / 2;
        double area = Math.sqrt(semip * ((semip - lado1) * (semip - lado2) * (semip - lado3)));
        return area;
    }

    @Override
    public void Dibujar(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.PINK);
        g2.drawPolygon(new int[]{(int) getCoordenada_x(), (int) x2, (int) x3}, new int[]{(int) getCoordenada_y(), (int) y2, (int) y3}, 3);

    }

    @Override
    public String toString() {
        return super.toString() + "Triangulo con los puntos ( " + getCoordenada_x() + "," + getCoordenada_y() + ")" + "  ( " + x2 + ",  " + y2 + ")" + "(" + x3 + ", " + y3 + ")";
    }

}
