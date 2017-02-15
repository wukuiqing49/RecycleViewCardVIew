package com.wkq.recyclerviewcardview;

import java.io.Serializable;

/**
 * ================================================
 * 作者：WKQ
 * 时间:  2017/2/15 11:22
 * 用途:
 * 备注:
 * <p>
 * ================================================
 */

public class DetailInfo implements Serializable{


    private String text;
    private String url;
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
