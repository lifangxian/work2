package com.example.www.week3.bena;

public class Contet {
    private String album_id;
    private String album_title;
    private String all_rate;
    private String author;
    private String biaoshi;
    private String pic_big;
    private String pic_small;
    private String rank_change;
    private String song_id;
    private String title;

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public String getAlbum_title() {
        return album_title;
    }

    public void setAlbum_title(String album_title) {
        this.album_title = album_title;
    }

    public String getAll_rate() {
        return all_rate;
    }

    public void setAll_rate(String all_rate) {
        this.all_rate = all_rate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBiaoshi() {
        return biaoshi;
    }

    public void setBiaoshi(String biaoshi) {
        this.biaoshi = biaoshi;
    }

    public String getPic_big() {
        return pic_big;
    }

    public void setPic_big(String pic_big) {
        this.pic_big = pic_big;
    }

    public String getPic_small() {
        return pic_small;
    }

    public void setPic_small(String pic_small) {
        this.pic_small = pic_small;
    }

    public String getRank_change() {
        return rank_change;
    }

    public void setRank_change(String rank_change) {
        this.rank_change = rank_change;
    }

    public String getSong_id() {
        return song_id;
    }

    public void setSong_id(String song_id) {
        this.song_id = song_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Contet{" +
                "album_id='" + album_id + '\'' +
                ", album_title='" + album_title + '\'' +
                ", all_rate='" + all_rate + '\'' +
                ", author='" + author + '\'' +
                ", biaoshi='" + biaoshi + '\'' +
                ", pic_big='" + pic_big + '\'' +
                ", pic_small='" + pic_small + '\'' +
                ", rank_change='" + rank_change + '\'' +
                ", song_id='" + song_id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
