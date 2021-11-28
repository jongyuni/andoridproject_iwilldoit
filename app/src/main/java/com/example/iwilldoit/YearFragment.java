package com.example.iwilldoit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class YearFragment extends Fragment {
    Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.year_fragment, container, false);

        Button btn_add = rootView.findViewById(R.id.btn_add);
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false)) ;
        adapter = new Adapter();
        for (int i = 0; i < 100; i++) {
            String str = i + "번째 아이템";
            adapter.setArrayData(str);
        }

        recyclerView.setAdapter(adapter);
        // Add 버튼 클릭
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDialog adddialog = new AddDialog(getActivity());
                adddialog.callDialog();
            }
        });

        return rootView;

    }
}
