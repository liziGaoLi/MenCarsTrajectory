package com.zhhl.analysis.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ReplacementTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.zhhl.analysis.R;
import com.zhhl.analysis.adapter.StringAdapter;
import com.zhhl.analysis.mvp.view.activities.CarTrajectoryAnalysisActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CarAnalysisActivity extends BaseActivity {

    @BindView(R.id.input_block)
    LinearLayout inputBlock;
    @BindView(R.id.mQuery)
    TextView mQuery;
    @BindView(R.id.mCancel)
    TextView mCancel;
    @BindView(R.id.input)
    EditText input;

    @BindView(R.id.floating)
    Button floating;

    private final StringAdapter mTipsAdapter = new StringAdapter();
    private PopupWindow popupWindow;

    private static final ArrayList<String> mHistory = new ArrayList<>();

    class A2bigA extends ReplacementTransformationMethod {

        @Override
        protected char[] getOriginal() {
            return new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        }

        @Override
        protected char[] getReplacement() {
            return new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorAccent));
        ButterKnife.bind(this);
        input.setTransformationMethod(new A2bigA());
        input.setSelection(input.getText().length());

        View mWrapper = View.inflate(this, R.layout.popup_list, null);
        ListView mList = mWrapper.findViewById(R.id.mList);
        mList.setAdapter(mTipsAdapter);
        mTipsAdapter.setData(mHistory);

        mList.setOnItemClickListener((parent, view, position, id) -> {
            input.setText(mTipsAdapter.getItem(position));
            input.setSelection(input.getText().length());
            popupWindow.dismiss();
        });
        showIfNeed();
        popupWindow = new PopupWindow(mWrapper, 800, 700, true);
    }

    @Override
    public int getContentRes() {
        return R.layout.activity_car_analysis;
    }

    private void showIfNeed() {
        floating.setVisibility(mTipsAdapter.getCount() == 0 ? View.GONE : View.VISIBLE);
    }

    @OnClick(R.id.floating)
    void floatingwindow() {
        popupWindow.showAsDropDown(input);
    }

    @OnClick({R.id.mQuery, R.id.mCancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mQuery:
                if (TextUtils.isEmpty(input.getText()) || input.getText().toString().trim().length() < 7) {
                    Toast.makeText(this, "请输入车牌信息", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!mHistory.contains(input.getText().toString().toUpperCase()))
                    mHistory.add(input.getText().toString().toUpperCase());

                showIfNeed();
                if (mHistory.size() > 5) mHistory.remove(0);
                mTipsAdapter.notifyDataSetChanged();

                Intent i = new Intent(this, CarTrajectoryAnalysisActivity.class);
                i.putExtra("idNumber", input.getText().toString().toUpperCase());
                startActivity(i);
                break;
            case R.id.mCancel:
                finish();
                break;
        }
    }

//    @OnClick(R.id.mCamera)
//    void onCapture() {
//        Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//用来打开相机的Intent
//        if (takePhotoIntent.resolveActivity(getPackageManager()) != null) {//这句作用是如果没有相机则该应用不会闪退，要是不加这句则当系统没有相机应用的时候该应用会闪退
//            startActivityForResult(takePhotoIntent, REQ_CODE);//启动相机
//        }
//
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQ_CODE && resultCode == RESULT_OK) {
//            /*缩略图信息是储存在返回的intent中的Bundle中的，
//             * 对应Bundle中的键为data，因此从Intent中取出
//             * Bundle再根据data取出来Bitmap即可*/
//            Bundle extras = data.getExtras();
//            Bitmap bitmap = (Bitmap) extras.get("data");
////            mPicture.setImageBitmap(bitmap);
//        }
//
//    }
//
//    private static final int REQ_CODE = 124;
}
