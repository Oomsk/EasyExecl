package com.example.easyexcel.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * @author: Omsk
 * @date: 2020/2/5 23:38
 * @params
 * @return:
 * @@Description: 日期辅助处理
 */
public class DateUtil {
    /*
     * @author: Omsk
     * @date: 2020/2/5 23:38
     * @params
     * @return:
     * @@Description: 根据出生日期来计算年龄
     */
    public static int getAge(Date date) {
        if (date == null) {
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //2000
        int year = calendar.get(Calendar.YEAR);
        Calendar now = Calendar.getInstance();
        //2019
        int nowYear = now.get(Calendar.YEAR);
        return nowYear - year == 0 ? 1 : nowYear - year;
    }
    /*
     * @author: Omsk
     * @date: 2020/2/5 23:39
     * @params
     * @return:
     * @@Description: String--->Date
     */
    public static Date getBirthday(String date) {
        if (date == null) {
            return null;
        }
        if (("").equals(date)){
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date birthday = null;
        try {
            birthday = format.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            birthday = null;
        }
        return birthday;
    }
    /*
     * @author: Omsk
     * @date: 2020/2/5 23:39
     * @params
     * @return:
     * @@Description: Date--->String
     */
    public static String fomartBirthday(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String birthday = format.format(date);
        return birthday;
    }
    /*
     * @author: Omsk
     * @date: 2020/2/5 23:52
     * @params
     * @return:
     * @@Description: 获取时间
     */
    public static Date getLocalDate(){
        Date now =new Date();
        return now;
    }
    /*
     * @author: Omsk
     * @date: 2020/2/16 18:50
     * @params 分钟化秒
     * @return:
     * @@Description: TODO(10分钟有效验证码)
     */
    public static String activeDate(Date date ,int time){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        int s = time*60;
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(date);
        Calendar after = (Calendar) calendar.clone();
        after.add(Calendar.SECOND, s);
        String outAfter = format.format(after.getTime());
        return outAfter;
    }
}

