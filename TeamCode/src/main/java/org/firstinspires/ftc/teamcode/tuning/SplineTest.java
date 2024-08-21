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
        Pose2d beginPose = new Pose2d(-36, -58, Math.toRadians(90));
        if (TuningOpModes.DRIVE_CLASS.equals(MecanumDrive.class)) {
            MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);

            waitForStart();

            Actions.runBlocking(
                  drive.actionBuilder(beginPose)
                          .setTangent(Math.toRadians(90))
                          .lineToY(-22)
                          .turn(Math.toRadians(450))
                          .setTangent(Math.toRadians(180))
                          .splineToConstantHeading(new  Vector2d(-16, 10), Math.toRadians(135))
                          .setTangent(Math.toRadians(135))
                          .lineToX(-26)
                          .turn(Math.toRadians(320))
                          .turn(Math.toRadians(-50))
                          .setTangent(Math.toRadians(270))
                          .lineToY(56)
                          .turn(Math.toRadians(-180))
                          .setTangent(Math.toRadians(0))
                          .lineToX(48)
                          .setTangent(Math.toRadians(225))
                          .lineToX(36)
                          .setTangent(Math.toRadians(270))
                          .lineToY(36)
                          .turn(Math.toRadians(360))
                          .lineToY(-12)
                          .turn(Math.toRadians(360))
                          .splineToLinearHeading(new Pose2d(22, -50, Math.toRadians(180)), Math.toRadians(-90))
                          .setTangent(Math.toRadians(180))
                          .lineToX(6)
                          .turn(Math.toRadians(360))
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
