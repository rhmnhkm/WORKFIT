package com.example.workfit.Activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.workfit.Adapters.PageAdapters;
import com.example.workfit.Fragments.DiagramFragment;
import com.example.workfit.Fragments.StatisticFragment;
import com.example.workfit.workfitapps.R;
import com.pkmmte.view.CircularImageView;

public class HomeActivity extends AppCompatActivity {

    private String iUsername, iWeight, iHeight, iGender;
    private Bitmap iAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /**Passing from register to here **/
        Bundle i = getIntent().getBundleExtra("Bundle");
        if(i!=null) {
            iUsername = i.getString("USERNAME");
            if (iUsername.contains(" ")){
                iUsername = iUsername.substring(0, iUsername.indexOf(" "));
            }
            iWeight = i.getString("WEIGHT");
            iHeight = i.getString("HEIGHT");
            iGender = i.getString("GENDER");

            byte[] bytes = i.getByteArray("BMP");
            iAvatar = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            
        } else Toast.makeText(this, "Bundle Intent is empty", Toast.LENGTH_LONG).show();

        TextView homeUsername = (TextView)findViewById(R.id.textView3);
        homeUsername.setText(iUsername);

        CircularImageView profileHome = (CircularImageView)findViewById(R.id.profilePictureHome);
        profileHome.setImageBitmap(iAvatar);

        /** Tab things **/
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
