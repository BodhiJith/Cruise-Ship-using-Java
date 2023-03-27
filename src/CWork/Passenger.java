package CWork;

public class Passenger {
    int expense;
    String fname;
    String sname;

    public Passenger() {
    }

    public Passenger(int expenses, String fname, String sname) {
        this.fname = fname;
        this.sname = sname;
        expense = expenses;
    }


    public int getexpense() {
        return expense;
    }

    public void setexpense(int expenses) {
        expense = expenses;
    }

    public String getfname() {
        return fname;
    }

    public void setfname (String fname) {
        this.fname = fname;
    }

    public String getsname() {
        return sname;
    }

    public void setsname(String sname) {
        this.sname = sname;
    }
}


