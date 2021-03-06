package zhangshengqin.bwie.com.zhangshengqin20180119.api;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import zhangshengqin.bwie.com.zhangshengqin20180119.bean.DatasBean;
import zhangshengqin.bwie.com.zhangshengqin20180119.bean.MessageBean;

/**
 * Created by 额头发 on 2018/1/19.
 */

public interface ApiService {
    @GET("product/getCarts")
    Flowable<MessageBean<List<DatasBean>>> getDatas(@Query("uid") String uid);
    @GET("product/deleteCart")
    Flowable<MessageBean> deleteData(@Query("uid") String uid, @Query("pid") String pid);


}
