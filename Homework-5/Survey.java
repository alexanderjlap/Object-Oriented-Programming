public class Survey {
    private int rankings;
    private int downloads;

    public int getRankings() {
        return rankings;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setRankings(int rankings) {
        this.rankings = rankings;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public Survey(int rankings, int downloads) {
        this.rankings = rankings;
        this.downloads = downloads;
    }


}
