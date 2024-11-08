package com.nurmandev.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;


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


        editText = findViewById(R.id.userInput);
        button = findViewById(R.id.btn);
        textView = findViewById(R.id.result);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString();

//                Converting a string to double
                double kilos = Double.parseDouble(inputText);
//                Converting kilos to Naira
                double naira = makeConversion(kilos);

                textView.setText(" " + naira);
            }
        });
    }

    public double makeConversion(double kilos){
        return kilos * 20.3103;
    }
}