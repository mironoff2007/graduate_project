package graduate.util;

import org.junit.Test;
import ru.mia.graduate.util.DateTimeUtil;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

/**
 * Created by Юрий on 13.08.2018.
 */
public class DateTimeUtilTest {

    @Test
    public void getCurrentDatetime() {
        System.out.println(DateTimeUtil.nowFormatted());
    }


    @Test
    public void isBeforeTime() throws Exception {
        assertEquals("Wrong Before Time", DateTimeUtil.isBeforeVoteTime("2018-08-13 10:00"), true);
        assertEquals("Wrong After Time" , DateTimeUtil.isBeforeVoteTime("2018-08-13 18:00"), false);
        assertEquals("Wrong empty"      , DateTimeUtil.isBeforeVoteTime(""), false);
        assertEquals("Wrong null"       , DateTimeUtil.isBeforeVoteTime(null), false);
    }

    @Test
    public void isBeforeDate() throws Exception {
        LocalDateTime beforeDate = LocalDateTime.now().now().minusDays(1);
        LocalDateTime currentDate = LocalDateTime.now();
        assertEquals("Wrong Before Date", DateTimeUtil.isBeforeToday(DateTimeUtil.toString(beforeDate)), true);
        assertEquals("Wrong Today Date", DateTimeUtil.isBeforeToday(DateTimeUtil.toString(currentDate)), false);
        assertEquals("Wrong empty", DateTimeUtil.isBeforeToday(""), false);
        assertEquals("Wrong null", DateTimeUtil.isBeforeToday(null), false);
    }

}
