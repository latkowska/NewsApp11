package com.example.android.newsapp11;

import android.net.ParseException;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class QueryUtils {

    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    private QueryUtils() {
    }

    public static List<News> fetchNewsData(String requestUrl) throws java.text.ParseException {

        URL url = createUrl(requestUrl);

        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        List<News> news = extractFeatureFromJson(jsonResponse);

        return news;
    }

    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem with building the URL ", e);
        }
        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the news JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    private static List<News> extractFeatureFromJson(String newsJSON) throws java.text.ParseException {

        if (TextUtils.isEmpty(newsJSON)) {
            return null;
        }

        List<News> news = new ArrayList<>();

        try {

            JSONObject baseJsonResponse = new JSONObject(newsJSON);
            JSONObject response = baseJsonResponse.getJSONObject("response");
            JSONArray results = response.getJSONArray("results");

            for (int i = 0; i < results.length(); i++) {

<<<<<<< HEAD
            JSONArray newsArray = firstObject.getJSONArray("results");

            for (int i = 0; i < newsArray.length(); i++) {

                JSONObject currentNews = newsArray.getJSONObject(i);

                String author = "";



                String webTitle = currentNews.getString("webTitle");

                String sectionName = currentNews.getString("sectionName");

                String webPublicationDate = currentNews.getString("webPublicationDate");

                webPublicationDate = dateFormat(webPublicationDate);

                String webUrl = currentNews.getString("webUrl");

                news.add(new News(webTitle, author, sectionName, webPublicationDate, webUrl));
=======
                JSONObject resultsContent = results.getJSONObject(i);
                String sectionName = resultsContent.getString("sectionName");
                String webPublicationDate = resultsContent.getString("webPublicationDate");
                String webUrl = resultsContent.getString("webUrl");

                JSONObject fieldsContent = resultsContent.getJSONObject("fields");
                String headline = fieldsContent.getString("headline");
                String byline = fieldsContent.getString("byline");

                news.add(new News(headline, sectionName, webPublicationDate, webUrl, byline));
>>>>>>> 01dcbca55b69d79263d72cba52dbd1e53d613188
            }

        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the news JSON results", e);
        }
        return news;
    }

    private static String dateFormat(String webPublicationDate) throws java.text.ParseException {
        String jsonDateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        SimpleDateFormat jsonFormatDate = new SimpleDateFormat(jsonDateFormat, Locale.GERMANY);
        try {
            Date parsedJsonDate = jsonFormatDate.parse(webPublicationDate);
            String finalDateFormat = "MMM d, yyy";
            SimpleDateFormat finalDateFormatis = new SimpleDateFormat(finalDateFormat, Locale.GERMANY);
            return finalDateFormatis.format(parsedJsonDate);
        } catch (ParseException e) {
            Log.e("QueryUtils", "Error parsing JSON date", e);
            return "";
        }
    }
}


