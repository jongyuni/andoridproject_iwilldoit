package com.example.iwilldoit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class Adapter2 extends RecyclerView.Adapter<ViewHolder>{
    public static ArrayList<LifeDreamInfo> lifeDreamInfos;

    public Adapter2() {
        lifeDreamInfos = new ArrayList<>();
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
        final LifeDreamInfo text = lifeDreamInfos.get(position);
        holder.textView.setText(text.dream);
        holder.checkBox.setOnCheckedChangeListener(null);
        holder.checkBox.setChecked(text.done);

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                text.done = isChecked;
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                db.collection(firebaseAuth.getUid()+"2")
                        .document(text.dream)
                        .update("done",isChecked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lifeDreamInfos.size();
    }

    // 데이터를 입력
    public void setArrayData(LifeDreamInfo tmpData) { lifeDreamInfos.add(tmpData);
    }
}
