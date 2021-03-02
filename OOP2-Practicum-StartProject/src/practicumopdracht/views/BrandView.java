package practicumopdracht.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import practicumopdracht.models.Brand;

/**
 * @author Mohammed Malloul
 */

public class BrandView extends View {


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

    private HBox saveBox;
    private Button save;

    private HBox listViewBox;
    private ListView<Brand> listView;

    private HBox buttons;
    private Button brand;
    private Button Delete;
    private Button models;

    public BrandView() {
        initializeRoot();
    }

    private void initializeRoot() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10, 10, 10, 10));

        comboBoxBox = new HBox();
        comboBoxLabel = new Label("Combobox");
        comboBox = new ComboBox<>();
        comboBox.setMinSize(500, 20);
        comboBoxBox.setPadding(new Insets(0, 0, 10, 0));
        comboBoxBox.getChildren().addAll(comboBoxLabel, comboBox);

        textFieldBox = new HBox();
        textFieldLabel = new Label("TextField: ");
        textFieldLabel.setMinSize(70, 20);
        textField = new TextField();
        textField.setMinSize(500, 16);
        textFieldBox.setPadding(new Insets(0, 0, 10, 0));
        textFieldBox.getChildren().addAll(textFieldLabel, textField);

        textAreaBox = new HBox();
        textAreaLabel = new Label("textArea: ");
        textAreaLabel.setMinSize(70, 16);
        textArea = new TextArea();
        textArea.setMinSize(500, 50);
        textAreaBox.setPadding(new Insets(0, 0, 10, 0));
        textAreaBox.getChildren().addAll(textAreaLabel, textArea);

        datePickerBox = new HBox();
        datePickerLabel = new Label("DatePicker: ");
        datePickerLabel.setMinSize(70, 16);
        datePicker = new DatePicker();
        datePicker.setMinSize(70, 20);
        datePickerBox.setPadding(new Insets(0, 0, 10, 0));
        datePickerBox.getChildren().addAll(datePickerLabel, datePicker);


        checkBoxBox = new HBox();
        checkBoxLabel = new Label("Checkbox:\t\t");
        checkBoxLabel.setMinSize(70, 16);
        booleanLabel = new Label("(boolean)");
        checkBox = new CheckBox();
        checkBoxBox.setPadding(new Insets(0, 0, 10, 0));
        checkBoxBox.getChildren().addAll(checkBoxLabel, checkBox, booleanLabel);

        saveBox = new HBox();
        save = new Button("Save");
        save.setMinWidth(600);
        saveBox.setPadding(new Insets(0, 0, 10, 0));
        saveBox.getChildren().addAll(save);

        listViewBox = new HBox();
        listView = new ListView();
        listView.setMinSize(600, 80);
        listViewBox.setPadding(new Insets(0, 0, 10, 0));
        listViewBox.getChildren().addAll(listView);

        buttons = new HBox();
        buttons.setMinSize(600, 30);
        brand = new Button("Brands");
        brand.setAlignment(Pos.CENTER_LEFT);
        Delete = new Button("Delete");
        Delete.setAlignment(Pos.CENTER);
        models = new Button("Models");
        models.setAlignment(Pos.CENTER_RIGHT);
        buttons.getChildren().addAll(brand, Delete, models);

        vbox.getChildren().addAll(comboBoxBox, textFieldBox, textAreaBox, datePickerBox, checkBoxBox, saveBox, listViewBox, buttons);
        root = vbox;
    }

    public ListView<Brand> getListView() {
        return listView;
    }

    public TextField getTextField() {
        return textField;
    }


    public Button getSave() {
        return save;
    }

    public Button getBrand() {
        return brand;
    }

    public Button getDelete() {
        return Delete;
    }

    public Button getModels() {
        return models;
    }

    @Override
    public Parent getRoot() {
        return root;
    }
}
