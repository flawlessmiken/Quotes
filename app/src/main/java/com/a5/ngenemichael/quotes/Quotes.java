package com.a5.ngenemichael.quotes;

/**
 * Created by Flawless on 10/26/2017.
 */
public class Quotes {
    private String name, quote, id;
    private  int like;
    public Quotes(){}

    public Quotes(String quote, String name, String id,int img){
        this.quote = quote;
        this.name= name;
         this.id = id;
        this.like= img;

    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
