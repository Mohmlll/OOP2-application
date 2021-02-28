package practicumopdracht.controller;


import javafx.scene.Parent;
import practicumopdracht.views.PhoneView;
import practicumopdracht.models.Brand;
import practicumopdracht.views.View;

public class PhoneController {

    private PhoneView view;
    private Brand brand;

    public PhoneController(){
        view = new PhoneView();

        view.getComboBox();
    }

    private void test(){

    }
    public PhoneView getView(){
        return view;
    }

}
