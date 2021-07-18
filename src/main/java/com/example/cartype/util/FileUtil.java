package com.example.cartype.util;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    public static String USER_ICON_REPOSITORY ="E:/iconRepository/userIcon/";


    public static final File getAbsoluteFile(String filename) throws IOException {
        File desc = new File(File.separator + filename);

        if (!desc.getParentFile().exists()) {
            desc.getParentFile().mkdirs();
        }
        if (!desc.exists()) {
            desc.createNewFile();
        }
        return desc;
    }

}
