package com.zhhl.analysis.mvp.contacts;

import com.zhhl.analysis.common.IModel;
import com.zhhl.analysis.common.IView;
import com.zhhl.analysis.data.ChangQuDiData;
import com.zhhl.analysis.data.GxclData;
import com.zhhl.analysis.data.GxrData2;
import com.zhhl.analysis.data.PersonTrajectory;
import com.zhhl.analysis.data.PersonTrajectoryNoId;
import com.zhhl.analysis.data.PersonTrajectorySZQY;
import com.zhhl.analysis.data.PersonTrajectoryUnLock;
import com.zhhl.analysis.data.SelfTrajectoryData;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by miao on 2019/1/17.
 */

public interface PersonTrajectoryAnalysisContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {

        void showRequestDialog();

        void dismissRequestDialog();

        void addData(ArrayList<PersonTrajectory> data);

        void setTrajectoryName(String xm);

        void clearAdapter();

        void setGxrAdapter(ArrayList<PersonTrajectory> transitionWrapper);

        void setGxclAdapter(GxclData o);

        void setExceptionPerson(boolean isException);
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {

        Observable<PersonTrajectoryNoId> noId(String idNumber, String start, String end);

        Observable<PersonTrajectorySZQY> szqy(String idNumber, String start, String end);

        Observable<PersonTrajectoryUnLock> unlock(String idNumber, String start, String end);

        Observable<SelfTrajectoryData> trajectory0(String idNumber, String start, String end, String value);

//        Observable<HunyinGuiji> trajectory1(String idNumber, String start, String end, String value);

//        Observable<GxrData> trajectoryGxr(String idNumber);

        Observable<ChangQuDiData> getChangQuDi(String idNumber, String start, String end, String value);

        Observable<GxclData> trajectoryGxcl(String idNumber);

        Observable<GxrData2> trajectoryGxr(String idNumber, String start, String end);
    }

}