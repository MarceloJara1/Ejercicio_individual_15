package com.example.ejercicioindividual15;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ejercicioindividual15.databinding.FragmentWrongBinding;

public class fragment_wrong extends Fragment {

    private FragmentWrongBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWrongBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        String nombre = fragment_wrongArgs.fromBundle(getArguments()).getNombre();
        binding.txtCorrect.setText("Te equivocaste "+nombre+", Intentalo denuevo");

        binding.btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.popBackStack();
            }
        });


        return view;
    }
}