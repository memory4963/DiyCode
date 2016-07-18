var
a:array[1..1000] of boolean;
n,m,i,k:longint;
begin
readln(n);
fillchar(a,sizeof(a),true);
for i:= 2 to n do
 begin
  m:=1;
  repeat
   m:=m+1;
   k:=m*i;
   if (k<=n) then a[k]:=false;
  until k>=n;
 end;
for i:= 2 to n do
 begin
  if a[i] then writeln(i);
 end;
end.
