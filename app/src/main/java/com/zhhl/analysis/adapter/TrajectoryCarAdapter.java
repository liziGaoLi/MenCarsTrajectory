package com.zhhl.analysis.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.zhhl.analysis.R;
import com.zhhl.analysis.data.CarTrajectory;
import com.zhhl.analysis.utils.DateUtil;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;

/**
 * Created by miao on 2018/10/10.
 */
public class TrajectoryCarAdapter extends BaseAdapter_r<CarTrajectory, TrajectoryCarAdapter.TrajectoryCarHolder> {

    public TrajectoryCarAdapter(ArrayList<CarTrajectory> data) {
        super(data);
    }

    @Override
    protected TrajectoryCarHolder create(View view,int idx) {
        return new TrajectoryCarHolder(view);
    }

    @Override
    protected void bindView(TrajectoryCarHolder vh, int position, CarTrajectory item) {

        switch (item.getType()) {
            case 1:
                vh.mTrajectoryIcon.setImageResource(R.mipmap.camera);
                vh.mTrajectoryDate.setText(DateUtil.format("yyyy-MM-dd", DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", item.getBayonet().getJgsj())));
                vh.mTrajectoryLocation.setText(item.getBayonet().getDwmc());
                vh.mTrajectoryType.setText("卡口过车:");
                vh.mTrajectoryTypeName.setText(item.getBayonet().getHphm());
                vh.mTrajectoryTime.setText(item.getBayonet().getJgsj());
                break;
            case 2:
                break;
        }

        if (position == 0) {
            vh.mTrajectoryIsNew.setVisibility(View.VISIBLE);
            vh.mTrajectoryLineTop.setVisibility(View.INVISIBLE);
            vh.mTrajectoryLineBottom.setVisibility(View.VISIBLE);
        } else if (position + 1 == getCount()) {
            vh.mTrajectoryIsNew.setVisibility(View.INVISIBLE);
            vh.mTrajectoryLineTop.setVisibility(View.VISIBLE);
            vh.mTrajectoryLineBottom.setVisibility(View.INVISIBLE);
        } else {
            vh.mTrajectoryIsNew.setVisibility(View.INVISIBLE);
            vh.mTrajectoryLineBottom.setVisibility(View.VISIBLE);
            vh.mTrajectoryLineTop.setVisibility(View.VISIBLE);
        }


        if (getCount() == 1) {
            vh.mTrajectoryIsNew.setVisibility(View.VISIBLE);
            vh.mTrajectoryLineTop.setVisibility(View.INVISIBLE);
            vh.mTrajectoryLineBottom.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.item_trajectory;
    }

    public void addData(ArrayList<CarTrajectory> list) {
        data.addAll(list);
        Collections.sort(data);
        notifyDataSetChanged();
    }

    static class TrajectoryCarHolder extends BaseAdapter_r.ViewHolder {
        @BindView(R.id.mTrajectoryDate)
        TextView mTrajectoryDate;
        @BindView(R.id.mTrajectoryLineTop)
        View mTrajectoryLineTop;
        @BindView(R.id.mTrajectoryIcon)
        ImageView mTrajectoryIcon;
        @BindView(R.id.mTrajectoryLineBottom)
        View mTrajectoryLineBottom;
        @BindView(R.id.mTrajectoryType)
        TextView mTrajectoryType;
        @BindView(R.id.mTrajectoryTypeName)
        TextView mTrajectoryTypeName;
        @BindView(R.id.mTrahectoryIsNew)
        TextView mTrajectoryIsNew;
        @BindView(R.id.mTrajectoryLocation)
        TextView mTrajectoryLocation;
        @BindView(R.id.mTrajectoryTime)
        TextView mTrajectoryTime;

        TrajectoryCarHolder(View view) {
            super(view);
        }
    }
}
