package zhangshengqin.bwie.com.zhangshengqin20180119.model;

import java.util.List;

import io.reactivex.Flowable;
import zhangshengqin.bwie.com.zhangshengqin20180119.bean.DatasBean;
import zhangshengqin.bwie.com.zhangshengqin20180119.bean.MessageBean;
import zhangshengqin.bwie.com.zhangshengqin20180119.presenter.NewsPresenter;
import zhangshengqin.bwie.com.zhangshengqin20180119.utils.RetrofitUtils;

/**
 * Created by 额头发 on 2018/1/19.
 */

public class NewsModel implements IModel{
    private NewsPresenter presenter;



    public NewsModel(NewsPresenter presenter) {

        this.presenter = (NewsPresenter) presenter;

    }



    @Override

    public void getData(String uid, String pid) {

        Flowable<MessageBean<List<DatasBean>>> flowable = RetrofitUtils.getInstance().getApiService().getDatas(uid);

        presenter.getNews(flowable);



    }
}
