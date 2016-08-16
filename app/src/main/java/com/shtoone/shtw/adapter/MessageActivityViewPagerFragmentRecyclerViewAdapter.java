package com.shtoone.shtw.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shtoone.shtw.R;

import java.util.List;
import java.util.Map;

public class MessageActivityViewPagerFragmentRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = MessageActivityViewPagerFragmentRecyclerViewAdapter.class.getSimpleName();
    private Context context;
    private OnItemClickListener mOnItemClickListener;
    private List<Map<String, Object>> data;

    public enum ITEM_TYPE {
        TYPE_ITEM, TYPE_FOOTER
    }

    public MessageActivityViewPagerFragmentRecyclerViewAdapter(Context context, List<Map<String, Object>> data) {
        super();
        this.context = context;
        this.data = data;
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public int getItemCount() {

        if (data.size() > 5) {
            return data.size() + 1;
        } else {
            return data.size();
        }

    }

    @Override
    public int getItemViewType(int position) {

        if (getItemCount() > 5 && position + 1 == getItemCount()) {

            return ITEM_TYPE.TYPE_FOOTER.ordinal();
        } else {
            return ITEM_TYPE.TYPE_ITEM.ordinal();
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        if (holder instanceof ItemViewHolder) {
            ItemViewHolder mItemViewHolder = (ItemViewHolder) holder;
            Resources mResources = context.getResources();
            mItemViewHolder.cv.setCardBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_teal_50) : mResources.getColor(R.color.material_blue_50));

            mItemViewHolder.tv_title.setText("消息：拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！拌合站出事啦！" + position);

            if (mOnItemClickListener != null) {
                mItemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = holder.getLayoutPosition();
                        mOnItemClickListener.onItemClick(holder.itemView, position);
                    }
                });
            }
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.TYPE_ITEM.ordinal()) {
            ItemViewHolder holder = new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_message_activity_viewpager_fragment, parent, false));
            return holder;
        } else if (viewType == ITEM_TYPE.TYPE_FOOTER.ordinal()) {
            View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_foot, parent, false);
            return new FootViewHolder(view);
        }
        return null;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        CardView cv;

        public ItemViewHolder(View view) {
            super(view);
            tv_title = (TextView) view.findViewById(R.id.tv_title_item_recyclerview_message_activity_viewpager_fragment);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_message_activity_viewpager_fragment);
        }
    }

    static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View view) {
            super(view);
        }
    }
}
