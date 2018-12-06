/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matematica;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author william
 */
public class MetodoPL {
    
    FuncaoObjetivo fo = new FuncaoObjetivo();
    List<Restricao> listaRestricoes = new ArrayList<>();
    RegiaoValida regVal = new RegiaoValida();
 
    double x_Otimo;
    double y_Otimo;
    double valor_Otimo;
    Restricao restr1 = new Restricao();
    Restricao restr2 = new Restricao();
    RetasInterseccao ptosIntersec;
    List<Double> pontosXY;
    List<List<Double>> listaPontosXY = new ArrayList<>();

    //metodo para equaçao de Função Objetivo
    public double eqFO(FuncaoObjetivo fo,List<Double> ponto){
        return fo.getA()*ponto.get(0)+fo.getB()*ponto.get(1);
    }

    //método para achar solução ótima, localizando ponto ótimo de maximização ou minimização
    public void localizarOtimo(FuncaoObjetivo fo,List<List<Double>> listaPontosXY){
        setValor_Otimo(eqFO(fo,listaPontosXY.get(0)));
        setX_Otimo(listaPontosXY.get(0).get(0));
        setY_Otimo(listaPontosXY.get(0).get(1));
        for (int i = 1; i < listaPontosXY.size(); i++)
        {
            double valor = eqFO(fo,listaPontosXY.get(i));
            if(fo.getTipo().equals("Maximização")&&valor>=getValor_Otimo())
            {
                setValor_Otimo(valor);
                setX_Otimo(listaPontosXY.get(i).get(0));
                setY_Otimo(listaPontosXY.get(i).get(1));
            }
            else if(fo.getTipo().equals("Minimização")&&valor<=getValor_Otimo()){
                setValor_Otimo(valor);
                setX_Otimo(listaPontosXY.get(i).get(0));
                setY_Otimo(listaPontosXY.get(i).get(1));
            }
        }
    }   
    
    //método principal que determina pontos da região valida e chama metodo para encontrar solução ótima
    public void calcular() {
        List<List<Double>> listaPontosXY;
        regVal.acharPontosRegiao(listaRestricoes);
        listaPontosXY= regVal.getListaPontoXY();
        localizarOtimo(fo, listaPontosXY);
    }

    public double getX_Otimo() {
        return x_Otimo;
    }

    public void setX_Otimo(double x_Otimo) {
        this.x_Otimo = x_Otimo;
    }

    public double getY_Otimo() {
        return y_Otimo;
    }

    public void setY_Otimo(double y_Otimo) {
        this.y_Otimo = y_Otimo;
    }

    public double getValor_Otimo() {
        return valor_Otimo;
    }

    public void setValor_Otimo(double valor_Otimo) {
        this.valor_Otimo = valor_Otimo;
    }
    
    public FuncaoObjetivo getFo() {
        return fo;
    }

    public void setFo(FuncaoObjetivo fo) {
        this.fo = fo;
    }

    public List<Restricao> getListaRestricoes() {
        return listaRestricoes;
    }

    public void setListaRestricoes(List<Restricao> listaRestricoes) {
        this.listaRestricoes = listaRestricoes;
    }

}
