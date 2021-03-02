package practicumopdracht.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import practicumopdracht.controller.BrandController;
import practicumopdracht.models.Brand;

public class ModelView extends View {

    private Parent root;

    private ComboBox comboBox;
    private TextField modelName;
    private TextField price;
    private DatePicker datePicker;
    private CheckBox checkBox;
    private Button save;
    private ListView modelListView;
    private Button brandButton;

    public ModelView() {
        initializeRoot();
    }

    private void initializeRoot() {
        BrandController brandController = new BrandController();
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10, 10, 10, 10));

        HBox comboBoxBox = new HBox();
        Label comboBoxLabel = new Label("Brand");
        comboBox = new ComboBox<Brand>();
        for (int i = 0; i < brandController.getBrandObservableList().size(); i++) {
            comboBox.getItems().add(brandController.getBrandObservableList().get(i));
        }
        comboBox.setMinSize(500, 20);
        comboBoxBox.setPadding(new Insets(0, 0, 10, 0));
        comboBoxBox.getChildren().addAll(comboBoxLabel, comboBox);

        HBox modelNameBox = new HBox();
        Label modelNameLabel = new Label("Model: ");
        modelName = new TextField();
        modelName.setMinSize(500, 16);
        modelNameBox.getChildren().addAll(modelNameLabel, modelName);
        modelNameBox.setPadding(new Insets(0, 0, 10, 0));

        HBox priceBox = new HBox();
        Label priceLabel = new Label("Price: ");
        price = new TextField();
        price.setMinSize(500, 16);
        priceBox.getChildren().addAll(priceLabel, price);
        priceBox.setPadding(new Insets(0, 0, 10, 0));

        HBox datePickerBox = new HBox();
        Label datePickerLabel = new Label("Release date: ");
        datePickerLabel.setMinSize(70, 16);
        datePicker = new DatePicker();
        datePicker.setMinSize(70, 20);
        datePickerBox.setPadding(new Insets(0, 0, 10, 0));
        datePickerBox.getChildren().addAll(datePickerLabel, datePicker);

        HBox checkBoxBox = new HBox();
        Label checkBoxLabel = new Label("On sale:\t\t");
        checkBoxLabel.setMinSize(70, 16);
        Label booleanLabel = new Label("(boolean)");
        checkBox = new CheckBox();
        checkBoxBox.setPadding(new Insets(0, 0, 10, 0));
        checkBoxBox.getChildren().addAll(checkBoxLabel, checkBox, booleanLabel);

        HBox saveBox = new HBox();
        save = new Button("Save");
        save.setMinWidth(600);
        saveBox.setPadding(new Insets(0, 0, 10, 0));
        saveBox.getChildren().addAll(save);

        modelListView = new ListView();
        modelListView.setMinSize(600, 80);
        modelListView.setPadding(new Insets(0, 0, 10, 0));
        brandButton = new Button("Brands");
        brandButton.setAlignment(Pos.CENTER_LEFT);

        vbox.getChildren().addAll(comboBoxBox, modelNameBox, priceBox, datePickerBox, checkBoxBox, saveBox, modelListView, brandButton);
        root = vbox;
    }

    public TextField getModelName() {
        return modelName;
    }

    public ListView getModelListView() {
        return modelListView;
    }

    public TextField getPrice() {
        return price;
    }

    public Button getSave() {
        return save;
    }

    public ComboBox getComboBox() {
        return comboBox;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public Button getBrandButton() {
        return brandButton;
    }

    @Override
    public Parent getRoot() {
        return root;
    }
}
