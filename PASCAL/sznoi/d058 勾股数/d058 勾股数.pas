var
a,b,c,d,n,i:integer;
begin
 for a:= 1 to 20 do
  for b:= 1 to 20 do
   for c:= 1 to 20 do
    if a*a+b*b=c*c then
     if (a<=b) and (b<=c) then
      writeln(a,' ',b,' ',c,' ');
 end.