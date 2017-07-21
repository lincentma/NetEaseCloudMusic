package util;

import com.google.gson.Gson;
import model.json.song.search.SongSearch;
import org.junit.Test;
import utils.Constants;
import utils.EncryptUtil;
import utils.HttpUtil;

import java.util.Map;

/**
 * Created by ml on 2017/7/20.
 */
public class HttpUtilTest {
    @Test
    public void gettest() {
        String url = "http://s.music.163.com/search/get/?type=1&filterDj=true&s=遇见&limit=10&offset=0";
        System.out.println(HttpUtil.doGet(url));
    }

    @Test
    public void posttest() {
        String url = "";
        String songId = "488733382";
        url = Constants.COMMENTAPI_PARAM1 + songId + Constants.COMMENTAPI_PARAM2;
        System.out.println(url);
        System.out.println(Constants.TEXT);


        Map<String, String> paramMap = EncryptUtil.encrypt(Constants.TEXT);
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ",value=" + entry.getValue());
        }


//        Map<String,String> paramMap = new HashMap<String,String>();
//        paramMap.put("params","ORkjLQfcWC5aL9waZ9qV0pLvIWRMmWSudzuui/aId56LIkxvqdMyqoQvrhXRabvgrMHBXKIKC4dwZDIykEJIpv4xxEnhtS6AG5O9dvtvqTszhJ8XNE2qWgtvq4ji6Ko3V6Rivh2EomEB6hGD44ZF11CnSdhGga2GPpOnP/avrlaaTqm8nUgy/8vVsTOZZPtC92nZ+Qomt1FRt3KZY4rBpdZZ98fG8TdqfHP+ppaC1Ms=");
//        paramMap.put("encSecKey","006ce7c5adfc61d7408012481080415f4913f4e10ae6ba1c0df940b1e0215d47c2bc8ef2cd581531791cc1aefdf6eb616ebba3c7962050ffe5f4eeea7dea1ce74a2f00b2f9adf4d1ee03ec93d30d33ec41508f54e438f7859499a249d542c08fd9fee85ccfe959c58e9ff3111f4ac7888a8061106467655d29b13301629be231");
        String httpOrgCreateTestRtn = HttpUtil.doPost(url, paramMap);
        System.out.println(httpOrgCreateTestRtn);
    }

    @Test
    public void postsearch() {

        String url = "http://music.163.com/api/search/get/web?csrf_token=";
        String parm = "hlpretag=&hlposttag=&s=啊哈哈&type=1&offset=37&total=false&limit=5";
        String httpOrgCreateTestRtn = HttpUtil.doPost(url, parm);
        System.out.println(httpOrgCreateTestRtn);
        Gson gson = new Gson();
        SongSearch search = gson.fromJson(httpOrgCreateTestRtn, SongSearch.class);
        System.out.println(search.getResult().getSongs().size());

    }
}
