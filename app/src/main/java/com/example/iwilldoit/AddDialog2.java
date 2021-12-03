package com.example.iwilldoit;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import static java.lang.Boolean.FALSE;
// 인생 버킷리스트에 추가를 위한 다이얼로그
public class AddDialog2 {

    private Context context;

    public AddDialog2 (Context context){
        this.context = context;
    }

    public void callDialog(){
        final Dialog dialog = new Dialog(context);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.add_dialog);
        dialog.show();

        final Button ok = (Button) dialog.findViewById(R.id.btn_ok);
        final Button cancel = (Button) dialog.findViewById(R.id.btn_cancel);
        final EditText txt_dream = (EditText) dialog.findViewById(R.id.txt_dream);

        // 확인 버튼
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                LifeDreamInfo tmp = new LifeDreamInfo(txt_dream.getText().toString(),FALSE);
                Adapter2 adapter = new Adapter2();
                adapter.setArrayData(tmp);
                db.collection(firebaseAuth.getUid() + "2")
                        .document(txt_dream.getText().toString())
                        .set(tmp);
                adapter.notifyDataSetChanged();
                Toast.makeText(context, "버킷리스트 추가 완료!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
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
