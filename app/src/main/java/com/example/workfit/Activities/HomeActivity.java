package com.example.workfit.Activities;

import android.graphics.Bitmap;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.workfit.Adapters.PageAdapters;
import com.example.workfit.Fragments.DiagramFragment;
import com.example.workfit.Fragments.StatisticFragment;
import com.example.workfit.workfitapps.R;

public class HomeActivity extends AppCompatActivity {

    private String iUsername, iWeight, iHeight, iGender;
    private Bitmap iAvatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /**Passing from register to here **/
        Bundle i = getIntent().getExtras();
        iUsername = i.getString("ID_USERNAME");
        iWeight = i.getString("ID_WEIGHT");
        iHeight = i.getString("ID_HEIGHT");
        iGender = i.getString("ID_GENDER");
        iAvatar = i.getParcelable("ID_PHOTO");

        /** Tab things **/
        TextView homeUsername = (TextView)findViewById(R.id.textView3);
        homeUsername.setText(iUsername);

        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewpager) {
        PageAdapters adapternya = new PageAdapters(getSupportFragmentManager());
        adapternya.addFragment(new StatisticFragment(), "Statistics");
        adapternya.addFragment(new DiagramFragment(), "Diagrams");
        viewpager.setAdapter(adapternya);
    }
}
