package com.example.navigation.ui.addStudent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.navigation.R;

public class AddStudentFragment extends Fragment {
    private Button buttonInsert;
    private TextView fullName;
    private TextView Age;
    private TextView Address;
    private RadioButton btnMale;
    private RadioButton btnFemale;
    private RadioButton btnOthers;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add_student, container, false);

        fullName = root.findViewById(R.id.fname);
        Age = root.findViewById(R.id.age);
        Address = root.findViewById(R.id.address);
        btnMale = root.findViewById(R.id.btn_male);
        btnFemale = root.findViewById(R.id.btn_female);
        btnOthers = root.findViewById(R.id.btn_other);
        buttonInsert = root.findViewById(R.id.btn_insert);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
        return root;
    }

    private void validate(){

    }
}