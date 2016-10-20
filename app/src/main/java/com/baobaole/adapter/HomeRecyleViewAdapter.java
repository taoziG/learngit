package com.baobaole.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baobaole.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by sumpay on 16/7/20.
 */
public class HomeRecyleViewAdapter extends RecyclerView.Adapter<HomeRecyleViewAdapter.MyViewHolder> {
    private static final int ITEM_VIEW_TYPE_HEADER = 0;
    private static final int ITEM_VIEW_TYPE_ITEM = 1;
    private List<String> nameList;

    private OnItemClickListener mOnItemClickListener;
    private Context mContext ;

    private LayoutInflater layoutInflater ;

    public HomeRecyleViewAdapter(List<String> nameList,Context mContext) {
        this.nameList = nameList;
        this.mContext = mContext ;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==ITEM_VIEW_TYPE_HEADER){
            View view = layoutInflater.inflate(R.layout.home_recyleview_head,parent,false);
            return new MyViewHolder(view);
        }
        View view = layoutInflater.inflate(R.layout.home_recycleview_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        if(isHead(position)){
            Uri uri = Uri.parse("http://pic.ecook.cn/web/17501179.jpg");
            holder.simpleDraweeView.setImageURI(uri);
            return;
        }
        holder.textView.setText(nameList.get(position-1));
        //判断是否设置了监听器
        if(mOnItemClickListener != null){
            //为ItemView设置监听器
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition(); // 1
                    mOnItemClickListener.onItemClick(holder.itemView,position); // 2
                }
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public int getItemCount() {
        return nameList.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        return isHead(position)?ITEM_VIEW_TYPE_HEADER:ITEM_VIEW_TYPE_ITEM;
    }

    public Boolean isHead(int position)
    {
        return position == 0;

    }

    class MyViewHolder extends HaeadHolder {

        private TextView textView ;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView =(TextView)itemView.findViewById(R.id.name_tv);

        }

    }

    class HaeadHolder extends  RecyclerView.ViewHolder {

        protected SimpleDraweeView simpleDraweeView ;
        public HaeadHolder(View itemView) {
            super(itemView);
            simpleDraweeView =(SimpleDraweeView) itemView.findViewById(R.id.my_image_view);
        }


    }

    private  void goNextActivity(Class nextActivity) {

        Intent intent = new Intent(mContext,nextActivity);
        mContext.startActivity(intent);
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

}
