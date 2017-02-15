package com.wkq.recyclerviewcardview.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.wkq.recyclerviewcardview.MyApplication;
import com.wkq.recyclerviewcardview.R;


import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * 作者：WKQ
 * 时间:  2017/1/17 18:13
 * 用途: 图片加载框架
 * 备注: 目标实现 加载  本地图片 ,圆角图,项目图片,相机图片
 * <p>
 * with:传入对象 Context,Activity,Fragment，Glide与当前传入值的生命周期一致，
 * 在onPause方法，onResume 等方法中可适当控件Glide的状态。
 * Glide.with(mContext).onStop();
 * Glide.with(mContext).onDestroy();
 * Glide.with(mContext).pauseRequests();
 * Glide.with(mContext).resumeRequests();
 * load对象: String(文件路径，网络地址)，File(文件资源)，Integer(资源id)；
 * asGif:表示的gif动画，asBitmap：表示静态图
 * diskCacheStrategy磁盘缓存策略：
 * DiskCacheStrategy.RESULT:展示小大的图片缓存
 * DiskCacheStrategy.ALL; 展示在控件中大小图片尺寸和原图都会缓存
 * DiskCacheStrategy.NONE：不设置缓存
 * DiskCacheStrategy.SOURCE：原图缓存
 * override(300，300) 显示图片的width，height
 * placeholder(R.drawable.progressbar):目标从加载到展示时的控件的显示状态（多用网络加载动画）
 * error(R,drawable,error):加载失败时，控件显示的图片。
 * thumbnail ：缩略图显示传入值(0-1f)
 * transform: 图片圆角或圆形显示(继承 BitmapTransformation可行)
 * into(iv) 展示的控件
 * <p>
 * <p>
 * <p>
 * <p>
 * 加载资源的类型:
 * <p>
 * Uri uri;
 * String uriString;
 * File file;
 * Integer resourceId;
 * byte[] model;
 * String model;
 */

public class GlideUtils {
    static GlideUtils instance;
    static Context mContext;

    public GlideUtils() {

        mContext = MyApplication.getMainContext();
    }

    /**
     * 获取Glide 的实例
     *
     * @return
     */
    public static GlideUtils getInstance() {
        mContext = MyApplication.getMainContext();
        if (instance == null) {
            instance = new GlideUtils();
        }
        return instance;
    }

    public void loadCircleImageViewFromService(String url, ImageView view) {

        Glide.with(mContext)
                .load(url)
                .placeholder(R.drawable.zhanwei)//占位图
                .error(R.drawable.erro)//加载失败图
                .animate(android.R.anim.slide_in_left)
                .diskCacheStrategy(DiskCacheStrategy.RESULT) //设置压缩后缓存
                .bitmapTransform(new CropCircleTransformation(mContext)) //使用圆形变换，还可以使用其他的变换
                .into(view);

    }

    /**
     * 加载网络图片
     *
     * @param url  图片地址
     * @param view 加载图片ImageView
     */
    public void loadImageViewFromURL(String url, ImageView view) {
        Glide.with(mContext).load(url)

                .error(R.drawable.erro)//加载失败图
                .animate(R.anim.scale)//图片展示动画
                .diskCacheStrategy(DiskCacheStrategy.RESULT) //设置压缩后缓存
//                .bitmapTransform(new CropCircleTransformation(mContext))//圆角图
                .into(view);
    }

    /**
     * @param url  图片地址
     * @param view 填充的空间
     * @param kuan 宽
     * @param gao  高
     */
    public void loadImageViewOnYouSetFromURL(String url, ImageView view, int kuan, int gao) {
        Glide.with(mContext).load(url).asBitmap().override(kuan, gao).error(R.drawable.erro)//加载失败图
                .animate(R.anim.scale)//图片展示动画
                .diskCacheStrategy(DiskCacheStrategy.RESULT).into(view);
    }


    public void loadIVCircle(String url, ImageView view) {
        Glide.with(mContext).load(url)
//                .override(700, 400)   设置图片加载的大小
//                .placeholder(R.drawable.zhanwei)//占位图  占位图的大小会影响控件显示的大小
                .error(R.drawable.erro)//加载失败图
                .animate(R.anim.scale)//图片展示动画
                .diskCacheStrategy(DiskCacheStrategy.RESULT) //设置压缩后缓存
                .bitmapTransform(new CropCircleTransformation(mContext))//圆角图
                .into(view);
    }

}
