package ru.mia.graduate.web;



public class SecurityUtil {

    private static int id ;

    public static int authUserId() {
        return id;
    }

    public static void setAuthUserId(int id) {
        SecurityUtil.id = id;
    }


}
