var
a,b,n,m,i,c,d:integer;
begin
readln(n);
a:=n-1;
b:=1;
for i:= 1 to n do
 begin
  for m:= 1 to a do write(' ');
  a:=a-1;
  for c:= 1 to b do write('*');
  b:=b+2;
  writeln;
 end;
b:=2*n-3;
a:=1;
for i:= n-1 downto 1 do
 begin
  for m:= 1 to a do write(' ');
  for c:= 1 to b do write('*');
  a:=a+1;
  b:=b-2;
  writeln;
 end;
end.
