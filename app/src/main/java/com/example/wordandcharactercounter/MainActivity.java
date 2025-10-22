package com.example.wordandcharactercounter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etInput;
    Spinner spinnerChoice;
    Button btnCount;
    TextView tvResult;
    String selectedOption = "Words"; // default


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.etInput);
        spinnerChoice = findViewById(R.id.spinnerChoice);
        btnCount = findViewById(R.id.btnCount);
        tvResult = findViewById(R.id.tvResult);

        // Set up Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.optionsArray,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerChoice.setAdapter(adapter);

        spinnerChoice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedOption = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Button
        btnCount.setOnClickListener(v -> {
            String text = etInput.getText().toString();
            Toast.makeText(this, getString(R.string.toast_empty), Toast.LENGTH_SHORT).show();


            if (selectedOption.equals("Words")) {
                long count = WordCounter.countWords(text);

                tvResult.setText("Word count " + count);
            } else {
                long count = CharacterCounter.countCharacters(text);
                tvResult.setText("Character Count " + count);
            }
        });
    }
}
