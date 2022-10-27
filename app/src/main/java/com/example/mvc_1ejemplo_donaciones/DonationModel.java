package com.example.mvc_1ejemplo_donaciones;

public class DonationModel {

    // modelo tiene la logica del negocio
    // 1.Monto acumulado
    private int donationAmount;

    // 2-Constructor Para recibir monedas
    public DonationModel(int donationAmount) {
        this.donationAmount = donationAmount;
    }

    public DonationModel() {
        this.donationAmount = 0;
    }
    // 3 crear un metodo que reciba y comprobar donaciones

    public boolean saveDonation(String donation) {
        Integer amount = Integer.valueOf(donation);
        if (amount <= 0) {
            return false;
        } else {
            this.donationAmount += amount;
            return true;
        }
    }

    // Retornar la donacion
    public int getDonationAmount() {
        return donationAmount;
    }


}
