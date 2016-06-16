package com.yanwanfu.jikeutils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yanwanfu.jikeutils.fragment.DBFragment;
import com.yanwanfu.jikeutils.fragment.HttpFragment;
import com.yanwanfu.jikeutils.fragment.ImageFragment;
import com.yanwanfu.jikeutils.fragment.InjectFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

// activity注入

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    // 控件注解
    @ViewInject(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        x.view().inject(this);

        // 设置adapter
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:
                        return new InjectFragment();
                    case 1:
                        return new HttpFragment();
                    case 2:
                        return new ImageFragment();
                    case 3:
                        return new DBFragment();
                }


                return null;
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position){
                    case 0:
                        return "注解模块";
                    case 1:
                        return "网络模块";
                    case 2:
                        return "图片模块";
                    case 3:
                        return "数据库模块";
                }

                return null;
            }
        });
    }
}
