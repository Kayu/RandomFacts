package com.example.kayuho.randomfacts;

/**
 * Created by kayuho on 2016-02-08.
 */
public class SportFactsModel {
    private String[] facts = {"sports_facts_1","sports_facts_2","sports_facts_3","sports_facts_4"};
    public String getFacts(){
        return (new updateTextView().getnewFacts(facts));
    }
}
