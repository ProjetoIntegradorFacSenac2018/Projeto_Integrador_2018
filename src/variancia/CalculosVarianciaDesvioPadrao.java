/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variancia;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;

public class CalculosVarianciaDesvioPadrao {

    // Variancia + desvio padrão
    //
    // formula 1 - E(U = X)² / n
    // formula 2 - (E(X²) / N) - U²
    //
    // coeficiente de varição desvio padão / média ( * 100 para apresentar porcentagem
    // X => Números
    // U => Média
    // N => Quantidade de números
    private boolean amostragem;
    private double[] numeros;
    private ArrayList<Double> moda1;
    private float media;
    private double varianciaA;
    private double varianciaT;
    private double desvioPadrao;

//    public CalculosVarianciaDesvioPadrao(int[] numeros, boolean amostragem) {
    public CalculosVarianciaDesvioPadrao(double[] numeros) {
        this.numeros = numeros;
        moda1 = new ArrayList<>();
        
//        this.amostragem = amostragem;
        calcularMedia();
//        if (amostragem == true) {
//            // Amostragem
//            System.out.println("Amostragem:");
//        } else {
//            // total
//            System.out.println("Total:");
//        }
    }

    public CalculosVarianciaDesvioPadrao(ArrayList<Double> numeros) {
        moda1 = new ArrayList<>();
        moda1 = numeros;
        
//        this.amostragem = amostragem;
        calcularMedia();
//        if (amostragem == true) {
//            // Amostragem
//            System.out.println("Amostragem:");
//        } else {
//            // total
//            System.out.println("Total:");
//        }
    }

    private void calcularMedia() {
        // calcular a média
        float somaTotal = 0;
        for (int i = 0; i < numeros.length; i++) {
            somaTotal += numeros[i];
        }
        System.out.format("\n O valor da média é --------: %.0f ", (somaTotal / numeros.length));
//        System.out.println("media " + (somaTotal / numeros.length));
        this.media = somaTotal / numeros.length;
    }

    public float calcularMediana() {
        /* Mediana
        (quantidade  + 1 ) / 2.
        se a qtd do nr for impar, obtenho o nr 
        se for par, somo os dois nr e os divido por 2.
         */
        float resultado = 0.0f;
        int tipo = numeros.length % 2;
        if (tipo == 1) {
            resultado = (float) numeros[((numeros.length + 1) / 2) - 1];
//                return resultado;
        } else {
            int m = numeros.length / 2;
            resultado = (float) ((numeros[m - 1] + numeros[m]) / 2);
//                return resultado;
        }
        System.out.format("\n O valor da mediana é ------: %.0f ", resultado);
//        System.out.println("\n mediana " + resultado);
        return resultado;

    }

//    calcular moda
    public void calcularModa() {
        HashMap map = new HashMap();
        HashMap map1 = new HashMap();
        Integer i;
        Double moda = 0.0;
        Integer numAtual, numMaior = 0;

        for (int count = 0; count < numeros.length; count++) {
            i = (Integer) map.get(new Double(numeros[count]));
            if (i == null) {
                map.put(new Double(numeros[count]), new Integer(1));
            } else {
                map.put(new Double(numeros[count]), new Integer(i.intValue() + 1));
                numAtual = i.intValue() + 1;
                if (numAtual > numMaior) {
                    numMaior = numAtual;
                    moda = new Double(numeros[count]);
                }
            }
        }
        System.out.print("\n O valor da moda é ---------: ");
        
        for (int count = 0; count < numeros.length; count++) {
            i = (Integer) map1.get(new Double(numeros[count]));
            if (i == null) {
                map1.put(new Double(numeros[count]), new Integer(1));
            } else {
                map1.put(new Double(numeros[count]), new Integer(i.intValue() + 1));
                numAtual = i.intValue() + 1;
                if (numAtual == numMaior) {
                    moda = new Double(numeros[count]);
                    moda1.add(moda);
        System.out.format("%.2f ", moda);

                }
            }
        }
    }

    public double calcularVariancia() {
        // calcular a variancia
        float somaNumeros = 0.0f;
        for (int i = 0; i < numeros.length; i++) {
            somaNumeros += Math.pow(media - numeros[i], 2);
        }

        double resultado;
        if (amostragem == true) {
            // Amostragem
            resultado = somaNumeros / (numeros.length - 1);
            System.out.format("\n A variância de amostragem é: %.2f ", resultado);
//            System.out.println("A variância de amostragem é: " + resultado);
            this.varianciaA = resultado;
        } else {
            resultado = somaNumeros / (numeros.length);
            this.varianciaT = resultado;
            System.out.format("\n A variância de total é ----: %.2f ", resultado);
//            System.out.println("A variância de total é: " + resultado);
        }
//        System.out.println("A variância dos dados é: " + resultado);
        return resultado;
    }

    public double calcularDesvioPadrao() {
//        double variancia = this.calularVariancia();

        double desvioPadrao = Math.sqrt(this.varianciaT);

        System.out.format("\n O desvio padrão é ---------: %.2f ", desvioPadrao);
//        System.out.println("O desvio padrão e: " + desvioPadrao);
        this.desvioPadrao = desvioPadrao;
        return desvioPadrao;
    }

    public void calcularCoeficienteVariacao() {
        // coeficiente de varição desvio padão / média ( * 100 para apresentar porcentagem
//        double coeficienteVariacao = this.calcularDesvioPadrao() / this.media;
        double coeficienteVariacao = this.desvioPadrao / this.media;

        System.out.format("\n Coeficiênte de Variação é -: %.2f \n", coeficienteVariacao);
//        System.out.println("Coeficiente de Variação é :" + coeficienteVariacao);
    }

    public void calcularPorAmostragem() {
        // System.out.println("Agora calculando por Amostragem:");
        this.amostragem = true;
    }

    public void calcularPorTotal() {
        // System.out.println("Agora calculando por Amostragem:");
        this.amostragem = false;
    }
}
