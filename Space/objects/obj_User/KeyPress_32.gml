/// @DnDAction : YoYo Games.Instances.Create_Instance
/// @DnDVersion : 1
/// @DnDHash : 7ACC40B1
/// @DnDArgument : "xpos_relative" "1"
/// @DnDArgument : "ypos_relative" "1"
/// @DnDArgument : "objectid" "obj_Shot"
/// @DnDSaveInfo : "objectid" "b46d6e29-7541-4772-b30e-0eda505aa9d7"
instance_create_layer(x + 0, y + 0, "Instances", obj_Shot);

/// @DnDAction : YoYo Games.Timelines.Set_Timeline
/// @DnDVersion : 1
/// @DnDHash : 3873CD02
timeline_index = noone;
timeline_loop = 0;
timeline_running = 1;