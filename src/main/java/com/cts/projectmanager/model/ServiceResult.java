package com.cts.projectmanager.model;

import java.util.List;


public class ServiceResult<T> extends PmBase {
	private T data;
	private List<T> dataList;
    boolean success;
    private PmError error;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public PmError getError() {
        return error;
    }

    public void setError(PmError error) {
        this.error = error;
    }

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
}
