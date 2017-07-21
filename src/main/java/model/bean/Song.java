package model.bean;

import dao.annotation.ColumnInfo;
import dao.annotation.TableInfo;

/**
 * Created by ml on 2017/7/19.
 */

@TableInfo(TableName = "song", PrimaryKey = "id")
public class Song {
    @ColumnInfo(columnName = "id")
    private int id;
    @ColumnInfo(columnName = "song_name")
    private String song_name;
    @ColumnInfo(columnName = "singer_name")
    private String singer_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getSinger_name() {
        return singer_name;
    }

    public void setSinger_name(String singer_name) {
        this.singer_name = singer_name;
    }


    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", song_name='" + song_name + '\'' +
                ", singer_name='" + singer_name + '\'' +
                '}';
    }
}
