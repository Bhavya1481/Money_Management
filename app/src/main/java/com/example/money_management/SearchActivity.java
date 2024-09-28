//package com.example.money_management;
//
//import android.annotation.SuppressLint;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.ArrayList;
//import java.util.Map;
//
//public class SearchActivity extends AppCompatActivity {
//
//    private ListView listViewSearchResults;
//
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search);
//
//        listViewSearchResults = findViewById(R.id.listview_search_results);
//
//        String searchQuery = getIntent().getStringExtra("search_query");
//        if (searchQuery == null || searchQuery.isEmpty()) {
//            Toast.makeText(this, "No search query provided", Toast.LENGTH_SHORT).show();
//            finish();
//            return;
//        }
//
//        // Load all expenses from SharedPreferences
//        SharedPreferences sharedPreferences = getSharedPreferences("Expenses", MODE_PRIVATE);
//        Map<String, ?> allExpenses = sharedPreferences.getAll();
//
//        ArrayList<String> searchResults = new ArrayList<>();
//
//        // Iterate over the saved expenses and search for matches
//        for (Map.Entry<String, ?> entry : allExpenses.entrySet()) {
//            if (entry.getValue() instanceof String) {
//                String expenseDetails = (String) entry.getValue();
//                if (expenseDetails.toLowerCase().contains(searchQuery.toLowerCase())) {
//                    searchResults.add(entry.getKey() + ": " + expenseDetails);
//                }
//            }
//        }
//
//        if (searchResults.isEmpty()) {
//            Toast.makeText(this, "No results found", Toast.LENGTH_SHORT).show();
//        } else {
//            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, searchResults);
//            listViewSearchResults.setAdapter(adapter);
//        }
//    }
//}




package com.example.money_management;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private ListView listViewSearchResults;
    private ArrayList<String> searchResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        listViewSearchResults = findViewById(R.id.listview_search_results);
        String query = getIntent().getStringExtra("search_query");

        if (query == null || query.isEmpty()) {
            Toast.makeText(this, "Search query is empty", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // Fetch expenses from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("Expenses", MODE_PRIVATE);
        searchResults = new ArrayList<>();

        String allExpenses = sharedPreferences.getString("all_expenses", "");
        if (!allExpenses.isEmpty()) {
            String[] expenseArray = allExpenses.split("\n");
            for (String expense : expenseArray) {
                if (expense.toLowerCase().contains(query.toLowerCase())) {
                    searchResults.add(expense);
                }
            }
        }

        if (searchResults.isEmpty()) {
            Toast.makeText(this, "No results found", Toast.LENGTH_SHORT).show();
        } else {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, searchResults);
            listViewSearchResults.setAdapter(adapter);
        }
    }
}
