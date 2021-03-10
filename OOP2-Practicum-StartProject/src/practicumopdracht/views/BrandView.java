package practicumopdracht.views;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    private Alert alertDelete;
    private Alert alertSave;
    private Alert alertDeleteList;
    private MenuBar menuBar;
    private Menu menuFile;
    private MenuItem menuLoad;
    private MenuItem menuSave;

    public BrandView() {
        initializeRoot();
    }

    private void initializeRoot() {

        GridPane gridPane = new GridPane();
        menuBar = new MenuBar();
        menuLoad = new MenuItem("Load");
        menuSave = new MenuItem("Save");
        menuFile = new Menu("File",null, menuLoad, menuSave);
        menuBar.getMenus().addAll(menuFile);
        VBox vbox = new VBox(menuBar);

        HBox hBoxName = new HBox();
        Label brandNameLabel = new Label("brand name: ");
        brandNameLabel.setMinSize(70, 20);
        brandName = new TextField();
        brandName.setMinSize(500, 16);
        hBoxName.getChildren().addAll(brandNameLabel, brandName);

        HBox hBoxCeo = new HBox();
        Label nameCeoLabel = new Label("name CEO: ");
        nameCeoLabel.setMinSize(70, 20);
        nameCeo = new TextField();
        nameCeo.setMinSize(500, 16);
        hBoxCeo.getChildren().addAll(nameCeoLabel, nameCeo);

        HBox hBoxNetworth = new HBox();
        Label networthLabel = new Label("networth: ");
        networthLabel.setMinSize(70, 20);
        networth = new TextField();
        networth.setMinSize(500, 16);
        hBoxNetworth.getChildren().addAll(networthLabel, networth);

        HBox hBoxTextArea = new HBox();
        Label textAreaLabel = new Label("Description: ");
        textAreaLabel.setMinSize(70, 16);
        textArea = new TextArea();
        textArea.setMinSize(500, 50);
        hBoxTextArea.getChildren().addAll(textAreaLabel, textArea);

        save = new Button("Save");
        save.setMinWidth(600);

        listView = new ListView<>();
        listView.setMinSize(600, 80);

        HBox hBoxButtons = new HBox();
        delete = new Button("Delete");
        delete.setMinWidth(200);
        models = new Button("Models");
        models.setMinWidth(200);
        hBoxButtons.setSpacing(20);
        hBoxButtons.getChildren().addAll(delete, models);

        alertDelete = new Alert(Alert.AlertType.CONFIRMATION);
        alertDelete.setTitle("Alert");
        alertDelete.setContentText("Are you sure you want to delete this Brand?");

        alertSave = new Alert(Alert.AlertType.WARNING);
        alertSave.setTitle("Save");
        alertSave.setContentText("- Niet alle velden zijn ingevuld\n- Networth mag alleen nummers hebben");

        alertDeleteList = new Alert(Alert.AlertType.WARNING);
        alertDeleteList.setTitle("Delete");
        alertDeleteList.setContentText("- Geen veld geselecteerd");

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

    public MenuItem getMenuLoad() {
        return menuLoad;
    }

    public MenuItem getMenuSave() {
        return menuSave;
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

    public Button getModels() {
        return models;
    }

    @Override
    public Parent getRoot() {
        return root;
    }
}
