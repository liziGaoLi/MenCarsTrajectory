package com.zhhl.analysis.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhhl.analysis.R;
import com.zhhl.analysis.data.GuijiCQDWrapper;
import com.zhhl.analysis.data.GxrData2;
import com.zhhl.analysis.data.PersonTrajectory;
import com.zhhl.analysis.data.SelfTrajectoryData;
import com.zhhl.analysis.data.SimpleCarInfo;
import com.zhhl.analysis.utils.DateUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

/**
 * Created by miao on 2018/9/5.
 */
public class PersonAnalysisAdapter extends BaseAdapter<PersonTrajectory, BaseAdapter.ViewHolder> {

    public PersonAnalysisAdapter(ArrayList<PersonTrajectory> data) {
        super(data);
    }

    @Override
    public ViewHolder create(View view, int idx) {
        switch (idx) {
            case 0:
                return new TrajectoryViewHolder(view);
            case 1:
                return new TrajectoryViewHolder2(view);
            case 2:
                return new TrajectoryViewHolder3(view);
            case 3:
                return new TrajectoryViewHolder4(view);
        }
        return null;
    }

    @Override
    protected void bindView(ViewHolder _vh, int position, PersonTrajectory item) {

        if (item.getType() < 20) {
            TrajectoryViewHolder vh = (TrajectoryViewHolder) _vh;
            switch (item.getType()) {
                case 1:
                    vh.mTrajectoryDate.setText(DateUtil.format("yyyy-MM-dd", DateUtil.parseDate("yyyyMMdd", item.getHouse().getCsrq())));
                    vh.mTrajectoryType.setText("住址:");
                    vh.mTrajectoryTypeName.setText(item.getHouse().getHjxz());
                    vh.mTrajectoryLocation.setText(item.getHouse().getZzxz());
                    vh.mTrajectoryTime.setText(DateUtil.format("yyyy-MM-dd", DateUtil.parseDate("yyyyMMdd", item.getHouse().getCsrq())));
                    vh.mTrajectoryIcon.setImageResource(getRes("酒店名称"));
                    break;
                case 2:
                    vh.mTrajectoryDate.setText(DateUtil.format("yyyy-MM-dd", DateUtil.parseDate("yyyy-MM-dd HH:mm", item.getUnLock().getCreateDate())));
                    vh.mTrajectoryType.setText("开锁:");
                    vh.mTrajectoryTypeName.setText(item.getUnLock().getDeptName());
                    vh.mTrajectoryLocation.setText(item.getUnLock().getAddress() + " " + item.getUnLock().getDetailAddress());
                    vh.mTrajectoryTime.setText(item.getUnLock().getCreateDate());
                    vh.mTrajectoryIcon.setImageResource(getRes("酒店名称"));
                    break;
                case 3:
                    vh.mTrajectoryDate.setText(DateUtil.format("yyyy-MM-dd", DateUtil.parseDate("yyyy-MM-dd HH:mm", item.getSzqy().getCreateDate())));
                    vh.mTrajectoryType.setText("散装汽油:");
                    vh.mTrajectoryTypeName.setText(item.getSzqy().getGasolineUse());
                    vh.mTrajectoryLocation.setText(item.getSzqy().getAddress());
                    vh.mTrajectoryTime.setText(item.getSzqy().getCreateDate());
                    vh.mTrajectoryIcon.setImageResource(getRes("酒店名称"));
                    break;
                case 4:
                    vh.mTrajectoryDate.setText(DateUtil.format("yyyy-MM-dd", DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", item.getNoId().getCreateDate())));
                    vh.mTrajectoryType.setText("无证居住:");
                    vh.mTrajectoryTypeName.setText(/*item.getNoId().getResult()*/"");
                    vh.mTrajectoryLocation.setText(item.getNoId().getAddress());
                    vh.mTrajectoryTime.setText(item.getNoId().getCreateDate());
                    vh.mTrajectoryIcon.setImageResource(getRes("酒店名称"));
                    break;
                case 5:
                    vh.mTrajectoryIcon.setImageResource(R.mipmap.camera);
                    vh.mTrajectoryDate.setText(DateUtil.format("yyyy-MM-dd", DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", item.getCarBayonet().getJgsj())));
                    vh.mTrajectoryLocation.setText(item.getCarBayonet().getDwmc());
                    vh.mTrajectoryType.setText("卡口过车:");
                    vh.mTrajectoryTypeName.setText(item.getCarBayonet().getHphm());
                    vh.mTrajectoryTime.setText(item.getCarBayonet().getJgsj());
                    break;

                case 6:
                    vh.mTrajectoryDate.setText(DateUtil.format("yyyy-MM-dd", item.getTime()));
                    vh.mTrajectoryType.setText("常去地:");
                    vh.mTrajectoryTypeName.setText(/*item.getNoId().getResult()*/"五洲花园大酒店");
                    vh.mTrajectoryLocation.setText(/*item.getNoId().getAddress()*/"吉林省长春市南湖街道");
                    vh.mTrajectoryTime.setText(DateUtil.format("yyyy-MM-dd", item.getTime()));
                    vh.mTrajectoryIcon.setImageResource(getRes("酒店名称"));
                    break;

            }

            vh.mTrajectoryDate.setText(DateUtil.format("yyyy-MM-dd", item.getTime()));
            switch (item.getType()) {
                case 12:
                    SelfTrajectoryData.KecheBean kc = item.getKecheBean();
                    vh.mTrajectoryTime.setText(DateUtil.format("yyyy-MM-dd HH:mm:ss", item.getTime()));
                    vh.mTrajectoryType.setText("客车购票:");
                    vh.mTrajectoryTypeName.setText("");
                    vh.mTrajectoryLocation.setText(kc.getFcjgmc() + "-" + kc.getDdzmc());
                    break;
                case 13:
                    SelfTrajectoryData.MinhangBean mh = item.getMinhangBean();
                    vh.mTrajectoryTime.setText(DateUtil.format("yyyy-MM-dd HH:mm:ss", item.getTime()));
                    vh.mTrajectoryType.setText("民航购票:");
                    vh.mTrajectoryTypeName.setText(mh.getCyhkgsdm() + mh.getHbh());
                    vh.mTrajectoryLocation.setText(mh.getQfjcdm() + "-" + mh.getDdjcdm());
                    break;
                case 14:
                    vh.mTrajectoryType.setText("网吧:");
                    vh.mTrajectoryTime.setText(DateUtil.format("yyyy-MM-dd HH:mm:ss", item.getTime()));
                    SelfTrajectoryData.ShangwangBean sw = item.getShangwangBean();
                    vh.mTrajectoryTypeName.setText("");
                    vh.mTrajectoryLocation.setText(sw.getYycsDwmc());
                    break;
                case 15:
                    vh.mTrajectoryTime.setText(DateUtil.format("yyyy-MM-dd HH:mm:ss", item.getTime()));
                    SelfTrajectoryData.TielugoupiaoBean tl = item.getTielugoupiaoBean();
                    vh.mTrajectoryType.setText("铁路购票:");
                    vh.mTrajectoryTypeName.setText(tl.getCc());
                    vh.mTrajectoryLocation.setText(tl.getSfd() + "-" + tl.getMdd());
                    break;
                case 16:
                    SelfTrajectoryData.ZhudianBean zd = item.getZhudianBean();
                    vh.mTrajectoryTime.setText(DateUtil.format("yyyy-MM-dd HH:mm:ss", item.getTime()));
                    vh.mTrajectoryType.setText("酒店:");
                    vh.mTrajectoryTypeName.setText(zd.getLdMc());
                    vh.mTrajectoryLocation.setText(zd.getLgbm());
                    break;
                case 17:
                    vh.mTrajectoryTime.setText(DateUtil.format("yyyy-MM-dd HH:mm:ss", item.getTime()));
                    SelfTrajectoryData.KakouBean kk = item.getKakouBean();
                    vh.mTrajectoryType.setText("卡口过车:");
                    vh.mTrajectoryTypeName.setText(kk.getTgfx());
                    vh.mTrajectoryLocation.setText(kk.getKkmc());
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
        } else if (item.getType() > 20 && item.getType() < 30) {
            TrajectoryViewHolder2 vh2 = (TrajectoryViewHolder2) _vh;
            GuijiCQDWrapper wrapper = item.getWrapper();
            if (position == 0) {
                vh2.toptip.setVisibility(View.VISIBLE);
            } else {
                vh2.toptip.setVisibility(View.GONE);
            }
            vh2.counter.setText(wrapper.tj + "次");
            vh2.name.setText(wrapper.ldmc);
        } else if (item.getType() > 30 && item.getType() < 40) {

            TrajectoryViewHolder3 vh3 = (TrajectoryViewHolder3) _vh;
            vh3.yuanyin.setVisibility(View.GONE);
            switch (item.getType()) {
                case 33:
                    GxrData2.HunyinBean hunyin = item.getHunyin2();
                    vh3.name.setText(hunyin.getPeiou());
                    vh3.sfzh.setText(hunyin.getPeioucode());
                    int sexId = Integer.parseInt(hunyin.getPeioucode().substring(16, 17));
                    vh3.gxId.setText("与本人关系(" + (sexId % 2 == 0 ? "妻子" : "丈夫") + ")");
                    break;
                case 34:
                    GxrData2.QinshuBean qinshu = item.getQinshu2();
                    vh3.name.setText(qinshu.getXm());
                    vh3.sfzh.setText(qinshu.getGmsfhm());
                    vh3.gxId.setText("与户主关系:" + qinshu.getYhzgxdm());
                    break;
            }
//        } else if (item.getType() > 40 && item.getType() <= 45) {
//            TrajectoryViewHolder3 vh3 = (TrajectoryViewHolder3) _vh;
//            switch (item.getType()) {
//                case 41:
//                    GxrData.HbtxBean hbtx = item.getHbtx();
//                    vh3.name.setText(hbtx.getName());
//                    vh3.sfzh.setText(hbtx.getIdcode());
//                    vh3.yuanyin.setText(hbtx.getYuanyin());
//                    break;
//                case 42:
//                    GxrData.HctxBean hctx = item.getHctx();
//                    vh3.name.setText(hctx.getHctxname());
//                    vh3.sfzh.setText(hctx.getHctxid());
//                    vh3.yuanyin.setText(hctx.getYuanyin());
//                    break;
//                case 43:
//                    GxrData.KctxBean kctx = item.getKctx();
//                    vh3.name.setText(kctx.getName());
//                    vh3.sfzh.setText(kctx.getIdcode());
//                    vh3.yuanyin.setText(kctx.getYuanyin());
//                    break;
//                case 44:
//                    GxrData.WbtxBean wbtx = item.getWbtx();
//                    vh3.name.setText(wbtx.getName());
//                    vh3.sfzh.setText(wbtx.getIdcode());
//                    vh3.yuanyin.setText(wbtx.getYuanyin());
//                    break;
//                case 45:
//                    GxrData.ZstxBean zstx = item.getZstx();
//                    vh3.name.setText(zstx.getZname());
//                    vh3.sfzh.setText(zstx.getZsfzh());
//                    vh3.yuanyin.setText(zstx.getYuanyin());
//                    break;
//            }
//        } else if (item.getType() > 50 && item.getType() < 60) {
//            TrajectoryViewHolder4 vh4 = (TrajectoryViewHolder4) _vh;
//            SimpleCarInfo carInfo = item.getCarInfo();
//            vh4.carCode.setText(carInfo.getCarCode());
//            vh4.carName.setText(carInfo.getCarName());
//            vh4.company.setText(carInfo.getCompany());
//            if (!TextUtils.isEmpty(carInfo.getBelongTo()))
//                vh4.belongTo.setText(carInfo.getBelongTo());
        }
    }

    @Override
    protected int getAdapterItemViewType(int position) {
        int type = getItem(position).getType();
        if (type < 20)
            return 0;
        else if (type > 20 && type < 30) return 1;
        else if (type > 30 && type < 50) {
            return 2;
        } else return 3;
    }

    public void addData(ArrayList<PersonTrajectory> list) {
        if (list != null && list.size() > 0) {
            data.addAll(list);
            Collections.sort(data);
            notifyDataSetChanged();
        }
    }

    @Override
    protected boolean multiItemEnable() {
        return true;
    }

    @Override
    protected int[] getMultiLayout() {
        return new int[]{getDefaultLayout(), R.layout.item_cqd, R.layout.item_gxr, R.layout.item_car_info};
    }

    protected int getAdapterViewTypeCount() {
        return 2;
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.item_trajectory;
    }


    private int getRes(String type) {
        switch (type) {
            case "火车":
                return R.mipmap.train;
            case "酒店名称":
                return R.mipmap.hotel;
            case "卡口过车":
                return R.mipmap.camera;
            case "航空":
                return R.mipmap.airport;
            default:
                return 0;
        }
    }

    public void add(List<PersonTrajectory> obj) {
        data.addAll(obj);
        Collections.sort(data);
        notifyDataSetChanged();
    }

    static class TrajectoryViewHolder extends ViewHolder {
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

        TrajectoryViewHolder(View view) {
            super(view);
        }
    }

    static class TrajectoryViewHolder2 extends ViewHolder {
        @BindView(R.id.toptips)
        TextView toptip;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.counter)
        TextView counter;

        TrajectoryViewHolder2(View view) {
            super(view);
        }
    }

    static class TrajectoryViewHolder3 extends ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.gxId)
        TextView gxId;
        @BindView(R.id.sfzh)
        TextView sfzh;
        @BindView(R.id.yuanyin)
        TextView yuanyin;

        TrajectoryViewHolder3(View view) {
            super(view);
        }
    }

    static class TrajectoryViewHolder4 extends ViewHolder {
        @BindView(R.id.carCode)
        TextView carCode;
        @BindView(R.id.carName)
        TextView carName;
        @BindView(R.id.company)
        TextView company;
        @BindView(R.id.belongTo)
        TextView belongTo;

        TrajectoryViewHolder4(View view) {
            super(view);
        }
    }


}

