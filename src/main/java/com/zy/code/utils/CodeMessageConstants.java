package com.zy.code.utils;

public enum CodeMessageConstants {

    SUCCESS(0,"成功"),
    SERVER_ERROR(500,"服务器错误"),
    PARAMIN_ERROR(501,"传入参数错误"),
    PARAMNULL_ERROR(502,"必填参数为空"),
    SAVE_SUCESS(503,"保存成功"),
    UPDATE_SUCESS(504,"更新成功"),
    DELETE_SUCESS(505,"删除成功"),
    QUERY_SUCESS(506,"删除成功"),
    SAVE_FAIL(507,"保存失败"),
    UPDATE_FAIL(508,"更新失败"),
    DELETE_FAIL(509,"删除失败"),
    QUERY_FAIL(510,"查询失败"),
    SCORE_SIZE_LESS(511,"样本数据过于小，请完善相关成绩信息");


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

    CodeMessageConstants() {
    }

    CodeMessageConstants(Integer status, String message) {
        this.status = status;
        this.message = message;
    }


}
