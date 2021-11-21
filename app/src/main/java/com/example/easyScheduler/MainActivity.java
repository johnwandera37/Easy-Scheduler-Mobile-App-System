package com.example.easyScheduler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private Toolbar topToolBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//for bottom navigation items to be appear clearly

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);

 //for bottom menu items to open activities
        bottomNavigationView.setSelectedItemId(R.id.Home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.Home:
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
                        startActivity(new Intent(getApplicationContext(),LinkActivity.class ));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });
        //ends here!


        //for top bar menu items to work
        topToolBar = findViewById(R.id.topAppBar);
        setSupportActionBar(topToolBar);



    }
//working of the search icon "clicking"
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.top_menu_bar,menu);
        return true;
    }

//working of the overflow menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.preferences){
            Intent intent =  new Intent(MainActivity.this,Preferences.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.help) {
            Intent intent1 = new Intent(MainActivity.this, Help.class);
            startActivity(intent1);
            return true;
        }
        return super.onOptionsItemSelected(item);

    }


}