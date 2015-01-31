package w2k15.com.moonlit.com.worldcup2015;

public class ScheduleData {
    private String teams;
    private String place;
    private String gmtTime;
    private String istTime;
    private String dayNite;
    private String pool;
    private String date;

    private String ground;
    private String city;


    public ScheduleData(String poolName, String dayNite, String city, String ground, String gmt, String ist, String date, String teams){
        this.pool = poolName;
        this.dayNite = dayNite;
        this.city = city;
        this.ground = ground;
        this.gmtTime = gmt;
        this.istTime = ist;
        this.date = date;
        this.teams = teams;

    }

    public  void setCity(String city)
    {
        this.city= city;
    }
    public String getCity()
    {
        return  city;
    }


    public  void setGround(String city)
    {
        this.ground= ground;
    }
    public String getGround()
    {
        return  ground;
    }
    public String getPool()
    {
        return  pool;
    }

    public  void setPool(String pool)
    {
        this.pool = pool;
    }

    public String getTeams() {
        return teams;
    }


    public void setTeams(String teams) {
        this.teams = teams;
    }



    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getGmtTime() {
        return gmtTime;
    }

    public void setGmtTime(String gmtTime) {
        this.gmtTime = gmtTime;
    }

    public String getIstTime() {
        return gmtTime;
    }

    public void setIstTime(String istTime) {
        this.gmtTime = istTime;
    }
    public String getDayNite( ) {
        return gmtTime;
    }

    public void setDayNite(String dayNite) {
        this.dayNite = dayNite;
    }

}