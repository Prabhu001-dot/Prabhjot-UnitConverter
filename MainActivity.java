package com.example.unitconvetor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText Input;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;
    TextView linking;
    //String[] S1Hold = {"Metre", "Celsius", "Kilograms"}; #Here is try to create a array list but I already create an aay in string.xml file so instead of using it from hee i am going to call my array from string.xml fies directly.

    ImageButton metreconvert;
    ImageButton kiloconvert;
    ImageButton celsiusconvert;
    Spinner Spin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        linking = findViewById(R.id.linking);
        celsiusconvert = findViewById(R.id.celsiusimage);
        metreconvert = findViewById(R.id.metreimage);
        kiloconvert = findViewById(R.id.kiloimage);
        Input = findViewById(R.id.Input);

        Spin = findViewById(R.id.Spin);
        Spin.setOnItemSelectedListener(this);
        //ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.spin, android.R.layout.simple_spinner_item );
        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, S1Hold);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spin, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spin.setAdapter(adapter);

    }

    public void metreconvert(View view){
        try
        {
            //String len= (Spin.getSelectedItemPosition() == 0) //.toString();
            //if(len.equals(S1Hold[0]))
            if (Spin.getSelectedItemPosition() == 0)
            {
                t4.setText("Centimetre");
                t5.setText("Foot");
                t6.setText("Inch");
                t1.setText(String.format("%.2f", (Double.parseDouble(Input.getText().toString()) * 100)));
                t2.setText(String.format("%.2f", (Double.parseDouble(Input.getText().toString()) * 3.28)));
                t3.setText(String.format("%.2f", (Double.parseDouble(Input.getText().toString()) * 39.37)));
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Please select the proper Icon", Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e)
        {
         Toast.makeText(getApplicationContext(), "Please try again with Integer/Doubles", Toast.LENGTH_SHORT).show();
        }
    }
    public void celsiusconvert(View view){
        try
        {
            //String len= Spin.getSelectedItem().toString();
            //if(len.equals(S1Hold[1]))
            if (Spin.getSelectedItemPosition() == 2)
            {
                t4.setText("Fahrenheit");
                t5.setText("Kelvin");
                t6.setText(" ");
                t1.setText(String.format("%.2f", (Double.parseDouble(Input.getText().toString()) * 9 / 5 + 32)));
                t2.setText(String.format("%.2f", (Double.parseDouble(Input.getText().toString()) + 273.15)));
                t3.setText("");
            }

            else{
                Toast.makeText(getApplicationContext(), "Please Select the Proper Icon", Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Please try again with Integer/Doubles", Toast.LENGTH_SHORT).show();
        }
    }
    public void Kiloconvert(View view){
        try{
            //String len= Spin.getSelectedItem().toString();
            //if(len.equals(S1Hold[2]))
            if (Spin.getSelectedItemPosition() == 1)
            {
                t4.setText("Gram");
                t5.setText("Ounce(Oz)");
                t6.setText("Pound (lb)");
                t1.setText(String.format("%.2f", (Double.parseDouble(Input.getText().toString()) * 1000)));
                t2.setText(String.format("%.2f", (Double.parseDouble(Input.getText().toString()) + 35.274)));
                t3.setText(String.format("%.2f", (Double.parseDouble(Input.getText().toString()) * 2.20)));
            }

            else
            {
                Toast.makeText(getApplicationContext(),"Please Select the Proper Icon",Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Please try again with Integer/Doubles", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        linking.setText(Spin.getSelectedItem().toString());
        //S1Hold.setText(Spin.getSelectedItem().toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}