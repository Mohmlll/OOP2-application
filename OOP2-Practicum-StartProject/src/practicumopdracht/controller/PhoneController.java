package practicumopdracht.controller;

import practicumopdracht.views.PhoneView;

/**
 * @author Mohammed Malloul
 */

public class PhoneController {

    private final PhoneView view;

    public PhoneController() {
        view = new PhoneView();

        view.getComboBox();
    }

    public PhoneView getView() {
        return view;
    }

}
