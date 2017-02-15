package com.wkq.recyclerviewcardview;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wkq.recyclerviewcardview.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ================================================
 * 作者：WKQ
 * 时间:  2017/2/15 12:25
 * 用途: RecycleViewAdapter
 * 备注:
 * <p>
 * ================================================
 */

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.ViewHolder> implements View.OnClickListener {
    Context context;
    List<DetailInfo> listInfo = new ArrayList<>();//数据来源
    private OnRecyclerViewItemClickListener mOnItemClickListener;

    //构造传递参数
    public MyRecycleAdapter(Context context, List<DetailInfo> listInfo) {
        this.context = context;
        this.listInfo = listInfo;

    }

    //加载布局
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        ViewHolder vh = new ViewHolder(view);
        //为item添加的点击事件
        view.setOnClickListener(this);


        return vh;
    }


    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v, (DetailInfo) v.getTag());
        }

    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    //绑定数据
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.username.setText(listInfo.get(position).getText());
        GlideUtils.getInstance().loadImageViewFromURL(listInfo.get(position).getUrl(), holder.image);
        holder.itemView.setTag(listInfo.get(position));

    }

    //条目数量
    @Override
    public int getItemCount() {
        return listInfo.size();
    }


    //定义自己的ViewHolder，将View的控件引用在成员变量上
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView username;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            username = (TextView) itemView.findViewById(R.id.tv_userName);
            image = (ImageView) itemView.findViewById(R.id.image);

        }
    }

    //定义item监听的接口
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, DetailInfo data);
    }
}
