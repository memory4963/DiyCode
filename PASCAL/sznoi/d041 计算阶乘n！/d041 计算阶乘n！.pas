var
a:int64;
n,i:integer;
begin
readln(n);
a:=1;
for i:= 2 to n do
 a:=a*i;
writeln(a);
end.
