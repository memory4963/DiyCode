var
n,m,i:integer;
t:char;
begin
assign(input,'cut.in');
assign(output,'cut.out');
reset(input);
rewrite(output);
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
close(input);
close(output);
end.
