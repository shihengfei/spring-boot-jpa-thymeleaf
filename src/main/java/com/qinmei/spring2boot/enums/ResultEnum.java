package com.qinmei.spring2boot.enums;

/**
 * 自定义异常结果
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月26日上午9:32:38
 */
public enum ResultEnum {

	UNKNOW_ERROR(1,"未知错误"),
    SUCCESS(0,"成功"),
    AGIRL(101,"小学"),
    BGIRL(102,"不是shf")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
