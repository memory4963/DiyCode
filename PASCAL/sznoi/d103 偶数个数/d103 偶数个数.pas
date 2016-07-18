var
a,b:integer;
function y(a:integer):boolean;
 begin
  if (a mod 2)=0 then y:=true else y:=false;
 end;
begin
 repeat
  read(a);
  if y(a) then b:=b+1;
 until a=-1;
writeln(b);
end.
