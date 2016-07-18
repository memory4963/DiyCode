var
a,b:real;
c,i:integer;
function j(d:integer):real;
var
g:real;
w:integer;
begin
j:=1;
for w:= 1 to d do
 j:=j*w;
end;
begin
a:=1;
readln(c);
for i:= 1 to c do
 a:=a+(1/j(i));
writeln(a:0:10);
end.