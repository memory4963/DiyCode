var
a,b,c,d,i,n,m:integer;
begin
readln(a);
b:=2*a;
c:=b-1;
d:=1;
for i:= 1 to a do
 begin
 for n:= 1 to c do write('*');
 c:=c-2;
 for m:= 1 to d do write('$');
 d:=d+2;
 writeln;
 end;
end.


