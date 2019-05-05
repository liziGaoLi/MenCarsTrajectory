package com.zhhl.analysis.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Created by miao on 2018/9/6.
 */
public abstract class BaseAdapter<T, VH extends BaseAdapter.ViewHolder> extends android.widget.BaseAdapter {

    private Context context;
    ArrayList<T> data;

    public BaseAdapter(ArrayList<T> data) {
        this.data = new ArrayList<>(data);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressWarnings("unchecked")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (context == null) context = parent.getContext();
        VH vh;
//        if (convertView == null) {
        int itemViewType = multiItemEnable() ? getAdapterItemViewType(position) : 0;
        convertView = getLayout(parent, itemViewType);
        vh = create(convertView, itemViewType);
        convertView.setTag(vh);
//        } else {
//            vh = (VH) convertView.getTag();
//        }
        bindView(vh, position, getItem(position));
        return convertView;
    }

    int getAdapterItemViewType(int position) {
        return 0;
    }

    /**
     * @param view         convertView
     * @param itemViewType adapter 会根据{@link BaseAdapter#multiItemEnable()}自动选择
     * @return 单个或多个viewholder
     */
    protected abstract VH create(View view, int itemViewType);

    /**
     * 根据viewholder 设置数据
     *
     * @param vh       viewholder
     * @param position item position
     * @param item     data
     */
    protected abstract void bindView(VH vh, int position, T item);

    private View getLayout(ViewGroup parent, int typeId) {
        return View.inflate(parent.getContext(), getLayouts()[typeId], null);
    }

    public ArrayList<T> getData() {
        return data;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addData(ArrayList<T> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void clear() {
        data.clear();
        notifyDataSetChanged();
    }

    /**
     * 使用多类型item layoutId请从此传入
     *
     * @return layoutIds
     */
    int[] getMultiLayout() {
        return new int[0];
    }

    private int[] getLayouts() {
        return multiItemEnable() ? getMultiLayout() : new int[]{getDefaultLayout()};
    }

    protected abstract int getDefaultLayout();

    public abstract static class ViewHolder {
        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }

    /**
     * 多类型开关
     *
     * @return if true 启用多item 类型
     */
    boolean multiItemEnable() {
        return false;
    }

    /**
     * 如果使用多类型item 请重写此方法
     *
     * @return 最大item数量
     */
    int getAdapterViewTypeCount() {
        return 1;
    }

    /**
     * 不要重写此方法 此方法已经为子类实现相应功能
     * see{@link BaseAdapter#getAdapterViewTypeCount()}
     *
     * @return item 数量
     */
    @Override
    public int getViewTypeCount() {
        return multiItemEnable() ? getAdapterViewTypeCount() : 1;
    }
}
