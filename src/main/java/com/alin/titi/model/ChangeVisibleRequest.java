package com.alin.titi.model;

public class ChangeVisibleRequest {
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    private boolean visible=false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id=0;
}
