package model.json.song.comment;

import java.util.List;

/**
 * Created by ml on 2017/7/21.
 */
public class SongCommentResult {
    //歌曲ID
    private int id;
    //歌曲评论数
    private int total;
    //最热评论
    private List<String> hotComments;
    //最新评论
    private List<String> newComments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<String> getHotComments() {
        return hotComments;
    }

    public void setHotComments(List<String> hotComments) {
        this.hotComments = hotComments;
    }

    public List<String> getNewComments() {
        return newComments;
    }

    public void setNewComments(List<String> newComments) {
        this.newComments = newComments;
    }

}
