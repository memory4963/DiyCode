var
a,b,x,n:integer;
d:real;
begin
readln(x);
n:=0;
d:=1;
while d<=x do
 begin
  n:=n+1;
  d:=d+(n*n);
 end;
writeln(n-1);
end.