package cartoon;

/**
 * This is the Constants class.
 *
 * It stores measurements.
 */

public class Constants {

    public static final int APP_DIM_X = 600;
    public static final int APP_DIM_Y = 820;

    //Measurements for the Alien class
    public static final int UFO_BASE_POS_X = 300;
    public static final int UFO_BASE_POS_Y = 110;
    public static final int UFO_BASE_RAD_X = 130;
    public static final int UFO_BASE_RAD_Y = 40;

    public static final int UFO_TOP_POS_X = 250;
    public static final int UFO_TOP_POS_Y = 75;
    public static final int UFO_TOP_RAD = 50;

    public static final int UFO_LIGHT_RAD = 12;
    public static final int UFO_LIGHT1_POS = -50;
    public static final int UFO_LIGHT3_POS = 50;

    public static final double BEAM_PT1_POS_X = UFO_TOP_POS_X+0.0;
    public static final double BEAM_PT1_POS_Y = UFO_TOP_POS_Y+0.0;
    public static final double BEAM_PT2_POS_X = UFO_TOP_POS_X-150.0;
    public static final double BEAM_PT2_POS_Y = UFO_TOP_POS_Y+650.0;
    public static final double BEAM_PT3_POS_X = UFO_TOP_POS_X+150.0;
    public static final double BEAM_PT3_POS_Y = UFO_TOP_POS_Y+650.0;

    public static final int ALIEN_FACE_POS_X = UFO_TOP_POS_X;
    public static final int ALIEN_FACE_POS_Y = UFO_TOP_POS_Y-7;
    public static final int ALIEN_FACE_RAD_X = 19;
    public static final int ALIEN_FACE_RAD_Y = 32;

    public static final int ALIEN_EYE_POS_Y = ALIEN_FACE_POS_Y-15;
    public static final int ALIEN_LEFT_EYE_POS_X = ALIEN_FACE_POS_X-7;
    public static final int ALIEN_RIGHT_EYE_POS_X = ALIEN_FACE_POS_X+7;
    public static final int ALIEN_EYE_RAD_X = 4;
    public static final int ALIEN_EYE_RAD_Y = 7;

    //Measurements for the Cow class
    public static final int COW_HEAD_POS_X = 300;
    public static final int COW_HEAD_POS_Y = -175;
    public static final int COW_HEAD_RAD = 45;

    public static final int COW_EYE1_POS_X = COW_HEAD_POS_X-9;
    public static final int COW_EYE_POS_Y = COW_HEAD_POS_Y-5;
    public static final int COW_EYE_RAD_X = 6;
    public static final int COW_EYE_RAD_Y = 10;

    public static final int COW_EYE2_POS_X = COW_HEAD_POS_X+9;

    public static final double STROKE_WIDTH = 4.0;

    public static final int COW_NOSE_POS_X = COW_HEAD_POS_X;
    public static final int COW_NOSE_POS_Y = COW_HEAD_POS_Y+14;
    public static final int COW_NOSE_RAD_X = 28;
    public static final int COW_NOSE_RAD_Y = 13;

    public static final int COW_NOSTRIL1_POS_X = COW_NOSE_POS_X+10;
    public static final int COW_NOSTRIL_POS_Y = COW_NOSE_POS_Y-3;
    public static final int COW_NOSTRIL_RAD_X = 3;
    public static final int COW_NOSTRIL_RAD_Y = 4;
    public static final int COW_NOSTRIL2_POS_X = COW_NOSE_POS_X-10;

    public static final int COW_BODY_POS_X = COW_HEAD_POS_X;
    public static final int COW_BODY_POS_Y = COW_HEAD_POS_Y+108;
    public static final int COW_BODY_RAD = 62;

    public static final int COW_LEFT_ARM_POS_X = COW_BODY_POS_X-20;
    public static final int COW_RIGHT_ARM_POS_X = COW_BODY_POS_X+20;
    public static final int COW_ARM_POS_Y = COW_BODY_POS_Y-17;
    public static final int COW_ARM_RAD_X = 14;
    public static final int COW_ARM_RAD_Y = 28;

    public static final double COW_LEG_POS_X = COW_BODY_POS_X-85.0;
    public static final double COW_LEG_POS_Y = COW_BODY_POS_Y+30.0;
    public static final double COW_LEG_WIDTH = 170.0;
    public static final double COW_LEG_HEIGHT = 30.0;

    public static final int COW_LEFT_EAR_POS_X = COW_HEAD_POS_X-45;
    public static final int COW_RIGHT_EAR_POS_X = COW_HEAD_POS_X+45;
    public static final int COW_EAR_POS_Y = COW_HEAD_POS_Y-35;
    public static final int COW_EAR_RAD_X = 17;
    public static final int COW_EAR_RAD_Y = 8;

    public static final double COW_LEFT_HORN_PT1_POS_X = COW_LEFT_EAR_POS_X+17.0;
    public static final double COW_LEFT_HORN_PT2_POS_X = COW_LEFT_EAR_POS_X+14.0;
    public static final double COW_LEFT_HORN_PT3_POS_X = COW_LEFT_EAR_POS_X+37.0;

    public static final double COW_HORN_PT1_POS_Y = COW_EAR_POS_Y+0.0;
    public static final double COW_HORN_PT2_POS_Y = COW_EAR_POS_Y-22.0;
    public static final double COW_HORN_PT3_POS_Y = COW_EAR_POS_Y-2.0;

    public static final double COW_RIGHT_HORN_PT1_POS_X = COW_RIGHT_EAR_POS_X-37.0;
    public static final double COW_RIGHT_HORN_PT2_POS_X = COW_RIGHT_EAR_POS_X-14.0;
    public static final double COW_RIGHT_HORN_PT3_POS_X = COW_RIGHT_EAR_POS_X-17.0;

    public static final int SPOT_RAD = 10;

    public static final int LEFT_LEG_HOOVE_POS_X = COW_BODY_POS_X-85;
    public static final int RIGHT_LEG_HOOVE_POS_X = COW_BODY_POS_X+70;
    public static final int LEG_HOOVE_POS_Y = COW_BODY_POS_Y+30;
    public static final int LEG_HOOVE_WIDTH = 15;
    public static final int LEG_HOOVE_HEIGHT = (int) COW_LEG_HEIGHT;

    public static final int LEFT_ARM_HOOVE_POS_X = COW_LEFT_ARM_POS_X;
    public static final int RIGHT_ARM_HOOVE_POS_X = COW_RIGHT_ARM_POS_X;
    public static final int ARM_HOOVE_POS_Y = COW_ARM_POS_Y+20;
    public static final int ARM_HOOVE_RAD_X = 10;
    public static final int ARM_HOOVE_RAD_Y = 7;

    public static final double DISTANCE_Y = 1;
}
