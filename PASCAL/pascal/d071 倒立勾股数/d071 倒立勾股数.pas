var
x,y,z:integer;
begin
for x:= 1 to 60 do
 for y:= x to 60 do
  for z:= 1 to 60 do
   if (y*y*z*z)+(x*x*z*z)=(x*x*y*y) then writeln(x,' ',y,' ',z);
end.
