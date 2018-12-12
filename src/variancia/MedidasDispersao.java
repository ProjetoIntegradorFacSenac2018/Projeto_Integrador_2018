/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variancia;

import Banco.DadosVendas;
import banco.MyPostgreSQL;
import Entidades.QtdDias;
import Entidades.QtdVendas;
import Entidades.Resultado;
import Entidades.VendasValor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class MedidasDispersao {

	private static Scanner leia = new Scanner(System.in);

	private static MyPostgreSQL myBD;

	// double[] numerosArray = {1, 46, 49, 51, 54, 54, 59, 59, 60, 60, 61, 61,
	// 65, 62, 66, 66,
	// 67, 67, 69, 70, 70, 71, 72, 74, 74, 76, 79, 80, 82, 87, 88};

	private static ArrayList<Double> numerosArray = new ArrayList<Double>();

	private static Resultado calcMedia;

//	 private static double[] numerosArray;

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		// seta valores do array
		myBD = new MyPostgreSQL();
		if (myBD.conecta() == false) {
			System.out
					.println("Não foi possivel fazer conecção com bando de dados!");
		} else {

			// inclusão de menu para opções diferêntes
			int opcao;
			do {
				opcao = menu();
				switch (opcao) {
				case 1:
					qantidadePorDia();
					break;
				case 2:
					valorVendas();
					break;
				// case 3: listarPaises(); break;
				// case 4: paisesVizinhos(); break;
				// case 5: encerraPrograma(); break;
				}
			} while (opcao < 5);
		}
		myBD.encerra();
	}

	private static int menu() {
		System.out.println();
		System.out.println("+========================================+");
		System.out.println("|              O P Ç Õ E S               |");
		System.out.println("+========================================+");
		System.out.println("| 1. Por quantidade de vendas por dia    |");
		System.out.println("| 2. Por valor de vendas por dia         |");
		System.out.println("| 3. Por tipo de pagamento               |");
		System.out.println("| 4. Totais de Clientes                  |");
		System.out.println("+----------------------------------------+");
		System.out.println("| 5. Encerra o Programa sem salvar dados |");
		System.out.println("+========================================+");

		int opcao;
		do {
			try {
				System.out.print("Digite a sua opção (1 a 5): ");
				opcao = leia.nextInt();
			} catch (Exception e) {
				leia.nextLine();
				opcao = 0;
			}
		} while (opcao < 1 || opcao > 5);

		return opcao;
	}

	private static boolean isValidDate(String input) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			format.parse(input);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	private static void qantidadePorDia() throws ParseException 
	{

		ArrayList<QtdDias> p;
//		ArrayList<QtdVendas> p1;
                ArrayList<QtdVendas> p1 = new ArrayList<QtdVendas>();
		QtdVendas q2;

		String dtInic;
		String dtFim;

		SimpleDateFormat dfm = new SimpleDateFormat("dd/MM/yyyy");

		do {
			System.out.println("+========================================+");
			System.out.println("| Informe data Inicial dd/MM/yyyy        |");
			System.out.println("+========================================+");
			dtInic = leia.nextLine();
		} while (isValidDate(dtInic) == false);

		do {
			System.out.println("+========================================+");
			System.out.println("| Informe data Final dd/MM/yyyy          |");
			System.out.println("+========================================+");
			dtFim = leia.nextLine();
		} while (isValidDate(dtFim) == false);

		Date dt_ini = dfm.parse(dtInic);
		Date dt_fim = dfm.parse(dtFim);
		int totReg = 0;
		int totVendas = 0;
		int mediana = 0;
		int media = 0;
		double totMediana = 0.0;
                
		p = DadosVendas.buscaDadosAgrup(myBD.getConnection(), dt_ini, dt_fim);
		QtdDias.setOrdemCrescente();
		Collections.sort(p);

		double[] numeros = new double[p.size()];
		
		
		// for (QtdDias q : p) {
		// numerosArray.add((double) q.getQtd());
		// qtd = qtd + q.getQtd();
		// }

		for (QtdDias q : p) {
            
			totReg += 1; // soma total de registro.
			totVendas += q.getQtd(); // soma total de qtd vendas.
//			numerosArray.add(q.getQtd());

			boolean achou = false; // controla se adiciona na lista de totais ou
									// se somente soma os valores
			// percorre a lista de totais para somar a quantidade do item
			for (QtdVendas q1 : p1) {
				// se a descrição for a mesma, então soma a quantidade
				if (q1.getXi() == (q.getQtd())) {
					q1.setNi(q1.getNi() + 1);
					achou = true;
					break; // interrompe o FOR para não continuar rodando sem
							// necessidade
				}
			}
			// se o item ainda não está na lista de totais, então adiciona um
			// novo
			if (!achou) {
				q2 = new QtdVendas(q.getQtd(), 1, 0.0, 0.0);
				p1.add(q2);
			}
		}

		media = totVendas / totReg;
                float  fi;
                int ni;
		for (QtdVendas q1 : p1) {
			q1.setXi_ni(q1.getXi() * q1.getNi());
			q1.setFi((q1.getNi() / totReg) * 100);
//                        fi = ((q1.getNi() / totReg) * 100);
//			totMediana += q1.getFi();
                        ni = q1.getNi();
                        fi = (float)(ni / totReg );
                        fi = fi * 100;
                          totMediana += fi;
			if (totMediana >= 51.00) {
				if (mediana == 0) {
					mediana = q1.getXi();
				}
			}
		}
                
		// calcular a variancia
		float somaNumeros = 0.0f;

//		for (int i = 0; i < p.size(); i++) {
//			somaNumeros += Math.pow(media - p.get(), 2);
//		}

		double resultado;
		// Amostragem
		resultado = somaNumeros / (p.size() - 1);

		// private ArrayList<Integer> moda1;
		// private double desvioPadrao;

		calcMedia.setTotReg(totReg);
		calcMedia.setTotVendas(totVendas);
		calcMedia.setMediana(mediana);
		calcMedia.setMedia(mediana);
		calcMedia.setVarianciaA(resultado);
		double desvioPadrao = Math.sqrt(resultado);
		calcMedia.setDesvioPadrao(desvioPadrao);

//		System.out.println("total de registro" + totReg);


//		mostrarCalculos(numerosArray);
	}

	private static void valorVendas() throws ParseException {
		ArrayList<VendasValor> p;
		ArrayList<VendasValor> p1;

		String dtInic;
		String dtFim;

		SimpleDateFormat dfm = new SimpleDateFormat("dd/MM/yyyy");

		do {
			System.out.println("+========================================+");
			System.out.println("| Informe data Inicial dd/MM/yyyy        |");
			System.out.println("+========================================+");
			dtInic = leia.nextLine();
		} while (isValidDate(dtInic) == false);

		do {
			System.out.println("+========================================+");
			System.out.println("| Informe data Final dd/MM/yyyy          |");
			System.out.println("+========================================+");
			dtFim = leia.nextLine();
		} while (isValidDate(dtFim) == false);

		Date dt_ini = dfm.parse(dtInic);
		Date dt_fim = dfm.parse(dtFim);
		int qtd = 0;
		double totClasse;

		p = DadosVendas.buscaDadosVendas(myBD.getConnection(), dt_ini, dt_fim);

		// VendasValor.setOrdemDecrescente();
		// Collections.sort(p);

		VendasValor q;

		q = p.get(0);

		double maior = q.getValor();
		double menor = q.getValor();

//		for (VendasValor q : p) {
//			if (q.getValor() > maior) {
//				maior = q.getValor();
//			}
//			if (q.getValor() < menor) {
//				menor = q.getValor();
//			}
//			numerosArray.add((double) q.getQtd());
//			qtd = qtd + q.getQtd();
//		}
//		System.out.println("total de registro" + qtd);
//		totClasse = Math.sqrt(qtd);
//		totClasse = Math.round(totClasse);
//		if (totClasse > 15) {
//			totClasse = 15;
//		}

		double[] exemplo = new double[numerosArray.size()];

		mostrarCalculos(numerosArray);

	}

	private static void mostrarCalculos(ArrayList<Double> numerosArray) {
		CalculosVarianciaDesvioPadrao vdpAmostagem = new CalculosVarianciaDesvioPadrao(
				numerosArray);
		vdpAmostagem.calcularMediana();
		vdpAmostagem.calcularModa();
		vdpAmostagem.calcularPorTotal();
		vdpAmostagem.calcularVariancia();
		vdpAmostagem.calcularPorAmostragem();
		vdpAmostagem.calcularVariancia();
		vdpAmostagem.calcularDesvioPadrao();
		vdpAmostagem.calcularCoeficienteVariacao();

	}
}
