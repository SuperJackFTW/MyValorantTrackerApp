package com.example.myvaloranttrackerapp;

public class AgentInstance {
    private static AgentInstance instance;
    private String agentName;

    private AgentInstance(){
        agentName = "noAgent";
    }

    public static AgentInstance getInstance(){
        instance = new AgentInstance();
        return instance;
    }

    public String setAgentName(String value){
        agentName = value;
        return value;
    }

    public String getAgentName(){
        return agentName;
    }




}
