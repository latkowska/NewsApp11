package com.example.android.newsapp11;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.text.ParseException;
import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private static final String LOG_TAG = NewsLoader.class.getName();

    private String mWebUrl;

    public NewsLoader(Context context, String webUrl) {
        super(context);
        mWebUrl = webUrl;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<News> loadInBackground() {
        if (mWebUrl == null) {
            return null;
        }

        List<News> news = null;
        try {
            news = QueryUtils.fetchNewsData(mWebUrl);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return news;
    }
}
