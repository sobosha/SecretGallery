package com.example.gallerysecret.Setting;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.gallerysecret.MainActivity;

import java.util.List;


public class mLocalData {

    public static void setLogInstall(Context context, boolean sync) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("install", sync);
        editor.apply();
    }


    public static void openDialogLogin (Context context , boolean open) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("openDialog", open);
        editor.apply();
    }

    public static void setSigns(Context context , boolean sign) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("signs", sign);
        editor.apply();
    }


    public static boolean getSigns (Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("signs" , false);
    }

    public static boolean isOpenDialogLogin(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("openDialog", false);
    }


    public static boolean getLogInstall(Context context) {

        SharedPreferences prefs =
                context!=null ?context.getSharedPreferences("MyDB", Context.MODE_PRIVATE)
                : nValue.getGlobal().getContext().getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("install", false);
    }


    /*------------------------------------------- token ------------------------------------------------------*/

    public static void SetToken(Context context, String token) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("token", token);
        editor.apply();
    }

    public static String getToken(Context context) {
        SharedPreferences prefs =
                context!=null ?context.getSharedPreferences("MyDB", Context.MODE_PRIVATE) :
                        nValue.getGlobal().getContext().getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("token", "");
         /*return "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpZCI6IjciLCJleHBpcmUiOjE1Njc3NTYyMzN9." +
                 "SBfrq85reHAhkhUvkZQ60H9GkOalua6br8acFuFyELCKDXCrvlTFY9pWsOJo6KEMUJv_ArXnJ-iNTwtD_g1aOg";*/
    }

    public static void SetQues(Context context, String token) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("question", token);
        editor.apply();
    }

    public static String getQues(Context context) {
        SharedPreferences prefs =
                context!=null ?context.getSharedPreferences("MyDB", Context.MODE_PRIVATE) :
                        nValue.getGlobal().getContext().getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("question", "");
         /*return "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpZCI6IjciLCJleHBpcmUiOjE1Njc3NTYyMzN9." +
                 "SBfrq85reHAhkhUvkZQ60H9GkOalua6br8acFuFyELCKDXCrvlTFY9pWsOJo6KEMUJv_ArXnJ-iNTwtD_g1aOg";*/
    }

    /*-------------------------- mobile -----------------------*/
    public static void setMobile(Context context, String mobile) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("mobile", mobile);
        editor.apply();
    }

    public static String getMobile(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("mobile", "");

    }

    /*-------------------------- id -----------------------*/
    public static void setUserID(Context context, int userId) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putInt("userID", userId);
        editor.apply();
    }

    public static int getUserID(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getInt("userID", 0);
    }
    /*--------------------------------------------------*/

    public static void SetCurrentDay(Context context, String token) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("curDay", token);
        editor.apply();
    }

    public static String getCurrentDay(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("curDay", "");
    }

    /*------------------------------- advice set---------------------------*/
    public static boolean isAdviceInDB(Context context) {
        Context context1 = context==null? nValue.getGlobal().getContext():context;
        SharedPreferences prefs = context1.getSharedPreferences("MyDB", context1.MODE_PRIVATE);
        return prefs.getBoolean("adviceInDB", false);
    }

    public static void setAdviceIDB(Context context, boolean done) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("adviceInDB", done);
        editor.apply();
    }

    /*------------------------------- user track ---------------------------*/
    private static SharedPreferences sharedPreferences = nValue.getGlobal().getContext().getApplicationContext().getSharedPreferences("MyDB", Context.MODE_PRIVATE);
    private static SharedPreferences.Editor editor = sharedPreferences.edit();

    public static void set(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }


    /* ------------------------------------------------*/
    public static boolean isUpdateInfo(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("dayStats", false);
    }

    public static void setInfoUpdate(Context context, boolean done) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("dayStats", done);
        editor.apply();
    }
    /*----------------------------- name  ----------------------------------*/

    public static void setAvatar(Context context, String name) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("avatar", name);
        editor.apply();
    }

    public static String getAvatar(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("avatar", "");
    }
    public static void setAvatarTallar(Context context, String type) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("avatarTallar", type);
        editor.apply();
    }

    public static int getBackgroundTalar(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getInt("BackgroundTalar", -1);
    }
    public static void setBackgroundTalar(Context context, int backgroundTalar) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putInt("BackgroundTalar", backgroundTalar);
        editor.apply();
    }


    public static String getAvatarURL(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("AvatarURL", "1");
    }
    public static void setAvatarURL(Context context, String avatarURL) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("AvatarURL", avatarURL);
        editor.apply();
    }

    public static String getAvatarTallar(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("avatarTallar", "1");
    }


    public static void setName(Context context, String name) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("namee", name);
        editor.apply();
    }

    public static String getName(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("namee", "");
    }

    public static void setPassword(Context context, String key) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("key", key);
        editor.apply();
    }


    public static String getPassword(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("key", "");

    }

    public static void setPasswordHint(Context context, String hint) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("hintt", hint);
        editor.apply();
    }

    public static String getPasswordHint(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("hintt", "");
    }


    public static boolean getDarkThemeStatus(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("darktheme", false);
    }

    public static void setDarkThemeStatus(Context context, boolean dark) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("darktheme", dark);
        editor.apply();
    }

    public static boolean getLoggedIn(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("LoggedIn", false);
    }

    public static void setLoggedIn(Context context, boolean loggedIn) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("LoggedIn", loggedIn);
        editor.apply();
    }

    public static boolean getIsSetFingerPrint(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("finger", false);
    }

    public static void setFingerPrint(Context context, boolean fingerPrint) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("finger", fingerPrint);
        editor.apply();
    }


    /*------------- push FCM ---------------------------------*/
    public static void setPush(Context context, boolean value) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("pushe", value);
        editor.apply();
    }

    public static boolean getPush(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("pushe", false);
    }

    /* ----------- userInfo ----------------------*/
    public static void setUserInfo(Context context, boolean registered) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("userInfo", registered);
        editor.apply();
    }

    public static String getAppLang(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("appLang", "IR");
    }

    public static void setAppLang(Context context, String registered) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("appLang", registered);
        editor.apply();
    }

    public static boolean getUserInfo(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("userInfo", false);
    }

    /* -----------pill  data seted in db  ----------------------*/
    public static void pillSetIsInDB(Context context, boolean registered) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("isInDB", registered);
        editor.apply();
    }

    public static boolean pillGetIsInDB(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("isInDB", false);
    }

    /*-----------------  events pil tbl is Seted or not --------------------------------*/
    public static void pillTblIsSetInDB(Context context, boolean isThere) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("pillTblIsInDB", isThere);
        editor.apply();
    }

    public static boolean getPillTblIsInDB(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("pillTblIsInDB", false);
    }


    /* -------------------------------------- versions --------------------------------------------------*/
    public static String getArticleVerion(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("articleVersion", "");
    }

    public static void setArticleVersion(Context context, String name) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("articleVersion", name);
        editor.apply();
    }

    public static String getPillVerion(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("pillVersion", "");
    }

    public static void setPillVerion(Context context, String version) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("pillVersion", version);
        editor.apply();
    }

    public static String getReminderVerion(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("reminderVersion", "");
    }

    public static void setReminderVersion(Context context, String version) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("reminderVersion", version);
        editor.apply();
    }

    public static String getSignVerion(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("signVersion", "");
    }

    public static void setSignVersion(Context context, String version) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("signVersion", version);
        editor.apply();
    }

    public static String getAdviceVerion(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("adviceVersion", "");
    }

    public static void setAdviceVersion(Context context, String version) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("adviceVersion", version);
        editor.apply();
    }

    public static String getHebbiesVerion(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("hobbiesVersion", "");
    }

    public static void setHobbiesVersion(Context context, String version) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("hobbiesVersion", version);
        editor.apply();
    }

    public static String getVideoVersion(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("videoVersion", "");
    }

    public static void setVideoVersion(Context context, String version) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("videoVersion", version);
        editor.apply();
    }

    public static String getVideoEducationVersion(Context context , int catId) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("educationVideoVersion"+catId, "");
    }

    public static void setVideoEducationVersion(Context context, String version , int catId) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("educationVideoVersion"+catId, version);
        editor.apply();
    }

    public static String getDescriptionOnlineClass(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("descOnlineClass", "");
    }

    public static void setDescriptionOnlineClass(Context context, String desc) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("descOnlineClass", desc);
        editor.apply();
    }

    public static String getVideoCategoryOnline(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("videoCategoryOnline", "");
    }

    public static void setVideoCategoryOnline(Context context, String video) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("videoCategoryOnline", video);
        editor.apply();
    }


    public static String getCategoryVideoVersion(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("categoryVideoVersion", "");
    }

    public static void setCategoryVideoVersion(Context context, String version) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("categoryVideoVersion", version);
        editor.apply();
    }


    public static String getCategoryOnlineVersion(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("categoryOnlineVersion", "");
    }

    public static void setCategoryOnlineVersion(Context context, String version) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("categoryOnlineVersion", version);
        editor.apply();
    }


    public static String getCategoryPodcastVersion(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("categoryPodcastVersion", "");
    }

    public static void setCategoryPodcastVersion(Context context, String version) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("categoryPodcastVersion", version);
        editor.apply();
    }

    public static String getPodcastVersion(Context context , int catId) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("podcastVersion"+catId, "");
    }

    public static void setPodcastVersion(Context context, String version , int catId) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("podcastVersion"+catId, version);
        editor.apply();
    }

    public static String getMusicVersion(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("musicVersion", "");
    }

    public static void setMusicVersion(Context context, String version) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("musicVersion", version);
        editor.apply();
    }

    public static String getWalkVersion(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("walkVersion", "");
    }

    public static void setWalkVersion(Context context, String version) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("walkVersion", version);
        editor.apply();
    }

    public static String getGameVersion(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("gameVersion", "");
    }

    public static void setGameVersion(Context context, String version) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("gameVersion", version);
        editor.apply();
    }

    /*---------------------------------------- state ------------------------------------*/
    // pr, wbf , f , wbp , pm
    public static String getLastState(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("lastState", "pr");
    }

    public static void setLastState(Context context, String version) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("lastState", version);
        editor.apply();
    }

    public static Boolean isFirstPr(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("firstPr", true);
    }

    public static void setFirstPr(Context context, boolean cal) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("firstPr", cal);
        editor.apply();
    }

    public static void setPrCounter(Context context, int conter) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putInt("prConter", conter);
        editor.apply();
    }

    public static int getPrCounter(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getInt("prConter", 0);
    }

    public static void setWbfCounter(Context context, int conter) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putInt("wbfCounter", conter);
        editor.apply();
    }

    public static int getWbfCounter(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getInt("wbfCounter", 0);
    }

    public static void setcheckFertility(Context context, boolean isChecked) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("checkFertility", isChecked);
        editor.apply();
    }

    public static boolean isCheckedFertility(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("checkFertility", false);
    }

    public static void setStillFerttility(Context context, boolean isChecked) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("stillFertility", isChecked);
        editor.apply();
    }

    public static boolean getStillFertility(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("stillFertility", false);
    }

    public static void setFertilityCounter(Context context, int conter) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putInt("fertility", conter);
        editor.apply();
    }

    public static int getFertilityCounter(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getInt("fertility", 0);
    }


    public static void setWbpCounter(Context context, int conter) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putInt("wbpCounter", conter);
        editor.apply();
    }

    public static int getWbpCounter(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getInt("wbpCounter", -1);
    }

    public static void setPmsCounter(Context context, int conter) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putInt("pmsCounter", conter);
        editor.apply();
    }

    public static int getPmsCounter(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getInt("pmsCounter", 0);
    }

    public static Boolean isCheckPMS(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("checkPms", true);
    }

    public static void setCheckPMS(Context context, boolean cal) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("checkPms", cal);
        editor.apply();
    }


    /*------------------------------- check first time setting reminder ---------------------*/

    public static Boolean isFirstReminder(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("firstReminder", false);
    }

    public static void setFirstReminder(Context context, boolean fisrt) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("firstReminder", fisrt);
        editor.apply();
    }


    public static void setBackSound(Context context, boolean backS) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("backSound", backS);
        editor.apply();
    }

    public static boolean getBackSound(Context context) {

        if (context != null) {
            SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
            return prefs.getBoolean("backSound", false);
        } else {
            context = MainActivity.getGlobal().getApplicationContext();
            SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
            return prefs.getBoolean("backSound", false);
        }
    }

    //    -------------------------- event Count ----------------------------
    public static void setEventCount(Context context, int eventCount) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putInt("eventCount", eventCount);
        editor.apply();
    }

    public static int getEventCount(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getInt("eventCount", 0);
    }

    public static void setBookmarkCount(Context context, int eventCount) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putInt("BookmarkCount", eventCount);
        editor.apply();
    }

    public static int getbookmarkCount(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getInt("BookmarkCount", 0);
    }

    public static void setPostCount(Context context, int eventCount) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putInt("PostCount", eventCount);
        editor.apply();
    }

    public static int getPostCount(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getInt("PostCount", 0);
    }


    //    ---------------------- has avatar --------------------------------------
    //todo set in mDatabase DeleteMetod too
    public static void setHasAvatar(Context context, boolean hasAvatar) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("hasAvatar", hasAvatar);
        editor.apply();
    }

    public static boolean getHasAvatar(Context context) {

        if (context != null) {
            SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
            return prefs.getBoolean("hasAvatar", false);
        } else {
            context = MainActivity.getGlobal().getApplicationContext();
            SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
            return prefs.getBoolean("hasAvatar", false);
        }
    }



    public static void setSection(Context context, int section) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putInt("section", section);
        editor.apply();
    }

    public static int getSection(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getInt("section", -1);
    }

    public static void setNotificationEnable (Context context, boolean notifEnabled) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("enableNotif", notifEnabled);
        editor.apply();
    }

    public static boolean getNotificationEnable (Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("enableNotif", true);
    }

    public static void setNotificationOfWaterAndOverAll (Context context , boolean notif) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("waterOverNotif", notif);
        editor.apply();
    }


    public static boolean getNotificationOfWaterAndOverAll (Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("waterOverNotif", true);
    }

    public static void setNotStartCounter(Context context, int notStartCounter) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putInt("notStart", notStartCounter);
        editor.apply();
    }

    /*-----------------------------------------------------------------------------------------------*/
    public static void isUpdateUserDatesInfo(Context context, boolean flag) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("userDatesInfo", flag);
        editor.apply();
    }

    public static boolean getUpdateUserDateInfo(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("userDatesInfo", false);
    }

    //    ---------------------------------------------------------------------------------------------
    public static void setMusicShowAgain(Context context, int notStartCounter) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putInt("musicAgain", notStartCounter);
        editor.apply();
    }

    public static int getMusicShowAgain(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getInt("musicAgain", 0);
    }

    public static void setVideoShowAgain(Context context, int notStartCounter) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putInt("videoAgain", notStartCounter);
        editor.apply();
    }

    public static int getVideoShowAgain(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getInt("videoAgain", 0);
    }
/*-----------------------------------------------------------------------------helps ----------------------------------------------------------------------------------*/
    public static void SetHelpMain(Context context,boolean value)
    {
        try {
            SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
            editor.putBoolean("HelpMain", value);
            editor.apply();
        }catch (Exception e) {
            e.printStackTrace();
        }
}
    public static boolean getHelpMain(Context context)
    {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("HelpMain",false);
    }

    public static void SetHelpForum(Context context,boolean value)
    {
        try {
            SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
            editor.putBoolean("HelpForum", value);
            editor.apply();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean getHelpForom(Context context)
    {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("HelpForum",false);
    }


    public static void SetHelpEntertainment(Context context,boolean value)
    {
        try {
            SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
            editor.putBoolean("HelpEntertainment", value);
            editor.apply();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean getHelpEntertainment(Context context)
    {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("HelpEntertainment",false);
    }


  /*-----------------------------------------------------------------------------------------------------------------------------------*/

    public static void setSawDialogHall(Context context,boolean isShown)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("setSawDialogHall", isShown);
        editor.apply();
    }

    public static boolean getSawDialogHall(Context context)
    {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("setSawDialogHall",false);
    }

    public static void setChangeSocialInfo(Context context,boolean isShown)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("changedSocialInfo", isShown);
        editor.apply();
    }

    public static boolean getChangeSocialInfo(Context context)
    {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("changedSocialInfo",false);
    }

    /*------------------------------------ partner -------------------------------------------*/
    public static void setOverAllAlert(Context context, String date)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("overAllAlert", date);
        editor.apply();
    }

    public static String getOverAllAlert(Context context)
    {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("overAllAlert" , "");
    }
    public static void setWaterAlert(Context context, String date)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("waterAlert", date);
        editor.apply();
    }

    public static String getWaterAlert(Context context)
    {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("waterAlert" , "");
    }

    public static void setPartnerInMain(Context context,boolean isIn)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("partnerInMain", isIn);
        editor.apply();
    }

    public static boolean getPartnerInMain(Context context)
    {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("partnerInMain" , true);
    }

    public static void setPermision2(Context context,boolean date)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("permision2partner", date);
        editor.apply();
    }

    public static boolean getPermision2(Context context)
    {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("permision2partner" , true);
    }


    public static void setFall(Context context,boolean fall)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("fall", fall);
        editor.apply();
    }

    public static boolean isFall(Context context)
    {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("fall" , false);
    }

    public static void setTall(Context context,float tall)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putFloat("bmiTall", tall);
        editor.apply();
    }

    public static float getTall(Context context)
    {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getFloat("bmiTall" , 150f);
    }

    public static void setLanguage(Context context,String lang)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("transLang", lang);
        editor.apply();
    }

    public static String getLanguage(Context context)
    {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("transLang" , "fa");
    }


    public static void setWaterOverAll(Context context,String tag)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("waterOvalAll", tag);
        editor.apply();
    }

    public static String getWaterOverAll(Context context)
    {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("waterOvalAll" , "water");
    }


    public static void setPartnerCount(Context context, int notStartCounter) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putInt("PartnerCount", notStartCounter);
        editor.apply();
    }

    public static int getPartnerCount(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getInt("PartnerCount", 0);
    }

    public static void setInstallDate(Context context,String tag)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("installDate", tag);
        editor.apply();
    }

    public static String getInstallDate(Context context)
    {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("installDate" , "");
    }

    public static void setFallMonth(Context context,String month)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("fallMonth", month);
        editor.apply();
    }

    public static String getFallMonth(Context context)
    {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("fallMonth" , "");
    }

    public static void setTodayDate(Context context,String date)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("todayDate", date);
        editor.apply();
    }

    public static String getTodayDate(Context context)
    {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("todayDate" , "");
    }

    //    -------------------------------------------------------------------------------
    public static void setInstagram(Context context, String instagram) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("instagram", instagram);
        editor.apply();
    }

    public static String getInstagram(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("instagram", "liom_apps");
    }



    public static void setCounterArticleMain(Context context, int count) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putInt("articleMain", count);
        editor.apply();
    }

    public static int getCounterArticleMain(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getInt("articleMain", 0);
    }


    //    -------------------------------------------------------------------------------
    public static void setPermitSign(Context context, boolean sign) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("permitSign", sign);
        editor.apply();
    }

    public static boolean isPermitSign(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("permitSign", false);
    }


    //    -------------------------------------------------------------------------------
    public static void setSignNew(Context context, boolean sign) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("signNew", sign);
        editor.apply();
    }

    public static boolean isSignNew(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("signNew", false);
    }

    public static void setLastMonthCal(Context context, boolean sign) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("lastMonthCAL", sign);
        editor.apply();
    }

    public static boolean getLastMonthCal(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("lastMonthCAL", false);
    }


    public static void setSandBox(Context context, int sandbox) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putInt("sandboxx", sandbox);
        editor.apply();
    }

    public static int getSandBox(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getInt("sandboxx", 0);
    }

    public static void setUserSendData(Context context, boolean sign) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("UserSendData", sign);
        editor.apply();
    }

    public static boolean getUserSendData(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("UserSendData", false);
    }

    public static void SetLength(Context context, String lengthhhhhh) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("lengthhhhhh", lengthhhhhh);
        editor.apply();
    }

    public static String getLength(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("lengthhhhhh", "");

    }



    public static void setSeenVideo(Context context, boolean seen) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putBoolean("seenVideo", seen);
        editor.apply();
    }

    public static boolean isSeenVideo(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getBoolean("seenVideo", false);

    }

    /*------------------------------------------- bio ------------------------------------------------------*/

    public static void SetBio(Context context, String bio) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("SetBio", bio);
        editor.apply();
    }

    public static String getBio(Context context) {
        SharedPreferences prefs = context!=null ?context.getSharedPreferences("MyDB", Context.MODE_PRIVATE) :
                        nValue.getGlobal().getContext().getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("SetBio", "");

    }
    public static void SetUserIP(Context context, String UserIP) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("UserIP", UserIP);
        editor.apply();
    }

    public static String getUserIP(Context context) {
        SharedPreferences prefs = context!=null ?context.getSharedPreferences("MyDB", Context.MODE_PRIVATE) :
                nValue.getGlobal().getContext().getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("UserIP", "");

    }


    public static void setDialogAdCount(Context context, int dialogAdCount) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putInt("dialogAdCount", dialogAdCount);
        editor.apply();
    }

    public static int getdialogAdCount(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getInt("dialogAdCount", 0);
    }

    public static void setBannerAdCount(Context context, int bannerAdCount) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putInt("bannerAdCount", bannerAdCount);
        editor.apply();
    }

    public static int getBannerAdCount(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getInt("bannerAdCount", 0);
    }

    public static void setTextAdCount(Context context, int textAdCount) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putInt("textAdCount", textAdCount);
        editor.apply();
    }

    public static int getTextAdCount(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getInt("textAdCount", 0);
    }


    public static void setAppFont(Context context, String appFont) {
        SharedPreferences.Editor editor = context.getSharedPreferences("MyDB", Context.MODE_PRIVATE).edit();
        editor.putString("appFont", appFont);
        editor.apply();
    }

    public static String getAppFont(Context context) {
        SharedPreferences prefs = context!=null ?context.getSharedPreferences("MyDB", Context.MODE_PRIVATE) :
                nValue.getGlobal().getContext().getSharedPreferences("MyDB", Context.MODE_PRIVATE);
        return prefs.getString("appFont", "dana");

    }


}
