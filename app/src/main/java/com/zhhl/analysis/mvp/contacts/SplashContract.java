package com.zhhl.analysis.mvp.contacts;

import com.zhhl.analysis.common.IModel;
import com.zhhl.analysis.common.IView;

import io.reactivex.Observable;

/**
 * Created by miao on 2018/9/7.
 */

public interface SplashContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {

        void showMain();

        void dismissIndicator();

    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {

        Observable<Boolean> checkPermission(String code, String requiredId);
    }

}