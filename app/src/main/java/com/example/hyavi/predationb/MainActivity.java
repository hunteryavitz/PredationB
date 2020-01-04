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

    //
    private static final String STAGE_01_APEX = "stage_01_apex";
    private static final String STAGE_01_FOOD_CHAIN = "stage_01_food_chain";
    private static final String STAGE_01_ACCURACY = "stage_01_accuracy";
    private static final String STAGE_01_CREATURE_KILLS = "stage_01_creature_kills";
    private static final String STAGE_01_BEST_TIME = "stage_01_best_time";
    private static final String STAGE_01_HIGHEST_STREAK = "stage_01_highest_streak";
    private static final String STAGE_01_CLOSEST_DEATH = "stage_01_closest_death";
    private static final String STAGE_01_LONGEST_FRENZY = "stage_01_longest_frenzy";
    private static final String STAGE_01_MOST_CALM = "stage_01_most_calm";
    private static final String STAGE_01_MOST_FRANTIC = "stage_01_most_frantic";

    //
    private static final String STAGE_01_ATTEMPTS = "stage_01_attempts";
    private static final String STAGE_01_BOSS_KILLS = "stage_01_boss_kills";
    private static final String STAGE_01_TOTAL_TIME = "stage_01_total_time";
    private static final String STAGE_01_COLLECTION = "stage_01_collection";

    //
    private static final String STAGE_01_PREDATOR_01 = "stage_01_predator_01";
    private static final String STAGE_01_PREDATOR_02 = "stage_01_predator_02";
    private static final String STAGE_01_PREDATOR_03 = "stage_01_predator_03";
    private static final String STAGE_01_PREDATOR_04 = "stage_01_predator_04";
    private static final String STAGE_01_PREDATOR_05 = "stage_01_predator_05";

    // Stage 2
    private static final String STAGE_02_COMPLETE = "stage_02_complete";

    //
    private static final String STAGE_02_APEX = "stage_02_apex";
    private static final String STAGE_02_FOOD_CHAIN = "stage_02_food_chain";
    private static final String STAGE_02_ACCURACY = "stage_02_accuracy";
    private static final String STAGE_02_CREATURE_KILLS = "stage_02_creature_kills";
    private static final String STAGE_02_BEST_TIME = "stage_02_best_time";
    private static final String STAGE_02_HIGHEST_STREAK = "stage_02_highest_streak";
    private static final String STAGE_02_CLOSEST_DEATH = "stage_02_closest_death";
    private static final String STAGE_02_LONGEST_FRENZY = "stage_02_longest_frenzy";
    private static final String STAGE_02_MOST_CALM = "stage_02_most_calm";
    private static final String STAGE_02_MOST_FRANTIC = "stage_02_most_frantic";

    //
    private static final String STAGE_02_ATTEMPTS = "stage_02_attempts";
    private static final String STAGE_02_BOSS_KILLS = "stage_02_boss_kills";
    private static final String STAGE_02_TOTAL_TIME = "stage_02_total_time";
    private static final String STAGE_02_COLLECTION = "stage_02_collection";

    //
    private static final String STAGE_02_PREDATOR_01 = "stage_02_predator_01";
    private static final String STAGE_02_PREDATOR_02 = "stage_02_predator_02";
    private static final String STAGE_02_PREDATOR_03 = "stage_02_predator_03";
    private static final String STAGE_02_PREDATOR_04 = "stage_02_predator_04";
    private static final String STAGE_02_PREDATOR_05 = "stage_02_predator_05";

    // Stage 3
    private static final String STAGE_03_COMPLETE = "stage_03_complete";

    //
    private static final String STAGE_03_APEX = "stage_03_apex";
    private static final String STAGE_03_FOOD_CHAIN = "stage_03_food_chain";
    private static final String STAGE_03_ACCURACY = "stage_03_accuracy";
    private static final String STAGE_03_CREATURE_KILLS = "stage_03_creature_kills";
    private static final String STAGE_03_BEST_TIME = "stage_03_best_time";
    private static final String STAGE_03_HIGHEST_STREAK = "stage_03_highest_streak";
    private static final String STAGE_03_CLOSEST_DEATH = "stage_03_closest_death";
    private static final String STAGE_03_LONGEST_FRENZY = "stage_03_longest_frenzy";
    private static final String STAGE_03_MOST_CALM = "stage_03_most_calm";
    private static final String STAGE_03_MOST_FRANTIC = "stage_03_most_frantic";

    //
    private static final String STAGE_03_ATTEMPTS = "stage_03_attempts";
    private static final String STAGE_03_BOSS_KILLS = "stage_03_boss_kills";
    private static final String STAGE_03_TOTAL_TIME = "stage_03_total_time";
    private static final String STAGE_03_COLLECTION = "stage_03_collection";

    //
    private static final String STAGE_03_PREDATOR_01 = "stage_03_predator_01";
    private static final String STAGE_03_PREDATOR_02 = "stage_03_predator_02";
    private static final String STAGE_03_PREDATOR_03 = "stage_03_predator_03";
    private static final String STAGE_03_PREDATOR_04 = "stage_03_predator_04";
    private static final String STAGE_03_PREDATOR_05 = "stage_03_predator_05";

    // Stage 4
    private static final String STAGE_04_COMPLETE = "stage_04_complete";

    //
    private static final String STAGE_04_APEX = "stage_04_apex";
    private static final String STAGE_04_FOOD_CHAIN = "stage_04_food_chain";
    private static final String STAGE_04_ACCURACY = "stage_04_accuracy";
    private static final String STAGE_04_CREATURE_KILLS = "stage_04_creature_kills";
    private static final String STAGE_04_BEST_TIME = "stage_04_best_time";
    private static final String STAGE_04_HIGHEST_STREAK = "stage_04_highest_streak";
    private static final String STAGE_04_CLOSEST_DEATH = "stage_04_closest_death";
    private static final String STAGE_04_LONGEST_FRENZY = "stage_04_longest_frenzy";
    private static final String STAGE_04_MOST_CALM = "stage_04_most_calm";
    private static final String STAGE_04_MOST_FRANTIC = "stage_04_most_frantic";

    //
    private static final String STAGE_04_ATTEMPTS = "stage_04_attempts";
    private static final String STAGE_04_BOSS_KILLS = "stage_04_boss_kills";
    private static final String STAGE_04_TOTAL_TIME = "stage_04_total_time";
    private static final String STAGE_04_COLLECTION = "stage_04_collection";

    //
    private static final String STAGE_04_PREDATOR_01 = "stage_04_predator_01";
    private static final String STAGE_04_PREDATOR_02 = "stage_04_predator_02";
    private static final String STAGE_04_PREDATOR_03 = "stage_04_predator_03";
    private static final String STAGE_04_PREDATOR_04 = "stage_04_predator_04";
    private static final String STAGE_04_PREDATOR_05 = "stage_04_predator_05";

    // Stage 5
    private static final String STAGE_05_COMPLETE = "stage_05_complete";

    //
    private static final String STAGE_05_APEX = "stage_05_apex";
    private static final String STAGE_05_FOOD_CHAIN = "stage_05_food_chain";
    private static final String STAGE_05_ACCURACY = "stage_05_accuracy";
    private static final String STAGE_05_CREATURE_KILLS = "stage_05_creature_kills";
    private static final String STAGE_05_BEST_TIME = "stage_05_best_time";
    private static final String STAGE_05_HIGHEST_STREAK = "stage_05_highest_streak";
    private static final String STAGE_05_CLOSEST_DEATH = "stage_05_closest_death";
    private static final String STAGE_05_LONGEST_FRENZY = "stage_05_longest_frenzy";
    private static final String STAGE_05_MOST_CALM = "stage_05_most_calm";
    private static final String STAGE_05_MOST_FRANTIC = "stage_05_most_frantic";

    //
    private static final String STAGE_05_ATTEMPTS = "stage_05_attempts";
    private static final String STAGE_05_BOSS_KILLS = "stage_05_boss_kills";
    private static final String STAGE_05_TOTAL_TIME = "stage_05_total_time";
    private static final String STAGE_05_COLLECTION = "stage_05_collection";

    //
    private static final String STAGE_05_PREDATOR_01 = "stage_05_predator_01";
    private static final String STAGE_05_PREDATOR_02 = "stage_05_predator_02";
    private static final String STAGE_05_PREDATOR_03 = "stage_05_predator_03";
    private static final String STAGE_05_PREDATOR_04 = "stage_05_predator_04";
    private static final String STAGE_05_PREDATOR_05 = "stage_05_predator_05";

    // Stage 6
    private static final String STAGE_06_COMPLETE = "stage_06_complete";

    //
    private static final String STAGE_06_APEX = "stage_06_apex";
    private static final String STAGE_06_FOOD_CHAIN = "stage_06_food_chain";
    private static final String STAGE_06_ACCURACY = "stage_06_accuracy";
    private static final String STAGE_06_CREATURE_KILLS = "stage_06_creature_kills";
    private static final String STAGE_06_BEST_TIME = "stage_06_best_time";
    private static final String STAGE_06_HIGHEST_STREAK = "stage_06_highest_streak";
    private static final String STAGE_06_CLOSEST_DEATH = "stage_06_closest_death";
    private static final String STAGE_06_LONGEST_FRENZY = "stage_06_longest_frenzy";
    private static final String STAGE_06_MOST_CALM = "stage_06_most_calm";
    private static final String STAGE_06_MOST_FRANTIC = "stage_06_most_frantic";

    //
    private static final String STAGE_06_ATTEMPTS = "stage_06_attempts";
    private static final String STAGE_06_BOSS_KILLS = "stage_06_boss_kills";
    private static final String STAGE_06_TOTAL_TIME = "stage_06_total_time";
    private static final String STAGE_06_COLLECTION = "stage_06_collection";

    //
    private static final String STAGE_06_PREDATOR_01 = "stage_06_predator_01";
    private static final String STAGE_06_PREDATOR_02 = "stage_06_predator_02";
    private static final String STAGE_06_PREDATOR_03 = "stage_06_predator_03";
    private static final String STAGE_06_PREDATOR_04 = "stage_06_predator_04";
    private static final String STAGE_06_PREDATOR_05 = "stage_06_predator_05";

    // Stage 7
    private static final String STAGE_07_COMPLETE = "stage_07_complete";

    //
    private static final String STAGE_07_APEX = "stage_07_apex";
    private static final String STAGE_07_FOOD_CHAIN = "stage_07_food_chain";
    private static final String STAGE_07_ACCURACY = "stage_07_accuracy";
    private static final String STAGE_07_CREATURE_KILLS = "stage_07_creature_kills";
    private static final String STAGE_07_BEST_TIME = "stage_07_best_time";
    private static final String STAGE_07_HIGHEST_STREAK = "stage_07_highest_streak";
    private static final String STAGE_07_CLOSEST_DEATH = "stage_07_closest_death";
    private static final String STAGE_07_LONGEST_FRENZY = "stage_07_longest_frenzy";
    private static final String STAGE_07_MOST_CALM = "stage_07_most_calm";
    private static final String STAGE_07_MOST_FRANTIC = "stage_07_most_frantic";

    //
    private static final String STAGE_07_ATTEMPTS = "stage_07_attempts";
    private static final String STAGE_07_BOSS_KILLS = "stage_07_boss_kills";
    private static final String STAGE_07_TOTAL_TIME = "stage_07_total_time";
    private static final String STAGE_07_COLLECTION = "stage_07_collection";

    //
    private static final String STAGE_07_PREDATOR_01 = "stage_07_predator_01";
    private static final String STAGE_07_PREDATOR_02 = "stage_07_predator_02";
    private static final String STAGE_07_PREDATOR_03 = "stage_07_predator_03";
    private static final String STAGE_07_PREDATOR_04 = "stage_07_predator_04";
    private static final String STAGE_07_PREDATOR_05 = "stage_07_predator_05";

//-- GLOBAL DYNAMIC VIEWS -->

//-- INTRO -->

    // Intro / Outro views
    private ImageView mCreditsImageView;

//-- ENTRY -->

    // Entry views
    private LinearLayout mEntryMainControlLayout;

    // Entry buttons
    private ImageButton mEntryContinueImageButton;
    private ImageButton mEntryCreditsImageButton;

//-- STAGE SELECT -->

    // Toggle Secret Button
    private ImageButton mStageSelectSecretImageButton;

    // Toggle Button Highlights
    private ImageButton mStageSelectTrophycaseImageButton;
    private ImageButton mStageSelectScorecardImageButton;
    private ImageButton mStageSelectContentImageButton;

    // Toggle Layout Views
    private LinearLayout mStageSelectTrophycaseLayout;
    private LinearLayout mStageSelectScorecardLayout;
    private LinearLayout mStageSelectContentLayout;

    // Populate Progress Bars
    private ProgressBar mStageSelectTrophycaseProgressBar;
    private ProgressBar mStageSelectScorecardProgressBar;
    private ProgressBar mStageSelectContentProgressBar;

    // Populate Progress Text Views
    private TextView mStageSelectTrophycaseProgressTextView;
    private TextView mStageSelectScorecardProgressTextView;
    private TextView mStageSelectContentProgressTextView;

    // Dialogue Layout
    private LinearLayout mStageSelectDialogueLayout;

//-- CONTENT -->

    // Populate Content Title Text View
    private ImageView mStageSelectContentStage01TitleImageView;
    private ImageView mStageSelectContentStage02TitleImageView;
    private ImageView mStageSelectContentStage03TitleImageView;
    private ImageView mStageSelectContentStage04TitleImageView;
    private ImageView mStageSelectContentStage05TitleImageView;
    private ImageView mStageSelectContentStage06TitleImageView;
    private ImageView mStageSelectContentStage07TitleImageView;

    // Populate Content Status Image Button
    private ImageView mStageSelectContentStage01StatusImageButton;
    private ImageView mStageSelectContentStage02StatusImageButton;
    private ImageView mStageSelectContentStage03StatusImageButton;
    private ImageView mStageSelectContentStage04StatusImageButton;
    private ImageView mStageSelectContentStage05StatusImageButton;
    private ImageView mStageSelectContentStage06StatusImageButton;
    private ImageView mStageSelectContentStage07StatusImageButton;

    // Populate Content Stage Color
    private LinearLayout mStageSelectContentStage01ColorLayout;
    private LinearLayout mStageSelectContentStage02ColorLayout;
    private LinearLayout mStageSelectContentStage03ColorLayout;
    private LinearLayout mStageSelectContentStage04ColorLayout;
    private LinearLayout mStageSelectContentStage05ColorLayout;
    private LinearLayout mStageSelectContentStage06ColorLayout;
    private LinearLayout mStageSelectContentStage07ColorLayout;

    // Populate Content Stage BG
    private LinearLayout mStageSelectContentStage01BGLayout;
    private LinearLayout mStageSelectContentStage02BGLayout;
    private LinearLayout mStageSelectContentStage03BGLayout;
    private LinearLayout mStageSelectContentStage04BGLayout;
    private LinearLayout mStageSelectContentStage05BGLayout;
    private LinearLayout mStageSelectContentStage06BGLayout;
    private LinearLayout mStageSelectContentStage07BGLayout;

    // Populate Content Stage Status Text View
    private TextView mStageSelectContentStage01StatusTextView;
    private TextView mStageSelectContentStage02StatusTextView;
    private TextView mStageSelectContentStage03StatusTextView;
    private TextView mStageSelectContentStage04StatusTextView;
    private TextView mStageSelectContentStage05StatusTextView;
    private TextView mStageSelectContentStage06StatusTextView;
    private TextView mStageSelectContentStage07StatusTextView;

    // Populate Content Stage Progress Bar
    private ProgressBar mStageSelectContentStage01ProgressBar;
    private ProgressBar mStageSelectContentStage02ProgressBar;
    private ProgressBar mStageSelectContentStage03ProgressBar;
    private ProgressBar mStageSelectContentStage04ProgressBar;
    private ProgressBar mStageSelectContentStage05ProgressBar;
    private ProgressBar mStageSelectContentStage06ProgressBar;
    private ProgressBar mStageSelectContentStage07ProgressBar;

    // Populate Content Stage Progress Text View
    private TextView mStageSelectContentStage01ProgressTextView;
    private TextView mStageSelectContentStage02ProgressTextView;
    private TextView mStageSelectContentStage03ProgressTextView;
    private TextView mStageSelectContentStage04ProgressTextView;
    private TextView mStageSelectContentStage05ProgressTextView;
    private TextView mStageSelectContentStage06ProgressTextView;
    private TextView mStageSelectContentStage07ProgressTextView;

//-- SCORECARD -->

    // Toggle Scorecard Layout Visibility
    private LinearLayout mStageSelectScorecardApexLayout;
    private LinearLayout mStageSelectScorecardPredatorLayout;
    private LinearLayout mStageSelectScorecardAccuracyLayout;
    private LinearLayout mStageSelectScorecardTimeLayout;
    private LinearLayout mStageSelectScorecardKillsLayout;
    private LinearLayout mStageSelectScorecardStreakLayout;
    private LinearLayout mStageSelectScorecardDeathLayout;
    private LinearLayout mStageSelectScorecardFrenzyLayout;
    private LinearLayout mStageSelectScorecardCalmLayout;
    private LinearLayout mStageSelectScorecardFranticLayout;

    // Toggle Scorecard Image View Badge Type
    private ImageView mStageSelectScorecardApexBadgeImageView;
    private ImageView mStageSelectScorecardPredatorBadgeImageView;
    private ImageView mStageSelectScorecardAccuracyBadgeImageView;
    private ImageView mStageSelectScorecardTimeBadgeImageView;
    private ImageView mStageSelectScorecardKillsBadgeImageView;
    private ImageView mStageSelectScorecardStreakBadgeImageView;
    private ImageView mStageSelectScorecardDeathBadgeImageView;
    private ImageView mStageSelectScorecardFrenzyBadgeImageView;
    private ImageView mStageSelectScorecardCalmBadgeImageView;
    private ImageView mStageSelectScorecardFranticBadgeImageView;

//-- TROPHYCASE -->

    // Toggle Trophycase Layout Visibility
    private LinearLayout mStageSelectTrophycaseStage01Layout;
    private LinearLayout mStageSelectTrophycaseStage02Layout;
    private LinearLayout mStageSelectTrophycaseStage03Layout;
    private LinearLayout mStageSelectTrophycaseStage04Layout;
    private LinearLayout mStageSelectTrophycaseStage05Layout;
    private LinearLayout mStageSelectTrophycaseStage06Layout;
    private LinearLayout mStageSelectTrophycaseStage07Layout;

    // Toggle Trophycase Image View Trophy *Maybe Unnecessary*
    private ImageView mStageSelectTrophycaseStage01TrophyImageView;
    private ImageView mStageSelectTrophycaseStage02TrophyImageView;
    private ImageView mStageSelectTrophycaseStage03TrophyImageView;
    private ImageView mStageSelectTrophycaseStage04TrophyImageView;
    private ImageView mStageSelectTrophycaseStage05TrophyImageView;
    private ImageView mStageSelectTrophycaseStage06TrophyImageView;
    private ImageView mStageSelectTrophycaseStage07TrophyImageView;

//-- STAGE CARD -->

    // Control Image Buttons
    private ImageButton mStageCardTrophycaseImageButton;
    private ImageButton mStageCardScorecardImageButton;
    private ImageButton mStageCardContentImageButton;

    // Content Layouts - Button Linked
    private LinearLayout mStageCardTrophycaseLayout;
    private LinearLayout mStageCardScorecardLayout;
    private LinearLayout mStageCardContentLayout;

    // Content Layouts - Event Linked
    private LinearLayout mStageCardCompleteLayout;
    private LinearLayout mStageCardEatenLayout;
    private LinearLayout mStageCardLockedLayout;

    // Dynamic BG
    private LinearLayout mStageCardScreenBodyLayout;

    //
    private LinearLayout mStageCardContentTitleLayout;
    private ImageButton mStageCardContentTitleImageButton;
    private TextView mStageCardBossNameTextView;

    //
    private ImageView mStageCardBossImageView;
    private ImageView mStageCardPowerImageView;
    private ImageView mStageCardDisasterImageView;

    //
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
    private LinearLayout mStageCardTopPredatorLayout;
    private LinearLayout mStageCardTopAccuracyLayout;
    private LinearLayout mStageCardTopTimeLayout;
    private LinearLayout mStageCardTopEatenLayout;
    private LinearLayout mStageCardTopStreakLayout;
    private LinearLayout mStageCardTopDeathLayout;
    private LinearLayout mStageCardTopFrenzyLayout;
    private LinearLayout mStageCardTopCalmLayout;
    private LinearLayout mStageCardTopFranticLayout;

    // StageCard creature collection - Stage top scores
    private ImageView mCreature01ImageView;
    private ImageView mCreature02ImageView;
    private ImageView mCreature03ImageView;
    private ImageView mCreature04ImageView;
    private ImageView mCreature05ImageView;

    // StageCard switch card controls
    public ImageButton mStageCardControlPrevImageButton;
    public ImageButton mStageCardControlNextImageButton;

//-- GAME -->

    //
    private ImageView mGameStageImageView;
    private ImageView mGameSceneImageView;

    //
    private LinearLayout mGameHeaderControlLayout;

    //
    private LinearLayout mGameBoard01ThumbnailLayout;
    private LinearLayout mGameBoard02ThumbnailLayout;
    private LinearLayout mGameBoard03ThumbnailLayout;
    private LinearLayout mGameBoard04ThumbnailLayout;
    private LinearLayout mGameBoard05ThumbnailLayout;

    //
    private ImageView mGamePredator01ThumbnailImageView;
    private ImageView mGamePredator02ThumbnailImageView;
    private ImageView mGamePredator03ThumbnailImageView;
    private ImageView mGamePredator04ThumbnailImageView;
    private ImageView mGamePredator05ThumbnailImageView;

    //
    private LinearLayout mGameAdrenalineLayout;
    private LinearLayout mGameBossThumbnailImageButton;

    //
    private ProgressBar mGameMainTapoutMeterProgressBar;

    // Game creature playground
    private FrameLayout mGameCreatureLayout;

    // Game creatures
    private ImageButton mGameCreature01ImageButton;
    private ImageButton mGameCreature02ImageButton;
    private ImageButton mGameCreature03ImageButton;
    private ImageButton mGameCreature04ImageButton;
    private ImageButton mGameCreature05ImageButton;

    //
    private ImageView mGameSplatter01ImageView;
    private ImageView mGameSplatter02ImageView;
    private ImageView mGameSplatter03ImageView;
    private ImageView mGameSplatter04ImageView;
    private ImageView mGameSplatter05ImageView;

    //
    private ImageButton mGamePredatorImageButton;

    // Game boss
    private ImageButton mGameBossImageButton;

    //
    private ProgressBar mGameBossHealthProgressBar;
    private ProgressBar mGameUserHealthProgressBar;

    //
    private LinearLayout mGameFooterControlLayout;

    //
    private ProgressBar mGameMainHungerMeterProgressBar;

    // Game footer user interfaces
    private ImageButton mGamePower01ImageButton;
    private ImageButton mGamePower02ImageButton;
    private ImageButton mGamePower03ImageButton;
    private ImageButton mGamePower04ImageButton;
    private ImageButton mGamePower05ImageButton;
    private ImageButton mGamePower06ImageButton;

    //
    private RelativeLayout mGameBittenLayout;

    //
    private RelativeLayout mGameDisasterLayout;

    // Game stage border
    private RelativeLayout mGameBorderLayout;

    // Game stage tunnel
    private RelativeLayout mGameTunnelVisionLayout;

//-- LOAD -->

    //
    private TextView mLoadRandomScoreTitleTextView;
    private TextView mLoadRandomScoreValueTextView;

//-- GENERAL -->

    // Fades
    private RelativeLayout mGameFlashLayout;
    private RelativeLayout mGameBlackoutLayout;

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
    private static boolean stage_01_apex;
    private static int stage_01_food_chain;
    private static float stage_01_accuracy;
    private static int stage_01_creature_kills;
    private static int stage_01_best_time;

    //
    private static int stage_01_highest_streak;
    private static int stage_01_closest_death;
    private static int stage_01_longest_frenzy;
    private static long stage_01_most_calm;
    private static long stage_01_most_frantic;

    //
    private static int stage_01_attempts;
    private static int stage_01_boss_kills;
    private static int stage_01_total_time;
    private static int stage_01_collection;

    //
    private static boolean stage_02_complete; // -> if (stage_02_complete) {boolean stage_03_unlocked = true;}

    // Top scores - stage 2
    private static boolean stage_02_apex;
    private static int stage_02_food_chain;
    private static float stage_02_accuracy;
    private static int stage_02_creature_kills;
    private static int stage_02_best_time;

    //
    private static int stage_02_highest_streak;
    private static int stage_02_closest_death;
    private static int stage_02_longest_frenzy;
    private static long stage_02_most_calm;
    private static long stage_02_most_frantic;

    //
    private static int stage_02_attempts;
    private static int stage_02_boss_kills;
    private static int stage_02_total_time;
    private static int stage_02_collection;

    //
    private static boolean stage_03_complete; // -> if (stage_03_complete) {boolean stage_04_unlocked = true;}

    // Top scores - stage 3
    private static boolean stage_03_apex;
    private static int stage_03_food_chain;
    private static float stage_03_accuracy;
    private static int stage_03_creature_kills;
    private static int stage_03_best_time;

    //
    private static int stage_03_highest_streak;
    private static int stage_03_closest_death;
    private static int stage_03_longest_frenzy;
    private static long stage_03_most_calm;
    private static long stage_03_most_frantic;

    //
    private static int stage_03_attempts;
    private static int stage_03_boss_kills;
    private static int stage_03_total_time;
    private static int stage_03_collection;

    //
    private static boolean stage_04_complete; // -> if (stage_04_complete) {boolean stage_05_unlocked = true;}

    // Top scores - stage 4
    private static boolean stage_04_apex;
    private static int stage_04_food_chain;
    private static float stage_04_accuracy;
    private static int stage_04_creature_kills;
    private static int stage_04_best_time;

    //
    private static int stage_04_highest_streak;
    private static int stage_04_closest_death;
    private static int stage_04_longest_frenzy;
    private static long stage_04_most_calm;
    private static long stage_04_most_frantic;

    //
    private static int stage_04_attempts;
    private static int stage_04_boss_kills;
    private static int stage_04_total_time;
    private static int stage_04_collection;

    //
    private static boolean stage_05_complete; // -> if (stage_05_complete) {boolean stage_06_unlocked = true;}

    // Top scores - stage 5
    private static boolean stage_05_apex;
    private static int stage_05_food_chain;
    private static float stage_05_accuracy;
    private static int stage_05_creature_kills;
    private static int stage_05_best_time;

    //
    private static int stage_05_highest_streak;
    private static int stage_05_closest_death;
    private static int stage_05_longest_frenzy;
    private static long stage_05_most_calm;
    private static long stage_05_most_frantic;

    //
    private static int stage_05_attempts;
    private static int stage_05_boss_kills;
    private static int stage_05_total_time;
    private static int stage_05_collection;

    //
    private static boolean stage_06_complete; // -> if (stage_06_complete) {boolean stage_final_boss_unlocked = true;}

    // Top scores - stage 6
    private static boolean stage_06_apex;
    private static int stage_06_food_chain;
    private static float stage_06_accuracy;
    private static int stage_06_creature_kills;
    private static int stage_06_best_time;

    //
    private static int stage_06_highest_streak;
    private static int stage_06_closest_death;
    private static int stage_06_longest_frenzy;
    private static long stage_06_most_calm;
    private static long stage_06_most_frantic;

    //
    private static int stage_06_attempts;
    private static int stage_06_boss_kills;
    private static int stage_06_total_time;
    private static int stage_06_collection;

    //
    private static boolean stage_07_complete; // -> if (stage_final_boss_complete) {boolean game_complete = true;}

    // Top scores - stage 7
    private static boolean stage_07_apex;
    private static int stage_07_food_chain;
    private static float stage_07_accuracy;
    private static int stage_07_creature_kills;
    private static int stage_07_best_time;

    //
    private static int stage_07_highest_streak;
    private static int stage_07_closest_death;
    private static int stage_07_longest_frenzy;
    private static long stage_07_most_calm;
    private static long stage_07_most_frantic;

    //
    private static int stage_07_attempts;
    private static int stage_07_boss_kills;
    private static int stage_07_total_time;
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
    private static boolean mTrophycase = false;
    private static boolean mScorecard = false;
    public static boolean mContent = false;

    // Stage ready [1 = Locked, 2 = Ready, 3 = Complete]
    private static int mStageReady = 1;
    private static boolean mStageComplete = false;

    // Variables for tap meter
    private static int mTapBarrel;
    private static int mTapCount;
    private static int mStreakCount;
    private static int mTapTotal;

    //
    private static int mBittenMeter;

    // Timers
    private static int mPauseTimer;
    private static int mStageTimer;
    public static int mStageHeartbeat;

    // Universal variables
    private static long mSpeedIndex;
    private static int mHungerMeter = 0;

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

    //
    private static int mStageFrenzy;

    // Stage scores - calculate at end stage
    private static boolean mStageApex = false;
    private static int mStageFoodChain;
    private static float mStageAccuracy;
    private static int mStageTime;
    private static int mStageCreatureKills;
    private static int mStageHighestStreak;
    private static int mStageClosestDeath;
    private static int mStageLongestFrenzy;
    private static long mStageMostCalm;
    private static long mStageMostFrantic;

    // Global scores - calculate at screen load
    private static boolean mGameApex;
    private static int mGameFoodChain;
    private static float mGameAccuracy;
    private static boolean mGameTimeBest;
    private static int mGameCreatureKills;
    private static int mGameHighestStreak;
    private static int mGameClosestDeath;
    private static int mGameLongestFrenzy;
    private static long mGameMostCalm;
    private static long mGameMostFrantic;

    //
    private static int mGameAttempts;
    private static int mGameBossKills;
    private static int mGameTimeTotal;

    //
    private static int mTurn;

    //
    private static int mBossHealth;

    //
    private static List<Integer> mStageSceneImages = new ArrayList<>();
    private static List<Integer> mStageSceneNames = new ArrayList<>();
    public static int mEnvironmentID;

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
    ArrayList<Boolean> stage_01_top_predators_previous = new ArrayList<Boolean>() {};
    ArrayList<Boolean> stage_02_top_predators_previous = new ArrayList<Boolean>() {};
    ArrayList<Boolean> stage_03_top_predators_previous = new ArrayList<Boolean>() {};
    ArrayList<Boolean> stage_04_top_predators_previous = new ArrayList<Boolean>() {};
    ArrayList<Boolean> stage_05_top_predators_previous = new ArrayList<Boolean>() {};
    ArrayList<Boolean> stage_06_top_predators_previous = new ArrayList<Boolean>() {};
    ArrayList<Boolean> stage_07_top_predators_previous = new ArrayList<Boolean>() {};

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
                            moveCreature(R.id.game_boss_image_button, R.id.game_main_pg_creature_canvas_layout);

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

// CREDITS SCREEN

        // Carousel
        mCreditsImageView = findViewById(R.id.credits_image_view);

// ENTRY SCREEN

        // Animation
        mEntryMainControlLayout = findViewById(R.id.entry_main_control_layout);

        // Toggle Button Visibility
        mEntryContinueImageButton = findViewById(R.id.entry_main_continue_image_button);
        mEntryCreditsImageButton = findViewById(R.id.entry_main_credits_image_button);

// STAGE SELECT SCREEN

        // Toggle Secret Button Visibility
        mStageSelectSecretImageButton = findViewById(R.id.stage_select_header_secret_image_button);

        // Toggle Button Highlights
        mStageSelectTrophycaseImageButton = findViewById(R.id.stage_select_trophycase_image_button);
        mStageSelectScorecardImageButton = findViewById(R.id.stage_select_scorecard_image_button);
        mStageSelectContentImageButton = findViewById(R.id.stage_select_content_image_button);

        // Toggle Layout Views
        mStageSelectTrophycaseLayout = findViewById(R.id.stage_select_trophycase_layout);
        mStageSelectScorecardLayout = findViewById(R.id.stage_select_scorecard_layout);
        mStageSelectContentLayout = findViewById(R.id.stage_select_content_layout);

        // Populate Progress Bars
        mStageSelectTrophycaseProgressBar = findViewById(R.id.stage_select_trophycase_progress_bar);
        mStageSelectScorecardProgressBar = findViewById(R.id.stage_select_scorecard_progress_bar);
        mStageSelectContentProgressBar = findViewById(R.id.stage_select_content_progress_bar);

        // Populate Progress Text Views
        mStageSelectTrophycaseProgressTextView = findViewById(R.id.stage_select_trophycase_progress_text_view);
        mStageSelectScorecardProgressTextView = findViewById(R.id.stage_select_scorecard_progress_text_view);
        mStageSelectContentProgressTextView = findViewById(R.id.stage_select_content_progress_text_view);

        // Dialogue Layout
        mStageSelectDialogueLayout = findViewById(R.id.stage_select_score_layout);

        // Content Layouts
        mStageSelectContentStage01TitleImageView = findViewById(R.id.stage_select_content_title_01_image_view);
        mStageSelectContentStage02TitleImageView = findViewById(R.id.stage_select_content_title_02_image_view);
        mStageSelectContentStage03TitleImageView = findViewById(R.id.stage_select_content_title_03_image_view);
        mStageSelectContentStage04TitleImageView = findViewById(R.id.stage_select_content_title_04_image_view);
        mStageSelectContentStage05TitleImageView = findViewById(R.id.stage_select_content_title_05_image_view);
        mStageSelectContentStage06TitleImageView = findViewById(R.id.stage_select_content_title_06_image_view);
        mStageSelectContentStage07TitleImageView = findViewById(R.id.stage_select_content_title_07_image_view);

        //
        mStageSelectContentStage01StatusImageButton = findViewById(R.id.stage_select_content_status_01_image_button);
        mStageSelectContentStage02StatusImageButton = findViewById(R.id.stage_select_content_status_02_image_button);
        mStageSelectContentStage03StatusImageButton = findViewById(R.id.stage_select_content_status_03_image_button);
        mStageSelectContentStage04StatusImageButton = findViewById(R.id.stage_select_content_status_04_image_button);
        mStageSelectContentStage05StatusImageButton = findViewById(R.id.stage_select_content_status_05_image_button);
        mStageSelectContentStage06StatusImageButton = findViewById(R.id.stage_select_content_status_06_image_button);
        mStageSelectContentStage07StatusImageButton = findViewById(R.id.stage_select_content_status_07_image_button);

        //
        mStageSelectContentStage01BGLayout = findViewById(R.id.stage_select_content_stage_01_header_layout);
        mStageSelectContentStage02BGLayout = findViewById(R.id.stage_select_content_stage_02_header_layout);
        mStageSelectContentStage03BGLayout = findViewById(R.id.stage_select_content_stage_03_header_layout);
        mStageSelectContentStage04BGLayout = findViewById(R.id.stage_select_content_stage_04_header_layout);
        mStageSelectContentStage05BGLayout = findViewById(R.id.stage_select_content_stage_05_header_layout);
        mStageSelectContentStage06BGLayout = findViewById(R.id.stage_select_content_stage_06_header_layout);
        mStageSelectContentStage07BGLayout = findViewById(R.id.stage_select_content_stage_07_header_layout);

        //
        mStageSelectContentStage01ColorLayout = findViewById(R.id.stage_select_content_card_01_layout);
        mStageSelectContentStage02ColorLayout = findViewById(R.id.stage_select_content_card_02_layout);
        mStageSelectContentStage03ColorLayout = findViewById(R.id.stage_select_content_card_03_layout);
        mStageSelectContentStage04ColorLayout = findViewById(R.id.stage_select_content_card_04_layout);
        mStageSelectContentStage05ColorLayout = findViewById(R.id.stage_select_content_card_05_layout);
        mStageSelectContentStage06ColorLayout = findViewById(R.id.stage_select_content_card_06_layout);
        mStageSelectContentStage07ColorLayout = findViewById(R.id.stage_select_content_card_07_layout);

        //
        mStageSelectContentStage01StatusTextView = findViewById(R.id.stage_select_content_status_01_text_view);
        mStageSelectContentStage02StatusTextView = findViewById(R.id.stage_select_content_status_02_text_view);
        mStageSelectContentStage03StatusTextView = findViewById(R.id.stage_select_content_status_03_text_view);
        mStageSelectContentStage04StatusTextView = findViewById(R.id.stage_select_content_status_04_text_view);
        mStageSelectContentStage05StatusTextView = findViewById(R.id.stage_select_content_status_05_text_view);
        mStageSelectContentStage06StatusTextView = findViewById(R.id.stage_select_content_status_06_text_view);
        mStageSelectContentStage07StatusTextView = findViewById(R.id.stage_select_content_status_07_text_view);

        //
        mStageSelectContentStage01ProgressBar = findViewById(R.id.stage_select_content_status_01_progress_bar);
        mStageSelectContentStage02ProgressBar = findViewById(R.id.stage_select_content_status_02_progress_bar);
        mStageSelectContentStage03ProgressBar = findViewById(R.id.stage_select_content_status_03_progress_bar);
        mStageSelectContentStage04ProgressBar = findViewById(R.id.stage_select_content_status_04_progress_bar);
        mStageSelectContentStage05ProgressBar = findViewById(R.id.stage_select_content_status_05_progress_bar);
        mStageSelectContentStage06ProgressBar = findViewById(R.id.stage_select_content_status_06_progress_bar);
        mStageSelectContentStage07ProgressBar = findViewById(R.id.stage_select_content_status_07_progress_bar);

        //
        mStageSelectContentStage01ProgressTextView = findViewById(R.id.stage_select_content_progress_01_text_view);
        mStageSelectContentStage02ProgressTextView = findViewById(R.id.stage_select_content_progress_02_text_view);
        mStageSelectContentStage03ProgressTextView = findViewById(R.id.stage_select_content_progress_03_text_view);
        mStageSelectContentStage04ProgressTextView = findViewById(R.id.stage_select_content_progress_04_text_view);
        mStageSelectContentStage05ProgressTextView = findViewById(R.id.stage_select_content_progress_05_text_view);
        mStageSelectContentStage06ProgressTextView = findViewById(R.id.stage_select_content_progress_06_text_view);
        mStageSelectContentStage07ProgressTextView = findViewById(R.id.stage_select_content_progress_07_text_view);

        // Scorecard Layouts
        mStageSelectScorecardApexLayout = findViewById(R.id.stage_select_score_apex_layout);
        mStageSelectScorecardPredatorLayout = findViewById(R.id.stage_select_score_predator_layout);
        mStageSelectScorecardAccuracyLayout = findViewById(R.id.stage_select_score_accuracy_layout);
        mStageSelectScorecardTimeLayout = findViewById(R.id.stage_select_score_time_layout);
        mStageSelectScorecardKillsLayout = findViewById(R.id.stage_select_score_creatures_layout);
        mStageSelectScorecardStreakLayout = findViewById(R.id.stage_select_score_streak_layout);
        mStageSelectScorecardDeathLayout = findViewById(R.id.stage_select_score_death_layout);
        mStageSelectScorecardFrenzyLayout = findViewById(R.id.stage_select_score_frenzy_layout);
        mStageSelectScorecardCalmLayout = findViewById(R.id.stage_select_score_calm_layout);
        mStageSelectScorecardFranticLayout = findViewById(R.id.stage_select_score_frantic_layout);

        // Scorecard Badge Type Image Views
        mStageSelectScorecardApexBadgeImageView = findViewById(R.id.stage_select_score_apex_badge_image_view);
        mStageSelectScorecardPredatorBadgeImageView = findViewById(R.id.stage_select_score_predator_badge_image_view);
        mStageSelectScorecardAccuracyBadgeImageView = findViewById(R.id.stage_select_score_accuracy_badge_image_view);
        mStageSelectScorecardTimeBadgeImageView = findViewById(R.id.stage_select_score_time_badge_image_view);
        mStageSelectScorecardKillsBadgeImageView = findViewById(R.id.stage_select_score_creatures_badge_image_view);
        mStageSelectScorecardStreakBadgeImageView = findViewById(R.id.stage_select_score_streak_badge_image_view);
        mStageSelectScorecardDeathBadgeImageView = findViewById(R.id.stage_select_score_death_badge_image_view);
        mStageSelectScorecardFrenzyBadgeImageView = findViewById(R.id.stage_select_score_frenzy_badge_image_view);
        mStageSelectScorecardCalmBadgeImageView = findViewById(R.id.stage_select_score_calm_badge_image_view);
        mStageSelectScorecardFranticBadgeImageView = findViewById(R.id.stage_select_score_frantic_badge_image_view);

        // Trophycase Layouts
        mStageSelectTrophycaseStage01Layout = findViewById(R.id.stage_select_trophy_01_layout);
        mStageSelectTrophycaseStage02Layout = findViewById(R.id.stage_select_trophy_02_layout);
        mStageSelectTrophycaseStage03Layout = findViewById(R.id.stage_select_trophy_03_layout);
        mStageSelectTrophycaseStage04Layout = findViewById(R.id.stage_select_trophy_04_layout);
        mStageSelectTrophycaseStage05Layout = findViewById(R.id.stage_select_trophy_05_layout);
        mStageSelectTrophycaseStage06Layout = findViewById(R.id.stage_select_trophy_06_layout);
        mStageSelectTrophycaseStage07Layout = findViewById(R.id.stage_select_trophy_07_layout);

        // Trophycase Image Views *Maybe Unnecessary*
        mStageSelectTrophycaseStage01TrophyImageView = findViewById(R.id.stage_select_trophy_01_image_view);
        mStageSelectTrophycaseStage02TrophyImageView = findViewById(R.id.stage_select_trophy_02_image_view);
        mStageSelectTrophycaseStage03TrophyImageView = findViewById(R.id.stage_select_trophy_03_image_view);
        mStageSelectTrophycaseStage04TrophyImageView = findViewById(R.id.stage_select_trophy_04_image_view);
        mStageSelectTrophycaseStage05TrophyImageView = findViewById(R.id.stage_select_trophy_05_image_view);
        mStageSelectTrophycaseStage06TrophyImageView = findViewById(R.id.stage_select_trophy_06_image_view);
        mStageSelectTrophycaseStage07TrophyImageView = findViewById(R.id.stage_select_trophy_07_image_view);

// STAGE CARD SCREEN

        //
        mStageCardTrophycaseImageButton = findViewById(R.id.stage_card_trophycase_image_button);
        mStageCardScorecardImageButton = findViewById(R.id.stage_card_scorecard_image_button);
        mStageCardContentImageButton = findViewById(R.id.stage_card_content_image_button);

        //
        mStageCardScreenBodyLayout = findViewById(R.id.stage_card_screen_main_layout);

        //
        mStageCardContentTitleLayout = findViewById(R.id.stage_card_control_layout);
        mStageCardContentTitleImageButton = findViewById(R.id.stage_card_title_image_view);
        mStageCardBossNameTextView = findViewById(R.id.stage_card_boss_title_text_view);

        //
        mStageCardDisasterImageView = findViewById(R.id.stage_card_disaster_image_view);
        mStageCardPowerImageView = findViewById(R.id.stage_card_power_image_view);
        mStageCardBossImageView = findViewById(R.id.stage_card_boss_image_view);

        //
        mStageCardTrophycaseLayout = findViewById(R.id.stage_card_trophycase_layout);
        mStageCardScorecardLayout = findViewById(R.id.stage_card_scorecard_layout);
        mStageCardContentLayout = findViewById(R.id.stage_card_content_layout);

        //
        mStageCardCompleteLayout = findViewById(R.id.stage_card_complete_layout);
        mStageCardLockedLayout = findViewById(R.id.stage_card_locked_layout);
        mStageCardEatenLayout = findViewById(R.id.stage_card_eaten_layout);

        //
        mStageTopPredatorBadgeImageView = findViewById(R.id.stage_card_scorecard_predator_badge_image_view);
        mStageTopAccuracyBadgeImageView = findViewById(R.id.stage_card_scorecard_accuracy_badge_image_view);
        mStageTopBestTimeBadgeImageView = findViewById(R.id.stage_card_scorecard_time_badge_image_view);
        mStageTotalCreatureKillsBadgeImageView = findViewById(R.id.stage_card_scorecard_kills_badge_image_view);
        mStageTopHighStreakBadgeImageView = findViewById(R.id.stage_card_scorecard_streak_badge_image_view);
        mStageTopCloseDeathBadgeImageView = findViewById(R.id.stage_card_scorecard_death_badge_image_view);
        mStageTopLongFrenzyBadgeImageView = findViewById(R.id.stage_card_scorecard_frenzy_badge_image_view);
        mStageTopMostCalmBadgeImageView = findViewById(R.id.stage_card_scorecard_calm_badge_image_view);
        mStageTopMostFranticBadgeImageView = findViewById(R.id.stage_card_scorecard_frantic_badge_image_view);

        //
        mStageCardTopPredatorLayout = findViewById(R.id.stage_card_scorecard_predator_layout);
        mStageCardTopAccuracyLayout = findViewById(R.id.stage_card_scorecard_accuracy_layout);
        mStageCardTopTimeLayout = findViewById(R.id.stage_card_scorecard_best_time_layout);
        mStageCardTopEatenLayout = findViewById(R.id.stage_card_scorecard_total_kills_layout);
        mStageCardTopStreakLayout = findViewById(R.id.stage_card_scorecard_highest_streak_layout);
        mStageCardTopDeathLayout = findViewById(R.id.stage_card_scorecard_closest_death_layout);
        mStageCardTopFrenzyLayout = findViewById(R.id.stage_card_scorecard_longest_frenzy_layout);
        mStageCardTopCalmLayout = findViewById(R.id.stage_card_scorecard_most_calm_layout);
        mStageCardTopFranticLayout = findViewById(R.id.stage_card_scorecard_most_frantic_layout);

        // Stage card - switch ui
        mStageCardControlPrevImageButton = findViewById(R.id.stage_card_control_prev_image_button);
        mStageCardControlNextImageButton = findViewById(R.id.stage_card_control_next_image_button);

        // Creature collection views
        mCreature01ImageView = findViewById(R.id.stage_card_trophy_01_image_view);
        mCreature02ImageView = findViewById(R.id.stage_card_trophy_02_image_view);
        mCreature03ImageView = findViewById(R.id.stage_card_trophy_03_image_view);
        mCreature04ImageView = findViewById(R.id.stage_card_trophy_04_image_view);
        mCreature05ImageView = findViewById(R.id.stage_card_trophy_05_image_view);

        // GAME SCREEN
        // Game control layout
        mGameHeaderControlLayout = findViewById(R.id.game_header_control_layout);
        mGameFooterControlLayout = findViewById(R.id.game_footer_control_layout);

        // Stage label
        mGameStageImageView = findViewById(R.id.game_main_stage_image_view);
        mGameSceneImageView = findViewById(R.id.game_main_scene_image_view);

        // Boss adrenaline button
        mGameAdrenalineLayout = findViewById(R.id.game_scene_boss_layout);

        // Game main meters
        mGameMainTapoutMeterProgressBar = findViewById(R.id.game_main_tapout_progress_bar);
        mGameMainHungerMeterProgressBar = findViewById(R.id.game_main_hunger_meter_progress_bar);

        // Creatures
        mGameCreature01ImageButton = findViewById(R.id.game_creature_01_image_button);
        mGameCreature02ImageButton = findViewById(R.id.game_creature_02_image_button);
        mGameCreature03ImageButton = findViewById(R.id.game_creature_03_image_button);
        mGameCreature04ImageButton = findViewById(R.id.game_creature_04_image_button);
        mGameCreature05ImageButton = findViewById(R.id.game_creature_05_image_button);

        // Power icons
        mGamePower01ImageButton = findViewById(R.id.game_power_01_image_button);
        mGamePower02ImageButton = findViewById(R.id.game_power_02_image_button);
        mGamePower03ImageButton = findViewById(R.id.game_power_03_image_button);
        mGamePower04ImageButton = findViewById(R.id.game_power_04_image_button);
        mGamePower05ImageButton = findViewById(R.id.game_power_05_image_button);
        mGamePower06ImageButton = findViewById(R.id.game_power_06_image_button);

        // Boss
        mGameBossHealthProgressBar = findViewById(R.id.game_main_boss_health_progress_bar);
        mGameUserHealthProgressBar = findViewById(R.id.game_main_user_health_progress_bar);
        mGameBossImageButton = findViewById(R.id.game_boss_image_button);

        // Playgrounds
        mGameCreatureLayout = findViewById(R.id.game_main_creature_layout);

        //
        mGameTunnelVisionLayout = findViewById(R.id.game_main_tunnel_vision_layout);
        mGameBittenLayout = findViewById(R.id.game_main_bitten_layout);
        mGameDisasterLayout = findViewById(R.id.game_disaster_layout);
        mGameBorderLayout = findViewById(R.id.game_main_silhouette_border_layout);
        mGameFlashLayout = findViewById(R.id.game_fade_white_layout);
        mGameBlackoutLayout = findViewById(R.id.game_fade_black_layout);

        //
        mLoadRandomScoreTitleTextView = findViewById(R.id.load_main_random_score_title_text_view);
        mLoadRandomScoreValueTextView = findViewById(R.id.load_main_random_score_value_text_view);
    }

    // Save game state data
    public void setGameData() {

        //
        SharedPreferences mUserPrefSet = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditorSet = mUserPrefSet.edit();

        // Saved Game
        mEditorSet.putBoolean(CONTINUE_SAVED_STATE, continue_game);

        // Settings
        mEditorSet.putBoolean(AUDIO_SAVED_STATE, play_audio);
        mEditorSet.putBoolean(HAPTIC_SAVED_STATE, play_haptic);
        mEditorSet.putBoolean(TUTORIAL_SAVED_STATE, play_tutorial);

        // 1
        mEditorSet.putBoolean(STAGE_01_COMPLETE, stage_01_complete);

        //
        mEditorSet.putInt(STAGE_01_ATTEMPTS, stage_01_attempts); // local variable into constant
        mEditorSet.putInt(STAGE_01_BOSS_KILLS, stage_01_boss_kills);
        mEditorSet.putInt(STAGE_01_TOTAL_TIME, stage_01_total_time);
        mEditorSet.putInt(STAGE_01_BEST_TIME, stage_01_best_time);

        //
        mEditorSet.putBoolean(STAGE_01_APEX, stage_01_apex);
        mEditorSet.putInt(STAGE_01_FOOD_CHAIN, stage_01_food_chain);
        mEditorSet.putFloat(STAGE_01_ACCURACY, stage_01_accuracy);
        mEditorSet.putInt(STAGE_01_CREATURE_KILLS, stage_01_creature_kills);
        mEditorSet.putInt(STAGE_01_HIGHEST_STREAK, stage_01_highest_streak);
        mEditorSet.putInt(STAGE_01_CLOSEST_DEATH, stage_01_closest_death);
        mEditorSet.putInt(STAGE_01_LONGEST_FRENZY, stage_01_longest_frenzy);
        mEditorSet.putLong(STAGE_01_MOST_CALM, stage_01_most_calm);
        mEditorSet.putLong(STAGE_01_MOST_FRANTIC, stage_01_most_frantic);

        //
        mEditorSet.putInt(STAGE_01_COLLECTION, stage_01_collection);

        //
        int i = 0;

        //
        for (boolean predator : stage_01_top_predators_previous) {

            //
            if (predator) {

                //
                mEditorSet.putBoolean(top_predator_previous_string_01[i], true);
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
        mEditorSet.putInt(STAGE_02_FOOD_CHAIN, stage_02_food_chain);
        mEditorSet.putFloat(STAGE_02_ACCURACY, stage_02_accuracy);
        mEditorSet.putBoolean(STAGE_02_APEX, stage_02_apex);

        //
        i = 0;

        //
        for (boolean predator : stage_02_top_predators_previous) {

            //
            if (predator) {

                //
                mEditorSet.putBoolean(top_predator_previous_string_02[i], true);
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
        mEditorSet.putInt(STAGE_03_FOOD_CHAIN, stage_03_food_chain);
        mEditorSet.putFloat(STAGE_03_ACCURACY, stage_03_accuracy);
        mEditorSet.putBoolean(STAGE_03_APEX, stage_03_apex);

        //
        i = 0;

        //
        for (boolean predator : stage_03_top_predators_previous) {

            //
            if (predator) {

                //
                mEditorSet.putBoolean(top_predator_previous_string_03[i], true);
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
        mEditorSet.putInt(STAGE_04_FOOD_CHAIN, stage_04_food_chain);
        mEditorSet.putFloat(STAGE_04_ACCURACY, stage_04_accuracy);
        mEditorSet.putBoolean(STAGE_04_APEX, stage_04_apex);

        //
        i = 0;

        //
        for (boolean predator : stage_04_top_predators_previous) {

            //
            if (predator) {

                //
                mEditorSet.putBoolean(top_predator_previous_string_04[i], true);
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
        mEditorSet.putInt(STAGE_05_FOOD_CHAIN, stage_05_food_chain);
        mEditorSet.putFloat(STAGE_05_ACCURACY, stage_05_accuracy);
        mEditorSet.putBoolean(STAGE_05_APEX, stage_05_apex);

        //
        i = 0;

        //
        for (boolean predator : stage_05_top_predators_previous) {

            //
            if (predator) {

                //
                mEditorSet.putBoolean(top_predator_previous_string_05[i], true);
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
        mEditorSet.putInt(STAGE_06_FOOD_CHAIN, stage_06_food_chain);
        mEditorSet.putFloat(STAGE_06_ACCURACY, stage_06_accuracy);
        mEditorSet.putBoolean(STAGE_06_APEX, stage_06_apex);

        //
        i = 0;

        //
        for (boolean predator : stage_06_top_predators_previous) {

            //
            if (predator) {

                //
                mEditorSet.putBoolean(top_predator_previous_string_06[i], true);
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
        mEditorSet.putInt(STAGE_07_FOOD_CHAIN, stage_07_food_chain);
        mEditorSet.putFloat(STAGE_07_ACCURACY, stage_07_accuracy);
        mEditorSet.putBoolean(STAGE_07_APEX, stage_07_apex);

        //
        i = 0;

        //
        for (boolean predator : stage_07_top_predators_previous) {

            //
            if (predator) {

                //
                mEditorSet.putBoolean(top_predator_previous_string_07[i], true);
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
        boolean stage_01_predator_01 = mUserPrefGet.getBoolean(STAGE_01_PREDATOR_01, false);
        boolean stage_01_predator_02 = mUserPrefGet.getBoolean(STAGE_01_PREDATOR_02, false);
        boolean stage_01_predator_03 = mUserPrefGet.getBoolean(STAGE_01_PREDATOR_03, false);
        boolean stage_01_predator_04 = mUserPrefGet.getBoolean(STAGE_01_PREDATOR_04, false);
        boolean stage_01_predator_05 = mUserPrefGet.getBoolean(STAGE_01_PREDATOR_05, false);

        //
        stage_01_top_predators_previous.clear();
        stage_01_top_predators_previous.add(stage_01_predator_01);
        stage_01_top_predators_previous.add(stage_01_predator_02);
        stage_01_top_predators_previous.add(stage_01_predator_03);
        stage_01_top_predators_previous.add(stage_01_predator_04);
        stage_01_top_predators_previous.add(stage_01_predator_05);

        //
        stage_01_collection = 0;

        //
        for (boolean predator : stage_01_top_predators_previous) {

            //
            if (predator) {
                ++stage_01_collection;
            }
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
        stage_01_food_chain = mUserPrefGet.getInt(STAGE_01_FOOD_CHAIN, 0);
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
        boolean stage_02_predator_01 = mUserPrefGet.getBoolean(STAGE_02_PREDATOR_01, false);
        boolean stage_02_predator_02 = mUserPrefGet.getBoolean(STAGE_02_PREDATOR_02, false);
        boolean stage_02_predator_03 = mUserPrefGet.getBoolean(STAGE_02_PREDATOR_03, false);
        boolean stage_02_predator_04 = mUserPrefGet.getBoolean(STAGE_02_PREDATOR_04, false);
        boolean stage_02_predator_05 = mUserPrefGet.getBoolean(STAGE_02_PREDATOR_05, false);

        //
        stage_02_top_predators_previous.clear();
        stage_02_top_predators_previous.add(stage_02_predator_01);
        stage_02_top_predators_previous.add(stage_02_predator_02);
        stage_02_top_predators_previous.add(stage_02_predator_03);
        stage_02_top_predators_previous.add(stage_02_predator_04);
        stage_02_top_predators_previous.add(stage_02_predator_05);

        //
        stage_02_collection = 0;

        //
        for (boolean predator : stage_02_top_predators_previous) {

            //
            if (predator) {
                ++stage_02_collection;
            }
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
        stage_02_food_chain = mUserPrefGet.getInt(STAGE_02_FOOD_CHAIN, 0);
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
        boolean stage_03_predator_01 = mUserPrefGet.getBoolean(STAGE_03_PREDATOR_01, false);
        boolean stage_03_predator_02 = mUserPrefGet.getBoolean(STAGE_03_PREDATOR_02, false);
        boolean stage_03_predator_03 = mUserPrefGet.getBoolean(STAGE_03_PREDATOR_03, false);
        boolean stage_03_predator_04 = mUserPrefGet.getBoolean(STAGE_03_PREDATOR_04, false);
        boolean stage_03_predator_05 = mUserPrefGet.getBoolean(STAGE_03_PREDATOR_05, false);

        //
        stage_03_top_predators_previous.clear();
        stage_03_top_predators_previous.add(stage_03_predator_01);
        stage_03_top_predators_previous.add(stage_03_predator_02);
        stage_03_top_predators_previous.add(stage_03_predator_03);
        stage_03_top_predators_previous.add(stage_03_predator_04);
        stage_03_top_predators_previous.add(stage_03_predator_05);

        //
        stage_03_collection = 0;

        //
        for (boolean predator : stage_03_top_predators_previous) {

            //
            if (predator) {
                ++stage_03_collection;
            }
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
        stage_03_food_chain = mUserPrefGet.getInt(STAGE_03_FOOD_CHAIN, 0);
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
        boolean stage_04_predator_01 = mUserPrefGet.getBoolean(STAGE_04_PREDATOR_01, false);
        boolean stage_04_predator_02 = mUserPrefGet.getBoolean(STAGE_04_PREDATOR_02, false);
        boolean stage_04_predator_03 = mUserPrefGet.getBoolean(STAGE_04_PREDATOR_03, false);
        boolean stage_04_predator_04 = mUserPrefGet.getBoolean(STAGE_04_PREDATOR_04, false);
        boolean stage_04_predator_05 = mUserPrefGet.getBoolean(STAGE_04_PREDATOR_05, false);

        //
        stage_04_top_predators_previous.clear();
        stage_04_top_predators_previous.add(stage_04_predator_01);
        stage_04_top_predators_previous.add(stage_04_predator_02);
        stage_04_top_predators_previous.add(stage_04_predator_03);
        stage_04_top_predators_previous.add(stage_04_predator_04);
        stage_04_top_predators_previous.add(stage_04_predator_05);

        //
        stage_04_collection = 0;

        //
        for (boolean predator : stage_04_top_predators_previous) {

            //
            if (predator) {
                ++stage_04_collection;
            }
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
        stage_04_food_chain = mUserPrefGet.getInt(STAGE_04_FOOD_CHAIN, 0);
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
        boolean stage_05_predator_01 = mUserPrefGet.getBoolean(STAGE_05_PREDATOR_01, false);
        boolean stage_05_predator_02 = mUserPrefGet.getBoolean(STAGE_05_PREDATOR_02, false);
        boolean stage_05_predator_03 = mUserPrefGet.getBoolean(STAGE_05_PREDATOR_03, false);
        boolean stage_05_predator_04 = mUserPrefGet.getBoolean(STAGE_05_PREDATOR_04, false);
        boolean stage_05_predator_05 = mUserPrefGet.getBoolean(STAGE_05_PREDATOR_05, false);

        //
        stage_05_top_predators_previous.clear();
        stage_05_top_predators_previous.add(stage_05_predator_01);
        stage_05_top_predators_previous.add(stage_05_predator_02);
        stage_05_top_predators_previous.add(stage_05_predator_03);
        stage_05_top_predators_previous.add(stage_05_predator_04);
        stage_05_top_predators_previous.add(stage_05_predator_05);

        //
        stage_05_collection = 0;

        //
        for (boolean predator : stage_05_top_predators_previous) {

            //
            if (predator) {
                ++stage_05_collection;
            }
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
        stage_05_food_chain = mUserPrefGet.getInt(STAGE_05_FOOD_CHAIN, 0);
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
        boolean stage_06_predator_01 = mUserPrefGet.getBoolean(STAGE_06_PREDATOR_01, false);
        boolean stage_06_predator_02 = mUserPrefGet.getBoolean(STAGE_06_PREDATOR_02, false);
        boolean stage_06_predator_03 = mUserPrefGet.getBoolean(STAGE_06_PREDATOR_03, false);
        boolean stage_06_predator_04 = mUserPrefGet.getBoolean(STAGE_06_PREDATOR_04, false);
        boolean stage_06_predator_05 = mUserPrefGet.getBoolean(STAGE_06_PREDATOR_05, false);

        //
        stage_06_top_predators_previous.clear();
        stage_06_top_predators_previous.add(stage_06_predator_01);
        stage_06_top_predators_previous.add(stage_06_predator_02);
        stage_06_top_predators_previous.add(stage_06_predator_03);
        stage_06_top_predators_previous.add(stage_06_predator_04);
        stage_06_top_predators_previous.add(stage_06_predator_05);

        //
        stage_06_collection = 0;

        //
        for (boolean predator : stage_06_top_predators_previous) {

            //
            if (predator) {
                ++stage_06_collection;
            }
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
        stage_06_food_chain = mUserPrefGet.getInt(STAGE_06_FOOD_CHAIN, 0);
        stage_06_accuracy = mUserPrefGet.getFloat(STAGE_06_ACCURACY, 0);
        stage_06_apex = mUserPrefGet.getBoolean(STAGE_06_APEX, false);

// -- STAGE 7 -->
        //
        stage_07_complete = mUserPrefGet.getBoolean(STAGE_07_COMPLETE, false);

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
        boolean stage_07_predator_01 = mUserPrefGet.getBoolean(STAGE_07_PREDATOR_01, false);
        boolean stage_07_predator_02 = mUserPrefGet.getBoolean(STAGE_07_PREDATOR_02, false);
        boolean stage_07_predator_03 = mUserPrefGet.getBoolean(STAGE_07_PREDATOR_03, false);
        boolean stage_07_predator_04 = mUserPrefGet.getBoolean(STAGE_07_PREDATOR_04, false);
        boolean stage_07_predator_05 = mUserPrefGet.getBoolean(STAGE_07_PREDATOR_05, false);

        //
        stage_07_top_predators_previous.clear();
        stage_07_top_predators_previous.add(stage_07_predator_01);
        stage_07_top_predators_previous.add(stage_07_predator_02);
        stage_07_top_predators_previous.add(stage_07_predator_03);
        stage_07_top_predators_previous.add(stage_07_predator_04);
        stage_07_top_predators_previous.add(stage_07_predator_05);

        //
        stage_07_collection = 0;

        //
        for (boolean predator : stage_07_top_predators_previous) {

            //
            if (predator) {
                ++stage_07_collection;
            }
        }

        // possible collection rate score [stage_07_collection / 32]
        // --> [collector, hobbyist, completest] (1 - 32)

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
        stage_07_food_chain = mUserPrefGet.getInt(STAGE_07_FOOD_CHAIN, 0);
        // --> [survivalist, food_chain, beast]
        stage_07_accuracy = mUserPrefGet.getFloat(STAGE_07_ACCURACY, 0);
        // --> [sharp, honed, exacting]
        stage_07_apex = mUserPrefGet.getBoolean(STAGE_07_APEX, false);

        //
        game_complete = stage_07_complete;

        // Assign - total attempts
        mGameAttempts = stage_01_attempts + stage_02_attempts + stage_03_attempts + stage_04_attempts + stage_05_attempts + stage_06_attempts + stage_07_attempts;
        // --> [around-the-block, known-by-name, old-stomping-grounds]

        // Assign - total boss kills
        mGameBossKills = stage_01_boss_kills + stage_02_boss_kills + stage_03_boss_kills + stage_04_boss_kills + stage_05_boss_kills + stage_06_boss_kills + stage_07_boss_kills;
        // --> [timid, bold, vicious]

        // Assign - total predator kills
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
            if (score >= hiScore) {
                hiScore = score;
            }
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
            if (score <= hiScore) {
                hiScore = score;
            }
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
            if (score >= hiScore) {
                hiScore = score;
            }
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
            if (score >= highScore) {
                highScore = score;
            }
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
            if (score <= highScore) {
                highScore = score;
            }
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

        // Assign - top food_chain
        mGameFoodChain = (stage_01_food_chain + stage_02_food_chain + stage_03_food_chain + stage_04_food_chain + stage_05_food_chain + stage_06_food_chain + stage_07_food_chain);

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
            if (score > 0) {

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
            if (!score) {
                mGameApex = false;
            }
        }

        //
        mGameAttempts =
                (stage_01_attempts + stage_02_attempts + stage_03_attempts +
                        stage_04_attempts + stage_05_attempts + stage_06_attempts +
                        stage_07_attempts);

        //
        mGameTimeTotal =
                (stage_01_total_time + stage_02_total_time + stage_03_total_time +
                        stage_04_total_time + stage_05_total_time + stage_06_total_time +
                        stage_07_total_time);

        //
        mGameBossKills =
                (stage_01_boss_kills + stage_02_boss_kills + stage_03_boss_kills +
                        stage_04_boss_kills + stage_05_boss_kills + stage_06_boss_kills +
                        stage_07_boss_kills);
        
        //
        mGameTimeTotal =
                (stage_01_total_time + stage_02_total_time + stage_03_total_time +
                    stage_04_total_time + stage_05_total_time + stage_06_total_time +
                    stage_07_total_time);
    }

    // Set click listeners
    public void setClickables() {

        // Set click listener for each item in CLICKABLES array
        for (int id : CLICKABLES) {
            findViewById(id).setOnClickListener(this);
        }
    }

    // Play credits [mode = intro / outro]
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
                //findViewById(mCurScreen).setVisibility(View.GONE);

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

                    // Switch to stage select screen
                    switchScreen(R.id.stage_select_screen_main_layout);

                    // Play audio
                    playAudio(ROAR);
                }

                break;

            // Entry - Credits Button Event
            case R.id.entry_main_credits_image_button:

                // Switch to credits
                playCredits(2);

                break;

            case R.id.entry_main_settings_image_button:

                // TODO : Add Functionality
                playAudio(ROAR);

                break;

            case R.id.entry_main_tutorial_image_button:

                // TODO : Add Functionality
                playAudio(RUN);

                break;

//--STAGE SELECT-->

            // Stage select - Return event
            case R.id.stage_select_header_return_image_button:

                // Switch to entry screen
                switchScreen(R.id.entry_screen_main_layout);

                // Play audio
                playAudio(RUN);

                break;

            //  Stage select - Secret button event
            case R.id.stage_select_header_secret_image_button:

                // TODO : Add Functionality
                playAudio(MISS);

                //
                mStageSelectDialogueLayout.setVisibility(View.VISIBLE);

                break;

            case R.id.stage_select_score_layout:

                // TODO : Add Functionality
                playAudio(CHOMP);

                //
                mStageSelectDialogueLayout.setVisibility(View.GONE);

                break;

            // Stage select - Scorecard event
            case R.id.stage_select_scorecard_image_button:

                // Check scores present - non-logical, just saving cpu
                if (stage_01_complete) {

                    // Display scorecard
                    if (mScorecard) {

                        //
                        mTrophycase = false;
                        mScorecard = false;
                        mContent = true;

                        //
                        mStageSelectTrophycaseLayout.setVisibility(View.GONE);
                        mStageSelectScorecardLayout.setVisibility(View.GONE);
                        mStageSelectContentLayout.setVisibility(View.VISIBLE);

                        //
                        mStageSelectTrophycaseImageButton.setAlpha(.5f);
                        mStageSelectScorecardImageButton.setAlpha(.5f);
                        mStageSelectContentImageButton.setAlpha(1f);

                    } else {

                        //
                        mScorecard = true;
                        mTrophycase = false;
                        mContent = false;

                        //
                        mStageSelectTrophycaseLayout.setVisibility(View.GONE);
                        mStageSelectScorecardLayout.setVisibility(View.VISIBLE);
                        mStageSelectContentLayout.setVisibility(View.GONE);

                        //
                        mStageSelectTrophycaseImageButton.setAlpha(.5f);
                        mStageSelectScorecardImageButton.setAlpha(1f);
                        mStageSelectContentImageButton.setAlpha(.5f);
                    }

                    // Play audio
                    playAudio(CROW_AUDIO);
                }

                break;

            // Stage select - Scorecard event
            case R.id.stage_select_trophycase_image_button:

                // Check scores present - non-logical just saving cpu
                if (stage_01_complete) {

                    // Display scorecard
                    if (mTrophycase) {

                        //
                        mTrophycase = false;
                        mScorecard = false;
                        mContent = true;

                        //
                        mStageSelectTrophycaseLayout.setVisibility(View.GONE);
                        mStageSelectScorecardLayout.setVisibility(View.GONE);
                        mStageSelectContentLayout.setVisibility(View.VISIBLE);

                        //
                        mStageSelectTrophycaseImageButton.setAlpha(.5f);
                        mStageSelectScorecardImageButton.setAlpha(.5f);
                        mStageSelectContentImageButton.setAlpha(1f);

                    } else {

                        //
                        mTrophycase = true;
                        mScorecard = false;
                        mContent = false;

                        //
                        mStageSelectTrophycaseLayout.setVisibility(View.VISIBLE);
                        mStageSelectScorecardLayout.setVisibility(View.GONE);
                        mStageSelectContentLayout.setVisibility(View.GONE);

                        //
                        mStageSelectTrophycaseImageButton.setAlpha(1f);
                        mStageSelectScorecardImageButton.setAlpha(.5f);
                        mStageSelectContentImageButton.setAlpha(.5f);
                    }

                    // Play audio
                    playAudio(CROW_AUDIO);
                }

                break;

            // Stage select -
            case R.id.stage_select_content_image_button:

                //
                mScorecard = false;
                mTrophycase = false;
                mContent = true;

                //
                mStageSelectTrophycaseLayout.setVisibility(View.GONE);
                mStageSelectScorecardLayout.setVisibility(View.GONE);
                mStageSelectContentLayout.setVisibility(View.VISIBLE);

                //
                mStageSelectTrophycaseImageButton.setAlpha(.5f);
                mStageSelectScorecardImageButton.setAlpha(.5f);
                mStageSelectContentImageButton.setAlpha(1f);

                // Play audio
                playAudio(CROW_AUDIO);

                break;

            // Stage select - trophy event
            case R.id.stage_select_trophy_01_layout:

                //
                playAudio(WOLF_CRY);

                break;

            // Stage select - trophy event
            case R.id.stage_select_trophy_02_layout:

                //
                playAudio(SHARK_CRY);

                break;

            // Stage select - trophy event
            case R.id.stage_select_trophy_03_layout:

                //
                playAudio(HAWK_CRY);

                break;

            // Stage select - trophy event
            case R.id.stage_select_trophy_04_layout:

                //
                playAudio(SCORPION_CRY);

                break;

            // Stage select - trophy event
            case R.id.stage_select_trophy_05_layout:

                //
                playAudio(SNAKE_CRY);

                break;

            // Stage select - trophy event
            case R.id.stage_select_trophy_06_layout:

                //
                playAudio(YETI_CRY);

                break;

            // Stage select - trophy event
            case R.id.stage_select_trophy_07_layout:

                //
                playAudio(THUNDER_AUDIO);

                break;

            // Stage select - scorecard event
            case R.id.stage_select_score_apex_layout:

                // TODO - Add Functionality
                playAudio(MISS);

                break;

            // Stage select - scorecard event
            case R.id.stage_select_score_predator_layout:

                // TODO - Add Functionality
                playAudio(MISS);

                break;

            // Stage select - scorecard event
            case R.id.stage_select_score_accuracy_layout:

                // TODO - Add Functionality
                playAudio(MISS);

                break;

            // Stage select - scorecard event
            case R.id.stage_select_score_time_layout:

                // TODO - Add Functionality
                playAudio(MISS);

                break;

            // Stage select - scorecard event
            case R.id.stage_select_score_creatures_layout:

                // TODO - Add Functionality
                playAudio(MISS);

                break;

            // Stage select - scorecard event
            case R.id.stage_select_score_streak_layout:

                // TODO - Add Functionality
                playAudio(MISS);

                break;

            // Stage select - scorecard event
            case R.id.stage_select_score_death_layout:

                // TODO - Add Functionality
                playAudio(MISS);

                break;

            // Stage select - scorecard event
            case R.id.stage_select_score_frenzy_layout:

                // TODO - Add Functionality
                playAudio(MISS);

                break;

            // Stage select - scorecard event
            case R.id.stage_select_score_calm_layout:

                // TODO - Add Functionality
                playAudio(MISS);

                break;

            // Stage select - scorecard event
            case R.id.stage_select_score_frantic_layout:

                // TODO - Add Functionality
                playAudio(MISS);

                break;

            // Stage select - stage event
            case R.id.stage_select_content_card_01_layout:

                // Set stage card - forest [index for resources]
                mStageIndex = 1;

                // Load stage
                loadStage();

                break;

            // Stage select - stage event
            case R.id.stage_select_content_card_02_layout:

                // Set stage card - ocean
                mStageIndex = 2;

                // Load stage
                loadStage();

                break;

            // Stage select - stage event
            case R.id.stage_select_content_card_03_layout:

                // Set stage card - mountain
                mStageIndex = 3;

                // Load stage
                loadStage();

                break;

            // Stage select - stage event
            case R.id.stage_select_content_card_04_layout:

                // Set stage card - desert
                mStageIndex = 4;

                // Load stage
                loadStage();

                break;

            // Stage select - stage event
            case R.id.stage_select_content_card_05_layout:

                // Set stage card - jungle
                mStageIndex = 5;

                // Load stage
                loadStage();

                break;

            // Stage select - stage event
            case R.id.stage_select_content_card_06_layout:

                // Set stage card - tundra
                mStageIndex = 6;

                // Load stage
                loadStage();

                break;

            // Stage select - stage event
            case R.id.stage_select_content_card_07_layout:

                // Set stage card - final
                mStageIndex = 7;

                // Load stage
                loadStage();

                break;

//--STAGE CARD-->

            // Stage card - Header return
            case R.id.stage_card_return_image_button:

                //
                mStageIndex = -1;

                //
                switchScreen(R.id.stage_select_screen_main_layout);

                //
                playAudio(RUN);

                break;

            // Stage care - help event
            case R.id.stage_card_help_image_button:

                // TODO - Add Functionality

                break;

            //
            case R.id.stage_card_trophycase_image_button:

                //
                if (mTrophycase) {

                    //
                    mTrophycase = false;
                    mScorecard = false;
                    mContent = true;

                    //
                    mStageCardTrophycaseImageButton.setAlpha(.5f);
                    mStageCardScorecardImageButton.setAlpha(.5f);
                    mStageCardContentImageButton.setAlpha(1f);

                    //
                    mStageCardScorecardLayout.setVisibility(View.GONE);
                    mStageCardTrophycaseLayout.setVisibility(View.GONE);
                    mStageCardContentLayout.setVisibility(View.VISIBLE);

                    //
                    mStageCardCompleteLayout.setVisibility(View.GONE);
                    mStageCardEatenLayout.setVisibility(View.GONE);
                    mStageCardLockedLayout.setVisibility(View.GONE);

                } else {

                    //
                    mTrophycase = true;
                    mScorecard = false;
                    mContent = false;

                    //
                    mStageCardTrophycaseImageButton.setAlpha(1f);
                    mStageCardScorecardImageButton.setAlpha(.5f);
                    mStageCardContentImageButton.setAlpha(.5f);

                    //
                    mStageCardTrophycaseLayout.setVisibility(View.VISIBLE);
                    mStageCardContentLayout.setVisibility(View.GONE);
                    mStageCardScorecardLayout.setVisibility(View.GONE);

                    //
                    mStageCardCompleteLayout.setVisibility(View.GONE);
                    mStageCardEatenLayout.setVisibility(View.GONE);
                    mStageCardLockedLayout.setVisibility(View.GONE);
                }

                // Play audio
                playAudio(CHOMP);

                break;

            // Stage card - Header collection
            case R.id.stage_card_scorecard_image_button:

                //
                if (mScorecard) {

                    //
                    mTrophycase = false;
                    mScorecard = false;
                    mContent = true;

                    //
                    mStageCardTrophycaseImageButton.setAlpha(.5f);
                    mStageCardScorecardImageButton.setAlpha(.5f);
                    mStageCardContentImageButton.setAlpha(1f);

                    //
                    mStageCardTrophycaseLayout.setVisibility(View.GONE);
                    mStageCardScorecardLayout.setVisibility(View.GONE);
                    mStageCardContentLayout.setVisibility(View.VISIBLE);

                    //
                    mStageCardCompleteLayout.setVisibility(View.GONE);
                    mStageCardEatenLayout.setVisibility(View.GONE);
                    mStageCardLockedLayout.setVisibility(View.GONE);

                } else {

                    //
                    mTrophycase = false;
                    mScorecard = true;
                    mContent = false;

                    //
                    mStageCardTrophycaseImageButton.setAlpha(.5f);
                    mStageCardScorecardImageButton.setAlpha(1f);
                    mStageCardContentImageButton.setAlpha(.5f);

                    //
                    mStageCardTrophycaseLayout.setVisibility(View.GONE);
                    mStageCardScorecardLayout.setVisibility(View.VISIBLE);
                    mStageCardContentLayout.setVisibility(View.GONE);

                    //
                    mStageCardCompleteLayout.setVisibility(View.GONE);
                    mStageCardEatenLayout.setVisibility(View.GONE);
                    mStageCardLockedLayout.setVisibility(View.GONE);
                }

                // Play audio
                playAudio(CHOMP);

                break;


            //
            case R.id.stage_card_content_image_button:

                //
                mTrophycase = false;
                mScorecard = false;
                mContent = true;

                //
                mStageCardTrophycaseImageButton.setAlpha(.5f);
                mStageCardScorecardImageButton.setAlpha(.5f);
                mStageCardContentImageButton.setAlpha(1f);

                //
                mStageCardTrophycaseLayout.setVisibility(View.GONE);
                mStageCardScorecardLayout.setVisibility(View.GONE);
                mStageCardContentLayout.setVisibility(View.VISIBLE);

                //
                mStageCardCompleteLayout.setVisibility(View.GONE);
                mStageCardEatenLayout.setVisibility(View.GONE);
                mStageCardLockedLayout.setVisibility(View.GONE);

                // Play audio
                playAudio(CHOMP);

                break;

            //
            case R.id.stage_card_eaten_layout:

                //
                mTrophycase = false;
                mScorecard = false;
                mContent = true;

                //
                mStageCardTrophycaseImageButton.setAlpha(.5f);
                mStageCardScorecardImageButton.setAlpha(.5f);
                mStageCardContentImageButton.setAlpha(1f);

                //
                mStageCardTrophycaseLayout.setVisibility(View.GONE);
                mStageCardScorecardLayout.setVisibility(View.GONE);
                mStageCardContentLayout.setVisibility(View.VISIBLE);

                //
                mStageCardCompleteLayout.setVisibility(View.GONE);
                mStageCardEatenLayout.setVisibility(View.GONE);
                mStageCardLockedLayout.setVisibility(View.GONE);

                // Stage card - Control prev
            case R.id.stage_card_control_prev_image_button:

                //
                if (mStageIndex != 0) {

                    //
                    findViewById(mCurScreen).setVisibility(View.GONE);

                    //
                    mTrophycase = false;
                    mScorecard = false;
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
                    mTrophycase = false;
                    mScorecard = false;
                    mContent = false;

                    //
                    switchStageCard(1);

                    // Play audio
                    playAudio(MISS);
                }

                break;

            // Stage card - Footer play here
            case R.id.stage_card_control_play_image_button:

                //
                prepStage();

                //
                startGame();

                // Play audio
                playAudio(mGameBossCry);

                break;

//--GAME-->

            // Game - Settings Event
            case R.id.game_main_return_image_button:

                // Settings dialogue
                alertReturnLoseProgress();

                break;

            //
            case R.id.game_power_01_image_button:

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Spend power
                    usePower(mPower01Meter, mPower01Target, 1);
                }

                break;

            //
            case R.id.game_power_02_image_button:

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Spend power
                    usePower(mPower02Meter, mPower02Target, 2);
                }

                break;

            //
            case R.id.game_power_03_image_button:

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Spend power
                    usePower(mPower03Meter, mPower03Target, 3);
                }

                break;

            //
            case R.id.game_power_04_image_button:

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Spend power
                    usePower(mPower04Meter, mPower04Target, 4);
                }

                break;

            //
            case R.id.game_power_05_image_button:

                //
                if (!mPauseGame || mPauseTimer != -1) {

                    // Spend power
                    usePower(mPower05Meter, mPower05Target, 5);
                }

                break;

            //
            case R.id.game_power_06_image_button:

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
            case R.id.game_creature_01_image_button:

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
                        switchCreature(R.id.game_creature_01_image_button);

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
                        findViewById(R.id.game_creature_01_image_button).setVisibility(View.GONE);

                        //
                        mStageCreature01ID = mCreatureID;
                    }
                }

                // Housekeeping
                drawScreen();

                break;

            //
            case R.id.game_creature_02_image_button:

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
                        switchCreature(R.id.game_creature_02_image_button);

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
                        findViewById(R.id.game_creature_02_image_button).setVisibility(View.GONE);

                        //
                        mStageCreature02ID = mCreatureID;
                    }
                }

                break;

            //
            case R.id.game_creature_03_image_button:

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
                        switchCreature(R.id.game_creature_03_image_button);

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
                        findViewById(R.id.game_creature_03_image_button).setVisibility(View.GONE);

                        //
                        mStageCreature03ID = mCreatureID;
                    }
                }

                break;

            //
            case R.id.game_creature_04_image_button:

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
                        switchCreature(R.id.game_creature_04_image_button);

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
                        findViewById(R.id.game_creature_04_image_button).setVisibility(View.GONE);

                        //
                        mStageCreature04ID = mCreatureID;
                    }
                }

                break;

            //
            case R.id.game_creature_05_image_button:

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
                        switchCreature(R.id.game_creature_05_image_button);

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
                        findViewById(R.id.game_creature_05_image_button).setVisibility(View.GONE);

                        //
                        mStageCreature05ID = mCreatureID;
                    }
                }

                break;

            //
            case R.id.game_boss_image_button:

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

        boolean[] stage_complete = {

                stage_01_complete, stage_02_complete, stage_03_complete, stage_04_complete, stage_05_complete, stage_06_complete, stage_07_complete
        };

        // Initial stage status - locked, unless stage 1
        mStageReady = 1;
        //if (mStageIndex != 1) {

            // Test for ready
            if (STAGE_COMPLETE_SCORE_ARRAY[mStageIndex - 1]) {

                //
                mStageComplete = true;
                mStageReady = 3;

            } else if (mStageIndex != 1 && STAGE_COMPLETE_SCORE_ARRAY[mStageIndex - 2]) {

                //
                mStageReady = 2;
            //}
        } else {
            mStageReady = 2;
        }

        // Reset apex
        mStageApex = false;

        mStageComplete = stage_complete[mStageIndex - 1];

        // Load audio for disaster / boss
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

        // Increment stage attempts
        incrementStageAttempts();

        // Reset variables
        resetVars();

        //
        buildStageTrophycase(mStageIndex);

        //
        mGameBossImageButton.setVisibility(View.GONE);
        mGameCreatureLayout.setVisibility(View.VISIBLE);

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

    //
    public void incrementStageAttempts() {

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
        if (mSpeedIndex < 100) {
            mSpeedIndex = 100;
        }
    }

    // Decelerate adrenaline timer
    private void decelerateTimer(double decel_rate) {

        //
        double speed_component = (mSpeedIndex * decel_rate);
        mSpeedIndex = mSpeedIndex + (long) speed_component;
        if (mSpeedIndex > 5000) {
            mSpeedIndex = 5000;
        }
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

        //
        mGameTunnelVisionLayout.setAlpha((float) (mHungerMeter / 100));
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
        mGameBittenLayout.setBackground(versionCheck(BITTEN_IMAGES[r.nextInt(BITTEN_IMAGES.length - 1)]));
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

        // Check if creature is already in box
        if (!mStageCreatureBox.contains(mStageCreatureID)) {

            // Add creature to box
            for (int special_creature : SPECIAL_CREATURES) {

                if (mStageCreatureID == special_creature) {
                    Log.d(TAG, "checkCreatureBox: Got Em!");

                    mStageCreatureBox.add(mStageCreatureID);
                    buildCreatureTrophycase(mStageCreatureID, (mStageCreatureBox.size() - 1));

                    //
                    playAudio(BAMBOO_CLICK);
                }
            }
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
                    ++mStageFoodChain;

                    // Accelerate timer
                    accelerateTimer(.25);

                    //
                    lessBorder(.5);

                    //
                    for (int creature : GAME_STAGE_CREATURE_BUTTONS) {

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

                    // Decelerate timer
                    decelerateTimer(.5);

                    // Reveal border
                    moreBorder(.25);

                    //
                    for (int creature : GAME_STAGE_CREATURE_BUTTONS) {

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
                    for (int creature : GAME_STAGE_CREATURE_BUTTONS) {
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
                        switchCreature(R.id.game_creature_01_image_button);

                        // Capture creature
                        mStageCreatureID = mStageCreature02ID;
                        mStageCreature02ID = mCreatureID;

                        //
                        checkCreatureBox();

                        // Regenerate creature
                        switchCreature(R.id.game_creature_02_image_button);

                        // Capture creature
                        mStageCreatureID = mStageCreature03ID;
                        mStageCreature03ID = mCreatureID;

                        //
                        checkCreatureBox();

                        // Regenerate creature
                        switchCreature(R.id.game_creature_03_image_button);

                        // Capture creature
                        mStageCreatureID = mStageCreature04ID;
                        mStageCreature04ID = mCreatureID;

                        //
                        checkCreatureBox();

                        // Regenerate creature
                        switchCreature(R.id.game_creature_04_image_button);

                        // Capture creature
                        mStageCreatureID = mStageCreature05ID;
                        mStageCreature05ID = mCreatureID;

                        //
                        checkCreatureBox();

                        // Regenerate creature
                        switchCreature(R.id.game_creature_05_image_button);

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
        mHungerMeter = 100;
        mBossDowned = true;

        //
        mGameHeaderControlLayout.setVisibility(View.GONE);
        mGameFooterControlLayout.setVisibility(View.GONE);
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
        moveCreature(R.id.game_boss_image_button, R.id.game_main_pg_creature_canvas_layout);

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
            moveCreature(R.id.game_boss_image_button, R.id.game_main_pg_creature_canvas_layout);
        }

        //
        drawScreen();
    }

    // Kill boss
    private void killBoss() {

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
        // This is glitching...
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
            if (mStageFrenzy > mStageLongestFrenzy) {
                mStageLongestFrenzy = mStageFrenzy;
            }

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
                    if (!stage_01_apex) {
                        stage_01_apex = mStageApex;
                    } // Replace if not already true, if it's false, it won't matter anyway.

                    //
                    if (mStageFoodChain > 4) {
                        mStageFoodChain = 5;
                    }
                    if (mStageFoodChain > stage_01_food_chain) {
                        stage_01_food_chain = mStageFoodChain;
                    } // Replace if better - maintain top scores at top

                    //
                    mStageAccuracy = (int) getPercentage(mTurn, mStageCreatureKills);
                    if (mStageAccuracy > stage_01_accuracy) {
                        stage_01_accuracy = mStageAccuracy;
                    } // Replace if better

                    // Scores best time and total time
                    if (mStageTime < stage_01_best_time || stage_01_best_time == 0) {
                        stage_01_best_time = mStageTime;
                    } // Replace if better
                    stage_01_total_time += mStageTime; // This will accumulate regardless

                    // Scores creature kills and collection
                    stage_01_creature_kills += mStageCreatureKills; // This will accumulate regardless

                    //
                    j = 0;

                    // Creature collection
                    for (int creature_captured : mStageCreatureBox) {

                        //
                        i = 0;
                        j = 0;

                        //
                        for (int creature : SPECIAL_CREATURES) {

                            //
                            if (creature == creature_captured) {

                                //
                                stage_01_top_predators_previous.set(i, true);
                                ++j;
                            }

                            //
                            ++i;
                        }
                    }

                    //
                    stage_01_collection = j - 1;

                    // Top scores
                    if (mStageHighestStreak > stage_01_highest_streak) {
                        stage_01_highest_streak = mStageHighestStreak;
                    } // Replace if better
                    if (mStageClosestDeath < stage_01_closest_death) {
                        stage_01_closest_death = mStageClosestDeath;
                    } // Replace if better
                    if (mStageLongestFrenzy > stage_01_longest_frenzy) {
                        stage_01_longest_frenzy = mStageLongestFrenzy;
                    } // Replace if better
                    if (mStageMostCalm > stage_01_most_calm) {
                        stage_01_most_calm = mStageMostCalm;
                    } // Replace if better
                    if (mStageMostFrantic < stage_01_most_frantic) {
                        stage_01_most_frantic = mStageMostFrantic;
                    } // Replace if better

                    break;

                // Ocean
                case 2:

                    // Kill boss
                    ++stage_02_boss_kills;

                    // Stage complete
                    stage_02_complete = mStageComplete;

                    // Scores apex, predator, and accuracy
                    if (!stage_02_apex) {
                        stage_02_apex = mStageApex;
                    } // Replace if not already true, if it's false, it won't matter anyway.

                    //
                    if (mStageFoodChain > stage_02_food_chain) {
                        stage_02_food_chain = mStageFoodChain;
                    } // Replace if better - maintain top scores at top

                    //
                    mStageAccuracy = (int) getPercentage(mTurn, mStageCreatureKills);
                    if (mStageAccuracy > stage_02_accuracy) {
                        stage_02_accuracy = mStageAccuracy;
                    } // Replace if better

                    // Scores best time and total time
                    if (mStageTime < stage_02_best_time || stage_02_best_time == 0) {
                        stage_02_best_time = mStageTime;
                    } // Replace if better
                    stage_02_total_time += mStageTime; // This will accumulate regardless

                    // Scores creature kills and collection
                    stage_02_creature_kills += mStageCreatureKills; // This will accumulate regardless

                    //
                    j = 0;

                    // Creature collection
                    for (int creature_captured : mStageCreatureBox) {

                        //
                        i = 0;
                        j = 0;

                        //
                        for (int creature : SPECIAL_CREATURES) {

                            //
                            if (creature == creature_captured) {

                                //
                                stage_02_top_predators_previous.set(i, true);
                                ++j;
                            }

                            //
                            ++i;
                        }
                    }

                    //
                    stage_02_collection = j - 1;

                    // Top scores
                    if (mStageHighestStreak > stage_02_highest_streak) {
                        stage_02_highest_streak = mStageHighestStreak;
                    } // Replace if better
                    if (mStageClosestDeath < stage_02_closest_death) {
                        stage_02_closest_death = mStageClosestDeath;
                    } // Replace if better
                    if (mStageLongestFrenzy > stage_02_longest_frenzy) {
                        stage_02_longest_frenzy = mStageLongestFrenzy;
                    } // Replace if better
                    if (mStageMostCalm > stage_02_most_calm) {
                        stage_02_most_calm = mStageMostCalm;
                    } // Replace if better
                    if (mStageMostFrantic < stage_02_most_frantic) {
                        stage_02_most_frantic = mStageMostFrantic;
                    } // Replace if better

                    break;

                // Mountain
                case 3:

                    // Kill boss
                    ++stage_03_boss_kills;

                    // Stage complete
                    stage_03_complete = mStageComplete;

                    // Scores apex, predator, and accuracy
                    if (!stage_03_apex) {
                        stage_03_apex = mStageApex;
                    } // Replace if not already true, if it's false, it won't matter anyway.

                    //
                    if (mStageFoodChain > stage_03_food_chain) {
                        stage_03_food_chain = mStageFoodChain;
                    } // Replace if better - maintain top scores at top

                    //
                    mStageAccuracy = (int) getPercentage(mTurn, mStageCreatureKills);
                    if (mStageAccuracy > stage_03_accuracy) {
                        stage_03_accuracy = mStageAccuracy;
                    } // Replace if better

                    // Scores best time and total time
                    if (mStageTime < stage_03_best_time || stage_03_best_time == 0) {
                        stage_03_best_time = mStageTime;
                    } // Replace if better
                    stage_03_total_time += mStageTime; // This will accumulate regardless

                    // Scores creature kills and collection
                    stage_03_creature_kills += mStageCreatureKills; // This will accumulate regardless

                    //
                    j = 0;

                    // Creature collection
                    for (int creature_captured : mStageCreatureBox) {

                        //
                        i = 0;
                        j = 0;

                        //
                        for (int creature : SPECIAL_CREATURES) {

                            //
                            if (creature == creature_captured) {

                                //
                                stage_03_top_predators_previous.set(i, true);
                                ++j;
                            }

                            //
                            ++i;
                        }
                    }

                    //
                    stage_03_collection = j - 1;

                    // Top scores
                    if (mStageHighestStreak > stage_03_highest_streak) {
                        stage_03_highest_streak = mStageHighestStreak;
                    } // Replace if better
                    if (mStageClosestDeath < stage_03_closest_death) {
                        stage_03_closest_death = mStageClosestDeath;
                    } // Replace if better
                    if (mStageLongestFrenzy > stage_03_longest_frenzy) {
                        stage_03_longest_frenzy = mStageLongestFrenzy;
                    } // Replace if better
                    if (mStageMostCalm > stage_03_most_calm) {
                        stage_03_most_calm = mStageMostCalm;
                    } // Replace if better
                    if (mStageMostFrantic < stage_03_most_frantic) {
                        stage_03_most_frantic = mStageMostFrantic;
                    } // Replace if better

                    break;

                // Desert
                case 4:

                    // Kill boss
                    ++stage_04_boss_kills;

                    // Stage complete
                    stage_04_complete = mStageComplete;

                    // Scores apex, predator, and accuracy
                    if (!stage_04_apex) {
                        stage_04_apex = mStageApex;
                    } // Replace if not already true, if it's false, it won't matter anyway.

                    //
                    if (mStageFoodChain > stage_04_food_chain) {
                        stage_04_food_chain = mStageFoodChain;
                    } // Replace if better - maintain top scores at top

                    //
                    mStageAccuracy = (int) getPercentage(mTurn, mStageCreatureKills);
                    if (mStageAccuracy > stage_04_accuracy) {
                        stage_04_accuracy = mStageAccuracy;
                    } // Replace if better

                    // Scores best time and total time
                    if (mStageTime < stage_04_best_time || stage_04_best_time == 0) {
                        stage_04_best_time = mStageTime;
                    } // Replace if better
                    stage_04_total_time += mStageTime; // This will accumulate regardless

                    // Scores creature kills and collection
                    stage_04_creature_kills += mStageCreatureKills; // This will accumulate regardless

                    //
                    j = 0;

                    // Creature collection
                    for (int creature_captured : mStageCreatureBox) {

                        //
                        i = 0;
                        j = 0;

                        //
                        for (int creature : SPECIAL_CREATURES) {

                            //
                            if (creature == creature_captured) {

                                //
                                stage_04_top_predators_previous.set(i, true);
                                ++j;
                            }

                            //
                            ++i;
                        }
                    }

                    //
                    stage_04_collection = j - 1;

                    // Top scores
                    if (mStageHighestStreak > stage_04_highest_streak) {
                        stage_04_highest_streak = mStageHighestStreak;
                    } // Replace if better
                    if (mStageClosestDeath < stage_04_closest_death) {
                        stage_04_closest_death = mStageClosestDeath;
                    } // Replace if better
                    if (mStageLongestFrenzy > stage_04_longest_frenzy) {
                        stage_04_longest_frenzy = mStageLongestFrenzy;
                    } // Replace if better
                    if (mStageMostCalm > stage_04_most_calm) {
                        stage_04_most_calm = mStageMostCalm;
                    } // Replace if better
                    if (mStageMostFrantic < stage_04_most_frantic) {
                        stage_04_most_frantic = mStageMostFrantic;
                    } // Replace if better

                    break;

                // Jungle
                case 5:

                    // Kill boss
                    ++stage_05_boss_kills;

                    // Stage complete
                    stage_05_complete = mStageComplete;

                    // Scores apex, predator, and accuracy
                    if (!stage_05_apex) {
                        stage_05_apex = mStageApex;
                    } // Replace if not already true, if it's false, it won't matter anyway.

                    //
                    if (mStageFoodChain > stage_05_food_chain) {
                        stage_05_food_chain = mStageFoodChain;
                    } // Replace if better - maintain top scores at top

                    //
                    mStageAccuracy = (int) getPercentage(mTurn, mStageCreatureKills);
                    if (mStageAccuracy > stage_05_accuracy) {
                        stage_05_accuracy = mStageAccuracy;
                    } // Replace if better

                    // Scores best time and total time
                    if (mStageTime < stage_05_best_time || stage_05_best_time == 0) {
                        stage_05_best_time = mStageTime;
                    } // Replace if better
                    stage_05_total_time += mStageTime; // This will accumulate regardless

                    // Scores creature kills and collection
                    stage_05_creature_kills += mStageCreatureKills; // This will accumulate regardless

                    //
                    j = 0;

                    // Creature collection
                    for (int creature_captured : mStageCreatureBox) {

                        //
                        i = 0;
                        j = 0;

                        //
                        for (int creature : SPECIAL_CREATURES) {

                            //
                            if (creature == creature_captured) {

                                //
                                stage_05_top_predators_previous.set(i, true);
                                ++j;
                            }

                            //
                            ++i;
                        }
                    }

                    //
                    stage_05_collection = j - 1;

                    // Top scores
                    if (mStageHighestStreak > stage_05_highest_streak) {
                        stage_05_highest_streak = mStageHighestStreak;
                    } // Replace if better
                    if (mStageClosestDeath < stage_05_closest_death) {
                        stage_05_closest_death = mStageClosestDeath;
                    } // Replace if better
                    if (mStageLongestFrenzy > stage_05_longest_frenzy) {
                        stage_05_longest_frenzy = mStageLongestFrenzy;
                    } // Replace if better
                    if (mStageMostCalm > stage_05_most_calm) {
                        stage_05_most_calm = mStageMostCalm;
                    } // Replace if better
                    if (mStageMostFrantic < stage_05_most_frantic) {
                        stage_05_most_frantic = mStageMostFrantic;
                    } // Replace if better

                    break;

                // Tundra
                case 6:

                    // Kill boss
                    ++stage_06_boss_kills;

                    // Stage complete
                    stage_06_complete = mStageComplete;

                    // Scores apex, predator, and accuracy
                    if (!stage_06_apex) {
                        stage_06_apex = mStageApex;
                    } // Replace if not already true, if it's false, it won't matter anyway.

                    //
                    if (mStageFoodChain > stage_06_food_chain) {
                        stage_06_food_chain = mStageFoodChain;
                    } // Replace if better - maintain top scores at top

                    //
                    mStageAccuracy = (int) getPercentage(mTurn, mStageCreatureKills);
                    if (mStageAccuracy > stage_06_accuracy) {
                        stage_06_accuracy = mStageAccuracy;
                    } // Replace if better

                    // Scores best time and total time
                    if (mStageTime < stage_06_best_time || stage_06_best_time == 0) {
                        stage_06_best_time = mStageTime;
                    } // Replace if better
                    stage_06_total_time += mStageTime; // This will accumulate regardless

                    // Scores creature kills and collection
                    stage_06_creature_kills += mStageCreatureKills; // This will accumulate regardless

                    //
                    j = 0;

                    // Creature collection
                    for (int creature_captured : mStageCreatureBox) {

                        //
                        i = 0;
                        j = 0;

                        //
                        for (int creature : SPECIAL_CREATURES) {

                            //
                            if (creature == creature_captured) {

                                //
                                stage_06_top_predators_previous.set(i, true);
                                ++j;
                            }

                            //
                            ++i;
                        }
                    }

                    //
                    stage_06_collection = j - 1;

                    // Top scores
                    if (mStageHighestStreak > stage_06_highest_streak) {
                        stage_06_highest_streak = mStageHighestStreak;
                    } // Replace if better
                    if (mStageClosestDeath < stage_06_closest_death) {
                        stage_06_closest_death = mStageClosestDeath;
                    } // Replace if better
                    if (mStageLongestFrenzy > stage_06_longest_frenzy) {
                        stage_06_longest_frenzy = mStageLongestFrenzy;
                    } // Replace if better
                    if (mStageMostCalm > stage_06_most_calm) {
                        stage_06_most_calm = mStageMostCalm;
                    } // Replace if better
                    if (mStageMostFrantic < stage_06_most_frantic) {
                        stage_06_most_frantic = mStageMostFrantic;
                    } // Replace if better

                    break;

                // Final
                case 7:

                    // Kill boss
                    ++stage_07_boss_kills;

                    // Stage complete
                    stage_07_complete = mStageComplete;

                    // Scores apex, predator, and accuracy
                    if (!stage_07_apex) {
                        stage_07_apex = mStageApex;
                    } // Replace if not already true, if it's false, it won't matter anyway.

                    //
                    if (mStageFoodChain > stage_07_food_chain) {
                        stage_07_food_chain = mStageFoodChain;
                    } // Replace if better - maintain top scores at top

                    //
                    mStageAccuracy = (int) getPercentage(mTurn, mStageCreatureKills);
                    if (mStageAccuracy > stage_07_accuracy) {
                        stage_07_accuracy = mStageAccuracy;
                    } // Replace if better

                    // Scores best time and total time
                    if (mStageTime < stage_07_best_time || stage_07_best_time == 0) {
                        stage_07_best_time = mStageTime;
                    } // Replace if better
                    stage_07_total_time += mStageTime; // This will accumulate regardless

                    // Scores creature kills and collection
                    stage_07_creature_kills += mStageCreatureKills; // This will accumulate regardless

                    //
                    j = 0;

                    // Creature collection
                    for (int creature_captured : mStageCreatureBox) {

                        //
                        i = 0;
                        j = 0;

                        //
                        for (int creature : SPECIAL_CREATURES) {

                            //
                            if (creature == creature_captured) {

                                //
                                stage_07_top_predators_previous.set(i, true);
                                ++j;
                            }

                            //
                            ++i;
                        }
                    }

                    //
                    stage_07_collection = j - 1;

                    // Top scores
                    if (mStageHighestStreak > stage_07_highest_streak) {
                        stage_07_highest_streak = mStageHighestStreak;
                    } // Replace if better
                    if (mStageClosestDeath < stage_07_closest_death) {
                        stage_07_closest_death = mStageClosestDeath;
                    } // Replace if better
                    if (mStageLongestFrenzy > stage_07_longest_frenzy) {
                        stage_07_longest_frenzy = mStageLongestFrenzy;
                    } // Replace if better
                    if (mStageMostCalm > stage_07_most_calm) {
                        stage_07_most_calm = mStageMostCalm;
                    } // Replace if better
                    if (mStageMostFrantic < stage_07_most_frantic) {
                        stage_07_most_frantic = mStageMostFrantic;
                    } // Replace if better

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
        mHungerMeter = 100;
        mSpeedIndex = 1000;

        //
        mStageFrenzy = 0;

        //
        mPowerIncrement = 3;

        // Roar
        mPower01Meter = 0;
        mPower01Target = 6;

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
        mStageFoodChain = 0;
        mStageAccuracy = 0f;

        //
        mStageCreatureKills = 0;
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
        for (int scene : STAGE_SCENE_NAMES[mStageIndex - 1]) {

            //
            mStageSceneNames.add(scene);
        }

        // Load stage name
        mGameStageImageView.setBackground(versionCheck(GAME_STAGE_TITLE_IMAGES[mStageIndex - 1]));

        // Load stage border image
        mGameBorderLayout.setBackground(versionCheck(STAGE_BORDERS[mStageIndex - 1]));

        // Load stage disaster image
        mGameDisasterLayout.setBackground(versionCheck(STAGE_DISASTERS[mStageIndex - 1]));

        //
        mGameFlashLayout.setVisibility(View.INVISIBLE);
        mGameBlackoutLayout.setVisibility(View.INVISIBLE);
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
            mStageReady = 3;

            //
            mStageCardScorecardImageButton.setVisibility(View.VISIBLE);
            mStageCardTrophycaseImageButton.setVisibility(View.VISIBLE);

            // Load boss image button
            mGameBossImageButton.setBackground(versionCheck(STAGE_CARD_BOSS_IMAGES[mStageIndex - 1]));

            // Reset trophy case
            resetCreatureTrophycase();

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
        //fadeBlackout();

        Log.d(TAG, "switchScreen: WE GOT TO SWITCHSCREEN!!!");

        // Show screen
        if (mScreenID != -1) {
            for (int id : SCREENS) {
                Log.d(TAG, "switchScreen: WE GOT IN THE SWITCHSCREEN LOOP!!!");
                findViewById(id).setVisibility(mScreenID == id ? View.VISIBLE : View.GONE);
            }
        }

        // ID screen
        mCurScreen = mScreenID;

        Log.d(TAG, "switchScreen: WE GOT PAST SWITCHSCREEN!!!");

        // Draw screen
        drawScreen();

    }

    // Draw screen
    @SuppressLint({"SetTextI18n", "DefaultLocale"})

    public void drawScreen() {

        //
        mTrophycase = false;
        mScorecard = false;
        mContent = true;

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

                //
                resetSelectStageCards();

                // Build stage cards
                buildStageCards();

                // Display stage cards
                mStageSelectScorecardLayout.setVisibility(View.GONE);
                mStageSelectTrophycaseLayout.setVisibility(View.GONE);
                mStageSelectContentLayout.setVisibility(View.VISIBLE);
                mStageSelectContentImageButton.setAlpha(1f);

                // Secret button
                mStageSelectSecretImageButton.setVisibility(View.VISIBLE);

                // Hide top scores button if none
                if (!stage_01_complete) {

                    //
                    mStageSelectScorecardImageButton.setVisibility(View.GONE);
                    mStageSelectTrophycaseImageButton.setVisibility(View.GONE);
                    mStageSelectContentImageButton.setVisibility(View.GONE);

                } else {

                    //
                    buildGameTrophyCase();
                    buildGameScores();

                    //
                    mStageSelectScorecardImageButton.setVisibility(View.VISIBLE);
                    mStageSelectTrophycaseImageButton.setVisibility(View.VISIBLE);
                    mStageSelectContentImageButton.setVisibility(View.VISIBLE);
                    mStageSelectScorecardImageButton.setAlpha(.5f);
                    mStageSelectTrophycaseImageButton.setAlpha(.5f);
                }

                break;

            case R.id.stage_card_screen_main_layout:

                //
                mStageCardContentTitleImageButton.setBackground(versionCheck(STAGE_CARD_TITLE_IMAGES[mStageIndex - 1]));
                mStageCardContentTitleLayout.setBackgroundColor(ContextCompat.getColor(this, STAGE_COLOR[mStageIndex - 1]));
                mStageCardBossNameTextView.setText(STAGE_CARD_BOSS_NAME_STRINGS[mStageIndex - 1]);
                //mStageCardPowerNameTextView.setText(POWER_NAME[mStageIndex - 1]);
                //mStageCardDisasterNameTextView.setText(DISASTER_NAME[mStageIndex - 1]);
                mStageCardScreenBodyLayout.setBackground(versionCheck(STAGE_CARD_BG[mStageIndex - 1]));

                // Load stage resources
                mStageCardBossImageView.setBackground(versionCheck(STAGE_CARD_BOSS_IMAGES[mStageIndex - 1]));
                mStageCardPowerImageView.setBackground(versionCheck(STAGE_CARD_POWER_IMAGES[mStageIndex - 1]));
                mStageCardDisasterImageView.setBackground(versionCheck(STAGE_DISASTERS[mStageIndex - 1]));

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
                        mStageCardTrophycaseImageButton.setVisibility(View.GONE);
                        mStageCardScorecardImageButton.setVisibility(View.GONE);
                        mStageCardContentImageButton.setVisibility(View.GONE);

                        //
                        mStageCardTrophycaseLayout.setVisibility(View.GONE);
                        mStageCardScorecardLayout.setVisibility(View.GONE);
                        mStageCardContentLayout.setVisibility(View.GONE);

                        //
                        mStageCardCompleteLayout.setVisibility(View.GONE);
                        mStageCardEatenLayout.setVisibility(View.GONE);
                        mStageCardLockedLayout.setVisibility(View.VISIBLE);

                        //
                        mStageCardContentTitleLayout.setBackgroundColor(Color.BLACK);

                        break;

                    // Case - Stage Ready
                    case 2:

                        //
                        mStageCardTrophycaseImageButton.setVisibility(View.GONE);
                        mStageCardScorecardImageButton.setVisibility(View.GONE);
                        mStageCardContentImageButton.setVisibility(View.VISIBLE);

                        //
                        mStageCardContentImageButton.setAlpha(1f);

                        //
                        if (mStageComplete) {

                            //
                            mStageCardTrophycaseImageButton.setVisibility(View.VISIBLE);
                            mStageCardScorecardImageButton.setVisibility(View.VISIBLE);

                            //
                            mStageCardTrophycaseImageButton.setAlpha(.5f);
                            mStageCardScorecardImageButton.setAlpha(.5f);
                        }

                        //
                        mStageCardTrophycaseLayout.setVisibility(View.GONE);
                        mStageCardScorecardLayout.setVisibility(View.GONE);
                        mStageCardContentLayout.setVisibility(View.VISIBLE);

                        //
                        mStageCardCompleteLayout.setVisibility(View.GONE);
                        mStageCardEatenLayout.setVisibility(View.GONE);
                        mStageCardLockedLayout.setVisibility(View.GONE);

                        //
                        mStageCardContentTitleLayout.setBackgroundColor(ContextCompat.getColor(this, STAGE_COLOR[mStageIndex - 1]));

                        break;

                    // Case - Stage Complete[d]
                    case 3:

                        //
                        mStageCardTrophycaseImageButton.setVisibility(View.VISIBLE);
                        mStageCardScorecardImageButton.setVisibility(View.VISIBLE);
                        mStageCardContentImageButton.setVisibility(View.VISIBLE);

                        //
                        mStageCardTrophycaseImageButton.setAlpha(.5f);
                        mStageCardScorecardImageButton.setAlpha(.5f);
                        mStageCardContentImageButton.setAlpha(1f);

                        //
                        mStageCardTrophycaseLayout.setVisibility(View.GONE);
                        mStageCardScorecardLayout.setVisibility(View.GONE);
                        mStageCardContentLayout.setVisibility(View.GONE);

                        //
                        mStageCardCompleteLayout.setVisibility(View.VISIBLE);
                        mStageCardEatenLayout.setVisibility(View.GONE);
                        mStageCardLockedLayout.setVisibility(View.GONE);

                        //
                        mStageCardContentTitleLayout.setBackgroundColor(ContextCompat.getColor(this, STAGE_COLOR[mStageIndex - 1]));

                        break;

                    // Case - Stage Over
                    case 4:

                        //
                        mStageCardTrophycaseImageButton.setVisibility(View.GONE);
                        mStageCardScorecardImageButton.setVisibility(View.GONE);
                        mStageCardContentImageButton.setVisibility(View.VISIBLE);

                        //
                        mStageCardContentImageButton.setAlpha(1f);

                        //
                        if (mStageComplete) {

                            //
                            mStageCardTrophycaseImageButton.setVisibility(View.VISIBLE);
                            mStageCardScorecardImageButton.setVisibility(View.VISIBLE);

                            //
                            mStageCardTrophycaseImageButton.setAlpha(.5f);
                            mStageCardScorecardImageButton.setAlpha(.5f);
                        }

                        //
                        mStageCardTrophycaseLayout.setVisibility(View.GONE);
                        mStageCardScorecardLayout.setVisibility(View.GONE);
                        mStageCardContentLayout.setVisibility(View.GONE);

                        //
                        mStageCardCompleteLayout.setVisibility(View.GONE);
                        mStageCardEatenLayout.setVisibility(View.VISIBLE);
                        mStageCardLockedLayout.setVisibility(View.GONE);

                        //
                        mStageCardContentTitleLayout.setBackgroundColor(ContextCompat.getColor(this, STAGE_COLOR[mStageIndex - 1]));

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

    // Resest Stage Cards
    private void resetSelectStageCards() {

        //
        mStageSelectContentStage01TitleImageView.setVisibility(View.INVISIBLE);
        mStageSelectContentStage01StatusImageButton.setVisibility(View.INVISIBLE);
        mStageSelectContentStage01ColorLayout.setVisibility(View.INVISIBLE);
        mStageSelectContentStage01StatusTextView.setVisibility(View.INVISIBLE);
        mStageSelectContentStage01ProgressTextView.setVisibility(View.INVISIBLE);
        mStageSelectContentStage01ProgressBar.setVisibility(View.INVISIBLE);
        mStageSelectContentStage01BGLayout.setVisibility(View.INVISIBLE);

        //
        mStageSelectContentStage02TitleImageView.setVisibility(View.INVISIBLE);
        mStageSelectContentStage02StatusImageButton.setVisibility(View.INVISIBLE);
        mStageSelectContentStage02ColorLayout.setVisibility(View.INVISIBLE);
        mStageSelectContentStage02StatusTextView.setVisibility(View.INVISIBLE);
        mStageSelectContentStage02ProgressTextView.setVisibility(View.INVISIBLE);
        mStageSelectContentStage02ProgressBar.setVisibility(View.INVISIBLE);
        mStageSelectContentStage02BGLayout.setVisibility(View.INVISIBLE);

        //
        mStageSelectContentStage03TitleImageView.setVisibility(View.INVISIBLE);
        mStageSelectContentStage03StatusImageButton.setVisibility(View.INVISIBLE);
        mStageSelectContentStage03ColorLayout.setVisibility(View.INVISIBLE);
        mStageSelectContentStage03StatusTextView.setVisibility(View.INVISIBLE);
        mStageSelectContentStage03ProgressTextView.setVisibility(View.INVISIBLE);
        mStageSelectContentStage03ProgressBar.setVisibility(View.INVISIBLE);
        mStageSelectContentStage03BGLayout.setVisibility(View.INVISIBLE);

        //
        mStageSelectContentStage04TitleImageView.setVisibility(View.INVISIBLE);
        mStageSelectContentStage04StatusImageButton.setVisibility(View.INVISIBLE);
        mStageSelectContentStage04ColorLayout.setVisibility(View.INVISIBLE);
        mStageSelectContentStage04StatusTextView.setVisibility(View.INVISIBLE);
        mStageSelectContentStage04ProgressTextView.setVisibility(View.INVISIBLE);
        mStageSelectContentStage04ProgressBar.setVisibility(View.INVISIBLE);
        mStageSelectContentStage04BGLayout.setVisibility(View.INVISIBLE);

        //
        mStageSelectContentStage05TitleImageView.setVisibility(View.INVISIBLE);
        mStageSelectContentStage05StatusImageButton.setVisibility(View.INVISIBLE);
        mStageSelectContentStage05ColorLayout.setVisibility(View.INVISIBLE);
        mStageSelectContentStage05StatusTextView.setVisibility(View.INVISIBLE);
        mStageSelectContentStage05ProgressTextView.setVisibility(View.INVISIBLE);
        mStageSelectContentStage05ProgressBar.setVisibility(View.INVISIBLE);
        mStageSelectContentStage05BGLayout.setVisibility(View.INVISIBLE);

        //
        mStageSelectContentStage06TitleImageView.setVisibility(View.INVISIBLE);
        mStageSelectContentStage06StatusImageButton.setVisibility(View.INVISIBLE);
        mStageSelectContentStage06ColorLayout.setVisibility(View.INVISIBLE);
        mStageSelectContentStage06StatusTextView.setVisibility(View.INVISIBLE);
        mStageSelectContentStage06ProgressTextView.setVisibility(View.INVISIBLE);
        mStageSelectContentStage06ProgressBar.setVisibility(View.INVISIBLE);
        mStageSelectContentStage06BGLayout.setVisibility(View.INVISIBLE);

        //
        mStageSelectContentStage07TitleImageView.setVisibility(View.INVISIBLE);
        mStageSelectContentStage07StatusImageButton.setVisibility(View.INVISIBLE);
        mStageSelectContentStage07ColorLayout.setVisibility(View.INVISIBLE);
        mStageSelectContentStage07StatusTextView.setVisibility(View.INVISIBLE);
        mStageSelectContentStage07ProgressTextView.setVisibility(View.INVISIBLE);
        mStageSelectContentStage07ProgressBar.setVisibility(View.INVISIBLE);
        mStageSelectContentStage07BGLayout.setVisibility(View.INVISIBLE);
    }

    // Check power display
    public void checkPowers() {

        // Power 1
        if (mPower01Meter >= mPower01Target) {
            mGamePower01ImageButton.setVisibility(View.VISIBLE);
        } else {
            mGamePower01ImageButton.setVisibility(View.INVISIBLE);
        }

        // Power 2
        if (stage_01_complete) {

            //
            if (mPower02Meter >= mPower02Target) {
                mGamePower02ImageButton.setVisibility(View.VISIBLE);
            } else {
                mGamePower02ImageButton.setVisibility(View.INVISIBLE);
            }

        } else {
            mGamePower02ImageButton.setVisibility(View.GONE);
        }

        // Power 5
        if (stage_02_complete) {

            if (mPower05Meter >= mPower05Target) {
                mGamePower05ImageButton.setVisibility(View.VISIBLE);
            } else {
                mGamePower05ImageButton.setVisibility(View.INVISIBLE);
            }

        } else {
            mGamePower05ImageButton.setVisibility(View.GONE);
        }

        // Power 4
        if (stage_03_complete) {

            if (mPower04Meter >= mPower04Target) {
                mGamePower04ImageButton.setVisibility(View.VISIBLE);
            } else {
                mGamePower04ImageButton.setVisibility(View.INVISIBLE);
            }

        } else {
            mGamePower04ImageButton.setVisibility(View.GONE);
        }

        // Power 6
        if (stage_04_complete) {

            if (mPower06Meter >= mPower06Target) {
                mGamePower06ImageButton.setVisibility(View.VISIBLE);
            } else {
                mGamePower06ImageButton.setVisibility(View.INVISIBLE);
            }

        } else {
            mGamePower06ImageButton.setVisibility(View.GONE);
        }
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
        mGameTunnelVisionLayout.setAlpha((float) (mHungerMeter / 100));
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

            if (mTapTotal < GAME_SCENE_LAYOUTS.length) {

                //
                findViewById(GAME_SCENE_LAYOUTS[mTapTotal]).setBackground(versionCheck(STAGE_DISASTERS[mStageIndex - 1]));
            }
            //
            tapOut();
        }

        //
        if (stage_03_complete) {
            //
            if (mTapCount < mTapBarrel) {

                // Adjust view visibility
                mGamePower03ImageButton.setVisibility(View.INVISIBLE);
            }
            mGamePower03ImageButton.setVisibility(View.VISIBLE);
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
        if (mBittenMeter < 0) {
            mBittenMeter = 0;
        }
        if (mBittenMeter > 19) {
            mBittenMeter = 19;
        }
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
        if (mStreakCount >= mStageHighestStreak || mStageHighestStreak == 0) {
            mStageHighestStreak = mStreakCount;
        }

        // Check target
        if (mTapCount >= mTapBarrel) {

            //
            mGamePower05ImageButton.setVisibility(View.VISIBLE);

            // Play audio
            playAudio(CROW_AUDIO);

        } else {

            //
            mGamePower05ImageButton.setVisibility(View.INVISIBLE);

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
        ++mTapBarrel;

        //
        if (mTapTotal == mStageSceneImages.size()) {

            // Start boss
            mCreatureGameOver = true;

        } else {

            //
            switchEnvironment();

            //
            //removeBG();

            //
            if (!(mTapTotal > GAME_SCENE_LAYOUTS.length - 1)) {

                //
                findViewById(GAME_SCENE_LAYOUTS[mTapTotal - 1]).setAlpha(1f);
                findViewById(GAME_SCENE_LAYOUTS[mTapTotal]).setAlpha(1f);
                //findViewById(LEVEL_MARKERS[mTapTotal]).setBackground(versionCheck(BOSS_IMAGES[mStageIndex - 1]));

            } else {

                //
                for (int scene : GAME_SCENE_LAYOUTS) {
                    findViewById(scene).setAlpha(1f);
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

        // Stage card bg [resource]
        for (int card : STAGE_SELECT_CONTENT_CARD_LAYOUTS) {

            // BG image [asset]
            findViewById(card).setBackground(versionCheck(STAGE_SELECT_CONTENT_BG_IMAGES[i]));

            //
            ++i;
        }

        //
        i = 0;

        // Stage card titles [resource]
        for (int card_title : STAGE_SELECT_CONTENT_TITLE_IMAGE_VIEWS) {

            // Title image [asset]
            findViewById(card_title).setBackground(versionCheck(STAGE_SELECT_CONTENT_TITLE_IMAGES[i]));

            //
            ++i;
        }

        //
        i = 0;

        // Stage icon [resource]
        for (int card_icon : STAGE_SELECT_CONTENT_STATUS_IMAGE_BUTTONS) {

            // Icon image [asset]
            findViewById(card_icon).setBackground(versionCheck(STAGE_SELECT_CONTENT_STATUS_IMAGES[0]));

            //
            if (stage_complete[i]) {

                // Icon image [asset]
                findViewById(card_icon).setBackground(versionCheck(STAGE_SELECT_CONTENT_STATUS_IMAGES[1]));

            }

            //
            if (i > 0 && !stage_complete[i - 1]) {

                // Icon image [asset]
                findViewById(card_icon).setBackground(versionCheck(STAGE_SELECT_CONTENT_STATUS_IMAGES[2]));
            }

            //
            ++i;
        }

        //
        i = 0;

        // Stage status [resource]
        for (int card_status : STAGE_SELECT_CONTENT_STATUS_TEXT_VIEWS) {

            // Status string [asset]
            TextView mText = findViewById(card_status);
            mText.setText(STAGE_SELECT_CONTENT_STATUS_STRINGS[0]);

            //
            if (i > 0 && !stage_complete[i - 1]) {

                // Status string [asset]
                mText.setText(STAGE_SELECT_CONTENT_STATUS_STRINGS[1]);
            }

            //
            if (stage_complete[i]) {

                // Status string [asset]
                mText.setText(STAGE_SELECT_CONTENT_STATUS_STRINGS[2]);
                ++journey_score;
            }

            //
            ++i;
        }

        //
        i = 0;

        // Stage hilite [resource]
        for (int hilite : STAGE_SELECT_CONTENT_PROGRESS_BARS) {

            // Color [asset]
            findViewById(hilite).setBackgroundColor(ContextCompat.getColor(this, (STAGE_SELECT_CONTENT_COLOR_VALUES[i])));
            findViewById(hilite).setAlpha(1f);

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
        i = 99;

        // Stage progress [resource]
        for (int card_progress : STAGE_SELECT_CONTENT_PROGRESS_BARS) {

            // Stage progress [asset]
            ProgressBar mProgress = findViewById(card_progress);
            mProgress.setProgress(getStageProgressValue(i));
        }

        //
        i = 0;

        // Stage progress [resource]
        for (int card_progress_text : STAGE_SELECT_CONTENT_PROGRESS_TEXT_VIEWS) {

            // Stage progress [asset]
            TextView mText = findViewById(card_progress_text);
            mText.setText(getStageProgressText(i));

            //
            ++i;
        }

        //
        revealStageCards();

        //
        mStageSelectContentProgressTextView.setText(Float.toString((int) getPercentage(7, journey_score)));
        mStageSelectContentProgressBar.setProgress((int) getPercentage(7, journey_score));
    }

    //
    private void revealStageCards() {

        //
        mStageSelectContentStage01TitleImageView.setVisibility(View.VISIBLE);
        mStageSelectContentStage01StatusImageButton.setVisibility(View.VISIBLE);
        mStageSelectContentStage01ColorLayout.setVisibility(View.VISIBLE);
        mStageSelectContentStage01StatusTextView.setVisibility(View.VISIBLE);
        mStageSelectContentStage01ProgressTextView.setVisibility(View.VISIBLE);
        mStageSelectContentStage01ProgressBar.setVisibility(View.VISIBLE);
        mStageSelectContentStage01BGLayout.setVisibility(View.VISIBLE);

        //
        mStageSelectContentStage02TitleImageView.setVisibility(View.VISIBLE);
        mStageSelectContentStage02StatusImageButton.setVisibility(View.VISIBLE);
        mStageSelectContentStage02ColorLayout.setVisibility(View.VISIBLE);
        mStageSelectContentStage02StatusTextView.setVisibility(View.VISIBLE);
        mStageSelectContentStage02ProgressTextView.setVisibility(View.VISIBLE);
        mStageSelectContentStage02ProgressBar.setVisibility(View.VISIBLE);
        mStageSelectContentStage02BGLayout.setVisibility(View.VISIBLE);

        //
        mStageSelectContentStage03TitleImageView.setVisibility(View.VISIBLE);
        mStageSelectContentStage03StatusImageButton.setVisibility(View.VISIBLE);
        mStageSelectContentStage03ColorLayout.setVisibility(View.VISIBLE);
        mStageSelectContentStage03StatusTextView.setVisibility(View.VISIBLE);
        mStageSelectContentStage03ProgressTextView.setVisibility(View.VISIBLE);
        mStageSelectContentStage03ProgressBar.setVisibility(View.VISIBLE);
        mStageSelectContentStage03BGLayout.setVisibility(View.VISIBLE);

        //
        mStageSelectContentStage04TitleImageView.setVisibility(View.VISIBLE);
        mStageSelectContentStage04StatusImageButton.setVisibility(View.VISIBLE);
        mStageSelectContentStage04ColorLayout.setVisibility(View.VISIBLE);
        mStageSelectContentStage04StatusTextView.setVisibility(View.VISIBLE);
        mStageSelectContentStage04ProgressTextView.setVisibility(View.VISIBLE);
        mStageSelectContentStage04ProgressBar.setVisibility(View.VISIBLE);
        mStageSelectContentStage04BGLayout.setVisibility(View.VISIBLE);

        //
        mStageSelectContentStage05TitleImageView.setVisibility(View.VISIBLE);
        mStageSelectContentStage05StatusImageButton.setVisibility(View.VISIBLE);
        mStageSelectContentStage05ColorLayout.setVisibility(View.VISIBLE);
        mStageSelectContentStage05StatusTextView.setVisibility(View.VISIBLE);
        mStageSelectContentStage05ProgressTextView.setVisibility(View.VISIBLE);
        mStageSelectContentStage05ProgressBar.setVisibility(View.VISIBLE);
        mStageSelectContentStage05BGLayout.setVisibility(View.VISIBLE);

        //
        mStageSelectContentStage06TitleImageView.setVisibility(View.VISIBLE);
        mStageSelectContentStage06StatusImageButton.setVisibility(View.VISIBLE);
        mStageSelectContentStage06ColorLayout.setVisibility(View.VISIBLE);
        mStageSelectContentStage06StatusTextView.setVisibility(View.VISIBLE);
        mStageSelectContentStage06ProgressTextView.setVisibility(View.VISIBLE);
        mStageSelectContentStage06ProgressBar.setVisibility(View.VISIBLE);
        mStageSelectContentStage06BGLayout.setVisibility(View.VISIBLE);

        //
        mStageSelectContentStage07TitleImageView.setVisibility(View.VISIBLE);
        mStageSelectContentStage07StatusImageButton.setVisibility(View.VISIBLE);
        mStageSelectContentStage07ColorLayout.setVisibility(View.VISIBLE);
        mStageSelectContentStage07StatusTextView.setVisibility(View.VISIBLE);
        mStageSelectContentStage07ProgressTextView.setVisibility(View.VISIBLE);
        mStageSelectContentStage07ProgressBar.setVisibility(View.VISIBLE);
        mStageSelectContentStage07BGLayout.setVisibility(View.VISIBLE);
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
                int mSceneID = mStageSceneNames.get(mStageSceneImages.indexOf(mEnvironmentID));

                //
                Drawable mEnvironmentDrawable;

                //
                mEnvironmentDrawable = versionCheck(mEnvironmentID);
                mGameCreatureLayout.setBackground(mEnvironmentDrawable);
                mGameSceneImageView.setBackground(versionCheck(mSceneID));
            } catch (IndexOutOfBoundsException e) {

                Log.d(TAG, "switchEnvironment: " + e);
            } finally {
                // Play bg audio
                playAudio(BG_AUDIO);

            }

        }
    }

    // Test stage complete
    private void getStageStatus(int stage_index) {

        //


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
        int randomSelection = r.nextInt(34);

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
        findViewById(GAME_STAGE_SPLATTER_IMAGE_VIEWS[splatter]).setVisibility(View.INVISIBLE);

        //
        float splatterX = findViewById(creature).getX();
        float splatterY = findViewById(creature).getY();

        //
        findViewById(GAME_STAGE_SPLATTER_IMAGE_VIEWS[splatter]).setX(splatterX);
        findViewById(GAME_STAGE_SPLATTER_IMAGE_VIEWS[splatter]).setY(splatterY);

        //
        findViewById(GAME_STAGE_SPLATTER_IMAGE_VIEWS[splatter]).setVisibility(View.VISIBLE);
        fadeSplatter(GAME_STAGE_SPLATTER_IMAGE_VIEWS[splatter]);

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
                showCreature(GAME_STAGE_CREATURE_BUTTONS[r.nextInt(5)]);
            }
        }
    }

    // Initial creature spread
    private void setStage() {

        //
        for (int creature : GAME_STAGE_CREATURE_BUTTONS) {

            //
            switchCreature(creature);

            //
            switch (creature) {

                //
                case R.id.game_creature_01_image_button:

                    //
                    mStageCreature01ID = mCreatureID;

                    break;

                //
                case R.id.game_creature_02_image_button:

                    //
                    mStageCreature02ID = mCreatureID;

                    break;

                //
                case R.id.game_creature_03_image_button:

                    //
                    mStageCreature03ID = mCreatureID;

                    break;

                //
                case R.id.game_creature_04_image_button:

                    //
                    mStageCreature04ID = mCreatureID;

                    break;

                //
                case R.id.game_creature_05_image_button:

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
        View screenImage = findViewById(R.id.game_boss_image_button);
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.boss_fade_in);
        fadeAnimation.setFillAfter(true);
        screenImage.startAnimation(fadeAnimation);
    }

    // Fade flash
    private void fadeDisaster() {

        //
        View screenImage = findViewById(R.id.game_disaster_layout);
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_flash);
        fadeAnimation.setFillAfter(true);
        screenImage.startAnimation(fadeAnimation);
    }

    // Fade flash
    private void fadeBloodsplat() {

        //
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_flash);
        fadeAnimation.setFillAfter(true);
        mGameBittenLayout.startAnimation(fadeAnimation);
    }

    // Fade flash
    private void fadeFlash() {

        //
        View screenImage = findViewById(R.id.game_fade_white_layout);
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_flash);
        fadeAnimation.setFillAfter(true);
        screenImage.startAnimation(fadeAnimation);
    }

    // Fade blackout
    private void fadeBlackout() {

        //
        View screenImage = findViewById(R.id.game_fade_black_layout);
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return context.getResources().getDrawable(mID, getTheme());
        } else {
            return context.getResources().getDrawable(mID);
        }
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
        if (turns < 1) {
            turns = 1;
        }

        // Build and return float average of turns and hits
        return (100 * (float) hits) / ((float) turns);
    }

    //
    private int getStageProgressValue(int stage_index) {

        //
        int progress_value = 99;

        // TODO - Add functionality


        //
        return progress_value;
    }

    //
    private String getStageProgressText(int stage_index) {

        //
        String progress_text = "99";

        // TODO - Add functionality

        //
        return progress_text;
    }

    // Reset level markers [Adapt to update stage bg images / creature capture images]
    private void resetLevelMarkers() {

        //
        int marker_index = 0;
        int bg_image_index = 0;

        // Replace bg image
        for (int marker : GAME_SCENE_LAYOUTS) {

            //
            findViewById(marker).setBackground(versionCheck(STAGE_PREDATORS[mStageIndex - 1][marker_index]));
            findViewById(marker).setAlpha(.25f);

            //
            ++marker_index;
        }

        //
        for (int bg_image : GAME_BOARD_CAPTURE_IMAGE_VIEWS) {

            //
            findViewById(bg_image).setBackground(versionCheck(STAGE_SCENES[mStageIndex - 1][bg_image_index]));
            findViewById(bg_image).setAlpha(.25f);

            //
            ++bg_image_index;
        }

        // Reveal markers
        mGameHeaderControlLayout.setVisibility(View.VISIBLE);
    }

    // Build game scores - GAME EOBE SCORES
    private void buildGameScores() {

        //
        int game_score = 0;

        //
        mStageSelectScorecardApexBadgeImageView.setVisibility(View.INVISIBLE);
        mStageSelectScorecardPredatorBadgeImageView.setVisibility(View.INVISIBLE);
        mStageSelectScorecardAccuracyBadgeImageView.setVisibility(View.INVISIBLE);
        mStageSelectScorecardTimeBadgeImageView.setVisibility(View.INVISIBLE);
        mStageSelectScorecardKillsBadgeImageView.setVisibility(View.INVISIBLE);
        mStageSelectScorecardStreakBadgeImageView.setVisibility(View.INVISIBLE);
        mStageSelectScorecardDeathBadgeImageView.setVisibility(View.INVISIBLE);
        mStageSelectScorecardFrenzyBadgeImageView.setVisibility(View.INVISIBLE);
        mStageSelectScorecardCalmBadgeImageView.setVisibility(View.INVISIBLE);
        mStageSelectScorecardFranticBadgeImageView.setVisibility(View.INVISIBLE);

        mStageSelectScorecardApexLayout.setVisibility(View.GONE);
        mStageSelectScorecardPredatorLayout.setVisibility(View.GONE);
        mStageSelectScorecardAccuracyLayout.setVisibility(View.GONE);
        mStageSelectScorecardTimeLayout.setVisibility(View.GONE);
        mStageSelectScorecardKillsLayout.setVisibility(View.GONE);
        mStageSelectScorecardStreakLayout.setVisibility(View.GONE);
        mStageSelectScorecardDeathLayout.setVisibility(View.GONE);
        mStageSelectScorecardFrenzyLayout.setVisibility(View.GONE);
        mStageSelectScorecardCalmLayout.setVisibility(View.GONE);
        mStageSelectScorecardFranticLayout.setVisibility(View.GONE);

        // Destroy every stage
        if (mGameApex) {

            //
            ++game_score;

            //
            mStageSelectScorecardApexBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            mStageSelectScorecardApexBadgeImageView.setVisibility(View.VISIBLE);
            mStageSelectScorecardApexLayout.setVisibility(View.VISIBLE);
        }

        // Achieve top predator in every stage
        if (mGameFoodChain > 29) {

            //
            ++game_score;

            //
            mStageSelectScorecardPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            mStageSelectScorecardPredatorBadgeImageView.setVisibility(View.VISIBLE);
            mStageSelectScorecardPredatorLayout.setVisibility(View.VISIBLE);
        }

        // Achieve 100% accuracy in every stage
        if (mGameAccuracy > 99) {

            //
            ++game_score;

            //
            mStageSelectScorecardAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            mStageSelectScorecardAccuracyBadgeImageView.setVisibility(View.VISIBLE);
            mStageSelectScorecardAccuracyLayout.setVisibility(View.VISIBLE);
        }

        // Complete each stage in under 60 seconds
        if (mGameTimeBest) {

            //
            ++game_score;

            //
            mStageSelectScorecardTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            mStageSelectScorecardTimeBadgeImageView.setVisibility(View.VISIBLE);
            mStageSelectScorecardTimeLayout.setVisibility(View.VISIBLE);
        }

        // Kill 1000 creatures
        if (mGameCreatureKills > 999) {

            //
            ++game_score;

            //
            mStageSelectScorecardKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            mStageSelectScorecardKillsBadgeImageView.setVisibility(View.VISIBLE);
            mStageSelectScorecardKillsLayout.setVisibility(View.VISIBLE);
        }

        // Achieve a high streak of 50+
        if (mGameHighestStreak > 50) {

            //
            ++game_score;

            //
            mStageSelectScorecardStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            mStageSelectScorecardStreakBadgeImageView.setVisibility(View.VISIBLE);
            mStageSelectScorecardStreakLayout.setVisibility(View.VISIBLE);
        }

        // Achieve closest to death of 3 heartbeats
        if (mGameClosestDeath < 4) {

            //
            ++game_score;

            //
            mStageSelectScorecardDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            mStageSelectScorecardDeathBadgeImageView.setVisibility(View.VISIBLE);
            mStageSelectScorecardDeathLayout.setVisibility(View.VISIBLE);
        }

        // Achieve longest frenzy of 20+
        if (mGameLongestFrenzy > 19) {

            //
            ++game_score;

            //
            mStageSelectScorecardFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            mStageSelectScorecardFrenzyBadgeImageView.setVisibility(View.VISIBLE);
            mStageSelectScorecardFrenzyLayout.setVisibility(View.VISIBLE);
        }

        // Achieve adrenaline score 2000+
        if (mGameMostCalm > 1999) {

            //
            ++game_score;

            //
            mStageSelectScorecardCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            mStageSelectScorecardCalmBadgeImageView.setVisibility(View.VISIBLE);
            mStageSelectScorecardCalmLayout.setVisibility(View.VISIBLE);
        }

        // Achieve adrenaline score 50-
        if (mGameMostFrantic < 51) {

            //
            ++game_score;

            //
            mStageSelectScorecardFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            mStageSelectScorecardFranticBadgeImageView.setVisibility(View.VISIBLE);
            mStageSelectScorecardFranticLayout.setVisibility(View.VISIBLE);
        }

        //
        mStageSelectScorecardProgressTextView.setText((Float.toString((int) getPercentage(10, game_score))));
        mStageSelectScorecardProgressBar.setProgress((int) getPercentage(10, game_score));
    }

    // Build game trophy case - GAME EOBE TROPHY
    private void buildGameTrophyCase() {

        //
        int mBossCount = 0;

        //
        mStageSelectTrophycaseStage01Layout.setVisibility(View.INVISIBLE);
        mStageSelectTrophycaseStage02Layout.setVisibility(View.INVISIBLE);
        mStageSelectTrophycaseStage03Layout.setVisibility(View.INVISIBLE);
        mStageSelectTrophycaseStage04Layout.setVisibility(View.INVISIBLE);
        mStageSelectTrophycaseStage05Layout.setVisibility(View.INVISIBLE);
        mStageSelectTrophycaseStage06Layout.setVisibility(View.INVISIBLE);
        mStageSelectTrophycaseStage07Layout.setVisibility(View.INVISIBLE);

        //
        mStageSelectTrophycaseStage01TrophyImageView.setBackground(versionCheck(R.drawable.game_unknown_creature_image));
        mStageSelectTrophycaseStage02TrophyImageView.setBackground(versionCheck(R.drawable.game_unknown_creature_image));
        mStageSelectTrophycaseStage03TrophyImageView.setBackground(versionCheck(R.drawable.game_unknown_creature_image));
        mStageSelectTrophycaseStage04TrophyImageView.setBackground(versionCheck(R.drawable.game_unknown_creature_image));
        mStageSelectTrophycaseStage05TrophyImageView.setBackground(versionCheck(R.drawable.game_unknown_creature_image));
        mStageSelectTrophycaseStage06TrophyImageView.setBackground(versionCheck(R.drawable.game_unknown_creature_image));
        mStageSelectTrophycaseStage07TrophyImageView.setBackground(versionCheck(R.drawable.game_unknown_creature_image));

        //
        if (stage_01_complete) {
            mStageSelectTrophycaseStage01TrophyImageView.setBackground(versionCheck(R.drawable.stage_01_boss_image));
            ++mBossCount;
        }
        mStageSelectTrophycaseStage01Layout.setVisibility(View.VISIBLE);
        if (stage_02_complete) {
            mStageSelectTrophycaseStage02TrophyImageView.setBackground(versionCheck(R.drawable.stage_02_boss_image));
            ++mBossCount;
        }
        mStageSelectTrophycaseStage02Layout.setVisibility(View.VISIBLE);
        if (stage_03_complete) {
            mStageSelectTrophycaseStage03TrophyImageView.setBackground(versionCheck(R.drawable.stage_03_boss_image));
            ++mBossCount;
        }
        mStageSelectTrophycaseStage03Layout.setVisibility(View.VISIBLE);
        if (stage_04_complete) {
            mStageSelectTrophycaseStage04TrophyImageView.setBackground(versionCheck(R.drawable.stage_04_boss_image));
            ++mBossCount;
        }
        mStageSelectTrophycaseStage04Layout.setVisibility(View.VISIBLE);
        if (stage_05_complete) {
            mStageSelectTrophycaseStage05TrophyImageView.setBackground(versionCheck(R.drawable.stage_05_boss_image));
            ++mBossCount;
        }
        mStageSelectTrophycaseStage05Layout.setVisibility(View.VISIBLE);
        if (stage_06_complete) {
            mStageSelectTrophycaseStage06TrophyImageView.setBackground(versionCheck(R.drawable.stage_06_boss_image));
            ++mBossCount;
        }
        mStageSelectTrophycaseStage06Layout.setVisibility(View.VISIBLE);
        if (stage_07_complete) {
            mStageSelectTrophycaseStage07TrophyImageView.setBackground(versionCheck(R.drawable.stage_07_boss_image));
            ++mBossCount;
        }
        mStageSelectTrophycaseStage07Layout.setVisibility(View.VISIBLE);

        //
        mStageSelectTrophycaseProgressTextView.setText(Float.toString((int) getPercentage(7, mBossCount)));
        mStageSelectTrophycaseProgressBar.setProgress((int) getPercentage(7, mBossCount));
    }

    // Build scorecard - STAGE TOP SCORES
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void buildScorecard() {

        //
        int top_score = 0;

        //
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
                mLoadRandomScoreTitleTextView.setText("Total Boss Kills:");
                mLoadRandomScoreValueTextView.setText(Integer.toString(mGameBossKills));

                //
                if (stage_01_apex) {

                    //
                    ++top_score;

                    //
                    //mStageTopApexBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    //mStageTopApexBadgeImageView.setVisibility(View.VISIBLE);
                    //mStageCardTopApexLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_01_food_chain > 2) {

                    //
                    ++top_score;

                    //
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopPredatorBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopPredatorLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_01_food_chain > 3) {
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_01_food_chain > 4) {
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_01_accuracy > 94) {
                    mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_01_accuracy > 99) {
                    mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_01_best_time < 76) {
                    mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_01_best_time < 61) {
                    mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_01_creature_kills > 74) {
                    mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_01_creature_kills > 99) {
                    mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_01_highest_streak > 14) {
                    mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_01_highest_streak > 19) {
                    mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_01_closest_death < 8) {
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_01_closest_death < 6) {
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_01_longest_frenzy > 4) {
                    mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_01_longest_frenzy > 9) {
                    mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_01_most_calm > 875) {
                    mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_01_most_calm > 999) {
                    mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_01_most_frantic < 225) {
                    mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_01_most_frantic < 100) {
                    mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

                break;

            case 2:

                //
                if (stage_02_apex) {

                    //
                    ++top_score;

                    //
                    //mStageTopApexBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    //mStageTopApexBadgeImageView.setVisibility(View.VISIBLE);
                    //mStageCardTopApexLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_02_food_chain > 2) {

                    //
                    ++top_score;

                    //
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopPredatorBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopPredatorLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_02_food_chain > 3) {
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_02_food_chain > 4) {
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_02_accuracy > 94) {
                    mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_02_accuracy > 99) {
                    mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_02_best_time < 76) {
                    mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_02_best_time < 61) {
                    mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_02_creature_kills > 74) {
                    mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_02_creature_kills > 99) {
                    mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_02_highest_streak > 14) {
                    mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_02_highest_streak > 19) {
                    mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

                //
                if (stage_02_closest_death < 11) {

                    //
                    ++top_score;

                    //
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopCloseDeathBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopDeathLayout.setVisibility(View.VISIBLE);
                }
                if (stage_02_closest_death < 8) {
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_02_closest_death < 6) {
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_02_longest_frenzy > 4) {
                    mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_02_longest_frenzy > 9) {
                    mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_02_most_calm > 875) {
                    mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_02_most_calm > 999) {
                    mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_02_most_frantic < 225) {
                    mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_02_most_frantic < 100) {
                    mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

                break;

            case 3:

                //
                if (stage_03_apex) {

                    //
                    ++top_score;

                    //
                    //mStageTopApexBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    //mStageTopApexBadgeImageView.setVisibility(View.VISIBLE);
                    //mStageCardTopApexLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_03_food_chain > 2) {

                    //
                    ++top_score;

                    //
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopPredatorBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopPredatorLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_03_food_chain > 3) {
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_03_food_chain > 4) {
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_03_accuracy > 94) {
                    mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_03_accuracy > 99) {
                    mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_03_best_time < 76) {
                    mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_03_best_time < 61) {
                    mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_03_creature_kills > 74) {
                    mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_03_creature_kills > 99) {
                    mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_03_highest_streak > 14) {
                    mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_03_highest_streak > 19) {
                    mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_03_closest_death < 8) {
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_03_closest_death < 6) {
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_03_longest_frenzy > 4) {
                    mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_03_longest_frenzy > 9) {
                    mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_03_most_calm > 875) {
                    mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_03_most_calm > 999) {
                    mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_03_most_frantic < 225) {
                    mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_03_most_frantic < 100) {
                    mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

                break;

            case 4:

                //
                if (stage_04_apex) {

                    //
                    ++top_score;

                    //
                    //mStageTopApexBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    //mStageTopApexBadgeImageView.setVisibility(View.VISIBLE);
                    //mStageCardTopApexLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_04_food_chain > 2) {

                    //
                    ++top_score;

                    //
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopPredatorBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopPredatorLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_04_food_chain > 3) {
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_04_food_chain > 4) {
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_04_accuracy > 94) {
                    mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_04_accuracy > 99) {
                    mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_04_best_time < 76) {
                    mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_04_best_time < 61) {
                    mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_04_creature_kills > 74) {
                    mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_04_creature_kills > 99) {
                    mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_04_highest_streak > 14) {
                    mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_04_highest_streak > 19) {
                    mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_04_closest_death < 8) {
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_04_closest_death < 6) {
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_04_longest_frenzy > 4) {
                    mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_04_longest_frenzy > 9) {
                    mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_04_most_calm > 875) {
                    mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_04_most_calm > 999) {
                    mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_04_most_frantic < 225) {
                    mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_04_most_frantic < 100) {
                    mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

                break;

            case 5:

                //
                if (stage_05_apex) {

                    //
                    ++top_score;

                    //
                    //mStageTopApexBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    //mStageTopApexBadgeImageView.setVisibility(View.VISIBLE);
                    //mStageCardTopApexLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_05_food_chain > 2) {

                    //
                    ++top_score;

                    //
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopPredatorBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopPredatorLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_05_food_chain > 3) {
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_05_food_chain > 4) {
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_05_accuracy > 94) {
                    mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_05_accuracy > 99) {
                    mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_05_best_time < 76) {
                    mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_05_best_time < 61) {
                    mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_05_creature_kills > 74) {
                    mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_05_creature_kills > 99) {
                    mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_05_highest_streak > 14) {
                    mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_05_highest_streak > 19) {
                    mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_05_closest_death < 8) {
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_05_closest_death < 6) {
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_05_longest_frenzy > 4) {
                    mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_05_longest_frenzy > 9) {
                    mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_05_most_calm > 875) {
                    mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_05_most_calm > 999) {
                    mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_05_most_frantic < 225) {
                    mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_05_most_frantic < 100) {
                    mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

                break;

            case 6:

                //
                if (stage_06_apex) {

                    //
                    ++top_score;

                    //
                    //mStageTopApexBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    //mStageTopApexBadgeImageView.setVisibility(View.VISIBLE);
                    //mStageCardTopApexLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_06_food_chain > 2) {

                    //
                    ++top_score;

                    //
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopPredatorBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopPredatorLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_06_food_chain > 3) {
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_06_food_chain > 4) {
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_06_accuracy > 94) {
                    mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_06_accuracy > 99) {
                    mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_06_best_time < 76) {
                    mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_06_best_time < 61) {
                    mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_06_creature_kills > 74) {
                    mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_06_creature_kills > 99) {
                    mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_06_highest_streak > 14) {
                    mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_06_highest_streak > 19) {
                    mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_06_closest_death < 8) {
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_06_closest_death < 6) {
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_06_longest_frenzy > 4) {
                    mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_06_longest_frenzy > 9) {
                    mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_06_most_calm > 825) {
                    mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_06_most_calm > 999) {
                    mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_06_most_frantic < 225) {
                    mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_06_most_frantic < 100) {
                    mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

                break;

            case 7:

                //
                if (stage_07_apex) {

                    //
                    ++top_score;

                    //
                    //mStageTopApexBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    //mStageTopApexBadgeImageView.setVisibility(View.VISIBLE);
                    //mStageCardTopApexLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_07_food_chain > 2) {

                    //
                    ++top_score;

                    //
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
                    mStageTopPredatorBadgeImageView.setVisibility(View.VISIBLE);
                    mStageCardTopPredatorLayout.setVisibility(View.VISIBLE);
                }

                //
                if (stage_07_food_chain > 3) {
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_07_food_chain > 4) {
                    mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_07_accuracy > 94) {
                    mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_07_accuracy > 99) {
                    mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_07_best_time < 76) {
                    mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_07_best_time < 61) {
                    mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_07_creature_kills > 74) {
                    mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_07_creature_kills > 99) {
                    mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_07_highest_streak > 14) {
                    mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_07_highest_streak > 19) {
                    mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_07_closest_death < 8) {
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_07_closest_death < 6) {
                    mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_07_longest_frenzy > 4) {
                    mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_07_longest_frenzy > 9) {
                    mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_07_most_calm > 875) {
                    mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_07_most_calm > 999) {
                    mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

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
                if (stage_07_most_frantic < 225) {
                    mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
                    ++top_score;
                }
                if (stage_07_most_frantic < 100) {
                    mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
                    ++top_score;
                }

                break;
        }
    }

    // Build stage scores - STAGE COMPLETE
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void buildStageScores() {

        //
        int final_score = 0;

        //
        mStageTopPredatorBadgeImageView.setVisibility(View.INVISIBLE);
        mStageTopAccuracyBadgeImageView.setVisibility(View.INVISIBLE);
        mStageTopBestTimeBadgeImageView.setVisibility(View.INVISIBLE);
        mStageTotalCreatureKillsBadgeImageView.setVisibility(View.INVISIBLE);
        mStageTopHighStreakBadgeImageView.setVisibility(View.INVISIBLE);
        mStageTopCloseDeathBadgeImageView.setVisibility(View.INVISIBLE);
        mStageTopLongFrenzyBadgeImageView.setVisibility(View.INVISIBLE);
        mStageTopMostCalmBadgeImageView.setVisibility(View.INVISIBLE);
        mStageTopMostFranticBadgeImageView.setVisibility(View.INVISIBLE);

        mStageCardTopPredatorLayout.setVisibility(View.GONE);
        mStageCardTopAccuracyLayout.setVisibility(View.GONE);
        mStageCardTopTimeLayout.setVisibility(View.GONE);
        mStageCardTopEatenLayout.setVisibility(View.GONE);
        mStageCardTopStreakLayout.setVisibility(View.GONE);
        mStageCardTopDeathLayout.setVisibility(View.GONE);
        mStageCardTopFrenzyLayout.setVisibility(View.GONE);
        mStageCardTopCalmLayout.setVisibility(View.GONE);
        mStageCardTopFranticLayout.setVisibility(View.GONE);

        // Primary scores
        if (mStageFoodChain > 2) {

            //
            ++final_score;

            //
            mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
            mStageTopPredatorBadgeImageView.setVisibility(View.VISIBLE);
            mStageCardTopPredatorLayout.setVisibility(View.VISIBLE);
        }

        //
        if (mStageFoodChain > 3) {
            mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
            ++final_score;
        }
        if (mStageFoodChain > 4) {
            mStageTopPredatorBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            ++final_score;
        }

        //
        if (mStageAccuracy > 84) {

            //
            ++final_score;

            //
            mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
            mStageTopAccuracyBadgeImageView.setVisibility(View.VISIBLE);
            mStageCardTopAccuracyLayout.setVisibility(View.VISIBLE);
        }

        //
        if (mStageAccuracy > 94) {
            mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
            ++final_score;
        }
        if (mStageAccuracy > 99) {
            mStageTopAccuracyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            ++final_score;
        }

        // Secondary scores
        if (mStageTime < 91) {

            //
            ++final_score;

            //
            mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
            mStageTopBestTimeBadgeImageView.setVisibility(View.VISIBLE);
            mStageCardTopTimeLayout.setVisibility(View.VISIBLE);
        }

        //
        if (mStageTime < 76) {
            mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
            ++final_score;
        }
        if (mStageTime < 61) {
            mStageTopBestTimeBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            ++final_score;
        }

        //
        if (mStageCreatureKills > 49) {

            //
            ++final_score;

            //
            mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
            mStageTotalCreatureKillsBadgeImageView.setVisibility(View.VISIBLE);
            mStageTotalCreatureKillsBadgeImageView.setVisibility(View.VISIBLE);
        }

        //
        if (mStageCreatureKills > 74) {
            mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
            ++final_score;
        }
        if (mStageCreatureKills > 99) {
            mStageTotalCreatureKillsBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            ++final_score;
        }

        // Tertiary scores
        if (mStageHighestStreak > 9) {

            //
            ++final_score;

            //
            mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
            mStageTopHighStreakBadgeImageView.setVisibility(View.VISIBLE);
            mStageTopHighStreakBadgeImageView.setVisibility(View.VISIBLE);
        }

        //
        if (mStageHighestStreak > 14) {
            mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
            ++final_score;
        }
        if (mStageHighestStreak > 19) {
            mStageTopHighStreakBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            ++final_score;
        }

        //
        if (mStageClosestDeath < 11) {

            //
            ++final_score;

            //
            mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
            mStageTopCloseDeathBadgeImageView.setVisibility(View.VISIBLE);
            mStageCardTopDeathLayout.setVisibility(View.VISIBLE);
        }

        //
        if (mStageClosestDeath < 8) {
            mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
            ++final_score;
        }
        if (mStageClosestDeath < 6) {
            mStageTopCloseDeathBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            ++final_score;
        }

        //
        if (mStageLongestFrenzy > 2) {

            //
            ++final_score;

            //
            mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
            mStageTopLongFrenzyBadgeImageView.setVisibility(View.VISIBLE);
            mStageCardTopFrenzyLayout.setVisibility(View.VISIBLE);
        }

        //
        if (mStageLongestFrenzy > 4) {
            mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
            ++final_score;
        }
        if (mStageLongestFrenzy > 9) {
            mStageTopLongFrenzyBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            ++final_score;
        }

        //
        if (mStageMostCalm > 750) {

            //
            ++final_score;

            //
            mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
            mStageTopMostCalmBadgeImageView.setVisibility(View.VISIBLE);
            mStageCardTopCalmLayout.setVisibility(View.VISIBLE);
        }

        //
        if (mStageMostCalm > 875) {
            mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
            ++final_score;
        }
        if (mStageMostCalm > 999) {
            mStageTopMostCalmBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            ++final_score;
        }

        //
        if (mStageMostFrantic < 350) {

            //
            ++final_score;

            //
            mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_bronze));
            mStageTopMostFranticBadgeImageView.setVisibility(View.VISIBLE);
            mStageCardTopFranticLayout.setVisibility(View.VISIBLE);
        }

        //
        if (mStageMostFrantic < 225) {
            mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_silver));
            ++final_score;
        }
        if (mStageMostFrantic < 100) {
            mStageTopMostFranticBadgeImageView.setBackground(versionCheck(R.drawable.badge_gold));
            ++final_score;
        }
    }

    // Construct views for creature collection
    private void buildCreatureTrophycase(int creature, int trophy_case) {

        // This stops the ArrayIndexOutOfBounds error until
        // We can finish the Special Creature Feature
        if (trophy_case < 5) {
            //
            if (trophy_case < 0) {
                trophy_case = 0;
            }

            View[] trophy_cases = new View[]{

                    //
                    mCreature01ImageView, mCreature02ImageView, mCreature03ImageView, mCreature04ImageView,
                    mCreature05ImageView
            };

            //
            trophy_cases[trophy_case].setBackground(versionCheck(creature));
            //trophy_cases[trophy_case].setAlpha(1);
        }
    }

    // Construct creature collection
    private void buildTrophycase() {

        //
        ArrayList[] stage_creatures_previous = {

                //
                stage_01_top_predators_previous, stage_02_top_predators_previous, stage_03_top_predators_previous,
                stage_04_top_predators_previous, stage_05_top_predators_previous, stage_06_top_predators_previous,
                stage_07_top_predators_previous
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
                buildCreatureTrophycase(CREATURES[i], i);
            }

            //
            i++;
        }
    }

    // mStageIndex [1-7]
    private void buildStageTrophycase(int trophy_shelf) {

        //
        ArrayList[] stage_creatures_previous = {

                //
                stage_01_top_predators_previous, stage_02_top_predators_previous, stage_03_top_predators_previous,
                stage_04_top_predators_previous, stage_05_top_predators_previous, stage_06_top_predators_previous,
                stage_07_top_predators_previous
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
    private void resetCreatureTrophycase() {

        View[] trophy_cases = new View[]{

                //
                mCreature01ImageView, mCreature02ImageView, mCreature03ImageView, mCreature04ImageView,
                mCreature05ImageView
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
        mPauseGame = true;

        // Record time
        mStageTime = mStageTimer;

        // Set stageReady
        mStageReady = 4;

        // Set handler
        mHandlerFlag = true;

        // Switch to SCREEN(EATEN)
        switchScreen(R.id.stage_card_screen_main_layout);

        // Play outro audio(s)
        playAudio(DARK_OUTRO);
    }

    //-- STAGE SELECT -->

    //
    final private static int[] STAGE_SELECT_CONTENT_CARD_LAYOUTS = {

            //
            R.id.stage_select_content_card_01_layout, R.id.stage_select_content_card_02_layout, R.id.stage_select_content_card_03_layout,
            R.id.stage_select_content_card_04_layout, R.id.stage_select_content_card_05_layout, R.id.stage_select_content_card_06_layout,
            R.id.stage_select_content_card_07_layout,
    };

    //
    final private static int[] STAGE_SELECT_CONTENT_BG_IMAGES = {

            //
            R.drawable.stage_select_content_bg_01_image, R.drawable.stage_select_content_bg_02_image, R.drawable.stage_select_content_bg_03_image,
            R.drawable.stage_select_content_bg_04_image, R.drawable.stage_select_content_bg_05_image, R.drawable.stage_select_content_bg_06_image,
            R.drawable.stage_select_content_bg_07_image
    };

    // RESOURCE : INTEGER - Array list of stage props - stage card title image views
    final private static int[] STAGE_SELECT_CONTENT_TITLE_IMAGE_VIEWS = {

            //
            R.id.stage_select_content_title_01_image_view, R.id.stage_select_content_title_02_image_view, R.id.stage_select_content_title_03_image_view,
            R.id.stage_select_content_title_04_image_view, R.id.stage_select_content_title_05_image_view, R.id.stage_select_content_title_06_image_view,
            R.id.stage_select_content_title_07_image_view,
    };

    //
    final private static int[] STAGE_SELECT_CONTENT_TITLE_IMAGES = {

            //
            R.drawable.stage_select_content_title_01_image, R.drawable.stage_select_content_title_02_image, R.drawable.stage_select_content_title_03_image,
            R.drawable.stage_select_content_title_04_image, R.drawable.stage_select_content_title_05_image, R.drawable.stage_select_content_title_06_image,
            R.drawable.stage_select_content_title_07_image
    };

    // RESOURCE : INTEGER - Array list of stage props - stage card icon image views
    final private static int[] STAGE_SELECT_CONTENT_STATUS_IMAGE_BUTTONS = {

            //
            R.id.stage_select_content_status_01_image_button, R.id.stage_select_content_status_02_image_button, R.id.stage_select_content_status_03_image_button,
            R.id.stage_select_content_status_04_image_button, R.id.stage_select_content_status_05_image_button, R.id.stage_select_content_status_06_image_button,
            R.id.stage_select_content_status_07_image_button
    };

    //
    final private static int[] STAGE_SELECT_CONTENT_STATUS_IMAGES = {

            //
            R.drawable.stage_select_content_icon_ready_image, R.drawable.stage_select_content_icon_complete_image, R.drawable.stage_select_content_icon_locked_image
    };

    // RESOURCE : INTEGER - Array list of stage props - stage card status image views
    final private static int[] STAGE_SELECT_CONTENT_STATUS_TEXT_VIEWS = {

            //
            R.id.stage_select_content_status_01_text_view, R.id.stage_select_content_status_02_text_view, R.id.stage_select_content_status_03_text_view,
            R.id.stage_select_content_status_04_text_view, R.id.stage_select_content_status_05_text_view, R.id.stage_select_content_status_06_text_view,
            R.id.stage_select_content_status_07_text_view
    };

    final private static int[] STAGE_SELECT_CONTENT_STATUS_STRINGS = {

            R.string.stage_select_content_status_ready, R.string.stage_select_content_status_locked, R.string.stage_select_content_status_complete
    };

    //
    final private static int[] STAGE_SELECT_CONTENT_COLOR_VALUES = {

            //
            R.color.stage_select_content_color_01_value, R.color.stage_select_content_color_02_value, R.color.stage_select_content_color_03_value,
            R.color.stage_select_content_color_04_value, R.color.stage_select_content_color_05_value, R.color.stage_select_content_color_06_value,
            R.color.stage_select_content_color_07_value
    };

    //
    final private static int[] STAGE_SELECT_CONTENT_PROGRESS_TEXT_VIEWS = {

            //
            R.id.stage_select_content_progress_01_text_view, R.id.stage_select_content_progress_02_text_view, R.id.stage_select_content_progress_03_text_view,
            R.id.stage_select_content_progress_04_text_view, R.id.stage_select_content_progress_05_text_view, R.id.stage_select_content_progress_06_text_view,
            R.id.stage_select_content_progress_07_text_view
    };

    //
    final private static int[] STAGE_SELECT_CONTENT_PROGRESS_BARS = {

            //
            R.id.stage_select_content_status_01_progress_bar, R.id.stage_select_content_status_02_progress_bar, R.id.stage_select_content_status_03_progress_bar,
            R.id.stage_select_content_status_04_progress_bar, R.id.stage_select_content_status_05_progress_bar, R.id.stage_select_content_status_06_progress_bar,
            R.id.stage_select_content_status_07_progress_bar
    };

    //-- STAGE CARD -->

    //
    final private static int[] STAGE_CARD_BG_IMAGES = {

            //
            R.drawable.stage_card_bg_01_image, R.drawable.stage_card_bg_02_image, R.drawable.stage_card_bg_03_image,
            R.drawable.stage_card_bg_04_image, R.drawable.stage_card_bg_05_image, R.drawable.stage_card_bg_06_image,
            R.drawable.stage_card_bg_07_image
    };

    //
    final private static int[] STAGE_CARD_TITLE_IMAGES = {

            //
            R.drawable.stage_card_title_01_image, R.drawable.stage_card_title_02_image, R.drawable.stage_card_title_03_image,
            R.drawable.stage_card_title_04_image, R.drawable.stage_card_title_05_image, R.drawable.stage_card_title_06_image,
            R.drawable.stage_card_title_07_image
    };

    //
    final private static int[] STAGE_CARD_COLOR_VALUES = {

            //
            R.color.stage_card_color_01_value, R.color.stage_card_color_02_value, R.color.stage_card_color_03_value,
            R.color.stage_card_color_04_value, R.color.stage_card_color_05_value, R.color.stage_card_color_06_value,
            R.color.stage_card_color_07_value
    };

    //
    final private static int[] STAGE_CARD_CONTENT_BOSS_IMAGES = {

            //
            R.drawable.stage_card_content_boss_01_image, R.drawable.stage_card_content_boss_02_image, R.drawable.stage_card_content_boss_03_image,
            R.drawable.stage_card_content_boss_04_image, R.drawable.stage_card_content_boss_05_image, R.drawable.stage_card_content_boss_06_image,
            R.drawable.stage_card_content_boss_07_image
    };

    //
    final private static int[] STAGE_CARD_CONTENT_BOSS_TITLE_STRINGS = {

            //
            R.string.stage_card_content_boss_01_title, R.string.stage_card_content_boss_02_title, R.string.stage_card_content_boss_03_title,
            R.string.stage_card_content_boss_04_title, R.string.stage_card_content_boss_05_title, R.string.stage_card_content_boss_06_title,
            R.string.stage_card_content_boss_07_title
    };

    //
    final private static int[] STAGE_CARD_CONTENT_BOSS_DESCRIPTION_STRINGS = {

            //
            R.string.stage_card_content_boss_01_description, R.string.stage_card_content_boss_02_description, R.string.stage_card_content_boss_03_description,
            R.string.stage_card_content_boss_04_description, R.string.stage_card_content_boss_05_description, R.string.stage_card_content_boss_06_description,
            R.string.stage_card_content_boss_07_description
    };

    //
    final private static int[] STAGE_CARD_CONTENT_POWER_IMAGES = {

            //
            R.drawable.stage_card_content_power_01_image, R.drawable.stage_card_content_power_02_image, R.drawable.stage_card_content_power_03_image,
            R.drawable.stage_card_content_power_04_image, R.drawable.stage_card_content_power_05_image, R.drawable.stage_card_content_power_06_image,
            R.drawable.stage_card_content_power_07_image
    };

    //
    final private static int[] STAGE_CARD_CONTENT_POWER_TITLE_STRINGS = {

            //
            R.string.stage_card_content_power_01_title, R.string.stage_card_content_power_02_title, R.string.stage_card_content_power_03_title,
            R.string.stage_card_content_power_04_title, R.string.stage_card_content_power_05_title, R.string.stage_card_content_power_06_title,
            R.string.stage_card_content_power_07_title
    };

    //
    final private static int[] STAGE_CARD_CONTENT_POWER_DESCRIPTION_STRINGS = {

            //
            R.string.stage_card_content_power_01_description, R.string.stage_card_content_power_02_description, R.string.stage_card_content_power_03_description,
            R.string.stage_card_content_power_04_description, R.string.stage_card_content_power_05_description, R.string.stage_card_content_power_06_description,
            R.string.stage_card_content_power_07_description
    };

    //
    final private static int[] STAGE_CARD_CONTENT_DISASTER_IMAGES = {

            //
            R.drawable.stage_card_content_disaster_01_image, R.drawable.stage_card_content_disaster_02_image, R.drawable.stage_card_content_disaster_03_image,
            R.drawable.stage_card_content_disaster_04_image, R.drawable.stage_card_content_disaster_05_image, R.drawable.stage_card_content_disaster_06_image,
            R.drawable.stage_card_content_disaster_07_image
    };

    //
    final private static int[] STAGE_CARD_CONTENT_DISASTER_TITLE_STRINGS = {

            //
            R.string.stage_card_content_disaster_01_title, R.string.stage_card_content_disaster_02_title, R.string.stage_card_content_disaster_03_title,
            R.string.stage_card_content_disaster_04_title, R.string.stage_card_content_disaster_05_title, R.string.stage_card_content_disaster_06_title,
            R.string.stage_card_content_disaster_07_title
    };

    //
    final private static int[] STAGE_CARD_CONTENT_DISASTER_DESCRIPTION_STRINGS = {

            //
            R.string.stage_card_content_disaster_01_description, R.string.stage_card_content_disaster_02_description, R.string.stage_card_content_disaster_03_description,
            R.string.stage_card_content_disaster_04_description, R.string.stage_card_content_disaster_05_description, R.string.stage_card_content_disaster_06_description,
            R.string.stage_card_content_disaster_07_description
    };

    //
    final private static int[] STAGE_CARD_TROPHYCASE_CREATURE_01_IMAGES = {

            //
            R.drawable.stage_card_trophycase_creature_01_01_image, R.drawable.stage_card_trophycase_creature_01_02_image, R.drawable.stage_card_trophycase_creature_01_03_image,
            R.drawable.stage_card_trophycase_creature_01_04_image, R.drawable.stage_card_trophycase_creature_01_05_image, R.drawable.stage_card_trophycase_creature_01_06_image,
            R.drawable.stage_card_trophycase_creature_01_07_image
    };

    //
    final private static int[] STAGE_CARD_TROPHYCASE_CREATURE_01_TITLE_STRINGS = {

            //
            R.string.stage_card_trophycase_creature_01_01_title, R.string.stage_card_trophycase_creature_01_02_title, R.string.stage_card_trophycase_creature_01_03_title,
            R.string.stage_card_trophycase_creature_01_04_title, R.string.stage_card_tropycase_creature_01_05_title, R.string.stage_card_trophycase_creature_01_06_title,
            R.string.stage_card_trophycase_creature_01_07_title
    };

    //
    final private static int[] STAGE_CARD_TROPHYCASE_CREATURE_01_DESCRIPTION_STRINGS = {

            //
            R.string.stage_card_trophycase_creature_01_01_description, R.string.stage_card_trophycase_creature_01_02_description, R.string.stage_card_trophycase_creature_01_03_description,
            R.string.stage_card_trophycase_creature_01_04_description, R.string.stage_card_trophycase_creature_01_05_description, R.string.stage_card_trophycase_creature_01_06_description,
            R.string.stage_card_trophycase_creature_01_07_description
    };

    //
    final private static int[] STAGE_CARD_TROPHYCASE_CREATURE_02_IMAGES = {

            //
            R.drawable.stage_card_trophycase_creature_02_01_image, R.drawable.stage_card_trophycase_creature_02_02_image, R.drawable.stage_card_trophycase_creature_02_03_image,
            R.drawable.stage_card_trophycase_creature_02_04_image, R.drawable.stage_card_trophycase_creature_02_05_image, R.drawable.stage_card_trophycase_creature_02_06_image,
            R.drawable.stage_card_trophycase_creature_02_07_image
    };

    //
    final private static int[] STAGE_CARD_TROPHYCASE_CREATURE_02_TITLE_STRINGS = {

            //
            R.string.stage_card_trophycase_creature_02_01_title, R.string.stage_card_trophycase_creature_02_02_title, R.string.stage_card_trophycase_creature_02_03_title,
            R.string.stage_card_trophycase_creature_02_04_title, R.string.stage_card_trophycase_creature_02_05_title, R.string.stage_card_trophycase_creature_02_06_title,
            R.string.stage_card_trophycase_creature_02_07_title
    };

    //
    final private static int[] STAGE_CARD_TROPHYCASE_CREATURE_02_DESCRIPTION_STRINGS = {

            //
            R.string.stage_card_trophycase_creature_02_01_description, R.string.stage_card_trophycase_creature_02_02_description, R.string.stage_card_trophycase_creature_02_03_description,
            R.string.stage_card_trophycase_creature_02_04_description, R.string.stage_card_trophycase_creature_02_05_description, R.string.stage_card_trophycase_creature_02_06_description,
            R.string.stage_card_trophycase_creature_02_07_description
    };

    //
    final private static int[] STAGE_CARD_TROPHYCASE_CREATURE_03_IMAGES = {

            //
            R.drawable.stage_card_trophycase_creature_03_01_image, R.drawable.stage_card_trophycase_creature_03_02_image, R.drawable.stage_card_trophycase_creature_03_03_image,
            R.drawable.stage_card_trophycase_creature_03_04_image, R.drawable.stage_card_trophycased_creature_03_05_image, R.drawable.stage_card_trophycase_creature_03_06_image,
            R.drawable.stage_card_trophycase_creature_03_07_image
    };

    //
    final private static int[] STAGE_CARD_TROPHYCASE_CREATURE_03_TITLE_STRINGS = {

            //
            R.string.stage_card_trophycase_creature_03_01_title, R.string.stage_card_trophycase_creature_03_02_title, R.string.stage_card_trophycase_creature_03_03_title,
            R.string.stage_card_trophycase_creature_03_04_title, R.string.stage_card_trophycase_creature_03_05_title, R.string.stage_card_trophycase_creature_03_06_title,
            R.string.stage_card_trophycase_creature_03_07_title
    };

    //
    final private static int[] STAGE_CARD_TROPHYCASE_CREATURE_03_DESCRIPTION_STRINGS = {

            //
            R.string.stage_card_trophycase_creature_03_01_description, R.string.stage_card_trophycase_creature_03_02_description, R.string.stage_card_trophycase_creature_03_03_description,
            R.string.stage_card_trophycase_creature_03_04_description, R.string.stage_card_trophycase_creature_03_05_description, R.string.stage_card_trophycase_creature_03_06_description,
            R.string.stage_card_trophycase_creature_03_07_description
    };

    //
    final private static int[] STAGE_CARD_TROPHYCASE_CREATURE_04_IMAGES = {

            //
            R.drawable.stage_card_trophycase_creature_04_01_image, R.drawable.stage_card_trophycase_creature_04_02_image, R.drawable.stage_card_trophycase_creature_04_03_image,
            R.drawable.stage_card_trophycase_creature_04_04_image, R.drawable.stage_card_trophycase_creature_04_05_image, R.drawable.stage_card_trophycase_creature_04_06_image,
            R.drawable.stage_card_trophycase_creature_04_07_image
    };

    //
    final private static int[] STAGE_CARD_TROPHYCASE_CREATURE_04_TITLE_STRINGS = {

            //
            R.string.stage_card_trophycase_creature_04_01_title, R.string.stage_card_trophycase_creature_04_02_title, R.string.stage_card_trophycase_creature_04_03_title,
            R.string.stage_card_trophycase_creature_04_04_title, R.string.stage_card_trophycase_creature_04_05_title, R.string.stage_card_trophycase_creature_04_06_title,
            R.string.stage_card_trophycase_creature_04_07_title
    };

    //
    final private static int[] STAGE_CARD_TROPHYCASE_CREATURE_04_DESCRIPTION_STRINGS = {

            //
            R.string.stage_card_trophycase_creature_04_01_description, R.string.stage_card_trophycase_creature_04_02_description, R.string.stage_card_trophycase_creature_04_03_description,
            R.string.stage_card_trophycase_creature_04_04_description, R.string.stage_card_trophycase_creature_04_05_description, R.string.stage_card_trophycase_creature_04_06_description,
            R.string.stage_card_trophycase_creature_04_07_description
    };

    //
    final private static int[] STAGE_CARD_TROPHYCASE_CREATURE_05_IMAGES = {

            //
            R.drawable.stage_card_trophycase_creature_05_01_image, R.drawable.stage_card_trophycase_creature_05_02_image, R.drawable.stage_card_trophycase_creature_05_03_image,
            R.drawable.stage_card_trophycase_creature_05_04_image, R.drawable.stage_card_trophycase_creature_05_05_image, R.drawable.stage_card_trophycase_creature_05_06_image,
            R.drawable.stage_card_trophycase_creature_05_07_image
    };

    //
    final private static int[] STAGE_CARD_TROPHYCASE_CREATURE_05_TITLE_STRINGS = {

            //
            R.string.stage_card_trophycase_creature_05_01_title, R.string.stage_card_trophycase_creature_05_02_title, R.string.stage_card_trophycase_creature_05_03_title,
            R.string.stage_card_trophycase_creature_05_04_title, R.string.stage_card_trophycase_creature_05_05_title, R.string.stage_card_trophycase_creature_05_06_title,
            R.string.stage_card_trophycase_creature_05_07_title
    };

    //
    final private static int[] STAGE_CARD_TROPHYCASE_CREATURE_05_DESCRIPTION_STRINGS = {

            //
            R.string.stage_card_trophycase_creature_05_01_description, R.string.stage_card_trophycase_creature_05_02_description, R.string.stage_card_trophycase_creature_05_03_description,
            R.string.stage_card_trophycase_creature_05_04_description, R.string.stage_card_trophycase_creature_05_05_description, R.string.stage_card_trophycase_creature_05_06_description,
            R.string.stage_card_trophycase_creature_05_07_description
    };

    //
    final private static int[] STAGE_CARD_COMPLETE_BOSS_STATUS_STRINGS = {

            //
            R.string.stage_card_complete_boss_status_eaten, R.string.stage_card_complete_boss_status_escaped, R.string.stage_card_complete_boss_status_defeated,
            R.string.stage_card_complete_boss_status_captured
    };

    //
    final private static int[] STAGE_CARD_COMPLETE_DISASTER_IMAGE_VIEWS = {

            //
            R.id.stage_card_complete_disaster_01_image_view, R.id.stage_card_complete_disaster_02_image_view, R.id.stage_card_complete_disaster_03_image_view,
            R.id.stage_card_complete_disaster_04_image_view, R.id.stage_card_complete_disaster_05_image_view
    };

    //
    final private static int[] STAGE_CARD_COMPLETE_PREDATOR_IMAGE_VIEWS = {

            //
            R.id.stage_card_complete_predator_01_image_view, R.id.stage_card_complete_predator_02_image_view, R.id.stage_card_complete_predator_03_image_view,
            R.id.stage_card_complete_predator_04_image_view, R.id.stage_card_complete_predator_05_image_view
    };

    //
    final private static int[] STAGE_CARD_SCORECARD_SCORE_LAYOUTS = {

            //
            R.id.stage_card_scorecard_score_01_layout, R.id.stage_card_scorecard_score_02_layout, R.id.stage_card_scorecard_score_03_layout,
            R.id.stage_card_scorecard_score_04_layout, R.id.stage_card_scorecard_score_05_layout, R.id.stage_card_scorecard_score_06_layout,
            R.id.stage_card_scorecard_score_07_layout, R.id.stage_card_scorecard_score_08_layout, R.id.stage_card_scorecard_score_09_layout
    };

    //
    final private static int[] STAGE_CARD_SCORECARD_BADGE_IMAGE_VIEWS = {

            //
            R.id.stage_card_scorecard_badge_01_image_view, R.id.stage_card_scorecard_badge_02_image_view, R.id.stage_card_scorecard_badge_03_image_view,
            R.id.stage_card_scorecard_badge_04_image_view, R.id.stage_card_scorecard_badge_05_image_view, R.id.stage_card_scorecard_badge_06_image_view,
            R.id.stage_card_scorecard_badge_07_image_view, R.id.stage_card_scorecard_badge_08_image_view, R.id.stage_card_scorecard_badge_09_image_view
    };

    //-- GAME -->

    //
    final private static int[] GAME_STAGE_TITLE_IMAGES = {

            //
            R.drawable.game_stage_title_01_image, R.drawable.game_stage_title_02_image, R.drawable.game_stage_title_03_image,
            R.drawable.game_stage_title_04_image, R.drawable.game_stage_title_05_image, R.drawable.game_stage_title_06_image,
            R.drawable.game_stage_title_07_image
    };

    //
    final private static int[] GAME_BOARD_01_TITLE_IMAGES = {

            //
            R.drawable.game_board_title_01_01_image, R.drawable.game_board_title_01_02_image, R.drawable.game_board_title_01_03_image,
            R.drawable.game_board_title_01_04_image, R.drawable.game_board_title_01_05_image, R.drawable.game_board_title_01_06_image,
            R.drawable.game_board_title_01_07_image
    };

    //
    final private static int[] GAME_BOARD_01_THUMBNAIL_IMAGES = {

            //
            R.drawable.game_board_thumbnail_01_01_image, R.drawable.game_board_thumbnail_01_02_image, R.drawable.game_board_thumbnail_01_03_image,
            R.drawable.game_board_thumbnail_01_04_image, R.drawable.game_board_thumbnail_01_05_image, R.drawable.game_board_thumbnail_01_06_image,
            R.drawable.game_board_thumbnail_01_07_image
    };

    //
    final private static int[] GAME_BOARD_01_BG_IMAGES = {

            //
            R.drawable.game_board_bg_01_01_image, R.drawable.game_board_bg_01_02_image, R.drawable.game_board_bg_01_03_image,
            R.drawable.game_board_bg_01_04_image, R.drawable.game_board_bg_01_05_image, R.drawable.game_board_bg_01_06_image,
            R.drawable.game_board_bg_01_07_image
    };

    //
    final private static int[] GAME_BOARD_02_TITLE_IMAGES = {

            //
            R.drawable.game_board_title_02_01_image, R.drawable.game_board_title_02_02_image, R.drawable.game_board_title_02_03_image,
            R.drawable.game_board_title_02_04_image, R.drawable.game_board_title_02_05_image, R.drawable.game_board_title_02_06_image,
            R.drawable.game_board_title_02_07_image
    };

    //
    final private static int[] GAME_BOARD_02_THUMBNAIL_IMAGES = {

            //
            R.drawable.game_board_thumbnail_02_01_image, R.drawable.game_board_thumbnail_02_02_image, R.drawable.game_board_thumbnail_02_03_image,
            R.drawable.game_board_thumbnail_02_04_image, R.drawable.game_board_thumbnail_02_05_image, R.drawable.game_board_thumbnail_02_06_image,
            R.drawable.game_board_thumbnail_02_07_image,
    };

    //
    final private static int[] GAME_BOARD_02_BG_IMAGES = {

            //
            R.drawable.game_board_bg_02_01_image, R.drawable.game_board_bg_02_02_image, R.drawable.game_board_bg_02_03_image,
            R.drawable.game_board_bg_02_04_image, R.drawable.game_board_bg_02_05_image, R.drawable.game_board_bg_02_06_image,
            R.drawable.game_board_bg_02_07_image
    };

    //
    final private static int[] GAME_BOARD_03_TITLE_IMAGES = {

            //
            R.drawable.game_board_title_03_01_image, R.drawable.game_board_title_03_02_image, R.drawable.game_board_title_03_03_image,
            R.drawable.game_board_title_03_04_image, R.drawable.game_board_title_03_05_image, R.drawable.game_board_title_03_06_image,
            R.drawable.game_board_title_03_07_image
    };

    //
    final private static int[] GAME_BOARD_03_THUMBNAIL_IMAGES = {

            //
            R.drawable.game_board_thumbnail_03_01_image, R.drawable.game_board_thumbnail_03_02_image, R.drawable.game_board_thumbnail_03_03_image,
            R.drawable.game_board_thumbnail_03_04_image, R.drawable.game_board_thumbnail_03_05_image, R.drawable.game_board_thumbnail_03_06_image,
            R.drawable.game_board_thumbnail_03_07_image
    };

    //
    final private static int[] GAME_BOARD_03_BG_IMAGES = {

            //
            R.drawable.game_board_bg_03_01_image, R.drawable.game_board_bg_03_02_image, R.drawable.game_board_bg_03_03_image,
            R.drawable.game_board_bg_03_04_image, R.drawable.game_board_bg_03_05_image, R.drawable.game_board_bg_03_06_image,
            R.drawable.game_board_bg_03_07_image
    };

    //
    final private static int[] GAME_BOARD_04_TITLE_IMAGES = {

            //
            R.drawable.game_board_title_04_01_image, R.drawable.game_board_title_04_02_image, R.drawable.game_board_title_04_03_image,
            R.drawable.game_board_title_04_04_image, R.drawable.game_board_title_04_05_image, R.drawable.game_board_title_04_06_image,
            R.drawable.game_board_title_04_07_image
    };

    //
    final private static int[] GAME_BOARD_04_THUMBNAIL_IMAGES = {

            //
            R.drawable.game_board_thumbnail_04_01_image, R.drawable.game_board_thumbnail_04_02_image, R.drawable.game_board_thumbnail_04_03_image,
            R.drawable.game_board_thumbnail_04_04_image, R.drawable.game_board_thumbnail_04_05_image, R.drawable.game_board_thumbnail_04_06_image,
            R.drawable.game_board_thumbnail_04_07_image
    };

    //
    final private static int[] GAME_BOARD_04_BG_IMAGES = {

            //
            R.drawable.game_board_bg_04_01_image, R.drawable.game_board_bg_04_02_image, R.drawable.game_board_bg_04_03_image,
            R.drawable.game_board_bg_04_04_image, R.drawable.game_board_bg_04_05_image, R.drawable.game_board_bg_04_06_image,
            R.drawable.game_board_bg_04_07_image
    };

    //
    final private static int[] GAME_BOARD_05_TITLE_IMAGES = {

            //
            R.drawable.game_board_title_05_01_image, R.drawable.game_board_title_05_02_image, R.drawable.game_board_title_05_03_image,
            R.drawable.game_board_title_05_04_image, R.drawable.game_board_title_05_05_image, R.drawable.game_board_title_05_06_image,
            R.drawable.game_board_title_05_07_image
    };

    //
    final private static int[] GAME_BOARD_05_THUMBNAIL_IMAGES = {

            //
            R.drawable.game_board_thumbnail_05_01_image, R.drawable.game_board_thumbnail_05_02_image, R.drawable.game_board_thumbnail_05_03_image,
            R.drawable.game_board_thumbnail_05_04_image, R.drawable.game_board_thumbnail_05_05_image, R.drawable.game_board_thumbnail_05_06_image,
            R.drawable.game_board_thumbnail_05_07_image,
    };

    //
    final private static int[] GAME_BOARD_05_BG_IMAGES = {

            //
            R.drawable.game_board_bg_05_01_image, R.drawable.game_board_bg_05_02_image, R.drawable.game_board_bg_05_03_image,
            R.drawable.game_board_bg_05_04_image, R.drawable.game_board_bg_05_05_image, R.drawable.game_board_bg_05_06_image,
            R.drawable.game_board_bg_05_07_image
    };

    //
    final private static int[] GAME_BOSS_THUMBNAIL_IMAGES = {

            //
            R.drawable.game_boss_thumbnail_01_image, R.drawable.game_boss_thumbnail_02_image, R.drawable.game_boss_thumbnail_03_image,
            R.drawable.game_boss_thumbnail_04_image, R.drawable.game_boss_thumbnail_05_image, R.drawable.game_boss_thumbnail_06_image,
            R.drawable.game_boss_thumbnail_07_image
    };

    //
    final private static int[] GAME_BOSS_TITLE_IMAGES = {

            //
            R.drawable.game_boss_title_01_image, R.drawable.game_boss_title_02_image, R.drawable.game_boss_title_03_image,
            R.drawable.game_boss_title_04_image, R.drawable.game_boss_title_05_image, R.drawable.game_boss_title_06_image,
            R.drawable.game_boss_title_07_image
    };

    //
    final private static int[] GAME_BOSS_TITLE_STRINGS = {

            //
            R.string.game_boss_01_title, R.string.game_boss_02_title, R.string.game_boss_03_title,
            R.string.game_boss_04_title, R.string.game_boss_05_title, R.string.game_boss_06_title,
            R.string.game_boss_07_title
    };

    //
    final private static int[] GAME_PREDATOR_01_IMAGES = {

            //
            R.drawable.game_predator_01_01_image, R.drawable.game_predator_01_02_image, R.drawable.game_predator_01_03_image,
            R.drawable.game_predator_01_04_image, R.drawable.game_predator_01_05_image, R.drawable.game_predator_01_06_image,
            R.drawable.game_predator_01_07_image
    };

    //
    final private static int[] GAME_PREDATOR_02_IMAGES = {

            //
            R.drawable.game_predator_02_01_image, R.drawable.game_predator_02_02_image, R.drawable.game_predator_02_03_image,
            R.drawable.game_predator_02_04_image, R.drawable.game_predator_02_05_image, R.drawable.game_predator_02_06_image,
            R.drawable.game_predator_02_07_image
    };

    //
    final private static int[] GAME_PREDATOR_03_IMAGES = {

            //
            R.drawable.game_predator_03_01_image, R.drawable.game_predator_03_02_image, R.drawable.game_predator_03_03_image,
            R.drawable.game_predator_03_04_image, R.drawable.game_predator_03_05_image, R.drawable.game_predator_03_06_image,
            R.drawable.game_predator_03_07_image
    };

    //
    final private static int[] GAME_PREDATOR_04_IMAGES = {

            //
            R.drawable.game_predator_04_01_image, R.drawable.game_predator_04_02_image, R.drawable.game_predator_04_03_image,
            R.drawable.game_predator_04_04_image, R.drawable.game_predator_04_05_image, R.drawable.game_predator_04_06_image,
            R.drawable.game_predator_04_07_image
    };

    //
    final private static int[] GAME_PREDATOR_05_IMAGES = {

            //
            R.drawable.game_predator_05_01_image, R.drawable.game_predator_05_02_image, R.drawable.game_predator_05_03_image,
            R.drawable.game_predator_05_04_image, R.drawable.game_predator_05_05_image, R.drawable.game_predator_05_06_image,
            R.drawable.game_predator_05_07_image
    };

    //
    final private static int[] GAME_STAGE_BORDER_IMAGES = {

            //
            R.drawable.game_stage_border_01_image, R.drawable.game_stage_border_02_image, R.drawable.game_stage_border_03_image,
            R.drawable.game_stage_border_04_image, R.drawable.game_stage_border_05_image, R.drawable.game_stage_border_06_image,
            R.drawable.game_stage_border_07_image
    };

    //
    final private static int[] GAME_STAGE_DISASTER_IMAGES = {

            //
            R.drawable.game_stage_disaster_01_image, R.drawable.game_stage_disaster_02_image, R.drawable.game_stage_disaster_03_image,
            R.drawable.game_stage_disaster_04_image, R.drawable.game_stage_disaster_05_image, R.drawable.game_stage_disaster_06_image,
            R.drawable.game_stage_disaster_07_image
    };

    //
    final private static int[] GAME_DISASTER_THUMBNAIL_IMAGES = {

            //
            R.drawable.game_disaster_thumbnail_01_image, R.drawable.game_disaster_thumbnail_02_image, R.drawable.game_disaster_thumbnail_03_image,
            R.drawable.game_disaster_thumbnail_04_image, R.drawable.game_disaster_thumbnail_05_image, R.drawable.game_disaster_thumbnail_06_image,
            R.drawable.game_disaster_thumbnail_07_image
    };

    // RESOURCE : INTEGER - Array list of level marker views [creature capture image]
    final private static int[] GAME_BOARD_CAPTURE_IMAGE_VIEWS = {

            //
            R.id.game_scene_01_capture_image_view, R.id.game_scene_02_capture_image_view, R.id.game_scene_03_capture_image_view,
            R.id.game_scene_04_capture_image_view, R.id.game_scene_05_capture_image_view
    };

    final private static int[] GAME_SCENE_LAYOUTS = {

            //
            R.id.game_scene_01_layout, R.id.game_scene_02_layout, R.id.game_scene_03_layout,
            R.id.game_scene_04_layout, R.id.game_scene_05_layout
    };

    // RESOURCE : INTEGER - Array list of creature button views [1-5]
    final private static int[] GAME_STAGE_CREATURE_BUTTONS = {

            //
            R.id.game_creature_01_image_button, R.id.game_creature_02_image_button, R.id.game_creature_03_image_button,
            R.id.game_creature_04_image_button, R.id.game_creature_05_image_button
    };

    //
    final private static int[] GAME_STAGE_SPLATTER_IMAGE_VIEWS = {

            //
            R.id.game_splatter_01_image_view, R.id.game_splatter_02_image_view, R.id.game_splatter_03_image_view,
            R.id.game_splatter_04_image_view, R.id.game_splatter_05_image_view
    };

    //
    final private static boolean[] STAGE_COMPLETE_SCORE_ARRAY = {

            //
            stage_01_complete, stage_02_complete, stage_03_complete,
            stage_04_complete, stage_05_complete, stage_06_complete,
            stage_07_complete,
    };

    // -- GLOBAL SCORES -->

    //
    final private static int[] TOTAL_GAME_BOSS_KILLS_SCORE_ARRAY = {

            //
            stage_01_boss_kills, stage_02_boss_kills, stage_03_boss_kills,
            stage_04_boss_kills, stage_05_boss_kills, stage_06_boss_kills,
            stage_07_boss_kills
    };

    //
    final private static int[] TOTAL_GAME_TIME_SCORE_ARRAY = {

            //
            stage_01_total_time, stage_02_total_time, stage_03_total_time,
            stage_04_total_time, stage_05_total_time, stage_06_total_time,
            stage_07_total_time
    };

    //
    final private static int[] TOTAL_GAME_ATTEMPTS_SCORE_ARRAY = {

            //
            stage_01_attempts, stage_02_attempts, stage_03_attempts,
            stage_04_attempts, stage_05_attempts, stage_06_attempts,
            stage_07_attempts
    };

    // RESOURCE : INTEGER - Array list of items that need event handlers
    final private static int[] CLICKABLES = {

// Credits
            //
            R.id.credits_screen_main_layout, // Skip intro

// Entry
            //
            R.id.entry_main_continue_image_button, R.id.entry_main_new_image_button, R.id.entry_main_credits_image_button, // Main menu options
            //R.id.entry_main_settings_image_button, R.id.entry_main_tutorial_image_button, // TODO Add Functionality

// Stage select
            //
            R.id.stage_select_header_return_image_button, // Exit to main
            R.id.stage_select_header_secret_image_button, R.id.stage_select_score_layout,

            // Control
            R.id.stage_select_trophycase_image_button, R.id.stage_select_scorecard_image_button, R.id.stage_select_content_image_button, // Switch scorecards

            // Trophycase
            R.id.stage_select_trophy_01_layout, R.id.stage_select_trophy_02_layout, R.id.stage_select_trophy_03_layout,
            R.id.stage_select_trophy_04_layout, R.id.stage_select_trophy_05_layout, R.id.stage_select_trophy_06_layout,
            R.id.stage_select_trophy_07_layout,

            // Scorecard
            R.id.stage_select_score_apex_layout, R.id.stage_select_score_predator_layout, R.id.stage_select_score_accuracy_layout,
            R.id.stage_select_score_time_layout, R.id.stage_select_score_creatures_layout, R.id.stage_select_score_streak_layout,
            R.id.stage_select_score_death_layout, R.id.stage_select_score_frenzy_layout, R.id.stage_select_score_calm_layout,
            R.id.stage_select_score_frantic_layout,

            // Content
            R.id.stage_select_content_card_01_layout, R.id.stage_select_content_card_02_layout, R.id.stage_select_content_card_03_layout,
            R.id.stage_select_content_card_04_layout, R.id.stage_select_content_card_05_layout, R.id.stage_select_content_card_06_layout,
            R.id.stage_select_content_card_07_layout,

// Stage card
            //
            R.id.stage_card_return_image_button, // Exit to stage select
            //R.id.stage_card_help_image_button, TODO : Add Functionality

            //
            R.id.stage_card_trophycase_image_button, R.id.stage_card_scorecard_image_button, R.id.stage_card_content_image_button, // Switch scorecards

            //
            R.id.stage_card_control_prev_image_button, R.id.stage_card_control_play_image_button, R.id.stage_card_control_next_image_button, // Switch stage cards
            //R.id.stage_card_screen_body_layout, // Touch to main

// Game
            //
            R.id.game_main_return_image_button, // Exit to stagecard

            //
            R.id.game_power_01_image_button, R.id.game_power_02_image_button, R.id.game_power_03_image_button,
            R.id.game_power_04_image_button, R.id.game_power_05_image_button, R.id.game_power_06_image_button, // Use power

            //
            R.id.game_main_pg_creature_canvas_layout, // Miss creature

            //
            R.id.game_creature_01_image_button, R.id.game_creature_02_image_button, R.id.game_creature_03_image_button,
            R.id.game_creature_04_image_button, R.id.game_creature_05_image_button, R.id.game_boss_image_button, // Hit creature
    };

    // RESOURCE : INTEGER - Array list of screen layouts
    final private static int[] SCREENS = {

            //
            R.id.load_screen_main_layout, R.id.entry_screen_main_layout, R.id.stage_select_screen_main_layout,
            R.id.stage_card_screen_main_layout, R.id.game_screen_main_layout, R.id.credits_screen_main_layout
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

//-----\/
    // RESOURCE : DRAWABLE - Array list of background images [forest]
    final private static int[] FOREST_SCENES = {

            //
            R.drawable.game_board_01_bg_01, R.drawable.game_board_02_bg_01, R.drawable.game_board_03_bg_01,
            R.drawable.game_board_04_bg_01, R.drawable.game_board_05_bg_01
    };

    // RESOURCE : STRING - Array list of background names [forest]
    final private static int[] FOREST_SCENE_NAMES = {

            //
            R.drawable.game_board_01_01, R.drawable.game_board_02_01, R.drawable.game_board_03_01,
            R.drawable.game_board_04_01, R.drawable.game_board_05_01
    };

    // RESOURCE : DRAWABLE - Array list of background images [ocean]
    final private static int[] OCEAN_SCENES = {

            //
            R.drawable.game_board_01_bg_02, R.drawable.game_board_02_bg_02, R.drawable.game_board_03_bg_02,
            R.drawable.game_board_04_bg_02, R.drawable.game_board_05_bg_02
    };

    // RESOURCE : STRING - Array list of background names [ocean]
    final private static int[] OCEAN_SCENE_NAMES = {

            //
            R.drawable.game_board_01_02, R.drawable.game_board_02_02, R.drawable.game_board_03_02,
            R.drawable.game_board_04_02, R.drawable.game_board_05_02
    };

    // RESOURCE : DRAWABLE - Array list of background images [mountain]
    final private static int[] MOUNTAIN_SCENES = {

            //
            R.drawable.game_board_01_bg_03, R.drawable.game_board_02_bg_03, R.drawable.game_board_03_bg_03,
            R.drawable.game_board_04_bg_03, R.drawable.game_board_05_bg_03
    };

    // RESOURCE : STRING - Array list of background names [mountain]
    final private static int[] MOUNTAIN_SCENE_NAMES = {

            //
            R.drawable.game_board_01_03, R.drawable.game_board_02_03, R.drawable.game_board_03_03,
            R.drawable.game_board_04_03, R.drawable.game_board_05_03
    };

    // RESOURCE : DRAWABLE - Array list of background images [desert]
    final private static int[] DESERT_SCENES = {

            //
            R.drawable.game_board_01_bg_04, R.drawable.game_board_02_bg_04, R.drawable.game_board_03_bg_04,
            R.drawable.game_board_04_bg_04, R.drawable.game_board_05_bg_04
    };

    // RESOURCE : STRING - Array list of background names [desert]
    final private static int[] DESERT_SCENE_NAMES = {

            //
            R.drawable.game_board_01_04, R.drawable.game_board_02_04, R.drawable.game_board_03_04,
            R.drawable.game_board_04_04, R.drawable.game_board_05_04
    };

    // RESOURCE : DRAWABLE - Array list of background images [jungle]
    final private static int[] JUNGLE_SCENES = {

            //
            R.drawable.game_board_01_bg_05, R.drawable.game_board_02_bg_05, R.drawable.game_board_03_bg_05,
            R.drawable.game_board_04_bg_05, R.drawable.game_board_05_bg_05
    };

    // RESOURCE : STRING - Array list of background names [jungle]
    final private static int[] JUNGLE_SCENE_NAMES = {

            //
            R.drawable.game_board_01_05, R.drawable.game_board_02_05, R.drawable.game_board_03_05,
            R.drawable.game_board_04_05, R.drawable.game_board_05_05
    };

    // RESOURCE : DRAWABLE - Array list of background images [tundra]
    final private static int[] TUNDRA_SCENES = {

            //
            R.drawable.game_board_01_bg_06, R.drawable.game_board_02_bg_06, R.drawable.game_board_03_bg_06,
            R.drawable.game_board_04_bg_06, R.drawable.game_board_05_bg_06
    };

    // RESOURCE : STRING - Array list of background names [tundra]
    final private static int[] TUNDRA_SCENE_NAMES = {

            //
            R.drawable.game_board_01_06, R.drawable.game_board_02_06, R.drawable.game_board_03_06,
            R.drawable.game_board_04_06, R.drawable.game_board_05_06
    };

    // RESOURCE : DRAWABLE - Array list of background images [final]
    final private static int[] FINAL_SCENES = {

            //
            R.drawable.game_board_01_bg_07, R.drawable.game_board_02_bg_07, R.drawable.game_board_03_bg_07,
            R.drawable.game_board_04_bg_07, R.drawable.game_board_05_bg_07
    };

    // RESOURCE : STRING - Array list of background names [final]
    final private static int[] FINAL_SCENE_NAMES = {

            //
            R.drawable.game_board_01_07, R.drawable.game_board_02_07, R.drawable.game_board_03_07,
            R.drawable.game_board_04_07, R.drawable.game_board_05_07
    };

    // RESOUCE : INTEGER - Array list of special creature images
    final private static int[] STAGE_01_PREDATORS = {

            //
            R.drawable.game_creature_special_01_01, R.drawable.game_creature_special_02_01, R.drawable.game_creature_special_03_01,
            R.drawable.game_creature_special_04_01, R.drawable.game_creature_special_05_01
    };

    // RESOUCE : INTEGER - Array list of special creature images
    final private static int[] STAGE_02_PREDATORS = {

            //
            R.drawable.game_creature_special_01_02, R.drawable.game_creature_special_02_02, R.drawable.game_creature_special_03_02,
            R.drawable.game_creature_special_04_02, R.drawable.game_creature_special_05_02
    };

    // RESOUCE : INTEGER - Array list of special creature images
    final private static int[] STAGE_03_PREDATORS = {

            //
            R.drawable.game_creature_special_01_03, R.drawable.game_creature_special_02_03, R.drawable.game_creature_special_03_03,
            R.drawable.game_creature_special_04_03, R.drawable.game_creature_special_05_03
    };

    // RESOUCE : INTEGER - Array list of special creature images
    final private static int[] STAGE_04_PREDATORS = {

            //
            R.drawable.game_creature_special_01_04, R.drawable.game_creature_special_02_04, R.drawable.game_creature_special_03_04,
            R.drawable.game_creature_special_04_04, R.drawable.game_creature_special_05_04
    };

    // RESOUCE : INTEGER - Array list of special creature images
    final private static int[] STAGE_05_PREDATORS = {

            //
            R.drawable.game_creature_special_01_05, R.drawable.game_creature_special_02_05, R.drawable.game_creature_special_03_05,
            R.drawable.game_creature_special_04_05, R.drawable.game_creature_special_05_05
    };

    // RESOUCE : INTEGER - Array list of special creature images
    final private static int[] STAGE_06_PREDATORS = {

            //
            R.drawable.game_creature_special_01_06, R.drawable.game_creature_special_02_06, R.drawable.game_creature_special_03_06,
            R.drawable.game_creature_special_04_06, R.drawable.game_creature_special_05_06
    };

    // RESOUCE : INTEGER - Array list of special creature images
    final private static int[] STAGE_07_PREDATORS = {

            //
            R.drawable.game_creature_special_01_07, R.drawable.game_creature_special_02_07, R.drawable.game_creature_special_03_07,
            R.drawable.game_creature_special_04_07, R.drawable.game_creature_special_05_07
    };

    // RESOUCE : ARRAY - Array list of stage creature capture image views [2D]
    final private static int[][] STAGE_PREDATORS = {

            //
            STAGE_01_PREDATORS, STAGE_02_PREDATORS, STAGE_03_PREDATORS,
            STAGE_04_PREDATORS, STAGE_05_PREDATORS, STAGE_06_PREDATORS,
            STAGE_07_PREDATORS
    };


    // RESOURCE : ARRAY - Array list of stage background image views [2D]
    // [TODO - Modify to generic labels (stage_01, stage_02, etc)]
    final private static int[][] STAGE_SCENES = {

            //
            FOREST_SCENES, OCEAN_SCENES, MOUNTAIN_SCENES,
            DESERT_SCENES, JUNGLE_SCENES, TUNDRA_SCENES,
            FINAL_SCENES
    };

    // RESOURCE : ARRAY - Array list of stage background names [2D]
    final private static int[][] STAGE_SCENE_NAMES = {

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

    // RESOURCE : DRAWABLE - Array list of stage boss image views
    final private static int[] STAGE_CARD_BOSS_IMAGES = {

            //
            R.drawable.stage_01_boss_image, R.drawable.stage_02_boss_image, R.drawable.stage_03_boss_image,
            R.drawable.stage_04_boss_image, R.drawable.stage_05_boss_image, R.drawable.stage_06_boss_image,
            R.drawable.stage_07_boss_image,
    };

    // RESOURCE : STRING - Array list of boss names
    final private static int[] STAGE_CARD_BOSS_NAME_STRINGS = {

            //
            R.string.stage_card_boss_01, R.string.stage_card_boss_02, R.string.stage_card_boss_03,
            R.string.stage_card_boss_04, R.string.stage_card_boss_05, R.string.stage_card_boss_06,
            R.string.stage_card_boss_07
    };

    final private static int[] STAGE_CARD_BOSS_NAME_DESCRIPTION_STRINGS = {

            //
            R.string.stage_card_boss_01_description, R.string.stage_card_boss_02_description, R.string.stage_card_boss_03_description,
            R.string.stage_card_boss_04_description, R.string.stage_card_boss_05_description, R.string.stage_card_boss_06_description,
            R.string.stage_card_boss_07_description
    };

    //
    final private static int[] STAGE_CARD_POWER_IMAGES = {};

    //
    final private static int[] STAGE_CARD_DISASTER_IMAGES = {};

    // RESOURCE : STRING - Array list of stage disasters
    final private static int[] POWER_NAME = {

            //
            R.string.stage_card_power_01, R.string.stage_card_power_02, R.string.stage_card_power_03,
            R.string.stage_card_power_04, R.string.stage_card_power_05, R.string.stage_card_power_06,
            R.string.stage_card_power_07
    };

    // RESOURCE : STRING - Array list of stage disasters
    final private static int[] POWER_NAME_DESCRIPTION = {

            //
            R.string.stage_card_power_01_description, R.string.stage_card_power_02_description, R.string.stage_card_power_03_description,
            R.string.stage_card_power_04_description, R.string.stage_card_power_05_description, R.string.stage_card_power_06_description,
            R.string.stage_card_power_07_description
    };

    // RESOURCE : STRING - Array list of stage disasters
    final private static int[] DISASTER_NAME = {

            //
            R.string.stage_card_disaster_01, R.string.stage_card_disaster_02, R.string.stage_card_disaster_03,
            R.string.stage_card_disaster_04, R.string.stage_card_disaster_05, R.string.stage_card_disaster_06,
            R.string.stage_card_disaster_07
    };

    // RESOURCE : STRING - Array list of stage disasters
    final private static int[] DISASTER_NAME_DESCRIPTION = {

            //
            R.string.stage_card_disaster_01_description, R.string.stage_card_disaster_02_description, R.string.stage_card_disaster_03_description,
            R.string.stage_card_disaster_04_description, R.string.stage_card_disaster_05_description, R.string.stage_card_disaster_06_description,
            R.string.stage_card_disaster_07_description
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
            R.drawable.game_black_creature_16_image, R.drawable.game_white_creature_16_image,
            R.drawable.skull_icon, R.drawable.skull_black_icon
    };

    // RESOURCE : DRAWABLE - Array list of special creature image views
    final private static int[] SPECIAL_CREATURES = {

            //
            R.drawable.skull_icon, R.drawable.skull_black_icon
    };

    // RESOURCE : INTEGER - Array list of pings
    final private static int[] PINGS = {

            //
            R.raw.ping_01_audio, R.raw.ping_02_audio, R.raw.ping_03_audio, R.raw.ping_04_audio, R.raw.ping_05_audio,
            R.raw.ping_06_audio, R.raw.ping_07_audio, R.raw.ping_08_audio, R.raw.ping_09_audio, R.raw.ping_10_audio
    };

// RESOURCES for setGameData()

    // RESOURCE : STRING - Array list of top scores constants
    final private static String[] top_predator_previous_string_01 = {

            //
            STAGE_01_PREDATOR_01, STAGE_01_PREDATOR_02, STAGE_01_PREDATOR_03, STAGE_01_PREDATOR_04,
            STAGE_01_PREDATOR_05
    };

    // RESOURCE : STRING - Array list of top scores constants
    final private static String[] top_predator_previous_string_02 = {

            //
            STAGE_02_PREDATOR_01, STAGE_02_PREDATOR_02, STAGE_02_PREDATOR_03, STAGE_02_PREDATOR_04,
            STAGE_02_PREDATOR_05
    };

    // RESOURCE : STRING - Array list of top scores constants
    final private static String[] top_predator_previous_string_03 = {

            //
            STAGE_03_PREDATOR_01, STAGE_03_PREDATOR_02, STAGE_03_PREDATOR_03, STAGE_03_PREDATOR_04,
            STAGE_03_PREDATOR_05
    };

    // RESOURCE : STRING - Array list of top scores constants
    final private static String[] top_predator_previous_string_04 = {

            //
            STAGE_04_PREDATOR_01, STAGE_04_PREDATOR_02, STAGE_04_PREDATOR_03, STAGE_04_PREDATOR_04,
            STAGE_04_PREDATOR_05
    };

    // RESOURCE : STRING - Array list of top scores constants
    final private static String[] top_predator_previous_string_05 = {

            //
            STAGE_05_PREDATOR_01, STAGE_05_PREDATOR_02, STAGE_05_PREDATOR_03, STAGE_05_PREDATOR_04,
            STAGE_05_PREDATOR_05
    };

    // RESOURCE : STRING - Array list of top scores constants
    final private static String[] top_predator_previous_string_06 = {

            //
            STAGE_06_PREDATOR_01, STAGE_06_PREDATOR_02, STAGE_06_PREDATOR_03, STAGE_06_PREDATOR_04,
            STAGE_06_PREDATOR_05
    };

    // RESOURCE : STRING - Array list of top scores constants
    final private static String[] top_predator_previous_string_07 = {

            //
            STAGE_07_PREDATOR_01, STAGE_07_PREDATOR_02, STAGE_07_PREDATOR_03, STAGE_07_PREDATOR_04,
            STAGE_07_PREDATOR_05
    };

    // RESOURCE : IMAGE - Array list of bite mark images
    final private static int[] BITTEN_IMAGES = {

            //
            R.drawable.game_bitten_01_image, R.drawable.game_bitten_02_image,
            R.drawable.game_bitten_03_image, R.drawable.game_bitten_04_image
    };
}