package com.qinmei.spring2boot.utils;

import com.qinmei.spring2boot.domain.Result;

/**
 * 统一返回对象
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月26日上午9:28:03
 */
public class ResultUtil {

	/**
     * 请求成功返回
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("添加成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    /**
     * 请求失败返回
     * @param code
     * @param msg
     * @return
     */
    public static Result error(int code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}
