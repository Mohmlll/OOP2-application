package practicumopdracht.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ModelView extends View {

    private HBox comboBoxBox;
    private Label comboBoxLabel;
    private ComboBox comboBox;

    private HBox datePickerBox;
    private Label datePickerLabel;
    private DatePicker datePicker;

    private HBox checkBoxBox;
    private Label checkBoxLabel;
    private Label booleanLabel;
    private CheckBox checkBox;

    private Button brandButton;

    public ModelView() {
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

        brandButton = new Button("Brands");
        brandButton.setAlignment(Pos.CENTER_LEFT);

        vbox.getChildren().addAll(comboBox, datePicker, checkBox);
    }

    @Override
    public Parent getRoot() {
        return null;
    }
}
