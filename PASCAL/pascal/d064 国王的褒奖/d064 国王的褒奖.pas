uses math;
var
a,k,n:real;
i:integer;
begin
readln(n);
k:=1;
a:=0;
for i:= 0 to trunc(n)-1 do
 begin
 a:=a+power(2,i);
 end;
writeln(trunc(a));
end.
