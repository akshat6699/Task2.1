package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    ImageButton length, temperature, weight;
    String selection;
    TextView label1, label2, label3, result1, result2, result3;
    EditText input;
    double value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        length = findViewById(R.id.imageButton);
        temperature = findViewById(R.id.imageButton3);
        weight = findViewById(R.id.imageButton4);

        label1 = findViewById(R.id.textView5);
        label2 = findViewById(R.id.textView);
        label3 = findViewById(R.id.textView2);

        result1 = findViewById(R.id.label1);
        result2 = findViewById(R.id.editTextTextPersonName);
        result3 = findViewById(R.id.editTextTextPersonName3);

        input = findViewById(R.id.number);



        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);



        length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!selection.equalsIgnoreCase("metre"))
                    Toast.makeText(getApplicationContext(),"Please select the correct conversion icon", Toast.LENGTH_SHORT ).show();
                else {
                    value = Double.parseDouble(input.getText().toString());
                    result1.setText(String.format("%.2f", (value * 100)));
                    result2.setText(String.format("%.2f", (value * 3.28084)));
                    result3.setText(String.format("%.2f", (value * 39.37008)));
                }
            }
        });

        temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!selection.equalsIgnoreCase("Celsius"))
                    Toast.makeText(getApplicationContext(),"Please select the correct conversion icon", Toast.LENGTH_SHORT ).show();
                else {
                    value = Double.parseDouble(input.getText().toString());

                    result1.setText(String.format("%.2f", value * (9.0/5.0) + 32));
                    result2.setText(String.format("%.2f", value +  273.15));
                }
            }
        });

        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!selection.equalsIgnoreCase("Kilograms"))
                    Toast.makeText(getApplicationContext(),"Please select the correct conversion icon", Toast.LENGTH_SHORT ).show();
                else {
                    value = Double.parseDouble(input.getText().toString());

                    result1.setText(String.format("%.2f", value * 1000));
                    result2.setText(String.format("%.2f", value * 35.274));
                    result3.setText(String.format("%.2f", value * 2.205));
                }
            }
        });
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selection = parent.getItemAtPosition(position).toString();
        if (selection.equalsIgnoreCase("metre")) {
                input.setText("");
                result1.setText("");
                result2.setText("");
                result3.setText("");
                label1.setText("Centimetre");
                label2.setText("Foot");
                label3.setVisibility(View.VISIBLE);
                result3.setVisibility(View.VISIBLE);
                label3.setText("Inch");
        }
        else if (selection.equalsIgnoreCase("kilograms")) {
            input.setText("");
            result1.setText("");
            result2.setText("");
            result3.setText("");
            label1.setText("Gram");
            label2.setText("Ounce(Oz)");
            label3.setVisibility(View.VISIBLE);
            result3.setVisibility(View.VISIBLE);
            label3.setText("Pound(lb)");
        }
        else {
            input.setText("");
            result1.setText("");
            result2.setText("");
            result3.setText("");
            label1.setText("Fahrenheit");
            label2.setText("Kelvin");
            label3.setVisibility(View.INVISIBLE);
            result3.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}