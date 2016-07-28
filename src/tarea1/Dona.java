/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

/**
 *
 * @author Isa
 */
public class Dona extends Figura {
    private double radio_menor;
    private double radio_mayor;

    public Dona( String nombre, double coordenada_x, double coordenada_y,double radio_menor, double radio_mayor,int id) {
        super(nombre, coordenada_x, coordenada_y,id);
        this.radio_menor = radio_menor;
        this.radio_mayor = radio_mayor;
    }

    public double getRadio_menor() {
        return radio_menor;
    }

    public void setRadio_menor(double radio_menor) {
        this.radio_menor = radio_menor;
    }

    public double getRadio_mayor() {
        return radio_mayor;
    }

    public void setRadio_mayor(double radio_mayor) {
        this.radio_mayor = radio_mayor;
    }

    @Override
    public String toString() {
      return super.toString()+ " Dona con centro ("+ getCoordenada_x()+ "," + getCoordenada_y()+ ")"+ " Y radio menor de "+ getRadio_menor()+ " radio mayor de "+ getRadio_mayor();
    }

   
}
