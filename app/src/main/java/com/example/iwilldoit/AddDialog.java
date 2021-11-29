package com.example.iwilldoit;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import static android.content.ContentValues.TAG;

public class AddDialog {

    private Context context;
    Adapter adapter = new Adapter();

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
        final EditText txt_dream = (EditText) dialog.findViewById(R.id.txt_dream);

        // 확인 버튼
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                YearDreamInfo tmp = new YearDreamInfo(txt_dream.getText().toString(),"False");
                Adapter adapter = new Adapter();
                adapter.setArrayData(tmp);
                db.collection(firebaseAuth.getUid())
                        .document(Integer.toString(adapter.yearDreamInfos.size()+1))
                        .set(tmp);

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
