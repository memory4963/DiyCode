var
w:array[1..26]of char;
i,n,m,k,a,b,c:integer;
p:char;
asdf:boolean;
begin
for i:= 1 to 26 do
begin
 w[i]:=chr(i+96);
end;
repeat
read(p);
 begin
  if (ord(p)>=97) and (ord(p)<=122) then asdf:=true;
 end;
case asdf of
 true:write(chr(219-ord(p)));
 false:write(p);
end;
asdf:=false;
until eoln;
end.