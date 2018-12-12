package Entidades;

import java.util.ArrayList;
import java.util.Date;

public class QtdDias implements Comparable <QtdDias> {
    public static boolean ordemCrescente = true;
    private Date data;
    private int qtd;
    
    public QtdDias(Date data, int qtd) {
        this.data = data;
        this.qtd = qtd;
    }

    public Date getData() {
            return data;
    }

    public void setData(Date data) {
            this.data = data;
    }

    public int getQtd() {
            return qtd;
    }

    public void setQtd(int qtd) {
            this.qtd = qtd;
    }

    public static void setOrdemCrescente()
    {
        ordemCrescente = true;
    }
    
    public static void setOrdemDecrescente()
    {
        ordemCrescente = false;
    }
    
    @Override
    public int compareTo(QtdDias o) {
        if(ordemCrescente)
            return this.qtd - o.qtd;
        else
            return o.qtd - this.qtd;
    }
}
