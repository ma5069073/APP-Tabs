package com.makk.mytab03;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.makk.mytab03.fragment.Fragment01;
import com.makk.mytab03.fragment.Fragment02;
import com.makk.mytab03.fragment.Fragment03;
import com.makk.mytab03.fragment.Fragment04;

public class MainActivity extends ActionBarActivity {
	RadioGroup main_radio;
	ViewPager vp;
	List<Fragment> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		main_radio = (RadioGroup) findViewById(R.id.main_radio);
		vp = (ViewPager) findViewById(R.id.vp);

		list = new ArrayList<Fragment>();
		list.add(new Fragment01());
		list.add(new Fragment02());
		list.add(new Fragment03());
		list.add(new Fragment04());

		FragmentManager fm = getSupportFragmentManager();
		FragmentPagerAdapter fpa = new MyFragmentPagerAdapter(fm,list);

		vp.setAdapter(fpa);
		vp.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				RadioButton rg  = (RadioButton) main_radio.getChildAt(arg0);
				rg.setChecked(true);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});

		main_radio.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.radio0:
					vp.setCurrentItem(0);
					break;
				case R.id.radio1:
					vp.setCurrentItem(1);
					break;
				case R.id.radio2:
					vp.setCurrentItem(2);
					break;
				case R.id.radio3:
					vp.setCurrentItem(3);
					break;

				default:
					break;
				}
			}
		});
	}

	class MyFragmentPagerAdapter extends FragmentPagerAdapter {
		List<Fragment> list;
		public MyFragmentPagerAdapter(FragmentManager fm,List<Fragment> list) {
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

	}
}
