package Entity;

import java.sql.Date;

public class Aim {

    private int id;
    private String aim;
    private Date date;
    private boolean isDone;

    public Aim(int id, String aim, Date date, boolean isDone) {
        this.id = id;
        this.aim = aim;
        this.date = date;
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
