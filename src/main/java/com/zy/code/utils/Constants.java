package com.zy.code.utils;

public enum Constants {

    SERVER_ERROR(500,"服务器错误"),
    PARAMIN_ERROR(501,"传入参数错误"),
    PARAMNULL_ERROR(502,"必填参数为空"),
    SUCCESS(0,"成功");


    private Integer status;
    private String message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    Constants(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
