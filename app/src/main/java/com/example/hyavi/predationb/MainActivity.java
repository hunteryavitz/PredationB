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
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    private static final String STAGE_02_CREATURE_01 = "stage_02_creature_01";
    private static final String STAGE_02_CREATURE_02 = "stage_02_creature_02";
    private static final String STAGE_02_CREATURE_03 = "stage_02_creature_03";
    private static final String STAGE_02_CREATURE_04 = "stage_02_creature_04";
    private static final String STAGE_02_CREATURE_05 = "stage_02_creature_05";
    private static final String STAGE_02_CREATURE_06 = "stage_02_creature_06";
    private static final String STAGE_02_CREATURE_07 = "stage_02_creature_07";
    private static final String STAGE_02_CREATURE_08 = "stage_02_creature_08";
    private static final String STAGE_02_CREATURE_09 = "stage_02_creature_09";
    private static final String STAGE_02_CREATURE_10 = "stage_02_creature_10";
    private static final String STAGE_02_CREATURE_11 = "stage_02_creature_11";
    private static final String STAGE_02_CREATURE_12 = "stage_02_creature_12";
    private static final String STAGE_02_CREATURE_13 = "stage_02_creature_13";
    private static final String STAGE_02_CREATURE_14 = "stage_02_creature_14";
    private static final String STAGE_02_CREATURE_15 = "stage_02_creature_15";
    private static final String STAGE_02_CREATURE_16 = "stage_02_creature_16";
    private static final String STAGE_02_CREATURE_17 = "stage_02_creature_17";
    private static final String STAGE_02_CREATURE_18 = "stage_02_creature_18";
    private static final String STAGE_02_CREATURE_19 = "stage_02_creature_19";
    private static final String STAGE_02_CREATURE_20 = "stage_02_creature_20";
    private static final String STAGE_02_CREATURE_21 = "stage_02_creature_21";
    private static final String STAGE_02_CREATURE_22 = "stage_02_creature_22";
    private static final String STAGE_02_CREATURE_23 = "stage_02_creature_23";
    private static final String STAGE_02_CREATURE_24 = "stage_02_creature_24";
    private static final String STAGE_02_CREATURE_25 = "stage_02_creature_25";
    private static final String STAGE_02_CREATURE_26 = "stage_02_creature_26";
    private static final String STAGE_02_CREATURE_27 = "stage_02_creature_27";
    private static final String STAGE_02_CREATURE_28 = "stage_02_creature_28";
    private static final String STAGE_02_CREATURE_29 = "stage_02_creature_29";
    private static final String STAGE_02_CREATURE_30 = "stage_02_creature_30";
    private static final String STAGE_02_CREATURE_31 = "stage_02_creature_31";
    private static final String STAGE_02_CREATURE_32 = "stage_02_creature_32";

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
    private static final String STAGE_03_CREATURE_01 = "stage_03_creature_01";
    private static final String STAGE_03_CREATURE_02 = "stage_03_creature_02";
    private static final String STAGE_03_CREATURE_03 = "stage_03_creature_03";
    private static final String STAGE_03_CREATURE_04 = "stage_03_creature_04";
    private static final String STAGE_03_CREATURE_05 = "stage_03_creature_05";
    private static final String STAGE_03_CREATURE_06 = "stage_03_creature_06";
    private static final String STAGE_03_CREATURE_07 = "stage_03_creature_07";
    private static final String STAGE_03_CREATURE_08 = "stage_03_creature_08";
    private static final String STAGE_03_CREATURE_09 = "stage_03_creature_09";
    private static final String STAGE_03_CREATURE_10 = "stage_03_creature_10";
    private static final String STAGE_03_CREATURE_11 = "stage_03_creature_11";
    private static final String STAGE_03_CREATURE_12 = "stage_03_creature_12";
    private static final String STAGE_03_CREATURE_13 = "stage_03_creature_13";
    private static final String STAGE_03_CREATURE_14 = "stage_03_creature_14";
    private static final String STAGE_03_CREATURE_15 = "stage_03_creature_15";
    private static final String STAGE_03_CREATURE_16 = "stage_03_creature_16";
    private static final String STAGE_03_CREATURE_17 = "stage_03_creature_17";
    private static final String STAGE_03_CREATURE_18 = "stage_03_creature_18";
    private static final String STAGE_03_CREATURE_19 = "stage_03_creature_19";
    private static final String STAGE_03_CREATURE_20 = "stage_03_creature_20";
    private static final String STAGE_03_CREATURE_21 = "stage_03_creature_21";
    private static final String STAGE_03_CREATURE_22 = "stage_03_creature_22";
    private static final String STAGE_03_CREATURE_23 = "stage_03_creature_23";
    private static final String STAGE_03_CREATURE_24 = "stage_03_creature_24";
    private static final String STAGE_03_CREATURE_25 = "stage_03_creature_25";
    private static final String STAGE_03_CREATURE_26 = "stage_03_creature_26";
    private static final String STAGE_03_CREATURE_27 = "stage_03_creature_27";
    private static final String STAGE_03_CREATURE_28 = "stage_03_creature_28";
    private static final String STAGE_03_CREATURE_29 = "stage_03_creature_29";
    private static final String STAGE_03_CREATURE_30 = "stage_03_creature_30";
    private static final String STAGE_03_CREATURE_31 = "stage_03_creature_31";
    private static final String STAGE_03_CREATURE_32 = "stage_03_creature_32";

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
    private static final String STAGE_04_CREATURE_01 = "stage_04_creature_01";
    private static final String STAGE_04_CREATURE_02 = "stage_04_creature_02";
    private static final String STAGE_04_CREATURE_03 = "stage_04_creature_03";
    private static final String STAGE_04_CREATURE_04 = "stage_04_creature_04";
    private static final String STAGE_04_CREATURE_05 = "stage_04_creature_05";
    private static final String STAGE_04_CREATURE_06 = "stage_04_creature_06";
    private static final String STAGE_04_CREATURE_07 = "stage_04_creature_07";
    private static final String STAGE_04_CREATURE_08 = "stage_04_creature_08";
    private static final String STAGE_04_CREATURE_09 = "stage_04_creature_09";
    private static final String STAGE_04_CREATURE_10 = "stage_04_creature_10";
    private static final String STAGE_04_CREATURE_11 = "stage_04_creature_11";
    private static final String STAGE_04_CREATURE_12 = "stage_04_creature_12";
    private static final String STAGE_04_CREATURE_13 = "stage_04_creature_13";
    private static final String STAGE_04_CREATURE_14 = "stage_04_creature_14";
    private static final String STAGE_04_CREATURE_15 = "stage_04_creature_15";
    private static final String STAGE_04_CREATURE_16 = "stage_04_creature_16";
    private static final String STAGE_04_CREATURE_17 = "stage_04_creature_17";
    private static final String STAGE_04_CREATURE_18 = "stage_04_creature_18";
    private static final String STAGE_04_CREATURE_19 = "stage_04_creature_19";
    private static final String STAGE_04_CREATURE_20 = "stage_04_creature_20";
    private static final String STAGE_04_CREATURE_21 = "stage_04_creature_21";
    private static final String STAGE_04_CREATURE_22 = "stage_04_creature_22";
    private static final String STAGE_04_CREATURE_23 = "stage_04_creature_23";
    private static final String STAGE_04_CREATURE_24 = "stage_04_creature_24";
    private static final String STAGE_04_CREATURE_25 = "stage_04_creature_25";
    private static final String STAGE_04_CREATURE_26 = "stage_04_creature_26";
    private static final String STAGE_04_CREATURE_27 = "stage_04_creature_27";
    private static final String STAGE_04_CREATURE_28 = "stage_04_creature_28";
    private static final String STAGE_04_CREATURE_29 = "stage_04_creature_29";
    private static final String STAGE_04_CREATURE_30 = "stage_04_creature_30";
    private static final String STAGE_04_CREATURE_31 = "stage_04_creature_31";
    private static final String STAGE_04_CREATURE_32 = "stage_04_creature_32";

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
    private static final String STAGE_05_CREATURE_01 = "stage_05_creature_01";
    private static final String STAGE_05_CREATURE_02 = "stage_05_creature_02";
    private static final String STAGE_05_CREATURE_03 = "stage_05_creature_03";
    private static final String STAGE_05_CREATURE_04 = "stage_05_creature_04";
    private static final String STAGE_05_CREATURE_05 = "stage_05_creature_05";
    private static final String STAGE_05_CREATURE_06 = "stage_05_creature_06";
    private static final String STAGE_05_CREATURE_07 = "stage_05_creature_07";
    private static final String STAGE_05_CREATURE_08 = "stage_05_creature_08";
    private static final String STAGE_05_CREATURE_09 = "stage_05_creature_09";
    private static final String STAGE_05_CREATURE_10 = "stage_05_creature_10";
    private static final String STAGE_05_CREATURE_11 = "stage_05_creature_11";
    private static final String STAGE_05_CREATURE_12 = "stage_05_creature_12";
    private static final String STAGE_05_CREATURE_13 = "stage_05_creature_13";
    private static final String STAGE_05_CREATURE_14 = "stage_05_creature_14";
    private static final String STAGE_05_CREATURE_15 = "stage_05_creature_15";
    private static final String STAGE_05_CREATURE_16 = "stage_05_creature_16";
    private static final String STAGE_05_CREATURE_17 = "stage_05_creature_17";
    private static final String STAGE_05_CREATURE_18 = "stage_05_creature_18";
    private static final String STAGE_05_CREATURE_19 = "stage_05_creature_19";
    private static final String STAGE_05_CREATURE_20 = "stage_05_creature_20";
    private static final String STAGE_05_CREATURE_21 = "stage_05_creature_21";
    private static final String STAGE_05_CREATURE_22 = "stage_05_creature_22";
    private static final String STAGE_05_CREATURE_23 = "stage_05_creature_23";
    private static final String STAGE_05_CREATURE_24 = "stage_05_creature_24";
    private static final String STAGE_05_CREATURE_25 = "stage_05_creature_25";
    private static final String STAGE_05_CREATURE_26 = "stage_05_creature_26";
    private static final String STAGE_05_CREATURE_27 = "stage_05_creature_27";
    private static final String STAGE_05_CREATURE_28 = "stage_05_creature_28";
    private static final String STAGE_05_CREATURE_29 = "stage_05_creature_29";
    private static final String STAGE_05_CREATURE_30 = "stage_05_creature_30";
    private static final String STAGE_05_CREATURE_31 = "stage_05_creature_31";
    private static final String STAGE_05_CREATURE_32 = "stage_05_creature_32";

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
    private static final String STAGE_06_CREATURE_01 = "stage_06_creature_01";
    private static final String STAGE_06_CREATURE_02 = "stage_06_creature_02";
    private static final String STAGE_06_CREATURE_03 = "stage_06_creature_03";
    private static final String STAGE_06_CREATURE_04 = "stage_06_creature_04";
    private static final String STAGE_06_CREATURE_05 = "stage_06_creature_05";
    private static final String STAGE_06_CREATURE_06 = "stage_06_creature_06";
    private static final String STAGE_06_CREATURE_07 = "stage_06_creature_07";
    private static final String STAGE_06_CREATURE_08 = "stage_06_creature_08";
    private static final String STAGE_06_CREATURE_09 = "stage_06_creature_09";
    private static final String STAGE_06_CREATURE_10 = "stage_06_creature_10";
    private static final String STAGE_06_CREATURE_11 = "stage_06_creature_11";
    private static final String STAGE_06_CREATURE_12 = "stage_06_creature_12";
    private static final String STAGE_06_CREATURE_13 = "stage_06_creature_13";
    private static final String STAGE_06_CREATURE_14 = "stage_06_creature_14";
    private static final String STAGE_06_CREATURE_15 = "stage_06_creature_15";
    private static final String STAGE_06_CREATURE_16 = "stage_06_creature_16";
    private static final String STAGE_06_CREATURE_17 = "stage_06_creature_17";
    private static final String STAGE_06_CREATURE_18 = "stage_06_creature_18";
    private static final String STAGE_06_CREATURE_19 = "stage_06_creature_19";
    private static final String STAGE_06_CREATURE_20 = "stage_06_creature_20";
    private static final String STAGE_06_CREATURE_21 = "stage_06_creature_21";
    private static final String STAGE_06_CREATURE_22 = "stage_06_creature_22";
    private static final String STAGE_06_CREATURE_23 = "stage_06_creature_23";
    private static final String STAGE_06_CREATURE_24 = "stage_06_creature_24";
    private static final String STAGE_06_CREATURE_25 = "stage_06_creature_25";
    private static final String STAGE_06_CREATURE_26 = "stage_06_creature_26";
    private static final String STAGE_06_CREATURE_27 = "stage_06_creature_27";
    private static final String STAGE_06_CREATURE_28 = "stage_06_creature_28";
    private static final String STAGE_06_CREATURE_29 = "stage_06_creature_29";
    private static final String STAGE_06_CREATURE_30 = "stage_06_creature_30";
    private static final String STAGE_06_CREATURE_31 = "stage_06_creature_31";
    private static final String STAGE_06_CREATURE_32 = "stage_06_creature_32";

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
    private static final String STAGE_07_CREATURE_01 = "stage_07_creature_01";
    private static final String STAGE_07_CREATURE_02 = "stage_07_creature_02";
    private static final String STAGE_07_CREATURE_03 = "stage_07_creature_03";
    private static final String STAGE_07_CREATURE_04 = "stage_07_creature_04";
    private static final String STAGE_07_CREATURE_05 = "stage_07_creature_05";
    private static final String STAGE_07_CREATURE_06 = "stage_07_creature_06";
    private static final String STAGE_07_CREATURE_07 = "stage_07_creature_07";
    private static final String STAGE_07_CREATURE_08 = "stage_07_creature_08";
    private static final String STAGE_07_CREATURE_09 = "stage_07_creature_09";
    private static final String STAGE_07_CREATURE_10 = "stage_07_creature_10";
    private static final String STAGE_07_CREATURE_11 = "stage_07_creature_11";
    private static final String STAGE_07_CREATURE_12 = "stage_07_creature_12";
    private static final String STAGE_07_CREATURE_13 = "stage_07_creature_13";
    private static final String STAGE_07_CREATURE_14 = "stage_07_creature_14";
    private static final String STAGE_07_CREATURE_15 = "stage_07_creature_15";
    private static final String STAGE_07_CREATURE_16 = "stage_07_creature_16";
    private static final String STAGE_07_CREATURE_17 = "stage_07_creature_17";
    private static final String STAGE_07_CREATURE_18 = "stage_07_creature_18";
    private static final String STAGE_07_CREATURE_19 = "stage_07_creature_19";
    private static final String STAGE_07_CREATURE_20 = "stage_07_creature_20";
    private static final String STAGE_07_CREATURE_21 = "stage_07_creature_21";
    private static final String STAGE_07_CREATURE_22 = "stage_07_creature_22";
    private static final String STAGE_07_CREATURE_23 = "stage_07_creature_23";
    private static final String STAGE_07_CREATURE_24 = "stage_07_creature_24";
    private static final String STAGE_07_CREATURE_25 = "stage_07_creature_25";
    private static final String STAGE_07_CREATURE_26 = "stage_07_creature_26";
    private static final String STAGE_07_CREATURE_27 = "stage_07_creature_27";
    private static final String STAGE_07_CREATURE_28 = "stage_07_creature_28";
    private static final String STAGE_07_CREATURE_29 = "stage_07_creature_29";
    private static final String STAGE_07_CREATURE_30 = "stage_07_creature_30";
    private static final String STAGE_07_CREATURE_31 = "stage_07_creature_31";
    private static final String STAGE_07_CREATURE_32 = "stage_07_creature_32";

//-- GLOBAL DYNAMIC VIEWS -->

//-- INTRO -->

    // Intro / Outro views
    private ImageView mCreditsImageView;

//-- ENTRY -->

    // Entry views
    private LinearLayout mEntryMainControlLayout;
    
    //
    private ImageButton mEntryContinueImageButton;
    private ImageButton mEntryCreditsImageButton;

//-- STAGE SELECT -->

    // Stage select toggle views
    private ImageButton mStageSelectScorecardImageButton;
    private ImageButton mStageSelectCollectionImageButton;
    private ImageButton mStageSelectContentImageButton;

    //
    private LinearLayout mStageSelectMainScorecardLayout;
    private LinearLayout mStageSelectMainCollectionLayout;
    private LinearLayout mStageSelectMainContentLayout;
    
    //
    private LinearLayout mStageSelectScorecardLayout;
    private LinearLayout mStageSelectCollectionLayout;
    private LinearLayout mStageSelectContentLayout;

    //
    private ProgressBar mStageSelectContentProgressBar;
    private ProgressBar mStageSelectTopScoresProgressBar;
    private ProgressBar mStageSelectTrophycaseProgressBar;

    // Stage select top scores
    private TextView mGameTrophyScoreTextView;
    private TextView mGameTrophyPercentTextView;

    //
    private TextView mGameScoreTextView;

    //
    private ImageView mEOBEApexScoreBadgeImageView;
    private ImageView mEOBEPredatorScoreBadgeImageView;
    private ImageView mEOBEAccuracyScoreBadgeImageView;
    private ImageView mEOBETimeBestScoreBadgeImageView;
    private ImageView mEOBECreatureKillsScoreBadgeImageView;
    private ImageView mEOBEHighStreakScoreBadgeImageView;
    private ImageView mEOBECloseDeathScoreBadgeImageView;
    private ImageView mEOBELongFrenzyScoreBadgeImageView;
    private ImageView mEOBEMostCalmScoreBadgeImageView;
    private ImageView mEOBEMostFranticScoreBadgeImageView;

    //
    private LinearLayout mGameApexLayout;
    private LinearLayout mGamePredatorLayout;
    private LinearLayout mGameAccuracyLayout;
    private LinearLayout mGameTimeLayout;
    private LinearLayout mGameEatenLayout;
    private LinearLayout mGameStreakLayout;
    private LinearLayout mGameDeathLayout;
    private LinearLayout mGameFrenzyLayout;
    private LinearLayout mGameCalmLayout;
    private LinearLayout mGameFranticLayout;

    //
    private TextView mApexRunningTextView;
    private TextView mPredatorRunningTextView;
    private TextView mAccuracyRunningTextView;
    private TextView mTimeRunningTextView;
    private TextView mCreatureRunningTextView;
    private TextView mStreakRunningTextView;
    private TextView mClosestRunningTextView;
    private TextView mFrenzyRunningTextView;
    private TextView mCalmRunningTextView;
    private TextView mFranticRunningTextView;

    //
    private ImageView mEOBEStage01TrophyImageView;
    private ImageView mEOBEStage02TrophyImageView;
    private ImageView mEOBEStage03TrophyImageView;
    private ImageView mEOBEStage04TrophyImageView;
    private ImageView mEOBEStage05TrophyImageView;
    private ImageView mEOBEStage06TrophyImageView;
    private ImageView mEOBEStage07TrophyImageView;

//-- STAGE CARD -->

    // Stage card titles / icons
    private ImageButton mStageCardLockedImageButton;
    private ImageButton mStageCardTrophyImageButton;
    private ImageButton mStageCardHiScoreImageButton;
    private ImageButton mStageCardStageScoreImageButton;
    private ImageButton mStageCardEatenImageButton;
    private ImageButton mStageCardContentImageButton;

    //
    private LinearLayout mStageCardMainTrophyLayout;
    private LinearLayout mStageCardMainHiScoreLayout;
    private LinearLayout mStageCardMainStageScoreLayout;
    private LinearLayout mStageCardMainEatenLayout;
    private LinearLayout mStageCardMainContentLayout;

    //
    private ProgressBar mStageCardTrophycaseProgressBar;
    private ProgressBar mStageCardTopScoresProgressbar;

    //
    private LinearLayout mStageCardScreenBodyLayout;

    //
    private LinearLayout mStageCardContentTitleLayout;
    private ImageButton mStageCardContentTitleImageButton;
    private TextView mStageCardBossNameTextView;

    //
    private ImageView mStageCardBossImageView;

    //
    private LinearLayout mStageCardTopScoreLayout;
    private LinearLayout mStageCardCollectionLayout;
    private LinearLayout mStageCardScorecardLayout;
    private LinearLayout mStageCardEatenScoreLayout;
    private LinearLayout mStageCardContentLayout;
    private LinearLayout mStageCardStageLockedLayout;

    //
    private LinearLayout mStageCardDisasterBGImageView;

    //
    private ImageView mStageTopApexBadgeImageView;
    private ImageView mStageTopPredatorBadgeImageView;
    private ImageView mStageTopAccuracyBadgeImageView;
    private ImageView mStageTopBestTimeBadgeImageView;
    private ImageView mStageTotalCreatureKillsBadgeImageView;
    private ImageView mStageTopHighStreakBadgeImageView;
    private ImageView mStageTopCloseDeathBadgeImageView;
    private ImageView mStageTopLongFrenzyBadgeImageView;
    private ImageView mStageTopMostCalmBadgeImageView;
    private ImageView mStageTopMostFranticBadgeImageView;

    //
    private LinearLayout mStageCardTopApexLayout;
    private LinearLayout mStageCardTopPredatorLayout;
    private LinearLayout mStageCardTopAccuracyLayout;
    private LinearLayout mStageCardTopTimeLayout;
    private LinearLayout mStageCardTopEatenLayout;
    private LinearLayout mStageCardTopStreakLayout;
    private LinearLayout mStageCardTopDeathLayout;
    private LinearLayout mStageCardTopFrenzyLayout;
    private LinearLayout mStageCardTopCalmLayout;
    private LinearLayout mStageCardTopFranticLayout;

    //
    //private TextView mStageScoreFinalScoreTextView;
    private TextView mTopScoreProgressScoreTextView;

    // StageCard complete views - Stage complete [stage scores]
    //private TextView mStageApexPredatorTextView;
    //private TextView mStagePredatorTextView;
    //private TextView mStageAccuracyTextView;
    //private TextView mStageTimeTextView;
    //private TextView mStageCreatureKillsTextView;
    //private TextView mStageCollectionTextView;
    //private TextView mStageHighestStreakTextView;
    //private TextView mStageClosestDeathTextView;
    //private TextView mStageLongestFrenzyTextView;
    //private TextView mStageMostCalmTextView;
    //private TextView mStageMostFranticTextView;

    //
    private LinearLayout mStageCardApexLayout;
    private LinearLayout mStageCardPredatorLayout;
    private LinearLayout mStageCardAccuracyLayout;
    private LinearLayout mStageCardTimeLayout;
    private LinearLayout mStageCardCreaturesLayout;
    private LinearLayout mStageCardStreakLayout;
    private LinearLayout mStageCardDeathLayout;
    private LinearLayout mStageCardFrenzyLayout;
    private LinearLayout mStageCardCalmLayout;
    private LinearLayout mStageCardFranticLayout;

    //
    private ImageView mStageApexBadgeImageView;
    private ImageView mStagePredatorBadgeImageView;
    private ImageView mStageAccuracyBadgeImageView;
    private ImageView mStageTimeBadgeImageView;
    private ImageView mStageCreatureKillsBadgeImageView;
    //private ImageView mStageCollectionBadgeImageView;
    private ImageView mStageHighStreakBadgeImageView;
    private ImageView mStageCloseDeathBadgeImageView;
    private ImageView mStageLongFrenzyBadgeImageView;
    private ImageView mStageMostCalmBadgeImageView;
    private ImageView mStageMostFranticBadgeImageView;

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

    private TextView mStageCardTotalCollectionTextView;

    // StageCard switch card controls
    private ImageButton mStageCardControlPrevImageButton;
    private ImageButton mStageCardControlNextImageButton;

    //
    private TextView mJourneyScoreTextView;

    //
    private TextView mEatenStageTimeTextView;

    //
    private ProgressBar mStageCardStageScoresProgressBar;
    private TextView mStageCardStageScoreTextView;

//-- GAME -->

    //
    //private TextView mDebugTextView;

    // Game titles
    private LinearLayout mGameControlLayout;

    private ImageView mGameStageImageView;
    private TextView mGameSceneTextView;

    private TextView mGameMainArea01TextView;
    private TextView mGameMainArea02TextView;
    private TextView mGameMainArea03TextView;
    private TextView mGameMainArea04TextView;
    private TextView mGameMainArea05TextView;

    //
    private LinearLayout mGameMainControlLayout;

    // Game user interfaces
    private LinearLayout mGameLevelMarkerLayout;
    private LinearLayout mGamePowersLayout;

    // Game power icons
    //private LinearLayout mGamePowerSet01Layout;
    private LinearLayout mGamePowerSet02Layout;
    private LinearLayout mGamePower01ImageView;
    private LinearLayout mGamePower02ImageView;
    private LinearLayout mGamePower03ImageView;
    private LinearLayout mGamePower04ImageView;
    private LinearLayout mGamePower05ImageView;
    private LinearLayout mGamePower06ImageView;

    // Game stage advances
    private ImageButton mGameSceneNextImageButton;

    // Game creatures
    private ImageButton mGameCreature01ImageButton;
    private ImageButton mGameCreature02ImageButton;
    private ImageButton mGameCreature03ImageButton;
    private ImageButton mGameCreature04ImageButton;
    private ImageButton mGameCreature05ImageButton;

    // Game boss
    private ImageButton mGameBossImageButton;
    private ProgressBar mGameBossHealthProgressBar;
    private ProgressBar mGameUserHealthProgressBar;
    private ProgressBar mGameAdrenalineProgressBar;

    // Game creature playground
    private FrameLayout mGameCreatureLayout;

    // Game stage border
    private RelativeLayout mGameBorderLayout;

    // Game stage tunnel
    private RelativeLayout mGameTunnelVisionLayout;

    //
    private RelativeLayout mGameBittenLayout;

    //
    private RelativeLayout mGameFlashLayout;
    private RelativeLayout mGameBloodsplatLayout;
    private RelativeLayout mGameDisasterLayout;

    //
    private ProgressBar mGameMainHungerMeterProgressBar;
    private ProgressBar mGameMainTapoutMeterProgressBar;

    private LinearLayout mGameAdrenalineLayout;

    //
    private LinearLayout mGameMainStageCaptionLayout;

//-- LOCAL DATA STORE  -->

    // Variables to store saved game data
    private static boolean continue_game;

    // Settings toggle for audio and haptic feedback
    public static boolean play_audio = true;
    public static boolean play_haptic = true;
    public static boolean play_tutorial = true;

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

    //
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

    //
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

    //
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

    //
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

    //
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

    //
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
    private static boolean mBossDowned;

    // Null screen state
    private static int mCurScreen = -1;
    private static int mStageIndex = -1;

    //
    private static boolean mStageLocked = false;
    private static boolean mTrophycase = false;
    private static boolean mTopScores = false;
    private static boolean mStageScores = false;
    private static boolean mEatenScores = false;
    private static boolean mContent = false;

    // Stage ready [1 = Locked, 2 = Ready, 3 = Complete]
    private static int mStageReady = 1;
    private static boolean mStageComplete = false;

    //
    private static int mStageFrenzy;

    // Variables for tap meter
    private static int mTapBarrel;
    private static int mTapCount;
    private static int mStreakCount;
    private static int mTapTotal;
    private static boolean mRunFlag;

    //
    private static int mBittenMeter;

    // Border timer
    private static int mBorderBarrel;

    // Timers
    private static int mPauseTimer;
    private static int mStageTimer;
    private static int mStageHeartbeat;

    // Universal variables
    private static long mSpeedIndex;
    private static int mHungerMeter = 0;
    private static int mStageAdvanceMeter;
    private static int mStageAdvanceTarget;

    // Power variables
    private static int mPowerIncrement;
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
    private static int mStageStalker;
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
    //private static int mGameAttempts;
    //private static int mGameBossKills;
    private static int mGameCreatureKills;
    private static int mGameHighestStreak;
    private static int mGameClosestDeath;
    private static int mGameLongestFrenzy;
    private static long mGameMostCalm;
    private static long mGameMostFrantic;
    private static boolean mGameTimeBest;
    //private static int mGameTimeTotal;
    private static int mGamePredator;
    private static float mGameAccuracy;
    private static boolean mGameApex;
    private static int mGameCollection;
    private static float mGameCollectionPercent;

    //
    private static int mTurn;

    //
    private static int mBossHealth;

    //
    private static List<Integer> mStageSceneImages = new ArrayList<>();
    private static List<String> mStageSceneNames = new ArrayList<>();
    private static int mEnvironmentID;

    //
    private static int mCreatureID;
    private static int mStageCreatureID;
    private static int mStageCreature01ID;
    private static int mStageCreature02ID;
    private static int mStageCreature03ID;
    private static int mStageCreature04ID;
    private static int mStageCreature05ID;
    private static List<Integer> mStageCreatureBox = new ArrayList<>();

    //
    private static List<Integer> mGameCreditsImages = new ArrayList<>();
    private static int mCreditSpinner;

    //
    private static int mRevealCreatureRandomIndex;

    //
    ArrayList<Boolean> stage_01_top_creatures_previous = new ArrayList<Boolean>(){};
    ArrayList<Boolean> stage_02_top_creatures_previous = new ArrayList<Boolean>(){};
    ArrayList<Boolean> stage_03_top_creatures_previous = new ArrayList<Boolean>(){};
    ArrayList<Boolean> stage_04_top_creatures_previous = new ArrayList<Boolean>(){};
    ArrayList<Boolean> stage_05_top_creatures_previous = new ArrayList<Boolean>(){};
    ArrayList<Boolean> stage_06_top_creatures_previous = new ArrayList<Boolean>(){};
    ArrayList<Boolean> stage_07_top_creatures_previous = new ArrayList<Boolean>(){};

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
    private static final int FLUTE_TRILL_SHORT = R.raw.pan_flute_short_audio;
    private static final int GROWL_ALERT = R.raw.game_main_growl_alert_audio;
    private static final int REVERSE_PING = R.raw.reverse_ding_10;
    //private static final int CREATURE_CAPTURE = R.raw.creature_capture;
    //private static final int CREATURE_CAUGHT = R.raw.creature_caught;
    private static final int BOSS_AUDIO = R.raw.boss_audio;

    // Run timer through executable task
    final Handler h1 = new Handler();
    final Handler h2 = new Handler();
    final Handler h3 = new Handler();
    final Handler h4 = new Handler();

    private boolean mHandlerFlag;

    // Intro credits runnable
    final Runnable r1 = new Runnable() {

            // Run task
            @Override
            public void run() {

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
            
            // Game IS NOT paused
            if (!mPauseGame) {

                // Non-Steady tasks
                gameOnTimer();
            }

            // Check creature game not expired
            if (mCreatureGameOver) {

                // End game - change from playerEaten to stageEnd
                creatureStageEnd();

            } else {

                // Increment timer
                h2.postDelayed(this, mSpeedIndex);
            }
        }
    };

    // Boss runnable
    final Runnable r3 = new Runnable() {

        // Run task
        @Override
        public void run() {

            // Game IS NOT paused
            if (!mPauseGame) {
                Log.d(TAG, "run: bossMode: game is not paused");

                // Boss mode IS NOT expired
                if (!mBossGameOver) {
                    Log.d(TAG, "run: bossMode: is not game over");

                    // User IS NOT dead AND Boss IS NOT dead
                    if (mHungerMeter > 0 && mBossHealth > 0) {
                        Log.d(TAG, "run: bossMode: hunger > 0 & bossHealth > 0");

                        // Boss IS NOT recovering
                        if (!mBossDowned) {
                            Log.d(TAG, "run: bossMode: not downed");

                            // Boss growl
                            playAudio(GROWL_ALERT);

                            // Boss move
                            moveCreature(R.id.game_main_boss_image_button, R.id.game_main_pg_creature_canvas_layout);

                            // Boss strike
                            --mHungerMeter;
                            --mHungerMeter;
                            --mHungerMeter;
                            mGameUserHealthProgressBar.setProgress((int) getPercentage(20, mHungerMeter));

                            // Update bite marks
                            mBittenMeter = mBittenMeter + 2;
                            Random r = new Random();
                            mGameBittenLayout.setBackground(versionCheck(BITTEN_IMAGES[r.nextInt(BITTEN_IMAGES.length - 1)]));

                        // Boss IS recovering
                        } else {
                            Log.d(TAG, "run: bossMode: is downed");

                            // Boss recovered
                            mBossDowned = false;

                            // User growl
                            playAudio(YETI_CRY);
                        }

                        // Increment timer
                        h3.postDelayed(this, 2000);

                        //
                        setStage();

                        // Update bite marks
                        --mBittenMeter;
                        updateBitten();

                    // User IS dead OR boss IS dead
                    } else {

                        // Sort it out here
                        bossStageEnd();
                    }

                // Boss mode IS expired
                } else {

                    // Sort it out here
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

            //
            if (!mBossGameOver && !mCreatureGameOver) {

                //
                h4.postDelayed(this, 2000);

                //
                if (mPauseGame) {

                    // Pause timer is running
                    if (mPauseTimer > 0) {

                        // Decrement timer
                        --mPauseTimer;

                        // Pause timer has expired
                    } else if (mPauseTimer != -1) {

                        // Retire timer
                        mPauseGame = false;
                        mPauseTimer = -1;
                    }
                }

                //
                gameOnSteady();
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

        // Initiate runnables
        mHandlerFlag = true;

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
        //mEntryScoreApexLayout = findViewById(R.id.entry_score_apex_layout);
        mEntryMainControlLayout = findViewById(R.id.entry_main_control_layout);
        mEntryContinueImageButton = findViewById(R.id.entry_main_continue_image_button);
        mEntryCreditsImageButton = findViewById(R.id.entry_main_credits_image_button);

        // Stage select toggle views
        mStageSelectScorecardImageButton = findViewById(R.id.stage_select_scorecard_image_button);
        mStageSelectCollectionImageButton = findViewById(R.id.stage_select_trophycase_image_button);
        mStageSelectContentImageButton = findViewById(R.id.stage_select_content_title_image_button);

        //
        mStageSelectMainScorecardLayout = findViewById(R.id.stage_select_main_scorecard_layout);
        mStageSelectMainCollectionLayout = findViewById(R.id.stage_select_main_trophy_layout);
        mStageSelectMainContentLayout = findViewById(R.id.stage_select_main_content_title_layout);

        //
        mStageSelectScorecardLayout = findViewById(R.id.stage_select_scorecard_layout);
        mStageSelectCollectionLayout = findViewById(R.id.stage_select_trophycase_layout);
        mStageSelectContentLayout = findViewById(R.id.stage_stage_selectcard_layout);

        //
        mStageSelectContentProgressBar = findViewById(R.id.stage_select_progress_bar);
        mStageSelectTopScoresProgressBar = findViewById(R.id.stage_select_top_scores_progress_bar);
        mStageSelectTrophycaseProgressBar = findViewById(R.id.stage_select_trophycase_progress_bar);

        // EOBE top scores
        mGameTrophyScoreTextView = findViewById(R.id.stage_select_trophycase_footer_count_text_view);
        mGameTrophyPercentTextView = findViewById(R.id.stage_select_trophycase_footer_percent_text_view);

        mJourneyScoreTextView = findViewById(R.id.stage_select_journey_score_text_view);
        mGameScoreTextView = findViewById(R.id.stage_select_game_score_text_view);

        //
        mEOBEApexScoreBadgeImageView = findViewById(R.id.stage_select_eobe_score_apex_badge_image_view);
        mEOBEPredatorScoreBadgeImageView = findViewById(R.id.stage_select_eobe_score_predator_badge_image_view);
        mEOBEAccuracyScoreBadgeImageView = findViewById(R.id.stage_select_eobe_score_accuracy_badge_image_view);
        mEOBETimeBestScoreBadgeImageView = findViewById(R.id.stage_select_eobe_score_best_time_badge_image_view);
        //mEOBETimeTotalScoreBadgeImageView = findViewById(R.id.stage_select_eobe_score_total_time_badge_image_view);
        //mEOBECollectionScoreBadgeImageView = findViewById(R.id.stage_select_eobe_score_collection_badge_image_view);
        //mEOBEAttemptsScoreBadgeImageView = findViewById(R.id.stage_select_eobo_score_total_attempts_badge_image_view);
        //mEOBEBossKillsScoreBadgeImageView = findViewById(R.id.stage_select_eobe_score_total_boss_kills_badge_image_view);
        mEOBECreatureKillsScoreBadgeImageView = findViewById(R.id.stage_select_eobe_score_total_creature_kills_badge_image_view);
        mEOBEHighStreakScoreBadgeImageView = findViewById(R.id.stage_select_eobe_score_high_streak_badge_image_view);
        mEOBECloseDeathScoreBadgeImageView = findViewById(R.id.stage_select_eobe_score_close_death_badge_image_view);
        mEOBELongFrenzyScoreBadgeImageView = findViewById(R.id.stage_select_eobe_score_long_frenzy_badge_image_view);
        mEOBEMostCalmScoreBadgeImageView = findViewById(R.id.stage_select_eobe_score_most_calm_badge_image_view);
        mEOBEMostFranticScoreBadgeImageView = findViewById(R.id.stage_select_eobe_score_most_frantic_badge_image_view);

        //
        mGameApexLayout = findViewById(R.id.stage_select_score_apex_layout);
        mGamePredatorLayout = findViewById(R.id.stage_select_score_predator_layout);
        mGameAccuracyLayout = findViewById(R.id.stage_select_score_accuracy_layout);
        mGameTimeLayout = findViewById(R.id.stage_select_score_time_best_layout);
        mGameEatenLayout = findViewById(R.id.stage_select_score_creature_layout);
        mGameStreakLayout = findViewById(R.id.stage_select_score_streak_layout);
        mGameDeathLayout = findViewById(R.id.stage_select_score_death_layout);
        mGameFrenzyLayout = findViewById(R.id.stage_select_score_frenzy_layout);
        mGameCalmLayout = findViewById(R.id.stage_select_score_calm_layout);
        mGameFranticLayout = findViewById(R.id.stage_select_score_frantic_layout);

        //
        mApexRunningTextView = findViewById(R.id.apex_running_text_view);
        mPredatorRunningTextView = findViewById(R.id.predator_running_text_view);
        mAccuracyRunningTextView = findViewById(R.id.accuracy_running_text_view);
        mTimeRunningTextView = findViewById(R.id.time_running_text_view);
        mCreatureRunningTextView = findViewById(R.id.creature_running_text_view);
        mStreakRunningTextView = findViewById(R.id.streak_running_text_view);
        mClosestRunningTextView = findViewById(R.id.closest_running_text_view);
        mFrenzyRunningTextView = findViewById(R.id.frenzy_running_text_view);
        mCalmRunningTextView = findViewById(R.id.calm_running_text_view);
        mFranticRunningTextView = findViewById(R.id.frantic_running_text_view);

        // Boss trophy case
        mEOBEStage01TrophyImageView = findViewById(R.id.stage_select_trophy_01_image_view);
        mEOBEStage02TrophyImageView = findViewById(R.id.stage_select_trophy_02_image_view);
        mEOBEStage03TrophyImageView = findViewById(R.id.stage_select_trophy_03_image_view);
        mEOBEStage04TrophyImageView = findViewById(R.id.stage_select_trophy_04_image_view);
        mEOBEStage05TrophyImageView = findViewById(R.id.stage_select_trophy_05_image_view);
        mEOBEStage06TrophyImageView = findViewById(R.id.stage_select_trophy_06_image_view);
        mEOBEStage07TrophyImageView = findViewById(R.id.stage_select_trophy_07_image_view);

        // Stage card views
        //mStageCardStatusImageView = findViewById(R.id.stage_card_status_image_view);
        mStageCardLockedImageButton = findViewById(R.id.stage_card_locked_image_button);
        mStageCardTrophyImageButton = findViewById(R.id.stage_card_trophy_image_button);
        mStageCardHiScoreImageButton = findViewById(R.id.stage_card_hiscore_image_button);
        mStageCardStageScoreImageButton = findViewById(R.id.stage_card_stagescore_image_button);
        mStageCardEatenImageButton = findViewById(R.id.stage_card_eaten_image_button);
        mStageCardContentImageButton = findViewById(R.id.stage_card_content_image_button);

        //
        mStageCardMainTrophyLayout = findViewById(R.id.stage_card_main_trophy_layout);
        mStageCardMainHiScoreLayout = findViewById(R.id.stage_card_main_hiscore_layout);
        mStageCardMainStageScoreLayout = findViewById(R.id.stage_card_main_stagescore_layout);
        mStageCardMainEatenLayout = findViewById(R.id.stage_card_main_eaten_layout);
        mStageCardMainContentLayout = findViewById(R.id.stage_card_main_content_layout);

        //
        mStageCardTrophycaseProgressBar = findViewById(R.id.stage_card_trophycase_progress_bar);
        mStageCardTopScoresProgressbar = findViewById(R.id.stage_card_top_scores_progress_bar);
        mStageCardStageScoresProgressBar = findViewById(R.id.stage_card_stage_scores_progress_bar);

        //
        mStageCardScreenBodyLayout = findViewById(R.id.stage_card_screen_main_layout);

        //
        mStageCardContentTitleLayout = findViewById(R.id.stage_card_content_title_layout);
        mStageCardContentTitleImageButton = findViewById(R.id.stage_card_content_title_image_button);
        mStageCardBossNameTextView = findViewById(R.id.stage_card_boss_name_text_view);

        //
        mStageCardContentLayout = findViewById(R.id.stage_card_content_layout);
        mStageCardDisasterBGImageView = findViewById(R.id.stage_card_disaster_bg_image_view);
        mStageCardBossImageView = findViewById(R.id.stage_card_boss_image_view);

        //
        mStageCardScorecardLayout = findViewById(R.id.stage_card_stagescore_layout);
        mStageCardCollectionLayout = findViewById(R.id.stage_card_trophy_layout);
        mStageCardTopScoreLayout = findViewById(R.id.stage_card_hiscore_layout);
        mStageCardStageLockedLayout = findViewById(R.id.stage_card_stage_locked_layout);
        mStageCardEatenScoreLayout = findViewById(R.id.stage_card_eaten_score_layout);

        // stage complete
        //mStageApexPredatorTextView = findViewById(R.id.stage_card_apex_predator_score_text_view);
        //mStagePredatorTextView = findViewById(R.id.stage_card_predator_score_text_view);
        //mStageAccuracyTextView = findViewById(R.id.stage_card_accuracy_score_text_view);

        // stage complete
        //mStageTimeTextView = findViewById(R.id.stage_card_time_score_text_view);
        //mStageCreatureKillsTextView = findViewById(R.id.stage_card_eaten_score_text_view);
        //mStageCollectionTextView = findViewById(R.id.stage_card_collection_score_text_view);

        // stage complete
        //mStageHighestStreakTextView = findViewById(R.id.stage_card_streak_score_text_view);
        //mStageClosestDeathTextView = findViewById(R.id.stage_card_death_score_text_view);
        //mStageLongestFrenzyTextView = findViewById(R.id.stage_card_frenzy_score_text_view);
        //mStageMostCalmTextView = findViewById(R.id.stage_card_calm_score_text_view);
        //mStageMostFranticTextView = findViewById(R.id.stage_card_frantic_score_text_view);

        //
        mStageApexBadgeImageView = findViewById(R.id.stage_card_stage_score_apex_badge_image_view);
        mStagePredatorBadgeImageView = findViewById(R.id.stage_card_stage_score_predator_badge_image_view);
        mStageAccuracyBadgeImageView = findViewById(R.id.stage_card_stage_score_accuracy_badge_image_view);
        mStageTimeBadgeImageView = findViewById(R.id.stage_card_stage_score_time_badge_image_view);
        mStageCreatureKillsBadgeImageView = findViewById(R.id.stage_card_stage_score_total_eaten_badge_image_view);
        //mStageCollectionBadgeImageView = findViewById(R.id.stage_card_stage_score_collection_badge_image_view);
        mStageHighStreakBadgeImageView = findViewById(R.id.stage_card_stage_score_high_streak_badge_image_view);
        mStageCloseDeathBadgeImageView = findViewById(R.id.stage_card_stage_score_close_death_badge_image_view);
        mStageLongFrenzyBadgeImageView = findViewById(R.id.stage_card_stage_score_long_frenzy_badge_image_view);
        mStageMostCalmBadgeImageView = findViewById(R.id.stage_card_stage_score_most_calm_badge_image_view);
        mStageMostFranticBadgeImageView = findViewById(R.id.stage_card_stage_score_most_frantic_badge_image_view);

        //
        mStageCardApexLayout = findViewById(R.id.stage_card_apex_layout);
        mStageCardPredatorLayout = findViewById(R.id.stage_card_predator_layout);
        mStageCardAccuracyLayout = findViewById(R.id.stage_card_accuracy_layout);
        mStageCardTimeLayout = findViewById(R.id.stage_card_time_layout);
        mStageCardCreaturesLayout = findViewById(R.id.stage_card_eaten_layout);
        mStageCardStreakLayout = findViewById(R.id.stage_card_streak_layout);
        mStageCardDeathLayout = findViewById(R.id.stage_card_death_layout);
        mStageCardFrenzyLayout = findViewById(R.id.stage_card_frenzy_layout);
        mStageCardCalmLayout = findViewById(R.id.stage_card_calm_layout);
        mStageCardFranticLayout = findViewById(R.id.stage_card_frantic_layout);

        // top scores
        //mStageTopApexPredatorTextView = findViewById(R.id.stage_card_top_apex_score_text_view);
        //mStageTotalAttemptsTextView = findViewById(R.id.stage_card_total_attempts_score_text_view);
        //mStageTotalBossKillsTextView = findViewById(R.id.stage_card_total_boss_kills_score_text_view);
        //mStageTotalCreatureKillsTextView = findViewById(R.id.stage_card_total_creature_kills_score_text_view);
        //mStageTopHighestStreakTextView = findViewById(R.id.stage_card_top_highest_streak_score_text_view);
        //mStageTopClosestDeathTextView = findViewById(R.id.stage_card_top_closest_death_score_text_view);
        //mStageTopLongestFrenzyTextView = findViewById(R.id.stage_card_top_longest_frenzy_score_text_view);
        //mStageTopMostCalmTextView = findViewById(R.id.stage_card_top_most_calm_score_text_view);
        //mStageTopMostFranticTextView = findViewById(R.id.stage_card_top_most_frantic_score_text_view);
        //mStageTotalTimeTextView = findViewById(R.id.stage_card_total_time_score_text_view);
        //mStageTopBestTimeTextView = findViewById(R.id.stage_card_top_best_time_score_text_view);
        //mStageTopPredatorTextView = findViewById(R.id.stage_card_top_predator_score_text_view);
        //mStageTopAccuracyTextView = findViewById(R.id.stage_card_top_accuracy_score_text_view);
        //mStageTotalCollectionTextView = findViewById(R.id.stage_card_total_collection_score_text_view);
        //mStageTotalCollectionPercentTextView = findViewById(R.id.stage_card_total_collection_percent_text_view);

        //
        mStageTopApexBadgeImageView = findViewById(R.id.stage_card_top_score_apex_badge_image_view);
        mStageTotalCreatureKillsBadgeImageView = findViewById(R.id.stage_card_top_score_total_eaten_badge_image_view);
        mStageTopHighStreakBadgeImageView = findViewById(R.id.stage_card_top_score_high_streak_badge_image_view);
        mStageTopCloseDeathBadgeImageView = findViewById(R.id.stage_card_top_score_close_death_badge_image_view);
        mStageTopLongFrenzyBadgeImageView = findViewById(R.id.stage_card_top_score_long_frenzy_badge_image_view);
        mStageTopMostCalmBadgeImageView = findViewById(R.id.stage_card_top_score_most_calm_badge_image_view);
        mStageTopMostFranticBadgeImageView = findViewById(R.id.stage_card_top_score_most_frantic_badge_image_view);
        mStageTopBestTimeBadgeImageView = findViewById(R.id.stage_card_top_score_best_time_badge_image_view);
        mStageTopPredatorBadgeImageView = findViewById(R.id.stage_card_top_score_predator_badge_image_view);
        mStageTopAccuracyBadgeImageView = findViewById(R.id.stage_card_top_score_accuracy_badge_image_view);
        //mStageTotalCollectionBadgeImageView = findViewById(R.id.stage_card_top_score_collection_badge_image_view);

        //
        mStageCardTopApexLayout = findViewById(R.id.stage_card_top_apex_layout);
        mStageCardTopPredatorLayout = findViewById(R.id.stage_card_top_predator_layout);
        mStageCardTopAccuracyLayout = findViewById(R.id.stage_card_top_accuracy_layout);
        mStageCardTopTimeLayout = findViewById(R.id.stage_card_top_best_time_layout);
        mStageCardTopEatenLayout = findViewById(R.id.stage_card_total_creature_kills_layout);
        mStageCardTopStreakLayout = findViewById(R.id.stage_card_top_highest_streak_layout);
        mStageCardTopDeathLayout = findViewById(R.id.stage_card_top_closest_death_layout);
        mStageCardTopFrenzyLayout = findViewById(R.id.stage_card_top_longest_frenzy_layout);
        mStageCardTopCalmLayout = findViewById(R.id.stage_card_top_most_calm_layout);
        mStageCardTopFranticLayout = findViewById(R.id.stage_card_top_most_frantic_layout);

        // Stage card - switch ui
        mStageCardControlPrevImageButton = findViewById(R.id.stage_card_control_prev_image_button);
        mStageCardControlNextImageButton = findViewById(R.id.stage_card_control_next_image_button);

        //
        mEatenStageTimeTextView = findViewById(R.id.eaten_stage_time_text_view);

        //mStageScoreFinalScoreTextView = findViewById(R.id.stage_score_final_score_text_view);
        mTopScoreProgressScoreTextView = findViewById(R.id.top_score_progress_score_text_view);

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

        mStageCardTotalCollectionTextView = findViewById(R.id.stage_card_total_collection_score_text_view);

        mStageCardStageScoreTextView = findViewById(R.id.stage_score_final_score_text_view);

        // Game control layout
        mGameControlLayout = findViewById(R.id.game_main_title_image_layout);
        mGameMainControlLayout = findViewById(R.id.game_main_control_layout);

        // Stage label
        mGameStageImageView = findViewById(R.id.game_main_stage_image_view);
        mGameSceneTextView = findViewById(R.id.game_main_scene_text_view);

        mGameMainArea01TextView = findViewById(R.id.game_main_area_01_text_view);
        mGameMainArea02TextView = findViewById(R.id.game_main_area_02_text_view);
        mGameMainArea03TextView = findViewById(R.id.game_main_area_03_text_view);
        mGameMainArea04TextView = findViewById(R.id.game_main_area_04_text_view);
        mGameMainArea05TextView = findViewById(R.id.game_main_area_05_text_view);

        //
        //mDebugTextView = findViewById(R.id.debug_text_view);

        // Stage UI
        mGameLevelMarkerLayout = findViewById(R.id.game_main_level_marker_layout);
        mGamePowersLayout = findViewById(R.id.game_main_powers_layout);

        //
        mGameSceneNextImageButton = findViewById(R.id.game_scene_next_image_button);
        //mStageDisasterImageView = findViewById(R.id.game_main_stage_advance_image_view);

        // Power icons
        //mGamePowerSet01Layout = findViewById(R.id.game_main_power_set_01_layout);
        mGamePowerSet02Layout = findViewById(R.id.game_main_power_set_02_layout);
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
        mGameBossHealthProgressBar = findViewById(R.id.game_main_boss_health_progress_bar);
        mGameUserHealthProgressBar = findViewById(R.id.game_main_user_health_progress_bar);

        // Playgrounds
        mGameCreatureLayout = findViewById(R.id.game_main_creature_layout);
        //mGameBossLayout = findViewById(R.id.game_main_boss_layout);

        // Stage camouflage
        mGameBorderLayout = findViewById(R.id.game_main_silhouette_border_layout);

        // Boss sneak
        mGameTunnelVisionLayout = findViewById(R.id.game_main_tunnel_vision_layout);

        //
        mGameBittenLayout = findViewById(R.id.game_main_bitten_layout);

        //
        mGameFlashLayout = findViewById(R.id.game_main_flash_layout);
        mGameBloodsplatLayout = findViewById(R.id.game_main_bloodsplat_layout);
        mGameDisasterLayout = findViewById(R.id.game_main_disaster_layout);

        //
        mGameMainHungerMeterProgressBar = findViewById(R.id.game_main_hunger_meter_progress_bar);
        mGameMainTapoutMeterProgressBar = findViewById(R.id.game_main_tapout_progress_bar);
        //mGameAdrenalineProgressBar = findViewById(R.id.game_main_adrenaline_progress_bar);

        mGameAdrenalineLayout = findViewById(R.id.game_main_adrenaline_layout);

        //
        //mGameMainStageCaptionLayout = findViewById(R.id.game_main_stage_caption_layout);
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

        //
        int i = 0;

        //
        for (boolean creature : stage_01_top_creatures_previous) {

            //
            if (creature) {

                //
                mEditorSet.putBoolean(top_creature_previous_string_01[i], true);
            }

            //
            i++;
        }

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

        //
        i = 0;

        //
        for (boolean creature : stage_02_top_creatures_previous) {

            //
            if (creature) {

                //
                mEditorSet.putBoolean(top_creature_previous_string_02[i], true);
            }

            //
            i++;
        }

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

        //
        i = 0;

        //
        for (boolean creature : stage_03_top_creatures_previous) {

            //
            if (creature) {

                //
                mEditorSet.putBoolean(top_creature_previous_string_03[i], true);
            }

            //
            i++;
        }

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

        //
        i = 0;

        //
        for (boolean creature : stage_04_top_creatures_previous) {

            //
            if (creature) {

                //
                mEditorSet.putBoolean(top_creature_previous_string_04[i], true);
            }

            //
            i++;
        }

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

        //
        i = 0;

        //
        for (boolean creature : stage_05_top_creatures_previous) {

            //
            if (creature) {

                //
                mEditorSet.putBoolean(top_creature_previous_string_05[i], true);
            }

            //
            i++;
        }

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

        //
        i = 0;

        //
        for (boolean creature : stage_06_top_creatures_previous) {

            //
            if (creature) {

                //
                mEditorSet.putBoolean(top_creature_previous_string_06[i], true);
            }

            //
            i++;
        }

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
        i = 0;

        //
        for (boolean creature : stage_07_top_creatures_previous) {

            //
            if (creature) {

                //
                mEditorSet.putBoolean(top_creature_previous_string_07[i], true);
            }

            //
            i++;
        }

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

// -- STAGE 1 -->
        //
        stage_01_complete = mUserPrefGet.getBoolean(STAGE_01_COMPLETE, false);

        //
        stage_01_attempts = mUserPrefGet.getInt(STAGE_01_ATTEMPTS, 0);
        stage_01_boss_kills = mUserPrefGet.getInt(STAGE_01_BOSS_KILLS, 0);
        stage_01_creature_kills = mUserPrefGet.getInt(STAGE_01_CREATURE_KILLS, 0);

        //
        //
        boolean stage_01_creature_01 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_01, false);
        boolean stage_01_creature_02 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_02, false);
        boolean stage_01_creature_03 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_03, false);
        boolean stage_01_creature_04 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_04, false);
        boolean stage_01_creature_05 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_05, false);
        boolean stage_01_creature_06 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_06, false);
        boolean stage_01_creature_07 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_07, false);
        boolean stage_01_creature_08 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_08, false);
        boolean stage_01_creature_09 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_09, false);
        boolean stage_01_creature_10 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_10, false);
        boolean stage_01_creature_11 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_11, false);
        boolean stage_01_creature_12 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_12, false);
        boolean stage_01_creature_13 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_13, false);
        boolean stage_01_creature_14 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_14, false);
        boolean stage_01_creature_15 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_15, false);
        boolean stage_01_creature_16 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_16, false);
        boolean stage_01_creature_17 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_17, false);
        boolean stage_01_creature_18 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_18, false);
        boolean stage_01_creature_19 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_19, false);
        boolean stage_01_creature_20 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_20, false);
        boolean stage_01_creature_21 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_21, false);
        boolean stage_01_creature_22 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_22, false);
        boolean stage_01_creature_23 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_23, false);
        boolean stage_01_creature_24 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_24, false);
        boolean stage_01_creature_25 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_25, false);
        boolean stage_01_creature_26 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_26, false);
        boolean stage_01_creature_27 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_27, false);
        boolean stage_01_creature_28 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_28, false);
        boolean stage_01_creature_29 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_29, false);
        boolean stage_01_creature_30 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_30, false);
        boolean stage_01_creature_31 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_31, false);
        boolean stage_01_creature_32 = mUserPrefGet.getBoolean(STAGE_01_CREATURE_32, false);

        //
        stage_01_top_creatures_previous.clear();
        stage_01_top_creatures_previous.add(stage_01_creature_01);
        stage_01_top_creatures_previous.add(stage_01_creature_02);
        stage_01_top_creatures_previous.add(stage_01_creature_03);
        stage_01_top_creatures_previous.add(stage_01_creature_04);
        stage_01_top_creatures_previous.add(stage_01_creature_05);
        stage_01_top_creatures_previous.add(stage_01_creature_06);
        stage_01_top_creatures_previous.add(stage_01_creature_07);
        stage_01_top_creatures_previous.add(stage_01_creature_08);
        stage_01_top_creatures_previous.add(stage_01_creature_09);
        stage_01_top_creatures_previous.add(stage_01_creature_10);
        stage_01_top_creatures_previous.add(stage_01_creature_11);
        stage_01_top_creatures_previous.add(stage_01_creature_12);
        stage_01_top_creatures_previous.add(stage_01_creature_13);
        stage_01_top_creatures_previous.add(stage_01_creature_14);
        stage_01_top_creatures_previous.add(stage_01_creature_15);
        stage_01_top_creatures_previous.add(stage_01_creature_16);
        stage_01_top_creatures_previous.add(stage_01_creature_17);
        stage_01_top_creatures_previous.add(stage_01_creature_18);
        stage_01_top_creatures_previous.add(stage_01_creature_19);
        stage_01_top_creatures_previous.add(stage_01_creature_20);
        stage_01_top_creatures_previous.add(stage_01_creature_21);
        stage_01_top_creatures_previous.add(stage_01_creature_22);
        stage_01_top_creatures_previous.add(stage_01_creature_23);
        stage_01_top_creatures_previous.add(stage_01_creature_24);
        stage_01_top_creatures_previous.add(stage_01_creature_25);
        stage_01_top_creatures_previous.add(stage_01_creature_26);
        stage_01_top_creatures_previous.add(stage_01_creature_27);
        stage_01_top_creatures_previous.add(stage_01_creature_28);
        stage_01_top_creatures_previous.add(stage_01_creature_29);
        stage_01_top_creatures_previous.add(stage_01_creature_30);
        stage_01_top_creatures_previous.add(stage_01_creature_31);
        stage_01_top_creatures_previous.add(stage_01_creature_32);

        //
        stage_01_collection = 0;

        //
        for (boolean creature : stage_01_top_creatures_previous) {

            //
            if (creature) { ++stage_01_collection; }
        }

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

// -- STAGE 2 -->
        //
        stage_02_complete = mUserPrefGet.getBoolean(STAGE_02_COMPLETE, false);

        //
        stage_02_attempts = mUserPrefGet.getInt(STAGE_02_ATTEMPTS, 0);
        stage_02_boss_kills = mUserPrefGet.getInt(STAGE_02_BOSS_KILLS, 0);
        stage_02_creature_kills = mUserPrefGet.getInt(STAGE_02_CREATURE_KILLS, 0);

        //
        boolean stage_02_creature_01 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_01, false);
        boolean stage_02_creature_02 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_02, false);
        boolean stage_02_creature_03 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_03, false);
        boolean stage_02_creature_04 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_04, false);
        boolean stage_02_creature_05 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_05, false);
        boolean stage_02_creature_06 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_06, false);
        boolean stage_02_creature_07 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_07, false);
        boolean stage_02_creature_08 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_08, false);
        boolean stage_02_creature_09 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_09, false);
        boolean stage_02_creature_10 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_10, false);
        boolean stage_02_creature_11 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_11, false);
        boolean stage_02_creature_12 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_12, false);
        boolean stage_02_creature_13 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_13, false);
        boolean stage_02_creature_14 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_14, false);
        boolean stage_02_creature_15 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_15, false);
        boolean stage_02_creature_16 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_16, false);
        boolean stage_02_creature_17 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_17, false);
        boolean stage_02_creature_18 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_18, false);
        boolean stage_02_creature_19 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_19, false);
        boolean stage_02_creature_20 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_20, false);
        boolean stage_02_creature_21 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_21, false);
        boolean stage_02_creature_22 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_22, false);
        boolean stage_02_creature_23 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_23, false);
        boolean stage_02_creature_24 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_24, false);
        boolean stage_02_creature_25 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_25, false);
        boolean stage_02_creature_26 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_26, false);
        boolean stage_02_creature_27 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_27, false);
        boolean stage_02_creature_28 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_28, false);
        boolean stage_02_creature_29 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_29, false);
        boolean stage_02_creature_30 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_30, false);
        boolean stage_02_creature_31 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_31, false);
        boolean stage_02_creature_32 = mUserPrefGet.getBoolean(STAGE_02_CREATURE_32, false);

        //
        stage_02_top_creatures_previous.clear();
        stage_02_top_creatures_previous.add(stage_02_creature_01);
        stage_02_top_creatures_previous.add(stage_02_creature_02);
        stage_02_top_creatures_previous.add(stage_02_creature_03);
        stage_02_top_creatures_previous.add(stage_02_creature_04);
        stage_02_top_creatures_previous.add(stage_02_creature_05);
        stage_02_top_creatures_previous.add(stage_02_creature_06);
        stage_02_top_creatures_previous.add(stage_02_creature_07);
        stage_02_top_creatures_previous.add(stage_02_creature_08);
        stage_02_top_creatures_previous.add(stage_02_creature_09);
        stage_02_top_creatures_previous.add(stage_02_creature_10);
        stage_02_top_creatures_previous.add(stage_02_creature_11);
        stage_02_top_creatures_previous.add(stage_02_creature_12);
        stage_02_top_creatures_previous.add(stage_02_creature_13);
        stage_02_top_creatures_previous.add(stage_02_creature_14);
        stage_02_top_creatures_previous.add(stage_02_creature_15);
        stage_02_top_creatures_previous.add(stage_02_creature_16);
        stage_02_top_creatures_previous.add(stage_02_creature_17);
        stage_02_top_creatures_previous.add(stage_02_creature_18);
        stage_02_top_creatures_previous.add(stage_02_creature_19);
        stage_02_top_creatures_previous.add(stage_02_creature_20);
        stage_02_top_creatures_previous.add(stage_02_creature_21);
        stage_02_top_creatures_previous.add(stage_02_creature_22);
        stage_02_top_creatures_previous.add(stage_02_creature_23);
        stage_02_top_creatures_previous.add(stage_02_creature_24);
        stage_02_top_creatures_previous.add(stage_02_creature_25);
        stage_02_top_creatures_previous.add(stage_02_creature_26);
        stage_02_top_creatures_previous.add(stage_02_creature_27);
        stage_02_top_creatures_previous.add(stage_02_creature_28);
        stage_02_top_creatures_previous.add(stage_02_creature_29);
        stage_02_top_creatures_previous.add(stage_02_creature_30);
        stage_02_top_creatures_previous.add(stage_02_creature_31);
        stage_02_top_creatures_previous.add(stage_02_creature_32);

        //
        stage_02_collection = 0;

        //
        for (boolean creature : stage_02_top_creatures_previous) {

            //
            if (creature) { ++stage_02_collection; }
        }

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

// -- STAGE 3 -->
        //
        stage_03_complete = mUserPrefGet.getBoolean(STAGE_03_COMPLETE, false);

        //
        stage_03_attempts = mUserPrefGet.getInt(STAGE_03_ATTEMPTS, 0);
        stage_03_boss_kills = mUserPrefGet.getInt(STAGE_03_BOSS_KILLS, 0);
        stage_03_creature_kills = mUserPrefGet.getInt(STAGE_03_CREATURE_KILLS, 0);

        //
        boolean stage_03_creature_01 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_01, false);
        boolean stage_03_creature_02 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_02, false);
        boolean stage_03_creature_03 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_03, false);
        boolean stage_03_creature_04 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_04, false);
        boolean stage_03_creature_05 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_05, false);
        boolean stage_03_creature_06 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_06, false);
        boolean stage_03_creature_07 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_07, false);
        boolean stage_03_creature_08 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_08, false);
        boolean stage_03_creature_09 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_09, false);
        boolean stage_03_creature_10 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_10, false);
        boolean stage_03_creature_11 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_11, false);
        boolean stage_03_creature_12 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_12, false);
        boolean stage_03_creature_13 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_13, false);
        boolean stage_03_creature_14 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_14, false);
        boolean stage_03_creature_15 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_15, false);
        boolean stage_03_creature_16 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_16, false);
        boolean stage_03_creature_17 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_17, false);
        boolean stage_03_creature_18 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_18, false);
        boolean stage_03_creature_19 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_19, false);
        boolean stage_03_creature_20 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_20, false);
        boolean stage_03_creature_21 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_21, false);
        boolean stage_03_creature_22 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_22, false);
        boolean stage_03_creature_23 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_23, false);
        boolean stage_03_creature_24 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_24, false);
        boolean stage_03_creature_25 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_25, false);
        boolean stage_03_creature_26 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_26, false);
        boolean stage_03_creature_27 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_27, false);
        boolean stage_03_creature_28 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_28, false);
        boolean stage_03_creature_29 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_29, false);
        boolean stage_03_creature_30 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_30, false);
        boolean stage_03_creature_31 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_31, false);
        boolean stage_03_creature_32 = mUserPrefGet.getBoolean(STAGE_03_CREATURE_32, false);

        //
        stage_03_top_creatures_previous.clear();
        stage_03_top_creatures_previous.add(stage_03_creature_01);
        stage_03_top_creatures_previous.add(stage_03_creature_02);
        stage_03_top_creatures_previous.add(stage_03_creature_03);
        stage_03_top_creatures_previous.add(stage_03_creature_04);
        stage_03_top_creatures_previous.add(stage_03_creature_05);
        stage_03_top_creatures_previous.add(stage_03_creature_06);
        stage_03_top_creatures_previous.add(stage_03_creature_07);
        stage_03_top_creatures_previous.add(stage_03_creature_08);
        stage_03_top_creatures_previous.add(stage_03_creature_09);
        stage_03_top_creatures_previous.add(stage_03_creature_10);
        stage_03_top_creatures_previous.add(stage_03_creature_11);
        stage_03_top_creatures_previous.add(stage_03_creature_12);
        stage_03_top_creatures_previous.add(stage_03_creature_13);
        stage_03_top_creatures_previous.add(stage_03_creature_14);
        stage_03_top_creatures_previous.add(stage_03_creature_15);
        stage_03_top_creatures_previous.add(stage_03_creature_16);
        stage_03_top_creatures_previous.add(stage_03_creature_17);
        stage_03_top_creatures_previous.add(stage_03_creature_18);
        stage_03_top_creatures_previous.add(stage_03_creature_19);
        stage_03_top_creatures_previous.add(stage_03_creature_20);
        stage_03_top_creatures_previous.add(stage_03_creature_21);
        stage_03_top_creatures_previous.add(stage_03_creature_22);
        stage_03_top_creatures_previous.add(stage_03_creature_23);
        stage_03_top_creatures_previous.add(stage_03_creature_24);
        stage_03_top_creatures_previous.add(stage_03_creature_25);
        stage_03_top_creatures_previous.add(stage_03_creature_26);
        stage_03_top_creatures_previous.add(stage_03_creature_27);
        stage_03_top_creatures_previous.add(stage_03_creature_28);
        stage_03_top_creatures_previous.add(stage_03_creature_29);
        stage_03_top_creatures_previous.add(stage_03_creature_30);
        stage_03_top_creatures_previous.add(stage_03_creature_31);
        stage_03_top_creatures_previous.add(stage_03_creature_32);


        //
        stage_03_collection = 0;

        //
        for (boolean creature : stage_03_top_creatures_previous) {

            //
            if (creature) { ++stage_03_collection; }
        }

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

// -- STAGE 4 -->
        //
        stage_04_complete = mUserPrefGet.getBoolean(STAGE_04_COMPLETE, false);

        //
        stage_04_attempts = mUserPrefGet.getInt(STAGE_04_ATTEMPTS, 0);
        stage_04_boss_kills = mUserPrefGet.getInt(STAGE_04_BOSS_KILLS, 0);
        stage_04_creature_kills = mUserPrefGet.getInt(STAGE_04_CREATURE_KILLS, 0);

        //
        boolean stage_04_creature_01 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_01, false);
        boolean stage_04_creature_02 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_02, false);
        boolean stage_04_creature_03 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_03, false);
        boolean stage_04_creature_04 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_04, false);
        boolean stage_04_creature_05 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_05, false);
        boolean stage_04_creature_06 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_06, false);
        boolean stage_04_creature_07 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_07, false);
        boolean stage_04_creature_08 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_08, false);
        boolean stage_04_creature_09 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_09, false);
        boolean stage_04_creature_10 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_10, false);
        boolean stage_04_creature_11 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_11, false);
        boolean stage_04_creature_12 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_12, false);
        boolean stage_04_creature_13 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_13, false);
        boolean stage_04_creature_14 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_14, false);
        boolean stage_04_creature_15 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_15, false);
        boolean stage_04_creature_16 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_16, false);
        boolean stage_04_creature_17 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_17, false);
        boolean stage_04_creature_18 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_18, false);
        boolean stage_04_creature_19 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_19, false);
        boolean stage_04_creature_20 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_20, false);
        boolean stage_04_creature_21 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_21, false);
        boolean stage_04_creature_22 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_22, false);
        boolean stage_04_creature_23 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_23, false);
        boolean stage_04_creature_24 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_24, false);
        boolean stage_04_creature_25 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_25, false);
        boolean stage_04_creature_26 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_26, false);
        boolean stage_04_creature_27 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_27, false);
        boolean stage_04_creature_28 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_28, false);
        boolean stage_04_creature_29 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_29, false);
        boolean stage_04_creature_30 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_30, false);
        boolean stage_04_creature_31 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_31, false);
        boolean stage_04_creature_32 = mUserPrefGet.getBoolean(STAGE_04_CREATURE_32, false);

        //
        stage_04_top_creatures_previous.clear();
        stage_04_top_creatures_previous.add(stage_04_creature_01);
        stage_04_top_creatures_previous.add(stage_04_creature_02);
        stage_04_top_creatures_previous.add(stage_04_creature_03);
        stage_04_top_creatures_previous.add(stage_04_creature_04);
        stage_04_top_creatures_previous.add(stage_04_creature_05);
        stage_04_top_creatures_previous.add(stage_04_creature_06);
        stage_04_top_creatures_previous.add(stage_04_creature_07);
        stage_04_top_creatures_previous.add(stage_04_creature_08);
        stage_04_top_creatures_previous.add(stage_04_creature_09);
        stage_04_top_creatures_previous.add(stage_04_creature_10);
        stage_04_top_creatures_previous.add(stage_04_creature_11);
        stage_04_top_creatures_previous.add(stage_04_creature_12);
        stage_04_top_creatures_previous.add(stage_04_creature_13);
        stage_04_top_creatures_previous.add(stage_04_creature_14);
        stage_04_top_creatures_previous.add(stage_04_creature_15);
        stage_04_top_creatures_previous.add(stage_04_creature_16);
        stage_04_top_creatures_previous.add(stage_04_creature_17);
        stage_04_top_creatures_previous.add(stage_04_creature_18);
        stage_04_top_creatures_previous.add(stage_04_creature_19);
        stage_04_top_creatures_previous.add(stage_04_creature_20);
        stage_04_top_creatures_previous.add(stage_04_creature_21);
        stage_04_top_creatures_previous.add(stage_04_creature_22);
        stage_04_top_creatures_previous.add(stage_04_creature_23);
        stage_04_top_creatures_previous.add(stage_04_creature_24);
        stage_04_top_creatures_previous.add(stage_04_creature_25);
        stage_04_top_creatures_previous.add(stage_04_creature_26);
        stage_04_top_creatures_previous.add(stage_04_creature_27);
        stage_04_top_creatures_previous.add(stage_04_creature_28);
        stage_04_top_creatures_previous.add(stage_04_creature_29);
        stage_04_top_creatures_previous.add(stage_04_creature_30);
        stage_04_top_creatures_previous.add(stage_04_creature_31);
        stage_04_top_creatures_previous.add(stage_04_creature_32);

        //
        stage_04_collection = 0;

        //
        for (boolean creature : stage_04_top_creatures_previous) {

            //
            if (creature) { ++stage_04_collection; }
        }

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

// -- STAGE 5 -->
        //
        stage_05_complete = mUserPrefGet.getBoolean(STAGE_05_COMPLETE, false);

        //
        stage_05_attempts = mUserPrefGet.getInt(STAGE_05_ATTEMPTS, 0);
        stage_05_boss_kills = mUserPrefGet.getInt(STAGE_05_BOSS_KILLS, 0);
        stage_05_creature_kills = mUserPrefGet.getInt(STAGE_05_CREATURE_KILLS, 0);

        //
        boolean stage_05_creature_01 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_01, false);
        boolean stage_05_creature_02 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_02, false);
        boolean stage_05_creature_03 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_03, false);
        boolean stage_05_creature_04 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_04, false);
        boolean stage_05_creature_05 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_05, false);
        boolean stage_05_creature_06 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_06, false);
        boolean stage_05_creature_07 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_07, false);
        boolean stage_05_creature_08 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_08, false);
        boolean stage_05_creature_09 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_09, false);
        boolean stage_05_creature_10 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_10, false);
        boolean stage_05_creature_11 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_11, false);
        boolean stage_05_creature_12 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_12, false);
        boolean stage_05_creature_13 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_13, false);
        boolean stage_05_creature_14 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_14, false);
        boolean stage_05_creature_15 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_15, false);
        boolean stage_05_creature_16 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_16, false);
        boolean stage_05_creature_17 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_17, false);
        boolean stage_05_creature_18 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_18, false);
        boolean stage_05_creature_19 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_19, false);
        boolean stage_05_creature_20 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_20, false);
        boolean stage_05_creature_21 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_21, false);
        boolean stage_05_creature_22 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_22, false);
        boolean stage_05_creature_23 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_23, false);
        boolean stage_05_creature_24 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_24, false);
        boolean stage_05_creature_25 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_25, false);
        boolean stage_05_creature_26 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_26, false);
        boolean stage_05_creature_27 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_27, false);
        boolean stage_05_creature_28 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_28, false);
        boolean stage_05_creature_29 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_29, false);
        boolean stage_05_creature_30 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_30, false);
        boolean stage_05_creature_31 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_31, false);
        boolean stage_05_creature_32 = mUserPrefGet.getBoolean(STAGE_05_CREATURE_32, false);

        //
        stage_05_top_creatures_previous.clear();
        stage_05_top_creatures_previous.add(stage_05_creature_01);
        stage_05_top_creatures_previous.add(stage_05_creature_02);
        stage_05_top_creatures_previous.add(stage_05_creature_03);
        stage_05_top_creatures_previous.add(stage_05_creature_04);
        stage_05_top_creatures_previous.add(stage_05_creature_05);
        stage_05_top_creatures_previous.add(stage_05_creature_06);
        stage_05_top_creatures_previous.add(stage_05_creature_07);
        stage_05_top_creatures_previous.add(stage_05_creature_08);
        stage_05_top_creatures_previous.add(stage_05_creature_09);
        stage_05_top_creatures_previous.add(stage_05_creature_10);
        stage_05_top_creatures_previous.add(stage_05_creature_11);
        stage_05_top_creatures_previous.add(stage_05_creature_12);
        stage_05_top_creatures_previous.add(stage_05_creature_13);
        stage_05_top_creatures_previous.add(stage_05_creature_14);
        stage_05_top_creatures_previous.add(stage_05_creature_15);
        stage_05_top_creatures_previous.add(stage_05_creature_16);
        stage_05_top_creatures_previous.add(stage_05_creature_17);
        stage_05_top_creatures_previous.add(stage_05_creature_18);
        stage_05_top_creatures_previous.add(stage_05_creature_19);
        stage_05_top_creatures_previous.add(stage_05_creature_20);
        stage_05_top_creatures_previous.add(stage_05_creature_21);
        stage_05_top_creatures_previous.add(stage_05_creature_22);
        stage_05_top_creatures_previous.add(stage_05_creature_23);
        stage_05_top_creatures_previous.add(stage_05_creature_24);
        stage_05_top_creatures_previous.add(stage_05_creature_25);
        stage_05_top_creatures_previous.add(stage_05_creature_26);
        stage_05_top_creatures_previous.add(stage_05_creature_27);
        stage_05_top_creatures_previous.add(stage_05_creature_28);
        stage_05_top_creatures_previous.add(stage_05_creature_29);
        stage_05_top_creatures_previous.add(stage_05_creature_30);
        stage_05_top_creatures_previous.add(stage_05_creature_31);
        stage_05_top_creatures_previous.add(stage_05_creature_32);

        //
        stage_05_collection = 0;

        //
        for (boolean creature : stage_05_top_creatures_previous) {

            //
            if (creature) { ++stage_05_collection; }
        }

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

// -- STAGE 6 -->
        //
        stage_06_complete = mUserPrefGet.getBoolean(STAGE_06_COMPLETE, false);

        //
        stage_06_attempts = mUserPrefGet.getInt(STAGE_06_ATTEMPTS, 0);
        stage_06_boss_kills = mUserPrefGet.getInt(STAGE_06_BOSS_KILLS, 0);
        stage_06_creature_kills = mUserPrefGet.getInt(STAGE_06_CREATURE_KILLS, 0);

        //
        boolean stage_06_creature_01 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_01, false);
        boolean stage_06_creature_02 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_02, false);
        boolean stage_06_creature_03 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_03, false);
        boolean stage_06_creature_04 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_04, false);
        boolean stage_06_creature_05 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_05, false);
        boolean stage_06_creature_06 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_06, false);
        boolean stage_06_creature_07 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_07, false);
        boolean stage_06_creature_08 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_08, false);
        boolean stage_06_creature_09 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_09, false);
        boolean stage_06_creature_10 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_10, false);
        boolean stage_06_creature_11 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_11, false);
        boolean stage_06_creature_12 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_12, false);
        boolean stage_06_creature_13 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_13, false);
        boolean stage_06_creature_14 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_14, false);
        boolean stage_06_creature_15 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_15, false);
        boolean stage_06_creature_16 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_16, false);
        boolean stage_06_creature_17 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_17, false);
        boolean stage_06_creature_18 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_18, false);
        boolean stage_06_creature_19 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_19, false);
        boolean stage_06_creature_20 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_20, false);
        boolean stage_06_creature_21 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_21, false);
        boolean stage_06_creature_22 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_22, false);
        boolean stage_06_creature_23 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_23, false);
        boolean stage_06_creature_24 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_24, false);
        boolean stage_06_creature_25 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_25, false);
        boolean stage_06_creature_26 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_26, false);
        boolean stage_06_creature_27 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_27, false);
        boolean stage_06_creature_28 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_28, false);
        boolean stage_06_creature_29 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_29, false);
        boolean stage_06_creature_30 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_30, false);
        boolean stage_06_creature_31 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_31, false);
        boolean stage_06_creature_32 = mUserPrefGet.getBoolean(STAGE_06_CREATURE_32, false);

        //
        stage_06_top_creatures_previous.clear();
        stage_06_top_creatures_previous.add(stage_06_creature_01);
        stage_06_top_creatures_previous.add(stage_06_creature_02);
        stage_06_top_creatures_previous.add(stage_06_creature_03);
        stage_06_top_creatures_previous.add(stage_06_creature_04);
        stage_06_top_creatures_previous.add(stage_06_creature_05);
        stage_06_top_creatures_previous.add(stage_06_creature_06);
        stage_06_top_creatures_previous.add(stage_06_creature_07);
        stage_06_top_creatures_previous.add(stage_06_creature_08);
        stage_06_top_creatures_previous.add(stage_06_creature_09);
        stage_06_top_creatures_previous.add(stage_06_creature_10);
        stage_06_top_creatures_previous.add(stage_06_creature_11);
        stage_06_top_creatures_previous.add(stage_06_creature_12);
        stage_06_top_creatures_previous.add(stage_06_creature_13);
        stage_06_top_creatures_previous.add(stage_06_creature_14);
        stage_06_top_creatures_previous.add(stage_06_creature_15);
        stage_06_top_creatures_previous.add(stage_06_creature_16);
        stage_06_top_creatures_previous.add(stage_06_creature_17);
        stage_06_top_creatures_previous.add(stage_06_creature_18);
        stage_06_top_creatures_previous.add(stage_06_creature_19);
        stage_06_top_creatures_previous.add(stage_06_creature_20);
        stage_06_top_creatures_previous.add(stage_06_creature_21);
        stage_06_top_creatures_previous.add(stage_06_creature_22);
        stage_06_top_creatures_previous.add(stage_06_creature_23);
        stage_06_top_creatures_previous.add(stage_06_creature_24);
        stage_06_top_creatures_previous.add(stage_06_creature_25);
        stage_06_top_creatures_previous.add(stage_06_creature_26);
        stage_06_top_creatures_previous.add(stage_06_creature_27);
        stage_06_top_creatures_previous.add(stage_06_creature_28);
        stage_06_top_creatures_previous.add(stage_06_creature_29);
        stage_06_top_creatures_previous.add(stage_06_creature_30);
        stage_06_top_creatures_previous.add(stage_06_creature_31);
        stage_06_top_creatures_previous.add(stage_06_creature_32);

        //
        stage_06_collection = 0;

        //
        for (boolean creature : stage_06_top_creatures_previous) {

            //
            if (creature) { ++stage_06_collection; }
        }

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

// -- STAGE 7 -->
        //
        //stage_07_complete = mUserPrefGet.getBoolean(STAGE_07_COMPLETE, false);

        //
        stage_07_attempts = mUserPrefGet.getInt(STAGE_07_ATTEMPTS, 0);
        // --> [new, comfortable, home] (1 - 50)
        stage_07_boss_kills = mUserPrefGet.getInt(STAGE_07_BOSS_KILLS, 0);
        // --> [lucky, skilled, master] (1 - 25)

        // save storage by calculating in game
        stage_07_complete = (stage_07_boss_kills > 0);

        // possible success rate score [boss_kills / stage_attempts]
        stage_07_creature_kills = mUserPrefGet.getInt(STAGE_07_CREATURE_KILLS, 0);
        // --> [vegetarian, omnivore, carnivore] (1 - 500)

        //
        boolean stage_07_creature_01 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_01, false);
        boolean stage_07_creature_02 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_02, false);
        boolean stage_07_creature_03 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_03, false);
        boolean stage_07_creature_04 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_04, false);
        boolean stage_07_creature_05 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_05, false);
        boolean stage_07_creature_06 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_06, false);
        boolean stage_07_creature_07 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_07, false);
        boolean stage_07_creature_08 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_08, false);
        boolean stage_07_creature_09 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_09, false);
        boolean stage_07_creature_10 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_10, false);
        boolean stage_07_creature_11 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_11, false);
        boolean stage_07_creature_12 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_12, false);
        boolean stage_07_creature_13 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_13, false);
        boolean stage_07_creature_14 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_14, false);
        boolean stage_07_creature_15 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_15, false);
        boolean stage_07_creature_16 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_16, false);
        boolean stage_07_creature_17 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_17, false);
        boolean stage_07_creature_18 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_18, false);
        boolean stage_07_creature_19 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_19, false);
        boolean stage_07_creature_20 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_20, false);
        boolean stage_07_creature_21 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_21, false);
        boolean stage_07_creature_22 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_22, false);
        boolean stage_07_creature_23 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_23, false);
        boolean stage_07_creature_24 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_24, false);
        boolean stage_07_creature_25 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_25, false);
        boolean stage_07_creature_26 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_26, false);
        boolean stage_07_creature_27 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_27, false);
        boolean stage_07_creature_28 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_28, false);
        boolean stage_07_creature_29 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_29, false);
        boolean stage_07_creature_30 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_30, false);
        boolean stage_07_creature_31 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_31, false);
        boolean stage_07_creature_32 = mUserPrefGet.getBoolean(STAGE_07_CREATURE_32, false);

        //
        stage_07_top_creatures_previous.clear();
        stage_07_top_creatures_previous.add(stage_07_creature_01);
        stage_07_top_creatures_previous.add(stage_07_creature_02);
        stage_07_top_creatures_previous.add(stage_07_creature_03);
        stage_07_top_creatures_previous.add(stage_07_creature_04);
        stage_07_top_creatures_previous.add(stage_07_creature_05);
        stage_07_top_creatures_previous.add(stage_07_creature_06);
        stage_07_top_creatures_previous.add(stage_07_creature_07);
        stage_07_top_creatures_previous.add(stage_07_creature_08);
        stage_07_top_creatures_previous.add(stage_07_creature_09);
        stage_07_top_creatures_previous.add(stage_07_creature_10);
        stage_07_top_creatures_previous.add(stage_07_creature_11);
        stage_07_top_creatures_previous.add(stage_07_creature_12);
        stage_07_top_creatures_previous.add(stage_07_creature_13);
        stage_07_top_creatures_previous.add(stage_07_creature_14);
        stage_07_top_creatures_previous.add(stage_07_creature_15);
        stage_07_top_creatures_previous.add(stage_07_creature_16);
        stage_07_top_creatures_previous.add(stage_07_creature_17);
        stage_07_top_creatures_previous.add(stage_07_creature_18);
        stage_07_top_creatures_previous.add(stage_07_creature_19);
        stage_07_top_creatures_previous.add(stage_07_creature_20);
        stage_07_top_creatures_previous.add(stage_07_creature_21);
        stage_07_top_creatures_previous.add(stage_07_creature_22);
        stage_07_top_creatures_previous.add(stage_07_creature_23);
        stage_07_top_creatures_previous.add(stage_07_creature_24);
        stage_07_top_creatures_previous.add(stage_07_creature_25);
        stage_07_top_creatures_previous.add(stage_07_creature_26);
        stage_07_top_creatures_previous.add(stage_07_creature_27);
        stage_07_top_creatures_previous.add(stage_07_creature_28);
        stage_07_top_creatures_previous.add(stage_07_creature_29);
        stage_07_top_creatures_previous.add(stage_07_creature_30);
        stage_07_top_creatures_previous.add(stage_07_creature_31);
        stage_07_top_creatures_previous.add(stage_07_creature_32);

        //
        stage_07_collection = 0;

        //
        for (boolean creature : stage_07_top_creatures_previous) {

            //
            if (creature) { ++stage_07_collection; }
        }

        // possible collection rate score [stage_07_collection / 32]
        // --> [collector, hobbyist, completist] (1 - 32)

        //
        stage_07_highest_streak = mUserPrefGet.getInt(STAGE_07_HIGHEST_STREAK, 0);
        // --> [hopper, juggler, sniper]
        stage_07_closest_death = mUserPrefGet.getInt(STAGE_07_CLOSEST_DEATH, 30);
        // --> [thrill-seeker, dare-devil, death-wish]
        stage_07_longest_frenzy = mUserPrefGet.getInt(STAGE_07_LONGEST_FRENZY, 0);
        // --> [peckish, starving, ravenous]
        stage_07_most_calm = mUserPrefGet.getLong(STAGE_07_MOST_CALM, 1000);
        // --> [peaceful, focused, zen]
        stage_07_most_frantic = mUserPrefGet.getLong(STAGE_07_MOST_FRANTIC, 1000);
        // --> [excited, stoked, insane]

        //
        stage_07_total_time = mUserPrefGet.getInt(STAGE_07_TOTAL_TIME, 0);

        //
        stage_07_best_time = mUserPrefGet.getInt(STAGE_07_BEST_TIME, 0);
        // --> [sloth, tortoise, jack-rabbit]

        //
        stage_07_predator = mUserPrefGet.getInt(STAGE_07_PREDATOR, 0);
        // --> [survivalist, predator, beast]
        stage_07_accuracy = mUserPrefGet.getFloat(STAGE_07_ACCURACY, 0);
        // --> [sharp, honed, exacting]
        stage_07_apex = mUserPrefGet.getBoolean(STAGE_07_APEX, false);

        //
        game_complete = stage_07_complete;

        // Assign - total attempts
        //mGameAttempts = stage_01_attempts + stage_02_attempts + stage_03_attempts + stage_04_attempts + stage_05_attempts + stage_06_attempts + stage_07_attempts;
        // --> [around-the-block, known-by-name, old-stomping-grounds]

        // Assign - total boss kills
        //mGameBossKills = stage_01_boss_kills + stage_02_boss_kills + stage_03_boss_kills + stage_04_boss_kills + stage_05_boss_kills + stage_06_boss_kills + stage_07_boss_kills;
        // --> [timid, bold, vicious]

        // Assign - total creature kills
        mGameCreatureKills = stage_01_creature_kills + stage_02_creature_kills + stage_03_creature_kills + stage_04_creature_kills + stage_05_creature_kills + stage_06_creature_kills + stage_07_creature_kills;
        // --> [afraid, daring, fearful]

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

        //
        int[] top_scores_highest_streak = {

                //
                stage_01_highest_streak, stage_02_highest_streak, stage_03_highest_streak,
                stage_04_highest_streak, stage_05_highest_streak, stage_06_highest_streak,
                stage_07_highest_streak
        };

        // Extract - highest streak
        for (int score : top_scores_highest_streak) {

            // Compare - highest streak
            if (score >= hiScore) { hiScore = score; }
        }

        // Assign - highest streak
        mGameHighestStreak = hiScore;

        // Reset - closest death
        hiScore = 20;

        //
        int[] top_scores_closest_death = {

                //
                stage_01_closest_death, stage_02_closest_death, stage_03_closest_death,
                stage_04_closest_death, stage_05_closest_death, stage_06_closest_death,
                stage_07_closest_death
        };

        // Extract - closest death
        for (int score : top_scores_closest_death) {

            // Compare - closest death
            if (score <= hiScore) { hiScore = score; }
        }

        // Assign - highest streak
        mGameClosestDeath = hiScore;

        // Reset - longest frenzy
        hiScore = 0;

        //
        int[] top_scores_longest_frenzy = {

                //
                stage_01_longest_frenzy, stage_02_longest_frenzy, stage_03_longest_frenzy,
                stage_04_longest_frenzy, stage_05_longest_frenzy, stage_06_longest_frenzy,
                stage_07_longest_frenzy
        };

        // Extract - longest frenzy
        for (int score : top_scores_longest_frenzy) {

            // Compare - longest frenzy
            if (score >= hiScore) { hiScore = score; }
        }

        // Assign - longest frenzy
        mGameLongestFrenzy = hiScore;

        // Reset - most calm
        highScore = 500;

        //
        long[] top_scores_most_calm = {

                //
                stage_01_most_calm, stage_02_most_calm, stage_03_most_calm,
                stage_04_most_calm, stage_05_most_calm, stage_06_most_calm,
                stage_07_most_calm
        };

        // Extract - most calm
        for (long score : top_scores_most_calm) {

            // Compare - most calm
            if (score >= highScore) { highScore = score; }
        }

        // Assign - most calm
        mGameMostCalm = highScore;

        // Reset - most frantic
        highScore = 500;

        //
        long[] top_scores_most_frantic = {

                //
                stage_01_most_frantic, stage_02_most_frantic, stage_03_most_frantic,
                stage_04_most_frantic, stage_05_most_frantic, stage_06_most_frantic,
                stage_07_most_frantic
        };

        // Extract - most frantic
        for (long score : top_scores_most_frantic) {

            // Compare - most frantic
            if (score <= highScore) { highScore = score; }
        }

        // Assign - most frantic
        mGameMostFrantic = highScore;

        // Reset - best time
        hiScore = 60;
        mGameTimeBest = true;

        //
        int[] top_scores_best_time = {

                //
                stage_01_best_time, stage_02_best_time, stage_03_best_time,
                stage_04_best_time, stage_05_best_time, stage_06_best_time,
                stage_07_best_time
        };

        // Extract - best time
        for (int score : top_scores_best_time) {

            // Compare - best time
            if (score == 0 || score > hiScore) {

                // Assign - local
                //hiScore = score;
                mGameTimeBest = false;
            }
        }

        // Assign - best time
        //mGameTimeBest = hiScore;

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

            }

            ++i;

            // Assign - top accuracy
            mGameAccuracy = mAccumulativeAccuracy / i;
        }

        // Reset - top apex
        mGameApex = true;

        //
        boolean[] top_scores_top_apex = {

                //
                stage_01_apex, stage_02_apex, stage_03_apex,
                stage_04_apex, stage_05_apex, stage_06_apex,
                stage_07_apex
        };

        // Extract - top apex
        for (boolean score : top_scores_top_apex) {

            // Compare - top apex
            if (!score) { mGameApex = false; }
        }

        // Assign - total collection
        mGameCollection = stage_01_collection + stage_02_collection + stage_03_collection + stage_04_collection + stage_05_collection + stage_06_collection + stage_07_collection;
        mGameCollectionPercent = (int) getPercentage(7, mGameCollection);
    }

    // Set click listeners
    public void setClickables() {

        // Set click listener for each item in CLICKABLES array
        for (int id : CLICKABLES) { findViewById(id).setOnClickListener(this); }
    }

    // Play credits
    public void playCredits(int mode) {

        //
        fadeDisaster();
        fadeBloodsplat();
        fadeFlash();
        fadeBlackout();

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

        //
        h1.postDelayed(r1, 1000);
    }

    // Click events
    public void onClick(View v) {

        // Get view clicked
        switch (v.getId()) {

//--CREDITS-->

            // Credits - skip intro / outro
            case R.id.credits_screen_main_layout:

                //
                findViewById(mCurScreen).setVisibility(View.GONE);

                // Touch to skip
                mCreditSpinner = mGameCreditsImages.size();

                // Play audio
                playAudio(CHOMP);

                break;

//--ENTRY-->

            // Entry - Continue Button Event
            case R.id.entry_main_continue_image_button:

                // Switch to stage select screen
                if (continue_game) {

                    //
                    findViewById(mCurScreen).setVisibility(View.GONE);

                    //
                    switchScreen(R.id.stage_select_screen_main_layout);

                    // Play audio
                    playAudio(ROAR);
                }

                break;

            // Entry - New Button Event
            case R.id.entry_main_new_image_button:

                // Check previous data
                if (continue_game) {

                    // Dialog to confirm new game
                    alertNewGame();

                } else {

                    //
                    findViewById(mCurScreen).setVisibility(View.GONE);

                    // Switch to stage select screen
                    switchScreen(R.id.stage_select_screen_main_layout);

                    // Play audio
                    playAudio(ROAR);
                }

                break;

            // Entry - Credits Button Event
            case R.id.entry_main_credits_image_button:

                //
                findViewById(mCurScreen).setVisibility(View.GONE);

                // Switch to credits
                playCredits(2);

                break;

//--STAGE SELECT-->

            // Stage select - Return event
            case R.id.stage_select_return_image_button:

                //
                findViewById(mCurScreen).setVisibility(View.GONE);

                //
                //mStageLocked = false;
                mTrophycase = false;
                mTopScores = false;
                //mStageScores = false;
                //mEatenScores = false;
                mContent = true;

                // Switch to entry screen
                switchScreen(R.id.entry_screen_main_layout);

                // Play audio
                playAudio(RUN);

                break;

            // Select stage - Scorecard event
            case R.id.stage_select_scorecard_image_button:

                // Check scores present - non-logical, just saving cpu
                if (stage_01_complete) {

                    // Display scorecard
                    if (mTopScores) {

                        //
                        mTrophycase = false;
                        mTopScores = false;
                        mContent = true;

                        //
                        mStageSelectCollectionLayout.setVisibility(View.GONE);
                        mStageSelectScorecardLayout.setVisibility(View.GONE);
                        mStageSelectContentLayout.setVisibility(View.VISIBLE);

                        //
                        mStageSelectCollectionImageButton.setAlpha(.5f);
                        mStageSelectScorecardImageButton.setAlpha(.5f);
                        mStageSelectContentImageButton.setAlpha(1f);

                        //
                        //findViewById(R.id.sub_title_icon_image_view).setBackground(versionCheck(R.drawable.world_map_icon));

                    } else {

                        //
                        mTopScores = true;
                        mTrophycase = false;
                        mContent = false;

                        //
                        mStageSelectCollectionLayout.setVisibility(View.GONE);
                        mStageSelectScorecardLayout.setVisibility(View.VISIBLE);
                        mStageSelectContentLayout.setVisibility(View.GONE);

                        //
                        mStageSelectCollectionImageButton.setAlpha(.5f);
                        mStageSelectScorecardImageButton.setAlpha(1f);
                        mStageSelectContentImageButton.setAlpha(.5f);

                        //
                        //findViewById(R.id.sub_title_icon_image_view).setBackground(versionCheck(R.drawable.achievements_icon));
                    }

                    // Play audio
                    playAudio(CROW_AUDIO);
                }

                break;

            // Select stage - Scorecard event
            case R.id.stage_select_trophycase_image_button:

                // Check scores present - non-logical just saving cpu
                if (stage_01_complete) {

                    // Display scorecard
                    if (mTrophycase) {

                        //
                        mTrophycase = false;
                        mTopScores = false;
                        mContent = true;

                        //
                        mStageSelectCollectionLayout.setVisibility(View.GONE);
                        mStageSelectScorecardLayout.setVisibility(View.GONE);
                        mStageSelectContentLayout.setVisibility(View.VISIBLE);

                        //
                        mStageSelectCollectionImageButton.setAlpha(.5f);
                        mStageSelectScorecardImageButton.setAlpha(.5f);
                        mStageSelectContentImageButton.setAlpha(1f);

                        //
                        //findViewById(R.id.sub_title_icon_image_view).setBackground(versionCheck(R.drawable.world_map_icon));

                    } else {

                        //
                        mTrophycase = true;
                        mTopScores = false;
                        mContent = false;

                        //
                        mStageSelectCollectionLayout.setVisibility(View.VISIBLE);
                        mStageSelectScorecardLayout.setVisibility(View.GONE);
                        mStageSelectContentLayout.setVisibility(View.GONE);

                        //
                        mStageSelectCollectionImageButton.setAlpha(1f);
                        mStageSelectScorecardImageButton.setAlpha(.5f);
                        mStageSelectContentImageButton.setAlpha(.5f);

                        //
                        //findViewById(R.id.sub_title_icon_image_view).setBackground(versionCheck(R.drawable.trophy_boss_icon));
                    }

                    // Play audio
                    playAudio(CROW_AUDIO);
                }

                break;

            case R.id.stage_select_content_title_image_button:

                //
                mTopScores = false;
                mTrophycase = false;
                mContent = true;

                //
                mStageSelectCollectionLayout.setVisibility(View.GONE);
                mStageSelectScorecardLayout.setVisibility(View.GONE);
                mStageSelectContentLayout.setVisibility(View.VISIBLE);

                //
                mStageSelectCollectionImageButton.setAlpha(.5f);
                mStageSelectScorecardImageButton.setAlpha(.5f);
                mStageSelectContentImageButton.setAlpha(1f);

                //
                //findViewById(R.id.sub_title_icon_image_view).setBackground(versionCheck(R.drawable.world_map_icon));

                // Play audio
                playAudio(CROW_AUDIO);

                break;

            // Stage select trophy
            case R.id.stage_select_trophy_01_image_view:

                //
                playAudio(WOLF_CRY);

                break;

            case R.id.stage_select_trophy_02_image_view:

                //
                playAudio(SHARK_CRY);

                break;

            case R.id.stage_select_trophy_03_image_view:

                //
                playAudio(HAWK_CRY);

                break;

            case R.id.stage_select_trophy_04_image_view:

                //
                playAudio(SCORPION_CRY);

                break;

            case R.id.stage_select_trophy_05_image_view:

                //
                playAudio(SNAKE_CRY);

                break;

            case R.id.stage_select_trophy_06_image_view:

                //
                playAudio(YETI_CRY);

                break;

            case R.id.stage_select_trophy_07_image_view:

                //
                playAudio(THUNDER_AUDIO);

                break;

            // Stage select event
            case R.id.stage_stage_select_01_hilite_layout:

                //
                findViewById(mCurScreen).setVisibility(View.GONE);

                // Set stage card - forest [index for resources]
                mStageIndex = 1;

                // Initial stage status - stage 1 is always ready, all others set to 1, then test for ready
                mStageReady = 2;

                // Check stage complete
                mStageComplete = stage_01_complete;

                // Load stage
                loadStage();

                break;

            //
            case R.id.stage_stage_select_02_hilite_layout:

                //
                findViewById(mCurScreen).setVisibility(View.GONE);

                // Set stage card - ocean
                mStageIndex = 2;

                // Initial stage status - locked
                mStageReady = 1;

                // Test for ready
                if (stage_01_complete) {
                    mStageReady = 2;
                }

                // Check stage complete
                mStageComplete = stage_02_complete;

                // Load stage
                loadStage();

                break;

            //
            case R.id.stage_stage_select_03_hilite_layout:

                //
                findViewById(mCurScreen).setVisibility(View.GONE);

                // Set stage card - mountain
                mStageIndex = 3;

                // Initial stage status - locked
                mStageReady = 1;

                // Test for ready
                if (stage_02_complete) {
                    mStageReady = 2;
                }

                // Check stage complete
                mStageComplete = stage_03_complete;

                // Load stage
                loadStage();

                break;

            //
            case R.id.stage_stage_select_04_hilite_layout:

                //
                findViewById(mCurScreen).setVisibility(View.GONE);

                // Set stage card - desert
                mStageIndex = 4;

                // Initial stage status - locked
                mStageReady = 1;

                // Test for ready
                if (stage_03_complete) {
                    mStageReady = 2;
                }

                // Check stage complete
                mStageComplete = stage_04_complete;

                // Load stage
                loadStage();

                break;

            //
            case R.id.stage_stage_select_05_hilite_layout:

                //
                findViewById(mCurScreen).setVisibility(View.GONE);

                // Set stage card - jungle
                mStageIndex = 5;

                // Initial stage status - locked
                mStageReady = 1;

                // Test for ready
                if (stage_04_complete) {
                    mStageReady = 2;
                }

                // Check stage complete
                mStageComplete = stage_05_complete;

                // Load stage
                loadStage();

                break;

            //
            case R.id.stage_stage_select_06_hilite_layout:

                //
                findViewById(mCurScreen).setVisibility(View.GONE);

                // Set stage card - tundra
                mStageIndex = 6;

                // Initial stage status - locked
                mStageReady = 1;

                // Test for ready
                if (stage_05_complete) {
                    mStageReady = 2;
                }

                // Check stage complete
                mStageComplete = stage_06_complete;

                // Load stage
                loadStage();

                break;

            case R.id.stage_stage_select_07_hilite_layout:

                //
                findViewById(mCurScreen).setVisibility(View.GONE);

                // Set stage card - final
                mStageIndex = 7;

                // Initial stage status - locked
                mStageReady = 1;

                // Test for ready
                if (stage_06_complete) {
                    mStageReady = 2;
                }

                // Check stage complete
                mStageComplete = stage_07_complete;

                // Load stage
                loadStage();

                break;

//--STAGE CARD-->

            //
            //case R.id.game_main_flash_layout:

                //
                //mGameFlashLayout.setVisibility(View.GONE);

                //break;

            // Stage card - Header return
            case R.id.stage_card_header_return_image_button:

                //
                findViewById(mCurScreen).setVisibility(View.GONE);

                //
                mStageApex = false;
                mStageIndex = -1;
                mStageReady = 1;
                mStageComplete = false;

                //
                mStageLocked = false;
                mTrophycase = false;
                mTopScores = false;
                mStageScores = false;
                mEatenScores = false;
                mContent = false;

                //
                switchScreen(R.id.stage_select_screen_main_layout);

                //
                playAudio(RUN);

                break;

            //
            case R.id.stage_card_locked_image_button:

                //
                findViewById(mCurScreen).setVisibility(View.GONE);

                //
                mStageLocked = false;
                mTrophycase = false;
                mTopScores = false;
                mStageScores = false;
                mEatenScores = false;
                mContent = false;

                //
                switchStageCard(0);

                // Play audio
                playAudio(MISS);

                break;

            //
            case R.id.stage_card_trophy_image_button:

                //
                if (mTrophycase) {

                    //
                    mStageLocked = false;
                    mTrophycase = false;
                    mTopScores = false;
                    mStageScores = false;
                    mEatenScores = false;
                    mContent = true;

                    //
                    mStageCardTrophyImageButton.setAlpha(.5f);
                    mStageCardHiScoreImageButton.setAlpha(.5f);
                    mStageCardStageScoreImageButton.setAlpha(.5f);
                    mStageCardEatenImageButton.setAlpha(.5f);
                    mStageCardContentImageButton.setAlpha(1f);

                    //
                    mStageCardStageLockedLayout.setVisibility(View.GONE);
                    mStageCardCollectionLayout.setVisibility(View.GONE);
                    mStageCardTopScoreLayout.setVisibility(View.GONE);
                    mStageCardScorecardLayout.setVisibility(View.GONE);
                    mStageCardEatenScoreLayout.setVisibility(View.GONE);
                    mStageCardContentLayout.setVisibility(View.VISIBLE);

                    //
                    findViewById(R.id.sub_title_content_icon_image_view).setBackground(versionCheck(R.drawable.area_icon));

                } else {

                    //
                    mStageLocked = false;
                    mTrophycase = true;
                    mTopScores = false;
                    mStageScores = false;
                    mEatenScores = false;
                    mContent = false;

                    //
                    mStageCardTrophyImageButton.setAlpha(1f);
                    mStageCardHiScoreImageButton.setAlpha(.5f);
                    mStageCardStageScoreImageButton.setAlpha(.5f);
                    mStageCardEatenImageButton.setAlpha(.5f);
                    mStageCardContentImageButton.setAlpha(.5f);

                    //
                    mStageCardStageLockedLayout.setVisibility(View.GONE);
                    mStageCardCollectionLayout.setVisibility(View.VISIBLE);
                    mStageCardTopScoreLayout.setVisibility(View.GONE);
                    mStageCardScorecardLayout.setVisibility(View.GONE);
                    mStageCardEatenScoreLayout.setVisibility(View.GONE);
                    mStageCardContentLayout.setVisibility(View.GONE);

                    //
                    findViewById(R.id.sub_title_content_icon_image_view).setBackground(versionCheck(R.drawable.trophy_creature_icon));
                }

                // Play audio
                playAudio(CHOMP);

                break;

            // Stage card - Header collection
            case R.id.stage_card_hiscore_image_button:

                //
                if (mTopScores) {

                    //
                    mStageLocked = false;
                    mTrophycase = false;
                    mTopScores = false;
                    mStageScores = false;
                    mEatenScores = false;
                    mContent = true;

                    //
                    mStageCardTrophyImageButton.setAlpha(.5f);
                    mStageCardHiScoreImageButton.setAlpha(.5f);
                    mStageCardStageScoreImageButton.setAlpha(.5f);
                    mStageCardEatenImageButton.setAlpha(.5f);
                    mStageCardContentImageButton.setAlpha(1f);

                    //
                    mStageCardStageLockedLayout.setVisibility(View.GONE);
                    mStageCardCollectionLayout.setVisibility(View.GONE);
                    mStageCardTopScoreLayout.setVisibility(View.GONE);
                    mStageCardScorecardLayout.setVisibility(View.GONE);
                    mStageCardEatenScoreLayout.setVisibility(View.GONE);
                    mStageCardContentLayout.setVisibility(View.VISIBLE);

                    //
                    findViewById(R.id.sub_title_content_icon_image_view).setBackground(versionCheck(R.drawable.area_icon));

                } else {

                    //
                    mStageLocked = false;
                    mTrophycase = false;
                    mTopScores = true;
                    mStageScores = false;
                    mEatenScores = false;
                    mContent = false;

                    //
                    mStageCardTrophyImageButton.setAlpha(.5f);
                    mStageCardHiScoreImageButton.setAlpha(1f);
                    mStageCardStageScoreImageButton.setAlpha(.5f);
                    mStageCardEatenImageButton.setAlpha(.5f);
                    mStageCardContentImageButton.setAlpha(.5f);

                    //
                    mStageCardStageLockedLayout.setVisibility(View.GONE);
                    mStageCardCollectionLayout.setVisibility(View.GONE);
                    mStageCardTopScoreLayout.setVisibility(View.VISIBLE);
                    mStageCardScorecardLayout.setVisibility(View.GONE);
                    mStageCardEatenScoreLayout.setVisibility(View.GONE);
                    mStageCardContentLayout.setVisibility(View.GONE);

                    //
                    findViewById(R.id.sub_title_content_icon_image_view).setBackground(versionCheck(R.drawable.awards_icon));
                }

                // Play audio
                playAudio(CHOMP);

                break;

            //
            case R.id.stage_card_stagescore_image_button:

                //
                if (mStageScores) {

                    //
                    mStageLocked = false;
                    mTrophycase = false;
                    mTopScores = false;
                    mStageScores = false;
                    mEatenScores = false;
                    mContent = true;

                    //
                    mStageCardTrophyImageButton.setAlpha(.5f);
                    mStageCardHiScoreImageButton.setAlpha(.5f);
                    mStageCardStageScoreImageButton.setAlpha(.5f);
                    mStageCardEatenImageButton.setAlpha(.5f);
                    mStageCardContentImageButton.setAlpha(1f);

                    //
                    mStageCardStageLockedLayout.setVisibility(View.GONE);
                    mStageCardCollectionLayout.setVisibility(View.GONE);
                    mStageCardTopScoreLayout.setVisibility(View.GONE);
                    mStageCardScorecardLayout.setVisibility(View.GONE);
                    mStageCardEatenScoreLayout.setVisibility(View.GONE);
                    mStageCardContentLayout.setVisibility(View.VISIBLE);

                    //
                    findViewById(R.id.sub_title_content_icon_image_view).setBackground(versionCheck(R.drawable.area_icon));

                } else {

                    //
                    mStageLocked = false;
                    mTrophycase = false;
                    mTopScores = false;
                    mStageScores = true;
                    mEatenScores = false;
                    mContent = false;

                    //
                    mStageCardTrophyImageButton.setAlpha(.5f);
                    mStageCardHiScoreImageButton.setAlpha(.5f);
                    mStageCardStageScoreImageButton.setAlpha(1f);
                    mStageCardEatenImageButton.setAlpha(.5f);
                    mStageCardContentImageButton.setAlpha(.5f);

                    //
                    mStageCardStageLockedLayout.setVisibility(View.GONE);
                    mStageCardCollectionLayout.setVisibility(View.GONE);
                    mStageCardTopScoreLayout.setVisibility(View.GONE);
                    mStageCardScorecardLayout.setVisibility(View.VISIBLE);
                    mStageCardEatenScoreLayout.setVisibility(View.GONE);
                    mStageCardContentLayout.setVisibility(View.GONE);

                    //
                    findViewById(R.id.sub_title_content_icon_image_view).setBackground(versionCheck(R.drawable.stage_complete_icon));
                }

                // Play audio
                playAudio(CHOMP);

                break;

            //
            case R.id.stage_card_content_image_button:

                //
                mStageLocked = false;
                mTrophycase = false;
                mTopScores = false;
                mStageScores = false;
                mEatenScores = false;
                mContent = true;

                //
                mStageCardTrophyImageButton.setAlpha(.5f);
                mStageCardHiScoreImageButton.setAlpha(.5f);
                mStageCardStageScoreImageButton.setAlpha(.5f);
                mStageCardEatenImageButton.setAlpha(.5f);
                mStageCardContentImageButton.setAlpha(1f);

                //
                mStageCardStageLockedLayout.setVisibility(View.GONE);
                mStageCardCollectionLayout.setVisibility(View.GONE);
                mStageCardTopScoreLayout.setVisibility(View.GONE);
                mStageCardScorecardLayout.setVisibility(View.GONE);
                mStageCardEatenScoreLayout.setVisibility(View.GONE);
                mStageCardContentLayout.setVisibility(View.VISIBLE);

                //
                findViewById(R.id.sub_title_content_icon_image_view).setBackground(versionCheck(R.drawable.area_icon));

                // Play audio
                playAudio(CHOMP);

                break;

            //
            case R.id.stage_card_eaten_image_button:

                //
                if (mEatenScores) {

                    //
                    mStageLocked = false;
                    mTrophycase = false;
                    mTopScores = false;
                    mStageScores = false;
                    mEatenScores = false;
                    mContent = true;

                    //
                    mStageCardTrophyImageButton.setAlpha(.5f);
                    mStageCardHiScoreImageButton.setAlpha(.5f);
                    mStageCardStageScoreImageButton.setAlpha(.5f);
                    mStageCardEatenImageButton.setAlpha(.5f);
                    mStageCardContentImageButton.setAlpha(1f);

                    //
                    mStageCardStageLockedLayout.setVisibility(View.GONE);
                    mStageCardCollectionLayout.setVisibility(View.GONE);
                    mStageCardTopScoreLayout.setVisibility(View.GONE);
                    mStageCardScorecardLayout.setVisibility(View.GONE);
                    mStageCardEatenScoreLayout.setVisibility(View.GONE);
                    mStageCardContentLayout.setVisibility(View.VISIBLE);

                    //
                    findViewById(R.id.sub_title_content_icon_image_view).setBackground(versionCheck(R.drawable.area_icon));

                } else {

                    //
                    mStageLocked = false;
                    mTrophycase = false;
                    mTopScores = false;
                    mStageScores = false;
                    mEatenScores = true;
                    mContent = false;

                    //
                    mStageCardTrophyImageButton.setAlpha(.5f);
                    mStageCardHiScoreImageButton.setAlpha(.5f);
                    mStageCardStageScoreImageButton.setAlpha(.5f);
                    mStageCardEatenImageButton.setAlpha(1f);
                    mStageCardContentImageButton.setAlpha(.5f);

                    //
                    mStageCardStageLockedLayout.setVisibility(View.GONE);
                    mStageCardCollectionLayout.setVisibility(View.GONE);
                    mStageCardTopScoreLayout.setVisibility(View.GONE);
                    mStageCardScorecardLayout.setVisibility(View.GONE);
                    mStageCardEatenScoreLayout.setVisibility(View.VISIBLE);
                    mStageCardContentLayout.setVisibility(View.GONE);

                    //
                    findViewById(R.id.sub_title_content_icon_image_view).setBackground(versionCheck(R.drawable.skull_icon));
                }

                //
                playAudio(CHOMP);

                break;

            // Stage card - Control prev
            case R.id.stage_card_control_prev_image_button:

                //
                if (mStageIndex != 0) {

                    //
                    findViewById(mCurScreen).setVisibility(View.GONE);

                    //
                    mStageLocked = false;
                    mTrophycase = false;
                    mTopScores = false;
                    mStageScores = false;
                    mEatenScores = false;
                    mContent = false;

                    //
                    switchStageCard(0);

                    // Play audio
                    playAudio(MISS);
                }

                break;

            // Stage card - Control next
            case R.id.stage_card_control_next_image_button:

                //
                if (mStageIndex != 7) {

                    //
                    findViewById(mCurScreen).setVisibility(View.GONE);

                    //
                    mStageLocked = false;
                    mTrophycase = false;
                    mTopScores = false;
                    mStageScores = false;
                    mEatenScores = false;
                    mContent = false;

                    //
                    switchStageCard(1);

                    // Play audio
                    playAudio(MISS);
                }

                break;

            // Stage card - Footer play here
            case R.id.stage_card_ready_play_here_image_button:

                //
                findViewById(mCurScreen).setVisibility(View.GONE);

                //
                mStageLocked = false;
                mTrophycase = false;
                mTopScores = false;
                mStageScores = false;
                mEatenScores = false;
                mContent = false;

                //
                prepStage();

                //
                startGame();

                // Play audio
                playAudio(mGameBossCry);

                break;

            //
            case R.id.stage_card_screen_body_layout:

                //
                fadeDisaster();

                //
                mStageLocked = false;
                mTrophycase = false;
                mTopScores = false;
                mStageScores = false;
                mEatenScores = false;
                mContent = true;

                //
                mStageCardTrophyImageButton.setAlpha(.5f);
                mStageCardHiScoreImageButton.setAlpha(.5f);
                mStageCardStageScoreImageButton.setAlpha(.5f);
                mStageCardEatenImageButton.setAlpha(.5f);
                mStageCardContentImageButton.setAlpha(1f);

                //
                mStageCardStageLockedLayout.setVisibility(View.GONE);
                mStageCardCollectionLayout.setVisibility(View.GONE);
                mStageCardTopScoreLayout.setVisibility(View.GONE);
                mStageCardScorecardLayout.setVisibility(View.GONE);
                mStageCardEatenScoreLayout.setVisibility(View.GONE);
                mStageCardContentLayout.setVisibility(View.VISIBLE);

                // Play audio
                playAudio(CHOMP);

                break;

//--GAME-->

            // Game - Settings Event
            case R.id.game_main_return_image_button:

                // Settings dialogue
                alertReturnLoseProgress();

                break;

            // Game - Exit Event
            case R.id.game_main_exit_image_button:

                // Exit dialogue
                alertExitLoseProgress();

                break;

            //
            //case R.id.game_scene_prev_image_button:

                // Pause game
                //Log.d(TAG, "gameButton: pause");
                //mPauseGame = true;

                //
                //if (mStageAdvanceMeter >= mStageAdvanceTarget) {

                    //
                    //tapOut();

                //} else {

                    //
                    //playAudio(MISS);
                //}

                //
                //mCurScreen = R.id.game_screen_main_layout;
                //drawScreen();

                //
                //playAudio(FLUTE_TRILL_LONG);

                // Undo pause game
                //Log.d(TAG, "onClick: un-pause");
                //mPauseGame = false;

                //break;

            //
            //case R.id.game_scene_next_image_button:

                //
                //findViewById(mCurScreen).setVisibility(View.GONE);

                // Pause game
                //Log.d(TAG, "gameButton: pause");
                //mPauseGame = true;

                //
                //tapOut();

                //
                //mCurScreen = R.id.game_screen_main_layout;
                //drawScreen();

                //
                //playAudio(FLUTE_TRILL_LONG);

                // Undo pause game
                //Log.d(TAG, "onClick: un-pause");
                //mPauseGame = false;

                //break;

            //
            case R.id.game_main_power_01_image_view:

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Spend power
                    usePower(mPower01Meter, mPower01Target, 1);
                }

                break;

            //
            case R.id.game_main_power_02_image_view:

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Spend power
                    usePower(mPower02Meter, mPower02Target, 2);
                }

                break;

            //
            case R.id.game_main_power_03_image_view:

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Spend power
                    usePower(mPower03Meter, mPower03Target, 3);
                }

                break;

            //
            case R.id.game_main_power_04_image_view:

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Spend power
                    usePower(mPower04Meter, mPower04Target, 4);
                }

                break;

            //
            case R.id.game_main_power_05_image_view:

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Spend power
                    usePower(mPower05Meter, mPower05Target, 5);
                }

                break;

            //
            case R.id.game_main_power_06_image_view:

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Spend power
                    usePower(mPower06Meter, mPower06Target, 6);
                }

                break;

            // Game - Miss Event
            case R.id.game_main_pg_creature_canvas_layout:

                // Creature game IS NOT over
                if (!mCreatureGameOver) {

                    // Creature game IS NOT paused, or if it IS paused it has a timer [still playing]
                    if (!mPauseGame || mPauseTimer != -1) {

                        // Broken streak
                        if (mTapCount > 4) {

                            //
                            playAudio(FLASH_BANG);
                        }

                        // Tally miss
                        missPoint();

                        // Reset tapper
                        resetTapper();
                    }

                // Boss game IS NOT over
                } else {

                    //
                    mBittenMeter = mBittenMeter + 3;
                    Random r = new Random();
                    mGameBittenLayout.setBackground(versionCheck(BITTEN_IMAGES[r.nextInt(BITTEN_IMAGES.length - 1)]));
                    updateBitten();

                    // Accelerate timer
                    accelerateTimer(.2);
                }

                // Housekeeping
                drawScreen();

                break;

            // Game - Hit Events
            case R.id.game_main_creature_01_image_button:

                //
                if (!mCreatureGameOver) {

                    //
                    if (!mPauseGame || mPauseTimer != -1) {

                        //
                        mStageCreatureID = mStageCreature01ID;

                        // Tally point
                        scorePoint();

                        // Inflate tapper
                        inflateTapper();

                        // Regenerate creature
                        switchCreature(R.id.game_main_creature_01_image_button);

                        //
                        mStageCreature01ID = mCreatureID;
                    }
                } else {

                    //
                    if (!mPauseGame || mPauseTimer != -1) {

                        //
                        mStageCreatureID = mStageCreature01ID;

                        // Tally point
                        tabPoint();

                        // Destroy creature
                        findViewById(R.id.game_main_creature_01_image_button).setVisibility(View.GONE);

                        //
                        mStageCreature01ID = mCreatureID;
                    }
                }

                // Housekeeping
                drawScreen();

                break;

            //
            case R.id.game_main_creature_02_image_button:

                //
                if (!mCreatureGameOver) {

                    //
                    if (!mPauseGame || mPauseTimer != -1) {

                        //
                        mStageCreatureID = mStageCreature02ID;

                        // Tally point
                        scorePoint();

                        // Inflate tapper
                        inflateTapper();

                        // Regenerate creature
                        switchCreature(R.id.game_main_creature_02_image_button);

                        //
                        mStageCreature02ID = mCreatureID;
                    }
                } else {

                    //
                    if (!mPauseGame || mPauseTimer != -1) {

                        //
                        mStageCreatureID = mStageCreature02ID;

                        // Tally point
                        tabPoint();

                        // Destroy creature
                        findViewById(R.id.game_main_creature_02_image_button).setVisibility(View.GONE);

                        //
                        mStageCreature02ID = mCreatureID;
                    }
                }

                break;

            //
            case R.id.game_main_creature_03_image_button:

                //
                if (!mCreatureGameOver) {

                    //
                    if (!mPauseGame || mPauseTimer != -1) {

                        //
                        mStageCreatureID = mStageCreature03ID;

                        // Tally point
                        scorePoint();

                        // Inflate tapper
                        inflateTapper();

                        // Regenerate creature
                        switchCreature(R.id.game_main_creature_03_image_button);

                        //
                        mStageCreature03ID = mCreatureID;
                    }
                } else {

                    //
                    if (!mPauseGame || mPauseTimer != -1) {

                        //
                        mStageCreatureID = mStageCreature03ID;

                        // Tally point
                        tabPoint();

                        // Destroy creature
                        findViewById(R.id.game_main_creature_03_image_button).setVisibility(View.GONE);

                        //
                        mStageCreature03ID = mCreatureID;
                    }
                }

                break;

            //
            case R.id.game_main_creature_04_image_button:

                //
                if (!mCreatureGameOver) {

                    //
                    if (!mPauseGame || mPauseTimer != -1) {

                        //
                        mStageCreatureID = mStageCreature04ID;

                        // Tally point
                        scorePoint();

                        // Inflate tapper
                        inflateTapper();

                        // Regenerate creature
                        switchCreature(R.id.game_main_creature_04_image_button);

                        //
                        mStageCreature04ID = mCreatureID;
                    }
                } else {

                    //
                    if (!mPauseGame || mPauseTimer != -1) {

                        //
                        mStageCreatureID = mStageCreature04ID;

                        // Tally point
                        tabPoint();

                        // Destroy creature
                        findViewById(R.id.game_main_creature_04_image_button).setVisibility(View.GONE);

                        //
                        mStageCreature04ID = mCreatureID;
                    }
                }

                break;

            //
            case R.id.game_main_creature_05_image_button:

                //
                if (!mCreatureGameOver) {

                    //
                    if (!mPauseGame || mPauseTimer != -1) {

                        //
                        mStageCreatureID = mStageCreature05ID;

                        // Tally point
                        scorePoint();

                        // Inflate tapper
                        inflateTapper();

                        // Regenerate creature
                        switchCreature(R.id.game_main_creature_05_image_button);

                        //
                        mStageCreature05ID = mCreatureID;
                    }
                } else {

                    //
                    if (!mPauseGame || mPauseTimer != -1) {

                        //
                        mStageCreatureID = mStageCreature05ID;

                        // Tally point
                        tabPoint();

                        // Destroy creature
                        findViewById(R.id.game_main_creature_05_image_button).setVisibility(View.GONE);

                        //
                        mStageCreature05ID = mCreatureID;
                    }
                }

                break;

            //
            case R.id.game_main_boss_image_button:

                //
                mGameBossImageButton.setVisibility(View.GONE);

                // Check pause game
                if (!mPauseGame || mPauseTimer != -1) {

                    // Attack boss
                    attackBoss();
                }

                break;
        }
    }

    // Load stage [pre / switch / post]
    public void loadStage() {

        // Reset apex
        mStageApex = false;

        // Load images, audio, scores
        preLoadStageProps();

        // Switch stage card screen
        switchScreen(R.id.stage_card_screen_main_layout);

        //
        playAudio(mGameTapAudio);

        //
        postLoadStageProps();
    }

    // Initiate game state
    public void startGame() {
        
        //
        Log.d(TAG, "StartGame: startGame...");
        // Pause game
        //Log.d(TAG, "StartGame: pause");
        //mPauseGame = true;

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

        //
        buildStageCollection(mStageIndex);

        //
        mGameBossImageButton.setVisibility(View.GONE);
        mGameCreatureLayout.setVisibility(View.VISIBLE);
        mGameControlLayout.setVisibility(View.VISIBLE);
        mGameMainControlLayout.setVisibility(View.VISIBLE);

        // Switch to game screen
        switchScreen(R.id.game_screen_main_layout);

        // Initial background
        switchEnvironment();

        //
        //fadeTitles(R.id.game_main_stage_caption_layout);

        // Play bg audio
        playAudio(BG_AUDIO);

        //
        if (mHandlerFlag) {

            //
            h2.postDelayed(r2, 1000);
            h4.postDelayed(r4, 1000);

            //
            mHandlerFlag = false;
        }

        //
        Log.d(TAG, "startGame: unpause game");
        mPauseGame = false;
    }

    // Game on timer independent [this WILL run if game is paused]
    private void gameOnSteady() {

        // Add real time
        updateRealTime();

        // Chance that creature will reappear
        revealCreatureRandom(mRevealCreatureRandomIndex);

        // Update frenzy score
        updateFrenzy();

        // Update tunnel vision
        updateTunnel();

        //
        if (!mCreatureGameOver && !mPauseGame && mTapCount > 1) {

            //
            --mTapCount;

            // Update tapper [don't run this in boss mode]
            updateTapper();
        }

        // Decrement / update bite marks
        if (mBittenMeter > 1) {

            //
            --mBittenMeter;
            updateBitten();

        } else {

            //
            mGameBittenLayout.setVisibility(View.INVISIBLE);
        }

        //
        checkPowers();

        // Check timer end game if expired, if not increment game
        if (mHungerMeter > 0) {

            // Decrement hunger
            --mHungerMeter;

            // Score closest death [1 is closest]
            if (mHungerMeter < mStageClosestDeath) {

                //
                mStageClosestDeath = mHungerMeter;
                toastIt("Achievement - CLOSEST TO DEATH", mStageClosestDeath);
            }

            mGameMainHungerMeterProgressBar.setProgress((int) getPercentage(50, mHungerMeter));

        } else {

            // Terminate game mode [switch to boss mode]
            mCreatureGameOver = true;

            //
            return;
        }
    }

    // Game on timer dependent [this WON'T run if game is paused]
    private void gameOnTimer() {

        // Update tick time
        updateTickTime();

        // Score most calm
        updateCalm();

        //
        updateFrantic();

        // Play audio heartbeat
        playAudio(HEARTBEAT);

        // Play haptic heartbeat
        playHaptic();
    }

    // Update real time
    private void updateRealTime() {

        //
        ++mStageTimer;

        //
        updatePower(2);
        updatePower(6); // Freeze
    }

    // Update tick time
    private void updateTickTime() {

        //
        ++mStageHeartbeat;

        // Update powers
        updatePower(1); // Roar
        updatePower(3); // Run
    }

    //
    private void updateCalm() {

        //
        if (mSpeedIndex > mStageMostCalm) {

            //
            mStageMostCalm = mSpeedIndex;
            toastIt("Achievement - MOST CALM", (int) mStageMostCalm);
        }
    }

    //
    private void updateFrantic() {

        // Score most frantic
        if (mSpeedIndex < mStageMostFrantic) {

            //
            mStageMostFrantic = mSpeedIndex;
            toastIt("Achievement - MOST FRANTIC", (int) mStageMostFrantic);
        }
    }

    // Accelerate adrenaline timer
    private void accelerateTimer(double accel_rate) {

        //
        double speed_component = (mSpeedIndex * accel_rate);
        mSpeedIndex = mSpeedIndex - (long) speed_component;
        if (mSpeedIndex < 100) { mSpeedIndex = 100; }
    }

    // Decelerate adrenaline timer
    private void decelerateTimer(double decel_rate) {

        //
        double speed_component = (mSpeedIndex * decel_rate);
        mSpeedIndex = mSpeedIndex + (long) speed_component;
        if (mSpeedIndex > 5000) { mSpeedIndex = 5000; }
    }

    // Update powers
    private void updatePower(int power) {

        //
        switch (power) {

            case 1:

                //
                ++mPower01Meter;
                Toast mToast1 = Toast.makeText(this, "power 1", Toast.LENGTH_SHORT);
                mToast1.show();

                break;

            case 2:

                //
                ++mPower02Meter;
                Toast mToast2 = Toast.makeText(this, "power 2", Toast.LENGTH_SHORT);
                mToast2.show();

                break;

            //
            case 3:

                 //
                 ++mPower03Meter;
                Toast mToast3 = Toast.makeText(this, "power 3", Toast.LENGTH_SHORT);
                mToast3.show();

                break;

            //
            case 4:

                //
                ++mPower04Meter;
                Toast mToast4 = Toast.makeText(this, "power 4", Toast.LENGTH_SHORT);
                mToast4.show();

                break;

            //
            case 5:

                //
                ++mPower05Meter;
                Toast mToast5 = Toast.makeText(this, "power 5", Toast.LENGTH_SHORT);
                mToast5.show();

                break;

            //
            case 6:

                //
                ++mPower06Meter;
                Toast mToast6 = Toast.makeText(this, "power 6", Toast.LENGTH_SHORT);
                mToast6.show();

                break;
        }
    }

    // Hit sprite
    private void scorePoint() {

        // Ensure still alive
        if (mHungerMeter > 0) {

            // Ensure still creature mode
            if (!mCreatureGameOver) {

                // Ensure within resource array bounds
                if (mTapCount > 0 && mTapCount < 11) {

                    // Play audio ping - scale for stacking
                    playAudio(PINGS[mTapCount - 1]);
                }
            }

            // Housekeeping
            tabPoint();
        }
    }

    //
    private void tabPoint() {

        // Check collection [DO this in boss mode]
        checkCreatureBox();

        // Increment hit counter [DO this in boss mode]
        ++mStageCreatureKills;

        //
        ++mStreakCount;

        // [DO this in boss mode]
        ++mTurn;

        //
        adjustAdrenaline();

        // [DO this in boss mode]
        ++mHungerMeter;

        // Play bite noise [DO this in boss mode]
        playAudio(HIT);

        // Reset bold image [DO this in boss mode]
        if (mHungerMeter < ALPHA_INDEX.length) {

            //
            mGameTunnelVisionLayout.setAlpha((float) ALPHA_INDEX[mHungerMeter]);
        }
    }

    // Miss sprite
    private void missPoint() {

        // Ensure there is still time
        if (mHungerMeter > 0) {

            // Play miss noise
            playAudio(MISS);
            }

        //
        //mBittenMeter = mBittenMeter + 5;
        Random r = new Random();
        mGameBloodsplatLayout.setBackground(versionCheck(BITTEN_IMAGES[r.nextInt(BITTEN_IMAGES.length - 1)]));
        fadeBloodsplat();

        //
        ++mTurn;

        //
        mStreakCount = 0;

        //
        adjustAdrenaline();
    }

    // Adjust adrenaline
    private void adjustAdrenaline() {

        //
        if (mSpeedIndex <= 1000) {

            // If adrenaline high, speed up
            accelerateTimer(.15);

        } else {

            // If adrenaline low, slow down
            decelerateTimer(.15);
        }

        //
        mGameAdrenalineLayout.setAlpha(getPercentage((int) mSpeedIndex, 1));
    }

    // Check creature box
    private void checkCreatureBox() {

        // Check creature box is not empty
        if (!mStageCreatureBox.isEmpty()) {

            // Check if creature is already in box
            if (!mStageCreatureBox.contains(mStageCreatureID)) {

                // Add creature to box
                mStageCreatureBox.add(mStageCreatureID);
                buildCreatureCollection(mStageCreatureID, (mStageCreatureBox.size() - 1)); // buildCreatureCollection is called from 2 different methods, this one
                                                                                            // needs to subtract 1 to avoid arrayIndexOutOfBounds

                //
                playAudio(BAMBOO_CLICK);

            }

        } else {

            // Add creature to box
            mStageCreatureBox.add(mStageCreatureID);
            buildCreatureCollection(mStageCreatureID, mStageCreatureBox.size());
        }

        //
        mStageCreatureID = -1;
    }

    // Use power
    private void usePower(int power_meter, int power_target, int power_index) {

        // Verify power meter
        if (power_meter >= power_target) {

            // Switch power call
            switch (power_index) {

                // Roar [reveal creatures / accelerate adrenaline]
                case 1:

                    //
                    mPower01Meter = 0;
                    mPower01Target = mPower01Target + mPowerIncrement;

                    // Add predator score
                    ++mStagePredator;

                    // Accelerate timer
                    accelerateTimer(.25);

                    //
                    lessBorder(.5);

                    //
                    for (int creature : CREATURE_BUTTONS) {

                        //
                        showCreature(creature);
                    }

                    //
                    updatePower(5); // Rage

                    //
                    playAudio(ROAR);

                    break;

                // Breathe [hide creatures / declerate adrenaline]
                case 2:

                    //
                    mPower02Meter = 0;
                    mPower02Target = mPower02Target + mPowerIncrement;

                    //
                    ++mStageStalker;

                    // Decelerate timer
                    decelerateTimer(.5);

                    // Reveal border
                    moreBorder(.25);

                    //
                    for (int creature : CREATURE_BUTTONS) {

                        //
                        hideCreature(creature);
                    }

                    //
                    updatePower(4); // Peak

                    //
                    playAudio(BREATH);

                    break;

                // Run
                case 3:

                    // Pause game
                    mPauseGame = true;

                    //
                    tapOut();

                    //
                    mCurScreen = R.id.game_screen_main_layout;
                    drawScreen();

                    //
                    playAudio(RUN);

                    // Undo pause game
                    mPauseGame = false;

                    break;

                // See
                case 4:

                    //
                    mPower04Meter = 0;
                    mPower04Target = mPower04Target + mPowerIncrement;

                    //
                    resetBorder();

                    //
                    for (int creature : CREATURE_BUTTONS) {
                        showCreature(creature);
                    }

                    //
                    playAudio(FLUTE_TRILL_SHORT);

                    break;

                // Bolt
                case 5:

                    //
                    mPower05Meter = 0;
                    mPower05Target = mPower05Target + mPowerIncrement;

                    //
                    if (!mPauseGame) {

                        // Inflate tapper
                        inflateTapper();

                        // Inflate tapper
                        inflateTapper();

                        // Inflate tapper
                        inflateTapper();

                        // Inflate tapper
                        inflateTapper();

                        // Inflate tapper
                        inflateTapper();

                        //
                        mTurn = mTurn + 5;
                        mStageCreatureKills = mStageCreatureKills + 5;
                        mStageHighestStreak = mStageHighestStreak + 5;

                        // Accelerate timer
                        accelerateTimer(.75);

                        // Capture creature
                        mStageCreatureID = mStageCreature01ID;
                        mStageCreature01ID = mCreatureID;

                        //
                        checkCreatureBox();

                        // Regenerate creature
                        switchCreature(R.id.game_main_creature_01_image_button);

                        // Capture creature
                        mStageCreatureID = mStageCreature02ID;
                        mStageCreature02ID = mCreatureID;

                        //
                        checkCreatureBox();

                        // Regenerate creature
                        switchCreature(R.id.game_main_creature_02_image_button);

                        // Capture creature
                        mStageCreatureID = mStageCreature03ID;
                        mStageCreature03ID = mCreatureID;

                        //
                        checkCreatureBox();

                        // Regenerate creature
                        switchCreature(R.id.game_main_creature_03_image_button);

                        // Capture creature
                        mStageCreatureID = mStageCreature04ID;
                        mStageCreature04ID = mCreatureID;

                        //
                        checkCreatureBox();

                        // Regenerate creature
                        switchCreature(R.id.game_main_creature_04_image_button);

                        // Capture creature
                        mStageCreatureID = mStageCreature05ID;
                        mStageCreature05ID = mCreatureID;

                        //
                        checkCreatureBox();

                        // Regenerate creature
                        switchCreature(R.id.game_main_creature_05_image_button);

                        // Play bite noise
                        playAudio(FRENZY);
                    }

                    break;

                // Freeze
                case 6:

                    //
                    mPauseGame = true;
                    mPauseTimer = 20;

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

        // Pause game
        Log.d(TAG, "startBoss: pause");
        mPauseGame = true;
        //mPauseTimer = -1;

        //
        mStageApex = true;
        mBossGameOver = false;

        //
        mBossHealth = 5;
        mHungerMeter = 20;
        mBossDowned = true;

        //
        mGameControlLayout.setVisibility(View.GONE);
        mGameMainControlLayout.setVisibility(View.GONE);
        //mGameBorderLayout.setVisibility(View.GONE);
        //mGameTunnelVisionLayout.setVisibility(View.GONE);

        //
        //Log.d(TAG, "startBoss: creatures should be gone here...");
        //mGameCreature01ImageButton.setVisibility(View.GONE);
        //mGameCreature02ImageButton.setVisibility(View.GONE);
        //mGameCreature03ImageButton.setVisibility(View.GONE);
        //mGameCreature04ImageButton.setVisibility(View.GONE);
        //mGameCreature05ImageButton.setVisibility(View.GONE);

        // Load boss scene image
        mGameCreatureLayout.setBackground(versionCheck(BOSS_SCENE_IMAGES[mStageIndex - 1]));

        //
        moveCreature(R.id.game_main_boss_image_button, R.id.game_main_pg_creature_canvas_layout);

        //
        //mGameBossImageButton.setVisibility(View.VISIBLE);

        //
        drawScreen();
        mGameBossHealthProgressBar.setProgress(0);


        // Undo pause game
        Log.d(TAG, "startBoss: un-pause");
        mPauseGame = false;

        //
        playAudio(FLUTE_TRILL_SHORT);
        playAudio(BOSS_AUDIO);

        //
        h3.postDelayed(r3, 1000);
    }

    // Attack boss
    private void attackBoss() {

        //
        playAudio(ROAR);

        //
        if (mBossHealth > 0) {

            //
            --mBossHealth;
            mBossDowned = true;

            mGameBossHealthProgressBar.setProgress((int) getPercentage(20, mBossHealth));

        } else {

            //
            findViewById(R.id.game_screen_main_layout).setVisibility(View.GONE);
            mBossGameOver = true;
        }

        // Move boss
        if (!mBossGameOver) {

            //
            moveCreature(R.id.game_main_boss_image_button, R.id.game_main_pg_creature_canvas_layout);
        }

        //
        drawScreen();
    }

    // Kill boss
    private void killBoss()    {

        // Pause game
        Log.d(TAG, "killBoss");
        mPauseGame = true;

        playAudio(mGameBossCry);

        mGameBorderLayout.setVisibility(View.GONE);
        mGameTunnelVisionLayout.setVisibility(View.GONE);
        mGameCreatureLayout.setVisibility(View.GONE);
        mGameBittenLayout.setVisibility(View.GONE);

        mGameCreature01ImageButton.setVisibility(View.GONE);
        mGameCreature02ImageButton.setVisibility(View.GONE);
        mGameCreature03ImageButton.setVisibility(View.GONE);
        mGameCreature04ImageButton.setVisibility(View.GONE);
        mGameCreature05ImageButton.setVisibility(View.GONE);

        // Get time score
        mStageTime = mStageTimer;

        //
        mStageComplete = true;

        // Extract stage scores to local variables
        extractScores();
        
        // Set data
        setGameData();

        // Get data
        getGameData();

        // Load stage card
        mStageReady = 3;

        //
        mHandlerFlag = true;

        // Populate stage scores
        buildStageScores();

        //
        loadStage();

        // Play audio
        playAudio(mGameTapAudio);
        playAudio(FLUTE_TRILL_LONG);
    }

    // Custom toast method
    private void toastIt(String message, int score) {

        //
        Toast mToast = Toast.makeText(this, message + ": " + score, Toast.LENGTH_SHORT);
        mToast.show();
    }

    //
    private void updateFrenzy() {

        //
        if (mHungerMeter < 20) {

            //
            ++mStageFrenzy;

            // Score longest frenzy
            if (mStageFrenzy > mStageLongestFrenzy) { mStageLongestFrenzy = mStageFrenzy; }

            //
            Toast frenzyToast = Toast.makeText(this, "FRENZY ACHIEVEMENT: " + mStageFrenzy, Toast.LENGTH_SHORT);
            frenzyToast.show();

        } else {

            //
            mStageFrenzy = 0;
        }
    }

    // Extract stage scores
    private void extractScores() {
        
        //
        if (mStageIndex != -1) {

            //
            int i;
            int j;

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
                    if (mStagePredator > 4) { mStagePredator = 5; }
                    if (mStagePredator > stage_01_predator) { stage_01_predator = mStagePredator; } // Replace if better - maintain top scores at top
                    
                    //
                    mStageAccuracy = (int) getPercentage(mTurn, mStageCreatureKills);
                    if (mStageAccuracy > stage_01_accuracy) { stage_01_accuracy = mStageAccuracy; } // Replace if better

                    // Scores best time and total time
                    if (mStageTime < stage_01_best_time || stage_01_best_time == 0) { stage_01_best_time = mStageTime; } // Replace if better
                    stage_01_total_time += mStageTime; // This will accumulate regardless

                    // Scores creature kills and collection
                    stage_01_creature_kills += mStageCreatureKills; // This will accumulate regardless

                    //
                    mStageCollection = mStageCreatureBox.size();

                    //
                    j = 0;

                    // Creature collection
                    for (int creature_captured : mStageCreatureBox) {

                        //
                        i = 0;
                        j = 0;

                        //
                        for (int creature : CREATURES) {

                            //
                            if (creature == creature_captured) {

                                //
                                stage_01_top_creatures_previous.set(i, true);
                                ++j;
                            }

                            //
                            ++i;
                        }
                    }

                    //
                    stage_01_collection = j - 1;

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
                    mStageAccuracy = (int) getPercentage(mTurn, mStageCreatureKills);
                    if (mStageAccuracy > stage_02_accuracy) { stage_02_accuracy = mStageAccuracy; } // Replace if better

                    // Scores best time and total time
                    if (mStageTime < stage_02_best_time || stage_02_best_time == 0) { stage_02_best_time = mStageTime; } // Replace if better
                    stage_02_total_time += mStageTime; // This will accumulate regardless

                    // Scores creature kills and collection
                    stage_02_creature_kills += mStageCreatureKills; // This will accumulate regardless

                    //
                    mStageCollection = mStageCreatureBox.size();
                    //if (mStageCollection > stage_02_collection) { stage_02_collection = mStageCollection; } // Need to parse this programmatically

                    //

                    j = 0;

                    // Creature collection
                    for (int creature_captured : mStageCreatureBox) {

                        //
                        i = 0;
                        j = 0;

                        //
                        for (int creature : CREATURES) {

                            //
                            if (creature == creature_captured) {

                                //
                                stage_02_top_creatures_previous.set(i, true);
                                ++j;
                            }

                            //
                            ++i;
                        }
                    }

                    //
                    stage_02_collection = j - 1;

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
                    mStageAccuracy = (int) getPercentage(mTurn, mStageCreatureKills);
                    if (mStageAccuracy > stage_03_accuracy) { stage_03_accuracy = mStageAccuracy; } // Replace if better

                    // Scores best time and total time
                    if (mStageTime < stage_03_best_time || stage_03_best_time == 0) { stage_03_best_time = mStageTime; } // Replace if better
                    stage_03_total_time += mStageTime; // This will accumulate regardless

                    // Scores creature kills and collection
                    stage_03_creature_kills += mStageCreatureKills; // This will accumulate regardless

                    //
                    mStageCollection = mStageCreatureBox.size();
                    //if (mStageCollection > stage_03_collection) { stage_03_collection = mStageCollection; } // Need to parse this programmatically

                    //

                    j = 0;

                    // Creature collection
                    for (int creature_captured : mStageCreatureBox) {

                        //
                        i = 0;
                        j = 0;

                        //
                        for (int creature : CREATURES) {

                            //
                            if (creature == creature_captured) {

                                //
                                stage_03_top_creatures_previous.set(i, true);
                                ++j;
                            }

                            //
                            ++i;
                        }
                    }

                    //
                    stage_03_collection = j - 1;

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
                    mStageAccuracy = (int) getPercentage(mTurn, mStageCreatureKills);
                    if (mStageAccuracy > stage_04_accuracy) { stage_04_accuracy = mStageAccuracy; } // Replace if better

                    // Scores best time and total time
                    if (mStageTime < stage_04_best_time || stage_04_best_time == 0) { stage_04_best_time = mStageTime; } // Replace if better
                    stage_04_total_time += mStageTime; // This will accumulate regardless

                    // Scores creature kills and collection
                    stage_04_creature_kills += mStageCreatureKills; // This will accumulate regardless

                    //
                    mStageCollection = mStageCreatureBox.size();
                    //if (mStageCollection > stage_04_collection) { stage_04_collection = mStageCollection; } // Need to parse this programmatically

                    //

                    j = 0;

                    // Creature collection
                    for (int creature_captured : mStageCreatureBox) {

                        //
                        i = 0;
                        j = 0;

                        //
                        for (int creature : CREATURES) {

                            //
                            if (creature == creature_captured) {

                                //
                                stage_04_top_creatures_previous.set(i, true);
                                ++j;
                            }

                            //
                            ++i;
                        }
                    }

                    //
                    stage_04_collection = j - 1;

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
                    mStageAccuracy = (int) getPercentage(mTurn, mStageCreatureKills);
                    if (mStageAccuracy > stage_05_accuracy) { stage_05_accuracy = mStageAccuracy; } // Replace if better

                    // Scores best time and total time
                    if (mStageTime < stage_05_best_time || stage_05_best_time == 0) { stage_05_best_time = mStageTime; } // Replace if better
                    stage_05_total_time += mStageTime; // This will accumulate regardless

                    // Scores creature kills and collection
                    stage_05_creature_kills += mStageCreatureKills; // This will accumulate regardless

                    //
                    mStageCollection = mStageCreatureBox.size();
                    //if (mStageCollection > stage_05_collection) { stage_05_collection = mStageCollection; } // Need to parse this programmatically

                    //

                    j = 0;

                    // Creature collection
                    for (int creature_captured : mStageCreatureBox) {

                        //
                        i = 0;
                        j = 0;

                        //
                        for (int creature : CREATURES) {

                            //
                            if (creature == creature_captured) {

                                //
                                stage_05_top_creatures_previous.set(i, true);
                                ++j;
                            }

                            //
                            ++i;
                        }
                    }

                    //
                    stage_05_collection = j - 1;

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
                    mStageAccuracy = (int) getPercentage(mTurn, mStageCreatureKills);
                    if (mStageAccuracy > stage_06_accuracy) { stage_06_accuracy = mStageAccuracy; } // Replace if better

                    // Scores best time and total time
                    if (mStageTime < stage_06_best_time || stage_06_best_time == 0) { stage_06_best_time = mStageTime; } // Replace if better
                    stage_06_total_time += mStageTime; // This will accumulate regardless

                    // Scores creature kills and collection
                    stage_06_creature_kills += mStageCreatureKills; // This will accumulate regardless

                    //
                    mStageCollection = mStageCreatureBox.size();
                    //if (mStageCollection > stage_06_collection) { stage_06_collection = mStageCollection; } // Need to parse this programmatically

                    //

                    j = 0;

                    // Creature collection
                    for (int creature_captured : mStageCreatureBox) {

                        //
                        i = 0;
                        j = 0;

                        //
                        for (int creature : CREATURES) {

                            //
                            if (creature == creature_captured) {

                                //
                                stage_06_top_creatures_previous.set(i, true);
                                ++j;
                            }

                            //
                            ++i;
                        }
                    }

                    //
                    stage_06_collection = j - 1;

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
                    mStageAccuracy = (int) getPercentage(mTurn, mStageCreatureKills);
                    if (mStageAccuracy > stage_07_accuracy) { stage_07_accuracy = mStageAccuracy; } // Replace if better

                    // Scores best time and total time
                    if (mStageTime < stage_07_best_time || stage_07_best_time == 0) { stage_07_best_time = mStageTime; } // Replace if better
                    stage_07_total_time += mStageTime; // This will accumulate regardless

                    // Scores creature kills and collection
                    stage_07_creature_kills += mStageCreatureKills; // This will accumulate regardless

                    //
                    mStageCollection = mStageCreatureBox.size();
                    //if (mStageCollection > stage_07_collection) { stage_07_collection = mStageCollection; } // Need to parse this programmatically

                    //

                    j = 0;

                    // Creature collection
                    for (int creature_captured : mStageCreatureBox) {

                        //
                        i = 0;
                        j = 0;

                        //
                        for (int creature : CREATURES) {

                            //
                            if (creature == creature_captured) {

                                //
                                stage_07_top_creatures_previous.set(i, true);
                                ++j;
                            }

                            //
                            ++i;
                        }
                    }

                    //
                    stage_07_collection = j - 1;

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

        //
        if (mHungerMeter > 0) {

            //
            startBoss();

        } else {

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
        resetBorder();

        //
        mHungerMeter = 30;
        mSpeedIndex = 1000;

        //mStageAdvanceMeter = 0;
        //mStageAdvanceTarget = 1;

        //
        mStageFrenzy = 0;

        //
        mPowerIncrement = 3;

        // Roar
        mPower01Meter = 0;
        mPower01Target =  6;

        // Bolt
        mPower05Meter = 0;
        mPower05Target = 9;

        // Freeze
        mPower06Meter = 0;
        mPower06Target = 15;

        // Breathe
        mPower02Meter = 0;
        mPower02Target = 6;

        // Dash
        mPower03Meter = 0;
        mPower03Target = 15;

        // See
        mPower04Meter = 0;
        mPower04Target = 9;

        //
        mTurn = 0;

        //
        mTapBarrel = 15;
        mTapCount = 0;
        mStreakCount = 0;
        mTapTotal = 0;
        mRunFlag = false;

        //
        mPauseTimer = -1;
        mStageTimer = 0;
        mStageTime = 0;
        mStageHeartbeat = 0;

        //
        mCreatureGameOver = false;
        mBossGameOver = false;

        //
        mBossHealth = 0;
        mBossDowned = false;

        //
        mStagePredator = 0;
        mStageStalker = 0;
        mStageAccuracy = 0f;

        //
        mStageCreatureKills = 0;
        mStageCollection = 0;
        mStageCreatureBox.clear();

        //
        mRevealCreatureRandomIndex = 5;

        //
        mStageHighestStreak = 0;
        mStageClosestDeath = 20;
        mStageLongestFrenzy = 0;
        mStageMostCalm = 500;
        mStageMostFrantic = 500;

        mGameAdrenalineLayout.setAlpha(0);
    }

    // Prep stage
    public void prepStage() {

        // Ready stage creature collection array
        mStageCreatureBox.clear();

        //
        mStageCreatureID = -1;

        // Load scene images and names
        mStageSceneImages.clear();

        //
        mStageSceneNames.clear();

        // Load stage scene images
        for (int scene : STAGE_SCENES[mStageIndex - 1]) {

            //
            mStageSceneImages.add(scene);
        }

        // Load scene names
        mStageSceneNames.addAll(Arrays.asList(STAGE_SCENE_NAMES[mStageIndex - 1]));

        // Assign stage color
        mGameSceneTextView.setBackgroundColor(ContextCompat.getColor(this, STAGE_COLOR[mStageIndex - 1]));
        mGameLevelMarkerLayout.setBackgroundColor(ContextCompat.getColor(this, STAGE_COLOR[mStageIndex - 1]));

        // Load stage name
        mGameStageImageView.setBackground(versionCheck(STAGE_NAMES[mStageIndex - 1]));

        // Load stage border image
        mGameBorderLayout.setBackground(versionCheck(STAGE_BORDERS[mStageIndex - 1]));

        // Load stage disaster image
        //mStageDisasterImageView.setBackground(versionCheck(STAGE_DISASTERS[mStageIndex - 1]));
    }

    // CPU light / required resources
    public void preLoadStageProps() {

        // Load stage disaster audio
        mGameTapAudio = STAGE_DISASTER_AUDIO[mStageIndex - 1];

        // Load boss cry
        mGameBossCry = BOSS_CRY_AUDIO[mStageIndex - 1];

        //
        mGameDisasterLayout.setBackground(versionCheck(STAGE_DISASTERS[mStageIndex - 1]));
    }

    // CPU heavy resources
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void postLoadStageProps() {

        //
        if (mStageComplete) {

            //
            mStageCardHiScoreImageButton.setVisibility(View.VISIBLE);
            mStageCardTrophyImageButton.setVisibility(View.VISIBLE);

            // Load boss image button
            mGameBossImageButton.setBackground(versionCheck(BOSS_IMAGES[mStageIndex - 1]));

            //
            fadeBoss();

            // Reset trophy case
            resetCreatureCollection();

            // Populate trophy case
            buildTrophycase();

            // Populate top scores
            buildScorecard();

        }
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

        //
        fadeBlackout();

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

        //
        mStageLocked = false;
        mTrophycase = false;
        mTopScores = false;
        mStageScores = false;
        mEatenScores = false;
        mContent = false;

        //
        switch (mCurScreen) {

            //
            case R.id.credits_screen_main_layout:

                //
                mCreditsImageView.setVisibility(View.VISIBLE);

                break;

            //
            case R.id.entry_screen_main_layout:

                //
                mEntryMainControlLayout.setVisibility(View.VISIBLE);
                fadeControl(R.id.entry_main_control_layout);

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

                break;

            case R.id.stage_select_screen_main_layout:

                // Reset stage index
                mStageIndex = -1;
                mStageReady = -1;
                mStageApex = false;
                mStageComplete = false;

                // Build stage cards
                buildStageCards();

                // Display stage cards
                mStageSelectScorecardLayout.setVisibility(View.GONE);
                mStageSelectCollectionLayout.setVisibility(View.GONE);
                mStageSelectContentLayout.setVisibility(View.VISIBLE);
                mStageSelectContentImageButton.setAlpha(1f);

                // Hide top scores button if none
                if (!stage_01_complete) {

                    //
                    mStageSelectMainScorecardLayout.setVisibility(View.GONE);
                    mStageSelectMainCollectionLayout.setVisibility(View.GONE);
                    mStageSelectMainContentLayout.setVisibility(View.GONE);

                } else {

                    //
                    buildGameTrophyCase();
                    buildGameScores();

                    //
                    mStageSelectMainScorecardLayout.setVisibility(View.VISIBLE);
                    mStageSelectMainCollectionLayout.setVisibility(View.VISIBLE);
                    mStageSelectMainContentLayout.setVisibility(View.VISIBLE);
                    mStageSelectScorecardImageButton.setAlpha(.5f);
                    mStageSelectCollectionImageButton.setAlpha(.5f);
                }

                break;

            case R.id.stage_card_screen_main_layout:

                //
                fadeDisaster();

                // Load stage resources
                //mStageCardDisasterBGImageView.setBackground(versionCheck(STAGE_DISASTERS[mStageIndex - 1]));
                //fadeControl(R.id.stage_card_disaster_bg_image_view);
                mStageCardBossImageView.setBackground(versionCheck(BOSS_IMAGES[mStageIndex - 1]));
                //fadeIn(R.id.stage_card_boss_image_view);
                mStageCardContentTitleImageButton.setBackground(versionCheck(STAGE_NAMES[mStageIndex - 1]));
                mStageCardContentTitleLayout.setBackgroundColor(ContextCompat.getColor(this, STAGE_COLOR[mStageIndex - 1]));
                mStageCardBossNameTextView.setText(BOSS_NAME[mStageIndex - 1] + " - " + DISASTER_NAME[mStageIndex - 1]);
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

                // [1 = Stage Locked / 2 = Stage Ready / 3 = Stage Complete / 4 = Stage Over]
                switch (mStageReady) {

                    // Case - Stage Locked
                    case 1:

                        //
                        mStageCardLockedImageButton.setVisibility(View.VISIBLE);
                        mStageCardMainTrophyLayout.setVisibility(View.GONE);
                        mStageCardMainHiScoreLayout.setVisibility(View.GONE);
                        mStageCardMainStageScoreLayout.setVisibility(View.GONE);
                        mStageCardMainEatenLayout.setVisibility(View.GONE);
                        mStageCardMainContentLayout.setVisibility(View.GONE);

                        //
                        mStageCardStageLockedLayout.setVisibility(View.VISIBLE);
                        mStageCardCollectionLayout.setVisibility(View.GONE);
                        mStageCardTopScoreLayout.setVisibility(View.GONE);
                        mStageCardScorecardLayout.setVisibility(View.GONE);
                        mStageCardEatenScoreLayout.setVisibility(View.GONE);
                        mStageCardContentLayout.setVisibility(View.GONE);

                        //
                        mStageCardContentTitleLayout.setBackgroundColor(Color.BLACK);

                        //
                        mStageLocked = true;

                        break;

                    // Case - Stage Ready
                    case 2:

                        //
                        mStageCardLockedImageButton.setVisibility(View.GONE);
                        mStageCardMainTrophyLayout.setVisibility(View.GONE);
                        mStageCardMainHiScoreLayout.setVisibility(View.GONE);
                        mStageCardMainStageScoreLayout.setVisibility(View.GONE);
                        mStageCardMainEatenLayout.setVisibility(View.GONE);
                        mStageCardMainContentLayout.setVisibility(View.GONE);

                        //
                        if (mStageComplete) {

                            //
                            mStageCardMainTrophyLayout.setVisibility(View.VISIBLE);
                            mStageCardTrophyImageButton.setAlpha(.5f);
                            mStageCardMainHiScoreLayout.setVisibility(View.VISIBLE);
                            mStageCardHiScoreImageButton.setAlpha(.5f);
                            mStageCardMainContentLayout.setVisibility(View.VISIBLE);
                            mStageCardContentImageButton.setAlpha(1f);
                        }

                        //
                        mStageCardStageLockedLayout.setVisibility(View.GONE);
                        mStageCardCollectionLayout.setVisibility(View.GONE);
                        mStageCardTopScoreLayout.setVisibility(View.GONE);
                        mStageCardScorecardLayout.setVisibility(View.GONE);
                        mStageCardEatenScoreLayout.setVisibility(View.GONE);
                        mStageCardContentLayout.setVisibility(View.VISIBLE);

                        //
                        mContent = true;

                        break;

                    // Case - Stage Complete[d]
                    case 3:

                        //
                        mStageCardMainTrophyLayout.setVisibility(View.VISIBLE);
                        mStageCardMainHiScoreLayout.setVisibility(View.VISIBLE);
                        mStageCardMainStageScoreLayout.setVisibility(View.VISIBLE);
                        mStageCardMainEatenLayout.setVisibility(View.GONE);
                        mStageCardMainContentLayout.setVisibility(View.VISIBLE);

                        //
                        mStageCardTrophyImageButton.setAlpha(.5f);
                        mStageCardHiScoreImageButton.setAlpha(.5f);
                        mStageCardStageScoreImageButton.setAlpha(1f);
                        mStageCardContentImageButton.setAlpha(.5f);

                        //
                        mStageCardScorecardLayout.setVisibility(View.VISIBLE);
                        mStageCardEatenScoreLayout.setVisibility(View.GONE);
                        mStageCardContentLayout.setVisibility(View.GONE);

                        //
                        mStageScores = true;

                        //fadeFlash();

                        break;

                    // Case - Stage Over
                    case 4:

                        //
                        mStageCardMainStageScoreLayout.setVisibility(View.GONE);
                        mStageCardMainEatenLayout.setVisibility(View.VISIBLE);
                        mStageCardEatenImageButton.setAlpha(1f);
                        mStageCardMainContentLayout.setVisibility(View.VISIBLE);
                        mStageCardContentImageButton.setAlpha(.5f);

                        //
                        mStageCardScorecardLayout.setVisibility(View.GONE);
                        mStageCardEatenScoreLayout.setVisibility(View.VISIBLE);
                        mStageCardContentLayout.setVisibility(View.GONE);

                        //
                        mEatenScores = true;

                        //fadeFlash();

                        break;
                }

                break;

            //
            case R.id.game_screen_main_layout:

                //
                if (!mCreatureGameOver) {

                    // Check power display
                    checkPowers();

                    // Check tap fade
                    updateTapper();

                    //
                    mGameAdrenalineLayout.setAlpha(getPercentage((int) mSpeedIndex, 1));
                }

                //
                updateBitten();

                // Check tunnel view fade
                updateTunnel();

                break;
        }
    }

    // Check power display
    public void checkPowers() {

        // Power 1
        if (mPower01Meter >= mPower01Target) { mGamePower01ImageView.setVisibility(View.VISIBLE); }
        else { mGamePower01ImageView.setVisibility(View.INVISIBLE); }

        // Power 2
        if (stage_01_complete) {

            //
            if (mPower02Meter >= mPower02Target) { mGamePower02ImageView.setVisibility(View.VISIBLE); }
            else { mGamePower02ImageView.setVisibility(View.INVISIBLE); }

        } else { mGamePower02ImageView.setVisibility(View.GONE); }

        // Power 5
        if (stage_02_complete) {

            if (mPower05Meter >= mPower05Target) { mGamePower05ImageView.setVisibility(View.VISIBLE); }
            else { mGamePower05ImageView.setVisibility(View.INVISIBLE); }

        } else { mGamePower05ImageView.setVisibility(View.GONE); }

        // Power 4
        if (stage_03_complete) {

            if (mPower04Meter >= mPower04Target) { mGamePower04ImageView.setVisibility(View.VISIBLE); }
            else { mGamePower04ImageView.setVisibility(View.INVISIBLE); }

        } else { mGamePower04ImageView.setVisibility(View.GONE); }

        // Power 6
        if (stage_04_complete) {

            if (mPower06Meter >= mPower06Target) { mGamePower06ImageView.setVisibility(View.VISIBLE); }
            else { mGamePower06ImageView.setVisibility(View.INVISIBLE); }

        } else { mGamePower06ImageView.setVisibility(View.GONE); }
        // Power 3
        //if (stage_05_complete) {

            //if (mPower03Meter >= mPower03Target) { mGamePower03ImageView.setVisibility(View.VISIBLE); }
            //else { mGamePower03ImageView.setVisibility(View.INVISIBLE); }

        //} else { mGamePower03ImageView.setVisibility(View.GONE);
            // }

    }

    // Update tunnel
    private void updateTunnel() {

        //
        mGameTunnelVisionLayout.setVisibility(View.VISIBLE);

        //
        if (mHungerMeter < ALPHA_INDEX.length) {

            //
            double tunnel_alpha = ALPHA_INDEX[mHungerMeter];
            mGameTunnelVisionLayout.setAlpha((float) tunnel_alpha);

        } else {

            //
            mGameTunnelVisionLayout.setAlpha(0);
        }
    }

    // Reveal more stage border
    private void moreBorder(double more_border) {

        //
        double border = mGameBorderLayout.getAlpha() + more_border;
        mGameBorderLayout.setAlpha((float) border);
    }

    // Reveal more stage border
    private void lessBorder(double less_border) {

        //
        double border = mGameBorderLayout.getAlpha() - less_border;
        mGameBorderLayout.setAlpha((float) border);
    }

    // Update tapper
    private void updateTapper() {

        //
        if (mTapCount > 11) {

            if (mTapTotal < LEVEL_MARKERS.length) {

                //
                findViewById(LEVEL_MARKERS[mTapTotal]).setBackground(versionCheck(STAGE_DISASTERS[mStageIndex - 1]));
            }
            //
            tapOut();
        }

        //
        if (stage_03_complete) {
            //
            if (mTapCount < mTapBarrel) {

                // Adjust view visibility
                mGamePower03ImageView.setVisibility(View.INVISIBLE);
            }
            mGamePower03ImageView.setVisibility(View.VISIBLE);
        }

        //
        if (mTapCount > 1) {

            //
            mGameMainTapoutMeterProgressBar.setProgress((int) getPercentage(mTapBarrel, mTapCount));

        //} else if (mTapCount < 1) {

            //
            //mGameMainTapoutMeterProgressBar.setProgress(0);

        } else {

            //
            mGameMainTapoutMeterProgressBar.setProgress(1);
        }
    }

    //
    private void updateBitten() {

        //
        mGameBittenLayout.setVisibility(View.VISIBLE);

        //
        if (mBittenMeter < 0) { mBittenMeter = 0; }
        if (mBittenMeter > 19) { mBittenMeter = 19; }
        if (mBittenMeter < ALPHA_INDEX.length) {

            //
            double bitten_alpha = ALPHA_INDEX_INVERSE[mBittenMeter];
            mGameBittenLayout.setAlpha((float) bitten_alpha);
        } else {

            //
            mGameBittenLayout.setAlpha(0);
        }
    }

    // Reset tunnel
    private void resetTunnel() {

        // Reset tunnel meter
        //mHungerMeter = 50;
        //mSpeedIndex = 2000;

        // Update tunnel image
        updateTunnel();
    }

    // Reset border
    private void resetBorder() {

        // Reset border
        mGameBorderLayout.setAlpha(0);

    }

    // Reset tap meter
    public void resetTapper() {

        //
        mTapCount = 0;
        mStreakCount = 0;

        //
        //mStageDisasterImageView.setAlpha((float) 0);

        // Update tap image
        updateTapper();
    }

    //
    public void resetBitten() {

        //
        mBittenMeter = 0;

        //
        mGameBittenLayout.setAlpha(1f);
        mGameBittenLayout.setVisibility(View.INVISIBLE);

        //
        updateBitten();
    }

    // Inflate tapper
    public void inflateTapper() {

        // Inflate tap variable
        ++mTapCount;

        // Score highest streak
        if (mStreakCount >= mStageHighestStreak || mStageHighestStreak == 0) { mStageHighestStreak = mStreakCount; }

        // Check target
        if (mTapCount >= mTapBarrel) {

            //
            mGamePower05ImageView.setVisibility(View.VISIBLE);

            // Play audio
            playAudio(CROW_AUDIO);

        } else {

            //
            mGamePower05ImageView.setVisibility(View.INVISIBLE);

            // Play audio
            playAudio(PINGS[0]);
        }

        // Update bolt, whirlpool, etc.
        updateTapper();
    }

    // Advance to next bg
    private void tapOut() {

        // Pause game
        Log.d(TAG, "tapOut: pause");
        mPauseGame = true;

        // Stage progress
        ++mTapTotal;

        //
        ++mStageAdvanceMeter;
        ++mTapBarrel;

        //
        if (mTapTotal == mStageSceneImages.size()) {

            // Start boss
            mCreatureGameOver = true;

        } else {

            //
            switchEnvironment();

            //
            removeBG();

            //
            if (!(mTapTotal > LEVEL_MARKERS.length - 1)) {

                //
                findViewById(LEVEL_MARKERS[mTapTotal - 1]).setAlpha(1f);
                findViewById(LEVEL_MARKERS[mTapTotal]).setAlpha(1f);
                //findViewById(LEVEL_MARKERS[mTapTotal]).setBackground(versionCheck(BOSS_IMAGES[mStageIndex - 1]));

            } else {

                //
                for (int marker : LEVEL_MARKERS) {
                    findViewById(marker).setAlpha(1f);
                }

            }
            //mGameLevelMarkerImageView.setBackground(versionCheck(LEVEL_MARKERS[mTapTotal]));
            //mGameLevelMarkerLayout.setVisibility(View.VISIBLE);
            //mGamePowersLayout.setVisibility(View.VISIBLE);
        }

        //
        playAudio(mGameTapAudio);

        // Undo pause game
        Log.d(TAG, "tapOut un-pause");
        mPauseGame = false;
    }

    // Build stage cards
    public void buildStageCards() {

        //
        int journey_score = 0;

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
            //fadeIn(card);

            //
            ++i;
        }

        //
        i = 0;

        // Set stage hilite color
        for (int hilite : STAGE_HILITE) {

            // back support for getColor
            findViewById(hilite).setBackgroundColor(ContextCompat.getColor(this, (STAGE_COLOR[i])));
            findViewById(hilite).setAlpha(.75f);

            //
            if (i > 0 && !stage_complete[i - 1]) {

                //
                findViewById(hilite).setBackgroundColor(0);
                findViewById(hilite).setAlpha(.75f);
            }

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
            findViewById(card_status).setBackground(versionCheck(R.drawable.stage_select_title_ready_image));

            //
            if (i > 0 && !stage_complete[i - 1]) {

                //
                findViewById(card_status).setBackground(versionCheck(R.drawable.stage_select_title_locked_image));
            }

            //
            if (stage_complete[i]) {

                //
                findViewById(card_status).setBackground(versionCheck(R.drawable.stage_select_title_complete_image));
                ++journey_score;
            }

            //
            ++i;
        }

        //

        mJourneyScoreTextView.setText(Float.toString((int) getPercentage(7, journey_score)));
        mStageSelectContentProgressBar.setProgress((int) getPercentage(7, journey_score));

        //
        i = 0;

        // Set stage icon
        for (int card_icon : STAGE_PROP_CARD_ICONS) {

            //
            findViewById(card_icon).setBackground(versionCheck(R.drawable.stage_select_icon_ready_image));

            //
            if (stage_complete[i]) {

                //
                findViewById(card_icon).setBackground(versionCheck(R.drawable.stage_select_icon_complete_image));

            }

            //
            if (i > 0 && !stage_complete[i - 1]) {

                //
                findViewById(card_icon).setBackground(versionCheck(R.drawable.stage_select_icon_lock_image));
            }

            //
            ++i;
        }
    }

    // Randomly select new background image
    private void switchEnvironment() {

        //
        fadeFlash();

        //
        if (mTapTotal < mStageSceneImages.size()) {

            //
            setStage();

            //
            resetTapper();

            //
            resetBorder();

            //
            resetTunnel();

            // Random selection from array
            //Random r = new Random();

            //
            //mEnvironmentID = mStageSceneImages.get(r.nextInt(mStageSceneImages.size()));
            try {

                //
                mEnvironmentID = mStageSceneImages.get(mTapTotal);
                String mSceneID = mStageSceneNames.get(mStageSceneImages.indexOf(mEnvironmentID));

                //
                Drawable mEnvironmentDrawable;

                //
                mEnvironmentDrawable = versionCheck(mEnvironmentID);
                mGameCreatureLayout.setBackground(mEnvironmentDrawable);
                mGameSceneTextView.setText(mSceneID);
            }
            catch (IndexOutOfBoundsException e) {

                Log.d(TAG, "switchEnvironment: " + e);
            }
            finally {
                // Play bg audio
                playAudio(BG_AUDIO);

            }

        }
    }

    // Remove images and names from arrays
    private void removeBG() {

        //
        //if (!mStageSceneImages.isEmpty()) {

            //
            //int mIndex = mStageSceneImages.indexOf(mEnvironmentID);
            //mStageSceneImages.remove(mIndex);

            //mStageSceneNames.remove(mStageSceneNames.indexOf(mEnvironmentID + 1));
        //}
    }

    // Switch stage cards
    private void switchStageCard(int mode) {

        boolean[] stage_complete = {

                stage_01_complete, stage_02_complete, stage_03_complete, stage_04_complete, stage_05_complete, stage_06_complete, stage_07_complete
        };

        //
        switch (mode) {

            //
            case 0:

                //
                if (mStageIndex != 1) {

                    //
                    --mStageIndex;

                    //
                    mStageApex = false;

                    // Check stage complete
                    if (mStageIndex != 1) {

                        // Initial stage status - locked
                        mStageReady = 1;

                        // Test for ready - *not needed*
                        if (stage_complete[mStageIndex - 2]) {

                            //
                            mStageReady = 2;
                        }
                    } else {

                        //
                        mStageReady = 2;
                    }

                    //
                    mStageComplete = stage_complete[mStageIndex - 1];

                    // Load images, audio, scores
                    preLoadStageProps();

                    // Switch stage card screen
                    switchScreen(R.id.stage_card_screen_main_layout);

                    //
                    playAudio(mGameTapAudio);

                    //
                    postLoadStageProps();
                }

                break;

            //
            case 1:

                //
                if (mStageIndex != 7) {

                    //
                    ++mStageIndex;

                    //
                    mStageApex = false;

                    // Initial stage status - locked
                    mStageReady = 1;

                    // Test for ready
                    if (stage_complete[mStageIndex - 2]) {

                        //
                        mStageReady = 2;
                    }

                    // Check stage complete
                    mStageComplete = stage_complete[mStageIndex - 1];

                    // Load images, audio, scores
                    preLoadStageProps();

                    // Switch stage card screen
                    switchScreen(R.id.stage_card_screen_main_layout);

                    //
                    playAudio(mGameTapAudio);

                    //
                    postLoadStageProps();
                }

                break;
        }
    }

	// Randomly select and position sprites
	private void switchCreature(int creature) {

        // Random selection from array
        Random r = new Random();
        int randomSelection = r.nextInt(32);

        // Array of images
        mCreatureID = CREATURES[randomSelection];
        Drawable mCreatureDrawable;

        // Return drawable
        mCreatureDrawable = versionCheck(mCreatureID);

        // Move creature
        moveCreature(creature, R.id.game_main_pg_creature_canvas_layout);

        // Attach random background
        findViewById(creature).setBackground(mCreatureDrawable);
    }

    //
    private void fadeSplatter(int splatter) {

        //
        View splatterImage = findViewById(splatter);
        Animation splatterAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        splatterAnimation.setFillAfter(true);
        splatterImage.startAnimation(splatterAnimation);

    }

    // Move creature
    private void moveCreature(int creature, int canvas) {

        //
        Random r = new Random();

        //
        int splatter = r.nextInt(4);
        //int splatter = Arrays.asList(CREATURE_BUTTONS).indexOf(creature);
        findViewById(CREATURE_SPLATTERS[splatter]).setVisibility(View.INVISIBLE);

        //
        float splatterX = findViewById(creature).getX();
        float splatterY = findViewById(creature).getY();

        //
        findViewById(CREATURE_SPLATTERS[splatter]).setX(splatterX);
        findViewById(CREATURE_SPLATTERS[splatter]).setY(splatterY);

        //
        findViewById(CREATURE_SPLATTERS[splatter]).setVisibility(View.VISIBLE);
        fadeSplatter(CREATURE_SPLATTERS[splatter]);

        // Hide creature
        findViewById(creature).setVisibility(View.INVISIBLE);

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

    // Reveal creature random
    private void revealCreatureRandom(int random_index) {

        Random r = new Random();
        if (!mCreatureGameOver) {

            //
            if (r.nextInt(10) >= random_index) {
                showCreature(CREATURE_BUTTONS[r.nextInt(5)]);
            }
        }
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
        int[] animateFade = {

                //
                R.anim.creature_jump_01, R.anim.creature_jump_02, R.anim.creature_jump_03,
                R.anim.creature_jump_04, R.anim.creature_jump_05, R.anim.creature_jump_06,
                R.anim.creature_jump_07
        };

        //
        View creatureImage = findViewById(v);
        Animation creatureAnimation = AnimationUtils.loadAnimation(this, animateFade[mStageIndex - 1]);
        creatureAnimation.setFillAfter(true);
        creatureImage.startAnimation(creatureAnimation);
    }

    // Fade creature in
    private void showCreature(int v) {

        //
        View screenImage = findViewById(v);
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.show_creature);
        fadeAnimation.setFillAfter(true);
        screenImage.startAnimation(fadeAnimation);
    }

    // Fade creature out
    private void hideCreature(int v) {

        //
        View screenImage = findViewById(v);
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.hide_creature);
        fadeAnimation.setFillAfter(true);
        screenImage.startAnimation(fadeAnimation);
    }

    // Fade in
    private void fadeIn(int v) {

        //
        View screenImage = findViewById(v);
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeAnimation.setFillAfter(true);
        screenImage.startAnimation(fadeAnimation);
    }

    // Fade titles
    private void fadeTitles(int v) {

        //
        View screenImage = findViewById(v);
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_titles);
        fadeAnimation.setFillAfter(true);
        screenImage.startAnimation(fadeAnimation);
    }

    // Fade titles
    private void fadeControl(int v) {

        //
        View screenImage = findViewById(v);
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_control);
        fadeAnimation.setFillAfter(true);
        screenImage.startAnimation(fadeAnimation);
    }

    // Fade flash
    private void fadeBoss() {

        //
        View screenImage = findViewById(R.id.game_main_boss_image_button);
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.boss_fade_in);
        fadeAnimation.setFillAfter(true);
        screenImage.startAnimation(fadeAnimation);
    }

    // Fade flash
    private void fadeDisaster() {

        //
        View screenImage = findViewById(R.id.game_main_disaster_layout);
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_flash);
        fadeAnimation.setFillAfter(true);
        screenImage.startAnimation(fadeAnimation);
    }

    // Fade flash
    private void fadeBloodsplat() {

        //
        View screenImage = findViewById(R.id.game_main_bloodsplat_layout);
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_flash);
        fadeAnimation.setFillAfter(true);
        screenImage.startAnimation(fadeAnimation);
    }

    // Fade flash
    private void fadeFlash() {

        //
        View screenImage = findViewById(R.id.game_main_flash_layout);
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_flash);
        fadeAnimation.setFillAfter(true);
        screenImage.startAnimation(fadeAnimation);
    }

    // Fade blackout
    private void fadeBlackout() {

        //
        View screenImage = findViewById(R.id.game_main_blackout_layout);
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_flash);
        fadeAnimation.setFillAfter(true);
        screenImage.startAnimation(fadeAnimation);
    }

    // Dialog to reset game
    private void alertNewGame() {

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
            }
        });

        // Display
        restartBuilder.show();

        //
        playAudio(CROW_AUDIO);
    }

    // Dialog to reset game
    private void alertTutorial(String message) {

        // Create dialog
        AlertDialog.Builder restartBuilder = new AlertDialog.Builder(this);

        // Set titles
        restartBuilder.setCancelable(false);
        restartBuilder.setTitle("Tutorial");
        restartBuilder.setMessage(message);

        // Set negative button
        restartBuilder.setNegativeButton("Remind Me Later", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //
                dialogInterface.cancel();

                //
                playAudio(RUN);
            }
        });

        // Set positive button
        restartBuilder.setPositiveButton("I Got It", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //
                dialogInterface.cancel();

                //
                playAudio(CHOMP);
            }
        });

        // Display
        restartBuilder.show();

        //
        playAudio(CROW_AUDIO);
    }

    // Dialog to alert return lose progress
    private void alertReturnLoseProgress() {

        mPauseGame = true;

        AlertDialog.Builder mReturnAlert = new AlertDialog.Builder(this);

        mReturnAlert.setCancelable(false);
        mReturnAlert.setTitle("Return to main");
        mReturnAlert.setMessage("You will lose progress on this stage.");

        mReturnAlert.setNegativeButton("No Way", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                playAudio(MISS);

                mPauseGame = false;

                dialogInterface.cancel();
            }
        });

        mReturnAlert.setPositiveButton("Sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                mStageTime = mStageTimer;

                // Set stageReady
                mStageReady = 2;

                //
                loadStage();

                // Switch to stage select screen
                switchScreen(R.id.stage_card_screen_main_layout);

                // Play audio
                playAudio(RUN);
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
        Log.d(TAG, "exit: pause");
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
                Log.d(TAG, "return: un-pause");
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
	public void playAudio(int sound) {

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
	public void playHaptic() {

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

        //
        int marker_index = 0;

        // Replace image
        for (int marker : LEVEL_MARKERS) {

            //
            findViewById(marker).setBackground(versionCheck(STAGE_SCENES[mStageIndex - 1][marker_index]));
            findViewById(marker).setAlpha(.25f);

            //
            ++marker_index;
        }

        //
        findViewById(R.id.game_main_level_marker_01_image_view).setAlpha(1);
        findViewById(BOSS_IMAGES[mStageIndex - 1]);

        //
        TextView[] stage_areas = {

                mGameMainArea01TextView, mGameMainArea02TextView, mGameMainArea03TextView,
                mGameMainArea04TextView, mGameMainArea05TextView,
        };

        int i = 0;

        //
        for (TextView area : stage_areas) {

            //
            area.setText(mStageSceneNames.get(i));

            i++;
        }

        // Reveal markers and powers
        mGameLevelMarkerLayout.setVisibility(View.VISIBLE);
        mGamePowersLayout.setVisibility(View.VISIBLE);
    }

    // Build game scores - GAME EOBE SCORES
    private void buildGameScores() {

        //
        int game_score = 0;

        //
        mEOBEApexScoreBadgeImageView.setVisibility(View.INVISIBLE); // Destroy every board
        mEOBEPredatorScoreBadgeImageView.setVisibility(View.INVISIBLE); // Roar and survive
        mEOBEAccuracyScoreBadgeImageView.setVisibility(View.INVISIBLE); // 95%-100%
        mEOBETimeBestScoreBadgeImageView.setVisibility(View.INVISIBLE); //
        mEOBECreatureKillsScoreBadgeImageView.setVisibility(View.INVISIBLE);
        mEOBEHighStreakScoreBadgeImageView.setVisibility(View.INVISIBLE);
        mEOBECloseDeathScoreBadgeImageView.setVisibility(View.INVISIBLE);
        mEOBELongFrenzyScoreBadgeImageView.setVisibility(View.INVISIBLE);
        mEOBEMostCalmScoreBadgeImageView.setVisibility(View.INVISIBLE);
        mEOBEMostFranticScoreBadgeImageView.setVisibility(View.INVISIBLE);

        mGameApexLayout.setVisibility(View.GONE);
        mGamePredatorLayout.setVisibility(View.GONE);
        mGameAccuracyLayout.setVisibility(View.GONE);
        mGameTimeLayout.setVisibility(View.GONE);
        mGameEatenLayout.setVisibility(View.GONE);
        mGameStreakLayout.setVisibility(View.GONE);
        mGameDeathLayout.setVisibility(View.GONE);
        mGameFrenzyLayout.setVisibility(View.GONE);
        mGameCalmLayout.setVisibility(View.GONE);
        mGameFranticLayout.setVisibility(View.GONE);

        // Destroy every stage
        if (mGameApex) {

            //
            ++game_score;

            //
            mEOBEApexScoreBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            mEOBEApexScoreBadgeImageView.setVisibility(View.VISIBLE);
            mGameApexLayout.setVisibility(View.VISIBLE);
            mApexRunningTextView.setText(Boolean.toString(mGameApex));

        }

        // Achieve top predator in every stage
        if (mGamePredator > 29) {

            //
            ++game_score;

            //
            mEOBEPredatorScoreBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            mEOBEPredatorScoreBadgeImageView.setVisibility(View.VISIBLE);
            mGamePredatorLayout.setVisibility(View.VISIBLE);
            mPredatorRunningTextView.setText(Integer.toString(mGamePredator));
        }


        // Achieve 100% accuracy in every stage
        if (mGameAccuracy > 99) {

            //
            ++game_score;

            //
            mEOBEAccuracyScoreBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            mEOBEAccuracyScoreBadgeImageView.setVisibility(View.VISIBLE);
            mGameAccuracyLayout.setVisibility(View.VISIBLE);
            mAccuracyRunningTextView.setText(Float.toString(mGameAccuracy));
        }

        // Complete each stage in under 60 seconds
        if (mGameTimeBest) {

            //
            ++game_score;

            //
            mEOBETimeBestScoreBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            mEOBETimeBestScoreBadgeImageView.setVisibility(View.VISIBLE);
            mGameTimeLayout.setVisibility(View.VISIBLE);
            mTimeRunningTextView.setText(Boolean.toString(mGameTimeBest));
        }

        // Kill 1000 creatures
        if (mGameCreatureKills > 999) {

            //
            ++game_score;

            //
            mEOBECreatureKillsScoreBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            mEOBECreatureKillsScoreBadgeImageView.setVisibility(View.VISIBLE);
            mGameEatenLayout.setVisibility(View.VISIBLE);
            mCreatureRunningTextView.setText(Integer.toString(mGameCreatureKills));
        }

        // Achieve a high streak of 50+
        if (mGameHighestStreak > 50) {

            //
            ++game_score;

            //
            mEOBEHighStreakScoreBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            mEOBEHighStreakScoreBadgeImageView.setVisibility(View.VISIBLE);
            mGameStreakLayout.setVisibility(View.VISIBLE);
            mStreakRunningTextView.setText(Integer.toString(mGameHighestStreak));
        }

        // Achieve closest to death of 3 heartbeats
        if (mGameClosestDeath < 4) {

            //
            ++game_score;

            //
            mEOBECloseDeathScoreBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            mEOBECloseDeathScoreBadgeImageView.setVisibility(View.VISIBLE);
            mGameDeathLayout.setVisibility(View.VISIBLE);
            mClosestRunningTextView.setText(Integer.toString(mGameClosestDeath));
        }

        // Achieve longest frenzy of 20+
        if (mGameLongestFrenzy > 19) {

            //
            ++game_score;

            //
            mEOBELongFrenzyScoreBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            mEOBELongFrenzyScoreBadgeImageView.setVisibility(View.VISIBLE);
            mGameFrenzyLayout.setVisibility(View.VISIBLE);
            mFrenzyRunningTextView.setText(Integer.toString(mGameLongestFrenzy));
        }

        // Achieve adrenaline score 2000+
        if (mGameMostCalm > 1999) {

            //
            ++game_score;

            //
            mEOBEMostCalmScoreBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            mEOBEMostCalmScoreBadgeImageView.setVisibility(View.VISIBLE);
            mGameCalmLayout.setVisibility(View.VISIBLE);
            mCalmRunningTextView.setText(Float.toString(mGameMostCalm));
        }

        // Achieve adrenaline score 50-
        if (mGameMostFrantic < 51) {

            //
            ++game_score;

            //
            mEOBEMostFranticScoreBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            mEOBEMostFranticScoreBadgeImageView.setVisibility(View.VISIBLE);
            mGameFranticLayout.setVisibility(View.VISIBLE);
            mFranticRunningTextView.setText(Float.toString(mGameMostFrantic));
        }

        //
        mGameScoreTextView.setText((Float.toString((int) getPercentage(10, game_score))));
        mStageSelectTopScoresProgressBar.setProgress((int) getPercentage(10, game_score));
    }

    // Build game trophy case - GAME EOBE TROPHY
    private void buildGameTrophyCase() {

        //
        int mBossCount = 0;

        //
        mEOBEStage01TrophyImageView.setBackground(versionCheck(R.drawable.game_unknown_creature_image));
        mEOBEStage02TrophyImageView.setBackground(versionCheck(R.drawable.game_unknown_creature_image));
        mEOBEStage03TrophyImageView.setBackground(versionCheck(R.drawable.game_unknown_creature_image));
        mEOBEStage04TrophyImageView.setBackground(versionCheck(R.drawable.game_unknown_creature_image));
        mEOBEStage05TrophyImageView.setBackground(versionCheck(R.drawable.game_unknown_creature_image));
        mEOBEStage06TrophyImageView.setBackground(versionCheck(R.drawable.game_unknown_creature_image));
        mEOBEStage07TrophyImageView.setBackground(versionCheck(R.drawable.game_unknown_creature_image));

        //
        if (stage_01_complete) { mEOBEStage01TrophyImageView.setBackground(versionCheck(R.drawable.stage_01_boss_image)); ++mBossCount; }
        if (stage_02_complete) { mEOBEStage02TrophyImageView.setBackground(versionCheck(R.drawable.stage_02_boss_image)); ++mBossCount; }
        if (stage_03_complete) { mEOBEStage03TrophyImageView.setBackground(versionCheck(R.drawable.stage_03_boss_image)); ++mBossCount; }
        if (stage_04_complete) { mEOBEStage04TrophyImageView.setBackground(versionCheck(R.drawable.stage_04_boss_image)); ++mBossCount; }
        if (stage_05_complete) { mEOBEStage05TrophyImageView.setBackground(versionCheck(R.drawable.stage_05_boss_image)); ++mBossCount; }
        if (stage_06_complete) { mEOBEStage06TrophyImageView.setBackground(versionCheck(R.drawable.stage_06_boss_image)); ++mBossCount; }
        if (stage_07_complete) { mEOBEStage07TrophyImageView.setBackground(versionCheck(R.drawable.stage_07_boss_image)); ++mBossCount; }

        mGameTrophyScoreTextView.setText(Integer.toString(mBossCount));
        mGameTrophyPercentTextView.setText(Float.toString((int) getPercentage(7, mBossCount)));
        mStageSelectTrophycaseProgressBar.setProgress((int) getPercentage(7, mBossCount));
    }

    // Build scorecard - STAGE TOP SCORES
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void buildScorecard() {

        //
        int top_score = 0;

        //
        mStageTopApexBadgeImageView.setVisibility(View.INVISIBLE);
        mStageTopPredatorBadgeImageView.setVisibility(View.INVISIBLE);
        mStageTopAccuracyBadgeImageView.setVisibility(View.INVISIBLE);
        mStageTopBestTimeBadgeImageView.setVisibility(View.INVISIBLE);
        mStageTotalCreatureKillsBadgeImageView.setVisibility(View.INVISIBLE);
        mStageTopHighStreakBadgeImageView.setVisibility(View.INVISIBLE);
        mStageTopCloseDeathBadgeImageView.setVisibility(View.INVISIBLE);
        mStageTopLongFrenzyBadgeImageView.setVisibility(View.INVISIBLE);
        mStageTopMostCalmBadgeImageView.setVisibility(View.INVISIBLE);
        mStageTopMostFranticBadgeImageView.setVisibility(View.INVISIBLE);

        //
        mStageCardTopApexLayout.setVisibility(View.GONE);
        mStageCardTopPredatorLayout.setVisibility(View.GONE);
        mStageCardTopAccuracyLayout.setVisibility(View.GONE);
        mStageCardTopTimeLayout.setVisibility(View.GONE);
        mStageCardTopEatenLayout.setVisibility(View.GONE);
        mStageCardTopStreakLayout.setVisibility(View.GONE);
        mStageCardTopDeathLayout.setVisibility(View.GONE);
        mStageCardTopFrenzyLayout.setVisibility(View.GONE);
        mStageCardTopCalmLayout.setVisibility(View.GONE);
        mStageCardTopFranticLayout.setVisibility(View.GONE);

        //
        switch (mStageIndex) {

            //
            case 1:

                //
                if (stage_01_apex) {

                    //
                    ++top_score;

                    //
                    mStageTopApexBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    mStageTopApexBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopApexLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_01_predator > 2) {

                    //
                    ++top_score;

                    //
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopPredatorBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopPredatorLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_01_predator > 3) { mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_01_predator > 4) { mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_01_accuracy > 84) {

                    //
                    ++top_score;

                    //
                    mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopAccuracyBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopAccuracyLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_01_accuracy > 94) { mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_01_accuracy > 99) { mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_01_best_time < 91) {

                    //
                    ++top_score;

                    //
                    mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopBestTimeBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopTimeLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_01_best_time < 76) { mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_01_best_time < 61) { mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_01_creature_kills > 49) {

                    //
                    ++top_score;

                    //
                    mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTotalCreatureKillsBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopEatenLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_01_creature_kills > 74) { mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_01_creature_kills > 99) { mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_01_highest_streak > 9) {

                    //
                    ++top_score;

                    //
                    mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopHighStreakBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopStreakLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_01_highest_streak > 14) { mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_01_highest_streak > 19) { mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_01_closest_death < 11) {

                    //
                    ++top_score;

                    //
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopCloseDeathBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopDeathLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_01_closest_death < 8) { mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_01_closest_death < 6) { mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_01_longest_frenzy > 2) {

                    //
                    ++top_score;

                    //
                    mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopLongFrenzyBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopFrenzyLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_01_longest_frenzy > 4) { mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_01_longest_frenzy > 9) { mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_01_most_calm > 750) {

                    //
                    ++top_score;

                    //
                    mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopMostCalmBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopCalmLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_01_most_calm > 875) { mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_01_most_calm > 999) { mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_01_most_frantic < 350) {

                    //
                    ++top_score;

                    //
                    mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopMostFranticBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopFranticLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_01_most_frantic < 225) { mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_01_most_frantic < 100) { mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                mTopScoreProgressScoreTextView.setText(Float.toString((int) getPercentage(28, top_score)));
                mStageCardTopScoresProgressbar.setProgress((int) getPercentage(28, top_score));

                break;

            case 2:

                //
                if (stage_02_apex) {

                    //
                    ++top_score;

                    //
                    mStageTopApexBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    mStageTopApexBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopApexLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_02_predator > 2) {

                    //
                    ++top_score;

                    //
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopPredatorBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopPredatorLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_02_predator > 3) { mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_02_predator > 4) { mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_02_accuracy > 84) {

                    //
                    ++top_score;

                    //
                    mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopAccuracyBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopAccuracyLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_02_accuracy > 94) { mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_02_accuracy > 99) { mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_02_best_time < 91) {

                    //
                    ++top_score;

                    //
                    mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopBestTimeBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopTimeLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_02_best_time < 76) { mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_02_best_time < 61) { mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_02_creature_kills > 49) {

                    //
                    ++top_score;

                    //
                    mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTotalCreatureKillsBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopEatenLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_02_creature_kills > 74) { mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_02_creature_kills > 99) { mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_02_highest_streak > 9) {

                    //
                    ++top_score;

                    //
                    mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopHighStreakBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopStreakLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_02_highest_streak > 14) { mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_02_highest_streak > 19) { mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_02_closest_death < 11) {

                    //
                    ++top_score;

                    //
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopCloseDeathBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopDeathLayout.setVisibility(View.VISIBLE);
                }
                if (stage_02_closest_death < 8) { mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_02_closest_death < 6) { mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_02_longest_frenzy > 2) {

                    //
                    ++top_score;

                    //
                    mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopLongFrenzyBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopFrenzyLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_02_longest_frenzy > 4) { mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_02_longest_frenzy > 9) { mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_02_most_calm > 750) {

                    //
                    ++top_score;

                    //
                    mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopMostCalmBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopCalmLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_02_most_calm > 875) { mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_02_most_calm > 999) { mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_02_most_frantic < 350) {

                    //
                    ++top_score;

                    //
                    mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopMostFranticBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopFranticLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_02_most_frantic < 225) { mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_02_most_frantic < 100) { mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                mTopScoreProgressScoreTextView.setText(Float.toString((int) getPercentage(28, top_score)));
                mStageCardTopScoresProgressbar.setProgress((int) getPercentage(28, top_score));

                break;

            case 3:

                //
                if (stage_03_apex) {

                    //
                    ++top_score;

                    //
                    mStageTopApexBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    mStageTopApexBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopApexLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_03_predator > 2) {

                    //
                    ++top_score;

                    //
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopPredatorBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopPredatorLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_03_predator > 3) { mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_03_predator > 4) { mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_03_accuracy > 84) {

                    //
                    ++top_score;

                    //
                    mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopAccuracyBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopAccuracyLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_03_accuracy > 94) { mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_03_accuracy > 99) { mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_03_best_time < 91) {

                    //
                    ++top_score;

                    //
                    mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopBestTimeBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopTimeLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_03_best_time < 76) { mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_03_best_time < 61) { mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_03_creature_kills > 49) {

                    //
                    ++top_score;

                    //
                    mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTotalCreatureKillsBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopEatenLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_03_creature_kills > 74) { mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_03_creature_kills > 99) { mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_03_highest_streak > 9) {

                    //
                    ++top_score;

                    //
                    mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopHighStreakBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopStreakLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_03_highest_streak > 14) { mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_03_highest_streak > 19) { mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_03_closest_death < 11) {

                    //
                    ++top_score;

                    //
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopCloseDeathBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopDeathLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_03_closest_death < 8) { mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_03_closest_death < 6) { mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_03_longest_frenzy > 2) {

                    //
                    ++top_score;

                    //
                    mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopLongFrenzyBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopFrenzyLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_03_longest_frenzy > 4) { mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_03_longest_frenzy > 9) { mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_03_most_calm > 750) {

                    //
                    ++top_score;

                    //
                    mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopMostCalmBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopCalmLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_03_most_calm > 875) { mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_03_most_calm > 999) { mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_03_most_frantic < 350) {

                    //
                    ++top_score;

                    //
                    mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopMostFranticBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopFranticLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_03_most_frantic < 225) { mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_03_most_frantic < 100) { mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                mTopScoreProgressScoreTextView.setText(Float.toString((int) getPercentage(28, top_score)));
                mStageCardTopScoresProgressbar.setProgress((int) getPercentage(28, top_score));

                break;

            case 4:

                //
                if (stage_04_apex) {

                    //
                    ++top_score;

                    //
                    mStageTopApexBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    mStageTopApexBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopApexLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_04_predator > 2) {

                    //
                    ++top_score;

                    //
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopPredatorBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopPredatorLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_04_predator > 3) { mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_04_predator > 4) { mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_04_accuracy > 84) {

                    //
                    ++top_score;

                    //
                    mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopAccuracyBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopAccuracyLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_04_accuracy > 94) { mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_04_accuracy > 99) { mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_04_best_time < 91) {

                    //
                    ++top_score;

                    //
                    mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopBestTimeBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopTimeLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_04_best_time < 76) { mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_04_best_time < 61) { mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_04_creature_kills > 49) {

                    //
                    ++top_score;

                    //
                    mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTotalCreatureKillsBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopEatenLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_04_creature_kills > 74) { mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_04_creature_kills > 99) { mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_04_highest_streak > 9) {

                    //
                    ++top_score;

                    //
                    mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopHighStreakBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopStreakLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_04_highest_streak > 14) { mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_04_highest_streak > 19) { mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_04_closest_death < 11) {

                    //
                    ++top_score;

                    //
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopCloseDeathBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopDeathLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_04_closest_death < 8) { mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_04_closest_death < 6) { mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_04_longest_frenzy > 2) {

                    //
                    ++top_score;

                    //
                    mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopLongFrenzyBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopFrenzyLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_04_longest_frenzy > 4) { mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_04_longest_frenzy > 9) { mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_04_most_calm > 750) {

                    //
                    ++top_score;

                    //
                    mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopMostCalmBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopCalmLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_04_most_calm > 875) { mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_04_most_calm > 999) { mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_04_most_frantic < 350) {

                    //
                    ++top_score;

                    //
                    mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopMostFranticBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopFranticLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_04_most_frantic < 225) { mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_04_most_frantic < 100) { mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                mTopScoreProgressScoreTextView.setText(Float.toString((int) getPercentage(28, top_score)));
                mStageCardTopScoresProgressbar.setProgress((int) getPercentage(28, top_score));

                break;

            case 5:

                //
                if (stage_05_apex) {

                    //
                    ++top_score;

                    //
                    mStageTopApexBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    mStageTopApexBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopApexLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_05_predator > 2) {

                    //
                    ++top_score;

                    //
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopPredatorBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopPredatorLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_05_predator > 3) { mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_05_predator > 4) { mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_05_accuracy > 84) {

                    //
                    ++top_score;

                    //
                    mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopAccuracyBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopAccuracyLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_05_accuracy > 94) { mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_05_accuracy > 99) { mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_05_best_time < 91) {

                    //
                    ++top_score;

                    //
                    mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopBestTimeBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopTimeLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_05_best_time < 76) { mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_05_best_time < 61) { mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_05_creature_kills > 49) {

                    //
                    ++top_score;

                    //
                    mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTotalCreatureKillsBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopEatenLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_05_creature_kills > 74) { mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_05_creature_kills > 99) { mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_05_highest_streak > 9) {

                    //
                    ++top_score;

                    //
                    mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopHighStreakBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopStreakLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_05_highest_streak > 14) { mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_05_highest_streak > 19) { mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_05_closest_death < 11) {

                    //
                    ++top_score;

                    //
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopCloseDeathBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopDeathLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_05_closest_death < 8) { mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_05_closest_death < 6) { mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_05_longest_frenzy > 2) {

                    //
                    ++top_score;

                    //
                    mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopLongFrenzyBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopFrenzyLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_05_longest_frenzy > 4) { mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_05_longest_frenzy > 9) { mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_05_most_calm > 750) {

                    //
                    ++top_score;

                    //
                    mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopMostCalmBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopCalmLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_05_most_calm > 875) { mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_05_most_calm > 999) { mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_05_most_frantic < 350) {

                    //
                    ++top_score;

                    //
                    mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopMostFranticBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopFranticLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_05_most_frantic < 225) { mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_05_most_frantic < 100) { mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                mTopScoreProgressScoreTextView.setText(Float.toString((int) getPercentage(28, top_score)));
                mStageCardTopScoresProgressbar.setProgress((int) getPercentage(28, top_score));

                break;

            case 6:

                //
                if (stage_06_apex) {

                    //
                    ++top_score;

                    //
                    mStageTopApexBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    mStageTopApexBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopApexLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_06_predator > 2) {

                    //
                    ++top_score;

                    //
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopPredatorBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopPredatorLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_06_predator > 3) { mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_06_predator > 4) { mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_06_accuracy > 84) {

                    //
                    ++top_score;

                    //
                    mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopAccuracyBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopAccuracyLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_06_accuracy > 94) { mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_06_accuracy > 99) { mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_06_best_time < 91) {

                    //
                    ++top_score;

                    //
                    mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopBestTimeBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopTimeLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_06_best_time < 76) { mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_06_best_time < 61) { mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_06_creature_kills > 49) {

                    //
                    ++top_score;

                    //
                    mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTotalCreatureKillsBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopEatenLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_06_creature_kills > 74) { mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_06_creature_kills > 99) { mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_06_highest_streak > 9) {

                    //
                    ++top_score;

                    //
                    mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopHighStreakBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopStreakLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_06_highest_streak > 14) { mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_06_highest_streak > 19) { mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_06_closest_death < 11) {

                    //
                    ++top_score;

                    //
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopCloseDeathBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopDeathLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_06_closest_death < 8) { mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_06_closest_death < 6) { mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_06_longest_frenzy > 2) {

                    //
                    ++top_score;

                    //
                    mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopLongFrenzyBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopFrenzyLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_06_longest_frenzy > 4) { mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_06_longest_frenzy > 9) { mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_06_most_calm > 750) {

                    //
                    ++top_score;

                    //
                    mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopMostCalmBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopCalmLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_06_most_calm > 825) { mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_06_most_calm > 999) { mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_06_most_frantic < 350) {

                    //
                    ++top_score;

                    //
                    mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopMostFranticBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopFranticLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_06_most_frantic < 225) { mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_06_most_frantic < 100) { mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                mTopScoreProgressScoreTextView.setText(Float.toString((int) getPercentage(28, top_score)));
                mStageCardTopScoresProgressbar.setProgress((int) getPercentage(28, top_score));

                break;

            case 7:

                //
                if (stage_07_apex) {

                    //
                    ++top_score;

                    //
                    mStageTopApexBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    mStageTopApexBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopApexLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_07_predator > 2) {

                    //
                    ++top_score;

                    //
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopPredatorBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopPredatorLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_07_predator > 3) { mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_07_predator > 4) { mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_07_accuracy > 84) {

                    //
                    ++top_score;

                    //
                    mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopAccuracyBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopAccuracyLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_07_accuracy > 94) { mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_07_accuracy > 99) { mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_07_best_time < 91) {

                    //
                    ++top_score;

                    //
                    mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopBestTimeBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopTimeLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_07_best_time < 76) { mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_07_best_time < 61) { mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_07_creature_kills > 49) {

                    //
                    ++top_score;

                    //
                    mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTotalCreatureKillsBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopEatenLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_07_creature_kills > 74) { mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_07_creature_kills > 99) { mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_07_highest_streak > 9) {

                    //
                    ++top_score;

                    //
                    mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopHighStreakBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopStreakLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_07_highest_streak > 14) { mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_07_highest_streak > 19) { mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_07_closest_death < 11) {

                    //
                    ++top_score;

                    //
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopCloseDeathBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopDeathLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_07_closest_death < 8) { mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_07_closest_death < 6) { mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_07_longest_frenzy > 2) {

                    //
                    ++top_score;

                    //
                    mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopLongFrenzyBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopFrenzyLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_07_longest_frenzy > 4) { mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_07_longest_frenzy > 9) { mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_07_most_calm > 750) {

                    //
                    ++top_score;

                    //
                    mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopMostCalmBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopCalmLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_07_most_calm > 875) { mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_07_most_calm > 999) { mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                if (stage_07_most_frantic < 350) {

                    //
                    ++top_score;

                    //
                    mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopMostFranticBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopFranticLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_07_most_frantic < 225) { mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++top_score; }
                if (stage_07_most_frantic < 100) { mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++top_score; }

                //
                mTopScoreProgressScoreTextView.setText(Float.toString((int) getPercentage(28, top_score)));
                mStageCardTopScoresProgressbar.setProgress((int) getPercentage(28, top_score));

                break;
        }
    }

    // Build stage scores - STAGE COMPLETE
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void buildStageScores() {

        //
        int final_score = 0;

        //
        mStageApexBadgeImageView.setVisibility(View.INVISIBLE);
        mStagePredatorBadgeImageView.setVisibility(View.INVISIBLE);
        mStageAccuracyBadgeImageView.setVisibility(View.INVISIBLE);
        mStageTimeBadgeImageView.setVisibility(View.INVISIBLE);
        mStageCreatureKillsBadgeImageView.setVisibility(View.INVISIBLE);
        mStageHighStreakBadgeImageView.setVisibility(View.INVISIBLE);
        mStageCloseDeathBadgeImageView.setVisibility(View.INVISIBLE);
        mStageLongFrenzyBadgeImageView.setVisibility(View.INVISIBLE);
        mStageMostCalmBadgeImageView.setVisibility(View.INVISIBLE);
        mStageMostFranticBadgeImageView.setVisibility(View.INVISIBLE);

        mStageCardApexLayout.setVisibility(View.GONE);
        mStageCardPredatorLayout.setVisibility(View.GONE);
        mStageCardAccuracyLayout.setVisibility(View.GONE);
        mStageCardTimeLayout.setVisibility(View.GONE);
        mStageCardCreaturesLayout.setVisibility(View.GONE);
        mStageCardStreakLayout.setVisibility(View.GONE);
        mStageCardDeathLayout.setVisibility(View.GONE);
        mStageCardFrenzyLayout.setVisibility(View.GONE);
        mStageCardCalmLayout.setVisibility(View.GONE);
        mStageCardFranticLayout.setVisibility(View.GONE);

        // Primary scores
        if (mStageApex) {

            //
            ++final_score;

            //
            mStageApexBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            mStageApexBadgeImageView.setVisibility(View.VISIBLE);
            mStageCardApexLayout.setVisibility(View.VISIBLE);
        }

        //
        if (mStagePredator > 2) {

            //
            ++final_score;

            //
            mStagePredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
            mStagePredatorBadgeImageView.setVisibility(View.VISIBLE);
            mStageCardPredatorLayout.setVisibility(View.VISIBLE);
        }

        //
        if (mStagePredator > 3) { mStagePredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++final_score; }
        if (mStagePredator > 4) { mStagePredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++final_score; }

        //
        if (mStageAccuracy > 84) {

            //
            ++final_score;

            //
            mStageAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
            mStageAccuracyBadgeImageView.setVisibility(View.VISIBLE);
            mStageCardAccuracyLayout.setVisibility(View.VISIBLE);
        }

        //
        if (mStageAccuracy > 94) { mStageAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++final_score; }
        if (mStageAccuracy > 99) { mStageAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++final_score; }

        // Secondary scores
        if (mStageTime < 91) {

            //
            ++final_score;

            //
            mStageTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
            mStageTimeBadgeImageView.setVisibility(View.VISIBLE);
            mStageCardTimeLayout.setVisibility(View.VISIBLE);
        }

        //
        if (mStageTime < 76) { mStageTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++final_score; }
        if (mStageTime < 61) { mStageTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++final_score; }

        //
        if (mStageCreatureKills > 49) {

            //
            ++final_score;

            //
            mStageCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
            mStageCreatureKillsBadgeImageView.setVisibility(View.VISIBLE);
            mStageCardCreaturesLayout.setVisibility(View.VISIBLE);
        }

        //
        if (mStageCreatureKills > 74) { mStageCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++final_score; }
        if (mStageCreatureKills > 99) { mStageCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++final_score; }

        // Tertiary scores
        if (mStageHighestStreak > 9) {

            //
            ++final_score;

            //
            mStageHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
            mStageHighStreakBadgeImageView.setVisibility(View.VISIBLE);
            mStageCardStreakLayout.setVisibility(View.VISIBLE);
        }

        //
        if (mStageHighestStreak > 14) { mStageHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++final_score; }
        if (mStageHighestStreak > 19) { mStageHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++final_score; }

        //
        if (mStageClosestDeath < 11) {

            //
            ++final_score;

            //
            mStageCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
            mStageCloseDeathBadgeImageView.setVisibility(View.VISIBLE);
            mStageCardDeathLayout.setVisibility(View.VISIBLE);
        }

        //
        if (mStageClosestDeath < 8) { mStageCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++final_score; }
        if (mStageClosestDeath < 6) { mStageCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++final_score; }

        //
        if (mStageLongestFrenzy > 2) {

            //
            ++final_score;

            //
            mStageLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
            mStageLongFrenzyBadgeImageView.setVisibility(View.VISIBLE);
            mStageCardFrenzyLayout.setVisibility(View.VISIBLE);
        }

        //
        if (mStageLongestFrenzy > 4) { mStageLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++final_score; }
        if (mStageLongestFrenzy > 9) { mStageLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++final_score; }

        //
        if (mStageMostCalm > 750) {

            //
            ++final_score;

            //
            mStageMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
            mStageMostCalmBadgeImageView.setVisibility(View.VISIBLE);
            mStageCardCalmLayout.setVisibility(View.VISIBLE);
        }

        //
        if (mStageMostCalm > 875) { mStageMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++final_score; }
        if (mStageMostCalm > 999) { mStageMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++final_score; }

        //
        if (mStageMostFrantic < 350) {

            //
            ++final_score;

            //
            mStageMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
            mStageMostFranticBadgeImageView.setVisibility(View.VISIBLE);
            mStageCardFranticLayout.setVisibility(View.VISIBLE);
        }

        //
        if (mStageMostFrantic < 225) { mStageMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver)); ++final_score; }
        if (mStageMostFrantic < 100) { mStageMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold)); ++final_score; }

        //
        mStageCardStageScoresProgressBar.setProgress((int) getPercentage(28, final_score));
        mStageCardStageScoreTextView.setText(Integer.toString(final_score));
    }

    // Construct views for creature collection
    private void buildCreatureCollection(int creature, int trophy_case) {

        //
        if (trophy_case < 0) { trophy_case = 0; }

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
        trophy_cases[trophy_case].setAlpha(1);
    }

    // Construct creature collection
    private void buildTrophycase() {

        //
        ArrayList[] stage_creatures_previous = {

                //
                stage_01_top_creatures_previous, stage_02_top_creatures_previous, stage_03_top_creatures_previous,
                stage_04_top_creatures_previous, stage_05_top_creatures_previous, stage_06_top_creatures_previous,
                stage_07_top_creatures_previous
        };

        //
        int[] stage_collections = {

                //
                stage_01_collection, stage_02_collection, stage_03_collection,
                stage_04_collection, stage_05_collection, stage_06_collection,
                stage_07_collection
        };

        // Collect creatures
        int i = 0;

        //
        for (Object creature_caught : stage_creatures_previous[mStageIndex - 1]) {

            //
            if ((Boolean) creature_caught) {

                //
                buildCreatureCollection(CREATURES[i], i);
            }

            //
            i++;
        }

        //
        //
        mStageCardTotalCollectionTextView.setText(Integer.toString(stage_collections[mStageIndex - 1]));
        //mStageTotalCollectionPercentTextView.setText(Float.toString((int) getPercentage(32, stage_collections[mStageIndex - 1])));
        mStageCardTrophycaseProgressBar.setProgress((int) getPercentage(32, stage_collections[mStageIndex - 1]));
    }

    // mStageIndex [1-7]
    private void buildStageCollection(int trophy_shelf) {

        //
        ArrayList[] stage_creatures_previous = {

                //
                stage_01_top_creatures_previous, stage_02_top_creatures_previous, stage_03_top_creatures_previous,
                stage_04_top_creatures_previous, stage_05_top_creatures_previous, stage_06_top_creatures_previous,
                stage_07_top_creatures_previous
        };

        //
        int i = 0;

        //
        for (Object creature_collected : stage_creatures_previous[trophy_shelf - 1]) {

            //
            if ((boolean) creature_collected) {

                //
                mStageCreatureBox.add(CREATURES[i]);
            }

            //
            ++i;
        }
    }

    // Reset views for creature collection
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
        for (View trophy_case : trophy_cases) {

            //
            trophy_case.setBackground(versionCheck(R.drawable.game_unknown_creature_image));
            trophy_case.setAlpha(.5f);
        }
    }

    // Player eaten
    @SuppressLint("SetTextI18n")
    private void playerEaten() {

        // Stop timer
        Log.d(TAG, "playerEaten: pause");
        mPauseGame = true;

        // Record time
        mStageTime = mStageTimer;

        //
        mEatenStageTimeTextView.setText(Integer.toString(mStageTime));

        // Set stageReady
        mStageReady = 4;

        //
        mHandlerFlag = true;

        //
        //fadeTitles(R.id.game_main_flash_layout);

        // Switch to SCREEN(EATEN)
        switchScreen(R.id.stage_card_screen_main_layout);

        // Play outro audio(s)
        playAudio(HIT);
        playAudio(DARK_OUTRO);
    }

    //
    private int addScore(int[] mScoreArray) {

        //
        int scoreValue = 0;

        //
        for (int score : mScoreArray) {

            //
            scoreValue = scoreValue + score;
        }

        return scoreValue;
    }

//-- ARRAY RESOURCES -->

    // RESOURCE : INTEGER - Array list of items that need event handlers
    final private static int[] CLICKABLES = {

            // Credits
            R.id.credits_screen_main_layout, // Skip intro

            // Entry
            R.id.entry_main_continue_image_button, R.id.entry_main_new_image_button, R.id.entry_main_credits_image_button, // Main menu options

            // Stage select
            R.id.stage_select_return_image_button, // Exit to main
            R.id.stage_select_trophycase_image_button, R.id.stage_select_scorecard_image_button, R.id.stage_select_content_title_image_button, // Switch scorecards
            R.id.stage_stage_select_01_hilite_layout, R.id.stage_stage_select_02_hilite_layout, R.id.stage_stage_select_03_hilite_layout,
            R.id.stage_stage_select_04_hilite_layout, R.id.stage_stage_select_05_hilite_layout, R.id.stage_stage_select_06_hilite_layout,
            R.id.stage_stage_select_07_hilite_layout, // Select stage

            //R.id.stage_select_trophy_01_image_view, R.id.stage_select_trophy_02_image_view, R.id.stage_select_trophy_03_image_view,
            //R.id.stage_select_trophy_04_image_view, R.id.stage_select_trophy_05_image_view, R.id.stage_select_trophy_06_image_view,
            //R.id.stage_select_trophy_07_image_view, // Boss cry

            // Stage card
            R.id.stage_card_header_return_image_button, R.id.stage_card_locked_image_button, // Exit to stage select
            R.id.stage_card_trophy_image_button, R.id.stage_card_hiscore_image_button, R.id.stage_card_stagescore_image_button,
            R.id.stage_card_eaten_image_button, R.id.stage_card_content_image_button, // Switch scorecards
            R.id.stage_card_control_prev_image_button, R.id.stage_card_ready_play_here_image_button, R.id.stage_card_control_next_image_button, // Switch stagecards
            //R.id.stage_card_screen_body_layout, // Touch to main

            // Game
            R.id.game_main_return_image_button, R.id.game_main_exit_image_button, // Exit to stagecard

            //
            //R.id.game_scene_prev_image_button, R.id.game_scene_next_image_button,

            //
            R.id.game_main_power_01_image_view, R.id.game_main_power_02_image_view, R.id.game_main_power_03_image_view,
            R.id.game_main_power_04_image_view, R.id.game_main_power_05_image_view, R.id.game_main_power_06_image_view, // Use power

            //
            R.id.game_main_pg_creature_canvas_layout, // Miss creature

            //
            R.id.game_main_creature_01_image_button, R.id.game_main_creature_02_image_button, R.id.game_main_creature_03_image_button,
            R.id.game_main_creature_04_image_button, R.id.game_main_creature_05_image_button, R.id.game_main_boss_image_button, // Hit creature
    };

    // RESOURCE : INTEGER - Array list of screen layouts
    final private static int[] SCREENS = {

            //
            R.id.credits_screen_main_layout, R.id.entry_screen_main_layout, R.id.stage_select_screen_main_layout,
            R.id.stage_card_screen_main_layout, R.id.game_screen_main_layout
    };

	// RESOURCE : DRAWABLE - Array list of intro view layouts
    final private static int[] INTRO = {

            //
            R.drawable.credits_logo_01_image, R.drawable.credits_logo_02_image, R.drawable.credits_logo_03_image
    };

    // RESOURCE : DRAWABLE - Array list of intro screen layouts
    final private static int[] OUTRO = {

            //
            R.drawable.credits_logo_01_image, R.drawable.credits_logo_02_image, R.drawable.credits_logo_03_image
    };

    // RESOURCE : INTEGER - Array list of level marker views
    final private static int[] LEVEL_MARKERS = {

            //
            R.id.game_main_level_marker_01_image_view, R.id.game_main_level_marker_02_image_view, R.id.game_main_level_marker_03_image_view,
            R.id.game_main_level_marker_04_image_view, R.id.game_main_level_marker_05_image_view
    };

    // RESOURCE : INTEGER - Array list of creature button views [1-5]
    final private static int[] CREATURE_BUTTONS = {

            //
            R.id.game_main_creature_01_image_button, R.id.game_main_creature_02_image_button, R.id.game_main_creature_03_image_button,
            R.id.game_main_creature_04_image_button, R.id.game_main_creature_05_image_button
    };

    //
    final private static int[] CREATURE_SPLATTERS = {

            //
            R.id.game_main_creature_01_splatter_image_view, R.id.game_main_creature_02_splatter_image_view, R.id.game_main_creature_03_splatter_image_view,
            R.id.game_main_creature_04_splatter_image_view, R.id.game_main_creature_05_splatter_image_view
    };

     // RESOURCE : DRAWABLE - Array list of stage names
    final private static int[] STAGE_NAMES = {

            //
            R.drawable.stage_select_title_01_image, R.drawable.stage_select_title_02_image, R.drawable.stage_select_title_03_image,
            R.drawable.stage_select_title_04_image, R.drawable.stage_select_title_05_image, R.drawable.stage_select_title_06_image,
            R.drawable.stage_select_title_07_image
    };

//-----\/
    // RESOURCE : DRAWABLE - Array list of background images [forest]
    final private static int[] FOREST_SCENES = {

            //
            R.drawable.stage_01_bg_01_image, R.drawable.stage_01_bg_02_image, R.drawable.stage_01_bg_03_image,
            R.drawable.stage_01_bg_04_image, R.drawable.stage_01_bg_05_image
    };

    // RESOURCE : STRING - Array list of background names [forest]
    final private static String[] FOREST_SCENE_NAMES = {

            //
            "GLADE", "CLEARING", "MEADOW", "FIELD", "GRASSLAND"
    };

    // RESOURCE : DRAWABLE - Array list of background images [ocean]
    final private static int[] OCEAN_SCENES = {

            //
            R.drawable.stage_02_bg_01_image, R.drawable.stage_02_bg_02_image, R.drawable.stage_02_bg_03_image,
            R.drawable.stage_02_bg_04_image, R.drawable.stage_02_bg_05_image
    };

    // RESOURCE : STRING - Array list of background names [ocean]
    final private static String[] OCEAN_SCENE_NAMES = {

            //
            "DELTA", "SHOAL", "SPRING", "BANKS", "DEEP"
    };

    // RESOURCE : DRAWABLE - Array list of background images [mountain]
    final private static int[] MOUNTAIN_SCENES = {

            //
            R.drawable.stage_03_bg_01_image, R.drawable.stage_03_bg_02_image, R.drawable.stage_03_bg_03_image,
            R.drawable.stage_03_bg_04_image, R.drawable.stage_03_bg_05_image
    };

    // RESOURCE : STRING - Array list of background names [mountain]
    final private static String[] MOUNTAIN_SCENE_NAMES = {

            //
            "VALLEY", "CLIFF", "OVERHANG", "CAVE", "PEAK"
    };

    // RESOURCE : DRAWABLE - Array list of background images [desert]
    final private static int[] DESERT_SCENES = {

            //
            R.drawable.stage_04_bg_01_image, R.drawable.stage_04_bg_02_image, R.drawable.stage_04_bg_03_image,
            R.drawable.stage_04_bg_04_image, R.drawable.stage_04_bg_05_image
    };

    // RESOURCE : STRING - Array list of background names [desert]
    final private static String[] DESERT_SCENE_NAMES = {

            //
            "DUNES", "BARRENS", "BADLANDS", "MIRAGE", "PIT"
    };

    // RESOURCE : DRAWABLE - Array list of background images [jungle]
    final private static int[] JUNGLE_SCENES = {

            //
            R.drawable.stage_05_bg_01_image, R.drawable.stage_05_bg_02_image, R.drawable.stage_05_bg_03_image,
            R.drawable.stage_05_bg_04_image, R.drawable.stage_05_bg_05_image
    };

    // RESOURCE : STRING - Array list of background names [jungle]
    final private static String[] JUNGLE_SCENE_NAMES = {

            //
            "TREETOPS", "CAVERNS", "VOLCANO", "UNDERBRUSH", "CANOPY"
    };

    // RESOURCE : DRAWABLE - Array list of background images [tundra]
    final private static int[] TUNDRA_SCENES = {

            //
            R.drawable.stage_06_bg_01_image, R.drawable.stage_06_bg_02_image, R.drawable.stage_06_bg_03_image,
            R.drawable.stage_06_bg_04_image, R.drawable.stage_06_bg_05_image
    };

    // RESOURCE : STRING - Array list of background names [tundra]
    final private static String[] TUNDRA_SCENE_NAMES = {

            //
            "STRAIGHTS", "KILLS", "CREVAS", "DRIFTS", "POLE"
    };

    // RESOURCE : DRAWABLE - Array list of background images [final]
    final private static int[] FINAL_SCENES = {

            //
            R.drawable.stage_07_bg_01_image, R.drawable.stage_07_bg_02_image, R.drawable.stage_07_bg_03_image,
            R.drawable.stage_07_bg_04_image, R.drawable.stage_07_bg_05_image,
    };

    // RESOURCE : STRING - Array list of background names [final]
    final private static String[] FINAL_SCENE_NAMES = {

            //
            "Planetary Gulf", "Stellar Field", "Galactic Space", "Universal Center", "Multiverse Foyer"
    };

    // RESOURCE : ARRAY - Array list of stage background image views [2D]
    final private static int[][] STAGE_SCENES = {

            //
            FOREST_SCENES, OCEAN_SCENES, MOUNTAIN_SCENES,
            DESERT_SCENES, JUNGLE_SCENES, TUNDRA_SCENES,
            FINAL_SCENES
    };

    // RESOURCE : ARRAY - Array list of stage background names [2D]
    final private static String[][] STAGE_SCENE_NAMES = {

            //
            FOREST_SCENE_NAMES, OCEAN_SCENE_NAMES, MOUNTAIN_SCENE_NAMES,
            DESERT_SCENE_NAMES, JUNGLE_SCENE_NAMES, TUNDRA_SCENE_NAMES,
            FINAL_SCENE_NAMES
    };
//-----/\

    // RESOURCE : DRAWABLE - Array list of stage border image views
    final private static int[] STAGE_BORDERS = {

            //
            R.drawable.stage_01_border_image, R.drawable.stage_02_border_image, R.drawable.stage_03_border_image,
            R.drawable.stage_04_border_image, R.drawable.stage_05_border_image, R.drawable.stage_06_border_image,
            R.drawable.stage_07_border_image,
    };

    // RESOURCE : DRAWABLE - Array list of stage disaster image views
    final private static int[] STAGE_DISASTERS = {

            //
            R.drawable.stage_01_disaster_image, R.drawable.stage_02_disaster_image, R.drawable.stage_03_disaster_image,
            R.drawable.stage_04_disaster_image, R.drawable.stage_05_disaster_image, R.drawable.stage_06_disaster_image,
            R.drawable.stage_07_disaster_image,
    };

    // RESOURCE : AUDIO - Array list of stage disaster audios
    final private static int[] STAGE_DISASTER_AUDIO = {

            //
            THUNDER_AUDIO, SPLASH_AUDIO, EARTHQUAKE_AUDIO,
            TORNADO_AUDIO, VOLCANO_AUDIO, AVALANCHE_AUDIO,
            REVERSE_PING
    };

    // RESOURCE : COLOR - Array list of stage colors
    final private static int[] STAGE_COLOR = {

            //
            R.color.style_color_palette_stage_01_main, R.color.style_color_palette_stage_02_main, R.color.style_color_palette_stage_03_main,
            R.color.style_color_palette_stage_04_main, R.color.style_color_palette_stage_05_main, R.color.style_color_palette_stage_06_main,
            R.color.style_color_palette_stage_07_main,
    };

    // RESOURCE : LAYOUT - Array list of stage select hilite layouts
    final private static int[] STAGE_HILITE = {

            //
            R.id.stage_stage_select_01_hilite_layout, R.id.stage_stage_select_02_hilite_layout, R.id.stage_stage_select_03_hilite_layout,
            R.id.stage_stage_select_04_hilite_layout, R.id.stage_stage_select_05_hilite_layout, R.id.stage_stage_select_06_hilite_layout,
            R.id.stage_stage_select_07_hilite_layout,
    };

    // RESOURCE : STRING - Array list of boss names
    final private static String[] BOSS_NAME = {

            //
            "WOLF", "SHARK", "HAWK",
            "SCORPION", "ANACONDA", "YETI",
            "DRAGON"
    };

    // RESOURCE : STRING - Array list of stage disasters
    final private static String[] DISASTER_NAME = {

            //
            "LIGHTNING", "WHIRLPOOL", "EARTHQUAKE",
            "DUST STORM", "VOLCANO", "AVALANCHE",
            "BLACK HOLE"
    };

    // RESOURCE : DRAWABLE - Array list of stage boss image views
    final private static int[] BOSS_IMAGES = {

            //
            R.drawable.stage_01_boss_image, R.drawable.stage_02_boss_image, R.drawable.stage_03_boss_image,
            R.drawable.stage_04_boss_image, R.drawable.stage_05_boss_image, R.drawable.stage_06_boss_image,
            R.drawable.stage_07_boss_image,
    };

    // RESOURCE : AUDIO - Array list of stage boss audios
    final private static int[] BOSS_CRY_AUDIO = {

            //
            WOLF_CRY, SHARK_CRY, HAWK_CRY,
            SCORPION_CRY, SNAKE_CRY, YETI_CRY,
            GROWL_ALERT
    };

    // RESOURCE : DRAWABLE - Array list of stage boss bg image views
    final private static int[] BOSS_SCENE_IMAGES = {

            //
            R.drawable.stage_01_boss_bg_image, R.drawable.stage_02_boss_bg_image, R.drawable.stage_03_boss_bg_image,
            R.drawable.stage_04_boss_bg_image, R.drawable.stage_05_boss_bg_image, R.drawable.stage_06_boss_bg_image,
            R.drawable.stage_07_boss_bg_image,
    };

    // RESOURCE : DRAWABLE - Array list of stage card bg image views
    final private static int[] STAGE_CARD_BG = {

            //
            R.drawable.stage_select_01_bg_image, R.drawable.stage_select_02_bg_image, R.drawable.stage_select_03_bg_image,
            R.drawable.stage_select_04_bg_image, R.drawable.stage_select_05_bg_image, R.drawable.stage_select_06_bg_image,
            R.drawable.stage_select_07_bg_image
    };

    // RESOURCE : DRAWABLE - Array list of creature image views
    final private static int[] CREATURES = {

            //
            R.drawable.game_black_creature_01_image, R.drawable.game_white_creature_01_image,
            R.drawable.game_black_creature_02_image, R.drawable.game_white_creature_02_image,
            R.drawable.game_black_creature_03_image, R.drawable.game_white_creature_03_image,
            R.drawable.game_black_creature_04_image, R.drawable.game_white_creature_04_image,
            R.drawable.game_black_creature_05_image, R.drawable.game_white_creature_05_image,
            R.drawable.game_black_creature_06_image, R.drawable.game_white_creature_06_image,
            R.drawable.game_black_creature_07_image, R.drawable.game_white_creature_07_image,
            R.drawable.game_black_creature_08_image, R.drawable.game_white_creature_08_image,
            R.drawable.game_black_creature_09_image, R.drawable.game_white_creature_09_image,
            R.drawable.game_black_creature_10_image, R.drawable.game_white_creature_10_image,
            R.drawable.game_black_creature_11_image, R.drawable.game_white_creature_11_image,
            R.drawable.game_black_creature_12_image, R.drawable.game_white_creature_12_image,
            R.drawable.game_black_creature_13_image, R.drawable.game_white_creature_13_image,
            R.drawable.game_black_creature_14_image, R.drawable.game_white_creature_14_image,
            R.drawable.game_black_creature_15_image, R.drawable.game_white_creature_15_image,
            R.drawable.game_black_creature_16_image, R.drawable.game_white_creature_16_image
    };

    // RESOURCE : DOUBLE - Array list of alphas - index.length = 20
    final private static double[] ALPHA_INDEX = {

            //
            1, .99, .98, .97, .96, .95, .93, .91, .89, .85, .8, .75, .7, .6, .5, .25, .1, .01, .001, 0
    };

    // RESOURCE : DOUBLE - Array list of alphas - index.length = 20
    final private static double[] ALPHA_INDEX_INVERSE = {

            //
            0, .001, .01, .1, .25, .5, .6, .7, .75, .8, .85, .89, .91, .93, .95, .96, .97, .98, .99, 1
    };

    // RESOURCE : INTEGER - Array list of pings
    final private static int[] PINGS = {

            //
            R.raw.ping_01_audio, R.raw.ping_02_audio, R.raw.ping_03_audio, R.raw.ping_04_audio, R.raw.ping_05_audio,
            R.raw.ping_06_audio, R.raw.ping_07_audio, R.raw.ping_08_audio, R.raw.ping_09_audio, R.raw.ping_10_audio
    };

//-- STAGE PROPS ARRAY -->
    // RESOURCE : INTEGER - Array list of stage cards - stage card layout views
    final private static int[] STAGE_PROP_CARDS = {

            //
            R.id.stage_stage_select_01_hilite_layout, R.id.stage_stage_select_02_hilite_layout, R.id.stage_stage_select_03_hilite_layout,
            R.id.stage_stage_select_04_hilite_layout, R.id.stage_stage_select_05_hilite_layout, R.id.stage_stage_select_06_hilite_layout,
            R.id.stage_stage_select_07_hilite_layout
    };

    // RESOURCE : INTEGER - Array list of stage props - stage card title image views
    final private static int[] STAGE_PROP_CARD_TITLES = {

            //
            R.id.stage_select_title_01_image_view, R.id.stage_select_title_02_image_view, R.id.stage_select_title_03_image_view,
            R.id.stage_select_title_04_image_view, R.id.stage_select_title_05_image_view, R.id.stage_select_title_06_image_view,
            R.id.stage_select_title_07_image_view
    };

    // RESOURCE : INTEGER - Array list of stage props - stage card status image views
    final private static int[] STAGE_PROP_CARD_STATUS = {

            //
            R.id.stage_select_status_01_image_view, R.id.stage_select_status_02_image_view, R.id.stage_select_status_03_image_view,
            R.id.stage_select_status_04_image_view, R.id.stage_select_status_05_image_view, R.id.stage_select_status_06_image_view,
            R.id.stage_select_status_07_image_view
    };

    // RESOURCE : INTEGER - Array list of stage props - stage card icon image views
    final private static int[] STAGE_PROP_CARD_ICONS = {

            //
            R.id.stage_select_status_01_icon_image_button, R.id.stage_select_status_02_icon_image_button, R.id.stage_select_status_03_icon_image_button,
            R.id.stage_select_status_04_icon_image_button, R.id.stage_select_status_05_icon_image_button, R.id.stage_select_status_06_icon_image_button,
            R.id.stage_select_status_07_icon_image_button
    };

    // RESOURCE : DRAWABLE - Array list of stage props - stage card bg images
    final private static int[] STAGE_PROP_CARD_BG = {

            //
            R.drawable.stage_select_01_bg_image, R.drawable.stage_select_02_bg_image, R.drawable.stage_select_03_bg_image,
            R.drawable.stage_select_04_bg_image, R.drawable.stage_select_05_bg_image, R.drawable.stage_select_06_bg_image,
            R.drawable.stage_select_07_bg_image
    };

    // RESOURCE : DRAWABLE - Array list of stage props - stage card title images
    final private static int[] STAGE_PROP_TITLE_IMAGES = {

            //
            R.drawable.stage_select_title_01_image, R.drawable.stage_select_title_02_image, R.drawable.stage_select_title_03_image,
            R.drawable.stage_select_title_04_image, R.drawable.stage_select_title_05_image, R.drawable.stage_select_title_06_image,
            R.drawable.stage_select_title_07_image
    };

// RESOURCES for setGameData()

    // RESOURCE : STRING - Array list of top scores constants
    String[] top_creature_previous_string_01 = {

            //
            STAGE_01_CREATURE_01, STAGE_01_CREATURE_02, STAGE_01_CREATURE_03, STAGE_01_CREATURE_04,
            STAGE_01_CREATURE_05, STAGE_01_CREATURE_06, STAGE_01_CREATURE_07, STAGE_01_CREATURE_08,
            STAGE_01_CREATURE_09, STAGE_01_CREATURE_10, STAGE_01_CREATURE_11, STAGE_01_CREATURE_12,
            STAGE_01_CREATURE_13, STAGE_01_CREATURE_14, STAGE_01_CREATURE_15, STAGE_01_CREATURE_16,
            STAGE_01_CREATURE_17, STAGE_01_CREATURE_18, STAGE_01_CREATURE_19, STAGE_01_CREATURE_20,
            STAGE_01_CREATURE_21, STAGE_01_CREATURE_22, STAGE_01_CREATURE_23, STAGE_01_CREATURE_24,
            STAGE_01_CREATURE_25, STAGE_01_CREATURE_26, STAGE_01_CREATURE_27, STAGE_01_CREATURE_28,
            STAGE_01_CREATURE_29, STAGE_01_CREATURE_30, STAGE_01_CREATURE_31, STAGE_01_CREATURE_32
    };

    // RESOURCE : STRING - Array list of top scores constants
    String[] top_creature_previous_string_02 = {

            //
            STAGE_02_CREATURE_01, STAGE_02_CREATURE_02, STAGE_02_CREATURE_03, STAGE_02_CREATURE_04,
            STAGE_02_CREATURE_05, STAGE_02_CREATURE_06, STAGE_02_CREATURE_07, STAGE_02_CREATURE_08,
            STAGE_02_CREATURE_09, STAGE_02_CREATURE_10, STAGE_02_CREATURE_11, STAGE_02_CREATURE_12,
            STAGE_02_CREATURE_13, STAGE_02_CREATURE_14, STAGE_02_CREATURE_15, STAGE_02_CREATURE_16,
            STAGE_02_CREATURE_17, STAGE_02_CREATURE_18, STAGE_02_CREATURE_19, STAGE_02_CREATURE_20,
            STAGE_02_CREATURE_21, STAGE_02_CREATURE_22, STAGE_02_CREATURE_23, STAGE_02_CREATURE_24,
            STAGE_02_CREATURE_25, STAGE_02_CREATURE_26, STAGE_02_CREATURE_27, STAGE_02_CREATURE_28,
            STAGE_02_CREATURE_29, STAGE_02_CREATURE_30, STAGE_02_CREATURE_31, STAGE_02_CREATURE_32
    };

    // RESOURCE : STRING - Array list of top scores constants
    String[] top_creature_previous_string_03 = {

            //
            STAGE_03_CREATURE_01, STAGE_03_CREATURE_02, STAGE_03_CREATURE_03, STAGE_03_CREATURE_04,
            STAGE_03_CREATURE_05, STAGE_03_CREATURE_06, STAGE_03_CREATURE_07, STAGE_03_CREATURE_08,
            STAGE_03_CREATURE_09, STAGE_03_CREATURE_10, STAGE_03_CREATURE_11, STAGE_03_CREATURE_12,
            STAGE_03_CREATURE_13, STAGE_03_CREATURE_14, STAGE_03_CREATURE_15, STAGE_03_CREATURE_16,
            STAGE_03_CREATURE_17, STAGE_03_CREATURE_18, STAGE_03_CREATURE_19, STAGE_03_CREATURE_20,
            STAGE_03_CREATURE_21, STAGE_03_CREATURE_22, STAGE_03_CREATURE_23, STAGE_03_CREATURE_24,
            STAGE_03_CREATURE_25, STAGE_03_CREATURE_26, STAGE_03_CREATURE_27, STAGE_03_CREATURE_28,
            STAGE_03_CREATURE_29, STAGE_03_CREATURE_30, STAGE_03_CREATURE_31, STAGE_03_CREATURE_32
    };

    // RESOURCE : STRING - Array list of top scores constants
    String[] top_creature_previous_string_04 = {

            //
            STAGE_04_CREATURE_01, STAGE_04_CREATURE_02, STAGE_04_CREATURE_03, STAGE_04_CREATURE_04,
            STAGE_04_CREATURE_05, STAGE_04_CREATURE_06, STAGE_04_CREATURE_07, STAGE_04_CREATURE_08,
            STAGE_04_CREATURE_09, STAGE_04_CREATURE_10, STAGE_04_CREATURE_11, STAGE_04_CREATURE_12,
            STAGE_04_CREATURE_13, STAGE_04_CREATURE_14, STAGE_04_CREATURE_15, STAGE_04_CREATURE_16,
            STAGE_04_CREATURE_17, STAGE_04_CREATURE_18, STAGE_04_CREATURE_19, STAGE_04_CREATURE_20,
            STAGE_04_CREATURE_21, STAGE_04_CREATURE_22, STAGE_04_CREATURE_23, STAGE_04_CREATURE_24,
            STAGE_04_CREATURE_25, STAGE_04_CREATURE_26, STAGE_04_CREATURE_27, STAGE_04_CREATURE_28,
            STAGE_04_CREATURE_29, STAGE_04_CREATURE_30, STAGE_04_CREATURE_31, STAGE_04_CREATURE_32
    };

    // RESOURCE : STRING - Array list of top scores constants
    String[] top_creature_previous_string_05 = {

            //
            STAGE_05_CREATURE_01, STAGE_05_CREATURE_02, STAGE_05_CREATURE_03, STAGE_05_CREATURE_04,
            STAGE_05_CREATURE_05, STAGE_05_CREATURE_06, STAGE_05_CREATURE_07, STAGE_05_CREATURE_08,
            STAGE_05_CREATURE_09, STAGE_05_CREATURE_10, STAGE_05_CREATURE_11, STAGE_05_CREATURE_12,
            STAGE_05_CREATURE_13, STAGE_05_CREATURE_14, STAGE_05_CREATURE_15, STAGE_05_CREATURE_16,
            STAGE_05_CREATURE_17, STAGE_05_CREATURE_18, STAGE_05_CREATURE_19, STAGE_05_CREATURE_20,
            STAGE_05_CREATURE_21, STAGE_05_CREATURE_22, STAGE_05_CREATURE_23, STAGE_05_CREATURE_24,
            STAGE_05_CREATURE_25, STAGE_05_CREATURE_26, STAGE_05_CREATURE_27, STAGE_05_CREATURE_28,
            STAGE_05_CREATURE_29, STAGE_05_CREATURE_30, STAGE_05_CREATURE_31, STAGE_05_CREATURE_32
    };

    // RESOURCE : STRING - Array list of top scores constants
    String[] top_creature_previous_string_06 = {

            //
            STAGE_06_CREATURE_01, STAGE_06_CREATURE_02, STAGE_06_CREATURE_03, STAGE_06_CREATURE_04,
            STAGE_06_CREATURE_05, STAGE_06_CREATURE_06, STAGE_06_CREATURE_07, STAGE_06_CREATURE_08,
            STAGE_06_CREATURE_09, STAGE_06_CREATURE_10, STAGE_06_CREATURE_11, STAGE_06_CREATURE_12,
            STAGE_06_CREATURE_13, STAGE_06_CREATURE_14, STAGE_06_CREATURE_15, STAGE_06_CREATURE_16,
            STAGE_06_CREATURE_17, STAGE_06_CREATURE_18, STAGE_06_CREATURE_19, STAGE_06_CREATURE_20,
            STAGE_06_CREATURE_21, STAGE_06_CREATURE_22, STAGE_06_CREATURE_23, STAGE_06_CREATURE_24,
            STAGE_06_CREATURE_25, STAGE_06_CREATURE_26, STAGE_06_CREATURE_27, STAGE_06_CREATURE_28,
            STAGE_06_CREATURE_29, STAGE_06_CREATURE_30, STAGE_06_CREATURE_31, STAGE_06_CREATURE_32
    };

    // RESOURCE : STRING - Array list of top scores constants
    String[] top_creature_previous_string_07 = {

            //
            STAGE_07_CREATURE_01, STAGE_07_CREATURE_02, STAGE_07_CREATURE_03, STAGE_07_CREATURE_04,
            STAGE_07_CREATURE_05, STAGE_07_CREATURE_06, STAGE_07_CREATURE_07, STAGE_07_CREATURE_08,
            STAGE_07_CREATURE_09, STAGE_07_CREATURE_10, STAGE_07_CREATURE_11, STAGE_07_CREATURE_12,
            STAGE_07_CREATURE_13, STAGE_07_CREATURE_14, STAGE_07_CREATURE_15, STAGE_07_CREATURE_16,
            STAGE_07_CREATURE_17, STAGE_07_CREATURE_18, STAGE_07_CREATURE_19, STAGE_07_CREATURE_20,
            STAGE_07_CREATURE_21, STAGE_07_CREATURE_22, STAGE_07_CREATURE_23, STAGE_07_CREATURE_24,
            STAGE_07_CREATURE_25, STAGE_07_CREATURE_26, STAGE_07_CREATURE_27, STAGE_07_CREATURE_28,
            STAGE_07_CREATURE_29, STAGE_07_CREATURE_30, STAGE_07_CREATURE_31, STAGE_07_CREATURE_32
    };

    // RESOURCE : IMAGE - Array list of bite mark images
    final private static int[] BITTEN_IMAGES = {

            //
            R.drawable.game_bitten_01_image, R.drawable.game_bitten_02_image,
            R.drawable.game_bitten_03_image, R.drawable.game_bitten_04_image
    };
}