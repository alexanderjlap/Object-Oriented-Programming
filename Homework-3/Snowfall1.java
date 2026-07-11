import java.util.LinkedList;

class Snowfall1 {
  Snowfall1(){}

  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum >= 101; } // Jan 1st
  // extracts the month from an 4-digit date
  int extractMonth(double dateNum) { return ((int)( dateNum / 100)); }

  /**
   * The purpose of this function is to consume data as a double and then take in a month
   * @param data
   * @param month
   * @return this function will return a list of reports of the largest snowfall measure for each day
   */
  public LinkedList<MaxInchReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
    LinkedList<MaxInchReport> report = new LinkedList<>();
    LinkedList<Double> dataReport = new LinkedList<>();
    double dates = 0;
    double inch = 0;

    for (int i = 0; i < data.size(); i++) {
      if (isDate(data.get(i)) && month == extractMonth(data.get(i))) {
        dates = data.get(i);
        for (int j = i + 1; j < data.size(); j++) {
          if (data.get(j) > inch) {
            inch = data.get(j);
          }
        }
        report.add(new MaxInchReport(dates, inch));
      }
      }
      return report;
    }
  }
