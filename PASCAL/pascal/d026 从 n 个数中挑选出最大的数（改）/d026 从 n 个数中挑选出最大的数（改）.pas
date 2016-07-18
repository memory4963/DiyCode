var
a,b,c,i:integer;
begin
b:=0;
i:=0;
repeat
read(a);
i:=i+1;
if a>b then
 begin
  b:=a;
 end;
until eoln;
writeln(i,' ',b);
end.