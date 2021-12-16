package com.example.easyScheduler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class LinkActivity extends AppCompatActivity {
    private Toolbar topToolBar;
    RecyclerView recyclerView;
    FloatingActionButton add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);

        recyclerView = findViewById(R.id.recyclerView1);

        //working of Floating button
        add_button = findViewById(R.id.add_btn2);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LinkActivity.this, AddLinkActivity.class);
                startActivity(intent);

            }
        });


        //setting topToolBar to ActionBar
        topToolBar = findViewById(R.id.topAppBar);
        setSupportActionBar(topToolBar);
        //hiding default app title
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getting custom title
        TextView mTitle = (TextView) topToolBar.findViewById(R.id.toolBarTitle);
        //Display icon in toolbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_baseline_link_24);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        //for bottom navigation items to be appear clearly

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);

        //for bottom menu items to open activities
        bottomNavigationView.setSelectedItemId(R.id.Link);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.Home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class ));
                        overridePendingTransition(0,0);
                        return true;


                    case R.id.Alarm:
                        startActivity(new Intent(getApplicationContext(),AlarmActivity.class ));
                        overridePendingTransition(0,0);
                        return true;


                    case R.id.Message:
                        startActivity(new Intent(getApplicationContext(), MessageActivity.class ));
                        overridePendingTransition(0,0);
                        return true;


                    case R.id.Call:
                        startActivity(new Intent(getApplicationContext(),CallActivity.class ));
                        overridePendingTransition(0,0);
                        return true;


                    case R.id.Link:
                        return true;
                }

                return false;
            }
        });
        //ends here!



    }



}