package com.zy.code.utils;

import java.util.HashMap;
import java.util.Map;

public class ProcessResult {

    private Integer status = 0;

    private String  message;

    private Map<String,Object> data = new HashMap<>();

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

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public ProcessResult(CodeMessageConstants codeMessageConstants) {
        this.status = codeMessageConstants.getStatus();
        this.message = codeMessageConstants.getMessage();
    }

    public ProcessResult() {
    }
}
