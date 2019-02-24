package com.example.android.reviews;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public static final String ANONYMOUS = "anonymous";
    private String mUsername;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    public static final int RC_SIGN_IN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        mUsername = ANONYMOUS;
        mFirebaseAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Toast.makeText(MainActivity.this, "You're now signed in. Welcome to FriendlyChat.", Toast.LENGTH_SHORT).show();
                } else {
                    // User is signed out
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setAvailableProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.GoogleBuilder().build(),
                                            new AuthUI.IdpConfig.EmailBuilder().build()))
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @NonNull Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN){
            if (resultCode == RESULT_OK){
                Toast.makeText(this, "Signed In", Toast.LENGTH_LONG).show();
            }else if (resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Signed In Canceled", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (mAuthStateListener != null){
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    private void onSignInInitialize(String username){
        mUsername = username;
    }

    private void onSignOutCleanup(){
        mUsername = ANONYMOUS;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {
            Intent i = new Intent(MainActivity.this, MainActivity.class);
            startActivity(i);
        }
        else if (id == R.id.profile){
            Intent i = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(i);
        }
        else if (id == R.id.notification) {

            Intent i = new Intent(MainActivity.this, NotificationActivity.class);
            startActivity(i);
        }
        else if (id == R.id.add_location){
            Intent i = new Intent(MainActivity.this, AddLocationActivity.class);
            startActivity(i);
        }
        else if (id == R.id.business_page) {

            Intent i = new Intent(MainActivity.this, BusinessBageActivity.class);
            startActivity(i);
        }
        else if (id == R.id.contact_us){
            Intent i = new Intent(MainActivity.this, ContactUsActivity.class);
            startActivity(i);
        }
        else if (id == R.id.rate) {

            Intent i = new Intent(MainActivity.this, RateActivity.class);
            startActivity(i);
        }
        else if (id == R.id.developers){
            Intent i = new Intent(MainActivity.this, DevelopersActivity.class);
            startActivity(i);
        }
        else if (id == R.id.share) {

            Intent i = new Intent(MainActivity.this, ShareActivity.class);
            startActivity(i);
        }
        else if (id == R.id.help){
            Intent i = new Intent(MainActivity.this, HelpActivity.class);
            startActivity(i);
        }
        else if (id == R.id.ahout) {

            Intent i = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(i);
        }
        else if (id == R.id.privacy){
            Intent i = new Intent(MainActivity.this, PrivacyActivity.class);
            startActivity(i);
        }
        else if (id == R.id.log_out) {

            Intent i = new Intent(MainActivity.this, LogOutActivity.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
