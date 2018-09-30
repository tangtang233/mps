package cn.net.pwai.mps.basic.wrapper;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author tangwei [toby911115@gmail.com]
 * @date 2018/9/29
 */
public class ResultJsonObject {
    private int code;
    private String msg;
    private Object data;
    private HashMap<String, String> errorData;

    public ResultJsonObject() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public HashMap<String, String> getErrorData() {
        return errorData;
    }

    public void setErrorData(HashMap<String, String> errorData) {
        this.errorData = errorData;
    }

    public ResultJsonObject addData(Object key, Object value) {
        if (this.data == null) {
            this.data = new HashMap();
        }

        if (this.data instanceof Map) {
            ((Map)this.data).put(key, value);
        }

        return this;
    }

    public static ResultJsonObject getResultFromErrors(Errors errors) {
        ResultJsonObject rj = new ResultJsonObject();
        if (errors != null && errors.hasErrors()) {
            HashMap<String, String> errorMap = new HashMap<>();
            List<FieldError> errorlist = errors.getFieldErrors();
            Iterator var4 = errorlist.iterator();

            while(var4.hasNext()) {
                FieldError error = (FieldError)var4.next();
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            rj.setErrorData(errorMap);
            rj.setCode(ResultCode.UNKNOWN_ERROR.code());
        }

        return rj;
    }

    public static ResultJsonObject getDefaultResult(Object data) {
        return getDefaultResult(data, "保存成功");
    }

    public static ResultJsonObject getDefaultResult(Object data, String message) {
        ResultJsonObject rj = new ResultJsonObject();
        rj.setData(data);
        rj.setCode(ResultCode.SUCCESS.code());
        rj.setMsg(message);
        return rj;
    }

    public static ResultJsonObject getErrorResult(Object data, String message) {
        ResultJsonObject rj = new ResultJsonObject();
        rj.setData(data);
        rj.setCode(ResultCode.UNKNOWN_ERROR.code());
        rj.setMsg(message);
        return rj;
    }

    public static ResultJsonObject getErrorResult(Object data) {
        return getErrorResult(data, "保存出错");
    }

    public static ResultJsonObject getNamedResult(HashMap map) {
        return getDefaultResult(map);
    }

    public static ResultJsonObject getNamedResult(Object... data) {
        HashMap<String, Object> map = new HashMap<>();
        Object[] objects = data;
        int count = data.length;

        for(int i = 0; i < count; ++i) {
            Object object = objects[i];
            if (object != null) {
                map.put(object.getClass().getSimpleName().toLowerCase(), object);
            }
        }

        return getNamedResult(map);
    }

    public static <M> ResultJsonObject getNamedResult(String name, M data) {
        HashMap<String, M> map = new HashMap<>(1);
        map.put(name, data);
        return getNamedResult(map);
    }
}
