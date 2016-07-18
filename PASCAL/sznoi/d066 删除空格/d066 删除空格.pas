var
a:integer;
d:char;
begin
repeat
read(d);
if (d<>' ') then
begin
a:=a+1;
write(d);
end;
until eoln;
writeln;
writeln(a);
end.