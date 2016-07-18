var
a,b,c,d:real;
i,m:integer;
n,t:real;
begin
assign(input,'3cfc.in');
assign(output,'3cfc.out');
reset(input);
rewrite(output);
read(a,b,c,d);
for i:= -10000 to 10000 do
 begin
  n:=0.01*i;
  t:=a*n*n*n+b*n*n+c*n+d;
  if (t<=0.01) and (t>=-0.01) then write(n:0:2,' ');
 end;
close(input);
close(output);
end.

