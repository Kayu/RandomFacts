package com.example.kayuho.randomfacts;

import java.util.Random;

public class RandomFacts {
  public String getnewFacts(String[] facts)
  {
      Random randomGenerator = new Random();
      return facts[ ( randomGenerator.nextInt(facts.length)) ];
  }
}
