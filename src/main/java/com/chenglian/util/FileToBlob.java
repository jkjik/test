package com.chenglian.util;

import com.chenglian.entity.Commodity;
import org.apache.commons.io.IOUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;


/**
 * Created by lenovo on 2019/9/7.
 */
public class FileToBlob {
    public static  byte[] changeFileToBlob(MultipartFile file){
        InputStream is = null;
        byte[] bytes = null;
        try {
            is = file.getInputStream();
            bytes = FileCopyUtils.copyToByteArray(is);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            IOUtils.closeQuietly(is);
        }
        return bytes;
    }
}
