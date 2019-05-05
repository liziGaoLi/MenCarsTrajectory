//package com.zhhl.analysis.adapter;
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.FrameLayout;
//import android.widget.TextView;
//
//import com.zhhl.analysis.R;
//import com.zhhl.analysis.RecyclerOnItemClick;
//
//import java.util.ArrayList;
//
///**
// * Created by miao on 2018/11/25.
// */
//public class HorName extends RecyclerView.Adapter<HorName.VH> implements View.OnClickListener {
//
//    private final Context context;
//    private RecyclerOnItemClick click;
//
//    public HorName(Context context) {
//
//        this.context = context;
//    }
//
//    public void setClick(RecyclerOnItemClick click) {
//        this.click = click;
//    }
//
//    public ArrayList<String> getNames() {
//        return names;
//    }
//
//    public void setNames(ArrayList<String> names) {
//        this.names = names;
//        notifyDataSetChanged();
//    }
//
//    public void addNames(ArrayList<String> names) {
//        this.names.addAll(names);
//        notifyDataSetChanged();
//    }
//
//    private ArrayList<String> names = new ArrayList<>();
//
//
//    @NonNull
//    @Override
//    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View inflate = LayoutInflater.from(context).inflate(R.layout.item_rec_text, viewGroup, false);
//        return new VH(inflate);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull VH vh, int i) {
//        vh.mText.setText(names.get(i));
//        vh.mTextWrapper.setTag(i);
//        vh.mTextWrapper.setOnClickListener(this);
//    }
//
//    @Override
//    public int getItemCount() {
//        return names.size();
//    }
//
//    @Override
//    public void onClick(View v) {
//        if (click != null)
//            click.onItemClick(v, (Integer) v.getTag());
//    }
//
//    public class VH extends RecyclerView.ViewHolder {
//
//        private final TextView mText;
//        private final FrameLayout mTextWrapper;
//
//
//        VH(@NonNull View itemView) {
//            super(itemView);
//            mText=itemView.findViewById(R.id.mText);
//            mTextWrapper=itemView.findViewById(R.id.mTextWrapper);
//        }
//    }
//}
