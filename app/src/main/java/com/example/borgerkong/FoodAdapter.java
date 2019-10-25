package com.example.borgerkong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    private List<Food> mList;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public FoodAdapter(Context mContext, List<Food> mList){
        this.mContext = mContext;
        this.mList = mList;
    }

    public void removeData(int position){
        mList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Food food = mList.get(position);
        holder.tv.setText(food.getName());
        holder.img.setImageResource(food.getRid());
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mOnItemClickListener != null){
                    mOnItemClickListener.onItemClick(view, (int)view.getTag());
                }
            }
        });
    }

    public int getItemCount(){
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        ImageView img;
        public MyViewHolder(View view){
            super(view);
            tv = (TextView)view.findViewById(R.id.tv_name);
            img = (ImageView)view.findViewById(R.id.img);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

}
