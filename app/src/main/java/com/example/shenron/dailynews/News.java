package com.example.shenron.dailynews;

public class News {

    //Title of News
    private String mTitle;

    //Summary of news
    private String mSummary;

    //Author of news
    private String mAuthor;

    //Category of news
    private String mCategory;

    //Date of news
    private String mDate;

    //Time of news
    private String mTime;

    //URL of news
    private String mUrl;

    //public constructor
    public News(String title,String summary,String author,String category,String date,String time,String url)
    {
        mTitle=title;
        mSummary=summary;
        mAuthor=author;
        mCategory=category;
        mDate=date;
        mTime=time;
        mUrl=url;
    }

    public String getTitle()
    {
        return mTitle;
    }
    public String getSummary()
    {
        return mSummary;
    }
    public String getAuthor()
    {
        return mAuthor;
    }
    public String getCategory()
    {
        return mCategory;
    }
    public String getDate()
    {
        return mDate;
    }
    public String getTime()
    {
        return mTime;
    }
    public String getUrl()
    {
        return mUrl;
    }
}
