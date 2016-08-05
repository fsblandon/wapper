package com.fsblandon.wapper.vista;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.fsblandon.wapper.R;
import com.fsblandon.wapper.modelo.Empresa;
import com.fsblandon.wapper.presentador.UsuarioLogin;
import com.fsblandon.wapper.vista.SlidingTab.SlidingTabLayout;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Home extends ActionBarActivity {

    //private List<Empresa> lsEmpresas = new ArrayList<>();

    private static String[] titles = {"Bills", "Invoices", "Wapps"};
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    public static final String key = "POS";
    private int item_pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        item_pos = getIntent().getIntExtra(key,0);
        getSupportActionBar().setElevation(0);
        setContentView(R.layout.activity_home);

        mViewPager = (ViewPager) findViewById(R.id.visor_fragments);
        mViewPager.setAdapter(new AppSectionsPagerAdapter(getSupportFragmentManager(), item_pos));

        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setCustomTabView(R.layout.tab_indicator,android.R.id.text1);
        setSlidingTabLayoutContentDescriptions();
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setViewPager(mViewPager);


        mSlidingTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setSlidingTabLayoutContentDescriptions() {
        for (int i = 0; i < titles.length; i++) {
            mSlidingTabLayout.setContentDescription(i, titles[i]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    static class AppSectionsPagerAdapter extends FragmentStatePagerAdapter{
        Bundle bundle;


        public AppSectionsPagerAdapter(FragmentManager fm, int pos) {
            super(fm);
            bundle = new Bundle();
            bundle.putInt(key,pos);
        }


        @Override
        public Fragment getItem(int position) {
            Fragment frag;
            switch (position){
                case 0:
                    frag = new Bills();
                    break;
                case 1:
                    frag = new Invoices();
                    break;
                case 2:
                    frag = new Wapps();
                    break;
                default:
                    frag = new Bills();
                    break;
            }
            frag.setArguments(bundle);
            return frag;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }



}
