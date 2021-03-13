package top.top7.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/******
 *       Created by LEARNING on 2021/2/22 18:16.
 *
 **********************************************************************
 *                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
 *            __.'              ~.   .~              `.__
 *          .'//                  \./                  \\`.
 *        .'//                     |                     \\`.
 *      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
 *    .'//.-"                 `-.  |  .-'                 "-.\\`.
 *  .'//______.============-..   \ | /   ..-============.______\\`.
 *.'______________________________\|/______________________________`.
 *
 *
 *                     Don't forget to be awesome!                      
 **********************************************************************
 */
public class PDate1 {
    public static void main(String[] args) throws InterruptedException, ParseException {
        //java.util.Date
        //创建Date对象,获得系统当前时间
        Date date = new Date();
        System.out.println(date);
        //按照本地化格式输出时间
        System.out.println(date.toLocaleString());
        //获得1970-01-01 00:00:00 至今的毫秒值
        long time = date.getTime();
        System.out.println(time);


        //java.text.SimpleDateFormat
        //日期格式化
        // y 年 MM 月 d 日  H 时 m 分 s 秒
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将指定时间按照自定义格式输出
        String format = simpleDateFormat.format(date);
        System.out.println(format);

        //将日期字符串解析为Date对象
        try {
            //日期字符串需要与创建SimpleDateFormat对象时的格式相同,否则会报异常
            Date parse = simpleDateFormat.parse("2020-12-18 12:12:12");
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        //java.util.Calendar 日历类
        //通过Calendar抽象类的getInstance()静态方法获取Calendar类的实现类对象,默认为系统当前时间
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        //设置每周的起始位置,默认周日为每周的第一天
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        //获取月份; 月份取值为0-11
        System.out.println(calendar.get(Calendar.MONTH + 1));
        //获取当前时间为本月的第几天
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        //获取当前时间的年份
        System.out.println(calendar.get(Calendar.YEAR));
        //获取当前时间为周几,星期日为1,星期六为7
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        //获得1970-01-01 00:00:00 至当前时刻的毫秒值
        System.out.println(calendar.getTimeInMillis());
        //获取当前月的最后一天
        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));


        //使用Date对象设置Calendar对象时间
//        calendar.setTime(new Date(4555555555555545L));
        calendar.setTime(simpleDateFormat.parse("2021-02-28 22:23:15"));
        System.out.println(calendar.get(Calendar.YEAR) + "------" + (calendar.get(Calendar.MONTH) + 1) + "----"
                + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH) + "--+--" + calendar.get(Calendar.WEEK_OF_MONTH));

        //使用set方法对时间进行修改
        calendar.set(Calendar.MONTH, Calendar.JULY);
        System.out.println(calendar.get(Calendar.MONTH));
        calendar.set(2022, Calendar.DECEMBER, 28);
        System.out.println(calendar.get(Calendar.YEAR) + "------" + (calendar.get(Calendar.MONTH) + 1) + "----"
                + calendar.get(Calendar.DAY_OF_MONTH));


        //获得1970-01-01 00:00:00 至当前时刻的毫秒值
        //第一种方式
        Date date1 = new Date();
        System.out.println(date1.getTime());
        //第二种方式
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getTimeInMillis());
        //第三种方式
        System.out.println(System.currentTimeMillis());
        //第四种方式 jdk8 java.time.Clock
        System.out.println(Clock.systemDefaultZone().millis());


        //java.time包 (jdk8)
        Instant now = Instant.now();
        System.out.println(now);
        Thread.sleep(3000);
        Instant now1 = Instant.now();
        System.out.println(Duration.between(now, now1).toMillis());

        LocalDate of = LocalDate.of(1997, 10, 29);
        LocalDate localDate = of.plusWeeks(3);
        System.out.println(of);
        System.out.println(localDate);
        System.out.println(of.getDayOfWeek());
    }
}
