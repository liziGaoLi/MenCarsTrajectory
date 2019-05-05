package com.zhhl.analysis.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
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
import com.zhhl.analysis.mvp.view.activities.PersonTrajectoryAnalysisActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonAnalysisActivity extends BaseActivity {

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

    private boolean isInputReady = false;
    private final StringAdapter mTipsAdapter = new StringAdapter();
    private PopupWindow popupWindow;

    private static final ArrayList<String> mHistory = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorOrange));

        ButterKnife.bind(this);

        View mWrapper = View.inflate(this, R.layout.popup_list, null);
        ListView mList = mWrapper.findViewById(R.id.mList);
        mList.setAdapter(mTipsAdapter);
        mTipsAdapter.setData(mHistory);
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                char[] chars = s.toString().toCharArray();
                if (chars.length < 15) isInputReady = false;
                if (chars.length > 18) {
                    isInputReady = false;
                    return;
                }
                if (chars.length <= 17) {
                    for (char aChar : chars) {
                        if (!Character.isDigit(aChar)) {
                            isInputReady = false;
                            Toast.makeText(PersonAnalysisActivity.this, "您输入的身份证号码格式不正确", Toast.LENGTH_SHORT).show();
                            break;
                        } else {
                            isInputReady = true;
                        }
                    }
                } else {
                    if (isInputReady && !Character.isDigit(chars[17]) && chars[17] != 'x' && chars[17] != 'X') {

                        Log.e("afterTextChanged: ", Character.isDigit(chars[17]) + "");
                        Log.e("afterTextChanged: ", (chars[17] == 'x') + "");
                        Log.e("afterTextChanged: ", (chars[17] == 'X') + "");
                        Toast.makeText(PersonAnalysisActivity.this, "您输入的身份证号码格式不正确", Toast.LENGTH_SHORT).show();
                        isInputReady = false;
                    }
                }
                if (chars.length < 15) isInputReady = false;
            }
        });
        mList.setOnItemClickListener((parent, view, position, id) -> {
            input.setText(mTipsAdapter.getItem(position));
            input.setSelection(input.getText().length());
            isInputReady = true;
            popupWindow.dismiss();
        });
        showIfNeed();
        popupWindow = new PopupWindow(mWrapper, 800, 700, true);
    }

    @Override
    public int getContentRes() {
        return R.layout.activity_person_analysis;
    }

    private void showIfNeed() {
        floating.setVisibility(mTipsAdapter.getCount() == 0 ? View.GONE : View.VISIBLE);
    }


    @OnClick(R.id.floating)
    void floatingWindow() {
        popupWindow.showAsDropDown(input);
    }

    @OnClick({R.id.mQuery, R.id.mCancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mQuery:
                if (TextUtils.isEmpty(input.getText())) {
                    Toast.makeText(this, "请输入身份证号码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!isInputReady) {
                    Toast.makeText(this, "身份证号码格式不正确,请检查身份证号码格式", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (input.getText().toString().length() != 15&&input.getText().toString().length()!=18) {
                    Toast.makeText(this, "身份证号码格式不正确,请检查身份证号码格式", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!mHistory.contains(input.getText().toString()))
                    mHistory.add(input.getText().toString());
                showIfNeed();
                if (mHistory.size() > 5) mHistory.remove(0);
                mTipsAdapter.notifyDataSetChanged();
                Intent intent = new Intent(this, PersonTrajectoryAnalysisActivity.class);
                intent.putExtra("idNumber", input.getText().toString());
                startActivity(intent);
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
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode==REQ_CODE&&resultCode==RESULT_OK){
//            /*缩略图信息是储存在返回的intent中的Bundle中的，
//             * 对应Bundle中的键为data，因此从Intent中取出
//             * Bundle再根据data取出来Bitmap即可*/
//            Bundle extras = data.getExtras();
//            Bitmap bitmap = (Bitmap) extras.get("data");
////            mPicture.setImageBitmap(bitmap);
//        }
//
//    }

//    private static final int REQ_CODE = 124;


}
