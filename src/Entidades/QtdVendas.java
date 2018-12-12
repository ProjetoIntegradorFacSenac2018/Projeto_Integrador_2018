/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

public class QtdVendas {
   private int xi;
    private int ni;
    private double xi_ni;
    private double fi;
    
    public QtdVendas(int xi, int ni, double xi_ni, double fi) {
        this.xi = xi;
        this.ni = ni;
        this.xi_ni = xi_ni;
        this.fi = fi;
    }

    public int getXi() {
        return xi;
    }

    public void setXi(int xi) {
        this.xi = xi;
    }

    public int getNi() {
        return ni;
    }

    public void setNi(int ni) {
        this.ni = ni;
    }

    public double getXi_ni() {
        return xi_ni;
    }

    public void setXi_ni(double xi_ni) {
        this.xi_ni = xi_ni;
    }

    public double getFi() {
        return fi;
    }

    public void setFi(double fi) {
        this.fi = fi;
    }
}
