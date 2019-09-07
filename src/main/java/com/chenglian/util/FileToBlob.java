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
    public static Commodity changeFileToBlob(MultipartFile file, Commodity commodity){
        InputStream is = null;
        try {
            is = file.getInputStream();
            byte[] bytes = FileCopyUtils.copyToByteArray(is);
            commodity.setImage(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            IOUtils.closeQuietly(is);
        }
        return commodity;
    }
}
