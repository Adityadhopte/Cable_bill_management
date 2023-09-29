package com.tech.cablebill;

public class Planet_route {

    public String Id;
    public String routename;
    public String Agentid;
    public String Agentname;

    public Planet_route(String id, String Routename, String Agentid, String Agentname){
        this.Id = id;
        this.routename= Routename;
        this.Agentid = Agentid;
        this.Agentname = Agentname;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getRoutename() {
        return routename;
    }

    public void setRoutename(String routename) {
        this.routename = routename;
    }

    public String getAgentid() {
        return Agentid;
    }

    public void setAgentid(String agentid) {
        Agentid = agentid;
    }

    public String getAgentname() {
        return Agentname;
    }

    public void setAgentname(String agentname) {
        Agentname = agentname;
    }
}
