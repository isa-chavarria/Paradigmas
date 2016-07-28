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
public class Figura {
    private String nombre;
    private double coordenada_x;
    private double  coordenada_y;
    private double area;
    private int id;

    public Figura(String nombre, double coordenada_x, double coordenada_y,  int id) {
        this.nombre = nombre;
        this.coordenada_x = coordenada_x;
        this.coordenada_y = coordenada_y;
      
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCoordenada_x() {
        return coordenada_x;
    }

    public void setCoordenada_x(double coordenada_x) {
        this.coordenada_x = coordenada_x;
    }

    public double getCoordenada_y() {
        return coordenada_y;
    }

    public void setCoordenada_y(double coordenada_y) {
        this.coordenada_y = coordenada_y;
    }

    public double calcularArea(){return 0;}

    public void Dibujar(Graphics g){  
        Graphics2D g2 = (Graphics2D) g;
    }

    @Override
    public String toString() {
        return "Figura " + id + ":";
    }
    

}
