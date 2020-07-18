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

import com.example.navigation.Item;
import com.example.navigation.ItemGiver;
import com.example.navigation.R;

public class AddStudentFragment extends Fragment {
    private Button insertBtn;
    private TextView fullnameET;
    private TextView ageET;
    private TextView addressET;
    private RadioGroup genderGroup;
    private String gender;
    private RadioButton btnMale;
    private RadioButton btnFemale;
    private RadioButton btnOthers;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add_student, container, false);

        fullnameET = root.findViewById(R.id.fname);
        ageET = root.findViewById(R.id.age);
        addressET = root.findViewById(R.id.address);
        genderGroup = root.findViewById(R.id.radiogroup);
        btnMale = root.findViewById(R.id.btn_male);
        btnFemale = root.findViewById(R.id.btn_female);
        btnOthers = root.findViewById(R.id.btn_other);
        insertBtn = root.findViewById(R.id.btn_insert);

        RadioGroup.OnCheckedChangeListener genderChangeListener = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_male: {
                        gender = "Male";
                        break;
                    }
                    case R.id.btn_female: {
                        gender = "Female";
                        break;
                    }
                    case R.id.btn_other: {
                        gender = "Others";
                        break;
                    }
                }
            }
        };

        genderGroup.setOnCheckedChangeListener(genderChangeListener);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    additem();
                    Toast.makeText(requireContext(), "Added Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }

    private boolean validate() {
        boolean isValid = true;
        String name = fullnameET.getText().toString().trim();
        int age = 0;
        if (ageET.getText() != null && !ageET.getText().toString().isEmpty())
            age = Integer.parseInt(ageET.getText().toString().trim());

        String address = addressET.getText().toString().trim();

        if (name.isEmpty()) {
            fullnameET.setError("Please Enter FullName");
            isValid = false;
        }
        if (age == 0) {
            ageET.setError("Please give valid age");
            isValid = false;
        }
        if (address.isEmpty()) {
            addressET.setError("Please write your address");
            isValid = false;
        }
        if (gender == null) {
            Toast.makeText(requireContext(), "Please select one Gender", Toast.LENGTH_SHORT).show();
            isValid = false;
        }
        return isValid;
    }

    public void additem(){
        String name = fullnameET.getText().toString().trim();
        int age = Integer.parseInt(ageET.getText().toString().trim());
        String address = addressET.getText().toString().trim();
        String gender = null;

        if(btnMale.isChecked()){
            gender = "male";
        }else if(btnFemale.isChecked()){
            gender = "female";
        }else if(btnOthers.isChecked()){
            gender = "others";
        }
        Item item = new Item(0, name, age, address, gender);
        ItemGiver.getInstance().addItem(item);
    }

}