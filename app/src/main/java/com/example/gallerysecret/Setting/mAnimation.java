package com.example.gallerysecret.Setting;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

import com.example.gallerysecret.R;


public class mAnimation {
    public static Animation myScale(final View NewView, float fromX, float fromY, float toX, float toY, long startOffset, int duration) {
        Animation scale = new ScaleAnimation(fromX, toX, fromY, toY, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(duration);
        scale.setInterpolator(new FastOutSlowInInterpolator());
        scale.setStartOffset(startOffset);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }

    public static Animation CustomScale(final View NewView, float fromX, float fromY, float toX, float toY, long startOffset, int duration) {
        Animation scale = new ScaleAnimation(fromX, toX, fromY, toY, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1);
        scale.setDuration(duration);
        scale.setInterpolator(new OvershootInterpolator());
        scale.setStartOffset(startOffset);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }

     public static Animation mpCycleRoll(View rel , int repeat) {
        RotateAnimation anim = new RotateAnimation(360, 0,
                RotateAnimation.RELATIVE_TO_SELF, 0.50f,
                RotateAnimation.RELATIVE_TO_SELF, 0.505f);
        anim.setInterpolator(new ReverseInterpolator(new LinearInterpolator()));
        anim.setDuration(1000);
        anim.setFillEnabled(true);
        anim.setRepeatCount(repeat);
        anim.setFillAfter(true);
        anim.setStartOffset(0);
        rel.startAnimation(anim);
        return anim;
    }
    public static Animation myTrans_ToBottomGame(final View NewView, long startOffset, int duration,float toY)
    {
        Animation scale = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_PARENT,0, Animation.RELATIVE_TO_PARENT,toY);
        scale.setDuration(duration);
        scale.setInterpolator(new LinearInterpolator());
        scale.setRepeatMode(Animation.REVERSE);
        scale.setRepeatCount(1);
        scale.setStartOffset(startOffset);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }

    public static Animation animateMain1(double fromDegrees, double toDegrees, double fromDegrees1, double toDegrees1, long durationMillis, View v1, View v2) {
        final RotateAnimation rotate = new RotateAnimation((float) fromDegrees, (float) toDegrees,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(durationMillis);
        rotate.setFillEnabled(true);
        rotate.setFillAfter(true);
        v1.startAnimation(rotate);

        final RotateAnimation rotate1 = new RotateAnimation((float) fromDegrees1, (float) toDegrees1,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate1.setDuration(durationMillis);
        rotate1.setFillEnabled(true);
        rotate1.setFillAfter(true);
        v2.startAnimation(rotate1);
        return rotate1;
    }

    public static Animation animateMain2(double fromDegrees, double toDegrees, double fromDegrees1, double toDegrees1, long durationMillis, View v1, View v2) {
        final RotateAnimation rotate = new RotateAnimation((float) fromDegrees, (float) toDegrees,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(durationMillis);
        rotate.setFillEnabled(true);
        rotate.setFillAfter(true);
        v1.startAnimation(rotate);

        final RotateAnimation rotate1 = new RotateAnimation((float) fromDegrees1, (float) toDegrees1,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate1.setDuration(durationMillis);
        rotate1.setFillEnabled(true);
        rotate1.setFillAfter(true);
        v2.startAnimation(rotate1);
        return rotate1;
    }

    public static Animation animateEnd(View view,float x1,float y1,double fromDegrees) {
        final RotateAnimation rotate = new RotateAnimation((float) fromDegrees + 100, (float) 0,
                RotateAnimation.RELATIVE_TO_SELF, 0.48f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(1000);
        rotate.setFillEnabled(true);
        rotate.setFillAfter(true);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.clearAnimation();
                view.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(rotate);
        view.setX(x1);
        view.setY(y1);
        return rotate;
    }



    public static Animation myTransInRightSabet(final View NewView, long startOffset, int duration, int toX) {
        Animation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, toX,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(duration);
        translateAnimation.setStartOffset(startOffset);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new LinearInterpolator());
        NewView.startAnimation(translateAnimation);
        return translateAnimation;

    }




    public static Animation myTransInRightSabet1(final View NewView, long startOffset, int duration, int fromX, int ToX, int fromY, int ToY) {
        Animation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, fromX,
                Animation.RELATIVE_TO_SELF, ToX,
                Animation.RELATIVE_TO_SELF, fromY,
                Animation.RELATIVE_TO_SELF, ToY);
        translateAnimation.setDuration(duration);
        translateAnimation.setStartOffset(startOffset);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new FastOutSlowInInterpolator());
        NewView.startAnimation(translateAnimation);
        return translateAnimation;

    }

    public static Animation myTransInRightReturn(final View NewView, long startOffset, int duration) {
        Animation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 1,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(duration);
        translateAnimation.setStartOffset(startOffset);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new LinearInterpolator());
        NewView.startAnimation(translateAnimation);
        return translateAnimation;

    }


    public static Animation myFadeOutRepeat1(final View NewView, long startOffset, int duration) {
        Animation alpha = new AlphaAnimation(1f, 0f);
        alpha.setDuration(duration);
        alpha.setStartOffset(startOffset);
        alpha.setFillEnabled(true);
        alpha.setFillAfter(true);
        alpha.setRepeatCount(Animation.INFINITE);
        alpha.setInterpolator(new LinearInterpolator());
        NewView.startAnimation(alpha);
        return alpha;
    }

    public static Animation myFadeOutRepeat2(final View NewView, long startOffset, int duration) {
        Animation alpha = new AlphaAnimation(0f, 1f);
        alpha.setDuration(duration);
        alpha.setStartOffset(startOffset);
        alpha.setFillEnabled(true);
        alpha.setFillAfter(true);
        alpha.setRepeatCount(Animation.INFINITE);
        alpha.setRepeatMode(Animation.REVERSE);
        alpha.setInterpolator(new LinearInterpolator());
        NewView.startAnimation(alpha);
        return alpha;
    }

    public static void TimerShow(View view) {
        Animation alpha = new AlphaAnimation(0, 1);
        alpha.setDuration(500);
        alpha.setInterpolator(new LinearOutSlowInInterpolator());
        alpha.setRepeatMode(Animation.REVERSE);
        alpha.setRepeatCount(2);
        view.startAnimation(alpha);
    }

    public static Animation myScale_fromTop(final View NewView, float fromX, float fromY, float toX, float toY, long startOffset, int duration) {
        Animation scale = new ScaleAnimation(fromX, toX, fromY, toY, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1);
        scale.setDuration(duration);
        scale.setInterpolator(new LinearInterpolator());
        scale.setStartOffset(startOffset);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }

    public static Animation myInLeft(final View NewView, long startOffset, int duration, int fromX, int fromY) {
        Animation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, fromX,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, fromY,
                Animation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(duration);
        translateAnimation.setStartOffset(startOffset);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        NewView.startAnimation(translateAnimation);
        return translateAnimation;

    }

    public static Animation myInLeftRepear(final View NewView, long startOffset, int duration, float fromX,float toX,float toY, float fromY) {
        Animation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, fromX,
                Animation.RELATIVE_TO_SELF, toX,
                Animation.RELATIVE_TO_SELF, fromY,
                Animation.RELATIVE_TO_SELF, toY);
        translateAnimation.setDuration(duration);
        translateAnimation.setStartOffset(startOffset);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        translateAnimation.setRepeatCount(Animation.INFINITE);
        translateAnimation.setFillAfter(true);
        NewView.startAnimation(translateAnimation);
        return translateAnimation;

    }

    public static void Main_Show(View NewView, int duration, long offSet) {
        Animation alpha = new AlphaAnimation(0, 1);
        Animation trans = new TranslateAnimation(0, 0, (-1) * NewView.getContext().getResources().getDimension(R.dimen._8sdp), 0);
        trans.setInterpolator(new AccelerateInterpolator());
        AnimationSet Seter = new AnimationSet(false);
        Seter.addAnimation(alpha);
        Seter.addAnimation(trans);
        Seter.setDuration(duration);
        Seter.setFillEnabled(true);
        Seter.setFillAfter(true);
        NewView.startAnimation(Seter);
    }

    public static void Main_Show_Only(View NewView, int duration, long offSet) {
        Animation alpha = new AlphaAnimation(0, 1);
        Animation trans = new TranslateAnimation(0, 0, 0, 0);
        trans.setInterpolator(new AccelerateInterpolator());
        AnimationSet Seter = new AnimationSet(false);
        Seter.addAnimation(alpha);
        Seter.addAnimation(trans);
        Seter.setDuration(duration);
        Seter.setFillEnabled(true);
        Seter.setFillAfter(true);
        NewView.startAnimation(Seter);
    }

    public static void Main_Fade(final View NewView, View OldView, final ViewGroup Parent, final int duration, final long offSet) {
        Animation alpha = new AlphaAnimation(1, 0);
        alpha.setDuration(duration);
        alpha.setFillEnabled(true);
        alpha.setFillAfter(true);
        alpha.setStartOffset(offSet);
        OldView.startAnimation(alpha);
        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Parent.removeAllViews();
                Parent.addView(NewView);
                Main_Show(NewView, duration, offSet);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    public static Animation myFadeIn(final View NewView, long startOffset, int duration) {
        Animation alpha = new AlphaAnimation(0f, 1.0f);
        alpha.setDuration(duration);
        alpha.setStartOffset(startOffset);
        alpha.setFillEnabled(true);
        alpha.setFillAfter(true);
        NewView.startAnimation(alpha);
        return alpha;
    }

    public static Animation myFadeOut(final View NewView, long startOffset, int duration) {
        Animation alpha = new AlphaAnimation(1f, 0f);
        alpha.setDuration(duration);
        alpha.setStartOffset(startOffset);
        alpha.setFillEnabled(true);
        alpha.setFillAfter(true);
        NewView.startAnimation(alpha);
        return alpha;
    }


    public static Animation myFadeInOut(final View NewView, long startOffset, int duration)
    {
        Animation alpha = new AlphaAnimation(1.0f,0f);
        alpha.setDuration(duration);
        alpha.setStartOffset(startOffset);
        alpha.setRepeatMode(Animation.REVERSE);
        alpha.setRepeatCount(1);
        alpha.setFillEnabled(true);
        alpha.setFillAfter(true);
        NewView.startAnimation(alpha);
        return alpha;
    }

    public static Animation myTransInTop(final View NewView, long startOffset, int duration, int FromY) {
        Animation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, FromY,
                Animation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(duration);
        translateAnimation.setStartOffset(startOffset);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new OvershootInterpolator());
        NewView.startAnimation(translateAnimation);
        return translateAnimation;
    }


    public static Animation myTransInTopCustom(final View NewView, long startOffset, int duration, int FromY) {
        Animation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, FromY,
                Animation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(duration);
        translateAnimation.setStartOffset(startOffset);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new FastOutSlowInInterpolator());
        NewView.startAnimation(translateAnimation);
        return translateAnimation;
    }

    public static Animation myTransOutTop(final View NewView, long startOffset, int duration, int toY) {
        Animation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, toY);
        translateAnimation.setDuration(duration);
        translateAnimation.setStartOffset(startOffset);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        NewView.startAnimation(translateAnimation);
        return translateAnimation;
    }

    public static Animation myTransOutLeft(final View NewView, long startOffset, int duration, float toX,float FromX) {
        Animation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, FromX,
                Animation.RELATIVE_TO_SELF, toX,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(duration);
        translateAnimation.setStartOffset(startOffset);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        NewView.startAnimation(translateAnimation);
        return translateAnimation;
    }


    public static Animation PressClick(View v) {
        Animation scale = AnimationUtils.loadAnimation(v.getContext(), R.anim.press_click);
        v.startAnimation(scale);
        return scale;
    }

    public static Animation myTransInLeft(final View NewView, long startOffset, int duration, float toX) {
        Animation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, toX,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(duration);
        translateAnimation.setStartOffset(startOffset);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new OvershootInterpolator());
        NewView.startAnimation(translateAnimation);
        NewView.setVisibility(View.VISIBLE);
        return translateAnimation;
    }

    public static Animation myTransInLeftCustom(final View NewView, long startOffset, int duration, float toX, Interpolator interpolator) {
        Animation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, toX,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(duration);
        translateAnimation.setStartOffset(startOffset);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(interpolator);
        NewView.startAnimation(translateAnimation);
        NewView.setVisibility(View.VISIBLE);
        return translateAnimation;
    }


    public static Animation myTransInLeft1(final View NewView, long startOffset, int duration, float toX) {
        Animation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, toX,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(duration);
        translateAnimation.setStartOffset(startOffset);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new LinearInterpolator());
        NewView.startAnimation(translateAnimation);
        NewView.setVisibility(View.VISIBLE);
        return translateAnimation;
    }

    public static Animation myTransInLeftSlow(final View NewView, long startOffset, int duration, float toX) {
        Animation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, toX,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(duration);
        translateAnimation.setStartOffset(startOffset);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new OvershootInterpolator());
        NewView.startAnimation(translateAnimation);
        NewView.setVisibility(View.VISIBLE);
        return translateAnimation;
    }

    public static Animation myTransToLeft(final View NewView, long startOffset, int duration, float fromX,float toX) {
        Animation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, fromX,
                Animation.RELATIVE_TO_SELF, toX,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(duration);
        translateAnimation.setStartOffset(startOffset);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new OvershootInterpolator(0.5f));
        NewView.startAnimation(translateAnimation);
        NewView.setVisibility(View.VISIBLE);
        return translateAnimation;
    }

    public static Animation myTransInRight(final View NewView, long startOffset, int duration, float toX) {
        Animation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, toX,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(duration);
        translateAnimation.setStartOffset(startOffset);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new OvershootInterpolator());
        NewView.startAnimation(translateAnimation);
        NewView.setVisibility(View.VISIBLE);
        return translateAnimation;

    }

    public static void ViberatonR(View rel , long startOffset)
    {
        Animation anim = new TranslateAnimation(0,15,0,0);
        anim.setDuration(1000);
        anim.setFillEnabled(false);
        anim.setFillAfter(false);
        anim.setStartOffset(startOffset);
        anim.setRepeatMode(ObjectAnimator.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        rel.startAnimation(anim);

    }
    public static Animation myTransOutLR(final View NewView, long startOffset, int duration, float FromX, float toX) {
        Animation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, FromX,
                Animation.RELATIVE_TO_SELF, toX,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(duration);
        translateAnimation.setStartOffset(startOffset);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        NewView.startAnimation(translateAnimation);
        return translateAnimation;
    }
    public static Animation myTransOutLRGone(final View NewView, long startOffset, int duration, float FromX, float toX) {
        Animation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, FromX,
                Animation.RELATIVE_TO_SELF, toX,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(duration);
        translateAnimation.setStartOffset(startOffset);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                NewView.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        NewView.startAnimation(translateAnimation);
        return translateAnimation;
    }

    public static Animation townScale(final View NewView, float fromX, float fromY, float toX, float toY, long startOffset, int duration) {
        Animation scale = new ScaleAnimation(fromX, toX, fromY, toY, Animation.RELATIVE_TO_SELF, 0.95f, Animation.RELATIVE_TO_SELF, 0.95f);
        scale.setDuration(duration);
        scale.setStartOffset(startOffset);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }

    public static void TransYekSevom(View NewView, int toX) {
        Animation translateAnimation = new TranslateAnimation(0, toX, 0, 0);
        translateAnimation.setDuration(1);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        NewView.startAnimation(translateAnimation);
    }

    public static void myCoinAnim(View view, long startOffset, int duration, float fromX, float toX, float fromY, float toY) {
        Animation scale = new ScaleAnimation(fromX, toX, fromY, toY, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(duration);
        scale.setStartOffset(startOffset);
        scale.setRepeatMode(Animation.REVERSE);
        scale.setRepeatCount(Animation.INFINITE);
        view.startAnimation(scale);
    }

    public static void Viberation(View rel) {
        Animation anim = new TranslateAnimation(0, 15, 0, 0);
        anim.setDuration(50);
        anim.setFillEnabled(false);
        anim.setFillAfter(false);
        anim.setStartOffset(0);
        anim.setRepeatMode(ObjectAnimator.REVERSE);
        anim.setRepeatCount(9);
        rel.startAnimation(anim);
    }

    public static Animation Viberation(View rel , int duration)
    {
        Animation anim = new TranslateAnimation(0,15,0,0);
        anim.setDuration(duration);
        anim.setFillEnabled(false);
        anim.setFillAfter(false);
        anim.setStartOffset(0);
        anim.setRepeatMode(ObjectAnimator.REVERSE);
        anim.setRepeatCount(9);
        rel.startAnimation(anim);
        return anim;
    }

    public static Animation rotationInfinit(final View NewView, long startOffset, int duration, int From, int To) {
        RotateAnimation rotate = new RotateAnimation(
                From, To,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        rotate.setDuration(duration);
        rotate.setStartOffset(startOffset);
        rotate.setInterpolator(new FastOutSlowInInterpolator());
        rotate.setRepeatCount(Animation.INFINITE);
        NewView.startAnimation(rotate);
        return rotate;
    }

    public static Animation townScaleMiddle(final View NewView, float fromX, float fromY, float toX, float toY, long startOffset, int duration) {
        Animation scale = new ScaleAnimation(fromX, toX, fromY, toY, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(duration);
        scale.setStartOffset(startOffset);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }

    public static Animation townScaleMiddleCustom(final View NewView, float fromX, float fromY, float toX, float toY, long startOffset, int duration) {
        Animation scale = new ScaleAnimation(fromX, toX, fromY, toY, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(duration);
        scale.setStartOffset(startOffset);
        scale.setInterpolator(new LinearInterpolator());
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        scale.setRepeatMode(Animation.REVERSE);
        scale.setRepeatCount(1);
        NewView.startAnimation(scale);
        return scale;
    }

    public static Animation myFadeOutRepeat(final View NewView, long startOffset, int duration) {
        Animation alpha = new AlphaAnimation(1f, 0f);
        alpha.setDuration(duration);
        alpha.setStartOffset(startOffset);
        alpha.setFillEnabled(true);
        alpha.setRepeatMode(Animation.REVERSE);
        alpha.setRepeatCount(1);
        alpha.setFillAfter(true);
        NewView.startAnimation(alpha);
        return alpha;
    }

    public static Animation myFadeOutRepeatCustom(final View NewView, long startOffset, int duration) {
        Animation alpha = new AlphaAnimation(1f, 0f);
        alpha.setDuration(duration);
        alpha.setStartOffset(startOffset);
        alpha.setFillEnabled(true);
        alpha.setRepeatMode(Animation.REVERSE);
        alpha.setInterpolator(new LinearInterpolator());
        alpha.setRepeatCount(Animation.INFINITE);
        alpha.setFillAfter(true);
        NewView.startAnimation(alpha);
        return alpha;
    }

    public static Animation rotation(final View NewView, long startOffset, int duration, int From, int To, int Count) {
        RotateAnimation rotate = new RotateAnimation(
                From, To,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        rotate.setDuration(duration);
        rotate.setInterpolator(new LinearInterpolator());
        rotate.setStartOffset(startOffset);
        rotate.setRepeatCount(Count);
        NewView.startAnimation(rotate);
        return rotate;
    }




    public static Animation myTransInLeftt(final View NewView, long startOffset, int duration, int fromX, int fromY, Interpolator interpolator) {
        Animation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, fromX,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, fromY,
                Animation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(duration);
        translateAnimation.setStartOffset(startOffset);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(interpolator);
        NewView.startAnimation(translateAnimation);
        return translateAnimation;

    }

    public static Animation myScaleRepeat(final View NewView, float fromX, float fromY, float toX, float toY, long startOffset, int duration) {
        Animation scale = new ScaleAnimation(fromX, toX, fromY, toY, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(duration);
        scale.setStartOffset(startOffset);
        scale.setRepeatMode(Animation.REVERSE);
        scale.setRepeatCount(Animation.INFINITE);
        NewView.startAnimation(scale);
        return scale;

    }

    public static Animation myTrans_fromBottom(final View NewView, long startOffset, long duration)
    {
        Animation scale = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,1, Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,0);
        scale.setDuration(duration);
        scale.setInterpolator(new LinearInterpolator());
        scale.setStartOffset(startOffset);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }

    public static Animation myTrans_ToBottom(final View NewView, long startOffset, int duration,float toY)
    {
        Animation scale = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_PARENT,0, Animation.RELATIVE_TO_PARENT,toY);
        scale.setDuration(duration);
        scale.setInterpolator(new AccelerateDecelerateInterpolator());
        scale.setStartOffset(startOffset);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }

    public static Animation myTrans_ToBottomCustom(final View NewView, long startOffset, int duration,float toY)
    {
        Animation scale = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_PARENT,0, Animation.RELATIVE_TO_PARENT,toY);
        scale.setDuration(duration);
        scale.setInterpolator(new FastOutSlowInInterpolator());
        scale.setStartOffset(startOffset);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }


    public static Animation myTrans_ToTop(final View NewView, long startOffset, int duration)
    {
        Animation scale = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_PARENT,0.2f, Animation.RELATIVE_TO_PARENT,0);
        scale.setDuration(duration);
        scale.setInterpolator(new AccelerateDecelerateInterpolator());
        scale.setStartOffset(startOffset);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }

    public static Animation myTrans_ToTop2(final View NewView, long startOffset, int duration,float ToY,float fromY)
    {
        Animation scale = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_PARENT,ToY, Animation.RELATIVE_TO_PARENT,fromY);
        scale.setDuration(duration);
        scale.setInterpolator(new AccelerateDecelerateInterpolator());
        scale.setStartOffset(startOffset);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }

    public static Animation CustommyTrans_ToTop(final View NewView, long startOffset, int duration)
    {
        Animation scale = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_PARENT,0.8f, Animation.RELATIVE_TO_PARENT,0);
        scale.setDuration(duration);
        scale.setInterpolator(new AccelerateDecelerateInterpolator());
        scale.setStartOffset(startOffset);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }

    public static Animation myTrans_ToTopSnack(final View NewView, long startOffset, int duration)
    {
        Animation scale = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                0, Animation.RELATIVE_TO_SELF,
                0, Animation.RELATIVE_TO_PARENT,
                0.2f, Animation.RELATIVE_TO_PARENT,
                0);
        scale.setDuration(duration);
        scale.setInterpolator(new OvershootInterpolator());
        scale.setStartOffset(startOffset);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }

    public static Animation myTrans_ToBottom(final View NewView, long startOffset, int duration)
    {
        Animation scale = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                0, Animation.RELATIVE_TO_SELF,
                0, Animation.RELATIVE_TO_PARENT,
                -1,
                0, Animation.RELATIVE_TO_PARENT);
        scale.setDuration(duration);
        scale.setInterpolator(new FastOutSlowInInterpolator());
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }

    public static Animation myTrans_ToBottomBAck(final View NewView, long startOffset, int duration)
    {
        Animation scale = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                0, Animation.RELATIVE_TO_SELF,
                0, Animation.RELATIVE_TO_PARENT,
                0,
                -1, Animation.RELATIVE_TO_PARENT);
        scale.setDuration(duration);
        scale.setInterpolator(new LinearInterpolator());
        scale.setStartOffset(startOffset);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }

    public static Animation mProgressAnim(final View NewView, int duration, float fromX, float toX, float fromY, float toY, float fromAlfa, float toAlfe) {
        Animation scale = new ScaleAnimation(
                fromX, toX, fromY, toY,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(duration);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);

        Animation fade = new AlphaAnimation(fromAlfa, toAlfe);
        fade.setDuration(duration);
        fade.setFillEnabled(true);
        fade.setFillAfter(true);

        AnimationSet settre = new AnimationSet(false);
        settre.addAnimation(scale);
        settre.addAnimation(fade);
        settre.setFillEnabled(true);
        settre.setFillAfter(true);
        NewView.startAnimation(settre);
        return settre;

    }

    public static Animation nabz(final View NewView,float fromX,float fromY,float toX,float toY,long startOffset,int duration , boolean isRepeat)
    {
        Animation scale = new ScaleAnimation(fromX,toX,fromY,toY, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(duration);
        scale.setInterpolator(new FastOutSlowInInterpolator());
        scale.setStartOffset(startOffset);
        if(isRepeat) {
            scale.setRepeatMode(Animation.INFINITE);
            scale.setRepeatCount(Animation.INFINITE);
        } else {
            scale.setRepeatMode(Animation.REVERSE);
            scale.setRepeatCount(1);
        }
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }


    public static Animation scaleImageSlowInhaleExhale(final View NewView,float fromX,float fromY,float toX,float toY,long startOffset,int duration)
    {
        Animation scale = new ScaleAnimation(fromX,toX,fromY,toY, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(duration);
        scale.setInterpolator(new FastOutSlowInInterpolator());
        scale.setStartOffset(startOffset);
        scale.setRepeatCount(1);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }

    public static Animation CycleRoll(View rel, float rotate) {
        RotateAnimation anim = new RotateAnimation( 0, rotate,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        // anim.setInterpolator(new ReverseInterpolator(new FastOutSlowInInterpolator()));
        anim.setDuration(1500);
        anim.setFillEnabled(true);
        anim.setFillAfter(true);
        anim.setStartOffset(0);
        rel.startAnimation(anim);
        return  anim;
    }

    public static Animation CycleRollCustom(View rel, float rotate,int count) {
        RotateAnimation anim = new RotateAnimation( 0, rotate,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        // anim.setInterpolator(new ReverseInterpolator(new FastOutSlowInInterpolator()));
        anim.setDuration(1500);
        anim.setFillEnabled(true);
        anim.setFillAfter(true);
        anim.setStartOffset(0);
        anim.setRepeatCount(count);
        rel.startAnimation(anim);
        return  anim;
    }


    public static Animation CycleRollRepeat(View rel, float rotate) {
        RotateAnimation anim = new RotateAnimation( 0, rotate,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        // anim.setInterpolator(new ReverseInterpolator(new FastOutSlowInInterpolator()));
        anim.setDuration(1000);
        anim.setFillEnabled(true);
        anim.setFillAfter(true);
        anim.setStartOffset(0);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(1);
        rel.startAnimation(anim);
        return  anim;
    }

    public static Animation CycleRollInfinit(View rel,int duration) {
        RotateAnimation anim = new RotateAnimation( 0, 360,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(duration);
        anim.setFillEnabled(true);
        anim.setFillAfter(true);
        anim.setStartOffset(0);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        rel.startAnimation(anim);
        return  anim;
    }



    public static Animation CustomScaleRepeat(final View NewView, float fromX, float fromY, float toX, float toY, long startOffset, int duration) {
        Animation scale = new ScaleAnimation(fromX, toX, fromY, toY, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1);
        scale.setDuration(duration);
        scale.setInterpolator(new FastOutSlowInInterpolator());
        scale.setStartOffset(startOffset);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        scale.setRepeatCount(Animation.INFINITE);
        scale.setRepeatMode(Animation.REVERSE);
        NewView.startAnimation(scale);
        return scale;
    }

    public static Animation myTransInTopLinearInterpolator(final View NewView, long startOffset, int duration, int FromY) {
        Animation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, FromY,
                Animation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(duration);
        translateAnimation.setStartOffset(startOffset);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new LinearInterpolator());
        NewView.startAnimation(translateAnimation);
        return translateAnimation;
    }

    public static Animation myTrans_fromTop(final View NewView, long startOffset, long duration) {
        NewView.setVisibility(View.VISIBLE);
        Animation scale = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -0.3f, Animation.RELATIVE_TO_SELF, 0);
        scale.setDuration(duration);
        scale.setInterpolator(new OvershootInterpolator());
        scale.setStartOffset(startOffset);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }

    public static Animation myTrans_fromTop2(final View NewView, long startOffset, long duration,float FromY) {
        NewView.setVisibility(View.VISIBLE);
        Animation scale = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, FromY, Animation.RELATIVE_TO_SELF, 0);
        scale.setDuration(duration);
        scale.setInterpolator(new OvershootInterpolator());
        scale.setStartOffset(startOffset);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }


    public static Animation myTrans_fromTopNew(final View NewView, long startOffset, long duration) {
        NewView.setVisibility(View.VISIBLE);
        Animation scale = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -0.3f, Animation.RELATIVE_TO_SELF, 0);
        scale.setDuration(duration);
        scale.setInterpolator(new BounceInterpolator());
        scale.setStartOffset(startOffset);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }

    public static Animation myTrans_fromTopCustom(final View NewView, long startOffset, long duration) {
        NewView.setVisibility(View.VISIBLE);
        Animation scale = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -0.3f, Animation.RELATIVE_TO_SELF, 0);
        scale.setDuration(duration);
        scale.setInterpolator(new BounceInterpolator());
        scale.setStartOffset(startOffset);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }

    public static Animation CustomViberation(View rel, int duration,int count) {
        rel.setVisibility(View.VISIBLE);
        Animation anim = new TranslateAnimation(0, 15, 0, 0);
        anim.setDuration(duration);
        anim.setFillEnabled(false);
        anim.setFillAfter(false);
        anim.setStartOffset(0);
        anim.setRepeatMode(ObjectAnimator.REVERSE);
        anim.setRepeatCount(count);
        rel.startAnimation(anim);
        return anim;
    }

    public static Animation bell(final View NewView, long startOffset, int duration) {
        RotateAnimation rotate = new RotateAnimation(
                -20, 20,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        rotate.setDuration(duration);
        rotate.setStartOffset(startOffset);
        rotate.setInterpolator(new LinearInterpolator());
        rotate.setRepeatCount(2);
        rotate.setRepeatMode(Animation.REVERSE);
        NewView.startAnimation(rotate);
        return rotate;
    }


    public static Animation myTrans_ToBottomBYFRom(final View NewView, long startOffset, int duration,float toY , float fromY , boolean reverse)
    {
        Animation scale = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_PARENT,fromY, Animation.RELATIVE_TO_PARENT,toY);
        scale.setDuration(duration);
        scale.setInterpolator(new AccelerateDecelerateInterpolator());
        scale.setStartOffset(startOffset);
        scale.setFillEnabled(true);
        if (reverse){
            scale.setRepeatCount(1);
            scale.setRepeatMode(Animation.REVERSE);
        }
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }

    public static Animation CustomScaleWithPivot(final View NewView, float fromX, float fromY, float toX, float toY, long startOffset, int duration , float PivotX , float PivotY) {
        Animation scale = new ScaleAnimation(fromX, toX, fromY, toY, Animation.RELATIVE_TO_SELF, PivotX, Animation.RELATIVE_TO_SELF, PivotY);
        scale.setDuration(duration);
        scale.setInterpolator(new LinearInterpolator());
        scale.setStartOffset(startOffset);
        scale.setFillEnabled(true);
        scale.setFillAfter(true);
        NewView.startAnimation(scale);
        return scale;
    }

    public static Animation CycleRollInfinit2(View rel, int duration) {
        RotateAnimation anim = new RotateAnimation(360, 0,
                RotateAnimation.RELATIVE_TO_SELF, 0.50f,
                RotateAnimation.RELATIVE_TO_SELF, 0.505f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setDuration(duration);
        anim.setFillEnabled(true);
        anim.setFillAfter(true);
        anim.setStartOffset(0);
        anim.setRepeatCount(Animation.INFINITE);
        rel.startAnimation(anim);
        return anim;
    }


    public static Animation CycleRollInfinitNew(View rel, int from, int to) {
        RotateAnimation anim = new RotateAnimation(from, to,
                RotateAnimation.RELATIVE_TO_SELF, 0.50f,
                RotateAnimation.RELATIVE_TO_SELF, 0.505f);
        anim.setInterpolator(new ReverseInterpolator(new LinearInterpolator()));
        anim.setDuration(10000);
        anim.setFillEnabled(true);
        anim.setFillAfter(true);
        anim.setStartOffset(0);
        anim.setRepeatCount(Animation.INFINITE);
        rel.startAnimation(anim);
        return anim;
    }

}
