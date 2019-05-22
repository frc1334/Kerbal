
/*
 *  Abstract superclass that every template subsystem will extend
 */

package lib.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.BaseMotorController;

import com.ctre.phoenix.motorcontrol.ControlMode;

public abstract class SubsystemBase extends Subsystem {

    // Array of ctre BaseMotorController objects that represent motor controllers
    protected BaseMotorController[] MotorControllers;

    /*
     *  Default Constructor with no arguments
     */
    public SubsystemBase () {    }

    /*
     *  initDefaultCommand method that calls an overridable special 
     *  on start method for initializations .etc (Polymorphism)
     */
    public final void initDefaultCommand () {
        specificInit();
    }

    /*
     *  Method stub that is overrided. Called by initDefaultCommand
     */
    public void specificInit () {    }

    /*
     *  Method that runs a BaseMotorController from the MotorController 
     *  array (at index) with given a given power percentage
     */
    public void runMotorControllers (int deviceIndex, double power) {
        BaseMotorController[deviceIndex].set(ControlMode.PercentOutput, power);
    }

}
