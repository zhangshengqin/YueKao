package zhangshengqin.bwie.com.zhangshengqin20180119.presenter;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import zhangshengqin.bwie.com.zhangshengqin20180119.bean.MessageBean;
import zhangshengqin.bwie.com.zhangshengqin20180119.model.DelModel;
import zhangshengqin.bwie.com.zhangshengqin20180119.view.Iview;

/**
 * Created by 额头发 on 2018/1/19.
 */

public class DelPresenter implements BasePresenter {
    private Iview iv;

    private DisposableSubscriber subscriber2;



    public void attachView(Iview iv) {

        this.iv = iv;

    }



    public void detachView() {

        if (iv != null) {

            iv = null;

        }



        if (!subscriber2.isDisposed()){

            subscriber2.dispose();

        }



    }



    @Override

    public void getData(String uid,String pid) {

        DelModel model = new DelModel(this);

        model.getData(uid,pid);

    }



    public void delData(Flowable<MessageBean> delFlowable) {

        subscriber2 = delFlowable.subscribeOn(Schedulers.io())

                .observeOn(AndroidSchedulers.mainThread())

                .subscribeWith(new DisposableSubscriber<MessageBean>() {

                    @Override

                    public void onNext(MessageBean listMessageBean) {

                        if (listMessageBean != null) {

                            iv.delSuccess(listMessageBean);



                        }



                    }



                    @Override

                    public void onError(Throwable t) {

                        iv.onFailed((Exception) t);

                    }



                    @Override

                    public void onComplete() {



                    }



                });

    }
}
