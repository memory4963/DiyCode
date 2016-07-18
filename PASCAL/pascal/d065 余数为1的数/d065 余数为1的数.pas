var
a,b,c,n,m,i:integer;
begin
readln(a,b,c);
m:=0;
n:=0;
repeat
n:=n+1;
if (n mod a=1) and (n mod b=1) and (n mod c=1)then begin
 m:=m+1;
 writeln(n);
 end;
until m=10;
end.