package com.example.musicplayer;

public class favItem {
    String id;
    String itemLocation;
     String itemTitle;
     String fstatus;
     public favItem(){

     }

    public favItem(String id, String itemLocation, String itemTitle, String fstatus) {
        this.id = id;
        this.itemLocation = itemLocation;
        this.itemTitle = itemTitle;
        this.fstatus = fstatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(String itemLocation) {
        this.itemLocation = itemLocation;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getFstatus() {
        return fstatus;
    }

    public void setFstatus(String fstatus) {
        this.fstatus = fstatus;
    }
}
