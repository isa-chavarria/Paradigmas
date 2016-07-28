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
public class Cuadrado extends Figura{
    private double longitud_del_lado;

    public Cuadrado( String nombre, double coordenada_x, double coordenada_y,double longitud_del_lado,int id) {
        super(nombre, coordenada_x, coordenada_y,id);
        this.longitud_del_lado = longitud_del_lado;
    }

    public double getLongitud_del_lado() {
        return longitud_del_lado;
    }

    public void setLongitud_del_lado(double longitud_del_lado) {
        this.longitud_del_lado = longitud_del_lado;
    }
      @Override
    public double calcularArea(){
    double area;
    area = longitud_del_lado * longitud_del_lado;
    return area;
    }
    @Override
    public void Dibujar(Graphics g){
      Graphics2D g2 = (Graphics2D) g;
      Rectangle2D.Double re= new Rectangle2D.Double(getCoordenada_x(),getCoordenada_y(),getLongitud_del_lado(),getLongitud_del_lado());
      g2.draw(re);
    
}
    @Override
    public String toString() {
        return super.toString()+ " Cuadrado"+ getCoordenada_x()+ "," + getCoordenada_y()+ "en la esquina superior Izquierda"+ " con una longitud de " + getLongitud_del_lado();
         
    }
    
}
