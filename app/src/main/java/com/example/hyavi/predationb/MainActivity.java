package com.example.hyavi.predationb;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*****************************************
    PREDATION BETA - EAT OR BE EATEN
******************************************/

// Main activity
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//-- DECLARE GLOBAL VARIABLES -->

    // Log ID
    private static final String TAG = "EAT OR BE EATEN";

    // Context
    private final Context context = this;

    // Shared preferences constants
    private static final String CONTINUE_SAVED_STATE = "continue_saved_state";

    // Settings
    private static final String AUDIO_SAVED_STATE = "audio_saved_state";
    private static final String HAPTIC_SAVED_STATE = "haptic_saved_state";
    private static final String TUTORIAL_SAVED_STATE = "tutorial_saved_state";

    // Stage 1
    private static final String STAGE_01_COMPLETE = "stage_01_complete";
    private static final String STAGE_01_ATTEMPTS = "stage_01_attempts";
    private static final String STAGE_01_BOSS_KILLS = "stage_01_boss_kills";
    private static final String STAGE_01_CREATURE_KILLS = "stage_01_creature_kills";
    private static final String STAGE_01_HIGHEST_STREAK = "stage_01_highest_streak";
    private static final String STAGE_01_CLOSEST_DEATH = "stage_01_closest_death";
    private static final String STAGE_01_LONGEST_FRENZY = "stage_01_longest_frenzy";
    private static final String STAGE_01_MOST_CALM = "stage_01_most_calm";
    private static final String STAGE_01_MOST_FRANTIC = "stage_01_most_frantic";
    private static final String STAGE_01_TOTAL_TIME = "stage_01_total_time";
    private static final String STAGE_01_BEST_TIME = "stage_01_best_time";
    private static final String STAGE_01_PREDATOR = "stage_01_predator";
    private static final String STAGE_01_ACCURACY = "stage_01_accuracy";
    private static final String STAGE_01_APEX = "stage_01_apex";
    private static final String STAGE_01_COLLECTION = "stage_01_collection";

    //
    private static final String STAGE_01_CREATURE_01 = "stage_01_creature_01";
    private static final String STAGE_01_CREATURE_02 = "stage_01_creature_02";
    private static final String STAGE_01_CREATURE_03 = "stage_01_creature_03";
    private static final String STAGE_01_CREATURE_04 = "stage_01_creature_04";
    private static final String STAGE_01_CREATURE_05 = "stage_01_creature_05";
    private static final String STAGE_01_CREATURE_06 = "stage_01_creature_06";
    private static final String STAGE_01_CREATURE_07 = "stage_01_creature_07";
    private static final String STAGE_01_CREATURE_08 = "stage_01_creature_08";
    private static final String STAGE_01_CREATURE_09 = "stage_01_creature_09";
    private static final String STAGE_01_CREATURE_10 = "stage_01_creature_10";
    private static final String STAGE_01_CREATURE_11 = "stage_01_creature_11";
    private static final String STAGE_01_CREATURE_12 = "stage_01_creature_12";
    private static final String STAGE_01_CREATURE_13 = "stage_01_creature_13";
    private static final String STAGE_01_CREATURE_14 = "stage_01_creature_14";
    private static final String STAGE_01_CREATURE_15 = "stage_01_creature_15";
    private static final String STAGE_01_CREATURE_16 = "stage_01_creature_16";
    private static final String STAGE_01_CREATURE_17 = "stage_01_creature_17";
    private static final String STAGE_01_CREATURE_18 = "stage_01_creature_18";
    private static final String STAGE_01_CREATURE_19 = "stage_01_creature_19";
    private static final String STAGE_01_CREATURE_20 = "stage_01_creature_20";
    private static final String STAGE_01_CREATURE_21 = "stage_01_creature_21";
    private static final String STAGE_01_CREATURE_22 = "stage_01_creature_22";
    private static final String STAGE_01_CREATURE_23 = "stage_01_creature_23";
    private static final String STAGE_01_CREATURE_24 = "stage_01_creature_24";
    private static final String STAGE_01_CREATURE_25 = "stage_01_creature_25";
    private static final String STAGE_01_CREATURE_26 = "stage_01_creature_26";
    private static final String STAGE_01_CREATURE_27 = "stage_01_creature_27";
    private static final String STAGE_01_CREATURE_28 = "stage_01_creature_28";
    private static final String STAGE_01_CREATURE_29 = "stage_01_creature_29";
    private static final String STAGE_01_CREATURE_30 = "stage_01_creature_30";
    private static final String STAGE_01_CREATURE_31 = "stage_01_creature_31";
    private static final String STAGE_01_CREATURE_32 = "stage_01_creature_32";

    // Stage 2
    private static final String STAGE_02_COMPLETE = "stage_02_complete";
    private static final String STAGE_02_ATTEMPTS = "stage_02_attempts";
    private static final String STAGE_02_BOSS_KILLS = "stage_02_boss_kills";
    private static final String STAGE_02_CREATURE_KILLS = "stage_02_creature_kills";
    private static final String STAGE_02_HIGHEST_STREAK = "stage_02_highest_streak";
    private static final String STAGE_02_CLOSEST_DEATH = "stage_02_closest_death";
    private static final String STAGE_02_LONGEST_FRENZY = "stage_02_longest_frenzy";
    private static final String STAGE_02_MOST_CALM = "stage_02_most_calm";
    private static final String STAGE_02_MOST_FRANTIC = "stage_02_most_frantic";
    private static final String STAGE_02_TOTAL_TIME = "stage_02_total_time";
    private static final String STAGE_02_BEST_TIME = "stage_02_best_time";
    private static final String STAGE_02_PREDATOR = "stage_02_predator";
    private static final String STAGE_02_ACCURACY = "stage_02_accuracy";
    private static final String STAGE_02_APEX = "stage_02_apex";
    private static final String STAGE_02_COLLECTION = "stage_02_collection";

    //
    private static final String STAGE_02_CREATURE_01 = "stage_01_creature_01";
    private static final String STAGE_02_CREATURE_02 = "stage_01_creature_02";
    private static final String STAGE_02_CREATURE_03 = "stage_01_creature_03";
    private static final String STAGE_02_CREATURE_04 = "stage_01_creature_04";
    private static final String STAGE_02_CREATURE_05 = "stage_01_creature_05";
    private static final String STAGE_02_CREATURE_06 = "stage_01_creature_06";
    private static final String STAGE_02_CREATURE_07 = "stage_01_creature_07";
    private static final String STAGE_02_CREATURE_08 = "stage_01_creature_08";
    private static final String STAGE_02_CREATURE_09 = "stage_01_creature_09";
    private static final String STAGE_02_CREATURE_10 = "stage_01_creature_10";
    private static final String STAGE_02_CREATURE_11 = "stage_01_creature_11";
    private static final String STAGE_02_CREATURE_12 = "stage_01_creature_12";
    private static final String STAGE_02_CREATURE_13 = "stage_01_creature_13";
    private static final String STAGE_02_CREATURE_14 = "stage_01_creature_14";
    private static final String STAGE_02_CREATURE_15 = "stage_01_creature_15";
    private static final String STAGE_02_CREATURE_16 = "stage_01_creature_16";
    private static final String STAGE_02_CREATURE_17 = "stage_01_creature_17";
    private static final String STAGE_02_CREATURE_18 = "stage_01_creature_18";
    private static final String STAGE_02_CREATURE_19 = "stage_01_creature_19";
    private static final String STAGE_02_CREATURE_20 = "stage_01_creature_20";
    private static final String STAGE_02_CREATURE_21 = "stage_01_creature_21";
    private static final String STAGE_02_CREATURE_22 = "stage_01_creature_22";
    private static final String STAGE_02_CREATURE_23 = "stage_01_creature_23";
    private static final String STAGE_02_CREATURE_24 = "stage_01_creature_24";
    private static final String STAGE_02_CREATURE_25 = "stage_01_creature_25";
    private static final String STAGE_02_CREATURE_26 = "stage_01_creature_26";
    private static final String STAGE_02_CREATURE_27 = "stage_01_creature_27";
    private static final String STAGE_02_CREATURE_28 = "stage_01_creature_28";
    private static final String STAGE_02_CREATURE_29 = "stage_01_creature_29";
    private static final String STAGE_02_CREATURE_30 = "stage_01_creature_30";
    private static final String STAGE_02_CREATURE_31 = "stage_01_creature_31";
    private static final String STAGE_02_CREATURE_32 = "stage_01_creature_32";

    // Stage 3
    private static final String STAGE_03_COMPLETE = "stage_03_complete";
    private static final String STAGE_03_ATTEMPTS = "stage_03_attempts";
    private static final String STAGE_03_BOSS_KILLS = "stage_03_boss_kills";
    private static final String STAGE_03_CREATURE_KILLS = "stage_03_creature_kills";
    private static final String STAGE_03_HIGHEST_STREAK = "stage_03_highest_streak";
    private static final String STAGE_03_CLOSEST_DEATH = "stage_03_closest_death";
    private static final String STAGE_03_LONGEST_FRENZY = "stage_03_longest_frenzy";
    private static final String STAGE_03_MOST_CALM = "stage_03_most_calm";
    private static final String STAGE_03_MOST_FRANTIC = "stage_03_most_frantic";
    private static final String STAGE_03_TOTAL_TIME = "stage_03_total_time";
    private static final String STAGE_03_BEST_TIME = "stage_03_best_time";
    private static final String STAGE_03_PREDATOR = "stage_03_predator";
    private static final String STAGE_03_ACCURACY = "stage_03_accuracy";
    private static final String STAGE_03_APEX = "stage_03_apex";
    private static final String STAGE_03_COLLECTION = "stage_03_collection";

    //
    private static final String STAGE_03_CREATURE_01 = "stage_01_creature_01";
    private static final String STAGE_03_CREATURE_02 = "stage_01_creature_02";
    private static final String STAGE_03_CREATURE_03 = "stage_01_creature_03";
    private static final String STAGE_03_CREATURE_04 = "stage_01_creature_04";
    private static final String STAGE_03_CREATURE_05 = "stage_01_creature_05";
    private static final String STAGE_03_CREATURE_06 = "stage_01_creature_06";
    private static final String STAGE_03_CREATURE_07 = "stage_01_creature_07";
    private static final String STAGE_03_CREATURE_08 = "stage_01_creature_08";
    private static final String STAGE_03_CREATURE_09 = "stage_01_creature_09";
    private static final String STAGE_03_CREATURE_10 = "stage_01_creature_10";
    private static final String STAGE_03_CREATURE_11 = "stage_01_creature_11";
    private static final String STAGE_03_CREATURE_12 = "stage_01_creature_12";
    private static final String STAGE_03_CREATURE_13 = "stage_01_creature_13";
    private static final String STAGE_03_CREATURE_14 = "stage_01_creature_14";
    private static final String STAGE_03_CREATURE_15 = "stage_01_creature_15";
    private static final String STAGE_03_CREATURE_16 = "stage_01_creature_16";
    private static final String STAGE_03_CREATURE_17 = "stage_01_creature_17";
    private static final String STAGE_03_CREATURE_18 = "stage_01_creature_18";
    private static final String STAGE_03_CREATURE_19 = "stage_01_creature_19";
    private static final String STAGE_03_CREATURE_20 = "stage_01_creature_20";
    private static final String STAGE_03_CREATURE_21 = "stage_01_creature_21";
    private static final String STAGE_03_CREATURE_22 = "stage_01_creature_22";
    private static final String STAGE_03_CREATURE_23 = "stage_01_creature_23";
    private static final String STAGE_03_CREATURE_24 = "stage_01_creature_24";
    private static final String STAGE_03_CREATURE_25 = "stage_01_creature_25";
    private static final String STAGE_03_CREATURE_26 = "stage_01_creature_26";
    private static final String STAGE_03_CREATURE_27 = "stage_01_creature_27";
    private static final String STAGE_03_CREATURE_28 = "stage_01_creature_28";
    private static final String STAGE_03_CREATURE_29 = "stage_01_creature_29";
    private static final String STAGE_03_CREATURE_30 = "stage_01_creature_30";
    private static final String STAGE_03_CREATURE_31 = "stage_01_creature_31";
    private static final String STAGE_03_CREATURE_32 = "stage_01_creature_32";

    // Stage 4
    private static final String STAGE_04_COMPLETE = "stage_04_complete";
    private static final String STAGE_04_ATTEMPTS = "stage_04_attempts";
    private static final String STAGE_04_BOSS_KILLS = "stage_04_boss_kills";
    private static final String STAGE_04_CREATURE_KILLS = "stage_04_creature_kills";
    private static final String STAGE_04_HIGHEST_STREAK = "stage_04_highest_streak";
    private static final String STAGE_04_CLOSEST_DEATH = "stage_04_closest_death";
    private static final String STAGE_04_LONGEST_FRENZY = "stage_04_longest_frenzy";
    private static final String STAGE_04_MOST_CALM = "stage_04_most_calm";
    private static final String STAGE_04_MOST_FRANTIC = "stage_04_most_frantic";
    private static final String STAGE_04_TOTAL_TIME = "stage_04_total_time";
    private static final String STAGE_04_BEST_TIME = "stage_04_best_time";
    private static final String STAGE_04_PREDATOR = "stage_04_predator";
    private static final String STAGE_04_ACCURACY = "stage_04_accuracy";
    private static final String STAGE_04_APEX = "stage_04_apex";
    private static final String STAGE_04_COLLECTION = "stage_04_collection";

    //
    private static final String STAGE_04_CREATURE_01 = "stage_01_creature_01";
    private static final String STAGE_04_CREATURE_02 = "stage_01_creature_02";
    private static final String STAGE_04_CREATURE_03 = "stage_01_creature_03";
    private static final String STAGE_04_CREATURE_04 = "stage_01_creature_04";
    private static final String STAGE_04_CREATURE_05 = "stage_01_creature_05";
    private static final String STAGE_04_CREATURE_06 = "stage_01_creature_06";
    private static final String STAGE_04_CREATURE_07 = "stage_01_creature_07";
    private static final String STAGE_04_CREATURE_08 = "stage_01_creature_08";
    private static final String STAGE_04_CREATURE_09 = "stage_01_creature_09";
    private static final String STAGE_04_CREATURE_10 = "stage_01_creature_10";
    private static final String STAGE_04_CREATURE_11 = "stage_01_creature_11";
    private static final String STAGE_04_CREATURE_12 = "stage_01_creature_12";
    private static final String STAGE_04_CREATURE_13 = "stage_01_creature_13";
    private static final String STAGE_04_CREATURE_14 = "stage_01_creature_14";
    private static final String STAGE_04_CREATURE_15 = "stage_01_creature_15";
    private static final String STAGE_04_CREATURE_16 = "stage_01_creature_16";
    private static final String STAGE_04_CREATURE_17 = "stage_01_creature_17";
    private static final String STAGE_04_CREATURE_18 = "stage_01_creature_18";
    private static final String STAGE_04_CREATURE_19 = "stage_01_creature_19";
    private static final String STAGE_04_CREATURE_20 = "stage_01_creature_20";
    private static final String STAGE_04_CREATURE_21 = "stage_01_creature_21";
    private static final String STAGE_04_CREATURE_22 = "stage_01_creature_22";
    private static final String STAGE_04_CREATURE_23 = "stage_01_creature_23";
    private static final String STAGE_04_CREATURE_24 = "stage_01_creature_24";
    private static final String STAGE_04_CREATURE_25 = "stage_01_creature_25";
    private static final String STAGE_04_CREATURE_26 = "stage_01_creature_26";
    private static final String STAGE_04_CREATURE_27 = "stage_01_creature_27";
    private static final String STAGE_04_CREATURE_28 = "stage_01_creature_28";
    private static final String STAGE_04_CREATURE_29 = "stage_01_creature_29";
    private static final String STAGE_04_CREATURE_30 = "stage_01_creature_30";
    private static final String STAGE_04_CREATURE_31 = "stage_01_creature_31";
    private static final String STAGE_04_CREATURE_32 = "stage_01_creature_32";

    // Stage 5
    private static final String STAGE_05_COMPLETE = "stage_05_complete";
    private static final String STAGE_05_ATTEMPTS = "stage_05_attempts";
    private static final String STAGE_05_BOSS_KILLS = "stage_05_boss_kills";
    private static final String STAGE_05_CREATURE_KILLS = "stage_05_creature_kills";
    private static final String STAGE_05_HIGHEST_STREAK = "stage_05_highest_streak";
    private static final String STAGE_05_CLOSEST_DEATH = "stage_05_closest_death";
    private static final String STAGE_05_LONGEST_FRENZY = "stage_05_longest_frenzy";
    private static final String STAGE_05_MOST_CALM = "stage_05_most_calm";
    private static final String STAGE_05_MOST_FRANTIC = "stage_05_most_frantic";
    private static final String STAGE_05_TOTAL_TIME = "stage_05_total_time";
    private static final String STAGE_05_BEST_TIME = "stage_05_best_time";
    private static final String STAGE_05_PREDATOR = "stage_05_predator";
    private static final String STAGE_05_ACCURACY = "stage_05_accuracy";
    private static final String STAGE_05_APEX = "stage_05_apex";
    private static final String STAGE_05_COLLECTION = "stage_05_collection";

    //
    private static final String STAGE_05_CREATURE_01 = "stage_01_creature_01";
    private static final String STAGE_05_CREATURE_02 = "stage_01_creature_02";
    private static final String STAGE_05_CREATURE_03 = "stage_01_creature_03";
    private static final String STAGE_05_CREATURE_04 = "stage_01_creature_04";
    private static final String STAGE_05_CREATURE_05 = "stage_01_creature_05";
    private static final String STAGE_05_CREATURE_06 = "stage_01_creature_06";
    private static final String STAGE_05_CREATURE_07 = "stage_01_creature_07";
    private static final String STAGE_05_CREATURE_08 = "stage_01_creature_08";
    private static final String STAGE_05_CREATURE_09 = "stage_01_creature_09";
    private static final String STAGE_05_CREATURE_10 = "stage_01_creature_10";
    private static final String STAGE_05_CREATURE_11 = "stage_01_creature_11";
    private static final String STAGE_05_CREATURE_12 = "stage_01_creature_12";
    private static final String STAGE_05_CREATURE_13 = "stage_01_creature_13";
    private static final String STAGE_05_CREATURE_14 = "stage_01_creature_14";
    private static final String STAGE_05_CREATURE_15 = "stage_01_creature_15";
    private static final String STAGE_05_CREATURE_16 = "stage_01_creature_16";
    private static final String STAGE_05_CREATURE_17 = "stage_01_creature_17";
    private static final String STAGE_05_CREATURE_18 = "stage_01_creature_18";
    private static final String STAGE_05_CREATURE_19 = "stage_01_creature_19";
    private static final String STAGE_05_CREATURE_20 = "stage_01_creature_20";
    private static final String STAGE_05_CREATURE_21 = "stage_01_creature_21";
    private static final String STAGE_05_CREATURE_22 = "stage_01_creature_22";
    private static final String STAGE_05_CREATURE_23 = "stage_01_creature_23";
    private static final String STAGE_05_CREATURE_24 = "stage_01_creature_24";
    private static final String STAGE_05_CREATURE_25 = "stage_01_creature_25";
    private static final String STAGE_05_CREATURE_26 = "stage_01_creature_26";
    private static final String STAGE_05_CREATURE_27 = "stage_01_creature_27";
    private static final String STAGE_05_CREATURE_28 = "stage_01_creature_28";
    private static final String STAGE_05_CREATURE_29 = "stage_01_creature_29";
    private static final String STAGE_05_CREATURE_30 = "stage_01_creature_30";
    private static final String STAGE_05_CREATURE_31 = "stage_01_creature_31";
    private static final String STAGE_05_CREATURE_32 = "stage_01_creature_32";

    // Stage 6
    private static final String STAGE_06_COMPLETE = "stage_06_complete";
    private static final String STAGE_06_ATTEMPTS = "stage_06_attempts";
    private static final String STAGE_06_BOSS_KILLS = "stage_06_boss_kills";
    private static final String STAGE_06_CREATURE_KILLS = "stage_06_creature_kills";
    private static final String STAGE_06_HIGHEST_STREAK = "stage_06_highest_streak";
    private static final String STAGE_06_CLOSEST_DEATH = "stage_06_closest_death";
    private static final String STAGE_06_LONGEST_FRENZY = "stage_06_longest_frenzy";
    private static final String STAGE_06_MOST_CALM = "stage_06_most_calm";
    private static final String STAGE_06_MOST_FRANTIC = "stage_06_most_frantic";
    private static final String STAGE_06_TOTAL_TIME = "stage_06_total_time";
    private static final String STAGE_06_BEST_TIME = "stage_06_best_time";
    private static final String STAGE_06_PREDATOR = "stage_06_predator";
    private static final String STAGE_06_ACCURACY = "stage_06_accuracy";
    private static final String STAGE_06_APEX = "stage_06_apex";
    private static final String STAGE_06_COLLECTION = "stage_06_collection";

    //
    private static final String STAGE_06_CREATURE_01 = "stage_01_creature_01";
    private static final String STAGE_06_CREATURE_02 = "stage_01_creature_02";
    private static final String STAGE_06_CREATURE_03 = "stage_01_creature_03";
    private static final String STAGE_06_CREATURE_04 = "stage_01_creature_04";
    private static final String STAGE_06_CREATURE_05 = "stage_01_creature_05";
    private static final String STAGE_06_CREATURE_06 = "stage_01_creature_06";
    private static final String STAGE_06_CREATURE_07 = "stage_01_creature_07";
    private static final String STAGE_06_CREATURE_08 = "stage_01_creature_08";
    private static final String STAGE_06_CREATURE_09 = "stage_01_creature_09";
    private static final String STAGE_06_CREATURE_10 = "stage_01_creature_10";
    private static final String STAGE_06_CREATURE_11 = "stage_01_creature_11";
    private static final String STAGE_06_CREATURE_12 = "stage_01_creature_12";
    private static final String STAGE_06_CREATURE_13 = "stage_01_creature_13";
    private static final String STAGE_06_CREATURE_14 = "stage_01_creature_14";
    private static final String STAGE_06_CREATURE_15 = "stage_01_creature_15";
    private static final String STAGE_06_CREATURE_16 = "stage_01_creature_16";
    private static final String STAGE_06_CREATURE_17 = "stage_01_creature_17";
    private static final String STAGE_06_CREATURE_18 = "stage_01_creature_18";
    private static final String STAGE_06_CREATURE_19 = "stage_01_creature_19";
    private static final String STAGE_06_CREATURE_20 = "stage_01_creature_20";
    private static final String STAGE_06_CREATURE_21 = "stage_01_creature_21";
    private static final String STAGE_06_CREATURE_22 = "stage_01_creature_22";
    private static final String STAGE_06_CREATURE_23 = "stage_01_creature_23";
    private static final String STAGE_06_CREATURE_24 = "stage_01_creature_24";
    private static final String STAGE_06_CREATURE_25 = "stage_01_creature_25";
    private static final String STAGE_06_CREATURE_26 = "stage_01_creature_26";
    private static final String STAGE_06_CREATURE_27 = "stage_01_creature_27";
    private static final String STAGE_06_CREATURE_28 = "stage_01_creature_28";
    private static final String STAGE_06_CREATURE_29 = "stage_01_creature_29";
    private static final String STAGE_06_CREATURE_30 = "stage_01_creature_30";
    private static final String STAGE_06_CREATURE_31 = "stage_01_creature_31";
    private static final String STAGE_06_CREATURE_32 = "stage_01_creature_32";

    // Stage 7
    private static final String STAGE_07_COMPLETE = "stage_07_complete";
    private static final String STAGE_07_ATTEMPTS = "stage_07_attempts";
    private static final String STAGE_07_BOSS_KILLS = "stage_07_boss_kills";
    private static final String STAGE_07_CREATURE_KILLS = "stage_07_creature_kills";
    private static final String STAGE_07_HIGHEST_STREAK = "stage_07_highest_streak";
    private static final String STAGE_07_CLOSEST_DEATH = "stage_07_closest_death";
    private static final String STAGE_07_LONGEST_FRENZY = "stage_07_longest_frenzy";
    private static final String STAGE_07_MOST_CALM = "stage_07_most_calm";
    private static final String STAGE_07_MOST_FRANTIC = "stage_07_most_frantic";
    private static final String STAGE_07_TOTAL_TIME = "stage_07_total_time";
    private static final String STAGE_07_BEST_TIME = "stage_07_best_time";
    private static final String STAGE_07_PREDATOR = "stage_07_predator";
    private static final String STAGE_07_ACCURACY = "stage_07_accuracy";
    private static final String STAGE_07_APEX = "stage_07_apex";
    private static final String STAGE_07_COLLECTION = "stage_07_collection";

    //
    private static final String STAGE_07_CREATURE_01 = "stage_01_creature_01";
    private static final String STAGE_07_CREATURE_02 = "stage_01_creature_02";
    private static final String STAGE_07_CREATURE_03 = "stage_01_creature_03";
    private static final String STAGE_07_CREATURE_04 = "stage_01_creature_04";
    private static final String STAGE_07_CREATURE_05 = "stage_01_creature_05";
    private static final String STAGE_07_CREATURE_06 = "stage_01_creature_06";
    private static final String STAGE_07_CREATURE_07 = "stage_01_creature_07";
    private static final String STAGE_07_CREATURE_08 = "stage_01_creature_08";
    private static final String STAGE_07_CREATURE_09 = "stage_01_creature_09";
    private static final String STAGE_07_CREATURE_10 = "stage_01_creature_10";
    private static final String STAGE_07_CREATURE_11 = "stage_01_creature_11";
    private static final String STAGE_07_CREATURE_12 = "stage_01_creature_12";
    private static final String STAGE_07_CREATURE_13 = "stage_01_creature_13";
    private static final String STAGE_07_CREATURE_14 = "stage_01_creature_14";
    private static final String STAGE_07_CREATURE_15 = "stage_01_creature_15";
    private static final String STAGE_07_CREATURE_16 = "stage_01_creature_16";
    private static final String STAGE_07_CREATURE_17 = "stage_01_creature_17";
    private static final String STAGE_07_CREATURE_18 = "stage_01_creature_18";
    private static final String STAGE_07_CREATURE_19 = "stage_01_creature_19";
    private static final String STAGE_07_CREATURE_20 = "stage_01_creature_20";
    private static final String STAGE_07_CREATURE_21 = "stage_01_creature_21";
    private static final String STAGE_07_CREATURE_22 = "stage_01_creature_22";
    private static final String STAGE_07_CREATURE_23 = "stage_01_creature_23";
    private static final String STAGE_07_CREATURE_24 = "stage_01_creature_24";
    private static final String STAGE_07_CREATURE_25 = "stage_01_creature_25";
    private static final String STAGE_07_CREATURE_26 = "stage_01_creature_26";
    private static final String STAGE_07_CREATURE_27 = "stage_01_creature_27";
    private static final String STAGE_07_CREATURE_28 = "stage_01_creature_28";
    private static final String STAGE_07_CREATURE_29 = "stage_01_creature_29";
    private static final String STAGE_07_CREATURE_30 = "stage_01_creature_30";
    private static final String STAGE_07_CREATURE_31 = "stage_01_creature_31";
    private static final String STAGE_07_CREATURE_32 = "stage_01_creature_32";

//-- GLOBAL DYNAMIC VIEWS -->

//-- INTRO -->
    // Intro / Outro views
    private ImageView mCreditsImageView; // logos, etc.

//-- ENTRY -->
    // Entry views
    private LinearLayout mEntryScoreApexLayout;
    private LinearLayout mEntryMainControlLayout;
    private ImageButton mEntryContinueImageButton;
    private ImageButton mEntryCreditsImageButton;

//-- STAGE SELECT -->
    // Stage select toggle views
    private ImageButton mStageSelectScorecardImageButton;
    private LinearLayout mStageSelectScorecardLayout;
    private LinearLayout mStageSelectStagecardLayout;

    // Stage select top scores
    private ImageView mEOBEApexScoreImageView;
    private TextView mEOBEPredatorScoreTextView;
    private TextView mEOBEAccuracyScoreTextView;
    private TextView mEOBETimeBestScoreTextView;
    private TextView mEOBETimeTotalScoreTextView;
    private TextView mEOBECollectionScoreTextView;
    private TextView mEOBEAttemptsScoreTextView;
    private TextView mEOBEBossKillsScoreTextView;
    private TextView mEOBECreatureKillsScoreTextView;
    private TextView mEOBEHighestStreakScoreTextView;
    private TextView mEOBEClosestDeathScoreTextView;
    private TextView mEOBELongestFrenzyScoreTextView;
    private TextView mEOBEMostCalmScoreTextView;
    private TextView mEOBEMostFranticTextView;

    // Stage card layouts
    //private LinearLayout mStage01CardLayout;
    //private LinearLayout mStage02CardLayout;
    //private LinearLayout mStage03CardLayout;
    //private LinearLayout mStage04CardLayout;
    //private LinearLayout mStage05CardLayout;
    //private LinearLayout mStage06CardLayout;
    //private LinearLayout mStage07CardLayout;

    // Stage card titles
    //private ImageView mStage01TitleImageView;
    //private ImageView mStage02TitleImageView;
    //private ImageView mStage03TitleImageView;
    //private ImageView mStage04TitleImageView;
    //private ImageView mStage05TitleImageView;
    //private ImageView mStage06TitleImageView;
    //private ImageView mStage07TitleImageView;

    // Stage card status
    //private ImageView mStage01StatusImageView;
    //private ImageView mStage02StatusImageView;
    //private ImageView mStage03StatusImageView;
    //private ImageView mStage04StatusImageView;
    //private ImageView mStage05StatusImageView;
    //private ImageView mStage06StatusImageView;
    //private ImageView mStage07StatusImageView;

    // Stage card icons
    //private ImageButton mStage01StatusImageButton;
    //private ImageButton mStage02StatusImageButton;
    //private ImageButton mStage03StatusImageButton;
    //private ImageButton mStage04StatusImageButton;
    //private ImageButton mStage05StatusImageButton;
    //private ImageButton mStage06StatusImageButton;
    //private ImageButton mStage07StatusImageButton;

//-- STAGE CARD -->
    // Stage card titles / icons
    private ImageView mStageCardStatusImageView; // To change (ready / complete / locked)
    private ImageButton mStageCardTopScoreImageButton; // To flip visibility

    //
    private LinearLayout mStageCardScreenBodyLayout; // To change stage background

    //
    private LinearLayout mStageCardContentTitleLayout; // To change background color
    private ImageButton mStageCardContentTitleImageButton; // To change stage name

    //
    private LinearLayout mStageCardContentBossLayout; // To change disaster image
    private ImageView mStageCardBossImageView; // To change boss image

    //
    private LinearLayout mStageCardScorecardLayout; // To flip visibility / stage complete

    //
    private LinearLayout mStageCardTopScoreLayout; // Toggle visibility

    // StageCard ready views - Stage ready (play again) [high scores]
    private TextView mStageTotalAttemptsTextView;
    private TextView mStageTotalBossKillsTextView;
    private TextView mStageTotalCreatureKillsTextView;
    private TextView mStageTopHighestStreakTextView;
    private TextView mStageTopClosestDeathTextView;
    private TextView mStageTopLongestFrenzyTextView;
    private TextView mStageTopMostCalmTextView;
    private TextView mStageTopMostFranticTextView;
    private TextView mStageTotalTimeTextView;
    private TextView mStageTopBestTimeTextView;
    private TextView mStageTopPredatorTextView;
    private TextView mStageTopAccuracyTextView;
    private TextView mStageTopApexPredatorTextView;
    private TextView mStageTotalCollectionTextView;

    // StageCard complete views - Stage complete [stage scores]
    private TextView mStageApexPredatorTextView;
    private TextView mStagePredatorTextView;
    private TextView mStageAccuracyTextView;
    private TextView mStageTimeTextView;
    private TextView mStageCreatureKillsTextView;
    private TextView mStageCollectionTextView;
    private TextView mStageHighestStreakTextView;
    private TextView mStageClosestDeathTextView;
    private TextView mStageLongestFrenzyTextView;
    private TextView mStageMostCalmTextView;
    private TextView mStageMostFranticTextView;

    // StageCard creature collection - Stage top scores
    private ImageView mCreature01ImageView;
    private ImageView mCreature02ImageView;
    private ImageView mCreature03ImageView;
    private ImageView mCreature04ImageView;
    private ImageView mCreature05ImageView;
    private ImageView mCreature06ImageView;
    private ImageView mCreature07ImageView;
    private ImageView mCreature08ImageView;
    private ImageView mCreature09ImageView;
    private ImageView mCreature10ImageView;
    private ImageView mCreature11ImageView;
    private ImageView mCreature12ImageView;
    private ImageView mCreature13ImageView;
    private ImageView mCreature14ImageView;
    private ImageView mCreature15ImageView;
    private ImageView mCreature16ImageView;
    private ImageView mCreature17ImageView;
    private ImageView mCreature18ImageView;
    private ImageView mCreature19ImageView;
    private ImageView mCreature20ImageView;
    private ImageView mCreature21ImageView;
    private ImageView mCreature22ImageView;
    private ImageView mCreature23ImageView;
    private ImageView mCreature24ImageView;
    private ImageView mCreature25ImageView;
    private ImageView mCreature26ImageView;
    private ImageView mCreature27ImageView;
    private ImageView mCreature28ImageView;
    private ImageView mCreature29ImageView;
    private ImageView mCreature30ImageView;
    private ImageView mCreature31ImageView;
    private ImageView mCreature32ImageView;

    // StageCard switch card controls
    private ImageButton mStageCardControlPrevImageButton;
    private ImageButton mStageCardControlNextImageButton;
    private ImageButton mStageCardControlPlayImageButton;

//-- GAME -->
    // Game titles
    private LinearLayout mGameControlLayout;

    private ImageView mGameStageImageView;
    private ImageView mGameSceneImageView;
    private TextView mGameSceneTextView;

    // Game user interfaces
    private LinearLayout mGameLevelMarkerLayout;
    private LinearLayout mGamePowersLayout;

    // Game progress markers
    private ImageView mGameLevelMarkerImageView;

    // Game power icons
    private ImageView mGamePower01ImageView;
    private ImageView mGamePower02ImageView;
    private ImageView mGamePower03ImageView;
    private ImageView mGamePower04ImageView;
    private ImageView mGamePower05ImageView;
    private ImageView mGamePower06ImageView;

    // Game stage advances
    private ImageButton mGameScenePrevImageButton;
    private ImageButton mGameSceneNextImageButton;
    private ImageView mStageDisasterImageView;

    // Game creatures
    private ImageButton mGameCreature01ImageButton;
    private ImageButton mGameCreature02ImageButton;
    private ImageButton mGameCreature03ImageButton;
    private ImageButton mGameCreature04ImageButton;
    private ImageButton mGameCreature05ImageButton;

    // Game boss
    private ImageButton mGameBossImageButton;

    // Game creature playground
    private FrameLayout mGameCreatureLayout;

    // Game boss playground
    private FrameLayout mGameBossLayout;

    // Game stage border
    private RelativeLayout mGameBorderLayout;

    // Game stage tunnel
    private RelativeLayout mGameTunnelVisionLayout;

//-- EATEN -->
    //
    private ImageView mEatenMainTitleImageView;
    private LinearLayout mEatenSubTitleLayout;

    //
    private TextView mEatenStageNameTextView;
    private TextView mEatenStageTimeTextView;

//-- LOCAL DATA STORE  -->
    // Variables to store saved game data
    private static boolean continue_game;

    // Settings toggle for audio and haptic feedback
    private static boolean play_audio;
    private static boolean play_haptic;
    private static boolean play_tutorial;

//-- SUPPLEMENTARY DATA STORE - KILL BOSS -->
    //
    private static boolean stage_01_complete; // -> if (stage_01_complete) {boolean stage_02_unlocked = true;}

    // Top scores - stage 1
    private static int stage_01_attempts;
    private static int stage_01_boss_kills;
    private static int stage_01_creature_kills;
    private static int stage_01_highest_streak;
    private static int stage_01_closest_death;
    private static int stage_01_longest_frenzy;
    private static long stage_01_most_calm;
    private static long stage_01_most_frantic;
    private static int stage_01_total_time;
    private static int stage_01_best_time;
    private static int stage_01_predator;
    private static float stage_01_accuracy;
    private static boolean stage_01_apex;
    private static int stage_01_collection;
    private static int[] stage_01_trophy_case;

    private static boolean stage_02_complete; // -> if (stage_02_complete) {boolean stage_03_unlocked = true;}

    // Top scores - stage 2
    private static int stage_02_attempts;
    private static int stage_02_boss_kills;
    private static int stage_02_creature_kills;
    private static int stage_02_highest_streak;
    private static int stage_02_closest_death;
    private static int stage_02_longest_frenzy;
    private static long stage_02_most_calm;
    private static long stage_02_most_frantic;
    private static int stage_02_total_time;
    private static int stage_02_best_time;
    private static int stage_02_predator;
    private static float stage_02_accuracy;
    private static boolean stage_02_apex;
    private static int stage_02_collection;

    private static boolean stage_03_complete; // -> if (stage_03_complete) {boolean stage_04_unlocked = true;}

    // Top scores - stage 3
    private static int stage_03_attempts;
    private static int stage_03_boss_kills;
    private static int stage_03_creature_kills;
    private static int stage_03_highest_streak;
    private static int stage_03_closest_death;
    private static int stage_03_longest_frenzy;
    private static long stage_03_most_calm;
    private static long stage_03_most_frantic;
    private static int stage_03_total_time;
    private static int stage_03_best_time;
    private static int stage_03_predator;
    private static float stage_03_accuracy;
    private static boolean stage_03_apex;
    private static int stage_03_collection;

    private static boolean stage_04_complete; // -> if (stage_04_complete) {boolean stage_05_unlocked = true;}

    // Top scores - stage 4
    private static int stage_04_attempts;
    private static int stage_04_boss_kills;
    private static int stage_04_creature_kills;
    private static int stage_04_highest_streak;
    private static int stage_04_closest_death;
    private static int stage_04_longest_frenzy;
    private static long stage_04_most_calm;
    private static long stage_04_most_frantic;
    private static int stage_04_total_time;
    private static int stage_04_best_time;
    private static int stage_04_predator;
    private static float stage_04_accuracy;
    private static boolean stage_04_apex;
    private static int stage_04_collection;

    private static boolean stage_05_complete; // -> if (stage_05_complete) {boolean stage_06_unlocked = true;}

    // Top scores - stage 5
    private static int stage_05_attempts;
    private static int stage_05_boss_kills;
    private static int stage_05_creature_kills;
    private static int stage_05_highest_streak;
    private static int stage_05_closest_death;
    private static int stage_05_longest_frenzy;
    private static long stage_05_most_calm;
    private static long stage_05_most_frantic;
    private static int stage_05_total_time;
    private static int stage_05_best_time;
    private static int stage_05_predator;
    private static float stage_05_accuracy;
    private static boolean stage_05_apex;
    private static int stage_05_collection;

    private static boolean stage_06_complete; // -> if (stage_06_complete) {boolean stage_final_boss_unlocked = true;}

    // Top scores - stage 6
    private static int stage_06_attempts;
    private static int stage_06_boss_kills;
    private static int stage_06_creature_kills;
    private static int stage_06_highest_streak;
    private static int stage_06_closest_death;
    private static int stage_06_longest_frenzy;
    private static long stage_06_most_calm;
    private static long stage_06_most_frantic;
    private static int stage_06_total_time;
    private static int stage_06_best_time;
    private static int stage_06_predator;
    private static float stage_06_accuracy;
    private static boolean stage_06_apex;
    private static int stage_06_collection;

    private static boolean stage_07_complete; // -> if (stage_final_boss_complete) {boolean game_complete = true;}

    // Top scores - stage 7
    private static int stage_07_attempts;
    private static int stage_07_boss_kills;
    private static int stage_07_creature_kills;
    private static int stage_07_highest_streak;
    private static int stage_07_closest_death;
    private static int stage_07_longest_frenzy;
    private static long stage_07_most_calm;
    private static long stage_07_most_frantic;
    private static int stage_07_total_time;
    private static int stage_07_best_time;
    private static int stage_07_predator;
    private static float stage_07_accuracy;
    private static boolean stage_07_apex;
    private static int stage_07_collection;

    // Game complete
    private static boolean game_complete; // -> see above

// GAME VARIABLES
    // Variable to stop timers
    private static boolean mPauseGame;
    private static boolean mCreatureGameOver;
    private static boolean mBossGameOver;

    // Null screen state
    private static int mCurScreen = -1;
    private static int mStageIndex = -1;
    private static boolean mTopScores = false;

    // Stage ready [1 = Locked, 2 = Ready, 3 = Complete]
    private static int mStageReady = 1;
    private static boolean mStageComplete = false;

    //
    private static int mStageFrenzy;

    // Variables for tap meter
    private static int mTapBarrel;
    private static int mTapCount;
    private static int mTapTotal;

    // Border timer
    private static int mBorderBarrel;

    // Timers
    private static int mPauseTimer;
    private static int mStageTimer;

    // Universal variables
    private static long mSpeedIndex;
    private static int mHungerMeter = 0;
    //private static int mStageAdvanceMeter;
    //private static int mStageAdvanceTarget;

    // Power variables
    private static int mPower01Meter;
    private static int mPower01Target;
    private static int mPower02Meter;
    private static int mPower02Target;
    private static int mPower03Meter;
    private static int mPower03Target;
    private static int mPower04Meter;
    private static int mPower04Target;
    private static int mPower05Meter;
    private static int mPower05Target;
    private static int mPower06Meter;
    private static int mPower06Target;

    // Stage scores - calculate at end stage
    private static int mStagePredator;
    private static float mStageAccuracy;
    private static int mStageTime;
    private static int mStageCreatureKills;
    private static int mStageCollection;
    private static int mStageHighestStreak;
    private static int mStageClosestDeath;
    private static int mStageLongestFrenzy;
    private static long mStageMostCalm;
    private static long mStageMostFrantic;
    private static boolean mStageApex = false;

    // Global scores - calculate at screen load
    private static int mGameAttempts;
    private static int mGameBossKills;
    private static int mGameCreatureKills;
    private static int mGameHighestStreak;
    private static int mGameClosestDeath;
    private static int mGameLongestFrenzy;
    private static long mGameMostCalm;
    private static long mGameMostFrantic;
    private static int mGameTimeBest;
    private static int mGameTimeTotal;
    private static int mGamePredator;
    private static float mGameAccuracy;
    private static boolean mGameApex;
    private static int mGameCollection;

    //
    private static int mTurn;

    //
    private static int mBossHealth;

    //
    private static List<Integer> mStageSceneImages = new ArrayList<>();
    private static List<String> mStageSceneNames = new ArrayList<>();
    private static int mEnvironmentID;

    //
    private static List<Integer> mStageCreatureBox = new ArrayList<>();
    private static int mStageCreatureID;
    private static int mStageCreature01ID;
    private static int mStageCreature02ID;
    private static int mStageCreature03ID;
    private static int mStageCreature04ID;
    private static int mStageCreature05ID;
    private static int mCreatureID;

    //
    private static List<Integer> mGameCreditsImages = new ArrayList<>();
    private static int mCreditSpinner;

    //
    private static int mGameTapAudio;

    //
    private static int mGameBossCry;

    // Audio definitions
    private static final int CHOMP = R.raw.chomp_audio_01;
    private static final int HEARTBEAT = R.raw.game_main_heartbeat_audio;
    private static final int HIT = R.raw.bite_audio_01;
    private static final int MISS = R.raw.miss_audio_01;
    private static final int ROAR = R.raw.game_main_roar_audio;
    private static final int RUN = R.raw.game_main_running_audio;
    private static final int DARK_INTRO = R.raw.entry_main_horn_intro_audio;
    private static final int DARK_OUTRO = R.raw.results_main_bg_audio;
    private static final int BG_AUDIO = R.raw.game_main_bg_audio_alt_01;
    private static final int CROW_AUDIO = R.raw.crow_caw;
    private static final int THUNDER_AUDIO = R.raw.game_main_thunder_audio;
    private static final int SPLASH_AUDIO = R.raw.splash_audio;
    private static final int EARTHQUAKE_AUDIO = R.raw.earthquake;
    private static final int TORNADO_AUDIO = R.raw.tornado;
    private static final int VOLCANO_AUDIO = R.raw.volcano;
    private static final int AVALANCHE_AUDIO = R.raw.avalanche;
    private static final int INTRO_01 = R.raw.intro_audio;
    private static final int WOLF_CRY = R.raw.wolf_cry;
    private static final int SHARK_CRY = R.raw.shark_cry;
    private static final int HAWK_CRY = R.raw.hawk_cry;
    private static final int SCORPION_CRY = R.raw.scorpion_cry;
    private static final int SNAKE_CRY = R.raw.snake_cry;
    private static final int YETI_CRY = R.raw.yeti_cry;
    private static final int BREATH = R.raw.power_02_audio;
    private static final int FRENZY = R.raw.power_05_audio;
    private static final int FREEZE = R.raw.power_06_audio;
    private static final int FLASH_BANG = R.raw.flash_bang;
    private static final int BAMBOO_CLICK = R.raw.bamboo_click_audio;
    private static final int FLUTE_TRILL_LONG = R.raw.flute_trill_long_audio;
    //private static final int FLUTE_TRILL_SHORT = R.raw.pan_flute_short_audio;
    private static final int GROWL_ALERT = R.raw.game_main_growl_alert_audio;
    private static final int REVERSE_PING = R.raw.reverse_ding_10;

    // Run timer through executable task
    final Handler h1 = new Handler();
    final Handler h2 = new Handler();
    final Handler h3 = new Handler();
    final Handler h4 = new Handler();

    // Intro credits runnable
    final Runnable r1 = new Runnable() {

            // Run task
            @Override
            public void run() {
                Log.d(TAG, "run: R1");

                // Check pause game
                if (!mPauseGame) {

                    // Check incremental - 2 intro slides
                    if (mCreditSpinner < mGameCreditsImages.size()) {

                        // Increment intro images
                        mCreditsImageView.setBackground(versionCheck(mGameCreditsImages.get(mCreditSpinner)));

                        //
                        fadeTitles(mCreditsImageView.getId());

                        //
                        h1.postDelayed(this, 5000);

                        //
                        ++mCreditSpinner;

                        //
                        playAudio(INTRO_01);

                    } else {

                        //
                        mCreditSpinner = 0;

                        // Switch the entry
                        switchScreen(R.id.entry_screen_main_layout);

                        // Play audio
                        playAudio(DARK_INTRO);
                    }
                }
            }
    };

    // Game on runnable
    final Runnable r2 = new Runnable() {

        // Run task
        @Override
        public void run() {
            Log.d(TAG, "run: R2");

            // If game is NOT paused, or if it IS paused with countdown
            if (!mPauseGame) {
                Log.d(TAG, "run: not paused");

                // Increment game
                Log.d(TAG, "run: Game On");
                gameOn();

            } else {

                // Decrement / disable pause timer
                if (mPauseTimer > 0) {
                    Log.d(TAG, "run: paused with countdown " + mPauseTimer);

                    //
                    --mPauseTimer;

                } else if (mPauseTimer != -1) {
                    Log.d(TAG, "run: pause countdown finish");

                    //
                    mPauseGame = false;
                    mPauseTimer = -1;
                }
            }

            // Check creature game not expired
            if (!mCreatureGameOver) {
                Log.d(TAG, "run: not creature game over");

                // Increment timer
                h2.postDelayed(this, mSpeedIndex);

            } else {
                Log.d(TAG, "run: creature game over");

                // End game - change from playerEaten to stageEnd
                creatureStageEnd();
            }
        }
    };

    // Boss runnable
    final Runnable r3 = new Runnable() {

        // Run task
        @Override
        public void run() {
            Log.d(TAG, "run: R3");

            // Check game paused
            if (!mPauseGame) {

                // Check boss game not expired
                if (!mBossGameOver) {

                    //
                    if (mHungerMeter > 0) {

                        //
                        playAudio(mGameBossCry);

                        // Increment timer
                        h3.postDelayed(this, 1000);
                        --mHungerMeter;

                    } else {

                        //
                        bossStageEnd();
                    }

                } else {

                    //
                    bossStageEnd();
                }
            }
        }
    };

    // Control runnable
    final Runnable r4 = new Runnable() {

        // Run task
        @Override
        public void run() {
            Log.d(TAG, "run: R4");

            //
            if (!mBossGameOver && !mCreatureGameOver) {

                //
                h4.postDelayed(this, 1000);

                //
                ++mStageTimer;
            }
        }
    };

    // OnCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Call super
        super.onCreate(savedInstanceState);

        // Set layout
        setContentView(R.layout.activity_main);

        // Instantiate views
        assignViews();

        // Set click listeners
        setClickables();

        // Pull saved data
        getGameData();

        // Enter game
        playCredits(1);
    }

    // Assign dynamic views
    public void assignViews() {

        // Credits view
        mCreditsImageView = findViewById(R.id.credits_image_view);

        // Entry views
        mEntryScoreApexLayout = findViewById(R.id.entry_score_apex_layout);
        mEntryMainControlLayout = findViewById(R.id.entry_main_control_layout);
        mEntryContinueImageButton = findViewById(R.id.entry_main_continue_image_button);
        mEntryCreditsImageButton = findViewById(R.id.entry_main_credits_image_button);

        // Stage select toggle views
        mStageSelectScorecardImageButton = findViewById(R.id.select_stage_scorecard_image_button);
        mStageSelectScorecardLayout = findViewById(R.id.stage_select_scorecard_layout);
        mStageSelectStagecardLayout = findViewById(R.id.stage_select_stagecard_layout);

        // EOBE top scores
        mEOBEApexScoreImageView = findViewById(R.id.stage_select_apex_image_view);
        mEOBEPredatorScoreTextView = findViewById(R.id.stage_select_predator_score_text_view);
        mEOBEAccuracyScoreTextView = findViewById(R.id.stage_select_accuracy_score_text_view);
        mEOBETimeBestScoreTextView = findViewById(R.id.stage_select_time_best_score_text_view);
        mEOBETimeTotalScoreTextView = findViewById(R.id.stage_select_time_total_score_text_view);
        mEOBECollectionScoreTextView = findViewById(R.id.stage_select_collection_score_text_view);
        mEOBEAttemptsScoreTextView = findViewById(R.id.stage_select_attempts_score_text_view);
        mEOBEBossKillsScoreTextView = findViewById(R.id.stage_select_boss_score_text_view);
        mEOBECreatureKillsScoreTextView = findViewById(R.id.stage_select_creature_score_text_view);
        mEOBEHighestStreakScoreTextView = findViewById(R.id.stage_select_streak_score_text_view);
        mEOBEClosestDeathScoreTextView = findViewById(R.id.stage_select_death_score_text_view);
        mEOBELongestFrenzyScoreTextView = findViewById(R.id.stage_select_frenzy_score_text_view);
        mEOBEMostCalmScoreTextView = findViewById(R.id.stage_select_calm_score_text_view);
        mEOBEMostFranticTextView = findViewById(R.id.stage_select_frantic_score_text_view);

        // Creature collection views
        mCreature01ImageView = findViewById(R.id.creature_01_image_view);
        mCreature02ImageView = findViewById(R.id.creature_02_image_view);
        mCreature03ImageView = findViewById(R.id.creature_03_image_view);
        mCreature04ImageView = findViewById(R.id.creature_04_image_view);
        mCreature05ImageView = findViewById(R.id.creature_05_image_view);
        mCreature06ImageView = findViewById(R.id.creature_06_image_view);
        mCreature07ImageView = findViewById(R.id.creature_07_image_view);
        mCreature08ImageView = findViewById(R.id.creature_08_image_view);
        mCreature09ImageView = findViewById(R.id.creature_09_image_view);
        mCreature10ImageView = findViewById(R.id.creature_10_image_view);
        mCreature11ImageView = findViewById(R.id.creature_11_image_view);
        mCreature12ImageView = findViewById(R.id.creature_12_image_view);
        mCreature13ImageView = findViewById(R.id.creature_13_image_view);
        mCreature14ImageView = findViewById(R.id.creature_14_image_view);
        mCreature15ImageView = findViewById(R.id.creature_15_image_view);
        mCreature16ImageView = findViewById(R.id.creature_16_image_view);
        mCreature17ImageView = findViewById(R.id.creature_17_image_view);
        mCreature18ImageView = findViewById(R.id.creature_18_image_view);
        mCreature19ImageView = findViewById(R.id.creature_19_image_view);
        mCreature20ImageView = findViewById(R.id.creature_20_image_view);
        mCreature21ImageView = findViewById(R.id.creature_21_image_view);
        mCreature22ImageView = findViewById(R.id.creature_22_image_view);
        mCreature23ImageView = findViewById(R.id.creature_23_image_view);
        mCreature24ImageView = findViewById(R.id.creature_24_image_view);
        mCreature25ImageView = findViewById(R.id.creature_25_image_view);
        mCreature26ImageView = findViewById(R.id.creature_26_image_view);
        mCreature27ImageView = findViewById(R.id.creature_27_image_view);
        mCreature28ImageView = findViewById(R.id.creature_28_image_view);
        mCreature29ImageView = findViewById(R.id.creature_29_image_view);
        mCreature30ImageView = findViewById(R.id.creature_30_image_view);
        mCreature31ImageView = findViewById(R.id.creature_31_image_view);
        mCreature32ImageView = findViewById(R.id.creature_32_image_view);

        // Stage card layouts
        //mStage01CardLayout = findViewById(R.id.stage_select_card_01_image_layout);
        //mStage02CardLayout = findViewById(R.id.stage_select_card_02_image_layout);
        //mStage03CardLayout = findViewById(R.id.stage_select_card_03_image_layout);
        //mStage04CardLayout = findViewById(R.id.stage_select_card_04_image_layout);
        //mStage05CardLayout = findViewById(R.id.stage_select_card_05_image_layout);
        //mStage06CardLayout = findViewById(R.id.stage_select_card_06_image_layout);
        //mStage07CardLayout = findViewById(R.id.stage_select_card_07_image_layout);

        // Stage title image views
        //mStage01TitleImageView = findViewById(R.id.select_stage_title_01_image_view);
        //mStage02TitleImageView = findViewById(R.id.select_stage_title_02_image_view);
        //mStage03TitleImageView = findViewById(R.id.select_stage_title_03_image_view);
        //mStage04TitleImageView = findViewById(R.id.select_stage_title_04_image_view);
        //mStage05TitleImageView = findViewById(R.id.select_stage_title_05_image_view);
        //mStage06TitleImageView = findViewById(R.id.select_stage_title_06_image_view);
        //mStage07TitleImageView = findViewById(R.id.select_stage_title_07_image_view);

        // Stage status image views
        //mStage01StatusImageView = findViewById(R.id.select_stage_status_01_image_view);
        //mStage02StatusImageView = findViewById(R.id.select_stage_status_02_image_view);
        //mStage03StatusImageView = findViewById(R.id.select_stage_status_03_image_view);
        //mStage04StatusImageView = findViewById(R.id.select_stage_status_04_image_view);
        //mStage05StatusImageView = findViewById(R.id.select_stage_status_05_image_view);
        //mStage06StatusImageView = findViewById(R.id.select_stage_status_06_image_view);
        //mStage07StatusImageView = findViewById(R.id.select_stage_status_07_image_view);

        // Stage status icon image buttons
        //mStage01StatusImageButton = findViewById(R.id.select_stage_status_01_icon_image_button);
        //mStage02StatusImageButton = findViewById(R.id.select_stage_status_02_icon_image_button);
        //mStage03StatusImageButton = findViewById(R.id.select_stage_status_03_icon_image_button);
        //mStage04StatusImageButton = findViewById(R.id.select_stage_status_04_icon_image_button);
        //mStage05StatusImageButton = findViewById(R.id.select_stage_status_05_icon_image_button);
        //mStage06StatusImageButton = findViewById(R.id.select_stage_status_06_icon_image_button);
        //mStage07StatusImageButton = findViewById(R.id.select_stage_status_07_icon_image_button);

        // Game control layout
        mGameControlLayout = findViewById(R.id.game_main_title_image_layout);

        // Stage label
        mGameStageImageView = findViewById(R.id.game_main_stage_image_view);
        mGameSceneImageView = findViewById(R.id.game_main_scene_image_view);
        mGameSceneTextView = findViewById(R.id.game_main_scene_text_view);

        // Stage UI
        mGameLevelMarkerLayout = findViewById(R.id.game_main_level_marker_layout);
        mGamePowersLayout = findViewById(R.id.game_main_powers_layout);

        // Progress marker
        mGameLevelMarkerImageView = findViewById(R.id.game_main_level_marker_image_view);

        //
        mGameScenePrevImageButton = findViewById(R.id.game_scene_prev_image_button);
        mGameSceneNextImageButton = findViewById(R.id.game_scene_next_image_button);
        mStageDisasterImageView = findViewById(R.id.game_main_stage_advance_image_view);

        // Power icons
        mGamePower01ImageView = findViewById(R.id.game_main_power_01_image_view);
        mGamePower02ImageView = findViewById(R.id.game_main_power_02_image_view);
        mGamePower03ImageView = findViewById(R.id.game_main_power_03_image_view);
        mGamePower04ImageView = findViewById(R.id.game_main_power_04_image_view);
        mGamePower05ImageView = findViewById(R.id.game_main_power_05_image_view);
        mGamePower06ImageView = findViewById(R.id.game_main_power_06_image_view);

        //
        mGameCreature01ImageButton = findViewById(R.id.game_main_creature_01_image_button);
        mGameCreature02ImageButton = findViewById(R.id.game_main_creature_02_image_button);
        mGameCreature03ImageButton = findViewById(R.id.game_main_creature_03_image_button);
        mGameCreature04ImageButton = findViewById(R.id.game_main_creature_04_image_button);
        mGameCreature05ImageButton = findViewById(R.id.game_main_creature_05_image_button);

        // Boss
        mGameBossImageButton = findViewById(R.id.game_main_boss_image_button);

        // Playgrounds
        mGameCreatureLayout = findViewById(R.id.game_main_creature_layout);
        mGameBossLayout = findViewById(R.id.game_main_boss_layout);

        // Stage camouflage
        mGameBorderLayout = findViewById(R.id.game_main_silhouette_border_layout);

        // Boss sneak
        mGameTunnelVisionLayout = findViewById(R.id.game_main_tunnel_vision_layout);

        // Stage card views
        mStageCardStatusImageView = findViewById(R.id.stage_card_status_image_view);
        mStageCardTopScoreImageButton = findViewById(R.id.stage_card_top_score_image_button);

        //
        mStageCardScreenBodyLayout = findViewById(R.id.stage_card_screen_body_layout);

        //
        mStageCardContentTitleLayout = findViewById(R.id.stage_card_content_title_layout);
        mStageCardContentTitleImageButton = findViewById(R.id.stage_card_content_title_image_button);

        //
        mStageCardContentBossLayout = findViewById(R.id.stage_card_content_boss_layout);
        mStageCardBossImageView = findViewById(R.id.stage_card_boss_image_view);

        //
        mStageCardScorecardLayout = findViewById(R.id.stage_card_scorecard_layout);

        //
        mStageCardTopScoreLayout = findViewById(R.id.stage_card_top_score_layout);

        // stage complete
        mStagePredatorTextView = findViewById(R.id.stage_card_predator_score_text_view);
        mStageAccuracyTextView = findViewById(R.id.stage_card_accuracy_score_text_view);
        mStageApexPredatorTextView = findViewById(R.id.stage_card_apex_predator_score_text_view);

        // stage complete
        mStageTimeTextView = findViewById(R.id.stage_card_time_score_text_view);
        mStageCreatureKillsTextView = findViewById(R.id.stage_card_eaten_score_text_view);
        mStageCollectionTextView = findViewById(R.id.stage_card_collection_score_text_view);

        // stage complete
        mStageHighestStreakTextView = findViewById(R.id.stage_card_streak_score_text_view);
        mStageClosestDeathTextView = findViewById(R.id.stage_card_death_score_text_view);
        mStageLongestFrenzyTextView = findViewById(R.id.stage_card_frenzy_score_text_view);
        mStageMostCalmTextView = findViewById(R.id.stage_card_calm_score_text_view);
        mStageMostFranticTextView = findViewById(R.id.stage_card_frantic_score_text_view);

        // top scores
        mStageTopApexPredatorTextView = findViewById(R.id.stage_card_top_apex_score_text_view);
        mStageTotalAttemptsTextView = findViewById(R.id.stage_card_total_attempts_score_text_view);
        mStageTotalBossKillsTextView = findViewById(R.id.stage_card_total_boss_kills_score_text_view);
        mStageTotalCreatureKillsTextView = findViewById(R.id.stage_card_total_creature_kills_score_text_view);
        mStageTopHighestStreakTextView = findViewById(R.id.stage_card_top_highest_streak_score_text_view);
        mStageTopClosestDeathTextView = findViewById(R.id.stage_card_top_closest_death_score_text_view);
        mStageTopLongestFrenzyTextView = findViewById(R.id.stage_card_top_longest_frenzy_score_text_view);
        mStageTopMostCalmTextView = findViewById(R.id.stage_card_top_most_calm_score_text_view);
        mStageTopMostFranticTextView = findViewById(R.id.stage_card_top_most_frantic_score_text_view);
        mStageTotalTimeTextView = findViewById(R.id.stage_card_total_time_score_text_view);
        mStageTopBestTimeTextView = findViewById(R.id.stage_card_top_best_time_score_text_view);
        mStageTopPredatorTextView = findViewById(R.id.stage_card_top_predator_score_text_view);
        mStageTopAccuracyTextView = findViewById(R.id.stage_card_top_accuracy_score_text_view);
        mStageTotalCollectionTextView = findViewById(R.id.stage_card_total_collection_score_text_view);

        // Stage card - switch ui
        mStageCardControlPrevImageButton = findViewById(R.id.stage_card_control_prev_image_button);
        mStageCardControlNextImageButton = findViewById(R.id.stage_card_control_next_image_button);
        mStageCardControlPlayImageButton = findViewById(R.id.stage_card_ready_play_here_image_button);

        // Eaten views
        mEatenMainTitleImageView = findViewById(R.id.eaten_main_title_image_view);
        mEatenSubTitleLayout = findViewById(R.id.eaten_sub_title_layout);
        mEatenStageNameTextView = findViewById(R.id.eaten_stage_name_text_view);
        mEatenStageTimeTextView = findViewById(R.id.eaten_stage_time_text_view);
    }

    // Save game state data
    public void setGameData() {

        //
        SharedPreferences mUserPrefSet = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditorSet = mUserPrefSet.edit();

        //
        mEditorSet.putBoolean(CONTINUE_SAVED_STATE, continue_game);

        //
        mEditorSet.putBoolean(AUDIO_SAVED_STATE, play_audio);
        mEditorSet.putBoolean(HAPTIC_SAVED_STATE, play_haptic);
        mEditorSet.putBoolean(TUTORIAL_SAVED_STATE, play_tutorial);

        // Top scores
        mEditorSet.putInt(STAGE_01_ATTEMPTS, stage_01_attempts); // local variable into constant
        mEditorSet.putInt(STAGE_01_BOSS_KILLS, stage_01_boss_kills);
        mEditorSet.putInt(STAGE_01_CREATURE_KILLS, stage_01_creature_kills);

        //
        mEditorSet.putInt(STAGE_01_HIGHEST_STREAK, stage_01_highest_streak);
        mEditorSet.putInt(STAGE_01_CLOSEST_DEATH, stage_01_closest_death);
        mEditorSet.putInt(STAGE_01_LONGEST_FRENZY, stage_01_longest_frenzy);
        mEditorSet.putLong(STAGE_01_MOST_CALM, stage_01_most_calm);
        mEditorSet.putLong(STAGE_01_MOST_FRANTIC, stage_01_most_frantic);

        //
        mEditorSet.putInt(STAGE_01_TOTAL_TIME, stage_01_total_time);
        mEditorSet.putInt(STAGE_01_BEST_TIME, stage_01_best_time);

        //
        mEditorSet.putInt(STAGE_01_COLLECTION, stage_01_collection);

        //
        mEditorSet.putBoolean(STAGE_01_COMPLETE, stage_01_complete);
        mEditorSet.putInt(STAGE_01_PREDATOR, stage_01_predator);
        mEditorSet.putFloat(STAGE_01_ACCURACY, stage_01_accuracy);
        mEditorSet.putBoolean(STAGE_01_APEX, stage_01_apex);

        // 2
        mEditorSet.putInt(STAGE_02_ATTEMPTS, stage_02_attempts);
        mEditorSet.putInt(STAGE_02_BOSS_KILLS, stage_02_boss_kills);
        mEditorSet.putInt(STAGE_02_CREATURE_KILLS, stage_02_creature_kills);

        //
        mEditorSet.putInt(STAGE_02_HIGHEST_STREAK, stage_02_highest_streak);
        mEditorSet.putInt(STAGE_02_CLOSEST_DEATH, stage_02_closest_death);
        mEditorSet.putInt(STAGE_02_LONGEST_FRENZY, stage_02_longest_frenzy);
        mEditorSet.putLong(STAGE_02_MOST_CALM, stage_02_most_calm);
        mEditorSet.putLong(STAGE_02_MOST_FRANTIC, stage_02_most_frantic);

        //
        mEditorSet.putInt(STAGE_02_TOTAL_TIME, stage_02_total_time);
        mEditorSet.putInt(STAGE_02_BEST_TIME, stage_02_best_time);

        //
        mEditorSet.putInt(STAGE_02_COLLECTION, stage_02_collection);

        //
        mEditorSet.putBoolean(STAGE_02_COMPLETE, stage_02_complete);
        mEditorSet.putInt(STAGE_02_PREDATOR, stage_02_predator);
        mEditorSet.putFloat(STAGE_02_ACCURACY, stage_02_accuracy);
        mEditorSet.putBoolean(STAGE_02_APEX, stage_02_apex);

        // 3
        mEditorSet.putInt(STAGE_03_ATTEMPTS, stage_03_attempts);
        mEditorSet.putInt(STAGE_03_BOSS_KILLS, stage_03_boss_kills);
        mEditorSet.putInt(STAGE_03_CREATURE_KILLS, stage_03_creature_kills);

        //
        mEditorSet.putInt(STAGE_03_HIGHEST_STREAK, stage_03_highest_streak);
        mEditorSet.putInt(STAGE_03_CLOSEST_DEATH, stage_03_closest_death);
        mEditorSet.putInt(STAGE_03_LONGEST_FRENZY, stage_03_longest_frenzy);

        //
        mEditorSet.putLong(STAGE_03_MOST_CALM, stage_03_most_calm);
        mEditorSet.putLong(STAGE_03_MOST_FRANTIC, stage_03_most_frantic);

        //
        mEditorSet.putInt(STAGE_03_TOTAL_TIME, stage_03_total_time);
        mEditorSet.putInt(STAGE_03_BEST_TIME, stage_03_best_time);

        //
        mEditorSet.putInt(STAGE_03_COLLECTION, stage_03_collection);

        //
        mEditorSet.putBoolean(STAGE_03_COMPLETE, stage_03_complete);
        mEditorSet.putInt(STAGE_03_PREDATOR, stage_03_predator);
        mEditorSet.putFloat(STAGE_03_ACCURACY, stage_03_accuracy);
        mEditorSet.putBoolean(STAGE_03_APEX, stage_03_apex);

        // 4
        mEditorSet.putInt(STAGE_04_ATTEMPTS, stage_04_attempts);
        mEditorSet.putInt(STAGE_04_BOSS_KILLS, stage_04_boss_kills);
        mEditorSet.putInt(STAGE_04_CREATURE_KILLS, stage_04_creature_kills);

        //
        mEditorSet.putInt(STAGE_04_HIGHEST_STREAK, stage_04_highest_streak);
        mEditorSet.putInt(STAGE_04_CLOSEST_DEATH, stage_04_closest_death);
        mEditorSet.putInt(STAGE_04_LONGEST_FRENZY, stage_04_longest_frenzy);

        //
        mEditorSet.putLong(STAGE_04_MOST_CALM, stage_04_most_calm);
        mEditorSet.putLong(STAGE_04_MOST_FRANTIC, stage_04_most_frantic);

        //
        mEditorSet.putInt(STAGE_04_TOTAL_TIME, stage_04_total_time);
        mEditorSet.putInt(STAGE_04_BEST_TIME, stage_04_best_time);

        //
        mEditorSet.putInt(STAGE_04_COLLECTION, stage_04_collection);

        //
        mEditorSet.putBoolean(STAGE_04_COMPLETE, stage_04_complete);
        mEditorSet.putInt(STAGE_04_PREDATOR, stage_04_predator);
        mEditorSet.putFloat(STAGE_04_ACCURACY, stage_04_accuracy);
        mEditorSet.putBoolean(STAGE_04_APEX, stage_04_apex);

        // 5
        mEditorSet.putInt(STAGE_05_ATTEMPTS, stage_05_attempts);
        mEditorSet.putInt(STAGE_05_BOSS_KILLS, stage_05_boss_kills);
        mEditorSet.putInt(STAGE_05_CREATURE_KILLS, stage_05_creature_kills);

        //
        mEditorSet.putInt(STAGE_05_HIGHEST_STREAK, stage_05_highest_streak);
        mEditorSet.putInt(STAGE_05_CLOSEST_DEATH, stage_05_closest_death);
        mEditorSet.putInt(STAGE_05_LONGEST_FRENZY, stage_05_longest_frenzy);

        //
        mEditorSet.putLong(STAGE_05_MOST_CALM, stage_05_most_calm);
        mEditorSet.putLong(STAGE_05_MOST_FRANTIC, stage_05_most_frantic);

        //
        mEditorSet.putInt(STAGE_05_TOTAL_TIME, stage_05_total_time);
        mEditorSet.putInt(STAGE_05_BEST_TIME, stage_05_best_time);

        //
        mEditorSet.putInt(STAGE_05_COLLECTION, stage_05_collection);

        //
        mEditorSet.putBoolean(STAGE_05_COMPLETE, stage_05_complete);
        mEditorSet.putInt(STAGE_05_PREDATOR, stage_05_predator);
        mEditorSet.putFloat(STAGE_05_ACCURACY, stage_05_accuracy);
        mEditorSet.putBoolean(STAGE_05_APEX, stage_05_apex);

        // 6
        mEditorSet.putInt(STAGE_06_ATTEMPTS, stage_06_attempts);
        mEditorSet.putInt(STAGE_06_BOSS_KILLS, stage_06_boss_kills);
        mEditorSet.putInt(STAGE_06_CREATURE_KILLS, stage_06_creature_kills);

        //
        mEditorSet.putInt(STAGE_06_HIGHEST_STREAK, stage_06_highest_streak);
        mEditorSet.putInt(STAGE_06_CLOSEST_DEATH, stage_06_closest_death);
        mEditorSet.putInt(STAGE_06_LONGEST_FRENZY, stage_06_longest_frenzy);

        //
        mEditorSet.putLong(STAGE_06_MOST_CALM, stage_06_most_calm);
        mEditorSet.putLong(STAGE_06_MOST_FRANTIC, stage_06_most_frantic);

        //
        mEditorSet.putInt(STAGE_06_TOTAL_TIME, stage_06_total_time);
        mEditorSet.putInt(STAGE_06_BEST_TIME, stage_06_best_time);

        //
        mEditorSet.putInt(STAGE_06_COLLECTION, stage_06_collection);

        //
        mEditorSet.putBoolean(STAGE_06_COMPLETE, stage_06_complete);
        mEditorSet.putInt(STAGE_06_PREDATOR, stage_06_predator);
        mEditorSet.putFloat(STAGE_06_ACCURACY, stage_06_accuracy);
        mEditorSet.putBoolean(STAGE_06_APEX, stage_06_apex);

        // 7
        mEditorSet.putInt(STAGE_07_ATTEMPTS, stage_07_attempts);
        mEditorSet.putInt(STAGE_07_BOSS_KILLS, stage_07_boss_kills);
        mEditorSet.putInt(STAGE_07_CREATURE_KILLS, stage_07_creature_kills);

        //
        mEditorSet.putInt(STAGE_07_HIGHEST_STREAK, stage_07_highest_streak);
        mEditorSet.putInt(STAGE_07_CLOSEST_DEATH, stage_07_closest_death);
        mEditorSet.putInt(STAGE_07_LONGEST_FRENZY, stage_07_longest_frenzy);

        //
        mEditorSet.putLong(STAGE_07_MOST_CALM, stage_07_most_calm);
        mEditorSet.putLong(STAGE_07_MOST_FRANTIC, stage_07_most_frantic);

        //
        mEditorSet.putInt(STAGE_07_TOTAL_TIME, stage_07_total_time);
        mEditorSet.putInt(STAGE_07_BEST_TIME, stage_07_best_time);

        //
        mEditorSet.putInt(STAGE_07_COLLECTION, stage_07_collection);

        //
        mEditorSet.putBoolean(STAGE_07_COMPLETE, stage_07_complete);
        mEditorSet.putInt(STAGE_07_PREDATOR, stage_07_predator);
        mEditorSet.putFloat(STAGE_07_ACCURACY, stage_07_accuracy);
        mEditorSet.putBoolean(STAGE_07_APEX, stage_07_apex);

        //
        mEditorSet.apply();
    }

    // Load game state data
    public void getGameData() {

        // Instantiate variables
        SharedPreferences mUserPrefGet = getPreferences(Context.MODE_PRIVATE);

        // Game settings
        play_audio = mUserPrefGet.getBoolean(AUDIO_SAVED_STATE, true);
        play_haptic = mUserPrefGet.getBoolean(HAPTIC_SAVED_STATE, true);
        play_tutorial = mUserPrefGet.getBoolean(TUTORIAL_SAVED_STATE, true);

        //
        stage_01_complete = mUserPrefGet.getBoolean(STAGE_01_COMPLETE, false);

        //
        stage_01_attempts = mUserPrefGet.getInt(STAGE_01_ATTEMPTS, 0);
        stage_01_boss_kills = mUserPrefGet.getInt(STAGE_01_BOSS_KILLS, 0);
        stage_01_creature_kills = mUserPrefGet.getInt(STAGE_01_CREATURE_KILLS, 0);
        stage_01_collection = mUserPrefGet.getInt(STAGE_01_COLLECTION, 0);






//-------------------------------->
        //public boolean saveArray(String[] array, String arrayName, Context mContext) {
            //SharedPreferences prefs = mContext.getSharedPreferences("preferencename", 0);
            //SharedPreferences.Editor editor = prefs.edit();
            //editor.putInt(arrayName +"_size", array.length);
            //for(int i=0;i<array.length;i++)
                //editor.putString(arrayName + "_" + i, array[i]);
            //return editor.commit();
        //}
// -------------------------------->

        //
        stage_01_highest_streak = mUserPrefGet.getInt(STAGE_01_HIGHEST_STREAK, 0);
        stage_01_closest_death = mUserPrefGet.getInt(STAGE_01_CLOSEST_DEATH, 30);
        stage_01_longest_frenzy = mUserPrefGet.getInt(STAGE_01_LONGEST_FRENZY, 0);
        stage_01_most_calm = mUserPrefGet.getLong(STAGE_01_MOST_CALM, 1000);
        stage_01_most_frantic = mUserPrefGet.getLong(STAGE_01_MOST_FRANTIC, 1000);

        //
        stage_01_total_time = mUserPrefGet.getInt(STAGE_01_TOTAL_TIME, 0);
        stage_01_best_time = mUserPrefGet.getInt(STAGE_01_BEST_TIME, 0);

        //
        stage_01_predator = mUserPrefGet.getInt(STAGE_01_PREDATOR, 0);
        stage_01_accuracy = mUserPrefGet.getFloat(STAGE_01_ACCURACY, 0);
        stage_01_apex = mUserPrefGet.getBoolean(STAGE_01_APEX, false);

        //
        continue_game = stage_01_complete;

        //
        //
        // -> see above
        //boolean stage_02_unlocked = stage_01_complete;

        //
        stage_02_complete = mUserPrefGet.getBoolean(STAGE_02_COMPLETE, false);

        //
        stage_02_attempts = mUserPrefGet.getInt(STAGE_02_ATTEMPTS, 0);
        stage_02_boss_kills = mUserPrefGet.getInt(STAGE_02_BOSS_KILLS, 0);
        stage_02_creature_kills = mUserPrefGet.getInt(STAGE_02_CREATURE_KILLS, 0);
        stage_02_collection = mUserPrefGet.getInt(STAGE_02_COLLECTION, 0);

        //
        stage_02_highest_streak = mUserPrefGet.getInt(STAGE_02_HIGHEST_STREAK, 0);
        stage_02_closest_death = mUserPrefGet.getInt(STAGE_02_CLOSEST_DEATH, 30);
        stage_02_longest_frenzy = mUserPrefGet.getInt(STAGE_02_LONGEST_FRENZY, 0);
        stage_02_most_calm = mUserPrefGet.getLong(STAGE_02_MOST_CALM, 1000);
        stage_02_most_frantic = mUserPrefGet.getLong(STAGE_02_MOST_FRANTIC, 1000);

        //
        stage_02_total_time = mUserPrefGet.getInt(STAGE_02_TOTAL_TIME, 0);
        stage_02_best_time = mUserPrefGet.getInt(STAGE_02_BEST_TIME, 0);

        //
        stage_02_predator = mUserPrefGet.getInt(STAGE_02_PREDATOR, 0);
        stage_02_accuracy = mUserPrefGet.getFloat(STAGE_02_ACCURACY, 0);
        stage_02_apex = mUserPrefGet.getBoolean(STAGE_02_APEX, false);

        //
        //
        // -> see above
        //boolean stage_03_unlocked = stage_02_complete;

        //
        stage_03_complete = mUserPrefGet.getBoolean(STAGE_03_COMPLETE, false);

        //
        stage_03_attempts = mUserPrefGet.getInt(STAGE_03_ATTEMPTS, 0);
        stage_03_boss_kills = mUserPrefGet.getInt(STAGE_03_BOSS_KILLS, 0);
        stage_03_creature_kills = mUserPrefGet.getInt(STAGE_03_CREATURE_KILLS, 0);
        stage_03_collection = mUserPrefGet.getInt(STAGE_03_COLLECTION, 0);

        //
        stage_03_highest_streak = mUserPrefGet.getInt(STAGE_03_HIGHEST_STREAK, 0);
        stage_03_closest_death = mUserPrefGet.getInt(STAGE_03_CLOSEST_DEATH, 30);
        stage_03_longest_frenzy = mUserPrefGet.getInt(STAGE_03_LONGEST_FRENZY, 0);
        stage_03_most_calm = mUserPrefGet.getLong(STAGE_03_MOST_CALM, 1000);
        stage_03_most_frantic = mUserPrefGet.getLong(STAGE_03_MOST_FRANTIC, 1000);

        //
        stage_03_total_time = mUserPrefGet.getInt(STAGE_03_TOTAL_TIME, 0);
        stage_03_best_time = mUserPrefGet.getInt(STAGE_03_BEST_TIME, 0);

        //
        stage_03_predator = mUserPrefGet.getInt(STAGE_03_PREDATOR, 0);
        stage_03_accuracy = mUserPrefGet.getFloat(STAGE_03_ACCURACY, 0);
        stage_03_apex = mUserPrefGet.getBoolean(STAGE_03_APEX, false);

        //
        //
        // -> see above
        //boolean stage_04_unlocked = stage_03_complete;

        //
        stage_04_complete = mUserPrefGet.getBoolean(STAGE_04_COMPLETE, false);

        //
        stage_04_attempts = mUserPrefGet.getInt(STAGE_04_ATTEMPTS, 0);
        stage_04_boss_kills = mUserPrefGet.getInt(STAGE_04_BOSS_KILLS, 0);
        stage_04_creature_kills = mUserPrefGet.getInt(STAGE_04_CREATURE_KILLS, 0);
        stage_04_collection = mUserPrefGet.getInt(STAGE_04_COLLECTION, 0);

        //
        stage_04_highest_streak = mUserPrefGet.getInt(STAGE_04_HIGHEST_STREAK, 0);
        stage_04_closest_death = mUserPrefGet.getInt(STAGE_04_CLOSEST_DEATH, 30);
        stage_04_longest_frenzy = mUserPrefGet.getInt(STAGE_04_LONGEST_FRENZY, 0);
        stage_04_most_calm = mUserPrefGet.getLong(STAGE_04_MOST_CALM, 1000);
        stage_04_most_frantic = mUserPrefGet.getLong(STAGE_04_MOST_FRANTIC, 1000);

        //
        stage_04_total_time = mUserPrefGet.getInt(STAGE_04_TOTAL_TIME, 0);
        stage_04_best_time = mUserPrefGet.getInt(STAGE_04_BEST_TIME, 0);

        //
        stage_04_predator = mUserPrefGet.getInt(STAGE_04_PREDATOR, 0);
        stage_04_accuracy = mUserPrefGet.getFloat(STAGE_04_ACCURACY, 0);
        stage_04_apex = mUserPrefGet.getBoolean(STAGE_04_APEX, false);

        //
        //
        // -> see above
        //boolean stage_05_unlocked = stage_04_complete;

        //
        stage_05_complete = mUserPrefGet.getBoolean(STAGE_05_COMPLETE, false);

        //
        stage_05_attempts = mUserPrefGet.getInt(STAGE_05_ATTEMPTS, 0);
        stage_05_boss_kills = mUserPrefGet.getInt(STAGE_05_BOSS_KILLS, 0);
        stage_05_creature_kills = mUserPrefGet.getInt(STAGE_05_CREATURE_KILLS, 0);
        stage_05_collection = mUserPrefGet.getInt(STAGE_05_COLLECTION, 0);

        //
        stage_05_highest_streak = mUserPrefGet.getInt(STAGE_05_HIGHEST_STREAK, 0);
        stage_05_closest_death = mUserPrefGet.getInt(STAGE_05_CLOSEST_DEATH, 30);
        stage_05_longest_frenzy = mUserPrefGet.getInt(STAGE_05_LONGEST_FRENZY, 0);
        stage_05_most_calm = mUserPrefGet.getLong(STAGE_05_MOST_CALM, 1000);
        stage_05_most_frantic = mUserPrefGet.getLong(STAGE_05_MOST_FRANTIC, 1000);

        //
        stage_05_total_time = mUserPrefGet.getInt(STAGE_05_TOTAL_TIME, 0);
        stage_05_best_time = mUserPrefGet.getInt(STAGE_05_BEST_TIME, 0);

        //
        stage_05_predator = mUserPrefGet.getInt(STAGE_05_PREDATOR, 0);
        stage_05_accuracy = mUserPrefGet.getFloat(STAGE_05_ACCURACY, 0);
        stage_05_apex = mUserPrefGet.getBoolean(STAGE_05_APEX, false);

        //
        //
        // -> see above
        //boolean stage_06_unlocked = stage_05_complete;

        //
        stage_06_complete = mUserPrefGet.getBoolean(STAGE_06_COMPLETE, false);

        //
        stage_06_attempts = mUserPrefGet.getInt(STAGE_06_ATTEMPTS, 0);
        stage_06_boss_kills = mUserPrefGet.getInt(STAGE_06_BOSS_KILLS, 0);
        stage_06_creature_kills = mUserPrefGet.getInt(STAGE_06_CREATURE_KILLS, 0);
        stage_07_collection = mUserPrefGet.getInt(STAGE_07_COLLECTION, 0);

        //
        stage_06_highest_streak = mUserPrefGet.getInt(STAGE_06_HIGHEST_STREAK, 0);
        stage_06_closest_death = mUserPrefGet.getInt(STAGE_06_CLOSEST_DEATH, 30);
        stage_06_longest_frenzy = mUserPrefGet.getInt(STAGE_06_LONGEST_FRENZY, 0);
        stage_06_most_calm = mUserPrefGet.getLong(STAGE_06_MOST_CALM, 1000);
        stage_06_most_frantic = mUserPrefGet.getLong(STAGE_06_MOST_FRANTIC, 1000);

        //
        stage_06_total_time = mUserPrefGet.getInt(STAGE_06_TOTAL_TIME, 0);
        stage_06_best_time = mUserPrefGet.getInt(STAGE_06_BEST_TIME, 0);

        //
        stage_06_predator = mUserPrefGet.getInt(STAGE_06_PREDATOR, 0);
        stage_06_accuracy = mUserPrefGet.getFloat(STAGE_06_ACCURACY, 0);
        stage_06_apex = mUserPrefGet.getBoolean(STAGE_06_APEX, false);

        //
        //
        // -> see above
        //boolean stage_07_unlocked = stage_06_complete;

        //
        stage_07_complete = mUserPrefGet.getBoolean(STAGE_07_COMPLETE, false);

        //
        stage_07_attempts = mUserPrefGet.getInt(STAGE_07_ATTEMPTS, 0);
        stage_07_boss_kills = mUserPrefGet.getInt(STAGE_07_BOSS_KILLS, 0);
        stage_07_creature_kills = mUserPrefGet.getInt(STAGE_07_CREATURE_KILLS, 0);
        stage_07_highest_streak = mUserPrefGet.getInt(STAGE_07_HIGHEST_STREAK, 0);
        stage_07_closest_death = mUserPrefGet.getInt(STAGE_07_CLOSEST_DEATH, 30);
        stage_07_longest_frenzy = mUserPrefGet.getInt(STAGE_07_LONGEST_FRENZY, 0);
        stage_07_most_calm = mUserPrefGet.getLong(STAGE_07_MOST_CALM, 1000);
        stage_07_most_frantic = mUserPrefGet.getLong(STAGE_07_MOST_FRANTIC, 1000);

        //
        stage_07_total_time = mUserPrefGet.getInt(STAGE_07_TOTAL_TIME, 0);
        stage_07_best_time = mUserPrefGet.getInt(STAGE_07_BEST_TIME, 0);

        //
        stage_07_predator = mUserPrefGet.getInt(STAGE_07_PREDATOR, 0);
        stage_07_accuracy = mUserPrefGet.getFloat(STAGE_07_ACCURACY, 0);
        stage_07_apex = mUserPrefGet.getBoolean(STAGE_07_APEX, false);

        //
        game_complete = stage_07_complete;

        // Assign - total attempts
        mGameAttempts = stage_01_attempts + stage_02_attempts + stage_03_attempts + stage_04_attempts + stage_05_attempts + stage_06_attempts + stage_07_attempts;

        // Assign - total boss kills
        mGameBossKills = stage_01_boss_kills + stage_02_boss_kills + stage_03_boss_kills + stage_04_boss_kills + stage_05_boss_kills + stage_06_boss_kills + stage_07_boss_kills;

        // Assign - total creature kills
        mGameCreatureKills = stage_01_creature_kills + stage_02_creature_kills + stage_03_creature_kills + stage_04_creature_kills + stage_05_creature_kills + stage_06_creature_kills + stage_07_creature_kills;

        // Int score
        int hiScore;

        // long score
        long highScore;

        // Accuracy iteration
        int i;

        // Accuracy accumulation
        float mAccumulativeAccuracy;

        // Reset - highest streak
        hiScore = 0;
        i = 1;

        //
        int[] top_scores_highest_streak = {

                //
                stage_01_highest_streak, stage_02_highest_streak, stage_03_highest_streak, stage_04_highest_streak, stage_05_highest_streak, stage_06_highest_streak, stage_07_highest_streak
        };

        // Extract - highest streak
        for (int score : top_scores_highest_streak) {

            // Compare - highest streak
            if (score >= hiScore) { hiScore = score; }
            i++;
        }

        // Assign - highest streak
        mGameHighestStreak = hiScore;

        // Reset - closest death
        hiScore = 30;
        i = 1;

        //
        int[] top_scores_closest_death = {

                //
                stage_01_closest_death, stage_02_closest_death, stage_03_closest_death, stage_04_closest_death, stage_05_closest_death, stage_06_closest_death, stage_07_closest_death
        };

        // Extract - closest death
        for (int score : top_scores_closest_death) {

            // Compare - closest death
            if (score <= hiScore && score != 30) { hiScore = score; }
            i++;
        }

        // Assign - highest streak
        mGameClosestDeath = hiScore;

        // Reset - longest frenzy
        hiScore = 0;
        i = 1;

        //
        int[] top_scores_longest_frenzy = {

                //
                stage_01_longest_frenzy, stage_02_longest_frenzy, stage_03_longest_frenzy, stage_04_longest_frenzy, stage_05_longest_frenzy, stage_06_longest_frenzy, stage_07_longest_frenzy
        };

        // Extract - longest frenzy
        for (int score : top_scores_longest_frenzy) {

            // Compare - longest frenzy
            if (score >= hiScore || score != 0) { hiScore = score; }
            i++;
        }

        // Assign - longest frenzy
        mGameLongestFrenzy = hiScore;

        // Reset - most calm
        highScore = 1000;
        i = 1;

        //
        long[] top_scores_most_calm = {

                //
                stage_01_most_calm, stage_02_most_calm, stage_03_most_calm, stage_04_most_calm, stage_05_most_calm, stage_06_most_calm, stage_07_most_calm
        };

        // Extract - most calm
        for (long score : top_scores_most_calm) {

            // Compare - most calm
            if (score >= highScore || score != 1000) { highScore = score; }
            i++;
        }

        // Assign - most calm
        mGameMostCalm = highScore;

        // Reset - most frantic
        highScore = 1000;
        i = 1;

        //
        long[] top_scores_most_frantic = {

                //
                stage_01_most_frantic, stage_02_most_frantic, stage_03_most_frantic, stage_04_most_frantic, stage_05_most_frantic, stage_06_most_frantic, stage_07_most_frantic
        };

        // Extract - most frantic
        for (long score : top_scores_most_frantic) {

            // Compare - most frantic
            if (score <= highScore || score != 1000) { highScore = score; }
            i++;
        }

        // Assign - most frantic
        mGameMostFrantic = highScore;

        // Reset - best time
        hiScore = 1000;
        i = 1;

        //
        int[] top_scores_best_time = {

                //
                stage_01_best_time, stage_02_best_time, stage_03_best_time, stage_04_best_time, stage_05_best_time, stage_06_best_time, stage_07_best_time
        };

        // Extract - best time
        for (int score : top_scores_best_time) {

            // Compare - best time
            if (score != 0 && score <= hiScore) {

                // Assign - local
                hiScore = score;
            }
            i++;
        }

        // Assign - best time
        mGameTimeBest = hiScore;

        // Assign - top predator
        mGamePredator = (stage_01_predator + stage_02_predator + stage_03_predator + stage_04_predator + stage_05_predator + stage_06_predator + stage_07_predator);

        // Reset - top accuracy
        mAccumulativeAccuracy = 0;
        i = 0;

        //
        float[] top_scores_top_accuracy = {

                //
                stage_01_accuracy, stage_02_accuracy, stage_03_accuracy, stage_04_accuracy, stage_05_accuracy, stage_06_accuracy, stage_07_accuracy
        };

        // Extract - top accuracy
        for (float score : top_scores_top_accuracy) {

            // Compare - top accuracy
            if (score > 0 ) {

                // Assign - local
                mAccumulativeAccuracy += score;
                ++i;

                // Assign - top accuracy
                mGameAccuracy = mAccumulativeAccuracy / i;
            }
        }

        // Reset - top apex
        mGameApex = true;
        i = 1;

        //
        boolean[] top_scores_top_apex = {

                //
                stage_01_apex, stage_02_apex, stage_03_apex, stage_04_apex, stage_05_apex, stage_06_apex, stage_07_apex
        };

        // Extract - top apex
        for (boolean score : top_scores_top_apex) {

            // Compare - top apex
            if (!score) { mGameApex = false; }
            i++;
        }

        // Assign - total time
        mGameTimeTotal = stage_01_total_time + stage_02_total_time + stage_03_total_time + stage_04_total_time + stage_05_total_time + stage_06_total_time + stage_07_total_time;

        // Assign - total collection
        mGameCollection = stage_01_collection + stage_02_collection + stage_03_collection + stage_04_collection + stage_05_collection + stage_06_collection + stage_07_collection;
    }

    // Set click listeners
    public void setClickables() {

        // Set click listener for each item in CLICKABLES array
        for (int id : CLICKABLES) { findViewById(id).setOnClickListener(this); }
    }

    // Play credits
    public void playCredits(int mode) {
        Log.d(TAG, "playCredits:");

        // Pause game
        mPauseGame = true;

        // Switch to intro screen
        switchScreen(R.id.credits_screen_main_layout);

        // Clear array
        mGameCreditsImages.clear();

        // Clear spinner
        mCreditSpinner = 0;

        // Switch intro [1] / outro [2]
        switch (mode) {

            //
            case 1:

                //
                for (int id : INTRO) {

                    //
                    mGameCreditsImages.add(id);
                }

                break;

            //
            case 2:

                //
                for (int id : OUTRO) {

                    //
                    mGameCreditsImages.add(id);
                }

                break;
        }

        // Play chomp
        playAudio(HIT);

        // Undo pause game
        mPauseGame = false;

        // Run timer through executable
        h1.postDelayed(r1, 1000);
    }

    // Click events
    public void onClick(View v) {

        // Get view clicked
        switch (v.getId()) {

//--CREDITS-->
            // Credits - skip intro / outro
            case R.id.credits_screen_main_layout:
                Log.d(TAG, "onClick: credit screen - touch screen");

                // Pause game
                mPauseGame = true;

                // Touch to skip
                mCreditSpinner = mGameCreditsImages.size();

                // Play audio
                playAudio(MISS);

                // Undo pause game
                mPauseGame = false;

                break;

//--ENTRY-->
            // Entry - Continue Button Event
            case R.id.entry_main_continue_image_button:
                Log.d(TAG, "onClick: entry screen - continue button");

                // Pause game
                mPauseGame = true;

                // Switch to stage select screen
                if (continue_game) {

                    //
                    switchScreen(R.id.stage_select_screen_main_layout);
                }

                // Play audio
                playAudio(MISS);

                // Undo pause game
                mPauseGame = false;

                break;

            // Entry - New Button Event
            case R.id.entry_main_new_image_button:
                Log.d(TAG, "onClick: entry screen - new game button");

                // Pause game
                mPauseGame = true;

                // Check previous data
                if (continue_game) {

                    // Dialog to confirm new game
                    alertNewGame();

                } else {

                    // Switch to stage select screen
                    switchScreen(R.id.stage_select_screen_main_layout);
                }

                // Play audio
                playAudio(MISS);

                // Undo pause game
                mPauseGame = false;

                break;

            // Entry - Settings Button Event
            case R.id.entry_main_settings_image_button:
                Log.d(TAG, "onClick: entry screen - settings button");

                // Pause game
                mPauseGame = true;

                // Dialog to edit settings
                alertEditSettings();

                // Play audio
                playAudio(CROW_AUDIO);

                // Undo pause game
                mPauseGame = false;

                break;

            // Entry - Tutorial Button Event
            case R.id.entry_main_tutorial_image_button:
                Log.d(TAG, "onClick: entry screen - tutorial button");

                // Pause game
                mPauseGame = true;

                // Dialog to toggle tutorial
                alertToggleTutorial();

                // Play audio
                playAudio(CROW_AUDIO);

                // Undo pause game
                mPauseGame = false;

                break;

            // Entry - Credits Button Event
            case R.id.entry_main_credits_image_button:
                Log.d(TAG, "onClick: entry screen - credits button");

                // Pause game
                mPauseGame = true;

                // Switch to credits
                playCredits(2);

                // Play audio
                playAudio(RUN);

                // Undo pause game
                mPauseGame = false;

                break;

//--STAGE SELECT-->
            // Stage select - Return event
            case R.id.stage_select_return_image_button:
                Log.d(TAG, "onClick: stage select - return");

                // Pause game
                mPauseGame = true;

                // Switch to entry screen
                switchScreen(R.id.entry_screen_main_layout);

                // Play audio
                playAudio(RUN);

                // Undo pause game
                mPauseGame = false;

                break;

            // Select stage - Scorecard event
            case R.id.select_stage_scorecard_image_button:
                Log.d(TAG, "onClick: stage select - scorecard");

                // Check scores present
                if (stage_01_complete) {

                    // Pause game
                    mPauseGame = true;

                    // Display scorecard
                    if (mTopScores) {

                        //
                        mTopScores = false;

                        //
                        mStageSelectScorecardLayout.setVisibility(View.GONE);
                        mStageSelectStagecardLayout.setVisibility(View.VISIBLE);

                    } else {

                        //
                        mTopScores = true;

                        //
                        mStageSelectScorecardLayout.setVisibility(View.VISIBLE);
                        mStageSelectStagecardLayout.setVisibility(View.GONE);
                    }

                    // Play audio
                    playAudio(CROW_AUDIO);

                    // Undo pause game
                    mPauseGame = false;
                }

                break;

            // Stage select event
            case R.id.stage_select_card_01_image_layout:
                Log.d(TAG, "onClick: stage select - stage 1");

                // Pause game
                mPauseGame = true;

                // Set stage card - forest [index for resources]
                mStageIndex = 1;
                mStageApex = false;

                // Initial stage status - stage 1 is always ready, all others set to 1, then test for ready
                mStageReady = 2;
                
                // Check stage complete
                mStageComplete = stage_01_complete;
                Log.d(TAG, "onClick: stage complete : " + stage_01_complete);

                // Load images, audio, scores
                loadStageProps(mStageIndex);

                // Switch stage card screen
                //startStageCard();
                // Switch to SCREEN(STAGE_CARD)
                switchScreen(R.id.stage_card_screen_main_layout);

                // Play audio
                playAudio(CHOMP);

                // Undo pause game
                mPauseGame = false;

                break;

            //
            case R.id.stage_select_card_02_image_layout:
                Log.d(TAG, "onClick: stage select - stage 2");

                // Pause game
                mPauseGame = true;

                // Set stage card - ocean
                mStageIndex = 2;
                mStageApex = false;

                // Initial stage status - locked
                mStageReady = 1;
                    
                // Test for ready
                if (stage_01_complete) { mStageReady = 2; }

                // Check stage complete
                mStageComplete = stage_02_complete;

                // Load images, audio, scores
                loadStageProps(mStageIndex);

                // Switch stage card screen
                //startStageCard();
                // Switch to SCREEN(STAGE_CARD)
                switchScreen(R.id.stage_card_screen_main_layout);

                // Play audio
                playAudio(CHOMP);

                // Undo pause game
                mPauseGame = false;

                break;

            //
            case R.id.stage_select_card_03_image_layout:
                Log.d(TAG, "onClick: stage select - stage 3");

                // Pause game
                mPauseGame = true;

                // Set stage card - mountain
                mStageIndex = 3;
                mStageApex = false;

                // Initial stage status - locked
                mStageReady = 1;

                // Test for ready
                if (stage_02_complete) { mStageReady = 2; }

                // Check stage complete
                mStageComplete = stage_03_complete;

                // Load images, audio, scores
                loadStageProps(mStageIndex);

                // Switch stage card screen
                //startStageCard();
                // Switch to SCREEN(STAGE_CARD)
                switchScreen(R.id.stage_card_screen_main_layout);

                // Play audio
                playAudio(CHOMP);

                // Undo pause game
                mPauseGame = false;

                break;

            //
            case R.id.stage_select_card_04_image_layout:
                Log.d(TAG, "onClick: stage select - stage 4");

                // Pause game
                mPauseGame = true;

                // Set stage card - desert
                mStageIndex = 4;
                mStageApex = false;

                // Initial stage status - locked
                mStageReady = 1;

                // Test for ready
                if (stage_03_complete) { mStageReady = 2; }

                // Check stage complete
                mStageComplete = stage_04_complete;

                // Load images, audio, scores
                loadStageProps(mStageIndex);

                // Switch stage card screen
                //startStageCard();
                // Switch to SCREEN(STAGE_CARD)
                switchScreen(R.id.stage_card_screen_main_layout);

                // Play audio
                playAudio(CHOMP);

                // Undo pause game
                mPauseGame = false;

                break;

            //
            case R.id.stage_select_card_05_image_layout:
                Log.d(TAG, "onClick: stage select - stage 5");

                // Pause game
                mPauseGame = true;

                // Set stage card - jungle
                mStageIndex = 5;
                mStageApex = false;

                // Initial stage status - locked
                mStageReady = 1;

                // Test for ready
                if (stage_04_complete) { mStageReady = 2; }

                // Check stage complete
                mStageComplete = stage_05_complete;

                // Load images, audio, scores
                loadStageProps(mStageIndex);

                // Switch stage card screen
                //startStageCard();
                // Switch to SCREEN(STAGE_CARD)
                switchScreen(R.id.stage_card_screen_main_layout);

                // Play audio
                playAudio(CHOMP);

                // Undo pause game
                mPauseGame = false;

                break;

            //
            case R.id.stage_select_card_06_image_layout:
                Log.d(TAG, "onClick: stage select - stage 6");

                // Pause game
                mPauseGame = true;

                // Set stage card - tundra
                mStageIndex = 6;
                mStageApex = false;

                // Initial stage status - locked
                mStageReady = 1;

                // Test for ready
                if (stage_05_complete) { mStageReady = 2; }

                // Check stage complete
                mStageComplete = stage_06_complete;

                // Load images, audio, scores
                loadStageProps(mStageIndex);

                // Switch stage card screen
                //startStageCard();
                // Switch to SCREEN(STAGE_CARD)
                switchScreen(R.id.stage_card_screen_main_layout);

                // Play audio
                playAudio(CHOMP);

                // Undo pause game
                mPauseGame = false;

                break;

            case R.id.stage_select_card_07_image_layout:
                Log.d(TAG, "onClick: stage select - final boss");

                // Pause game
                mPauseGame = true;

                // Set stage card - final
                mStageIndex = 7;
                mStageApex = false;

                // Initial stage status - locked
                mStageReady = 1;

                // Test for ready
                if (stage_06_complete) { mStageReady = 2; }

                // Check stage complete
                mStageComplete = stage_07_complete;

                // Load images, audio, scores
                loadStageProps(mStageIndex);

                // Switch stage card screen
                //startStageCard();
                // Switch to SCREEN(STAGE_CARD)
                switchScreen(R.id.stage_card_screen_main_layout);

                // Play audio
                playAudio(GROWL_ALERT);

                // Undo pause game
                mPauseGame = false;

                break;

//--STAGE CARD-->
            // Stage card - Header return
            case R.id.stage_card_header_return_image_button:
                Log.d(TAG, "onClick: return to stage select");

                //
                mStageApex = false;
                mStageIndex = -1;
                mStageReady = 1;
                mStageComplete = false;

                //
                resetCreatureCollection();

                //
                switchScreen(R.id.stage_select_screen_main_layout);

                break;

            // Stage card - Header collection
            case R.id.stage_card_top_score_image_button:
                Log.d(TAG, "onClick: top score image button - mTopScores = " + mTopScores);

                //
                if (mTopScores) {

                    //
                    if (mStageReady == 2) {

                        //
                        mTopScores = false;

                        //
                        mStageCardContentBossLayout.setVisibility(View.VISIBLE);
                        mStageCardTopScoreLayout.setVisibility(View.GONE);
                        mStageCardScorecardLayout.setVisibility(View.GONE);
                        mStageCardContentTitleLayout.setBackgroundColor(STAGE_COLOR[mStageIndex - 1]);

                    } else {

                        //
                        mTopScores = false;

                        //
                        mStageCardContentBossLayout.setVisibility(View.GONE);
                        mStageCardTopScoreLayout.setVisibility(View.GONE);
                        mStageCardScorecardLayout.setVisibility(View.VISIBLE);
                        mStageCardContentTitleLayout.setBackgroundColor(STAGE_COLOR[mStageIndex - 1]);
                    }

                } else {

                    //
                    if (mStageReady == 2) {

                        //
                        mTopScores = true;

                        //
                        mStageCardContentBossLayout.setVisibility(View.GONE);
                        mStageCardTopScoreLayout.setVisibility(View.VISIBLE);
                        mStageCardScorecardLayout.setVisibility(View.GONE);
                        mStageCardContentTitleLayout.setBackgroundColor(STAGE_COLOR[mStageIndex - 1]);

                    } else {

                        //
                        mTopScores = true;

                        //
                        mStageCardContentBossLayout.setVisibility(View.GONE);
                        mStageCardTopScoreLayout.setVisibility(View.VISIBLE);
                        mStageCardScorecardLayout.setVisibility(View.GONE);
                        mStageCardContentTitleLayout.setBackgroundColor(STAGE_COLOR[mStageIndex - 1]);

                    }
                }

                break;

            // Stage card - Content title
            case R.id.stage_card_content_title_image_button:

                //
                playAudio(mGameTapAudio);
                findViewById(R.id.stage_card_content_title_layout).setBackgroundColor(getResources().getColor(R.color.color_palette_fade_01));

                break;

            // Stage card - Control prev
            case R.id.stage_card_control_prev_image_button:

                //
                if (mStageIndex != 0) {

                    //
                    switchStageCard(0);
                }

                break;

            // Stage card - Control next
            case R.id.stage_card_control_next_image_button:

                //
                if (mStageIndex != 7) {

                    //
                    switchStageCard(1);
                }

                break;

            // Stage card - Footer play here
            case R.id.stage_card_ready_play_here_image_button:
                Log.d(TAG, "onClick: Play Here");

                //
                //switchScreen(R.id.game_screen_main_layout);

                //
                loadStageProps(mStageIndex);
                startGame();

                break;

//--GAME-->
            // Game - Settings Event
            case R.id.game_settings_alert_image_button:
                Log.d(TAG, "onClick: game - settings alert button");

                // Pause game
                mPauseGame = true;

                // Settings dialogue
                alertEditSettings();

                // Play audio
                playAudio(CROW_AUDIO);

                // Undo pause game
                //mPauseGame = false; --> in method

                break;

            // Game - Exit Event
            case R.id.game_main_exit_image_button:
                Log.d(TAG, "onClick: game - exit button");

                // Pause game
                mPauseGame = true;

                // Exit dialogue
                alertExitLoseProgress();

                // Play audio
                playAudio(RUN);

                // Undo pause game
                //mPauseGame = false; --> in method

                break;

            //
            case R.id.game_scene_prev_image_button:
                Log.d(TAG, "onClick: game - stage advance");

                // Pause game
                mPauseGame = true;

                //
                //if (mStageAdvanceMeter >= mStageAdvanceTarget) {

                        //
                        tapOut();

                    //
                    mCurScreen = R.id.game_screen_main_layout;
                    drawScreen();

                    //
                    playAudio(FLUTE_TRILL_LONG);
                //}

                // Undo pause game
                mPauseGame = false;

                break;

            //
            case R.id.game_scene_next_image_button:
                Log.d(TAG, "onClick: game - stage advance");

                // Pause game
                mPauseGame = true;

                //
                //if (mStageAdvanceMeter >= mStageAdvanceTarget) {

                        //
                        tapOut();

                    //
                    mCurScreen = R.id.game_screen_main_layout;
                    drawScreen();

                    //
                    playAudio(FLUTE_TRILL_LONG);
                //}

                // Undo pause game
                mPauseGame = false;

                break;

            // Game - Run Event
            case R.id.game_main_power_01_image_view:
                Log.d(TAG, "onClick: game - power 1");

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Spend power
                    usePower(mPower01Meter, mPower01Target, 1);
                }

                break;

            //
            case R.id.game_main_power_02_image_view:
                Log.d(TAG, "onClick: game - power 2");

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Spend power
                    usePower(mPower02Meter, mPower02Target, 2);
                }

                break;

            //
            case R.id.game_main_power_03_image_view:
                Log.d(TAG, "onClick: game - power 3");

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Spend power
                    usePower(mPower03Meter, mPower03Target, 3);
                }

                break;

            //
            case R.id.game_main_power_04_image_view:
                Log.d(TAG, "onClick: game - power 4");

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Spend power
                    usePower(mPower04Meter, mPower04Target, 4);
                }

                break;

            //
            case R.id.game_main_power_05_image_view:
                Log.d(TAG, "onClick: game - power 5");

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Spend power
                    usePower(mPower05Meter, mPower05Target, 5);
                }

                break;

            // Game - Roar Event
            case R.id.game_main_power_06_image_view:
                Log.d(TAG, "onClick: game - power 6");

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Spend power
                    usePower(mPower06Meter, mPower06Target, 6);
                }

                break;

            // Game - Miss Event
            case R.id.game_main_pg_creature_canvas_layout:
                Log.d(TAG, "onClick: game - miss [+1 MissNRoar]");

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    //
                    if (mTapCount > 2) {

                        //
                        playAudio(FLASH_BANG);
                    }

                    // Reset tapper
                    resetTapper();

                    // Tally miss
                    missPoint();

                    // Housekeeping
                    drawScreen();
                }

                break;

            // Game - Hit Events
            case R.id.game_main_creature_01_image_button:
                Log.d(TAG, "onClick: game - hit creature 1 [+1 EatNRun]");

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    //
                    mStageCreatureID = mStageCreature01ID;

                    // Inflate tapper
                    inflateTapper();

                    // Tally point
                    scorePoint();

                    // Housekeeping
                    drawScreen();

                    // Regenerate creature
                    switchCreature(R.id.game_main_creature_01_image_button);
                }

                break;

            //
            case R.id.game_main_creature_02_image_button:
                Log.d(TAG, "onClick: game - hit creature 2 [+1 EatNRun]");

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    //
                    mStageCreatureID = mStageCreature02ID;

                    // Inflate tapper
                    inflateTapper();

                    // Tally point
                    scorePoint();

                    // Housekeeping
                    drawScreen();

                    // Regenerate creature
                    switchCreature(R.id.game_main_creature_02_image_button);
                }

                break;

            //
            case R.id.game_main_creature_03_image_button:
                Log.d(TAG, "onClick: game - hit creature 3 [+1 EatNRun]");

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    //
                    mStageCreatureID = mStageCreature03ID;

                    // Inflate tapper
                    inflateTapper();

                    // Tally point
                    scorePoint();

                    // Housekeeping
                    drawScreen();

                    // Regenerate creature
                    switchCreature(R.id.game_main_creature_03_image_button);
                }

                break;

            //
            case R.id.game_main_creature_04_image_button:
                Log.d(TAG, "onClick: game - hit creature 4 [+1 EatNRun]");

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    //
                    mStageCreatureID = mStageCreature04ID;

                    // Inflate tapper
                    inflateTapper();

                    // Tally point
                    scorePoint();

                    // Housekeeping
                    drawScreen();

                    // Regenerate creature
                    switchCreature(R.id.game_main_creature_04_image_button);
                }

                break;

            //
            case R.id.game_main_creature_05_image_button:
                Log.d(TAG, "onClick: game - hit creature 5 [+1 EatNRun]");

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    //
                    mStageCreatureID = mStageCreature05ID;

                    // Inflate tapper
                    inflateTapper();

                    // Tally point
                    scorePoint();

                    // Housekeeping
                    drawScreen();

                    // Regenerate creature
                    switchCreature(R.id.game_main_creature_05_image_button);
                }

                break;

            //
            case R.id.game_main_boss_image_button:
                Log.d(TAG, "onClick: game - Boss Tap [-1 mBossHealth]");

                // Check pause game
                if (!mPauseGame || mPauseTimer != -1) {

                    // Attack boss
                    attackBoss();
                }

                break;

            //
            case R.id.game_main_pg_boss_canvas_layout:
                Log.d(TAG, "onClick: game - Boss Miss [no apex]");

                // Check pause game
                if (!mPauseGame || mPauseTimer != -1) {

                    //
                    playAudio(MISS);

                    //
                    mStageApex = false;
                }

                break;

//--EATEN-->
            // Eaten - Return
            case R.id.eaten_main_return_image_button:
                Log.d(TAG, "onClick: eaten - return");

                boolean[] stage_complete = {

                        //
                        stage_01_complete, stage_02_complete, stage_03_complete, stage_04_complete, stage_05_complete, stage_06_complete, stage_07_complete

                };

                //
                playAudio(MISS);

                // Initial stage status - locked
                mStageReady = 1;

                // Test for ready
                if (stage_complete[mStageIndex - 1]) { mStageReady = 2; }

                mStageComplete = stage_complete[mStageIndex - 1];

                // Load images, audio, scores
                //loadStageProps(mStageIndex);

                // Switch stage card screen
                //startStageCard();
                // Switch to SCREEN(STAGE_CARD)
                switchScreen(R.id.stage_card_screen_main_layout);

                break;

            // Eaten - Exit
            case R.id.eaten_main_exit_image_button:
                Log.d(TAG, "onClick: eaten - exit");

                //
                playAudio(RUN);

                // Exit
                this.finish();

                break;

            // Eaten - Try Again
            case R.id.eaten_footer_try_again_image_button:
                Log.d(TAG, "onClick: eaten - try again");

                //
                loadStageProps(mStageIndex);
                startGame();

                break;

            // Eaten - Give up
            case R.id.eaten_footer_tutorial_image_button:
                Log.d(TAG, "onClick: eaten - give up");

                // Tutorial
                alertToggleTutorial();

                //
                playAudio(RUN);

                break;
        }
    }

    // Initiate game state
    public void startGame() {
        Log.d(TAG, "startGame: Start Game stage ");

        // Pause game
        mPauseGame = true;

        // Pass stage ID
        //mStageIndex = stage_index;

        // Switch boss layout with creature layout
        mGameBossLayout.setVisibility(View.GONE);
        mGameCreatureLayout.setVisibility(View.VISIBLE);
        mGameControlLayout.setVisibility(View.VISIBLE);

        // Increment stage attempts
        switch (mStageIndex) {

            //
            case 1:

                //
                ++stage_01_attempts;

                break;

            //
            case 2:

                //
                ++stage_02_attempts;

                break;

            //
            case 3:

                //
                ++stage_03_attempts;

                break;

            //
            case 4:

                //
                ++stage_04_attempts;

                break;

            //
            case 5:

                //
                ++stage_05_attempts;

                break;

            //
            case 6:

                //
                ++stage_06_attempts;

                break;

            //
            case 7:

                //
                ++stage_07_attempts;

                break;
        }

        // Reset variables
        resetVars();

        // Switch to game screen
        switchScreen(R.id.game_screen_main_layout);

        // Initial background
        switchEnvironment();

        // Play bg audio
        playAudio(BG_AUDIO);

        // Undo pause game
        mPauseGame = false;

        // Start runnable
        h2.postDelayed(r2, 1000);
        h4.postDelayed(r4, 1000);
    }

    // Game on
    private void gameOn() {
        Log.d(TAG, "gameOn:");

        // Score most calm
        if (mSpeedIndex > mStageMostCalm) { mStageMostCalm = mSpeedIndex; }

        // Score most frantic
        if (mSpeedIndex < mStageMostFrantic) { mStageMostFrantic = mSpeedIndex; }

        // Check timer end game if expired, if not increment game
        if (mHungerMeter > 0) {

            // Decrement hunger
            --mHungerMeter;

            // Score closest death
            if (mHungerMeter < mStageClosestDeath) { mStageClosestDeath = mHungerMeter; }

        } else {

            // Terminate game mode
            mCreatureGameOver = true;

            // Return
            return;
        }

        // Add stopwatch
        if (mHungerMeter < 10) {

            // Update stopwatch
            //updatePower06();
            updatePower(6);

            //
            ++mStageFrenzy;
            Log.d(TAG, "gameOn: mStageFrenzy : " + mStageFrenzy);

            // Score longest frenzy
            if (mStageFrenzy > mStageLongestFrenzy) { mStageLongestFrenzy = mStageFrenzy; }
            Log.d(TAG, "gameOn: mStageLongestFrenzy : " + mStageLongestFrenzy);

        } else {

            //
            mStageFrenzy = 0;
        }

        // Add heart
        //updatePower02();
        updatePower(2);

        // Update bolt
        //updatePower05();
        updatePower(5);

        // Update tunnel vision
        updateTunnel();

        // Decrement border fade
        if (mBorderBarrel > 0) {

            //
            --mBorderBarrel;
        }

        // Update border fade
        updateBorder();

        // Decrement tapper
        if (mTapCount > 1) {

            //
            --mTapCount;
        }

        // Update tapper
        updateTapper();

        // Play audio heartbeat
        playAudio(HEARTBEAT);

        // Play haptic heartbeat
        playHaptic();
    }

    // Update powers
    private void updatePower(int power) {

        //
        switch (power) {

            case 1:

                //
                ++mPower01Meter;

                break;

            case 2:

                //
                mPower02Meter = mPower02Meter + 5;

                break;

            //
            case 3:

                //
                ++mPower03Meter;

                break;

            //
            case 4:

                //
                ++mPower04Meter;

                break;

            //
            case 5:

                // Check speed index
                if (mSpeedIndex < 500) {

                    // Add bolt
                    ++mPower05Meter;
                }

                break;

            //
            case 6:

                //
                ++mPower06Meter;

                break;
        }
    }

    // Update power 1
    //private void updatePower01() {

        //
        //++mPower01Meter;
    //}

    // Update power 2
    //private void updatePower02() {

        //
        //mPower02Meter = mPower02Meter + 5;
    //}

    // Update power 3
    //private void updatePower03() {

        //
        //++mPower03Meter;
    //}

    // Update power 4
    //private void updatePower04() {

        //
        //++mPower04Meter;
    //}

    // Update power 5
    //private void updatePower05() {

        // Check speed index
        //if (mSpeedIndex < 500) {

            // Add bolt
            //++mPower05Meter;
        //}
    //}

    // Update power 6
    //private void updatePower06() {

        //
        //++mPower06Meter;
    //}

    // Hit sprite
    private void scorePoint() {

        // Ensure there is still time
        if (mHungerMeter <= 0) {

            //
            return;
        }

        //
        //updatePower01();
        updatePower(1);

        //
        //updatePower03();
        updatePower(3);

        // Increment hit counter
        ++mStageCreatureKills;

        // Check collection
        checkCreatureBox();

        //
        ++mTurn;

        // Accelerate timer
        double speedComponent = (mSpeedIndex * .0015);
        mSpeedIndex = mSpeedIndex + (long) speedComponent;

        //
        ++mHungerMeter;

        // Play bite noise
        playAudio(HIT);

        //
        if (mTapCount > 0 && mTapCount < 10
                ) {

            //
            playAudio(PINGS[mTapCount]);
        }

        // Reset bold image
        if (mHungerMeter < ALPHA_INDEX.length) {
            mGameTunnelVisionLayout.setAlpha((float) ALPHA_INDEX[mHungerMeter]);
        }
    }

    // Miss sprite
    private void missPoint() {

        // Ensure there is still time
        if (mHungerMeter <= 0) {

            //
            return;
        }

        //
        if (mTapCount > 3) {

            //
            playAudio(FLASH_BANG);

        } else {

            // Play miss noise
            playAudio(MISS);
        }

        //
        //updatePower04();
        updatePower(4);

        //
        ++mTurn;

        // Accelerate timer
        double speedComponent = (mSpeedIndex * .1);
        mSpeedIndex = mSpeedIndex - (long) speedComponent;
    }

    // Check creature box
    private void checkCreatureBox() {
        Log.d(TAG, "checkCreatureBox: Checking empty... ");

        // Check creature box is not empty
        if (!mStageCreatureBox.isEmpty()) {
            Log.d(TAG, "checkCreatureBox: Checking contains " + mCreatureID + "...");

            // Check if creature is already in box
            if (!mStageCreatureBox.contains(mStageCreatureID)) {
                Log.d(TAG, "checkCreatureBox: Adding creature " + mCreatureID + "...");

                // Add creature to box
                mStageCreatureBox.add(mStageCreatureID);
                buildCreatureCollection(mStageCreatureID, mStageCreatureBox.size());
            } else {
                Log.d(TAG, "checkCreatureBox: Looks like it's already there " + mCreatureID + "...");
            }
        } else {
            Log.d(TAG, "checkCreatureBox: Since it's empty, we'll start with " + mCreatureID + "...");
            // Add creature to box
            mStageCreatureBox.add(mStageCreatureID);
            buildCreatureCollection(mStageCreatureID, mStageCreatureBox.size());
        }
        // List contents of box
        for (int creature : mStageCreatureBox) {

            // Display
            Log.d(TAG, "checkCreatureBox: contains - " + creature + " - ");
        }
    }

    // Use power
    private void usePower(int power_meter, int power_target, int power_index) {

        //
        if (power_meter >= power_target) {

            //
            switch (power_index) {

                //
                case 1:

                    //
                    mPower01Meter = 0;
                    mPower01Target += 1;

                    //
                    ++mStagePredator;

                    //
                    setStage();

                    //
                    playAudio(ROAR);

                    break;

                case 2:

                    //
                    mPower02Meter = 0;
                    mPower02Target += 1;

                    // Accelerate timer
                    double speedComponent = (mSpeedIndex * .5);
                    mSpeedIndex = mSpeedIndex + (long) speedComponent;

                    //
                    playAudio(BREATH);

                    break;

                case 3:

                    //
                    mPower03Meter = 0;
                    mPower03Target += 1;

                    //
                    switchEnvironment();

                    //
                    playAudio(RUN);

                    break;

                case 4:

                    //
                    mPower04Meter = 0;
                    mPower04Target += 1;

                    //
                    mBorderBarrel = 19;

                    //
                    updateBorder();

                    //
                    playAudio(MISS);

                    break;

                case 5:

                    //
                    mPower05Meter = 0;
                    mPower05Target += 1;

                    //
                    if (!mPauseGame) {

                        // Inflate tapper
                        inflateTapper();
                        //h4.postDelayed(r4, 1000);

                        // Inflate tapper
                        inflateTapper();
                        //h4.postDelayed(r4, 1000);

                        // Inflate tapper
                        inflateTapper();
                        //h4.postDelayed(r4, 1000);

                        // Inflate tapper
                        inflateTapper();
                        //h4.postDelayed(r4, 1000);

                        // Inflate tapper
                        inflateTapper();
                        //h4.postDelayed(r4, 1000);

                        // Increment hit counter
                        //updatePower02();
                        updatePower(2);

                        //
                        ++mTurn;

                        // Play bite noise
                        playAudio(FRENZY);

                        // Accelerate timer
                        double speedComponentAlt = (mSpeedIndex * .25);
                        mSpeedIndex = mSpeedIndex + (long) speedComponentAlt;

                        // Regenerate creature
                        switchCreature(R.id.game_main_creature_01_image_button);
                        //h4.postDelayed(r4, 1000);

                        // Regenerate creature
                        switchCreature(R.id.game_main_creature_02_image_button);
                        //h4.postDelayed(r4, 1000);

                        // Regenerate creature
                        switchCreature(R.id.game_main_creature_03_image_button);
                        //h4.postDelayed(r4, 1000);

                        // Regenerate creature
                        switchCreature(R.id.game_main_creature_04_image_button);
                        //h4.postDelayed(r4, 1000);

                        // Regenerate creature
                        switchCreature(R.id.game_main_creature_05_image_button);
                        //h4.postDelayed(r4, 1000);
                    }

                    break;

                case 6:

                    //
                    mPower06Meter = 0;
                    mPower06Target += 1;

                    //
                    mPauseGame = true;
                    mPauseTimer = 10;

                    //
                    playAudio(FREEZE);

                    break;
            }

            // Housekeeping
            drawScreen();
        }
    }

    // Start boss
    private void startBoss() {
        Log.d(TAG, "startBoss: start boss");

        // Pause game
        mPauseGame = true;

        //
        mStageApex = true;
        mBossGameOver = false;

        //
        mBossHealth = 4;
        mHungerMeter = 10;

        //
        mGameBossLayout.setVisibility(View.VISIBLE);
        mGameCreatureLayout.setVisibility(View.GONE);
        mGameControlLayout.setVisibility(View.GONE);

        //
        mGameCreatureLayout.setVisibility(View.GONE);
        mGameCreature01ImageButton.setVisibility(View.GONE);
        mGameCreature02ImageButton.setVisibility(View.GONE);
        mGameCreature03ImageButton.setVisibility(View.GONE);
        mGameCreature04ImageButton.setVisibility(View.GONE);
        mGameCreature05ImageButton.setVisibility(View.GONE);

        //
        moveCreature(R.id.game_main_boss_image_button, R.id.game_main_pg_boss_canvas_layout);

        //
        mGameBossImageButton.setVisibility(View.VISIBLE);

        //
        drawScreen();

        // Undo pause game
        mPauseGame = false;

        // Run timer through executable task - background activities
        h3.postDelayed(r3, 1000);
    }

    // Attack boss
    private void attackBoss() {

        //
        mGameBossImageButton.setVisibility(View.INVISIBLE);

        //
        playAudio(ROAR);

        //
        if (mBossHealth > 0) {

            //
            --mBossHealth;

        } else {

            //
            mBossGameOver = true;
        }

        // Move boss
        if (!mBossGameOver) {

            //
            moveCreature(R.id.game_main_boss_image_button, R.id.game_main_pg_boss_canvas_layout);
        }

        //
        drawScreen();
    }

    // Kill boss
    private void killBoss()    {
        Log.d(TAG, "killBoss: kill boss");

        // Pause game
        mPauseGame = true;

        // Get time score
        mStageTime = mStageTimer;

        //
        mStageComplete = true;

        // Extract stage scores
        extractScores();
        
        // Set data
        setGameData();

        // Get data
        getGameData();

        // Built stage scores
        buildStageScores();

        // Load stage card
        mStageReady = 3;
        //startStageCard();
        // Switch to SCREEN(STAGE_CARD)
        switchScreen(R.id.stage_card_screen_main_layout);

        // Play audio
        playAudio(mGameTapAudio);

        // Undo pause game
        //mPauseGame = false;
    }

    // Extract stage scores
    private void extractScores() {
        
        //
        if (mStageIndex != -1) {
            Log.d(TAG, "extractScores: mStageIndex " + mStageIndex);

            // Switch stage case
            switch (mStageIndex) {

                // Forest
                case 1:

                    // Kill boss

                    ++stage_01_boss_kills;

                    // Stage complete
                    stage_01_complete = mStageComplete;

                    // Scores apex, predator, and accuracy
                    if (!stage_01_apex) { stage_01_apex = mStageApex; } // Replace if not already true, if it's false, it won't matter anyway.
                    
                    //
                    if (mStagePredator > stage_01_predator) { stage_01_predator = mStagePredator; } // Replace if better - maintain top scores at top
                    
                    //
                    mStageAccuracy = getPercentage(mTurn, mStageCreatureKills);
                    if (mStageAccuracy > stage_01_accuracy) { stage_01_accuracy = mStageAccuracy; } // Replace if better
                    Log.d(TAG, "extractScores: saved accuracy to mStageAccuracy and stage_01_accuracy : " + mStageAccuracy + " : " + stage_01_accuracy);

                    // Scores best time and total time
                    if (mStageTime < stage_01_best_time || stage_01_best_time == 0) { stage_01_best_time = mStageTime; } // Replace if better
                    stage_01_total_time += mStageTime; // This will accumulate regardless

                    // Scores creature kills and collection
                    stage_01_creature_kills += mStageCreatureKills; // This will accumulate regardless

                    //
                    mStageCollection = mStageCreatureBox.size();

                    //



                    //
                    if (mStageCollection > stage_01_collection) { stage_01_collection = mStageCollection; } // Need to parse this programmatically

                    // Top scores
                    if (mStageHighestStreak > stage_01_highest_streak) { stage_01_highest_streak = mStageHighestStreak; } // Replace if better
                    if (mStageClosestDeath < stage_01_closest_death) { stage_01_closest_death = mStageClosestDeath; } // Replace if better
                    if (mStageLongestFrenzy > stage_01_longest_frenzy) { stage_01_longest_frenzy = mStageLongestFrenzy; } // Replace if better
                    if (mStageMostCalm > stage_01_most_calm) { stage_01_most_calm = mStageMostCalm; } // Replace if better
                    if (mStageMostFrantic < stage_01_most_frantic) { stage_01_most_frantic = mStageMostFrantic; } // Replace if better

                    break;

                // Ocean
                case 2:

                    // Kill boss

                    ++stage_02_boss_kills;

                    // Stage complete
                    stage_02_complete = mStageComplete;

                    // Scores apex, predator, and accuracy
                    if (!stage_02_apex) { stage_02_apex = mStageApex; } // Replace if not already true, if it's false, it won't matter anyway.

                    //
                    if (mStagePredator > stage_02_predator) { stage_02_predator = mStagePredator; } // Replace if better - maintain top scores at top

                    //
                    mStageAccuracy = getPercentage(mTurn, mStageCreatureKills);
                    if (mStageAccuracy > stage_02_accuracy) { stage_02_accuracy = mStageAccuracy; } // Replace if better

                    // Scores best time and total time
                    if (mStageTime < stage_02_best_time || stage_02_best_time == 0) { stage_02_best_time = mStageTime; } // Replace if better
                    stage_02_total_time += mStageTime; // This will accumulate regardless


                    // Scores creature kills and collection
                    stage_02_creature_kills += mStageCreatureKills; // This will accumulate regardless

                    //
                    mStageCollection = mStageCreatureBox.size();
                    if (mStageCollection > stage_02_collection) { stage_02_collection = mStageCollection; } // Need to parse this programmatically

                    // Top scores
                    if (mStageHighestStreak > stage_02_highest_streak) { stage_02_highest_streak = mStageHighestStreak; } // Replace if better
                    if (mStageClosestDeath < stage_02_closest_death) { stage_02_closest_death = mStageClosestDeath; } // Replace if better
                    if (mStageLongestFrenzy > stage_02_longest_frenzy) { stage_02_longest_frenzy = mStageLongestFrenzy; } // Replace if better
                    if (mStageMostCalm > stage_02_most_calm) { stage_02_most_calm = mStageMostCalm; } // Replace if better
                    if (mStageMostFrantic < stage_02_most_frantic) { stage_02_most_frantic = mStageMostFrantic; } // Replace if better

                    break;

                // Mountain
                case 3:

                    // Kill boss

                    ++stage_03_boss_kills;

                    // Stage complete
                    stage_03_complete = mStageComplete;

                    // Scores apex, predator, and accuracy
                    if (!stage_03_apex) { stage_03_apex = mStageApex; } // Replace if not already true, if it's false, it won't matter anyway.

                    //
                    if (mStagePredator > stage_03_predator) { stage_03_predator = mStagePredator; } // Replace if better - maintain top scores at top

                    //
                    mStageAccuracy = getPercentage(mTurn, mStageCreatureKills);
                    if (mStageAccuracy > stage_03_accuracy) { stage_03_accuracy = mStageAccuracy; } // Replace if better

                    // Scores best time and total time
                    if (mStageTime < stage_03_best_time || stage_03_best_time == 0) { stage_03_best_time = mStageTime; } // Replace if better
                    stage_03_total_time += mStageTime; // This will accumulate regardless


                    // Scores creature kills and collection
                    stage_03_creature_kills += mStageCreatureKills; // This will accumulate regardless

                    //
                    mStageCollection = mStageCreatureBox.size();
                    if (mStageCollection > stage_03_collection) { stage_03_collection = mStageCollection; } // Need to parse this programmatically

                    // Top scores
                    if (mStageHighestStreak > stage_03_highest_streak) { stage_03_highest_streak = mStageHighestStreak; } // Replace if better
                    if (mStageClosestDeath < stage_03_closest_death) { stage_03_closest_death = mStageClosestDeath; } // Replace if better
                    if (mStageLongestFrenzy > stage_03_longest_frenzy) { stage_03_longest_frenzy = mStageLongestFrenzy; } // Replace if better
                    if (mStageMostCalm > stage_03_most_calm) { stage_03_most_calm = mStageMostCalm; } // Replace if better
                    if (mStageMostFrantic < stage_03_most_frantic) { stage_03_most_frantic = mStageMostFrantic; } // Replace if better

                    break;

                // Desert
                case 4:

                    // Kill boss

                    ++stage_04_boss_kills;

                    // Stage complete
                    stage_04_complete = mStageComplete;

                    // Scores apex, predator, and accuracy
                    if (!stage_04_apex) { stage_04_apex = mStageApex; } // Replace if not already true, if it's false, it won't matter anyway.

                    //
                    if (mStagePredator > stage_04_predator) { stage_04_predator = mStagePredator; } // Replace if better - maintain top scores at top

                    //
                    mStageAccuracy = getPercentage(mTurn, mStageCreatureKills);
                    if (mStageAccuracy > stage_04_accuracy) { stage_04_accuracy = mStageAccuracy; } // Replace if better

                    // Scores best time and total time
                    if (mStageTime < stage_04_best_time || stage_04_best_time == 0) { stage_04_best_time = mStageTime; } // Replace if better
                    stage_04_total_time += mStageTime; // This will accumulate regardless


                    // Scores creature kills and collection
                    stage_04_creature_kills += mStageCreatureKills; // This will accumulate regardless

                    //
                    mStageCollection = mStageCreatureBox.size();
                    if (mStageCollection > stage_04_collection) { stage_04_collection = mStageCollection; } // Need to parse this programmatically

                    // Top scores
                    if (mStageHighestStreak > stage_04_highest_streak) { stage_04_highest_streak = mStageHighestStreak; } // Replace if better
                    if (mStageClosestDeath < stage_04_closest_death) { stage_04_closest_death = mStageClosestDeath; } // Replace if better
                    if (mStageLongestFrenzy > stage_04_longest_frenzy) { stage_04_longest_frenzy = mStageLongestFrenzy; } // Replace if better
                    if (mStageMostCalm > stage_04_most_calm) { stage_04_most_calm = mStageMostCalm; } // Replace if better
                    if (mStageMostFrantic < stage_04_most_frantic) { stage_04_most_frantic = mStageMostFrantic; } // Replace if better

                    break;

                // Jungle
                case 5:

                    // Kill boss

                    ++stage_05_boss_kills;

                    // Stage complete
                    stage_05_complete = mStageComplete;

                    // Scores apex, predator, and accuracy
                    if (!stage_05_apex) { stage_05_apex = mStageApex; } // Replace if not already true, if it's false, it won't matter anyway.

                    //
                    if (mStagePredator > stage_05_predator) { stage_05_predator = mStagePredator; } // Replace if better - maintain top scores at top

                    //
                    mStageAccuracy = getPercentage(mTurn, mStageCreatureKills);
                    if (mStageAccuracy > stage_05_accuracy) { stage_05_accuracy = mStageAccuracy; } // Replace if better

                    // Scores best time and total time
                    if (mStageTime < stage_05_best_time || stage_05_best_time == 0) { stage_05_best_time = mStageTime; } // Replace if better
                    stage_05_total_time += mStageTime; // This will accumulate regardless


                    // Scores creature kills and collection
                    stage_05_creature_kills += mStageCreatureKills; // This will accumulate regardless

                    //
                    mStageCollection = mStageCreatureBox.size();
                    if (mStageCollection > stage_05_collection) { stage_05_collection = mStageCollection; } // Need to parse this programmatically

                    // Top scores
                    if (mStageHighestStreak > stage_05_highest_streak) { stage_05_highest_streak = mStageHighestStreak; } // Replace if better
                    if (mStageClosestDeath < stage_05_closest_death) { stage_05_closest_death = mStageClosestDeath; } // Replace if better
                    if (mStageLongestFrenzy > stage_05_longest_frenzy) { stage_05_longest_frenzy = mStageLongestFrenzy; } // Replace if better
                    if (mStageMostCalm > stage_05_most_calm) { stage_05_most_calm = mStageMostCalm; } // Replace if better
                    if (mStageMostFrantic < stage_05_most_frantic) { stage_05_most_frantic = mStageMostFrantic; } // Replace if better

                    break;

                // Tundra
                case 6:

                    // Kill boss

                    ++stage_06_boss_kills;

                    // Stage complete
                    stage_06_complete = mStageComplete;

                    // Scores apex, predator, and accuracy
                    if (!stage_06_apex) { stage_06_apex = mStageApex; } // Replace if not already true, if it's false, it won't matter anyway.

                    //
                    if (mStagePredator > stage_06_predator) { stage_06_predator = mStagePredator; } // Replace if better - maintain top scores at top

                    //
                    mStageAccuracy = getPercentage(mTurn, mStageCreatureKills);
                    if (mStageAccuracy > stage_06_accuracy) { stage_06_accuracy = mStageAccuracy; } // Replace if better

                    // Scores best time and total time
                    if (mStageTime < stage_06_best_time || stage_06_best_time == 0) { stage_06_best_time = mStageTime; } // Replace if better
                    stage_06_total_time += mStageTime; // This will accumulate regardless


                    // Scores creature kills and collection
                    stage_06_creature_kills += mStageCreatureKills; // This will accumulate regardless

                    //
                    mStageCollection = mStageCreatureBox.size();
                    if (mStageCollection > stage_06_collection) { stage_06_collection = mStageCollection; } // Need to parse this programmatically

                    // Top scores
                    if (mStageHighestStreak > stage_06_highest_streak) { stage_06_highest_streak = mStageHighestStreak; } // Replace if better
                    if (mStageClosestDeath < stage_06_closest_death) { stage_06_closest_death = mStageClosestDeath; } // Replace if better
                    if (mStageLongestFrenzy > stage_06_longest_frenzy) { stage_06_longest_frenzy = mStageLongestFrenzy; } // Replace if better
                    if (mStageMostCalm > stage_06_most_calm) { stage_06_most_calm = mStageMostCalm; } // Replace if better
                    if (mStageMostFrantic < stage_06_most_frantic) { stage_06_most_frantic = mStageMostFrantic; } // Replace if better

                    break;

                // Final
                case 7:

                    // Kill boss

                    ++stage_07_boss_kills;

                    // Stage complete
                    stage_07_complete = mStageComplete;

                    // Scores apex, predator, and accuracy
                    if (!stage_07_apex) { stage_07_apex = mStageApex; } // Replace if not already true, if it's false, it won't matter anyway.

                    //
                    if (mStagePredator > stage_07_predator) { stage_07_predator = mStagePredator; } // Replace if better - maintain top scores at top

                    //
                    mStageAccuracy = getPercentage(mTurn, mStageCreatureKills);
                    if (mStageAccuracy > stage_07_accuracy) { stage_07_accuracy = mStageAccuracy; } // Replace if better

                    // Scores best time and total time
                    if (mStageTime < stage_07_best_time || stage_07_best_time == 0) { stage_07_best_time = mStageTime; } // Replace if better
                    stage_07_total_time += mStageTime; // This will accumulate regardless


                    // Scores creature kills and collection
                    stage_07_creature_kills += mStageCreatureKills; // This will accumulate regardless

                    //
                    mStageCollection = mStageCreatureBox.size();
                    if (mStageCollection > stage_07_collection) { stage_07_collection = mStageCollection; } // Need to parse this programmatically

                    // Top scores
                    if (mStageHighestStreak > stage_07_highest_streak) { stage_07_highest_streak = mStageHighestStreak; } // Replace if better
                    if (mStageClosestDeath < stage_07_closest_death) { stage_07_closest_death = mStageClosestDeath; } // Replace if better
                    if (mStageLongestFrenzy > stage_07_longest_frenzy) { stage_07_longest_frenzy = mStageLongestFrenzy; } // Replace if better
                    if (mStageMostCalm > stage_07_most_calm) { stage_07_most_calm = mStageMostCalm; } // Replace if better
                    if (mStageMostFrantic < stage_07_most_frantic) { stage_07_most_frantic = mStageMostFrantic; } // Replace if better

                    break;
            }
        }
    }
    
    // Creature stage end
    private void creatureStageEnd() {
        Log.d(TAG, "creatureStageEnd: hunger is " + mHungerMeter);

        //
        if (mHungerMeter > 0) {
            Log.d(TAG, "creatureStageEnd: bing - startboss");

            //
            startBoss();

        } else {
            Log.d(TAG, "creatureStageEnd: bang - playereaten");

            //
            mGameCreatureLayout.setVisibility(View.GONE);
            mGameBossLayout.setVisibility(View.VISIBLE);

            //
            playerEaten();
        }
    }

    // Boss stage end
    private void bossStageEnd() {

        //
        if (mHungerMeter > 0) {

            //
            killBoss();

        } else {

            //
            playerEaten();
        }
    }

    // Reset game variables
    private void resetVars() {

        // Reset progress marker
        resetLevelMarkers();

        //
        mHungerMeter = 30;
        mSpeedIndex = 1000;
        //mStageAdvanceMeter = 0;
        //mStageAdvanceTarget = 1;

        //
        mStageFrenzy = 0;

        //
        mPower01Meter = 0;
        mPower01Target = 5;
        mPower02Meter = 0;
        mPower02Target = 20;
        mPower03Meter = 0;
        mPower03Target = 5;
        mPower04Meter = 0;
        mPower04Target = 3;
        mPower05Meter = 0;
        mPower05Target = 2;
        mPower06Meter = 0;
        mPower06Target = 2;

        //
        mTurn = 0;

        //
        mTapBarrel = 3;
        mTapCount = 0;
        mTapTotal = 0;

        //
        mBorderBarrel = 0;
        mPauseTimer = -1;
        mStageTimer = 0;
        mStageTime = 0;

        //
        mPauseGame = false;
        mCreatureGameOver = false;
        mBossGameOver = false;

        //
        mBossHealth = 0;

        //
        mStagePredator = 0;
        mStageAccuracy = 0f;

        //
        mStageCreatureKills = 0;
        mStageCollection = 0;
        mStageCreatureBox.clear();

        //
        mStageHighestStreak = 0;
        mStageClosestDeath = 30;
        mStageLongestFrenzy = 0;
        mStageMostCalm = 1000;
        mStageMostFrantic = 1000;
    }

    // Load / unload stage props
    public void loadStageProps(int stage_index) {
        Log.d(TAG, "loadStageProps: " + stage_index);

        // Load scene images and names
        mStageSceneImages.clear();
        //mStageSceneImages.add(android.R.color.transparent);
        mStageSceneNames.clear();

        // Ready stage creature collection array
        mStageCreatureBox.clear();

        //
        mStageCreatureID = -1;

        // Load stage scene images
        for (int scene : STAGE_SCENES[stage_index - 1]) {

            //
            mStageSceneImages.add(scene);
        }

        // Load scene names
        mStageSceneNames.addAll(Arrays.asList(STAGE_SCENE_NAMES[stage_index - 1]));

        // Assign stage color
        mGameSceneTextView.setBackgroundColor(STAGE_COLOR[stage_index - 1]);

        // Load stage name
        mGameStageImageView.setBackground(versionCheck(STAGE_NAMES[stage_index - 1]));

        // Load stage border image
        mGameBorderLayout.setBackground(versionCheck(STAGE_BORDERS[stage_index - 1]));

        // Load stage disaster image
        mStageDisasterImageView.setBackground(versionCheck(STAGE_DISASTERS[stage_index - 1]));

        // Load stage disaster audio
        mGameTapAudio = STAGE_DISASTER_AUDIO[stage_index - 1];

        // Load boss cry
        mGameBossCry = BOSS_CRY_AUDIO[stage_index - 1];

        // Load boss image button
        mGameBossImageButton.setBackground(versionCheck(BOSS_IMAGES[stage_index - 1]));

        // Load boss scene image
        mGameBossLayout.setBackground(versionCheck(BOSS_SCENE_IMAGES[stage_index - 1]));
    }

    // Reset saved game data
    public void clearGameData() {

        //
        SharedPreferences mUserPrefReset = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mUserPrefReset.edit();

        //
        mEditor.clear();
        mEditor.apply();

        //
        getGameData();
    }

    // UI navigation to hide and show layouts
    private void switchScreen(int mScreenID) {
        Log.d(TAG, "switchScreen: >" + mScreenID);

        // Show screen
        if (mScreenID != -1) {
            for (int id : SCREENS) {
                findViewById(id).setVisibility(mScreenID == id ? View.VISIBLE : View.GONE);
            }
        }

        // ID screen
        mCurScreen = mScreenID;

        // Draw screen
        drawScreen();

    }

    // Draw screen
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void drawScreen() {
        Log.d(TAG, "drawScreen: START " + mCurScreen);

        //
        setGameData();

        //
        getGameData();

        //
        mTopScores = false;

        //
        switch (mCurScreen) {

            //
            case R.id.credits_screen_main_layout:
                Log.d(TAG, "drawScreen: credit_screen " + mCurScreen);

                //
                mCreditsImageView.setVisibility(View.VISIBLE);

                break;

            //
            case R.id.entry_screen_main_layout:
                Log.d(TAG, "drawScreen: entry_screen " + mCurScreen);

                //
                mEntryMainControlLayout.setVisibility(View.VISIBLE);

                //
                if (continue_game) {

                    //
                    mEntryContinueImageButton.setVisibility(View.VISIBLE);

                } else {

                    //
                    mEntryContinueImageButton.setVisibility(View.GONE);
                }

                //
                if (game_complete) {

                    //
                    mEntryCreditsImageButton.setVisibility(View.VISIBLE);

                } else {

                    //
                    mEntryCreditsImageButton.setVisibility(View.GONE);
                }

                //
                if (mGameApex) {

                    //
                    mEntryScoreApexLayout.setVisibility(View.VISIBLE);

                } else {

                    //
                    mEntryScoreApexLayout.setVisibility(View.GONE);
                }

                break;

            case R.id.stage_select_screen_main_layout:
                Log.d(TAG, "drawScreen: stage_select " + mCurScreen);

                // Reset stage index
                mStageIndex = -1;
                mStageReady = -1;
                mStageApex = false;
                mStageComplete = false;

                // Reset scorecard display toggle
                mTopScores = false;

                // Reset scorecard display
                mStageSelectScorecardLayout.setVisibility(View.GONE);

                // Hide top scores if none
                if (!stage_01_complete) { mStageSelectScorecardImageButton.setVisibility(View.INVISIBLE); }
                else { mStageSelectScorecardImageButton.setVisibility(View.VISIBLE); }

                // Set game high scores
                if (mGameApex) { mEOBEApexScoreImageView.setVisibility(View.VISIBLE); }
                else { mEOBEApexScoreImageView.setVisibility(View.INVISIBLE); }

                //
                mEOBEPredatorScoreTextView.setText(Integer.toString(mGamePredator));
                mEOBEAccuracyScoreTextView.setText(String.format("%.2f", mGameAccuracy));

                //
                mEOBETimeBestScoreTextView.setText(Integer.toString(mGameTimeBest));
                mEOBETimeTotalScoreTextView.setText(Integer.toString(mGameTimeTotal));
                mEOBECollectionScoreTextView.setText(Integer.toString(mGameCollection));
                mEOBEAttemptsScoreTextView.setText(Integer.toString(mGameAttempts));
                mEOBEBossKillsScoreTextView.setText(Integer.toString(mGameBossKills));
                mEOBECreatureKillsScoreTextView.setText(Integer.toString(mGameCreatureKills));
                mEOBEHighestStreakScoreTextView.setText(Integer.toString(mGameHighestStreak));
                mEOBEClosestDeathScoreTextView.setText(Integer.toString(mGameClosestDeath));
                mEOBELongestFrenzyScoreTextView.setText(Integer.toString(mGameLongestFrenzy));
                mEOBEMostCalmScoreTextView.setText(Float.toString(mGameMostCalm));
                mEOBEMostFranticTextView.setText(Float.toString(mGameMostFrantic));

                // Build stage cards
                buildStageCards();

                // Display stage cards
                mStageSelectStagecardLayout.setVisibility(View.VISIBLE);

                break;

            case R.id.stage_card_screen_main_layout:
                Log.d(TAG, "drawScreen: mStageIndex: " + mStageIndex + " - mStageReady: " + mStageReady + " - mStageComplete: " + mStageComplete);

                if (mStageComplete) {

                    // Build scorecards
                    buildScorecard();
                }

                //
                mStageCardContentBossLayout.setBackground(versionCheck(STAGE_DISASTERS[mStageIndex - 1]));
                mStageCardBossImageView.setBackground(versionCheck(BOSS_IMAGES[mStageIndex - 1]));
                mStageCardContentTitleImageButton.setBackground(versionCheck(STAGE_NAMES[mStageIndex - 1]));
                mStageCardContentTitleLayout.setBackgroundColor(STAGE_COLOR[mStageIndex - 1]);
                mStageCardScreenBodyLayout.setBackground(versionCheck(STAGE_CARD_BG[mStageIndex - 1]));

                //
                mStageCardControlPrevImageButton.setVisibility(View.VISIBLE);
                mStageCardControlNextImageButton.setVisibility(View.VISIBLE);

                //
                switch (mStageIndex) {

                    case 1:

                        //
                        mStageCardControlPrevImageButton.setVisibility(View.INVISIBLE);

                        break;

                    case 7:

                        //
                        mStageCardControlNextImageButton.setVisibility(View.INVISIBLE);

                        break;
                }

                // [1 = Stage Locked / 2 = Stage Ready / 3 = Stage Complete]
                switch (mStageReady) {

                    // Case - Stage Locked
                    case 1:

                        //
                        mStageCardStatusImageView.setBackground(versionCheck(R.drawable.stage_locked_image));

                        //
                        mStageCardTopScoreImageButton.setVisibility(View.INVISIBLE);

                        //
                        mStageCardContentTitleLayout.setBackgroundColor(Color.BLACK);

                        //
                        mStageCardScorecardLayout.setVisibility(View.GONE);
                        mStageCardTopScoreLayout.setVisibility(View.GONE);

                        //
                        mStageCardContentBossLayout.setVisibility(View.GONE);

                        //
                        //findViewById(R.id.stage_card_scorecard_control_layout).setVisibility(View.GONE);
                        mStageCardControlNextImageButton.setVisibility(View.INVISIBLE);
                        mStageCardControlPlayImageButton.setVisibility(View.INVISIBLE);

                        break;

                    // Case - Stage Ready
                    case 2:

                        //
                        mStageCardStatusImageView.setBackground(versionCheck(R.drawable.stage_ready_image));

                        //
                        if (mStageComplete) {

                            //
                            mStageCardTopScoreImageButton.setVisibility(View.VISIBLE);

                        } else {

                            //
                            mStageCardTopScoreImageButton.setVisibility(View.INVISIBLE);
                        }

                        //
                        mStageCardScorecardLayout.setVisibility(View.INVISIBLE);
                        mStageCardTopScoreLayout.setVisibility(View.GONE);

                        //
                        mStageCardContentBossLayout.setVisibility(View.VISIBLE);

                        //
                        mStageCardControlPlayImageButton.setVisibility(View.VISIBLE);

                        //findViewById(R.id.stage_card_scorecard_control_layout).setVisibility(View.VISIBLE);
                        //findViewById(R.id.stage_card_ready_play_here_image_button).setVisibility(View.VISIBLE);
                        //mStageCardControlPrevImageButton.setVisibility(View.VISIBLE);
                        //mStageCardControlNextImageButton.setVisibility(View.VISIBLE);

                        //*inject*
                        mStageCardContentBossLayout.setVisibility(View.GONE);
                        findViewById(R.id.stage_card_collection_layout).setVisibility(View.VISIBLE);
                        //buildCreatureCollection();

                        break;

                    // Case - Stage Complete
                    case 3:

                        //
                        mStageCardStatusImageView.setBackground(versionCheck(R.drawable.stage_complete_image));

                        //
                        mStageCardTopScoreImageButton.setVisibility(View.VISIBLE);

                        //
                        mStageCardScorecardLayout.setVisibility(View.VISIBLE);
                        mStageCardTopScoreLayout.setVisibility(View.GONE);

                        //
                        mStageCardContentBossLayout.setVisibility(View.GONE);

                        //
                        //findViewById(R.id.stage_card_scorecard_control_layout).setVisibility(View.VISIBLE);
                        mStageCardControlPlayImageButton.setVisibility(View.VISIBLE);

                        if (mStageIndex == 7) { mStageCardControlNextImageButton.setVisibility(View.GONE); }
                        else { mStageCardControlNextImageButton.setVisibility(View.VISIBLE); }

                        //--move to stageReady 3 *duplicate* should remove
                        //mStageCardScorecardLayout.setVisibility(View.VISIBLE);
                        //mStageCardTopScoreLayout.setVisibility(View.GONE);
                        //mStageCardContentBossLayout.setVisibility(View.GONE);

                        //--move to stageReady 2, 3 with onClick
                        //mStageCardTopScoreLayout.setVisibility(View.VISIBLE);
                        //mStageCardScorecardLayout.setVisibility(View.GONE);
                        //mStageCardContentBossLayout.setVisibility(View.GONE);

                        break;
                }

                //
                switch (mStageIndex) {

                    // This is where we need to populate the text views

                    case 1:

                        //
                        if (stage_01_complete) {

                            //
                            mStageTopApexPredatorTextView.setText(Boolean.toString(stage_01_apex));

                            // Top Scores
                            mStageTotalAttemptsTextView.setText(Integer.toString(stage_01_attempts));
                            mStageTotalBossKillsTextView.setText(Integer.toString(stage_01_boss_kills));
                            mStageTotalCreatureKillsTextView.setText(Integer.toString(stage_01_creature_kills));
                            mStageTopHighestStreakTextView.setText(Integer.toString(stage_01_highest_streak));
                            mStageTopClosestDeathTextView.setText(Integer.toString(stage_01_closest_death));
                            mStageTopLongestFrenzyTextView.setText(Integer.toString(stage_01_longest_frenzy));
                            mStageTopMostCalmTextView.setText(Long.toString(stage_01_most_calm));
                            mStageTopMostFranticTextView.setText(Long.toString(stage_01_most_frantic));
                            mStageTotalTimeTextView.setText(Integer.toString(stage_01_total_time));
                            mStageTopBestTimeTextView.setText(Integer.toString(stage_01_best_time));
                            mStageTopPredatorTextView.setText(Integer.toString(stage_01_predator));
                            mStageTopAccuracyTextView.setText(String.format("%.2f", stage_01_accuracy));
                            mStageTotalCollectionTextView.setText(Integer.toString(stage_01_collection));

                            // Current Stage Scores
                            mStageApexPredatorTextView.setText(Boolean.toString(mStageApex));
                            mStagePredatorTextView.setText(Integer.toString(mStagePredator));
                            mStageAccuracyTextView.setText(String.format("%.2f", mStageAccuracy));

                            //
                            mStageTimeTextView.setText(Integer.toString(mStageTime));
                            mStageCreatureKillsTextView.setText(Integer.toString(mStageCreatureKills));
                            mStageCollectionTextView.setText(Integer.toString(mStageCollection));

                            //
                            mStageHighestStreakTextView.setText(Integer.toString(mStageHighestStreak));
                            mStageClosestDeathTextView.setText(Integer.toString(mStageClosestDeath));
                            mStageLongestFrenzyTextView.setText(Integer.toString(mStageLongestFrenzy));
                            mStageMostCalmTextView.setText(Long.toString(mStageMostCalm));
                            mStageMostFranticTextView.setText(Long.toString(mStageMostFrantic));

                        }

                        break;

                    case 2:

                        //
                        mStageTopApexPredatorTextView.setText(Boolean.toString(stage_02_apex));

                        // Top Scores
                        mStageTotalAttemptsTextView.setText(Integer.toString(stage_02_attempts));
                        mStageTotalBossKillsTextView.setText(Integer.toString(stage_02_boss_kills));
                        mStageTotalCreatureKillsTextView.setText(Integer.toString(stage_02_creature_kills));
                        mStageTopHighestStreakTextView.setText(Integer.toString(stage_02_highest_streak));
                        mStageTopClosestDeathTextView.setText(Integer.toString(stage_02_closest_death));
                        mStageTopLongestFrenzyTextView.setText(Integer.toString(stage_02_longest_frenzy));
                        mStageTopMostCalmTextView.setText(Long.toString(stage_02_most_calm));
                        mStageTopMostFranticTextView.setText(Long.toString(stage_02_most_frantic));
                        mStageTotalTimeTextView.setText(Integer.toString(stage_02_total_time));
                        mStageTopBestTimeTextView.setText(Integer.toString(stage_02_best_time));
                        mStageTopPredatorTextView.setText(Integer.toString(stage_02_predator));
                        mStageTopAccuracyTextView.setText(String.format("%.2f", stage_02_accuracy));
                        mStageTotalCollectionTextView.setText(Integer.toString(stage_02_collection));

                        // Current Stage Scores
                        mStageApexPredatorTextView.setText(Boolean.toString(mStageApex));
                        mStagePredatorTextView.setText(Integer.toString(mStagePredator));
                        mStageAccuracyTextView.setText(String.format("%.2f", mStageAccuracy));

                        //
                        mStageTimeTextView.setText(Integer.toString(mStageTime));
                        mStageCreatureKillsTextView.setText(Integer.toString(mStageCreatureKills));
                        mStageCollectionTextView.setText(Integer.toString(mStageCollection));

                        //
                        mStageHighestStreakTextView.setText(Integer.toString(mStageHighestStreak));
                        mStageClosestDeathTextView.setText(Integer.toString(mStageClosestDeath));
                        mStageLongestFrenzyTextView.setText(Integer.toString(mStageLongestFrenzy));
                        mStageMostCalmTextView.setText(Long.toString(mStageMostCalm));
                        mStageMostFranticTextView.setText(Long.toString(mStageMostFrantic));

                        break;

                    case 3:

                        //
                        mStageTopApexPredatorTextView.setText(Boolean.toString(stage_03_apex));

                        // Top Scores
                        mStageTotalAttemptsTextView.setText(Integer.toString(stage_03_attempts));
                        mStageTotalBossKillsTextView.setText(Integer.toString(stage_03_boss_kills));
                        mStageTotalCreatureKillsTextView.setText(Integer.toString(stage_03_creature_kills));
                        mStageTopHighestStreakTextView.setText(Integer.toString(stage_03_highest_streak));
                        mStageTopClosestDeathTextView.setText(Integer.toString(stage_03_closest_death));
                        mStageTopLongestFrenzyTextView.setText(Integer.toString(stage_03_longest_frenzy));
                        mStageTopMostCalmTextView.setText(Long.toString(stage_03_most_calm));
                        mStageTopMostFranticTextView.setText(Long.toString(stage_03_most_frantic));
                        mStageTotalTimeTextView.setText(Integer.toString(stage_03_total_time));
                        mStageTopBestTimeTextView.setText(Integer.toString(stage_03_best_time));
                        mStageTopPredatorTextView.setText(Integer.toString(stage_03_predator));
                        mStageTopAccuracyTextView.setText(String.format("%.2f", stage_03_accuracy));
                        mStageTotalCollectionTextView.setText(Integer.toString(stage_03_collection));

                        // Current Stage Scores
                        mStageApexPredatorTextView.setText(Boolean.toString(mStageApex));
                        mStagePredatorTextView.setText(Integer.toString(mStagePredator));
                        mStageAccuracyTextView.setText(String.format("%.2f", mStageAccuracy));

                        //
                        mStageTimeTextView.setText(Integer.toString(mStageTime));
                        mStageCreatureKillsTextView.setText(Integer.toString(mStageCreatureKills));
                        mStageCollectionTextView.setText(Integer.toString(mStageCollection));

                        //
                        mStageHighestStreakTextView.setText(Integer.toString(mStageHighestStreak));
                        mStageClosestDeathTextView.setText(Integer.toString(mStageClosestDeath));
                        mStageLongestFrenzyTextView.setText(Integer.toString(mStageLongestFrenzy));
                        mStageMostCalmTextView.setText(Long.toString(mStageMostCalm));
                        mStageMostFranticTextView.setText(Long.toString(mStageMostFrantic));

                        break;

                    case 4:

                        //
                        mStageTopApexPredatorTextView.setText(Boolean.toString(stage_04_apex));

                        // Top Scores
                        mStageTotalAttemptsTextView.setText(Integer.toString(stage_04_attempts));
                        mStageTotalBossKillsTextView.setText(Integer.toString(stage_04_boss_kills));
                        mStageTotalCreatureKillsTextView.setText(Integer.toString(stage_04_creature_kills));
                        mStageTopHighestStreakTextView.setText(Integer.toString(stage_04_highest_streak));
                        mStageTopClosestDeathTextView.setText(Integer.toString(stage_04_closest_death));
                        mStageTopLongestFrenzyTextView.setText(Integer.toString(stage_04_longest_frenzy));
                        mStageTopMostCalmTextView.setText(Long.toString(stage_04_most_calm));
                        mStageTopMostFranticTextView.setText(Long.toString(stage_04_most_frantic));
                        mStageTotalTimeTextView.setText(Integer.toString(stage_04_total_time));
                        mStageTopBestTimeTextView.setText(Integer.toString(stage_04_best_time));
                        mStageTopPredatorTextView.setText(Integer.toString(stage_04_predator));
                        mStageTopAccuracyTextView.setText(String.format("%.2f", stage_04_accuracy));
                        mStageTotalCollectionTextView.setText(Integer.toString(stage_04_collection));

                        // Current Stage Scores
                        mStageApexPredatorTextView.setText(Boolean.toString(mStageApex));
                        mStagePredatorTextView.setText(Integer.toString(mStagePredator));
                        mStageAccuracyTextView.setText(String.format("%.2f", mStageAccuracy));

                        //
                        mStageTimeTextView.setText(Integer.toString(mStageTime));
                        mStageCreatureKillsTextView.setText(Integer.toString(mStageCreatureKills));
                        mStageCollectionTextView.setText(Integer.toString(mStageCollection));

                        //
                        mStageHighestStreakTextView.setText(Integer.toString(mStageHighestStreak));
                        mStageClosestDeathTextView.setText(Integer.toString(mStageClosestDeath));
                        mStageLongestFrenzyTextView.setText(Integer.toString(mStageLongestFrenzy));
                        mStageMostCalmTextView.setText(Long.toString(mStageMostCalm));
                        mStageMostFranticTextView.setText(Long.toString(mStageMostFrantic));

                        break;

                    case 5:

                        //
                        mStageTopApexPredatorTextView.setText(Boolean.toString(stage_05_apex));

                        // Top Scores
                        mStageTotalAttemptsTextView.setText(Integer.toString(stage_05_attempts));
                        mStageTotalBossKillsTextView.setText(Integer.toString(stage_05_boss_kills));
                        mStageTotalCreatureKillsTextView.setText(Integer.toString(stage_05_creature_kills));
                        mStageTopHighestStreakTextView.setText(Integer.toString(stage_05_highest_streak));
                        mStageTopClosestDeathTextView.setText(Integer.toString(stage_05_closest_death));
                        mStageTopLongestFrenzyTextView.setText(Integer.toString(stage_05_longest_frenzy));
                        mStageTopMostCalmTextView.setText(Long.toString(stage_05_most_calm));
                        mStageTopMostFranticTextView.setText(Long.toString(stage_05_most_frantic));
                        mStageTotalTimeTextView.setText(Integer.toString(stage_05_total_time));
                        mStageTopBestTimeTextView.setText(Integer.toString(stage_05_best_time));
                        mStageTopPredatorTextView.setText(Integer.toString(stage_05_predator));
                        mStageTopAccuracyTextView.setText(String.format("%.2f", stage_05_accuracy));
                        mStageTotalCollectionTextView.setText(Integer.toString(stage_05_collection));

                        // Current Stage Scores
                        mStageApexPredatorTextView.setText(Boolean.toString(mStageApex));
                        mStagePredatorTextView.setText(Integer.toString(mStagePredator));
                        mStageAccuracyTextView.setText(String.format("%.2f", mStageAccuracy));

                        //
                        mStageTimeTextView.setText(Integer.toString(mStageTime));
                        mStageCreatureKillsTextView.setText(Integer.toString(mStageCreatureKills));
                        mStageCollectionTextView.setText(Integer.toString(mStageCollection));

                        //
                        mStageHighestStreakTextView.setText(Integer.toString(mStageHighestStreak));
                        mStageClosestDeathTextView.setText(Integer.toString(mStageClosestDeath));
                        mStageLongestFrenzyTextView.setText(Integer.toString(mStageLongestFrenzy));
                        mStageMostCalmTextView.setText(Long.toString(mStageMostCalm));
                        mStageMostFranticTextView.setText(Long.toString(mStageMostFrantic));

                        break;

                    case 6:

                        //
                        mStageTopApexPredatorTextView.setText(Boolean.toString(stage_06_apex));

                        // Top Scores
                        mStageTotalAttemptsTextView.setText(Integer.toString(stage_06_attempts));
                        mStageTotalBossKillsTextView.setText(Integer.toString(stage_06_boss_kills));
                        mStageTotalCreatureKillsTextView.setText(Integer.toString(stage_06_creature_kills));
                        mStageTopHighestStreakTextView.setText(Integer.toString(stage_06_highest_streak));
                        mStageTopClosestDeathTextView.setText(Integer.toString(stage_06_closest_death));
                        mStageTopLongestFrenzyTextView.setText(Integer.toString(stage_06_longest_frenzy));
                        mStageTopMostCalmTextView.setText(Long.toString(stage_06_most_calm));
                        mStageTopMostFranticTextView.setText(Long.toString(stage_06_most_frantic));
                        mStageTotalTimeTextView.setText(Integer.toString(stage_06_total_time));
                        mStageTopBestTimeTextView.setText(Integer.toString(stage_06_best_time));
                        mStageTopPredatorTextView.setText(Integer.toString(stage_06_predator));
                        mStageTopAccuracyTextView.setText(String.format("%.2f", stage_06_accuracy));
                        mStageTotalCollectionTextView.setText(Integer.toString(stage_06_collection));

                        // Current Stage Scores
                        mStageApexPredatorTextView.setText(Boolean.toString(mStageApex));
                        mStagePredatorTextView.setText(Integer.toString(mStagePredator));
                        mStageAccuracyTextView.setText(String.format("%.2f", mStageAccuracy));

                        //
                        mStageTimeTextView.setText(Integer.toString(mStageTime));
                        mStageCreatureKillsTextView.setText(Integer.toString(mStageCreatureKills));
                        mStageCollectionTextView.setText(Integer.toString(mStageCollection));

                        //
                        mStageHighestStreakTextView.setText(Integer.toString(mStageHighestStreak));
                        mStageClosestDeathTextView.setText(Integer.toString(mStageClosestDeath));
                        mStageLongestFrenzyTextView.setText(Integer.toString(mStageLongestFrenzy));
                        mStageMostCalmTextView.setText(Long.toString(mStageMostCalm));
                        mStageMostFranticTextView.setText(Long.toString(mStageMostFrantic));

                        break;

                    case 7:

                        //
                        mStageTopApexPredatorTextView.setText(Boolean.toString(stage_07_apex));

                        // Top Scores
                        mStageTotalAttemptsTextView.setText(Integer.toString(stage_07_attempts));
                        mStageTotalBossKillsTextView.setText(Integer.toString(stage_07_boss_kills));
                        mStageTotalCreatureKillsTextView.setText(Integer.toString(stage_07_creature_kills));
                        mStageTopHighestStreakTextView.setText(Integer.toString(stage_07_highest_streak));
                        mStageTopClosestDeathTextView.setText(Integer.toString(stage_07_closest_death));
                        mStageTopLongestFrenzyTextView.setText(Integer.toString(stage_07_longest_frenzy));
                        mStageTopMostCalmTextView.setText(Long.toString(stage_07_most_calm));
                        mStageTopMostFranticTextView.setText(Long.toString(stage_07_most_frantic));
                        mStageTotalTimeTextView.setText(Integer.toString(stage_07_total_time));
                        mStageTopBestTimeTextView.setText(Integer.toString(stage_07_best_time));
                        mStageTopPredatorTextView.setText(Integer.toString(stage_07_predator));
                        mStageTopAccuracyTextView.setText(String.format("%.2f", stage_07_accuracy));
                        mStageTotalCollectionTextView.setText(Integer.toString(stage_07_collection));

                        // Current Stage Scores
                        mStageApexPredatorTextView.setText(Boolean.toString(mStageApex));
                        mStagePredatorTextView.setText(Integer.toString(mStagePredator));
                        mStageAccuracyTextView.setText(String.format("%.2f", mStageAccuracy));

                        //
                        mStageTimeTextView.setText(Integer.toString(mStageTime));
                        mStageCreatureKillsTextView.setText(Integer.toString(mStageCreatureKills));
                        mStageCollectionTextView.setText(Integer.toString(mStageCollection));

                        //
                        mStageHighestStreakTextView.setText(Integer.toString(mStageHighestStreak));
                        mStageClosestDeathTextView.setText(Integer.toString(mStageClosestDeath));
                        mStageLongestFrenzyTextView.setText(Integer.toString(mStageLongestFrenzy));
                        mStageMostCalmTextView.setText(Long.toString(mStageMostCalm));
                        mStageMostFranticTextView.setText(Long.toString(mStageMostFrantic));

                        break;
                }

                break;

            //
            case R.id.game_screen_main_layout:
                Log.d(TAG, "drawScreen: > game_screen " + mCurScreen);

                //
                //checkPlayground();

                // Check power display
                checkPowers();

                // Check tunnel view fade
                updateTunnel();

                // Check border view fade
                updateBorder();

                // Check tap fade
                updateTapper();

                break;

            //
            case R.id.eaten_screen_main_layout:
                Log.d(TAG, "drawScreen: eaten_screen " + mCurScreen);

                //
                mEatenStageNameTextView.setBackground(versionCheck(STAGE_NAMES[mStageIndex - 1]));
                mEatenStageTimeTextView.setText(Integer.toString(mStageTime));

                // Extract stage and time scores *duplicate* should remove
                //mEatenStageNameTextView.setBackground(versionCheck(STAGE_NAMES[mStageIndex - 1]));
                //mEatenStageTimeTextView.setText(Integer.toString(mStageTime));

                //
                mEatenMainTitleImageView.setVisibility(View.VISIBLE);
                mEatenSubTitleLayout.setVisibility(View.VISIBLE);
                fadeIn(R.id.eaten_main_title_image_view);

                break;
        }
    }

    // Check playground mode *redundant* should remove
    //public void checkPlayground() {
        //Log.d(TAG, "checkPlayground: checking...");

        //
        //if (!mCreatureGameOver) {

            //
            //mGameBossLayout.setVisibility(View.GONE);
            //mGameCreatureLayout.setVisibility(View.VISIBLE);
            //mGameControlLayout.setVisibility(View.VISIBLE);
            //mGameLevelMarkerLayout.setVisibility(View.VISIBLE);
            //mGamePowersLayout.setVisibility(View.VISIBLE);

        //} else {

            //
            //mGameBossLayout.setVisibility(View.VISIBLE);
            //mGameCreatureLayout.setVisibility(View.GONE);
            //mGameControlLayout.setVisibility(View.GONE);
            //mGameLevelMarkerLayout.setVisibility(View.GONE);
            //mGamePowersLayout.setVisibility(View.GONE);
        //}
    //}

    // Check power display
    public void checkPowers() {

        // Power 1
        if (mPower01Meter > mPower01Target) { mGamePower01ImageView.setVisibility(View.VISIBLE); }
        else { mGamePower01ImageView.setVisibility(View.INVISIBLE); }

        // Power 2
        if (stage_01_complete) {

            //
            if (mPower02Meter > mPower02Target) { mGamePower02ImageView.setVisibility(View.VISIBLE); }
            else { mGamePower02ImageView.setVisibility(View.INVISIBLE); }

        } else { mGamePower02ImageView.setVisibility(View.GONE); }

        // Power 3
        if (stage_02_complete) {

            if (mPower03Meter > mPower03Target) {

                mGamePower03ImageView.setVisibility(View.VISIBLE);

            } else {

                mGamePower03ImageView.setVisibility(View.INVISIBLE);
            }

        } else { mGamePower03ImageView.setVisibility(View.GONE); }

        // Power 4
        if (stage_03_complete) {

            if (mPower04Meter > mPower04Target) {

                mGamePower04ImageView.setVisibility(View.VISIBLE);

            } else {

                mGamePower04ImageView.setVisibility(View.INVISIBLE);
            }

        } else { mGamePower04ImageView.setVisibility(View.GONE); }

        // Power 5
        if (stage_04_complete) {

            if (mPower05Meter > mPower05Target) {

                mGamePower05ImageView.setVisibility(View.VISIBLE);

            } else {

                mGamePower05ImageView.setVisibility(View.INVISIBLE);
            }

        } else { mGamePower05ImageView.setVisibility(View.GONE); }

        // Power 6
        if (stage_05_complete) {

            if (mPower06Meter > mPower06Target) {

                mGamePower06ImageView.setVisibility(View.VISIBLE);

            } else {

                mGamePower06ImageView.setVisibility(View.INVISIBLE);
            }

        } else { mGamePower06ImageView.setVisibility(View.GONE); }
    }

    // Build stage cards
    public void buildStageCards() {

        //
        boolean[] stage_complete = {

                //
                stage_01_complete, stage_02_complete, stage_03_complete, stage_04_complete, stage_05_complete, stage_06_complete, stage_07_complete
        };

        //
        int i = 0;

        // Set stage card bg
        for (int card : STAGE_PROP_CARDS) {

            //
            findViewById(card).setBackground(versionCheck(STAGE_PROP_CARD_BG[i]));

            //
            ++i;
        }

        //
        i = 0;

        // Set stage card titles
        for (int card_title : STAGE_PROP_CARD_TITLES) {

            //
            findViewById(card_title).setBackground(versionCheck(STAGE_PROP_TITLE_IMAGES[i]));

            //
            ++i;
        }

        //
        i = 0;

        // Set stage status
        for (int card_status : STAGE_PROP_CARD_STATUS) {

            //
            findViewById(card_status).setBackground(versionCheck(R.drawable.stage_ready_image));

            //
            if (i > 0 && !stage_complete[i - 1]) {

                //
                findViewById(card_status).setBackground(versionCheck(R.drawable.stage_locked_image));
            }

            //
            if (stage_complete[i]) {

                //
                findViewById(card_status).setBackground(versionCheck(R.drawable.stage_complete_image));
            }

            //
            ++i;
        }

        //
        i = 0;

        // Set stage icon
        for (int card_icon : STAGE_PROP_CARD_ICONS) {

            //
            findViewById(card_icon).setBackground(versionCheck(R.drawable.stage_select_icon_ready));

            //
            if (stage_complete[i]) {

                //
                findViewById(card_icon).setBackground(versionCheck(R.drawable.stage_select_icon_complete));

            }

            //
            if (i > 0 && !stage_complete[i - 1]) {

                //
                findViewById(card_icon).setBackground(versionCheck(R.drawable.stage_select_icon_lock));
            }

            //
            ++i;
        }
    }

	// Randomly select new background image
	private void switchEnvironment() {
        Log.d(TAG, "switchEnvironment:");

        //
        if (!mStageSceneImages.isEmpty()) {

            //
            setStage();

            //
            resetTapper();

            //
            resetBorder();

            //
            resetTunnel();

            // Random selection from array
            Random r = new Random();

            //
            mEnvironmentID = mStageSceneImages.get(r.nextInt(mStageSceneImages.size()));
            String mSceneID = mStageSceneNames.get(mStageSceneImages.indexOf(mEnvironmentID));

            //
            Drawable mEnvironmentDrawable;

            //
            mEnvironmentDrawable = versionCheck(mEnvironmentID);
            mGameCreatureLayout.setBackground(mEnvironmentDrawable);
            mGameSceneTextView.setText(mSceneID);
        }
    }

    // Remove images and names from arrays
    private void removeBG() {

        //
        if (!mStageSceneImages.isEmpty()) {

            //
            mStageSceneImages.remove(mStageSceneImages.indexOf(mEnvironmentID));
            //mStageSceneNames.remove(mStageSceneNames.indexOf(mEnvironmentID));
        }
    }

    // Reset tunnel
    private void resetTunnel() {

        // Reset tunnel meter
        mHungerMeter = 30;
        mSpeedIndex = 1000;

        // Update tunnel image
        updateTunnel();
    }

    // Reset border
    private void resetBorder() {

        // Reset border meter
        mBorderBarrel = 19;

        // Update border image
        updateBorder();
    }

    // Reset tap meter
    public void resetTapper() {

        //
        mTapCount = 0;

        //
        mStageDisasterImageView.setAlpha((float) 0);

        //
        //mStageAdvanceMeter = 0;

        // Update tap image
        updateTapper();
    }

    // Update tunnel
    private void updateTunnel() {

        //
        if (mHungerMeter < ALPHA_INDEX.length) {

            //
            double tunnel_alpha = ALPHA_INDEX[mHungerMeter];
            mGameTunnelVisionLayout.setAlpha((float) tunnel_alpha);

        } else {

            //
            mGameTunnelVisionLayout.setAlpha(0);

            //
            mStageFrenzy = 0;
        }
    }

    // Update border
    private void updateBorder() {

        mGameBorderLayout.setVisibility(View.VISIBLE);

        //
        if (mBorderBarrel < ALPHA_INDEX.length) {

            //
            double border_alpha = ALPHA_INDEX[mBorderBarrel];
            mGameBorderLayout.setAlpha((float) border_alpha);

        } else {

            //
            mGameBorderLayout.setAlpha(0);
        }
    }

    // Update tapper
    private void updateTapper() {

        //
        if (mTapCount < mTapBarrel) {

            // Adjust view visibility
            mGameScenePrevImageButton.setVisibility(View.INVISIBLE);
            mGameSceneNextImageButton.setVisibility(View.INVISIBLE);
            mGameSceneImageView.setBackgroundColor(getResources().getColor(R.color.color_palette_fade_05));
        }

        // Check valid tap
        if (mTapCount < ALPHA_INDEX_INVERSE.length) {

            // Adjust alpha on disaster image
            double tap_alpha = ALPHA_INDEX_INVERSE[mTapCount];
            mStageDisasterImageView.setVisibility(View.VISIBLE);
            mStageDisasterImageView.setAlpha((float) tap_alpha);

        } else {

            // Fill alpha on disaster image
            mStageDisasterImageView.setVisibility(View.VISIBLE);
            mStageDisasterImageView.setAlpha((float) 1);
        }
    }

    // Inflate tapper
    public void inflateTapper() {

        // Inflate tap variable
        ++mTapCount;

        // Score highest streak
        if (mTapCount >= mStageHighestStreak || mStageHighestStreak == 0) { mStageHighestStreak = mTapCount; }

        // Check target
        if (mTapCount >= mTapBarrel) {

            // Adjust view visibility
            mStageDisasterImageView.setVisibility(View.VISIBLE);
            //findViewById(R.id.game_main_stage_advance_image_view).setVisibility(View.VISIBLE);
            //mGamePowersLayout.setVisibility(View.GONE);

            // Adjust view visibility
            mGameScenePrevImageButton.setVisibility(View.VISIBLE);
            mGameSceneNextImageButton.setVisibility(View.VISIBLE);
            mGameSceneImageView.setBackgroundColor(getResources().getColor(R.color.color_palette_fade_01));

            // Play audio
            playAudio(BAMBOO_CLICK);

        } else {

            // Adjust view visibility
            findViewById(R.id.game_main_stage_advance_image_view).setVisibility(View.INVISIBLE);
            mGamePowersLayout.setVisibility(View.VISIBLE);

            // Adjust view visibility
            mGameScenePrevImageButton.setVisibility(View.INVISIBLE);
            mGameSceneNextImageButton.setVisibility(View.INVISIBLE);

            // Play audio
            playAudio(PINGS[0]);

        }

        // Update bolt, whirlpool, etc.
        if (mTapCount < ALPHA_INDEX_INVERSE.length) { updateTapper(); }
    }

    // Advance to next bg
    private void tapOut() {

        // Pause game
        mPauseGame = true;

        // Stage progress
        ++mTapTotal;

        //
        //mStageAdvanceMeter = 0;

        //
        if (mStageSceneImages.isEmpty()) {

            // Start boss
            mCreatureGameOver = true;

        } else {

            //
            switchEnvironment();

            //
            removeBG();

            //
            mGameLevelMarkerImageView.setBackground(versionCheck(LEVEL_MARKERS[mTapTotal]));
            mGameLevelMarkerLayout.setVisibility(View.VISIBLE);
            mGamePowersLayout.setVisibility(View.VISIBLE);
        }

        //
        playAudio(mGameTapAudio);

        // Undo pause game
        mPauseGame = false;
    }

    // Switch stage cards
    private void switchStageCard(int mode) {

        boolean[] stage_complete = {

                stage_01_complete, stage_02_complete, stage_03_complete, stage_04_complete, stage_05_complete, stage_06_complete, stage_07_complete
        };

        //
        resetCreatureCollection();

        //
        switch (mode) {

            //
            case 0:

                //
                if (mStageIndex != 1) {

                    //
                    --mStageIndex;
                    mStageApex = false;

                    // Check stage complete
                    if (mStageIndex != 1) {

                        // Initial stage status - locked
                        mStageReady = 1;

                        // Test for ready - *not needed*
                        if (stage_complete[mStageIndex - 2]) {

                            Log.d(TAG, "switchStageCard: previous stage complete : " );

                            //
                            mStageReady = 2;
                        }
                    } else {

                        //
                        mStageReady = 2;
                    }

                    Log.d(TAG, "switchStageCard: mStageReady : " + mStageReady);

                    //
                    mStageComplete = stage_complete[mStageIndex - 1];

                    Log.d(TAG, "switchStageCard: mStageComplete : " + mStageComplete);

                    // Load images, audio, scores
                    loadStageProps(mStageIndex);

                    // Switch stage card screen
                    //startStageCard();
                    // Switch to SCREEN(STAGE_CARD)
                    switchScreen(R.id.stage_card_screen_main_layout);
                }

                break;

            //
            case 1:

                //
                if (mStageIndex != 7) {

                    //
                    ++mStageIndex;
                    mStageApex = false;

                    // Initial stage status - locked
                    mStageReady = 1;

                    // Test for ready
                    if (stage_complete[mStageIndex - 2]) {

                        //
                        mStageReady = 2;
                    }

                    Log.d(TAG, "switchStageCard: mStageReady : " + mStageReady);

                    // Check stage complete
                    mStageComplete = stage_complete[mStageIndex - 1];

                    Log.d(TAG, "switchStageCard: mStageComplete : " + mStageComplete);

                    // Load images, audio, scores
                    loadStageProps(mStageIndex);

                    // Switch stage card screen
                    //startStageCard();
                    // Switch to SCREEN(STAGE_CARD)
                    switchScreen(R.id.stage_card_screen_main_layout);
                }

                break;
        }
    }

	// Randomly select and position sprites
	private void switchCreature(int creature) {

        // Random selection from array
        Random r = new Random();

        // Array of images
        mCreatureID = CREATURES[r.nextInt(32)];
        Drawable mCreatureDrawable;

        // Return drawable
        mCreatureDrawable = versionCheck(mCreatureID);

        // Move creature
        moveCreature(creature, R.id.game_main_pg_creature_canvas_layout);

        // Attach random background
        findViewById(creature).setBackground(mCreatureDrawable);
    }

    // Move creature
    private void moveCreature(int creature, int canvas) {

        // Hide creature
        findViewById(creature).setVisibility(View.INVISIBLE);

        //
        Random r = new Random();

        // Declare floats
        float dx = findViewById(canvas).getWidth();
        float dy = findViewById(canvas).getHeight();

        // Randomize
        float dxRand = r.nextFloat() * dx;
        float dyRand = r.nextFloat() * dy;

        // Constraints
        if (dxRand < 52) {
            dxRand = 128;
        }
        if (dyRand < 52) {
            dyRand = 128;
        }

        // Declare floats
        float dxFinal = dxRand - 64;
        float dyFinal = dyRand - 64;

        // Assign random position based on device screen size
        findViewById(creature).setX((dxFinal));
        findViewById(creature).setY((dyFinal));

        // Restore visibility
        findViewById(creature).setVisibility(View.VISIBLE);

        //
        animateCreature(creature);
    }

	// Initial creature spread
	private void setStage() {

        //
        for (int creature : CREATURE_BUTTONS) {

            //
            switchCreature(creature);

            //
            switch (creature) {

                //
                case R.id.game_main_creature_01_image_button:

                    //
                    mStageCreature01ID = mCreatureID;

                    break;

                //
                case R.id.game_main_creature_02_image_button:

                    //
                    mStageCreature02ID = mCreatureID;

                    break;

                //
                case R.id.game_main_creature_03_image_button:

                    //
                    mStageCreature03ID = mCreatureID;

                    break;

                //
                case R.id.game_main_creature_04_image_button:

                    //
                    mStageCreature04ID = mCreatureID;

                    break;

                //
                case R.id.game_main_creature_05_image_button:

                    //
                    mStageCreature05ID = mCreatureID;

                    break;
            }
        }
    }

    // Creature animation
    private void animateCreature(int v) {

        //
        ImageView creatureImage = findViewById(v);
        Animation creatureAnimation = AnimationUtils.loadAnimation(this, R.anim.creature_jump);
        creatureAnimation.setFillAfter(true);
        creatureImage.startAnimation(creatureAnimation);
    }

    // Fade in
    private void fadeIn(int v) {

        //
        View screenImage = findViewById(v);
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeAnimation.setFillAfter(true);
        screenImage.startAnimation(fadeAnimation);
    }

    //
    private void fadeInObj(int v) {

        //
        LinearLayout screenImage = findViewById(v);
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in_obj);
        fadeAnimation.setFillAfter(true);
        screenImage.startAnimation(fadeAnimation);
    }

    // Fade titles
    private void fadeTitles(int v) {

        //
        ImageView screenImage = findViewById(v);
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_titles);
        fadeAnimation.setFillAfter(true);
        screenImage.startAnimation(fadeAnimation);
    }

    // Dialog to reset game
    private void alertNewGame() {

        // Pause game
        mPauseGame = true;

        // Create dialog
        AlertDialog.Builder restartBuilder = new AlertDialog.Builder(this);

        // Set titles
        restartBuilder.setCancelable(false);
        restartBuilder.setTitle("Start New Game");
        restartBuilder.setMessage("This will erase all previous game data.");

        // Set negative button
        restartBuilder.setNegativeButton("No Way", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //
                dialogInterface.cancel();

                //
                playAudio(MISS);

                //
                mPauseGame = false;
            }
        });

        // Set positive button
        restartBuilder.setPositiveButton("Yeah", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                // Reset saved data
                clearGameData();

                // Start game - stage select
                switchScreen(R.id.stage_select_screen_main_layout);

                //
                playAudio(ROAR);

                //
                mPauseGame = false;
            }
        });

        // Display
        restartBuilder.show();

        //
        playAudio(CROW_AUDIO);
    }

    // Dialog to toggle tutorial
    private void alertToggleTutorial() {

        // Pause game
        mPauseGame = true;

        // Create dialog
        AlertDialog.Builder tutorialBuilder = new AlertDialog.Builder(this);

        // Set title
        tutorialBuilder.setCancelable(false);
        tutorialBuilder.setTitle("Toggle Tutorial");
        tutorialBuilder.setMessage("Continue tutorial mode?");

        //Pass checked state
        boolean[] mToggle = { play_tutorial };

        // Setup checkbox
        tutorialBuilder.setMultiChoiceItems(R.array.tutorial, mToggle, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                //
                switch (i) {

                    //
                    case 0:

                        // Assign boolean value
                        play_tutorial = b;

                        // Set game data
                        setGameData();

                        // Play audio
                        playAudio(THUNDER_AUDIO);

                        // Undo pause game
                        mPauseGame = false;

                        break;
                }
            }
        });

        // Set positive button
        tutorialBuilder.setPositiveButton("Yeah", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                // Play audio
                playAudio(RUN);

                // Undo pause game
                mPauseGame = false;
            }
        });

        // Display
        tutorialBuilder.show();

        // Play audio
        playAudio(CROW_AUDIO);
    }

    // Dialog to edit settings
    private void alertEditSettings() {

        // Pause game
        mPauseGame = true;

        // Create dialog
        AlertDialog.Builder settingsBuilder = new AlertDialog.Builder(this);

        // Set title
        settingsBuilder.setCancelable(false);
        settingsBuilder.setTitle("Game Settings");
        settingsBuilder.setMessage("Make adjustments");

        // Pass checked states
        boolean[] mChecked = {play_audio, play_haptic};

        // Setup multi choice buttons and logic
        settingsBuilder.setMultiChoiceItems(R.array.settings_list, mChecked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                // Which item was checked
                switch (i) {

                    // Audio
                    case 0:

                        // Is checked
                        play_audio = b;

                        //
                        playAudio(MISS);

                        //
                        setGameData();

                        break;

                    // Haptic
                    case 1:

                        // Is checked
                        play_haptic = b;

                        //
                        playHaptic();

                        //
                        setGameData();

                        break;
                }
            }
        });

        // Set positive button
        settingsBuilder.setPositiveButton("Yeah", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                // Play audio
                playAudio(RUN);

                // Undo pause game
                mPauseGame = false;
            }
        });

        // Display
        settingsBuilder.show();

        //
        playAudio(CROW_AUDIO);
    }

    // Dialog to alert return lose progress
    private void alertReturnLoseProgress() {

        // Pause game
        mPauseGame = true;

        // Alert dialog
        AlertDialog.Builder mReturnAlert = new AlertDialog.Builder(this);

        // Set titles
        mReturnAlert.setCancelable(false);
        mReturnAlert.setTitle("Return to main");
        mReturnAlert.setMessage("You will lose progress on this stage.");

        // Set negative button
        mReturnAlert.setNegativeButton("No Way", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                // Play audio
                playAudio(MISS);

                // Undo pause game
                mPauseGame = false;

                // Cancel dialogue
                dialogInterface.cancel();
            }
        });

        // Set positive button
        mReturnAlert.setPositiveButton("Sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                // Switch to stage select screen
                switchScreen(R.id.stage_select_screen_main_layout);

                // Play audio
                playAudio(RUN);

                // Undo pause game
                mPauseGame = false;
            }
        });

        // Display
        mReturnAlert.show();

        // Play audio
        playAudio(CROW_AUDIO);
    }

    // Dialog to alert exit lose progress
    private void alertExitLoseProgress() {

        // Pause game
        mPauseGame = true;

        // Alert dialog
        AlertDialog.Builder mReturnAlert = new AlertDialog.Builder(this);

        // Set titles
        mReturnAlert.setCancelable(false);
        mReturnAlert.setTitle("Exit");
        mReturnAlert.setMessage("You will lose progress on this stage.");

        // Set negative button
        mReturnAlert.setNegativeButton("No Way", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                // Play audio
                playAudio(MISS);

                // Undo pause game
                mPauseGame = false;

                // Cancel dialogue
                dialogInterface.cancel();
            }
        });

        // Set positive button
        mReturnAlert.setPositiveButton("Sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                // Play audio
                playAudio(RUN);

                // Undo pause game
                //mPauseGame = false;

                // Kill app
                finish();
            }
        });

        // Display
        mReturnAlert.show();

        // Play audio
        playAudio(CROW_AUDIO);
    }

    // Method to return drawable resource
    @SuppressWarnings("deprecation")
    private Drawable versionCheck(int mID) {

	    // Check version
	    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { return context.getResources().getDrawable(mID, getTheme()); }
	    else { return  context.getResources().getDrawable(mID); }
    }

	// Method to play audio
	private void playAudio(int sound) {

	    // Check toggle
		if (play_audio) {

		    //
            MediaPlayer mediaPlayer;

			// Initiate media object
            mediaPlayer = MediaPlayer.create(this, sound);

            //
            mediaPlayer.start();

			// On click listener clears audio memory when finished playing
			mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

				@Override
				public void onCompletion(MediaPlayer mediaPlayer) {
					mediaPlayer.release();
				}
			});
		}
	}

	// Method to vibrate device
	private void playHaptic() {

	    // Check toggle
		if (play_haptic) {

			// Request vibrator service ;)
			Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

			// Version check
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

			    //
			    if (v != null) {

			        //
			        v.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
                }

            } else {

			    //
			    if (v != null) {

			        //
			        v.vibrate(50);
                }
            }
		}
	}

	// Calculate percentage
	private static float getPercentage(int turns, int hits) {

        // Ensure not dividing by zero
        if (turns < 1) { turns = 1; }

        // Build and return float average of turns and hits
        return (100 * (float) hits) / ((float) turns);
    }

    // Reset level markers
    private void resetLevelMarkers() {

        // Replace image
        mGameLevelMarkerImageView.setBackground(versionCheck(LEVEL_MARKERS[0]));

        // Reveal markers and powers
        mGameLevelMarkerImageView.setVisibility(View.VISIBLE);
        mGameLevelMarkerLayout.setVisibility(View.VISIBLE);
        mGamePowersLayout.setVisibility(View.VISIBLE);
    }

    // Stage card *redundant* should remove
    //private void startStageCard () {

        // Pause game
        // mPauseGame = true;

        // Switch to SCREEN(STAGE_CARD)
        //switchScreen(R.id.stage_card_screen_main_layout);

        // Play audio(s)
        //playAudio(RUN);

        // Undo pause game
        //mPauseGame = false;
    //}

    // Build scorecard - STAGE TOP SCORES
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void buildScorecard() {

        // Primary scores
        mStageTopApexPredatorTextView.setText(Boolean.toString(TOP_SCORES_TOP_APEX[mStageIndex - 1]));
        mStagePredatorTextView.setText(Integer.toString(TOP_SCORES_TOP_PREDATOR[mStageIndex - 1]));
        mStageTopAccuracyTextView.setText(String.format("%.2f", TOP_SCORES_TOP_ACCURACY[mStageIndex - 1]));

        // Secondary scores
        mStageTopBestTimeTextView.setText(Integer.toString(TOP_SCORES_BEST_TIME[mStageIndex - 1]));
        mStageTotalTimeTextView.setText(Integer.toString(TOP_SCORES_TOTAL_TIME[mStageIndex - 1]));
        mStageTotalCreatureKillsTextView.setText(Integer.toString(TOP_SCORES_TOTAL_CREATURE_KILLS[mStageIndex - 1]));
        mStageCollectionTextView.setText(Integer.toString(TOP_SCORES_TOTAL_COLLECTION[mStageIndex - 1]));

        // Tertiary scores
        mStageHighestStreakTextView.setText(Integer.toString(TOP_SCORES_HIGHEST_STREAK[mStageIndex - 1]));
        mStageClosestDeathTextView.setText(Integer.toString(TOP_SCORES_CLOSEST_DEATH[mStageIndex - 1]));
        mStageLongestFrenzyTextView.setText(Integer.toString(TOP_SCORES_LONGEST_FRENZY[mStageIndex - 1]));
        mStageMostCalmTextView.setText(Long.toString(TOP_SCORES_MOST_CALM[mStageIndex - 1]));
        mStageMostFranticTextView.setText(Long.toString(TOP_SCORES_MOST_FRANTIC[mStageIndex - 1]));

        // Top scores
        mStageTotalAttemptsTextView.setText(Integer.toString(TOP_SCORES_TOTAL_ATTEMPTS[mStageIndex - 1]));
        mStageTotalBossKillsTextView.setText(Integer.toString(TOP_SCORES_TOTAL_BOSS_KILLS[mStageIndex - 1]));
    }

    // Build stage scores - STAGE COMPLETE
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void buildStageScores() {

        // Primary scores
        mStageApexPredatorTextView.setText(Boolean.toString(mStageApex));
        mStagePredatorTextView.setText(Integer.toString(mStagePredator));
        mStageAccuracyTextView.setText(String.format("%.2f", mStageAccuracy));

        // Secondary scores
        mStageTimeTextView.setText(Integer.toString(mStageTime));
        mStageCreatureKillsTextView.setText(Integer.toString(mStageCreatureKills));
        mStageCollectionTextView.setText(Integer.toString(mStageCollection));

        // Tertiary scores
        mStageHighestStreakTextView.setText(Integer.toString(mStageHighestStreak));
        mStageClosestDeathTextView.setText(Integer.toString(mStageClosestDeath));
        mStageLongestFrenzyTextView.setText(Integer.toString(mStageLongestFrenzy));
        mStageMostCalmTextView.setText(Long.toString(mStageMostCalm));
        mStageMostFranticTextView.setText(Long.toString(mStageMostFrantic));
    }

    //
    private void buildCreatureCollection(int creature, int trophy_case) {

        View[] trophy_cases = new View[]{

                //
                mCreature01ImageView, mCreature02ImageView, mCreature03ImageView, mCreature04ImageView,
                mCreature05ImageView, mCreature06ImageView, mCreature07ImageView, mCreature08ImageView,
                mCreature09ImageView, mCreature10ImageView, mCreature11ImageView, mCreature12ImageView,
                mCreature13ImageView, mCreature14ImageView, mCreature15ImageView, mCreature16ImageView,
                mCreature17ImageView, mCreature18ImageView, mCreature19ImageView, mCreature20ImageView,
                mCreature21ImageView, mCreature22ImageView, mCreature23ImageView, mCreature24ImageView,
                mCreature25ImageView, mCreature26ImageView, mCreature27ImageView, mCreature28ImageView,
                mCreature29ImageView, mCreature30ImageView, mCreature31ImageView, mCreature32ImageView,
        };

        //
        trophy_cases[trophy_case].setBackground(versionCheck(creature));
        Log.d(TAG, "buildCreatureCollection: trophy_case: " + trophy_cases[trophy_case] + " creature: " + creature);


        //
        //int i = 0;

        //
        //for (View trophy_case : trophy_cases) {

            //
            //trophy_case.setBackground(versionCheck(collections[i]));

            //i++;
        //}


    }

    //
    private void resetCreatureCollection() {

        View[] trophy_cases = new View[]{

                //
                mCreature01ImageView, mCreature02ImageView, mCreature03ImageView, mCreature04ImageView,
                mCreature05ImageView, mCreature06ImageView, mCreature07ImageView, mCreature08ImageView,
                mCreature09ImageView, mCreature10ImageView, mCreature11ImageView, mCreature12ImageView,
                mCreature13ImageView, mCreature14ImageView, mCreature15ImageView, mCreature16ImageView,
                mCreature17ImageView, mCreature18ImageView, mCreature19ImageView, mCreature20ImageView,
                mCreature21ImageView, mCreature22ImageView, mCreature23ImageView, mCreature24ImageView,
                mCreature25ImageView, mCreature26ImageView, mCreature27ImageView, mCreature28ImageView,
                mCreature29ImageView, mCreature30ImageView, mCreature31ImageView, mCreature32ImageView,
        };

        //
        //trophy_cases[trophy_case].setBackground(versionCheck(creature));
        //Log.d(TAG, "buildCreatureCollection: trophy_case: " + trophy_cases[trophy_case] + " creature: " + creature);

        //
        for (View trophy_case : trophy_cases) {

            //
            trophy_case.setBackground(versionCheck(android.R.color.transparent));
        }
    }

    // Player eaten
    @SuppressLint("SetTextI18n")
    private void playerEaten() {

        // Stop timer
        mPauseGame = true;

        // Record time
        mStageTime = mStageTimer;

        // Switch to SCREEN(EATEN)
        switchScreen(R.id.eaten_screen_main_layout);

        // Play outro audio(s)
        playAudio(HIT);
        playAudio(DARK_OUTRO);

        // Undo pause game
        mPauseGame = false;
    }

//-- ARRAY RESOURCES -->
    // Array list of screen layouts
    final private static int[] SCREENS = {


            //
            R.id.credits_screen_main_layout, R.id.entry_screen_main_layout, R.id.game_screen_main_layout,
            R.id.stage_select_screen_main_layout, R.id.eaten_screen_main_layout, R.id.stage_card_screen_main_layout
    };

	// Array list of intro screen layouts
    final private static int[] INTRO = {

            //
            R.drawable.logo_beta_02, R.drawable.pretty_good_logo_02, R.drawable.entry_footer_credits_white_title_image
    };

    // Array list of intro screen layouts
    final private static int[] OUTRO = {

            //
            R.drawable.entry_main_eobe_white_title_image, R.drawable.entry_main_title_image_view_01, R.drawable.entry_footer_credits_white_title_image
    };

    // Array list of level marker images
    final private static int[] LEVEL_MARKERS = {

            //
            R.drawable.level_progress_marker_01, R.drawable.level_progress_marker_02, R.drawable.level_progress_marker_03,
            R.drawable.level_progress_marker_04,R.drawable.level_progress_marker_05, R.drawable.level_progress_marker_empty,
    };

    // Array list of items that need event handlers
    final private static int[] CLICKABLES = {

            // Credits
            R.id.credits_screen_main_layout,

            // Entry
            R.id.entry_main_continue_image_button, R.id.entry_main_new_image_button, R.id.entry_main_settings_image_button, R.id.entry_main_tutorial_image_button,
            R.id.entry_main_credits_image_button,

            // Stage card
            R.id.stage_card_header_return_image_button, R.id.stage_card_content_title_image_button, R.id.stage_card_top_score_image_button,
            R.id.stage_card_control_prev_image_button, R.id.stage_card_control_next_image_button,
            R.id.stage_card_ready_play_here_image_button,

            // Stage select
            R.id.stage_select_return_image_button, R.id.select_stage_scorecard_image_button, R.id.stage_select_scorecard_layout,

            //
            R.id.stage_select_card_01_image_layout, R.id.stage_select_card_02_image_layout, R.id.stage_select_card_03_image_layout,
            R.id.stage_select_card_04_image_layout, R.id.stage_select_card_05_image_layout, R.id.stage_select_card_06_image_layout,
            R.id.stage_select_card_07_image_layout,

            // Game
            R.id.game_main_exit_image_button, R.id.game_settings_alert_image_button,

            //
            R.id.game_scene_prev_image_button, R.id.game_scene_next_image_button,

            //
            R.id.game_main_power_01_image_view, R.id.game_main_power_02_image_view, R.id.game_main_power_03_image_view,
            R.id.game_main_power_04_image_view, R.id.game_main_power_05_image_view, R.id.game_main_power_06_image_view,

            //
            R.id.game_main_pg_creature_canvas_layout, R.id.game_main_pg_boss_canvas_layout,

            //
            R.id.game_main_creature_01_image_button, R.id.game_main_creature_02_image_button, R.id.game_main_creature_03_image_button,
            R.id.game_main_creature_04_image_button, R.id.game_main_creature_05_image_button, R.id.game_main_boss_image_button,

            // Eaten
            R.id.eaten_main_return_image_button, R.id.eaten_main_exit_image_button, R.id.eaten_footer_tutorial_image_button, R.id.eaten_footer_try_again_image_button,
    };

    // Array list of creature buttons
    final private static int[] CREATURE_BUTTONS = {

            //
            R.id.game_main_creature_01_image_button, R.id.game_main_creature_02_image_button, R.id.game_main_creature_03_image_button,
            R.id.game_main_creature_04_image_button, R.id.game_main_creature_05_image_button
    };

    // Array list of stage names
    final private static int[] STAGE_NAMES = {

            //
            R.drawable.stage_01_title_image, R.drawable.stage_02_title_image, R.drawable.stage_03_title_image, R.drawable.stage_04_title_image,
            R.drawable.stage_05_title_image, R.drawable.stage_06_title_image, R.drawable.game_main_subtitle_image_view
    };

    // Array list of background images [forest]
    final private static int[] FOREST_SCENES = {

            //
            R.drawable.forest_bg_01, R.drawable.forest_bg_02, R.drawable.forest_bg_03, R.drawable.forest_bg_04, R.drawable.forest_bg_05
    };

    final private static String[] FOREST_SCENE_NAMES = {

            //
            "Glade", "Clearing", "Meadow", "Field", "Grassland"
    };

    // Array list of background images [ocean]
    final private static int[] OCEAN_SCENES = {

            //
            R.drawable.ocean_bg_01, R.drawable.ocean_bg_02, R.drawable.ocean_bg_03, R.drawable.ocean_bg_04, R.drawable.ocean_bg_05
    };

    final private static String[] OCEAN_SCENE_NAMES = {

            //
            "Delta", "Shoal", "Spring", "Banks", "Deep"
    };

    // Array list of background images [mountain]
    final private static int[] MOUNTAIN_SCENES = {

            //
            R.drawable.mountain_bg_01, R.drawable.mountain_bg_02, R.drawable.mountain_bg_03, R.drawable.mountain_bg_04, R.drawable.mountain_bg_05
    };

    final private static String[] MOUNTAIN_SCENE_NAMES = {

            //
            "Valley", "Cliff", "Overhang", "Sheer Face", "Tops"
    };

    // Array list of background images [desert]
    final private static int[] DESERT_SCENES = {

            //
            R.drawable.desert_bg_01, R.drawable.desert_bg_02, R.drawable.desert_bg_03, R.drawable.desert_bg_04, R.drawable.desert_bg_05
    };

    final private static String[] DESERT_SCENE_NAMES = {

            //
            "Dunes", "Barrens", "Highlands", "Mirage", "Deathlands"
    };

    // Array list of background images [jungle]
    final private static int[] JUNGLE_SCENES = {

            //
            R.drawable.jungle_bg_01, R.drawable.jungle_bg_02, R.drawable.jungle_bg_03, R.drawable.jungle_bg_04, R.drawable.jungle_bg_05
    };

    final private static String[] JUNGLE_SCENE_NAMES = {

            //
            "Treetops", "Caves", "Volcano", "Underbrush", "Canopy"
    };

    // Array list of background images [tundra]
    final private static int[] TUNDRA_SCENES = {

            //
            R.drawable.tundra_bg_01, R.drawable.tundra_bg_02, R.drawable.tundra_bg_03, R.drawable.tundra_bg_04, R.drawable.tundra_bg_05
    };

    final private static String[] TUNDRA_SCENE_NAMES = {

            //
            "Staights", "Kills", "Dry Bed", "Snowlands", "Pole"
    };

    // Array list of background images [final]
    final private static int[] FINAL_SCENES = {

            //
            R.drawable.final_bg_01, R.drawable.final_bg_02, R.drawable.final_bg_03, R.drawable.final_bg_04, R.drawable.final_bg_05
    };

    final private static String[] FINAL_SCENE_NAMES = {

            //
            "Planetary Gulf", "Stellar Field", "Galactic Space", "Universal Center", "Multiverse Foyer"
    };

    final private static int[][] STAGE_SCENES = {

            //
            FOREST_SCENES, OCEAN_SCENES, MOUNTAIN_SCENES, DESERT_SCENES, JUNGLE_SCENES, TUNDRA_SCENES, FINAL_SCENES
    };

    final private static String[][] STAGE_SCENE_NAMES = {

            //
            FOREST_SCENE_NAMES, OCEAN_SCENE_NAMES, MOUNTAIN_SCENE_NAMES, DESERT_SCENE_NAMES, JUNGLE_SCENE_NAMES, TUNDRA_SCENE_NAMES, FINAL_SCENE_NAMES
    };

    final private static int[] STAGE_BORDERS = {

            //
            R.drawable.forest_border, R.drawable.ocean_border, R.drawable.mountain_border, R.drawable.desert_border,
            R.drawable.jungle_border, R.drawable.tundra_border, R.drawable.tundra_border_alt
    };

    // Array list of background images for disasters
    final private static int[] STAGE_DISASTERS = {

            //
            R.drawable.forest_tap, R.drawable.ocean_tap, R.drawable.mountain_tap,
            R.drawable.desert_tap, R.drawable.jungle_tap, R.drawable.tundra_tap,
            R.drawable.final_tap
    };

    // Array list of audio for disasters
    final private static int[] STAGE_DISASTER_AUDIO = {

            //
            THUNDER_AUDIO, SPLASH_AUDIO, EARTHQUAKE_AUDIO, TORNADO_AUDIO, VOLCANO_AUDIO, AVALANCHE_AUDIO, REVERSE_PING
    };

    // Array list of stage colors
    final private static int[] STAGE_COLOR = {

            //
            Color.GREEN, Color.BLUE, R.color.color_palette_02_light_brown, Color.MAGENTA, Color.RED, Color.GRAY, Color.BLACK
    };

    // Array list of sprite images for bosses
    final private static int[] BOSS_IMAGES = {

            //
            R.drawable.forest_boss, R.drawable.ocean_boss, R.drawable.mountain_boss,
            R.drawable.desert_boss, R.drawable.jungle_boss, R.drawable.tundra_boss, R.drawable.final_boss
    };

    // Array list of audio for bosses
    final private static int[] BOSS_CRY_AUDIO = {

            //
            WOLF_CRY, SHARK_CRY, HAWK_CRY, SCORPION_CRY, SNAKE_CRY, YETI_CRY, GROWL_ALERT
    };

    // Array list of images for boss scenes
    final private static int[] BOSS_SCENE_IMAGES = {

            //
            R.drawable.forest_bg_boss, R.drawable.ocean_bg_boss, R.drawable.mountain_bg_boss,
            R.drawable.desert_bg_boss, R.drawable.jungle_bg_boss, R.drawable.tundra_bg_boss,
            R.drawable.final_boss_bg
    };

    // Array list of images for stage card bg
    final private static int[] STAGE_CARD_BG = {

            //
            R.drawable.results_forest_bg_image, R.drawable.results_ocean_bg_image, R.drawable.results_mountain_bg_image,
            R.drawable.results_desert_bg_image, R.drawable.results_jungle_bg_image, R.drawable.results_tundra_bg_image,
            R.drawable.results_main_final_boss_bg_image
    };


    // Array list of sprite images
    final private static int[] CREATURES = {

            //
            R.drawable.game_main_carnivore_black_creature_image, R.drawable.game_main_carnivore_white_creature_image,
            R.drawable.game_main_delighted_black_creature_image, R.drawable.game_main_delighted_white_creature_image,
            R.drawable.game_main_diamonds_black_creature_image, R.drawable.game_main_diamonds_white_creature_image,
            R.drawable.game_main_fangs_black_creature_image, R.drawable.game_main_fangs_white_creature_image,
            R.drawable.game_main_front_teeth_black_creature_image, R.drawable.game_main_front_teeth_white_creature_image,
            R.drawable.game_main_incisors_black_creature_image, R.drawable.game_main_incisors_white_creature_image,
            R.drawable.game_main_insect_black_creature_image, R.drawable.game_main_insect_white_creature_image,
            R.drawable.game_main_lamprey_black_creature_image, R.drawable.game_main_lamprey_white_creature_image,
            R.drawable.game_main_sabre_black_creature_image, R.drawable.game_main_sabre_white_creature_image,
            R.drawable.game_main_sharp_black_creature_image, R.drawable.game_main_sharp_white_creature_image,
            R.drawable.game_main_sharp_smile_black_creature_image, R.drawable.game_main_sharp_smile_white_creature_image,
            R.drawable.game_main_smile_black_creature_image, R.drawable.game_main_smile_white_creature_image,
            R.drawable.game_main_swallow_black_creature_image, R.drawable.game_main_swallow_white_creature_image,
            R.drawable.game_main_swallower_black_creature_image, R.drawable.game_main_swallower_white_creature_image,
            R.drawable.game_main_toad_black_creature_image, R.drawable.game_main_toad_white_creature_image,
            R.drawable.game_main_watering_black_creature_image, R.drawable.game_main_watering_white_creature_image,
    };

    // Array list of alphas - index.length = 20
    final private static double[] ALPHA_INDEX = {

            //
            1, .99, .98, .97, .96, .95, .93, .91, .89, .85, .8, .75, .7, .6, .5, .25, .1, .01, .001, 0
    };

    // Array list of alphas - index.length = 20
    final private static double[] ALPHA_INDEX_INVERSE = {

            //
            0, .001, .01, .1, .25, .5, .6, .7, .75, .8, .85, .89, .91, .93, .95, .96, .97, .98, .99, .1
    };

    // Array list of pings
    final private static int[] PINGS = {

            //
            R.raw.ping_01_audio, R.raw.ping_02_audio, R.raw.ping_03_audio, R.raw.ping_04_audio, R.raw.ping_05_audio,
            R.raw.ping_06_audio, R.raw.ping_07_audio, R.raw.ping_08_audio, R.raw.ping_09_audio, R.raw.ping_10_audio
    };

//-- STAGE PROPS ARRAY -->
    // Array list of stage cards
    final private static int[] STAGE_PROP_CARDS = {

            //
            R.id.stage_select_card_01_image_layout, R.id.stage_select_card_02_image_layout, R.id.stage_select_card_03_image_layout,
            R.id.stage_select_card_04_image_layout, R.id.stage_select_card_05_image_layout, R.id.stage_select_card_06_image_layout
    };


    // Array list of stage props - stage card titles
    final private static int[] STAGE_PROP_CARD_TITLES = {

            //
            R.id.select_stage_title_01_image_view, R.id.select_stage_title_02_image_view, R.id.select_stage_title_03_image_view, R.id.select_stage_title_04_image_view,
            R.id.select_stage_title_05_image_view, R.id.select_stage_title_06_image_view
    };

    // Array list of stage props - stage card status
    final private static int[] STAGE_PROP_CARD_STATUS = {

            //
            R.id.select_stage_status_01_image_view, R.id.select_stage_status_02_image_view, R.id.select_stage_status_03_image_view, R.id.select_stage_status_04_image_view,
            R.id.select_stage_status_05_image_view, R.id.select_stage_status_06_image_view, R.id.select_stage_status_07_image_view
    };

    // Array list of stage props - stage card icons
    final private static int[] STAGE_PROP_CARD_ICONS = {

            //
            R.id.select_stage_status_01_icon_image_button, R.id.select_stage_status_02_icon_image_button, R.id.select_stage_status_03_icon_image_button,
            R.id.select_stage_status_04_icon_image_button, R.id.select_stage_status_05_icon_image_button, R.id.select_stage_status_06_icon_image_button
    };

    // Array list of stage props - stage card bg
    final private static int[] STAGE_PROP_CARD_BG = {

            //
            R.drawable.forest_card, R.drawable.ocean_card, R.drawable.mountain_card, R.drawable.desert_card,
            R.drawable.jungle_card, R.drawable.tundra_card
    };

    // Array list of stage props - stage title images
    final private static int[] STAGE_PROP_TITLE_IMAGES = {

            //
            R.drawable.select_stage_title_01_image, R.drawable.select_stage_title_02_image, R.drawable.select_stage_title_03_image, R.drawable.select_stage_title_04_image,
            R.drawable.select_stage_title_05_image, R.drawable.select_stage_title_06_image
    };

//-- TOP SCORES ARRAYS -->
    // Array list of top scores - total attempts
    int[] TOP_SCORES_TOTAL_ATTEMPTS = {

            //
            stage_01_attempts, stage_02_attempts, stage_03_attempts, stage_04_attempts, stage_05_attempts, stage_06_attempts, stage_07_attempts
    };

    // Array list of top scores - total attempts
    int[] TOP_SCORES_TOTAL_BOSS_KILLS = {

            //
            stage_01_boss_kills, stage_02_boss_kills, stage_03_boss_kills, stage_04_boss_kills, stage_05_boss_kills, stage_06_boss_kills, stage_07_boss_kills
    };

    // Array list of top scores - total attempts
    int[] TOP_SCORES_TOTAL_CREATURE_KILLS = {

            //
            stage_01_creature_kills, stage_02_creature_kills, stage_03_creature_kills, stage_04_creature_kills, stage_05_creature_kills, stage_06_creature_kills, stage_07_creature_kills
    };

    // Array list of top scores - total attempts
    int[] TOP_SCORES_HIGHEST_STREAK = {

            //
            stage_01_highest_streak, stage_02_highest_streak, stage_03_highest_streak, stage_04_highest_streak, stage_05_highest_streak, stage_06_highest_streak, stage_07_highest_streak
    };

    // Array list of top scores - total attempts
    int[] TOP_SCORES_CLOSEST_DEATH = {

            //
            stage_01_closest_death, stage_02_closest_death, stage_03_closest_death, stage_04_closest_death, stage_05_closest_death, stage_06_closest_death, stage_07_closest_death
    };

    // Array list of top scores - total attempts
    int[] TOP_SCORES_LONGEST_FRENZY = {

            //
            stage_01_longest_frenzy, stage_02_longest_frenzy, stage_03_longest_frenzy, stage_04_longest_frenzy, stage_05_longest_frenzy, stage_06_longest_frenzy, stage_07_longest_frenzy
    };

    // Array list of top scores - total attempts
    Long[] TOP_SCORES_MOST_CALM = {

            //
            stage_01_most_calm, stage_02_most_calm, stage_03_most_calm, stage_04_most_calm, stage_05_most_calm, stage_06_most_calm, stage_07_most_calm
    };

    // Array list of top scores - total attempts
    Long[] TOP_SCORES_MOST_FRANTIC = {

            //
            stage_01_most_frantic, stage_02_most_frantic, stage_03_most_frantic, stage_04_most_frantic, stage_05_most_frantic, stage_06_most_frantic, stage_07_most_frantic
    };

    // Array list of top scores - total attempts
    int[] TOP_SCORES_TOTAL_TIME = {

            //
            stage_01_total_time, stage_02_total_time, stage_03_total_time, stage_04_total_time, stage_05_total_time, stage_06_total_time, stage_07_total_time
    };

    // Array list of top scores - total attempts
    int[] TOP_SCORES_BEST_TIME = {

            //
            stage_01_best_time, stage_02_best_time, stage_03_best_time, stage_04_best_time, stage_05_best_time, stage_06_best_time, stage_07_best_time
    };

    // Array list of top scores - total attempts
    boolean[] TOP_SCORES_TOP_APEX = {

            //
            stage_01_apex, stage_02_apex, stage_03_apex, stage_04_apex, stage_05_apex, stage_06_apex, stage_07_apex
    };

    // Array list of top scores - total attempts
    int[] TOP_SCORES_TOP_PREDATOR = {

            //
            stage_01_predator, stage_02_predator, stage_03_predator, stage_04_predator, stage_05_predator, stage_06_predator, stage_07_predator
    };

    // Array list of top scores - total attempts
    Float[] TOP_SCORES_TOP_ACCURACY = {

            //
            stage_01_accuracy, stage_02_accuracy, stage_03_accuracy, stage_04_accuracy, stage_05_accuracy, stage_06_accuracy, stage_07_accuracy
    };

    // Array list of top scores - total attempts
    int[] TOP_SCORES_TOTAL_COLLECTION = {

            //
            stage_01_collection, stage_02_collection, stage_03_collection, stage_04_collection, stage_05_collection, stage_06_collection, stage_07_collection
    };
}