package com.utf.api;

public enum ApiEndpoints {

    PRODUCTS_LIST("/productsList"),
    BRANDS_LIST("/brandsList"),
    SEARCH_PRODUCT("/searchProduct"),
    VERIFY_LOGIN("/verifyLogin"),
    CREATE_ACCOUNT("/createAccount"),
    UPDATE_ACCOUNT("/updateAccount"),
    DELETE_ACCOUNT("/deleteAccount"),
    GET_USER_BY_EMAIL("/getUserDetailByEmail");

    private final String path;

    ApiEndpoints(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}