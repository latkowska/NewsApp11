package com.example.android.newsapp11;

import android.content.Context;
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

public class NewsAdapter extends ArrayAdapter<News> {

    public static final String LOG_TAG = MainActivity.class.getName();

    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        News currentNews = getItem(position);

        String date = currentNews.getWebPublicationDate();

        viewHolder.webTitleTextView.setText(currentNews.getWebTitle());
        viewHolder.authorTextView.setText(currentNews.getAuthor());
        viewHolder.sectionNameTextView.setText(currentNews.getSectionName());
        viewHolder.webPublicationDateTextView.setText(convertDate(date));

        return convertView;
    }
        /**View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        News currentNews = getItem(position);

        TextView webTitleTextView = (TextView) listItemView.findViewById(R.id.article_title);
        webTitleTextView.setText(currentNews.getWebTitle());

        TextView authorTextView = (TextView) listItemView.findViewById(R.id.article_author);
        authorTextView.setText(currentNews.getAuthor());

        TextView sectionTextView = (TextView) listItemView.findViewById(R.id.section_name);
        sectionTextView.setText(currentNews.getSectionName());




        TextView webPublicationDateTextView = (TextView) listItemView.findViewById(R.id.date_of_publishing);
        webPublicationDateTextView.setText(currentNews.getWebPublicationDate());

       /** long timeInMilliseconds = 1454124312220L;
        Date dateObject = new Date(timeInMilliseconds);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String web = dateFormatter.format(dateObject);
*/

    /*
    }

    /*
    Helper method to create date to Jan 18, 2018 for example
     */

    private String convertDate(String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            Date d = format.parse(date);
            SimpleDateFormat serverFormat = new SimpleDateFormat("MMM dd yyyy");
            return serverFormat.format(d);
        } catch (Exception e) {
            Log.e(LOG_TAG, "Parsing error");
        }
        return "";
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
