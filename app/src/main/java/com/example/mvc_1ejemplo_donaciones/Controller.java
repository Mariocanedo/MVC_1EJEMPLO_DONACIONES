package com.example.mvc_1ejemplo_donaciones;

public class Controller {


    //1  HACER REFERENCIA AL MÓDELO PARA COMUNICARSE CON ÉL
    private  DonationModel model;

    //  2 conectar model con controller
    public Controller() {
        this.model = new DonationModel();
    }

    public boolean saveDonation(String amount) {

        return model.saveDonation(amount);
    }

    public int totalDonation() {
        return model.getDonationAmount();
    }


}
