package com.shtoone.shtw.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shtoone.shtw.R;
import com.shtoone.shtw.bean.YalijiFragmentViewPagerFragmentRecyclerViewItemData;
import com.shtoone.shtw.ui.SlantedTextView;

import java.util.List;

public class YaLiJiFragmentViewPagerFragmentRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = YaLiJiFragmentViewPagerFragmentRecyclerViewAdapter.class.getSimpleName();
    private Context context;
    private OnItemClickListener mOnItemClickListener;
    private List<YalijiFragmentViewPagerFragmentRecyclerViewItemData.DataBean> itemsData;
    private Resources mResources;

    public enum ITEM_TYPE {
        TYPE_ITEM, TYPE_FOOTER
    }

    public YaLiJiFragmentViewPagerFragmentRecyclerViewAdapter(Context context, List<YalijiFragmentViewPagerFragmentRecyclerViewItemData.DataBean> itemsData) {
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

            YalijiFragmentViewPagerFragmentRecyclerViewItemData.DataBean item = itemsData.get(position);
            mItemViewHolder.tv_title.setText(item.getSYRQ());
            mItemViewHolder.tv_test_number.setText(item.getSJBH());
            mItemViewHolder.tv_design_strength.setText(item.getSJQD());
            mItemViewHolder.tv_central_value.setText(item.getQDDBZ());
            mItemViewHolder.tv_project_name.setText(item.getGCMC());
            mItemViewHolder.tv_position.setText(item.getSGBW());
            mItemViewHolder.tv_testtype.setText(item.getTestName());
            mItemViewHolder.tv_equipment.setText(item.getShebeiname());
            if ("合格".equals(item.getPDJG())) {
                //默认就是合格设置
            } else if ("有效".equals(item.getPDJG())) {
                mItemViewHolder.stv_qualified.setText("有效");
            } else {
                //设置是否处置标签
                mItemViewHolder.stv_handle.setVisibility(View.VISIBLE);
                if ("0".equals(item.getChuzhi())) {
                    mItemViewHolder.stv_handle.setText("未处置").setSlantedBackgroundColor(Color.YELLOW);
                } else {
                    mItemViewHolder.stv_handle.setText("已处置").setSlantedBackgroundColor(Color.GREEN);
                }

                if ("不合格".equals(item.getPDJG())) {
                    mItemViewHolder.stv_qualified.setText("不合格").setSlantedBackgroundColor(Color.RED);
                } else if ("无效".equals(item.getPDJG())) {
                    mItemViewHolder.stv_qualified.setText("无效").setSlantedBackgroundColor(Color.RED);
                }
            }

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
            return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_yaliji_fragment_viewpager_fragment, parent, false));
        } else if (viewType == ITEM_TYPE.TYPE_FOOTER.ordinal()) {
            return new FootViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item_foot, parent, false));
        }
        return null;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        TextView tv_test_number;
        TextView tv_design_strength;
        TextView tv_central_value;
        TextView tv_project_name;
        TextView tv_position;
        TextView tv_equipment;
        TextView tv_testtype;
        SlantedTextView stv_qualified;
        SlantedTextView stv_handle;
        CardView cv;

        public ItemViewHolder(View view) {
            super(view);
            tv_title = (TextView) view.findViewById(R.id.tv_title_item_recyclerview_yaliji_fragment_viewpager_fragment);
            tv_test_number = (TextView) view.findViewById(R.id.tv_test_number_item_recyclerview_yaliji_fragment_viewpager_fragment);
            tv_design_strength = (TextView) view.findViewById(R.id.tv_design_strength_item_recyclerview_yaliji_fragment_viewpager_fragment);
            tv_central_value = (TextView) view.findViewById(R.id.tv_central_value_item_recyclerview_yaliji_fragment_viewpager_fragment);
            tv_project_name = (TextView) view.findViewById(R.id.tv_project_name_item_recyclerview_yaliji_fragment_viewpager_fragment);
            tv_position = (TextView) view.findViewById(R.id.tv_position_item_recyclerview_yaliji_fragment_viewpager_fragment);
            tv_testtype = (TextView) view.findViewById(R.id.tv_testtype_item_recyclerview_yaliji_fragment_viewpager_fragment);
            tv_equipment = (TextView) view.findViewById(R.id.tv_equipment_item_recyclerview_yaliji_fragment_viewpager_fragment);
            stv_qualified = (SlantedTextView) view.findViewById(R.id.stv_qualified_item_recyclerview_yaliji_fragment_viewpager_fragment);
            stv_handle = (SlantedTextView) view.findViewById(R.id.stv_handle_item_recyclerview_yaliji_fragment_viewpager_fragment);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_yaliji_fragment_viewpager_fragment);
        }
    }

    static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View view) {
            super(view);
        }
    }
}
