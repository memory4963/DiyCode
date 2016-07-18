var
a,b,c,d,e:integer;
yes,wr:boolean;
begin
readln(a,b,c);
if a+b<=c then writeln('Error!')
else begin
if a>b then
 begin
  d:=a;
  a:=b;
  b:=d;
 end;
if b>c then
 begin
  d:=b;
  b:=c;
  c:=d;
 end;
begin
if a+b<c then writeln('Error!')
 else if a*a+b*b=c*c then writeln('Yes!')
  else writeln('No!');
end;
end;
end.
