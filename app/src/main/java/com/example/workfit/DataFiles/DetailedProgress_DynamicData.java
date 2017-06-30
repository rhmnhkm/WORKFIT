package com.example.workfit.DataFiles;

/**
 * Created by Revina Adisty on 6/26/2017.
 */

public class DetailedProgress_DynamicData {
    private int _groupIndex;
    private int v0,v1, v2, v3,v4,v5,v6,v7,v8,v9;

    public DetailedProgress_DynamicData() {

    }

    public DetailedProgress_DynamicData(int _groupIndex,
                                        int v0, int v1, int v2, int v3,
                                        int v4, int v5, int v6, int v7,
                                        int v8, int v9){
        this._groupIndex = _groupIndex;
        this.v0 = v0;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
        this.v5 = v5;
        this.v6 = v6;
        this.v7 = v7;
        this.v8 = v8;
        this.v9 = v9;
    }

    public void setGroupIndex(int a) {
        this._groupIndex = a;
    }

    public int getGroupIndex() {
        return this._groupIndex;
    }


    public int getV0() {return v0;}
    public void addV0() {this.v0 += 1;}
    public int getV1() {return v1;}
    public void addV1() {this.v1 += 1;}
    public int getV2() {return v2;}
    public void addV2() {this.v2 += 1;}
    public int getV3() {return v3;}
    public void addV3() {this.v3 += 1;}
    public int getV4() {return v4;}
    public void addV4() {this.v4 += 1;}
    public int getV5() {return v5;}
    public void addV5() {this.v5 += 1;}
    public int getV6() {return v6;}
    public void addV6() {this.v6 += 1;}
    public int getV7() {return v7;}
    public void addV7() {this.v7 += 1;}
    public int getV8() {return v8;}
    public void addV8() {this.v8 += 1;}
    public int getV9() {return v9;}
    public void addV9() {this.v9 += 1;}


}
