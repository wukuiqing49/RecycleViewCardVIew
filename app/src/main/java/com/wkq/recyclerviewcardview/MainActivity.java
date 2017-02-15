package com.wkq.recyclerviewcardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.wkq.recyclerviewcardview.utils.L;
import com.wkq.recyclerviewcardview.utils.ToastSingle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    List<DetailInfo> listInfo = new ArrayList<>();
    String[] names = {"邓紫棋", "范冰冰", "杨幂", "Angelababy", "唐嫣", "柳岩", "邓紫棋", "范冰冰", "杨幂", "Angelababy", "唐嫣"};
    String[] imgUrs = {"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=673651839,1464649612&fm=111&gp=0.jpg",
            "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1477122795&di=f740bd484870f9bcb0cafe454a6465a2&src=http://tpic.home.news.cn/xhCloudNewsPic/xhpic1501/M08/28/06/wKhTlVfs1h2EBoQfAAAAAF479OI749.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=673651839,1464649612&fm=111&gp=0.jpg",
            "https://ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=fd90a83e900a304e4d22a7fae1c9a7c3/d01373f082025aafa480a2f1fcedab64034f1a5d.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1849074283,1272897972&fm=111&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=673651839,1464649612&fm=111&gp=0.jpg",
            "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1477122795&di=f740bd484870f9bcb0cafe454a6465a2&src=http://tpic.home.news.cn/xhCloudNewsPic/xhpic1501/M08/28/06/wKhTlVfs1h2EBoQfAAAAAF479OI749.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=673651839,1464649612&fm=111&gp=0.jpg",
            "https://ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=fd90a83e900a304e4d22a7fae1c9a7c3/d01373f082025aafa480a2f1fcedab64034f1a5d.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1849074283,1272897972&fm=111&gp=0.jpg",
            "https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=005560fc8b5494ee982208191df4e0e1/c2fdfc039245d68827b453e7a3c27d1ed21b243b.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();


    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        // 当确定List内容（数据）的变化不会影响RecycleView布局的大小时，以下设置可以提高性能
        recyclerView.setHasFixedSize(true);

        // 使用不规则的网格布局
        StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);//两列，纵向排列
        recyclerView.setLayoutManager(mLayoutManager);
        final MyRecycleAdapter myAdapter = new MyRecycleAdapter(this, listInfo);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new MyRecycleAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, DetailInfo data) {
                ToastSingle.showToast(getApplicationContext(), data.getText());
                data.setText("刷新了Text");
                myAdapter.notifyItemChanged(data.getPosition());
                L.e("数据:"+data.getText());
            }
        });


        myAdapter.notifyDataSetChanged();
    }

    private void initData() {
        DetailInfo detail;
        for (int i = 0; i < names.length; i++) {
            detail = new DetailInfo();
            detail.setText(names[i]);
            detail.setUrl(imgUrs[i]);
            detail.setPosition(i);
            listInfo.add(detail);
        }


    }
}
