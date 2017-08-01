package com.example.shenron.dailynews;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

public class NewsAdapter extends ArrayAdapter<News>{

    public NewsAdapter(Context context, List<News> news)
    {
        super(context,0,news);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);
        }

        //Find current news at a given position in the list item
        News currentNews = getItem(position);

        TextView headingView = (TextView)listItemView.findViewById(R.id.heading_text_view);
        headingView.setText(currentNews.getTitle());

        TextView summaryView = (TextView)listItemView.findViewById(R.id.summary_text_view);
        summaryView.setText(currentNews.getSummary());

        TextView authorView = (TextView)listItemView.findViewById(R.id.author_text_view);
        authorView.setText(currentNews.getAuthor());

        TextView categoryView = (TextView)listItemView.findViewById(R.id.categories_text_view);
        categoryView.setText(currentNews.getCategory());

        Date dateobject = new Date(currentNews.getDate());
        TextView dateView = (TextView)listItemView.findViewById(R.id.date_text_view);
        dateView.setText(formatDate(currentNews.getDate()));

        TextView timeView = (TextView)listItemView.findViewById(R.id.time_text_view);
        timeView.setText(formatTime(currentNews.getTime()));

        // Return the list item view that is now showing the appropriate data
        return listItemView;

    }

    private String formatDate(String dateString) {
        String someDateString = "2016-09-26T15:57:34Z";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss'Z'");
        Date dateObject = null;
        try {
            dateObject = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        simpleDateFormat = new SimpleDateFormat("MMM dd,yyyy");
        String date = simpleDateFormat.format(dateObject);

        return date;
    }

    private String formatTime(String timeString)
    {
        String someTimeString = "2016-09-26T15:57:34Z";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss'Z'");
        Time timeObject = null;
        try{
            timeObject = (Time) simpleDateFormat.parse(timeString);
        }catch (ParseException e){
            e.printStackTrace();
        }

        simpleDateFormat = new SimpleDateFormat("hh:mm a");
        String time = simpleDateFormat.format(timeObject);
        return time;
    }
}
