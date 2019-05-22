
/*
 *  Template drive subsystem for a 4 cim drivetrain class 
 *  that contains methods for tank and arcade drive
 */

package lib.subsystems;

import lib.subsystems.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class DriveSubsystemTemplate extends SubsystemBase {

    DriveTrainConfig config;

    /*
     *  This enumerator outlines the different configurations for
     *  the motor controllers of a possible 4 cim drivetrain
     *  (e.g., 4 ctre Talon SRXs, 2 Talon SRXs + 2 Victor SPXs)
     * 
     *  T represents a Talon SRX, V represents a Victor SPX
     */
    public enum DriveTrainConfig {
        TTTT,
        TVTV,
        VVVV
    }

    public DriveSubsystemTemplate (DriveTrainConfig config) {
        super();
        this.config = config;
        initDefaultCommand();
    }

    public void specificInit () {
        assignMotorControllers(config);
    }

    public void assignMotorControllers (DriveTrainConfig config) {

        // Call to parent/superclass MotorController array variable
        MotorControllers = new BaseMotorController[4];

        switch (config) {
            case TTTT:
                MotorControllers = new BaseMotorController[]
                                   {new TalonSRX(0), 
                                    new TalonSRX(1), 
                                    new TalonSRX(2), 
                                    new TalonSRX(3)};
                break;
            case TVTV:
                 MotorControllers = new BaseMotorController[]
                                   {new TalonSRX(0), 
                                    new VictorSPX(1), 
                                    new TalonSRX(2), 
                                    new VictorSPX(3)};
                break;
            case VVVV:
            MotorControllers = new BaseMotorController[]
                                   {new VictorSPX(0), 
                                    new VictorSPX(1), 
                                    new VictorSPX(2), 
                                    new VictorSPX(3)};
                break;
        }

    }

}
