toggle = 0
toggle2 = 0
#MaxThreadsPerHotkey 2
p1 = 250
p2 = 360
p3 = 470
p4 = 580
s = 10

scroll(){
send,{WheelDown}
return
}

f9::

MouseGetPos,xx,yy
Tooltip %xx%`,%yy%
return


buy(){
Send, {Ctrl down}
sleep 5
Click
sleep 5
Click
sleep 5
Send, {Ctrl up}
return
}

move(xx,yy){
MouseMove, xx, yy, 0
sleep 10
buy()
return
}

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
SetMouseDelay, 0
move(100,p1)
sleep 50
move(100,p2)
sleep 50
move(100,p3)
sleep 50
move(100,p4)
sleep 50
scroll()
sleep 50
scroll()
sleep 500
move(100,p1+(s*2))
sleep 50
move(100,p2+(s*2))
sleep 50
move(100,p3+(s*2))
sleep 50
move(100,p4+(s*2))
sleep 50
scroll()
sleep 50
scroll()
sleep 500
move(100,p1+(s*2))
sleep 50
move(100,p2+(s*2))
sleep 50
move(100,p3+(s*2))
sleep 50
scroll()
sleep 50
scroll()
sleep 500
move(100,p1)
sleep 50
move(100,p2)
sleep 50
move(100,p3)
sleep 50
move(100,p4)
sleep 50
scroll()
sleep 50
scroll()
sleep 500
move(100,p1+(s*2))
sleep 50
move(100,p2+(s*2))
sleep 50
move(100,p3+(s*2))
sleep 50
move(100,p4+(s*2))
sleep 50
scroll()
sleep 50
scroll()
sleep 500
move(100,p1+(s*3))
sleep 50
move(100,p2+(s*3))
sleep 50
move(100,p3+(s*3))
sleep 50
scroll()
sleep 50
scroll()
sleep 500
move(100,p1+(s*3))
sleep 50
move(100,p2+(s*3))
sleep 50
move(100,p3+(s*3))
sleep 50
move(100,p4+(s*3))
sleep 50
return

NumPad1::
scroll()
return

NumPad9::
move(100,p1)
return

NumPad8::
move(100,p2)
return
NumPad7::
move(100,p3)
return
NumPad6::
move(100,p4)
return
NumPad5::
MouseMove, 0, +s, 0,R
return