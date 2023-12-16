package Task4.view;

import Task4.application.CurrencyApp;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.List;

public class CurrencyView extends Application {
    CurrencyApp ca = new CurrencyApp();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Converter");
        Label label = new Label("Currency Converter");
        label.setFont(javafx.scene.text.Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20));
        List<String> currencyNames = ca.getNames();

        ComboBox<String> comboBox1 = new ComboBox<>();
        comboBox1.getItems().addAll(currencyNames);
        comboBox1.setPromptText("FROM");

        ComboBox<String> comboBox2 = new ComboBox<>();
        comboBox2.getItems().addAll(currencyNames);
        comboBox2.setPromptText("TO");

        TextField textField1 = new TextField();
        textField1.setPromptText("Enter Amount");
        TextField textField2 = new TextField();
        textField2.setDisable(true);

        Button button = new Button("Convert");
        button.setOnAction(e -> {
            int from = comboBox1.getSelectionModel().getSelectedIndex() + 1;
            int to = comboBox2.getSelectionModel().getSelectedIndex() + 1;
            double amount = Double.parseDouble(textField1.getText());
            textField2.setText(String.valueOf(ca.convert(amount, from, to)));
        });

        Button addCurrencyButton = new Button("Add Currency");
        addCurrencyButton.setOnAction(e -> {
            AddCurrencyView addCurrencyView = new AddCurrencyView();
            addCurrencyView.start(new Stage());

            List<String> updatedCurrencyNames = ca.getNames();
            comboBox1.getItems().setAll(updatedCurrencyNames);
            comboBox2.getItems().setAll(updatedCurrencyNames);
        });

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.getChildren().addAll(comboBox1, textField1, comboBox2, textField2);

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.alignmentProperty().setValue(Pos.CENTER);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.getChildren().addAll(label, hBox, button, addCurrencyButton);

        Scene scene = new Scene(vBox, 500, 200);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
