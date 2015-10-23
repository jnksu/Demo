package com.mrli.cat.demo;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mrli.cat.demo.adapter.ImageViewPagerAdapter;
import com.mrli.cat.demo.mode.ImageViewPageMessage;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * Created by MrLi on 2015/10/22.
 * 多图浏览
 */
public class ImageViewPagerActivity extends AppCompatActivity {

    @Bind(R.id.image_page_vp)
    ViewPager mImagePageVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpage);
        ButterKnife.bind(this);
        EventBus.getDefault().registerSticky(this);
        mImagePageVp.setPageMargin((int) getResources().getDisplayMetrics().density * 15);
    }

    //接收图片事件
    public void onEventMainThread(ImageViewPageMessage message) {
        //初始化Adapter
        ImageViewPagerAdapter adapter = new ImageViewPagerAdapter(message.urlList, this);
        mImagePageVp.setAdapter(adapter);
        mImagePageVp.setCurrentItem(message.touchID);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    public static class pagerAdapter extends PagerAdapter {

        public pagerAdapter() {

        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return false;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return null;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }
    }
}
