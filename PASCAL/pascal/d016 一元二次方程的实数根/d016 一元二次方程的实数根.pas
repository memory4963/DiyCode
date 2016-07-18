var
x1,x2,a,b,c,d:real;
begin
readln(a,b,c);
if b*b-4*a*c<0 then writeln('No answer!')
 else if b*b-4*a*c=0 then
  begin
   x1:=(-1*b+sqrt(b*b-4*a*c))/2/a;
   writeln(x1:0:2);
  end
   else if b*b-4*a*c>0 then
    begin
     x1:=(-1*b+sqrt(b*b-4*a*c))/2/a;
     x2:=(-1*b-sqrt(b*b-4*a*c))/2/a;
     writeln(x1:0:2);
     writeln(x2:0:2);
    end;
end.