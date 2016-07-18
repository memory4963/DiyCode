var
a,b:real;
i,c:integer;
begin
readln(a);
c:=trunc(a);
b:=0;
for i:= 1 to c do
 b:= b+(1/i);
writeln(b:0:6);
end.
