var
a,k,c:integer;
n:real;
begin
k:=1;
a:=1;
c:=1;
n:=0;
repeat
 n:=n+k*(1/a);
 a:=a+2;
 k:=(-1)*k;
 c:=c+1;
until c=1000;
writeln(n*4:0:4);
end.