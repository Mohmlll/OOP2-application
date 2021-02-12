package practicumopdracht;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Mohammed Malloul
 */

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) {
        if (!Main.launchedFromMain) {
            System.err.println("Je moet deze applicatie opstarten vanuit de Main-class, niet de MainApplication-class!");
            System.exit(1337);

            return;
        }

        stage.setTitle(String.format("Practicumopdracht OOP2 - %s", Main.studentNaam));
        stage.setWidth(640);
        stage.setHeight(480);
        stage.show();

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));

//        String comboBoxS = "ComboBox: ";
//        String textFieldS = "TextField: ";
//        String textAreaS = "TextArea: ";
//        String datePickerS = "DatePicker: ";
//        String checkBoxS = "CheckBox: ";

        //combobox
        HBox comboBoxBox = new HBox();
        Label comboBoxLabel = new Label("Combobox");
        comboBoxLabel.setMinSize(100, 16);
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().add("Choice 1");
        comboBox.getItems().add("Choice 2");
        comboBox.getItems().add("Choice 3");
        comboBox.setMinSize(500, 16);
        comboBoxBox.getChildren().addAll(comboBoxLabel, comboBox);
        comboBoxBox.setPadding(new Insets(0, 0, 10, 0));

        //textfield
        HBox textFieldBox = new HBox();
        Label textFieldLabel = new Label("TextField: ");
        textFieldLabel.setMinSize(70, 16);
        TextField textField = new TextField();
        textFieldBox.getChildren().addAll(textFieldLabel, textField);
        textField.setMinSize(500, 16);
        textFieldBox.setPadding(new Insets(0, 0, 10, 0));

        //textarea
        HBox textAreaBox = new HBox();
        Label textAreaLabel = new Label("textArea: ");
        textAreaLabel.setMinSize(70, 16);
        TextArea textArea = new TextArea();
        textAreaBox.getChildren().addAll(textAreaLabel, textArea);
        textArea.setMinSize(500, 30);
        textAreaBox.setPadding(new Insets(0, 0, 10, 0));

        //datePicker
        HBox datePickerBox = new HBox();
        Label datePickerLabel = new Label("DatePicker: ");
        datePickerLabel.setMinSize(70, 16);

        DatePicker datePicker = new DatePicker();
        datePickerBox.getChildren().addAll(datePickerLabel, datePicker);
        datePicker.setMinSize(500, 16);
        datePickerBox.setPadding(new Insets(0, 0, 10, 0));


        //checkbox
        HBox checkBoxBox = new HBox();
        Label checkBoxLabel = new Label("Checkbox:\t\t");
        checkBoxLabel.setMinSize(70, 16);
        Label booleanLabel = new Label("(boolean)");
        CheckBox checkBox = new CheckBox();
        checkBox.setAlignment(Pos.CENTER_LEFT);
        checkBoxBox.getChildren().addAll(checkBoxLabel, checkBox, booleanLabel);
        checkBoxBox.setPadding(new Insets(0, 0, 10, 0));

        //opslaan button
        HBox opslaanBox = new HBox();
        Button opslaan = new Button("Opslaan");
        opslaanBox.getChildren().addAll(opslaan);
        opslaan.setMinWidth(600);
        opslaanBox.setPadding(new Insets(0, 0, 10, 0));

        //ListView
        HBox listViewBox = new HBox();
        ListView listView = new ListView();
        listViewBox.getChildren().addAll(listView);
        listView.setMinSize(600,100);
        listViewBox.setPadding(new Insets(0, 0, 10, 0));

        //Buttons
        HBox buttons = new HBox();
        buttons.setMinSize(600, 30);
        Button nieuw = new Button("Opslaan");
        nieuw.setAlignment(Pos.CENTER_LEFT);
        Button verwijderen = new Button("Verwijderen");
        verwijderen.setAlignment(Pos.CENTER);
        Button terug_naar_overzicht = new Button("Terug naar overzicht");
        terug_naar_overzicht.setAlignment(Pos.CENTER_RIGHT);
        buttons.getChildren().addAll(nieuw, verwijderen, terug_naar_overzicht);


        vbox.getChildren().addAll(comboBox, textFieldBox, textAreaBox, datePickerBox, checkBoxBox, opslaanBox, listViewBox, buttons);
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
    }
}
