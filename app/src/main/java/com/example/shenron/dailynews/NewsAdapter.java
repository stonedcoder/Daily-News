package com.example.shenron.dailynews;


import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
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
import java.util.Locale;

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

        TextView authorView = (TextView)listItemView.findViewById(R.id.author_text_view);
        authorView.setText(currentNews.getAuthor());

        TextView categoryView = (TextView)listItemView.findViewById(R.id.categories_text_view);
        categoryView.setText(currentNews.getCategory());


        Date dateObject = new Date(currentNews.getDate());
        TextView dateView = (TextView)listItemView.findViewById(R.id.date_text_view);

        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);

        TextView timeView = (TextView)listItemView.findViewById(R.id.time_text_view);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        // Return the list item view that is now showing the appropriate data
        return listItemView;

    }

    private static String formatDate(Date dateString) {
        String someDateString = "2016-09-26T15:57:34Z";
        SimpleDateFormat jsonFormatter = new SimpleDateFormat(someDateString, Locale.US);

        try {
            Date dateObject = jsonFormatter.parse(String.valueOf(dateString));
            String finalDatePattern = "MMM d, yyy";
            SimpleDateFormat finalDateFormatter = new SimpleDateFormat(finalDatePattern, Locale.US);
            return finalDateFormatter.format(dateObject);
        } catch (ParseException e) {
            Log.e("News Adapter", "Error parsing JSON date: ", e);
        }

     return "" ;
    }

    private String formatTime(Date timeString)
    {
        String someTimeString = "2016-09-26T15:57:34Z";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss'Z'");
        Time timeObject = null;
        try{
            timeObject = (Time) simpleDateFormat.parse(String.valueOf(timeString));
        }catch (ParseException e){
            e.printStackTrace();
        }

        simpleDateFormat = new SimpleDateFormat("hh:mm a");
        String time = simpleDateFormat.format(timeObject);
        return time;
    }
}
