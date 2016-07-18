var
a,b,c:integer;
begin
readln(a);
c:=0;
for b:= 1 to a do
 if a mod b=0 then
  c:=c+b;
writeln(c);
end.