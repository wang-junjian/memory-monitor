package com.wangjunjian.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetimeUtil {

    public static String now() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

}
