package com.shtoone.shtw.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shtoone.shtw.R;
import com.shtoone.shtw.bean.LaboratoryStatisticFragmentData;

import java.util.List;

/**
 * Created by leguang on 2016/7/22 0022.
 */
public class LaboratoryStatisticFragmentRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = LaboratoryStatisticFragmentRecyclerViewAdapter.class.getSimpleName();
    private Context context;
    private List<LaboratoryStatisticFragmentData.DataBean> itemsData;
    private Resources mResources;

    public LaboratoryStatisticFragmentRecyclerViewAdapter(Context context, List<LaboratoryStatisticFragmentData.DataBean> itemsData) {
        super();
        this.context = context;
        this.itemsData = itemsData;
        mResources = context.getResources();
    }

    @Override
    public int getItemCount() {
        if (itemsData != null && itemsData.size() > 0) {
            return itemsData.size();
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder mItemViewHolder = (ItemViewHolder) holder;
            LaboratoryStatisticFragmentData.DataBean item = itemsData.get(position);
            ViewGroup mViewGroup = (ViewGroup) mItemViewHolder.tv0.getParent();
            mViewGroup.setBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_teal_50) : mResources.getColor(R.color.material_blue_50));
            mItemViewHolder.tv0.setText(item.getTestName());
            mItemViewHolder.tv1.setText(item.getTestCount());
            mItemViewHolder.tv2.setText(item.getQualifiedCount());
            mItemViewHolder.tv3.setText(item.getValidCount());
            mItemViewHolder.tv4.setText(item.getNotqualifiedCount());
            mItemViewHolder.tv5.setText(item.getQualifiedPer());
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_laboratory_statistic_fragment, parent, false));
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv0;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        TextView tv4;
        TextView tv5;

        public ItemViewHolder(View view) {
            super(view);
            tv0 = (TextView) view.findViewById(R.id.tv0_item_recyclerview_laboratory_statistic_fragment);
            tv1 = (TextView) view.findViewById(R.id.tv1_item_recyclerview_laboratory_statistic_fragment);
            tv2 = (TextView) view.findViewById(R.id.tv2_item_recyclerview_laboratory_statistic_fragment);
            tv3 = (TextView) view.findViewById(R.id.tv3_item_recyclerview_laboratory_statistic_fragment);
            tv4 = (TextView) view.findViewById(R.id.tv4_item_recyclerview_laboratory_statistic_fragment);
            tv5 = (TextView) view.findViewById(R.id.tv5_item_recyclerview_laboratory_statistic_fragment);
        }
    }
}
