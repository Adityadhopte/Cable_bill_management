package com.tech.cablebill;

public class Customerlistplanet {

    public String Id;
    public String Customername;
    public String Settopbox;
    public String Phoneno;


    public Customerlistplanet(String id, String customername, String settopbox, String phoneno){
        this.Id = id;
        this.Customername = customername;
        this.Settopbox=settopbox;
        this.Phoneno=phoneno;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCustomername() {
        return Customername;
    }

    public void setCustomername(String customername) {
        Customername = customername;
    }

    public String getSettopbox() {
        return Settopbox;
    }

    public void setSettopbox(String settopbox) {
        Settopbox = settopbox;
    }

    public String getPhoneno() {
        return Phoneno;
    }

    public void setPhoneno(String phoneno) {
        Phoneno = phoneno;
    }
}
