var
a,b,m:real;
begin
readln(a,b);
m:=0;
repeat
 m:=m+1;
until a*m>b;
writeln(trunc(m));
end.
