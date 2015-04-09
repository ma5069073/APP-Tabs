package com.mkk.mytab01;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	ViewPager vp;
	RadioGroup main_radio;

	String[] names = { "111", "222", "333", "444" };
	List<TextView> list = new ArrayList<TextView>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		vp = (ViewPager) findViewById(R.id.vp);
		vp.setAdapter(new MyPageAdapter());

		vp.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				int i = vp.getCurrentItem();
				RadioButton rg  = (RadioButton) main_radio.getChildAt(i);
				rg.setChecked(true);
				
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});

		main_radio = (RadioGroup) findViewById(R.id.main_radio);
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

				group.check(checkedId);
			}
		});
	}

	class MyPageAdapter extends PagerAdapter {

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			TextView tv = new TextView(MainActivity.this);
			tv.setText(names[position]);
			LayoutParams params = new LayoutParams(100, 100);

			((ViewPager) container).addView(tv, params);
			list.add(tv);

			return tv;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {

			((ViewPager) container).removeViewAt(position);
			list.remove(position);
		}

		@Override
		public int getCount() {
			return names.length;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

	}

	@Override
	public void onClick(View v) {

	}
}
