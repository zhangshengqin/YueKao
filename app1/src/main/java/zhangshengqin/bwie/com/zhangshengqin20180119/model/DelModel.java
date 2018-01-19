package zhangshengqin.bwie.com.zhangshengqin20180119.model;


import io.reactivex.Flowable;
import zhangshengqin.bwie.com.zhangshengqin20180119.bean.MessageBean;
import zhangshengqin.bwie.com.zhangshengqin20180119.presenter.DelPresenter;
import zhangshengqin.bwie.com.zhangshengqin20180119.utils.RetrofitUtils;

/**
 * Created by 额头发 on 2018/1/19.
 */

public class DelModel implements IModel {
    private DelPresenter presenter;



    public DelModel(DelPresenter presenter){

        this.presenter =  presenter;

    }



    @Override

    public void getData(String uid,String pid) {

        Flowable<MessageBean> delFlowable = RetrofitUtils.getInstance().getApiService().deleteData(uid,pid);

        presenter.delData(delFlowable);

    }
}
