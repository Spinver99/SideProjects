/// @DnDAction : YoYo Games.Random.Get_Random_Number
/// @DnDVersion : 1
/// @DnDHash : 0CE5B2F5
/// @DnDArgument : "var" "dir"
/// @DnDArgument : "max" "360"
dir = (random_range(0, 360));

/// @DnDAction : YoYo Games.Random.Get_Random_Number
/// @DnDVersion : 1
/// @DnDHash : 77520775
/// @DnDArgument : "var" "spd"
/// @DnDArgument : "max" "10"
spd = (random_range(0, 10));

/// @DnDAction : YoYo Games.Movement.Set_Direction_Free
/// @DnDVersion : 1
/// @DnDHash : 186FE279
/// @DnDArgument : "direction" "dir"
direction = dir;

/// @DnDAction : YoYo Games.Movement.Set_Speed
/// @DnDVersion : 1
/// @DnDHash : 6BE9815C
/// @DnDArgument : "speed" "spd"
speed = spd;

/// @DnDAction : YoYo Games.Instances.Set_Alarm
/// @DnDVersion : 1
/// @DnDHash : 74BEEB82
/// @DnDApplyTo : fd5ff6a7-23ed-47ad-b2f1-0d6a58b0d8ba
with(obj_User) {
alarm_set(0, 30);

}