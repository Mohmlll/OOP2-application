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

    private final MenuItem ascending = new MenuItem("A-Z");
    private final MenuItem descending = new MenuItem("Z-A");
    private final Alert menuAlert;

    private final MenuBar root;

    public MenuView() {
        Menu menu = new Menu("File", null, menuLoad, menuSave, menuClose);
        Menu soorteerMenu = new Menu("Sort", null, ascending, descending);
        this.root = new MenuBar(menu, soorteerMenu);

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

    public MenuItem getAscending() {
        return ascending;
    }

    public MenuItem getDescending() {
        return descending;
    }

    @Override
    public Parent getRoot() {
        return root;
    }

}
