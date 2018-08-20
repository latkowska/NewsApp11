package com.example.android.newsapp11;

public class News {

<<<<<<< HEAD
    private String mWebTitle;

    private String mAuthor;

=======
    private String mHeadline;
>>>>>>> 01dcbca55b69d79263d72cba52dbd1e53d613188
    private String mSectionName;
    private String mWebPublicationDate;
    private String mWebUrl;
    private String mByline; //author's name


<<<<<<< HEAD
    public News(String webTitle, String author, String sectionName, String webPublicationDate, String webUrl) {
        mWebTitle = webTitle;
        mAuthor = author;
=======
    public News(String headline, String sectionName, String webPublicationDate, String webUrl, String byline) {
        mHeadline = headline;
>>>>>>> 01dcbca55b69d79263d72cba52dbd1e53d613188
        mSectionName = sectionName;
        mWebUrl = webUrl;
        mWebPublicationDate = webPublicationDate;
        mByline = byline;
    }

    public String getHeadline() {
        return mHeadline;
    }
<<<<<<< HEAD

    public String getAuthor() {
        return mAuthor;
    }

=======
>>>>>>> 01dcbca55b69d79263d72cba52dbd1e53d613188
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


