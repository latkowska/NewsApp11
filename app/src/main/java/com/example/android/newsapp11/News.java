package com.example.android.newsapp11;

public class News {

    private String mWebTitle;

    private String mAuthor;

    private String mSectionName;

    private String mWebPublicationDate;

    private String mWebUrl;


    public News(String webTitle, String author, String sectionName, String webPublicationDate, String webUrl) {
        mWebTitle = webTitle;
        mAuthor = author;
        mSectionName = sectionName;
        mWebUrl = webUrl;
        mWebPublicationDate = webPublicationDate;
    }

    public String getWebTitle() {
        return mWebTitle;
    }

    public String getAuthor() {
        return mAuthor;
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


