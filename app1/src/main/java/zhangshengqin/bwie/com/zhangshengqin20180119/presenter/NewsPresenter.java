package zhangshengqin.bwie.com.zhangshengqin20180119.presenter;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import zhangshengqin.bwie.com.zhangshengqin20180119.bean.DatasBean;
import zhangshengqin.bwie.com.zhangshengqin20180119.bean.MessageBean;
import zhangshengqin.bwie.com.zhangshengqin20180119.model.NewsModel;
import zhangshengqin.bwie.com.zhangshengqin20180119.view.Iview;

/**
 * Created by 额头发 on 2018/1/19.
 */

public class NewsPresenter implements BasePresenter{
    private Iview iv;

    private DisposableSubscriber subscriber1;



    public void attachView(Iview iv) {

        this.iv = iv;

    }



    public void detachView() {

        if (iv != null) {

            iv = null;

        }

        if (!subscriber1.isDisposed()){

            subscriber1.dispose();

        }



    }



    @Override

    public void getData(String uid,String pid) {

        NewsModel model = new NewsModel(this);

        model.getData(uid,pid);

    }



    public void getNews(Flowable<MessageBean<List<DatasBean>>> flowable) {

        subscriber1 = flowable.subscribeOn(Schedulers.io())

                .observeOn(AndroidSchedulers.mainThread())

                .subscribeWith(new DisposableSubscriber<MessageBean<List<DatasBean>>>() {

                    @Override

                    public void onNext(MessageBean<List<DatasBean>> listMessageBean) {

                        if (listMessageBean != null) {

                            List<DatasBean> list = listMessageBean.getData();

                            if (list != null) {

                                iv.onSuccess(list);

                            }



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
