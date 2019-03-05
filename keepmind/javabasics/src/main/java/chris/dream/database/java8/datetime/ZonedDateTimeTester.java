package chris.dream.database.java8.datetime;

import java.time.*;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 2019-02-26
 */
public class ZonedDateTimeTester {

    public static void main(String[] args){
        ZonedDateTimeTester ZonedDateTimeTester = new ZonedDateTimeTester();
        ZonedDateTimeTester.testZonedDateTime();
    }

    public void testZonedDateTime(){

        // 获取当前时区的时间日期
        ZonedDateTime now = ZonedDateTime.now(Clock.systemDefaultZone());
        System.out.println("now: " + now);

        ZoneId euId = ZoneId.of("Europe/Paris");
        System.out.println("EUZoneId: " + euId);
        ZonedDateTime euNow = ZonedDateTime.now(euId);
        System.out.println("EUNow: " + euNow);

        ZoneId currentZone = ZoneId.systemDefault();

        ZonedDateTime date1 = ZonedDateTime.parse(now.toString());
        System.out.println("date1: " + date1);
    }
}
