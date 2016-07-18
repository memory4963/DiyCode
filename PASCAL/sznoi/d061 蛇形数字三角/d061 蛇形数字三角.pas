var i,j,n:integer;
begin
readln(n);
for i:=n-1 downto 0 do
begin
for j:=0 to n-i-1 do
write( (i+j+1) * (i+j+2) div 2 - i, ' ' );
writeln;
end;
end.