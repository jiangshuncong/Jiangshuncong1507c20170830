package com.bwie.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import app.API;
import bean.BeanJson;
import bean.BeanMsg;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.lv_listview)
    ListView lv;
    private List<BeanMsg> list = new ArrayList<>();
    private final int a = 0;
    private final int b = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //加载控件
        x.view().inject(this);

        RequestParams params = new RequestParams(API.url);
        params.addBodyParameter("key",API.key);

        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //解析
                Gson gson = new Gson();
                BeanJson beanJson = gson.fromJson(result, BeanJson.class);
                List<BeanJson.Result.Data> data = beanJson.result.data;
                for (BeanJson.Result.Data data2:data
                     ) {
                    String title = data2.title;
                    String author_name = data2.author_name;
                    String date = data2.date;
                    String thumbnail_pic_s = data2.thumbnail_pic_s;

                    list.add(new BeanMsg(title,author_name,date,thumbnail_pic_s));

                    System.out.println("=========================="+thumbnail_pic_s);
                    System.out.println("=========================="+title);
                    System.out.println("=========================="+author_name);
                    System.out.println("=========================="+date);
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                lv.setAdapter(new MyAdapter());

            }
        });


    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public int getItemViewType(int position) {
            if(position%2 == 0){
                return a;
            }else{
                return b;
            }

        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder1 h1 = null;
            ViewHolder2 h2 = null;

            int type = getItemViewType(i);

            if(view == null){
                switch (type){
                    case a:
                        h1 = new ViewHolder1();
                        view = View.inflate(MainActivity.this,R.layout.item2,null);
                        h1.icon = view.findViewById(R.id.iv_icon2);
                        h1.title = view.findViewById(R.id.tv_title2);
                        h1.author = view.findViewById(R.id.tv_author2);
                        h1.date = view.findViewById(R.id.tv_date2);

                        view.setTag(h1);
                        break;

                    case  b:
                        h2 = new ViewHolder2();
                        view = View.inflate(MainActivity.this,R.layout.item1,null);
                        h2.icon2 = view.findViewById(R.id.iv_icon);
                        h2.title2 = view.findViewById(R.id.tv_msg);
                        h2.author2 = view.findViewById(R.id.tv_author);
                        h2.date2 = view.findViewById(R.id.tv_date);
                        view.setTag(h2);
                        break;

                }

            }else{
                switch (type){
                    case a:
                        h1 = (ViewHolder1) view.getTag();
                        ImageLoader.getInstance().displayImage(list.get(i).getThumbnail_pic_s(),h1.icon);
                    h1.title.setText(list.get(i).getTitle());
                    h1.author.setText(list.get(i).getAuthor_name());
                    h1.date.setText(list.get(i).getDate());

                    break;

                    case b:
                        h2 = (ViewHolder2) view.getTag();
                        ImageLoader.getInstance().displayImage(list.get(i).getThumbnail_pic_s(),h2.icon2);
                        h2.title2.setText(list.get(i).getTitle());
                        h2.author2.setText(list.get(i).getAuthor_name());
                        h2.date2.setText(list.get(i).getDate());

                        break;

                }
            }
            return view;
        }
    }

    public class ViewHolder1{
        ImageView icon;
        TextView title;
        TextView author;
        TextView date;
    }

    public class ViewHolder2{
        ImageView icon2;
        TextView title2;
        TextView author2;
        TextView date2;
    }


}
