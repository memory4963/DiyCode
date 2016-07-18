var
a,b:integer;
c:char;
begin
repeat
read(c);
if (c='a') or (c='A') then
 a:=a+1;
until c='#';
writeln(a);
end.
