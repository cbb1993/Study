package com.andy.study.设计模式.简单工厂;

/**
 * Created by 斌斌.
 * Date: 2019/4/9
 * Time: 9:54
 * describe: 生产产品的工厂
 */
public class SimpleFactory {
    /**
     * @param type  生产产品类型
    * */
    public static SimpleApi createApi(int type){
        SimpleApi api =null;
        switch (type){
            case 1:
                api = new ImpPhone();
                break;
            case 2:
                api = new ImpPad();
                break;
            default:
                api = new ImpPhone();
                break;
        }
        return api;
    }
}
