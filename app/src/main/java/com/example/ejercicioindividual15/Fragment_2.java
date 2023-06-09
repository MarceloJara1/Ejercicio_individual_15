package com.example.ejercicioindividual15;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.ejercicioindividual15.databinding.Fragment1Binding;
import com.example.ejercicioindividual15.databinding.Fragment2Binding;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.snackbar.Snackbar;


public class Fragment_2 extends Fragment {

    private Fragment2Binding binding;
    private int radioButtonResult = -1;
    private MaterialToolbar topAppbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = Fragment2Binding.inflate(inflater,container, false);
        View view = binding.getRoot();

        String nombre = Fragment_2Args.fromBundle(getArguments()).getNombre();
        binding.txtNombre.setText("Bienvenido "+nombre);

        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButtonResult = checkedId;
            }
        });

        binding.btnComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButtonResult !=-1){
                    if (radioButtonResult == R.id.radioPringles){
                        String txtNombre = nombre;
                        NavDirections action = Fragment_2Directions.actionFragment2ToFragmentCorrect2(txtNombre);
                        Navigation.findNavController(v).navigate(action);

                    }else {
                        String txtNombre = nombre;
                        NavDirections action = Fragment_2Directions.actionFragment2ToFragmentWrong(txtNombre);
                        Navigation.findNavController(v).navigate(action);
                    }
                }else {
                    Snackbar.make(v, "Selecciona una opcion para continuar...", Snackbar.LENGTH_LONG)
                            
                        .show();
                }
            }
        });

        topAppbar = binding.topAppBar;

        topAppbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.popBackStack();
            }
        });
        return view;
    }


}