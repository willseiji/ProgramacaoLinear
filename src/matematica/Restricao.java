/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matematica;

import java.util.List;

/**
 *
 * @author william
 */
public class Restricao {
    double a;
    double b;
    double c;
    String simboloIneq;
    List<Double> pontoA;
    List<Double> pontoB;

    public char tipoReta(){
	if (a * b < 0)
            return 'c';
        else if (a * b > 0)
            return 'd';
        else if (a == 0)
            return 'h';
        else if (b == 0)
            return 'v';
        else 
            return 'n';
    }

    public double coefAngular(){
        if(tipoReta() =='v' )
            return 1000000;
        else
            return -1*a/b;
    }
    
    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
    
    public String getSimboloIneq() {
        return simboloIneq;
    }

    public void setSimboloIneq(String simboloIneq) {
        this.simboloIneq = simboloIneq;
    }
        
    public List<Double> getPontoA() {
        return pontoA;
    }

    public void setPontoA(List<Double> pontoA) {
        this.pontoA = pontoA;
    }

    public List<Double> getPontoB() {
        return pontoB;
    }

    public void setPontoB(List<Double> pontoB) {
        this.pontoB = pontoB;
    }
    
    
}
