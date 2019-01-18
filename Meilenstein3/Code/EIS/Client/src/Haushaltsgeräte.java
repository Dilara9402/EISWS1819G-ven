import java.util.Date;

public class Haushaltsgeräte {

   private String art;
   private double verbrauch;
   private Date datum=new Date();

    public Haushaltsgeräte(String art, double verbrauch) {
        this.art = art;
        this.verbrauch = verbrauch;
    }

    public String getArt() {
        return art;
    }

    public double getVerbrauch() {
        return verbrauch;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public void setVerbrauch(double verbrauch) {
        this.verbrauch = verbrauch;
    }

    public Date getDatum() {
        return datum;
    }

    public void print(){
        System.out.println(art + " : " + verbrauch + " kWH " + datum);
    }
}
