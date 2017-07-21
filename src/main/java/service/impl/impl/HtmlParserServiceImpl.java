package service.impl.impl;

import com.google.gson.Gson;
import model.json.song.comment.SongComment;
import model.json.song.comment.SongCommentResult;
import model.json.song.search.SongSearch;
import model.json.song.search.SongSearchResult;
import org.apache.commons.lang3.StringUtils;
import service.impl.HtmlParserService;
import utils.Constants;
import utils.EncryptUtil;
import utils.HttpUtil;

import java.util.*;

/**
 * Created by ml on 2017/7/20.
 */
public class HtmlParserServiceImpl implements HtmlParserService {

    public Queue<SongSearchResult> parseSearchInfo(String search) {

        SongSearch songSearch = new SongSearch();

        int type = Constants.TYPE_SONG;
        int limit = Constants.LIMIT_NUM;
        int offset = 0;
        String url = Constants.SEARCHAPI;
        String urlPost = Constants.SEARCHPOSTAPI;
        int totalNum = 0;
        String post_param = "";
        boolean flag = true;

        Queue<SongSearchResult> result = new LinkedList<SongSearchResult>();

        url = url + "?" + "s=" + search + "&type=" + type + "&limit=" + limit + "&offset=" + offset;

        post_param = "hlpretag=&hlposttag=&s=" + search + "&type=" + type + "&offset=" + offset + "&total=" + flag + "&limit=" + limit;

        //第一次请求获取totalCount
        String responseFirst = HttpUtil.doGet(url);

        Gson gson = new Gson();
        songSearch = gson.fromJson(responseFirst, SongSearch.class);
        totalNum = songSearch.getResult().getSongCount();

        //计算totalCount需要请求次数
        int num = (totalNum % limit == 0) ? (totalNum / limit) : totalNum / limit + 1;
        for (int i = 0; i < num; i++) {
            offset += limit * i;
            String name = "offset";
            //正则替换请求参数
            if (StringUtils.isNotBlank(url)) {
                url = url.replaceAll("(" + name + "=[^&]*)", name + "=" + offset);
            }
            String responseOther = HttpUtil.doGet(url);
            //Json结果处理
            gson = new Gson();
            songSearch = gson.fromJson(responseFirst, SongSearch.class);
            //歌曲id，歌曲名称，歌手姓名
            List<SongSearch.ResultBean.SongsBean> songs = songSearch.getResult().getSongs();
            Iterator<SongSearch.ResultBean.SongsBean> iter = songs.iterator();
            while (iter.hasNext()) {
                SongSearch.ResultBean.SongsBean song = iter.next();
                //歌手姓名
                List<String> artistName = new ArrayList<String>();
                List<SongSearch.ResultBean.SongsBean.ArtistsBean> artists = song.getArtists();
                for (SongSearch.ResultBean.SongsBean.ArtistsBean artist : artists) {
                    artistName.add(artist.getName());
                }
                //整合
                SongSearchResult resultbean = new SongSearchResult();
                resultbean.setId(song.getId());
                resultbean.setSong_name(song.getName());
                resultbean.setArtist_name(StringUtils.join(artistName, Constants.SEPARATOR));
                //添加到队列
                result.offer(resultbean);
            }
        }
        //最后
        return result;
    }

    public SongCommentResult parseSongInfo(int id) {

        SongComment songComment = new SongComment();

        SongCommentResult result = new SongCommentResult();

        String songId = String.valueOf(id);
        String url = Constants.COMMENTAPI_PARAM1 + songId + Constants.COMMENTAPI_PARAM2;
        Map<String, String> paramMap = EncryptUtil.encrypt(Constants.TEXT);
        String response = HttpUtil.doPost(url, paramMap);

        Gson gson = new Gson();
        songComment = gson.fromJson(response, SongComment.class);

        result.setId(id);
        result.setTotal(songComment.getTotal());

        List<SongComment.CommentsBean> newComments = songComment.getComments();
        List<String> newCommentsResult = new ArrayList<String>();
        List<SongComment.HotCommentsBean> hotComments = songComment.getHotComments();
        List<String> hotCommentsReuslt = new ArrayList<String>();

        for (int i = 0; i < newComments.size(); i++) {
            //后续可以统计点赞，发表时间，用户Id等其他信息
            String user = String.valueOf(newComments.get(i).getUser().getUserId());
            String time = String.valueOf(newComments.get(i).getTime());
            String likeCount = String.valueOf(newComments.get(i).getLikedCount());
            String content = newComments.get(i).getContent();
            String newOneComment = user + "\t" + time + "\t" + likeCount + "\t" + content;
            newCommentsResult.add(newOneComment);
        }
        result.setNewComments(newCommentsResult);

        for (SongComment.HotCommentsBean hot : hotComments) {
            String user = String.valueOf(hot.getUser().getUserId());
            String time = String.valueOf(hot.getTime());
            String likeCount = String.valueOf(hot.getLikedCount());
            String content = hot.getContent();
            String hotOneComment = user + "\t" + time + "\t" + likeCount + "\t" + content;
            hotCommentsReuslt.add(hotOneComment);
        }
        result.setHotComments(hotCommentsReuslt);

        return result;
    }
}
