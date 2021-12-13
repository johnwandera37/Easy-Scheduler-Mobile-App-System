package com.example.easyScheduler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private Toolbar topToolBar;
    private long backPressed;
    private Toast backToast;

    //back press button
    @Override
    public void onBackPressed() {

        if(backPressed + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
        }else{
           backToast = Toast.makeText(getBaseContext(), "Press back again to exit",Toast.LENGTH_SHORT);
           backToast.show();
        }
        backPressed = System.currentTimeMillis();

    }

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
                        break;


                    case R.id.Alarm:
                        startActivity(new Intent(getApplicationContext(),AlarmActivity.class ));
                        overridePendingTransition(0,0);
                        break;


                    case R.id.Message:
                        startActivity(new Intent(getApplicationContext(), MessageActivity.class ));
                        overridePendingTransition(0,0);
                        break;


                    case R.id.Call:
                        startActivity(new Intent(getApplicationContext(),CallActivity.class ));
                        overridePendingTransition(0,0);
                        break;


                    case R.id.Link:
                        startActivity(new Intent(getApplicationContext(),LinkActivity.class ));
                        overridePendingTransition(0,0);
                        break;
                }

                return false;
            }
        });
        //ends here!


        //for top bar menu items to work, setting topToolBar to ActionBar
        topToolBar = findViewById(R.id.topAppBar);
        setSupportActionBar(topToolBar);
        //hiding default app title
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getting custom title
        TextView mTitle = (TextView) topToolBar.findViewById(R.id.toolBarTitle);
        //Display icon in toolbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_baseline_home_24);
        getSupportActionBar().setDisplayUseLogoEnabled(true);




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