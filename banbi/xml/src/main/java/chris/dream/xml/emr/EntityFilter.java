package chris.dream.xml.emr;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bonc.text.sdk.client.TextEntityIdentifyClient;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 3:46 2018-09-05
 */
public class EntityFilter {

    private static TextEntityIdentifyClient client = TextEntityIdentifyClient.getInstance("172.16.3.116:9187");

    public static String filterEntity(String content) {
        try {
            Set<String> entities = new HashSet<>();
            String json = client.
                    extractBasicEntitiesSingleModel(null, content, true, true);
            JSONObject obj = JSON.parseObject(json);
            JSONArray array = obj.getJSONArray("data");
            for(int i = 0; i < array.size(); i++){
                JSONObject entityObj = (JSONObject) array.get(i);
                entities.add(entityObj.getString("word"));
            }

            for(String entity : entities){
                content = content.replaceAll(entity, "****");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
}
