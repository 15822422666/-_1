package com.d.homepage;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

private DrawerLayout mDrawerLayout;
private ViewPager viewPager;
private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout =(DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.personal);
        }
    }
    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        viewPager = findViewById(R.id.main_viewpager);
        tabLayout = findViewById(R.id.main_tablayout);
        final TextView toolbarTitle = findViewById(R.id.tool_bar_title);
        toolbarTitle.setText("碎片1标题");
        toolbarTitle.setText("碎片2标题");
        toolbarTitle.setText("碎片3标题");
        toolbarTitle.setText("碎片4标题");
        final String[] toolbarTitles = {"碎片1标题","碎片2标题","碎片3标题","碎片4标题"};
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                toolbarTitle.setText(toolbarTitles[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void initData(){
        List<Fragment> fragments = new ArrayList<>();  //创建四个碎片
        fragments.add(new MyFragment1());
        fragments.add(new MyFragment2());
        fragments.add(new MyFragment3());
        fragments.add(new MyFragment4());
        String[] tabTitles = {"选项卡1", "选项卡2", "选项卡3", "选项卡4"};  //创建四个选项卡标签的标题

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments, tabTitles);
        viewPager.setAdapter(adapter);  //设置ViewPager的适配器
        tabLayout.setupWithViewPager(viewPager);  //组合ViewPager和TabLayout
        tabLayout.getTabAt(0).select();  //这是设置打开第几个选项卡，不设置就会默认打开第一个

    }
    class MyFragmentPagerAdapter extends FragmentPagerAdapter{
        private List<Fragment> fragments;
        private String[] titles;
        public MyFragmentPagerAdapter(FragmentManager fm,List<Fragment> fragments,String[] titles){
            super(fm);
            this.fragments = fragments;
            this.titles = titles;
        }
        public Fragment getItem(int position){
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
        public CharSequence getPageTitle(int position){
            return titles[position];
        }
    }
    public static class MyFragment1 extends Fragment{
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle saveInstanceState){
            View view = inflater.inflate(R.layout.fragment_layout_1,container,false);
            return view;
        }

    }
    public static class MyFragment2 extends Fragment{
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle saveInstanceState){
            View view = inflater.inflate(R.layout.fragment_layout_2,container,false);
            return view;
        }

    }
    public static class MyFragment3 extends Fragment{
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle saveInstanceState){
            View view = inflater.inflate(R.layout.fragment_layout_3,container,false);
            return view;
        }

    }
    public static class MyFragment4 extends Fragment{
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle saveInstanceState){
            View view = inflater.inflate(R.layout.fragment_layout_4,container,false);
            return view;
        }

    }



    /*public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }*/

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
           /* case R.id.add:
                Toast.makeText(this,"You clicked Backup",Toast.LENGTH_SHORT).show();
                break;*/
                default:
        }
        return true;
}

}
