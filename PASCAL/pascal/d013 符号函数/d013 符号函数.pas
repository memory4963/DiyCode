var
a,b:integer;
begin
readln(a);
if a>0 then b:=1
 else if a=0 then b:=0
  else if a<0 then b:=-1;
writeln(b);
end.