import static org.junit.Assert.*;
import org.junit.Test;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Examples {
    GregorianCalendar today;
    RadioStation radioStation = new RadioStation(new LLRatings(new LinkedList<>(), new GregorianCalendar(2015, 10, 2)));
    IDailyRating dailyRating;
    Survey survey1 = new Survey(1, 4);
    Survey survey2 = new Survey(5, 13);
    Survey survey3 = new Survey(0, 0);
    Survey survey4 = new Survey(10, 2);
    Survey survey5 = new Survey(100, 9);
    Survey survey6 = new Survey(8, 148);
    LLRatings llRatings;
    LinkedList<Survey> survey = new LinkedList<>();
    LinkedList<Integer> downloads = new LinkedList<>();
    LinkedList<Integer> rankings = new LinkedList<>();

    public Examples() {
        survey.add(survey1);
        survey.add(survey2);
        survey.add(survey3);
        survey.add(survey4);
        survey.add(survey5);
        survey.add(survey6);
        radioStation.addTodaysSurveys(survey);
        downloads.add(10);
        downloads.add(100);
        rankings.add(100);
        rankings.add(100);
    }

    //BestRankThisMonth Tests
    @Test
    public void testBestRankThisMonth_givenValidAnswer() {
        dailyRating.addTodaysSurveys(survey);
        assertEquals(100, dailyRating.bestRankThisMonth());
    }

    //TotalSongDownloads Tests
    @Test
    public void testTotalSongDownloads_givenValidAnswer() {
        assertEquals(2, dailyRating.totalSongDownloads(3, 2014), 100);
    }
}
