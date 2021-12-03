package com.example.iwilldoit;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    public ImageButton btn_delete;
    public CheckBox checkBox;
    public ImageButton btn_search;

    ViewHolder(Context context, View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.textView);
        btn_delete = itemView.findViewById(R.id.btn_delete);
        checkBox = itemView.findViewById(R.id.checkBox);
        btn_search = itemView.findViewById(R.id.btn_search);

        // 검색 버튼
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, textView.getText().toString());
                v.getContext().startActivity(intent);
            }
        });

    }
}
