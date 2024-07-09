package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
   public static void main(String[] args) {
      MeepMeep meepMeep = new MeepMeep(800);

      RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
            // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
            .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
            .followTrajectorySequence(drive ->
                  drive.trajectorySequenceBuilder(new Pose2d(-36, -55, Math.toRadians(90)))
                        .waitSeconds(1)
                        .forward(20)
                        .back(4)
                        .waitSeconds(1)
                        .strafeLeft(15)
                        .lineToLinearHeading(new Pose2d(-52, -12, Math.toRadians(0)))
                        .back(4)
                        .forward(65)
                        .splineToSplineHeading(new Pose2d(50, -35, Math.toRadians(0)), Math.toRadians(-30))
                        .build()
            );

      RoadRunnerBotEntity myBot2 = new DefaultBotBuilder(meepMeep)
            // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
            .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
            .followTrajectorySequence(drive ->
                  drive.trajectorySequenceBuilder(new Pose2d(-36, -55, Math.toRadians(90)))
                        .waitSeconds(1)
                        .splineTo(new Vector2d(-30, -35), Math.toRadians(45))
                        //.splineTo(new Vector2d(-60, -10), Math.toRadians(0))
                        .waitSeconds(1)
                        .back(4)
                        //.setReversed()
                        //.splineToSplineHeading(new Pose2d(-60, -10, Math.toRadians(-30)),0)
                        .splineTo(new Vector2d(-60, -10),Math.toRadians(-30))
                        .build()
            );

      meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
            .setDarkMode(true)
            .setBackgroundAlpha(0.95f)
            .addEntity(myBot2)
            .start();
   }
}