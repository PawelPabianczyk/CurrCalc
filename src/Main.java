import connections.NBPConnection;
import controllers.ErrorController;
import controllers.HomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    private double exchangeRate = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {

        exchangeRate = new NBPConnection().getCurrentExchangeRate("gbp");

        FXMLLoader loader;
        Initializable controller;

        if(exchangeRate == -1){
            loader = new FXMLLoader(getClass().getResource("views/error.fxml"));
            controller = new ErrorController();
        }
        else{
            loader = new FXMLLoader(getClass().getResource("views/home.fxml"));
            controller = new HomeController(exchangeRate);
        }
        loader.setController(controller);
        Parent home = loader.load();
        Scene homeScene = new Scene(home);
        window = primaryStage;
        window.setTitle("Currency Calculator");
        window.setScene(homeScene);
        window.setMaxHeight(450);
        window.setMinHeight(450);
        window.setMaxWidth(600);
        window.setMinWidth(600);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
