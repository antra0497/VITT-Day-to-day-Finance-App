package com.finance.personal.vitt;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import static com.finance.personal.vitt.LoginActivity.mAuth;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String userEmail;
    FirebaseUser currentUser;
    DocumentReference db;

    NavigationView navigationView = null;
    Toolbar toolbar = null;
    Fragment fragment= null;
    FloatingActionButton addexpense;
    CardView cd;
    TextView totA,limA,leftA,datetime, tot,lim,left;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        currentUser = mAuth.getCurrentUser();
        userEmail = currentUser.getEmail();
        db = FirebaseFirestore.getInstance().collection("UserData").document(userEmail);

        addexpense=(FloatingActionButton)findViewById(R.id.floatingadd);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Home Page");
        setSupportActionBar(toolbar);


        totA=(TextView)findViewById(R.id.amttotal);
        limA=(TextView)findViewById(R.id.amtlimit);
        leftA=(TextView)findViewById(R.id.amtleft);
        tot=(TextView)findViewById(R.id.total);
        lim=(TextView)findViewById(R.id.limit);
        left=(TextView)findViewById(R.id.left);
        datetime=(TextView)findViewById(R.id.dttext);


       // Date currentTime = Calendar.getInstance().getTime();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();

            db.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                    if (documentSnapshot.exists()) {
                        String budget = (String) documentSnapshot.get("Total_budget");
                        String limit = (String) documentSnapshot.get("Limit_budget");
//                        String mAge = (String) documentSnapshot.get("age");
//                        String mAddress = (String) documentSnapshot.get("address");

                        totA.setText(budget);
                        limA.setText(limit);
                    }
                }
            });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            fragment= new Notification();
            toolbar.setTitle("Notifications");
            addexpense.hide();
        }

        return super.onOptionsItemSelected(item);
    }

    FragmentManager fragmentManager;

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.nav_camera)
        {
            // Handle the camera action
            fragment= new ReportAnalysis();
            toolbar.setTitle("Report Analysis");
            addexpense.hide();
            datetime.setVisibility(View.INVISIBLE);
            totA.setVisibility(View.INVISIBLE);
            limA.setVisibility(View.INVISIBLE);
            leftA.setVisibility(View.INVISIBLE);
            datetime.setVisibility(View.INVISIBLE);
            tot.setVisibility(View.INVISIBLE);
            lim.setVisibility(View.INVISIBLE);
            left.setVisibility(View.INVISIBLE);

        }
        else if (id == R.id.nav_gallery)
        {
           fragment= new TakeNotes();
            toolbar.setTitle("Take Notes");
            addexpense.hide();
            datetime.setVisibility(View.INVISIBLE);
            totA.setVisibility(View.INVISIBLE);
            limA.setVisibility(View.INVISIBLE);
            leftA.setVisibility(View.INVISIBLE);
            datetime.setVisibility(View.INVISIBLE);
            tot.setVisibility(View.INVISIBLE);
            lim.setVisibility(View.INVISIBLE);
            left.setVisibility(View.INVISIBLE);

        }
        else if (id == R.id.nav_slideshow)
        {
            fragment= new Signout();
            toolbar.setTitle("Signout");
            addexpense.hide();
            datetime.setVisibility(View.INVISIBLE);
            totA.setVisibility(View.INVISIBLE);
            limA.setVisibility(View.INVISIBLE);
            leftA.setVisibility(View.INVISIBLE);
            datetime.setVisibility(View.INVISIBLE);
            tot.setVisibility(View.INVISIBLE);
            lim.setVisibility(View.INVISIBLE);
            left.setVisibility(View.INVISIBLE);

        }
        else if (id == R.id.nav_share)
        {
            fragment= new AboutUs();
            toolbar.setTitle("About Us ");
            addexpense.hide();
            datetime.setVisibility(View.INVISIBLE);
            totA.setVisibility(View.INVISIBLE);
            limA.setVisibility(View.INVISIBLE);
            leftA.setVisibility(View.INVISIBLE);
            datetime.setVisibility(View.INVISIBLE);
            tot.setVisibility(View.INVISIBLE);
            lim.setVisibility(View.INVISIBLE);
            left.setVisibility(View.INVISIBLE);
        }
        else if (id == R.id.nav_send)
        {
            fragment= new Feedback();
            toolbar.setTitle("Feedback");
            addexpense.hide();
            datetime.setVisibility(View.INVISIBLE);
            totA.setVisibility(View.INVISIBLE);
            limA.setVisibility(View.INVISIBLE);
            leftA.setVisibility(View.INVISIBLE);
            datetime.setVisibility(View.INVISIBLE);
            tot.setVisibility(View.INVISIBLE);
            lim.setVisibility(View.INVISIBLE);
            left.setVisibility(View.INVISIBLE);
        }

        if (fragment != null) {
            fragmentManager= getSupportFragmentManager();
            FragmentTransaction ft= fragmentManager.beginTransaction();
            ft.replace(R.id.content_fragment,fragment);
            ft.commit();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
