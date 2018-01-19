package zhangshengqin.bwie.com.zhangshengqin20180119.presenter;


import zhangshengqin.bwie.com.zhangshengqin20180119.bean.DetailsBean;
import zhangshengqin.bwie.com.zhangshengqin20180119.model.Idetailsmodel;
import zhangshengqin.bwie.com.zhangshengqin20180119.model.OnselectDetails;
import zhangshengqin.bwie.com.zhangshengqin20180119.model.model;
import zhangshengqin.bwie.com.zhangshengqin20180119.view.Idetailsview;

/**
 * Created by 额头发 on 2018/1/19.
 */

public class presenterDetails {
    Idetailsview idetailsview;

    Idetailsmodel idetailsmodel;



    public presenterDetails(Idetailsview idetailsview) {

        this.idetailsview = idetailsview;

        idetailsmodel = new model();

    }



    public void getOkDetails(String url, int pid) {

        idetailsmodel.RequestDetails(url, pid, new OnselectDetails() {



            @Override



            public void dataDetailsSuccess(DetailsBean.DataBean list) {

                idetailsview.shouDetails(list);

            }



        });

    }
}
