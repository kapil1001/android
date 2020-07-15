package com.example.navigation.ui.studentList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigation.R;
import com.example.navigation.Item;
import com.example.navigation.ItemAdapter;

import java.util.ArrayList;

public class StudentListFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_student_list, container, false);

        ArrayList<Item> List = new ArrayList<>();
        List.add(new Item(R.mipmap.boy,"Kapil", 23, "bhaktapur", "male"));
        List.add(new Item(R.mipmap.girl,"kabita", 24, "bhaktapur", "female"));

        RecyclerView mRecyclerView = root.findViewById(R.id.recyclerView);
        ItemAdapter recyclerViewAdapter = new ItemAdapter(List);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        mRecyclerView.setAdapter(recyclerViewAdapter);

        return root;
    }
}