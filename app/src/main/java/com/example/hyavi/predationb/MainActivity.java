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
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Random;

/*
    PREDATION BETA - AKA EAT OR BE EATEN
	Game of Predator and Prey
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

    //
    private static final String AUDIO_SAVED_STATE = "audio_saved_state";
    private static final String HAPTIC_SAVED_STATE = "haptic_saved_state";

    //
    private static final String STAGE_01_COMPLETE = "stage_01_complete";
    private static final String STAGE_01_PREDATOR = "stage_01_predator";
    private static final String STAGE_01_ACCURACY = "stage_01_accuracy";
    private static final String STAGE_01_APEX = "stage_01_apex";

    //
    private static final String STAGE_02_COMPLETE = "stage_02_complete";
    private static final String STAGE_02_PREDATOR = "stage_02_predator";
    private static final String STAGE_02_ACCURACY = "stage_02_accuracy";
    private static final String STAGE_02_APEX = "stage_02_apex";

    //
    private static final String STAGE_03_COMPLETE = "stage_03_complete";
    private static final String STAGE_03_PREDATOR = "stage_03_predator";
    private static final String STAGE_03_ACCURACY = "stage_03_accuracy";
    private static final String STAGE_03_APEX = "stage_03_apex";

    //
    private static final String STAGE_04_COMPLETE = "stage_04_complete";
    private static final String STAGE_04_PREDATOR = "stage_04_predator";
    private static final String STAGE_04_ACCURACY = "stage_04_accuracy";
    private static final String STAGE_04_APEX = "stage_04_apex";

    //
    private static final String STAGE_05_COMPLETE = "stage_05_complete";
    private static final String STAGE_05_PREDATOR = "stage_05_predator";
    private static final String STAGE_05_ACCURACY = "stage_05_accuracy";
    private static final String STAGE_05_APEX = "stage_05_apex";

    //
    private static final String STAGE_06_COMPLETE = "stage_06_complete";
    private static final String STAGE_06_PREDATOR = "stage_06_predator";
    private static final String STAGE_06_ACCURACY = "stage_06_accuracy";
    private static final String STAGE_06_APEX = "stage_06_apex";

    //
    private static final String GAME_COMPLETE = "game_complete";

// DECLARE GLOBAL VIEWS

    // Intro views
    private ImageView mIntroImageView;

    // Entry views
    private ImageButton mEntryContinueImageButton;
    private ImageButton mEntryTutorialImageButton;

    // Stage views
    private TextView mStage01PredatorTextView;
    private TextView mStage01AccuracyTextView;
    private ImageView mStage01ApexImageView;

    //
    private ImageButton mStage02LockedImageButton;
    private TextView mStage02PredatorTextView;
    private TextView mStage02AccuracyTextView;
    private ImageView mStage02ApexImageView;

    //
    private ImageButton mStage03LockedImageButton;
    private TextView mStage03PredatorTextView;
    private TextView mStage03AccuracyTextView;
    private ImageView mStage03ApexImageView;

    //
    private ImageButton mStage04LockedImageButton;
    private TextView mStage04PredatorTextView;
    private TextView mStage04AccuracyTextView;
    private ImageView mStage04ApexImageView;

    //
    private ImageButton mStage05LockedImageButton;
    private TextView mStage05PredatorTextView;
    private TextView mStage05AccuracyTextView;
    private ImageView mStage05ApexImageView;

    //
    private ImageButton mStage06LockedImageButton;
    private TextView mStage06PredatorTextView;
    private TextView mStage06AccuracyTextView;
    private ImageView mStage06ApexImageView;

    // Game views
    private ImageView mGameLevelMarkerImageView;

    //
    private ImageView mGamePower01ImageView;
    private ImageView mGamePower02ImageView;
    private ImageView mGamePower03ImageView;
    private ImageView mGamePower04ImageView;
    private ImageView mGamePower05ImageView;
    private ImageView mGamePower06ImageView;

    //
    private ImageButton mGameCreature01ImageButton;
    private ImageButton mGameCreature02ImageButton;
    private ImageButton mGameCreature03ImageButton;
    private ImageButton mGameCreature04ImageButton;
    private ImageButton mGameCreature05ImageButton;

    //
    private ImageButton mGameBossImageButton;

    //
    private FrameLayout mGameCreatureLayout;

    //
    private FrameLayout mGameBossLayout;

    //
    private ImageView mGameBoltImageView;

    //
    private RelativeLayout mGameTunnelVisionLayout;

    // Results views
    private ImageView mResultsStageImageView;

    //
    private TextView mResultsAccuracyTextView;
    private TextView mResultsPredatorTextView;

    //
    private ImageView mResultsApexImageView;

    // Eaten views
    private ImageView mEatenStageImageView;

// INITIAL DATASTORE - NEW GAME

    // Variables to store saved game data
    private static boolean continue_game;

    // Settings toggle for audio and haptic feedback
    private static boolean play_audio;
    private static boolean play_haptic;

// SUPPLEMENTARY DATASTORE - KILL BOSS

    // Variables to save / restore gamestate
    private static boolean stage_01_complete; // -> if (stage_01_complete) {boolean stage_02_unlocked = true}
    private static String stage_01_predator;
    private static String stage_01_accuracy;
    private static boolean stage_01_apex;

    //
    private static boolean stage_02_unlocked; // -> see above
    private static boolean stage_02_complete; // -> if (stage_02_complete) {boolean stage_03_unlocked = true}
    private static String stage_02_predator;
    private static String stage_02_accuracy;
    private static boolean stage_02_apex;

    //
    private static boolean stage_03_unlocked; // -> see above
    private static boolean stage_03_complete; // -> if (stage_03_complete) {boolean stage_04_unlocked = true}
    private static String stage_03_predator;
    private static String stage_03_accuracy;
    private static boolean stage_03_apex;

    //
    private static boolean stage_04_unlocked; // -> see above
    private static boolean stage_04_complete; // -> if (stage_04_complete) {boolean stage_05_unlocked = true}
    private static String stage_04_predator;
    private static String stage_04_accuracy;
    private static boolean stage_04_apex;

    //
    private static boolean stage_05_unlocked; // -> see above
    private static boolean stage_05_complete; // -> if (stage_05_complete) {boolean stage_06_unlocked = true}
    private static String stage_05_predator;
    private static String stage_05_accuracy;
    private static boolean stage_05_apex;

    //
    private static boolean stage_06_unlocked; // -> see above
    private static boolean stage_06_complete; // -> if (stage_06_complete) {boolean game_beat = true}
    private static String stage_06_predator;
    private static String stage_06_accuracy;
    private static boolean stage_06_apex;

    //
    private static boolean game_complete;

// GAME VARIABLES

    // Variable to stop timers
    private static boolean mPauseGame;

    // Null screen state
    private static int mCurScreen = -1;

    // Variables for tap meter
    private static int mTapBarrel;
    private static int mTapCount;
    private static int mTapTotal;

    // Instantiate universal variables
    private static long mSpeedIndex;
    private static int mHungerMeter = 0;

    //
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

    //
    private static int mTurn;

    //
    private static int mBossHeath;

    //
    private static int mStageIndex;
    private static String mStageAccuracy;
    private static String mStagePredator;
    private static boolean mStageApex;

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
    private static final int THUNDER_AUDIO = R.raw.game_main_thunder_audio;

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

    // Assign views
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

        // Game views
        mGameLevelMarkerImageView = findViewById(R.id.game_main_level_marker_image_view);

        //
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

        //
        mGameBossImageButton = findViewById(R.id.game_main_boss_image_button);

        //
        mGameBossLayout = findViewById(R.id.game_main_boss_layout);
        mGameCreatureLayout = findViewById(R.id.game_main_creature_layout);

        //
        mGameBoltImageView = findViewById(R.id.game_main_bolt_image_view);

        //
        mGameTunnelVisionLayout = findViewById(R.id.game_main_tunnel_vision_layout);

        // Results views
        mResultsStageImageView = findViewById(R.id.results_sub_stage_image_view);
        mResultsAccuracyTextView = findViewById(R.id.results_main_score_accuracy_title_text_view);
        mResultsPredatorTextView = findViewById(R.id.results_sub_score_predator_title_text_view);
        mResultsApexImageView = findViewById(R.id.results_sub_apex_score_image_view);

        // Eaten views
        mEatenStageImageView = findViewById(R.id.eaten_sub_stage_image_view);
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
        game_complete = stage_06_complete;
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

                // Check incremental - 2 intro slides
                if (i < INTRO.length) {

                    // Increment intro images
                    mIntroImageView.setBackground(versionCheck(INTRO[i]));

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

                break;

//--HELP-->

            // Help - Return Button Event
            case R.id.help_main_return_image_button:
                Log.d(TAG, "onClick: help screen - return button");

                // Switch to entry screen
                switchScreen(R.id.entry_screen_main_layout);

                break;

            // Help - Exit Button Event
            case R.id.help_main_exit_image_button:
                Log.d(TAG, "onClick: help screen - exit button");
                
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

                break;

            // Select stage - Exit event
            case R.id.select_stage_exit_image_button:

                // End
                this.finish();

                break;

            // Stage select event
            case R.id.stage_select_card_01_image_layout:
                Log.d(TAG, "onClick: stage select - stage 1");

                // Start game - forest [startStage(forest)]
                startGame(1);

                break;

            //
            case R.id.stage_select_card_02_image_layout:
                Log.d(TAG, "onClick: stage select - stage 2");

                // Start game - ocean [startStage(ocean)]
                if (stage_02_unlocked) { startGame(2); }

                break;

            //
            case R.id.stage_select_card_03_image_layout:
                Log.d(TAG, "onClick: stage select - stage 3");

                // Start game - mountain [startStage(mountain)]
                if (stage_03_unlocked) { startGame(3); }

                break;

            //
            case R.id.stage_select_card_04_image_layout:
                Log.d(TAG, "onClick: stage select - stage 4");

                // Start game - desert [startStage(desert)]
                if (stage_04_unlocked) { startGame(4); }

                break;

            //
            case R.id.stage_select_card_05_image_layout:
                Log.d(TAG, "onClick: stage select - stage 5");

                //
                if (stage_05_unlocked) { startGame(5); }

                break;

            //
            case R.id.stage_select_card_06_image_layout:
                Log.d(TAG, "onClick: stage select - stage 6");

                // Start game - tundra [ startStage{tundra)]
                if (stage_06_unlocked) { startGame(6); }

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
                alertExitLostProgress();

                break;

            // Game - Miss Event
            case R.id.game_main_pg_creature_canvas_layout:
                Log.d(TAG, "onClick: game - miss [+1 MissNRoar]");

                //
                if (!mPauseGame) {

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
                if (!mPauseGame) {

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
                if (!mPauseGame) {

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
                if (!mPauseGame) {

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
                if (!mPauseGame) {

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
                if (!mPauseGame) {

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
                if (!mPauseGame) {

                    // Spend power
                    usePower(mPower01Meter, mPower01Target, 1);

                    // Housekeeping
                    drawScreen(R.id.game_screen_main_layout);
                }

                break;

            //
            case R.id.game_main_power_02_image_view:
                Log.d(TAG, "onClick: game - power 2");

                //
                if (!mPauseGame) {

                    // Spend power
                    usePower(mPower02Meter, mPower02Target, 2);

                    // Housekeeping
                    drawScreen(R.id.game_screen_main_layout);
                }

                break;

            //
            case R.id.game_main_power_03_image_view:
                Log.d(TAG, "onClick: game - power 3");

                //
                if (!mPauseGame) {

                    // Spend power
                    usePower(mPower03Meter, mPower03Target, 3);

                    // Housekeeping
                    drawScreen(R.id.game_screen_main_layout);
                }

                break;

            //
            case R.id.game_main_power_04_image_view:
                Log.d(TAG, "onClick: game - power 4");

                //
                if (!mPauseGame) {

                    // Spend power
                    usePower(mPower04Meter, mPower04Target, 4);

                    // Housekeeping
                    drawScreen(R.id.game_screen_main_layout);
                }

                break;

            //
            case R.id.game_main_power_05_image_view:
                Log.d(TAG, "onClick: game - power 5");

                //
                if (!mPauseGame) {

                    // Spend power
                    usePower(mPower05Meter, mPower05Target, 5);

                    // Housekeeping
                    drawScreen(R.id.game_screen_main_layout);
                }

                break;

            // Game - Roar Event
            case R.id.game_main_power_06_image_view:
                Log.d(TAG, "onClick: game - Roar [reset MissNRoar]");

                //
                if (!mPauseGame) {

                    // Spend power
                    usePower(mPower06Meter, mPower06Target, 6);

                    // Housekeeping
                    drawScreen(R.id.game_screen_main_layout);
                }

                break;

            //
            case R.id.game_main_boss_image_button:
                Log.d(TAG, "onClick: game - Boss Tap [-1 mBossHealth]");

                //
                playAudio(ROAR);

                // Attack boss
                attackBoss();

                // Move boss
                moveCreature(R.id.game_main_boss_image_button, R.id.game_main_pg_boss_canvas_layout);

                break;

            //
            case R.id.game_main_pg_boss_canvas_layout:
                Log.d(TAG, "onClick: game - Boss Miss [no apex]");

                //
                playAudio(THUNDER_AUDIO);

                //
                mStageApex = false;

                break;

//--RESULTS-->

            // Results - Return Game Event
            case R.id.results_main_return_image_button:
                Log.d(TAG, "onClick: results - return");

                // Switch to entry screen
                switchScreen(R.id.entry_screen_main_layout);

                break;

            // Results - Exit Game Event
            case R.id.results_main_exit_image_button:
                Log.d(TAG, "onClick: results - exit");

                // Exit game
                this.finish();

                break;

            // Results - Restart Game Event
            case R.id.results_footer_restart_image_button:
                Log.d(TAG, "onClick: results - restart button");

                // Restart level
                startGame(mStageIndex);

                break;

            // Results - Next Stage Event
            case R.id.results_footer_next_image_button:
                Log.d(TAG, "onClick: results - next button");

                // Restart stage
                switchScreen(R.id.stage_select_screen_main_layout);

                break;

//--EATEN-->

            // Eaten - Return
            case R.id.eaten_main_return_image_button:
                Log.d(TAG, "onClick: eaten - return");

                // Return
                switchScreen(R.id.stage_select_screen_main_layout);

                break;

            // Eaten - Exit
            case R.id.eaten_main_exit_image_button:
                Log.d(TAG, "onClick: eaten - exit");

                // Exit
                this.finish();

                break;

            // Eaten - Try Again
            case R.id.eaten_footer_try_again_image_button:
                Log.d(TAG, "onClick: eaten - try again");

                // Try again
                startGame(mStageIndex);

                break;

            // Eaten - Give up
            case R.id.eaten_footer_tutorial_image_button:
                Log.d(TAG, "onClick: eaten - give up");

                // Tutorial
                switchScreen(R.id.help_screen_main_layout);

                break;
        }
    }

    // Initiate game state - forest
    public void startGame(int stage_index) {

        // Switch to select stage screen [pass stage to startGame function and outsource switchScreen]
        switchScreen(R.id.game_screen_main_layout);

        // Check toggle
        playAudio(RUN);

        // Reset variables
        resetVars();

        //
        if (stage_index != -1) { mStageIndex = stage_index; }

        // Reset progress marker
        resetLevelMarkers();

        // Initial background
        switchEnvironment(R.id.game_main_pg_creature_canvas_layout);

        // Initial sprite rotation
        setStage();

        // Run timer through executable task
        final Handler h = new Handler();
        h.postDelayed(new Runnable() {

            @Override
            public void run() {

                // Check boss mode
                if (!mPauseGame) {

                    // Increment game
                    gameOn();
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
        }, 1000);
    }

    // Reset tap meter
    public void resetTapper() {

        // Reset tap meter
        mTapCount = 0;
    }

    // Inflate tapper
    public void inflateTapper() {

        // Inflate tap variable
        mTapCount = mTapCount + 6;

        // Check target
        if (mTapCount > mTapBarrel) { tapOut(); }

        // Update bolt
        if (mTapCount < BOLT_FADE.length) { updateBolt(); }
    }

    private void tapOut() {

        //
        mPauseGame = true;

        //
        switchEnvironment(R.id.game_main_pg_creature_canvas_layout);

        //
        mPauseGame = false;

        //
        playAudio(THUNDER_AUDIO);

        //
        ++mTapTotal;

        //
        ++mAggressionScore;

        // Reset bold image
        mGameTunnelVisionLayout.setAlpha((float) 0);

        // Check boss ready
        if (mTapTotal < 6) {

            //
            mGameLevelMarkerImageView.setBackground(versionCheck(LEVEL_MARKERS[mTapTotal]));

        } else {

            //
            startBoss();

            //
             switchCreature(R.id.game_main_boss_image_button, R.id.game_main_pg_boss_canvas_layout);
        }
    }

    private void updateBolt() {

        //
        double opacity = BOLT_FADE[mTapCount];
        mGameBoltImageView.setAlpha((float) opacity);
    }

    // Increment game
    private void gameOn() {

            // Check timer end game if expired, if not increment game
            if (mHungerMeter > 0) {

                //
                --mHungerMeter;

                //
                if (mHungerMeter < TUNNEL_FADE.length) {

                    //
                    double tunnel_vision_alpha = TUNNEL_FADE[mHungerMeter];
                    mGameTunnelVisionLayout.setAlpha((float) tunnel_vision_alpha);

                } else {

                    //
                    mGameTunnelVisionLayout.setAlpha(0);
                }


            } else {

                //
                return;
            }

            //
            if (mTapCount > 1) {

                //
                --mTapCount;
            }

            updateBolt();

            // Play heartbeat
            playAudio(HEARTBEAT);

            //
            playHaptic();
    }

    // Hit sprite
    private void scorePoint() {

        // Ensure there is still time
        if (mHungerMeter <= 0) {
            return;
        }

        // Reset bold image
        mGameTunnelVisionLayout.setAlpha((float) 0);

        // Increment hit counter
        ++mPower01Meter;
        ++mPower03Meter;
        ++mPower05Meter;

        //
        ++mSpeciesScore;
        ++mTurn;

        // Play bite noise
        playAudio(HIT);

        //
        ++mHungerMeter;

        // Accelerate timer
        double speedComponent = (mSpeedIndex * .1);
        mSpeedIndex = mSpeedIndex - (long) speedComponent;
    }

    // Miss sprite
    private void missPoint() {

        // Ensure there is still time
        if (mHungerMeter <= 0) {
            return;
        }

        //
        updateBolt();

        // Increment miss counter
        ++mPower06Meter;
        ++mPower04Meter;
        ++mPower02Meter;

        ++mAggressionScore;
        ++mTurn;

        // Play miss noise
        playAudio(MISS);

        //
        --mHungerMeter;

        // Accelerate timer
        double speedComponent = (mSpeedIndex * .2);
        mSpeedIndex = mSpeedIndex - (long) speedComponent;
    }

    private void usePower(int power_meter, int power_target, int power_index) {

        //
        if (power_meter > power_target) {

            //
            switch (power_index) {

                //
                case 1:

                    //
                    mPower01Meter = 0;
                    mPower01Target += 1;

                    // Accelerate timer
                    double speedComponent01 = (mSpeedIndex * .2);
                    mSpeedIndex = mSpeedIndex - (long) speedComponent01;

                    //
                    switchEnvironment(R.id.game_main_pg_creature_canvas_layout);

                    break;

                case 2:

                    //
                    mPower02Meter = 0;
                    mPower02Target += 1;

                    // Reset bold image
                    mGameTunnelVisionLayout.setAlpha((float) 0);

                    //
                    mHungerMeter = 50;

                    break;

                case 3:

                    //
                    mPower03Meter = 0;
                    mPower03Target += 1;

                    break;

                case 4:

                    //
                    mPower04Meter = 0;
                    mPower04Target += 1;

                    break;

                case 5:

                    //
                    mPower05Meter = 0;
                    mPower05Target += 1;

                    break;

                case 6:

                    //
                    mPower06Meter = 0;
                    mPower06Target += 1;

                    // Accelerate timer
                    double speedComponent06 = (mSpeedIndex * .2);
                    mSpeedIndex = mSpeedIndex - (long) speedComponent06;

                    //
                    setStage();

                    break;
            }

            // Housekeeping
            drawScreen(R.id.game_screen_main_layout);

            // Check toggle
            playAudio(ROAR);
        }
    }

    //
    private void startBoss() {
        Log.d(TAG, "startBoss: start boss");

        //
        mPauseGame = true;
        mStageApex = true;
        mStagePredator = getAggressionScore(mAggressionScore) + getSpeciesScore(mSpeciesScore);
        mStageAccuracy = getPercentage(mTurn, mSpeciesScore);

        //
        playAudio(ROAR);

        //
        mGameCreatureLayout.setVisibility(View.GONE);
        mGameBossLayout.setVisibility(View.VISIBLE);

        //
        mGameBossImageButton.setVisibility(View.VISIBLE);

        //
        drawScreen(R.id.game_screen_main_layout);
    }

    //
    private void attackBoss() {

        //
        if (mBossHeath > 0) {

            //
            --mBossHeath;

            //
            playAudio(CHOMP);

        } else {

            //
            killBoss();
        }

        //
        drawScreen(R.id.game_screen_main_layout);
    }

    //
    private void killBoss() {
        Log.d(TAG, "killBoss: kill boss");

        //
        continue_game = true;

        //
        if (mStageIndex != -1) {
            switch (mStageIndex) {

                //
                case 1:

                    //
                    stage_01_complete = true;
                    stage_01_apex = mStageApex;
                    stage_01_predator = mStagePredator;
                    stage_01_accuracy = mStageAccuracy;

                    break;

                case 2:

                    //
                    stage_02_complete = true;
                    stage_02_apex = mStageApex;
                    stage_02_predator = mStagePredator;
                    stage_02_accuracy = mStageAccuracy;

                    break;

                case 3:

                    //
                    stage_03_complete = true;
                    stage_03_apex = mStageApex;
                    stage_03_predator = mStagePredator;
                    stage_03_accuracy = mStageAccuracy;

                    break;

                case 4:

                    //
                    stage_04_complete = true;
                    stage_04_apex = mStageApex;
                    stage_04_predator = mStagePredator;
                    stage_04_accuracy = mStageAccuracy;

                    break;

                case 5:

                    //
                    stage_05_complete = true;
                    stage_05_apex = mStageApex;
                    stage_05_predator = mStagePredator;
                    stage_05_accuracy = mStageAccuracy;

                    break;

                case 6:

                    //
                    stage_06_complete = true;
                    stage_06_apex = mStageApex;
                    stage_06_predator = mStagePredator;
                    stage_06_accuracy = mStageAccuracy;

                    break;

            }
        }

        //
        playAudio(ROAR);

        //
        mGameBossLayout.setVisibility(View.GONE);
        mGameCreatureLayout.setVisibility(View.VISIBLE);

        //
        mGameBossImageButton.setVisibility(View.GONE);

        //
        getResults(getPercentage(mTurn, mSpeciesScore), getAggressionScore(mAggressionScore) + getSpeciesScore(mSpeciesScore), mStageApex);

        //
        setGameData();
        getGameData();
    }

    // Reset game variables
    private void resetVars() {

        //
        mHungerMeter = 50;
        mSpeedIndex = 1000;

        //
        mPower01Meter = 0;
        mPower01Target = 2;
        mPower02Meter = 0;
        mPower02Target = 2;
        mPower03Meter = 0;
        mPower03Target = 2;
        mPower04Meter = 0;
        mPower04Target = 2;
        mPower05Meter = 0;
        mPower05Target = 2;
        mPower06Meter = 0;
        mPower06Target = 2;

        //
        mTurn = 0;

        //
        mAggressionScore = 0;
        mSpeciesScore = 0;

        //
        mTapBarrel = 14;
        mTapCount = 0;
        mTapTotal = 0;

        //
        mPauseGame = false;

        //
        mBossHeath = 2;

        //
        mStageIndex = -1;
        mStageApex = false;
        mStageAccuracy = null;
        mStagePredator = null;
    }

    // Reset saved game data
    public void clearGameData() {

        //
        SharedPreferences mUserPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mUserPref.edit();

        //
        mEditor.clear();
        mEditor.apply();
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

    public void drawScreen(int mScreenID) {

        //
        switch (mScreenID) {

            //
            case R.id.intro_screen_main_layout:

                // Reset image view
                mIntroImageView.setBackground(versionCheck(INTRO[0]));

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

                // Check score data for cards
                checkCardData();

                break;

            case R.id.game_screen_main_layout:
                Log.d(TAG, "drawScreen: game");

                // Check power meters

                // Power 1
                if (mPower01Meter > mPower01Target) {

                    mGamePower01ImageView.setBackground(versionCheck(R.drawable.game_main_power_01_red_image_view));

                } else {

                    mGamePower01ImageView.setBackground(versionCheck(R.drawable.game_main_power_01_black_image_view));
                }

                // Power 2
                if (mPower02Meter > mPower02Target) {

                    mGamePower02ImageView.setBackground(versionCheck(R.drawable.game_main_power_02_red_image_view));

                } else {

                    mGamePower02ImageView.setBackground(versionCheck(R.drawable.game_main_power_02_black_image_view));
                }

                // Power 3
                if (mPower03Meter > mPower03Target) {

                    mGamePower03ImageView.setBackground(versionCheck(R.drawable.game_main_power_03_red_image_view));

                } else {

                    mGamePower03ImageView.setBackground(versionCheck(R.drawable.game_main_power_03_black_image_view));
                }

                // Power 4
                if (mPower04Meter > mPower04Target) {

                    mGamePower04ImageView.setBackground(versionCheck(R.drawable.game_main_power_04_red_image_view));

                } else {

                    mGamePower04ImageView.setBackground(versionCheck(R.drawable.game_main_power_04_black_image_view));
                }

                // Power 5
                if (mPower05Meter > mPower05Target) {

                    mGamePower05ImageView.setBackground(versionCheck(R.drawable.game_main_power_05_red_image_view));

                } else {

                    mGamePower05ImageView.setBackground(versionCheck(R.drawable.game_main_power_05_black_image_view));
                }

                // Power 6
                if (mPower06Meter > mPower06Target) {

                    mGamePower06ImageView.setBackground(versionCheck(R.drawable.game_main_power_06_red_image_view));

                } else {

                    mGamePower06ImageView.setBackground(versionCheck(R.drawable.game_main_power_06_black_image_view));
                }

                break;

            case R.id.results_screen_main_layout:
                Log.d(TAG, "drawScreen: results");

                //
                mResultsStageImageView.setVisibility(View.VISIBLE);

                break;

            case R.id.eaten_screen_main_layout:
                Log.d(TAG, "drawScreen: eaten");

                //
                mEatenStageImageView.setVisibility(View.VISIBLE);

                break;

        }
    }

	// Randomly select new background image
	private void switchEnvironment(int canvas) {

        //
        mHungerMeter = 50;
        mSpeedIndex = 1000;

        //
        setStage();

        //
        resetTapper();

        // Play bg audio
        playAudio(BG_AUDIO);

        // Random selection from array
        Random r = new Random();

        //
        int mEnvironmentID = ENVIRONMENTS[r.nextInt(18)];
        Drawable mEnvironmentDrawable;

        //
        mEnvironmentDrawable = versionCheck(mEnvironmentID);
        findViewById(canvas).setBackground(mEnvironmentDrawable);
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
    }

	// Initial creature spread
	private void setStage() {

            //
            for (int creature : CREATURE_BUTTONS) {
                switchCreature(creature, R.id.game_main_pg_creature_canvas_layout);
            }
    }

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
                dialogInterface.cancel();
            }
        });

        // Set positive button
        restartBuilder.setPositiveButton("Sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                // Reset saved data
                clearGameData();

                // Reinstantiate game state data
                getGameData();

                // Start game - stage select
                switchScreen(R.id.stage_select_screen_main_layout);
            }
        });

        // Display
        restartBuilder.show();
    }

    // Dialog to edit settings
    private void alertEditSettings() {

        // Create dialog
        AlertDialog.Builder settingsBuilder = new AlertDialog.Builder(this);

        // Set title
        settingsBuilder.setTitle("Settings");

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
                        setGameData();

                        //
                        getGameData();

                        break;

                    // Haptic
                    case 1:

                        // Is checked
                        play_haptic = b;

                        //
                        setGameData();

                        //
                        getGameData();

                        break;

                }
            }
        });

        // Display
        settingsBuilder.show();
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
                mPauseGame = false;
                dialogInterface.cancel();
            }
        });

        // Set positive button
        mReturnAlert.setPositiveButton("Sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //
                switchScreen(R.id.stage_select_screen_main_layout);

            }
        });

        //
        mReturnAlert.show();
    }

    // Dialog to alert exit lose progress
    private void alertExitLostProgress() {

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
                mPauseGame = false;
                dialogInterface.cancel();
            }
        });

        // Set positive button
        mReturnAlert.setPositiveButton("Sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //
                finish();
            }
        });

        //
        mReturnAlert.show();
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
                if (v != null) {
                    v.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
                }
            } else {
                if (v != null) {
                    v.vibrate(50);
                }
            }
		}
	}

	// Check card data
	private void checkCardData() {

        // Check stage 1 scores
        if (stage_01_apex) {

            mStage01ApexImageView.setVisibility(View.VISIBLE);

        } else {

            mStage01ApexImageView.setVisibility(View.GONE);
        }

        if (stage_01_accuracy != null) {

            //
            mStage01AccuracyTextView.setVisibility(View.VISIBLE);
            mStage01AccuracyTextView.setText(stage_01_accuracy);

        } else {

            mStage01AccuracyTextView.setVisibility(View.GONE);
        }

        if (stage_01_predator != null) {

            //
            mStage01PredatorTextView.setVisibility(View.VISIBLE);
            mStage01PredatorTextView.setText(stage_01_predator);
        } else {
            mStage01PredatorTextView.setVisibility(View.GONE);
        }

        // Check stage 2 progress
        if (stage_02_unlocked) {

            //
            mStage02LockedImageButton.setVisibility(View.GONE);

            // Check stage 2 scores
            if (stage_02_apex) {
                mStage02ApexImageView.setVisibility(View.VISIBLE);
            } else {
                mStage02ApexImageView.setVisibility(View.GONE);
            }

            //
            if (stage_02_accuracy != null) {

                //
                mStage02AccuracyTextView.setVisibility(View.VISIBLE);
                mStage02AccuracyTextView.setText(stage_02_accuracy);
            } else {
                mStage02AccuracyTextView.setVisibility(View.GONE);
            }

            //
            if (stage_02_predator != null) {

                //
                mStage02PredatorTextView.setVisibility(View.VISIBLE);
                mStage02PredatorTextView.setText(stage_02_predator);
            } else {
                mStage02PredatorTextView.setVisibility(View.GONE);
            }
        } else {
            mStage02LockedImageButton.setVisibility(View.VISIBLE);
        }

        // Check stage 3 progress
        if (stage_03_unlocked) {

            //
            mStage03LockedImageButton.setVisibility(View.GONE);

            // Check stage 3 scores
            if (stage_03_apex) {
                mStage03ApexImageView.setVisibility(View.VISIBLE);
            } else {
                mStage03ApexImageView.setVisibility(View.GONE);
            }

            //
            if (stage_03_accuracy != null) {

                //
                mStage03AccuracyTextView.setVisibility(View.VISIBLE);
                mStage03AccuracyTextView.setText(stage_03_accuracy);
            } else {
                mStage03AccuracyTextView.setVisibility(View.GONE);
            }

            //
            if (stage_03_predator != null) {

                //
                mStage03PredatorTextView.setVisibility(View.VISIBLE);
                mStage03PredatorTextView.setText(stage_03_predator);
            } else {
                mStage03PredatorTextView.setVisibility(View.GONE);
            }
        } else {
            mStage03LockedImageButton.setVisibility(View.VISIBLE);
        }

        // Check stage 4 progress
        if (stage_04_unlocked) {

            //
            mStage04LockedImageButton.setVisibility(View.GONE);

            // Check stage 4 scores
            if (stage_04_apex) {
                mStage04ApexImageView.setVisibility(View.VISIBLE);
            } else {
                mStage04ApexImageView.setVisibility(View.GONE);
            }

            //
            if (stage_04_accuracy != null) {

                //
                mStage04AccuracyTextView.setVisibility(View.VISIBLE);
                mStage04AccuracyTextView.setText(stage_04_accuracy);
            } else {
                mStage04AccuracyTextView.setVisibility(View.GONE);
            }

            //
            if (stage_04_predator != null) {

                //
                mStage04PredatorTextView.setVisibility(View.VISIBLE);
                mStage04PredatorTextView.setText(stage_04_predator);
            } else {
                mStage04PredatorTextView.setVisibility(View.GONE);
            }
        } else {
            mStage04LockedImageButton.setVisibility(View.VISIBLE);
        }

        // Check stage 5 progress
        if (stage_05_unlocked) {

            //
            mStage05LockedImageButton.setVisibility(View.GONE);

            // Check stage 5 scores
            if (stage_05_apex) {
                mStage05ApexImageView.setVisibility(View.VISIBLE);
            } else {
                mStage05ApexImageView.setVisibility(View.GONE);
            }

            //
            if (stage_05_accuracy != null) {

                //
                mStage05AccuracyTextView.setVisibility(View.VISIBLE);
                mStage05AccuracyTextView.setText(stage_05_accuracy);
            } else {
                mStage05AccuracyTextView.setVisibility(View.GONE);
            }

            //
            if (stage_05_predator != null) {

                //
                mStage05PredatorTextView.setVisibility(View.VISIBLE);
                mStage05PredatorTextView.setText(stage_05_predator);
            } else {
                mStage05PredatorTextView.setVisibility(View.GONE);
            }
        } else {
            mStage05LockedImageButton.setVisibility(View.VISIBLE);
        }

        // Check stage 6 progress
        if (stage_06_unlocked) {

            //
            mStage06LockedImageButton.setVisibility(View.GONE);

            // Check stage 6 scores
            if (stage_06_apex) {
                mStage06ApexImageView.setVisibility(View.VISIBLE);
            } else {
                mStage06ApexImageView.setVisibility(View.GONE);
            }

            //
            if (stage_06_accuracy != null) {

                //
                mStage06AccuracyTextView.setVisibility(View.VISIBLE);
                mStage06AccuracyTextView.setText(stage_06_accuracy);
            } else {
                mStage06AccuracyTextView.setVisibility(View.GONE);
            }

            //
            if (stage_06_predator != null) {

                //
                mStage06PredatorTextView.setVisibility(View.VISIBLE);
                mStage06PredatorTextView.setText(stage_06_predator);
            } else {
                mStage06PredatorTextView.setVisibility(View.GONE);
            }
        } else {
            mStage06LockedImageButton.setVisibility(View.VISIBLE);
        }
    }

	// Calculate percentage
	@SuppressLint("DefaultLocale")
	private static String getPercentage(int mTurns, int mEatNRunMeters) {

        //
        if (mTurns < 1) { mTurns = 1; }

        // Build and return float average of turns and hits
		float mPercentage = (100 * (float) mEatNRunMeters) / ((float) mTurns);
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
        } else if (aggression < 9) {
            aggressionScore = "hostile ";
        } else if (aggression < 12) {
            aggressionScore = "wrathful ";
        } else if (aggression < 15) {
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
		if (species < 15) {
			speciesScore = "newborn tadpole";
		} else if (species < 20) {
            speciesScore = "field mouse";
        } else if (species < 25) {
            speciesScore = "bull frog";
		} else if (species < 30) {
            speciesScore = "city pigeon";
        } else if (species < 35) {
            speciesScore = "soft-shelled crab";
		} else if (species < 40) {
            speciesScore = "jack rabbit";
		} else if (species < 50) {
            speciesScore = "lazy sloth";
		} else {
            speciesScore = "???";
		}

		// Return string
		return speciesScore;
	}

    // Reset level markers
    private void resetLevelMarkers() {

        // Replace image
        mGameLevelMarkerImageView.setBackground(versionCheck(R.drawable.level_progress_marker_empty));
    }

	// Method to end game
	private void getResults(String stage_accuracy_score, String stage_predator_score, boolean stage_apex_score) {

        // Switch to results screen
		switchScreen(R.id.results_screen_main_layout);

		// Post scores
        mResultsAccuracyTextView.setText(stage_accuracy_score);
        mResultsPredatorTextView.setText(stage_predator_score);

        //
        if (stage_apex_score) { mResultsApexImageView.setVisibility(View.VISIBLE); }
        else { mResultsApexImageView.setVisibility(View.GONE); }

        // Play outro
        playAudio(DARK_OUTRO);
    }

    // Eaten
    private void playerEaten() {

        //
        mPauseGame = true;

        // Player eaten
        switchScreen(R.id.eaten_screen_main_layout);

        // Play outro
        playAudio(HIT);
        playAudio(DARK_OUTRO);
    }

//-- ARRAY RESOURCES -->

    // Array list of screen layouts
    final private static int[] SCREENS = {

            //
            R.id.help_screen_main_layout, R.id.entry_screen_main_layout, R.id.game_screen_main_layout, R.id.results_screen_main_layout,
            R.id.intro_screen_main_layout, R.id.stage_select_screen_main_layout, R.id.eaten_screen_main_layout
    };

	// Array list of intro screen layouts
    final private static int[] INTRO = {

            //
            R.drawable.logo_beta_02, R.drawable.pretty_good_logo_02
    };

    // Array list of level marker images
    final private static int[] LEVEL_MARKERS = {

            //
            R.drawable.level_progress_marker_empty, R.drawable.level_progress_marker_01, R.drawable.level_progress_marker_02,
            R.drawable.level_progress_marker_03, R.drawable.level_progress_marker_04,R.drawable.level_progress_marker_05
    };

    // Array list of items that need event handlers
    final private static int[] CLICKABLES = {

            //
            R.id.entry_main_continue_image_button, R.id.entry_main_new_image_button, R.id.entry_main_settings_image_button, R.id.entry_main_tutorial_image_button,

            //
            R.id.help_main_return_image_button, R.id.help_main_exit_image_button, R.id.help_main_tutorial_image_button,

            //
            R.id.game_main_return_image_button, R.id.game_main_exit_image_button,

            //
            R.id.game_main_power_01_image_view, R.id.game_main_power_02_image_view, R.id.game_main_power_03_image_view,
            R.id.game_main_power_04_image_view, R.id.game_main_power_05_image_view, R.id.game_main_power_06_image_view,

            //
            R.id.game_main_pg_creature_canvas_layout, R.id.game_main_pg_boss_canvas_layout,

            //
            R.id.game_main_creature_01_image_button, R.id.game_main_creature_02_image_button, R.id.game_main_creature_03_image_button,
            R.id.game_main_creature_04_image_button, R.id.game_main_creature_05_image_button, R.id.game_main_boss_image_button,

            //
            R.id.results_main_return_image_button, R.id.results_main_exit_image_button,
            R.id.results_footer_restart_image_button, R.id.results_footer_next_image_button,

            //
            R.id.stage_select_return_image_button, R.id.select_stage_exit_image_button,

            //
            R.id.stage_select_card_01_image_layout, R.id.stage_select_card_02_image_layout, R.id.stage_select_card_03_image_layout,
            R.id.stage_select_card_04_image_layout, R.id.stage_select_card_05_image_layout, R.id.stage_select_card_06_image_layout,

            //
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
    final private static int[] ENVIRONMENTS = {

            //
            R.drawable.test_bg_01, R.drawable.test_bg_02, R.drawable.test_bg_03, R.drawable.test_bg_04, R.drawable.test_bg_05,
            R.drawable.test_bg_06, R.drawable.test_bg_07, R.drawable.test_bg_08, R.drawable.test_bg_09, R.drawable.test_bg_10,
            R.drawable.test_bg_11, R.drawable.test_bg_12, R.drawable.test_bg_13, R.drawable.test_bg_14, R.drawable.test_bg_15,
            R.drawable.test_bg_16, R.drawable.test_bg_17, R.drawable.test_bg_18, R.drawable.test_bg_19
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

    // Array list of alphas for bolt image
    final private static double[] BOLT_FADE = {

            //
            .0, .0, .1, .12, .13, .14, .15, .17, .2, .25, .3, .35, .4, .45, .5, .6, .7, .8, .9, .99, 1
    };

    // Array list of alphas for tunnel fade
    final private static double[] TUNNEL_FADE = {

            //
            1, .95, .9, .85, .8, .75, .7, .65, .6, .55, .5, .45, .4, .35, .3, .25, .2, .15, .1, .05, 0
    };
}