import java.util.LinkedList;

public interface IDailyRating {
    int bestRankThisMonth();
    int totalSongDownloads(int month, int year);
    void addTodaysSurveys(LinkedList<Survey> surveys);
}
