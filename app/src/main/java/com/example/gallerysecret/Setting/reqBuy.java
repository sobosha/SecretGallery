package com.example.gallerysecret.Setting;

public class reqBuy {

  String id,code ;
  int gate ;

    public reqBuy(String id, int gate) {
        this.id = id;
        this.gate = gate;
    }

    public reqBuy(String id, String code, int gate) {
        this.id = id;
        this.code = code;
        this.gate = gate;
    }
}
