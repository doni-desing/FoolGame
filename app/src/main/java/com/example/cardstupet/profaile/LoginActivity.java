package com.example.cardstupet.profaile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cardstupet.main.MainActivity;
import com.example.cardstupet.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    FirebaseStorage firebaseStorage;
    EditText passwordEd, login;
    RegisterActivity registerActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        login = findViewById(R.id.et_login);
        passwordEd = findViewById(R.id.et_passwor_login);
        registerActivity = new RegisterActivity();

    }

    public void onCome(View view) {
        working();
    }



    public void working(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        DocumentReference docRef = db.collection("users").document(login.getText().toString());

        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Toast.makeText(getApplicationContext(), "secsefull", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });


        String login1 = login.getText().toString().trim();
        String pass1 = passwordEd.getText().toString().trim();
        Log.e("------", docRef+"");


       /*tring a = firebaseAuth.getCurrentUser().getEmail();
            String b = firebaseAuth.getCurrentUser().getPhoneNumber();

            if (!login1.equals(a)){
                login.setError("YOu no have accound");
            } else {
                Toast.makeText(getApplicationContext(), "secsefull", Toast.LENGTH_LONG).show();
            }
            if (!pass1.equals(b)){
                passwordEd.setError("YOu no have accound");
            }else {
                Toast.makeText(getApplicationContext(), "secsefull", Toast.LENGTH_LONG).show();
        }*/

        if (!login1.isEmpty()&& pass1.isEmpty()) {
            startActivity(new Intent(this, MainActivity.class));
        }
        }


    public void onRegister(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }


    public void forgot(View view) {
        startActivity(new Intent(this, ForgotPasswordActivity.class));
    }
}
