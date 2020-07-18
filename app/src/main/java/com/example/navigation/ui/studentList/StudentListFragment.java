package com.example.navigation.ui.studentList;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigation.ItemGiver;
import com.example.navigation.R;
import com.example.navigation.ItemAdapter;

import static android.content.ContentValues.TAG;

public class StudentListFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_student_list, container, false);

        ItemAdapter recyclerViewAdapter = new ItemAdapter(ItemGiver.getInstance().getItems());
        RecyclerView mRecyclerView = root.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        mRecyclerView.setAdapter(recyclerViewAdapter);
        
        return root;
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG, "onResume: called");
        new ItemAdapter(ItemGiver.getInstance().getItems());
    }
}