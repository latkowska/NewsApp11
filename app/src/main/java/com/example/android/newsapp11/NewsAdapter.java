package com.example.android.newsapp11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the position of the object located at list
        News currentNews = getItem(position);

        TextView webTitleTextView = (TextView) listItemView.findViewById(R.id.article_title);
        webTitleTextView.setText(currentNews.getWebTitle());

        TextView sectionTextView = (TextView) listItemView.findViewById(R.id.section_name);
        sectionTextView.setText(currentNews.getSectionName());

        TextView webPublicationDateTextView = (TextView) listItemView.findViewById(R.id.date_of_publishing);
        webPublicationDateTextView.setText(currentNews.getWebPublicationDate());

        return listItemView;
    }
}
