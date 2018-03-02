package com.anderson.bryce.store;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.widget.EditText;
//import android.widget.Toast;
//import android.widget.TextView;
//import android.widget.Button;
import android.widget.*;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    EditText etTemperature;
    TextView tvCelsius;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //TextView message = new TextView(this);
        //message.setText("Hello World"); 
        //setContentView(message);

        //Toast.makeText(MainActivity.this, "hello world", Toast.LENGTH_SHORT).show();     //display in short period of time 
        //Toast.makeText(getApplicationContext(), "msg msg", Toast.LENGTH_SHORT).show();   //display in long period of time 
        //Toast.makeText(getApplicationContext(), "msg msg", Toast.LENGTH_LONG).show(); 

        etTemperature = (EditText) findViewById(R.id.etTemperature); // like VB Textbox 
        Button btnCompute = (Button) findViewById(R.id.btnCompute);         // like VB Button 
        Button btnReset = (Button) findViewById(R.id.btnReset);
        tvCelsius = (TextView) findViewById(R.id.tvCelsius);

        btnCompute.setOnClickListener(new Button.OnClickListener()
        {

            public void onClick(View v)
            {
                calculate();
            }

        });

        btnReset.setOnClickListener(new Button.OnClickListener()
        {

            public void onClick(View v)
            {
                reset();
            }

        });

    }// end of onCreate method

    private void calculate()
    {
        double degreesFahrenheit = Double.parseDouble(etTemperature.getText().toString());
        double degreesCelsius = (degreesFahrenheit - 32) * 5./9.;
        tvCelsius.setText(Double.toString(degreesCelsius));
    }

    private void reset()
    {
        etTemperature.setText("");
        tvCelsius.setText("");
    }

}// end of MainActivity class




