package com.tech.cablebill;

public class Agentplanet {

    public String Id;
    public String Agent_name;

    public Agentplanet(String id, String agent_name){
        this.Id = id;
        this.Agent_name = agent_name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getAgent_name() {
        return Agent_name;
    }

    public void setAgent_name(String agent_name) {
        Agent_name = agent_name;
    }
}
