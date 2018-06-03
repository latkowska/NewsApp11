package com.example.android.newsapp11;

public class News {

    private String mHeadline;
    private String mSectionName;
    private String mWebPublicationDate;
    private String mWebUrl;
    private String mByline; //author's name


    public News(String headline, String sectionName, String webPublicationDate, String webUrl, String byline) {
        mHeadline = headline;
        mSectionName = sectionName;
        mWebUrl = webUrl;
        mWebPublicationDate = webPublicationDate;
        mByline = byline;
    }

    public String getHeadline() {
        return mHeadline;
    }
    public String getSectionName() {
        return mSectionName;
    }
    public String getWebPublicationDate() {
        return mWebPublicationDate;
    }
    public String getWebUrl() {
        return mWebUrl;
    }
    public String getByline() {
        return mByline;
    }
}


