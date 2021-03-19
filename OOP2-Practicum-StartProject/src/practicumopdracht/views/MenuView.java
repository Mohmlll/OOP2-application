package practicumopdracht.views;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuView extends View {

    private final MenuItem menuLoad = new MenuItem("Load");
    private final MenuItem menuSave = new MenuItem("Save");
    private final MenuItem menuClose = new MenuItem("Exit");

    private final Alert menuAlert;

    private final MenuBar root;

    public MenuView() {
        Menu menu = new Menu("File", null, menuLoad, menuSave, menuClose);
        this.root = new MenuBar(menu);

        menuAlert = new Alert(Alert.AlertType.CONFIRMATION);
    }

    public MenuItem getMenuLoad() {
        return menuLoad;
    }

    public MenuItem getMenuSave() {
        return menuSave;
    }

    public MenuItem getMenuClose() {
        return menuClose;
    }

    public Alert getMenuAlert() {
        return menuAlert;
    }

    @Override
    public Parent getRoot() {
        return root;
    }

}
