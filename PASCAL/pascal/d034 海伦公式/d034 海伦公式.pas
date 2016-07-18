var
a,b,c,d,e,p,s:real;
begin
readln(a,b,c);
if (a+b>c) and (a+c>b) and (b+c>a) then
 begin
  p:=(a+b+c)/2;
  s:=sqrt(p*(p-a)*(p-b)*(p-c));
 writeln(s:0:2);
 end
else writeln('Data Error!');
end.
