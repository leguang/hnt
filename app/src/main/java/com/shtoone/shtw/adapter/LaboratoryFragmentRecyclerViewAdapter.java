package com.shtoone.shtw.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shtoone.shtw.R;
import com.shtoone.shtw.bean.LaboratoryFragmentRecyclerViewItemData;
import com.shtoone.shtw.ui.ItemInItemView;

public class LaboratoryFragmentRecyclerViewAdapter extends RecyclerView.Adapter<LaboratoryFragmentRecyclerViewAdapter.MyViewHolder> {
    private static final String TAG = LaboratoryFragmentRecyclerViewAdapter.class.getSimpleName();
    private Context context;
    private OnItemClickListener mOnItemClickListener;
    private LaboratoryFragmentRecyclerViewItemData itemData;
    private Resources mResources;

    public LaboratoryFragmentRecyclerViewAdapter(Context context, LaboratoryFragmentRecyclerViewItemData itemData) {
        super();
        this.context = context;
        this.itemData = itemData;
        this.mResources = context.getResources();
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public int getItemCount() {
        if (null != itemData && itemData.getData().size() > 0 && itemData.isSuccess()) {
            return itemData.getData().size();
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        if (itemData != null && itemData.isSuccess() && itemData.getData().size() > 0) {
//            holder.cv.setCardBackgroundColor(position % 2 == 0 ? Color.argb(250, 78, 100, 132) : Color.argb(255, 66, 90, 126));
            //此处该优化，相同的部位应提取出来
            holder.tv_organization.setText(itemData.getData().get(position).get(0).getDepartName());
            holder.tv_laboratory_count.setText(itemData.getData().get(position).get(0).getSysCount());     //拌合站总数
            holder.tv_machine_count.setText(itemData.getData().get(position).get(0).getSyjCount());     //拌合机总数xx

            for (int i = 0; i < itemData.getData().get(position).size(); i++) {

                ItemInItemView itemInItem = new ItemInItemView(context);

                switch (itemData.getData().get(position).get(i).getTesttype()) {
                    case "100014":
                        itemInItem.setBackgroundColor(mResources.getColor(R.color.material_green_100));
                        break;
                    case "100047":
                        itemInItem.setBackgroundColor(mResources.getColor(R.color.material_Lime_100));
                        break;
                    case "100048":
                        itemInItem.setBackgroundColor(mResources.getColor(R.color.material_brown_100));
                        break;
                    case "100049":
                        itemInItem.setBackgroundColor(mResources.getColor(R.color.material_blue_100));
                        break;
                }
                itemInItem.setTestType(itemData.getData().get(position).get(i).getTestName());
                itemInItem.setTestCount(itemData.getData().get(position).get(i).getTestCount());
                itemInItem.setDisqualificationCount(itemData.getData().get(position).get(i).getNotQualifiedCount());
                itemInItem.setDispositionCount(itemData.getData().get(position).get(i).getRealCount());
                if (TextUtils.isEmpty(itemData.getData().get(position).get(i).getRealPer())) {
                    itemInItem.setDispositionRate("0.00%");
                } else {
                    itemInItem.setDispositionRate(itemData.getData().get(position).get(i).getRealPer() + "%");
                }
                holder.ll_content.addView(itemInItem);
            }
        }

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_laboratory_fragment, parent, false));
        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_organization;
        TextView tv_laboratory_count;
        TextView tv_machine_count;
        LinearLayout ll_content;
        CardView cv;

        public MyViewHolder(View view) {
            super(view);
            tv_organization = (TextView) view.findViewById(R.id.tv_organization_item_recyclerview_laboratory_fragment);
            tv_laboratory_count = (TextView) view.findViewById(R.id.tv_laboratory_count_item_recyclerview_laboratory_fragment);
            tv_machine_count = (TextView) view.findViewById(R.id.tv_machine_count_content_item_recyclerview_laboratory_fragment);
            ll_content = (LinearLayout) view.findViewById(R.id.ll_content_item_recyclerview_laboratory_fragment);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_laboratory_fragment);
        }
    }
}
