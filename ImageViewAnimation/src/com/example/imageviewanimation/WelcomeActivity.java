package com.example.imageviewanimation;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class WelcomeActivity extends Activity
{

	private Context context = this;
	private ViewPager viewPager;
	private List<View> views = new ArrayList<View>();

	private boolean[] isCreated = new boolean[2];
	private ImageButton imageButton1;
	private ImageButton imageButton2;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);

		viewPager = (ViewPager) findViewById(R.id.pager);
		imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
		imageButton2 = (ImageButton) findViewById(R.id.imageButton2);

		LayoutInflater inflater = LayoutInflater.from(context);
		views.add(inflater.inflate(R.layout.page1, null));
		views.add(inflater.inflate(R.layout.page2, null));

		viewPager.setAdapter(new PagerAdapter()
		{

			@Override
			public boolean isViewFromObject(View arg0, Object arg1)
			{
				return arg0 == arg1;
			}

			@Override
			public int getCount()
			{
				return views.size();
			}

			@Override
			public CharSequence getPageTitle(int position)
			{
				return super.getPageTitle(position);
			}

			@Override
			public void destroyItem(View container, int position, Object object)
			{
				((ViewPager) container).removeView(views.get(position));
			}

			@Override
			public Object instantiateItem(View container, int position)
			{
				((ViewPager) container).addView(views.get(position));
				return views.get(position);
			}
		});

		viewPager.setOnPageChangeListener(new OnPageChangeListener()
		{

			@Override
			public void onPageSelected(int index)
			{
				showAnimation(index);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2)
			{
			}

			@Override
			public void onPageScrollStateChanged(int arg0)
			{
			}
		});

		showAnimation(0);
	}

	protected void showAnimation(final int index)
	{
		switch (index)
		{
		case 0:
			imageButton1.setImageDrawable(getResources().getDrawable(
					R.drawable.unread_icon_at));
			imageButton2.setImageDrawable(getResources().getDrawable(
					R.drawable.unread_icon_no_at));
			break;
		case 1:
			imageButton2.setImageDrawable(getResources().getDrawable(
					R.drawable.unread_icon_at));
			imageButton1.setImageDrawable(getResources().getDrawable(
					R.drawable.unread_icon_no_at));
			break;
		}

		if (isCreated[index])
			return;

		isCreated[index] = true;

		switch (index)
		{
		case 0:
			ImageView imageView1 = (ImageView) views.get(index).findViewById(
					R.id.imageView1);
			AlphaAnimation animation1 = new AlphaAnimation(0.1f, 1.0f);
			animation1.setDuration(800);
			imageView1.startAnimation(animation1);

			animation1.setAnimationListener(new AnimationListener()
			{

				@Override
				public void onAnimationStart(Animation animation)
				{
				}

				@Override
				public void onAnimationRepeat(Animation animation)
				{
				}

				@Override
				public void onAnimationEnd(Animation animation)
				{
					ImageView imageView2 = (ImageView) views.get(index)
							.findViewById(R.id.imageView2);
					imageView2.setVisibility(View.VISIBLE);
					AlphaAnimation animation2 = new AlphaAnimation(0.1f, 1.0f);
					animation2.setDuration(600);
					imageView2.startAnimation(animation2);
				}
			});
			break;
		case 1:
			ImageView imageView21 = (ImageView) views.get(index).findViewById(
					R.id.imageView1);
			AlphaAnimation animation21 = new AlphaAnimation(0.1f, 1.0f);
			animation21.setDuration(800);
			imageView21.startAnimation(animation21);

			animation21.setAnimationListener(new AnimationListener()
			{

				@Override
				public void onAnimationStart(Animation animation)
				{
				}

				@Override
				public void onAnimationRepeat(Animation animation)
				{
				}

				@Override
				public void onAnimationEnd(Animation animation)
				{
					ImageView imageView22 = (ImageView) views.get(index)
							.findViewById(R.id.imageView2);
					imageView22.setVisibility(View.VISIBLE);
					AlphaAnimation animation22 = new AlphaAnimation(0.1f, 1.0f);
					animation22.setDuration(600);
					imageView22.startAnimation(animation22);

					animation22.setAnimationListener(new AnimationListener()
					{

						@Override
						public void onAnimationStart(Animation animation)
						{
						}

						@Override
						public void onAnimationRepeat(Animation animation)
						{
						}

						@Override
						public void onAnimationEnd(Animation animation)
						{
							ImageView imageView23 = (ImageView) views
									.get(index).findViewById(R.id.imageView3);
							imageView23.setVisibility(View.VISIBLE);
							AlphaAnimation animation23 = new AlphaAnimation(
									0.1f, 1.0f);
							animation23.setDuration(600);
							imageView23.startAnimation(animation23);

							imageView23
									.setOnClickListener(new OnClickListener()
									{

										@Override
										public void onClick(View v)
										{
											startActivity(new Intent(context,
													MainActivity.class));
											finish();
										}
									});
						}
					});
				}
			});
			break;

		default:
			break;
		}

	}
}
