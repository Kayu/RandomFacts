package com.example.kayuho.randomfacts;

import java.util.Random;

public class updateTextView {
  public String getnewFacts(String[] facts)
  {
      Random randomGenerator = new Random();
      return facts[ ( randomGenerator.nextInt(facts.length)) ];
  }
}
