var
a,b,k,n,m,i:integer;
t:array[1..10000]of boolean;
begin
readln(a);
fillchar(t,sizeof(t),true);
for i:= 2 to a do
 if t[i] then
 begin
  m:=1;
  repeat
    m:=m+1;
    k:=m*i;
    if ((k<=a) and (k>=2))   then t[k]:=false;
  until k>=a;
 end;
for i:=2 to a-2 do
begin
 k:=a-i;
 if (t[k] and t[i]) then
 begin
 writeln(a,'=',i,'+',k);
 break;
 end;
 end;
 end.
