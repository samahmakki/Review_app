package com.example.android.reviews;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class PrivacyActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);

        ///////////////////////////////////////////////////////////

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ///////////////////////////////////////////////////////////
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {
            Intent i = new Intent(PrivacyActivity.this, MainActivity.class);
            startActivity(i);
        }
        else if (id == R.id.profile){
            Intent i = new Intent(PrivacyActivity.this, ProfileActivity.class);
            startActivity(i);
        }
        else if (id == R.id.notification) {

            Intent i = new Intent(PrivacyActivity.this, NotificationActivity.class);
            startActivity(i);
        }
        else if (id == R.id.add_location){
            Intent i = new Intent(PrivacyActivity.this, AddLocationActivity.class);
            startActivity(i);
        }
        else if (id == R.id.business_page) {

            Intent i = new Intent(PrivacyActivity.this, BusinessBageActivity.class);
            startActivity(i);
        }
        else if (id == R.id.contact_us){
            Intent i = new Intent(PrivacyActivity.this, ContactUsActivity.class);
            startActivity(i);
        }
        else if (id == R.id.rate) {

            Intent i = new Intent(PrivacyActivity.this, RateActivity.class);
            startActivity(i);
        }
        else if (id == R.id.developers){
            Intent i = new Intent(PrivacyActivity.this, DevelopersActivity.class);
            startActivity(i);
        }
        else if (id == R.id.share) {

            Intent i = new Intent(PrivacyActivity.this, ShareActivity.class);
            startActivity(i);
        }
        else if (id == R.id.help){
            Intent i = new Intent(PrivacyActivity.this, HelpActivity.class);
            startActivity(i);
        }
        else if (id == R.id.ahout) {

            Intent i = new Intent(PrivacyActivity.this, AboutActivity.class);
            startActivity(i);
        }
        else if (id == R.id.privacy){
            Intent i = new Intent(PrivacyActivity.this, PrivacyActivity.class);
            startActivity(i);
        }
        else if (id == R.id.log_out) {

            Intent i = new Intent(PrivacyActivity.this, LogOutActivity.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
