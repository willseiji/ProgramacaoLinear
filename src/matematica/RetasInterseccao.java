/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matematica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author william
 */
public class RetasInterseccao {
    private Restricao restr1 = new Restricao();
    private Restricao restr2 = new Restricao();
    private List<Double> pontoXY = new ArrayList<>();
    
    public RetasInterseccao(Restricao restr1, Restricao restr2){
        this.restr1=restr1;
        this.restr2=restr2;
    }

    //método para calcular os pontos X e Y usando sistemas de equações
    public List<Double> pontoIntersec(){        
        double detA = determinante(restr1.getA(),restr1.getB(),restr2.getA(),restr2.getB());
        double detX = determinante(restr1.getC(),restr1.getB(),restr2.getC(),restr2.getB());
	double detY = determinante(restr1.getA(),restr1.getC(),restr2.getA(),restr2.getC());
        pontoXY.add(detX/detA);
        pontoXY.add(detY/detA);
        return pontoXY;
    }
    
    public double determinante(double a11, double a12, double a21, double a22)
    {
	double det = a11*a22-a12*a21;
	return det;
    }

    
    public void setPontoXY(List<Double> pontoXY) {
        this.pontoXY = pontoXY;
    }
    
    public List<Double> getPontoXY() {
        return pontoXY;
    }

    

}
