package com.example.shenron.dailynews;

public class News {

    //Title of News
    private String mTitle;

    //Author of news
    private String mAuthor;

    //Category of news
    private String mCategory;

    //Date of news
    private String mDate;

    //URL of news
    private String mUrl;

    //public constructor
    public News(String title,String category,String date,String url)
    {
        mTitle=title;
        mCategory=category;
        mDate=date;
        mUrl=url;
    }

    public String getTitle()
    {
        return mTitle;
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
    public String getUrl()
    {
        return mUrl;
    }
}
