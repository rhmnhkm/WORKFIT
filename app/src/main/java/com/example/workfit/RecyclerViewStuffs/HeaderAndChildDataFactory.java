package com.example.workfit.RecyclerViewStuffs;

/**
 * Created by Revina Adisty on 7/1/2017.
 */

import java.util.Arrays;
import java.util.List;

public class HeaderAndChildDataFactory {

    public static List<WorkoutHeaderItems> makeWorkoutList() {
        return Arrays.asList(armWorkout(),
                absWorkout(),
                buttWorkout());
    }

    public static WorkoutHeaderItems armWorkout() {
        return new WorkoutHeaderItems("Arm Workout", makeArmWorkoutList());
    }

    public static List<WorkoutChildItems> makeArmWorkoutList() {
        WorkoutChildItems arm1 = new WorkoutChildItems("Bicycle Crunches");
        WorkoutChildItems arm2 = new WorkoutChildItems("Bridge");
        WorkoutChildItems arm3 = new WorkoutChildItems("Bird Dog");
        WorkoutChildItems arm4 = new WorkoutChildItems("Cobras");
        WorkoutChildItems arm5 = new WorkoutChildItems("Abdominal Crunches");
        WorkoutChildItems arm6 = new WorkoutChildItems("Reverse Crunches");
        WorkoutChildItems arm7 = new WorkoutChildItems("Mountain Climber");
        WorkoutChildItems arm8 = new WorkoutChildItems("One Leg Bridge");
        WorkoutChildItems arm9 = new WorkoutChildItems("Two Leg Bridge");
        WorkoutChildItems arm10 = new WorkoutChildItems("Three Leg Bridge");

        return Arrays.asList(arm1, arm2, arm3, arm4, arm5, arm6, arm7, arm8, arm9, arm10);
    }

    public static WorkoutHeaderItems absWorkout() {
        return new WorkoutHeaderItems("Abs Workout", makeAbsWorkoutList());
    }

    public static List<WorkoutChildItems> makeAbsWorkoutList() {
        WorkoutChildItems abs1 = new WorkoutChildItems("Bicycle Crunches");
        WorkoutChildItems abs2 = new WorkoutChildItems("Bridge");
        WorkoutChildItems abs3 = new WorkoutChildItems("Bird Dog");
        WorkoutChildItems abs4 = new WorkoutChildItems("Cobras");
        WorkoutChildItems abs5 = new WorkoutChildItems("Abdominal Crunches");
        WorkoutChildItems abs6 = new WorkoutChildItems("Reverse Crunches");
        WorkoutChildItems abs7 = new WorkoutChildItems("Mountain Climber");
        WorkoutChildItems abs8 = new WorkoutChildItems("One Leg Bridge");
        WorkoutChildItems abs9 = new WorkoutChildItems("Two Leg Bridge");
        WorkoutChildItems abs10 = new WorkoutChildItems("Three Leg Bridge");

        return Arrays.asList(abs1, abs2, abs3, abs4, abs5, abs6, abs7, abs8, abs9, abs10);
    }

    public static WorkoutHeaderItems buttWorkout() {
        return new WorkoutHeaderItems("Butt Workout", makeButtWorkoutList());
    }

    public static List<WorkoutChildItems> makeButtWorkoutList() {
        WorkoutChildItems butt1 = new WorkoutChildItems("Bicycle Crunches");
        WorkoutChildItems butt2 = new WorkoutChildItems("Bridge");
        WorkoutChildItems butt3 = new WorkoutChildItems("Bird Dog");
        WorkoutChildItems butt4 = new WorkoutChildItems("Cobras");
        WorkoutChildItems butt5 = new WorkoutChildItems("Abdominal Crunches");
        WorkoutChildItems butt6 = new WorkoutChildItems("Reverse Crunches");
        WorkoutChildItems butt7 = new WorkoutChildItems("Mountain Climber");
        WorkoutChildItems butt8 = new WorkoutChildItems("One Leg Bridge");
        WorkoutChildItems butt9 = new WorkoutChildItems("Two Leg Bridge");
        WorkoutChildItems butt10 = new WorkoutChildItems("Three Leg Bridge");

        return Arrays.asList(butt1, butt2, butt3, butt4, butt5, butt6, butt7, butt8, butt9, butt10);
    }

}

