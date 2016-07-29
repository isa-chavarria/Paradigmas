/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.ScrollPane;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
    static Dibujito dib;
    static int identificador = 0;

    static public void verificar(String[] vec) {

        double x;
        double y;

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
                System.out.println("El area del circulo es:  " + circulito.calcularArea());

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
                System.out.println("El area del ellipse es:  " + ellipse.calcularArea());

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
                System.out.println("El area del rectangulo es:  " + rec.calcularArea());
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
                System.out.println("El area del cuadrado es:  " + cuadrado.calcularArea());
                break;
            case "TRIANGULO":
                x = Double.parseDouble(vec[1]);
                y = Double.parseDouble(vec[2]);
                double x2 = Double.parseDouble(vec[3]);
                double y2 = Double.parseDouble(vec[4]);
                double x3 = Double.parseDouble(vec[5]);
                double y3 = Double.parseDouble(vec[6]);

                Figura tri = new Triangulo(vec[0], x, y, x2, y2, x3, y3, identificador);
                System.out.println(tri.toString());

                identificador++;
                figuras.add(tri);
                dib.repaint();
                System.out.println("El area del triangulo es:  " + tri.calcularArea());

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
                System.out.println(ayuda());
                break;
        }
    }

    public static String ayuda() {

        String a;
        a = "Los siguientes son algunos comandos de ayuda \n"
                + "Para dibujar las distintas figuras es necesario escribir la figura y sus parametros.\n"
                + "\n"
                + "Cuadrado 5 5 10 (x, y ,longitud del lado).\n"
                + "Triangulo 6 1 9 3 15 4 (x1,y1,x2,y2,x3,y3 los ejes)\n"
                + "Ellipse 10 10 5 15 (x, y , radio altura, Ancho)\n"
                + "circulo 10 10 10 (x, y , radio)\n"
                + "Rectangulo 10 10 3 5 (x, y , base, altura)\n"
                + "Dona 10 10 5 8  ( x, y , radio mayor , radio menor)\n"
                + "Tambien contamos con otros comandos como lo son:\n"
                + "Listar -> devolvera todas las figuras que esten creadas.Y el area total de las figuras existentes.\n"
                + "Eliminar 2 -> El # que se agrega corresponde al identificador de cada figura , con este es que se \n"
                + "podra eliminar la figura.\n"
                + "\n"
                + "Help -> Desplega una lista de comandos que seran utiles a la hora de usar la aplicacion.";
        return a;
    }

    static void readFile() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                String vec[] = line.split(" ");
                vec[0] = vec[0].toUpperCase();

                verificar(vec);
            }
        } finally {
            br.close();
        }
    }

    public static void List(ArrayList<Figura> figuritas) {
        double area = 0.0;
        for (Figura figura : figuritas) {
            area = area + figura.calcularArea();
            System.out.println(figura.toString() + " El area de la figura " + figura.getArea());

        }
        System.out.println(" El area total de todas las figuras es:  " + area);
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

        while (!s.equals("exit")) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            try {
                s = br.readLine();
                String vec[] = s.split(" ");
                vec[0] = vec[0].toUpperCase();

                verificar(vec);
            } catch (IOException ex) {
                Logger.getLogger(Tarea1.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public static void main(String[] args) {
        try {
            // TODO code application logic here
            readFile();
        } catch (IOException ex) {
            Logger.getLogger(Tarea1.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new Dibujar();
                dib = new Dibujito(figuras);
                frame.setSize(400, 400);
                dib.setSize(new Dimension(4000, 4000));
                dib.setPreferredSize(new Dimension(4000, 4000));

                frame.add(dib);
                frame.setVisible(true);

            }
        });
        ReadFromConsole();
    }

}
