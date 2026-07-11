import java.util.LinkedList;

public class RadioStation {

    private IDailyRating dailyRatings;

    public RadioStation(IDailyRating dailyRatings) {
        this.dailyRatings = dailyRatings;
    }

    public int bestRankThisMonth() {
         return dailyRatings.bestRankThisMonth();
    }


    public int totalSongDownloads(int month, int year) {
        return dailyRatings.totalSongDownloads(month, year);
    }


    public void addTodaysSurveys(LinkedList<Survey> surveys) {
        dailyRatings.addTodaysSurveys(surveys);
    }
}

// 1) What might be a better data structure than a LinkedList<TodaysRatings> to encapsulate? Why?
// Arrays would be a better use of encapsulation because arrays store multiple data of similar types with the same name.
// Because there is so much data, encapsulation would put it together and require access through the methods, creating less code clump.

// 2) If you implemented a class to encapsulate that data structure as a field, how would that class implement the methods of the interface you designed? (you can answer at a high level).
// A class must specify that implements that interface, and it must also provide implementation for all the methods, defined in the interface.

// 3) Do you think it is possible to implement that class without modifying the interface? Why or why not?
// It is not possible because the methods are stored within the interface, their needs to be an instance of a class implementing the interface or else there is an error.
