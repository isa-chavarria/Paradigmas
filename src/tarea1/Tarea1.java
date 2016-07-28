/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Isa
 */
class Dibujito extends JPanel {

    ArrayList<Figura> figuritas_para_dibujar = new ArrayList<Figura>();

    Dibujito(ArrayList<Figura> figuritas) {
        figuritas_para_dibujar = figuritas;
    }

    public ArrayList<Figura> getFiguritas_para_dibujar() {
        return figuritas_para_dibujar;
    }

    public void setFiguritas_para_dibujar(ArrayList<Figura> figuritas_para_dibujar) {
        this.figuritas_para_dibujar = figuritas_para_dibujar;
    }

    @Override
    public void paint(Graphics g) {
        for (Figura fig : figuritas_para_dibujar) {
            fig.Dibujar(g);
        }
    }

}

public class Tarea1 {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Figura> figuras = new ArrayList<>();
    static Dibujito dib = new Dibujito(figuras);

    public static void List(ArrayList<Figura> figuritas) {
        double area =0.0;
        for (Figura figura : figuritas) {
            area = area + figura.calcularArea();
            System.out.println(figura.toString() + " El area de la figura " + figura.getArea());
            
            

        }
        System.out.println(" El area total de todas las figuras es:  "+ area);
    }

    public static void delete(ArrayList<Figura> figuritas, int figura) {
        for (Figura figu : figuritas) {
            if (figu.getId() == figura) {
                figuritas.remove(figu);
            }

        }

    }

    public static void ReadFromConsole() {

        String s = "";
        int identificador = 0;
        double x;
        double y;

        while (!s.equals("exit")) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            try {
                s = br.readLine();
                String vec[] = s.split(" ");
                vec[0] = vec[0].toUpperCase();

                switch (vec[0]) {
                    case "CIRCULO":
                        x = Double.parseDouble(vec[1]);
                        y = Double.parseDouble(vec[2]);
                        double radio = Double.parseDouble(vec[3]);
                        Figura circulito = new Circulo(vec[0], x, y, radio, identificador);
                        System.out.println(circulito.toString());

                        identificador++;
                        figuras.add(circulito);
                        dib.repaint();
                        System.out.println("El area del circulo es:  "+circulito.calcularArea());
                        

                        break;
                           case "ELLIPSE":
                        x = Double.parseDouble(vec[1]);
                        y = Double.parseDouble(vec[2]);
                        double ancho = Double.parseDouble(vec[3]);
                        double altura_ellipse = Double.parseDouble(vec[4]);
                        Figura ellipse = new ellipse(vec[0], x, y, ancho, altura_ellipse, identificador);
                        System.out.println(ellipse.toString());

                        identificador++;
                        figuras.add(ellipse);
                        dib.repaint();
                         System.out.println("El area del ellipse es:  "+ellipse.calcularArea());

                        break;
                    case "RECTANGULO":
                        x = Double.parseDouble(vec[1]);
                        y = Double.parseDouble(vec[2]);
                        double base = Double.parseDouble(vec[3]);
                        double altura = Double.parseDouble(vec[4]);
                        Figura rec = new Rectangulo(vec[0], x, y, base, altura, identificador);
                        System.out.println(rec.toString());
                        identificador++;
                        figuras.add(rec);
                        dib.repaint();
                         System.out.println("El area del rectangulo es:  "+ rec.calcularArea());
                        break;
                    case "CUADRADO":
                        x = Double.parseDouble(vec[1]);
                        y = Double.parseDouble(vec[2]);
                        double longitud = Double.parseDouble(vec[3]);
                        Figura cuadrado = new Cuadrado(vec[0], x, y, longitud, identificador);
                        System.out.println(cuadrado.toString());

                        identificador++;
                        figuras.add(cuadrado);
                        dib.repaint();
                         System.out.println("El area del cuadrado es:  "+cuadrado.calcularArea());
                        break;
                    case "TRIANGULO":

                        break;
                    case "DONA":
                        x = Double.parseDouble(vec[1]);
                        y = Double.parseDouble(vec[2]);
                        double radio_menor = Double.parseDouble(vec[3]);
                        double radio_mayor = Double.parseDouble(vec[4]);
                        Figura donita = new Dona(vec[0], x, y, radio_menor, radio_mayor, identificador);
                        System.out.println(donita.toString());
                        identificador++;
                        figuras.add(donita);
                        dib.repaint();
                        break;
                    case "LISTAR":
                        List(figuras);
                        break;
                    case "ELIMINAR":
                        int eliminar = Integer.parseInt(vec[1]);
                        delete(figuras, eliminar);
                        break;
                    case "HELP":
                        break;
                }

            } catch (IOException ex) {
                Logger.getLogger(Tarea1.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new Dibujar();
                frame.setSize(400,400);
                dib.setSize(400,400);
                frame.getContentPane().add(dib);
                frame.setVisible(true);
                
               
            }
        });
        ReadFromConsole();
    }

}
