package com.example.androidapplication;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class SearchActivity extends AppCompatActivity {

    private  RecyclerView mRecyclerView;
    private  SearchAdapter mSearchAdapter = new SearchAdapter();
    private SearchView mSearchView;
//    private ListView mListview;

    public List<String>filter(List<String> LS,String text){//筛选含有特定字符的字符串
        List<String> filterString=new ArrayList<>();

        for (String word:LS){
            if (word.contains(text))
                filterString.add(word);
        }
        return filterString;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mSearchView=(SearchView)findViewById(R.id.search_view);
//        mListview=(ListView) findViewById(R.id.rv);
        mRecyclerView=findViewById(R.id.rv);//通过id找到XML里的RecycleView
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//设置item的布局，这里是线性布局，每行一个
        mRecyclerView.setAdapter(mSearchAdapter);//给RecycleView设置适配器

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {// 当点击搜索按钮时触发该方法
                return false;
            }

            @Override
            public boolean onQueryTextChange(String NewText) {// 当搜索内容改变时触发该方法
//                if(!TextUtils.isEmpty(NewText)) {
//                    items = filter(items, NewText);
//                }
//                else{
//                    items.clear();
//                }
                return false;
            }
        });
        List<String> items = new ArrayList<>();
        for(int i=0;i<100;i++) {
            items.add("这是第" + String.valueOf(i) + "行");
        }
        mSearchAdapter.notifyItems(items);
    }
}

//RecyclerView中Adapter和ViewHolder的封装，分为ViewHolder与Adapter两部分
class TextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView mTextView;

    public TextViewHolder(@NonNull View itemView){
        super(itemView);
        mTextView=itemView.findViewById(R.id.text);
        itemView.setOnClickListener(this);
    }

    public void bind(String text){mTextView.setText(text);}

    @Override
    public void onClick(View v){
        Intent intent = new Intent(v.getContext(),MyActivity.class);//MyActivity
        intent.putExtra("extra",mTextView.getText().toString());//getText()获得item的内容信息，并转化为字符串形式
        v.getContext().startActivity(intent);//向目标活动发送信息
    }
}
class SearchAdapter extends RecyclerView.Adapter<TextViewHolder>{
    @NonNull
    private List<String> mItems = new ArrayList<>();

    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){//将XML与适配器连接起来
        return new TextViewHolder(LayoutInflater.from(parent.getContext())//LayoutInflater能解析XML并转化为View
                .inflate(R.layout.layout_text,parent,false));
    }//返回一个ViewHolder

    @Override
    public void onBindViewHolder(@NonNull TextViewHolder holder,int position){
        holder.bind(mItems.get(position));
    }//绑定ViewHolder

    @Override
    public int getItemCount(){return mItems.size();}//获取列表长度

    public void notifyItems(@NonNull List<String> items){
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }
}