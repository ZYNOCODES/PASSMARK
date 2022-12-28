package com.example.passmark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new InfoDepartmentFragment()).commit();
            navigationView.setCheckedItem(R.id.menuinformatique);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuinformatique:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new InfoDepartmentFragment()).commit();
                Toast.makeText(this, "Informatique Departement", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menumathematique:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MathDepartmentFragment()).commit();
                Toast.makeText(this, "Coming Soon!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuelectronique:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ElectronicFragment()).commit();
                Toast.makeText(this, "Coming Soon!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuchimie:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChimieFragment()).commit();
                Toast.makeText(this, "Coming Soon!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuphysique:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PhysiqueFragment()).commit();
                Toast.makeText(this, "Coming Soon!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menumecanique:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MecaniqueFragment()).commit();
                Toast.makeText(this, "Coming Soon!", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
