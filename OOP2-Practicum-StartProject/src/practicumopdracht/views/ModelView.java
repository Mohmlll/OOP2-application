package practicumopdracht.views;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import practicumopdracht.models.Brand;
import practicumopdracht.models.Model;

public class ModelView extends View {

    private Parent root;

    private ComboBox comboBox;
    private TextField modelName;
    private TextField price;
    private DatePicker datePicker;
    private CheckBox checkBox;
    private Button save;
    private ListView<Model> modelListView;
    private Button delete;
    private Button brandButton;
    private MenuBar menuBar;

    public ModelView() {
        initializeRoot();
    }

    private void initializeRoot() {

        GridPane gridPaneModel = new GridPane();
        menuBar = new MenuBar();
        Menu menuLoad = new Menu("Load");
        Menu menuSave = new Menu("Save");
        menuBar.getMenus().addAll(menuLoad, menuSave);
        VBox vbox = new VBox(menuBar);

        HBox hBoxComboBox = new HBox();
        Label comboBoxLabel = new Label("Brand");
        comboBoxLabel.setMinSize(70, 20);
        comboBox = new ComboBox<Brand>();
        comboBox.setMinSize(500, 20);
        hBoxComboBox.getChildren().addAll(comboBoxLabel, comboBox);

        HBox hBoxModelName = new HBox();
        Label modelNameLabel = new Label("Model: ");
        modelNameLabel.setMinSize(70, 20);
        modelName = new TextField();
        modelName.setMinSize(500, 20);
        hBoxModelName.getChildren().addAll(modelNameLabel, modelName);

        HBox hBoxPrice = new HBox();
        Label priceLabel = new Label("Price: ");
        priceLabel.setMinSize(70, 20);
        price = new TextField();
        price.setMinSize(500, 20);
        hBoxPrice.getChildren().addAll(priceLabel, price);

        HBox hBoxDataPicker = new HBox();
        Label datePickerLabel = new Label("Release date: ");
        datePickerLabel.setMinSize(70, 20);
        datePickerLabel.setMinSize(70, 20);
        datePicker = new DatePicker();
        datePicker.setMinSize(70, 20);
        hBoxDataPicker.getChildren().addAll(datePickerLabel, datePicker);

        HBox hBoxCheckBox = new HBox();
        Label checkBoxLabel = new Label("On sale:\t\t");
        hBoxCheckBox.setMinSize(70, 20);
        Label booleanLabel = new Label("(boolean)");
        checkBox = new CheckBox();
        hBoxCheckBox.getChildren().addAll(checkBoxLabel, checkBox, booleanLabel);

        HBox hBoxSave = new HBox();
        save = new Button("Save");
        save.setMinWidth(600);
        hBoxSave.getChildren().addAll(save);

        modelListView = new ListView<Model> ();
        modelListView.setMinSize(600, 80);

        HBox hBoxButtons = new HBox();
        delete = new Button("Delete");
        delete.setMinWidth(200);
        brandButton = new Button("Brands");
        brandButton.setMinWidth(200);
        hBoxButtons.setSpacing(20);
        hBoxButtons.getChildren().addAll(delete, brandButton);

        gridPaneModel.add(hBoxComboBox, 0, 1);
        gridPaneModel.add(hBoxModelName, 0, 2);
        gridPaneModel.add(hBoxPrice, 0, 3);
        gridPaneModel.add(hBoxDataPicker, 0, 4);
        gridPaneModel.add(hBoxCheckBox, 0, 5);
        gridPaneModel.add(hBoxSave, 0, 6);
        gridPaneModel.add(modelListView, 0, 7);
        gridPaneModel.add(hBoxButtons, 0, 8);

        //horizontal gap in pixels
        gridPaneModel.setHgap(10);
        //vertical gap in pixels
        gridPaneModel.setVgap(10);
        // a 10 pixel margin around the whole grid
        gridPaneModel.setPadding(new Insets(10, 10, 10, 10));

        vbox.getChildren().addAll(gridPaneModel);

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

    public Button getDelete() {
        return delete;
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
