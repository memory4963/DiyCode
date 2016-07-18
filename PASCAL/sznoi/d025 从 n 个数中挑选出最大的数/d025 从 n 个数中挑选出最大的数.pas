var
a,b,n,i:integer;
begin
readln(n);
for i:= 1 to n do
  begin
   read(a);
   if a>b then b:=a;
  end;
writeln(b);
end.