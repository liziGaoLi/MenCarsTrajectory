package com.zhhl.analysis.adapter;

import android.view.View;
import android.widget.TextView;

import com.zhhl.analysis.R;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by miao on 2018/12/5.
 */
public class StringAdapter extends BaseAdapter<String, StringAdapter.StringViewHolder> {

    public StringAdapter() {
        super(new ArrayList<>());
    }

    public StringAdapter(ArrayList<String> data) {
        super(data);
    }

    @Override
    protected StringViewHolder create(View view, int itemViewType) {
        return new StringViewHolder(view);
    }

    @Override
    protected void bindView(StringViewHolder vh, int position, String item) {
        vh.text1.setText(item);
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.item_history;
    }

    class StringViewHolder extends BaseAdapter.ViewHolder {

        @BindView(R.id.mText)
        TextView text1;


        StringViewHolder(View view) {
            super(view);
        }
    }
}
