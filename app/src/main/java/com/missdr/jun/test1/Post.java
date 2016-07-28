package com.missdr.jun.test1;

/**
 * Created by jun on 7/28/16.
 * A Lyan template!
 */
public class Post {

    private String author ;
    private String description ;
    private int likes ;
    private String image ;

    public Post(String author, String description, int likes) {
        this.author = author;
        this.description = description;
        this.likes = likes;
    }

    public Post(String author, String description, int likes, String image) {
        this.author = author;
        this.description = description;
        this.likes = likes;
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public int getLikes() {
        return likes;
    }

    //    private final java.a


    public void setLikes(int likes) {
        this.likes = likes;
    }



    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
