package com.jiayeli.blog.esDemo;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

@Slf4j
public class Test {
    public static void main(String[] args) throws IOException {
        log.debug("debug");
        log.info("info");
        log.error("error");
    }

    public void esConnectorTest() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
        System.out.println(client);
        // 创建索引 - 请求对象
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("user");
        // 发送请求，获取响应
        CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        // 获取响应状态
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println("操作状态 = " + acknowledged);
        log.error("test error message.");
        client.close();
    }
}
