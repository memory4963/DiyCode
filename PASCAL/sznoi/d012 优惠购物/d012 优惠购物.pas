var
a,c:real;
begin
readln(a);
if a>1000 then begin
 c:=(a-1000)*0.9+950
 end
else c:=0.95*a;
writeln(c:0:2);
end.