public class DiplomaData {
    public String No;
    public String category;
    public String name;
    public String year2014;
    public String year2015;
    public String year2016;
    public String year2017;
    public String year2018;
    public String year2019;

    public DiplomaData(String no,String category,String name,String year2014,String year2015,
                       String year2016,String year2017,String year2018,String year2019) {
        this.No = no;
        this.category = category;
        this.name = name;
        this.year2014 = year2014;
        this.year2015 = year2015;
        this.year2016 = year2016;
        this.year2017 = year2017;
        this.year2018 = year2018;
        this.year2019 = year2019;
    }
    public int getTotalIntake(){
        int totalIntake = Integer.parseInt(year2014)+Integer.parseInt(year2015)+Integer.parseInt(year2016)
                +Integer.parseInt(year2017)+Integer.parseInt(year2018)+Integer.parseInt(year2019);
        return  totalIntake;
    }
    public int getMaxIntake(){
        int max = Math.max(Math.max(Math.max(Math.max(Math.max(Integer.parseInt(year2019), Integer.parseInt(year2018)),
                Integer.parseInt(year2017)), Integer.parseInt(year2016)), Integer.parseInt(year2015)), Integer.parseInt(year2014));
        return max;
    }
    public int getMinIntake() {
        int min = Math.min(Math.min(Math.min(Math.min(Math.min(Integer.parseInt(year2019), Integer.parseInt(year2018)),
                Integer.parseInt(year2017)), Integer.parseInt(year2016)), Integer.parseInt(year2015)), Integer.parseInt(year2014));
        return min;
    }

    public String toString(){
        String text = No + ". Program Category= " + category + ", Kursus Name = " + name + ", Maximum = " + getMaxIntake()
                + ", Minimum = "+ getMinIntake()+", Total People Intake = " + getTotalIntake();
        return text;
    }
}

