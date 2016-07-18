var
n,m,i:integer;
a:array[1..10] of integer;
begin
assign(input,'apple.in');
assign(output,'apple.out');
reset(input);
rewrite(output);
for i:= 1 to 10 do read(a[i]);
readln;
read(n);
n:=n+30;
for i:= 1 to 10 do if n>=a[i] then m:=m+1;
writeln(m);
close(input);
close(output);
end.
