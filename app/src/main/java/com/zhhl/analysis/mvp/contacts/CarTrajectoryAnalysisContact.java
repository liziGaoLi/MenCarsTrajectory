package com.zhhl.analysis.mvp.contacts;

import com.zhhl.analysis.common.IModel;
import com.zhhl.analysis.common.IView;
import com.zhhl.analysis.data.CarInformation;
import com.zhhl.analysis.data.CarTrajectory;
import com.zhhl.analysis.data.CarTrajectoryBayonet;

import java.util.ArrayList;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created by miao on 2019/2/28.
 */

public interface CarTrajectoryAnalysisContact {
    interface View extends IView {

        void putData(CarInformation o);

        void changeData(ArrayList<CarTrajectory> mData);

        void dialogDismiss();
    }

    interface Model extends IModel {

        Observable<CarTrajectoryBayonet> customDateTrajectory(String idNumber, String start, String end);

        Observable<CarInformation> carInformation(String idNumber);

        Observable<CarTrajectoryBayonet> carTrajectoryOneToThree(String idNumber, String code);
    }

}