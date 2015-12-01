package com.appdevzhang.wechattab.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;

import com.appdevzhang.wechattab.R;
import com.appdevzhang.wechattab.ui.fragment.NewsFragment;
import com.appdevzhang.wechattab.ui.fragment.NewsFragmentTwo;
import com.appdevzhang.wechattab.ui.view.PagerSlidingTabStrip;

/**
 * @ClassName:
 * @Description:
 * @author: appdevzhang
 * @email: 1160030655@qq.com
 * @date: 15/11/26 下午4:58
 */
public class HomeActivity extends FragmentActivity{

    /**
     * 新闻界面的Fragment
     */
    private NewsFragment mNewsFragment;
    private NewsFragmentTwo mNewsFragmentTwo;

    /**
     * PagerSlidingTabStrip的实例
     */
    private PagerSlidingTabStrip mPagerSlidingTabStrip;

    /**
     * 获取当前屏幕的密度
     */
    private DisplayMetrics dm;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        dm = getResources().getDisplayMetrics();
        mViewPager = (ViewPager) findViewById(R.id.vp_pager);
        mPagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.psts_tabs);

        mViewPager.setAdapter(new NewsPagerAdapter(getSupportFragmentManager()));
        mPagerSlidingTabStrip.setViewPager(mViewPager);
        setTabsValue();

        mViewPager.setCurrentItem(1);

    }
    /**
     * 对PagerSlidingTabStrip的各项属性进行赋值。
     */
    private void setTabsValue() {
        // 设置Tab是自动填充满屏幕的
//		tabs.setShouldExpand(false);
        // 设置Tab的分割线是透明的
        mPagerSlidingTabStrip.setDividerColor(Color.TRANSPARENT);
//		tabs.setDividerColor(Color.BLACK);
        // 设置Tab底部线的高度
        mPagerSlidingTabStrip.setUnderlineHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, dm));
        // 设置Tab Indicator的高度
        mPagerSlidingTabStrip.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, dm));
        // 设置Tab标题文字的大小
        mPagerSlidingTabStrip.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, dm));
        // 设置Tab Indicator的颜色
        mPagerSlidingTabStrip.setIndicatorColor(Color.parseColor("#ff0000"));
        mPagerSlidingTabStrip.setSelectedTextColor(Color.parseColor("#ff0000"));
        // 设置选中Tab文字的颜色 (这是我自定义的一个方法)
//        mPagerSlidingTabStrip.setSelectedTextColor(Color.parseColor("#45c01a"));
        //设置正常Tab文字的颜色
//        mPagerSlidingTabStrip.setTextColor(Color.parseColor("#C231C7"));
        // 取消点击Tab时的背景色
        mPagerSlidingTabStrip.setTabBackground(0);
    }

    public class NewsPagerAdapter extends FragmentPagerAdapter {

        public NewsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        private final String[] titles = { "要闻", "科技","南方新闻", "军事", "南方知道", "自贸区","粤政一周" };

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // TODO Auto-generated method stub
            return super.instantiateItem(container, position);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if (mNewsFragment == null) {
                        mNewsFragment = new NewsFragment();
                    }
                    return mNewsFragment;
                case 1:
                    if (mNewsFragmentTwo == null) {
                        mNewsFragmentTwo = new NewsFragmentTwo();
                    }
                    return mNewsFragmentTwo;

                default:
                    return new NewsFragment();
            }

        }

    }
}
