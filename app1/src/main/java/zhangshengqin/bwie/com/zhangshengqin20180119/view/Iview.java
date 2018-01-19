package zhangshengqin.bwie.com.zhangshengqin20180119.view;

import zhangshengqin.bwie.com.zhangshengqin20180119.bean.MessageBean;

/**
 * Created by 额头发 on 2018/1/19.
 */

public interface Iview {
    void onSuccess(Object o);
    void onFailed(Exception e);
    void delSuccess(MessageBean listMessageBean);
}
