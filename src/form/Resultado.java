/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.util.ArrayList;
import java.util.List;
import matematica.Restricao;

/**
 *
 * @author william
 */
public class Resultado {
    String msg;
    Restricao restricao = new Restricao();

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Restricao getRestricao() {
        return restricao;
    }

    public void setRestricao(Restricao restricao) {
        this.restricao = restricao;
    }
    

}
