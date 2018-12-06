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
public class RegiaoValida {

    List<List<Double>> listaPontoXY = new ArrayList<>();
    
    //método para achar pontos da Região válida do sistema de restrições
    public void acharPontosRegiao(List<Restricao> listaRestricoes) {
        Restricao restr1;
        Restricao restr2;
        RetasInterseccao intersec;
        double x, y;

        List<Double> pontoXY;
        List<List<Double>> listaPontosXY = new ArrayList<>();
        List<List<Double>> listaPontosValidos;
        
        //inicia pontos extremos da reta da equação de cada restrição
        for (int i = 0; i < listaRestricoes.size(); i++) {
            restr1 = listaRestricoes.get(i);
            pontoXY = new ArrayList<>();
            pontoXY.add(iniciarPontoA(restr1).get(0));
            pontoXY.add(iniciarPontoA(restr1).get(1));
            listaPontosXY.add(pontoXY);
            pontoXY = new ArrayList<>();
            pontoXY.add(iniciarPontoB(restr1).get(0));
            pontoXY.add(iniciarPontoB(restr1).get(1));
            listaPontosXY.add(pontoXY);
            
            //lista pontos de todas as intersecções de cada reta das restrições
            for (int j = 0; j < listaRestricoes.size(); j++) {
                restr2 = listaRestricoes.get(j);
                if (restr1.coefAngular() != restr2.coefAngular()) {
                    intersec = new RetasInterseccao(restr1, restr2);
                    x = intersec.pontoIntersec().get(0);
                    y = intersec.pontoIntersec().get(1);
                    pontoXY = new ArrayList<>();
                    pontoXY.add(x);
                    pontoXY.add(y);
                    listaPontosXY.add(pontoXY);
                }
            }
        }
        listaPontosValidos = validarPontos(listaPontosXY,listaRestricoes);
        setListaPontoXY(removerPontosRepetidos(listaPontosValidos));
    }

    //método para remover pontos repetidos da lista de pontos
    public List<List<Double>> removerPontosRepetidos(List<List<Double>> listaPontosXY) {
        for (int i = 0; i < listaPontosXY.size(); i++) {
            for (int j = i + 1; j < listaPontosXY.size(); j++) {
                if (Math.abs(listaPontosXY.get(i).get(0) - listaPontosXY.get(j).get(0)) == 0
                        && Math.abs(listaPontosXY.get(i).get(1) - listaPontosXY.get(j).get(1)) == 0) {
                    listaPontosXY.remove(j);
                }
            }
        }
        return listaPontosXY;
    }

    //método para validar os pontos que estão dentro da região válida
    public List<List<Double>> validarPontos(List<List<Double>> listaPontosXY, List<Restricao> listaRestricoes) {
        double esquerdo, direito;
        String simboloIneq;
        List<List<Double>> listaPontosValidos = new ArrayList<>();
        boolean ptoValido;
        for (int i = 0; i < listaPontosXY.size(); i++) {
            ptoValido=false;
            for (int j = 0; j < listaRestricoes.size(); j++) {
                esquerdo = listaRestricoes.get(j).getA()*listaPontosXY.get(i).get(0)+listaRestricoes.get(j).getB()*listaPontosXY.get(i).get(1);
                direito = listaRestricoes.get(j).getC();
                simboloIneq=listaRestricoes.get(j).getSimboloIneq();
                if ((simboloIneq.equals("≤")&&esquerdo<=direito)||(simboloIneq.equals("≥")&&esquerdo>=direito)) {
                    ptoValido=true;
                }else{
                    ptoValido=false;
                    break;
                }
            }
            if(ptoValido)
                listaPontosValidos.add(listaPontosXY.get(i));
        }
        return listaPontosValidos;
    }

    public List<Double> iniciarPontoA(Restricao restr) {
        List<Double> pontoA = new ArrayList<>();
        double x, y;
        if (restr.tipoReta() == 'c') {
            x = -2e12;
            y = (restr.getC()-restr.getA()*x)/restr.getB();
            //y = -2e12;
        } else if (restr.tipoReta() == 'd') {
            x = 2e12;
            y = (restr.getC()-restr.getA()*x)/restr.getB();
            //y = -2e12;
        } else if (restr.tipoReta() == 'h') {
            x = -2e12;
            y = restr.getC();
        } else {//(restr.tipoReta()=='v')
            x = restr.getC();
            y = -2e12;
        }
        pontoA.add(x);
        pontoA.add(y);
        return pontoA;
    }

    public List<Double> iniciarPontoB(Restricao restr) {
        List<Double> pontoB = new ArrayList<>();
        double x, y;
        if (restr.tipoReta() == 'c') {
            x = 2e12;
            y = 2e12;
        } else if (restr.tipoReta() == 'd') {
            x = -2e12;
            y = 2e12;
        } else if (restr.tipoReta() == 'h') {
            x = 2e12;
            y = restr.getC();
        } else {//(restr.tipoReta()=='v')
            x = restr.getC();
            y = 2e12;
        }
        pontoB.add(x);
        pontoB.add(y);
        return pontoB;
    }
    
    public List<List<Double>> getListaPontoXY() {
        return listaPontoXY;
    }

    public void setListaPontoXY(List<List<Double>> listaPontoXY) {
        this.listaPontoXY = listaPontoXY;
    }

}
