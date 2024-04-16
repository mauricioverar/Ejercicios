package com.example.ejercicios;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.d("onCreate", "entr onCreate");

        Button btnSend = findViewById(R.id.btn_send);

        // escuchador de un boton
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                IrSegunda(v);
            }
        });
    }

    public void IrSegunda(View view) { // primera CON MAYUS
        EditText edtName = findViewById(R.id.edt_name);
        String send_string = edtName.getText().toString();
        Intent intent = new Intent(this, MainActivity2.class);// desde esta a la segunda
        intent.putExtra("LINK", send_string);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart", "entr onStart"); // ok
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume", "entr onResume"); // ok
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause", "entr onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onStop", "entr onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy", "entr onDestroy");
    }
}