package com.chenglian.util;


import org.hibernate.Hibernate;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.internet.ContentType;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;

/**
 * Created by lenovo on 2019/9/8.
 */
public class BytesToFile {
    public static MultipartFile bytesToFile(byte[] bytes){
        MultipartFile file = new MockMultipartFile("data",bytes);
        return file;
    }
}
