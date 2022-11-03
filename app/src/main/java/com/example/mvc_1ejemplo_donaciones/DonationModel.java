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

    // metodo que Válida las donaciones y el presentador es quien notifica a la vista
    public String ChekAmountDonation(){

        if(donationAmount >=200 && donationAmount<= 500){
             return "#F31A1A";
        }
        else if(donationAmount >500 && donationAmount <=1000 ){
            return "#FFFB33";
        }else  {
            return "#58FF11";
        }
    }



}
