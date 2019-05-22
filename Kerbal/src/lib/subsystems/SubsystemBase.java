
/*
 *  Abstract superclass that every template subsystem will extend
 */

package lib.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.BaseMotorController;

public abstract class SubsystemBase extends Subsystem {

    // Array of ctre BaseMotorController objects that represent motor controllers
    protected BaseMotorController[] MotorControllers;

    /*
     *  Default Constructor with a list of BaseMotorController objects
     *  (e.g., ctre Talon SRX, Victor SPX)
     */
    public SubsystemBase (BaseMotorController[] MotorControllers) {
        this.MotorController = MotorControllers;
    }

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
    public void specificInit() {    }

}
