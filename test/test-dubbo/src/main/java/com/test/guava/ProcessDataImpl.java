package com.test.guava;

public class ProcessDataImpl implements IProcessData {
    @Override
    public String deal(String data) {
          try {
             Thread. sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
          return "Finished:" + data;
    }
}
