package com.example.sqlite_database;

public class ProductModel {
    private String pdtCategory, pdtId, pdtName, pdtQuantity, pdtBp, pdtSp;

    //constructor
    public ProductModel(String pdtCategory, String pdtId, String pdtName, String pdtQuantity, String pdtBp, String pdtSp) {
        this.pdtCategory = pdtCategory;
        this.pdtId = pdtId;
        this.pdtName = pdtName;
        this.pdtQuantity = pdtQuantity;
        this.pdtBp = pdtBp;
        this.pdtSp = pdtSp;
    }

    //    empty constructor to construct an object with default values
    public ProductModel() {
        this.pdtCategory = "";
        this.pdtId = "";
        this.pdtName = "";
        this.pdtQuantity = "";
        this.pdtBp = "";
        this.pdtSp = "";
    }

    //    getters and setters
    public String getPdtCategory() {
        return pdtCategory;
    }

    public void setPdtCategory(String pdtCategory) {
        this.pdtCategory = pdtCategory;
    }

    public String getPdtId() {
        return pdtId;
    }

    public void setPdtId(String pdtId) {
        this.pdtId = pdtId;
    }

    public String getPdtName() {
        return pdtName;
    }

    public void setPdtName(String pdtName) {
        this.pdtName = pdtName;
    }

    public String getPdtQuantity() {
        return pdtQuantity;
    }

    public void setPdtQuantity(String pdtQuantity) {
        this.pdtQuantity = pdtQuantity;
    }

    public String getPdtBp() {
        return pdtBp;
    }

    public void setPdtBp(String pdtBp) {
        this.pdtBp = pdtBp;
    }

    public String getPdtSp() {
        return pdtSp;
    }

    public void setPdtSp(String pdtSp) {
        this.pdtSp = pdtSp;
    }
}
