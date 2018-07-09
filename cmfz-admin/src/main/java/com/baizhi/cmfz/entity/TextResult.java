package com.baizhi.cmfz.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:
 *
 * @author future_zwp
 * @create 2018-07-08 21:52
 */
@Component
@Scope("prototype")
public class TextResult implements Serializable {

    private Integer errno;
    private List<String> data;

    public TextResult() {
        super();
    }

    public Integer getErrno() {
        return errno;
    }

    @Override
    public String toString() {
        return "TextResult{" +
                "errno=" + errno +
                ", data=" + data +
                '}';
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
