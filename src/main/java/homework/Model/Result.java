package homework.Model;

import java.io.Serializable;

public class Result<D> implements Serializable {
    private boolean success = false;
    private int code;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public Result<D> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result<D> setMessage(String message) {
        this.message = message;
        return this;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    private String message;
    private D data;

    public static <T> Result<T> create() {
        return new Result<T>();
    }
}
