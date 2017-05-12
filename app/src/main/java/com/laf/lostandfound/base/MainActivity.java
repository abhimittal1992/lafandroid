package com.laf.lostandfound.base;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.laf.lostandfound.R;
import com.laf.lostandfound.adapters.HomeCardAdapter;
import com.laf.lostandfound.dto.BaseCardDto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    String type = "LOST";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //Simple Comment
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Spinner spinner = (Spinner) findViewById(R.id.typeSelect);
        setSpinnerOnSelect(spinner);

        Button submitBtn = (Button) findViewById(R.id.submitBtn);
        setButtonOnClick(submitBtn);
    }
    private void setButtonOnClick(Button submitBtn) {
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = ((EditText) findViewById(R.id.itemName)).getText().toString();
                String itemLocation = ((EditText) findViewById(R.id.itemLocation)).getText().toString();
                String itemDesc = ((EditText) findViewById(R.id.itemDesc)).getText().toString();

                System.out.println("I have "+type+" "+itemName+ " at "+itemLocation+". Here are details about it: "+itemDesc);
            }
        });
    }
    private void setSpinnerOnSelect(Spinner spinner) {
        AdapterView.OnItemSelectedListener typeSelector = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position >0) {
                    type="FOUND";
                } else {
                    type="LOST";
                }
                setRecyclerView();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                type = "LOST";
                setRecyclerView();
            }
        };
        spinner.setOnItemSelectedListener(typeSelector);
        setRecyclerView();
    }

    private void setRecyclerView() {
        RecyclerView cardList = (RecyclerView) findViewById(R.id.cardList);
        cardList.setAdapter(null);
        cardList.setHasFixedSize(true);
        List<BaseCardDto> cardDtos = new ArrayList<BaseCardDto>(30);
        for (int i = 1; i <= 30; i++) {
            BaseCardDto dto = new BaseCardDto();
            dto.setCardTitle(i + "is the title with type = " + type);
            dto.setCardDesc(i + "is the Desc with type = " + type);
            cardDtos.add(dto);
        }
        cardList.setAdapter(new HomeCardAdapter(cardDtos));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
     /*   if (id == R.id.action_settings) {
            return true;
        }
*/
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       /* if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    /* String type = "LOST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.title_bar);

        Spinner spinner = (Spinner) findViewById(R.id.typeSelect);
        setSpinnerOnSelect(spinner);

        Button submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = ((EditText) findViewById(R.id.itemName)).getText().toString();
                String itemLocation = ((EditText) findViewById(R.id.itemLocation)).getText().toString();
                String itemDesc = ((EditText) findViewById(R.id.itemDesc)).getText().toString();

                System.out.println("I have "+type+" "+itemName+ " at "+itemLocation+". Here are details about it: "+itemDesc);
            }
        });
    }

    private void setSpinnerOnSelect(Spinner spinner) {
        OnItemSelectedListener typeSelector = new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position >0) {
                    type="FOUND";
                } else {
                    type="LOST";
                }
                setRecyclerView();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                type = "LOST";
                setRecyclerView();
            }
        };
        spinner.setOnItemSelectedListener(typeSelector);
        setRecyclerView();
    }

    private void setRecyclerView() {
        RecyclerView cardList = (RecyclerView) findViewById(R.id.cardList);
        cardList.setAdapter(null);
        cardList.setHasFixedSize(true);
        List<BaseCardDto> cardDtos = new ArrayList<BaseCardDto>(30);
        for (int i = 1; i <= 30; i++) {
            BaseCardDto dto = new BaseCardDto();
            dto.setCardTitle(i + "is the title with type = " + type);
            dto.setCardDesc(i + "is the Desc with type = " + type);
            cardDtos.add(dto);
        }
        cardList.setAdapter(new HomeCardAdapter(cardDtos));
    }*/
}