package practicumopdracht.views;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import practicumopdracht.models.Brand;

import java.util.List;

/**
 * @author Mohammed Malloul
 */

public class BrandView extends View {

    private Parent root;

    private TextField brandName;
    private TextField nameCeo;
    private TextField networth;
    private TextArea textArea;
    private Button save;
    private ListView<Brand> listView;
    private Button delete;
    private Button details;
    private Button newBrand;
    private Alert alertDelete;
    private Alert alertSave;
    private Alert alertDeleteList;

    private ListView<Brand> brands = new ListView<>();

    public BrandView() {
        initializeRoot();
    }

    private void initializeRoot() {

        GridPane gridPane = new GridPane();


        VBox vbox = new VBox();

        //brand name textfield for brand
        HBox hBoxName = new HBox();
        Label brandNameLabel = new Label("brand name: ");
        brandNameLabel.setMinSize(70, 20);
        brandName = new TextField();
        brandName.setMinSize(500, 16);
        hBoxName.getChildren().addAll(brandNameLabel, brandName);

        //name of ceo textfield for brand
        HBox hBoxCeo = new HBox();
        Label nameCeoLabel = new Label("name CEO: ");
        nameCeoLabel.setMinSize(70, 20);
        nameCeo = new TextField();
        nameCeo.setMinSize(500, 16);
        hBoxCeo.getChildren().addAll(nameCeoLabel, nameCeo);

        //networth textfield for brand
        HBox hBoxNetworth = new HBox();
        Label networthLabel = new Label("networth: ");
        networthLabel.setMinSize(70, 20);
        networth = new TextField();
        networth.setMinSize(500, 16);
        hBoxNetworth.getChildren().addAll(networthLabel, networth);

        //description textarea for brand
        HBox hBoxTextArea = new HBox();
        Label textAreaLabel = new Label("Description: ");
        textAreaLabel.setMinSize(70, 16);
        textArea = new TextArea();
        textArea.setMinSize(500, 50);
        hBoxTextArea.getChildren().addAll(textAreaLabel, textArea);

        //save brand button
        save = new Button("Save");
        save.setMinWidth(600);

        //list of brands
        listView = new ListView<>();
        listView.setMinSize(600, 80);

        //delete and details button
        HBox hBoxButtons = new HBox();
        delete = new Button("Delete");
        delete.setMinWidth(150);
        details = new Button("Details");
        details.setDisable(true);
        details.setMinWidth(150);
        newBrand = new Button("New");
        newBrand.setMinWidth(150);
        hBoxButtons.setSpacing(20);
        hBoxButtons.getChildren().addAll(newBrand, delete, details);

        //delete item alert
        alertDelete = new Alert(Alert.AlertType.CONFIRMATION);
        alertDelete.setTitle("Alert");
        alertDelete.setContentText("Are you sure you want to delete this Brand?");

        //alert for wrong input
        alertSave = new Alert(Alert.AlertType.WARNING);
        alertSave.setTitle("Save");

        //no selected item to delete
        alertDeleteList = new Alert(Alert.AlertType.WARNING);
        alertDeleteList.setTitle("Delete");


        gridPane.add(hBoxName, 0, 1);
        gridPane.add(hBoxCeo, 0, 2);
        gridPane.add(hBoxNetworth, 0, 3);
        gridPane.add(hBoxTextArea, 0, 4);
        gridPane.add(save, 0, 5);
        gridPane.add(listView, 0, 6);
        gridPane.add(hBoxButtons, 0, 7);

        //horizontal gap in pixels
        gridPane.setHgap(10);
        //vertical gap in pixels
        gridPane.setVgap(10);
        // a 10 pixel margin around the whole grid
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        vbox.getChildren().addAll(gridPane);

        root = vbox;
    }

//    If brand is null then the details button will be disabled
//    if brand is not null the the details button will not be disabled
//    and the fields will be filled in with data from the brand
    public void setBrand(Brand brand) {
        if (brand == null) {
            this.details.setDisable(true);
        } else {
            this.details.setDisable(false);
            this.brandName.setText(String.valueOf(brand.getBrandName()));
            this.nameCeo.setText(String.valueOf(brand.getCeo()));
            this.networth.setText(String.valueOf(brand.getNetWorth()));
            this.textArea.setText(String.valueOf(brand.getDescription()));
        }
    }

    public void setBrands(List<Brand> brands) {

      this.setBrand(null);
      this.brands.getItems().clear();
      this.brands.getItems().addAll(brands);

    }

    //method to get a selected brand
    public Brand getSelectedBrand() {
        return this.listView.getSelectionModel().getSelectedItem();
    }

    public ListView<Brand> getListView() {
        return listView;
    }

    public TextField getBrandName() {
        return brandName;
    }

    public Alert getAlertDelete() {
        return alertDelete;
    }

    public TextField getNameCeo() {
        return nameCeo;
    }

    public TextField getNetworth() {
        return networth;
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public Button getSave() {
        return save;
    }

    public Alert getAlertSave() {
        return alertSave;
    }

    public Alert getAlertDeleteList() {
        return alertDeleteList;
    }

    public Button getDelete() {
        return delete;
    }

    public Button getDetails() {
        return details;
    }

    public Button getNewBrand() {
        return newBrand;
    }

    @Override
    public Parent getRoot() {
        return root;
    }
}
