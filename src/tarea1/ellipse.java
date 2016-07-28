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
public class ellipse extends Figura{
    private double ancho;
    private double altura;

    public ellipse(String nombre, double coordenada_x, double coordenada_y,double ancho, double altura, int id) {
        super(nombre, coordenada_x, coordenada_y, id);
        this.ancho = ancho;
        this.altura = altura;
        
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

       @Override
    public void Dibujar(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
      Ellipse2D.Double shape = new Ellipse2D.Double(getCoordenada_x(), getCoordenada_y(), ancho, altura);
        g2.draw(shape);
    
    
    
    }

  @Override
    public double calcularArea(){
    double area;
    area = Math.PI * altura * ancho;
    return area;
    }
    @Override
    public String toString() {
        return super.toString()+ " Ellipse con centro ("+ getCoordenada_x()+ "," + getCoordenada_y()+ ")"+ " Y  ("+ ancho + "," + altura + " )";
    }
    
           
    
}
