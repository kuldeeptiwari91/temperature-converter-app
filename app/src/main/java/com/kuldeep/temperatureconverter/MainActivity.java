package com.kuldeep.temperatureconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCelsius;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCelsius = findViewById(R.id.editTextCelsius);
        textViewResult = findViewById(R.id.textViewResult);
        Button buttonConvert = findViewById(R.id.buttonConvert);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        try {
            String celsiusString = editTextCelsius.getText().toString();
            double celsius = Double.parseDouble(celsiusString);

            double fahrenheit = (celsius * 9/5) + 32;

            textViewResult.setText(String.format("%.2f °F", fahrenheit));
        } catch (NumberFormatException e) {
            textViewResult.setText("Invalid input");
        }
    }
}
