package com.example.gamingrewardandroid;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.example.gamingrewardandroid.MainApplication.getContext;


/**
 * Created by Priyanka on 3/19/2018.
 */

public class CommonFunctions {
  public Context context;

    /*
    * Function to hide keyboard.
    * @param context
    * @param view
    */
    public static void hideKeyboardFrom(Context context, View view) {
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void showToast(String msg){
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }



    /*
    * Function to show keyboard.
    * @param context
    * @param view
    */
    public static void showKeyboardFrom(Context context, View view) {
        InputMethodManager keyboard = (InputMethodManager)
                context.getSystemService(Context.INPUT_METHOD_SERVICE);
        keyboard.showSoftInput(view, 0);
    }

    /*
    * Function to show network error message.
    * @param activity
    */
    public static void showNetworkMsg(final Activity activity) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, "No internet connection.", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /*
    * Function to show progress dialog.
    * @param context
    * @param message
    */
    public static ProgressDialog showProgress(Context context, String message) {
        ProgressDialog mProgressDialog;
        mProgressDialog = new ProgressDialog(context);
        //  mProgressDialog.setContentView(R.layout.progressview);
        mProgressDialog.setMessage(message);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setCancelable(false);

        return mProgressDialog;
    }

    /*
    * Function to capitalize each word of a string.
    * @param s
    */
    public static String capitalize(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char first = s.charAt(0);
        if (Character.isUpperCase(first)) {
            return s;
        } else {
            return Character.toUpperCase(first) + s.substring(1);
        }
    }

    /*
    * Function to validate email.
    * @param email
    */
    public static boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                .matches();
    }

    /*
    * Function to validate phone number.
    * @param number
    */
    public static boolean isValidNumber(String number) {
        return Patterns.PHONE.matcher(number)
                .matches();
    }

    /*
    * Function to get month from month number.
    * @param month
    */
    public static String returnMonthOfDate(String month) {

        if (!(TextUtils.isEmpty(month))) {

            if (month.equalsIgnoreCase("1")) {
                return "JAN";
            } else if (month.equalsIgnoreCase("2")) {
                return "FEB";
            } else if (month.equalsIgnoreCase("3")) {
                return "MAR";
            } else if (month.equalsIgnoreCase("4")) {
                return "APRIL";
            } else if (month.equalsIgnoreCase("5")) {
                return "MAY";
            } else if (month.equalsIgnoreCase("6")) {
                return "JUNE";
            } else if (month.equalsIgnoreCase("7")) {
                return "JULY";
            } else if (month.equalsIgnoreCase("8")) {
                return "AUG";
            } else if (month.equalsIgnoreCase("9")) {
                return "SEPT";
            } else if (month.equalsIgnoreCase("10")) {
                return "OCT";
            } else if (month.equalsIgnoreCase("11")) {
                return "NOV";
            } else if (month.equalsIgnoreCase("12")) {
                return "DEC";
            }

        }
        return null;
    }

    /*
    * Function to convert date format from given sdf to "dd-MMM-yyyy".
    * @param date
    * @param sdf
    */
    public static String convertDateFormat(String date, SimpleDateFormat sdf) {

      //  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        java.util.Date d1 = null;
        try {
            d1 = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sdf.applyPattern("yyyy-MMM-dd");
        String mydt = sdf.format(d1);

        return mydt;
    }

    public static String convertDateFormatDOB(String date, SimpleDateFormat sdf) {

      //  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        java.util.Date d1 = null;
        try {
            d1 = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sdf.applyPattern("yyyy-MM-dd");
        String mydt = sdf.format(d1);
        return mydt;
    }

    static List<String> formatStrings = Arrays.asList("dd/MM/yyyy", "yyyy/MM/dd", "yyyy-MM-dd", "MM/dd/yyyy");

    /**
   * Function to get month name from date.
   * @param date
   */
    public static String monthFromDate(Date date){
        String monthString  = (String) DateFormat.format("MMM",  date);

        return monthString;
    }

    /**
   * Function to get day of week from date.
   * @param date
   */
    public static String dayOfTheWeekFromDate(Date date){
        String dayOfTheWeek = (String) DateFormat.format("EEEE", date);

        return dayOfTheWeek;
    }


    /**
     * Function to get day from date.
     * @param date
     */
    public static String dayFromDate(Date date){
        String day          = (String) DateFormat.format("dd",   date);

        return day;
    }

    public static String dateFromDate(Date date){
        String dateString          = (String) DateFormat.format("dd-MMM-yyyy",   date);

        return dateString;
    }

    public static String dateFromDateymd(Date date){
        String dateString          = (String) DateFormat.format("yyyy-MMM-dd",   date);

        return dateString;
    }

    /**
     * Function to get month number from date.
     * @param date
     */
    public static String monthNumberFromDate(Date date){
        String monthNumber  = (String) DateFormat.format("MM",   date);

        return monthNumber;
    }


    /**
     * Function to get year from date.
     * @param date
     */
    public static String yearFromDate(Date date){
        String year = (String) DateFormat.format("yyyy", date);

        return year;
    }


    /**
     * Function to get date in string of format "dd-MMM-yyyy".
     * @param dateString
     */
    public static String tryParse(String dateString)
    {
        for (String formatString : formatStrings)
        {
            try
            {
                SimpleDateFormat outputFormat = new SimpleDateFormat(formatString);
                Date date = outputFormat.parse(dateString);
                outputFormat.applyPattern("dd-MMM-yyyy");
                String returenDate = outputFormat.format(date);
                return returenDate;
            }
            catch (ParseException e) {}
        }

        return null;
    }

    /**
     * Function to get date in string of format "dd/MM/yyyy".
     * @param dateString
     */
    public static String dateSplitsBySlash(String dateString)
    {
        for (String formatString : formatStrings)
        {
            try
            {
                SimpleDateFormat outputFormat = new SimpleDateFormat(formatString);
                Date date = outputFormat.parse(dateString);
                outputFormat.applyPattern("yyyy-MMM-dd");

                String returenDate = outputFormat.format(date);
                return returenDate;
            }
            catch (ParseException e) {}
        }

        return null;
    }

    /**
     * Function to get Date from String
     * @param dateString
     */
    public static Date stringToDate(String dateString)
    {
        for (String formatString : formatStrings)
        {
            try
            {
                if(formatString.equals("dd/MM/yyyy")){
                    String[] items1 = dateString.split("/");
                    if (items1.length == 3) {
                        if( items1[0].length() == 4){
                            formatString = "yyyy/MM/dd";
                        }
                        SimpleDateFormat outputFormat = new SimpleDateFormat(formatString);
                        Date date = outputFormat.parse(dateString);
                        return date;
                    }
                }else {
                    SimpleDateFormat outputFormat = new SimpleDateFormat(formatString);
                    Date date = outputFormat.parse(dateString);
                    return date;
                }
            }
            catch (ParseException e) {
                try {
                    if(formatString.equals("yyyy/MM/dd")){
                        String[] items1 = dateString.split("/");
                        String date1 = null, month = null, year = null;
                        if (items1.length == 3) {
                            year = items1[0];
                            month = items1[1];
                            date1 = items1[2];
                            String date = date1+ "/" + month + "/" + year;

                            SimpleDateFormat outputFormat = new SimpleDateFormat(formatString);
                            Date date2 = outputFormat.parse(date);
                            return date2;
                           /* try {
                                Date date2 = outputFormat.parse(date);
                                return date2;
                            } catch (ParseException e1) {
                                e1.printStackTrace();
                            }*/
                        }
                    }else if(formatString.equals("dd/MM/yyyy")){
                        String[] items1 = dateString.split("/");
                        String date1 = null, month = null, year = null;
                        if (items1.length == 3) {
                            date1 = items1[0];
                            month = items1[1];
                            year = items1[2];
                            String date = date1+ "/" + month + "/" + year;

                            SimpleDateFormat outputFormat = new SimpleDateFormat(formatString);
                            Date date2 = outputFormat.parse(date);
                            return date2;
                           /* try {
                                Date date2 = outputFormat.parse(date);
                                return date2;
                            } catch (ParseException e1) {
                                e1.printStackTrace();
                            }*/
                        }
                    }
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
        }

        return null;
    }

    public static Date stringToDateDash(String dateString)
    {
        String formatString = "yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat outputFormat = new SimpleDateFormat(formatString);
        Date date = null;
        try {
            date = outputFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Function to get String from Date
     * @param dateString
     */
    public static String dateToString(Date dateString)
    {
        for (String formatString : formatStrings)
        {
            String dateTime = formatString.format(String.valueOf(dateString));

            return dateTime;
        }

        return null;
    }

    public static String getNetworkClass(Context context) {
        TelephonyManager mTelephonyManager = (TelephonyManager)
                context.getSystemService(Context.TELEPHONY_SERVICE);
        @SuppressLint("MissingPermission") int networkType = mTelephonyManager.getNetworkType();
        switch (networkType) {
            case TelephonyManager.NETWORK_TYPE_GPRS:
            case TelephonyManager.NETWORK_TYPE_EDGE:
            case TelephonyManager.NETWORK_TYPE_CDMA:
            case TelephonyManager.NETWORK_TYPE_1xRTT:
            case TelephonyManager.NETWORK_TYPE_IDEN:
                return "2G";
            case TelephonyManager.NETWORK_TYPE_UMTS:
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
            case TelephonyManager.NETWORK_TYPE_HSDPA:
            case TelephonyManager.NETWORK_TYPE_HSUPA:
            case TelephonyManager.NETWORK_TYPE_HSPA:
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
            case TelephonyManager.NETWORK_TYPE_EHRPD:
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                return "3G";
            case TelephonyManager.NETWORK_TYPE_LTE:
                return "4G";
            default:
                return "Unknown";
        }
    }

}

