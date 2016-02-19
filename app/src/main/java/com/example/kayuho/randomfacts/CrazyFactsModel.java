package com.example.kayuho.randomfacts;

/**
 * Created by kayuho on 2016-02-08.
 */
public class CrazyFactsModel {
    private String[] facts = {"crazy_facts_1","crazy_facts_2","crazy_facts_3","crazy_facts_4"};
    public String getFacts(){
        return (new RandomFacts().getnewFacts(facts));
    }
}
