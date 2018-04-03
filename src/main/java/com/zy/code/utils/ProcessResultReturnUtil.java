package com.zy.code.utils;

public class ProcessResultReturnUtil {

    public static ProcessResult successProcessResult(){
        return new ProcessResult(CodeMessageConstants.SUCCESS);
    }

    public static ProcessResult failProcessResult(){
        return new ProcessResult(CodeMessageConstants.SERVER_ERROR);
    }

    public static ProcessResult saveSuccessProcessResult(){
        return new ProcessResult(CodeMessageConstants.SAVE_SUCESS);
    }

    public static ProcessResult saveFailProcessResult(){
        return new ProcessResult(CodeMessageConstants.SAVE_FAIL);
    }

    public static ProcessResult updateSuccessProcessResult(){
        return new ProcessResult(CodeMessageConstants.UPDATE_SUCESS);
    }

    public static ProcessResult updateFailProcessResult(){
        return new ProcessResult(CodeMessageConstants.UPDATE_FAIL);
    }

    public static ProcessResult deleteSuccessProcessResult(){
        return new ProcessResult(CodeMessageConstants.DELETE_SUCESS);
    }

    public static ProcessResult deleteFailProcessResult(){
        return new ProcessResult(CodeMessageConstants.DELETE_FAIL);
    }

    public static ProcessResult querySuccessProcessResult(){
        return new ProcessResult(CodeMessageConstants.QUERY_SUCESS);
    }

    public static ProcessResult queryFailProcessResult(){
        return new ProcessResult(CodeMessageConstants.QUERY_FAIL);
    }

}
