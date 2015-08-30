package com.agoodkissapp.mvpdaggertesting;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.agoodkissapp.mvpdaggertesting.Login.LoginPresenter;
import com.agoodkissapp.mvpdaggertesting.Login.LoginView;
import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    public static String TAG = "MainActivity";
    private ViewPagerAdapter mViewPagerAdapter;
    private CharSequence Titles[]={"Home","Movies", "Contacts"};
    private int Numboftabs =3;


    @Bind(R.id.pager) ViewPager mViewPager;

    @Bind(R.id.tool_bar) Toolbar mToolbar;

    @Bind(R.id.tabs) SlidingTabLayout mTabs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        setSupportActionBar(mToolbar);

        getDelegate().getSupportActionBar().setDisplayShowHomeEnabled(true);
        getDelegate().getSupportActionBar().setTitle("Resume App");


        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        mViewPagerAdapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and setting the adapter
        mViewPager.setAdapter(mViewPagerAdapter);

        // Assiging the Sliding Tab Layout View
        mTabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        mTabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        mTabs.setViewPager(mViewPager);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
