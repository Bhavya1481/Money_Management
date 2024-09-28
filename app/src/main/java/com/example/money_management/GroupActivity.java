package com.example.money_management;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GroupActivity extends AppCompatActivity {

    EditText groupNameEditText;
    Button addGroupButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        groupNameEditText = findViewById(R.id.groupNameEditText);
        addGroupButton = findViewById(R.id.btnCreateGroup);

        addGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String groupName = groupNameEditText.getText().toString();
                if (!groupName.isEmpty()) {
                    Toast.makeText(GroupActivity.this, "Group Created", Toast.LENGTH_SHORT).show();
                    finish();  // Go back to the main activity
                } else {
                    Toast.makeText(GroupActivity.this, "Enter a group name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
