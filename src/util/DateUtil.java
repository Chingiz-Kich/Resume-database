package util;

import java.time.LocalDate;
import java.time.Month;

/*
    Мы создали данный утилитный класс, чтобы он помогал нам создавать LocalDate:
    startDate, endDate потому что нам нужно будет не текущее время,
    а время которое задал пользователь или у нас будут тестовые данные.
*/

/*
    Утильному классу не создают private конструктор,
    потому что instance этого класса не создается,
    все методы в данном классе static.
    Наподобие Collections, Arrays - служит для вспомогальных действий.
*/
public class DateUtil {

    // We use this util method to construct our 'Organizations'
    public static LocalDate of (int year, Month month) {
        return LocalDate.of(year, month, 1);
    }
}
