package com.example.ejercicioindividual15;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ejercicioindividual15.databinding.Fragment1Binding;
import com.google.android.material.snackbar.Snackbar;


public class Fragment_1 extends Fragment {

    private Fragment1Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = Fragment1Binding.inflate(inflater, container, false);

        binding.btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = binding.textField.getEditText().getText().toString();
                NavDirections action = Fragment_1Directions.actionFragment1ToFragment2(inputText);

                if (inputText.isEmpty()){
                    Snackbar.make(v, "Ingresa tu nombre para continuar...", Snackbar.LENGTH_LONG)

                            .show();
                }else {
                    Navigation.findNavController(v).navigate(action);
                }

            }
        });

        return binding.getRoot();

    }
}