uses math;
var
a,n,k:integer;
begin
readln(n);
k:=0;
while power(3,k)<=n do
 k:=k+1;
writeln(k-1);
end.