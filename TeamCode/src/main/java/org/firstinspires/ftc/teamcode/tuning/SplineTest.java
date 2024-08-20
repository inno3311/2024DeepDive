package org.firstinspires.ftc.teamcode.tuning;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.TankDrive;

public final class SplineTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Pose2d beginPose = new Pose2d(-36, -58, Math.toRadians(180));
        if (TuningOpModes.DRIVE_CLASS.equals(MecanumDrive.class)) {
            MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);

            waitForStart();

            Actions.runBlocking(
                  drive.actionBuilder(beginPose)
                          .splineToSplineHeading(new Pose2d(-55, -34, Math.toRadians(90)), Math.toRadians(90))
                          .splineToSplineHeading(new Pose2d(-36, 0, Math.toRadians(0)), Math.toRadians(0))
                          .lineToX(0)
                          .setTangent(0)
                          .splineToSplineHeading(new Pose2d(48, -36, Math.toRadians(90)), Math.toRadians(0))
                          .setTangent(Math.toRadians(90))
                          .lineToY(47)
                          .setTangent(Math.toRadians(0))
                          .lineToXSplineHeading(0, Math.toRadians(180))
                          .lineToX(-55)
                          .build());

        } else if (TuningOpModes.DRIVE_CLASS.equals(TankDrive.class)) {
            TankDrive drive = new TankDrive(hardwareMap, beginPose);

            waitForStart();

            Actions.runBlocking(
                    drive.actionBuilder(beginPose)
                            .splineTo(new Vector2d(30, 30), Math.PI / 2)
                            .splineTo(new Vector2d(0, 60), Math.PI)
                            .build());
        } else {
            throw new RuntimeException();
        }
    }
}
