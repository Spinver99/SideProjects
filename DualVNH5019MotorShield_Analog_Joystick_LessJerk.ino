#include "DualVNH5019MotorShield.h"

int acceleration;
int velocity;

DualVNH5019MotorShield md;
void setup() {
  velocity = 0;
  acceleration = 0;
  md.init();
  digitalWrite(0, HIGH);
}



void loop() {
    acceleration = map(analogRead(0), 0, 1000, -1, 1); //Takes the input from the analog joystick and converts it to either -1, 0, or 1.
    if (acceleration == 0) { 
        //We do not want to stop the motor immediatly, as this could cause a sudden jerk.
        //We also do not want it to take forever to stop as this is unsafe.
        //Instead it decreases by 10% each second.
        velocity = velocity*.9;
    } else {
      //Increases velocity by 1 (or -1) each time the joystick is in a non-zero position.
      velocity += acceleration;
    }
    //This if/ifelse simply checks if velocity is outside the bounds of the motor speeds and corrects it.
    //The motor can take in any integer but only sets istelf to 400.
    //This prevents us from getting a large speed that isn't being used.
    if (velocity > 400) {
      velocity = 400;
    } else if (velocity < -400) {
      velocity = -400;
    }
    //Sets the speed of BOTH motors. This command also works for single motors.
    md.setSpeeds(velocity, velocity);
}
