package com.example.mvc_1ejemplo_donaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvc_1ejemplo_donaciones.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
// 1 referencia a Binding
    private ActivityMainBinding mBinding;
    // 2 Hacer referencia al Controller
    private  Controller controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //inflar la vista
        mBinding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        controller = new Controller();
        mBinding.button.setOnClickListener(view -> MakeDonation());
    }

    private void MakeDonation() {
        boolean donation = controller.saveDonation(mBinding.tvDonation.getText().toString());
        if (donation) {
            int totalDonation = controller.totalDonation();
            String total = getString(R.string.total_donaciones, String.valueOf(totalDonation));
            mBinding.tvTotal.setText(total);
            mBinding.tvDonation.setText("");
        } else {
        showMessage("Donacion Fallida");
    }}

    private void showMessage(String message){
        Toast.makeText(this, message,Toast.LENGTH_LONG).show();
    }
}