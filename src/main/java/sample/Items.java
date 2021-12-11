package sample;

public class Items {
    public Items(String itemcustno, String itemcustname,double itemcdep,int itemnyears,String itemsavtype) {
        this.itemcustno = itemcustno;
        this.itemcustname = itemcustname;
        this.itemcdep =itemcdep;
        this.itemnyears = itemnyears;
        this.itemsavtype =itemsavtype;
    }

    private String itemcustno;

    private String itemcustname;

    private double itemcdep;

    private int itemnyears;

    private  String itemsavtype;

    public String getItemcustno() {
        return itemcustno;
    }

    public void setItemcustno(String itemcustno) {
        this.itemcustno = itemcustno;
    }

    public double getItemcdep() {
        return itemcdep;
    }

    public void setItemcdep(double itemcdep) {
        this.itemcdep = itemcdep;
    }
    public int getItemnyears() {
        return itemnyears;
    }

    public void setItemnyears(int itemnyears) {
        this.itemnyears = itemnyears;
    }
    public String getItemcustname() {
        return itemcustname;
    }

    public void setItemcustname(String itemcustname) {
        this.itemcustname = itemcustname;
    }
    public String getItemsavtype() {
        return itemsavtype;
    }

    public void setItemsavtype(String itemsavtype) {
        this.itemsavtype = itemsavtype;
    }

}
