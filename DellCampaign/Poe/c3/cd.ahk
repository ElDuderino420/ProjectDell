toggle = 0
toggle2 = 0
#MaxThreadsPerHotkey 2


f8::
Toggle := !Toggle
     While Toggle{
send,1
sleep 5
send,2
sleep 5
send,3
sleep 5
send,4
sleep 5
send,8
sleep 5
send,5
sleep 5
send,6
sleep 5
send,7
sleep 1500
}
return


F3::
reload
return

F1::
SetMouseDelay, 2
Toggle2 := !Toggle2
     While Toggle2{
Send, {Ctrl down}
sleep 5
Click
sleep 5
Click
sleep 5
MouseMove, 0, 100, 100, R
sleep 100
Click
sleep 5
Click
sleep 5
Send, {Ctrl up}
sleep 5
send,{WheelDown}
MouseMove, 0, -95, 100, R
sleep 600
}
return