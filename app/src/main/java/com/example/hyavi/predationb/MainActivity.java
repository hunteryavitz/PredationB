package com.example.hyavi.predationb;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
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
import java.util.List;
import java.util.Random;

/*
    PREDATION BETA - EAT OR BE EATEN
*/

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

    // Stage progress / scores
    private static final String STAGE_01_COMPLETE = "stage_01_complete";
    private static final String STAGE_01_PREDATOR = "stage_01_predator";
    private static final String STAGE_01_ACCURACY = "stage_01_accuracy";
    private static final String STAGE_01_APEX = "stage_01_apex";

    // Stage 2
    private static final String STAGE_02_COMPLETE = "stage_02_complete";
    private static final String STAGE_02_PREDATOR = "stage_02_predator";
    private static final String STAGE_02_ACCURACY = "stage_02_accuracy";
    private static final String STAGE_02_APEX = "stage_02_apex";

    // Stage 3
    private static final String STAGE_03_COMPLETE = "stage_03_complete";
    private static final String STAGE_03_PREDATOR = "stage_03_predator";
    private static final String STAGE_03_ACCURACY = "stage_03_accuracy";
    private static final String STAGE_03_APEX = "stage_03_apex";

    // Stage 4
    private static final String STAGE_04_COMPLETE = "stage_04_complete";
    private static final String STAGE_04_PREDATOR = "stage_04_predator";
    private static final String STAGE_04_ACCURACY = "stage_04_accuracy";
    private static final String STAGE_04_APEX = "stage_04_apex";

    // Stage 5
    private static final String STAGE_05_COMPLETE = "stage_05_complete";
    private static final String STAGE_05_PREDATOR = "stage_05_predator";
    private static final String STAGE_05_ACCURACY = "stage_05_accuracy";
    private static final String STAGE_05_APEX = "stage_05_apex";

    // Stage 6
    private static final String STAGE_06_COMPLETE = "stage_06_complete";
    private static final String STAGE_06_PREDATOR = "stage_06_predator";
    private static final String STAGE_06_ACCURACY = "stage_06_accuracy";
    private static final String STAGE_06_APEX = "stage_06_apex";

    // Final stage
    private static final String STAGE_FINAL_BOSS_COMPLETE = "stage_final_boss_complete";
    private static final String STAGE_FINAL_BOSS_APEX = "stage_final_boss_complete";

    // Game complete
    private static final String GAME_COMPLETE = "game_complete";

//-- DECLARE GLOBAL DYNAMIC VIEWS -->

    // Intro views
    private ImageView mIntroImageView;

    // Entry views
    private ImageButton mEntryContinueImageButton;
    private ImageButton mEntryTutorialImageButton;

    // Stage views
    private TextView mStage01PredatorTextView;
    private TextView mStage01AccuracyTextView;
    private ImageView mStage01ApexImageView;

    // Stage 2
    private ImageButton mStage02LockedImageButton;
    private TextView mStage02PredatorTextView;
    private TextView mStage02AccuracyTextView;
    private ImageView mStage02ApexImageView;

    // Stage 3
    private ImageButton mStage03LockedImageButton;
    private TextView mStage03PredatorTextView;
    private TextView mStage03AccuracyTextView;
    private ImageView mStage03ApexImageView;

    // Stage 4
    private ImageButton mStage04LockedImageButton;
    private TextView mStage04PredatorTextView;
    private TextView mStage04AccuracyTextView;
    private ImageView mStage04ApexImageView;

    // Stage 5
    private ImageButton mStage05LockedImageButton;
    private TextView mStage05PredatorTextView;
    private TextView mStage05AccuracyTextView;
    private ImageView mStage05ApexImageView;

    // Stage 6
    private ImageButton mStage06LockedImageButton;
    private TextView mStage06PredatorTextView;
    private TextView mStage06AccuracyTextView;
    private ImageView mStage06ApexImageView;

    // Final stage
    private ImageButton mStageFinalBossLockedImageButton;
    private ImageView mStageFinalBossApexImageView;

    // Game views
    private ImageView mGameMainStageImageView;

    // Stage advance
    private ImageView mGameAdvanceImageView;

    // Progress marker
    private ImageView mGameLevelMarkerImageView;

    // Power icons
    private ImageView mGamePower01ImageView;
    private ImageView mGamePower02ImageView;
    private ImageView mGamePower03ImageView;
    private ImageView mGamePower04ImageView;
    private ImageView mGamePower05ImageView;
    private ImageView mGamePower06ImageView;

    // Creatures
    private ImageButton mGameCreature01ImageButton;
    private ImageButton mGameCreature02ImageButton;
    private ImageButton mGameCreature03ImageButton;
    private ImageButton mGameCreature04ImageButton;
    private ImageButton mGameCreature05ImageButton;

    // Boss
    private ImageButton mGameBossImageButton;

    // Final boss sprite
    private ImageView mFinalBossImageView;

    // Creature playground
    private FrameLayout mGameCreatureLayout;

    // Boss playground
    private FrameLayout mGameBossLayout;

    // Stage border
    private RelativeLayout mGameBorderLayout;

    // Stage tunnel vision
    private RelativeLayout mGameTunnelVisionLayout;

    // Results views
    private LinearLayout mResultsMainBGImageView;

    // Stage title
    private ImageView mResultsSubStageImageView;

    // Stage image
    private ImageView mResultsStageCardImageView;

    // Stage scores
    private TextView mResultsAccuracyTextView;
    private TextView mResultsPredatorTextView;

    // Apex score
    private ImageView mResultsApexImageView;

    // Eaten views
    private ImageView mEatenStageImageView;

    // Credits
    private ImageView mOutroImageView;

//-- INITIAL DATA STORE - NEW GAME -->

    // Variables to store saved game data
    private static boolean continue_game;

    // Settings toggle for audio and haptic feedback
    private static boolean play_audio;
    private static boolean play_haptic;

//-- SUPPLEMENTARY DATA STORE - KILL BOSS -->

    // Variables to save / restore gamestate
    private static boolean stage_01_complete; // -> if (stage_01_complete) {boolean stage_02_unlocked = true;}
    private static String stage_01_predator;
    private static String stage_01_accuracy;
    private static boolean stage_01_apex;

    // Stage 2
    private static boolean stage_02_unlocked; // -> see above
    private static boolean stage_02_complete; // -> if (stage_02_complete) {boolean stage_03_unlocked = true;}
    private static String stage_02_predator;
    private static String stage_02_accuracy;
    private static boolean stage_02_apex;

    // Stage 3
    private static boolean stage_03_unlocked; // -> see above
    private static boolean stage_03_complete; // -> if (stage_03_complete) {boolean stage_04_unlocked = true;}
    private static String stage_03_predator;
    private static String stage_03_accuracy;
    private static boolean stage_03_apex;

    // Stage 4
    private static boolean stage_04_unlocked; // -> see above
    private static boolean stage_04_complete; // -> if (stage_04_complete) {boolean stage_05_unlocked = true;}
    private static String stage_04_predator;
    private static String stage_04_accuracy;
    private static boolean stage_04_apex;

    // Stage 5
    private static boolean stage_05_unlocked; // -> see above
    private static boolean stage_05_complete; // -> if (stage_05_complete) {boolean stage_06_unlocked = true;}
    private static String stage_05_predator;
    private static String stage_05_accuracy;
    private static boolean stage_05_apex;

    // Stage 6
    private static boolean stage_06_unlocked; // -> see above
    private static boolean stage_06_complete; // -> if (stage_06_complete) {boolean stage_final_boss_unlocked = true;}
    private static String stage_06_predator;
    private static String stage_06_accuracy;
    private static boolean stage_06_apex;

    // Final stage
    private static boolean stage_final_boss_unlocked; // -> see above
    private static boolean stage_final_boss_complete; // -> if (stage_final_boss_complete) {boolean game_complete = true;}
    private static boolean stage_final_boss_apex;

    // Game complete
    private static boolean game_complete; // -> see above

// GAME VARIABLES

    // Variable to stop timers
    private static boolean mPauseGame;

    // Null screen state
    private static int mCurScreen = -1;
    private static int mCurEnvironment = -1;

    // Variables for tap meter
    private static int mTapBarrel;
    private static int mTapCount;
    private static int mTapTotal;

    // Border barrel
    private static int mBorderBarrel;

    // Pause timer
    private static int mPauseTimer;

    // Universal variables
    private static long mSpeedIndex;
    private static int mHungerMeter = 0;
    private static int mStageAdvanceMeter;
    private static int mStageAdvanceTarget;

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

    //
    private static int mAggressionScore;
    private static int mSpeciesScore;
    private static int mTotalEatScore;

    //
    private static int mGameTotalHit;
    private static int mGameTotalMiss;
    private static double mGameTotalAverage;

    //
    private static int mGameTotalAttempts;
    private static int mGameTotalTime;

    //
    private static int mEOBETotalAttempts;
    private static int mEOBETotalTime;

    //
    private static int mGameStreakRecord;
    private static int mEOBEStreakRecord;

    //
    private static int mGameTotalBlackoutTime;
    private static int mGameBlackoutRecoveryRecord;

    //
    private static int mEOBETotalBlackoutTime;
    private static int mEOBEBlackoutRecoveryRecord;

    //
    private static int mGameAdrenalineRecord;
    private static int mEOBEAdrenalineRecord;

    //
    private static int mGameTapTotal;
    private static int mEOBETapTotal;

    //
    private static int mGameFastestTap;
    private static int mEOBEFastestTap;

    //
    private static int mEOBETotalHit;
    private static int mEOBETotalMiss;
    private static int mEOBETotalAverage;

    //
    private static int mTurn;
    private static int mTotalTurn;
    private static int mEOBETotalTurn;

    //
    private static int mBossHealth;
    private static boolean mKillBoss;

    //
    private static int mStageIndex;
    private static String mStageAccuracy;
    private static String mStagePredator;
    private static boolean mStageApex;

    //
    private static List<Integer> mStageBGImages = new ArrayList<>();
    private static int mEnvironmentID;

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
    private static final int ERROR_DRONE = R.raw.error_drone;
    private static final int BAMBOO_CLICK = R.raw.bamboo_click_audio;
    private static final int FLUTE_TRILL_LONG = R.raw.flute_trill_long_audio;
    private static final int FLUTE_TRILL_SHORT = R.raw.pan_flute_short_audio;
    private static final int GROWL_ALERT = R.raw.game_main_growl_alert_audio;

    // Run timer through executable task
    final Handler h = new Handler();

//-- ONCREATE METHOD -->

    // OnCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate views
        assignViews();

        // Set click listeners
        setClickables();

        // Pull saved data
        getGameData();

        // Enter game
        playIntroCredits();
    }

    // Assign dynamic views
    public void assignViews() {

        // Intro views
        mIntroImageView = findViewById(R.id.intro_main_logo_image_view);

        // Entry views
        mEntryContinueImageButton = findViewById(R.id.entry_main_continue_image_button);
        mEntryTutorialImageButton = findViewById(R.id.entry_main_tutorial_image_button);

        // Stage views

        // 1
        mStage01PredatorTextView = findViewById(R.id.select_stage_01_predator_text_view);
        mStage01AccuracyTextView = findViewById(R.id.select_stage_01_accuracy_text_view);
        mStage01ApexImageView = findViewById(R.id.select_stage_01_apex_image_view);

        // 2
        mStage02LockedImageButton = findViewById(R.id.stage_select_card_02_image_button);
        mStage02PredatorTextView = findViewById(R.id.select_stage_02_predator_text_view);
        mStage02AccuracyTextView = findViewById(R.id.select_stage_02_accuracy_text_view);
        mStage02ApexImageView = findViewById(R.id.select_stage_02_apex_image_view);

        // 3
        mStage03LockedImageButton = findViewById(R.id.stage_select_card_03_image_button);
        mStage03PredatorTextView = findViewById(R.id.select_stage_03_predator_text_view);
        mStage03AccuracyTextView = findViewById(R.id.select_stage_03_accuracy_text_view);
        mStage03ApexImageView = findViewById(R.id.select_stage_03_apex_image_view);

        // 4
        mStage04LockedImageButton = findViewById(R.id.stage_select_card_04_image_button);
        mStage04PredatorTextView = findViewById(R.id.select_stage_04_predator_text_view);
        mStage04AccuracyTextView = findViewById(R.id.select_stage_04_accuracy_text_view);
        mStage04ApexImageView = findViewById(R.id.select_stage_04_apex_image_view);

        // 5
        mStage05LockedImageButton = findViewById(R.id.stage_select_card_05_image_button);
        mStage05PredatorTextView = findViewById(R.id.select_stage_05_predator_text_view);
        mStage05AccuracyTextView = findViewById(R.id.select_stage_05_accuracy_text_view);
        mStage05ApexImageView = findViewById(R.id.select_stage_05_apex_image_view);

        // 6
        mStage06LockedImageButton = findViewById(R.id.stage_select_card_06_image_button);
        mStage06PredatorTextView = findViewById(R.id.select_stage_06_predator_text_view);
        mStage06AccuracyTextView = findViewById(R.id.select_stage_06_accuracy_text_view);
        mStage06ApexImageView = findViewById(R.id.select_stage_06_apex_image_view);

        // Final
        mStageFinalBossApexImageView = findViewById(R.id.select_stage_final_boss_apex_image_view);

        //
        mFinalBossImageView = findViewById(R.id.game_main_boss_image_button);

        // Game views
        // Stage label
        mGameMainStageImageView = findViewById(R.id.game_main_stage_image_view);

        //
        mGameAdvanceImageView = findViewById(R.id.game_main_stage_advance_image_view);

        // Progress marker
        mGameLevelMarkerImageView = findViewById(R.id.game_main_level_marker_image_view);

        // Power icons
        mGamePower01ImageView = findViewById(R.id.game_main_power_01_image_view);
        mGamePower02ImageView = findViewById(R.id.game_main_power_02_image_view);
        mGamePower03ImageView = findViewById(R.id.game_main_power_03_image_view);
        mGamePower04ImageView = findViewById(R.id.game_main_power_04_image_view);
        mGamePower05ImageView = findViewById(R.id.game_main_power_05_image_view);
        mGamePower06ImageView = findViewById(R.id.game_main_power_06_image_view);

        // Creatures
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

        // Results views
        //
        mResultsMainBGImageView = findViewById(R.id.results_screen_main_layout);

        //
        mResultsSubStageImageView = findViewById(R.id.results_sub_stage_image_view);

        //
        mResultsStageCardImageView = findViewById(R.id.results_main_stage_card_image_view);

        //
        mResultsAccuracyTextView = findViewById(R.id.results_main_score_accuracy_title_text_view);
        mResultsPredatorTextView = findViewById(R.id.results_sub_score_predator_title_text_view);

        //
        mResultsApexImageView = findViewById(R.id.results_sub_apex_score_image_view);

        // Eaten views
        mEatenStageImageView = findViewById(R.id.eaten_sub_stage_image_view);

        //
        mOutroImageView = findViewById(R.id.outro_main_logo_image_view);
    }

    // Save game state data
    public void setGameData() {

        //
        SharedPreferences mUserPrefSet = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditorSet = mUserPrefSet.edit();

        //
        mEditorSet.putBoolean(CONTINUE_SAVED_STATE, continue_game);
        mEditorSet.putBoolean(GAME_COMPLETE, game_complete);

        //
        mEditorSet.putBoolean(AUDIO_SAVED_STATE, play_audio);
        mEditorSet.putBoolean(HAPTIC_SAVED_STATE, play_haptic);

        //
        mEditorSet.putBoolean(STAGE_01_COMPLETE, stage_01_complete);
        mEditorSet.putString(STAGE_01_PREDATOR, stage_01_predator);
        mEditorSet.putString(STAGE_01_ACCURACY, stage_01_accuracy);
        mEditorSet.putBoolean(STAGE_01_APEX, stage_01_apex);

        //
        mEditorSet.putBoolean(STAGE_02_COMPLETE, stage_02_complete);
        mEditorSet.putString(STAGE_02_PREDATOR, stage_02_predator);
        mEditorSet.putString(STAGE_02_ACCURACY, stage_02_accuracy);
        mEditorSet.putBoolean(STAGE_02_APEX, stage_02_apex);

        //
        mEditorSet.putBoolean(STAGE_03_COMPLETE, stage_03_complete);
        mEditorSet.putString(STAGE_03_PREDATOR, stage_03_predator);
        mEditorSet.putString(STAGE_03_ACCURACY, stage_03_accuracy);
        mEditorSet.putBoolean(STAGE_03_APEX, stage_03_apex);

        //
        mEditorSet.putBoolean(STAGE_04_COMPLETE, stage_04_complete);
        mEditorSet.putString(STAGE_04_PREDATOR, stage_04_predator);
        mEditorSet.putString(STAGE_04_ACCURACY, stage_04_accuracy);
        mEditorSet.putBoolean(STAGE_04_APEX, stage_04_apex);

        //
        mEditorSet.putBoolean(STAGE_05_COMPLETE, stage_05_complete);
        mEditorSet.putString(STAGE_05_PREDATOR, stage_05_predator);
        mEditorSet.putString(STAGE_05_ACCURACY, stage_05_accuracy);
        mEditorSet.putBoolean(STAGE_05_APEX, stage_05_apex);

        //
        mEditorSet.putBoolean(STAGE_06_COMPLETE, stage_06_complete);
        mEditorSet.putString(STAGE_06_PREDATOR, stage_06_predator);
        mEditorSet.putString(STAGE_06_ACCURACY, stage_06_accuracy);
        mEditorSet.putBoolean(STAGE_06_APEX, stage_06_apex);

        //
        mEditorSet.putBoolean(STAGE_FINAL_BOSS_COMPLETE, stage_final_boss_complete);
        mEditorSet.putBoolean(STAGE_FINAL_BOSS_APEX, stage_final_boss_apex);

        //
        mEditorSet.apply();
    }

    // Load game state data
    public void getGameData() {

        // Instantiate variables
        SharedPreferences mUserPrefGet = getPreferences(Context.MODE_PRIVATE);

        //
        continue_game = mUserPrefGet.getBoolean(CONTINUE_SAVED_STATE, false);

        //
        play_audio = mUserPrefGet.getBoolean(AUDIO_SAVED_STATE, true);
        play_haptic = mUserPrefGet.getBoolean(HAPTIC_SAVED_STATE, true);

        //
        stage_01_complete = mUserPrefGet.getBoolean(STAGE_01_COMPLETE, false);
        stage_01_predator = mUserPrefGet.getString(STAGE_01_PREDATOR, null);
        stage_01_accuracy = mUserPrefGet.getString(STAGE_01_ACCURACY, null);
        stage_01_apex = mUserPrefGet.getBoolean(STAGE_01_APEX, false);

        //
        stage_02_unlocked = stage_01_complete;

        //
        stage_02_complete = mUserPrefGet.getBoolean(STAGE_02_COMPLETE, false);
        stage_02_predator = mUserPrefGet.getString(STAGE_02_PREDATOR, null);
        stage_02_accuracy = mUserPrefGet.getString(STAGE_02_ACCURACY, null);
        stage_02_apex = mUserPrefGet.getBoolean(STAGE_02_APEX, false);

        //
        stage_03_unlocked = stage_02_complete;

        //
        stage_03_complete = mUserPrefGet.getBoolean(STAGE_03_COMPLETE, false);
        stage_03_predator = mUserPrefGet.getString(STAGE_03_PREDATOR, null);
        stage_03_accuracy = mUserPrefGet.getString(STAGE_03_ACCURACY, null);
        stage_03_apex = mUserPrefGet.getBoolean(STAGE_03_APEX, false);

        //
        stage_04_unlocked = stage_03_complete;

        //
        stage_04_complete = mUserPrefGet.getBoolean(STAGE_04_COMPLETE, false);
        stage_04_predator = mUserPrefGet.getString(STAGE_04_PREDATOR, null);
        stage_04_accuracy = mUserPrefGet.getString(STAGE_04_ACCURACY, null);
        stage_04_apex = mUserPrefGet.getBoolean(STAGE_04_APEX, false);

        //
        stage_05_unlocked = stage_04_complete;

        //
        stage_05_complete = mUserPrefGet.getBoolean(STAGE_05_COMPLETE, false);
        stage_05_predator = mUserPrefGet.getString(STAGE_05_PREDATOR, null);
        stage_05_accuracy = mUserPrefGet.getString(STAGE_05_ACCURACY, null);
        stage_05_apex = mUserPrefGet.getBoolean(STAGE_05_APEX, false);

        //
        stage_06_unlocked = stage_05_complete;

        //
        stage_06_complete = mUserPrefGet.getBoolean(STAGE_06_COMPLETE, false);
        stage_06_predator = mUserPrefGet.getString(STAGE_06_PREDATOR, null);
        stage_06_accuracy = mUserPrefGet.getString(STAGE_06_ACCURACY, null);
        stage_06_apex = mUserPrefGet.getBoolean(STAGE_06_APEX, false);

        //
        stage_final_boss_complete = mUserPrefGet.getBoolean(STAGE_FINAL_BOSS_COMPLETE, false);
        stage_final_boss_apex = mUserPrefGet.getBoolean(STAGE_FINAL_BOSS_APEX, false);

        //
        game_complete = stage_final_boss_complete;
    }

    // Set click listeners
    public void setClickables() {

        // Set click listener for each item in CLICKABLES array
        for (int id : CLICKABLES) { findViewById(id).setOnClickListener(this); }
    }

    // Play intro credits
    public void playIntroCredits() {

        // Switch to intro screen
        switchScreen(R.id.intro_screen_main_layout);

        // Run timer through executable task - background activities
        final Handler h = new Handler();

        h.postDelayed(new Runnable() {

            // Incremental - 2 images, intro[].length
            int i = 0;

            // Run task
            @Override
            public void run() {

                //
                Log.d(TAG, "run: fade in>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                fadeOut(mIntroImageView.getId());

                playAudio(INTRO_01);
                // Check incremental - 2 intro slides
                if (i < INTRO.length) {

                    //
                    Log.d(TAG, "run: <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<fade out");
                    fadeIn(mIntroImageView.getId());

                    // Increment intro images
                    mIntroImageView.setBackground(versionCheck(INTRO[i]));

                    // Increment timer
                    h.postDelayed(this, 5000);
                    i++;

                    // Entry
                } else {

                    //


                    // Switch the entry
                    switchScreen(R.id.entry_screen_main_layout);

                    // Play audio
                    playAudio(DARK_INTRO);
                }
            }
        }, 1000);
    }

    // Play outro credits
    public void playOutroCredits() {

        // Switch to intro screen
        switchScreen(R.id.outro_screen_main_layout);
        findViewById(R.id.outro_screen_main_layout).setVisibility(View.VISIBLE);

        // Run timer through executable task - background activities
        final Handler h = new Handler();
        h.postDelayed(new Runnable() {

            // Incremental - 2 images, intro[].length
            int i = 0;

            // Run task
            @Override
            public void run() {

                playAudio(INTRO_01);

                // Check incremental - 2 intro slides
                if (i < OUTRO.length) {

                    // Increment intro images
                    mOutroImageView.setBackground(versionCheck(OUTRO[i]));

                    // Increment timer
                    h.postDelayed(this, 5000);
                    i++;

                    // Entry
                } else {

                    // Switch the entry
                    switchScreen(R.id.entry_screen_main_layout);

                    // Play audio
                    playAudio(DARK_INTRO);
                }
            }
        }, 1000);
    }

    // Click events
    public void onClick(View v) {

        // Get view clicked
        switch (v.getId()) {

//--ENTRY-->

            // Entry - Continue Button Event
            case R.id.entry_main_continue_image_button:
                Log.d(TAG, "onClick: entry screen - continue button");

                // Switch to stage select screen
                if (continue_game) {

                    //
                    switchScreen(R.id.stage_select_screen_main_layout);
                }

                break;

            // Entry - New Button Event
            case R.id.entry_main_new_image_button:
                Log.d(TAG, "onClick: entry screen - new game button");

                // Check previous data
                if (continue_game) {

                    // Dialog to confirm new game
                    alertNewGame();

                } else {

                    // Switch to stage select screen
                    switchScreen(R.id.stage_select_screen_main_layout);
                }

                break;

            // Entry - Settings Button Event
            case R.id.entry_main_settings_image_button:
                Log.d(TAG, "onClick: entry screen - settings button");

                // Dialog to edit settings
                alertEditSettings();

                break;

            // Entry - Tutorial Button Event
            case R.id.entry_main_tutorial_image_button:
                Log.d(TAG, "onClick: entry screen - tutorial button");

                // Switch to help screen
                switchScreen(R.id.help_screen_main_layout);

                //
                playAudio(RUN);

                break;

//--HELP-->

            // Help - Return Button Event
            case R.id.help_main_return_image_button:
                Log.d(TAG, "onClick: help screen - return button");

                // Switch to entry screen
                switchScreen(R.id.entry_screen_main_layout);

                //
                playAudio(MISS);

                break;

            // Help - Exit Button Event
            case R.id.help_main_exit_image_button:
                Log.d(TAG, "onClick: help screen - exit button");

                //
                playAudio(RUN);

                // Exit game
                finish();

                break;

            // Help - Tutorial Button Event
            case R.id.help_main_tutorial_image_button:
                Log.d(TAG, "onClick: help screen - tour button");

                // Start tutorial
                playAudio(THUNDER_AUDIO);

                break;

//--STAGE SELECT-->

            // Stage select - Return event
            case R.id.stage_select_return_image_button:
                Log.d(TAG, "onClick: stage select - return");

                // Switch to entry screen
                switchScreen(R.id.entry_screen_main_layout);

                //
                playAudio(MISS);

                break;

            // Select stage - Exit event
            case R.id.select_stage_exit_image_button:

                //
                playAudio(RUN);

                // End
                this.finish();

                break;

            // Stage select event
            case R.id.stage_select_card_01_image_layout:
                Log.d(TAG, "onClick: stage select - stage 1");

                // Start game - forest [startStage(forest)]
                //startGame(1);

                // Modify - Switch to results

                //
                playAudio(CHOMP);

                // Load images, audio, etc.
                loadStageProps(1);

                //
                postResults(mStageAccuracy, mStagePredator, mStageApex);

                break;

            //
            case R.id.stage_select_card_02_image_layout:
                Log.d(TAG, "onClick: stage select - stage 2");

                // Start game - ocean [startStage(ocean)]
                if (stage_02_unlocked) {

                    //
                    //startGame(2);

                    //
                    playAudio(CHOMP);

                    // Load images, audio, etc.
                    loadStageProps(2);

                    //
                    postResults(mStageAccuracy, mStagePredator, mStageApex);
                }

                break;

            //
            case R.id.stage_select_card_03_image_layout:
                Log.d(TAG, "onClick: stage select - stage 3");

                // Start game - mountain [startStage(mountain)]
                if (stage_03_unlocked) {

                    //
                    //startGame(3);

                    //
                    playAudio(CHOMP);

                    // Load images, audio, etc.
                    loadStageProps(3);

                    //
                    postResults(mStageAccuracy, mStagePredator, mStageApex);
                }

                break;

            //
            case R.id.stage_select_card_04_image_layout:
                Log.d(TAG, "onClick: stage select - stage 4");

                // Start game - desert [startStage(desert)]
                if (stage_04_unlocked) {

                    //
                    //startGame(4);

                    //
                    playAudio(CHOMP);

                    // Load images, audio, etc.
                    loadStageProps(4);

                    //
                    postResults(mStageAccuracy, mStagePredator, mStageApex);
                }

                break;

            //
            case R.id.stage_select_card_05_image_layout:
                Log.d(TAG, "onClick: stage select - stage 5");

                //
                if (stage_05_unlocked) {

                    //
                    //startGame(5);

                    //
                    playAudio(CHOMP);

                    // Load images, audio, etc.
                    loadStageProps(5);

                    //
                    postResults(mStageAccuracy, mStagePredator, mStageApex);
                }

                break;

            //
            case R.id.stage_select_card_06_image_layout:
                Log.d(TAG, "onClick: stage select - stage 6");

                // Start game - tundra [ startStage(tundra)]
                if (stage_06_unlocked) {

                    //
                    //startGame(6);

                    //
                    playAudio(CHOMP);

                    // Load images, audio, etc.
                    loadStageProps(6);

                    //
                    postResults(mStageAccuracy, mStagePredator, mStageApex);
                }

                break;

            case R.id.stage_select_card_final_boss_image_layout:
                Log.d(TAG, "onClick: stage select - final boss");

                // Stage game - final boss [ stageBoss(final_boss)]
                if (stage_06_complete) {

                    //
                    startBoss();
                }

                break;

//--GAME-->

            // Game - Return Event
            case R.id.game_main_return_image_button:
                Log.d(TAG, "onClick: game - return button");

                // Dialog to confirm lose progress
                alertReturnLoseProgress();

                break;

            // Game - Exit Event
            case R.id.game_main_exit_image_button:
                Log.d(TAG, "onClick: game - exit button");

                //
                alertExitLoseProgress();

                break;

            //
            case R.id.stage_advance_image:
                Log.d(TAG, "onClick: game - stage advance");

                // Advance stage bg
                if (mStageAdvanceMeter >= mStageAdvanceTarget) {

                    //
                    playAudio(FLUTE_TRILL_SHORT);

                    //
                    tapOut();
                }
                break;

            // Game - Miss Event
            case R.id.game_main_pg_creature_canvas_layout:
                Log.d(TAG, "onClick: game - miss [+1 MissNRoar]");

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    //
                    if (mTapCount > 1) {

                        //
                        playAudio(FLASH_BANG);
                    }
                    // Reset tapper
                    resetTapper();

                    // Tally miss
                    missPoint();

                    // Housekeeping
                    drawScreen(R.id.game_screen_main_layout);
                }

                break;

            // Game - Hit Events
            case R.id.game_main_creature_01_image_button:
                Log.d(TAG, "onClick: game - hit creature 1 [+1 EatNRun]");

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Inflate tapper
                    inflateTapper();

                    // Tally point
                    scorePoint();

                    // Housekeeping
                    drawScreen(R.id.game_screen_main_layout);

                    // Regenerate creature
                    switchCreature(R.id.game_main_creature_01_image_button, R.id.game_main_pg_creature_canvas_layout);
                }

                break;

            //
            case R.id.game_main_creature_02_image_button:
                Log.d(TAG, "onClick: game - hit creature 2 [+1 EatNRun]");

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Inflate tapper
                    inflateTapper();

                    // Tally point
                    scorePoint();

                    // Housekeeping
                    drawScreen(R.id.game_screen_main_layout);

                    // Regenerate creature
                    switchCreature(R.id.game_main_creature_02_image_button, R.id.game_main_pg_creature_canvas_layout);
                }

                break;

            //
            case R.id.game_main_creature_03_image_button:
                Log.d(TAG, "onClick: game - hit creature 3 [+1 EatNRun]");

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Inflate tapper
                    inflateTapper();

                    // Tally point
                    scorePoint();

                    // Housekeeping
                    drawScreen(R.id.game_screen_main_layout);

                    // Regenerate creature
                    switchCreature(R.id.game_main_creature_03_image_button, R.id.game_main_pg_creature_canvas_layout);
                }

                break;

            //
            case R.id.game_main_creature_04_image_button:
                Log.d(TAG, "onClick: game - hit creature 4 [+1 EatNRun]");

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Inflate tapper
                    inflateTapper();

                    // Tally point
                    scorePoint();

                    // Housekeeping
                    drawScreen(R.id.game_screen_main_layout);

                    // Regenerate creature
                    switchCreature(R.id.game_main_creature_04_image_button, R.id.game_main_pg_creature_canvas_layout);
                }

                break;

            //
            case R.id.game_main_creature_05_image_button:
                Log.d(TAG, "onClick: game - hit creature 5 [+1 EatNRun]");

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Inflate tapper
                    inflateTapper();

                    // Tally point
                    scorePoint();

                    // Housekeeping
                    drawScreen(R.id.game_screen_main_layout);

                    // Regenerate creature
                    switchCreature(R.id.game_main_creature_05_image_button, R.id.game_main_pg_creature_canvas_layout);
                }

                break;

            // Game - Run Event
            case R.id.game_main_power_01_image_view:
                Log.d(TAG, "onClick: game - Run [reset EatNRun]");

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
                Log.d(TAG, "onClick: game - Roar [reset MissNRoar]");

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Spend power
                    usePower(mPower06Meter, mPower06Target, 6);
                }

                break;

            //
            case R.id.game_main_boss_image_button:
                Log.d(TAG, "onClick: game - Boss Tap [-1 mBossHealth]");

                // Attack boss
                attackBoss();

                // Move boss
                moveCreature(R.id.game_main_boss_image_button, R.id.game_main_pg_boss_canvas_layout);

                break;

            //
            case R.id.game_main_pg_boss_canvas_layout:
                Log.d(TAG, "onClick: game - Boss Miss [no apex]");

                //
                playAudio(MISS);

                //
                mStageApex = false;

                break;

//--RESULTS-->

            // Results - Return Game Event
            case R.id.results_main_return_image_button:
                Log.d(TAG, "onClick: results - return");

                // Switch to entry screen
                switchScreen(R.id.entry_screen_main_layout);

                //
                playAudio(MISS);

                break;

            // Results - Exit Game Event
            case R.id.results_main_exit_image_button:
                Log.d(TAG, "onClick: results - exit");

                //
                playAudio(RUN);

                // Exit game
                this.finish();

                break;

            // Results - Restart Game Event
            // -- Modify to 'start' -->
            case R.id.results_footer_restart_image_button:
                Log.d(TAG, "onClick: results - restart button");

                //
                playAudio(ROAR);

                // -- Refer to stage props to load level -->

                // Restart level
                startGame(mStageIndex);

                break;

            // Results - Next Stage Event
            case R.id.results_footer_next_image_button:
                Log.d(TAG, "onClick: results - next button");

                // -- Reset stage props -->

                // Restart stage
                switchScreen(R.id.stage_select_screen_main_layout);

                //
                playAudio(RUN);

                break;

//--EATEN-->

            // Eaten - Return
            case R.id.eaten_main_return_image_button:
                Log.d(TAG, "onClick: eaten - return");

                // Return
                switchScreen(R.id.stage_select_screen_main_layout);

                //
                playAudio(MISS);

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

                // Try again
                if (mStageIndex != -1) {

                    //
                    startGame(mStageIndex);

                } else {

                    //
                    startBoss();
                }

                //
                playAudio(ROAR);

                break;

            // Eaten - Give up
            case R.id.eaten_footer_tutorial_image_button:
                Log.d(TAG, "onClick: eaten - give up");

                // Tutorial
                switchScreen(R.id.help_screen_main_layout);

                //
                playAudio(RUN);

                break;
        }
    }

    // Initiate game state
    public void startGame(int stage_index) {
        Log.d(TAG, "startGame: >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + stage_index + "<<<<<<<<<<<<<<<<<<<<<<<<");

        //
        playAudio(BG_AUDIO);

        //
        mStageIndex = stage_index;

        // Reset variables
        resetVars();

        // Reset progress marker
        resetLevelMarkers();

        // Initial background
        switchEnvironment(R.id.game_main_pg_creature_canvas_layout);

        // Switch to game screen
        switchScreen(R.id.game_screen_main_layout);


//       final Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//            }
//        };

        h.postDelayed(new Runnable() {

            @Override
            public void run() {

                // If game is NOT paused, or if it IS paused with countdown
                if (!mPauseGame) {

                    // Increment game
                    gameOn();

                } else {

                    //
                    if (mPauseTimer > 0) {

                        //
                        --mPauseTimer;

                    } else if (mPauseTimer != -1) {

                        //
                        mPauseGame = false;
                        mPauseTimer = -1;

                    }
                }

                // Check timer is not expired
                if (mHungerMeter > 0) {

                    // Increment timer
                    h.postDelayed(this, mSpeedIndex);

                } else {

                    // End game
                    playerEaten();
                }
            }
        }, 1);
    }

    // Game on
    private void gameOn() {

        // Check timer end game if expired, if not increment game
        if (mHungerMeter > 0) {

            //
            --mHungerMeter;

            //
            ++mPower02Meter;

            //
            updatePower06();

        } else {

            //
            return;
        }

        //
        updatePower05();

        //
        updateTunnel();

        //
        if (mBorderBarrel > 0) {

            //
            --mBorderBarrel;
        }

        //
        updateBorder();

        //
        if (mTapCount > 1) {

            //
            --mTapCount;
        }

        //
        updateTapper();

        // Play heartbeat
        playAudio(HEARTBEAT);

        //
        playHaptic();
    }

    // Update power 1
    private void updatePower01() {

        //
        ++mPower01Meter;
    };

    // Update power 2
    private void updatePower02() {

        //
        mPower02Meter = mPower02Meter + 5;
    };

    // Update power 3
    private void updatePower03() {

        //
        ++mSpeciesScore;
        if (mSpeciesScore > 5) {

            //
            ++mPower03Meter;
            mSpeciesScore = 0;
        }
    };

    // Update power 4
    private void updatePower04() {

        //
        ++mPower04Meter;
    };

    // Update power 5
    private void updatePower05() {

        //
        if (mSpeedIndex < 500) {

            //
            ++mPower05Meter;
        }
    }

    // Update power 6
    private void updatePower06() {

        //
        if (mHungerMeter < 10 && !mPauseGame) {

            //
            ++mPower06Meter;
        }
    }

    // Hit sprite
    private void scorePoint() {

        // Ensure there is still time
        if (mHungerMeter <= 0) {

            //
            return;
        }

        //
        updatePower01();

        //
        updatePower03();

        // Increment hit counter
        ++mTotalEatScore;

        //
        ++mTurn;

        //
        ++mHungerMeter;

        // Play bite noise
        playAudio(HIT);

        //
        if (mTapCount > 3 && mTapCount < 13) {

            //
            playAudio(PINGS[mTapCount - 3]);
        }

        // Reset bold image
        if (mHungerMeter < TUNNEL_FADE.length) {
            mGameTunnelVisionLayout.setAlpha((float) TUNNEL_FADE[mHungerMeter]);
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

        }
        //
        updateTapper();

        //
        updatePower04();

        //
        ++mTurn;

        // Play miss noise
        playAudio(MISS);

        // Accelerate timer
        double speedComponent = (mSpeedIndex * .15);
        mSpeedIndex = mSpeedIndex - (long) speedComponent;
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
                    setStage();

                    //
                    playAudio(ROAR);

                    break;

                case 2:

                    //
                    mPower02Meter = 0;
                    mPower02Target += 1;

                    //
                    mSpeedIndex = 2000;

                    //
                    playAudio(BREATH);

                    break;

                case 3:

                    //
                    mPower03Meter = 0;
                    mPower03Target += 1;

                    //
                    switchEnvironment(mGameCreatureLayout.getId());

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

                        // Inflate tapper
                        inflateTapper();

                        // Inflate tapper
                        inflateTapper();

                        // Inflate tapper
                        inflateTapper();

                        // Inflate tapper
                        inflateTapper();

                        // Increment hit counter
                        updatePower02();

                        //
                        mSpeciesScore = mSpeciesScore + 5;
                        ++mTurn;

                        // Play bite noise
                        playAudio(FRENZY);

                        // Accelerate timer
                        double speedComponent = (mSpeedIndex * .25);
                        mSpeedIndex = mSpeedIndex + (long) speedComponent;

                        // Regenerate creature
                        switchCreature(R.id.game_main_creature_01_image_button, R.id.game_main_pg_creature_canvas_layout);

                        // Regenerate creature
                        switchCreature(R.id.game_main_creature_02_image_button, R.id.game_main_pg_creature_canvas_layout);

                        // Regenerate creature
                        switchCreature(R.id.game_main_creature_03_image_button, R.id.game_main_pg_creature_canvas_layout);

                        // Regenerate creature
                        switchCreature(R.id.game_main_creature_04_image_button, R.id.game_main_pg_creature_canvas_layout);

                        // Regenerate creature
                        switchCreature(R.id.game_main_creature_05_image_button, R.id.game_main_pg_creature_canvas_layout);
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
            drawScreen(R.id.game_screen_main_layout);
        }
    }

    // Start boss
    private void startBoss() {
        Log.d(TAG, "startBoss: start boss");

        //
        mPauseGame = true;
        mStageApex = true;
        mKillBoss = false;

        //
        mBossHealth = 4;

        //
        //playAudio(mGameBossCry);

        //
        if (stage_06_complete && mStageIndex == -1) {

            //
            switchScreen(R.id.game_screen_main_layout);

            //
            mGameBossImageButton.setBackground(versionCheck(R.drawable.final_boss));

            //
            mGameBossLayout.setBackground(versionCheck(R.drawable.final_boss_bg));
            mGameBossLayout.setVisibility(View.GONE);
            mGameCreatureLayout.setVisibility(View.VISIBLE);

            //
            mGameMainStageImageView.setBackground(versionCheck(R.drawable.final_boss_title_image));

            //
            findViewById(R.id.game_main_level_marker_layout).setVisibility(View.GONE);
            findViewById(R.id.game_main_power_layouts).setVisibility(View.GONE);

            //
            mGameBossCry = ROAR;

            //
            //mResultsSubStageImageView.setBackground(versionCheck(R.drawable.final_boss_title_image));
            mEatenStageImageView.setBackground(versionCheck(R.drawable.final_boss_title_image));

            //
            mGameTapAudio = THUNDER_AUDIO;

            //
            //mResultsMainBGImageView.setBackground(versionCheck(R.drawable.results_main_final_boss_bg_image));

        } else {

            //
            mStagePredator = getAggressionScore(mAggressionScore) + getSpeciesScore(mSpeciesScore);
            mStageAccuracy = String.valueOf(mTotalEatScore);
            //getPercentage(mTurn, mSpeciesScore);
        }

        //
        mGameCreatureLayout.setVisibility(View.GONE);
        mGameBossLayout.setVisibility(View.VISIBLE);

        //
        mGameBossImageButton.setVisibility(View.VISIBLE);

        //
        drawScreen(R.id.game_screen_main_layout);

        // Run timer through executable task - background activities
        final Handler h = new Handler();
        h.postDelayed(new Runnable() {

            // Incremental
            int i = 0;

            // Run task
            @Override
            public void run() {

                // Check incremental
                if (!mKillBoss) {
                    if (i < 3) {

                        playAudio(mGameBossCry);

                        // Increment timer
                        h.postDelayed(this, 2000);
                        i++;

                        //
                    } else {
                        // Eaten
                        playerEaten();
                    }
                }
            }
        }, 1000);
    }

    // Attack boss
    private void attackBoss() {

        //
        playAudio(ROAR);

        //
        if (mBossHealth > 0) {

            //
            --mBossHealth;

        } else {

            //
            killBoss();
        }

        //
        drawScreen(R.id.game_screen_main_layout);
    }

    // Kill boss
    private void killBoss() {
        Log.d(TAG, "killBoss: kill boss");

        //
        playAudio(mGameTapAudio);
        //
        continue_game = true;

        //
        mKillBoss = true;

        //
        if (mStageIndex != -1) {

            //
            switch (mStageIndex) {

                //
                case 1:

                    //
                    stage_01_complete = true;
                    stage_01_apex = mStageApex;
                    stage_01_predator = mStagePredator;
                    stage_01_accuracy = mStageAccuracy;

                    break;

                //
                case 2:

                    //
                    stage_02_complete = true;
                    stage_02_apex = mStageApex;
                    stage_02_predator = mStagePredator;
                    stage_02_accuracy = mStageAccuracy;

                    break;

                //
                case 3:

                    //
                    stage_03_complete = true;
                    stage_03_apex = mStageApex;
                    stage_03_predator = mStagePredator;
                    stage_03_accuracy = mStageAccuracy;

                    break;

                //
                case 4:

                    //
                    stage_04_complete = true;
                    stage_04_apex = mStageApex;
                    stage_04_predator = mStagePredator;
                    stage_04_accuracy = mStageAccuracy;

                    break;

                //
                case 5:

                    //
                    stage_05_complete = true;
                    stage_05_apex = mStageApex;
                    stage_05_predator = mStagePredator;
                    stage_05_accuracy = mStageAccuracy;

                    break;

                //
                case 6:

                    //
                    stage_06_complete = true;
                    stage_06_apex = mStageApex;
                    stage_06_predator = mStagePredator;
                    stage_06_accuracy = mStageAccuracy;

                    break;

            }

        } else {

            //
            game_complete = true;
            stage_final_boss_apex = mStageApex;

            //
            switchScreen(SCREENS[7]);
            //
            playOutroCredits();

        }

        //
        mGameBossLayout.setVisibility(View.GONE);
        mGameCreatureLayout.setVisibility(View.VISIBLE);

        //
        mGameBossImageButton.setVisibility(View.GONE);

        //
        if (mStageIndex != -1) {

            //
            postResults(getPercentage(mTurn, mSpeciesScore), getAggressionScore(mAggressionScore) + getSpeciesScore(mSpeciesScore), mStageApex);
        }
        //
        setGameData();

        //
        getGameData();
    }

    // Reset game variables
    private void resetVars() {

        //
        mHungerMeter = 21;
        mSpeedIndex = 1000;
        mStageAdvanceMeter = 0;
        mStageAdvanceTarget = 1;

        //
        mPower01Meter = 0;
        mPower01Target = 5;
        mPower02Meter = 0;
        mPower02Target = 10;
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
        mAggressionScore = 0;
        mSpeciesScore = 0;
        mTotalEatScore = 0;

        //
        mTapBarrel = 10;
        mTapCount = 0;
        mTapTotal = 0;

        //
        mBorderBarrel = 0;
        mPauseTimer = -1;

        //
        mPauseGame = false;

        //
        mBossHealth = 4;
        mKillBoss = false;

        //
        mStageApex = false;
        mStageAccuracy = null;
        mStagePredator = null;

    }

    // Load props
    public void loadStageProps(int stage_index) {

        //
        mStageBGImages.clear();

        //
        switch(stage_index) {

            case 1:

                //
                for (int bg : FOREST_SCENES) {

                    //
                    mStageBGImages.add(bg);
                }

                //
                mGameMainStageImageView.setBackground(versionCheck(R.drawable.stage_01_title_image));

                //
                mResultsSubStageImageView.setBackground(versionCheck(R.drawable.stage_01_title_image));
                mResultsStageCardImageView.setBackground(versionCheck(R.drawable.forest_card));
                mEatenStageImageView.setBackground(versionCheck(R.drawable.stage_01_title_image));

                //
                mGameBorderLayout.setBackground(versionCheck(R.drawable.forest_border));
                mGameBorderLayout.setVisibility(View.VISIBLE);

                //
                mGameAdvanceImageView.setBackground(versionCheck(R.drawable.forest_tap));

                //
                mGameTapAudio = THUNDER_AUDIO;

                //
                mGameBossCry = WOLF_CRY;

                //
                mGameBossImageButton.setBackground(versionCheck(R.drawable.forest_boss));

                //
                mGameBossLayout.setBackground(versionCheck(R.drawable.forest_bg_boss));
                mGameBossLayout.setVisibility(View.GONE);
                mGameCreatureLayout.setVisibility(View.VISIBLE);

                //
                mResultsMainBGImageView.setBackground(versionCheck(R.drawable.results_forest_bg_image));

                break;

            case 2:

                //
                for (int bg : OCEAN_SCENES) {

                    //
                    mStageBGImages.add(bg);
                }

                //
                mGameMainStageImageView.setBackground(versionCheck(R.drawable.stage_02_title_image));

                //
                mResultsSubStageImageView.setBackground(versionCheck(R.drawable.stage_02_title_image));
                mResultsStageCardImageView.setBackground(versionCheck(R.drawable.ocean_card));
                mEatenStageImageView.setBackground(versionCheck(R.drawable.stage_02_title_image));

                //
                mGameBorderLayout.setBackground(versionCheck(R.drawable.ocean_border));
                mGameBorderLayout.setVisibility(View.VISIBLE);

                //
                mGameAdvanceImageView.setBackground(versionCheck(R.drawable.ocean_tap));

                //
                mGameTapAudio = SPLASH_AUDIO;

                //
                mGameBossCry = SHARK_CRY;

                //
                mGameBossImageButton.setBackground(versionCheck(R.drawable.ocean_boss));

                //
                mGameBossLayout.setBackground(versionCheck(R.drawable.ocean_bg_boss));
                mGameBossLayout.setVisibility(View.GONE);
                mGameCreatureLayout.setVisibility(View.VISIBLE);

                //
                mResultsMainBGImageView.setBackground(versionCheck(R.drawable.results_ocean_bg_image));

                break;

            case 3:

                //
                for (int bg : MOUNTAIN_SCENES) {

                    //
                    mStageBGImages.add(bg);
                }

                //
                mGameMainStageImageView.setBackground(versionCheck(R.drawable.stage_03_title_image));

                //
                mResultsSubStageImageView.setBackground(versionCheck(R.drawable.stage_03_title_image));
                mResultsStageCardImageView.setBackground(versionCheck(R.drawable.mountain_card));
                mEatenStageImageView.setBackground(versionCheck(R.drawable.stage_03_title_image));

                //
                mGameBorderLayout.setBackground(versionCheck(R.drawable.mountain_border));
                mGameBorderLayout.setVisibility(View.VISIBLE);

                //
                mGameAdvanceImageView.setBackground(versionCheck(R.drawable.mountain_tap));

                //
                mGameTapAudio = EARTHQUAKE_AUDIO;

                //
                mGameBossCry = HAWK_CRY;

                //
                mGameBossImageButton.setBackground(versionCheck(R.drawable.mountain_boss));

                //
                mGameBossLayout.setBackground(versionCheck(R.drawable.mountain_bg_boss));
                mGameBossLayout.setVisibility(View.GONE);
                mGameCreatureLayout.setVisibility(View.VISIBLE);

                //
                mResultsMainBGImageView.setBackground(versionCheck(R.drawable.results_mountain_bg_image));

                break;

            case 4:

                //
                for (int bg : DESERT_SCENES) {

                    //
                    mStageBGImages.add(bg);
                }

                //
                mGameMainStageImageView.setBackground(versionCheck(R.drawable.stage_04_title_image));

                //
                mResultsSubStageImageView.setBackground(versionCheck(R.drawable.stage_04_title_image));
                mResultsStageCardImageView.setBackground(versionCheck(R.drawable.desert_card));
                mEatenStageImageView.setBackground(versionCheck(R.drawable.stage_04_title_image));

                //
                mGameBorderLayout.setBackground(versionCheck(R.drawable.desert_border));
                mGameBorderLayout.setVisibility(View.VISIBLE);

                //
                mGameAdvanceImageView.setBackground(versionCheck(R.drawable.desert_tap));

                //
                mGameTapAudio = TORNADO_AUDIO;

                //
                mGameBossCry = SCORPION_CRY;

                //
                mGameBossImageButton.setBackground(versionCheck(R.drawable.desert_boss));

                //
                mGameBossLayout.setBackground(versionCheck(R.drawable.desert_bg_boss));
                mGameBossLayout.setVisibility(View.GONE);
                mGameCreatureLayout.setVisibility(View.VISIBLE);

                //
                mResultsMainBGImageView.setBackground(versionCheck(R.drawable.results_desert_bg_image));

                break;

            case 5:

                //
                for (int bg : JUNGLE_SCENES) {

                    //
                    mStageBGImages.add(bg);
                }

                //
                mGameMainStageImageView.setBackground(versionCheck(R.drawable.stage_05_title_image));

                //
                mResultsSubStageImageView.setBackground(versionCheck(R.drawable.stage_05_title_image));
                mResultsStageCardImageView.setBackground(versionCheck(R.drawable.jungle_card));
                mEatenStageImageView.setBackground(versionCheck(R.drawable.stage_05_title_image));

                //
                mGameBorderLayout.setBackground(versionCheck(R.drawable.jungle_border));
                mGameBorderLayout.setVisibility(View.VISIBLE);

                //
                mGameAdvanceImageView.setBackground(versionCheck(R.drawable.jungle_tap));

                //
                mGameTapAudio = VOLCANO_AUDIO;

                //
                mGameBossCry = SNAKE_CRY;

                //
                mGameBossImageButton.setBackground(versionCheck(R.drawable.jungle_boss));

                //
                mGameBossLayout.setBackground(versionCheck(R.drawable.jungle_bg_boss));
                mGameBossLayout.setVisibility(View.GONE);
                mGameCreatureLayout.setVisibility(View.VISIBLE);

                //
                mResultsMainBGImageView.setBackground(versionCheck(R.drawable.results_jungle_bg_image));

                break;

            case 6:

                //
                for (int bg : TUNDRA_SCENES) {

                    //
                    mStageBGImages.add(bg);
                }

                //
                mGameMainStageImageView.setBackground(versionCheck(R.drawable.stage_06_title_image));

                //
                mResultsSubStageImageView.setBackground(versionCheck(R.drawable.stage_06_title_image));
                mResultsStageCardImageView.setBackground(versionCheck(R.drawable.tundra_card));
                mEatenStageImageView.setBackground(versionCheck(R.drawable.stage_06_title_image));

                //
                mGameBorderLayout.setBackground(versionCheck(R.drawable.tundra_border));
                mGameBorderLayout.setVisibility(View.VISIBLE);

                //
                mGameAdvanceImageView.setBackground(versionCheck(R.drawable.tundra_tap));

                //
                mGameTapAudio = AVALANCHE_AUDIO;

                //
                mGameBossCry = YETI_CRY;

                //
                mGameBossImageButton.setBackground(versionCheck(R.drawable.tundra_boss));

                //
                mGameBossLayout.setBackground(versionCheck(R.drawable.tundra_bg_boss));
                mGameBossLayout.setVisibility(View.GONE);
                mGameCreatureLayout.setVisibility(View.VISIBLE);

                //
                mResultsMainBGImageView.setBackground(versionCheck(R.drawable.results_tundra_bg_image));

                break;
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

        getGameData();
    }

    // UI navigation to hide and show layouts
    private void switchScreen(int mScreenID) {

        // ID screen
        mCurScreen = mScreenID;

        // Show screen
        if (mCurScreen != -1) {
            for (int id : SCREENS) {
                findViewById(id).setVisibility(mCurScreen == id ? View.VISIBLE : View.GONE);
            }
        }

        // Draw screen
        drawScreen(mCurScreen);
    }

    // Draw screen
    public void drawScreen(int mScreenID) {

        //
        switch (mScreenID) {

            //
            case R.id.intro_screen_main_layout:

                // Reset image view
                //mIntroImageView.setBackground(versionCheck(INTRO[0]));
                //mIntroImageView.setAlpha((float) 0);
                //fadeIn(mIntroImageView.getId());

                break;

            //
            case R.id.entry_screen_main_layout:
                Log.d(TAG, "drawScreen: entry");

                //
                if (continue_game) {
                    mEntryContinueImageButton.setVisibility(View.VISIBLE);
                } else {
                    mEntryContinueImageButton.setVisibility(View.GONE);
                }

                //
                if (game_complete) {
                    mEntryTutorialImageButton.setVisibility(View.GONE);
                } else {
                    mEntryTutorialImageButton.setVisibility(View.VISIBLE);
                }

                break;

            case R.id.help_screen_main_layout:
                Log.d(TAG, "drawScreen: help");

                //
                playAudio(THUNDER_AUDIO);

                break;

            case R.id.stage_select_screen_main_layout:
                Log.d(TAG, "drawScreen: stage select");

                //
                mStageIndex = -1;

                // Check score data for cards
                checkCardData();

                break;

            case R.id.game_screen_main_layout:
                Log.d(TAG, "drawScreen: game");

                // Check power meters

                // Power 1
                if (mPower01Meter > mPower01Target) {

                    mGamePower01ImageView.setVisibility(View.VISIBLE);

                } else {

                    mGamePower01ImageView.setVisibility(View.INVISIBLE);
                }

                // Power 2
                if (stage_01_complete) {

                    if (mPower02Meter > mPower02Target) {

                        mGamePower02ImageView.setVisibility(View.VISIBLE);

                    } else {

                        mGamePower02ImageView.setVisibility(View.INVISIBLE);
                    }

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

                // Check tunnel view fade
                updateTunnel();

                // Check border view fade
                updateBorder();

                // Check tap fade
                updateTapper();

                break;

            case R.id.results_screen_main_layout:
                Log.d(TAG, "drawScreen: results");

                //
                //mResultsSubStageImageView.setVisibility(View.VISIBLE);

                break;

            case R.id.eaten_screen_main_layout:
                Log.d(TAG, "drawScreen: eaten");

                //
                mEatenStageImageView.setVisibility(View.VISIBLE);

                break;

            //
            case R.id.outro_screen_main_layout:

                // Reset image view
                mOutroImageView.setBackground(versionCheck(OUTRO[0]));

                break;
        }
    }

	// Randomly select new background image
	private void switchEnvironment(int canvas) {

        //
        if (!mStageBGImages.isEmpty()) {
            Log.d(TAG, "switchEnvironment: Background Array is Empty >>>>>>>" + mStageBGImages.isEmpty() + "<<<<<<<<<<<<<<<<<<<<");

            //
            //startBoss();

        //} else {

            //
            setStage();

            //
            resetTapper();

            //
            resetBorder();

            //
            resetTunnel();

            // Play bg audio
            //playAudio(BG_AUDIO);

            // Random selection from array
            Random r = new Random();

            //
            mEnvironmentID = mStageBGImages.get(r.nextInt(mStageBGImages.size()));
            Log.d(TAG, "switchEnvironment: Background Array Size >>>>>>>>" + mStageBGImages.size() + "<<<<<<<<<<<<<<<<<<<<<<<<");
            Log.d(TAG, "switchEnvironment: Random Selection ID >>>>>>>>>>>>" + mEnvironmentID + "<<<<<<<<<<<<<<<<<<");

            //
            mStageBGImages.remove(mStageBGImages.indexOf(mEnvironmentID));

            //
            Drawable mEnvironmentDrawable;

            //
            mEnvironmentDrawable = versionCheck(mEnvironmentID);
            findViewById(canvas).setBackground(mEnvironmentDrawable);
        }
    }

    // Reset tunnel
    private void resetTunnel() {

        // Reset tunnel meter
        mHungerMeter = 21;
        mSpeedIndex = 1000;

        // Update tunnel image
        updateTunnel();
    }

    // Reset border
    private void resetBorder() {

        // Reset border meter
        mBorderBarrel = 0;

        // Update border image
        updateBorder();
    }

    // Reset tap meter
    public void resetTapper() {

        // Reset tap meter
        if (mTapCount > 0) {

            //
            mTapCount = 0;
        }

        //
        findViewById(R.id.stage_advance_image).setVisibility(View.INVISIBLE);

        // Update tap image
        updateTapper();
    }

    // Update tunnel
    private void updateTunnel() {

        //
        if (mHungerMeter < TUNNEL_FADE.length) {

            //
            double tunnel_alpha = TUNNEL_FADE[mHungerMeter];
            mGameTunnelVisionLayout.setAlpha((float) tunnel_alpha);

        } else {

            //
            mGameTunnelVisionLayout.setAlpha(0);
        }
    }

    // Update border
    private void updateBorder() {

        //
        if (mBorderBarrel < BORDER_FADE.length) {

            //
            double border_alpha = BORDER_FADE[mBorderBarrel];
            mGameBorderLayout.setAlpha((float) border_alpha);

        } else {

            //
            mGameBorderLayout.setAlpha(0);
        }
    }

    // Update tapper
    private void updateTapper() {

        //
        if (mTapCount < TAP_FADE.length && mStageAdvanceMeter < mStageAdvanceTarget) {

            //
            double tap_alpha = TAP_FADE[mTapCount];
            mGameAdvanceImageView.setAlpha((float) tap_alpha);

        } else {

            //
            mGameAdvanceImageView.setAlpha((float) 1);
        }
    }

    // Inflate tapper
    public void inflateTapper() {

        // Inflate tap variable
        mTapCount = mTapCount + 1;

        // Check target
        if (mTapCount >= mTapBarrel) {

            //
            ++mStageAdvanceMeter;

            //
            if (mStageAdvanceMeter >= mStageAdvanceTarget) {

                //
                findViewById(R.id.game_main_stage_advance_image_view).setVisibility(View.VISIBLE);
                findViewById(R.id.stage_advance_image).setVisibility(View.VISIBLE);
            }

            //
            playAudio(BAMBOO_CLICK);
        }

        // Update bolt, whirlpool, etc.
        if (mTapCount < TAP_FADE.length) { updateTapper(); }
    }

    // Advance to next bg
    private void tapOut() {

        //
        mPauseGame = true;

        // Stage progress
        ++mTapTotal;

        //
        mStageAdvanceMeter = 0;
        //++mStageAdvanceTarget;

        //
        playAudio(mGameTapAudio);

        //
        mGameLevelMarkerImageView.setBackground(versionCheck(LEVEL_MARKERS[mTapTotal]));

        //
        if (mStageBGImages.isEmpty()) {

            //
            findViewById(R.id.game_main_level_marker_layout).setVisibility(View.GONE);
            findViewById(R.id.game_main_power_layouts).setVisibility(View.GONE);

            //
            startBoss();

        } else {

            //
            switchEnvironment(R.id.game_main_pg_creature_canvas_layout);

            //
            mPauseGame = false;
        }
    }

	// Randomly select and position sprites
	private void switchCreature(int creature, int canvas) {

        // Random selection from array
        Random r = new Random();

        // Array of images
        int mCreatureID = CREATURES[r.nextInt(32)];
        Drawable mCreatureDrawable;

        // Return drawable
        mCreatureDrawable = versionCheck(mCreatureID);

        // Attach random background
        findViewById(creature).setBackground(mCreatureDrawable);

        // Move creature
        moveCreature(creature, canvas);
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
            switchCreature(creature, R.id.game_main_pg_creature_canvas_layout);
        }
    }

    // Creature animation
    private void animateCreature(int creature) {

        //
        ImageView creatureImage = (ImageView) findViewById(creature);
        Animation creatureAnimation = AnimationUtils.loadAnimation(this, R.anim.creature_jump);
        creatureAnimation.setFillAfter(true);
        creatureImage.startAnimation(creatureAnimation);
    }

    // Fade out
    private void fadeOut(int screen) {

        //
        ImageView screenImage = (ImageView) findViewById(screen);
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        screenImage.startAnimation(fadeAnimation);
    }

    // Fade in
    private void fadeIn(int view) {

        //
        ImageView screenImage = (ImageView) findViewById(view);
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        screenImage.startAnimation(fadeAnimation);
    }

    // Dialog to reset game
    private void alertNewGame() {

        // Create dialog
        AlertDialog.Builder restartBuilder = new AlertDialog.Builder(this);

        // Set titles
        restartBuilder.setCancelable(true);
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

    // Dialog to edit settings
    private void alertEditSettings() {

        // Create dialog
        AlertDialog.Builder settingsBuilder = new AlertDialog.Builder(this);

        // Set title
        settingsBuilder.setCancelable(true);
        //settingsBuilder.setTitle("Settings");
        settingsBuilder.setTitle("Adjust Game Settings");

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

                //
                playAudio(HEARTBEAT);
            }
        });

        // Display
        settingsBuilder.show();

        //
        playAudio(CROW_AUDIO);
    }

    // Dialog to alert return lose progress
    private void alertReturnLoseProgress() {

        // Pause
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

                //
                playAudio(MISS);

                //
                mPauseGame = false;
                dialogInterface.cancel();
            }
        });

        // Set positive button
        mReturnAlert.setPositiveButton("Sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //
                playAudio(RUN);

                //
                switchScreen(R.id.stage_select_screen_main_layout);

            }
        });

        //
        mReturnAlert.show();

        //
        playAudio(CROW_AUDIO);
    }

    // Dialog to alert exit lose progress
    private void alertExitLoseProgress() {

        // Pause
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

                //
                playAudio(MISS);

                //
                mPauseGame = false;
                dialogInterface.cancel();
            }
        });

        // Set positive button
        mReturnAlert.setPositiveButton("Sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //
                playAudio(RUN);

                //
                finish();
            }
        });

        //
        mReturnAlert.show();

        //
        playAudio(CROW_AUDIO);
    }

    // Method to return drawable resource
    @SuppressWarnings("deprecation")
    private Drawable versionCheck(int mID) {

	    // Check version
	    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

	        //
	        return context.getResources().getDrawable(mID, getTheme());

        } else {

	        //
	        return  context.getResources().getDrawable(mID);
        }
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
            if (sound == BG_AUDIO) {

                //
                mediaPlayer.setLooping(true);
            }

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

	// Check stage progress and scores
	private void checkCardData() {

        // Check apex achievement
        if (stage_01_apex) {

            // Reveal apex achievement
            mStage01ApexImageView.setVisibility(View.VISIBLE);

        } else {

            // Hide apex achievement
            mStage01ApexImageView.setVisibility(View.GONE);
        }

        // Check accuracy score
        if (stage_01_accuracy != null) {

            // Reveal accuracy score
            mStage01AccuracyTextView.setVisibility(View.VISIBLE);
            mStage01AccuracyTextView.setText(stage_01_accuracy);

        } else {

            // Hide accuracy score
            mStage01AccuracyTextView.setVisibility(View.GONE);
        }

        // Check predator score
        if (stage_01_predator != null) {

            // Reveal predator score
            mStage01PredatorTextView.setVisibility(View.VISIBLE);
            mStage01PredatorTextView.setText(stage_01_predator);

        } else {

            // Hide predator score
            mStage01PredatorTextView.setVisibility(View.GONE);
        }

        // Check stage 2 ready
        if (stage_02_unlocked) {

            // Unlock stage
            mStage02LockedImageButton.setVisibility(View.GONE);

            // Check apex achievement
            if (stage_02_apex) {

                // Reveal apex achievement
                mStage02ApexImageView.setVisibility(View.VISIBLE); }

            else {

                // Hide apex achievement
                mStage02ApexImageView.setVisibility(View.GONE); }

            // Check accuracy score
            if (stage_02_accuracy != null) {

                // Reveal accuracy score
                mStage02AccuracyTextView.setVisibility(View.VISIBLE);
                mStage02AccuracyTextView.setText(stage_02_accuracy);

            } else {

                // Hide accuracy score
                mStage02AccuracyTextView.setVisibility(View.GONE); }

            // Check predator score
            if (stage_02_predator != null) {

                // Reveal predator score
                mStage02PredatorTextView.setVisibility(View.VISIBLE);
                mStage02PredatorTextView.setText(stage_02_predator);

            } else {

                // Hide predator score
                mStage02PredatorTextView.setVisibility(View.GONE); }

        } else {

            // Lock stage
            mStage02LockedImageButton.setVisibility(View.VISIBLE);
            mStage02ApexImageView.setVisibility(View.GONE);
            mStage02AccuracyTextView.setVisibility(View.GONE);
            mStage02PredatorTextView.setVisibility(View.GONE);
        }

        // Check stage 3 progress
        if (stage_03_unlocked) {

            // Unlock stage
            mStage03LockedImageButton.setVisibility(View.GONE);

            // Check apex achievement
            if (stage_03_apex) {

                // Reveal apex achievement
                mStage03ApexImageView.setVisibility(View.VISIBLE);

            } else {

                // Hide apex achievement
                mStage03ApexImageView.setVisibility(View.GONE);
            }

            // Check accuracy score
            if (stage_03_accuracy != null) {

                // Reveal accuracy score
                mStage03AccuracyTextView.setVisibility(View.VISIBLE);
                mStage03AccuracyTextView.setText(stage_03_accuracy);

            } else {

                // Hide accuracy score
                mStage03AccuracyTextView.setVisibility(View.GONE);
            }

            // Check predator score
            if (stage_03_predator != null) {

                // Reveal predator score
                mStage03PredatorTextView.setVisibility(View.VISIBLE);
                mStage03PredatorTextView.setText(stage_03_predator);

            } else {

                // Hide predator score
                mStage03PredatorTextView.setVisibility(View.GONE);
            }

        } else {

            // Lock stage
            mStage03LockedImageButton.setVisibility(View.VISIBLE);
            mStage03ApexImageView.setVisibility(View.GONE);
            mStage03AccuracyTextView.setVisibility(View.GONE);
            mStage03PredatorTextView.setVisibility(View.GONE);
        }

        // Check stage 4 progress
        if (stage_04_unlocked) {

            // Unlock stage
            mStage04LockedImageButton.setVisibility(View.GONE);

            // Check apex achievement
            if (stage_04_apex) {

                // Reveal apex achievement
                mStage04ApexImageView.setVisibility(View.VISIBLE);

            } else {

                // Hide apex achievement
                mStage04ApexImageView.setVisibility(View.GONE);
            }

            // Check accuracy score
            if (stage_04_accuracy != null) {

                // Reveal accuracy score
                mStage04AccuracyTextView.setVisibility(View.VISIBLE);
                mStage04AccuracyTextView.setText(stage_04_accuracy);

            } else {

                // Hide accuracy score
                mStage04AccuracyTextView.setVisibility(View.GONE);
            }

            // Check predator score
            if (stage_04_predator != null) {

                // Reveal predator score
                mStage04PredatorTextView.setVisibility(View.VISIBLE);
                mStage04PredatorTextView.setText(stage_04_predator);

            } else {

                // Hide predator score
                mStage04PredatorTextView.setVisibility(View.GONE);
            }

        } else {

            // Lock stage
            mStage04LockedImageButton.setVisibility(View.VISIBLE);
            mStage04ApexImageView.setVisibility(View.GONE);
            mStage04AccuracyTextView.setVisibility(View.GONE);
            mStage04PredatorTextView.setVisibility(View.GONE);
        }

        // Check stage 5 progress
        if (stage_05_unlocked) {

            // Unlock stage
            mStage05LockedImageButton.setVisibility(View.GONE);

            // Check apex achievement
            if (stage_05_apex) {

                // Reveal apex achievement
                mStage05ApexImageView.setVisibility(View.VISIBLE);

            } else {

                // Hide apex achievement
                mStage05ApexImageView.setVisibility(View.GONE);
            }

            // Check accuracy score
            if (stage_05_accuracy != null) {

                // Reveal accuracy score
                mStage05AccuracyTextView.setVisibility(View.VISIBLE);
                mStage05AccuracyTextView.setText(stage_05_accuracy);

            } else {

                // Hide accuracy score
                mStage05AccuracyTextView.setVisibility(View.GONE);
            }

            // Check predator score
            if (stage_05_predator != null) {

                // Reveal predator score
                mStage05PredatorTextView.setVisibility(View.VISIBLE);
                mStage05PredatorTextView.setText(stage_05_predator);

            } else {

                // Hide predator score
                mStage05PredatorTextView.setVisibility(View.GONE);
            }

        } else {

            // Lock stage
            mStage05LockedImageButton.setVisibility(View.VISIBLE);
            mStage05ApexImageView.setVisibility(View.GONE);
            mStage05AccuracyTextView.setVisibility(View.GONE);
            mStage05PredatorTextView.setVisibility(View.GONE);
        }

        // Check stage 6 progress
        if (stage_06_unlocked) {

            // Unlock stage
            mStage06LockedImageButton.setVisibility(View.GONE);

            // Check apex achievement
            if (stage_06_apex) {

                // Reveal apex achievement
                mStage06ApexImageView.setVisibility(View.VISIBLE);

            } else {

                // Hide apex achievement
                mStage06ApexImageView.setVisibility(View.GONE);
            }

            // Check accuracy score
            if (stage_06_accuracy != null) {

                // Reveal accuracy score
                mStage06AccuracyTextView.setVisibility(View.VISIBLE);
                mStage06AccuracyTextView.setText(stage_06_accuracy);

            } else {

                // Hide accuracy score
                mStage06AccuracyTextView.setVisibility(View.GONE);
            }

            // Check predator score
            if (stage_06_predator != null) {

                // Reveal predator score
                mStage06PredatorTextView.setVisibility(View.VISIBLE);
                mStage06PredatorTextView.setText(stage_06_predator);

            } else {

                // Hide predator score
                mStage06PredatorTextView.setVisibility(View.GONE);
            }

        } else {

            // Lock stage
            mStage06LockedImageButton.setVisibility(View.VISIBLE);
            mStage06ApexImageView.setVisibility(View.GONE);
            mStage06AccuracyTextView.setVisibility(View.GONE);
            mStage06PredatorTextView.setVisibility(View.GONE);
        }

        // Check final stage progress
        if (stage_06_complete) {

            // Unlock final
            findViewById(R.id.stage_select_card_final_boss_image_layout).setVisibility(View.VISIBLE);
            //mFinalBossImageView.setVisibility(View.VISIBLE);

            // Check apex achievement
            if (stage_final_boss_apex) {

                // Reveal apex achievement
                findViewById(R.id.select_stage_final_boss_apex_image_view).setVisibility(View.VISIBLE);
                //mStageFinalBossApexImageView.setVisibility(View.VISIBLE);

            } else {

                // Hide apex achievement
                findViewById(R.id.select_stage_final_boss_apex_image_view).setVisibility(View.GONE);
                //mStageFinalBossApexImageView.setVisibility(View.GONE);
            }

        } else {

            // Lock stage
            findViewById(R.id.stage_select_card_final_boss_image_layout).setVisibility(View.GONE);
            //mFinalBossImageView.setVisibility(View.GONE);
            findViewById(R.id.select_stage_final_boss_apex_image_view).setVisibility(View.GONE);
            //mStageFinalBossApexImageView.setVisibility(View.GONE);
        }
    }

	// Calculate percentage
	@SuppressLint("DefaultLocale")
	private static String getPercentage(int mTurns, int mHits) {

        // Ensure not dividing by zero
        if (mTurns < 1) { mTurns = 1; }

        // Build and return float average of turns and hits
		float mPercentage = (100 * (float) mHits) / ((float) mTurns);
		return String.format("%2.0f%%", mPercentage);
	}

	// Get aggression score
	private static String getAggressionScore(int aggression) {

	    // Build return string
		String aggressionScore;

		// Classify aggression
		if (aggression < 1) {
            aggressionScore = "grumpy ";
        } else if (aggression < 2) {
            aggressionScore = "bothered ";
		} else if (aggression < 3) {
			aggressionScore = "irritated ";
		} else if (aggression < 4) {
			aggressionScore = "annoyed ";
		} else if (aggression < 5) {
			aggressionScore = "upset ";
		} else if (aggression < 6) {
			aggressionScore = "frustrated ";
        } else if (aggression < 7) {
            aggressionScore = "infuriated ";
        } else if (aggression < 8) {
            aggressionScore = "hostile ";
        } else if (aggression < 9) {
            aggressionScore = "wrathful ";
        } else if (aggression < 10) {
            aggressionScore = "enraged ";
        } else {
            aggressionScore = "???";
		}

		// Return string
		return aggressionScore;
	}

	// Get species score
	private static String getSpeciesScore(int species) {

	    // Build return string
		String speciesScore;

		// Classify predator
		if (species < 2) {
			speciesScore = "tadpole";
		} else if (species < 3) {
            speciesScore = "mouse";
        } else if (species < 4) {
            speciesScore = "toad";
		} else if (species < 5) {
            speciesScore = "pigeon";
        } else if (species < 6) {
            speciesScore = "crab";
		} else if (species < 7) {
            speciesScore = "rabbit";
		} else if (species < 8) {
            speciesScore = "sloth";
		} else {
            speciesScore = "???";
		}

		// Return string
		return speciesScore;
	}

    // Reset level markers
    private void resetLevelMarkers() {

        // Replace image
        mGameLevelMarkerImageView.setBackground(versionCheck(LEVEL_MARKERS[0]));

        // Reveal markers and powers
        findViewById(R.id.game_main_level_marker_layout).setVisibility(View.VISIBLE);
        findViewById(R.id.game_main_power_layouts).setVisibility(View.VISIBLE);
    }

	// Post score results
    // TODO - add total score formulas to this method
	private void postResults(String stage_accuracy_score, String stage_predator_score, boolean stage_apex_score) {

        // Switch to results screen
		switchScreen(R.id.results_screen_main_layout);

		// Post scores
        mResultsAccuracyTextView.setText(stage_accuracy_score);
        mResultsPredatorTextView.setText(stage_predator_score);

        // Toggle apex achievement
        if (stage_apex_score) { mResultsApexImageView.setVisibility(View.VISIBLE); }
        else { mResultsApexImageView.setVisibility(View.GONE); }

        // Play outro
        playAudio(FLUTE_TRILL_LONG);
    }

    // Player eaten
    private void playerEaten() {

        // Stop timer
        mPauseGame = true;

        // Switch to eaten screen
        switchScreen(R.id.eaten_screen_main_layout);

        // Fade titles
        fadeIn(R.id.eaten_main_ending_image_view);
        fadeIn(R.id.eaten_footer_tutorial_image_button);
        fadeIn(R.id.eaten_footer_try_again_image_button);

        // Play outro audio
        playAudio(HIT);
        playAudio(DARK_OUTRO);
    }

//-- ARRAY RESOURCES -->

    // Array list of screen layouts
    final private static int[] SCREENS = {

            //
            R.id.help_screen_main_layout, R.id.entry_screen_main_layout, R.id.game_screen_main_layout, R.id.results_screen_main_layout,
            R.id.intro_screen_main_layout, R.id.stage_select_screen_main_layout, R.id.eaten_screen_main_layout, R.id.outro_screen_main_layout
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

            // Entry
            R.id.entry_main_continue_image_button, R.id.entry_main_new_image_button, R.id.entry_main_settings_image_button, R.id.entry_main_tutorial_image_button,

            // Help
            R.id.help_main_return_image_button, R.id.help_main_exit_image_button, R.id.help_main_tutorial_image_button,

            // Game
            R.id.game_main_return_image_button, R.id.game_main_exit_image_button, R.id.stage_advance_image,

            //
            R.id.game_main_power_01_image_view, R.id.game_main_power_02_image_view, R.id.game_main_power_03_image_view,
            R.id.game_main_power_04_image_view, R.id.game_main_power_05_image_view, R.id.game_main_power_06_image_view,

            //
            R.id.game_main_pg_creature_canvas_layout, R.id.game_main_pg_boss_canvas_layout,

            //
            R.id.game_main_creature_01_image_button, R.id.game_main_creature_02_image_button, R.id.game_main_creature_03_image_button,
            R.id.game_main_creature_04_image_button, R.id.game_main_creature_05_image_button, R.id.game_main_boss_image_button,

            // Results
            R.id.results_main_return_image_button, R.id.results_main_exit_image_button,
            R.id.results_footer_restart_image_button, R.id.results_footer_next_image_button,

            // Stage select
            R.id.stage_select_return_image_button, R.id.select_stage_exit_image_button,

            //
            R.id.stage_select_card_01_image_layout, R.id.stage_select_card_02_image_layout, R.id.stage_select_card_03_image_layout,
            R.id.stage_select_card_04_image_layout, R.id.stage_select_card_05_image_layout, R.id.stage_select_card_06_image_layout,
            R.id.stage_select_card_final_boss_image_layout,

            // Eaten
            R.id.eaten_main_return_image_button, R.id.eaten_main_exit_image_button,
            R.id.eaten_footer_tutorial_image_button, R.id.eaten_footer_try_again_image_button,
    };

    // Array list of creature buttons
    final private static int[] CREATURE_BUTTONS = {

            //
            R.id.game_main_creature_01_image_button, R.id.game_main_creature_02_image_button, R.id.game_main_creature_03_image_button,
            R.id.game_main_creature_04_image_button, R.id.game_main_creature_05_image_button
    };

    // Array list of background images [forest]
    final private static int[] FOREST_SCENES = {

            //
            R.drawable.forest_bg_01, R.drawable.forest_bg_02, R.drawable.forest_bg_03, R.drawable.forest_bg_04, R.drawable.forest_bg_05
    };

    // Array list of background images [ocean]
    final private static int[] OCEAN_SCENES = {

            //
            R.drawable.ocean_bg_01, R.drawable.ocean_bg_02, R.drawable.ocean_bg_03, R.drawable.ocean_bg_04, R.drawable.ocean_bg_05
    };

    // Array list of background images [mountain]
    final private static int[] MOUNTAIN_SCENES = {

            //
            R.drawable.mountain_bg_01, R.drawable.mountain_bg_02, R.drawable.mountain_bg_03, R.drawable.mountain_bg_04, R.drawable.mountain_bg_05
    };

    // Array list of background images [desert]
    final private static int[] DESERT_SCENES = {

            //
            R.drawable.desert_bg_01, R.drawable.desert_bg_02, R.drawable.desert_bg_03, R.drawable.desert_bg_04, R.drawable.desert_bg_05
    };

    // Array list of background images [jungle]
    final private static int[] JUNGLE_SCENES = {

            //
            R.drawable.jungle_bg_01, R.drawable.jungle_bg_02, R.drawable.jungle_bg_03, R.drawable.jungle_bg_04, R.drawable.jungle_bg_05
    };

    // Array list of background images [tundra]
    final private static int[] TUNDRA_SCENES = {

            //
            R.drawable.tundra_bg_01, R.drawable.tundra_bg_02, R.drawable.tundra_bg_03, R.drawable.tundra_bg_04, R.drawable.tundra_bg_05
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

    // Array list of alphas for border image
    final private static double[] BORDER_FADE = {

            //
            1, .95, .9, .85, .8, .75, .7, .65, .6, .55, .5, .4, .3, .25, .2, .15, .1, .075, .05, .025, 0
    };

    // Array list of alphas for bolt image
    final private static double[] TAP_FADE = {

            //
            .0, .0, .1, .12, .13, .14, .10, .25, .40, .50, .60, .75, .80, .85, .87, .91, .93, .95, .97, .99, 1
    };

    // Array list of alphas for tunnel fade
    final private static double[] TUNNEL_FADE = {

            //
            1, .95, .9, .85, .8, .75, .7, .65, .6, .55, .5, .4, .3, .25, .2, .15, .1, .075, .05, .025, 0
    };

    // Array list of alphas
    final private static double[] ALPHA_INDEX = {

            //
            1, .99, .98, .97, .96, .95, .93, .9, .85, .8, .75, .7, .6, .5, .4, .25, .1, 0, 0
    };

    // Array list of sound effects
    final private static int[] PING = {

            //
            R.raw.reverse_ding_00, R.raw.reverse_ding_01, R.raw.reverse_ding_02, R.raw.reverse_ding_03, R.raw.reverse_ding_04,
            R.raw.reverse_ding_05, R.raw.reverse_ding_06, R.raw.reverse_ding_07, R.raw.reverse_ding_08, R.raw.reverse_ding_09,
            R.raw.reverse_ding_10
    };

    // Array list of pings
    final private static int[] PINGS = {

            //
            R.raw.ping_01_audio, R.raw.ping_02_audio, R.raw.ping_03_audio, R.raw.ping_04_audio, R.raw.ping_05_audio,
            R.raw.ping_06_audio, R.raw.ping_07_audio, R.raw.ping_08_audio, R.raw.ping_09_audio, R.raw.ping_10_audio
    };
}