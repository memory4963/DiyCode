var
l,r:integer;
c:char;
begin
l:=0;
r:=0;
repeat
read(c);
case c of
 '(':l:=l+1;
 ')':r:=r+1;
end;
until eoln;
if l>r then writeln('Left')
 else if l<r then writeln('Right')
  else if l=r then writeln('Yes');
end.