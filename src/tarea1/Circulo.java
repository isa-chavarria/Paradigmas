/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Isa
 */
public class Circulo extends Figura{
    private double radio;

    public Circulo( String nombre, double coordenada_x, double coordenada_y,double radio,int id) {
        super(nombre, coordenada_x, coordenada_y,id);
        this.radio = radio;
        
        
    }



    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    @Override
    public double calcularArea(){
    double area;
    area = Math.PI * (Math.pow(radio, 2.0));
    return area;
    }
    

    @Override
    public void Dibujar(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
      Ellipse2D.Double shape = new Ellipse2D.Double(getCoordenada_x(), getCoordenada_y(), radio, radio);
        g2.draw(shape);
    
    
    
    }
    @Override
    public String toString() {
        return super.toString()+ " Circulo con centro ("+ getCoordenada_x()+ "," + getCoordenada_y()+ ")"+ " Y radio "+ radio;
    }
    
}
