package frc.team4828.testboardtoast;

        import jaci.openrio.toast.lib.log.Logger;
        import jaci.openrio.toast.lib.module.IterativeModule;

public class RobotModule extends IterativeModule {

    public static Logger logger;
    public Drive d;
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
        //TODO: Module Init
    }

    public void teleopPeriodic() {
        d.set(0.1,0.1,0.1,0.1);
    }
}
