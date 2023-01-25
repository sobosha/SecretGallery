package com.example.gallerysecret.Core;


public class DeepLinks {

    String deepLink, deepLinkNew;
    int IdP;
    String[] splitText;

    public DeepLinks(String deepLink) {
        this.deepLink = deepLink;
    }

    String backHobbies = "Entertaiment";
    public DeepLinks(String deepLink , String backHobbies) {
        this.deepLink = deepLink;
        this.backHobbies = backHobbies ;
    }

    public void onStart() {
        if (deepLink.contains("-")) {
            splitText = deepLink.split("-");
            deepLinkNew = splitText[0];
            IdP = Integer.parseInt(splitText[1]);
        } else
            deepLinkNew = deepLink;
        switch (deepLinkNew) {
            case "#calendar":
//                MainActivity.getGlobal().FinishFragStartFrag(new FragCalendar());
                break;
            default:
//                MainActivity.getGlobal().FinishFragStartFrag(new FragMain());
        }
    }



}
