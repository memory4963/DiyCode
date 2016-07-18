var
b:integer;
a:char;
begin
b:=0;
repeat
read(a);
b:=b+(ord(a)-48);
until eoln;
writeln(b);
end.
