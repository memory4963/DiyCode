var
a,b,h,f,c,r:integer;
begin
readln(h,f);
r:=(f-2*h);
if r mod 2 =0 then
 begin
 r:=trunc(r/2);
c:=h-r;
writeln(c,' ',r);
end;
end.

