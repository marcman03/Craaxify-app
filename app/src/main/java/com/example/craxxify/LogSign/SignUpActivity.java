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

import com.example.craxxify.MainActivity;
import com.example.craxxify.R;

public class SignUpActivity extends AppCompatActivity {

    private Button enter;
    private EditText nom, password, rpassword, correu;
    private ActivityResultLauncher<Intent> signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        enter = (Button) findViewById(R.id.enterbut);
        nom = (EditText) findViewById(R.id.intro_nom_SU);
        password = (EditText) findViewById(R.id.intro_password_SU);
        rpassword = (EditText) findViewById(R.id.intro_Rpassword_SU);
        correu = (EditText) findViewById(R.id.intro_correu);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = nom.getText().toString();
                String pass = password.getText().toString();
                String rpass = rpassword.getText().toString();
                String corr = correu.getText().toString();

                if (!(username.isEmpty()) &&  !(pass.isEmpty()) &&  !(rpass.isEmpty()) &&  !(corr.isEmpty())) {
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Completa tots els camps", Toast.LENGTH_SHORT).show();
                }
            }
        });
        signup = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {

                    }
                }
        );
    }
}