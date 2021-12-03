package com.example.iwilldoit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
//올해 버킷리스트를 위한 어댑터
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
        final YearDreamInfo text = yearDreamInfos.get(position);
        holder.textView.setText(text.dream);
        holder.checkBox.setOnCheckedChangeListener(null);
        holder.checkBox.setChecked(text.done);

        // 체크박스
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                text.done = isChecked;
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                db.collection(firebaseAuth.getUid())
                        .document(text.dream)
                        .update("done",isChecked);
            }
        });

        // 검색 버튼의 경우
        // ViewHolder.java에 구현되어있음

        // 삭제 버튼
        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                db.collection(firebaseAuth.getUid())
                        .document(text.dream)
                        .delete()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                yearDreamInfos.remove(text.dream);
                                notifyDataSetChanged();
                            }
                        });
            }
        });
    }

    // 데이터 수 반환
    @Override
    public int getItemCount() {
        return yearDreamInfos.size();
    }

    // 데이터를 입력
    public void setArrayData(YearDreamInfo tmpData) {
        yearDreamInfos.add(tmpData);
    }
}
