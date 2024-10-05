package com.example.craxxify.LogSign;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.craxxify.R;
import com.example.craxxify.UserAct;

public class LogInActivity extends AppCompatActivity {

    private Button enter;
    private EditText nom, password;
    private ActivityResultLauncher<Intent> enterUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        enter = (Button) findViewById(R.id.intro);
        nom = (EditText) findViewById(R.id.intro_nom);
        password = (EditText) findViewById(R.id.intro_password);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = nom.getText().toString();
                String pass = password.getText().toString();

                if (!(username.isEmpty()) &&  !(pass.isEmpty())) {
                    Intent intent = new Intent(v.getContext(), UserAct.class);
                    enterUser.launch(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Completa tots els camps", Toast.LENGTH_SHORT).show();
                }
            }
        });
        enterUser = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {

                    }
                }
        );

    }
}