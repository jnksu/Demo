package com.mrli.cat.demo.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by MrLi on 2015/10/22.
 */
public class ImageViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private final String[] mDataSet;

    public ImageViewPagerAdapter(String[] mDataSet, Context context) {
        this.mDataSet = mDataSet;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mDataSet.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(mContext);
        simpleDraweeView.setImageURI(Uri.parse(mDataSet[position]));
        ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
        layoutParams.width = ViewPager.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewPager.LayoutParams.MATCH_PARENT;
        layoutParams.gravity = Gravity.CENTER;
        container.addView(simpleDraweeView, layoutParams);
        return simpleDraweeView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
