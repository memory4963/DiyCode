var
a,b,n,i:integer;
begin
readln(n);
i:=0;
for i:= n downto 1 do
 begin
a:=0;
b:=0;
 repeat
  write(' ');
  a:=a+1
 until a=n-i+1;
 repeat
  write('#');
  b:=b+1;
 until b=2*i-1;
 writeln;
 end;
end.