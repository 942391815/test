package com.test.java.elasticsearch.handlees;

import com.alibaba.fastjson.JSONObject;
import com.test.java.elasticsearch.ClientUtils;
import com.test.java.elasticsearch.content.News;
import com.test.java.elasticsearch.utils.Constant;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.client.Client;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Micheal on 2016/10/7.
 */

public class EsService {
    /**
     * Es 批量插入
     */
    public void bulkInsert(List<News> newsList){
        Client client = ClientUtils.getClient();
        BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();
        /**
         * 100条提交一次
         */
        if(newsList!=null){
            for (int i =0;i<newsList.size();i++){
                News each = newsList.get(i);
                IndexRequestBuilder indexRequestBuilder = client.prepareIndex(Constant.INDEX, Constant.TYPE);
                HashMap<String,Object> eachMap = JSONObject.parseObject(JSONObject.toJSON(each).toString(),HashMap.class);
                indexRequestBuilder.setSource(eachMap);
                bulkRequestBuilder.add(indexRequestBuilder);
                if(i%100 ==0){
                    BulkResponse bulkItemResponses = bulkRequestBuilder.execute().actionGet();
                    bulkRequestBuilder.request().requests().clear();
                }
            }
        }
        if(!bulkRequestBuilder.request().requests().isEmpty()){
            bulkRequestBuilder.execute().actionGet();
        }
        client.close();
    }

    public void deleteAllData(){
        Client client = ClientUtils.getClient();
        client.admin().indices().prepareDelete(Constant.INDEX,Constant.TYPE).execute().actionGet();
    }
}
