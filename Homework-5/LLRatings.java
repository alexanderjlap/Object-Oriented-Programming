import java.util.GregorianCalendar;
import java.util.LinkedList;

public class LLRatings implements IDailyRating {

    private LinkedList<TodaysRatings> dailyRatings;
    private GregorianCalendar today;

    public LLRatings(LinkedList<TodaysRatings> dailyRatings, GregorianCalendar today) {
        this.dailyRatings = dailyRatings;
        this.today = today;
    }

    /**
     * The method compares if the months and year are equal to the rating date.
     * @param rating is a new TodayRatings value.
     * @return true is operation passes, false otherwise.
     */
    public boolean compareDate(TodaysRatings rating) {
        if (today.get(GregorianCalendar.MONTH) == rating.getDate().get(GregorianCalendar.MONTH)) {
            if (today.get(GregorianCalendar.YEAR) == rating.getDate().get(GregorianCalendar.YEAR)) {
                return true;
            }
        }
        return false;
    }

    /**
     * The method comapres the param month and year and checks to see if it equals the rating date.
     * @param rating is a new TodaysRatings.
     * @param month is a new int value.
     * @param year is a new int value.
     * @return
     */
    public boolean compareDateWithDate(TodaysRatings rating, int month, int year) {
        if (month == rating.getDate().get(GregorianCalendar.MONTH)) {
            if (year == rating.getDate().get(GregorianCalendar.YEAR)) {
                return true;
            }
        }
        return false;
    }

    @Override
    /**
     * The method goes through the LinkedList and checks for whether today and rating date are equal,
     * if so the LinkedList of rating is checks for if the integer is less than the min value, which should never be passed,
     * and the integer is now the new min (the highest).
     * @return the new value min after operation is completed.
     */
    public int bestRankThisMonth() {
        int min = Integer.MAX_VALUE;
        for (TodaysRatings rating : dailyRatings) {
            compareDate(rating);
            for (Integer i : rating.getRankings()) {
                if (i < min) {
                    min = i;
                }
            }
        }
        return min;
    }

    /**
     * The method takes in two integers and goes through the LinkedList and checks if the integers in a parameter equal the rating dates,
     * if so the downloads LinkedList is checked with an integer, i being set to equal total which was declared.
     * @param month is a new int value.
     * @param year  is a new int value.
     * @return the total value.
     */
    @Override
    public int totalSongDownloads(int month, int year) {
        int total = 0;
        for (TodaysRatings rating : dailyRatings) {
            compareDateWithDate(rating, month, year);
            for (Integer i : rating.getDownloads()) {
                total = i;
            }
        }
        return total;
    }

    /**
     * The method takes in a LinkedList from the survey class and declaring a new TodaysRating object.
     * Then the LinkedList is then searched for and adds the downloads and rankings from the survey class to their respected LinkedList in TodaysRating.
     * After the value are added to the LinkedList, the dailyRating LinkedList adds the new ratings (downloads and rankings).
     * The current date gets added one after the operation is completed.
     * @param surveys is a new LinkedList.
     */
    @Override
    public void addTodaysSurveys(LinkedList<Survey> surveys) {
        TodaysRatings rating = new TodaysRatings(today.get(GregorianCalendar.YEAR), today.get(GregorianCalendar.MONTH), today.get(GregorianCalendar.DAY_OF_MONTH));
        for (Survey survey : surveys) {
            rating.getDownloads().add(survey.getDownloads());
            rating.getRankings().add(survey.getRankings());
        }
        dailyRatings.add(rating);
        today.add(GregorianCalendar.DAY_OF_YEAR, 1);
    }
}
