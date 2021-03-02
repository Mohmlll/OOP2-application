package practicumopdracht.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import practicumopdracht.models.Brand;

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
    private Button models;
    private Alert alert;

    public BrandView() {
        initializeRoot();
    }

    private void initializeRoot() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10, 10, 10, 10));


        HBox brandNameBox = new HBox();
        Label brandNameLabel = new Label("brand name: ");
        brandNameLabel.setMinSize(70, 20);
        brandName = new TextField();
        brandName.setMinSize(500, 16);
        brandNameBox.setPadding(new Insets(0, 0, 10, 0));
        brandNameBox.getChildren().addAll(brandNameLabel, brandName);

        HBox nameCeoBox = new HBox();
        Label nameCeoLabel = new Label("name CEO: ");
        nameCeoLabel.setMinSize(70, 20);
        nameCeo = new TextField();
        nameCeo.setMinSize(500, 16);
        nameCeoBox.setPadding(new Insets(0, 0, 10, 0));
        nameCeoBox.getChildren().addAll(nameCeoLabel, nameCeo);

        HBox networthBox = new HBox();
        Label networthLabel = new Label("networth: ");
        networthLabel.setMinSize(70, 20);
        networth = new TextField();
        networth.setMinSize(500, 16);
        networthBox.setPadding(new Insets(0, 0, 10, 0));
        networthBox.getChildren().addAll(networthLabel, networth);

        HBox textAreaBox = new HBox();
        Label textAreaLabel = new Label("Description: ");
        textAreaLabel.setMinSize(70, 16);
        textArea = new TextArea();
        textArea.setMinSize(500, 50);
        textAreaBox.setPadding(new Insets(0, 0, 10, 0));
        textAreaBox.getChildren().addAll(textAreaLabel, textArea);


        HBox saveBox = new HBox();
        save = new Button("Save");
        save.setMinWidth(600);
        saveBox.setPadding(new Insets(0, 0, 10, 0));
        saveBox.getChildren().addAll(save);

        HBox listViewBox = new HBox();
        listView = new ListView();
        listView.setMinSize(600, 80);
        listViewBox.setPadding(new Insets(0, 0, 10, 0));
        listViewBox.getChildren().addAll(listView);

        HBox buttons = new HBox();
        buttons.setMinSize(600, 30);

        delete = new Button("Delete");
        delete.setAlignment(Pos.CENTER);
        models = new Button("Models");
        models.setAlignment(Pos.BOTTOM_RIGHT);
        buttons.setSpacing(480);
        buttons.getChildren().addAll(delete, models);

        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Alert");
        alert.setContentText("Are you sure you want to delete this Brand?");
        HBox pane = new HBox(15);
        pane.getChildren().addAll( delete);

        vbox.getChildren().addAll(brandNameBox, nameCeoBox, networthBox, textAreaBox, saveBox, listViewBox, buttons, pane);
        root = vbox;
    }

    public ListView<Brand> getListView() {
        return listView;
    }

    public TextField getBrandName() {
        return brandName;
    }

    public Alert getAlert() {
        return alert;
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


    public Button getDelete() {
        return delete;
    }

    public Button getModels() {
        return models;
    }

    public Brand getGeselecteerdeBrand() {
        return this.listView.getSelectionModel().getSelectedItem();
    }

    @Override
    public Parent getRoot() {
        return root;
    }
}
