package com.example.iwilldoit;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class AddDialog {

    private Context context;

    public AddDialog (Context context){
        this.context = context;
    }

    public void callDialog(){
        final Dialog dialog = new Dialog(context);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.add_dialog);
        dialog.show();

        final Button ok = (Button) dialog.findViewById(R.id.btn_ok);
        final Button cancel = (Button) dialog.findViewById(R.id.btn_cancel);

        // 확인 버튼
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(context, "앱을 종료합니다", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                ((MainActivity) context).finish();
            }
        });

        // 취소 버튼
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                dialog.dismiss();
            }
        });
    }
}
