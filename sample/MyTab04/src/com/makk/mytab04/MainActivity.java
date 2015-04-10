package com.makk.mytab04;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.makk.mytab04.fragment.Fragment01;
import com.makk.mytab04.fragment.Fragment02;
import com.makk.mytab04.fragment.Fragment03;
import com.makk.mytab04.fragment.Fragment04;
import com.viewpagerindicator.TabPageIndicator;

public class MainActivity extends FragmentActivity {

	TabPageIndicator indicator;

	ViewPager vp;

	List<Fragment> list = new ArrayList<Fragment>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		vp = (ViewPager) findViewById(R.id.vp);
		indicator = (TabPageIndicator) findViewById(R.id.indicator);
		list.add(new Fragment01());
		list.add(new Fragment02());
		list.add(new Fragment03());
		list.add(new Fragment04());
		vp.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),
				list));

		indicator.setViewPager(vp,0);
	}

	class MyFragmentPagerAdapter extends FragmentPagerAdapter {
		List<Fragment> list;
		String[] names = { "生活", "新闻", "乐趣", "游泳" };

		public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
			super(fm);
			this.list = list;
		}

		@Override
		public Fragment getItem(int arg0) {
			return list.get(arg0);
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return names[position];
		}

	}
}
