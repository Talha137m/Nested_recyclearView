package com.example.modelClasses;

import java.util.List;

public class ParentModelClass {
    private String title;
    List<ChildModelClass> childModelClassList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ChildModelClass> getChildModelClassList() {
        return childModelClassList;
    }

    public void setChildModelClassList(List<ChildModelClass> childModelClassList) {
        this.childModelClassList = childModelClassList;
    }

    public ParentModelClass(String title, List<ChildModelClass> childModelClassList) {
        this.title = title;
        this.childModelClassList = childModelClassList;
    }
}
