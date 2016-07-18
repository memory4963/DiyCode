var
t,n,i:integer;
m:char;
begin
assign(input,'evenodd.in');
assign(output,'evenodd.out');
reset(input);
rewrite(output);
readln(n);
for i:= 1 to n do
begin
repeat
read(m);
until eoln;
t:=ord(m)-48;
if t mod 2=0 then writeln('even') else writeln('odd');
end;
close(input);
close(output);
end.

