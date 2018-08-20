package com.example.android.newsapp11;

import android.content.Context;
import android.net.ParseException;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NewsAdapter extends ArrayAdapter<News> {

    public static final String LOG_TAG = MainActivity.class.getName();

    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        News currentNews = getItem(position);

        viewHolder.webTitleTextView.setText(currentNews.getWebTitle());
        viewHolder.authorTextView.setText(currentNews.getAuthor());
        viewHolder.sectionNameTextView.setText(currentNews.getSectionName());
        viewHolder.webPublicationDateTextView.setText(currentNews.getWebPublicationDate());
        return convertView;
    }

    class ViewHolder {
        private TextView webTitleTextView;
        private TextView authorTextView;
        private TextView sectionNameTextView;
        private TextView webPublicationDateTextView;

        public ViewHolder(@NonNull View view) {
            this.webTitleTextView = (TextView) view.findViewById(R.id.article_title);
            this.authorTextView = (TextView) view.findViewById(R.id.article_author);
            this.sectionNameTextView = (TextView) view.findViewById(R.id.section_name);
            this.webPublicationDateTextView = (TextView) view.findViewById(R.id.date_of_publishing);
        }
    }
}