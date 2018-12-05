package janelasfxml;

import com.sun.java.swing.plaf.windows.resources.windows;
import com.sun.javafx.scene.control.skin.Utils;
import static java.awt.SystemColor.window;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
//import pacotespi2018.contBut;

/**
 * FXML Controller class
 *
 * @author Rafael Carvalho e Lima
 */
public class FXMLjanelaPrincipalController implements Initializable {

//    contBut c;
//
//    public FXMLjanelaPrincipalController() {
//        this.c = new contBut();
//    }
    
    @FXML
    private AnchorPane rootPane, pnlCliente, pnlProduto, pnlRegVendas;

    @FXML
    private Pane pnlBut;

    @FXML
    private ScrollPane janela;

    @FXML
    private Button butCliente, butProduto, butPesquisar, butRegVenda, butBut, butSair, butSalvar;

    @FXML
    private Label label;

    /*
    @FXML
    private ListView<NomeDaListaNoPacote> ListaDaJanela;

    private List<NomeDaListaNoPacote> NomeDaListaPAcesso = new ArrayList<>();

    private ObservableList<NomeDaListaNoPacote> obsNomeDaListaNoPacote;

   
    
    public void carregarNomeDaListaPAcesso() {
        NomeDaListaNoPacote c1 = new NomeDaListaNoPacote(1, "Nome da categoria 1");
        NomeDaListaNoPacote c2 = new NomeDaListaNoPacote(2, "Nome da categoria 2");

        NomeDaListaPAcesso.add(c1);
        NomeDaListaPAcesso.add(c2);
        obsNomeDaListaNoPacote = FXCollections.observableArrayList(ListaDaJanela);
        ListaDaJanela.setItems(obsNomeDaListaNoPacote);
    }
    
    **/
    @FXML
    void ButaoSalvarCadCliente(ActionEvent event) {

    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @FXML
    private void encerraPrograma(ActionEvent event) {
        System.out.println("Encerrando o programa");
        System.exit(0);
    }

    @FXML
    private void limmpaTexto(ActionEvent event) {
        System.out.println("Limpando o Label.");
        label.setText("");
    }

    @FXML
    private void outroBotao(ActionEvent event) {
        System.out.println("Botao extra para não ficar sozinho.");
        label.setText("Botão Extra");
    }

    public AnchorPane fadeAnimated(String url) throws IOException {
        AnchorPane ap = (AnchorPane) FXMLLoader.load(getClass().getResource(url));
//        Efeito de transicao
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(ap);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(5);
        ft.setAutoReverse(false);
        ft.play();
        return ap;
    }

    @FXML
    public void handleClicks(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() == butSair) {
            System.exit(0);
        }

        if (actionEvent.getSource() == butCliente) {
            if (!rootPane.getChildren().isEmpty()) {
                rootPane.getChildren().remove(0);
            }
            AnchorPane proot = FXMLLoader.load(getClass().getResource("FXMLJanCadCliente.fxml"));
            FadeTransition ft = new FadeTransition(Duration.seconds(2));
            ft.setNode(proot);
            ft.setFromValue(0.1);
            ft.setToValue(1);
            ft.setCycleCount(1);
            ft.setAutoReverse(false);
            ft.play();
            rootPane.getChildren().setAll(proot);

        }

        if (actionEvent.getSource() == butProduto) {
            if (!rootPane.getChildren().isEmpty()) {
                rootPane.getChildren().remove(0);
            }
            AnchorPane proot = FXMLLoader.load(getClass().getResource("FXMLJanCadProduto.fxml"));
            FadeTransition ft = new FadeTransition(Duration.seconds(2));
            ft.setNode(proot);
            ft.setFromValue(0.1);
            ft.setToValue(1);
            ft.setCycleCount(1);
            ft.setAutoReverse(false);
            ft.play();
            rootPane.getChildren().setAll(proot);
        }

        if (actionEvent.getSource() == butRegVenda) {
            if (!rootPane.getChildren().isEmpty()) {
                rootPane.getChildren().remove(0);
            }
            AnchorPane proot = FXMLLoader.load(getClass().getResource("FXMLJanRegVenda.fxml"));
            FadeTransition ft = new FadeTransition(Duration.seconds(2));
            ft.setNode(proot);
            ft.setFromValue(0.1);
            ft.setToValue(1);
            ft.setCycleCount(1);
            ft.setAutoReverse(false);
            ft.play();
            rootPane.getChildren().setAll(proot);

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        carregarNomeDaListaPAcesso();
    }
}
