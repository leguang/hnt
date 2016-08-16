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
import com.shtoone.shtw.bean.ProduceQueryFragmentListData;

import java.util.List;

public class ProduceQueryFragmentRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = ProduceQueryFragmentRecyclerViewAdapter.class.getSimpleName();
    private Context context;
    private OnItemClickListener mOnItemClickListener;
    private List<ProduceQueryFragmentListData.DataBean> itemsData;
    private Resources mResources;

    public enum ITEM_TYPE {
        TYPE_ITEM, TYPE_FOOTER
    }

    public ProduceQueryFragmentRecyclerViewAdapter(Context context, List<ProduceQueryFragmentListData.DataBean> itemsData) {
        super();
        this.context = context;
        this.itemsData = itemsData;
        mResources = context.getResources();
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public int getItemCount() {
        if (itemsData != null && itemsData.size() > 0) {
            //这里的10是根据分页查询，一页该显示的条数
            if (itemsData.size() > 4) {
                return itemsData.size() + 1;
            } else {
                return itemsData.size();
            }
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (getItemCount() > 4 && position + 1 == getItemCount()) {
            return ITEM_TYPE.TYPE_FOOTER.ordinal();
        } else {
            return ITEM_TYPE.TYPE_ITEM.ordinal();
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder mItemViewHolder = (ItemViewHolder) holder;
            mItemViewHolder.cv.setCardBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_teal_50) : mResources.getColor(R.color.material_blue_50));

            ProduceQueryFragmentListData.DataBean item = itemsData.get(position);
            mItemViewHolder.tv_datetime.setText(item.getChuliaoshijian());
            mItemViewHolder.tv_site.setText(item.getBanhezhanminchen());
            mItemViewHolder.tv_project_name.setText(item.getGongchengmingcheng());
            mItemViewHolder.tv_position.setText(item.getJiaozuobuwei());
            mItemViewHolder.tv_location.setText(item.getSigongdidian());
            mItemViewHolder.tv_strength_grade.setText(item.getQiangdudengji());
            mItemViewHolder.tv_count.setText(item.getGujifangshu());

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
            return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_produce_query_fragment, parent, false));
        } else if (viewType == ITEM_TYPE.TYPE_FOOTER.ordinal()) {
            return new FootViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item_foot, parent, false));
        }
        return null;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView tv_datetime;
        TextView tv_site;
        TextView tv_project_name;
        TextView tv_position;
        TextView tv_location;
        TextView tv_strength_grade;
        TextView tv_count;

        public ItemViewHolder(View view) {
            super(view);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_produce_query_fragment);
            tv_datetime = (TextView) view.findViewById(R.id.tv0_item_recyclerview_produce_query_fragment);
            tv_site = (TextView) view.findViewById(R.id.tv1_item_recyclerview_produce_query_fragment);
            tv_project_name = (TextView) view.findViewById(R.id.tv2_item_recyclerview_produce_query_fragment);
            tv_position = (TextView) view.findViewById(R.id.tv3_item_recyclerview_produce_query_fragment);
            tv_location = (TextView) view.findViewById(R.id.tv4_item_recyclerview_produce_query_fragment);
            tv_strength_grade = (TextView) view.findViewById(R.id.tv5_item_recyclerview_produce_query_fragment);
            tv_count = (TextView) view.findViewById(R.id.tv6_item_recyclerview_produce_query_fragment);
        }
    }

    static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View view) {
            super(view);
        }
    }
}
