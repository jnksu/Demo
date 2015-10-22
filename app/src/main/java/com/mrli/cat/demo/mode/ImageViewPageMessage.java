package com.mrli.cat.demo.mode;

/**
 * Created by MrLi on 2015/10/22.
 */
public class ImageViewPageMessage {
    //图片的url集合
    public final String[] urlList;
    //当前显示的图片
    public final int touchID;

    public ImageViewPageMessage(String[] urlList, int touchID) {
        this.urlList = urlList;
        this.touchID = touchID;
    }
}
