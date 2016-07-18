var
n,m,i:integer;
t:char;
begin
readln(n);
repeat
 read(t);
 i:=i+1;
 if i<=n then write(t) else
 begin
  writeln;
  write(t);
  i:=1;
 end;
until eoln;
end.
