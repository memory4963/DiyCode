var
a:integer;
d:char;
begin
a:=1;
repeat
 read(d);
 if d=' ' then
  a:=a+1;
until d='.';
writeln(a);
end.