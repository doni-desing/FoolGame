package com.example.cardstupet.profaile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cardstupet.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private ActionCodeSettings actionCodeSettings;
    private DatabaseReference mPostReference;
    private DatabaseReference mDataBase;
    private TextView login, number, password, pass2;
    FirebaseAuth firebaseAuth;

    EditText editNumber, editPassword, editLogin, editReapedPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mDataBase = FirebaseDatabase.getInstance().getReference();
        editNumber = findViewById(R.id.et_number);
        editPassword = findViewById(R.id.et_password);
        firebaseAuth = FirebaseAuth.getInstance();

        editLogin = findViewById(R.id.et_login_in_register);
        editReapedPass = findViewById(R.id.et_reaped_password);
        mPostReference = FirebaseDatabase.getInstance().getReference().child("users");

        login = findViewById(R.id.tv_login);
        number = findViewById(R.id.number);
        password = findViewById(R.id.password);
        pass2 = findViewById(R.id.pass2);
click();


    }
    public void click(){

        editNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setTextColor((getResources().getColor(R.color.tv)));
                login.setTextColor((getResources().getColor(R.color.q)));
            }
        });
        editPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password.setTextColor((getResources().getColor(R.color.tv)));
            }
        });
        editReapedPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass2.setTextColor((getResources().getColor(R.color.tv)));
            }
        });
        editLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.setTextColor((getResources().getColor(R.color.tv)));
            }
        });
    }

    public void onCreate(View view) {

        String login1 = editLogin.getText().toString().trim();
        String pass1 = editPassword.getText().toString().trim();
        String number1 = editNumber.getText().toString().trim();

        if (login1.isEmpty()&&pass1.isEmpty()&&number1.isEmpty()){
            editLogin.setError("sds");
            login1.equalsIgnoreCase("xzxzxzx");
            editPassword.setError("sds");
            pass1.equalsIgnoreCase("xzxzxzx");

            editNumber.setError("sds");
            number1.equalsIgnoreCase("xzxzxzx");

            editReapedPass.setError("asasas");
        }

        else {
            writeNewUser(login1, pass1, number1);
        }
        if (!editPassword.toString().equals(editReapedPass.toString())){
            editReapedPass.setError("asasas");

        } else if (editPassword.toString().equals(editReapedPass.toString())) {
            Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_LONG).show();
        }

    }
    public boolean writeNewUser(String login, String password, String number) {

        Map<String, String> map = new HashMap<>();
        map.put("login", login);
        map.put("password", password);
        map.put("number", number);

        FirebaseFirestore.getInstance().collection("users").document(map.get("login"))
                .set(map)
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "В get data error " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        return true;
    }

    public void haveAkk(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
