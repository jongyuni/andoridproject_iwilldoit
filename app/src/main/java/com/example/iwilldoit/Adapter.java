package com.example.iwilldoit;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    public static ArrayList<YearDreamInfo> yearDreamInfos;

    public Adapter() {
        yearDreamInfos = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_list, parent, false);

        ViewHolder viewholder = new ViewHolder(context, view);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        YearDreamInfo text = yearDreamInfos.get(position);
        holder.textView.setText(text.dream);
    }

    @Override
    public int getItemCount() {
        return yearDreamInfos.size();
    }

    // 데이터를 입력
    public void setArrayData(YearDreamInfo tmpData) {
        yearDreamInfos.add(tmpData);
    }
}
