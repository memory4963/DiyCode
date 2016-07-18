var
a,b,t:integer;
begin
readln(a,b);
if a<b then
 begin
  t:=a;
  a:=b;
  b:=t;
 end;
 begin
  repeat
   t:=a mod b;
   a:=b;
   b:=t;
  until t=0;
 end;
writeln(a);
end.

