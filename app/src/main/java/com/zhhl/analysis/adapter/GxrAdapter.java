package com.zhhl.analysis.adapter;

import android.view.View;
import android.widget.TextView;

import com.zhhl.analysis.R;
import com.zhhl.analysis.data.GxrData2;
import com.zhhl.analysis.data.PersonTrajectory;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;

/**
 * Created by miao on 2019/1/24.
 */
public class GxrAdapter extends BaseAdapter<PersonTrajectory, GxrAdapter.GxrViewHolder> {

    public GxrAdapter(ArrayList<PersonTrajectory> data) {
        super(data);
    }

    @Override
    protected GxrViewHolder create(View view, int itemViewType) {
        return new GxrViewHolder(view);
    }

//    private ArrayList<GxrData2.HbtxBean> hbtx2;//46
//    private ArrayList<GxrData2.HctxBean> hctx2;//47
//    private ArrayList<GxrData2.KctxBean> kctx2;//48
//    private ArrayList<GxrData2.ZstxBean> zstx2;//49
//    private ArrayList<GxrData2.HclzBean> hclz2;//50

    @Override
    protected void bindView(GxrViewHolder viewHolder, int position, PersonTrajectory item) {
        if (item.getType() >= 46 && item.getType() <= 50)
            switch (item.getType()) {
                case 46:
                    ArrayList<GxrData2.HbtxBean> hbtx2 = item.getHbtx2();
                    viewHolder.name.setText(hbtx2.get(0).getXm());
                    viewHolder.sfzh.setText(hbtx2.get(0).getZjhm());
                    viewHolder.yuanyin.setText("航班同行:" + hbtx2.size() + "次");
                    break;
                case 47:
                    ArrayList<GxrData2.HctxBean> hctx = item.getHctx2();
                    viewHolder.name.setText(hctx.get(0).getXm());
                    viewHolder.sfzh.setText(hctx.get(0).getGmsfhm());
                    viewHolder.yuanyin.setText("火车同行:" + hctx.size() + "次");
                    break;
                case 48:
                    ArrayList<GxrData2.KctxBean> kctx2 = item.getKctx2();
                    viewHolder.name.setText(kctx2.get(0).getCkXm());
                    viewHolder.sfzh.setText(kctx2.get(0).getZjqfZjhm());
                    viewHolder.yuanyin.setText("客车同行:" + kctx2.size() + "次");
                    break;
                case 49:
                    ArrayList<GxrData2.ZstxBean> zstx = item.getZstx2();
                    viewHolder.name.setText(zstx.get(0).getXm());
                    viewHolder.sfzh.setText(zstx.get(0).getGmsfhm());
                    viewHolder.yuanyin.setText("同住:" + zstx.size() + "次");
                    break;
                case 50:
                    ArrayList<GxrData2.HclzBean> hclz = item.getHclz2();
                    viewHolder.name.setText(hclz.get(0).getXm());
                    viewHolder.sfzh.setText(hclz.get(0).getGmsfhm());
                    viewHolder.yuanyin.setText("火车邻座:" + hclz.size() + "次");
                    break;
            }
        else if (item.getType() >= 33 && item.getType() <= 34) {
            switch (item.getType()) {
                case 33:
                    GxrData2.HunyinBean hunyin2 = item.getHunyin2();
                    viewHolder.name.setText(hunyin2.getPeiou());
                    viewHolder.sfzh.setText(hunyin2.getPeioucode());
                    viewHolder.yuanyin.setText("(与本人关系:配偶)");
                    break;
                case 34:
                    GxrData2.QinshuBean qinshu = item.getQinshu2();
                    viewHolder.name.setText(qinshu.getXm());
                    viewHolder.sfzh.setText(qinshu.getGmsfhm());
                    viewHolder.yuanyin.setText("(与户主关系:" + qinshu.getYhzgxdm() + ")");
                    break;
            }
        }
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.item_gxr_2;
    }

    @Override
    public void setData(ArrayList<PersonTrajectory> data) {
        Collections.sort(data);
        super.setData(data);
    }

    static
    class GxrViewHolder extends BaseAdapter.ViewHolder {
        @BindView(R.id.textView2)
        TextView textView2;
        @BindView(R.id.textView4)
        TextView textView4;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.sfzh)
        TextView sfzh;
        @BindView(R.id.yuanyin)
        TextView yuanyin;

        public GxrViewHolder(View view) {
            super(view);
        }
    }
}
