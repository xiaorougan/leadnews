package com.minio;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;

import java.io.FileOutputStream;

public class MinIOTest {
    public static void main(String[] args) {
        //获取minio的链接信息 创建一个minio的客户端
        FileOutputStream fileOutputStream = new FileOutputStream()
        MinioClient minioClient = MinioClient.builder().credentials("minio", "minio123").endpoint("http://10.21.172.231:9000").build();


        //上传
        PutObjectArgs putObjectArgs =PutObjectArgs.builder()
                .object("list.html")
                .contentType("test/html")
                .bucket("news")
                .stream();
        minioClient.putObject(putObjectArgs);

    }
}
