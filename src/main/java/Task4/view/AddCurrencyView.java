package Task4.view;

import Task4.application.CurrencyApp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddCurrencyView extends Application {
    CurrencyApp ca = new CurrencyApp();
    @Override
    public void start(Stage stage) {
        stage.setTitle("Add Currency");

        VBox vBox = new VBox();
        vBox.setSpacing(10);

        HBox hBox1 = new HBox();
        hBox1.setSpacing(10);

        Label label1 = new Label("Abbreviation: ");
        TextField textField1 = new TextField();
        hBox1.getChildren().addAll(label1, textField1);

        HBox hBox2 = new HBox();
        hBox2.setSpacing(10);

        Label label2 = new Label("Name: ");
        TextField textField2 = new TextField();
        hBox2.getChildren().addAll(label2, textField2);

        HBox hBox3 = new HBox();
        hBox3.setSpacing(10);

        Label label3 = new Label("Rate To Euro: ");
        TextField textField3 = new TextField();
        hBox3.getChildren().addAll(label3, textField3);

        HBox hBox4 = new HBox();
        hBox4.setSpacing(10);

        Label label4 = new Label("Rate from Euro: ");
        TextField textField4 = new TextField();
        hBox4.getChildren().addAll(label4, textField4);

        Button addButton = new Button("Add Currency");
        addButton.setOnAction(e -> {
            String abbreviation = textField1.getText();
            String name = textField2.getText();
            double rateToEuro = Double.parseDouble(textField3.getText());
            double rateFromEuro = Double.parseDouble(textField4.getText());
            ca.addCurrency(abbreviation, name, rateToEuro, rateFromEuro);
            stage.close();
        });

        vBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4, addButton);

        Scene scene = new Scene(vBox, 300, 300);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
