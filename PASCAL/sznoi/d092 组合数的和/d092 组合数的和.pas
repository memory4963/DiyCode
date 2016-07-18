var
i,j,n,m:integer;
function fac(a:integer):real;
var
i:integer;
begin
 fac:=1;
for i:= 1 to a do
 fac:=fac*i;
end;
function slot(a,b:integer):real;
begin
 slot:=fac(a)/(fac(b)*fac(a-b));
end;
begin
readln(i,j,n,m);
writeln(trunc(slot(i,j)+slot(n,m)));
end.
