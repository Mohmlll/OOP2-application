package practicumopdracht.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PhoneView extends View {


    private Parent root;

    private HBox comboBoxBox;
    private Label comboBoxLabel;
    private ComboBox comboBox;

    private HBox textFieldBox;
    private TextField textField;
    private Label textFieldLabel;

    private HBox textAreaBox;
    private Label textAreaLabel;
    private TextArea textArea;

    private HBox datePickerBox;
    private Label datePickerLabel;
    private DatePicker datePicker;

    private HBox checkBoxBox;
    private Label checkBoxLabel;
    private Label booleanLabel;
    private CheckBox checkBox;

    private HBox opslaanBox;
    private Button opslaan;

    private HBox listViewBox;
    private ListView listView;

    private HBox buttons;
    private Button nieuw;
    private Button verwijderen;
    private Button terugNaarOverzicht;

    public PhoneView() {
        initializeRoot();
    }

    private void initializeRoot() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10, 10, 10, 10));

        comboBoxBox = new HBox();
        comboBoxLabel = new Label("Combobox");
        comboBox = new ComboBox<>();
        comboBox.setMinSize(500, 16);
        comboBox.setPadding(new Insets(0, 0, 10, 0));
        comboBoxBox.getChildren().addAll(comboBoxLabel, comboBox);

        textFieldBox = new HBox();
        textFieldLabel = new Label("TextField: ");
        textFieldLabel.setMinSize(70, 16);
        textField = new TextField();
        textField.setMinSize(500, 16);
        textFieldBox.setPadding(new Insets(0, 0, 10, 0));
        textFieldBox.getChildren().addAll(textFieldLabel, textField);

        textAreaBox = new HBox();
        textAreaLabel = new Label("textArea: ");
        textAreaLabel.setMinSize(70, 16);
        textArea = new TextArea();
        textAreaBox.getChildren().addAll(textAreaLabel, textArea);
        textArea.setMinSize(500, 30);
        textAreaBox.setPadding(new Insets(0, 0, 10, 0));

        datePickerBox = new HBox();
        datePickerLabel = new Label("DatePicker: ");
        datePickerLabel.setMinSize(70, 16);

        datePicker = new DatePicker();
        datePickerBox.getChildren().addAll(datePickerLabel, datePicker);
        datePicker.setMinSize(80, 16);
        datePickerBox.setPadding(new Insets(0, 0, 10, 0));


        checkBoxBox = new HBox();
        checkBoxLabel = new Label("Checkbox:\t\t");
        checkBoxLabel.setMinSize(70, 16);
        booleanLabel = new Label("(boolean)");
        checkBox = new CheckBox();
        checkBox.setAlignment(Pos.CENTER_LEFT);
        checkBoxBox.getChildren().addAll(checkBoxLabel, checkBox, booleanLabel);
        checkBoxBox.setPadding(new Insets(0, 0, 10, 0));

        opslaanBox = new HBox();
        opslaan = new Button("Opslaan");
        opslaanBox.getChildren().addAll(opslaan);
        opslaan.setMinWidth(600);
        opslaanBox.setPadding(new Insets(0, 0, 10, 0));

        listViewBox = new HBox();
        listView = new ListView();
        listViewBox.getChildren().addAll(listView);
        listView.setMinSize(600, 100);
        listViewBox.setPadding(new Insets(0, 0, 10, 0));

        buttons = new HBox();
        buttons.setMinSize(600, 30);
        nieuw = new Button("Opslaan");
        nieuw.setAlignment(Pos.CENTER_LEFT);
        verwijderen = new Button("Verwijderen");
        verwijderen.setAlignment(Pos.CENTER);
        terugNaarOverzicht = new Button("Terug naar overzicht");
        terugNaarOverzicht.setAlignment(Pos.CENTER_RIGHT);
        buttons.getChildren().addAll(nieuw, verwijderen, terugNaarOverzicht);

        vbox.getChildren().addAll(comboBoxBox, textFieldBox, textAreaBox, datePickerBox, checkBoxBox, opslaanBox, listViewBox, buttons);
        root = vbox;
    }

    public Label getComboBoxLabel() {
        return comboBoxLabel;
    }

    public ComboBox getComboBox() {
        return comboBox;
    }

    @Override
    public Parent getRoot() {
        return root;
    }
}
