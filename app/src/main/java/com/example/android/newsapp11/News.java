package com.example.android.newsapp11;

public class News {

    private String mWebTitle;

    private String mSectionName;

    private String mWebPublicationDate;

    private String mUrl; //url of an article

    public News(String webTitle, String sectionName, String webPublicationDate, String url) {
        mWebTitle = webTitle;
        mSectionName = sectionName;
        mUrl = url;
        mWebPublicationDate = webPublicationDate;
    }

    public String getWebTitle() {
        return mWebTitle;
    }

    public String getSectionName() {
        return mSectionName;
    }

    public String getWebPublicationDate() {
        return mWebPublicationDate;
    }

    public String getUrl() {
        return mUrl;
    }
}


