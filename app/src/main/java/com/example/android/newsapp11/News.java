package com.example.android.newsapp11;

public class News {

    private String mWebTitle;

    private String mSectionName;

    private String mWebPublicationDate;

    private String mWebUrl; //weburl of an article


    public News(String webTitle, String sectionName, String webPublicationDate, String webUrl) {
        mWebTitle = webTitle;
        mSectionName = sectionName;
        mWebUrl = webUrl;
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

    public String getWebUrl() {
        return mWebUrl;
    }


}


