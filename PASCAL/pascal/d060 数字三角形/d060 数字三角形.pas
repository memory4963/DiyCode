var
n,m,i,k,b,r:integer;
begin
k:=1;
r:=1;
readln(n);
for i:= 1 to n do
 begin
  for b:= 1 to k do
   begin
    write(r,' ');
    r:=r+1;
   end;
  k:=k+1;
  writeln;
 end;
end.