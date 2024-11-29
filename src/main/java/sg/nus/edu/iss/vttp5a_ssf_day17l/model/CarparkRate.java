package sg.nus.edu.iss.vttp5a_ssf_day17l.model;

public class CarparkRate {
    private Integer id;
    private String carpark;
    private String category;
    private String weekdaysRate1;
    private String weekdaysRate2;
    private String saturdayRate;
    private String sundayRate;

    public CarparkRate(Integer id, String carpark, String category, String weekdaysRate1, String weekdaysRate2,
            String saturdayRate, String sundayRate) {
        this.id = id;
        this.carpark = carpark;
        this.category = category;
        this.weekdaysRate1 = weekdaysRate1;
        this.weekdaysRate2 = weekdaysRate2;
        this.saturdayRate = saturdayRate;
        this.sundayRate = sundayRate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarpark() {
        return carpark;
    }

    public void setCarpark(String carpark) {
        this.carpark = carpark;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWeekdaysRate1() {
        return weekdaysRate1;
    }

    public void setWeekdaysRate1(String weekdaysRate1) {
        this.weekdaysRate1 = weekdaysRate1;
    }

    public String getWeekdaysRate2() {
        return weekdaysRate2;
    }

    public void setWeekdaysRate2(String weekdaysRate2) {
        this.weekdaysRate2 = weekdaysRate2;
    }

    public String getSaturdayRate() {
        return saturdayRate;
    }

    public void setSaturdayRate(String saturdayRate) {
        this.saturdayRate = saturdayRate;
    }

    public String getSundayRate() {
        return sundayRate;
    }

    public void setSundayRate(String sundayRate) {
        this.sundayRate = sundayRate;
    }

    @Override
    public String toString(){
        return "" + this.id + "," + this.carpark + "," + this.category + "," + this.weekdaysRate1 + "," + this.weekdaysRate2 + "," + this.saturdayRate + "," + this.sundayRate;
    }

    
}
