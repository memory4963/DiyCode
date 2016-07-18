var
a,b,c,i:longint;
w:boolean;
procedure p(t:longint);
var
d,e:integer;
begin
e:=0;
for d:= 1 to t-1 do
 if t mod d =0 then
  e:=e+d;
if e=t then w:=true else w:=false;
end;
begin
c:=0;
for i:= 1 to 4 do
begin
 read(a);
 p(a);
 if w then write('1 ') else write('0 ');
end;
read(a);
p(a);
if w then write('1') else write('0');
end.

