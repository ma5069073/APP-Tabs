package com.makk.mytab02;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.makk.mytab02.fragment.Fragment01;
import com.makk.mytab02.fragment.Fragment02;
import com.makk.mytab02.fragment.Fragment03;
import com.makk.mytab02.fragment.Fragment04;

public class MainActivity extends FragmentActivity {

	RadioGroup main_radio;
	private Fragment01 f1;
	private Fragment02 f2;
	private Fragment03 f3;
	private Fragment04 f4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		main_radio = (RadioGroup) findViewById(R.id.main_radio);
		main_radio.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				FragmentManager fm = getSupportFragmentManager();
				FragmentTransaction ft = fm.beginTransaction();
				hide(ft);

				switch (checkedId) {
				case R.id.radio0:
					if (f1 == null) {
						f1 = new Fragment01();
						ft.add(R.id.content, f1);
					} else {
						ft.show(f1);
					}
					break;
				case R.id.radio1:
					if (f1 == null) {
						f2 = new Fragment02();
						ft.add(R.id.content, f2);
					} else {
						ft.show(f2);
					}
					break;
				case R.id.radio2:
					if (f1 == null) {
						f3 = new Fragment03();
						ft.add(R.id.content, f3);
					} else {
						ft.show(f3);
					}
					break;
				case R.id.radio3:
					if (f1 == null) {
						f4 = new Fragment04();
						ft.add(R.id.content, f4);
					} else {
						ft.show(f4);
					}
					break;

				default:
					break;
				}

				ft.commit();
				group.check(checkedId);
			}

			private void hide(FragmentTransaction ft) {
				if (f1 != null) {
					ft.hide(f1);
				}
				if (f2 != null) {
					ft.hide(f2);
				}
				if (f3 != null) {
					ft.hide(f3);
				}
				if (f4 != null) {
					ft.hide(f4);
				}
			}
		});
	}

}
