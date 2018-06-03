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

        News currentNews = getItem(position);

        TextView headlineTextView = (TextView) listItemView.findViewById(R.id.article_title);
        headlineTextView.setText(currentNews.getHeadline());

        TextView sectionTextView = (TextView) listItemView.findViewById(R.id.section_name);
        sectionTextView.setText(currentNews.getSectionName());

        if(currentNews.getWebPublicationDate() != null) {
            TextView webPublicationDateTextView = (TextView) listItemView.findViewById(R.id.date_of_publishing);
            webPublicationDateTextView.setText(currentNews.getWebPublicationDate());
        } else {
            System.out.println("Publication date unknown.");
        }

        if(currentNews.getByline() != null) {
            TextView authorTextView = (TextView) listItemView.findViewById(R.id.author);
            authorTextView.setText(currentNews.getByline());
        } else {
            System.out.println("Authors name unknown.");
        }

        return listItemView;
    }
}
