package com.example.mvc_1ejemplo_donaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mvc_1ejemplo_donaciones.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements iviewPresenter {
// 1 referencia a Binding
    private ActivityMainBinding mBinding;
    // 2 Hacer referencia al Controller
  //  private  Controller controller;
    //HACER REFERENCIA AL PRESENTADOR
    private DonationPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //inflar la vista
        mBinding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
      //  controller = new Controller();
        presenter= new DonationPresenter(this);
        mBinding.button.setOnClickListener(view -> MakeDonation());
    }

    // ENVIAR LA DONACIÓN
    private void MakeDonation() {
        // SE ENVIA LA DONACIÓN
        presenter.saveDonation(mBinding.tvDonation.getText().toString());
        mBinding.tvDonation.setText("");
        presenter.checkTotal();
  }



    // Metodos de la interfaz
    @Override
    public void updateTotalDonation(int totalMount) {
       String total = getString(R.string.total_donaciones,String.valueOf(totalMount));
       mBinding.tvTotal.setText(total);
    }

    @Override
    public void displayConfirmationMessage() {
  Toast.makeText(this,"Donación realizada con Éxito",Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayErrorMessage() {
        Toast.makeText(this,"Fallida",Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayColorAlert(String color) {
        // 1 ESPERA UN STRING Y LE ESTOY PASANDO UN  COLOR CONVERTIR
        mBinding.textView2.setBackgroundColor(Color.parseColor(color));
    }
}