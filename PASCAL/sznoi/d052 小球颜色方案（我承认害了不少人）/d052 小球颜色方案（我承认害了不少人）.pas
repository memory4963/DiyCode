var
a,b,c,n:integer;
begin
for a:= 1 to 5 do
 for b:= 1 to 5 do
  for c:= 1 to 5 do
   if (a<>b) and (b<>c) and (a<>c) then n:=n+1;
writeln(n);
end.