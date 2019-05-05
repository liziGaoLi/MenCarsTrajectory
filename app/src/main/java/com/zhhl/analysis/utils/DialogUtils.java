package com.zhhl.analysis.utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhhl.analysis.R;
import com.zhhl.analysis.activity.UserInfoActivity;
import com.zhhl.analysis.data.SimpleCarInfo;
import com.zhhl.analysis.mvp.view.activities.CarTrajectoryAnalysisActivity;

import java.util.ArrayList;

/**
 * Created by miao on 2018/11/12.
 */
public class DialogUtils {
    public static ProgressDialog createProgressDialog(Context context) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage("正在加载,请稍后...");
        return dialog;
    }

    public static ProgressDialog createProgressDialog(Context context, String text) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage(text);
        return dialog;
    }

    public static AlertDialog create(Context context, int layout, String name, String sex, String minzu, String xl, String sfzh, String jtzz, ArrayList<String> rylb, String ladw, ArrayList<SimpleCarInfo> carInfo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View inflate = View.inflate(context, layout, null);
        TextView sname = inflate.findViewById(R.id.name);
        TextView sexs = inflate.findViewById(R.id.sex);
        TextView minzus = inflate.findViewById(R.id.type);
        TextView xls = inflate.findViewById(R.id.xl);
        TextView sfzhs = inflate.findViewById(R.id.sfzh);
        TextView jtzzs = inflate.findViewById(R.id.jtzz);
        ImageView sfzImg = inflate.findViewById(R.id.sfzImg);
        sfzImg.setVisibility(View.INVISIBLE);
        LinearLayout mRoot = inflate.findViewById(R.id.mRoot);
        sname.setText(name);
        sexs.setText(sex);
        minzus.setText(minzu == null ? "其它" : minzu);
        xls.setText(xl == null ? "其它" : xl);
        sfzhs.setText(sfzh);
        jtzzs.setText(jtzz);


//        if (rylb.size() > 0) {
//            View.inflate(context, R.layout.rylb, mRoot);
//        }
//        for (int i = 0; i < rylb.size(); i++) {
//            if (i >= 15) {
//                break;
//            }
//            TextView item = mRoot.findViewById(ids[i]);
//            item.setVisibility(View.VISIBLE);
//            item.setText(rylb.get(i));
//        }


//        if (!TextUtils.isEmpty(ladw)) {
//            View view = View.inflate(context, R.layout.view_dwmc, mRoot);
//            TextView content = view.findViewById(R.id.content);
//            content.setText(ladw);
//        }

        LinearLayout mList;
        if (rylb.size() > 0) {
            View view = View.inflate(context, R.layout.rylb2, mRoot);
            mList = view.findViewById(R.id.mListContainer);

            for (int i = 0; i < rylb.size(); i++) {
                View item = View.inflate(context, R.layout.rylb_item, null);
                mList.addView(item);
                TextView tp = item.findViewById(R.id.tp);
                tp.setText(rylb.get(i));
                TextView dw = item.findViewById(R.id.dw);
                if (!TextUtils.isEmpty(ladw)) {
                    dw.setVisibility(View.VISIBLE);
                    dw.setText("(" + ladw + ")");
                } else {
                    dw.setVisibility(View.INVISIBLE);
                }
            }
        }


//        SimpleCarInfo simpleCarInfo = new SimpleCarInfo();
//        simpleCarInfo.setCarCode("ABncjiakdj");
//        carInfo.add(simpleCarInfo);
//        carInfo.add(simpleCarInfo);
//        carInfo.add(simpleCarInfo);
//        carInfo.add(simpleCarInfo);
        for (int i = 0; i < carInfo.size(); i++) {
            View view = View.inflate(context, R.layout.item_car_info_users, null);
            new ViewHolder(i, view, carInfo.get(i));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            mRoot.addView(view, params);
        }

        return builder.setView(inflate)
                .create();
    }


    public static class ViewHolder {

        TextView carId;
        TextView cpTitle;

        ViewHolder(int idx, View view, SimpleCarInfo carInfo) {

            carId = view.findViewById(R.id.carCode);
            cpTitle = view.findViewById(R.id.cp_title);
            carId.setText(carInfo.getCarCode());
            cpTitle.setVisibility(idx == 0 ? View.VISIBLE : View.INVISIBLE);
            view.setOnClickListener((v) -> view.getContext().startActivity(new Intent(view.getContext(), CarTrajectoryAnalysisActivity.class).putExtra("idNumber", carInfo.getCarCode())));
        }
    }


    public static AlertDialog carInfo(Context context, String userName, String userId, String carTypeName, String carColor, String phone) {
        View view = View.inflate(context, R.layout.car_info_car_trajectory, null);
        TextView mName = view.findViewById(R.id.mName);
        TextView mIdNumber = view.findViewById(R.id.mIdNumber);
        TextView mTypeName = view.findViewById(R.id.mTypeName);
        TextView mCarColor = view.findViewById(R.id.mCarColor);
        TextView mPhone = view.findViewById(R.id.mPhone);

        if (!TextUtils.isEmpty(userName)) {
            mName.setText(userName);
        }
        if (!TextUtils.isEmpty(userId)) {
            mIdNumber.setText(userId);
        }
        if (!TextUtils.isEmpty(carTypeName)) {
            mTypeName.setText(carTypeName);
        }
        if (!TextUtils.isEmpty(carColor)) {
            mCarColor.setText(carColor);
        }
        if (!TextUtils.isEmpty(phone)) {
            mPhone.setText(phone);
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setView(view);
        return builder.create();
    }

    public static AlertDialog tips(Context context, String msg, DialogInterface.OnClickListener
            ok, DialogInterface.OnClickListener cancel) {
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setMessage(msg)
                .setPositiveButton("查询", ok)
                .setNegativeButton("取消", cancel)
                .create();
//        alertDialog.getButton(alertDialog.BUTTON_POSITIVE).setTextColor(context.getResources().getColor(R.color.colorAccent));
//        alertDialog.getButton(alertDialog.BUTTON_NEGATIVE).setTextColor(context.getResources().getColor(R.color.colorAccent));
        alertDialog.setCancelable(false);
        return alertDialog;
    }


}
