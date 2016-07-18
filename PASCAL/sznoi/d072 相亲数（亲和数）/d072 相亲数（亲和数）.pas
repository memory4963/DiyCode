var
a,b,c,n,m,i,k,p,t:integer;
w:array[1..1000] of boolean;
begin
fillchar(w,sizeof(w),true);
for n:= 2 to 1000 do
if w[n] then
 begin
  t:=n;
  k:=0;
  for a:= 1 to n-1 do
   if (n mod a=0) then
   begin
   k:=k+a;
   end;
  m:=k;
  p:=0;
  for b:= 1 to m-1 do
   if (m mod b=0) then
    begin
     p:=p+b;
    end;
if (p=n) and (m<>n)  then
begin
writeln(n,' ',m);
w[m]:=false;
end;
end;
end.

