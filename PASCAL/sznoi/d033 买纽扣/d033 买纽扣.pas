const
j=50;
y=10;
x=(1/3);
z=500;
var
a,b,c,d,e:integer;
begin
for a:= 1 to 10 do
 for b:= 1 to 50 do
  for c:= 1 to 100 do
   if (a+b+c=100) then
    begin
     if (a*j+b*y+c*x=z) then
      writeln(a,' ',b,' ',c,' ');
    end;
end.
