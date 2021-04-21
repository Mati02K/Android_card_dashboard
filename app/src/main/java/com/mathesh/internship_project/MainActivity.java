package com.mathesh.internship_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav = (NavigationView) findViewById(R.id.navmenu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_home:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_call:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_setting:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

                return true;
            }
        });

        TextView tellmore = (TextView) findViewById(R.id.tellmore);
        tellmore.setPaintFlags(tellmore.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tellmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textinfo = (TextView) findViewById(R.id.info);
                textinfo.setVisibility( textinfo.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });

        VideoView v = (VideoView) findViewById(R.id.youtube_video);

        v.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.unicef_kids);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(v);
        v.setMediaController(mediaController);



    }
}