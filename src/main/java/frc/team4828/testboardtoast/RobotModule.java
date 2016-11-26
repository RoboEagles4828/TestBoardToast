package frc.team4828.testboardtoast;

import edu.wpi.first.wpilibj.Joystick;
import jaci.openrio.toast.lib.log.Logger;
import jaci.openrio.toast.lib.module.IterativeModule;

public class RobotModule extends IterativeModule {

    public static Logger logger;
    public Drive d;
    public Joystick j1;
    public Joystick j2;

    @Override
    public String getModuleName() {
        return "TestBoardToast";
    }

    @Override
    public String getModuleVersion() {
        return "0.0.1";
    }

    @Override
    public void robotInit() {
        logger = new Logger("TestBoardToast", Logger.ATTR_DEFAULT);
        d = new Drive(9,8,7,6);
        j1 = new Joystick(0);
        j2 = new Joystick(1);
    }

    public void teleopPeriodic() {
        d.arcadeDrive(j1);
    }
}
