package com.gyy.sm.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.File;
import java.util.UUID;

/**
 * @ClassName AliOSSUtil
 * @Description TODO
 * @Author GYY
 * @Date 2020/11/23
 **/
public class AliOSSUtil {
    /**
     * 将本地file上传到阿里云指定域名的目录下，并用UUID重命名
     *
     * @param file 待传文件
     * @return String 上传成功返回url
     *
     */
    public static String ossUpload(File file){
        String bucketDomain = "https://gyy-niit.oss-cn-hangzhou.aliyuncs.com/";
        String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
        String accesKeyId = "LTAI4GD4LT7icyBV5HzSKDft";
        String accesKeySecret = "6ZIv9uxIyc4QedeeohN6nVnGrNPbkz";
        String bucketName = "gyy-niit";
        String fileDir = "img/";
        String fileName = file.getName();
        String fileKey = UUID.randomUUID().toString() + fileName.substring(fileName.indexOf("."));
        OSS ossClient = new OSSClientBuilder().build(endpoint, accesKeyId, accesKeySecret);
        ossClient.putObject(bucketName, fileDir + fileKey, file);
        ossClient.shutdown();
        return bucketDomain + fileDir + fileKey;
    }

    public static void main(String[] args) {
        File file = new File("D:/QQ/photo/T1.jpg");
        String url = ossUpload(file);
        System.out.println(url);
    }
}
