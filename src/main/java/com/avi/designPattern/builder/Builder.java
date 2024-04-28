package com.avi.designPattern.builder;

interface Builder {

    public void buildFloor();

    public void buildWalls();

    public void bulidTerrace();


    public Home getComplexHomeObject();

}
