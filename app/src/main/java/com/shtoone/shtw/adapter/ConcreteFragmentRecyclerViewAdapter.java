package com.shtoone.shtw.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shtoone.shtw.R;
import com.shtoone.shtw.bean.ConcreteFragmentData;

/**
 * Created by leguang on 2016/7/19 0019.
 */
public class ConcreteFragmentRecyclerViewAdapter extends RecyclerView.Adapter<ConcreteFragmentRecyclerViewAdapter.MyViewHolder> {
    private static final String TAG = LaboratoryFragmentRecyclerViewAdapter.class.getSimpleName();
    private Context context;
    private OnItemClickListener mOnItemClickListener;
    private ConcreteFragmentData itemData;
    private Resources mResources;

    public ConcreteFragmentRecyclerViewAdapter(Context context, ConcreteFragmentData itemData) {
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
        if (itemData != null && itemData.isSuccess()) {
            return itemData.getData().size();
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        if (itemData != null && itemData.isSuccess() && itemData.getData().size() > 0) {
//            holder.cv.setCardBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_green_100) : mResources.getColor(R.color.material_green_100));
            ConcreteFragmentData.DataBean item = itemData.getData().get(position);
            holder.tv_organization.setText(item.getDepartName());
            holder.tv_site_count.setText(item.getBhzCount());     //拌合站总数
            holder.tv_machine_count.setText(item.getBhjCount());     //拌合机总数
            holder.tv_zongpanshu.setText(item.getTotalPanshu());
            holder.tv_zongfangliang.setText(item.getTotalFangliang());
            holder.tv_elementary1.setText(item.getCbpanshu());
            holder.tv_elementary2.setText(item.getCblv());
            holder.tv_elementary3.setText(item.getCczpanshu());
            holder.tv_elementary4.setText(item.getCzlv());
            holder.tv_middle1.setText(item.getMcbpanshu());
            holder.tv_middle2.setText(item.getMcblv());
            holder.tv_middle3.setText(item.getMczpanshu());
            holder.tv_middle4.setText(item.getMczlv());
            holder.tv_high1.setText(item.getHcbpanshu());
            holder.tv_high2.setText(item.getHcblv());
            holder.tv_high3.setText(item.getHczpanshu());
            holder.tv_high4.setText(item.getHczlv());
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
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_concrete_fragment, parent, false));
        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView tv_organization;
        TextView tv_site_count;
        TextView tv_machine_count;
        TextView tv_zongpanshu;
        TextView tv_zongfangliang;
        TextView tv_elementary1;
        TextView tv_elementary2;
        TextView tv_elementary3;
        TextView tv_elementary4;
        TextView tv_middle1;
        TextView tv_middle2;
        TextView tv_middle3;
        TextView tv_middle4;
        TextView tv_high1;
        TextView tv_high2;
        TextView tv_high3;
        TextView tv_high4;

        public MyViewHolder(View view) {
            super(view);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_concrete_fragment);
            tv_organization = (TextView) view.findViewById(R.id.tv_organization_item_recyclerview_concrete_fragment);
            tv_site_count = (TextView) view.findViewById(R.id.tv_site_count_item_recyclerview_concrete_fragment);
            tv_machine_count = (TextView) view.findViewById(R.id.tv_machine_count_item_recyclerview_concrete_fragment);
            tv_zongpanshu = (TextView) view.findViewById(R.id.tv_zongpanshu_item_recyclerview_concrete_fragment);
            tv_zongfangliang = (TextView) view.findViewById(R.id.tv_zongfangliang_item_recyclerview_concrete_fragment);
            tv_elementary1 = (TextView) view.findViewById(R.id.tv_elementary1);
            tv_elementary2 = (TextView) view.findViewById(R.id.tv_elementary2);
            tv_elementary3 = (TextView) view.findViewById(R.id.tv_elementary3);
            tv_elementary4 = (TextView) view.findViewById(R.id.tv_elementary4);
            tv_middle1 = (TextView) view.findViewById(R.id.tv_middle1);
            tv_middle2 = (TextView) view.findViewById(R.id.tv_middle2);
            tv_middle3 = (TextView) view.findViewById(R.id.tv_middle3);
            tv_middle4 = (TextView) view.findViewById(R.id.tv_middle4);
            tv_high1 = (TextView) view.findViewById(R.id.tv_high1);
            tv_high2 = (TextView) view.findViewById(R.id.tv_high2);
            tv_high3 = (TextView) view.findViewById(R.id.tv_high3);
            tv_high4 = (TextView) view.findViewById(R.id.tv_high4);
        }
    }
}
