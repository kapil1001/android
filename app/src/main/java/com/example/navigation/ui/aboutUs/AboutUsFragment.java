package com.example.navigation.ui.aboutUs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.navigation.R;

import java.net.URI;

public class AboutUsFragment extends Fragment {
    private Button aboutUs;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_about_us, container, false);

        aboutUs = root.findViewById(R.id.Au_button);

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked_btn("https://softwarica.edu.np/");
            }
        });
        return root;
    }
    public void clicked_btn(String url)
    {
        Intent intent = new Intent ( Intent.ACTION_VIEW );
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}