package com.mrli.cat.demo.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mrli.cat.demo.config.Image;
import com.mrli.cat.demo.mode.ImageViewPageMessage;
import com.mrli.cat.demo.ImageViewPagerActivity;
import com.mrli.cat.demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * Created by MrLi on 2015/10/21.
 */
public class IndexAdapter extends RecyclerView.Adapter<IndexAdapter.ViewHolder> {
    private Context mContext;

    //传递上下文环境, 初始化数据集
    public IndexAdapter(Context context) {
        this.mContext = context;
    }

    //创建ViewHolder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.index_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    //绑定数据到ViewHolder
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        buildMultiPic(holder.indexListItemContentPicMulti);
        Uri uri = Uri.parse("https://raw.githubusercontent.com/facebook/fresco/gh-pages/static/fresco-logo.png");
        holder.indexListItemAvatar.setImageURI(uri);
    }

    //显示条目的数量
    @Override
    public int getItemCount() {
        return 100;
    }


    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'index_list_item.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.index_list_item_avatar)
        SimpleDraweeView indexListItemAvatar;
        @Bind(R.id.index_list_item_head)
        TextView indexListItemHead;
        @Bind(R.id.index_list_item_subhead)
        TextView indexListItemSubhead;
        @Bind(R.id.index_list_item_content_tv)
        TextView indexListItemContentTv;
        @Bind(R.id.index_list_item_content_pic_multi)
        GridLayout indexListItemContentPicMulti;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    protected void buildMultiPic(final GridLayout gridLayout) {
        gridLayout.setVisibility(View.VISIBLE);
        for (int i = 0; i < 9; i++) {
            final SimpleDraweeView pic = (SimpleDraweeView) gridLayout.getChildAt(i);
            GenericDraweeHierarchy genericDraweeHierarchy = pic.getHierarchy();
            Uri uri = Uri.parse(Image.imageThumbUrls[i]);
            final ImageViewPageMessage message = new ImageViewPageMessage(Image.imageThumbUrls, i);
            pic.setImageURI(uri);
            pic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventBus.getDefault().postSticky(message);
                    Intent intent = new Intent(mContext, ImageViewPagerActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
