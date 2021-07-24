package com.example.tempconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


/***
 *  [c] = ([F] -32) * 5/9 ---> From Fahrenheit to celsius
 *  [f] = ([c] * 9/5) + 32 ---> From celsius  to Fahrenheit
 *
 */

public class MainActivity extends AppCompatActivity {
    private EditText tempEditText;
    private Button cButton;
    private Button fButton;
    private TextView showTempTextView;

    DecimalFormat round = new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempEditText = (EditText)findViewById(R.id.editTextTextPersonName);
        cButton = (Button)findViewById(R.id.button);
        fButton = (Button)findViewById(R.id.button2);
        showTempTextView = (TextView)findViewById(R.id.textView2);

        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call convertToCelsius()
                String editTextVal= tempEditText.getText().toString();

                if (editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Enter Valid Temp Number",Toast.LENGTH_LONG).show();
                }else{
                    double intEditText = Double.parseDouble(editTextVal);
                    double convertedVal =  convertToCelsius(intEditText);
                    String stringResult = String.valueOf( round.format(convertedVal));
                    showTempTextView.setText(stringResult + " C");
                }
            }
        });

        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call convertToFahrenheit
                String editTextVal = tempEditText.getText().toString();
                if(editTextVal.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Enter Valid Value", Toast.LENGTH_LONG).show();
                }else{
                    double intEditTempText = Double.parseDouble(editTextVal);
                    double convertedVal =  convertToFahrenheit(intEditTempText);
                    String stringResult = String.valueOf(round.format(convertedVal));
                    showTempTextView.setText(stringResult + " F");
                }
            }
        });
    }

    public double convertToCelsius(double farVal){
        /*
         *  [c] = ([F] -32) * 5/9 ---> From Fahrenheit to celsius
         */
        double resultCel;
        resultCel = (farVal - 32 ) * 5/9;
        return  resultCel;
    }

    public double convertToFahrenheit(double celVal){
        /*
         *  [f] = ([c] * 9/5) + 32 ---> From celsius  to Fahrenheit
         */
        double resultFar = (celVal * 9/5) + 32 ;
        return resultFar;
    }
}