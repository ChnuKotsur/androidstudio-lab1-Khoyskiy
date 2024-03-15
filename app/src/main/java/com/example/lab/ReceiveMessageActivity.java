package com.example.lab;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class ReceiveMessageActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        Intent intent = getIntent();
        String messageText  = intent.getStringExtra(EXTRA_MESSAGE);
        TextView messageView = (TextView) findViewById(R.id.messageT);
        messageView.setText(messageText);

    }
}
