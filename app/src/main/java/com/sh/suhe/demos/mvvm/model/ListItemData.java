package com.sh.suhe.demos.mvvm.model;

/**
 * Created by suhe on 2017/2/27.
 * com.sh.suhe.demos.mvvm.model
 */

public class ListItemData {
    private String title;
    private int state;
    private String url;

    public ListItemData(String title,int state,String url){
        this.title = title;
        this.state = state;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
