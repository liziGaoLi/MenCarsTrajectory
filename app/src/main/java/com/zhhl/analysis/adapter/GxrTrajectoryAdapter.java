package com.zhhl.analysis.adapter;

import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhhl.analysis.R;
import com.zhhl.analysis.data.GxrData2;
import com.zhhl.analysis.utils.DateUtil;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by miao on 2019/1/24.
 */
public class GxrTrajectoryAdapter extends BaseAdapter<Parcelable, GxrTrajectoryAdapter.GxrTrajectoryViewHolder> {

    private int type;

    public GxrTrajectoryAdapter(ArrayList<Parcelable> data) {
        super(data);
    }

    @Override
    protected GxrTrajectoryViewHolder create(View view, int itemViewType) {
        return new GxrTrajectoryViewHolder(view);
    }

    @Override
    protected void bindView(GxrTrajectoryViewHolder vh, int position, Parcelable item) {
        switch (type) {
            case 46:
                GxrData2.HbtxBean hbtx = (GxrData2.HbtxBean) item;
                vh.mTrajectoryDate.setText(DateUtil.format("MM-dd", DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", hbtx.getDdcfRq()) + DateUtil.parseDate("HH:mm:ss", hbtx.getDdcfSj())));
                vh.mTrajectoryTime.setText(DateUtil.format("yyyy-MM-dd HH:mm:ss", DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", hbtx.getDdcfRq()) + DateUtil.parseDate("HH:mm:ss", hbtx.getDdcfSj())));
                vh.mTrajectoryType.setText("航班同行:");
                vh.mTrajectoryTypeName.setText(hbtx.getHbh());
                vh.mTrajectoryLocation.setText(hbtx.getQfjcdm() + "-" + hbtx.getDdjcdm());
                vh.mName.setText(hbtx.getXm());
                vh.sfzh.setText(hbtx.getZjhm());
                break;
            case 47:
                GxrData2.HctxBean hctx = (GxrData2.HctxBean) item;
                vh.mTrajectoryDate.setText(DateUtil.format("MM-dd", DateUtil.parseDate("yyyyMMdd", hctx.getCcrq())));
                vh.mTrajectoryTime.setText(DateUtil.format("yyyy-MM-dd HH:mm:ss", DateUtil.parseDate("yyyyMMdd", hctx.getCcrq())));
                vh.mTrajectoryType.setText("火车同行:");
                vh.mTrajectoryTypeName.setText(hctx.getCc());
                vh.mTrajectoryLocation.setText(hctx.getSfd() + "-" + hctx.getMdd());
                vh.mName.setText(hctx.getXm());
                vh.sfzh.setText(hctx.getGmsfhm());
                break;
            case 48:
                GxrData2.KctxBean kctx = (GxrData2.KctxBean) item;
                vh.mTrajectoryDate.setText(DateUtil.format("MM-dd", DateUtil.parseDate("yyyy-MM-dd", kctx.getFcrq())));
                vh.mTrajectoryTime.setText(DateUtil.format("yyyy-MM-dd HH:mm:ss", DateUtil.parseDate("yyyy-MM-dd", kctx.getFcrq()) + DateUtil.parseDate("HH:mm", kctx.getFcsj())));
                vh.mTrajectoryType.setText("客车同行:");
                vh.mTrajectoryTypeName.setText("");
                vh.mTrajectoryLocation.setText(kctx.getFcjgmc() + "-" + kctx.getDdzmc());
                vh.mName.setText(kctx.getCkXm());
                vh.sfzh.setText(kctx.getZjqfZjhm());
                break;
            case 49:
                GxrData2.ZstxBean zstx = (GxrData2.ZstxBean) item;
                vh.mTrajectoryDate.setText(DateUtil.format("MM-dd", DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", zstx.getRzsj2())));
                vh.mTrajectoryTime.setText(DateUtil.format("yyyy-MM-dd HH:mm:ss", DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", zstx.getRzsj2())));
                vh.mTrajectoryType.setText("同住:");
                vh.mTrajectoryTypeName.setText(zstx.getLdMc());
                vh.mTrajectoryLocation.setText(zstx.getLgbm());
                vh.mName.setText(zstx.getXm());
                vh.sfzh.setText(zstx.getGmsfhm());
                break;
            case 50:
                GxrData2.HclzBean hclz = (GxrData2.HclzBean) item;
                vh.mTrajectoryDate.setText(DateUtil.format("MM-dd", DateUtil.parseDate("yyyyMMdd", hclz.getCcrq())));
                vh.mTrajectoryTime.setText(DateUtil.format("yyyy-MM-dd HH:mm:ss", DateUtil.parseDate("yyyyMMdd", hclz.getCcrq())));
                vh.mTrajectoryType.setText("火车同行:");
                vh.mTrajectoryTypeName.setText(hclz.getCc());
                vh.mTrajectoryLocation.setText(hclz.getSfd() + "-" + hclz.getMdd());
                vh.mName.setText(hclz.getXm());
                vh.sfzh.setText(hclz.getGmsfhm());
                break;
        }
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.txr_trajectory_2;
    }

    public void setData(int type, ArrayList<Parcelable> data) {
        this.type = type;
        super.setData(data);
    }

    static class GxrTrajectoryViewHolder extends BaseAdapter.ViewHolder {
        @BindView(R.id.mTrajectoryDate)
        TextView mTrajectoryDate;
        @BindView(R.id.mTrajectoryLineTop)
        View mTrajectoryLineTop;
        @BindView(R.id.mTrajectoryIcon)
        ImageView mTrajectoryIcon;
        @BindView(R.id.mTrajectoryLineBottom)
        View mTrajectoryLineBottom;
        @BindView(R.id.mName)
        TextView mName;
        @BindView(R.id.sfzh)
        TextView sfzh;
        @BindView(R.id.mTrajectoryType)
        TextView mTrajectoryType;
        @BindView(R.id.mTrajectoryTypeName)
        TextView mTrajectoryTypeName;
        @BindView(R.id.mTrajectoryLocation)
        TextView mTrajectoryLocation;
        @BindView(R.id.mTrajectoryTime)
        TextView mTrajectoryTime;

        public GxrTrajectoryViewHolder(View view) {
            super(view);
        }
    }
}
