package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.net.*;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private TextField tfGBP;

    @FXML
    private TextField tfPLN;

    @FXML
    private Label lPLN;

    private double exchangeRate;

    public HomeController(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lPLN.setText(String.format("%.2f", exchangeRate) + " PLN");
    }

    public void goToLinkedIn(MouseEvent mouseEvent) {
        openBrowser("https://www.linkedin.com/in/pawel-pabianczyk/");
    }

    public void goToGithub(MouseEvent mouseEvent) {
        openBrowser("https://github.com/PawelPabianczyk");
    }

    private void openBrowser(String url) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(URI.create(url));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void getGBPValue(KeyEvent keyEvent) {
        String sGbp = tfGBP.getText();
        if (isInputValueValid(sGbp)){
            double gbp = Double.parseDouble("0"+sGbp);
            double pln = gbp * exchangeRate;
            tfPLN.setText(String.format("%.2f", pln));
        }
        else
            clean(null);
    }

    public void clean(MouseEvent mouseEvent) {
        tfPLN.clear();
        tfGBP.clear();
    }

    public void getPLNValue(KeyEvent keyEvent) {
        String sPln = tfPLN.getText();
        if (isInputValueValid(sPln)){
            double pln = Double.parseDouble("0"+sPln);
            double gbp = pln / exchangeRate;
            tfGBP.setText(String.format("%.2f", gbp));
        }
        else
            clean(null);
    }

    public Boolean isInputValueValid(String input){
        int commaNumber = 0;

        if (input == null || input.length()==0)
            return false;

        for (Character c:
                input.toCharArray()) {
            if(c == 46 && commaNumber == 0){
                commaNumber++;
            }
            else if(c<48 || c>57){
                return false;
            }
        }
        return true;
    }
}
