package com.baizhi.cmfz.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 描述:上师实体类
 *
 * @author future_zwp
 * @create 2018-07-06 16:52
 */
@Component
@Scope("prototype")
public class Guru implements Serializable {

    private String guruId;
    private String guruName;//上师法名
    private String guruPhoto;//上师头像
    private String guruIntro;//上师简介


    @Override
    public String toString() {
        return "Guru{" +
                "guruId='" + guruId + '\'' +
                ", guruName='" + guruName + '\'' +
                ", guruPhoto='" + guruPhoto + '\'' +
                ", guruIntro='" + guruIntro + '\'' +
                '}';
    }

    public Guru() {
        super();
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    public String getGuruName() {
        return guruName;
    }

    public void setGuruName(String guruName) {
        this.guruName = guruName;
    }

    public String getGuruPhoto() {
        return guruPhoto;
    }

    public void setGuruPhoto(String guruPhoto) {
        this.guruPhoto = guruPhoto;
    }

    public String getGuruIntro() {
        return guruIntro;
    }

    public void setGuruIntro(String guruIntro) {
        this.guruIntro = guruIntro;
    }
}
