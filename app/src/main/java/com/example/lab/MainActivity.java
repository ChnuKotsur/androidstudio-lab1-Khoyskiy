package com.example.lab;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.LinearLayout;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
    ImageView imageViewFlag;
    ImageView imageViewBack;
    Resources resources;
    TextView topText;
    TextView AnthemText;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources resource = getResources();

        String[] items = getResources().getStringArray(R.array.activity_options);
        Spinner countries = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.activity_options, // Ресурс масиву рядків
                android.R.layout.simple_spinner_item // Макет для відображення елементів у Spinner
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        countries.setAdapter(adapter);
        countries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner countries = (Spinner) findViewById(R.id.spinner);
                imageViewFlag = findViewById(R.id.imageView);
                resources = getResources();
                topText = (TextView) findViewById(R.id.textName);
                AnthemText = (TextView) findViewById(R.id.textGimn);

                String country = String.valueOf(countries.getSelectedItem());
                topText.setText(country);

                switch (country) {
                    case "North Korea":
                        imageViewFlag.setImageResource(R.drawable.photo);
                        constraintLayout = findViewById(R.id.constraintLayout);
                        constraintLayout.setBackgroundResource(R.drawable.b5);
                        AnthemText.setText(resources.getString(R.string.GimnNK));

                        break;
                    case "Vetnam":
                        imageViewFlag.setImageResource(R.drawable.dr);
                        AnthemText.setText(resources.getString(R.string.GimnV));
                        constraintLayout = findViewById(R.id.constraintLayout);
                        constraintLayout.setBackgroundResource(R.drawable.big_106375);
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Дія, яка відбувається, коли нічого не вибрано
            }
        });
    }
}