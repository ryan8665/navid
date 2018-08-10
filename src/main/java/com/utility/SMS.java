/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utility;

/**
 *
 * @author ryan
 */
public class SMS {
    public static void _send(String phone, String message) {
        try {

            com.kavenegar.sdk.KavenegarApi api = new com.kavenegar.sdk.KavenegarApi("756E6C616757626C38644136574558586236666F39773D3D");
            api.send("10001000550077", phone, message);
        } catch (com.kavenegar.sdk.excepctions.ApiException ex) {
            // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
            System.out.print(ex.toString());
        } catch (com.kavenegar.sdk.excepctions.HttpException ex) {
            // در زمانی که مشکلی در برقرای ارتباط با وب سرویس وجود داشته باشد این خطا رخ می دهد
            System.out.print(ex.toString());
        } catch (Exception ex) {
            System.out.print(ex.toString());
        }
    }

    public static void sendWelcome(String phone, String name) {
        try {

            com.kavenegar.sdk.KavenegarApi api = new com.kavenegar.sdk.KavenegarApi("756E6C616757626C38644136574558586236666F39773D3D");
            api.send("10001000550077", phone, "" + name + "، خوش آمدید\n"
                    + "ورود به سامانه \n"
                    + "در " + com.utility.DateTime.todayDay() + "");
        } catch (com.kavenegar.sdk.excepctions.ApiException ex) {
            // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
            System.out.print("Message 11111111111111: " + ex.toString());
        } catch (com.kavenegar.sdk.excepctions.HttpException ex) {
            // در زمانی که مشکلی در برقرای ارتباط با وب سرویس وجود داشته باشد این خطا رخ می دهد
            System.out.print("Message 11111111111111112: " + ex.toString());
        } catch (Exception ex) {
            System.out.print("Message 11111111111111113: " + ex.toString());
        }
    }

    public static void sendPass(String phone, String name, String user, String pass) {
        try {

            com.kavenegar.sdk.KavenegarApi api = new com.kavenegar.sdk.KavenegarApi("756E6C616757626C38644136574558586236666F39773D3D");
            api.send("10001000550077", phone, "سامانه \n"
                    + "مشخصات ورود شما عبارت است از\n"
                    + "نام کاربری: " + user + "\n"
                    + "گذرواژه: " + pass + "");
        } catch (com.kavenegar.sdk.excepctions.ApiException ex) {
            // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
            System.out.print("Message 11111111111111: " + ex.toString());
        } catch (com.kavenegar.sdk.excepctions.HttpException ex) {
            // در زمانی که مشکلی در برقرای ارتباط با وب سرویس وجود داشته باشد این خطا رخ می دهد
            System.out.print("Message 11111111111111113: " + ex.toString());
        } catch (Exception ex) {
            System.out.print("Message 11111111111111113: " + ex.toString());
        }
    }
    
}
