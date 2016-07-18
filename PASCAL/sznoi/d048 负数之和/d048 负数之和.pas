var
a,b,c:integer;
begin
b:=0;
 repeat
  read(a);
   if (a<0) then
    b:=b+a;
 until a=0;
writeln(b);
end.