package utils;

/**
 * Created by ml on 2017/7/20.
 */
public class Constants {
    //请求头部信息
    public static final String BASE_URL = "http://music.163.com/";
    public static final String USERAGENT = "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36";

    //API调用地址
    //歌曲搜索API
    public static final String SEARCHAPI = "http://s.music.163.com/search/get/";
    public static final String SEARCHPOSTAPI = "http://music.163.com/api/search/get/web?csrf_token=";
    //歌曲评论API
    public static final String COMMENTAPI_PARAM1 = "http://music.163.com/weapi/v1/resource/comments/R_SO_4_";
    public static final String COMMENTAPI_PARAM2 = "/?csrf_token=";
    //歌曲信息API
    public static final String SONGAPI_PARAM1 = "http://music.163.com/api/song/detail/?id=";
    public static final String SONGAPI_PARAM2 = "&ids=";
    //歌词API
    public static final String LYRICSAPI = "http://music.163.com/weapi/song/lyric";
    //好友API
    public static final String GETFOLLOWSAPI = "http://music.163.com/weapi/user/getfollows";

    //加密使用到的文本
    public static final String TEXT = "{\"username\": \"\", \"rememberLogin\": \"true\", \"password\": \"\"}";

    //歌词搜索POST参数


    //歌曲搜索默认限制结果数
    public static final int LIMIT_NUM = 30;
    //歌曲 1
    public static final int TYPE_SONG = 1;
    //专辑 10
    public static final int TYPE_ALBUM = 10;
    //歌手 100
    public static final int TYPE_ARTIST = 100;
    //歌单 1000
    public static final int TYPE_PLAYLIST = 1000;
    //用户 1002
    public static final int TYPE_USER = 1002;
    //mv 1004
    public static final int TYPE_MV = 1004;
    //歌词 1006
    public static final int TYPE_ = 1006;
    //主播电台 1009
    public static final int TYPE_DJRADIO = 1009;

    //默认分隔符
    public static final String SEPARATOR = ",";

    //默认最热评论数量
    public static final String FUNC_HOT = "setHot_";
    public static final int HOT_NUM = 15;
    //默认最新评论数量
    public static final String FUNC_NEW = "setNew_";
    public static final int NEW_NUM = 20;


}
