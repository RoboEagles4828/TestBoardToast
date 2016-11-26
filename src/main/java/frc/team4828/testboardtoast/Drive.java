package frc.team4828.testboardtoast;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Victor;
import jaci.openrio.toast.lib.registry.Registrar;

/**
 * Created by cheez on 11/26/2016.
 */
public class Drive {
    public Victor frontLeft;
    public Victor backLeft;
    public Victor frontRight;
    public Victor backRight;

    public Drive(int fl, int bl, int fr, int br) {
        frontLeft = Registrar.victor(fl);
        backLeft = Registrar.victor(bl);
        frontRight = Registrar.victor(fr);
        backRight = Registrar.victor(br);
    }

    public void set(double fl, double bl, double fr, double br) {
        frontLeft.set(fl);
        backLeft.set(bl);
        frontRight.set(fr);
        backRight.set(br);
    }

    public void stop() {
        frontLeft.set(0);
        backLeft.set(0);
        frontRight.set(0);
        backRight.set(0);
    }
    public void tankDrive(GenericHID leftStick, GenericHID rightStick) {
        if (leftStick == null || rightStick == null) {
            throw new NullPointerException("Null HID provided");
        }
        double mult = (((-leftStick.getThrottle()+1)/2)*.99);
        //double mult = 1;
        tankDrive(-leftStick.getY() * mult, -rightStick.getY() * mult, true);
    }
    public void tankDrive(double leftValue, double rightValue, boolean squaredInputs) {
        if (squaredInputs) {
            if (leftValue >= 0.0) {
                leftValue = (leftValue * leftValue);
            } else {
                leftValue = -(leftValue * leftValue);
            }
            if (rightValue >= 0.0) {
                rightValue = (rightValue * rightValue);
            } else {
                rightValue = -(rightValue * rightValue);
            }
        }
        setLeftRightMotorOutputs(leftValue, rightValue);
    }

    public void setLeftRightMotorOutputs(double leftOutput, double rightOutput) {
        if (backLeft == null || backRight == null) {
            throw new NullPointerException("Null motor provided");
        }
        if (frontLeft != null) {
            frontLeft.set(leftOutput);
        }
        backLeft.set(leftOutput);
        if (frontRight != null) {
            frontRight.set(-rightOutput);
        }
        backRight.set(-rightOutput);
    }
}
