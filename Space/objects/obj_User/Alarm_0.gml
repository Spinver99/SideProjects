/// @DnDAction : YoYo Games.Random.Get_Random_Number
/// @DnDVersion : 1
/// @DnDHash : 63392B51
/// @DnDArgument : "var" "newx"
/// @DnDArgument : "max" "1024"
newx = (random_range(0, 1024));

/// @DnDAction : YoYo Games.Random.Get_Random_Number
/// @DnDVersion : 1
/// @DnDHash : 4CC2BD23
/// @DnDArgument : "var" "newy"
/// @DnDArgument : "min" "-768"
/// @DnDArgument : "max" "0"
newy = (random_range(-768, 0));

/// @DnDAction : YoYo Games.Instances.Create_Instance
/// @DnDVersion : 1
/// @DnDHash : 0F2F2009
/// @DnDArgument : "xpos" "newx"
/// @DnDArgument : "xpos_relative" "1"
/// @DnDArgument : "ypos" "newy"
/// @DnDArgument : "ypos_relative" "1"
/// @DnDArgument : "objectid" "obj_Astroid"
/// @DnDSaveInfo : "objectid" "75c737eb-63e4-4464-8fe7-770892b198f6"
instance_create_layer(x + newx, y + newy, "Instances", obj_Astroid);