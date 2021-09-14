package com.example.braille;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
EditText msg;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.btn);
        msg=(EditText)findViewById(R.id.msg);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.child("message");
        btn.setOnClickListener(v -> {
            String m=msg.getText().toString().trim();
            myRef.child("message").setValue(m);
            Toast.makeText(getApplicationContext(),m,Toast.LENGTH_LONG).show();
        });
    }
}