/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import Entidades.QtdDias;
import Entidades.VendasValor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class DadosVendas {

	public static ArrayList<QtdDias> buscaDadosAgrup(Connection bdConnection,
			Date dtaIni, Date dtaFim) {
		if (bdConnection == null) {
			return null;
		}
		ArrayList<QtdDias> p = new ArrayList<>();

		try {

			String sql_str = "" + "SELECT data_nf, count(cod_cli) "
					+ "FROM db_header "
					+ "WHERE data_nf >= ? AND data_nf <= ? "
					+ "group by data_nf";
			PreparedStatement stmt = bdConnection.prepareStatement(sql_str);
			stmt.setDate(1, new java.sql.Date(dtaIni.getTime()));
			stmt.setDate(2, new java.sql.Date(dtaFim.getTime()));
			ResultSet rs = stmt.executeQuery();

			int qtdade;
			Date dt;
			QtdDias q;
			// percorre conjunto de registros retornados pelo banco de dados
			while (rs.next()) {
				// obtém dados do registro corrente
				dt = rs.getDate(1);
				qtdade = rs.getInt(2);
				q = new QtdDias(dt, qtdade);
				p.add(q);
			}
			stmt.close();
			rs.close();
			// retorna lista de pessoas
			return p;
		} catch (SQLException ex) {
			System.out.println("Erro na consulta SQL\n" + ex.getMessage());
			return null;
		}
	}

	public static ArrayList<VendasValor> buscaDadosVendas(
			Connection bdConnection, Date dtaIni, Date dtaFim) {
		if (bdConnection == null) {
			return null;
		}

		ArrayList<VendasValor> p = new ArrayList<>();
		ArrayList<VendasValor> p1 = new ArrayList<>();

		try {
//
//			String sql_str ="" + "SELECT db_header.nr_nf, db_header.serie_nf, db_header.cod_cli "
//                                        + " tb_item.cod_prod, "
//					+ " tb_item.qtd_item, tb_item.vlr_desc_item, tb_produto.preco_unit_prod"
//					+ "FROM db_header"
//					+ "INNER JOIN tb_item "
//					+ "on db_header.nr_nf = tb_item.nr_nf"
//					+ "INNER JOIN tb_produto"
//					+ "(on tb_item.cod_prod = tb_produto.cod_prod)"
//					+ "WHERE db_header.data_nf >= ? AND db_header.data_nf <= ?"
//					+ "order by nr_nf, serie_nf, cod_cli";

			String sql_str ="" + "SELECT nr_nf, serie_nf, cod_cli "
					+ "FROM db_header";
//					+ "WHERE data_nf >= ? AND data_nf <= ?"
//					+ "order by nr_nf, serie_nf, cod_cli";

                        PreparedStatement stmt = bdConnection.prepareStatement(sql_str);
//			stmt.setDate(1, new java.sql.Date(dtaIni.getTime()));
//			stmt.setDate(2, new java.sql.Date(dtaFim.getTime()));
			ResultSet rs = stmt.executeQuery();

			String nf;
			String serie;
			String cliente;
			String produto;
			double qtd;
			double valor;
			double desconto;
			VendasValor q;

			// percorre conjunto de registros retornados pelo banco de dados
			while (rs.next()) {
				// obtém dados do registro corrente

				nf = rs.getString(1);
				serie = rs.getString(2);
				cliente = rs.getString(3);
				produto = rs.getString(4);
				qtd = rs.getDouble(5);
				desconto = rs.getDouble(6);
				valor = rs.getDouble(7);

				valor = valor * desconto;
				q = new VendasValor(nf, serie, cliente, produto, qtd, valor);
				p.add(q);
			}

//			for (VendasValor q1 : p) {
//				   boolean achou = false; // variavel que controla se adiciona na lista de totais ou se somente soma os valores
//				   // percorre a lista de totais para somar a quantidade do item
//				   for (VendasValor q2 : p1) {
//				       // se a descrição for a mesma, então soma a quantidade
//				       if (p1.nf.equals(p.nf)) {
//                                           this.nf = nf;
//                                           this.serie = serie;
//                                           this.cliente = cliente;
//                                           
//                                           
//                                           
//                                           total.quantidadeTotal += item.quantidade;
//                                           achou = true;
//                                           break; // aqui interrompe o FOR para não continuar rodando sem necessidade
//                                       } else {
//                                       }
//				   }
//				   // se o item ainda não está na lista de totais, então adiciona um novo
//				   if (!achou) {
//				      totais.add(new TotalPedido(item.descricao, item.quantidade));
//				   }
//				}			
			
			
			
//			nf = " ";
//			serie = " ";
//			cliente = " ";
//			valor = 0.0;
//
//			for (VendasValor q1 : p) {
//				if (q1.getNf() != nf || q1.getSerie() != serie || q1.getCliente() != cliente) {
//					if (nf != " ") {
//						q1.setNf(nf);
//						q1.setSerie(serie);
//						q1.setCliente(cliente);
//						q1.setValor(valor);
//						p1.add(q1);
//						nf = q1.getNf();
//						serie = q1.getSerie();
//						cliente = q1.getCliente();
//						valor = 0.0;
//					}
//					valor = valor + q1.getValor();
//				}
//			}
//			if (nf != " ") {
//				q1.setNf(nf);
//				q1.setSerie(serie);
//				q1.setCliente(cliente);
//				q1.setValor(valor);
//				p1.add(q1);
//			}

			stmt.close();
			rs.close();
			// retorna lista de pessoas
			return p1;
		} catch (SQLException ex) {
			System.out.println("Erro na consulta SQL\n" + ex.getMessage());
			return null;
		}
	}
}
