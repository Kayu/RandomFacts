package com.example.kayuho.randomfacts;

import android.database.Cursor;

import java.util.List;
import java.util.Random;

public class RandomFacts {
  public String getnewFacts(List<String> facts)
  {
      Random randomGenerator = new Random();
      int size = facts.size();
      return facts.get( randomGenerator.nextInt(size));
      //return facts[ ( randomGenerator.nextInt(facts.length)) ];
  }
}
