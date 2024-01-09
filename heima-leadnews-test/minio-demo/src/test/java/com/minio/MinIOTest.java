package com.minio;

import com.heima.file.service.FileStorageService;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
@SpringBootTest(classes = MinIOApplication.class)
@RunWith(SpringRunner.class)
public class MinIOTest {

    @Autowired
    private FileStorageService fileStorageService;
    @Test
    public void test() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("C:/private-file/develop/toutiao/list.html");
        String path = fileStorageService.uploadHtmlFile("", "list.html", fileInputStream);
        System.out.println(path);
    }
    public static void main(String[] args) {

//        try {
//            //获取minio的链接信息 创建一个minio的客户端
//            FileInputStream fileInputStream = new FileInputStream("C:/private-file/develop/toutiao/list.html");
//            MinioClient minioClient = MinioClient.builder().credentials("minio", "minio123").endpoint("http://10.21.172.231:9000").build();
//
//
//            //上传
//            PutObjectArgs putObjectArgs =PutObjectArgs.builder()
//                    .object("list.html")
//                    .contentType("test/html")
//                    .bucket("news")
//                    .stream(fileInputStream, fileInputStream.available(), -1).build();
//            minioClient.putObject(putObjectArgs);
//
//            //访问路径
//            System.out.println("http://10.21.172.231:9000/leadnews/list.html");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }



    }
}
