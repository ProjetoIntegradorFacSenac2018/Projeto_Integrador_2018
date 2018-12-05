package pacotespi2018;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Rafael Carvalho e Lima
 */

public class contBut {
//    FIXME
    private static class encherLista {
//  Apagar isto depois de implemetar a classe
    }

    Scanner scan = new Scanner(System.in);
    private static ArrayList<ListaAqui> listaAqui = new ArrayList<>();
//    private static ArrayList<encherLista> encherLista()= newList<>();

    String nomeAqui = scan.nextLine();
    String dadosAqui = scan.nextLine();
    
    
//    TODO
    private static encherLista colocar(String dadosAqui) {
//        Colocar dados p montar a lista
        return null;
    }

//    FIXME
    private static ListaAqui buscaLista(String nomeAqui) {
/*
        TODO
        Criar parametro p procurar diferentes metódos.
*/
        if (listaAqui.isEmpty()) {
            return null;
        }
        for (ListaAqui la : listaAqui) {
            if (la.getNome().equalsIgnoreCase(nomeAqui)) {
                return la;
            }
        }
        return null;
    }

    public void encerraPrograma() {
        System.out.println("Bye, bye!");
        System.exit(0);
    }
    
    

//  TODO
    private static void dadosTextField() {
        /*  
        * Implementar algo aqui p carregar na janela.
        * Notar diferenca entre listar de um ArrayList e direto do BD.
        * Contruir opcoes p abstrair de BD e apenas algo p apresentar na Lista.
        *?????????
         */
    }

//    private static void salvarDados("TEXTFIELD"){
////        implementar método em que adiciona tnato no array qto no BD
//    listaAqui.add("TEXTFIELD");
//    }
//   TODO
    private static void arquivoImportar() {
//        Como fazer  isto !
    }
//   TODO
    private static void arquivoExportar() {
//        Como fazer  isto !  
//  Continentes tem uma boa forma de gravarDados, olhar lá
    }
    
    
}
