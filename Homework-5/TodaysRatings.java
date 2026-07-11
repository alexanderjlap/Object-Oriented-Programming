import java.util.GregorianCalendar;
import java.util.LinkedList;

public class TodaysRatings {

    private GregorianCalendar date;
    private LinkedList<Integer> rankings = new LinkedList<Integer>();
    private LinkedList<Integer> downloads = new LinkedList<Integer>();

    public TodaysRatings(int year, int month, int dayOfMonth) {
        date = new GregorianCalendar(year, month, dayOfMonth);
    }

    //Getters
    public GregorianCalendar getDate() {
        return date;
    }

    public LinkedList<Integer> getRankings() {
        return rankings;
    }

    public LinkedList<Integer> getDownloads() {
        return downloads;
    }

    //Setters
    public void setDate(GregorianCalendar newDate) {
        this.date = newDate;
    }

    public void setRankings(LinkedList<Integer> newRankings) {
        this.rankings = newRankings;
    }

    public void setDownloads(LinkedList<Integer> newDownloads) {
        this.downloads = newDownloads;
    }

}

