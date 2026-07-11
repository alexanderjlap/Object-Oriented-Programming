import java.util.LinkedList;

class Snowfall2 {
  Snowfall2() {}

  // checks whether a datum is a date
  boolean isDate(double anum) {
    return (int) anum >= 101;
  } // Jan 1st

  // extracts the month from an 4-digit date
  int extractMonth(double dateNum) {
    return ((int) (dateNum / 100));
  }


  /**
   * This function consumes a list of data as a double and also consumes a month
   * @param data
   * @param month
   * @return This function will return a list of reports indicating the largest snowfall for each day in the month
   */
  public LinkedList<MaxInchReport> dailyMaxForMonth (LinkedList<Double> data, int month) {
    LinkedList<MaxInchReport> report = new LinkedList<MaxInchReport>();
    int curmon = 0;
    double curmax = 0.0;
    double curdate = 0.0;

    if(data.size() == 0) {
      return report;
    }else {
      curdate = data.getFirst();
      curmon = extractMonth(curdate);
    }

    for (int i = 1; i < data.size(); i++) {
      double find = data.get(i);
      if(!isDate(find)) {
        if(find > curmax) {
          curmax = find;
        }
      }else {
        if(month ==curmon) {
          MaxInchReport finished = new MaxInchReport(curdate, curmax);
          report.add(finished);
          curmax = 0.0;
          curdate = find;
          curmon = extractMonth(find);
        }else {
          if(isDate(find)) {
            curmax = 0.0;
            curdate = find;
            curmon = extractMonth(find);
          }
        }
      }
      if((i == data.size()-1) && (month == curmon)) {
        if(find > curmax) {
          curmax = find;
        }
        MaxInchReport finishedLast = new MaxInchReport(curdate, curmax);
        report.add(finishedLast);
        return report;
      }
    }
    return report;
  }
}